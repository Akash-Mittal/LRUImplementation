package com.lru.model;

import java.util.Objects;

import com.lru.Common;
import com.lru.model.Enums.CUISINE;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public enum SweepStrategy  implements Common.LISTCONSTANTS{

	/*
	 * Increment the count of founded object If not found get from database if found
	 * from DB then remove lru item and add the founded one
	 *
	 */
	LIST_ITERATIVE {
		@Override
		public String get(String itemName) {

			ItemCacheObject val = null;
			val = itemCacheList.stream()
					.filter(cachedObject -> Objects.equals(itemName, cachedObject.getItem().getName())).findFirst()
					.get();
			if (val == null) {
				// Below Line Imitates the Call to get persisted object
				log.debug("Object Not Found in cache" );
				val = ItemCacheObject.builder().count(0).item(Item.builder().cuisine(CUISINE.BREADS)
						.name("Name: Object Fetched Fron DB").price(Double.MIN_VALUE).build()).build();
				log.debug(super.cacheStats()+"Found object from DB {} , Removing LRU Items" );
				itemCacheList.removeIf(item -> item.getCount() < COUNT_ELIGIBLE_FOR_REMOVAL);
				log.debug(super.cacheStats(),"After Removal \n Addind Object {} ", val.getItem().getName());
				itemCacheList.add(val);

			}
			val.setCount(val.getCount() + 1);
			return val.getItem().getName();
		}
	};
	public abstract String get(String itemName);

}


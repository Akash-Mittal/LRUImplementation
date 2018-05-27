package com.lru;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.lru.model.Enums.CUISINE;
import com.lru.model.Item;
import com.lru.model.ItemCacheObject;

public interface Common {

	public interface LISTCONSTANTS {
		// Should be volatile or optionally use Atomic Integer
		int SIZE = 10;
		int COUNT_ELIGIBLE_FOR_REMOVAL = 2;

		List<ItemCacheObject> itemCacheList = new ArrayList<>(SIZE);

		static void initialize() {
			for (int i = 0; i < SIZE; i++) {
				ItemCacheObject cacheObject = ItemCacheObject.builder().count(0)
						.item(Item.builder().cuisine(CUISINE.BREADS).name("Name:" + i).price(Double.MIN_VALUE).build())
						.build();
				itemCacheList.add(cacheObject);

			}
		}

		default List<ItemCacheObject> filter(Predicate<ItemCacheObject> predicate) {
			return itemCacheList.stream().filter(predicate).collect(Collectors.<ItemCacheObject>toList());
		}

		default String cacheStats() {
			StringBuilder cachestat = new StringBuilder();
			cachestat.append(" Size: ").append(itemCacheList.size());
			return cacheStats();
		}

		public interface API{
			String ROOT_PATH = "/api/v1/lru";
			String LIST_PATH = "/list";
		}
	}

}

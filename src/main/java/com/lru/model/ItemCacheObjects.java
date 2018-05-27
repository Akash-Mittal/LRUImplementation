package com.lru.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@SuppressWarnings("unused")
@Builder
@ToString
public final class ItemCacheObjects{
	private Item ItemCacheObjects ;
	private CountToItemName minCount;

}

@Getter
@Setter
@SuppressWarnings("unused")
@Builder
@ToString
 class CountToItemName{
	private int count;
	private int itemName;
}
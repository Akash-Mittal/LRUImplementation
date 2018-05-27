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
public final class ItemCacheObject{
	private Item item ;
	private volatile int count = 0;
}
package com.lru.arraylist;

import java.util.ArrayList;
import java.util.List;

import com.lru.Common;

import ch.qos.logback.classic.Level;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
@Slf4j
public class MainApplication {
	
	public static void main(String[] args) {
		Common.LISTCONSTANTS.initialize();
		log.debug("Cache Initalised ");
	}
}


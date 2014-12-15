package com.wyrz.core.utils;

import java.util.UUID;

/**
 * UUID生成器
 * @author yanziqi
 * @date 2014年12月9日下午3:57:21
 */
public class UUIDUtils {

	public static String getUUID() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString().toUpperCase();
	}

	public static void main(String[] args) {
		UUIDUtils uuid = new UUIDUtils();
		System.out.println(uuid.getUUID());
	}

}

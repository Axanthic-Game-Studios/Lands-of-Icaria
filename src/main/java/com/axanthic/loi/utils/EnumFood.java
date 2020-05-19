package com.axanthic.loi.utils;

public enum EnumFood {
	/*
	 * Changing the order here will change the in-game order.
	 * If you change this order, don't forget to update relevant loot tables.
	 */
	OLIVE_GREEN,
	OLIVE_BLACK,
	LAUREL_CHERRY,
	STRAWBERRY,
	PHYSALIS,
	AETERNAE_MEAT,
	AETERNAE_MEAT_COOKED,
	SOW_MEAT,
	SOW_MEAT_COOKED,
	CATOBLEPAS_MEAT,
	CATOBLEPAS_MEAT_COOKED;
	
	public static EnumFood[] valueArray = EnumFood.values();
	
	public static EnumFood fromOrdinal(int ordinal) {
		return valueArray[ordinal];
	}
}

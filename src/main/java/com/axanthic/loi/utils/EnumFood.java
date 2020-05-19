package com.axanthic.loi.utils;

public enum EnumFood {
	/*
	 * Please do not change ordering until all old uses have been
	 * found and refactored.
	 */
	OLIVE_GREEN,
	OLIVE_BLACK,
	LAUREL_CHERRY,
	AETERNAE_MEAT,
	AETERNAE_MEAT_COOKED,
	STRAWBERRY,
	PHYSALIS,
	SOW_MEAT,
	SOW_MEAT_COOKED,
	CATOBLEPAS_MEAT,
	CATOBLEPAS_MEAT_COOKED;
	
	public static EnumFood[] valueArray = EnumFood.values();
	
	public static EnumFood fromOrdinal(int ordinal) {
		return valueArray[ordinal];
	}
}

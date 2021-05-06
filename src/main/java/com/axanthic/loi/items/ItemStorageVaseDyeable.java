package com.axanthic.loi.items;

import net.minecraft.item.ItemStack;

public class ItemStorageVaseDyeable extends ItemMeta
{
	public ItemStorageVaseDyeable()
	{
		super("unfired_vase", new String[VaseType.length]);

		for (VaseType type : VaseType.values)
		{
			this.names[type.toMeta()] = type.name;
		}
	}
	
	@Override
	public String getUnlocalizedName(ItemStack item)
	{
		return super.getUnlocalizedName(item);
	}
	
	public enum VaseType
	{
		NONE("dyed_none"),
		WHITE("dyed_white"),
		ORANGE("dyed_orange"),
		MAGENTA("dyed_magenta"),
		AZURE("dyed_azure"),
		YELLOW("dyed_yellow"),
		LIME("dyed_lime"),
		PINK("dyed_pink"),
		GRAY("dyed_gray"),
		PALE("dyed_pale"),
		CYAN("dyed_cyan"),
		PURPLE("dyed_purple"),
		BLUE("dyed_blue"),
		BROWN("dyed_brown"),
		GREEN("dyed_green"),
		RED("dyed_red"),
		BLACK("dyed_black");

		public final String name;
		public static final VaseType[] values = VaseType.values();
		public static final int length = values.length;

		public int toMeta()
		{
			return ordinal();
		}

		VaseType(String name)
		{
			this.name = name;
		}
	}
}
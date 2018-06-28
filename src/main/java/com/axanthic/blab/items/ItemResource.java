package com.axanthic.blab.items;

import net.minecraft.item.ItemStack;

public class ItemResource extends ItemMeta {

	public ItemResource() {
		super("resource", new String[]{"lignite", "dolomite", "anthracite", "abyssal_essence", "silkstone_powder", "silkstone_brick", "calcite", "jasper", "zircon", "polished_zircon", "loam_lump"});
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		int meta = stack.getMetadata();
		if (meta == 0 || meta == 1 || meta == 2 || meta == 3 || meta == 6 || meta == 7 || meta == 8) {
			return "material." + names[meta];
		}
		return super.getUnlocalizedName() + "." + names[meta];
	}
}

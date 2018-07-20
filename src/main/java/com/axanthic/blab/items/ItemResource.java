package com.axanthic.blab.items;

import net.minecraft.item.ItemStack;

public class ItemResource extends ItemMeta {

	public ItemResource() {
		super("resource", new String[]{"lignite", "dolomite", "anthracite", "abyssal_essence", "silkstone_powder", "calcite", "jasper", "zircon", "calcite_powder",  "polished_zircon", "loam_lump", "raw_vase", "loam_brick"});
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		int meta = stack.getMetadata();
		if (meta == 0 || meta == 1 || meta == 2 || meta == 3 || meta == 5 || meta == 6 || meta == 7) {
			return "material." + names[meta];
		}
		return super.getUnlocalizedName() + "." + names[meta];
	}

	@Override
	public int getItemBurnTime(ItemStack stack) {
		int meta = stack.getMetadata();
		if (meta == 0) {
			return 800;
		} if (meta == 2) {
			return 3200;
		}
		return -1;
	}
}

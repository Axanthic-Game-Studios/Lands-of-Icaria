package com.axanthic.loi.items;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.item.ItemStack;

public class ItemResources extends ItemMeta {
	public ItemResources() {
		super("resource", new String[ResourceType.length]);
		for (ResourceType type : ResourceType.values) {
			this.names[type.toMeta()] = type.name;
		}
	}
	
	@Override
	public String getUnlocalizedName(ItemStack item) {
		ResourceType type = ResourceType.byMeta(item.getMetadata());
		if (type.isMaterial) {
			return "material." + type.name;
		}
		
		return super.getUnlocalizedName(item);
	}

	@Override
	public int getItemBurnTime(ItemStack stack) {
		return ResourceType.byMeta(stack.getMetadata()).burnTime;
	}
	
	public enum ResourceType {
		LIGNITE("lignite", true, 800),
		DOLOMITE("dolomite", true),
		ANTHRACITE("anthracite", true, 3200),
		ABYSSAL_ESSENCE("abyssal_essence", true),
		SILKSTONE_POWDER("silkstone_powder"),
		CALCITE("calcite", true),
		JASPER("jasper", true),
		ZIRCON("zircon", true),
		CALCITE_POWDER("calcite_powder"),
		POLISHED_ZIRCON("polished_zircon"),
		LOAM_LUMP("loam_lump"),
		RAW_VASE("raw_vase"),
		LOAM_BRICK("loam_brick"),
		ROTTEN_BONES("rotten_bones", true),
		REVENANT_FEMUR("revenant_femur"),
		REMAINS("remains"),
		AETERNAE_FUR("aeternae_fur"),
		AETERNAE_LEATHER("aeternae_leather", true),
		BLACK_DYE("black_dye"),
		BROWN_DYE("brown_dye"),
		BLUE_DYE("blue_dye"),
		WHITE_DYE("white_dye");
		
		public static final ResourceType[] values = ResourceType.values();
		public static final int length = values.length;
		private static final Map<String, ResourceType> NAME_LOOKUP = new HashMap<String, ResourceType>(length);
		
		public final String name;
		public final boolean isMaterial;
		public final int burnTime;
		
		ResourceType(String name) {
			this.name = name;
			this.isMaterial = false;
			this.burnTime = -1;
		}
		
		ResourceType(String name, boolean isMaterial) {
			this.name = name;
			this.isMaterial = isMaterial;
			this.burnTime = -1;
		}
		
		ResourceType(String name, int burnTime) {
			this.name = name;
			this.isMaterial = false;
			this.burnTime = burnTime;
		}
		
		ResourceType(String name, boolean isMaterial, int burnTime) {
			this.name = name;
			this.isMaterial = isMaterial;
			this.burnTime = burnTime;
		}
		
		public static ResourceType byMeta(int meta) {
			return values[meta];
		}
		
		public static ResourceType byName(String name) {
			return NAME_LOOKUP.get(name);
		}
		
		public int toMeta() {
			return ordinal();
		}
		
		static {
			for (ResourceType type : values) {
				NAME_LOOKUP.put(type.name, type);
			}
		}
	}
}

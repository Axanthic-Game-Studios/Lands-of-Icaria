package com.axanthic.icaria.common.materials;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.tags.IcariaBlockTags;
import com.axanthic.icaria.common.tags.IcariaItemTags;

import net.minecraft.world.item.ToolMaterial;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaToolMaterials {
	public static final ToolMaterial CHERT = new ToolMaterial(IcariaBlockTags.INCORRECT_FOR_CHERT_TOOL, 128, 4.0F, 1.0F, 5, IcariaItemTags.TOOL_MATERIALS_CHERT);
	public static final ToolMaterial CHALKOS = new ToolMaterial(IcariaBlockTags.INCORRECT_FOR_CHALKOS_TOOL, 192, 5.0F, 1.0F, 10, IcariaItemTags.TOOL_MATERIALS_CHALKOS);
	public static final ToolMaterial KASSITEROS = new ToolMaterial(IcariaBlockTags.INCORRECT_FOR_KASSITEROS_TOOL, 256, 6.0F, 2.0F, 10, IcariaItemTags.TOOL_MATERIALS_KASSITEROS);
	public static final ToolMaterial ORICHALCUM = new ToolMaterial(IcariaBlockTags.INCORRECT_FOR_ORICHALCUM_TOOL, 640, 7.0F, 2.0F, 15, IcariaItemTags.TOOL_MATERIALS_ORICHALCUM);
	public static final ToolMaterial VANADIUMSTEEL = new ToolMaterial(IcariaBlockTags.INCORRECT_FOR_VANADIUMSTEEL_TOOL, 1024, 9.0F, 4.0F, 15, IcariaItemTags.TOOL_MATERIALS_VANADIUMSTEEL);
	public static final ToolMaterial SIDEROS = new ToolMaterial(IcariaBlockTags.INCORRECT_FOR_SIDEROS_TOOL, 1536, 8.0F, 3.0F, 10, IcariaItemTags.TOOL_MATERIALS_SIDEROS);
	public static final ToolMaterial MOLYBDENUMSTEEL = new ToolMaterial(IcariaBlockTags.INCORRECT_FOR_MOLYBDENUMSTEEL_TOOL, 2048, 9.0F, 4.0F, 15, IcariaItemTags.TOOL_MATERIALS_MOLYBDENUMSTEEL);
}

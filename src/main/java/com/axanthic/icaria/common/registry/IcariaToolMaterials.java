package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.data.provider.tags.IcariaBlockTagsProvider;
import com.axanthic.icaria.data.provider.tags.IcariaItemTagsProvider;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.world.item.ToolMaterial;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaToolMaterials {
	public static final ToolMaterial CHERT = new ToolMaterial(IcariaBlockTagsProvider.INCORRECT_FOR_CHERT_TOOL, 59, 2.0F, 0.0F, 15, IcariaItemTagsProvider.TOOL_MATERIALS_CHERT);
	public static final ToolMaterial CHALKOS = new ToolMaterial(IcariaBlockTagsProvider.INCORRECT_FOR_CHALKOS_TOOL, 174, 5.0F, 1.0F, 15, IcariaItemTagsProvider.TOOL_MATERIALS_CHALKOS);
	public static final ToolMaterial KASSITEROS = new ToolMaterial(IcariaBlockTagsProvider.INCORRECT_FOR_KASSITEROS_TOOL, 234, 5.0F, 1.5F, 15, IcariaItemTagsProvider.TOOL_MATERIALS_KASSITEROS);
	public static final ToolMaterial ORICHALCUM = new ToolMaterial(IcariaBlockTagsProvider.INCORRECT_FOR_ORICHALCUM_TOOL, 385, 6.0F, 2.0F, 19, IcariaItemTagsProvider.TOOL_MATERIALS_ORICHALCUM);
	public static final ToolMaterial VANADIUMSTEEL = new ToolMaterial(IcariaBlockTagsProvider.INCORRECT_FOR_VANADIUMSTEEL_TOOL, 424, 4.0F, 3.0F, 11, IcariaItemTagsProvider.TOOL_MATERIALS_VANADIUMSTEEL);
	public static final ToolMaterial SIDEROS = new ToolMaterial(IcariaBlockTagsProvider.INCORRECT_FOR_SIDEROS_TOOL, 528, 7.0F, 2.5F, 14, IcariaItemTagsProvider.TOOL_MATERIALS_SIDEROS);
	public static final ToolMaterial MOLYBDENUMSTEEL = new ToolMaterial(IcariaBlockTagsProvider.INCORRECT_FOR_MOLYBDENUMSTEEL_TOOL, 673, 7.5F, 2.0F, 12, IcariaItemTagsProvider.TOOL_MATERIALS_MOLYBDENUMSTEEL);
}

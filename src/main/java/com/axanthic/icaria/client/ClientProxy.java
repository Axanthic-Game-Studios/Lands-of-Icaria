package com.axanthic.icaria.client;

import com.axanthic.icaria.common.CommonProxy;
import com.axanthic.icaria.common.registry.LandsOfIcariaBlocks;

import net.minecraft.client.Minecraft;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.block.state.BlockState;

public class ClientProxy extends CommonProxy {
	public ClientProxy() {

	}

	@Override
	public void init() {
		BlockColors blockColors = Minecraft.getInstance().getBlockColors();
		ItemColors itemColors = Minecraft.getInstance().getItemColors();

		blockColors.register((state, getter, pos, i) -> getter != null && pos != null ? BiomeColors.getAverageGrassColor(getter, pos) : GrassColor.get(0.60D, 0.10D), LandsOfIcariaBlocks.MARL_GRASS.get());

		ItemColor itemBlockColorHandler = (stack, tintIndex) -> {
			BlockState state = ((BlockItem) stack.getItem()).getBlock().defaultBlockState();
			return blockColors.getColor(state, null, null, tintIndex);
		};

		itemColors.register(itemBlockColorHandler, LandsOfIcariaBlocks.MARL_GRASS.get());

		ItemBlockRenderTypes.setRenderLayer(LandsOfIcariaBlocks.MARL_GRASS.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(LandsOfIcariaBlocks.GRAINGLASS.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(LandsOfIcariaBlocks.GRAINGLASS_PANE.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(LandsOfIcariaBlocks.GRAINGLASS_PANE_HORIZONTAL.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(LandsOfIcariaBlocks.SILKGLASS.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(LandsOfIcariaBlocks.SILKGLASS_PANE.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(LandsOfIcariaBlocks.SILKGLASS_PANE_HORIZONTAL.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(LandsOfIcariaBlocks.ARISTONE.get(), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(LandsOfIcariaBlocks.JELLYFISH_JELLY_BLOCK.get(), RenderType.translucent());
	}
}

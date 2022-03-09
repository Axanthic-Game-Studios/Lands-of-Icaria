package com.axanthic.icaria.client.proxy;

import com.axanthic.icaria.client.render.ThrownBidentRenderer;
import com.axanthic.icaria.common.proxy.CommonProxy;
import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaEntities;

import com.axanthic.icaria.common.registry.IcariaFluids;
import net.minecraft.client.Minecraft;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.block.state.BlockState;

public class ClientProxy extends CommonProxy {
	public ClientProxy() {

	}

	public void setup() {

	}

	@Override
	public void loadComplete() {
		BlockColors blockColors = Minecraft.getInstance().getBlockColors();
		ItemColors itemColors = Minecraft.getInstance().getItemColors();

		blockColors.register((state, getter, pos, i) -> getter != null && pos != null ? BiomeColors.getAverageGrassColor(getter, pos) : GrassColor.get(0.60D, 0.10D), IcariaBlocks.MARL_GRASS.get());

		ItemColor itemBlockColorHandler = (stack, tintIndex) -> {
			BlockState state = ((BlockItem) stack.getItem()).getBlock().defaultBlockState();
			return blockColors.getColor(state, null, null, tintIndex);
		};

		itemColors.register(itemBlockColorHandler, IcariaBlocks.MARL_GRASS.get());

		ItemBlockRenderTypes.setRenderLayer(IcariaFluids.HYLIASTRUM_FLUID_SOURCE.get(), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(IcariaFluids.HYLIASTRUM_FLUID_FLOWING.get(), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(IcariaFluids.MEDITERRANEAN_WATER_SOURCE.get(), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(IcariaFluids.MEDITERRANEAN_WATER_FLOWING.get(), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(IcariaFluids.UPWARDS_FLUID_SOURCE.get(), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(IcariaFluids.UPWARDS_FLUID_FLOWING.get(), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.MARL_GRASS.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.GRAINGLASS.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.GRAINGLASS_PANE.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.GRAINGLASS_PANE_HORIZONTAL.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.SILKGLASS.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.SILKGLASS_PANE.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.SILKGLASS_PANE_HORIZONTAL.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.ARISTONE.get(), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.JELLYFISH_JELLY_BLOCK.get(), RenderType.translucent());

		EntityRenderers.register(IcariaEntities.BIDENT.get(), ThrownBidentRenderer::new);
	}
}

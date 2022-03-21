package com.axanthic.icaria.client.proxy;

import com.axanthic.icaria.client.render.ThrownBidentRenderer;
import com.axanthic.icaria.common.proxy.CommonProxy;
import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaEntities;
import com.axanthic.icaria.common.registry.IcariaFluids;

import com.axanthic.icaria.common.registry.IcariaItems;
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

	@Override
	public void setup() {

	}

	@Override
	public void loadComplete() {
		BlockColors blockColors = Minecraft.getInstance().getBlockColors();
		ItemColors itemColors = Minecraft.getInstance().getItemColors();

		blockColors.register((state, getter, pos, i) -> getter != null && pos != null ? BiomeColors.getAverageGrassColor(getter, pos) : GrassColor.get(0.60D, 0.10D), IcariaBlocks.MARL_GRASS.get(), IcariaBlocks.FERN.get(), IcariaBlocks.POTTED_FERN.get(), IcariaBlocks.SMALL_GRASS.get(), IcariaBlocks.MEDIUM_GRASS.get(), IcariaBlocks.LARGE_GRASS.get(), IcariaBlocks.GRAIN_0.get(), IcariaBlocks.GRAIN_1.get(), IcariaBlocks.GRAIN_2.get(), IcariaBlocks.GRAIN_3.get(), IcariaBlocks.GRAIN_4.get(), IcariaBlocks.GRAIN_5.get(), IcariaBlocks.BLINDWEED.get(), IcariaBlocks.POTTED_BLINDWEED.get(), IcariaBlocks.CHAMEOMILE.get(), IcariaBlocks.POTTED_CHAMEOMILE.get(), IcariaBlocks.CHARMONDER.get(), IcariaBlocks.POTTED_CHARMONDER.get(), IcariaBlocks.CLOVER.get(), IcariaBlocks.POTTED_CLOVER.get(), IcariaBlocks.FIREHILT.get(), IcariaBlocks.POTTED_FIREHILT.get(), IcariaBlocks.BLUE_HYDRACINTH.get(), IcariaBlocks.POTTED_BLUE_HYDRACINTH.get(), IcariaBlocks.PURPLE_HYDRACINTH.get(), IcariaBlocks.POTTED_PURPLE_HYDRACINTH.get(), IcariaBlocks.LIONFANGS.get(), IcariaBlocks.POTTED_LIONFANGS.get(), IcariaBlocks.SPEARDROPS.get(), IcariaBlocks.POTTED_SPEARDROPS.get(), IcariaBlocks.PURPLE_STAGHORN.get(), IcariaBlocks.POTTED_PURPLE_STAGHORN.get(), IcariaBlocks.YELLOW_STAGHORN.get(), IcariaBlocks.POTTED_YELLOW_STAGHORN.get(), IcariaBlocks.BLUE_STORMCOTTON.get(), IcariaBlocks.POTTED_BLUE_STORMCOTTON.get(), IcariaBlocks.PINK_STORMCOTTON.get(), IcariaBlocks.POTTED_PINK_STORMCOTTON.get(), IcariaBlocks.PURPLE_STORMCOTTON.get(), IcariaBlocks.POTTED_PURPLE_STORMCOTTON.get(), IcariaBlocks.SUNKETTLE.get(), IcariaBlocks.POTTED_SUNKETTLE.get(), IcariaBlocks.SUNSPONGE.get(), IcariaBlocks.POTTED_SUNSPONGE.get(), IcariaBlocks.VOIDLILY.get(), IcariaBlocks.POTTED_VOIDLILY.get());

		ItemColor itemBlockColorHandler = (stack, tintIndex) -> {
			BlockState state = ((BlockItem) stack.getItem()).getBlock().defaultBlockState();
			return blockColors.getColor(state, null, null, tintIndex);
		};

		itemColors.register(itemBlockColorHandler, IcariaItems.MARL_GRASS.get());

		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.MARL_GRASS.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.GRAINGLASS.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.GRAINGLASS_PANE.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.GRAINGLASS_PANE_HORIZONTAL.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.SILKGLASS.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.SILKGLASS_PANE.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.SILKGLASS_PANE_HORIZONTAL.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.ARISTONE.get(), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.JELLYFISH_JELLY_BLOCK.get(), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.CALCITE_BLOCK.get(), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.HALITE_BLOCK.get(), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.JASPER_BLOCK.get(), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.ZIRCON_BLOCK.get(), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.CYPRESS_SAPLING.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.POTTED_CYPRESS_SAPLING.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.FALLEN_CYPRESS_LEAVES.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.CYPRESS_DOOR.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.CYPRESS_TRAPDOOR.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.CYPRESS_LADDER.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.DROUGHTROOT_SAPLING.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.POTTED_DROUGHTROOT_SAPLING.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.FALLEN_DROUGHTROOT_LEAVES.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.DROUGHTROOT_DOOR.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.DROUGHTROOT_TRAPDOOR.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.DROUGHTROOT_LADDER.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.FIR_SAPLING.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.POTTED_FIR_SAPLING.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.FALLEN_FIR_LEAVES.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.FIR_DOOR.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.FIR_TRAPDOOR.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.FIR_LADDER.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.LAUREL_SAPLING.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.POTTED_LAUREL_SAPLING.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.FALLEN_LAUREL_LEAVES.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.LAUREL_DOOR.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.LAUREL_TRAPDOOR.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.LAUREL_LADDER.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.OLIVE_SAPLING.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.POTTED_OLIVE_SAPLING.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.FALLEN_OLIVE_LEAVES.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.OLIVE_DOOR.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.OLIVE_TRAPDOOR.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.OLIVE_LADDER.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.PLANE_SAPLING.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.POTTED_PLANE_SAPLING.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.FALLEN_PLANE_LEAVES.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.PLANE_DOOR.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.PLANE_TRAPDOOR.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.PLANE_LADDER.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.POPULUS_SAPLING.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.POTTED_POPULUS_SAPLING.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.FALLEN_POPULUS_LEAVES.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.POPULUS_DOOR.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.POPULUS_TRAPDOOR.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.POPULUS_LADDER.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.FERN.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.POTTED_FERN.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.SMALL_GRASS.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.MEDIUM_GRASS.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.LARGE_GRASS.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.GRAIN_0.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.GRAIN_1.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.GRAIN_2.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.GRAIN_3.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.GRAIN_4.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.GRAIN_5.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.BLINDWEED.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.POTTED_BLINDWEED.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.CHAMEOMILE.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.POTTED_CHAMEOMILE.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.CHARMONDER.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.POTTED_CHARMONDER.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.CLOVER.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.POTTED_CLOVER.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.FIREHILT.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.POTTED_FIREHILT.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.BLUE_HYDRACINTH.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.POTTED_BLUE_HYDRACINTH.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.PURPLE_HYDRACINTH.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.POTTED_PURPLE_HYDRACINTH.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.LIONFANGS.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.POTTED_LIONFANGS.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.SPEARDROPS.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.POTTED_SPEARDROPS.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.PURPLE_STAGHORN.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.POTTED_PURPLE_STAGHORN.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.YELLOW_STAGHORN.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.POTTED_YELLOW_STAGHORN.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.BLUE_STORMCOTTON.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.POTTED_BLUE_STORMCOTTON.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.PINK_STORMCOTTON.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.POTTED_PINK_STORMCOTTON.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.PURPLE_STORMCOTTON.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.POTTED_PURPLE_STORMCOTTON.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.SUNKETTLE.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.POTTED_SUNKETTLE.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.SUNSPONGE.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.POTTED_SUNSPONGE.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.VOIDLILY.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.POTTED_VOIDLILY.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.BLUE_GROUND_FLOWERS.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.CYAN_GROUND_FLOWERS.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.PINK_GROUND_FLOWERS.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.PURPLE_GROUND_FLOWERS.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.RED_GROUND_FLOWERS.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.WHITE_GROUND_FLOWERS.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.STRAWBERRY_BUSH.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.SPELT_CROP.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.STRAWBERRY_CROP.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.PHYSALIS_CROP.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.ONION_CROP.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaFluids.HYLIASTRUM_FLUID_SOURCE.get(), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(IcariaFluids.HYLIASTRUM_FLUID_FLOWING.get(), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(IcariaFluids.MEDITERRANEAN_WATER_SOURCE.get(), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(IcariaFluids.MEDITERRANEAN_WATER_FLOWING.get(), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(IcariaFluids.UPWARDS_FLUID_SOURCE.get(), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(IcariaFluids.UPWARDS_FLUID_FLOWING.get(), RenderType.translucent());

		EntityRenderers.register(IcariaEntities.BIDENT.get(), ThrownBidentRenderer::new);
	}
}

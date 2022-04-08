package com.axanthic.icaria.client.proxy;

import com.axanthic.icaria.client.render.CrystalBlockRenderer;
import com.axanthic.icaria.client.render.IcariaSignBlockRenderer;
import com.axanthic.icaria.client.render.ThrownBidentRenderer;
import com.axanthic.icaria.common.proxy.CommonProxy;
import com.axanthic.icaria.common.registry.*;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.client.Minecraft;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.block.state.BlockState;

public class ClientProxy extends CommonProxy {
	public ClientProxy() {

	}

	@Override
	public void setup() {
		for (IcariaItems.ToolCombination tools : IcariaItems.TOOLS) {
			ItemProperties.register(tools.BIDENT.get(), new ResourceLocation(IcariaInfo.MODID, "throwing"), (stack, world, entity, id) -> entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F);
		}
	}

	@Override
	public void loadComplete() {
		BlockColors blockColors = Minecraft.getInstance().getBlockColors();
		ItemColors itemColors = Minecraft.getInstance().getItemColors();

		blockColors.register((state, getter, pos, i) -> getter != null && pos != null ? BiomeColors.getAverageGrassColor(getter, pos) : GrassColor.get(0.60D, 0.10D),
			IcariaBlocks.MARL_GRASS.get(),
			IcariaBlocks.GROWING_BLOOMY_VINE.get(),
			IcariaBlocks.BLOOMY_VINE.get(),
			IcariaBlocks.BLOOMING_BLOOMY_VINE.get(),
			IcariaBlocks.RIPE_BLOOMY_VINE.get(),
			IcariaBlocks.GROWING_BRANCHY_VINE.get(),
			IcariaBlocks.BRANCHY_VINE.get(),
			IcariaBlocks.GROWING_BRUSHY_VINE.get(),
			IcariaBlocks.RIPE_BRUSHY_VINE.get(),
			IcariaBlocks.BRUSHY_VINE.get(),
			IcariaBlocks.DEAD_DRY_VINE.get(),
			IcariaBlocks.GROWING_DRY_VINE.get(),
			IcariaBlocks.DRY_VINE.get(),
			IcariaBlocks.GROWING_REEDY_VINE.get(),
			IcariaBlocks.REEDY_VINE.get(),
			IcariaBlocks.DEAD_SWIRLY_VINE.get(),
			IcariaBlocks.GROWING_SWIRLY_VINE.get(),
			IcariaBlocks.SWIRLY_VINE.get(),
			IcariaBlocks.DEAD_THORNY_VINE.get(),
			IcariaBlocks.GROWING_THORNY_VINE.get(),
			IcariaBlocks.THORNY_VINE.get(),
			IcariaBlocks.FERN.get(),
			IcariaBlocks.POTTED_FERN.get(),
			IcariaBlocks.SMALL_GRASS.get(),
			IcariaBlocks.MEDIUM_GRASS.get(),
			IcariaBlocks.LARGE_GRASS.get(),
			IcariaBlocks.GRAIN_0.get(),
			IcariaBlocks.GRAIN_1.get(),
			IcariaBlocks.GRAIN_2.get(),
			IcariaBlocks.GRAIN_3.get(),
			IcariaBlocks.GRAIN_4.get(),
			IcariaBlocks.GRAIN_5.get(),
			IcariaBlocks.BLINDWEED.get(),
			IcariaBlocks.POTTED_BLINDWEED.get(),
			IcariaBlocks.CHAMEOMILE.get(),
			IcariaBlocks.POTTED_CHAMEOMILE.get(),
			IcariaBlocks.CHARMONDER.get(),
			IcariaBlocks.POTTED_CHARMONDER.get(),
			IcariaBlocks.CLOVER.get(),
			IcariaBlocks.POTTED_CLOVER.get(),
			IcariaBlocks.FIREHILT.get(),
			IcariaBlocks.POTTED_FIREHILT.get(),
			IcariaBlocks.BLUE_HYDRACINTH.get(),
			IcariaBlocks.POTTED_BLUE_HYDRACINTH.get(),
			IcariaBlocks.PURPLE_HYDRACINTH.get(),
			IcariaBlocks.POTTED_PURPLE_HYDRACINTH.get(),
			IcariaBlocks.LIONFANGS.get(),
			IcariaBlocks.POTTED_LIONFANGS.get(),
			IcariaBlocks.SPEARDROPS.get(),
			IcariaBlocks.POTTED_SPEARDROPS.get(),
			IcariaBlocks.PURPLE_STAGHORN.get(),
			IcariaBlocks.POTTED_PURPLE_STAGHORN.get(),
			IcariaBlocks.YELLOW_STAGHORN.get(),
			IcariaBlocks.POTTED_YELLOW_STAGHORN.get(),
			IcariaBlocks.BLUE_STORMCOTTON.get(),
			IcariaBlocks.POTTED_BLUE_STORMCOTTON.get(),
			IcariaBlocks.PINK_STORMCOTTON.get(),
			IcariaBlocks.POTTED_PINK_STORMCOTTON.get(),
			IcariaBlocks.PURPLE_STORMCOTTON.get(),
			IcariaBlocks.POTTED_PURPLE_STORMCOTTON.get(),
			IcariaBlocks.SUNKETTLE.get(),
			IcariaBlocks.POTTED_SUNKETTLE.get(),
			IcariaBlocks.SUNSPONGE.get(),
			IcariaBlocks.POTTED_SUNSPONGE.get(),
			IcariaBlocks.VOIDLILY.get(),
			IcariaBlocks.POTTED_VOIDLILY.get(),
			IcariaBlocks.WHITE_BROMELIA.get(),
			IcariaBlocks.POTTED_WHITE_BROMELIA.get(),
			IcariaBlocks.ORANGE_BROMELIA.get(),
			IcariaBlocks.POTTED_ORANGE_BROMELIA.get(),
			IcariaBlocks.PINK_BROMELIA.get(),
			IcariaBlocks.POTTED_PINK_BROMELIA.get(),
			IcariaBlocks.PURPLE_BROMELIA.get(),
			IcariaBlocks.POTTED_PURPLE_BROMELIA.get());

		ItemColor itemBlockColorHandler = (stack, tintIndex) -> {
			BlockState state = ((BlockItem) stack.getItem()).getBlock().defaultBlockState();
			return blockColors.getColor(state, null, null, tintIndex);
		};

		itemColors.register(itemBlockColorHandler, IcariaItems.MARL_GRASS.get(), IcariaBlocks.WHITE_BROMELIA.get(), IcariaBlocks.ORANGE_BROMELIA.get(), IcariaBlocks.PINK_BROMELIA.get(), IcariaBlocks.PURPLE_BROMELIA.get());

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
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.DIM_TORCH.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.DIM_WALL_TORCH.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.DEAD_BLOOMY_VINE.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.GROWING_BLOOMY_VINE.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.BLOOMY_VINE.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.BLOOMING_BLOOMY_VINE.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.RIPE_BLOOMY_VINE.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.DEAD_BRANCHY_VINE.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.GROWING_BRANCHY_VINE.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.BRANCHY_VINE.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.DEAD_BRUSHY_VINE.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.GROWING_BRUSHY_VINE.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.RIPE_BRUSHY_VINE.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.BRUSHY_VINE.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.DEAD_DRY_VINE.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.GROWING_DRY_VINE.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.DRY_VINE.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.DEAD_REEDY_VINE.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.GROWING_REEDY_VINE.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.REEDY_VINE.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.DEAD_SWIRLY_VINE.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.GROWING_SWIRLY_VINE.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.SWIRLY_VINE.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.DEAD_THORNY_VINE.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.GROWING_THORNY_VINE.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.THORNY_VINE.get(), RenderType.cutout());
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
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.PSILOCYBOS.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.ROWAN.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.BLUE_GROUND_FLOWERS.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.CYAN_GROUND_FLOWERS.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.PINK_GROUND_FLOWERS.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.PURPLE_GROUND_FLOWERS.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.RED_GROUND_FLOWERS.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.WHITE_GROUND_FLOWERS.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.PALM_FERN.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.POTTED_PALM_FERN.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.WHITE_BROMELIA.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.POTTED_WHITE_BROMELIA.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.ORANGE_BROMELIA.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.POTTED_ORANGE_BROMELIA.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.PINK_BROMELIA.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.POTTED_PINK_BROMELIA.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.PURPLE_BROMELIA.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(IcariaBlocks.POTTED_PURPLE_BROMELIA.get(), RenderType.cutout());
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

		BlockEntityRenderers.register(IcariaBlockEntities.CRYSTAL.get(), CrystalBlockRenderer::new);
		BlockEntityRenderers.register(IcariaBlockEntities.SIGN.get(), IcariaSignBlockRenderer::new);
	}
}

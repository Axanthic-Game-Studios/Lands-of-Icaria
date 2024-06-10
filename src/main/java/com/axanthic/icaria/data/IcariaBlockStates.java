package com.axanthic.icaria.data;

import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaStoneDecoItems;
import com.axanthic.icaria.common.registry.IcariaWoodDecoItems;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoorHingeSide;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;

import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class IcariaBlockStates extends BlockStateProvider {
	public static final List<Supplier<? extends Block>> MIRRORED = new ArrayList<>();
	public static final List<Supplier<? extends Block>> ROTATED = new ArrayList<>();

	public IcariaBlockStates(PackOutput pOutput, String pId, ExistingFileHelper pHelper) {
		super(pOutput, pId, pHelper);
	}

	@Override
	public void registerStatesAndModels() {
		IcariaBlockStates.MIRRORED.add(IcariaBlocks.ARACHNE_STRING_BLOCK);

		IcariaBlockStates.ROTATED.add(IcariaBlocks.MARL);
		IcariaBlockStates.ROTATED.add(IcariaBlocks.COARSE_MARL);
		IcariaBlockStates.ROTATED.add(IcariaBlocks.DRY_LAKE_BED);
		IcariaBlockStates.ROTATED.add(IcariaBlocks.MARL_ADOBE);
		IcariaBlockStates.ROTATED.add(IcariaBlocks.DOLOMITE_ADOBE);
		IcariaBlockStates.ROTATED.add(IcariaBlocks.GRAINEL);
		IcariaBlockStates.ROTATED.add(IcariaBlocks.GRAINITE_ADOBE);
		IcariaBlockStates.ROTATED.add(IcariaBlocks.YELLOWSTONE_ADOBE);
		IcariaBlockStates.ROTATED.add(IcariaBlocks.SILKSAND);
		IcariaBlockStates.ROTATED.add(IcariaBlocks.SILKSTONE_ADOBE);
		IcariaBlockStates.ROTATED.add(IcariaBlocks.SUNSTONE_ADOBE);
		IcariaBlockStates.ROTATED.add(IcariaBlocks.VOIDSHALE_ADOBE);
		IcariaBlockStates.ROTATED.add(IcariaBlocks.BAETYL_ADOBE);
		IcariaBlockStates.ROTATED.add(IcariaBlocks.ENDER_JELLYFISH_JELLY_BLOCK);
		IcariaBlockStates.ROTATED.add(IcariaBlocks.FIRE_JELLYFISH_JELLY_BLOCK);
		IcariaBlockStates.ROTATED.add(IcariaBlocks.NATURE_JELLYFISH_JELLY_BLOCK);
		IcariaBlockStates.ROTATED.add(IcariaBlocks.VOID_JELLYFISH_JELLY_BLOCK);
		IcariaBlockStates.ROTATED.add(IcariaBlocks.WATER_JELLYFISH_JELLY_BLOCK);

		for (var blocks : IcariaBlocks.SIMPLE_BLOCKS) {
			if (IcariaBlockStates.MIRRORED.contains(blocks)) {
				this.mirroredBlockWithItem(blocks);
			} else if (IcariaBlockStates.ROTATED.contains(blocks)) {
				this.rotatedBlockWithItem(blocks);
			} else {
				this.baseBlockWithItem(blocks);
			}
		}

		this.baseBlockWithItem(IcariaBlocks.MARL_CHERT);
		this.baseBlockWithItem(IcariaBlocks.MARL_BONES);
		this.baseBlockWithItem(IcariaBlocks.MARL_LIGNITE);
		this.baseBlockWithItem(IcariaBlocks.GRAINEL_CHERT);
		this.baseBlockWithItem(IcariaBlocks.GRAINGLASS);
		this.baseBlockWithItem(IcariaBlocks.YELLOWSTONE);
		this.baseBlockWithItem(IcariaBlocks.SILKGLASS);
		this.baseBlockWithItem(IcariaBlocks.SILKSTONE);
		this.baseBlockWithItem(IcariaBlocks.SUNSTONE);
		this.baseBlockWithItem(IcariaBlocks.VOIDSHALE);
		this.baseBlockWithItem(IcariaBlocks.BAETYL);
		this.baseBlockWithItem(IcariaBlocks.LIGNITE_ORE);
		this.baseBlockWithItem(IcariaBlocks.CHALKOS_ORE);
		this.baseBlockWithItem(IcariaBlocks.KASSITEROS_ORE);
		this.baseBlockWithItem(IcariaBlocks.DOLOMITE_ORE);
		this.baseBlockWithItem(IcariaBlocks.VANADIUM_ORE);
		this.baseBlockWithItem(IcariaBlocks.SLIVER_ORE);
		this.baseBlockWithItem(IcariaBlocks.SIDEROS_ORE);
		this.baseBlockWithItem(IcariaBlocks.ANTHRACITE_ORE);
		this.baseBlockWithItem(IcariaBlocks.MOLYBDENUM_ORE);
		this.baseBlockWithItem(IcariaBlocks.HYLIASTRUM_ORE);
		this.baseBlockWithItem(IcariaBlocks.CYPRESS_LEAVES);
		this.baseBlockWithItem(IcariaBlocks.DROUGHTROOT_LEAVES);
		this.baseBlockWithItem(IcariaBlocks.FIR_LEAVES);
		this.baseBlockWithItem(IcariaBlocks.LAUREL_LEAVES);
		this.baseBlockWithItem(IcariaBlocks.PLANE_LEAVES);
		this.baseBlockWithItem(IcariaBlocks.POPULUS_LEAVES);

		this.mirroredBlockWithItem(IcariaBlocks.LOAM);
		this.mirroredBlockWithItem(IcariaBlocks.SMOOTH_RELICSTONE);

		this.axisBlockWithItem(IcariaBlocks.DOLOMITE_PILLAR);
		this.axisBlockWithItem(IcariaBlocks.RELICSTONE_PILLAR);
		this.axisBlockWithItem(IcariaBlocks.SPELT_BALE_BLOCK);
		this.axisBlockWithItem(IcariaBlocks.CYPRESS_WOOD);
		this.axisBlockWithItem(IcariaBlocks.STRIPPED_CYPRESS_WOOD);
		this.axisBlockWithItem(IcariaBlocks.CYPRESS_LOG);
		this.axisBlockWithItem(IcariaBlocks.STRIPPED_CYPRESS_LOG);
		this.axisBlockWithItem(IcariaBlocks.DROUGHTROOT_WOOD);
		this.axisBlockWithItem(IcariaBlocks.STRIPPED_DROUGHTROOT_WOOD);
		this.axisBlockWithItem(IcariaBlocks.DROUGHTROOT_LOG);
		this.axisBlockWithItem(IcariaBlocks.STRIPPED_DROUGHTROOT_LOG);
		this.axisBlockWithItem(IcariaBlocks.FIR_WOOD);
		this.axisBlockWithItem(IcariaBlocks.STRIPPED_FIR_WOOD);
		this.axisBlockWithItem(IcariaBlocks.FIR_LOG);
		this.axisBlockWithItem(IcariaBlocks.STRIPPED_FIR_LOG);
		this.axisBlockWithItem(IcariaBlocks.LAUREL_WOOD);
		this.axisBlockWithItem(IcariaBlocks.STRIPPED_LAUREL_WOOD);
		this.axisBlockWithItem(IcariaBlocks.LAUREL_LOG);
		this.axisBlockWithItem(IcariaBlocks.STRIPPED_LAUREL_LOG);
		this.axisBlockWithItem(IcariaBlocks.OLIVE_WOOD);
		this.axisBlockWithItem(IcariaBlocks.STRIPPED_OLIVE_WOOD);
		this.axisBlockWithItem(IcariaBlocks.OLIVE_LOG);
		this.axisBlockWithItem(IcariaBlocks.STRIPPED_OLIVE_LOG);
		this.axisBlockWithItem(IcariaBlocks.PLANE_WOOD);
		this.axisBlockWithItem(IcariaBlocks.STRIPPED_PLANE_WOOD);
		this.axisBlockWithItem(IcariaBlocks.PLANE_LOG);
		this.axisBlockWithItem(IcariaBlocks.STRIPPED_PLANE_LOG);
		this.axisBlockWithItem(IcariaBlocks.POPULUS_WOOD);
		this.axisBlockWithItem(IcariaBlocks.STRIPPED_POPULUS_WOOD);
		this.axisBlockWithItem(IcariaBlocks.POPULUS_LOG);
		this.axisBlockWithItem(IcariaBlocks.STRIPPED_POPULUS_LOG);

		this.paneBlock(IcariaBlocks.GRAINGLASS_PANE, IcariaBlocks.GRAINGLASS);
		this.paneBlock(IcariaBlocks.SILKGLASS_PANE, IcariaBlocks.SILKGLASS);

		this.doorBlock(IcariaBlocks.CYPRESS_DOOR);
		this.doorBlock(IcariaBlocks.DROUGHTROOT_DOOR);
		this.doorBlock(IcariaBlocks.FIR_DOOR);
		this.doorBlock(IcariaBlocks.LAUREL_DOOR);
		this.doorBlock(IcariaBlocks.OLIVE_DOOR);
		this.doorBlock(IcariaBlocks.PLANE_DOOR);
		this.doorBlock(IcariaBlocks.POPULUS_DOOR);

		this.trapDoorWithItem(IcariaBlocks.CYPRESS_TRAPDOOR);
		this.trapDoorWithItem(IcariaBlocks.DROUGHTROOT_TRAPDOOR);
		this.trapDoorWithItem(IcariaBlocks.FIR_TRAPDOOR);
		this.trapDoorWithItem(IcariaBlocks.LAUREL_TRAPDOOR);
		this.trapDoorWithItem(IcariaBlocks.OLIVE_TRAPDOOR);
		this.trapDoorWithItem(IcariaBlocks.PLANE_TRAPDOOR);
		this.trapDoorWithItem(IcariaBlocks.POPULUS_TRAPDOOR);

		for (var items : IcariaStoneDecoItems.STONE_DECO_ITEMS) {
			var resourceLocation = this.blockTexture(items.block.block.get());
			this.slabBlock(items.block.slab.get(), BuiltInRegistries.BLOCK.getKey(items.block.block.get()), resourceLocation);
			this.itemModels().slab(BuiltInRegistries.BLOCK.getKey(items.block.slab.get()).getPath(), resourceLocation, resourceLocation, resourceLocation);
			this.stairsBlock(items.block.stairs.get(), resourceLocation);
			this.itemModels().stairs(BuiltInRegistries.BLOCK.getKey(items.block.stairs.get()).getPath(), resourceLocation, resourceLocation, resourceLocation);
			this.wallBlock(items.block.wall.get(), resourceLocation);
			this.itemModels().wallInventory(BuiltInRegistries.BLOCK.getKey(items.block.wall.get()).getPath(), resourceLocation);
		}

		for (var items : IcariaWoodDecoItems.WOOD_DECO_ITEMS) {
			var resourceLocation = this.blockTexture(items.block.block.get());
			this.slabBlock(items.block.slab.get(), BuiltInRegistries.BLOCK.getKey(items.block.block.get()), resourceLocation);
			this.itemModels().slab(BuiltInRegistries.BLOCK.getKey(items.block.slab.get()).getPath(), resourceLocation, resourceLocation, resourceLocation);
			this.stairsBlock(items.block.stairs.get(), resourceLocation);
			this.itemModels().stairs(BuiltInRegistries.BLOCK.getKey(items.block.stairs.get()).getPath(), resourceLocation, resourceLocation, resourceLocation);
			this.fenceBlock(items.block.fence.get(), resourceLocation);
			this.itemModels().fenceInventory(BuiltInRegistries.BLOCK.getKey(items.block.fence.get()).getPath(), resourceLocation);
			this.fenceGateBlock(items.block.gate.get(), resourceLocation);
			this.itemModels().fenceGate(BuiltInRegistries.BLOCK.getKey(items.block.gate.get()).getPath(), resourceLocation);
		}
	}

	public void baseBlockWithItem(Supplier<? extends Block> pBlock) {
		this.simpleBlock(pBlock.get());
		this.itemBlock(pBlock);
	}

	public void axisBlockWithItem(Supplier<? extends RotatedPillarBlock> pBlock) {
		this.axisBlock(pBlock.get());
		this.itemBlock(pBlock);
	}

	public void paneBlock(Supplier<? extends IronBarsBlock> pPaneBlock, Supplier<? extends GlassBlock> pGlassBlock) {
		this.paneBlock(pPaneBlock.get(), new ResourceLocation(BuiltInRegistries.BLOCK.getKey(pGlassBlock.get()).getNamespace(), "block/" + BuiltInRegistries.BLOCK.getKey(pGlassBlock.get()).getPath()), new ResourceLocation(BuiltInRegistries.BLOCK.getKey(pGlassBlock.get()).getNamespace(), "block/" + BuiltInRegistries.BLOCK.getKey(pGlassBlock.get()).getPath() + "_pane"));
	}

	public void doorBlock(Supplier<? extends DoorBlock> pBlock) {
		this.doorBlock(BuiltInRegistries.BLOCK.getKey(pBlock.get()).getPath(), pBlock.get(), new ResourceLocation(IcariaInfo.ID + ":block/" + BuiltInRegistries.BLOCK.getKey(pBlock.get()).getPath() + "_bottom"), new ResourceLocation(IcariaInfo.ID + ":block/" + BuiltInRegistries.BLOCK.getKey(pBlock.get()).getPath() + "_top"));
	}

	public void doorBlock(String pName, Block pDoor, ResourceLocation pBottom, ResourceLocation pTop) {
		var bottomLeft = this.doorBlock(pName + "_bottom_left", "bottom_left", pBottom, pTop);
		var bottomLeftOpen = this.doorBlock(pName + "_bottom_left_open", "bottom_left_open", pBottom, pTop);
		var bottomRight = this.doorBlock(pName + "_bottom_right", "bottom_right", pBottom, pTop);
		var bottomRightOpen = this.doorBlock(pName + "_bottom_right_open", "bottom_right_open", pBottom, pTop);
		var topLeft = this.doorBlock(pName + "_top_left", "top_left", pBottom, pTop);
		var topLeftOpen = this.doorBlock(pName + "_top_left_open", "top_left_open", pBottom, pTop);
		var topRight = this.doorBlock(pName + "_top_right", "top_right", pBottom, pTop);
		var topRightOpen = this.doorBlock(pName + "_top_right_open", "top_right_open", pBottom, pTop);

		this.getVariantBuilder(pDoor).forAllStatesExcept(pState -> {
			int yRot = ((int) pState.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot()) + 90;

			boolean open = pState.getValue(BlockStateProperties.OPEN);
			boolean rightHinge = pState.getValue(BlockStateProperties.DOOR_HINGE) == DoorHingeSide.RIGHT;
			boolean right = rightHinge ^ open;

			if (open) {
				yRot += 90;
			}

			if (rightHinge && open) {
				yRot += 180;
			}

			yRot %= 360;

			var bottom = open ? (right ? bottomRightOpen : bottomLeftOpen) : (right ? bottomRight : bottomLeft);
			var top = open ? (right ? topRightOpen : topLeftOpen) : (right ? topRight : topLeft);

			return ConfiguredModel.builder().modelFile(pState.getValue(BlockStateProperties.DOUBLE_BLOCK_HALF) == DoubleBlockHalf.LOWER ? bottom : top).rotationY(yRot).build();
		}, BlockStateProperties.POWERED);
	}

	public void trapDoorWithItem(Supplier<? extends TrapDoorBlock> pBlock) {
		this.trapdoorBlock(pBlock.get(), new ResourceLocation(IcariaInfo.ID + ":block/" + BuiltInRegistries.BLOCK.getKey(pBlock.get()).getPath()), true);
		this.itemBlockTrapDoor(pBlock);
	}

	public void itemBlock(Supplier<? extends Block> pBlock) {
		this.itemModels().withExistingParent(BuiltInRegistries.BLOCK.getKey(pBlock.get()).getPath(), BuiltInRegistries.BLOCK.getKey(pBlock.get()).getNamespace() + ":block/" + BuiltInRegistries.BLOCK.getKey(pBlock.get()).getPath());
	}

	public void itemBlockTrapDoor(Supplier<? extends Block> pBlock) {
		this.itemModels().withExistingParent(BuiltInRegistries.BLOCK.getKey(pBlock.get()).getPath(), BuiltInRegistries.BLOCK.getKey(pBlock.get()).getNamespace() + ":block/" + BuiltInRegistries.BLOCK.getKey(pBlock.get()).getPath() + "_bottom");
	}

	public void mirroredBlockWithItem(Supplier<? extends Block> pBlock) {
		var normal = this.cubeAll(pBlock.get());
		var mirrored = this.models().singleTexture(BuiltInRegistries.BLOCK.getKey(pBlock.get()).getPath() + "_mirrored", new ResourceLocation(ModelProvider.BLOCK_FOLDER + "/cube_mirrored_all"), "all", this.blockTexture(pBlock.get()));
		this.getVariantBuilder(pBlock.get()).partialState().setModels(new ConfiguredModel(normal), new ConfiguredModel(normal, 0, 180, false), new ConfiguredModel(mirrored), new ConfiguredModel(mirrored, 0, 180, false));
		this.itemBlock(pBlock);
	}

	public void rotatedBlockWithItem(Supplier<? extends Block> pBlock) {
		this.getVariantBuilder(pBlock.get()).partialState().setModels(ConfiguredModel.allRotations(cubeAll(pBlock.get()), false));
		this.itemBlock(pBlock);
	}

	public BlockModelBuilder doorBlock(String pName, String pType, ResourceLocation pBottom, ResourceLocation pTop) {
		return this.models().withExistingParent(pName, "block/door_" + pType).texture("bottom", pBottom).texture("top", pTop);
	}
}

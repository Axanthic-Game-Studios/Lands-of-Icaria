package com.axanthic.icaria.data;

import com.axanthic.icaria.common.util.IcariaInfo;
import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaItems;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.DoorHingeSide;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;

import net.minecraftforge.client.model.generators.*;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class IcariaBlockStates extends BlockStateProvider {
	public static final List<RegistryObject<? extends Block>> MIRRORED = new ArrayList<>();
	public static final List<RegistryObject<? extends Block>> ROTATED = new ArrayList<>();

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

		for (RegistryObject<? extends Block> basicBlocks : IcariaBlocks.BASIC_BLOCKS) {
			if (IcariaBlockStates.MIRRORED.contains(basicBlocks)) {
				this.mirroredBlockWithItem(basicBlocks);
			} else if (IcariaBlockStates.ROTATED.contains(basicBlocks)) {
				this.rotatedBlockWithItem(basicBlocks);
			} else {
				this.baseBlockWithItem(basicBlocks);
			}
		}

		for (IcariaItems.StoneDecoItemBlocks deco : IcariaItems.STONE_DECO) {
			ResourceLocation resourceLocation = this.blockTexture(deco.block.block.get());
			this.slabBlock(Objects.requireNonNull(deco.block.slab).get(), deco.block.block.getId(), resourceLocation);
			this.itemModels().slab(deco.block.slab.getId().getPath(), resourceLocation, resourceLocation, resourceLocation);
			this.stairsBlock(Objects.requireNonNull(deco.block.stairs).get(), resourceLocation);
			this.itemModels().stairs(deco.block.stairs.getId().getPath(), resourceLocation, resourceLocation, resourceLocation);
			this.wallBlock(Objects.requireNonNull(deco.block.wall).get(), resourceLocation);
			this.itemModels().wallInventory(deco.block.wall.getId().getPath(), resourceLocation);
		}

		for (IcariaItems.WoodDecoItemBlocks deco : IcariaItems.WOOD_DECO) {
			ResourceLocation resourceLocation = this.blockTexture(deco.block.block.get());
			this.slabBlock(Objects.requireNonNull(deco.block.slab).get(), deco.block.block.getId(), resourceLocation);
			this.itemModels().slab(deco.block.slab.getId().getPath(), resourceLocation, resourceLocation, resourceLocation);
			this.stairsBlock(Objects.requireNonNull(deco.block.stairs).get(), resourceLocation);
			this.itemModels().stairs(deco.block.stairs.getId().getPath(), resourceLocation, resourceLocation, resourceLocation);
			this.fenceBlock(Objects.requireNonNull(deco.block.fence).get(), resourceLocation);
			this.itemModels().fenceInventory(deco.block.fence.getId().getPath(), resourceLocation);
			this.fenceGateBlock(Objects.requireNonNull(deco.block.gate).get(), resourceLocation);
			this.itemModels().fenceGate(deco.block.gate.getId().getPath(), resourceLocation);
		}
	}

	public void baseBlockWithItem(RegistryObject<? extends Block> pBlock) {
		this.simpleBlock(pBlock.get());
		this.itemBlock(pBlock);
	}

	public void axisBlockWithItem(RegistryObject<? extends RotatedPillarBlock> pBlock) {
		this.axisBlock(pBlock.get());
		this.itemBlock(pBlock);
	}

	public void paneBlock(RegistryObject<? extends IronBarsBlock> pPaneBlock, RegistryObject<? extends GlassBlock> pGlassBlock) {
		this.paneBlock(pPaneBlock.get(), new ResourceLocation(pGlassBlock.getId().getNamespace(), "block/" + pGlassBlock.getId().getPath()), new ResourceLocation(pGlassBlock.getId().getNamespace(), "block/" + pGlassBlock.getId().getPath() + "_pane"));
	}

	public void doorBlock(RegistryObject<? extends DoorBlock> pBlock) {
		this.doorBlock(pBlock.getId().getPath(), pBlock.get(), new ResourceLocation(IcariaInfo.ID + ":block/" + pBlock.getId().getPath() + "_bottom"), new ResourceLocation(IcariaInfo.ID + ":block/" + pBlock.getId().getPath() + "_top"));
	}

	public void doorBlock(String pName, Block pDoor, ResourceLocation pBottom, ResourceLocation pTop) {
		BlockModelBuilder bottomLeft = this.doorBlock(pName + "_bottom_left", "bottom_left", pBottom, pTop);
		BlockModelBuilder bottomLeftOpen = this.doorBlock(pName + "_bottom_left_open", "bottom_left_open", pBottom, pTop);
		BlockModelBuilder bottomRight = this.doorBlock(pName + "_bottom_right", "bottom_right", pBottom, pTop);
		BlockModelBuilder bottomRightOpen = this.doorBlock(pName + "_bottom_right_open", "bottom_right_open", pBottom, pTop);
		BlockModelBuilder topLeft = this.doorBlock(pName + "_top_left", "top_left", pBottom, pTop);
		BlockModelBuilder topLeftOpen = this.doorBlock(pName + "_top_left_open", "top_left_open", pBottom, pTop);
		BlockModelBuilder topRight = this.doorBlock(pName + "_top_right", "top_right", pBottom, pTop);
		BlockModelBuilder topRightOpen = this.doorBlock(pName + "_top_right_open", "top_right_open", pBottom, pTop);

		this.getVariantBuilder(pDoor).forAllStatesExcept(pState -> {
			int yRot = ((int) pState.getValue(DoorBlock.FACING).toYRot()) + 90;

			boolean open = pState.getValue(DoorBlock.OPEN);
			boolean rightHinge = pState.getValue(DoorBlock.HINGE) == DoorHingeSide.RIGHT;
			boolean right = rightHinge ^ open;

			if (open) {
				yRot += 90;
			}

			if (rightHinge && open) {
				yRot += 180;
			}

			yRot %= 360;

			BlockModelBuilder bottom = open ? (right ? bottomRightOpen : bottomLeftOpen) : (right ? bottomRight : bottomLeft);
			BlockModelBuilder top = open ? (right ? topRightOpen : topLeftOpen) : (right ? topRight : topLeft);

			return ConfiguredModel.builder().modelFile(pState.getValue(DoorBlock.HALF) == DoubleBlockHalf.LOWER ? bottom : top).rotationY(yRot).build();
		}, DoorBlock.POWERED);
	}

	public void trapDoorWithItem(RegistryObject<? extends TrapDoorBlock> pBlock) {
		this.trapdoorBlock(pBlock.get(), new ResourceLocation(IcariaInfo.ID + ":block/" + pBlock.getId().getPath()), true);
		this.itemBlockTrapDoor(pBlock);
	}

	public void itemBlock(RegistryObject<? extends Block> pBlock) {
		this.itemModels().withExistingParent(pBlock.getId().getPath(), pBlock.getId().getNamespace() + ":block/" + pBlock.getId().getPath());
	}

	public void itemBlockTrapDoor(RegistryObject<? extends Block> pBlock) {
		this.itemModels().withExistingParent(pBlock.getId().getPath(), pBlock.getId().getNamespace() + ":block/" + pBlock.getId().getPath() + "_bottom");
	}

	public void mirroredBlockWithItem(RegistryObject<? extends Block> pBlock) {
		ModelFile normal = this.cubeAll(pBlock.get());
		ModelFile mirrored = this.models().singleTexture(Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(pBlock.get())).getPath() + "_mirrored", new ResourceLocation(ModelProvider.BLOCK_FOLDER + "/cube_mirrored_all"), "all", this.blockTexture(pBlock.get()));
		this.getVariantBuilder(pBlock.get()).partialState().setModels(new ConfiguredModel(normal), new ConfiguredModel(normal, 0, 180, false), new ConfiguredModel(mirrored), new ConfiguredModel(mirrored, 0, 180, false));
		this.itemBlock(pBlock);
	}

	public void rotatedBlockWithItem(RegistryObject<? extends Block> pBlock) {
		this.getVariantBuilder(pBlock.get()).partialState().setModels(ConfiguredModel.allRotations(cubeAll(pBlock.get()), false));
		this.itemBlock(pBlock);
	}

	public BlockModelBuilder doorBlock(String pName, String pType, ResourceLocation pBottom, ResourceLocation pTop) {
		return this.models().withExistingParent(pName, "block/door_" + pType).texture("bottom", pBottom).texture("top", pTop);
	}
}

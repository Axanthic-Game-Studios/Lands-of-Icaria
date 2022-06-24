package com.axanthic.icaria.data;

import com.axanthic.icaria.common.util.IcariaInfo;
import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaItems;

import net.minecraft.data.DataGenerator;
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
	public List<RegistryObject<? extends Block>> MIRRORED = new ArrayList<>();
	public List<RegistryObject<? extends Block>> ROTATED = new ArrayList<>();

	public IcariaBlockStates(DataGenerator generator, ExistingFileHelper helper) {
		super(generator, IcariaInfo.MODID, helper);
	}

	@Override
	public void registerStatesAndModels() {
		MIRRORED.add(IcariaBlocks.ARACHNE_STRING_BLOCK);

		ROTATED.add(IcariaBlocks.MARL);
		ROTATED.add(IcariaBlocks.MARL_COARSE);
		ROTATED.add(IcariaBlocks.MARL_ADOBE);
		ROTATED.add(IcariaBlocks.DOLOMITE_ADOBE);
		ROTATED.add(IcariaBlocks.GRAINEL);
		ROTATED.add(IcariaBlocks.GRAINITE_ADOBE);
		ROTATED.add(IcariaBlocks.YELLOWSTONE_ADOBE);
		ROTATED.add(IcariaBlocks.SILKSAND);
		ROTATED.add(IcariaBlocks.SILKSTONE_ADOBE);
		ROTATED.add(IcariaBlocks.SUNSTONE_ADOBE);
		ROTATED.add(IcariaBlocks.VOIDSHALE_ADOBE);
		ROTATED.add(IcariaBlocks.BAETYL_ADOBE);
		ROTATED.add(IcariaBlocks.JELLYFISH_JELLY_BLOCK);

		baseBlockWithItem(IcariaBlocks.MARL_CHERT);
		baseBlockWithItem(IcariaBlocks.MARL_ROTTEN_BONES);
		baseBlockWithItem(IcariaBlocks.MARL_LIGNITE);
		baseBlockWithItem(IcariaBlocks.GRAINEL_CHERT);
		baseBlockWithItem(IcariaBlocks.GRAINGLASS);
		baseBlockWithItem(IcariaBlocks.YELLOWSTONE);
		baseBlockWithItem(IcariaBlocks.SILKGLASS);
		baseBlockWithItem(IcariaBlocks.SILKSTONE);
		baseBlockWithItem(IcariaBlocks.SUNSTONE);
		baseBlockWithItem(IcariaBlocks.VOIDSHALE);
		baseBlockWithItem(IcariaBlocks.BAETYL);
		baseBlockWithItem(IcariaBlocks.LIGNITE_ORE);
		baseBlockWithItem(IcariaBlocks.CHALKOS_ORE);
		baseBlockWithItem(IcariaBlocks.KASSITEROS_ORE);
		baseBlockWithItem(IcariaBlocks.DOLOMITE_ORE);
		baseBlockWithItem(IcariaBlocks.VANADIUM_ORE);
		baseBlockWithItem(IcariaBlocks.SLIVER_ORE);
		baseBlockWithItem(IcariaBlocks.SIDEROS_ORE);
		baseBlockWithItem(IcariaBlocks.ANTHRACITE_ORE);
		baseBlockWithItem(IcariaBlocks.MOLYBDENUM_ORE);
		baseBlockWithItem(IcariaBlocks.HYLIASTRUM_ORE);
		baseBlockWithItem(IcariaBlocks.CYPRESS_LEAVES);
		baseBlockWithItem(IcariaBlocks.DROUGHTROOT_LEAVES);
		baseBlockWithItem(IcariaBlocks.FIR_LEAVES);
		baseBlockWithItem(IcariaBlocks.LAUREL_LEAVES);
		baseBlockWithItem(IcariaBlocks.OLIVE_LEAVES);
		baseBlockWithItem(IcariaBlocks.OLIVE_LEAVES_BLACK);
		baseBlockWithItem(IcariaBlocks.OLIVE_LEAVES_GREEN);
		baseBlockWithItem(IcariaBlocks.PLANE_LEAVES);
		baseBlockWithItem(IcariaBlocks.POPULUS_LEAVES);

		mirroredBlockWithItem(IcariaBlocks.LOAM);
		mirroredBlockWithItem(IcariaBlocks.RELICSTONE_SMOOTH);

		axisBlockWithItem(IcariaBlocks.DOLOMITE_PILLAR);
		axisBlockWithItem(IcariaBlocks.RELICSTONE_PILLAR);
		axisBlockWithItem(IcariaBlocks.SPELT_BALE_BLOCK);
		axisBlockWithItem(IcariaBlocks.CYPRESS_WOOD);
		axisBlockWithItem(IcariaBlocks.STRIPPED_CYPRESS_WOOD);
		axisBlockWithItem(IcariaBlocks.CYPRESS_LOG);
		axisBlockWithItem(IcariaBlocks.STRIPPED_CYPRESS_LOG);
		axisBlockWithItem(IcariaBlocks.DROUGHTROOT_WOOD);
		axisBlockWithItem(IcariaBlocks.STRIPPED_DROUGHTROOT_WOOD);
		axisBlockWithItem(IcariaBlocks.DROUGHTROOT_LOG);
		axisBlockWithItem(IcariaBlocks.STRIPPED_DROUGHTROOT_LOG);
		axisBlockWithItem(IcariaBlocks.FIR_WOOD);
		axisBlockWithItem(IcariaBlocks.STRIPPED_FIR_WOOD);
		axisBlockWithItem(IcariaBlocks.FIR_LOG);
		axisBlockWithItem(IcariaBlocks.STRIPPED_FIR_LOG);
		axisBlockWithItem(IcariaBlocks.LAUREL_WOOD);
		axisBlockWithItem(IcariaBlocks.STRIPPED_LAUREL_WOOD);
		axisBlockWithItem(IcariaBlocks.LAUREL_LOG);
		axisBlockWithItem(IcariaBlocks.STRIPPED_LAUREL_LOG);
		axisBlockWithItem(IcariaBlocks.OLIVE_WOOD);
		axisBlockWithItem(IcariaBlocks.STRIPPED_OLIVE_WOOD);
		axisBlockWithItem(IcariaBlocks.OLIVE_LOG);
		axisBlockWithItem(IcariaBlocks.STRIPPED_OLIVE_LOG);
		axisBlockWithItem(IcariaBlocks.PLANE_WOOD);
		axisBlockWithItem(IcariaBlocks.STRIPPED_PLANE_WOOD);
		axisBlockWithItem(IcariaBlocks.PLANE_LOG);
		axisBlockWithItem(IcariaBlocks.STRIPPED_PLANE_LOG);
		axisBlockWithItem(IcariaBlocks.POPULUS_WOOD);
		axisBlockWithItem(IcariaBlocks.STRIPPED_POPULUS_WOOD);
		axisBlockWithItem(IcariaBlocks.POPULUS_LOG);
		axisBlockWithItem(IcariaBlocks.STRIPPED_POPULUS_LOG);

		paneBlock(IcariaBlocks.GRAINGLASS_PANE, IcariaBlocks.GRAINGLASS);
		paneBlock(IcariaBlocks.SILKGLASS_PANE, IcariaBlocks.SILKGLASS);

		doorBlock(IcariaBlocks.CYPRESS_DOOR);
		doorBlock(IcariaBlocks.DROUGHTROOT_DOOR);
		doorBlock(IcariaBlocks.FIR_DOOR);
		doorBlock(IcariaBlocks.LAUREL_DOOR);
		doorBlock(IcariaBlocks.OLIVE_DOOR);
		doorBlock(IcariaBlocks.PLANE_DOOR);
		doorBlock(IcariaBlocks.POPULUS_DOOR);

		trapDoorWithItem(IcariaBlocks.CYPRESS_TRAPDOOR);
		trapDoorWithItem(IcariaBlocks.DROUGHTROOT_TRAPDOOR);
		trapDoorWithItem(IcariaBlocks.FIR_TRAPDOOR);
		trapDoorWithItem(IcariaBlocks.LAUREL_TRAPDOOR);
		trapDoorWithItem(IcariaBlocks.OLIVE_TRAPDOOR);
		trapDoorWithItem(IcariaBlocks.PLANE_TRAPDOOR);
		trapDoorWithItem(IcariaBlocks.POPULUS_TRAPDOOR);

		for (RegistryObject<? extends Block> registryObject : IcariaBlocks.BASIC_BLOCKS) {
			if (MIRRORED.contains(registryObject)) {
				mirroredBlockWithItem(registryObject);
			} else if (ROTATED.contains(registryObject)) {
				rotatedBlockWithItem(registryObject);
			} else {
				baseBlockWithItem(registryObject);
			}
		}

		for (IcariaItems.StoneDecoItemBlocks deco : IcariaItems.STONE_BLOCKS) {
			ResourceLocation texture = blockTexture(deco.block.original.get());
			if (deco.SLAB != null) {
				slabBlock(Objects.requireNonNull(deco.block.SLAB).get(), deco.block.original.getId(), texture);
				itemModels().slab(deco.block.SLAB.getId().getPath(), texture, texture, texture);
			}
			if (deco.STAIRS != null) {
				stairsBlock(Objects.requireNonNull(deco.block.STAIRS).get(), texture);
				itemModels().stairs(deco.block.STAIRS.getId().getPath(), texture, texture, texture);
			}
			if (deco.WALL != null) {
				wallBlock(Objects.requireNonNull(deco.block.WALL).get(), texture);
				itemModels().wallInventory(deco.block.WALL.getId().getPath(), texture);
			}
		}

		for (IcariaItems.WoodDecoItemBlocks deco : IcariaItems.WOOD_BLOCKS) {
			ResourceLocation texture = blockTexture(deco.block.original.get());
			if (deco.SLAB != null) {
				slabBlock(Objects.requireNonNull(deco.block.SLAB).get(), deco.block.original.getId(), texture);
				itemModels().slab(deco.block.SLAB.getId().getPath(), texture, texture, texture);
			}
			if (deco.STAIRS != null) {
				stairsBlock(Objects.requireNonNull(deco.block.STAIRS).get(), texture);
				itemModels().stairs(deco.block.STAIRS.getId().getPath(), texture, texture, texture);
			}
			if (deco.FENCE != null) {
				fenceBlock(Objects.requireNonNull(deco.block.FENCE).get(), texture);
				itemModels().fenceInventory(deco.block.FENCE.getId().getPath(), texture);
			}
			if (deco.GATE != null) {
				fenceGateBlock(Objects.requireNonNull(deco.block.GATE).get(), texture);
				itemModels().fenceGate(deco.block.GATE.getId().getPath(), texture);
			}
		}
	}

	public void baseBlockWithItem(RegistryObject<? extends Block> registryObject) {
		simpleBlock(registryObject.get());
		itemBlock(registryObject);
	}

	public void axisBlockWithItem(RegistryObject<? extends RotatedPillarBlock> registryObject) {
		axisBlock(registryObject.get());
		itemBlock(registryObject);
	}

	public void paneBlock(RegistryObject<? extends IronBarsBlock> registryObject, RegistryObject<? extends GlassBlock> glassBlock) {
		paneBlock(registryObject.get(), new ResourceLocation(glassBlock.getId().getNamespace(), "block/" + glassBlock.getId().getPath()), new ResourceLocation(glassBlock.getId().getNamespace(), "block/" + glassBlock.getId().getPath() + "_pane"));
	}

	public void doorBlock(RegistryObject<? extends DoorBlock> registryObject) {
		doorBlock(registryObject.getId().getPath(), registryObject.get(), new ResourceLocation(IcariaInfo.MODID + ":block/" + registryObject.getId().getPath() + "_bottom"), new ResourceLocation(IcariaInfo.MODID + ":block/" + registryObject.getId().getPath() + "_top"));
	}

	public void doorBlock(String typeLocation, Block door, ResourceLocation bottom, ResourceLocation top) {
		BlockModelBuilder bottomLeft = doorBlock(typeLocation + "_bottom_left", "bottom_left", bottom, top);
		BlockModelBuilder bottomLeftOpen = doorBlock(typeLocation + "_bottom_left_open", "bottom_left_open", bottom, top);
		BlockModelBuilder bottomRight = doorBlock(typeLocation + "_bottom_right", "bottom_right", bottom, top);
		BlockModelBuilder bottomRightOpen = doorBlock(typeLocation + "_bottom_right_open", "bottom_right_open", bottom, top);

		BlockModelBuilder topLeft = doorBlock(typeLocation + "_top_left", "top_left", bottom, top);
		BlockModelBuilder topLeftOpen = doorBlock(typeLocation + "_top_left_open", "top_left_open", bottom, top);
		BlockModelBuilder topRight = doorBlock(typeLocation + "_top_right", "top_right", bottom, top);
		BlockModelBuilder topRightOpen = doorBlock(typeLocation + "_top_right_open", "top_right_open", bottom, top);

		getVariantBuilder(door).forAllStatesExcept(state -> {
			int yRot = ((int) state.getValue(DoorBlock.FACING).toYRot()) + 90;
			boolean rh = state.getValue(DoorBlock.HINGE) == DoorHingeSide.RIGHT;
			boolean open = state.getValue(DoorBlock.OPEN);
			boolean right = rh ^ open;
			if (open) {
				yRot += 90;
			}

			if (rh && open) {
				yRot += 180;
			}

			yRot %= 360;
			BlockModelBuilder bottomModel = open ? (right ? bottomRightOpen : bottomLeftOpen) : (right ? bottomRight : bottomLeft);
			BlockModelBuilder topModel = open ? (right ? topRightOpen : topLeftOpen) : (right ? topRight : topLeft);
			return ConfiguredModel.builder().modelFile(state.getValue(DoorBlock.HALF) == DoubleBlockHalf.LOWER ? bottomModel : topModel).rotationY(yRot).build();
		}, DoorBlock.POWERED);
	}

	public void trapDoorWithItem(RegistryObject<? extends TrapDoorBlock> registryObject) {
		trapdoorBlock(registryObject.get(), new ResourceLocation(IcariaInfo.MODID + ":block/" + registryObject.getId().getPath()), true);
		itemBlockTrapDoor(registryObject);
	}

	public void itemBlock(RegistryObject<? extends Block> registryObject) {
		itemModels().withExistingParent(registryObject.getId().getPath(), registryObject.getId().getNamespace() + ":block/" + registryObject.getId().getPath());
	}

	public void itemBlockTrapDoor(RegistryObject<? extends Block> registryObject) {
		itemModels().withExistingParent(registryObject.getId().getPath(), registryObject.getId().getNamespace() + ":block/" + registryObject.getId().getPath() + "_bottom");
	}

	public void mirroredBlockWithItem(RegistryObject<? extends Block> registryObject) {
		ModelFile normal = cubeAll(registryObject.get());
		ModelFile mirrored = models().singleTexture(Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(registryObject.get())).getPath() + "_mirrored", new ResourceLocation(ModelProvider.BLOCK_FOLDER + "/cube_mirrored_all"), "all", blockTexture(registryObject.get()));
		getVariantBuilder(registryObject.get()).partialState().setModels(new ConfiguredModel(normal), new ConfiguredModel(normal, 0, 180, false), new ConfiguredModel(mirrored), new ConfiguredModel(mirrored, 0, 180, false));
		itemBlock(registryObject);
	}

	public void rotatedBlockWithItem(RegistryObject<? extends Block> registryObject) {
		getVariantBuilder(registryObject.get()).partialState().setModels(ConfiguredModel.allRotations(cubeAll(registryObject.get()), false));
		itemBlock(registryObject);
	}

	public BlockModelBuilder doorBlock(String name, String type, ResourceLocation bottom, ResourceLocation top) {
		return models().withExistingParent(name, "block/door_" + type).texture("bottom", bottom).texture("top", top);
	}
}

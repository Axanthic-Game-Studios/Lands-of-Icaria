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
	public static final List<RegistryObject<? extends Block>> MIRRORED = new ArrayList<>();
	public static final List<RegistryObject<? extends Block>> ROTATED = new ArrayList<>();

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

		this.baseBlockWithItem(IcariaBlocks.MARL_CHERT);
		this.baseBlockWithItem(IcariaBlocks.MARL_ROTTEN_BONES);
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
		this.baseBlockWithItem(IcariaBlocks.OLIVE_LEAVES);
		this.baseBlockWithItem(IcariaBlocks.OLIVE_LEAVES_BLACK);
		this.baseBlockWithItem(IcariaBlocks.OLIVE_LEAVES_GREEN);
		this.baseBlockWithItem(IcariaBlocks.PLANE_LEAVES);
		this.baseBlockWithItem(IcariaBlocks.POPULUS_LEAVES);

		this.mirroredBlockWithItem(IcariaBlocks.LOAM);
		this.mirroredBlockWithItem(IcariaBlocks.RELICSTONE_SMOOTH);

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

		for (RegistryObject<? extends Block> registryObject : IcariaBlocks.BASIC_BLOCKS) {
			if (MIRRORED.contains(registryObject)) {
				this.mirroredBlockWithItem(registryObject);
			} else if (ROTATED.contains(registryObject)) {
				this.rotatedBlockWithItem(registryObject);
			} else {
				this.baseBlockWithItem(registryObject);
			}
		}

		for (IcariaItems.StoneDecoItemBlocks deco : IcariaItems.STONE_BLOCKS) {
			ResourceLocation texture = this.blockTexture(deco.block.original.get());
			if (deco.slab != null) {
				this.slabBlock(Objects.requireNonNull(deco.block.slab).get(), deco.block.original.getId(), texture);
				this.itemModels().slab(deco.block.slab.getId().getPath(), texture, texture, texture);
			}
			if (deco.stairs != null) {
				this.stairsBlock(Objects.requireNonNull(deco.block.stairs).get(), texture);
				this.itemModels().stairs(deco.block.stairs.getId().getPath(), texture, texture, texture);
			}
			if (deco.wall != null) {
				this.wallBlock(Objects.requireNonNull(deco.block.wall).get(), texture);
				this.itemModels().wallInventory(deco.block.wall.getId().getPath(), texture);
			}
		}

		for (IcariaItems.WoodDecoItemBlocks deco : IcariaItems.WOOD_BLOCKS) {
			ResourceLocation texture = this.blockTexture(deco.block.original.get());
			if (deco.slab != null) {
				this.slabBlock(Objects.requireNonNull(deco.block.slab).get(), deco.block.original.getId(), texture);
				this.itemModels().slab(deco.block.slab.getId().getPath(), texture, texture, texture);
			}
			if (deco.stairs != null) {
				this.stairsBlock(Objects.requireNonNull(deco.block.stairs).get(), texture);
				this.itemModels().stairs(deco.block.stairs.getId().getPath(), texture, texture, texture);
			}
			if (deco.fence != null) {
				this.fenceBlock(Objects.requireNonNull(deco.block.fence).get(), texture);
				this.itemModels().fenceInventory(deco.block.fence.getId().getPath(), texture);
			}
			if (deco.gate != null) {
				this.fenceGateBlock(Objects.requireNonNull(deco.block.gate).get(), texture);
				this.itemModels().fenceGate(deco.block.gate.getId().getPath(), texture);
			}
		}
	}

	public void baseBlockWithItem(RegistryObject<? extends Block> registryObject) {
		this.simpleBlock(registryObject.get());
		this.itemBlock(registryObject);
	}

	public void axisBlockWithItem(RegistryObject<? extends RotatedPillarBlock> registryObject) {
		this.axisBlock(registryObject.get());
		this.itemBlock(registryObject);
	}

	public void paneBlock(RegistryObject<? extends IronBarsBlock> registryObject, RegistryObject<? extends GlassBlock> glassBlock) {
		this.paneBlock(registryObject.get(), new ResourceLocation(glassBlock.getId().getNamespace(), "block/" + glassBlock.getId().getPath()), new ResourceLocation(glassBlock.getId().getNamespace(), "block/" + glassBlock.getId().getPath() + "_pane"));
	}

	public void doorBlock(RegistryObject<? extends DoorBlock> registryObject) {
		this.doorBlock(registryObject.getId().getPath(), registryObject.get(), new ResourceLocation(IcariaInfo.MODID + ":block/" + registryObject.getId().getPath() + "_bottom"), new ResourceLocation(IcariaInfo.MODID + ":block/" + registryObject.getId().getPath() + "_top"));
	}

	public void doorBlock(String typeLocation, Block door, ResourceLocation bottom, ResourceLocation top) {
		BlockModelBuilder bottomLeft = this.doorBlock(typeLocation + "_bottom_left", "bottom_left", bottom, top);
		BlockModelBuilder bottomLeftOpen = this.doorBlock(typeLocation + "_bottom_left_open", "bottom_left_open", bottom, top);
		BlockModelBuilder bottomRight = this.doorBlock(typeLocation + "_bottom_right", "bottom_right", bottom, top);
		BlockModelBuilder bottomRightOpen = this.doorBlock(typeLocation + "_bottom_right_open", "bottom_right_open", bottom, top);

		BlockModelBuilder topLeft = this.doorBlock(typeLocation + "_top_left", "top_left", bottom, top);
		BlockModelBuilder topLeftOpen = this.doorBlock(typeLocation + "_top_left_open", "top_left_open", bottom, top);
		BlockModelBuilder topRight = this.doorBlock(typeLocation + "_top_right", "top_right", bottom, top);
		BlockModelBuilder topRightOpen = this.doorBlock(typeLocation + "_top_right_open", "top_right_open", bottom, top);

		this.getVariantBuilder(door).forAllStatesExcept(state -> {
			int yRot = ((int) state.getValue(DoorBlock.FACING).toYRot()) + 90;

			boolean open = state.getValue(DoorBlock.OPEN);
			boolean rh = state.getValue(DoorBlock.HINGE) == DoorHingeSide.RIGHT;
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
		this.trapdoorBlock(registryObject.get(), new ResourceLocation(IcariaInfo.MODID + ":block/" + registryObject.getId().getPath()), true);
		this.itemBlockTrapDoor(registryObject);
	}

	public void itemBlock(RegistryObject<? extends Block> registryObject) {
		this.itemModels().withExistingParent(registryObject.getId().getPath(), registryObject.getId().getNamespace() + ":block/" + registryObject.getId().getPath());
	}

	public void itemBlockTrapDoor(RegistryObject<? extends Block> registryObject) {
		this.itemModels().withExistingParent(registryObject.getId().getPath(), registryObject.getId().getNamespace() + ":block/" + registryObject.getId().getPath() + "_bottom");
	}

	public void mirroredBlockWithItem(RegistryObject<? extends Block> registryObject) {
		ModelFile normal = this.cubeAll(registryObject.get());
		ModelFile mirrored = this.models().singleTexture(Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(registryObject.get())).getPath() + "_mirrored", new ResourceLocation(ModelProvider.BLOCK_FOLDER + "/cube_mirrored_all"), "all", this.blockTexture(registryObject.get()));

		this.getVariantBuilder(registryObject.get()).partialState().setModels(new ConfiguredModel(normal), new ConfiguredModel(normal, 0, 180, false), new ConfiguredModel(mirrored), new ConfiguredModel(mirrored, 0, 180, false));
		this.itemBlock(registryObject);
	}

	public void rotatedBlockWithItem(RegistryObject<? extends Block> registryObject) {
		this.getVariantBuilder(registryObject.get()).partialState().setModels(ConfiguredModel.allRotations(cubeAll(registryObject.get()), false));
		this.itemBlock(registryObject);
	}

	public BlockModelBuilder doorBlock(String name, String type, ResourceLocation bottom, ResourceLocation top) {
		return this.models().withExistingParent(name, "block/door_" + type).texture("bottom", bottom).texture("top", top);
	}
}

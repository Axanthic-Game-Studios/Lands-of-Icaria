package com.axanthic.icaria.datagen;

import com.axanthic.icaria.util.IcariaInfo;
import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.registry.IcariaItems.StoneDecoItemBlocks;
import com.axanthic.icaria.common.registry.IcariaItems.WoodDecoItemBlocks;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class IcariaBlockStates extends BlockStateProvider {
	public static final List<RegistryObject<? extends Block>> ROTATED = new ArrayList<>();
	public static final List<RegistryObject<? extends Block>> MIRRORED = new ArrayList<>();

	public IcariaBlockStates(DataGenerator gen, ExistingFileHelper exFileHelper) {
		super(gen, IcariaInfo.MODID, exFileHelper);
	}

	@Override
	protected void registerStatesAndModels() {
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

		MIRRORED.add(IcariaBlocks.ARACHNE_STRING_BLOCK);

		//blockWithItem(IcariaBlocks.MARL_GRASS);
		blockWithItem(IcariaBlocks.MARL_CHERT);
		blockWithItem(IcariaBlocks.MARL_ROTTEN_BONES);
		blockWithItem(IcariaBlocks.MARL_LIGNITE);
		//blockWithItem(IcariaBlocks.FARMLAND);
		//blockWithItem(IcariaBlocks.FARMLAND_FERTILIZED);
		mirroredBlockWithItem(IcariaBlocks.LOAM);
		axisBlock(IcariaBlocks.DOLOMITE_PILLAR.get());
		blockItem(IcariaBlocks.DOLOMITE_PILLAR);
		//blockWithItem(IcariaBlocks.DOLOMITE_PILLAR_HEAD);
		blockWithItem(IcariaBlocks.GRAINEL_CHERT);
		blockWithItem(IcariaBlocks.GRAINGLASS);
		paneBlock(IcariaBlocks.GRAINGLASS_PANE.get(), new ResourceLocation(IcariaBlocks.GRAINGLASS.getId().getNamespace(), "block/" + IcariaBlocks.GRAINGLASS.getId().getPath()), new ResourceLocation(IcariaBlocks.GRAINGLASS.getId().getNamespace(), "block/" + IcariaBlocks.GRAINGLASS.getId().getPath() + "_pane"));
		//blockWithItem(IcariaBlocks.GRAINGLASS_PANE_HORIZONTAL);
		blockWithItem(IcariaBlocks.YELLOWSTONE);
		blockWithItem(IcariaBlocks.SILKGLASS);
		paneBlock(IcariaBlocks.SILKGLASS_PANE.get(), new ResourceLocation(IcariaBlocks.SILKGLASS.getId().getNamespace(), "block/" + IcariaBlocks.SILKGLASS.getId().getPath()), new ResourceLocation(IcariaBlocks.SILKGLASS.getId().getNamespace(), "block/" + IcariaBlocks.SILKGLASS.getId().getPath() + "_pane"));
		//blockWithItem(IcariaBlocks.SILKGLASS_PANE_HORIZONTAL);
		blockWithItem(IcariaBlocks.SILKSTONE);
		blockWithItem(IcariaBlocks.SUNSTONE);
		blockWithItem(IcariaBlocks.VOIDSHALE);
		blockWithItem(IcariaBlocks.BAETYL);
		mirroredBlockWithItem(IcariaBlocks.RELICSTONE_SMOOTH);
		axisBlock(IcariaBlocks.RELICSTONE_PILLAR.get());
		blockItem(IcariaBlocks.RELICSTONE_PILLAR);
		//blockWithItem(IcariaBlocks.RELICSTONE_PILLAR_HEAD);
		blockWithItem(IcariaBlocks.LIGNITE_ORE);
		blockWithItem(IcariaBlocks.CHALKOS_ORE);
		blockWithItem(IcariaBlocks.KASSITEROS_ORE);
		blockWithItem(IcariaBlocks.DOLOMITE_ORE);
		blockWithItem(IcariaBlocks.VANADIUM_ORE);
		blockWithItem(IcariaBlocks.SLIVER_ORE);
		blockWithItem(IcariaBlocks.SIDEROS_ORE);
		blockWithItem(IcariaBlocks.ANTHRACITE_ORE);
		blockWithItem(IcariaBlocks.MOLYBDENUM_ORE);
		blockWithItem(IcariaBlocks.HYLIASTRUM_ORE);
		//blockWithItem(IcariaBlocks.QUARTZ_PILLAR_HEAD);
		axisBlock(IcariaBlocks.SPELT_BALE_BLOCK.get());
		blockItem(IcariaBlocks.SPELT_BALE_BLOCK);
		blockWithItem(IcariaBlocks.CYPRESS_LEAVES);
		axisBlock(IcariaBlocks.CYPRESS_WOOD.get());
		blockItem(IcariaBlocks.CYPRESS_WOOD);
		axisBlock(IcariaBlocks.STRIPPED_CYPRESS_WOOD.get());
		blockItem(IcariaBlocks.STRIPPED_CYPRESS_WOOD);
		axisBlock(IcariaBlocks.CYPRESS_LOG.get());
		blockItem(IcariaBlocks.CYPRESS_LOG);
		axisBlock(IcariaBlocks.STRIPPED_CYPRESS_LOG.get());
		blockItem(IcariaBlocks.STRIPPED_CYPRESS_LOG);
		blockWithItem(IcariaBlocks.DROUGHTROOT_LEAVES);
		axisBlock(IcariaBlocks.DROUGHTROOT_WOOD.get());
		blockItem(IcariaBlocks.DROUGHTROOT_WOOD);
		axisBlock(IcariaBlocks.STRIPPED_DROUGHTROOT_WOOD.get());
		blockItem(IcariaBlocks.STRIPPED_DROUGHTROOT_WOOD);
		axisBlock(IcariaBlocks.DROUGHTROOT_LOG.get());
		blockItem(IcariaBlocks.DROUGHTROOT_LOG);
		axisBlock(IcariaBlocks.STRIPPED_DROUGHTROOT_LOG.get());
		blockItem(IcariaBlocks.STRIPPED_DROUGHTROOT_LOG);
		blockWithItem(IcariaBlocks.FIR_LEAVES);
		axisBlock(IcariaBlocks.FIR_WOOD.get());
		blockItem(IcariaBlocks.FIR_WOOD);
		axisBlock(IcariaBlocks.STRIPPED_FIR_WOOD.get());
		blockItem(IcariaBlocks.STRIPPED_FIR_WOOD);
		axisBlock(IcariaBlocks.FIR_LOG.get());
		blockItem(IcariaBlocks.FIR_LOG);
		axisBlock(IcariaBlocks.STRIPPED_FIR_LOG.get());
		blockItem(IcariaBlocks.STRIPPED_FIR_LOG);
		blockWithItem(IcariaBlocks.LAUREL_LEAVES);
		axisBlock(IcariaBlocks.LAUREL_WOOD.get());
		blockItem(IcariaBlocks.LAUREL_WOOD);
		axisBlock(IcariaBlocks.STRIPPED_LAUREL_WOOD.get());
		blockItem(IcariaBlocks.STRIPPED_LAUREL_WOOD);
		axisBlock(IcariaBlocks.LAUREL_LOG.get());
		blockItem(IcariaBlocks.LAUREL_LOG);
		axisBlock(IcariaBlocks.STRIPPED_LAUREL_LOG.get());
		blockItem(IcariaBlocks.STRIPPED_LAUREL_LOG);
		blockWithItem(IcariaBlocks.OLIVE_LEAVES);
		blockWithItem(IcariaBlocks.OLIVE_LEAVES_BLACK);
		blockWithItem(IcariaBlocks.OLIVE_LEAVES_GREEN);
		axisBlock(IcariaBlocks.OLIVE_WOOD.get());
		blockItem(IcariaBlocks.OLIVE_WOOD);
		axisBlock(IcariaBlocks.STRIPPED_OLIVE_WOOD.get());
		blockItem(IcariaBlocks.STRIPPED_OLIVE_WOOD);
		axisBlock(IcariaBlocks.OLIVE_LOG.get());
		blockItem(IcariaBlocks.OLIVE_LOG);
		axisBlock(IcariaBlocks.STRIPPED_OLIVE_LOG.get());
		blockItem(IcariaBlocks.STRIPPED_OLIVE_LOG);
		blockWithItem(IcariaBlocks.PLANE_LEAVES);
		axisBlock(IcariaBlocks.PLANE_WOOD.get());
		blockItem(IcariaBlocks.PLANE_WOOD);
		axisBlock(IcariaBlocks.STRIPPED_PLANE_WOOD.get());
		blockItem(IcariaBlocks.STRIPPED_PLANE_WOOD);
		axisBlock(IcariaBlocks.PLANE_LOG.get());
		blockItem(IcariaBlocks.PLANE_LOG);
		axisBlock(IcariaBlocks.STRIPPED_PLANE_LOG.get());
		blockItem(IcariaBlocks.STRIPPED_PLANE_LOG);
		blockWithItem(IcariaBlocks.POPULUS_LEAVES);
		axisBlock(IcariaBlocks.POPULUS_WOOD.get());
		blockItem(IcariaBlocks.POPULUS_WOOD);
		axisBlock(IcariaBlocks.STRIPPED_POPULUS_WOOD.get());
		blockItem(IcariaBlocks.STRIPPED_POPULUS_WOOD);
		axisBlock(IcariaBlocks.POPULUS_LOG.get());
		blockItem(IcariaBlocks.POPULUS_LOG);
		axisBlock(IcariaBlocks.STRIPPED_POPULUS_LOG.get());
		blockItem(IcariaBlocks.STRIPPED_POPULUS_LOG);
		//blockWithItem(IcariaBlocks.MOSS_0);
		//blockWithItem(IcariaBlocks.MOSS_1);
		//blockWithItem(IcariaBlocks.MOSS_2);

		for (RegistryObject<? extends Block> basicBlock : IcariaBlocks.BASIC_BLOCKS) {
			if (ROTATED.contains(basicBlock)) {
				rotatedBlockWithItem(basicBlock);
			} else if (MIRRORED.contains(basicBlock)) {
				mirroredBlockWithItem(basicBlock);
			} else {
				blockWithItem(basicBlock);
			}
		}

		for (StoneDecoItemBlocks deco : IcariaItems.STONE_BLOCKS) {
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

		for (WoodDecoItemBlocks deco : IcariaItems.WOOD_BLOCKS) {
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

	public void blockWithItem(RegistryObject<? extends Block> registryObject) {
		//block model
		simpleBlock(registryObject.get());

		//itemblock model
		blockItem(registryObject);
	}

	public void rotatedBlockWithItem(RegistryObject<? extends Block> registryObject) {
		//block model
		getVariantBuilder(registryObject.get()).partialState().setModels(ConfiguredModel.allRotations(cubeAll(registryObject.get()), false));

		//itemblock model
		blockItem(registryObject);
	}

	public void rotatedYBlockWithItem(RegistryObject<? extends Block> registryObject) {
		//block model
		getVariantBuilder(registryObject.get()).partialState().setModels(ConfiguredModel.allYRotations(cubeAll(registryObject.get()), 0, false));

		//itemblock model
		blockItem(registryObject);
	}

	public void mirroredBlockWithItem(RegistryObject<? extends Block> registryObject) {
		//block model
		ModelFile normal = cubeAll(registryObject.get());
		ModelFile mirrored = models().singleTexture(Objects.requireNonNull(registryObject.get().getRegistryName()).getPath() + "_mirrored", new ResourceLocation(ModelProvider.BLOCK_FOLDER + "/cube_mirrored_all"), "all", blockTexture(registryObject.get()));
		getVariantBuilder(registryObject.get()).partialState().setModels(new ConfiguredModel(normal), new ConfiguredModel(normal, 0, 180, false), new ConfiguredModel(mirrored), new ConfiguredModel(mirrored, 0, 180, false));

		//itemblock model
		blockItem(registryObject);
	}

	public void blockItem(RegistryObject<? extends Block> registryObject) {
		itemModels().withExistingParent(registryObject.getId().getPath(), registryObject.getId().getNamespace() + ":block/" + registryObject.getId().getPath());
	}

	public void fluid(RegistryObject<? extends Block> fluid) {
		ResourceLocation name = fluid.get().getRegistryName();
		simpleBlock(fluid.get(), models().cubeAll(Objects.requireNonNull(name).getPath(), new ResourceLocation(name.getNamespace(), ModelProvider.BLOCK_FOLDER + "/fluid/" + name.getPath().replace("block", "still"))));
	}
}

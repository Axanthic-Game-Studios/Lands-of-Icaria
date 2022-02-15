package com.axanthic.icaria.datagen;

import java.util.ArrayList;
import java.util.List;

import com.axanthic.icaria.IcariaInfo;
import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.registry.IcariaItems.DecoItemBlockCombination;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class IcariaBlockStates extends BlockStateProvider {

	public static final List<RegistryObject<? extends Block>> ROTATED = new ArrayList<RegistryObject<? extends Block>>();
	public static final List<RegistryObject<? extends Block>> MIRRORED = new ArrayList<RegistryObject<? extends Block>>();

	public IcariaBlockStates(DataGenerator gen, ExistingFileHelper exFileHelper) {
		super(gen, IcariaInfo.MODID, exFileHelper);
	}

	@Override
	protected void registerStatesAndModels() {
		ROTATED.add(IcariaBlocks.MARL);
		ROTATED.add(IcariaBlocks.MARL_COARSE);
		ROTATED.add(IcariaBlocks.GRAINEL);
		ROTATED.add(IcariaBlocks.SILKSAND);
		ROTATED.add(IcariaBlocks.JELLYFISH_JELLY_BLOCK);

		ROTATED.add(IcariaBlocks.MARL_ADOBE);
		ROTATED.add(IcariaBlocks.DOLOMITE_ADOBE);
		ROTATED.add(IcariaBlocks.GRAINITE_ADOBE);
		ROTATED.add(IcariaBlocks.YELLOWSTONE_ADOBE);
		ROTATED.add(IcariaBlocks.SILKSTONE_ADOBE);
		ROTATED.add(IcariaBlocks.SUNSTONE_ADOBE);
		ROTATED.add(IcariaBlocks.VOIDSHALE);
		ROTATED.add(IcariaBlocks.BAETYL);

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
		//blockWithItem(IcariaBlocks.RELICSTONE_PILLAR_HEAD);
		//blockWithItem(IcariaBlocks.QUARTZ_PILLAR_HEAD);
		axisBlock(IcariaBlocks.SPELT_BALE_BLOCK.get());
		blockItem(IcariaBlocks.SPELT_BALE_BLOCK);
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

		for (DecoItemBlockCombination deco : IcariaItems.DECO_BLOCKS) {
			ResourceLocation texture = blockTexture(deco.block.original.get());
			if (deco.SLAB != null) {
				slabBlock(deco.block.SLAB.get(), deco.block.original.getId(), texture);
				itemModels().slab(deco.block.SLAB.getId().getPath(), texture, texture, texture);
			}
			if (deco.STAIRS != null) {
				stairsBlock(deco.block.STAIRS.get(), texture);
				itemModels().stairs(deco.block.STAIRS.getId().getPath(), texture, texture, texture);
			}
			if (deco.WALL != null) {
				wallBlock(deco.block.WALL.get(), texture);
				itemModels().wallInventory(deco.block.WALL.getId().getPath(), texture);
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
		ModelFile mirrored = models().singleTexture(registryObject.get().getRegistryName().getPath() + "_mirrored", new ResourceLocation(ModelProvider.BLOCK_FOLDER + "/cube_mirrored_all"), "all", blockTexture(registryObject.get()));
		getVariantBuilder(registryObject.get()).partialState().setModels(new ConfiguredModel(normal), new ConfiguredModel(normal, 0, 180, false), new ConfiguredModel(mirrored), new ConfiguredModel(mirrored, 0, 180, false));

		//itemblock model
		blockItem(registryObject);
	}

	public void blockItem(RegistryObject<? extends Block> registryObject) {
		itemModels().withExistingParent(registryObject.getId().getPath(), registryObject.getId().getNamespace() + ":block/" + registryObject.getId().getPath());
	}

	public void fluid(RegistryObject<? extends Block> fluid) {
		ResourceLocation name = fluid.get().getRegistryName();
		simpleBlock(fluid.get(), models().cubeAll(name.getPath(), new ResourceLocation(name.getNamespace(), ModelProvider.BLOCK_FOLDER + "/fluid/" + name.getPath().replace("block", "still"))));
	}
}

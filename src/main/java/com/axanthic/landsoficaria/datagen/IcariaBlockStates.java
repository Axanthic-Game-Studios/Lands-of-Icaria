package com.axanthic.landsoficaria.datagen;

import com.axanthic.landsoficaria.LandsOfIcariaInfo;
import com.axanthic.landsoficaria.common.registry.LandsOfIcariaBlocks;
import com.axanthic.landsoficaria.common.registry.LandsOfIcariaItems;
import com.axanthic.landsoficaria.common.registry.LandsOfIcariaItems.DecoItemBlockCombination;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class IcariaBlockStates extends BlockStateProvider {

	public IcariaBlockStates(DataGenerator gen, ExistingFileHelper exFileHelper) {
		super(gen, LandsOfIcariaInfo.MODID, exFileHelper);
	}

	@Override
	protected void registerStatesAndModels() {
		for (RegistryObject<? extends Block> basicBlock : LandsOfIcariaBlocks.BASIC_BLOCKS) {
			blockWithItem(basicBlock);
		}
		for (DecoItemBlockCombination deco : LandsOfIcariaItems.DECO_BLOCKS) {
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
		itemModels().cubeAll(registryObject.getId().getPath(), blockTexture(registryObject.get()));
	}

	public void fluid(RegistryObject<? extends Block> fluid) {
		ResourceLocation name = fluid.get().getRegistryName();
		simpleBlock(fluid.get(), models().cubeAll(name.getPath(), new ResourceLocation(name.getNamespace(), ModelProvider.BLOCK_FOLDER + "/fluid/" + name.getPath().replace("block", "still"))));
	}
}

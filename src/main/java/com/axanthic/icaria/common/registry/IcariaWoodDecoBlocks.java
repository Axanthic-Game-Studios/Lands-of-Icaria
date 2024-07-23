package com.axanthic.icaria.common.registry;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.WoodType;

import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaWoodDecoBlocks {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, IcariaIdents.ID);

	public String name;

	public Supplier<Block> block;
	public Supplier<StairBlock> stairs;
	public Supplier<SlabBlock> slab;
	public Supplier<FenceBlock> fence;
	public Supplier<FenceGateBlock> gate;

	public IcariaWoodDecoBlocks(String pName, Supplier<Block> pBlock, WoodType pType, BlockBehaviour.Properties pProperties, boolean pStairs, boolean pSlab, boolean pFence, boolean pGate) {
		this.name = pName;
		this.block = pBlock;
		this.stairs = IcariaWoodDecoBlocks.BLOCKS.register(pName + "_stairs", () -> new StairBlock(pBlock.get().defaultBlockState(), pProperties));
		this.slab = IcariaWoodDecoBlocks.BLOCKS.register(pName + "_slab", () -> new SlabBlock(pProperties));
		this.fence = IcariaWoodDecoBlocks.BLOCKS.register(pName + "_fence", () -> new FenceBlock(pProperties));
		this.gate = IcariaWoodDecoBlocks.BLOCKS.register(pName + "_fence_gate", () -> new FenceGateBlock(pType, pProperties));
	}

	public IcariaWoodDecoBlocks(String pName, Supplier<Block> pBlock, WoodType pType, BlockBehaviour.Properties pProperties) {
		this(pName, pBlock, pType, pProperties, true, true, true, true);
	}
}

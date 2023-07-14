package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings("unused")

public class IcariaWoodDecoBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, IcariaInfo.ID);

    public String name;

    public RegistryObject<Block> block;
    public RegistryObject<StairBlock> stairs;
    public RegistryObject<SlabBlock> slab;
    public RegistryObject<FenceBlock> fence;
    public RegistryObject<FenceGateBlock> gate;

    public IcariaWoodDecoBlocks(String pName, RegistryObject<Block> pBlock, BlockBehaviour.Properties pProperties, boolean pStairs, boolean pSlab, boolean pFence, boolean pGate) {
        this.name = pName;
        this.block = pBlock;
        this.stairs = IcariaWoodDecoBlocks.BLOCKS.register(pName + "_stairs", () -> new StairBlock(() -> pBlock.get().defaultBlockState(), pProperties));
        this.slab = IcariaWoodDecoBlocks.BLOCKS.register(pName + "_slab", () -> new SlabBlock(pProperties));
        this.fence = IcariaWoodDecoBlocks.BLOCKS.register(pName + "_fence", () -> new FenceBlock(pProperties));
        this.gate = IcariaWoodDecoBlocks.BLOCKS.register(pName + "_fence_gate", () -> new FenceGateBlock(pProperties, SoundEvents.FENCE_GATE_CLOSE, SoundEvents.FENCE_GATE_OPEN));
    }

    public IcariaWoodDecoBlocks(String pName, RegistryObject<Block> pBlock, BlockBehaviour.Properties pProperties) {
        this(pName, pBlock, pProperties, true, true, true, true);
    }
}

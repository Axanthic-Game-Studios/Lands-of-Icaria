package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings("unused")

public class IcariaStoneDecoBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, IcariaInfo.ID);

    public String name;

    public RegistryObject<Block> block;
    public RegistryObject<StairBlock> stairs;
    public RegistryObject<SlabBlock> slab;
    public RegistryObject<WallBlock> wall;

    public IcariaStoneDecoBlocks(String pName, RegistryObject<Block> pBlock, BlockBehaviour.Properties pProperties, boolean pStairs, boolean pSlab, boolean pWall) {
        this.name = pName;
        this.block = pBlock;
        this.stairs = IcariaStoneDecoBlocks.BLOCKS.register(pName + "_stairs", () -> new StairBlock(() -> pBlock.get().defaultBlockState(), pProperties));
        this.slab = IcariaStoneDecoBlocks.BLOCKS.register(pName + "_slab", () -> new SlabBlock(pProperties));
        this.wall = IcariaStoneDecoBlocks.BLOCKS.register(pName + "_wall", () -> new WallBlock(pProperties));
    }

    public IcariaStoneDecoBlocks(String pName, RegistryObject<Block> pBlock, BlockBehaviour.Properties pProperties) {
        this(pName, pBlock, pProperties, true, true, true);
    }
}

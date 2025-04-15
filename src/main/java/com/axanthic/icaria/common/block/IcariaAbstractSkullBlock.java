package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.entity.IcariaSkullBlockEntity;
import com.axanthic.icaria.common.util.IcariaSkullBlockType;

import com.mojang.serialization.MapCodec;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaAbstractSkullBlock extends BaseEntityBlock {
	public float offset;

	public IcariaSkullBlockType type;

	public static final MapCodec<IcariaAbstractSkullBlock> CODEC = Block.simpleCodec(IcariaAbstractSkullBlock::new);

	public IcariaAbstractSkullBlock(Properties pProperties) {
		super(pProperties);
	}

	public IcariaAbstractSkullBlock(float pOffset, IcariaSkullBlockType pType, Properties pProperties) {
		this(pProperties);
		this.offset = pOffset;
		this.type = pType;
	}

	@Override
	public boolean isPathfindable(BlockState pBlockState, PathComputationType pPathComputationType) {
		return false;
	}

	public float getOffset() {
		return this.offset;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pBlockPos, BlockState pBlockState) {
		return new IcariaSkullBlockEntity(pBlockPos, pBlockState);
	}

	public IcariaSkullBlockType getType() {
		return this.type;
	}

	@Override
	public MapCodec<? extends BaseEntityBlock> codec() {
		return IcariaAbstractSkullBlock.CODEC;
	}
}

package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.entity.IcariaSkullBlockEntity;
import com.axanthic.icaria.common.util.IcariaSkullBlockType;

import com.mojang.serialization.MapCodec;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Equipable;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaAbstractSkullBlock extends BaseEntityBlock implements Equipable {
	public float offset;

	public IcariaSkullBlockType type;

	public static final MapCodec<IcariaAbstractSkullBlock> CODEC = Block.simpleCodec(IcariaAbstractSkullBlock::new);

	public IcariaAbstractSkullBlock(Properties pProperties) {
		super(pProperties);
	}

	public IcariaAbstractSkullBlock(float pOffset, IcariaSkullBlockType pType, Properties pProperties) {
		this(pProperties);
		this.type = pType;
		this.offset = pOffset;
	}

	@Override
	public boolean isPathfindable(BlockState pState, PathComputationType pType) {
		return false;
	}

	public float getOffset() {
		return this.offset;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
		return new IcariaSkullBlockEntity(pPos, pState);
	}

	@Override
	public EquipmentSlot getEquipmentSlot() {
		return EquipmentSlot.HEAD;
	}

	public IcariaSkullBlockType getType() {
		return this.type;
	}

	@Override
	public MapCodec<? extends BaseEntityBlock> codec() {
		return IcariaAbstractSkullBlock.CODEC;
	}
}

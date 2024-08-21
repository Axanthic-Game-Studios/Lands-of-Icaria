package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.registry.IcariaIdents;

import com.mojang.serialization.MapCodec;

import net.minecraft.ChatFormatting;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault

public class PillarHeadBlock extends DirectionalBlock {
	public static final MapCodec<PillarHeadBlock> CODEC = Block.simpleCodec(PillarHeadBlock::new);

	public PillarHeadBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.FACING, Direction.NORTH));
	}

	@Override
	public void appendHoverText(ItemStack pStack, Item.TooltipContext pContext, List<Component> pList, TooltipFlag pFlag) {
		pList.add(Component.translatable("tooltip" + "." + IcariaIdents.ID + "." + "pillar_head" + "." + "title").withStyle(ChatFormatting.GRAY));
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(BlockStateProperties.FACING);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pContext) {
		if (pContext.getPlayer() != null) {
			if (pContext.getPlayer().isShiftKeyDown()) {
				return this.defaultBlockState().setValue(BlockStateProperties.FACING, pContext.getNearestLookingDirection().getOpposite());
			}
		}

		return this.defaultBlockState().setValue(BlockStateProperties.FACING, pContext.getNearestLookingDirection());
	}

	@Override
	public BlockState mirror(BlockState pState, Mirror pMirror) {
		return pState.setValue(BlockStateProperties.FACING, pMirror.mirror(pState.getValue(BlockStateProperties.FACING)));
	}

	@Override
	public BlockState rotate(BlockState pState, Rotation pRotation) {
		return pState.setValue(BlockStateProperties.FACING, pRotation.rotate(pState.getValue(BlockStateProperties.FACING)));
	}

	@Override
	public MapCodec<? extends DirectionalBlock> codec() {
		return PillarHeadBlock.CODEC;
	}
}

package com.axanthic.icaria.common.blocks;

import com.axanthic.icaria.common.registry.LandsOfIcariaBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.IPlantable;

public class MarlCoarseBlock extends Block {
	public MarlCoarseBlock(Properties properties) {
		super(properties);
	}

	@Override
	public boolean canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction facing, IPlantable plantable) {
		return false; //TODO
	}

	@Override
	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
		ItemStack itemStack = player.getItemInHand(hand);

		if (itemStack.getItem() instanceof HoeItem) {
			level.playSound(player, pos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);
			if (!level.isClientSide) {
				level.setBlock(pos, LandsOfIcariaBlocks.MARL.get().defaultBlockState(), 0);
				if (!player.isCreative()) {
					itemStack.hurtAndBreak(1, player, (playerUsing) -> playerUsing.broadcastBreakEvent(hand));
				}
			}

			return InteractionResult.SUCCESS;
		}

		return InteractionResult.FAIL;
	}
}

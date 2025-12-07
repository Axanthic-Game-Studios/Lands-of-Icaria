package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.properties.Candle;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractThrownPotion;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.BlockHitResult;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CandleCountertopBlock extends CountertopBlock {
	public CandleCountertopBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.getStateDefinition().any().setValue(IcariaBlockStateProperties.CANDLE, Candle.NONE).setValue(IcariaBlockStateProperties.CANDLE_AMOUNT, 0).setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.LIT, false).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, false).setValue(BlockStateProperties.WATERLOGGED, false));
	}

	public boolean canHit(BlockHitResult pBlockHitResult) {
		return pBlockHitResult.getLocation().y - pBlockHitResult.getBlockPos().getY() >= 0.1875D;
	}

	@Override
	public boolean hasAnalogOutputSignal(BlockState pBlockState) {
		return true;
	}

	@Override
	public boolean placeLiquid(LevelAccessor pLevelAccessor, BlockPos pBlockPos, BlockState pBlockState, FluidState pFluidState) {
		pLevelAccessor.scheduleTick(pBlockPos, this, 0);
		return super.placeLiquid(pLevelAccessor, pBlockPos, pBlockState, pFluidState);
	}

	@Override
	public int getAnalogOutputSignal(BlockState pBlockState, Level pLevel, BlockPos pBlockPos) {
		return pBlockState.getValue(IcariaBlockStateProperties.CANDLE_AMOUNT) * 3;
	}

	@Override
	public int getLightEmission(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos) {
		return pBlockState.getValue(BlockStateProperties.LIT) ? pBlockState.getValue(IcariaBlockStateProperties.CANDLE_AMOUNT) * 3 : 0;
	}

	@Override
	public void animateTick(BlockState pBlockState, Level pLevel, BlockPos pBlockPos, RandomSource pRandomSource) {
		this.animateTick(pBlockState, pLevel, pBlockPos, pRandomSource, 0.40625D, 0.59375D, 0.75D, 0.34375D, 0.65625D, 0);
		this.animateTick(pBlockState, pLevel, pBlockPos, pRandomSource, 0.1875D, 0.8125D, 0.5625D, 0.5625D, 0.4375D, 1);
		this.animateTick(pBlockState, pLevel, pBlockPos, pRandomSource, 0.8125D, 0.1875D, 0.5D, 0.4375D, 0.5625D, 2);
		this.animateTick(pBlockState, pLevel, pBlockPos, pRandomSource, 0.625D, 0.375D, 0.625D, 0.25D, 0.75D, 3);
	}

	public void animateTick(BlockState pBlockState, Level pLevel, BlockPos pBlockPos, RandomSource pRandomSource, double pXMin, double pXMax, double pY, double pZMin, double pZMax, int pCount) {
		if (pBlockState.getValue(IcariaBlockStateProperties.CANDLE_AMOUNT) > pCount) {
			this.animateTick(pBlockState, pLevel, pBlockPos, pRandomSource, pXMin, pXMax, pY, pZMin, pZMax);
		}
	}

	public void animateTick(BlockState pBlockState, Level pLevel, BlockPos pBlockPos, RandomSource pRandomSource, double pXMin, double pXMax, double pY, double pZMin, double pZMax) {
		if (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING) == Direction.NORTH) {
			this.animateTick(pBlockPos, pBlockState, pLevel, pRandomSource, pXMax, pY, pZMax);
		} else if (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING) == Direction.EAST) {
			this.animateTick(pBlockPos, pBlockState, pLevel, pRandomSource, pZMin, pY, pXMax);
		} else if (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING) == Direction.SOUTH) {
			this.animateTick(pBlockPos, pBlockState, pLevel, pRandomSource, pXMin, pY, pZMin);
		} else if (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING) == Direction.WEST) {
			this.animateTick(pBlockPos, pBlockState, pLevel, pRandomSource, pZMax, pY, pXMin);
		}
	}

	public void animateTick(BlockPos pBlockPos, BlockState pBlockState, Level pLevel, RandomSource pRandomSource, double pX, double pY, double pZ) {
		var x = pBlockPos.getX() + pX;
		var y = pBlockPos.getY() + pY;
		var z = pBlockPos.getZ() + pZ;
		var f = pRandomSource.nextFloat();
		if (pBlockState.getValue(BlockStateProperties.LIT)) {
			pLevel.addParticle(ParticleTypes.SMALL_FLAME, x, y, z, 0.0D, 0.0D, 0.0D);
			if (f < 0.3F) {
				pLevel.addParticle(ParticleTypes.SMOKE, x, y, z, 0.0D, 0.0D, 0.0D);
				if (f < 0.15F) {
					pLevel.playLocalSound(x, y, z, SoundEvents.CANDLE_AMBIENT, SoundSource.BLOCKS, 1.0F, 1.0F, false);
				}
			}
		}
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(IcariaBlockStateProperties.CANDLE, IcariaBlockStateProperties.CANDLE_AMOUNT, BlockStateProperties.HORIZONTAL_FACING, BlockStateProperties.LIT, IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, BlockStateProperties.WATERLOGGED);
	}

	public void extinguish(BlockState pBlockState, Level pLevel, BlockPos pBlockPos, double pXMin, double pXMax, double pY, double pZMin, double pZMax, int pCount) {
		if (pBlockState.getValue(IcariaBlockStateProperties.CANDLE_AMOUNT) > pCount) {
			this.extinguish(pBlockState, pLevel, pBlockPos, pXMin, pXMax, pY, pZMin, pZMax);
		}
	}

	public void extinguish(BlockState pBlockState, Level pLevel, BlockPos pBlockPos, double pXMin, double pXMax, double pY, double pZMin, double pZMax) {
		if (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING) == Direction.NORTH) {
			this.extinguish(pBlockPos, pLevel, pXMax, pY, pZMax);
		} else if (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING) == Direction.EAST) {
			this.extinguish(pBlockPos, pLevel, pZMin, pY, pXMax);
		} else if (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING) == Direction.SOUTH) {
			this.extinguish(pBlockPos, pLevel, pXMin, pY, pZMin);
		} else if (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING) == Direction.WEST) {
			this.extinguish(pBlockPos, pLevel, pZMax, pY, pXMin);
		}
	}

	public void extinguish(BlockPos pBlockPos, Level pLevel, double pX, double pY, double pZ) {
		var x = pBlockPos.getX() + pX;
		var y = pBlockPos.getY() + pY;
		var z = pBlockPos.getZ() + pZ;
		pLevel.addParticle(ParticleTypes.SMOKE, x, y, z, 0.0D, 0.1D, 0.0D);
	}

	@Override
	public void onProjectileHit(Level pLevel, BlockState pBlockState, BlockHitResult pBlockHitResult, Projectile pProjectile) {
		var blockPos = pBlockHitResult.getBlockPos();
		if (!pLevel.isClientSide() && pBlockState.getValue(IcariaBlockStateProperties.CANDLE) != Candle.NONE) {
			if (pProjectile.isOnFire() && !pBlockState.getValue(BlockStateProperties.LIT)) {
				pLevel.setBlockAndUpdate(blockPos, pBlockState.setValue(BlockStateProperties.LIT, true));
			} else if (pProjectile instanceof AbstractThrownPotion abstractThrownPotion && abstractThrownPotion.getItem().getOrDefault(DataComponents.POTION_CONTENTS, PotionContents.EMPTY).is(Potions.WATER)) {
				this.extinguish(blockPos, pBlockState, pLevel);
			}
		}
	}

	@Override
	public void tick(BlockState pBlockState, ServerLevel pServerLevel, BlockPos pBlockPos, RandomSource pRandomSource) {
		if (pBlockState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED) || pBlockState.getValue(BlockStateProperties.WATERLOGGED)) {
			this.extinguish(pBlockPos, pBlockState, pServerLevel);
		}
	}

	public InteractionResult candle(BlockPos pBlockPos, BlockState pBlockState, Candle pCandle, ItemStack pItemStack, Level pLevel, Player pPlayer) {
		if (pBlockState.getValue(IcariaBlockStateProperties.CANDLE) == Candle.NONE || pBlockState.getValue(IcariaBlockStateProperties.CANDLE) == pCandle && pBlockState.getValue(IcariaBlockStateProperties.CANDLE_AMOUNT) < 4) {
			pLevel.playSound(null, pBlockPos, SoundEvents.CANDLE_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);
			pLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.CANDLE, pCandle).setValue(IcariaBlockStateProperties.CANDLE_AMOUNT, pBlockState.getValue(IcariaBlockStateProperties.CANDLE_AMOUNT) + 1));
			pPlayer.awardStat(Stats.ITEM_USED.get(pItemStack.getItem()));
			pItemStack.consume(1, pPlayer);
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.TRY_WITH_EMPTY_HAND;
		}
	}

	public InteractionResult charge(BlockPos pBlockPos, BlockState pBlockState, ItemStack pItemStack, Level pLevel, Player pPlayer) {
		if (pBlockState.getValue(IcariaBlockStateProperties.CANDLE) != Candle.NONE && !pBlockState.getValue(BlockStateProperties.LIT) && !pBlockState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED) && !pBlockState.getValue(BlockStateProperties.WATERLOGGED)) {
			pLevel.playSound(null, pBlockPos, SoundEvents.FIRECHARGE_USE, SoundSource.BLOCKS, 1.0F, 1.0F);
			pLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(BlockStateProperties.LIT, true));
			pPlayer.awardStat(Stats.ITEM_USED.get(pItemStack.getItem()));
			pItemStack.consume(1, pPlayer);
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.TRY_WITH_EMPTY_HAND;
		}
	}

	public InteractionResult extinguish(BlockPos pBlockPos, BlockState pBlockState, Level pLevel) {
		if (pBlockState.getValue(BlockStateProperties.LIT)) {
			this.extinguish(pBlockState, pLevel, pBlockPos, 0.40625D, 0.59375D, 0.75D, 0.34375D, 0.65625D, 0);
			this.extinguish(pBlockState, pLevel, pBlockPos, 0.1875D, 0.8125D, 0.5625D, 0.5625D, 0.4375D, 1);
			this.extinguish(pBlockState, pLevel, pBlockPos, 0.8125D, 0.1875D, 0.5D, 0.4375D, 0.5625D, 2);
			this.extinguish(pBlockState, pLevel, pBlockPos, 0.625D, 0.375D, 0.625D, 0.25D, 0.75D, 3);
			pLevel.playSound(null, pBlockPos, SoundEvents.CANDLE_EXTINGUISH, SoundSource.BLOCKS, 1.0F, 1.0F);
			pLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(BlockStateProperties.LIT, false));
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.TRY_WITH_EMPTY_HAND;
		}
	}

	public InteractionResult flintAndSteel(BlockPos pBlockPos, BlockState pBlockState, ItemStack pItemStack, Level pLevel, Player pPlayer) {
		if (pBlockState.getValue(IcariaBlockStateProperties.CANDLE) != Candle.NONE && !pBlockState.getValue(BlockStateProperties.LIT) && !pBlockState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED) && !pBlockState.getValue(BlockStateProperties.WATERLOGGED)) {
			pLevel.playSound(null, pBlockPos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 1.0F, 1.0F);
			pLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(BlockStateProperties.LIT, true));
			pPlayer.awardStat(Stats.ITEM_USED.get(pItemStack.getItem()));
			pItemStack.hurtAndBreak(1, pPlayer, LivingEntity.getSlotForHand(pPlayer.getUsedItemHand()));
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.TRY_WITH_EMPTY_HAND;
		}
	}

	@Override
	public InteractionResult useItemOn(ItemStack pItemStack, BlockState pBlockState, Level pLevel, BlockPos pBlockPos, Player pPlayer, InteractionHand pInteractionHand, BlockHitResult pBlockHitResult) {
		if (pItemStack.is(Items.CANDLE)) {
			return this.candle(pBlockPos, pBlockState, Candle.CANDLE, pItemStack, pLevel, pPlayer);
		} else if (pItemStack.is(Items.WHITE_CANDLE)) {
			return this.candle(pBlockPos, pBlockState, Candle.WHITE_CANDLE, pItemStack, pLevel, pPlayer);
		} else if (pItemStack.is(Items.LIGHT_GRAY_CANDLE)) {
			return this.candle(pBlockPos, pBlockState, Candle.LIGHT_GRAY_CANDLE, pItemStack, pLevel, pPlayer);
		} else if (pItemStack.is(Items.GRAY_CANDLE)) {
			return this.candle(pBlockPos, pBlockState, Candle.GRAY_CANDLE, pItemStack, pLevel, pPlayer);
		} else if (pItemStack.is(Items.BLACK_CANDLE)) {
			return this.candle(pBlockPos, pBlockState, Candle.BLACK_CANDLE, pItemStack, pLevel, pPlayer);
		} else if (pItemStack.is(Items.BROWN_CANDLE)) {
			return this.candle(pBlockPos, pBlockState, Candle.BROWN_CANDLE, pItemStack, pLevel, pPlayer);
		} else if (pItemStack.is(Items.RED_CANDLE)) {
			return this.candle(pBlockPos, pBlockState, Candle.RED_CANDLE, pItemStack, pLevel, pPlayer);
		} else if (pItemStack.is(Items.ORANGE_CANDLE)) {
			return this.candle(pBlockPos, pBlockState, Candle.ORANGE_CANDLE, pItemStack, pLevel, pPlayer);
		} else if (pItemStack.is(Items.YELLOW_CANDLE)) {
			return this.candle(pBlockPos, pBlockState, Candle.YELLOW_CANDLE, pItemStack, pLevel, pPlayer);
		} else if (pItemStack.is(Items.LIME_CANDLE)) {
			return this.candle(pBlockPos, pBlockState, Candle.LIME_CANDLE, pItemStack, pLevel, pPlayer);
		} else if (pItemStack.is(Items.GREEN_CANDLE)) {
			return this.candle(pBlockPos, pBlockState, Candle.GREEN_CANDLE, pItemStack, pLevel, pPlayer);
		} else if (pItemStack.is(Items.CYAN_CANDLE)) {
			return this.candle(pBlockPos, pBlockState, Candle.CYAN_CANDLE, pItemStack, pLevel, pPlayer);
		} else if (pItemStack.is(Items.LIGHT_BLUE_CANDLE)) {
			return this.candle(pBlockPos, pBlockState, Candle.LIGHT_BLUE_CANDLE, pItemStack, pLevel, pPlayer);
		} else if (pItemStack.is(Items.BLUE_CANDLE)) {
			return this.candle(pBlockPos, pBlockState, Candle.BLUE_CANDLE, pItemStack, pLevel, pPlayer);
		} else if (pItemStack.is(Items.PURPLE_CANDLE)) {
			return this.candle(pBlockPos, pBlockState, Candle.PURPLE_CANDLE, pItemStack, pLevel, pPlayer);
		} else if (pItemStack.is(Items.MAGENTA_CANDLE)) {
			return this.candle(pBlockPos, pBlockState, Candle.MAGENTA_CANDLE, pItemStack, pLevel, pPlayer);
		} else if (pItemStack.is(Items.PINK_CANDLE)) {
			return this.candle(pBlockPos, pBlockState, Candle.PINK_CANDLE, pItemStack, pLevel, pPlayer);
		} else if (pItemStack.is(Items.FIRE_CHARGE)) {
			return this.charge(pBlockPos, pBlockState, pItemStack, pLevel, pPlayer);
		} else if (pItemStack.is(Items.FLINT_AND_STEEL)) {
			return this.flintAndSteel(pBlockPos, pBlockState, pItemStack, pLevel, pPlayer);
		} else if (pItemStack.isEmpty() && this.canHit(pBlockHitResult)) {
			return this.extinguish(pBlockPos, pBlockState, pLevel);
		} else {
			return InteractionResult.TRY_WITH_EMPTY_HAND;
		}
	}
}

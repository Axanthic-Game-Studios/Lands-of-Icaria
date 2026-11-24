package com.axanthic.icaria.common.block;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.helper.IcariaCommonHelper;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;

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
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.throwableitemprojectile.AbstractThrownPotion;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.context.BlockPlaceContext;
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

public class ParchmentBlock extends TableDecorationBlock {
	public ParchmentBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.getStateDefinition().any().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.LIT, false).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, false).setValue(IcariaBlockStateProperties.PARCHMENT_VARIANT, 0).setValue(BlockStateProperties.WATERLOGGED, false));
	}

	public boolean canHit(BlockHitResult pBlockHitResult) {
		return pBlockHitResult.getLocation().y - pBlockHitResult.getBlockPos().getY() >= 0.125D;
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
	public int getAnalogOutputSignal(BlockState pBlockState, Level pLevel, BlockPos pBlockPos, Direction pDirection) {
		return pBlockState.getValue(BlockStateProperties.LIT) ? 15 : 0;
	}

	@Override
	public int getLightEmission(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos) {
		var variant = pBlockState.getValue(IcariaBlockStateProperties.PARCHMENT_VARIANT);
		return pBlockState.getValue(BlockStateProperties.LIT) ? variant == 5 ? 0 : variant == 4 ? 6 : 3 : 0;
	}

	public void animateExtinguish(BlockPos pBlockPos, BlockState pBlockState, Level pLevel) {
		if (pBlockState.getValue(IcariaBlockStateProperties.PARCHMENT_VARIANT) == 0) {
			this.animateExtinguish(pBlockPos, pBlockState, pLevel, 0.5625D, 0.4375D, 0.5D, 0.1875D, 0.8125D);
		} else if (pBlockState.getValue(IcariaBlockStateProperties.PARCHMENT_VARIANT) == 1) {
			this.animateExtinguish(pBlockPos, pBlockState, pLevel, 0.25D, 0.75D, 0.5625D, 0.125D, 0.875D);
		} else if (pBlockState.getValue(IcariaBlockStateProperties.PARCHMENT_VARIANT) == 2) {
			this.animateExtinguish(pBlockPos, pBlockState, pLevel, 0.3125D, 0.6875D, 0.4375D, 0.125D, 0.875D);
		} else if (pBlockState.getValue(IcariaBlockStateProperties.PARCHMENT_VARIANT) == 3) {
			this.animateExtinguish(pBlockPos, pBlockState, pLevel, 0.4375D, 0.5625D, 0.5D, 0.25D, 0.75D);
		} else if (pBlockState.getValue(IcariaBlockStateProperties.PARCHMENT_VARIANT) == 4) {
			this.animateExtinguish(pBlockPos, pBlockState, pLevel, 0.25D, 0.75D, 0.5D, 0.125D, 0.875D);
			this.animateExtinguish(pBlockPos, pBlockState, pLevel, 0.5D, 0.5D, 0.375D, 0.1875D, 0.8125D);
		}
	}

	public void animateExtinguish(BlockPos pBlockPos, BlockState pBlockState, Level pLevel, double pXMin, double pXMax, double pY, double pZMin, double pZMax) {
		if (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING) == Direction.NORTH) {
			this.animateExtinguish(pBlockPos, pLevel, pXMax, pY, pZMax);
		} else if (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING) == Direction.EAST) {
			this.animateExtinguish(pBlockPos, pLevel, pZMin, pY, pXMax);
		} else if (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING) == Direction.SOUTH) {
			this.animateExtinguish(pBlockPos, pLevel, pXMin, pY, pZMin);
		} else if (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING) == Direction.WEST) {
			this.animateExtinguish(pBlockPos, pLevel, pZMax, pY, pXMin);
		}
	}

	public void animateExtinguish(BlockPos pBlockPos, Level pLevel, double pX, double pY, double pZ) {
		var x = pBlockPos.getX() + pX;
		var y = pBlockPos.getY() + pY;
		var z = pBlockPos.getZ() + pZ;
		pLevel.addParticle(ParticleTypes.SMOKE, x, y, z, 0.0D, 0.1D, 0.0D);
	}

	@Override
	public void animateTick(BlockState pBlockState, Level pLevel, BlockPos pBlockPos, RandomSource pRandomSource) {
		if (pBlockState.getValue(IcariaBlockStateProperties.PARCHMENT_VARIANT) == 0) {
			this.animateTick(pBlockState, pLevel, pBlockPos, pRandomSource, 0.5625D, 0.4375D, 0.5D, 0.1875D, 0.8125D);
		} else if (pBlockState.getValue(IcariaBlockStateProperties.PARCHMENT_VARIANT) == 1) {
			this.animateTick(pBlockState, pLevel, pBlockPos, pRandomSource, 0.25D, 0.75D, 0.5625D, 0.125D, 0.875D);
		} else if (pBlockState.getValue(IcariaBlockStateProperties.PARCHMENT_VARIANT) == 2) {
			this.animateTick(pBlockState, pLevel, pBlockPos, pRandomSource, 0.3125D, 0.6875D, 0.4375D, 0.125D, 0.875D);
		} else if (pBlockState.getValue(IcariaBlockStateProperties.PARCHMENT_VARIANT) == 3) {
			this.animateTick(pBlockState, pLevel, pBlockPos, pRandomSource, 0.4375D, 0.5625D, 0.5D, 0.25D, 0.75D);
		} else if (pBlockState.getValue(IcariaBlockStateProperties.PARCHMENT_VARIANT) == 4) {
			this.animateTick(pBlockState, pLevel, pBlockPos, pRandomSource, 0.25D, 0.75D, 0.5D, 0.125D, 0.875D);
			this.animateTick(pBlockState, pLevel, pBlockPos, pRandomSource, 0.5D, 0.5D, 0.375D, 0.1875D, 0.8125D);
		}
	}

	public void animateTick(BlockState pBlockState, Level pLevel, BlockPos pBlockPos, RandomSource pRandomSource, double pXMin, double pXMax, double pY, double pZMin, double pZMax) {
		if (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING) == Direction.NORTH) {
			this.animateTick(pBlockState, pLevel, pBlockPos, pRandomSource, pXMax, pY, pZMax);
		} else if (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING) == Direction.EAST) {
			this.animateTick(pBlockState, pLevel, pBlockPos, pRandomSource, pZMin, pY, pXMax);
		} else if (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING) == Direction.SOUTH) {
			this.animateTick(pBlockState, pLevel, pBlockPos, pRandomSource, pXMin, pY, pZMin);
		} else if (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING) == Direction.WEST) {
			this.animateTick(pBlockState, pLevel, pBlockPos, pRandomSource, pZMax, pY, pXMin);
		}
	}

	public void animateTick(BlockState pBlockState, Level pLevel, BlockPos pBlockPos, RandomSource pRandomSource, double pX, double pY, double pZ) {
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
		pBuilder.add(BlockStateProperties.HORIZONTAL_FACING, BlockStateProperties.LIT, IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, IcariaBlockStateProperties.PARCHMENT_VARIANT, BlockStateProperties.WATERLOGGED);
	}

	@Override
	public void onProjectileHit(Level pLevel, BlockState pBlockState, BlockHitResult pBlockHitResult, Projectile pProjectile) {
		var blockPos = pBlockHitResult.getBlockPos();
		if (!pLevel.isClientSide() && pBlockState.getValue(IcariaBlockStateProperties.PARCHMENT_VARIANT) != 5) {
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

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pBlockPlaceContext) {
		var blockPos = pBlockPlaceContext.getClickedPos();
		var randomSource = IcariaCommonHelper.getRandomSource(blockPos);
		return super.getStateForPlacement(pBlockPlaceContext).setValue(IcariaBlockStateProperties.PARCHMENT_VARIANT, randomSource.nextInt(6));
	}

	@Override
	public InteractionResult useItemOn(ItemStack pItemStack, BlockState pBlockState, Level pLevel, BlockPos pBlockPos, Player pPlayer, InteractionHand pInteractionHand, BlockHitResult pBlockHitResult) {
		if (pItemStack.is(Items.FIRE_CHARGE)) {
			return this.fireCharge(pBlockPos, pBlockState, pItemStack, pLevel, pPlayer);
		} else if (pItemStack.is(Items.FLINT_AND_STEEL)) {
			return this.flintAndSteel(pBlockPos, pBlockState, pItemStack, pLevel, pPlayer);
		} else if (pItemStack.isEmpty() && this.canHit(pBlockHitResult)) {
			return this.extinguish(pBlockPos, pBlockState, pLevel);
		} else {
			return InteractionResult.TRY_WITH_EMPTY_HAND;
		}
	}

	public InteractionResult extinguish(BlockPos pBlockPos, BlockState pBlockState, Level pLevel) {
		if (pBlockState.getValue(BlockStateProperties.LIT)) {
			pLevel.playSound(null, pBlockPos, SoundEvents.CANDLE_EXTINGUISH, SoundSource.BLOCKS, 1.0F, 1.0F);
			pLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(BlockStateProperties.LIT, false));
			this.animateExtinguish(pBlockPos, pBlockState, pLevel);
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.TRY_WITH_EMPTY_HAND;
		}
	}

	public InteractionResult fireCharge(BlockPos pBlockPos, BlockState pBlockState, ItemStack pItemStack, Level pLevel, Player pPlayer) {
		if (pBlockState.getValue(IcariaBlockStateProperties.PARCHMENT_VARIANT) != 5 && !pBlockState.getValue(BlockStateProperties.LIT) && !pBlockState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED) && !pBlockState.getValue(BlockStateProperties.WATERLOGGED)) {
			pLevel.playSound(null, pBlockPos, SoundEvents.FIRECHARGE_USE, SoundSource.BLOCKS, 1.0F, 1.0F);
			pLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(BlockStateProperties.LIT, true));
			pPlayer.awardStat(Stats.ITEM_USED.get(pItemStack.getItem()));
			pItemStack.consume(1, pPlayer);
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.TRY_WITH_EMPTY_HAND;
		}
	}

	public InteractionResult flintAndSteel(BlockPos pBlockPos, BlockState pBlockState, ItemStack pItemStack, Level pLevel, Player pPlayer) {
		if (pBlockState.getValue(IcariaBlockStateProperties.PARCHMENT_VARIANT) != 5 && !pBlockState.getValue(BlockStateProperties.LIT) && !pBlockState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED) && !pBlockState.getValue(BlockStateProperties.WATERLOGGED)) {
			pLevel.playSound(null, pBlockPos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 1.0F, 1.0F);
			pLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(BlockStateProperties.LIT, true));
			pPlayer.awardStat(Stats.ITEM_USED.get(pItemStack.getItem()));
			pItemStack.hurtAndBreak(1, pPlayer, pPlayer.getUsedItemHand().asEquipmentSlot());
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.TRY_WITH_EMPTY_HAND;
		}
	}
}

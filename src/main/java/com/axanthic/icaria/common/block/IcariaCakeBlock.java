package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.properties.Candle;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.shapes.IcariaCakeShapes;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

@SuppressWarnings("deprecation")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaCakeBlock extends Block {
	public boolean teleport;

	public int duration;

	public Holder<MobEffect> mobEffect;

	public IcariaCakeBlock(boolean pTeleport, int pDuration, Holder<MobEffect> pMobEffect, Properties pProperties) {
		super(pProperties);
		this.teleport = pTeleport;
		this.duration = pDuration;
		this.mobEffect = pMobEffect;
		this.registerDefaultState(this.stateDefinition.any().setValue(IcariaBlockStateProperties.CAKE_BITE, 0).setValue(IcariaBlockStateProperties.CANDLE, Candle.NONE).setValue(BlockStateProperties.LIT, false));
	}

	public boolean canHit(BlockHitResult pBlockHitResult) {
		return pBlockHitResult.getLocation().y - pBlockHitResult.getBlockPos().getY() > 0.5D;
	}

	@Override
	public boolean canSurvive(BlockState pBlockState, LevelReader pLevelReader, BlockPos pBlockPos) {
		return pLevelReader.getBlockState(pBlockPos.below()).isSolid();
	}

	@Override
	public boolean hasAnalogOutputSignal(BlockState pBlockState) {
		return true;
	}

	@Override
	public boolean isPathfindable(BlockState pBlockState, PathComputationType pPathComputationType) {
		return false;
	}

	@Override
	public int getAnalogOutputSignal(BlockState pBlockState, Level pLevel, BlockPos pBlockPos) {
		return (4 - pBlockState.getValue(IcariaBlockStateProperties.CAKE_BITE)) * 3;
	}

	@Override
	public int getLightEmission(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos) {
		return pBlockState.getValue(BlockStateProperties.LIT) ? 3 : 0;
	}

	@Override
	public void animateTick(BlockState pBlockState, Level pLevel, BlockPos pBlockPos, RandomSource pRandomSource) {
		var x = pBlockPos.getX() + 0.5D;
		var y = pBlockPos.getY() + 1.0D;
		var z = pBlockPos.getZ() + 0.5D;
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

	public void bite(BlockState pBlockState, Level pLevel, BlockPos pBlockPos) {
		var i = pBlockState.getValue(IcariaBlockStateProperties.CAKE_BITE);
		if (i < 3) {
			pLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.CAKE_BITE, i + 1).setValue(IcariaBlockStateProperties.CANDLE, Candle.NONE).setValue(BlockStateProperties.LIT, false));
		} else {
			pLevel.removeBlock(pBlockPos, false);
		}
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(IcariaBlockStateProperties.CAKE_BITE, IcariaBlockStateProperties.CANDLE, BlockStateProperties.LIT);
	}

	@Override
	public void onProjectileHit(Level pLevel, BlockState pBlockState, BlockHitResult pBlockHitResult, Projectile pProjectile) {
		var blockPos = pBlockHitResult.getBlockPos();
		if (!pLevel.isClientSide() && pBlockState.getValue(IcariaBlockStateProperties.CANDLE) != Candle.NONE) {
			if (pProjectile.isOnFire() && !pBlockState.getValue(BlockStateProperties.LIT)) {
				pLevel.setBlockAndUpdate(blockPos, pBlockState.setValue(BlockStateProperties.LIT, true));
			} else if (pProjectile instanceof ThrownPotion thrownPotion && thrownPotion.getItem().getOrDefault(DataComponents.POTION_CONTENTS, PotionContents.EMPTY).is(Potions.WATER)) {
				this.extinguish(blockPos, pBlockState, pLevel);
			}
		}
	}

	public void teleport(Level pLevel, Player pPlayer) {
		for (var j = 0; j < 16; ++j) {
			var randomSource = pPlayer.getRandom();
			if (!pLevel.isClientSide() && this.teleport) {
				pPlayer.randomTeleport(pPlayer.getX() + (randomSource.nextDouble() - 0.5D) * 16.0D, Mth.clamp(pPlayer.getY() + (randomSource.nextDouble() - 0.5D) * 16.0D, pLevel.getMinY(), pLevel.getMaxY()), pPlayer.getZ() + (randomSource.nextDouble() - 0.5D) * 16.0D, true);
				if (pPlayer.isPassenger()) {
					pPlayer.stopRiding();
				}
			}
		}
	}

	@Override
	public BlockState updateShape(BlockState pBlockState, LevelReader pLevelReader, ScheduledTickAccess pScheduledTickAccess, BlockPos pBlockPos, Direction pDirection, BlockPos pBlockPosFaced, BlockState pBlockStateFaced, RandomSource pRandomSource) {
		return pBlockState.canSurvive(pLevelReader, pBlockPos) ? super.updateShape(pBlockState, pLevelReader, pScheduledTickAccess, pBlockPos, pDirection, pBlockPosFaced, pBlockStateFaced, pRandomSource) : Blocks.AIR.defaultBlockState();
	}

	public InteractionResult candle(BlockPos pBlockPos, BlockState pBlockState, Candle pCandle, ItemStack pItemStack, Level pLevel, Player pPlayer) {
		if (pBlockState.getValue(IcariaBlockStateProperties.CANDLE) == Candle.NONE && pBlockState.getValue(IcariaBlockStateProperties.CAKE_BITE) == 0) {
			pLevel.playSound(null, pBlockPos, SoundEvents.CAKE_ADD_CANDLE, SoundSource.BLOCKS, 1.0F, 1.0F);
			pLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.CANDLE, pCandle));
			pPlayer.awardStat(Stats.ITEM_USED.get(pItemStack.getItem()));
			pItemStack.consume(1, pPlayer);
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.TRY_WITH_EMPTY_HAND;
		}
	}

	public InteractionResult charge(BlockPos pBlockPos, BlockState pBlockState, ItemStack pItemStack, Level pLevel, Player pPlayer) {
		if (pBlockState.getValue(IcariaBlockStateProperties.CANDLE) != Candle.NONE && !pBlockState.getValue(BlockStateProperties.LIT)) {
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
			pLevel.addParticle(ParticleTypes.SMOKE, pBlockPos.getX() + 0.5D, pBlockPos.getY() + 1.0D, pBlockPos.getZ() + 0.5D, 0.0D, 0.1D, 0.0D);
			pLevel.playSound(null, pBlockPos, SoundEvents.CANDLE_EXTINGUISH, SoundSource.BLOCKS, 1.0F, 1.0F);
			pLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(BlockStateProperties.LIT, false));
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.TRY_WITH_EMPTY_HAND;
		}
	}

	public InteractionResult flintAndSteel(BlockPos pBlockPos, BlockState pBlockState, ItemStack pItemStack, Level pLevel, Player pPlayer) {
		if (pBlockState.getValue(IcariaBlockStateProperties.CANDLE) != Candle.NONE && !pBlockState.getValue(BlockStateProperties.LIT)) {
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

	@Override
	public InteractionResult useWithoutItem(BlockState pBlockState, Level pLevel, BlockPos pBlockPos, Player pPlayer, BlockHitResult pBlockHitResult) {
		if (pPlayer.canEat(false)) {
			pPlayer.addEffect(new MobEffectInstance(this.mobEffect, this.duration));
			pPlayer.awardStat(Stats.EAT_CAKE_SLICE);
			pPlayer.getFoodData().eat(2, 0.1F);
			Block.dropResources(pBlockState, pLevel, pBlockPos);
			this.bite(pBlockState, pLevel, pBlockPos);
			this.teleport(pLevel, pPlayer);
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.PASS;
		}
	}

	@Override
	public VoxelShape getShape(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos, CollisionContext pCollisionContext) {
		return pBlockState.getValue(IcariaBlockStateProperties.CANDLE) == Candle.NONE ? IcariaCakeShapes.CAKE_SHAPES[pBlockState.getValue(IcariaBlockStateProperties.CAKE_BITE)] : IcariaCakeShapes.CANDLE_CAKE;
	}
}

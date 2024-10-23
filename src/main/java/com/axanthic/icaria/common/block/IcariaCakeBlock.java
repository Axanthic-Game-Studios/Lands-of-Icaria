package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.properties.Candle;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaMobEffects;
import com.axanthic.icaria.common.shapes.IcariaCakeShapes;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
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
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaCakeBlock extends Block {
	public IcariaCakeBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.stateDefinition.any().setValue(IcariaBlockStateProperties.CAKE_BITE, 0).setValue(IcariaBlockStateProperties.CANDLE, Candle.NONE).setValue(BlockStateProperties.LIT, false));
	}

	public boolean canHit(BlockHitResult pResult) {
		return pResult.getLocation().y - pResult.getBlockPos().getY() > 0.5D;
	}

	@Override
	public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
		return pLevel.getBlockState(pPos.below()).isSolid();
	}

	@Override
	public boolean hasAnalogOutputSignal(BlockState pState) {
		return true;
	}

	@Override
	public boolean isPathfindable(BlockState pState, PathComputationType pType) {
		return false;
	}

	@Override
	public int getAnalogOutputSignal(BlockState pState, Level pLevel, BlockPos pPos) {
		return (4 - pState.getValue(IcariaBlockStateProperties.CAKE_BITE)) * 3;
	}

	@Override
	public int getLightEmission(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
		return pState.getValue(BlockStateProperties.LIT) ? 3 : 0;
	}

	@Override
	public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
		double x = pPos.getX() + 0.5D;
		double y = pPos.getY() + 1.0D;
		double z = pPos.getZ() + 0.5D;
		float f = pRandom.nextFloat();
		if (pState.getValue(BlockStateProperties.LIT)) {
			pLevel.addParticle(ParticleTypes.SMALL_FLAME, x, y, z, 0.0D, 0.0D, 0.0D);
			if (f < 0.3F) {
				pLevel.addParticle(ParticleTypes.SMOKE, x, y, z, 0.0D, 0.0D, 0.0D);
				if (f < 0.15F) {pLevel.playLocalSound(x, y, z, SoundEvents.CANDLE_AMBIENT, SoundSource.BLOCKS, 1.0F, 1.0F, false);
				}
			}
		}
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(IcariaBlockStateProperties.CAKE_BITE, IcariaBlockStateProperties.CANDLE, BlockStateProperties.LIT);
	}

	@Override
	public void onProjectileHit(Level pLevel, BlockState pState, BlockHitResult pResult, Projectile pProjectile) {
		var blockPos = pResult.getBlockPos();
		if (!pLevel.isClientSide() && pState.getValue(IcariaBlockStateProperties.CANDLE) != Candle.NONE) {
			if (pProjectile.isOnFire() && !pState.getValue(BlockStateProperties.LIT)) {
				pLevel.setBlockAndUpdate(blockPos, pState.setValue(BlockStateProperties.LIT, true));
			} else if (pProjectile instanceof ThrownPotion thrownPotion && thrownPotion.getItem().getOrDefault(DataComponents.POTION_CONTENTS, PotionContents.EMPTY).is(Potions.WATER)) {
				this.extinguish(pState, pLevel, blockPos);
			}
		}
	}

	@Override
	public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pNeighborPos) {
		return pDirection == Direction.DOWN && !pState.canSurvive(pLevel, pCurrentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(pState, pDirection, pNeighborState, pLevel, pCurrentPos, pNeighborPos);
	}

	@Override
	public InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pResult) {
		if (!pPlayer.canEat(false)) {
			return InteractionResult.PASS;
		} else {
			int bite = pState.getValue(IcariaBlockStateProperties.CAKE_BITE);
			if (bite < 3) {
				pLevel.setBlockAndUpdate(pPos, pState.setValue(IcariaBlockStateProperties.CAKE_BITE, bite + 1).setValue(IcariaBlockStateProperties.CANDLE, Candle.NONE).setValue(BlockStateProperties.LIT, false));
			} else {
				pLevel.removeBlock(pPos, false);
			}

			if (pState.is(IcariaBlocks.LAUREL_CHERRY_CAKE.get())) {
				pPlayer.addEffect(new MobEffectInstance(IcariaMobEffects.LIFESTEAL, 600));
			} else if (pState.is(IcariaBlocks.STRAWBERRY_CAKE.get())) {
				pPlayer.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 600));
			} else if (pState.is(IcariaBlocks.PHYSALIS_CAKE.get())) {
				pPlayer.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 600));
			} else if (pState.is(IcariaBlocks.VINE_BERRY_CAKE.get())) {
				pPlayer.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 600));
			} else if (pState.is(IcariaBlocks.VINE_SPROUT_CAKE.get())) {
				pPlayer.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600));
			}

			if (pState.is(IcariaBlocks.LAUREL_CHERRY_CAKE.get())) {
				if (!pLevel.isClientSide()) {
					for (int i = 0; i < 16; ++i) {
						pPlayer.randomTeleport(pPlayer.getX() + (pPlayer.getRandom().nextDouble() - 0.5D) * 16.0D, Mth.clamp(pPlayer.getY() + (pPlayer.getRandom().nextInt(16) - 8), pLevel.getMinBuildHeight(), pLevel.getMaxBuildHeight()), pPlayer.getZ() + (pPlayer.getRandom().nextDouble() - 0.5D) * 16.0D, true);
						if (pPlayer.isPassenger()) {
							pPlayer.stopRiding();
						}
					}
				}
			}

			pPlayer.awardStat(Stats.EAT_CAKE_SLICE);
			pPlayer.getFoodData().eat(2, 0.1F);

			Block.dropResources(pState, pLevel, pPos);

			return InteractionResult.SUCCESS;
		}
	}

	public ItemInteractionResult candle(ItemStack pStack, BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, Candle pCandle) {
		if (pState.getValue(IcariaBlockStateProperties.CANDLE) == Candle.NONE && pState.getValue(IcariaBlockStateProperties.CAKE_BITE) == 0) {
			pLevel.playSound(null, pPos, SoundEvents.CAKE_ADD_CANDLE, SoundSource.BLOCKS, 1.0F, 1.0F);
			pLevel.setBlockAndUpdate(pPos, pState.setValue(IcariaBlockStateProperties.CANDLE, pCandle));
			pPlayer.awardStat(Stats.ITEM_USED.get(pStack.getItem()));
			if (!pPlayer.isCreative()) {
				pStack.shrink(1);
			}
			return ItemInteractionResult.SUCCESS;
		} else {
			return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
		}
	}

	public ItemInteractionResult charge(ItemStack pStack, BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer) {
		if (pState.getValue(IcariaBlockStateProperties.CANDLE) != Candle.NONE && !pState.getValue(BlockStateProperties.LIT)) {
			pLevel.playSound(null, pPos, SoundEvents.FIRECHARGE_USE, SoundSource.BLOCKS, 1.0F,  1.0F);
			pLevel.setBlockAndUpdate(pPos, pState.setValue(BlockStateProperties.LIT, true));
			pPlayer.awardStat(Stats.ITEM_USED.get(pStack.getItem()));
			if (!pPlayer.isCreative()) {
				pStack.shrink(1);
			}
			return ItemInteractionResult.SUCCESS;
		} else {
			return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
		}
	}

	public ItemInteractionResult extinguish(BlockState pState, Level pLevel, BlockPos pPos) {
		if (pState.getValue(BlockStateProperties.LIT)) {
			pLevel.addParticle(ParticleTypes.SMOKE, pPos.getX() + 0.5D, pPos.getY() + 1.0D, pPos.getZ() + 0.5D, 0.0D, 0.1D, 0.0D);
			pLevel.playSound(null, pPos, SoundEvents.CANDLE_EXTINGUISH, SoundSource.BLOCKS, 1.0F, 1.0F);
			pLevel.setBlockAndUpdate(pPos, pState.setValue(BlockStateProperties.LIT, false));
			return ItemInteractionResult.SUCCESS;
		} else {
			return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
		}
	}

	public ItemInteractionResult flintAndSteel(ItemStack pStack, BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand) {
		if (pState.getValue(IcariaBlockStateProperties.CANDLE) != Candle.NONE && !pState.getValue(BlockStateProperties.LIT)) {
			pLevel.playSound(null, pPos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 1.0F,  1.0F);
			pLevel.setBlockAndUpdate(pPos, pState.setValue(BlockStateProperties.LIT, true));
			pPlayer.awardStat(Stats.ITEM_USED.get(pStack.getItem()));
			if (!pPlayer.isCreative()) {
				pStack.hurtAndBreak(1, pPlayer, LivingEntity.getSlotForHand(pHand));
			}
			return ItemInteractionResult.SUCCESS;
		} else {
			return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
		}
	}

	@Override
	public ItemInteractionResult useItemOn(ItemStack pStack, BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pResult) {
		if (pStack.is(Items.CANDLE)) {
			return this.candle(pStack, pState, pLevel, pPos, pPlayer, Candle.CANDLE);
		} else if (pStack.is(Items.WHITE_CANDLE)) {
			return this.candle(pStack, pState, pLevel, pPos, pPlayer, Candle.WHITE_CANDLE);
		} else if (pStack.is(Items.LIGHT_GRAY_CANDLE)) {
			return this.candle(pStack, pState, pLevel, pPos, pPlayer, Candle.LIGHT_GRAY_CANDLE);
		} else if (pStack.is(Items.GRAY_CANDLE)) {
			return this.candle(pStack, pState, pLevel, pPos, pPlayer, Candle.GRAY_CANDLE);
		} else if (pStack.is(Items.BLACK_CANDLE)) {
			return this.candle(pStack, pState, pLevel, pPos, pPlayer, Candle.BLACK_CANDLE);
		} else if (pStack.is(Items.BROWN_CANDLE)) {
			return this.candle(pStack, pState, pLevel, pPos, pPlayer, Candle.BROWN_CANDLE);
		} else if (pStack.is(Items.RED_CANDLE)) {
			return this.candle(pStack, pState, pLevel, pPos, pPlayer, Candle.RED_CANDLE);
		} else if (pStack.is(Items.ORANGE_CANDLE)) {
			return this.candle(pStack, pState, pLevel, pPos, pPlayer, Candle.ORANGE_CANDLE);
		} else if (pStack.is(Items.YELLOW_CANDLE)) {
			return this.candle(pStack, pState, pLevel, pPos, pPlayer, Candle.YELLOW_CANDLE);
		} else if (pStack.is(Items.LIME_CANDLE)) {
			return this.candle(pStack, pState, pLevel, pPos, pPlayer, Candle.LIME_CANDLE);
		} else if (pStack.is(Items.GREEN_CANDLE)) {
			return this.candle(pStack, pState, pLevel, pPos, pPlayer, Candle.GREEN_CANDLE);
		} else if (pStack.is(Items.CYAN_CANDLE)) {
			return this.candle(pStack, pState, pLevel, pPos, pPlayer, Candle.CYAN_CANDLE);
		} else if (pStack.is(Items.LIGHT_BLUE_CANDLE)) {
			return this.candle(pStack, pState, pLevel, pPos, pPlayer, Candle.LIGHT_BLUE_CANDLE);
		} else if (pStack.is(Items.BLUE_CANDLE)) {
			return this.candle(pStack, pState, pLevel, pPos, pPlayer, Candle.BLUE_CANDLE);
		} else if (pStack.is(Items.PURPLE_CANDLE)) {
			return this.candle(pStack, pState, pLevel, pPos, pPlayer, Candle.PURPLE_CANDLE);
		} else if (pStack.is(Items.MAGENTA_CANDLE)) {
			return this.candle(pStack, pState, pLevel, pPos, pPlayer, Candle.MAGENTA_CANDLE);
		} else if (pStack.is(Items.PINK_CANDLE)) {
			return this.candle(pStack, pState, pLevel, pPos, pPlayer, Candle.PINK_CANDLE);
		} else if (pStack.is(Items.FIRE_CHARGE)) {
			return this.charge(pStack, pState, pLevel, pPos, pPlayer);
		} else if (pStack.is(Items.FLINT_AND_STEEL)) {
			return this.flintAndSteel(pStack, pState, pLevel, pPos, pPlayer, pHand);
		} else if (pStack.isEmpty() && this.canHit(pResult)) {
			return this.extinguish(pState, pLevel, pPos);
		} else {
			return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
		}
	}

	@Override
	public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		return pState.getValue(IcariaBlockStateProperties.CANDLE) == Candle.NONE ? IcariaCakeShapes.CAKE_SHAPES[pState.getValue(IcariaBlockStateProperties.CAKE_BITE)] : IcariaCakeShapes.CANDLE_CAKE;
	}
}

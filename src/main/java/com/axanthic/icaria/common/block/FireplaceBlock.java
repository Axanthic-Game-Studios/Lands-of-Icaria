package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.config.IcariaConfig;
import com.axanthic.icaria.common.entity.FireplaceBlockEntity;
import com.axanthic.icaria.common.registry.IcariaBlockEntityTypes;
import com.axanthic.icaria.common.registry.IcariaRecipeTypes;

import com.mojang.serialization.MapCodec;

import java.util.Optional;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.phys.BlockHitResult;

@SuppressWarnings("OptionalUsedAsFieldOrParameterType")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class FireplaceBlock extends BaseEntityBlock {
	public float itemHeight;

	public static final MapCodec<FireplaceBlock> CODEC = Block.simpleCodec(FireplaceBlock::new);

	public FireplaceBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.getStateDefinition().any().setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER).setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.LIT, false));
	}

	public FireplaceBlock(float pItemHeight, Properties pProperties) {
		this(pProperties);
		this.itemHeight = pItemHeight;
	}

	@Override
	public boolean canDropFromExplosion(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos, Explosion pExplosion) {
		return false;
	}

	@Override
	public boolean hasAnalogOutputSignal(BlockState pBlockState) {
		return true;
	}

	public double getX(BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH, SOUTH -> 0.5D;
			case EAST -> 0.4375D;
			case WEST -> 0.5625D;
			default -> 1.0D;
		};
	}

	public double getZ(BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> 0.5625D;
			case EAST, WEST -> 0.5D;
			case SOUTH -> 0.4375D;
			default -> 1.0D;
		};
	}

	@Override
	public int getAnalogOutputSignal(BlockState pBlockState, Level pLevel, BlockPos pBlockPos) {
		return pBlockState.getValue(BlockStateProperties.LIT) ? 15 : 0;
	}

	@Override
	public int getLightEmission(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos) {
		return pBlockState.getValue(BlockStateProperties.LIT) ? 15 : 0;
	}

	@Override
	public void animateTick(BlockState pBlockState, Level pLevel, BlockPos pBlockPos, RandomSource pRandomSource) {
		if (pBlockState.getValue(BlockStateProperties.DOUBLE_BLOCK_HALF) == DoubleBlockHalf.LOWER && pBlockState.getValue(BlockStateProperties.LIT)) {
			this.particlesFireplace(pBlockPos, pBlockState, pLevel, pRandomSource);
			this.particlesItems(pBlockPos, pBlockState, pLevel, pRandomSource);
			this.sounds(pBlockPos, pLevel, pRandomSource);
		}
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(BlockStateProperties.DOUBLE_BLOCK_HALF, BlockStateProperties.HORIZONTAL_FACING, BlockStateProperties.LIT);
	}

	public void drop(BlockPos pBlockPos, BlockState pBlockState, Level pLevel) {
		Block.dropResources(pBlockState, pLevel, pBlockPos);
	}

	@Override
	public void onBlockExploded(BlockState pBlockState, ServerLevel pServerLevel, BlockPos pBlockPos, Explosion pExplosion) {
		this.drop(pBlockPos, pBlockState, pServerLevel);
		this.removeMultiBlock(FireplaceBlock.getBlockEntityPosition(pBlockPos, pBlockState), pServerLevel);
		super.onBlockExploded(pBlockState, pServerLevel, pBlockPos, pExplosion);
	}

	public void particlesFireplace(BlockPos pBlockPos, BlockState pBlockState, Level pLevel, RandomSource pRandomSource) {
		if (IcariaConfig.RENDER_FIREPLACE_ITEMS.get()) {
			pLevel.addParticle(ParticleTypes.SMALL_FLAME, this.getX(pBlockState) + pBlockPos.getX() + pRandomSource.nextDouble() / 4.0D * (pRandomSource.nextBoolean() ? 1 : -1), pBlockPos.getY() + 1.0D, this.getZ(pBlockState) + pBlockPos.getZ() + pRandomSource.nextDouble() / 4.0D * (pRandomSource.nextBoolean() ? 1 : -1), 0.0D, 0.0D, 0.0D);
			pLevel.addParticle(ParticleTypes.SMOKE, this.getX(pBlockState) + pBlockPos.getX() + pRandomSource.nextDouble() / 4.0D * (pRandomSource.nextBoolean() ? 1 : -1), pBlockPos.getY() + 1.0D, this.getZ(pBlockState) + pBlockPos.getZ() + pRandomSource.nextDouble() / 4.0D * (pRandomSource.nextBoolean() ? 1 : -1), 0.0D, 0.0D, 0.0D);
		}
	}

	public void particlesItems(BlockPos pBlockPos, BlockState pBlockState, Level pLevel, RandomSource pRandomSource) {
		if (IcariaConfig.RENDER_FIREPLACE_ITEMS.get() && pLevel.getBlockEntity(pBlockPos) instanceof FireplaceBlockEntity blockEntity && blockEntity.getOutput().isEmpty() && !blockEntity.getInput().isEmpty()) {
			pLevel.addParticle(ParticleTypes.WHITE_SMOKE, this.getX(pBlockState) + pBlockPos.getX() + pRandomSource.nextDouble() / 8.0D * (pRandomSource.nextBoolean() ? 1 : -1), this.itemHeight + pBlockPos.getY() + 0.1D, this.getZ(pBlockState) + pBlockPos.getZ() + pRandomSource.nextDouble() / 8.0D * (pRandomSource.nextBoolean() ? 1 : -1), 0.0D, 0.0D, 0.0D);
		}
	}

	public void removeMultiBlock(BlockPos pBlockPos, Level pLevel) {
		pLevel.setBlock(pBlockPos, Blocks.AIR.defaultBlockState(), 3);
		pLevel.setBlock(pBlockPos.above(), Blocks.AIR.defaultBlockState(), 3);
	}

	@Override
	public void setPlacedBy(Level pLevel, BlockPos pBlockPos, BlockState pBlockState, @Nullable LivingEntity pLivingEntity, ItemStack pItemStack) {
		pLevel.setBlock(pBlockPos, pBlockState.setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER), 3);
		pLevel.setBlock(pBlockPos.above(), pBlockState.setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER), 3);
	}

	public void sounds(BlockPos pBlockPos, Level pLevel, RandomSource pRandomSource) {
		if (IcariaConfig.FIREPLACE_SOUNDS.get() && pRandomSource.nextDouble() < 0.1D) {
			pLevel.playLocalSound(pBlockPos, SoundEvents.FIRE_AMBIENT, SoundSource.BLOCKS, 1.0F, 1.0F, false);
		}
	}

	public void update(BlockPos pBlockPos, BlockState pBlockState, Level pLevel, boolean pLit) {
		if (pBlockState.getValue(BlockStateProperties.DOUBLE_BLOCK_HALF) == DoubleBlockHalf.LOWER) {
			pLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(BlockStateProperties.LIT, pLit).setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER));
			pLevel.setBlockAndUpdate(pBlockPos.above(), pBlockState.setValue(BlockStateProperties.LIT, pLit).setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER));
		} else {
			pLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(BlockStateProperties.LIT, pLit).setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER));
			pLevel.setBlockAndUpdate(pBlockPos.below(), pBlockState.setValue(BlockStateProperties.LIT, pLit).setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER));
		}
	}

	@Nullable
	@Override
	public BlockEntity newBlockEntity(BlockPos pBlockPos, BlockState pBlockState) {
		if (pBlockState.getValue(BlockStateProperties.DOUBLE_BLOCK_HALF) == DoubleBlockHalf.LOWER) {
			return new FireplaceBlockEntity(pBlockPos, pBlockState);
		} else {
			return null;
		}
	}

	public static BlockPos getBlockEntityPosition(BlockPos pBlockPos, BlockState pBlockState) {
		if (pBlockState.getValue(BlockStateProperties.DOUBLE_BLOCK_HALF) == DoubleBlockHalf.LOWER) {
			return pBlockPos;
		} else {
			return pBlockPos.below();
		}
	}

	@Nullable
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pBlockPlaceContext) {
		var blockPos = pBlockPlaceContext.getClickedPos();
		var level = pBlockPlaceContext.getLevel();
		if (blockPos.getY() < level.getMaxY() && level.getBlockState(blockPos.above()).canBeReplaced(pBlockPlaceContext)) {
			return this.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, pBlockPlaceContext.getHorizontalDirection().getOpposite());
		} else {
			return null;
		}
	}

	@Override
	public BlockState mirror(BlockState pBlockState, Mirror pMirror) {
		return pBlockState.setValue(BlockStateProperties.HORIZONTAL_FACING, pMirror.mirror(pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)));
	}

	@Override
	public BlockState playerWillDestroy(Level pLevel, BlockPos pBlockPos, BlockState pBlockState, Player pPlayer) {
		this.drop(pBlockPos, pBlockState, pLevel);
		this.removeMultiBlock(FireplaceBlock.getBlockEntityPosition(pBlockPos, pBlockState), pLevel);
		return super.playerWillDestroy(pLevel, pBlockPos, pBlockState, pPlayer);
	}

	@Override
	public BlockState rotate(BlockState pBlockState, Rotation pRotation) {
		return pBlockState.setValue(BlockStateProperties.HORIZONTAL_FACING, pRotation.rotate(pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)));
	}

	@Override
	public InteractionResult useItemOn(ItemStack pItemStack, BlockState pBlockState, Level pLevel, BlockPos pBlockPos, Player pPlayer, InteractionHand pInteractionHand, BlockHitResult pBlockHitResult) {
		if (pItemStack.is(Items.FIRE_CHARGE)) {
			return this.charge(pBlockPos, pBlockState, pItemStack, pLevel, pPlayer);
		} else if (pItemStack.is(Items.FLINT_AND_STEEL)) {
			return this.flintAndSteel(pBlockPos, pBlockState, pItemStack, pLevel, pPlayer);
		} else if (pItemStack.is(ItemTags.SHOVELS)) {
			return this.shovel(pBlockPos, pBlockState, pItemStack, pLevel, pPlayer);
		} else {
			return this.ingredient(pBlockPos, pBlockState, pItemStack, pLevel, pPlayer);
		}
	}

	public InteractionResult ingredient(BlockPos pBlockPos, BlockState pBlockState, ItemStack pItemStack, Level pLevel, Player pPlayer) {
		if (pLevel instanceof ServerLevel serverLevel) {
			var singleRecipeInput = new SingleRecipeInput(pItemStack);
			var cachedCheck = RecipeManager.createCheck(IcariaRecipeTypes.GRILLING.get());
			var optional = cachedCheck.getRecipeFor(singleRecipeInput, serverLevel).map(recipeHolder -> recipeHolder.value().ingredient());
			return this.ingredient(pBlockPos, pBlockState, pItemStack, pLevel, pPlayer, optional);
		} else {
			return InteractionResult.TRY_WITH_EMPTY_HAND;
		}
	}

	public InteractionResult ingredient(BlockPos pBlockPos, BlockState pBlockState, ItemStack pItemStack, Level pLevel, Player pPlayer, Optional<Ingredient> pOptional) {
		if (pBlockState.getValue(BlockStateProperties.DOUBLE_BLOCK_HALF) == DoubleBlockHalf.UPPER && pLevel.getBlockEntity(FireplaceBlock.getBlockEntityPosition(pBlockPos, pBlockState)) instanceof FireplaceBlockEntity blockEntity && blockEntity.getInput().isEmpty() && pOptional.isPresent() && pOptional.get().test(pItemStack)) {
			var itemStack = new ItemStack(pItemStack.getItem());
			blockEntity.setStackInSlot(itemStack);
			pPlayer.awardStat(Stats.ITEM_USED.get(pItemStack.getItem()));
			pItemStack.consume(1, pPlayer);
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.TRY_WITH_EMPTY_HAND;
		}
	}

	public InteractionResult charge(BlockPos pBlockPos, BlockState pBlockState, ItemStack pItemStack, Level pLevel, Player pPlayer) {
		if (!pBlockState.getValue(BlockStateProperties.LIT)) {
			pLevel.playSound(null, pBlockPos, SoundEvents.FIRECHARGE_USE, SoundSource.BLOCKS, 1.0F, 1.0F);
			pPlayer.awardStat(Stats.ITEM_USED.get(pItemStack.getItem()));
			pItemStack.consume(1, pPlayer);
			this.update(pBlockPos, pBlockState, pLevel, true);
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.TRY_WITH_EMPTY_HAND;
		}
	}

	public InteractionResult flintAndSteel(BlockPos pBlockPos, BlockState pBlockState, ItemStack pItemStack, Level pLevel, Player pPlayer) {
		if (!pBlockState.getValue(BlockStateProperties.LIT)) {
			pLevel.playSound(null, pBlockPos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 1.0F, 1.0F);
			pPlayer.awardStat(Stats.ITEM_USED.get(pItemStack.getItem()));
			pItemStack.hurtAndBreak(1, pPlayer, LivingEntity.getSlotForHand(pPlayer.getUsedItemHand()));
			this.update(pBlockPos, pBlockState, pLevel, true);
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.TRY_WITH_EMPTY_HAND;
		}
	}

	public InteractionResult shovel(BlockPos pBlockPos, BlockState pBlockState, ItemStack pItemStack, Level pLevel, Player pPlayer) {
		if (pBlockState.getValue(BlockStateProperties.LIT)) {
			pLevel.playSound(null, pBlockPos, SoundEvents.FIRE_EXTINGUISH, SoundSource.BLOCKS, 1.0F, 1.0F);
			pPlayer.awardStat(Stats.ITEM_USED.get(pItemStack.getItem()));
			pItemStack.hurtAndBreak(1, pPlayer, LivingEntity.getSlotForHand(pPlayer.getUsedItemHand()));
			this.update(pBlockPos, pBlockState, pLevel, false);
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.TRY_WITH_EMPTY_HAND;
		}
	}

	@Override
	public MapCodec<? extends BaseEntityBlock> codec() {
		return FireplaceBlock.CODEC;
	}

	@Nullable
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pBlockState, BlockEntityType<T> pBlockEntityType) {
		return pLevel instanceof ServerLevel serverlevel ? BaseEntityBlock.createTickerHelper(pBlockEntityType, IcariaBlockEntityTypes.FIREPLACE.get(), (level, blockPos, blockState, blockEntity) -> FireplaceBlockEntity.tick(blockEntity, blockPos, blockState, serverlevel)) : null;
	}
}

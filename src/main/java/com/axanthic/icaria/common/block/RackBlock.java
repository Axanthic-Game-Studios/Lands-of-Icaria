package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.entity.IcariaBarrelEntity;
import com.axanthic.icaria.common.helper.IcariaCommonHelper;
import com.axanthic.icaria.common.registry.*;
import com.axanthic.icaria.common.shapes.LayerShapes;
import com.axanthic.icaria.data.provider.tags.IcariaBlockTagsProvider;
import com.axanthic.icaria.data.registry.IcariaLootTables;

import java.util.List;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class RackBlock extends Block implements MediterraneanWaterloggedBlock, SimpleWaterloggedBlock {
	public RackBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.stateDefinition.any().setValue(IcariaBlockStateProperties.FULL_RACK, false).setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(IcariaBlockStateProperties.LOADED_BARREL, false).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, false).setValue(IcariaBlockStateProperties.TAPPED_BARREL, false).setValue(BlockStateProperties.WATERLOGGED, false));
	}

	@Override
	public boolean hasAnalogOutputSignal(BlockState pBlockState) {
		return true;
	}

	@Override
	public int getAnalogOutputSignal(BlockState pBlockState, Level pLevel, BlockPos pBlockPos) {
		return pBlockState.getValue(IcariaBlockStateProperties.FULL_RACK) ? 15 : 0;
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(IcariaBlockStateProperties.FULL_RACK, BlockStateProperties.HORIZONTAL_FACING, IcariaBlockStateProperties.LOADED_BARREL, IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, IcariaBlockStateProperties.TAPPED_BARREL, BlockStateProperties.WATERLOGGED);
	}

	@Override
	public void onBlockExploded(BlockState pBlockState, ServerLevel pServerLevel, BlockPos pBlockPos, Explosion pExplosion) {
		super.onBlockExploded(pBlockState, pServerLevel, pBlockPos, pExplosion);
		IcariaCommonHelper.loadedOrTappedRack(pBlockPos, pBlockState, pServerLevel);
	}

	@Override
	public void onProjectileHit(Level pLevel, BlockState pBlockState, BlockHitResult pBlockHitResult, Projectile pProjectile) {
		if (!pLevel.isClientSide() && pProjectile.isOnFire() && pBlockState.getValue(IcariaBlockStateProperties.LOADED_BARREL)) {
			IcariaCommonHelper.loaded(pBlockHitResult.getBlockPos(), null, Level.ExplosionInteraction.BLOCK, pLevel, 2, 10);
		}
	}

	@Override
	public void playerDestroy(Level pLevel, Player pPlayer, BlockPos pBlockPos, BlockState pBlockState, @Nullable BlockEntity pBlockEntity, ItemStack pItemStack) {
		super.playerDestroy(pLevel, pPlayer, pBlockPos, pBlockState, pBlockEntity, pItemStack);
		IcariaCommonHelper.loadedOrTappedRack(pBlockPos, pBlockState, pLevel);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pBlockPlaceContext) {
		var fluid = pBlockPlaceContext.getLevel().getFluidState(pBlockPlaceContext.getClickedPos()).getType();
		return this.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, pBlockPlaceContext.getHorizontalDirection().getOpposite()).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, fluid == IcariaFluids.MEDITERRANEAN_WATER.get()).setValue(BlockStateProperties.WATERLOGGED, fluid == Fluids.WATER);
	}

	@Override
	public BlockState mirror(BlockState pBlockState, Mirror pMirror) {
		return pBlockState.setValue(BlockStateProperties.HORIZONTAL_FACING, pMirror.mirror(pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)));
	}

	@Override
	public BlockState rotate(BlockState pBlockState, Rotation pRotation) {
		return pBlockState.setValue(BlockStateProperties.HORIZONTAL_FACING, pRotation.rotate(pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)));
	}

	@Override
	public FluidState getFluidState(BlockState pBlockState) {
		return pBlockState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED) ? IcariaFluids.MEDITERRANEAN_WATER.get().getSource(false) : pBlockState.getValue(BlockStateProperties.WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pBlockState);
	}

	@Override
	public InteractionResult useItemOn(ItemStack pItemStack, BlockState pBlockState, Level pLevel, BlockPos pBlockPos, Player pPlayer, InteractionHand pInteractionHand, BlockHitResult pBlockHitResult) {
		if (Block.byItem(pItemStack.getItem()) instanceof IcariaBarrelBlock block && block.woodType() == this.woodType() && !pBlockState.getValue(IcariaBlockStateProperties.FULL_RACK)) {
			var blockState = block.defaultBlockState();
			pLevel.playSound(null, pBlockPos, SoundEvents.WOOD_PLACE, SoundSource.BLOCKS);
			pLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.FULL_RACK, true).setValue(IcariaBlockStateProperties.LOADED_BARREL, blockState.is(IcariaBlockTagsProvider.BARRELS_LOADED)).setValue(IcariaBlockStateProperties.TAPPED_BARREL, blockState.is(IcariaBlockTagsProvider.BARRELS_TAPPED)));
			pItemStack.consume(1, pPlayer);
			return InteractionResult.SUCCESS;
		} else if (!pLevel.isClientSide() && pItemStack.is(Items.FIRE_CHARGE) && pBlockState.getValue(IcariaBlockStateProperties.LOADED_BARREL)) {
			IcariaCommonHelper.loaded(pBlockPos, null, Level.ExplosionInteraction.BLOCK, pLevel, 2, 10);
			pPlayer.awardStat(Stats.ITEM_USED.get(pItemStack.getItem()));
			pItemStack.consume(1, pPlayer);
			return InteractionResult.SUCCESS;
		} else if (!pLevel.isClientSide() && pItemStack.is(Items.FLINT_AND_STEEL) && pBlockState.getValue(IcariaBlockStateProperties.LOADED_BARREL)) {
			IcariaCommonHelper.loaded(pBlockPos, null, Level.ExplosionInteraction.BLOCK, pLevel, 2, 10);
			pPlayer.awardStat(Stats.ITEM_USED.get(pItemStack.getItem()));
			pItemStack.hurtAndBreak(1, pPlayer, LivingEntity.getSlotForHand(pInteractionHand));
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.TRY_WITH_EMPTY_HAND;
		}
	}

	@Override
	public InteractionResult useWithoutItem(BlockState pBlockState, Level pLevel, BlockPos pBlockPos, Player pPlayer, BlockHitResult pBlockHitResult) {
		if (pLevel.isClientSide() || !pPlayer.getMainHandItem().isEmpty() || !pPlayer.getOffhandItem().isEmpty() || pPlayer.isPassenger() || pPlayer.isVehicle() || !pBlockState.getValue(IcariaBlockStateProperties.FULL_RACK)) {
			return InteractionResult.FAIL;
		} else {
			var entity = new IcariaBarrelEntity(IcariaEntityTypes.BARREL.get(), pLevel, pBlockState, pBlockPos);
			entity.moveTo(pPlayer.blockPosition(), 0, 0);
			entity.startRiding(pPlayer);
			pLevel.addFreshEntity(entity); // TODO not working as of 1.21.2
			pLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.FULL_RACK, false).setValue(IcariaBlockStateProperties.LOADED_BARREL, false).setValue(IcariaBlockStateProperties.TAPPED_BARREL, false));
			pPlayer.displayClientMessage(Component.translatable("message" + "." + IcariaIdents.ID + "." + "barrel"), true);
			return InteractionResult.PASS;
		}
	}

	@Override
	public List<ItemStack> getDrops(BlockState pBlockState, LootParams.Builder pBuilder) {
		var lootParams = pBuilder.withParameter(LootContextParams.BLOCK_STATE, pBlockState).create(LootContextParamSets.BLOCK);
		return pBlockState.getValue(IcariaBlockStateProperties.FULL_RACK) ? pBlockState.getValue(IcariaBlockStateProperties.LOADED_BARREL) || pBlockState.getValue(IcariaBlockStateProperties.TAPPED_BARREL) ? List.of() : lootParams.getLevel().getServer().reloadableRegistries().getLootTable(IcariaLootTables.BARREL_LOOT).getRandomItems(lootParams) : List.of(new ItemStack(this));
	}

	@Override
	public SoundType getSoundType(BlockState pBlockState, LevelReader pLevelReader, BlockPos pBlockPos, @Nullable Entity pEntity) {
		return pBlockState.getValue(IcariaBlockStateProperties.FULL_RACK) ? IcariaSoundTypes.BARREL : super.getSoundType(pBlockState, pLevelReader, pBlockPos, pEntity);
	}

	@Override
	public VoxelShape getBlockSupportShape(BlockState pBlockState, BlockGetter pLevel, BlockPos pPos) {
		return Shapes.empty();
	}

	@Override
	public VoxelShape getShape(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos, CollisionContext pCollisionContext) {
		return pBlockState.getValue(IcariaBlockStateProperties.FULL_RACK) ? Shapes.block() : LayerShapes.Y_04;
	}

	public WoodType woodType() {
		if (this.defaultBlockState().is(IcariaBlockTagsProvider.RACKS_CYPRESS)) {
			return IcariaWoodTypes.CYPRESS;
		} else if (this.defaultBlockState().is(IcariaBlockTagsProvider.RACKS_DROUGHTROOT)) {
			return IcariaWoodTypes.DROUGHTROOT;
		} else if (this.defaultBlockState().is(IcariaBlockTagsProvider.RACKS_FIR)) {
			return IcariaWoodTypes.FIR;
		} else if (this.defaultBlockState().is(IcariaBlockTagsProvider.RACKS_LAUREL)) {
			return IcariaWoodTypes.LAUREL;
		} else if (this.defaultBlockState().is(IcariaBlockTagsProvider.RACKS_OLIVE)) {
			return IcariaWoodTypes.OLIVE;
		} else if (this.defaultBlockState().is(IcariaBlockTagsProvider.RACKS_PLANE)) {
			return IcariaWoodTypes.PLANE;
		} else {
			return IcariaWoodTypes.POPULUS;
		}
	}
}

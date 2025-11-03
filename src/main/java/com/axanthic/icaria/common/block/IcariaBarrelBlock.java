package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.entity.IcariaBarrelEntity;
import com.axanthic.icaria.common.helper.IcariaCommonHelper;
import com.axanthic.icaria.common.packet.LootVasePacket;
import com.axanthic.icaria.common.registry.*;
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
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
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
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import net.neoforged.neoforge.network.PacketDistributor;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaBarrelBlock extends Block implements MediterraneanWaterloggedBlock, SimpleWaterloggedBlock {
	public IcariaBarrelBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.getStateDefinition().any().setValue(IcariaBlockStateProperties.BARREL_FACING, Direction.NORTH).setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, false).setValue(BlockStateProperties.WATERLOGGED, false));
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(IcariaBlockStateProperties.BARREL_FACING, BlockStateProperties.HORIZONTAL_FACING, IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, BlockStateProperties.WATERLOGGED);
	}

	@Override
	public void onBlockExploded(BlockState pBlockState, ServerLevel pServerLevel, BlockPos pBlockPos, Explosion pExplosion) {
		super.onBlockExploded(pBlockState, pServerLevel, pBlockPos, pExplosion);
		IcariaCommonHelper.loadedOrTappedBarrel(pBlockPos, pBlockState, pServerLevel);
	}

	@Override
	public void onPlace(BlockState pBlockStateNew, Level pLevel, BlockPos pBlockPos, BlockState pBlockStateOld, boolean pMovedByPiston) {
		pLevel.scheduleTick(pBlockPos, this, 0);
	}

	@Override
	public void onProjectileHit(Level pLevel, BlockState pBlockState, BlockHitResult pBlockHitResult, Projectile pProjectile) {
		if (!pLevel.isClientSide() && pProjectile.isOnFire() && pBlockState.is(IcariaBlockTagsProvider.BARRELS_LOADED)) {
			IcariaCommonHelper.loaded(pBlockHitResult.getBlockPos(), null, Level.ExplosionInteraction.BLOCK, pLevel, 2, 10);
		}
	}

	@Override
	public void playerDestroy(Level pLevel, Player pPlayer, BlockPos pBlockPos, BlockState pBlockState, @Nullable BlockEntity pBlockEntity, ItemStack pItemStack) {
		super.playerDestroy(pLevel, pPlayer, pBlockPos, pBlockState, pBlockEntity, pItemStack);
		IcariaCommonHelper.loadedOrTappedBarrel(pBlockPos, pBlockState, pLevel);
	}

	@Override
	public void tick(BlockState pBlockState, ServerLevel pServerLevel, BlockPos pBlockPos, RandomSource pRandomSource) {
		if (pServerLevel.getBlockState(pBlockPos.below()).canBeReplaced()) {
			var entity = new IcariaBarrelEntity(IcariaEntityTypes.BARREL.get(), pServerLevel, pBlockState, pBlockPos);
			entity.snapTo(pBlockPos, 0, 0);
			pServerLevel.addFreshEntity(entity);
			pServerLevel.removeBlock(pBlockPos, false);
		}
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pBlockPlaceContext) {
		var fluid = pBlockPlaceContext.getLevel().getFluidState(pBlockPlaceContext.getClickedPos()).getType();
		var horizontalDirection = pBlockPlaceContext.getHorizontalDirection();
		var nearestLookingDirection = pBlockPlaceContext.getNearestLookingDirection();
		return nearestLookingDirection == Direction.UP ? this.defaultBlockState().setValue(IcariaBlockStateProperties.BARREL_FACING, Direction.UP).setValue(BlockStateProperties.HORIZONTAL_FACING, horizontalDirection.getOpposite()).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, fluid == IcariaFluids.MEDITERRANEAN_WATER.get()).setValue(BlockStateProperties.WATERLOGGED, fluid == Fluids.WATER) : this.defaultBlockState().setValue(IcariaBlockStateProperties.BARREL_FACING, nearestLookingDirection.getOpposite()).setValue(BlockStateProperties.HORIZONTAL_FACING, horizontalDirection.getOpposite()).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, fluid == IcariaFluids.MEDITERRANEAN_WATER.get()).setValue(BlockStateProperties.WATERLOGGED, fluid == Fluids.WATER);
	}

	@Override
	public BlockState mirror(BlockState pBlockState, Mirror pMirror) {
		return pBlockState.setValue(IcariaBlockStateProperties.BARREL_FACING, pMirror.mirror(pBlockState.getValue(IcariaBlockStateProperties.BARREL_FACING))).setValue(BlockStateProperties.HORIZONTAL_FACING, pMirror.mirror(pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)));
	}

	@Override
	public BlockState rotate(BlockState pBlockState, Rotation pRotation) {
		return pBlockState.setValue(IcariaBlockStateProperties.BARREL_FACING, pRotation.rotate(pBlockState.getValue(IcariaBlockStateProperties.BARREL_FACING))).setValue(BlockStateProperties.HORIZONTAL_FACING, pRotation.rotate(pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)));
	}

	@Override
	public BlockState updateShape(BlockState pBlockState, LevelReader pLevelReader, ScheduledTickAccess pScheduledTickAccess, BlockPos pBlockPos, Direction pDirection, BlockPos pBlockPosFaced, BlockState pBlockStateFaced, RandomSource pRandomSource) {
		pScheduledTickAccess.scheduleTick(pBlockPos, this, 0);
		return super.updateShape(pBlockState, pLevelReader, pScheduledTickAccess, pBlockPos, pDirection, pBlockPosFaced, pBlockStateFaced, pRandomSource);
	}

	@Override
	public FluidState getFluidState(BlockState pBlockState) {
		return pBlockState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED) ? IcariaFluids.MEDITERRANEAN_WATER.get().getSource(false) : pBlockState.getValue(BlockStateProperties.WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pBlockState);
	}

	@Override
	public InteractionResult useItemOn(ItemStack pItemStack, BlockState pBlockState, Level pLevel, BlockPos pBlockPos, Player pPlayer, InteractionHand pInteractionHand, BlockHitResult pBlockHitResult) {
		if (!pLevel.isClientSide() && pBlockState.is(IcariaBlockTagsProvider.BARRELS_LOADED) && pItemStack.is(Items.FIRE_CHARGE)) {
			IcariaCommonHelper.loaded(pBlockPos, null, Level.ExplosionInteraction.BLOCK, pLevel, 2, 10);
			pPlayer.awardStat(Stats.ITEM_USED.get(pItemStack.getItem()));
			pItemStack.consume(1, pPlayer);
			return InteractionResult.SUCCESS;
		} else if (!pLevel.isClientSide() && pBlockState.is(IcariaBlockTagsProvider.BARRELS_LOADED) && pItemStack.is(Items.FLINT_AND_STEEL)) {
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
		if (pLevel.isClientSide() || !pPlayer.getMainHandItem().isEmpty() || !pPlayer.getOffhandItem().isEmpty() || pPlayer.getData(IcariaAttachmentTypes.LOOT_VASE) || IcariaCommonHelper.canCarry(pPlayer)) {
			return InteractionResult.FAIL;
		} else {
			pLevel.removeBlock(pBlockPos, false);
			pPlayer.displayClientMessage(Component.translatable("message" + "." + IcariaIdents.ID + "." + "barrel"), true);
			pPlayer.setData(IcariaAttachmentTypes.LOOT_VASE, true);
			pPlayer.setData(IcariaAttachmentTypes.LOOT_VASE_BLOCK_POS, pBlockPos);
			pPlayer.setData(IcariaAttachmentTypes.LOOT_VASE_BLOCK_STATE, pBlockState);
			PacketDistributor.sendToAllPlayers(new LootVasePacket(true, pPlayer.getId(), pBlockPos, pBlockState));
			return InteractionResult.PASS;
		}
	}

	@Override
	public List<ItemStack> getDrops(BlockState pBlockState, LootParams.Builder pBuilder) {
		var lootParams = pBuilder.withParameter(LootContextParams.BLOCK_STATE, pBlockState).create(LootContextParamSets.BLOCK);
		return pBlockState.is(IcariaBlockTagsProvider.BARRELS_LOADED) || pBlockState.is(IcariaBlockTagsProvider.BARRELS_TAPPED) ? List.of() : lootParams.getLevel().getServer().reloadableRegistries().getLootTable(IcariaLootTables.BARREL).getRandomItems(lootParams);
	}

	@Override
	public VoxelShape getBlockSupportShape(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos) {
		return Shapes.empty();
	}

	public WoodType woodType() {
		if (this.defaultBlockState().is(IcariaBlockTagsProvider.BARRELS_CYPRESS)) {
			return IcariaWoodTypes.CYPRESS;
		} else if (this.defaultBlockState().is(IcariaBlockTagsProvider.BARRELS_DROUGHTROOT)) {
			return IcariaWoodTypes.DROUGHTROOT;
		} else if (this.defaultBlockState().is(IcariaBlockTagsProvider.BARRELS_FIR)) {
			return IcariaWoodTypes.FIR;
		} else if (this.defaultBlockState().is(IcariaBlockTagsProvider.BARRELS_LAUREL)) {
			return IcariaWoodTypes.LAUREL;
		} else if (this.defaultBlockState().is(IcariaBlockTagsProvider.BARRELS_OLIVE)) {
			return IcariaWoodTypes.OLIVE;
		} else if (this.defaultBlockState().is(IcariaBlockTagsProvider.BARRELS_PLANE)) {
			return IcariaWoodTypes.PLANE;
		} else {
			return IcariaWoodTypes.POPULUS;
		}
	}
}

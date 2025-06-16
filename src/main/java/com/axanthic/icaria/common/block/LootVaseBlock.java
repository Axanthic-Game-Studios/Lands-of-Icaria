package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.entity.LootVaseEntity;
import com.axanthic.icaria.common.helper.IcariaCommonHelper;
import com.axanthic.icaria.common.network.packet.LootVasePacket;
import com.axanthic.icaria.common.registry.*;
import com.axanthic.icaria.data.registry.IcariaLootTables;

import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
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

public class LootVaseBlock extends Block implements MediterraneanWaterloggedBlock, SimpleWaterloggedBlock {
	public LootVaseBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.stateDefinition.any().setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, false).setValue(BlockStateProperties.WATERLOGGED, false));
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, BlockStateProperties.WATERLOGGED);
	}

	@Override
	public void onPlace(BlockState pBlockStateNew, Level pLevel, BlockPos pBlockPos, BlockState pBlockStateOld, boolean pMovedByPiston) {
		pLevel.scheduleTick(pBlockPos, this, 0);
	}

	@Override
	public void onProjectileHit(Level pLevel, BlockState pBlockState, BlockHitResult pBlockHitResult, Projectile pProjectile) {
		var blockPos = pBlockHitResult.getBlockPos();
		if (pLevel instanceof ServerLevel serverLevel && pProjectile.mayBreak(serverLevel) && pProjectile.mayInteract(serverLevel, blockPos)) {
			pLevel.destroyBlock(blockPos, true, pProjectile);
		}
	}

	@Override
	public void tick(BlockState pBlockState, ServerLevel pServerLevel, BlockPos pBlockPos, RandomSource pRandomSource) {
		var entity = new LootVaseEntity(IcariaEntityTypes.LOOT_VASE.get(), pServerLevel, pBlockState, pBlockPos);
		if (pServerLevel.getBlockState(pBlockPos.below()).canBeReplaced()) {
			entity.snapTo(pBlockPos, 0, 0);
			pServerLevel.addFreshEntity(entity);
			pServerLevel.removeBlock(pBlockPos, false);
		}
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pBlockPlaceContext) {
		var fluid = pBlockPlaceContext.getLevel().getFluidState(pBlockPlaceContext.getClickedPos()).getType();
		return this.defaultBlockState().setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, fluid == IcariaFluids.MEDITERRANEAN_WATER.get()).setValue(BlockStateProperties.WATERLOGGED, fluid == Fluids.WATER);
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
	public InteractionResult useWithoutItem(BlockState pBlockState, Level pLevel, BlockPos pBlockPos, Player pPlayer, BlockHitResult pBlockHitResult) {
		if (pLevel.isClientSide() || !pPlayer.getMainHandItem().isEmpty() || !pPlayer.getOffhandItem().isEmpty() || pPlayer.getData(IcariaAttachmentTypes.LOOT_VASE) || IcariaCommonHelper.canCarry(pPlayer)) {
			return InteractionResult.FAIL;
		} else {
			pLevel.removeBlock(pBlockPos, false);
			pPlayer.displayClientMessage(Component.translatable("message" + "." + IcariaIdents.ID + "." + "loot_vase"), true);
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
		var lootTable = pBlockState.is(IcariaBlocks.RED_LOOT_VASE.get()) ? IcariaLootTables.RED_LOOT_VASE : pBlockState.is(IcariaBlocks.LOST_LOOT_VASE.get()) ? IcariaLootTables.LOST_LOOT_VASE : IcariaLootTables.CYAN_LOOT_VASE;
		return lootParams.getLevel().getServer().reloadableRegistries().getLootTable(lootTable).getRandomItems(lootParams);
	}

	@Override
	public VoxelShape getBlockSupportShape(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos) {
		return Shapes.empty();
	}
}

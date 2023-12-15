package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.properties.Corner;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.List;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class TripleBarrelRackBlock extends Block {
    public TripleBarrelRackBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(IcariaBlockStateProperties.CORNER, Corner.BOTTOM_FRONT_LEFT).setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH));
    }

    @Override
    public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(IcariaBlockStateProperties.CORNER, BlockStateProperties.HORIZONTAL_FACING);
    }

    @Override
    public void onBlockExploded(BlockState pState, Level pLevel, BlockPos pPos, Explosion pExplosion) {
        var blockPos = TripleBarrelRackBlock.getPlacedBlockPosition(pState, pPos);
        var facing = pState.getValue(BlockStateProperties.HORIZONTAL_FACING);
        pLevel.setBlock(blockPos, Blocks.AIR.defaultBlockState(), 3);
        pLevel.setBlock(blockPos.offset(facing.getCounterClockWise().getNormal()), Blocks.AIR.defaultBlockState(), 3);
        pLevel.setBlock(blockPos.above(), Blocks.AIR.defaultBlockState(), 3);
        pLevel.setBlock(blockPos.above().offset(facing.getCounterClockWise().getNormal()), Blocks.AIR.defaultBlockState(), 3);
        super.onBlockExploded(pState, pLevel, pPos, pExplosion);
    }

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pMovedByPiston) {
        if (pState.getBlock() != pNewState.getBlock()) {
            if (pState.getValue(IcariaBlockStateProperties.CORNER) == Corner.BOTTOM_FRONT_LEFT) {
                Block.dropResources(pState, pLevel, pPos);
            }
        }

        super.onRemove(pState, pLevel, pPos, pNewState, pMovedByPiston);
    }

    @Override
    public void playerWillDestroy(Level pLevel, BlockPos pPos, BlockState pState, Player pPlayer) {
        var blockPos = TripleBarrelRackBlock.getPlacedBlockPosition(pState, pPos);
        var facing = pState.getValue(BlockStateProperties.HORIZONTAL_FACING);
        pLevel.setBlock(blockPos, Blocks.AIR.defaultBlockState(), 3);
        pLevel.setBlock(blockPos.offset(facing.getCounterClockWise().getNormal()), Blocks.AIR.defaultBlockState(), 3);
        pLevel.setBlock(blockPos.above(), Blocks.AIR.defaultBlockState(), 3);
        pLevel.setBlock(blockPos.above().offset(facing.getCounterClockWise().getNormal()), Blocks.AIR.defaultBlockState(), 3);
        super.playerWillDestroy(pLevel, pPos, pState, pPlayer);
    }

    @Override
    public void setPlacedBy(Level pLevel, BlockPos pPos, BlockState pState, @Nullable LivingEntity pPlacer, ItemStack pStack) {
        var facing = pState.getValue(BlockStateProperties.HORIZONTAL_FACING);
        pLevel.setBlock(pPos.offset(facing.getCounterClockWise().getNormal()), pState.setValue(IcariaBlockStateProperties.CORNER, Corner.BOTTOM_FRONT_RIGHT), 3);
        pLevel.setBlock(pPos.above(), pState.setValue(IcariaBlockStateProperties.CORNER, Corner.TOP_FRONT_LEFT), 3);
        pLevel.setBlock(pPos.above().offset(facing.getCounterClockWise().getNormal()), pState.setValue(IcariaBlockStateProperties.CORNER, Corner.TOP_FRONT_RIGHT), 3);
    }

    public static BlockPos getPlacedBlockPosition(BlockState pState, BlockPos pPos) {
        var facing = pState.getValue(BlockStateProperties.HORIZONTAL_FACING);
        if (pState.getValue(IcariaBlockStateProperties.CORNER) == Corner.TOP_FRONT_RIGHT) {
            return pPos.below().offset(facing.getClockWise().getNormal());
        } else if (pState.getValue(IcariaBlockStateProperties.CORNER) == Corner.TOP_FRONT_LEFT) {
            return pPos.below();
        } else if (pState.getValue(IcariaBlockStateProperties.CORNER) == Corner.BOTTOM_FRONT_RIGHT) {
            return pPos.offset(facing.getClockWise().getNormal());
        } else {
            return pPos;
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        var blockPos = pContext.getClickedPos();
        var facing = pContext.getHorizontalDirection().getOpposite();
        var level = pContext.getLevel();
        if (blockPos.getY() < level.getMaxBuildHeight() - 1 && level.getBlockState(blockPos.offset(facing.getCounterClockWise().getNormal())).canBeReplaced(pContext) && level.getBlockState(blockPos.above()).canBeReplaced(pContext) && level.getBlockState(blockPos.above().offset(facing.getCounterClockWise().getNormal())).canBeReplaced(pContext)) {
            return this.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, pContext.getHorizontalDirection().getOpposite());
        } else {
            return null;
        }
    }

    @Override
    public VoxelShape getBlockSupportShape(BlockState pState, BlockGetter pReader, BlockPos pPos) {
        return Shapes.empty();
    }

    @Override
    public List<ItemStack> getDrops(BlockState pState, LootParams.Builder pBuilder) {
        var lootContext = pBuilder.withParameter(LootContextParams.BLOCK_STATE, pState).create(LootContextParamSets.BLOCK);
        return lootContext.getLevel().getServer().getLootData().getLootTable(IcariaResourceLocations.BARREL).getRandomItems(lootContext);
    }
}

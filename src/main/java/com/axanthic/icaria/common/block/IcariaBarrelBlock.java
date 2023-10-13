package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.entity.IcariaBarrelEntity;
import com.axanthic.icaria.common.registry.*;
import com.axanthic.icaria.common.util.IcariaInfo;
import com.axanthic.icaria.data.loot.IcariaBarrelLoot;
import com.axanthic.icaria.data.tags.IcariaBlockTags;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
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

import java.util.List;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaBarrelBlock extends Block implements MediterraneanWaterloggedBlock, SimpleWaterloggedBlock {
    public IcariaBarrelBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(IcariaBlockStateProperties.BARREL_FACING, Direction.NORTH).setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, false).setValue(BlockStateProperties.WATERLOGGED, false));
    }

    @Override
    public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(IcariaBlockStateProperties.BARREL_FACING, BlockStateProperties.HORIZONTAL_FACING, IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, BlockStateProperties.WATERLOGGED);
    }

    @Override
    public void onBlockExploded(BlockState pState, Level pLevel, BlockPos pPos, Explosion pExplosion) {
        if (!pLevel.isClientSide()) {
            if (pState.is(IcariaBlockTags.LOADED_BARRELS)) {
                pExplosion.explode();
                for (int i = -2; i <= 2; i++) {
                    var negPos = BlockPos.containing(pPos.getX() - i, pPos.getY() - i, pPos.getZ() - i);
                    var posPos = BlockPos.containing(pPos.getX() + i, pPos.getY() + i, pPos.getZ() + i);
                    for (var blockPos : BlockPos.betweenClosed(negPos, posPos)) {
                        if (pLevel.random.nextInt(10) == 0) {
                            if (pLevel.getBlockState(blockPos).isAir()) {
                                if (pLevel.getBlockState(blockPos.below()).isSolidRender(pLevel, blockPos.below())) {
                                    pLevel.setBlockAndUpdate(blockPos, IcariaBlocks.GREEK_FIRE.get().defaultBlockState());
                                }
                            }
                        }
                    }
                }
            } else if (pState.is(IcariaBlockTags.TAPPED_BARRELS)) {
                for (int i = -1; i <= 1; i++) {
                    var negPos = BlockPos.containing(pPos.getX() - i, pPos.getY() - i, pPos.getZ() - i);
                    var posPos = BlockPos.containing(pPos.getX() + i, pPos.getY() + i, pPos.getZ() + i);
                    for (var blockPos : BlockPos.betweenClosed(negPos, posPos)) {
                        if (pLevel.random.nextInt(10) == 0) {
                            if (pLevel.getBlockState(blockPos).isAir()) {
                                if (pLevel.getBlockState(blockPos.below()).isSolidRender(pLevel, blockPos.below())) {
                                    pLevel.setBlockAndUpdate(blockPos, IcariaBlocks.MEDITERRANEAN_WATER.get().defaultBlockState());
                                }
                            }
                        }
                    }
                }
            }
        }

        super.onBlockExploded(pState, pLevel, pPos, pExplosion);
    }

    @Override
    public void onProjectileHit(Level pLevel, BlockState pState, BlockHitResult pHit, Projectile pProjectile) {
        var pos = pHit.getBlockPos();
        if (!pLevel.isClientSide()) {
            if (pState.is(IcariaBlockTags.LOADED_BARRELS)) {
                if (pProjectile.isOnFire()) {
                    pLevel.explode(null, pos.getX(), pos.getY(), pos.getZ(), 2.0F, false, Level.ExplosionInteraction.BLOCK);
                    for (int i = -2; i <= 2; i++) {
                        var negPos = BlockPos.containing(pos.getX() - i, pos.getY() - i, pos.getZ() - i);
                        var posPos = BlockPos.containing(pos.getX() + i, pos.getY() + i, pos.getZ() + i);
                        for (var blockPos : BlockPos.betweenClosed(negPos, posPos)) {
                            if (pLevel.random.nextInt(10) == 0) {
                                if (pLevel.getBlockState(blockPos).isAir()) {
                                    if (pLevel.getBlockState(blockPos.below()).isSolidRender(pLevel, blockPos.below())) {
                                        pLevel.setBlockAndUpdate(blockPos, IcariaBlocks.GREEK_FIRE.get().defaultBlockState());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public void playerDestroy(Level pLevel, Player pPlayer, BlockPos pPos, BlockState pState, @Nullable BlockEntity pBlockEntity, ItemStack pTool) {
        if (!pLevel.isClientSide()) {
            if (pState.is(IcariaBlockTags.LOADED_BARRELS)) {
                pLevel.explode(null, pPos.getX(), pPos.getY(), pPos.getZ(), 2.0F, false, Level.ExplosionInteraction.BLOCK);
                for (int i = -2; i <= 2; i++) {
                    var negPos = BlockPos.containing(pPos.getX() - i, pPos.getY() - i, pPos.getZ() - i);
                    var posPos = BlockPos.containing(pPos.getX() + i, pPos.getY() + i, pPos.getZ() + i);
                    for (var blockPos : BlockPos.betweenClosed(negPos, posPos)) {
                        if (pLevel.random.nextInt(10) == 0) {
                            if (pLevel.getBlockState(blockPos).isAir()) {
                                if (pLevel.getBlockState(blockPos.below()).isSolidRender(pLevel, blockPos.below())) {
                                    pLevel.setBlockAndUpdate(blockPos, IcariaBlocks.GREEK_FIRE.get().defaultBlockState());
                                }
                            }
                        }
                    }
                }
            } else if (pState.is(IcariaBlockTags.TAPPED_BARRELS)) {
                for (int i = -1; i <= 1; i++) {
                    var negPos = BlockPos.containing(pPos.getX() - i, pPos.getY() - i, pPos.getZ() - i);
                    var posPos = BlockPos.containing(pPos.getX() + i, pPos.getY() + i, pPos.getZ() + i);
                    for (var blockPos : BlockPos.betweenClosed(negPos, posPos)) {
                        if (pLevel.random.nextInt(10) == 0) {
                            if (pLevel.getBlockState(blockPos).isAir()) {
                                if (pLevel.getBlockState(blockPos.below()).isSolidRender(pLevel, blockPos.below())) {
                                    pLevel.setBlockAndUpdate(blockPos, IcariaBlocks.MEDITERRANEAN_WATER.get().defaultBlockState());
                                }
                            }
                        }
                    }
                }
            }
        }

        super.playerDestroy(pLevel, pPlayer, pPos, pState, pBlockEntity, pTool);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        var fluidState = pContext.getLevel().getFluidState(pContext.getClickedPos()).getType();
        var horizontalDirection = pContext.getHorizontalDirection();
        var nearestLookingDirection = pContext.getNearestLookingDirection();
        return nearestLookingDirection.equals(Direction.UP) ? this.defaultBlockState().setValue(IcariaBlockStateProperties.BARREL_FACING, Direction.UP).setValue(BlockStateProperties.HORIZONTAL_FACING, horizontalDirection.getOpposite()).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, fluidState == IcariaFluids.MEDITERRANEAN_WATER.get()).setValue(BlockStateProperties.WATERLOGGED, fluidState == Fluids.WATER) : this.defaultBlockState().setValue(IcariaBlockStateProperties.BARREL_FACING, nearestLookingDirection.getOpposite()).setValue(BlockStateProperties.HORIZONTAL_FACING, horizontalDirection.getOpposite()).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, fluidState == IcariaFluids.MEDITERRANEAN_WATER.get()).setValue(BlockStateProperties.WATERLOGGED, fluidState == Fluids.WATER);
    }

    @Override
    public FluidState getFluidState(BlockState pState) {
        return pState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED) ? IcariaFluids.MEDITERRANEAN_WATER.get().getSource(false) : pState.getValue(BlockStateProperties.WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (pLevel.isClientSide() || !pPlayer.getMainHandItem().isEmpty() || !pPlayer.getOffhandItem().isEmpty() || pPlayer.isPassenger() || pPlayer.isVehicle()) {
            return InteractionResult.FAIL;
        } else {
            var entity = new IcariaBarrelEntity(IcariaEntityTypes.BARREL.get(), pLevel, pState, pPos);
            entity.moveTo(pPlayer.blockPosition(), 0, 0);
            entity.startRiding(pPlayer);
            pLevel.addFreshEntity(entity);
            pLevel.removeBlock(pPos, false);
            pPlayer.displayClientMessage(Component.translatable("message" + "." + IcariaInfo.ID + "." + "barrel"), true);
            return InteractionResult.PASS;
        }
    }

    @Override
    public VoxelShape getBlockSupportShape(BlockState pState, BlockGetter pReader, BlockPos pPos) {
        return Shapes.empty();
    }

    public WoodType getType() {
        if (this.defaultBlockState().is(IcariaBlockTags.CYPRESS_BARRELS)) {
            return IcariaWoodTypes.CYPRESS;
        } else if (this.defaultBlockState().is(IcariaBlockTags.DROUGHTROOT_BARRELS)) {
            return IcariaWoodTypes.DROUGHTROOT;
        } else if (this.defaultBlockState().is(IcariaBlockTags.FIR_BARRELS)) {
            return IcariaWoodTypes.FIR;
        } else if (this.defaultBlockState().is(IcariaBlockTags.LAUREL_BARRELS)) {
            return IcariaWoodTypes.LAUREL;
        } else if (this.defaultBlockState().is(IcariaBlockTags.OLIVE_BARRELS)) {
            return IcariaWoodTypes.OLIVE;
        } else if (this.defaultBlockState().is(IcariaBlockTags.PLANE_BARRELS)) {
            return IcariaWoodTypes.PLANE;
        } else {
            return IcariaWoodTypes.POPULUS;
        }
    }

    @Override
    public List<ItemStack> getDrops(BlockState pState, LootParams.Builder pBuilder) {
        var lootContext = pBuilder.withParameter(LootContextParams.BLOCK_STATE, pState).create(LootContextParamSets.BLOCK);
        return pState.is(IcariaBlockTags.LOADED_BARRELS) || pState.is(IcariaBlockTags.TAPPED_BARRELS) ? List.of() : lootContext.getLevel().getServer().getLootData().getLootTable(IcariaBarrelLoot.BARREL).getRandomItems(lootContext);
    }
}

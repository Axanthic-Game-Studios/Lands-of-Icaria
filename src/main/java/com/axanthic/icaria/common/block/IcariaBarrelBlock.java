package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.entity.IcariaBarrelEntity;
import com.axanthic.icaria.common.registry.*;
import com.axanthic.icaria.common.util.IcariaInfo;
import com.axanthic.icaria.data.tags.IcariaBlockTags;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
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
        var x = pPos.getX();
        var y = pPos.getY();
        var z = pPos.getZ();
        if (!pLevel.isClientSide()) {
            if (pState.is(IcariaBlockTags.LOADED_BARRELS)) {
                pExplosion.explode();
                for (int i = -2; i <= 2; i++) {
                    var negPos = BlockPos.containing(x - i, y - i, z - i);
                    var posPos = BlockPos.containing(x + i, y + i, z + i);
                    for (var blockPos : BlockPos.betweenClosed(negPos, posPos)) {
                        var belowPos = blockPos.below();
                        if (pLevel.getRandom().nextInt(10) == 0) {
                            if (pLevel.getBlockState(blockPos).isAir()) {
                                if (pLevel.getBlockState(belowPos).isSolidRender(pLevel, belowPos)) {
                                    pLevel.setBlockAndUpdate(blockPos, IcariaBlocks.GREEK_FIRE.get().defaultBlockState());
                                }
                            }
                        }
                    }
                }
            } else if (pState.is(IcariaBlockTags.TAPPED_BARRELS)) {
                for (int i = -1; i <= 1; i++) {
                    var negPos = BlockPos.containing(x - i, y - i, z - i);
                    var posPos = BlockPos.containing(x + i, y + i, z + i);
                    for (var blockPos : BlockPos.betweenClosed(negPos, posPos)) {
                        var belowPos = blockPos.below();
                        if (pLevel.getRandom().nextInt(10) == 0) {
                            if (pLevel.getBlockState(blockPos).isAir()) {
                                if (pLevel.getBlockState(belowPos).isSolidRender(pLevel, belowPos)) {
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
        var x = pos.getX();
        var y = pos.getY();
        var z = pos.getZ();
        if (!pLevel.isClientSide()) {
            if (pState.is(IcariaBlockTags.LOADED_BARRELS)) {
                if (pProjectile.isOnFire()) {
                    pLevel.explode(null, x, y, z, 2.0F, Level.ExplosionInteraction.BLOCK);
                    for (int i = -2; i <= 2; i++) {
                        var negPos = BlockPos.containing(x - i, y - i, z - i);
                        var posPos = BlockPos.containing(x + i, y + i, z + i);
                        for (var blockPos : BlockPos.betweenClosed(negPos, posPos)) {
                            var belowPos = blockPos.below();
                            if (pLevel.getRandom().nextInt(10) == 0) {
                                if (pLevel.getBlockState(blockPos).isAir()) {
                                    if (pLevel.getBlockState(belowPos).isSolidRender(pLevel, belowPos)) {
                                        pLevel.setBlockAndUpdate(blockPos, IcariaBlocks.GREEK_FIRE.get().defaultBlockState());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        super.onProjectileHit(pLevel, pState, pHit, pProjectile);
    }

    @Override
    public void playerDestroy(Level pLevel, Player pPlayer, BlockPos pPos, BlockState pState, @Nullable BlockEntity pBlockEntity, ItemStack pTool) {
        var x = pPos.getX();
        var y = pPos.getY();
        var z = pPos.getZ();
        if (!pLevel.isClientSide()) {
            if (pState.is(IcariaBlockTags.LOADED_BARRELS)) {
                pLevel.explode(null, x, y, z, 2.0F, Level.ExplosionInteraction.BLOCK);
                for (int i = -2; i <= 2; i++) {
                    var negPos = BlockPos.containing(x - i, y - i, z - i);
                    var posPos = BlockPos.containing(x + i, y + i, z + i);
                    for (var blockPos : BlockPos.betweenClosed(negPos, posPos)) {
                        var belowPos = blockPos.below();
                        if (pLevel.getRandom().nextInt(10) == 0) {
                            if (pLevel.getBlockState(blockPos).isAir()) {
                                if (pLevel.getBlockState(belowPos).isSolidRender(pLevel, belowPos)) {
                                    pLevel.setBlockAndUpdate(blockPos, IcariaBlocks.GREEK_FIRE.get().defaultBlockState());
                                }
                            }
                        }
                    }
                }
            } else if (pState.is(IcariaBlockTags.TAPPED_BARRELS)) {
                for (int i = -1; i <= 1; i++) {
                    var negPos = BlockPos.containing(x - i, y - i, z - i);
                    var posPos = BlockPos.containing(x + i, y + i, z + i);
                    for (var blockPos : BlockPos.betweenClosed(negPos, posPos)) {
                        var belowPos = blockPos.below();
                        if (pLevel.getRandom().nextInt(10) == 0) {
                            if (pLevel.getBlockState(blockPos).isAir()) {
                                if (pLevel.getBlockState(belowPos).isSolidRender(pLevel, belowPos)) {
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
        var itemStack = pPlayer.getItemInHand(pHand);
        var x = pPos.getX();
        var y = pPos.getY();
        var z = pPos.getZ();
        if (!pLevel.isClientSide()) {
            if (pState.is(IcariaBlockTags.LOADED_BARRELS)) {
                if (itemStack.is(Items.FIRE_CHARGE) || itemStack.is(Items.FLINT_AND_STEEL)) {
                    pLevel.explode(null, x, y, z, 2.0F, Level.ExplosionInteraction.BLOCK);
                    pPlayer.awardStat(Stats.ITEM_USED.get(itemStack.getItem()));
                    if (!pPlayer.isCreative()) {
                        if (itemStack.is(Items.FIRE_CHARGE)) {
                            itemStack.shrink(1);
                        } else {
                            itemStack.hurtAndBreak(1, pPlayer, (player) -> player.broadcastBreakEvent(pHand));
                        }
                    }

                    for (int i = -2; i <= 2; i++) {
                        var negPos = BlockPos.containing(x - i, y - i, z - i);
                        var posPos = BlockPos.containing(x + i, y + i, z + i);
                        for (var blockPos : BlockPos.betweenClosed(negPos, posPos)) {
                            var belowPos = blockPos.below();
                            if (pLevel.getRandom().nextInt(10) == 0) {
                                if (pLevel.getBlockState(blockPos).isAir()) {
                                    if (pLevel.getBlockState(belowPos).isSolidRender(pLevel, belowPos)) {
                                        pLevel.setBlockAndUpdate(blockPos, IcariaBlocks.GREEK_FIRE.get().defaultBlockState());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

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
        return pState.is(IcariaBlockTags.LOADED_BARRELS) || pState.is(IcariaBlockTags.TAPPED_BARRELS) ? List.of() : lootContext.getLevel().getServer().getLootData().getLootTable(IcariaResourceLocations.BARREL).getRandomItems(lootContext);
    }
}

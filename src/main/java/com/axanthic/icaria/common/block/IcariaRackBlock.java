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
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.SoundType;
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

import java.util.List;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaRackBlock extends Block implements MediterraneanWaterloggedBlock, SimpleWaterloggedBlock {
    public static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D);

    public IcariaRackBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(IcariaBlockStateProperties.FULL_RACK, false).setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(IcariaBlockStateProperties.LOADED_BARREL, false).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, false).setValue(IcariaBlockStateProperties.TAPPED_BARREL, false).setValue(BlockStateProperties.WATERLOGGED, false));
    }

    @Override
    public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(IcariaBlockStateProperties.FULL_RACK, BlockStateProperties.HORIZONTAL_FACING, IcariaBlockStateProperties.LOADED_BARREL, IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, IcariaBlockStateProperties.TAPPED_BARREL, BlockStateProperties.WATERLOGGED);
    }

    @Override
    public void onBlockExploded(BlockState pState, Level pLevel, BlockPos pPos, Explosion pExplosion) {
        if (!pLevel.isClientSide()) {
            if (pState.getValue(IcariaBlockStateProperties.LOADED_BARREL)) {
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
            } else if (pState.getValue(IcariaBlockStateProperties.TAPPED_BARREL)) {
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
            if (pState.getValue(IcariaBlockStateProperties.LOADED_BARREL)) {
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
            if (pState.getValue(IcariaBlockStateProperties.LOADED_BARREL)) {
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
            } else if (pState.getValue(IcariaBlockStateProperties.TAPPED_BARREL)) {
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
        return this.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, horizontalDirection.getOpposite()).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, fluidState == IcariaFluids.MEDITERRANEAN_WATER.get()).setValue(BlockStateProperties.WATERLOGGED, fluidState == Fluids.WATER);
    }

    @Override
    public FluidState getFluidState(BlockState pState) {
        return pState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED) ? IcariaFluids.MEDITERRANEAN_WATER.get().getSource(false) : pState.getValue(BlockStateProperties.WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (pState.getValue(IcariaBlockStateProperties.FULL_RACK)) {
            if (pLevel.isClientSide() || !pPlayer.getMainHandItem().isEmpty() || !pPlayer.getOffhandItem().isEmpty() || pPlayer.isPassenger() || pPlayer.isVehicle()) {
                return InteractionResult.FAIL;
            } else {
                var entity = new IcariaBarrelEntity(IcariaEntityTypes.BARREL.get(), pLevel, pState, pPos);
                entity.moveTo(pPlayer.blockPosition(), 0, 0);
                entity.startRiding(pPlayer);
                pLevel.addFreshEntity(entity);
                pLevel.setBlockAndUpdate(pPos, pState.setValue(IcariaBlockStateProperties.FULL_RACK, false).setValue(IcariaBlockStateProperties.LOADED_BARREL, false).setValue(IcariaBlockStateProperties.TAPPED_BARREL, false));
                pPlayer.displayClientMessage(Component.translatable("message" + "." + IcariaInfo.ID + "." + "barrel"), true);
                return InteractionResult.PASS;
            }
        } else {
            var itemStack = pPlayer.getItemInHand(pHand);
            if (Block.byItem(itemStack.getItem()) instanceof IcariaBarrelBlock block) {
                var state = block.defaultBlockState();
                if (this.getType() == block.getType()) {
                    pLevel.playSound(pPlayer, pPos, SoundEvents.WOOD_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);
                    if (!pLevel.isClientSide()) {
                        pLevel.setBlockAndUpdate(pPos, pState.setValue(IcariaBlockStateProperties.FULL_RACK, true).setValue(IcariaBlockStateProperties.LOADED_BARREL, state.is(IcariaBlockTags.LOADED_BARRELS)).setValue(IcariaBlockStateProperties.TAPPED_BARREL, state.is(IcariaBlockTags.TAPPED_BARRELS)));
                        if (!pPlayer.isCreative()) {
                            itemStack.shrink(1);
                        }
                    }
                }

                return InteractionResult.SUCCESS;
            }
        }

        return InteractionResult.FAIL;
    }

    @Override
    public SoundType getSoundType(BlockState pState, LevelReader pLevel, BlockPos pPos, @Nullable Entity pEntity) {
        return pState.getValue(IcariaBlockStateProperties.FULL_RACK) ? IcariaSoundTypes.BARREL : super.getSoundType(pState, pLevel, pPos, pEntity);
    }

    @Override
    public VoxelShape getBlockSupportShape(BlockState pState, BlockGetter pReader, BlockPos pPos) {
        return Shapes.empty();
    }

    @Override
    public VoxelShape getCollisionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return pState.getValue(IcariaBlockStateProperties.FULL_RACK) ? Shapes.block() : IcariaRackBlock.SHAPE;
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return pState.getValue(IcariaBlockStateProperties.FULL_RACK) ? Shapes.block() : IcariaRackBlock.SHAPE;
    }

    @Override
    public VoxelShape getVisualShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return pState.getValue(IcariaBlockStateProperties.FULL_RACK) ? Shapes.block() : IcariaRackBlock.SHAPE;
    }

    public WoodType getType() {
        if (this.defaultBlockState().is(IcariaBlockTags.CYPRESS_RACKS)) {
            return IcariaWoodTypes.CYPRESS;
        } else if (this.defaultBlockState().is(IcariaBlockTags.DROUGHTROOT_RACKS)) {
            return IcariaWoodTypes.DROUGHTROOT;
        } else if (this.defaultBlockState().is(IcariaBlockTags.FIR_RACKS)) {
            return IcariaWoodTypes.FIR;
        } else if (this.defaultBlockState().is(IcariaBlockTags.LAUREL_RACKS)) {
            return IcariaWoodTypes.LAUREL;
        } else if (this.defaultBlockState().is(IcariaBlockTags.OLIVE_RACKS)) {
            return IcariaWoodTypes.OLIVE;
        } else if (this.defaultBlockState().is(IcariaBlockTags.PLANE_RACKS)) {
            return IcariaWoodTypes.PLANE;
        } else {
            return IcariaWoodTypes.POPULUS;
        }
    }

    @Override
    public List<ItemStack> getDrops(BlockState pState, LootParams.Builder pBuilder) {
        var lootContext = pBuilder.withParameter(LootContextParams.BLOCK_STATE, pState).create(LootContextParamSets.BLOCK);
        return pState.getValue(IcariaBlockStateProperties.FULL_RACK) ? pState.getValue(IcariaBlockStateProperties.LOADED_BARREL) || pState.getValue(IcariaBlockStateProperties.TAPPED_BARREL) ? List.of() : lootContext.getLevel().getServer().getLootData().getLootTable(IcariaBarrelLoot.BARREL).getRandomItems(lootContext) : List.of(new ItemStack(this));
    }
}

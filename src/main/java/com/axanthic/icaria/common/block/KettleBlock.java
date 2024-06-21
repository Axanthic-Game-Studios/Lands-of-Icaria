package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.config.IcariaConfig;
import com.axanthic.icaria.common.entity.KettleBlockEntity;
import com.axanthic.icaria.common.properties.Kettle;
import com.axanthic.icaria.common.registry.IcariaBlockEntityTypes;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;
import com.axanthic.icaria.data.tags.IcariaItemTags;

import com.mojang.serialization.MapCodec;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
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
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class KettleBlock extends BaseEntityBlock {
    public static final MapCodec<KettleBlock> CODEC = Block.simpleCodec(KettleBlock::new);

    public static final VoxelShape SHAPE_NORTH = Block.box(0.0D, 0.0D, 7.5D, 16.0D, 14.0D, 16.0D);
    public static final VoxelShape SHAPE_EAST = Block.box(0.0D, 0.0D, 0.0D, 8.5D, 14.0D, 16.0D);
    public static final VoxelShape SHAPE_SOUTH = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 8.5D);
    public static final VoxelShape SHAPE_WEST = Block.box(7.5D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D);

    public KettleBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER).setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(IcariaBlockStateProperties.KETTLE, Kettle.EMPTY).setValue(BlockStateProperties.LIT, false));
    }

    @Override
    public boolean canDropFromExplosion(BlockState pState, BlockGetter pLevel, BlockPos pPos, Explosion pExplosion) {
        return false;
    }

    @Override
    public boolean hasAnalogOutputSignal(BlockState pState) {
        return true;
    }

    @Override
    public int getAnalogOutputSignal(BlockState pState, Level pLevel, BlockPos pPos) {
        return pLevel.getBlockEntity(KettleBlock.getBlockEntityPosition(pState, pPos)) instanceof KettleBlockEntity blockEntity ? blockEntity.getComparatorInput() : 0;
    }

    @Override
    public int getLightEmission(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return pState.getValue(BlockStateProperties.LIT) ? 13 : 0;
    }

    public double getX(BlockState pState) {
        return switch (pState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
            case NORTH, SOUTH -> 0.5D;
            case EAST -> 0.65625D;
            case WEST -> 0.34375D;
            default -> 1.0D;
        };
    }

    public double getZ(BlockState pState) {
        return switch (pState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
            case NORTH -> 0.34375D;
            case EAST, WEST -> 0.5D;
            case SOUTH -> 0.65625D;
            default -> 1.0D;
        };
    }

    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        if (pState.getValue(BlockStateProperties.DOUBLE_BLOCK_HALF) == DoubleBlockHalf.LOWER) {
            if (pState.getValue(IcariaBlockStateProperties.KETTLE) == Kettle.ACTIVE) {
                pLevel.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, pPos.getX() + this.getX(pState) + pRandom.nextDouble() / 8.0D * (pRandom.nextBoolean() ? 1 : -1), pPos.getY() + 1.125D, pPos.getZ() + this.getZ(pState) + pRandom.nextDouble() / 8.0D * (pRandom.nextBoolean() ? 1 : -1), 0.0D, 0.05D, 0.0D);
                pLevel.addParticle(ParticleTypes.SMALL_FLAME, pPos.getX() + this.getX(pState) + pRandom.nextDouble() / 4.0D * (pRandom.nextBoolean() ? 1 : -1), pPos.getY() + 0.125D, pPos.getZ() + this.getZ(pState) + pRandom.nextDouble() / 4.0D * (pRandom.nextBoolean() ? 1 : -1), 0.0D, 0.0D, 0.0D);
                if (IcariaConfig.KETTLE_SOUNDS.get() && pRandom.nextDouble() < 0.1D) {
                    pLevel.playLocalSound(pPos, SoundEvents.FIRE_AMBIENT, SoundSource.BLOCKS, 1.0F, 1.0F, false);
                }
            } else if (pState.getValue(IcariaBlockStateProperties.KETTLE) == Kettle.BREWING) {
                pLevel.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, pPos.getX() + this.getX(pState) + pRandom.nextDouble() / 8.0D * (pRandom.nextBoolean() ? 1 : -1), pPos.getY() + 1.125D, pPos.getZ() + this.getZ(pState) + pRandom.nextDouble() / 8.0D * (pRandom.nextBoolean() ? 1 : -1), 0.0D, 0.05D, 0.0D);
                pLevel.addParticle(ParticleTypes.SMALL_FLAME, pPos.getX() + this.getX(pState) + pRandom.nextDouble() / 4.0D * (pRandom.nextBoolean() ? 1 : -1), pPos.getY() + 0.125D, pPos.getZ() + this.getZ(pState) + pRandom.nextDouble() / 4.0D * (pRandom.nextBoolean() ? 1 : -1), 0.0D, 0.0D, 0.0D);
                if (IcariaConfig.KETTLE_SOUNDS.get() && pRandom.nextDouble() < 0.1D) {
                    pLevel.playLocalSound(pPos, SoundEvents.FIRE_AMBIENT, SoundSource.BLOCKS, 1.0F, 1.0F, false);
                } else if (IcariaConfig.KETTLE_SOUNDS.get() && pRandom.nextDouble() > 0.9D) {
                    pLevel.playLocalSound(pPos, IcariaSoundEvents.KETTLE_CONCOCT, SoundSource.BLOCKS, 1.0F, 1.0F, false);
                }
            }
        }
    }

    @Override
    public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(BlockStateProperties.DOUBLE_BLOCK_HALF, BlockStateProperties.HORIZONTAL_FACING, IcariaBlockStateProperties.KETTLE, BlockStateProperties.LIT);
    }

    @Override
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        if (pLevel.getBlockEntity(pPos) instanceof KettleBlockEntity kettleBlockEntity) {
            if (pEntity instanceof ItemEntity itemEntity) {
                if (pState.getValue(BlockStateProperties.DOUBLE_BLOCK_HALF) == DoubleBlockHalf.LOWER) {
                    if (pState.getValue(IcariaBlockStateProperties.KETTLE) != Kettle.EMPTY) {
                        var item = itemEntity.getItem();
                        if (item.is(IcariaItemTags.KETTLE_ITEMS)) {
                            var itemStack = new ItemStack(item.getItem());
                            item.shrink(1);
                            kettleBlockEntity.resetProgress();
                            kettleBlockEntity.deque.offer(itemStack);
                            pLevel.playSound(null, pPos, SoundEvents.VILLAGER_WORK_LEATHERWORKER, SoundSource.BLOCKS);
                            pLevel.setBlockAndUpdate(pPos, pState.setValue(IcariaBlockStateProperties.KETTLE, Kettle.ACTIVE).setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER).setValue(BlockStateProperties.LIT, true));
                            pLevel.setBlockAndUpdate(pPos.above(), pState.setValue(IcariaBlockStateProperties.KETTLE, Kettle.ACTIVE).setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER).setValue(BlockStateProperties.LIT, true));
                        }
                    }
                }
            }
        }
    }

    @Override
    public void onBlockExploded(BlockState pState, Level pLevel, BlockPos pPos, Explosion pExplosion) {
        if (pState.getValue(BlockStateProperties.DOUBLE_BLOCK_HALF) == DoubleBlockHalf.LOWER) {
            pLevel.setBlock(pPos.above(), Blocks.AIR.defaultBlockState(), 3);
        } else {
            pLevel.setBlock(pPos.below(), Blocks.AIR.defaultBlockState(), 3);
        }

        super.onBlockExploded(pState, pLevel, pPos, pExplosion);
    }

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
        if (pState.getBlock() != pNewState.getBlock()) {
            if (pState.getValue(BlockStateProperties.DOUBLE_BLOCK_HALF) == DoubleBlockHalf.LOWER) {
                Block.popResource(pLevel, pPos, new ItemStack(IcariaItems.KETTLE.get()));
            }
        }

        super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
    }

    @Override
    public BlockState playerWillDestroy(Level pLevel, BlockPos pPos, BlockState pState, Player pPlayer) {
        if (pState.getValue(BlockStateProperties.DOUBLE_BLOCK_HALF) == DoubleBlockHalf.LOWER) {
            pLevel.setBlock(pPos.above(), Blocks.AIR.defaultBlockState(), 3);
        } else {
            pLevel.setBlock(pPos.below(), Blocks.AIR.defaultBlockState(), 3);
        }

        return super.playerWillDestroy(pLevel, pPos, pState, pPlayer);
    }

    @Override
    public void setPlacedBy(Level pLevel, BlockPos pPos, BlockState pState, @Nullable LivingEntity pPlacer, ItemStack pStack) {
        pLevel.setBlock(pPos.above(), pState.setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER), 3);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        if (pState.getValue(BlockStateProperties.DOUBLE_BLOCK_HALF) == DoubleBlockHalf.LOWER) {
            return new KettleBlockEntity(pPos, pState);
        } else {
            return null;
        }
    }

    public static BlockPos getBlockEntityPosition(BlockState pState, BlockPos pPos) {
        if (pState.getValue(BlockStateProperties.DOUBLE_BLOCK_HALF) == DoubleBlockHalf.LOWER) {
            return pPos;
        } else {
            return pPos.below();
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        var blockPos = pContext.getClickedPos();
        var level = pContext.getLevel();
        if (blockPos.getY() < level.getMaxBuildHeight() - 1 && level.getBlockState(blockPos.above()).canBeReplaced(pContext)) {
            return this.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, pContext.getHorizontalDirection().getOpposite());
        } else {
            return null;
        }
    }

    @Override
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.setValue(BlockStateProperties.HORIZONTAL_FACING, pMirror.mirror(pState.getValue(BlockStateProperties.HORIZONTAL_FACING)));
    }

    @Override
    public BlockState rotate(BlockState pState, Rotation pRotation) {
        return pState.setValue(BlockStateProperties.HORIZONTAL_FACING, pRotation.rotate(pState.getValue(BlockStateProperties.HORIZONTAL_FACING)));
    }

    @Override
    public ItemInteractionResult useItemOn(ItemStack pStack, BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pResult) {
        var item = pPlayer.getItemInHand(pHand);
        if (pLevel.getBlockEntity(pPos) instanceof KettleBlockEntity kettleBlockEntity) {
            if (pState.getValue(BlockStateProperties.DOUBLE_BLOCK_HALF) == DoubleBlockHalf.LOWER) {
                if (pState.getValue(IcariaBlockStateProperties.KETTLE) == Kettle.EMPTY) {
                    if (item.is(IcariaItems.MEDITERRANEAN_WATER_BUCKET.get())) {
                        var itemStack = new ItemStack(Items.BUCKET);
                        kettleBlockEntity.resetProgress();
                        kettleBlockEntity.deque.clear();
                        pLevel.playSound(null, pPos, SoundEvents.BUCKET_EMPTY, SoundSource.BLOCKS);
                        pLevel.setBlockAndUpdate(pPos, pState.setValue(IcariaBlockStateProperties.KETTLE, Kettle.FILLED).setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER));
                        pLevel.setBlockAndUpdate(pPos.above(), pState.setValue(IcariaBlockStateProperties.KETTLE, Kettle.FILLED).setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER));
                        pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.MEDITERRANEAN_WATER_BUCKET.get()));
                        if (!pPlayer.isCreative()) {
                            pPlayer.setItemInHand(pHand, itemStack);
                        }

                        return ItemInteractionResult.SUCCESS;
                    }
                } else {
                    if (item.is(IcariaItemTags.KETTLE_ITEMS)) {
                        var itemStack = new ItemStack(item.getItem());
                        kettleBlockEntity.resetProgress();
                        kettleBlockEntity.deque.offer(itemStack);
                        pLevel.playSound(null, pPos, SoundEvents.VILLAGER_WORK_LEATHERWORKER, SoundSource.BLOCKS);
                        pLevel.setBlockAndUpdate(pPos, pState.setValue(IcariaBlockStateProperties.KETTLE, Kettle.ACTIVE).setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER).setValue(BlockStateProperties.LIT, true));
                        pLevel.setBlockAndUpdate(pPos.above(), pState.setValue(IcariaBlockStateProperties.KETTLE, Kettle.ACTIVE).setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER).setValue(BlockStateProperties.LIT, true));
                        pPlayer.awardStat(Stats.ITEM_USED.get(item.getItem()));
                        if (!pPlayer.isCreative()) {
                            item.shrink(1);
                        }

                        return ItemInteractionResult.SUCCESS;
                    }

                    return ItemInteractionResult.FAIL;
                }

                return ItemInteractionResult.FAIL;
			}

            return ItemInteractionResult.FAIL;
		}

		return ItemInteractionResult.FAIL;
	}

    @Override
    public MapCodec<? extends BaseEntityBlock> codec() {
        return KettleBlock.CODEC;
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    public VoxelShape getBlockSupportShape(BlockState pState, BlockGetter pReader, BlockPos pPos) {
        return Shapes.empty();
    }

    @Override
    public VoxelShape getCollisionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return pState.getValue(BlockStateProperties.DOUBLE_BLOCK_HALF) == DoubleBlockHalf.LOWER ? Block.box(0, 0, 0, 16, 12, 16) : this.getShape(pState, pLevel, pPos, pContext);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return pState.getValue(BlockStateProperties.DOUBLE_BLOCK_HALF) == DoubleBlockHalf.LOWER ? Shapes.block() : switch (pState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
            case NORTH -> KettleBlock.SHAPE_NORTH;
            case EAST -> KettleBlock.SHAPE_EAST;
            case SOUTH -> KettleBlock.SHAPE_SOUTH;
            default -> KettleBlock.SHAPE_WEST;
        };
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        return !pLevel.isClientSide() ? BaseEntityBlock.createTickerHelper(pBlockEntityType, IcariaBlockEntityTypes.KETTLE.get(), KettleBlockEntity::tick) : null;
    }
}

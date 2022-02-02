package com.axanthic.landsoficaria.common.blocks;

import com.axanthic.landsoficaria.common.registry.LandsOfIcariaBlocks;
import com.axanthic.landsoficaria.common.registry.LandsOfIcariaItems;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.piston.MovingPistonBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import net.minecraftforge.common.FarmlandWaterManager;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.PlantType;

import java.util.Random;

public class FarmlandBlock extends Block {
    public static final IntegerProperty MOISTURE = BlockStateProperties.MOISTURE;
    public static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 15.0D, 16.0D);

    public FarmlandBlock() {
        super(Properties.of(Material.DIRT, MaterialColor.COLOR_BROWN).sound(SoundType.GRAVEL).explosionResistance(0.6F).strength(0.6F).randomTicks());
        this.registerDefaultState(this.stateDefinition.any().setValue(MOISTURE, 0));
    }

    public BlockState updateShape(BlockState stateFirst, Direction direction, BlockState stateSecond, LevelAccessor accessor, BlockPos posFirst, BlockPos posSecond) {
        if (direction == Direction.UP && !stateFirst.canSurvive(accessor, posFirst)) {
            accessor.scheduleTick(posFirst, this, 1);
        }

        return super.updateShape(stateFirst, direction, stateSecond, accessor, posFirst, posSecond);
    }

    public boolean canSurvive(BlockState state, LevelReader reader, BlockPos pos) {
        BlockState blockstate = reader.getBlockState(pos.above());
        return !blockstate.getMaterial().isSolid() || blockstate.getBlock() instanceof FenceGateBlock || blockstate.getBlock() instanceof MovingPistonBlock;
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return !this.defaultBlockState().canSurvive(context.getLevel(), context.getClickedPos()) ? LandsOfIcariaBlocks.MARL.get().defaultBlockState() : super.getStateForPlacement(context);
    }

    public boolean useShapeForLightOcclusion(BlockState state) {
        return true;
    }

    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    public void tick(BlockState state, ServerLevel level, BlockPos pos, Random random) {
        if (!state.canSurvive(level, pos)) {
            turnToMarl(state, level, pos);
        }
    }

    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, Random random) {
        int i = state.getValue(MOISTURE);
        if (!isNearWater(level, pos) && !level.isRainingAt(pos.above())) {
            if (i > 0) {
                level.setBlock(pos, state.setValue(MOISTURE, i - 1), 2);
            } else if (!isUnderCrops(level, pos)) {
                turnToMarl(state, level, pos);
            }
        } else if (i < 7) {
            level.setBlock(pos, state.setValue(MOISTURE, 7), 2);
        }
    }

    public void fallOn(Level level, BlockState state, BlockPos pos, Entity entity, float f) {
        if (!level.isClientSide && net.minecraftforge.common.ForgeHooks.onFarmlandTrample(level, pos, LandsOfIcariaBlocks.MARL.get().defaultBlockState(), f, entity)) {
            turnToMarl(state, level, pos);
        }

        super.fallOn(level, state, pos, entity, f);
    }

    public static void turnToMarl(BlockState state, Level level, BlockPos pos) {
        level.setBlockAndUpdate(pos, pushEntitiesUp(state, LandsOfIcariaBlocks.MARL.get().defaultBlockState(), level, pos));
    }

    public static boolean isUnderCrops(BlockGetter getter, BlockPos pos) {
        BlockState plant = getter.getBlockState(pos.above());
        BlockState state = getter.getBlockState(pos);
        return plant.getBlock() instanceof IPlantable && state.canSustainPlant(getter, pos, Direction.UP, (IPlantable)plant.getBlock());
    }

    public static boolean isNearWater(LevelReader reader, BlockPos pos) {
        for(BlockPos blockpos : BlockPos.betweenClosed(pos.offset(-4, 0, -4), pos.offset(4, 1, 4))) {
            if (reader.getFluidState(blockpos).is(FluidTags.WATER)) {
                return true;
            }
        }

        return FarmlandWaterManager.hasBlockWaterTicket(reader, pos);
    }

    public void createBlockStateDefinition(Builder<Block, BlockState> builder) {
        builder.add(MOISTURE);
    }

    public boolean isPathfindable(BlockState state, BlockGetter getter, BlockPos pos, PathComputationType type) {
        return false;
    }

    @Override
    public boolean canSustainPlant(BlockState state, BlockGetter getter, BlockPos pos, Direction direction, IPlantable plantable) {
        PlantType plantType = plantable.getPlantType(getter, pos.relative(direction));
        return plantType == PlantType.CROP || plantType == PlantType.PLAINS;
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit)
    {
        ItemStack itemStack = player.getItemInHand(hand);

        if(itemStack.getItem() == LandsOfIcariaItems.CALCITE_POWDER.get()) {
            if(state.getValue(MOISTURE) == 7) {
                level.playSound(player, pos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                if(!level.isClientSide) {
                    level.setBlock(pos, LandsOfIcariaBlocks.FARMLAND_FERTILIZED.get().defaultBlockState(), 0);
                    if(!player.isCreative()) {
                        itemStack.shrink(1);
                        }
                    }
                }

            return InteractionResult.SUCCESS;
        }

        return InteractionResult.FAIL;
    }
}

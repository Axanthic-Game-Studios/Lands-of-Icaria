package com.axanthic.icaria.common.blocks;

import java.util.Random;

import com.axanthic.icaria.common.registry.LandsOfIcariaBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.lighting.LayerLightEngine;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.IPlantable;

public class MarlGrassBlock extends Block {
	public static final BooleanProperty MOSSY_0 = BooleanProperty.create("mossy_0");
	public static final BooleanProperty MOSSY_1 = BooleanProperty.create("mossy_1");
	public static final BooleanProperty MOSSY_2 = BooleanProperty.create("mossy_2");

	public MarlGrassBlock(Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(MOSSY_0, false).setValue(MOSSY_1, false).setValue(MOSSY_2, false));
	}

	@Override
	public BlockState updateShape(BlockState stateFirst, Direction direction, BlockState stateSecond, LevelAccessor accessor, BlockPos posFirst, BlockPos posSecond) {
		return direction == Direction.UP ? stateFirst.setValue(MOSSY_0, stateSecond.is(LandsOfIcariaBlocks.MOSS_0.get())).setValue(MOSSY_1, stateSecond.is(LandsOfIcariaBlocks.MOSS_1.get())).setValue(MOSSY_2, stateSecond.is(LandsOfIcariaBlocks.MOSS_2.get())) : super.updateShape(stateFirst, direction, stateSecond, accessor, posFirst, posSecond);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		BlockState blockstate = context.getLevel().getBlockState(context.getClickedPos().above());
		return this.defaultBlockState().setValue(MOSSY_0, blockstate.is(LandsOfIcariaBlocks.MOSS_0.get())).setValue(MOSSY_1, blockstate.is(LandsOfIcariaBlocks.MOSS_1.get())).setValue(MOSSY_2, blockstate.is(LandsOfIcariaBlocks.MOSS_2.get()));
	}

	@Override
	public void createBlockStateDefinition(Builder<Block, BlockState> builder) {
		builder.add(MOSSY_0).add(MOSSY_1).add(MOSSY_2);
	}

	public static boolean canBeGrass(BlockState state, LevelReader reader, BlockPos pos) {
		BlockPos blockpos = pos.above();
		BlockState blockstate = reader.getBlockState(blockpos);
		if ((blockstate.is(LandsOfIcariaBlocks.MOSS_0.get()) || blockstate.is(LandsOfIcariaBlocks.MOSS_1.get()) || blockstate.is(LandsOfIcariaBlocks.MOSS_2.get())) && blockstate.getValue(MossBlock.LAYERS) == 1) {
			return true;
		} else if (blockstate.getFluidState().getAmount() == 8) {
			return false;
		} else {
			int i = LayerLightEngine.getLightBlockInto(reader, state, pos, blockstate, blockpos, Direction.UP, blockstate.getLightBlock(reader, blockpos));
			return i < reader.getMaxLightLevel();
		}
	}

	public static boolean canPropagate(BlockState state, LevelReader reader, BlockPos pos) {
		BlockPos blockpos = pos.above();
		return canBeGrass(state, reader, pos) && !reader.getFluidState(blockpos).is(FluidTags.WATER);
	}

	@Override
	public void randomTick(BlockState state, ServerLevel level, BlockPos pos, Random random) {
		if (!canBeGrass(state, level, pos)) {
			if (!level.isAreaLoaded(pos, 1))
				return;
			level.setBlockAndUpdate(pos, LandsOfIcariaBlocks.MARL.get().defaultBlockState());
		} else {
			if (!level.isAreaLoaded(pos, 3))
				return;
			if (level.getMaxLocalRawBrightness(pos.above()) >= 9) {
				BlockState blockstate = this.defaultBlockState();
				for (int i = 0; i < 4; ++i) {
					BlockPos blockpos = pos.offset(random.nextInt(3) - 1, random.nextInt(5) - 3, random.nextInt(3) - 1);
					if (level.getBlockState(blockpos).is(LandsOfIcariaBlocks.MARL.get()) && canPropagate(blockstate, level, blockpos)) {
						level.setBlockAndUpdate(blockpos, blockstate.setValue(MOSSY_0, level.getBlockState(blockpos.above()).is(LandsOfIcariaBlocks.MOSS_0.get())).setValue(MOSSY_1, level.getBlockState(blockpos.above()).is(LandsOfIcariaBlocks.MOSS_1.get())).setValue(MOSSY_2, level.getBlockState(blockpos.above()).is(LandsOfIcariaBlocks.MOSS_2.get())));
					}
				}
			}
		}
	}

	@Override
	public boolean canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction facing, IPlantable plantable) {
		return false; //TODO
	}

	@Override
	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
		ItemStack itemStack = player.getItemInHand(hand);

		if (itemStack.getItem() instanceof HoeItem) {
			level.playSound(player, pos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);
			if (!level.isClientSide) {
				level.setBlock(pos, LandsOfIcariaBlocks.FARMLAND.get().defaultBlockState(), 0);
				if (!player.isCreative()) {
					itemStack.hurtAndBreak(1, player, (playerUsing) -> playerUsing.broadcastBreakEvent(hand));
				}
			}

			return InteractionResult.SUCCESS;
		}

		return InteractionResult.FAIL;
	}
}

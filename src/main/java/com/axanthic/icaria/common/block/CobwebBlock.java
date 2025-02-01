package com.axanthic.icaria.common.block;

import javax.annotation.ParametersAreNonnullByDefault;

import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.mojang.math.Axis;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.WebBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

@SuppressWarnings("deprecation")
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CobwebBlock extends WebBlock {
	public static final BooleanProperty				PARENT_HORIZONTAL	= BooleanProperty.create("parent_adjacent");
	public static final IntegerProperty				NEIGHBOURS			= IntegerProperty.create("state", 0, 65);
	public static final Int2ObjectMap<VoxelShape>	STATEMAP			= new Int2ObjectOpenHashMap<>( );

	public CobwebBlock(Properties pProperties) {
		super(pProperties);
		registerDefaultState(
			this.stateDefinition.any( ).setValue(NEIGHBOURS, 0).setValue(PARENT_HORIZONTAL, false));
	}

	@Override
	public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
		int variant = pState.getValue(NEIGHBOURS);
		if (!pState.getVisualShape(pLevel, pPos, null).bounds( ).move(pPos).intersects(pEntity.getBoundingBox( )))
			return;
		if (variant == 1 || variant == 4 || variant == 8 || variant == 16 || variant == 32)
			pEntity.makeStuckInBlock(pState, new Vec3(0.75D, (double) 0.5F, 0.75D));
		else pEntity.makeStuckInBlock(pState, new Vec3(0.35D, (double) 0.05F, 0.35D));
	}

	@Override
	protected void createBlockStateDefinition(Builder<Block, BlockState> pBuilder) {
		pBuilder.add(NEIGHBOURS, PARENT_HORIZONTAL);
	}

	public static void fill( ) {
		// Down, Up, North, South, West, East
		STATEMAP.put(0, Block.box(0.d, 0.d, 0.d, 16.d, 16.d, 16.d)); // NONE
		STATEMAP.put(1, Block.box(0.d, 0.d, 0.d, 16.d, 2.d, 16.d)); // DOWN
		STATEMAP.put(2, Block.box(0.d, 2.d, 0.d, 16.d, 16.d, 16.d)); // UP
		STATEMAP.put(3, Block.box(0.d, 0.d, 0.d, 16.d, 16.d, 16.d));
		STATEMAP.put(4, Block.box(0.d, 0.d, 0.d, 16.d, 16.d, 2.d)); // NORTH
		STATEMAP.put(5, Block.box(0.d, 0.d, 0.d, 16.d, 16.d, 16.d));
		STATEMAP.put(6, Block.box(0.d, 0.d, 0.d, 16.d, 16.d, 16.d));
		STATEMAP.put(7, Block.box(0.d, 0.d, 0.d, 16.d, 16.d, 16.d));
		STATEMAP.put(8, Block.box(0.d, 0.d, 14.d, 16.d, 16.d, 16.d)); // SOUTH
		STATEMAP.put(9, Block.box(0.d, 0.d, 0.d, 16.d, 16.d, 16.d));
		STATEMAP.put(10, Block.box(0.d, 0.d, 0.d, 16.d, 16.d, 16.d));
		STATEMAP.put(11, Block.box(0.d, 0.d, 0.d, 16.d, 16.d, 16.d));
		STATEMAP.put(12, Block.box(0.d, 0.d, 0.d, 16.d, 16.d, 16.d));
		STATEMAP.put(13, Block.box(0.d, 0.d, 0.d, 16.d, 16.d, 16.d));
		STATEMAP.put(14, Block.box(0.d, 0.d, 0.d, 16.d, 16.d, 16.d));
		STATEMAP.put(15, Block.box(0.d, 0.d, 0.d, 16.d, 16.d, 16.d));
		STATEMAP.put(16, Block.box(14.d, 0.d, 0.d, 16.d, 16.d, 16.d)); // WEST
		STATEMAP.put(17, Block.box(0.d, 0.d, 0.d, 16.d, 16.d, 16.d));
		STATEMAP.put(18, Block.box(0.d, 0.d, 0.d, 16.d, 16.d, 16.d));
		STATEMAP.put(19, Block.box(0.d, 0.d, 0.d, 16.d, 16.d, 16.d));
		STATEMAP.put(20, Block.box(0.d, 0.d, 0.d, 16.d, 16.d, 16.d));
		STATEMAP.put(21, Block.box(0.d, 0.d, 0.d, 16.d, 16.d, 16.d));
		STATEMAP.put(22, Block.box(0.d, 0.d, 0.d, 16.d, 16.d, 16.d));
		STATEMAP.put(23, Block.box(0.d, 0.d, 0.d, 16.d, 16.d, 16.d));
		STATEMAP.put(24, Block.box(0.d, 0.d, 0.d, 16.d, 16.d, 16.d));
		STATEMAP.put(25, Block.box(0.d, 0.d, 0.d, 16.d, 16.d, 16.d));
		STATEMAP.put(26, Block.box(0.d, 0.d, 0.d, 16.d, 16.d, 16.d));
		STATEMAP.put(27, Block.box(0.d, 0.d, 0.d, 16.d, 16.d, 16.d));
		STATEMAP.put(28, Block.box(0.d, 0.d, 0.d, 16.d, 16.d, 16.d));
		STATEMAP.put(29, Block.box(0.d, 0.d, 0.d, 16.d, 16.d, 16.d));
		STATEMAP.put(30, Block.box(0.d, 0.d, 0.d, 16.d, 16.d, 16.d));
		STATEMAP.put(31, Block.box(0.d, 0.d, 0.d, 16.d, 16.d, 16.d));
		STATEMAP.put(32, Block.box(0.d, 0.d, 0.d, 2.d, 16.d, 16.d)); // EAST
		STATEMAP.put(33, Block.box(0.d, 0.d, 0.d, 16.d, 16.d, 16.d));
		STATEMAP.put(34, Block.box(0.d, 0.d, 0.d, 16.d, 16.d, 16.d));
		STATEMAP.put(35, Block.box(0.d, 0.d, 0.d, 16.d, 16.d, 16.d));
		STATEMAP.put(36, Block.box(0.d, 0.d, 0.d, 16.d, 16.d, 16.d));
		STATEMAP.put(37, Block.box(0.d, 0.d, 0.d, 16.d, 16.d, 16.d));
		STATEMAP.put(38, Block.box(0.d, 0.d, 0.d, 16.d, 16.d, 16.d));
		STATEMAP.put(39, Block.box(0.d, 0.d, 0.d, 16.d, 16.d, 16.d));
		STATEMAP.put(40, Block.box(0.d, 0.d, 0.d, 16.d, 16.d, 16.d));
		STATEMAP.put(41, Block.box(0.d, 0.d, 0.d, 16.d, 16.d, 16.d));
		STATEMAP.put(42, Block.box(0.d, 0.d, 0.d, 16.d, 16.d, 16.d));
		STATEMAP.put(43, Block.box(0.d, 0.d, 0.d, 16.d, 16.d, 16.d));
		STATEMAP.put(44, Block.box(0.d, 0.d, 0.d, 16.d, 16.d, 16.d));
		STATEMAP.put(45, Block.box(0.d, 0.d, 0.d, 16.d, 16.d, 16.d));
		STATEMAP.put(46, Block.box(0.d, 0.d, 0.d, 16.d, 16.d, 16.d));
		STATEMAP.put(47, Block.box(0.d, 0.d, 0.d, 16.d, 16.d, 16.d));
		STATEMAP.put(48, Block.box(0.d, 0.d, 0.d, 16.d, 16.d, 16.d));
		STATEMAP.put(49, Block.box(0.d, 0.d, 0.d, 16.d, 16.d, 16.d));
		STATEMAP.put(50, Block.box(0.d, 0.d, 0.d, 16.d, 16.d, 16.d));
		STATEMAP.put(51, Block.box(0.d, 0.d, 0.d, 16.d, 16.d, 16.d));
		STATEMAP.put(52, Block.box(0.d, 0.d, 0.d, 16.d, 16.d, 16.d));
		STATEMAP.put(53, Block.box(0.d, 0.d, 0.d, 16.d, 16.d, 16.d));
		STATEMAP.put(54, Block.box(0.d, 0.d, 0.d, 16.d, 16.d, 16.d));
		STATEMAP.put(55, Block.box(0.d, 0.d, 0.d, 16.d, 16.d, 16.d));
		STATEMAP.put(56, Block.box(0.d, 0.d, 0.d, 16.d, 16.d, 16.d));
		STATEMAP.put(57, Block.box(0.d, 0.d, 0.d, 16.d, 16.d, 16.d));
		STATEMAP.put(58, Block.box(0.d, 0.d, 0.d, 16.d, 16.d, 16.d));
		STATEMAP.put(59, Block.box(0.d, 0.d, 0.d, 16.d, 16.d, 16.d));
		STATEMAP.put(60, Block.box(0.d, 0.d, 0.d, 16.d, 16.d, 16.d));
		STATEMAP.put(61, Block.box(0.d, 0.d, 0.d, 16.d, 16.d, 16.d));
		STATEMAP.put(62, Block.box(0.d, 0.d, 0.d, 16.d, 16.d, 16.d));
		STATEMAP.put(63, Block.box(0.d, 0.d, 0.d, 16.d, 16.d, 16.d));
		STATEMAP.put(64, Block.box(0.d, 0.d, 0.d, 16.d, 16.d, 16.d));
	}

	public static int getID(Direction[] dirs) {
		int id = 0b00000000;
		for (Direction dir : dirs) {
			id |= dir.ordinal( );
		}
		return id;
	}

	@Override
	public boolean isCollisionShapeFullBlock(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
		return false;
	}

	@Override
	public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		return STATEMAP
			.getOrDefault(pState.getValue(NEIGHBOURS), Block.box(0.d, 0.d, 0.d, 16.d, 16.d, 16.d));
	}

	@Override
	public VoxelShape getVisualShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		return STATEMAP
			.getOrDefault(pState.getValue(NEIGHBOURS), Block.box(0.d, 0.d, 0.d, 16.d, 16.d, 16.d));
	}

	@Override
	public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pPos,
		BlockPos pNeighborPos) {
		return getStateForPos(pState, pPos, pLevel);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pContext) {
		BlockState state = getStateForPos(IcariaBlocks.COBWEB.get( ).defaultBlockState( ), pContext.getClickedPos( ), pContext.getLevel( ));
//		System.out.println(state);
		return state;
	}

	public BlockState getStateForPos(BlockState pState, BlockPos pPos, LevelAccessor pLevel) {
		BlockPos pos = pPos.immutable( );
		// Down, Up, North, South, West, East
		int	mask	= 0b000000;
		int	webMask	= 0b000000;

		for (Direction dir : Direction.values( )) {
			BlockState	state	= pLevel.getBlockState(pos.relative(dir));
			boolean		isweb	= state.getBlock( ) instanceof WebBlock;
			if (!state.isAir( ) && (state.isSolid( ) || isweb)) {
//				System.out.println("I am not air, but:" + state);
				mask	|= 1 << dir.ordinal( );
				webMask	|= ((!isweb || dir.equals(Direction.DOWN)) ? 0 : 1 << dir.ordinal( ));
			}
		}

		pState = pState.setValue(NEIGHBOURS, mask);
		if (webMask != 0) pState = pState.setValue(PARENT_HORIZONTAL, true);

//		System.out.println(mask + " : " + pState);
		return pState;
	}
}

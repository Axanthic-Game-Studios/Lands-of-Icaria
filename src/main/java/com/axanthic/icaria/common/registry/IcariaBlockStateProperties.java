package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.properties.*;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaBlockStateProperties {
	public static final BooleanProperty AMOUNT_LOCKED = BooleanProperty.create("amount_locked");
	public static final BooleanProperty BATHTUB_REMAINS = BooleanProperty.create("bathtub_remains");
	public static final BooleanProperty FULL_RACK = BooleanProperty.create("full_rack");
	public static final BooleanProperty GRINDER_GRINDING = BooleanProperty.create("grinder_grinding");
	public static final BooleanProperty LABEL_UP = BooleanProperty.create("label_up");
	public static final BooleanProperty LABEL_NORTH = BooleanProperty.create("label_north");
	public static final BooleanProperty LABEL_EAST = BooleanProperty.create("label_east");
	public static final BooleanProperty LABEL_SOUTH = BooleanProperty.create("label_south");
	public static final BooleanProperty LABEL_WEST = BooleanProperty.create("label_west");
	public static final BooleanProperty LOADED_BARREL = BooleanProperty.create("loaded_barrel");
	public static final BooleanProperty MEDITERRANEAN_WATERLOGGED = BooleanProperty.create("mediterranean_waterlogged");
	public static final BooleanProperty PLAYER_PLACED = BooleanProperty.create("player_placed");
	public static final BooleanProperty STOOL_TAKEN = BooleanProperty.create("stool_taken");
	public static final BooleanProperty TAPPED_BARREL = BooleanProperty.create("tapped_barrel");

	public static final EnumProperty<Direction> BARREL_FACING = EnumProperty.create("barrel_facing", Direction.class, direction -> direction != Direction.DOWN);

	public static final EnumProperty<Bathtub> BATHTUB = EnumProperty.create("bathtub", Bathtub.class);
	public static final EnumProperty<Candle> CANDLE = EnumProperty.create("candle", Candle.class);
	public static final EnumProperty<Carpet> CARPET = EnumProperty.create("carpet", Carpet.class);
	public static final EnumProperty<Corner> CORNER = EnumProperty.create("corner", Corner.class);
	public static final EnumProperty<Fill> FILL = EnumProperty.create("fill", Fill.class);
	public static final EnumProperty<HorizontalCorner> HORIZONTAL_CORNER = EnumProperty.create("horizontal_corner", HorizontalCorner.class);
	public static final EnumProperty<Kettle> KETTLE = EnumProperty.create("kettle", Kettle.class);
	public static final EnumProperty<Moss> MOSS = EnumProperty.create("moss", Moss.class);
	public static final EnumProperty<Olives> OLIVES = EnumProperty.create("olives", Olives.class);
	public static final EnumProperty<Part> PART = EnumProperty.create("part", Part.class);
	public static final EnumProperty<Ripe> RIPE = EnumProperty.create("ripe", Ripe.class);
	public static final EnumProperty<Side> SIDE = EnumProperty.create("side", Side.class);
	public static final EnumProperty<Trough> TROUGH = EnumProperty.create("trough", Trough.class);
	public static final EnumProperty<VerticalCorner> VERTICAL_CORNER = EnumProperty.create("vertical_corner", VerticalCorner.class);
	public static final EnumProperty<Vine> VINE = EnumProperty.create("vine", Vine.class);

	public static final IntegerProperty AMPHORA_AMOUNT = IntegerProperty.create("amphora_amount", 1, 3);
	public static final IntegerProperty BATHTUB_FILL = IntegerProperty.create("bathtub_fill", 0, 12);
	public static final IntegerProperty CAKE_BITE = IntegerProperty.create("cake_bite", 0, 3);
	public static final IntegerProperty CANDLE_AMOUNT = IntegerProperty.create("candle_amount", 0, 4);
	public static final IntegerProperty TROUGH_FILL = IntegerProperty.create("trough_fill", 0, 9);
}

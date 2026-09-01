package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.properties.*;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaBlockStateProperties {
	public static final BooleanProperty BATHTUB_REMAINS = BooleanProperty.create("bathtub_remains");
	public static final BooleanProperty FLOWER_POTTED = BooleanProperty.create("flower_potted");
	public static final BooleanProperty FULL_RACK = BooleanProperty.create("full_rack");
	public static final BooleanProperty GRINDER_GRINDING = BooleanProperty.create("grinder_grinding");
	public static final BooleanProperty LOADED_BARREL = BooleanProperty.create("loaded_barrel");
	public static final BooleanProperty MEDITERRANEAN_WATERLOGGED = BooleanProperty.create("mediterranean_waterlogged");
	public static final BooleanProperty MULTI_HUTCH = BooleanProperty.create("multi_hutch");
	public static final BooleanProperty PLAYER_PLACED = BooleanProperty.create("player_placed");
	public static final BooleanProperty POT_FILLED = BooleanProperty.create("pot_filled");
	public static final BooleanProperty RIPE_BUSH = BooleanProperty.create("ripe_bush");
	public static final BooleanProperty STANDING_BARREL = BooleanProperty.create("standing_barrel");
	public static final BooleanProperty STOOL_TAKEN = BooleanProperty.create("stool_taken");
	public static final BooleanProperty TAPPED_BARREL = BooleanProperty.create("tapped_barrel");

	public static final BooleanProperty LABEL_NORTH = BooleanProperty.create("label_north");
	public static final BooleanProperty LABEL_EAST = BooleanProperty.create("label_east");
	public static final BooleanProperty LABEL_SOUTH = BooleanProperty.create("label_south");
	public static final BooleanProperty LABEL_WEST = BooleanProperty.create("label_west");
	public static final BooleanProperty LABEL_UP = BooleanProperty.create("label_up");
	public static final BooleanProperty LABEL_DOWN = BooleanProperty.create("label_down");

	public static final EnumProperty<Candle> CANDLE = EnumProperty.create("candle", Candle.class);
	public static final EnumProperty<Carpet> CARPET = EnumProperty.create("carpet", Carpet.class);
	public static final EnumProperty<Chessboard> CHESSBOARD = EnumProperty.create("chessboard", Chessboard.class);
	public static final EnumProperty<Corner> CORNER = EnumProperty.create("corner", Corner.class);
	public static final EnumProperty<Fill> FILL = EnumProperty.create("fill", Fill.class);
	public static final EnumProperty<FirewoodWedge> FIREWOOD_WEDGE = EnumProperty.create("firewood_wedge", FirewoodWedge.class);
	public static final EnumProperty<HorizontalCorner> HORIZONTAL_CORNER = EnumProperty.create("horizontal_corner", HorizontalCorner.class);
	public static final EnumProperty<Kettle> KETTLE = EnumProperty.create("kettle", Kettle.class);
	public static final EnumProperty<Ladder> LADDER = EnumProperty.create("ladder", Ladder.class);
	public static final EnumProperty<Moss> MOSS = EnumProperty.create("moss", Moss.class);
	public static final EnumProperty<Olives> OLIVES = EnumProperty.create("olives", Olives.class);
	public static final EnumProperty<Part> PART = EnumProperty.create("part", Part.class);
	public static final EnumProperty<Side> SIDE = EnumProperty.create("side", Side.class);
	public static final EnumProperty<Trough> TROUGH = EnumProperty.create("trough", Trough.class);
	public static final EnumProperty<VerticalCorner> VERTICAL_CORNER = EnumProperty.create("vertical_corner", VerticalCorner.class);
	public static final EnumProperty<Vine> VINE = EnumProperty.create("vine", Vine.class);

	public static final EnumProperty<Connection> CONNECTION_NORTH = EnumProperty.create("connection_north", Connection.class);
	public static final EnumProperty<Connection> CONNECTION_EAST = EnumProperty.create("connection_east", Connection.class);
	public static final EnumProperty<Connection> CONNECTION_SOUTH = EnumProperty.create("connection_south", Connection.class);
	public static final EnumProperty<Connection> CONNECTION_WEST = EnumProperty.create("connection_west", Connection.class);
	public static final EnumProperty<Connection> CONNECTION_UP = EnumProperty.create("connection_up", Connection.class);
	public static final EnumProperty<Connection> CONNECTION_DOWN = EnumProperty.create("connection_down", Connection.class);

	public static final IntegerProperty AMPHORA_AMOUNT = IntegerProperty.create("amphora_amount", 1, 3);
	public static final IntegerProperty BATHTUB_FILL = IntegerProperty.create("bathtub_fill", 0, 12);
	public static final IntegerProperty CAKE_BITE = IntegerProperty.create("cake_bite", 0, 3);
	public static final IntegerProperty CANDLE_AMOUNT = IntegerProperty.create("candle_amount", 0, 4);
	public static final IntegerProperty LADDER_TICK = IntegerProperty.create("ladder_tick", 0, 40);
	public static final IntegerProperty POT_FILL = IntegerProperty.create("pot_fill", 0, 3);
	public static final IntegerProperty SUSPICIOUS_SUBSTANCE = IntegerProperty.create("suspicious_substance", 0, 3);
	public static final IntegerProperty TROUGH_FILL = IntegerProperty.create("trough_fill", 0, 9);
	public static final IntegerProperty VASE_VARIANT = IntegerProperty.create("vase_variant", 0, 9);
}

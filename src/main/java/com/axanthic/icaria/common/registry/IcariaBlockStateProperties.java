package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.properties.*;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

@SuppressWarnings("unused")

public class IcariaBlockStateProperties {
    public static final BooleanProperty FULL_RACK = BooleanProperty.create("full_rack");
    public static final BooleanProperty GRINDER_GRINDING = BooleanProperty.create("grinder_grinding");
    public static final BooleanProperty LOADED_BARREL = BooleanProperty.create("loaded_barrel");
    public static final BooleanProperty MEDITERRANEAN_WATERLOGGED = BooleanProperty.create("mediterranean_waterlogged");
    public static final BooleanProperty PLAYER_PLACED = BooleanProperty.create("player_placed");
    public static final BooleanProperty TAPPED_BARREL = BooleanProperty.create("tapped_barrel");
    public static final BooleanProperty TEXT_UP = BooleanProperty.create("text_up");
    public static final BooleanProperty TEXT_NORTH = BooleanProperty.create("text_north");
    public static final BooleanProperty TEXT_EAST = BooleanProperty.create("text_east");
    public static final BooleanProperty TEXT_SOUTH = BooleanProperty.create("text_south");
    public static final BooleanProperty TEXT_WEST = BooleanProperty.create("text_west");
    public static final BooleanProperty TROUGH_WATER = BooleanProperty.create("trough_water");

    public static final DirectionProperty BARREL_FACING = DirectionProperty.create("barrel_facing", (direction) -> direction != Direction.DOWN);

    public static final EnumProperty<Corner> CORNER = EnumProperty.create("corner", Corner.class);
    public static final EnumProperty<HorizontalCorner> HORIZONTAL_CORNER = EnumProperty.create("horizontal_corner", HorizontalCorner.class);
    public static final EnumProperty<Kettle> KETTLE = EnumProperty.create("kettle", Kettle.class);
    public static final EnumProperty<Moss> MOSS = EnumProperty.create("moss", Moss.class);
    public static final EnumProperty<Olives> OLIVES = EnumProperty.create("olives", Olives.class);
    public static final EnumProperty<Ripe> RIPE = EnumProperty.create("ripe", Ripe.class);
    public static final EnumProperty<Side> SIDE = EnumProperty.create("side", Side.class);
    public static final EnumProperty<VerticalCorner> VERTICAL_CORNER = EnumProperty.create("vertical_corner", VerticalCorner.class);
    public static final EnumProperty<Vine> VINE = EnumProperty.create("vine", Vine.class);

    public static final IntegerProperty CAKE_BITE = IntegerProperty.create("cake_bite", 0, 3);
    public static final IntegerProperty GRINDER_ROTATION = IntegerProperty.create("grinder_rotation", 0, 90);
}

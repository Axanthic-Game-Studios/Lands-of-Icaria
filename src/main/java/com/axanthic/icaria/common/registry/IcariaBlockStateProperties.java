package com.axanthic.icaria.common.registry;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class IcariaBlockStateProperties {
    public static final BooleanProperty FOREST_MOSS = BooleanProperty.create("forest_moss");
    public static final BooleanProperty GRINDING = BooleanProperty.create("grinding");
    public static final BooleanProperty MEDITERRANEAN_WATERLOGGED = BooleanProperty.create("mediterranean_waterlogged");
    public static final BooleanProperty SCRUBLAND_MOSS = BooleanProperty.create("scrubland_moss");
    public static final BooleanProperty STEPPE_MOSS = BooleanProperty.create("steppe_moss");
    public static final BooleanProperty TEXT_UP = BooleanProperty.create("text_up");
    public static final BooleanProperty TEXT_NORTH = BooleanProperty.create("text_north");
    public static final BooleanProperty TEXT_EAST = BooleanProperty.create("text_east");
    public static final BooleanProperty TEXT_SOUTH = BooleanProperty.create("text_south");
    public static final BooleanProperty TEXT_WEST = BooleanProperty.create("text_west");

    public static final IntegerProperty CAKE_BITE = IntegerProperty.create("cake_bite", 0, 3);
    public static final IntegerProperty GRINDER_ROTATION = IntegerProperty.create("grinder_rotation", 0, 90);
    public static final IntegerProperty OLIVE_STAGE = IntegerProperty.create("olive_stage", 0, 2);
    public static final IntegerProperty STRAWBERRY_STAGE = IntegerProperty.create("strawberry_stage", 0, 1);
}

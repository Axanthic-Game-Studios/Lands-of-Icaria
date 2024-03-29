package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.properties.Corner;
import com.axanthic.icaria.common.properties.Kettle;
import com.axanthic.icaria.common.properties.Moss;
import com.axanthic.icaria.common.properties.Side;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class IcariaBlockStateProperties {
    public static final BooleanProperty FULL_RACK = BooleanProperty.create("full_rack");
    public static final BooleanProperty GRINDER_GRINDING = BooleanProperty.create("grinder_grinding");
    public static final BooleanProperty LOADED_BARREL = BooleanProperty.create("loaded_barrel");
    public static final BooleanProperty MEDITERRANEAN_WATERLOGGED = BooleanProperty.create("mediterranean_waterlogged");
    public static final BooleanProperty TAPPED_BARREL = BooleanProperty.create("tapped_barrel");
    public static final BooleanProperty TEXT_UP = BooleanProperty.create("text_up");
    public static final BooleanProperty TEXT_NORTH = BooleanProperty.create("text_north");
    public static final BooleanProperty TEXT_EAST = BooleanProperty.create("text_east");
    public static final BooleanProperty TEXT_SOUTH = BooleanProperty.create("text_south");
    public static final BooleanProperty TEXT_WEST = BooleanProperty.create("text_west");
    public static final BooleanProperty TROUGH_WATER = BooleanProperty.create("trough_water");

    public static final DirectionProperty BARREL_FACING = DirectionProperty.create("barrel_facing", (direction) -> direction != Direction.DOWN);

    public static final EnumProperty<Corner> CORNER = EnumProperty.create("corner", Corner.class);
    public static final EnumProperty<Kettle> KETTLE = EnumProperty.create("kettle", Kettle.class);
    public static final EnumProperty<Moss> MOSS = EnumProperty.create("moss", Moss.class);
    public static final EnumProperty<Side> SIDE = EnumProperty.create("side", Side.class);

    public static final IntegerProperty CAKE_BITE = IntegerProperty.create("cake_bite", 0, 3);
    public static final IntegerProperty GRINDER_ROTATION = IntegerProperty.create("grinder_rotation", 0, 90);
    public static final IntegerProperty OLIVE_STAGE = IntegerProperty.create("olive_stage", 0, 2);
    public static final IntegerProperty STRAWBERRY_STAGE = IntegerProperty.create("strawberry_stage", 0, 1);
}

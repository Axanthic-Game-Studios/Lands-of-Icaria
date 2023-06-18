package com.axanthic.icaria.common.registry;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class IcariaBlockStateProperties {
    public static final BooleanProperty FOREST_MOSS = BooleanProperty.create("forest_moss");
    public static final BooleanProperty GRINDING = BooleanProperty.create("grinding");
    public static final BooleanProperty MEDITERRANEAN_WATERLOGGED = BooleanProperty.create("mediterranean_waterlogged");
    public static final BooleanProperty SCRUBLAND_MOSS = BooleanProperty.create("scrubland_moss");
    public static final BooleanProperty STEPPE_MOSS = BooleanProperty.create("steppe_moss");

    public static final IntegerProperty CAKE_BITE = IntegerProperty.create("cake_bite", 0, 3);
    public static final IntegerProperty OLIVE_STAGE = IntegerProperty.create("olive_stage", 0, 2);
    public static final IntegerProperty GRINDER_ROTATION = IntegerProperty.create("grinder_rotation", 0, 90);
}

package com.axanthic.icaria.common.registry;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.level.block.state.properties.BlockSetType;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaBlockSetTypes {
    public static final BlockSetType CYPRESS = BlockSetType.register(IcariaBlockSetTypes.register("cypress"));
    public static final BlockSetType DROUGHTROOT = BlockSetType.register(IcariaBlockSetTypes.register("droughtroot"));
    public static final BlockSetType FIR = BlockSetType.register(IcariaBlockSetTypes.register("fir"));
    public static final BlockSetType LAUREL = BlockSetType.register(IcariaBlockSetTypes.register("laurel"));
    public static final BlockSetType OLIVE = BlockSetType.register(IcariaBlockSetTypes.register("olive"));
    public static final BlockSetType PLANE = BlockSetType.register(IcariaBlockSetTypes.register("plane"));
    public static final BlockSetType POPULUS = BlockSetType.register(IcariaBlockSetTypes.register("populus"));

    public static BlockSetType register(String pName) {
        return new BlockSetType(IcariaIdents.ID + ":" + pName);
    }
}

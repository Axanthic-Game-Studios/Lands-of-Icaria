package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.world.structure.IcariaJigsawStructure;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.StructureType;

import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaStructureTypes {
	public static final DeferredRegister<StructureType<?>> STRUCTURE_TYPES = DeferredRegister.create(Registries.STRUCTURE_TYPE, IcariaIdents.ID);

	public static final Supplier<StructureType<IcariaJigsawStructure>> JIGSAW = IcariaStructureTypes.STRUCTURE_TYPES.register("jigsaw", () -> () -> IcariaJigsawStructure.CODEC);
}

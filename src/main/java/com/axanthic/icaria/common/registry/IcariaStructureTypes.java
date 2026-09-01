package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.world.structure.IcariaJigsawStructure;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.StructureType;

import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaStructureTypes {
	public static final DeferredRegister<StructureType<?>> STRUCTURE_TYPES = DeferredRegister.create(Registries.STRUCTURE_TYPE, IcariaKeys.ID);

	public static final DeferredHolder<StructureType<?>, StructureType<IcariaJigsawStructure>> JIGSAW = IcariaStructureTypes.STRUCTURE_TYPES.register("jigsaw", () -> () -> IcariaJigsawStructure.CODEC);
}

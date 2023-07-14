package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.util.IcariaInfo;
import com.axanthic.icaria.common.world.gen.IcariaChunkGenerator;

import com.mojang.serialization.Codec;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.chunk.ChunkGenerator;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class IcariaChunkGenerators {
    public static final DeferredRegister<Codec<? extends ChunkGenerator>> CHUNK_GENERATORS = DeferredRegister.create(Registries.CHUNK_GENERATOR, IcariaInfo.ID);

    public static final RegistryObject<Codec<? extends ChunkGenerator>> ICARIA = IcariaChunkGenerators.CHUNK_GENERATORS.register("icaria", () -> IcariaChunkGenerator.CODEC);
}

package com.axanthic.icaria.common.world.gen;

import java.util.stream.Stream;

import com.axanthic.icaria.common.registry.IcariaBiomes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.Holder;
import net.minecraft.core.QuartPos;
import net.minecraft.resources.RegistryOps;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.Climate;

// TODO: use in the future instead of the default minecraft biome source
public class IcariaBiomeProvider extends BiomeSource {

	// To add new biomes, add it in the instance group.
	// TODO: add scrubland here
	public static final Codec<IcariaBiomeProvider> CODEC = RecordCodecBuilder.create(instance -> instance
			.group(RegistryOps.retrieveElement(IcariaBiomes.SCRUBLAND),
					RegistryOps.retrieveElement(IcariaBiomes.DESERT))
			.apply(instance, instance.stable(IcariaBiomeProvider::new)));

	// List of all biomes holder
	private final Holder<Biome> scrubland;
	private final Holder<Biome> desert;

	// TODO: find a better way to get the biome holders (use registry lookup).
	private IcariaBiomeProvider(final Holder<Biome> scrubland, final Holder<Biome> desert) {
		this.scrubland = scrubland;
		this.desert = desert;
	}

	@Override
	protected Stream<Holder<Biome>> collectPossibleBiomes() {
		return Stream.of(this.scrubland, this.desert);
	}

	@Override
	protected Codec<? extends BiomeSource> codec() {
		return CODEC;
	}

	@Override
	public Holder<Biome> getNoiseBiome(final int x, final int y, final int z, final Climate.Sampler sampler) {
		final int qx = QuartPos.toBlock(x);
		final int qy = QuartPos.toBlock(y);
		final int qz = QuartPos.toBlock(z);

		// TODO: generate biomes (equivalent voronoi except for void I guess)
//		final int l = SectionPos.blockToSectionCoord(qx);
//		final int i1 = SectionPos.blockToSectionCoord(qz);
//		if ((long) l * (long) l + (long) i1 * (long) i1 <= 4096L) {
//			return this.end;
//		}
//		final int j1 = (SectionPos.blockToSectionCoord(qx) * 2 + 1) * 8;
//		final int k1 = (SectionPos.blockToSectionCoord(qz) * 2 + 1) * 8;
//		final double d0 = sampler.erosion().compute(new DensityFunction.SinglePointContext(j1, qy, k1));
//		if (d0 > 0.25D) {
//			return this.highlands;
//		}
//		if (d0 >= -0.0625D) {
//			return this.midlands;
//		} else {
//			return d0 < -0.21875D ? this.islands : this.barrens;
//		}

		return this.scrubland;
	}
}
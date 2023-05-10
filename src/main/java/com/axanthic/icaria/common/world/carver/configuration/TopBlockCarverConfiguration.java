package com.axanthic.icaria.common.world.carver.configuration;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.carver.CarverConfiguration;

public class TopBlockCarverConfiguration extends CarverConfiguration {

	public BlockState topBlockPrimary;
	public BlockState fillerBlockPrimary;
	public BlockState topBlockSecondary;
	public BlockState fillerBlockSecondary;

	public BlockState upperBlockPrimary;
	public BlockState upperBlockSecondary;
	public BlockState upperBlockTertiary;
	public BlockState topBlockTertiary;
	public BlockState fillerBlockTertiary;

	public static final Codec<TopBlockCarverConfiguration> CODEC = RecordCodecBuilder.create(instance -> instance.group(
			CarverConfiguration.CODEC.forGetter(p_159192_ -> p_159192_),
			// MANDATORY
			BlockState.CODEC.fieldOf("topBlockPrimary").forGetter(configuration -> configuration.topBlockPrimary),
			BlockState.CODEC.fieldOf("fillerBlockPrimary").forGetter(configuration -> configuration.fillerBlockPrimary),
			BlockState.CODEC.fieldOf("topBlockSecondary").forGetter(configuration -> configuration.topBlockSecondary),
			BlockState.CODEC.fieldOf("fillerBlockSecondary")
					.forGetter(configuration -> configuration.fillerBlockSecondary),
			// OPTIONAL
			BlockState.CODEC.fieldOf("upperBlockPrimary").forGetter(configuration -> configuration.upperBlockPrimary),
			BlockState.CODEC.fieldOf("upperBlockSecondary")
					.forGetter(configuration -> configuration.upperBlockSecondary),
			BlockState.CODEC.fieldOf("upperBlockTertiary").forGetter(configuration -> configuration.upperBlockTertiary),
			BlockState.CODEC.fieldOf("topBlockTertiary").forGetter(configuration -> configuration.topBlockTertiary),
			BlockState.CODEC.fieldOf("fillerBlockTertiary")
					.forGetter(configuration -> configuration.fillerBlockTertiary)

	).apply(instance, TopBlockCarverConfiguration::new));

	public TopBlockCarverConfiguration(final CarverConfiguration conf, final BlockState topBlock,
			final BlockState fillerBlockPrimary, final BlockState topBlockSecondary,
			final BlockState fillerBlockSecondary, final BlockState upperBlockPrimary,
			final BlockState upperBlockSecondary, final BlockState upperBlockTertiary,
			final BlockState topBlockTertiary, final BlockState fillerBlockTertiary) {
		super(conf.probability, conf.y, conf.yScale, conf.lavaLevel, conf.debugSettings, conf.replaceable);
		this.topBlockPrimary = topBlock;
		this.fillerBlockPrimary = fillerBlockPrimary;
		this.topBlockSecondary = topBlockSecondary;
		this.fillerBlockSecondary = fillerBlockSecondary;

		this.upperBlockPrimary = fillerBlockSecondary;
		this.upperBlockSecondary = fillerBlockSecondary;
		this.upperBlockTertiary = fillerBlockSecondary;
		this.topBlockTertiary = fillerBlockSecondary;
		this.fillerBlockTertiary = fillerBlockSecondary;
	}
}
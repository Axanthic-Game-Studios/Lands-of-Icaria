package com.axanthic.icaria.common.world.carver.configuration;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.carver.CarverConfiguration;

import java.util.Optional;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class IcariaSoilCarverConfiguration extends CarverConfiguration {
	public BlockState fillerPrimary;
	public BlockState fillerSecondary;
	public BlockState fillerTertiary;
	public BlockState topPrimary;
	public BlockState topSecondary;
	public BlockState topTertiary;

	public static final Codec<IcariaSoilCarverConfiguration> CODEC = RecordCodecBuilder.create(pInstance -> pInstance.group(CarverConfiguration.CODEC.forGetter(pConfig -> pConfig), BlockState.CODEC.fieldOf("fillerPrimary").forGetter(pConfig -> pConfig.fillerPrimary), BlockState.CODEC.fieldOf("fillerSecondary").forGetter(pConfig -> pConfig.fillerSecondary), BlockState.CODEC.fieldOf("fillerTertiary").forGetter(pConfig -> pConfig.fillerTertiary), BlockState.CODEC.fieldOf("topPrimary").forGetter(pConfig -> pConfig.topPrimary), BlockState.CODEC.fieldOf("topSecondary").forGetter(pConfig -> pConfig.topSecondary), BlockState.CODEC.fieldOf("topTertiary").forGetter(pConfig -> pConfig.topTertiary), BlockState.CODEC.optionalFieldOf("topperPrimary").forGetter(pConfig -> pConfig.topperPrimary), BlockState.CODEC.optionalFieldOf("topperSecondary").forGetter(pConfig -> pConfig.topperSecondary), BlockState.CODEC.optionalFieldOf("topperTertiary").forGetter(pConfig -> pConfig.topperTertiary)).apply(pInstance, IcariaSoilCarverConfiguration::new));

	public Optional<BlockState> topperPrimary;
	public Optional<BlockState> topperSecondary;
	public Optional<BlockState> topperTertiary;

	public IcariaSoilCarverConfiguration(CarverConfiguration pConfig, BlockState pFillerPrimary, BlockState pFillerSecondary, BlockState pFillerTertiary, BlockState pTopPrimary, BlockState pTopSecondary, BlockState pTopTertiary, Optional<BlockState> pTopperPrimary, Optional<BlockState> pTopperSecondary, Optional<BlockState> pTopperTertiary) {
		super(pConfig.probability, pConfig.y, pConfig.yScale, pConfig.lavaLevel, pConfig.debugSettings, pConfig.replaceable);
		this.fillerPrimary = pFillerPrimary;
		this.fillerSecondary = pFillerSecondary;
		this.fillerTertiary = pFillerTertiary;
		this.topPrimary = pTopPrimary;
		this.topSecondary = pTopSecondary;
		this.topTertiary = pTopTertiary;
		this.topperPrimary = pTopperPrimary;
		this.topperSecondary = pTopperSecondary;
		this.topperTertiary = pTopperTertiary;
	}
}
package com.axanthic.loi.worldgen.biome;

import com.axanthic.blab.Resources;

import net.minecraft.block.state.IBlockState;
import net.minecraft.world.biome.Biome;

public class BiomeLOI extends Biome {

	public IBlockState upperBlockPrimary = null;
	public IBlockState topBlockPrimary = Resources.grass.getBlock().getDefaultState();
	public IBlockState fillerBlockPrimary = Resources.soil.getBlock().getDefaultState();
	public IBlockState upperBlockSecondary = null;
	public IBlockState topBlockSecondary = Resources.soil.getBlock().getStateFromMeta(1);
	public IBlockState fillerBlockSecondary = Resources.soil.getBlock().getStateFromMeta(1);
	public IBlockState upperBlockTertiary = null;
	public IBlockState topBlockTertiary = Resources.soil.getBlock().getStateFromMeta(2);
	public IBlockState fillerBlockTertiary = Resources.soil.getBlock().getDefaultState();

	public BiomeLOI(BiomeProperties properties) {
		super(properties);
	}
}

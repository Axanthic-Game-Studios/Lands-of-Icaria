package com.axanthic.loi.worldgen.biome;

import com.axanthic.loi.Resources;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BiomeLOI extends Biome {

	private final double density;
	private final double topCraziness;

	public IBlockState upperBlockPrimary = null;
	public IBlockState topBlockPrimary = Resources.grass.getBlock().getDefaultState();
	public IBlockState fillerBlockPrimary = Resources.soil.getBlock().getDefaultState();
	public IBlockState upperBlockSecondary = null;
	public IBlockState topBlockSecondary = Resources.soil.getBlock().getStateFromMeta(1);
	public IBlockState fillerBlockSecondary = Resources.soil.getBlock().getStateFromMeta(1);
	public IBlockState upperBlockTertiary = null;
	public IBlockState topBlockTertiary = Resources.soil.getBlock().getStateFromMeta(2);
	public IBlockState fillerBlockTertiary = Resources.soil.getBlock().getStateFromMeta(2);

	public BiomeLOI(final BiomeProperties properties, final double d, final double topC) {
		super(properties);
		this.density = d;
		this.topCraziness = topC;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getFoliageColorAtPos(final BlockPos pos) {
		return this.getGrassColorAtPos(pos);
	}

	public boolean isVoid() {
		return false;
	}

	public double getDensity() {
		return this.density;
	}

	public double getTopCrazyness() {
		return this.topCraziness;
	}
}

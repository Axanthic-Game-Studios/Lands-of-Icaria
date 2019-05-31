package com.axanthic.loi.worldgen.dimension;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiCreateWorld;
import net.minecraft.init.Biomes;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WorldTypeLOI extends WorldType
{
	
	public BiomeProvider biomeProvider = null;

	public WorldTypeLOI()
	{
		super("loi");
	}

	@Override
	public BiomeProvider getBiomeProvider(final World world)
	{
		//return new BiomeProviderSingle(Biomes.SKY);
		if (biomeProvider == null) {
			biomeProvider = new BiomeProviderLOI(world.getWorldInfo());
		}
		return biomeProvider;
	}

	@Override
	public IChunkGenerator getChunkGenerator(final World world, final String generatorOptions)
	{
		return new ChunkGeneratorLOI(world, world.getSeed(), world.getWorldInfo().isMapFeaturesEnabled());
	}

	@Override
	public int getMinimumSpawnHeight(final World world)
	{
		return world.getSeaLevel() + 1;
	}

	@Override
	public double getHorizon(final World world)
	{
		return 63.0D;
	}

	@Override
	public double voidFadeMagnitude()
	{
		return 0.03125D;
	}

	@Override
	public boolean handleSlimeSpawnReduction(final Random random, final World world)
	{
		return false;
	}

	/**
	 * Called when 'Create New World' button is pressed before starting game
	 */
	@Override
	public void onGUICreateWorldPress() { }

	/**
	 * Gets the spawn fuzz for players who join the world.
	 * Useful for void world types.
	 * @return Fuzz for entity initial spawn in blocks.
	 */
	@Override
	public int getSpawnFuzz(final WorldServer world, final net.minecraft.server.MinecraftServer server)
	{
		return Math.max(0, server.getSpawnRadius(world));
	}

	/**
	 * Called when the 'Customize' button is pressed on world creation GUI
	 * @param mc The Minecraft instance
	 * @param guiCreateWorld the createworld GUI
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public void onCustomizeButton(final Minecraft mc, final GuiCreateWorld guiCreateWorld)
	{
	}

	/**
	 * Should world creation GUI show 'Customize' button for this world type?
	 * @return if this world type has customization parameters
	 */
	@Override
	public boolean isCustomizable()
	{
		return false;
	}

	/**
	 * returns true if selecting this worldtype from the customize menu should display the generator.[worldtype].info
	 * message
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasInfoNotice()
	{
		return true;
	}

	/**
	 * Get the height to render the clouds for this world type
	 * @return The height to render clouds at
	 */
	@Override
	public float getCloudHeight()
	{
		return 128.0F;
	}
}
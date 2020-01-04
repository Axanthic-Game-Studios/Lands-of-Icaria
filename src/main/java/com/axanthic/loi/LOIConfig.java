package com.axanthic.loi;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.LangKey;
import net.minecraftforge.common.config.Config.Name;
import net.minecraftforge.common.config.Config.RangeDouble;
import net.minecraftforge.common.config.Config.RequiresMcRestart;

@Config(modid = ModInformation.ID, name = ModInformation.ID, category = "")
public class LOIConfig {

	@Name("compatibility")
	@LangKey("loi.config.compat")
	@Comment("Cross mod compatibility settings")
	public static CategoryCompatibility compat = new CategoryCompatibility();

	public static class CategoryCompatibility {

		@RequiresMcRestart
		@LangKey("loi.config.compat.jei")
		public Boolean jei = true;

	}

	@Name("worldgeneration")
	@LangKey("loi.config.worldgen")
	@Comment("World Generation settings")
	public static CategoryWorldgen world = new CategoryWorldgen();

	public static class CategoryWorldgen {

		@RequiresMcRestart
		@LangKey("loi.config.worldgen.lignite")
		public OreSettings lignite = new OreSettings(true, -0.02D, -0.0D, 1.0D, 0000);

		@RequiresMcRestart
		@LangKey("loi.config.worldgen.chalkos")
		public OreSettings chalkos = new OreSettings(true, -0.115D, -0.1D, 0.75D, 2000);

		@RequiresMcRestart
		@LangKey("loi.config.worldgen.dolomite")
		public OreSettings dolomite = new OreSettings(true, 0.0D, 0.02D, 1.0D, 4000);

		@RequiresMcRestart
		@LangKey("loi.config.worldgen.kassiteros")
		public OreSettings kassiteros = new OreSettings(true, 0.1D, 0.115D, 0.75D, 6000);

		@RequiresMcRestart
		@LangKey("loi.config.worldgen.molibos")
		public OreSettings molibos = new OreSettings(false, 0.2D, 0.21D, 0.5D, 8000);

		@RequiresMcRestart
		@LangKey("loi.config.worldgen.sliver")
		public OreSettings sliver = new OreSettings(false, -0.22D, -0.2D, 1.0D, 1000);

		@RequiresMcRestart
		@LangKey("loi.config.worldgen.vanadium")
		public OreSettings vanadium = new OreSettings(true, -0.31D, -0.3D, 0.5D, 3000);

		@RequiresMcRestart
		@LangKey("loi.config.worldgen.anthracite")
		public OreSettings anthracite = new OreSettings(true, 0.3D, 0.32D, 1.0D, 5000);

		@RequiresMcRestart
		@LangKey("loi.config.worldgen.sideros")
		public OreSettings sideros = new OreSettings(true, 0.4D, 0.415D, 0.75D, 7000);

		@RequiresMcRestart
		@LangKey("loi.config.worldgen.molybdenum")
		public OreSettings molybdenum = new OreSettings(true, 0.5D, 0.51D, 0.5D, 9000);

		@RequiresMcRestart
		@LangKey("loi.config.worldgen.hyliastrum")
		public OreSettings hyliastrum = new OreSettings(false, -0.62D, -0.6D, 1.0D, 0000);

		@RequiresMcRestart
		@LangKey("loi.config.worldgen.abyssalessence")
		public OreSettings abyssalEssence = new OreSettings(false, -0.615D, -0.6D, 0.75D, 2000);

		@RequiresMcRestart
		@LangKey("loi.config.worldgen.bluridium")
		public OreSettings bluridium = new OreSettings(false, -0.71D, -0.7D, 0.5D, 4000);

		@RequiresMcRestart
		@LangKey("loi.config.worldgen.ore.custom")
		@Comment("Here you can add custom blocks to ore generation"
				+ "\nSyntax is:"
				+ "\nmodID:itemID:metadata:rockLayer:indexBegin:indexEnd:noiseSize:offset"
				+ "\nmodID: The mod ID of the block."
				+ "\nitemID: The ID of the block."
				+ "\nmetadata: The metadata value of the block, usually 0."
				+ "\nrockLayer: The stone layer to generate in, yellowstone is 0, baetyl is 4."
				+ "\nindexBegin: Lower vein thickness value."
				+ "\nindexEnd: Upper vein thickness value."
				+ "\nnoiseSize: Scale of the generation noise."
				+ "\noffset: Offset that veins will be generated at in blocks."
				+ "\nExample: landsoficaria:soil:2:0:-0.06:-0.0:1.0:2000")
		public String[] custom = new String[] {};

		public static class OreSettings {

			@RequiresMcRestart
			@Name("enabled")
			@LangKey("loi.config.worldgen.ore.enabled")
			public boolean enabled;
			@RequiresMcRestart
			@Name("veinbegin")
			@LangKey("loi.config.worldgen.ore.indexbegin")
			@RangeDouble(min = -1.0D, max = 1.0D)
			public Double indexBegin;
			@RequiresMcRestart
			@Name("veinend")
			@LangKey("loi.config.worldgen.ore.indexend")
			@RangeDouble(min = -1.0D, max = 1.0D)
			public Double indexEnd;
			@RequiresMcRestart
			@Name("veinscale")
			@LangKey("loi.config.worldgen.ore.noisesize")
			public Double noiseSize;
			@RequiresMcRestart
			@Name("generationoffset")
			@LangKey("loi.config.worldgen.ore.offset")
			public int offset;

			public OreSettings (boolean enabled, Double indexBegin, Double indexEnd, Double noiseSize, int offset) {
				this.enabled = enabled;
				this.indexBegin = indexBegin;
				this.indexEnd = indexEnd;
				this.noiseSize = noiseSize;
				this.offset = offset;
			}
		}
	}

	@Name("rendering")
	@LangKey("loi.config.render")
	@Comment("Cross mod compatibility settings")
	public static CategoryRender render = new CategoryRender();

	public static class CategoryRender {

		@RequiresMcRestart
		@LangKey("loi.config.render.lights")
		public Boolean lights = true;

		@RequiresMcRestart
		@LangKey("loi.config.render.rays")
		public Integer rays = 75;

		@RequiresMcRestart
		@LangKey("loi.config.render.emissive")
		public Boolean emissiveTextures = true;

	}
}

package com.axanthic.loi;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.LangKey;
import net.minecraftforge.common.config.Config.Name;
import net.minecraftforge.common.config.Config.RequiresMcRestart;

@Config(modid = ModInformation.ID, name = ModInformation.ID, category = "")
public class LOIConfig {

	@Name("compatibility")
	@LangKey("loi.config.compat")
	@Comment("Cross mod compatibility settings")
	public static CategoryCompatibility compat = new CategoryCompatibility();

	public static class CategoryCompatibility {

		@RequiresMcRestart
		@LangKey("loi.config.compat.albedo")
		public Boolean albedo = true;

	}

	@Name("worldgeneration")
	@LangKey("loi.config.worldgen")
	@Comment("World Generation settings")
	public static CategoryWorldgen world = new CategoryWorldgen();

	public static class CategoryWorldgen {

		@RequiresMcRestart
		@LangKey("loi.config.worldgen.lignite")
		public OreSettings lignite = new OreSettings(-0.02F, -0.0F, 1.0F, 0000);

		@RequiresMcRestart
		@LangKey("loi.config.worldgen.chalkos")
		public OreSettings chalkos = new OreSettings(-0.115F, -0.1F, 0.75F, 2000);

		@RequiresMcRestart
		@LangKey("loi.config.worldgen.dolomite")
		public OreSettings dolomite = new OreSettings(0.0F, 0.02F, 1.0F, 4000);

		@RequiresMcRestart
		@LangKey("loi.config.worldgen.kassiteros")
		public OreSettings kassiteros = new OreSettings(0.1F, 0.115F, 0.75F, 6000);

		@RequiresMcRestart
		@LangKey("loi.config.worldgen.molibos")
		public OreSettings molibos = new OreSettings(0.2F, 0.21F, 0.5F, 8000);

		@RequiresMcRestart
		@LangKey("loi.config.worldgen.sliver")
		public OreSettings sliver = new OreSettings(-0.22F, -0.2F, 1.0F, 1000);

		@RequiresMcRestart
		@LangKey("loi.config.worldgen.vanadium")
		public OreSettings vanadium = new OreSettings(-0.31F, -0.3F, 0.5F, 3000);

		@RequiresMcRestart
		@LangKey("loi.config.worldgen.anthracite")
		public OreSettings anthracite = new OreSettings(0.3F, 0.32F, 1.0F, 5000);

		@RequiresMcRestart
		@LangKey("loi.config.worldgen.sideros")
		public OreSettings sideros = new OreSettings(0.4F, 0.415F, 0.75F, 7000);

		@RequiresMcRestart
		@LangKey("loi.config.worldgen.molybdenum")
		public OreSettings molybdenum = new OreSettings(0.5F, 0.51F, 0.5F, 9000);

		@RequiresMcRestart
		@LangKey("loi.config.worldgen.hyliastrum")
		public OreSettings hyliastrum = new OreSettings(-0.62F, -0.6F, 1.0F, 0000);

		@RequiresMcRestart
		@LangKey("loi.config.worldgen.abyssalessence")
		public OreSettings abyssalEssence = new OreSettings(-0.615F, -0.6F, 0.75F, 2000);

		@RequiresMcRestart
		@LangKey("loi.config.worldgen.bluridium")
		public OreSettings bluridium = new OreSettings(-0.71F, -0.7F, 0.5F, 4000);

		public static class OreSettings {

			@RequiresMcRestart
			@Name("veinbegin")
			@LangKey("loi.config.worldgen.ore.indexbegin")
			public Float indexBegin;
			@RequiresMcRestart
			@Name("veinend")
			@LangKey("loi.config.worldgen.ore.indexend")
			public Float indexEnd;
			@RequiresMcRestart
			@Name("veinscale")
			@LangKey("loi.config.worldgen.ore.noisesize")
			public Float noiseSize;
			@RequiresMcRestart
			@Name("generationoffset")
			@LangKey("loi.config.worldgen.ore.offset")
			public int offset;

			public OreSettings (Float indexBegin, Float indexEnd, Float noiseSize, int offset) {
				this.indexBegin = indexBegin;
				this.indexEnd = indexEnd;
				this.noiseSize = noiseSize;
				this.offset = offset;
			}
		}
	}
}

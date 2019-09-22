package com.axanthic.blab;

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
}

package com.axanthic.icaria.client.renderer;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.client.renderer.state.level.LevelRenderState;
import net.minecraft.client.renderer.state.level.SkyRenderState;

import net.neoforged.neoforge.client.CustomSkyboxRenderer;

import org.joml.Matrix4fc;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class SkyboxRenderer implements CustomSkyboxRenderer {

	@Override
	public boolean renderSky(LevelRenderState pLevelRenderState, SkyRenderState pSkyRenderState, Matrix4fc pMatrix4fc, Runnable pRunnable) {
		return true;
	}
}

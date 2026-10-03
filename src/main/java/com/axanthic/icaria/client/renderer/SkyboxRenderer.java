package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;

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

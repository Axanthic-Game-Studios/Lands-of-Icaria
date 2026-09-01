package com.axanthic.icaria.client.renderer;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.client.renderer.state.LevelRenderState;
import net.minecraft.client.renderer.state.SkyRenderState;

import net.neoforged.neoforge.client.CustomSkyboxRenderer;

import org.joml.Matrix4f;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class SkyboxRenderer implements CustomSkyboxRenderer {

	@Override
	public boolean renderSky(LevelRenderState pLevelRenderState, SkyRenderState pSkyRenderState, Matrix4f pMatrix4f, Runnable pRunnable) {
		return true;
	}
}

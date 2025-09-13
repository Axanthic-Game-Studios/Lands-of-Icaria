package com.axanthic.icaria.client.state;

import com.axanthic.icaria.common.variant.FicheVariant;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.core.Holder;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class FicheRenderState extends LivingEntityRenderState {
	public float renderScale;
	public float shadowScale;
	public int id;
	public Holder<FicheVariant> ficheVariant;
}

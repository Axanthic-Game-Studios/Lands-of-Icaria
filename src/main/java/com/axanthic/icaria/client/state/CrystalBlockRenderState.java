package com.axanthic.icaria.client.state;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CrystalBlockRenderState extends BlockEntityRenderState {
	public double x;
	public double y;
	public double z;
	public float red;
	public float green;
	public float blue;
}

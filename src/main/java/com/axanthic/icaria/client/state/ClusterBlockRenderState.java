package com.axanthic.icaria.client.state;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;

import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ClusterBlockRenderState extends BlockEntityRenderState {
	public double x;
	public double y;
	public double z;
	public float red;
	public float green;
	public float blue;
}

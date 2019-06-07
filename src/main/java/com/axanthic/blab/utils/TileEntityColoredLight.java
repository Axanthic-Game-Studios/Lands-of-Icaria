package com.axanthic.blab.utils;

import elucent.albedo.lighting.Light;
import elucent.albedo.lighting.ILightProvider;
import net.minecraft.tileentity.TileEntity;

public class TileEntityColoredLight extends TileEntity implements ILightProvider {

	Float r = 1.0F;
	Float g = 0.5F;
	Float b = 0.0F;

	public TileEntityColoredLight() {
		super();
	}

	public TileEntityColoredLight(Float r, Float g, Float b) {
		this();
		this.r = r;
		this.g = g;
		this.b = b;
	}

	@Override
	public Light provideLight() {
		return new Light.Builder().pos(pos).color(r, g, b, 1F).radius(15).build();
	}
}

package com.axanthic.loi.tileentity;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;

public class TileEntityColoredLight extends TileEntity {//implements ILightProvider, ILightEventConsumer {

	public Float r = 1.0F;
	public Float g = 0.5F;
	public Float b = 0.0F;

	public EnumFacing offset = null;

	public TileEntityColoredLight() {
		super();
	}

	public TileEntityColoredLight(Float r, Float g, Float b) {
		this();
		this.r = r;
		this.g = g;
		this.b = b;
	}

	public TileEntityColoredLight setOffset(EnumFacing offset) {
		this.offset = offset;
		return this;
	}

	@Override
	public AxisAlignedBB getRenderBoundingBox() {
		return new AxisAlignedBB(getPos().add(-2, -2, -2), getPos().add(3, 3, 3));
	}

	/*@Override
	public Light provideLight() {
		return new Light.Builder().pos(pos).color(r, g, b, 1F).radius(15).build();
	}

	@Override
	public void gatherLights(GatherLightsEvent arg0, Entity arg1) {

	}

	@Override
	public void gatherLights(com.elytradev.mirage.event.GatherLightsEvent evt) {
		evt.add(com.elytradev.mirage.lighting.Light.builder().pos(pos).color(r, g, b).radius(4).build());
	}*/
}

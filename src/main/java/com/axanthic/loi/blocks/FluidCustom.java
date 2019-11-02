package com.axanthic.loi.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

public class FluidCustom extends Fluid {

	protected int mapColor = 0xFFFFFFFF;
	protected float overlayAlpha = 0.2F;
	protected SoundEvent emptySound = SoundEvents.ITEM_BUCKET_EMPTY;
	protected SoundEvent fillSound = SoundEvents.ITEM_BUCKET_FILL;
	protected Material material = Material.WATER;

	public FluidCustom(String fluidName, ResourceLocation still, ResourceLocation flowing) {
		super(fluidName, still, flowing);
	}

	public FluidCustom(String fluidName, ResourceLocation still, ResourceLocation flowing, int mapColor) {
		this(fluidName, still, flowing);
		setColor(mapColor);
	}

	public FluidCustom(String fluidName, ResourceLocation still, ResourceLocation flowing, int mapColor, float overlayAlpha) {
		this(fluidName, still, flowing, mapColor);
		setAlpha(overlayAlpha);
	}

	@Override
	public int getColor() {
		return mapColor;
	}

	public FluidCustom setColor(int parColor) {
		mapColor = parColor;
		return this;
	}

	public float getAlpha() {
		return overlayAlpha;
	}

	public FluidCustom setAlpha(float parOverlayAlpha) {
		overlayAlpha = parOverlayAlpha;
		return this;
	}

	@Override
	public FluidCustom setEmptySound(SoundEvent parSound) {
		emptySound = parSound;
		return this;
	}

	@Override
	public SoundEvent getEmptySound() {
		return emptySound;
	}

	@Override
	public FluidCustom setFillSound(SoundEvent parSound) {
		fillSound = parSound;
		return this;
	}

	@Override
	public SoundEvent getFillSound() {
		return fillSound;
	}

	public FluidCustom setMaterial(Material parMaterial) {
		material = parMaterial;
		return this;
	}

	public Material getMaterial() {
		return material;
	}

	@Override
	public boolean doesVaporize(FluidStack fluidStack) {
		if (block == null)
			return false;
		return block.getDefaultState().getMaterial() == getMaterial();
	}
}

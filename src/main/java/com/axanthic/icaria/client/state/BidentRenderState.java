package com.axanthic.icaria.client.state;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.world.item.ItemStack;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class BidentRenderState extends EntityRenderState {
	public float xRot;
	public float yRot;
	public ItemStack itemStack;
	public ItemStackRenderState itemStackRenderState;
}

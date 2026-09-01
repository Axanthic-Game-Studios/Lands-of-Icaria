package com.axanthic.icaria.client.state;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.decoration.painting.PaintingVariant;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class RugRenderState extends EntityRenderState {
	public Direction direction;
	public Direction placementDirection;
	public Holder<PaintingVariant> paintingVariant;
}

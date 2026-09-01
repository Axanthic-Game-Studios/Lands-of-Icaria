package com.axanthic.icaria.client.state;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class HutchBlockRenderState extends BlockEntityRenderState {
	public double bottomLeftAngle;
	public double bottomRightAngle;
	public double topLeftAngle;
	public double topRightAngle;
	public BlockState blockState;
	public ItemStackRenderState bottomLeftItem;
	public ItemStackRenderState bottomRightItem;
	public ItemStackRenderState topLeftItem;
	public ItemStackRenderState topRightItem;
	public Level level;
}

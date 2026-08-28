package com.axanthic.icaria.client.state;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GrinderBlockRenderState extends BlockEntityRenderState {
	public boolean tickClient;
	public BlockState blockState;
	public ItemStackRenderState gear;
	public ItemStackRenderState shaft;
	public ItemStackRenderState stone;
	public ItemStackRenderState leftChain;
	public ItemStackRenderState rightChain;
	public ItemStackRenderState staticLeftChain;
	public ItemStackRenderState staticRightChain;
	public Level level;
}

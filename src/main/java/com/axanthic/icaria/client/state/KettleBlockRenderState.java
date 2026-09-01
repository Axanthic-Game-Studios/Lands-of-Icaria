package com.axanthic.icaria.client.state;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class KettleBlockRenderState extends BlockEntityRenderState {
	public int color;
	public int maxProgress;
	public int progress;
	public BlockPos blockPos;
	public BlockState blockState;
	public ItemStackRenderState intakeA;
	public ItemStackRenderState intakeB;
	public ItemStackRenderState intakeC;
	public Level level;
}

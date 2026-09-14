package com.axanthic.icaria.client.state;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.client.renderer.block.BlockModelRenderState;
import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.world.item.ItemStack;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class FlowerPotCountertopBlockRenderState extends BlockEntityRenderState {
	public BlockModelRenderState blockModelRenderState;
	public ItemStack itemStack;
}

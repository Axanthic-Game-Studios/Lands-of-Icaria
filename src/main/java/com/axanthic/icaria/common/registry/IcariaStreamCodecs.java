package com.axanthic.icaria.common.registry;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import io.netty.buffer.ByteBuf;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.level.block.state.BlockState;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaStreamCodecs {
	public static final StreamCodec<ByteBuf, BlockState> BLOCK_STATE = ByteBufCodecs.fromCodec(BlockState.CODEC);
}

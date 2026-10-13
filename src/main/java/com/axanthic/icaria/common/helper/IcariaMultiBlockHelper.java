package com.axanthic.icaria.common.helper;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.enums.*;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;

import net.minecraft.world.level.block.state.BlockState;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaMultiBlockHelper {

	public static boolean hasValue(BlockState pBlockState, DepthPair pDepthPair, HeightPair pHeightPair) {
		return pBlockState.getValue(IcariaBlockStateProperties.DEPTH_PAIR) == pDepthPair && pBlockState.getValue(IcariaBlockStateProperties.HEIGHT_PAIR) == pHeightPair;
	}

	public static boolean hasValue(BlockState pBlockState, DepthPair pDepthPair, WidthPair pWidthPair) {
		return pBlockState.getValue(IcariaBlockStateProperties.DEPTH_PAIR) == pDepthPair && pBlockState.getValue(IcariaBlockStateProperties.WIDTH_PAIR) == pWidthPair;
	}

	public static boolean hasValue(BlockState pBlockState, HeightPair pHeightPair, WidthPair pWidthPair) {
		return pBlockState.getValue(IcariaBlockStateProperties.HEIGHT_PAIR) == pHeightPair && pBlockState.getValue(IcariaBlockStateProperties.WIDTH_PAIR) == pWidthPair;
	}

	public static boolean hasValue(BlockState pBlockState, DepthPair pDepthPair, HeightPair pHeightPair, WidthPair pWidthPair) {
		return pBlockState.getValue(IcariaBlockStateProperties.DEPTH_PAIR) == pDepthPair && pBlockState.getValue(IcariaBlockStateProperties.HEIGHT_PAIR) == pHeightPair && pBlockState.getValue(IcariaBlockStateProperties.WIDTH_PAIR) == pWidthPair;
	}

	public static boolean hasValue(BlockState pBlockState, DepthSpan pDepthSpan, HeightSpan pHeightSpan) {
		return pBlockState.getValue(IcariaBlockStateProperties.DEPTH_SPAN) == pDepthSpan && pBlockState.getValue(IcariaBlockStateProperties.HEIGHT_SPAN) == pHeightSpan;
	}

	public static boolean hasValue(BlockState pBlockState, DepthSpan pDepthSpan, WidthSpan pWidthSpan) {
		return pBlockState.getValue(IcariaBlockStateProperties.DEPTH_SPAN) == pDepthSpan && pBlockState.getValue(IcariaBlockStateProperties.WIDTH_SPAN) == pWidthSpan;
	}

	public static boolean hasValue(BlockState pBlockState, HeightSpan pHeightSpan, WidthSpan pWidthSpan) {
		return pBlockState.getValue(IcariaBlockStateProperties.HEIGHT_SPAN) == pHeightSpan && pBlockState.getValue(IcariaBlockStateProperties.WIDTH_SPAN) == pWidthSpan;
	}

	public static boolean hasValue(BlockState pBlockState, DepthSpan pDepthSpan, HeightSpan pHeightSpan, WidthSpan pWidthSpan) {
		return pBlockState.getValue(IcariaBlockStateProperties.DEPTH_SPAN) == pDepthSpan && pBlockState.getValue(IcariaBlockStateProperties.HEIGHT_SPAN) == pHeightSpan && pBlockState.getValue(IcariaBlockStateProperties.WIDTH_SPAN) == pWidthSpan;
	}

	public static BlockState setValue(BlockState pBlockState, DepthPair pDepthPair, HeightPair pHeightPair) {
		return pBlockState.setValue(IcariaBlockStateProperties.DEPTH_PAIR, pDepthPair).setValue(IcariaBlockStateProperties.HEIGHT_PAIR, pHeightPair);
	}

	public static BlockState setValue(BlockState pBlockState, DepthPair pDepthPair, WidthPair pWidthPair) {
		return pBlockState.setValue(IcariaBlockStateProperties.DEPTH_PAIR, pDepthPair).setValue(IcariaBlockStateProperties.WIDTH_PAIR, pWidthPair);
	}

	public static BlockState setValue(BlockState pBlockState, HeightPair pHeightPair, WidthPair pWidthPair) {
		return pBlockState.setValue(IcariaBlockStateProperties.HEIGHT_PAIR, pHeightPair).setValue(IcariaBlockStateProperties.WIDTH_PAIR, pWidthPair);
	}

	public static BlockState setValue(BlockState pBlockState, DepthPair pDepthPair, HeightPair pHeightPair, WidthPair pWidthPair) {
		return pBlockState.setValue(IcariaBlockStateProperties.DEPTH_PAIR, pDepthPair).setValue(IcariaBlockStateProperties.HEIGHT_PAIR, pHeightPair).setValue(IcariaBlockStateProperties.WIDTH_PAIR, pWidthPair);
	}

	public static BlockState setValue(BlockState pBlockState, DepthSpan pDepthSpan, HeightSpan pHeightSpan) {
		return pBlockState.setValue(IcariaBlockStateProperties.DEPTH_SPAN, pDepthSpan).setValue(IcariaBlockStateProperties.HEIGHT_SPAN, pHeightSpan);
	}

	public static BlockState setValue(BlockState pBlockState, DepthSpan pDepthSpan, WidthSpan pWidthSpan) {
		return pBlockState.setValue(IcariaBlockStateProperties.DEPTH_SPAN, pDepthSpan).setValue(IcariaBlockStateProperties.WIDTH_SPAN, pWidthSpan);
	}

	public static BlockState setValue(BlockState pBlockState, HeightSpan pHeightSpan, WidthSpan pWidthSpan) {
		return pBlockState.setValue(IcariaBlockStateProperties.HEIGHT_SPAN, pHeightSpan).setValue(IcariaBlockStateProperties.WIDTH_SPAN, pWidthSpan);
	}

	public static BlockState setValue(BlockState pBlockState, DepthSpan pDepthSpan, HeightSpan pHeightSpan, WidthSpan pWidthSpan) {
		return pBlockState.setValue(IcariaBlockStateProperties.DEPTH_SPAN, pDepthSpan).setValue(IcariaBlockStateProperties.HEIGHT_SPAN, pHeightSpan).setValue(IcariaBlockStateProperties.WIDTH_SPAN, pWidthSpan);
	}
}

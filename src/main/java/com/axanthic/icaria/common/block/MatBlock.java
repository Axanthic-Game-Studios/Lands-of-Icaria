package com.axanthic.icaria.common.block;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.properties.Mat;

import net.minecraft.world.level.block.CarpetBlock;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class MatBlock extends CarpetBlock {
	public Mat mat;

	public MatBlock(Mat pMat, Properties pProperties) {
		super(pProperties);
		this.mat = pMat;
	}

	public Mat getMat() {
		return this.mat;
	}
}

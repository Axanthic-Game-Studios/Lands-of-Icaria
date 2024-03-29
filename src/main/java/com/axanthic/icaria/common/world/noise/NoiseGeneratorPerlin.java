package com.axanthic.icaria.common.world.noise;

import java.util.Random;

public class NoiseGeneratorPerlin extends NoiseGenerator {
	private final NoiseGeneratorSimplex[] field_151603_a;
	private final int field_151602_b;

	public NoiseGeneratorPerlin(final Random p_i45470_1_, final int p_i45470_2_) {
		this.field_151602_b = p_i45470_2_;
		this.field_151603_a = new NoiseGeneratorSimplex[p_i45470_2_];

		for (int i = 0; i < p_i45470_2_; ++i) {
			this.field_151603_a[i] = new NoiseGeneratorSimplex(p_i45470_1_);
		}
	}

	public double func_151601_a(final double p_151601_1_, final double p_151601_3_) {
		double d0 = 0.0D;
		double d1 = 1.0D;

		for (int i = 0; i < this.field_151602_b; ++i) {
			d0 += this.field_151603_a[i].func_151605_a(p_151601_1_ * d1, p_151601_3_ * d1) / d1;
			d1 /= 2.0D;
		}

		return d0;
	}

	public double[] getRegion(final double[] p_151599_1_, final double p_151599_2_, final double p_151599_4_,
			final int p_151599_6_, final int p_151599_7_, final double p_151599_8_, final double p_151599_10_,
			final double p_151599_12_) {
		return this.getRegion(p_151599_1_, p_151599_2_, p_151599_4_, p_151599_6_, p_151599_7_, p_151599_8_,
				p_151599_10_, p_151599_12_, 0.5D);
	}

	public double[] getRegion(double[] p_151600_1_, final double p_151600_2_, final double p_151600_4_,
			final int p_151600_6_, final int p_151600_7_, final double p_151600_8_, final double p_151600_10_,
			final double p_151600_12_, final double p_151600_14_) {
		if (p_151600_1_ != null && p_151600_1_.length >= p_151600_6_ * p_151600_7_) {
			for (int i = 0; i < p_151600_1_.length; ++i) {
				p_151600_1_[i] = 0.0D;
			}
		} else {
			p_151600_1_ = new double[p_151600_6_ * p_151600_7_];
		}

		double d1 = 1.0D;
		double d0 = 1.0D;

		for (int j = 0; j < this.field_151602_b; ++j) {
			this.field_151603_a[j].func_151606_a(p_151600_1_, p_151600_2_, p_151600_4_, p_151600_6_, p_151600_7_,
					p_151600_8_ * d0 * d1, p_151600_10_ * d0 * d1, 0.55D / d1);
			d0 *= p_151600_12_;
			d1 *= p_151600_14_;
		}

		return p_151600_1_;
	}
}
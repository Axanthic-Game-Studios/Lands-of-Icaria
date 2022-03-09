package com.axanthic.icaria.common.fluids;

import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.fluids.ForgeFlowingFluid;

public abstract class UpwardsFluid extends ForgeFlowingFluid {
	public UpwardsFluid(Properties properties) {
		super(properties);
	}

	public static class Source extends UpwardsFluid {
		public Source(Properties properties) {
			super(properties);
		}

		public int getAmount(final FluidState state) {
			return 8;
		}

		public boolean isSource(final FluidState state) {
			return true;
		}
	}

	public static class Flowing extends UpwardsFluid {
		public Flowing(Properties properties) {
			super(properties);
		}

		public void createFluidStateDefinition(final StateDefinition.Builder<Fluid, FluidState> builder) {
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}

		public int getAmount(final FluidState state) {
			return state.getValue(LEVEL);
		}

		public boolean isSource(final FluidState state) {
			return false;
		}
	}
}

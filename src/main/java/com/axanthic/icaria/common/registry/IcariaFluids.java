package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.client.util.IcariaFluidTypeRenderProperties;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.pathfinder.BlockPathTypes;

import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.common.util.NonNullFunction;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Consumer;

public class IcariaFluids {
	public static final ResourceLocation MEDITERRANEAN_WATER_TEXTURE_FLOWING = new ResourceLocation(IcariaInfo.MODID + ":block/mediterranean_water_flowing");
	public static final ResourceLocation MEDITERRANEAN_WATER_TEXTURE_STILL = new ResourceLocation(IcariaInfo.MODID + ":block/mediterranean_water_still");
	public static final ResourceLocation MEDITERRANEAN_WATER_TEXTURE_OVERLAY = new ResourceLocation(IcariaInfo.MODID + ":textures/block/mediterranean_water_overlay.png");

	public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, IcariaInfo.MODID);
	public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, IcariaInfo.MODID);

	public static RegistryObject<FlowingFluid> MEDITERRANEAN_WATER_FLOWING;
	public static RegistryObject<FlowingFluid> MEDITERRANEAN_WATER_SOURCE;

	public static RegistryObject<FluidType> MEDITERRANEAN_WATER_TYPE;

	public static RegistryObject<FlowingFluid> registerMediterraneanWater(String name, NonNullFunction<ForgeFlowingFluid.Properties, FlowingFluid> factory) {
		return FLUIDS.register(name, () -> factory.apply((new ForgeFlowingFluid.Properties(MEDITERRANEAN_WATER_TYPE, MEDITERRANEAN_WATER_SOURCE, MEDITERRANEAN_WATER_FLOWING)).bucket(IcariaItems.MEDITERRANEAN_WATER_BUCKET).block(IcariaBlocks.MEDITERRANEAN_WATER)));
	}

	static {
		MEDITERRANEAN_WATER_TYPE = FLUID_TYPES.register("mediterranean_water", () -> new FluidType(FluidType.Properties.create()
			.descriptionId("fluid.landsoficaria.mediterranean_water")
			.motionScale(0.014)
			.canPushEntity(true)
			.canSwim(true)
			.canDrown(true)
			.fallDistanceModifier(0)
			.canExtinguish(true)
			.canConvertToSource(true)
			.supportsBoating(true)
			.pathType(BlockPathTypes.WATER)
			.canHydrate(true)
			.lightLevel(0)
			.density(1000)
			.temperature(300)
			.viscosity(1000)
			.sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
			.sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)) {
			@Override
			public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
				consumer.accept(new IcariaFluidTypeRenderProperties(MEDITERRANEAN_WATER_TEXTURE_STILL, MEDITERRANEAN_WATER_TEXTURE_FLOWING, MEDITERRANEAN_WATER_TEXTURE_OVERLAY));
			}
		});

		MEDITERRANEAN_WATER_SOURCE = registerMediterraneanWater("mediterranean_water", ForgeFlowingFluid.Source::new);
		MEDITERRANEAN_WATER_FLOWING = registerMediterraneanWater("mediterranean_water_flowing", ForgeFlowingFluid.Flowing::new);
	}
}

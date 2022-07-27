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
	public static final ResourceLocation HYLIASTRUM_FLUID_TEXTURE_FLOWING = new ResourceLocation(IcariaInfo.MODID + ":block/hyliastrum_fluid_flowing");
	public static final ResourceLocation HYLIASTRUM_FLUID_TEXTURE_STILL = new ResourceLocation(IcariaInfo.MODID + ":block/hyliastrum_fluid_still");
	public static final ResourceLocation HYLIASTRUM_FLUID_TEXTURE_OVERLAY = new ResourceLocation(IcariaInfo.MODID + ":textures/block/hyliastrum_fluid_overlay.png");
	public static final ResourceLocation MEDITERRANEAN_WATER_TEXTURE_FLOWING = new ResourceLocation(IcariaInfo.MODID + ":block/mediterranean_water_flowing");
	public static final ResourceLocation MEDITERRANEAN_WATER_TEXTURE_STILL = new ResourceLocation(IcariaInfo.MODID + ":block/mediterranean_water_still");
	public static final ResourceLocation MEDITERRANEAN_WATER_TEXTURE_OVERLAY = new ResourceLocation(IcariaInfo.MODID + ":textures/block/mediterranean_water_overlay.png");
	public static final ResourceLocation UPWARDS_FLUID_TEXTURE_FLOWING = new ResourceLocation(IcariaInfo.MODID + ":block/upwards_fluid_flowing");
	public static final ResourceLocation UPWARDS_FLUID_TEXTURE_STILL = new ResourceLocation(IcariaInfo.MODID + ":block/upwards_fluid_still");
	public static final ResourceLocation UPWARDS_FLUID_TEXTURE_OVERLAY = new ResourceLocation(IcariaInfo.MODID + ":textures/block/upwards_fluid_overlay.png");

	public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, IcariaInfo.MODID);
	public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, IcariaInfo.MODID);

	public static final RegistryObject<FlowingFluid> HYLIASTRUM_FLUID_FLOWING;
	public static final RegistryObject<FlowingFluid> HYLIASTRUM_FLUID_SOURCE;
	public static final RegistryObject<FlowingFluid> MEDITERRANEAN_WATER_FLOWING;
	public static final RegistryObject<FlowingFluid> MEDITERRANEAN_WATER_SOURCE;
	public static final RegistryObject<FlowingFluid> UPWARDS_FLUID_FLOWING;
	public static final RegistryObject<FlowingFluid> UPWARDS_FLUID_SOURCE;

	public static final RegistryObject<FluidType> HYLIASTRUM_FLUID_TYPE;
	public static final RegistryObject<FluidType> MEDITERRANEAN_WATER_TYPE;
	public static final RegistryObject<FluidType> UPWARDS_FLUID_TYPE;

	public static RegistryObject<FlowingFluid> registerHyliastrumFluid(String name, NonNullFunction<ForgeFlowingFluid.Properties, FlowingFluid> factory) {
		return FLUIDS.register(name, () -> factory.apply((new ForgeFlowingFluid.Properties(HYLIASTRUM_FLUID_TYPE, HYLIASTRUM_FLUID_SOURCE, HYLIASTRUM_FLUID_FLOWING)).bucket(IcariaItems.HYLIASTRUM_FLUID_BUCKET).block(IcariaBlocks.HYLIASTRUM_FLUID)));
	}

	public static RegistryObject<FlowingFluid> registerMediterraneanWater(String name, NonNullFunction<ForgeFlowingFluid.Properties, FlowingFluid> factory) {
		return FLUIDS.register(name, () -> factory.apply((new ForgeFlowingFluid.Properties(MEDITERRANEAN_WATER_TYPE, MEDITERRANEAN_WATER_SOURCE, MEDITERRANEAN_WATER_FLOWING)).bucket(IcariaItems.MEDITERRANEAN_WATER_BUCKET).block(IcariaBlocks.MEDITERRANEAN_WATER)));
	}

	public static RegistryObject<FlowingFluid> registerUpwardsFluid(String name, NonNullFunction<ForgeFlowingFluid.Properties, FlowingFluid> factory) {
		return FLUIDS.register(name, () -> factory.apply((new ForgeFlowingFluid.Properties(UPWARDS_FLUID_TYPE, UPWARDS_FLUID_SOURCE, UPWARDS_FLUID_FLOWING)).bucket(IcariaItems.UPWARDS_FLUID_BUCKET).block(IcariaBlocks.UPWARDS_FLUID)));
	}

	static {
		HYLIASTRUM_FLUID_TYPE = FLUID_TYPES.register("hyliastrum_fluid", () -> new FluidType(FluidType.Properties.create()
			.descriptionId("fluid.landsoficaria.hyliastrum_fluid")
			.motionScale(0.0023)
			.canPushEntity(true)
			.canSwim(false)
			.canDrown(false)
			.fallDistanceModifier(0.5F)
			.canExtinguish(false)
			.canConvertToSource(false)
			.supportsBoating(false)
			.pathType(BlockPathTypes.LAVA)
			.canHydrate(false)
			.lightLevel(15)
			.density(3000)
			.temperature(1300)
			.viscosity(6000)
			.sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
			.sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)) {
			@Override
			public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
				consumer.accept(new IcariaFluidTypeRenderProperties(HYLIASTRUM_FLUID_TEXTURE_STILL, HYLIASTRUM_FLUID_TEXTURE_FLOWING, HYLIASTRUM_FLUID_TEXTURE_OVERLAY));
			}
		});

		HYLIASTRUM_FLUID_SOURCE = registerHyliastrumFluid("hyliastrum_fluid", ForgeFlowingFluid.Source::new);
		HYLIASTRUM_FLUID_FLOWING = registerHyliastrumFluid("hyliastrum_fluid_flowing", ForgeFlowingFluid.Flowing::new);

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

		UPWARDS_FLUID_TYPE = FLUID_TYPES.register("upwards_fluid", () -> new FluidType(FluidType.Properties.create()
			.descriptionId("fluid.landsoficaria.upwards_fluid")
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
			.lightLevel(15)
			.density(-1000)
			.temperature(300)
			.viscosity(1000)
			.sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
			.sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)) {
			@Override
			public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
				consumer.accept(new IcariaFluidTypeRenderProperties(UPWARDS_FLUID_TEXTURE_STILL, UPWARDS_FLUID_TEXTURE_FLOWING, UPWARDS_FLUID_TEXTURE_OVERLAY));
			}
		});

		UPWARDS_FLUID_SOURCE = registerUpwardsFluid("upwards_fluid", ForgeFlowingFluid.Source::new);
		UPWARDS_FLUID_FLOWING = registerUpwardsFluid("upwards_fluid_flowing", ForgeFlowingFluid.Flowing::new);
	}
}

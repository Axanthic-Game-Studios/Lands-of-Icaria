package com.axanthic.loi;

import com.axanthic.loi.blocks.FluidCustom;

import java.awt.Color;

import com.axanthic.loi.blocks.BlockFluidCustom;
import com.axanthic.loi.blocks.BlockFluidUpwards;

import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidRegistry;

public class LOIFluids {

	public static final FluidCustom waterFluid = (FluidCustom) new FluidCustom("mediterranean_water",
			new ResourceLocation(ModInformation.ID, "blocks/fluid_mediterranean_water_still"),
			new ResourceLocation(ModInformation.ID, "blocks/fluid_mediterranean_water_flow"))
					.setMaterial(Material.WATER).setDensity(1100).setGaseous(false).setViscosity(1000)
					.setTemperature(300).setColor(0xFF51A18B);
	public static ItemBlock waterFluidBlock;

	public static final FluidCustom gasFluid = (FluidCustom) new FluidCustom("gas",
			new ResourceLocation(ModInformation.ID, "blocks/fluid_upwards_still"),
			new ResourceLocation(ModInformation.ID, "blocks/fluid_upwards_flow")).setMaterial(Material.WATER)
					.setDensity(-1000).setGaseous(false).setLuminosity(15).setViscosity(1000).setTemperature(1300)
					.setColor(0xFFF3BF61);
	public static ItemBlock gasFluidBlock;

	public static final FluidCustom voidFluid = (FluidCustom) new FluidCustom("hyliastrum_fluid",
			new ResourceLocation(ModInformation.ID, "blocks/fluid_hyliastrum_still"),
			new ResourceLocation(ModInformation.ID, "blocks/fluid_hyliastrum_flow")).setMaterial(Material.LAVA)
					.setDensity(300).setGaseous(false).setViscosity(3000).setTemperature(300).setColor(new Color(0,0,0,0));
	public static ItemBlock voidFluidBlock;

	public static void registerFluids() {
		FluidRegistry.registerFluid(waterFluid);
		FluidRegistry.addBucketForFluid(waterFluid);
		waterFluidBlock = new ItemBlock(new BlockFluidCustom(waterFluid, Material.WATER).canCreateSources(true));
		waterFluid.setBlock(waterFluidBlock.getBlock());
		Resources.registerBlock(waterFluidBlock);

		FluidRegistry.registerFluid(gasFluid);
		FluidRegistry.addBucketForFluid(gasFluid);
		gasFluidBlock = new ItemBlock(new BlockFluidUpwards(gasFluid, Material.WATER));
		gasFluid.setBlock(gasFluidBlock.getBlock());
		Resources.registerBlock(gasFluidBlock);

		FluidRegistry.registerFluid(voidFluid);
		FluidRegistry.addBucketForFluid(voidFluid);
		voidFluidBlock = new ItemBlock(new BlockFluidCustom(voidFluid, Material.LAVA).canCreateSources(false));
		voidFluid.setBlock(voidFluidBlock.getBlock());
		Resources.registerBlock(voidFluidBlock);
	}

}

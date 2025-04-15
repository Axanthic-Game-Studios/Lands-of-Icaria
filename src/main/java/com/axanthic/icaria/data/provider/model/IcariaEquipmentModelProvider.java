package com.axanthic.icaria.data.provider.model;

import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.models.EquipmentModelProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.equipment.EquipmentModel;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaEquipmentModelProvider extends EquipmentModelProvider {
	public PackOutput.PathProvider pathProvider;

	public IcariaEquipmentModelProvider(PackOutput pPackOutput) {
		super(pPackOutput);
		this.pathProvider = pPackOutput.createPathProvider(PackOutput.Target.RESOURCE_PACK, "models/equipment");
	}

	@Override
	public CompletableFuture<?> run(CachedOutput pCachedOutput) {
		var hashMap = new HashMap<ResourceLocation, EquipmentModel>();
		hashMap.put(IcariaResourceLocations.AETERNAE_HIDE, EquipmentModel.builder().addHumanoidLayers(IcariaResourceLocations.AETERNAE_HIDE, false).build());
		hashMap.put(IcariaResourceLocations.CHALKOS, EquipmentModel.builder().addHumanoidLayers(IcariaResourceLocations.CHALKOS, false).build());
		hashMap.put(IcariaResourceLocations.KASSITEROS, EquipmentModel.builder().addHumanoidLayers(IcariaResourceLocations.KASSITEROS, false).build());
		hashMap.put(IcariaResourceLocations.ORICHALCUM, EquipmentModel.builder().addHumanoidLayers(IcariaResourceLocations.ORICHALCUM, false).build());
		hashMap.put(IcariaResourceLocations.VANADIUMSTEEL, EquipmentModel.builder().addHumanoidLayers(IcariaResourceLocations.VANADIUMSTEEL, false).build());
		hashMap.put(IcariaResourceLocations.LAUREL, EquipmentModel.builder().addMainHumanoidLayer(IcariaResourceLocations.LAUREL, false).build());
		return DataProvider.saveAll(pCachedOutput, EquipmentModel.CODEC, this.pathProvider, hashMap);
	}
}

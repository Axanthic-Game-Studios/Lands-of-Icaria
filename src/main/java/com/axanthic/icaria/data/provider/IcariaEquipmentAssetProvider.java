package com.axanthic.icaria.data.provider;

import com.axanthic.icaria.common.registry.IcariaResourceLocations;
import com.axanthic.icaria.data.registry.IcariaEquipmentAssets;

import java.util.function.BiConsumer;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.data.models.EquipmentAssetProvider;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.EquipmentAsset;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaEquipmentAssetProvider extends EquipmentAssetProvider {
	public IcariaEquipmentAssetProvider(PackOutput pPackOutput) {
		super(pPackOutput);
	}

	@Override
	public void registerModels(BiConsumer<ResourceKey<EquipmentAsset>, EquipmentClientInfo> pBiConsumer) {
		pBiConsumer.accept(IcariaEquipmentAssets.AETERNAE_HIDE, EquipmentClientInfo.builder().addHumanoidLayers(IcariaResourceLocations.AETERNAE_HIDE, false).build());
		pBiConsumer.accept(IcariaEquipmentAssets.CHALKOS, EquipmentClientInfo.builder().addHumanoidLayers(IcariaResourceLocations.CHALKOS, false).build());
		pBiConsumer.accept(IcariaEquipmentAssets.KASSITEROS, EquipmentClientInfo.builder().addHumanoidLayers(IcariaResourceLocations.KASSITEROS, false).build());
		pBiConsumer.accept(IcariaEquipmentAssets.ORICHALCUM, EquipmentClientInfo.builder().addHumanoidLayers(IcariaResourceLocations.ORICHALCUM, false).build());
		pBiConsumer.accept(IcariaEquipmentAssets.VANADIUMSTEEL, EquipmentClientInfo.builder().addHumanoidLayers(IcariaResourceLocations.VANADIUMSTEEL, false).build());
		pBiConsumer.accept(IcariaEquipmentAssets.LAUREL, EquipmentClientInfo.builder().addMainHumanoidLayer(IcariaResourceLocations.LAUREL, false).build());
	}
}

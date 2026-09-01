package com.axanthic.icaria.data.provider;

import com.axanthic.icaria.common.registry.IcariaIdentifiers;
import com.axanthic.icaria.common.registry.IcariaKeys;
import com.axanthic.icaria.data.registry.IcariaEquipmentAssets;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import java.util.function.BiConsumer;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.client.data.models.EquipmentAssetProvider;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
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
		pBiConsumer.accept(IcariaEquipmentAssets.AETERNAE_HIDE, EquipmentClientInfo.builder().addHumanoidLayers(IcariaIdentifiers.AETERNAE_HIDE, false).build());
		pBiConsumer.accept(IcariaEquipmentAssets.CHALKOS, EquipmentClientInfo.builder().addHumanoidLayers(IcariaIdentifiers.CHALKOS, false).build());
		pBiConsumer.accept(IcariaEquipmentAssets.KASSITEROS, EquipmentClientInfo.builder().addHumanoidLayers(IcariaIdentifiers.KASSITEROS, false).build());
		pBiConsumer.accept(IcariaEquipmentAssets.ORICHALCUM, EquipmentClientInfo.builder().addHumanoidLayers(IcariaIdentifiers.ORICHALCUM, false).build());
		pBiConsumer.accept(IcariaEquipmentAssets.VANADIUMSTEEL, EquipmentClientInfo.builder().addHumanoidLayers(IcariaIdentifiers.VANADIUMSTEEL, false).build());
		pBiConsumer.accept(IcariaEquipmentAssets.LAUREL, EquipmentClientInfo.builder().addMainHumanoidLayer(IcariaIdentifiers.LAUREL, false).build());

		for (var entry : IcariaEquipmentAssets.CARPET.entrySet()) {
			pBiConsumer.accept(entry.getValue(), EquipmentClientInfo.builder().addLayers(EquipmentClientInfo.LayerType.LLAMA_BODY, new EquipmentClientInfo.Layer(Identifier.fromNamespaceAndPath(IcariaKeys.ID, entry.getKey().getSerializedName()))).build());
		}
	}
}

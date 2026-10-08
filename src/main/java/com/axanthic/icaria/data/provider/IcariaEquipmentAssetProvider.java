package com.axanthic.icaria.data.provider;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.ids.IcariaEquipmentAssetIds;
import com.axanthic.icaria.common.registry.IcariaIdentifiers;

import java.util.function.BiConsumer;

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
		this.humanoidLayer(pBiConsumer);
		this.humanoidLayers(pBiConsumer);
		this.layers(pBiConsumer);
	}

	public void humanoidLayer(BiConsumer<ResourceKey<EquipmentAsset>, EquipmentClientInfo> pBiConsumer) {
		pBiConsumer.accept(IcariaEquipmentAssetIds.LAUREL, EquipmentClientInfo.builder().addMainHumanoidLayer(IcariaIdentifiers.LAUREL, false).build());
	}

	public void humanoidLayers(BiConsumer<ResourceKey<EquipmentAsset>, EquipmentClientInfo> pBiConsumer) {
		pBiConsumer.accept(IcariaEquipmentAssetIds.AETERNAE_HIDE, EquipmentClientInfo.builder().addHumanoidLayers(IcariaIdentifiers.AETERNAE_HIDE, false).build());
		pBiConsumer.accept(IcariaEquipmentAssetIds.CHALKOS, EquipmentClientInfo.builder().addHumanoidLayers(IcariaIdentifiers.CHALKOS, false).build());
		pBiConsumer.accept(IcariaEquipmentAssetIds.KASSITEROS, EquipmentClientInfo.builder().addHumanoidLayers(IcariaIdentifiers.KASSITEROS, false).build());
		pBiConsumer.accept(IcariaEquipmentAssetIds.ORICHALCUM, EquipmentClientInfo.builder().addHumanoidLayers(IcariaIdentifiers.ORICHALCUM, false).build());
		pBiConsumer.accept(IcariaEquipmentAssetIds.VANADIUMSTEEL, EquipmentClientInfo.builder().addHumanoidLayers(IcariaIdentifiers.VANADIUMSTEEL, false).build());
	}

	public void layers(BiConsumer<ResourceKey<EquipmentAsset>, EquipmentClientInfo> pBiConsumer) {
		pBiConsumer.accept(IcariaEquipmentAssetIds.TERRY_MAT, EquipmentClientInfo.builder().addLayers(EquipmentClientInfo.LayerType.LLAMA_BODY, new EquipmentClientInfo.Layer(IcariaIdentifiers.TERRY_MAT)).build());
		pBiConsumer.accept(IcariaEquipmentAssetIds.WHITE_TERRY_MAT, EquipmentClientInfo.builder().addLayers(EquipmentClientInfo.LayerType.LLAMA_BODY, new EquipmentClientInfo.Layer(IcariaIdentifiers.WHITE_TERRY_MAT)).build());
		pBiConsumer.accept(IcariaEquipmentAssetIds.LIGHT_GRAY_TERRY_MAT, EquipmentClientInfo.builder().addLayers(EquipmentClientInfo.LayerType.LLAMA_BODY, new EquipmentClientInfo.Layer(IcariaIdentifiers.LIGHT_GRAY_TERRY_MAT)).build());
		pBiConsumer.accept(IcariaEquipmentAssetIds.GRAY_TERRY_MAT, EquipmentClientInfo.builder().addLayers(EquipmentClientInfo.LayerType.LLAMA_BODY, new EquipmentClientInfo.Layer(IcariaIdentifiers.GRAY_TERRY_MAT)).build());
		pBiConsumer.accept(IcariaEquipmentAssetIds.BLACK_TERRY_MAT, EquipmentClientInfo.builder().addLayers(EquipmentClientInfo.LayerType.LLAMA_BODY, new EquipmentClientInfo.Layer(IcariaIdentifiers.BLACK_TERRY_MAT)).build());
		pBiConsumer.accept(IcariaEquipmentAssetIds.BROWN_TERRY_MAT, EquipmentClientInfo.builder().addLayers(EquipmentClientInfo.LayerType.LLAMA_BODY, new EquipmentClientInfo.Layer(IcariaIdentifiers.BROWN_TERRY_MAT)).build());
		pBiConsumer.accept(IcariaEquipmentAssetIds.RED_TERRY_MAT, EquipmentClientInfo.builder().addLayers(EquipmentClientInfo.LayerType.LLAMA_BODY, new EquipmentClientInfo.Layer(IcariaIdentifiers.RED_TERRY_MAT)).build());
		pBiConsumer.accept(IcariaEquipmentAssetIds.ORANGE_TERRY_MAT, EquipmentClientInfo.builder().addLayers(EquipmentClientInfo.LayerType.LLAMA_BODY, new EquipmentClientInfo.Layer(IcariaIdentifiers.ORANGE_TERRY_MAT)).build());
		pBiConsumer.accept(IcariaEquipmentAssetIds.YELLOW_TERRY_MAT, EquipmentClientInfo.builder().addLayers(EquipmentClientInfo.LayerType.LLAMA_BODY, new EquipmentClientInfo.Layer(IcariaIdentifiers.YELLOW_TERRY_MAT)).build());
		pBiConsumer.accept(IcariaEquipmentAssetIds.LIME_TERRY_MAT, EquipmentClientInfo.builder().addLayers(EquipmentClientInfo.LayerType.LLAMA_BODY, new EquipmentClientInfo.Layer(IcariaIdentifiers.LIME_TERRY_MAT)).build());
		pBiConsumer.accept(IcariaEquipmentAssetIds.GREEN_TERRY_MAT, EquipmentClientInfo.builder().addLayers(EquipmentClientInfo.LayerType.LLAMA_BODY, new EquipmentClientInfo.Layer(IcariaIdentifiers.GREEN_TERRY_MAT)).build());
		pBiConsumer.accept(IcariaEquipmentAssetIds.CYAN_TERRY_MAT, EquipmentClientInfo.builder().addLayers(EquipmentClientInfo.LayerType.LLAMA_BODY, new EquipmentClientInfo.Layer(IcariaIdentifiers.CYAN_TERRY_MAT)).build());
		pBiConsumer.accept(IcariaEquipmentAssetIds.LIGHT_BLUE_TERRY_MAT, EquipmentClientInfo.builder().addLayers(EquipmentClientInfo.LayerType.LLAMA_BODY, new EquipmentClientInfo.Layer(IcariaIdentifiers.LIGHT_BLUE_TERRY_MAT)).build());
		pBiConsumer.accept(IcariaEquipmentAssetIds.BLUE_TERRY_MAT, EquipmentClientInfo.builder().addLayers(EquipmentClientInfo.LayerType.LLAMA_BODY, new EquipmentClientInfo.Layer(IcariaIdentifiers.BLUE_TERRY_MAT)).build());
		pBiConsumer.accept(IcariaEquipmentAssetIds.PURPLE_TERRY_MAT, EquipmentClientInfo.builder().addLayers(EquipmentClientInfo.LayerType.LLAMA_BODY, new EquipmentClientInfo.Layer(IcariaIdentifiers.PURPLE_TERRY_MAT)).build());
		pBiConsumer.accept(IcariaEquipmentAssetIds.MAGENTA_TERRY_MAT, EquipmentClientInfo.builder().addLayers(EquipmentClientInfo.LayerType.LLAMA_BODY, new EquipmentClientInfo.Layer(IcariaIdentifiers.MAGENTA_TERRY_MAT)).build());
		pBiConsumer.accept(IcariaEquipmentAssetIds.PINK_TERRY_MAT, EquipmentClientInfo.builder().addLayers(EquipmentClientInfo.LayerType.LLAMA_BODY, new EquipmentClientInfo.Layer(IcariaIdentifiers.PINK_TERRY_MAT)).build());
	}
}

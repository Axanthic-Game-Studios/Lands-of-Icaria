package com.axanthic.icaria.client.extensions;

import com.axanthic.icaria.client.model.OrichalcumHelmetModel;
import com.axanthic.icaria.client.registry.IcariaModelLayerLocations;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.Model;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.world.item.ItemStack;

import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class OrichalcumHelmetClientItemExtensions implements IClientItemExtensions {

	@Override
	public HumanoidModel<?> getHumanoidArmorModel(ItemStack pItemStack, EquipmentClientInfo.LayerType pLayerType, Model pModel) {
		return new OrichalcumHelmetModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(IcariaModelLayerLocations.ORICHALCUM_HELMET));
	}
}

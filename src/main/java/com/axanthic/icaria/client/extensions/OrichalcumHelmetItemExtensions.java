package com.axanthic.icaria.client.extensions;

import com.axanthic.icaria.client.model.OrichalcumHelmetModel;
import com.axanthic.icaria.client.registry.IcariaLayerLocations;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class OrichalcumHelmetItemExtensions implements IClientItemExtensions {

	@Override
	public HumanoidModel<?> getHumanoidArmorModel(LivingEntity pLivingEntity, ItemStack pItemStack, EquipmentSlot pEquipmentSlot, HumanoidModel<?> pHumanoidModel) {
		return new OrichalcumHelmetModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(IcariaLayerLocations.ORICHALCUM_HELMET));
	}
}

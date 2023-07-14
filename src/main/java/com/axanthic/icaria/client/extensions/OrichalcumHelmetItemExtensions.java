package com.axanthic.icaria.client.extensions;

import com.axanthic.icaria.client.model.OrichalcumHelmetModel;
import com.axanthic.icaria.client.registry.IcariaLayerLocations;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

import net.minecraftforge.client.extensions.common.IClientItemExtensions;

import javax.annotation.Nonnull;

public class OrichalcumHelmetItemExtensions implements IClientItemExtensions {
    @Override
    public @Nonnull HumanoidModel<?> getHumanoidArmorModel(LivingEntity pLivingEntity, ItemStack pItemStack, EquipmentSlot pEquipmentSlot, HumanoidModel<?> pHumanoidModel) {
        var minecraft = Minecraft.getInstance();
        return new OrichalcumHelmetModel<>(minecraft.getEntityModels().bakeLayer(IcariaLayerLocations.ORICHALCUM_HELMET));
    }
}

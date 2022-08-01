package com.axanthic.icaria.common.item;

import com.axanthic.icaria.common.registry.IcariaItems;

import net.minecraft.client.Minecraft;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class TotemItem extends Item {
    public TotemItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public boolean isEnchantable(ItemStack pStack) {
        return false;
    }

    @Override
    public boolean isValidRepairItem(ItemStack pItemStack, ItemStack pItemStackRepairItem) {
        return pItemStackRepairItem.is(IcariaItems.BLURIDIUM_NUGGET.get());
    }

    @OnlyIn(Dist.CLIENT)
    public void totemAnimation(Entity pEntity) {
        Minecraft minecraft = Minecraft.getInstance();
        Level level = minecraft.level;
        if (pEntity instanceof Player) {
            minecraft.particleEngine.createTrackingEmitter(pEntity, ParticleTypes.TOTEM_OF_UNDYING, 30);
            minecraft.gameRenderer.displayItemActivation(new ItemStack(this));
            if (level != null) {
                level.playLocalSound(pEntity.getX(), pEntity.getY(), pEntity.getZ(), SoundEvents.TOTEM_USE, pEntity.getSoundSource(), 1.0F, 1.0F, false);
            }
        }
    }
}

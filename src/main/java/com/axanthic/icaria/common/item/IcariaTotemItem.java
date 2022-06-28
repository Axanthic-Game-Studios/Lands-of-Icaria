package com.axanthic.icaria.common.item;

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

public class IcariaTotemItem extends Item {
    public IcariaTotemItem(Properties pProperties) {
        super(pProperties);
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

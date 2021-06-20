package com.axanthic.loi.items;

import com.axanthic.loi.LandsOfIcaria;
import com.axanthic.loi.Resources;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;

public class ItemTotem extends Item {

	public ItemTotem(String name) {
		this.setMaxStackSize(1);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(LandsOfIcaria.modTabItems);
	}

	public void animationTotemUndrowning(Entity entity) {
		Minecraft minecraft = Minecraft.getMinecraft();
		if(entity == minecraft.player) {
			minecraft.effectRenderer.emitParticleAtEntity(entity, EnumParticleTypes.TOTEM);
			minecraft.entityRenderer.displayItemActivation(new ItemStack(Resources.totem_undrowning));
			minecraft.world.playSound(entity.posX, entity.posY, entity.posZ, SoundEvents.ITEM_TOTEM_USE, entity.getSoundCategory(), 1.0F, 1.0F, false);
		}
	}

	public void animationTotemUnblinding(Entity entity) {
		Minecraft minecraft = Minecraft.getMinecraft();
		if(entity == minecraft.player) {
			minecraft.effectRenderer.emitParticleAtEntity(entity, EnumParticleTypes.TOTEM);
			minecraft.entityRenderer.displayItemActivation(new ItemStack(Resources.totem_unblinding));
			minecraft.world.playSound(entity.posX, entity.posY, entity.posZ, SoundEvents.ITEM_TOTEM_USE, entity.getSoundCategory(), 1.0F, 1.0F, false);
		}
	}

	public void animationTotemUnshattering(Entity entity) {
		Minecraft minecraft = Minecraft.getMinecraft();
		if(entity == minecraft.player) {
			minecraft.effectRenderer.emitParticleAtEntity(entity, EnumParticleTypes.TOTEM);
			minecraft.entityRenderer.displayItemActivation(new ItemStack(Resources.totem_unshattering));
			minecraft.world.playSound(entity.posX, entity.posY, entity.posZ, SoundEvents.ITEM_TOTEM_USE, entity.getSoundCategory(), 1.0F, 1.0F, false);
		}
	}

	public void animationTotemUnsinking(Entity entity) {
		Minecraft minecraft = Minecraft.getMinecraft();
		if(entity == minecraft.player) {
			minecraft.effectRenderer.emitParticleAtEntity(entity, EnumParticleTypes.TOTEM);
			minecraft.entityRenderer.displayItemActivation(new ItemStack(Resources.totem_unsinking));
			minecraft.world.playSound(entity.posX, entity.posY, entity.posZ, SoundEvents.ITEM_TOTEM_USE, entity.getSoundCategory(), 1.0F, 1.0F, false);
		}
	}

	public void animationTotemUndying(Entity entity) {
		Minecraft minecraft = Minecraft.getMinecraft();
		if(entity == minecraft.player) {
			minecraft.effectRenderer.emitParticleAtEntity(entity, EnumParticleTypes.TOTEM);
			minecraft.entityRenderer.displayItemActivation(new ItemStack(Resources.totem_undying));
			minecraft.world.playSound(entity.posX, entity.posY, entity.posZ, SoundEvents.ITEM_TOTEM_USE, entity.getSoundCategory(), 1.0F, 1.0F, false);
		}
	}

	public void animationTotemStuffing(Entity entity) {
		Minecraft minecraft = Minecraft.getMinecraft();
		if(entity == minecraft.player) {
			minecraft.effectRenderer.emitParticleAtEntity(entity, EnumParticleTypes.TOTEM);
			minecraft.entityRenderer.displayItemActivation(new ItemStack(Resources.totem_stuffing));
			minecraft.world.playSound(entity.posX, entity.posY, entity.posZ, SoundEvents.ITEM_TOTEM_USE, entity.getSoundCategory(), 1.0F, 1.0F, false);
		}
	}
}
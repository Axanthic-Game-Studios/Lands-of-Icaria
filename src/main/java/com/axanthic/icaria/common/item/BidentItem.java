package com.axanthic.icaria.common.item;

import com.axanthic.icaria.common.entity.BidentEntity;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;

import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.item.component.Weapon;
import net.minecraft.world.level.Level;

import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class BidentItem extends Item implements ProjectileItem {
	public float attackDamage;

	public BidentItem(ToolMaterial pToolMaterial, float pAttackDamage, float pAttackSpeed, Properties pProperties) {
		super(pProperties.component(DataComponents.ATTRIBUTE_MODIFIERS, BidentItem.createAttributes(pToolMaterial, pAttackDamage, pAttackSpeed)).component(DataComponents.TOOL, BidentItem.createToolProperties()).component(DataComponents.WEAPON, BidentItem.createWeaponProperties()).durability(pToolMaterial.durability()).enchantable(pToolMaterial.enchantmentValue()).repairable(pToolMaterial.repairItems()));
		this.attackDamage = pToolMaterial.attackDamageBonus() + pAttackDamage;
	}

	@Override
	public boolean canPerformAction(ItemStack pItemStack, ItemAbility pItemAbility) {
		return pItemAbility == ItemAbilities.TRIDENT_THROW;
	}

	@Override
	public boolean releaseUsing(ItemStack pItemStack, Level pLevel, LivingEntity pLivingEntity, int pTimeLeft) {
		if (this.getUseDuration(pItemStack, pLivingEntity) - pTimeLeft >= 10 && pLevel instanceof ServerLevel serverLevel && pLivingEntity instanceof Player player && !pItemStack.nextDamageWillBreak()) {
			player.awardStat(Stats.ITEM_USED.get(this));
			pLevel.playSound(null, player.blockPosition(), IcariaSoundEvents.BIDENT_THROW, SoundSource.PLAYERS);
			pItemStack.hurtWithoutBreaking(1, player);
			this.handlePickup(Projectile.spawnProjectileFromRotation(BidentEntity::new, serverLevel, pItemStack, player, 0.0F, 2.0F, 1.0F), pItemStack, player);
			return true;
		} else {
			return false;
		}
	}

	public float getAttackDamage() {
		return this.attackDamage;
	}

	@Override
	public int getUseDuration(ItemStack pItemStack, LivingEntity pLivingEntity) {
		return 72000;
	}

	public void handlePickup(BidentEntity pEntity, ItemStack pItemStack, Player pPlayer) {
		if (pPlayer.hasInfiniteMaterials()) {
			pEntity.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
		} else {
			pPlayer.getInventory().removeItem(pItemStack);
		}
	}

	@Override
	public void postHurtEnemy(ItemStack pItemStack, LivingEntity pTarget, LivingEntity pSource) {
		pItemStack.hurtAndBreak(1, pSource, EquipmentSlot.MAINHAND);
	}

	@Override
	public InteractionResult use(Level pLevel, Player pPlayer, InteractionHand pInteractionHand) {
		if (pPlayer.getItemInHand(pInteractionHand).nextDamageWillBreak()) {
			return InteractionResult.FAIL;
		} else {
			pPlayer.startUsingItem(pInteractionHand);
			return InteractionResult.CONSUME;
		}
	}

	public static ItemAttributeModifiers createAttributes(ToolMaterial pToolMaterial, float pAttackDamage, float pAttackSpeed) {
		return ItemAttributeModifiers.builder().add(Attributes.ATTACK_DAMAGE, new AttributeModifier(Item.BASE_ATTACK_DAMAGE_ID, pToolMaterial.attackDamageBonus() + pAttackDamage, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).add(Attributes.ATTACK_SPEED, new AttributeModifier(Item.BASE_ATTACK_SPEED_ID, pAttackSpeed, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).build();
	}

	@Override
	public ItemUseAnimation getUseAnimation(ItemStack pItemStack) {
		return ItemUseAnimation.SPEAR;
	}

	@Override
	public Projectile asProjectile(Level pLevel, Position pBlockPos, ItemStack pItemStack, Direction pDirection) {
		var bidentEntity = new BidentEntity(pLevel, pBlockPos.x(), pBlockPos.y(), pBlockPos.z(), pItemStack.copyWithCount(1));
		bidentEntity.pickup = AbstractArrow.Pickup.ALLOWED;
		return bidentEntity;
	}

	public static Tool createToolProperties() {
		return new Tool(List.of(), 1.0F, 2, false);
	}

	public static Weapon createWeaponProperties() {
		return new Weapon(1, 0.0F);
	}
}

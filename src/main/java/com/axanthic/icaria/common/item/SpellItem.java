package com.axanthic.icaria.common.item;

import com.axanthic.icaria.common.entity.SpellEntity;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public abstract class SpellItem extends Item {
	public float inaccuracy;
	public float velocity;

	public int colour;
	public int cooldown;

	public SpellItem(float pInaccuracy, float pVelocity, int pColour, int pCooldown, Properties pProperties) {
		super(pProperties);
		this.inaccuracy = pInaccuracy;
		this.velocity = pVelocity;
		this.colour = pColour;
		this.cooldown = pCooldown;
	}

	public void handleAction(ItemStack pItemStack, Level pLevel, Player pPlayer) {
		if (pLevel.isClientSide()) {
			pPlayer.playSound(IcariaSoundEvents.SPELL_SHOOT);
		} else {
			pPlayer.awardStat(Stats.ITEM_USED.get(this));
			pPlayer.getCooldowns().addCooldown(pItemStack, this.cooldown);
			pItemStack.consume(1, pPlayer);
			if (this.getEntity().create(pLevel, EntitySpawnReason.SPAWN_ITEM_USE) instanceof SpellEntity spellEntity) {
				spellEntity.snapTo(pPlayer.getX(), pPlayer.getY() + pPlayer.getEyeHeight(), pPlayer.getZ());
				spellEntity.setColor(this.colour);
				spellEntity.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, this.velocity, this.inaccuracy);
				pLevel.addFreshEntity(spellEntity);
			}
		}
	}

	@Override
	public InteractionResult use(Level pLevel, Player pPlayer, InteractionHand pInteractionHand) {
		this.handleAction(pPlayer.getItemInHand(pInteractionHand), pLevel, pPlayer);
		return super.use(pLevel, pPlayer, pInteractionHand);
	}

	public abstract EntityType<?> getEntity();
}

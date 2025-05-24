package com.axanthic.icaria.common.item;

import com.axanthic.icaria.common.entity.BubbleSpellEntity;
import com.axanthic.icaria.common.registry.IcariaEntityTypes;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class BubbleSpellItem extends Item {
	public float inaccuracy;
	public float velocity;

	public int amount;
	public int cooldown;

	public BubbleSpellItem(float pInaccuracy, float pVelocity, int pAmount, int pCooldown, Properties pProperties) {
		super(pProperties);
		this.inaccuracy = pInaccuracy;
		this.velocity = pVelocity;
		this.amount = pAmount;
		this.cooldown = pCooldown;
	}

	public void createAmount(Level pLevel, Player pPlayer) {
		for (var i = 0; i < this.amount; ++i) {
			if (IcariaEntityTypes.BUBBLE_SPELL.get().create(pLevel, EntitySpawnReason.SPAWN_ITEM_USE) instanceof BubbleSpellEntity bubbleSpellEntity) {
				bubbleSpellEntity.snapTo(pPlayer.getX(), pPlayer.getY() + pPlayer.getEyeHeight(), pPlayer.getZ());
				bubbleSpellEntity.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, this.velocity, this.inaccuracy);
				pLevel.addFreshEntity(bubbleSpellEntity);
			}
		}
	}

	public void handleAction(Level pLevel, Player pPlayer, ItemStack pItemStack) {
		if (pLevel.isClientSide()) {
			pPlayer.playSound(IcariaSoundEvents.BUBBLE_SPELL_SHOOT);
		} else {
			pPlayer.awardStat(Stats.ITEM_USED.get(this));
			pPlayer.getCooldowns().addCooldown(pItemStack, this.cooldown);
			pItemStack.consume(1, pPlayer);
			this.createAmount(pLevel, pPlayer);
		}
	}

	@Override
	public InteractionResult use(Level pLevel, Player pPlayer, InteractionHand pInteractionHand) {
		this.handleAction(pLevel, pPlayer, pPlayer.getItemInHand(pInteractionHand));
		return super.use(pLevel, pPlayer, pInteractionHand);
	}
}

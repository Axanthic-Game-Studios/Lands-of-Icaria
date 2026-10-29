package com.axanthic.icaria.common.item;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.entity.SpellEntity;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;

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
	public SpellItem(Properties pProperties) {
		super(pProperties);
	}

	public void shoot(ItemStack pItemStack, Level pLevel, Player pPlayer) {
		if (this.getEntity().create(pLevel, EntitySpawnReason.SPAWN_ITEM_USE) instanceof SpellEntity entity) {
			entity.setOwner(pPlayer);
			entity.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, this.getVelocity(), this.getInaccuracy());
			entity.snapTo(pPlayer.getX(), pPlayer.getY() + pPlayer.getEyeHeight(), pPlayer.getZ());
			pLevel.addFreshEntity(entity);
		}
	}

	public void handleAction(ItemStack pItemStack, Level pLevel, Player pPlayer) {
		if (pLevel.isClientSide()) {
			pPlayer.playSound(IcariaSoundEvents.SPELL_SHOOT);
		} else {
			pPlayer.awardStat(Stats.ITEM_USED.get(this));
			pPlayer.getCooldowns().addCooldown(pItemStack, this.getCooldown());
			pItemStack.consume(1, pPlayer);
			this.shoot(pItemStack, pLevel, pPlayer);
		}
	}

	@Override
	public InteractionResult use(Level pLevel, Player pPlayer, InteractionHand pInteractionHand) {
		this.handleAction(pPlayer.getItemInHand(pInteractionHand), pLevel, pPlayer);
		return super.use(pLevel, pPlayer, pInteractionHand);
	}

	public abstract float getInaccuracy();

	public abstract float getVelocity();

	public abstract int getCooldown();

	public abstract EntityType<?> getEntity();
}

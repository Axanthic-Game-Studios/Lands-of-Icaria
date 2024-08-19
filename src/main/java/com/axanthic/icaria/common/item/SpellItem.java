package com.axanthic.icaria.common.item;

import com.axanthic.icaria.common.entity.SpellEntity;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class SpellItem extends Item {
	public float inaccuracy;
	public float velocity;

	public int color;
	public int cooldown;

	public SpellItem(Properties pProperties, float pInaccuracy, float pVelocity, int pColor, int pCooldown) {
		super(pProperties);
		this.inaccuracy = pInaccuracy;
		this.velocity = pVelocity;
		this.color = pColor;
		this.cooldown = pCooldown;
	}

	public @Nullable EntityType<?> getEntity() {
		return null;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
		var itemStack = pPlayer.getItemInHand(pUsedHand);
		pPlayer.playSound(IcariaSoundEvents.SPELL_SHOOT);
		if (!pLevel.isClientSide()) {
			if (this.getEntity() != null) {
				if (this.getEntity().create(pLevel) instanceof SpellEntity spellEntity) {
					spellEntity.moveTo(pPlayer.getX(), pPlayer.getY() + pPlayer.getEyeHeight(), pPlayer.getZ());
					spellEntity.setColor(this.color);
					spellEntity.setOwner(pPlayer);
					spellEntity.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, this.velocity, this.inaccuracy);
					pLevel.addFreshEntity(spellEntity);
					pPlayer.awardStat(Stats.ITEM_USED.get(this));
					if (!pPlayer.isCreative()) {
						itemStack.shrink(1);
						pPlayer.getCooldowns().addCooldown(itemStack.getItem(), this.cooldown);
					}
				}
			}
		}

		return InteractionResultHolder.sidedSuccess(itemStack, pLevel.isClientSide());
	}
}

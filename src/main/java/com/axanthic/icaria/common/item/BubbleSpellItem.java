package com.axanthic.icaria.common.item;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.config.IcariaConfig;
import com.axanthic.icaria.common.entity.BubbleSpellEntity;
import com.axanthic.icaria.common.registry.IcariaEntityTypes;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;

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
	public BubbleSpellItem(Properties pProperties) {
		super(pProperties);
	}

	public void shoot(Level pLevel, Player pPlayer) {
		var min = IcariaConfig.MINIMUM_BUBBLE_AMOUNT_BUBBLE_SPELL.get();
		var max = IcariaConfig.MAXIMUM_BUBBLE_AMOUNT_BUBBLE_SPELL.get();
		for (var i = 0; i < pLevel.getRandom().nextIntBetweenInclusive(Math.min(min, max), Math.max(min, max)); ++i) {
			if (IcariaEntityTypes.BUBBLE_SPELL.get().create(pLevel, EntitySpawnReason.SPAWN_ITEM_USE) instanceof BubbleSpellEntity entity) {
				entity.setOwner(pPlayer);
				entity.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, IcariaConfig.VELOCITY_BUBBLE_SPELL.get().floatValue(), IcariaConfig.INACCURACY_BUBBLE_SPELL.get().floatValue());
				entity.snapTo(pPlayer.getX(), pPlayer.getY() + pPlayer.getEyeHeight(), pPlayer.getZ());
				pLevel.addFreshEntity(entity);
			}
		}
	}

	public void handleAction(Level pLevel, Player pPlayer, ItemStack pItemStack) {
		if (pLevel.isClientSide()) {
			pPlayer.playSound(IcariaSoundEvents.BUBBLE_SPELL_SHOOT);
		} else {
			pPlayer.awardStat(Stats.ITEM_USED.get(this));
			pPlayer.getCooldowns().addCooldown(pItemStack, IcariaConfig.COOLDOWN_BUBBLE_SPELL.get());
			pItemStack.consume(1, pPlayer);
			this.shoot(pLevel, pPlayer);
		}
	}

	@Override
	public InteractionResult use(Level pLevel, Player pPlayer, InteractionHand pInteractionHand) {
		this.handleAction(pLevel, pPlayer, pPlayer.getItemInHand(pInteractionHand));
		return super.use(pLevel, pPlayer, pInteractionHand);
	}
}

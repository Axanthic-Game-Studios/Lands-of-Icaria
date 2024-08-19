package com.axanthic.icaria.common.item;

import com.axanthic.icaria.common.entity.BubbleSpellEntity;
import com.axanthic.icaria.common.registry.IcariaEntityTypes;
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

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class BubbleSpellItem extends Item {
	public BubbleSpellItem(Properties pProperties) {
		super(pProperties);
	}

	public EntityType<?> getEntity() {
		return IcariaEntityTypes.BUBBLE_SPELL.get();
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
		var itemStack = pPlayer.getItemInHand(pUsedHand);
		pPlayer.playSound(IcariaSoundEvents.BUBBLE_SPELL_SHOOT);
		if (!pLevel.isClientSide()) {
			for (int i = 0; i < pLevel.getRandom().nextInt(4) + 4; ++i) {
				if (this.getEntity().create(pLevel) instanceof BubbleSpellEntity spellEntity) {
					spellEntity.moveTo(pPlayer.getX(), pPlayer.getY() + pPlayer.getEyeHeight(), pPlayer.getZ());
					spellEntity.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 0.1F, 20.0F);
					pLevel.addFreshEntity(spellEntity);
				}
			}

			pPlayer.awardStat(Stats.ITEM_USED.get(this));
			if (!pPlayer.isCreative()) {
				itemStack.shrink(1);
				pPlayer.getCooldowns().addCooldown(itemStack.getItem(), 40);
			}
		}

		return InteractionResultHolder.sidedSuccess(itemStack, pLevel.isClientSide());
	}
}

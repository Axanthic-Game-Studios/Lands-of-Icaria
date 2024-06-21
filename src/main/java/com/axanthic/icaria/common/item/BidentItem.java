package com.axanthic.icaria.common.item;

import com.axanthic.icaria.common.entity.BidentEntity;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import net.neoforged.neoforge.common.SimpleTier;

import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class BidentItem extends TieredItem {
	public BidentItem(SimpleTier pTier, Properties pProperties) {
		super(pTier, pProperties);
	}

	@Override
	public boolean canAttackBlock(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer) {
		return !pPlayer.isCreative();
	}

	@Override
	public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
		pStack.hurtAndBreak(1, pAttacker, LivingEntity.getSlotForHand(InteractionHand.MAIN_HAND));
		return true;
	}

	@Override
	public int getUseDuration(ItemStack pStack) {
		return 72000;
	}

	@Override
	public void releaseUsing(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity, int pTimeCharged) {
		if (pLivingEntity instanceof Player player && this.getUseDuration(pStack) - pTimeCharged >= 10) {
			player.playSound(SoundEvents.TRIDENT_THROW);
			if (!pLevel.isClientSide()) {
				player.awardStat(Stats.ITEM_USED.get(this));
				pStack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(pLivingEntity.getUsedItemHand()));
				var entity = new BidentEntity(pLevel, player, pStack);
				entity.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 2.0F, 1.0F);
				pLevel.addFreshEntity(entity);
				if (player.getAbilities().instabuild) {
					entity.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
				} else {
					player.getInventory().removeItem(pStack);
				}
			}
		}
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
		var itemStack = pPlayer.getItemInHand(pUsedHand);
		if (itemStack.getDamageValue() >= itemStack.getMaxDamage() - 1) {
			return InteractionResultHolder.fail(itemStack);
		} else {
			pPlayer.startUsingItem(pUsedHand);
			return InteractionResultHolder.consume(itemStack);
		}
	}

	public static ItemAttributeModifiers createAttributes(SimpleTier pTier, float pAttackDamage, float pAttackSpeed) {
		return ItemAttributeModifiers.builder().add(Attributes.ATTACK_DAMAGE, new AttributeModifier(Item.BASE_ATTACK_DAMAGE_UUID, "Tool modifier", pAttackDamage + pTier.getAttackDamageBonus(), AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).add(Attributes.ATTACK_SPEED, new AttributeModifier(Item.BASE_ATTACK_SPEED_UUID, "Tool modifier", pAttackSpeed, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).build();
	}

	public static Tool createToolProperties() {
		return new Tool(List.of(), 1.0F, 2);
	}

	@Override
	public UseAnim getUseAnimation(ItemStack pStack) {
		return UseAnim.SPEAR;
	}
}

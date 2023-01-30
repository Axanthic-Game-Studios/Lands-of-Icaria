package com.axanthic.icaria.common.item;

import com.axanthic.icaria.common.entity.BidentEntity;
import com.axanthic.icaria.common.util.IcariaTier;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultimap.Builder;
import com.google.common.collect.Multimap;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Vanishable;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class BidentItem extends TieredItem implements Vanishable {
	public float attackDamage;
	public float baseDamage = 3.5F;
	public float shootPower = 1.5F;

	public int throwThresholdTime = 10;

	public Multimap<Attribute, AttributeModifier> defaultModifiers;

	public BidentItem(IcariaTier pTier, Properties pProperties) {
		super(pTier, pProperties);
		this.attackDamage = this.baseDamage + pTier.getAttackDamageBonus();
		Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
		builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Tool modifier", this.attackDamage, AttributeModifier.Operation.ADDITION));
		builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Tool modifier", -2.5D, AttributeModifier.Operation.ADDITION));
		this.defaultModifiers = builder.build();
	}

	@Override
	public boolean canAttackBlock(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer) {
		return !pPlayer.isCreative();
	}

	@Override
	public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
		pStack.hurtAndBreak(1, pAttacker, (pLivingEntity) -> pLivingEntity.broadcastBreakEvent(EquipmentSlot.MAINHAND));
		return true;
	}

	@Override
	public boolean mineBlock(ItemStack pStack, Level pLevel, BlockState pState, BlockPos pPos, LivingEntity pMiningEntity) {
		if (pState.getDestroySpeed(pLevel, pPos) != 0.0D) {
			pStack.hurtAndBreak(2, pMiningEntity, (pLivingEntity) -> pLivingEntity.broadcastBreakEvent(EquipmentSlot.MAINHAND));
		}

		return true;
	}

	@Override
	public int getUseDuration(ItemStack pStack) {
		return 72000;
	}

	@Override
	public void releaseUsing(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity, int pTimeCharged) {
		if (pLivingEntity instanceof Player player) {
			int i = this.getUseDuration(pStack) - pTimeCharged;
			if (i >= this.throwThresholdTime) {
				player.awardStat(Stats.ITEM_USED.get(this));
				if (!pLevel.isClientSide) {
					pStack.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(pLivingEntity.getUsedItemHand()));
					BidentEntity bidentEntity = new BidentEntity(pLevel, player, pStack);
					bidentEntity.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, this.shootPower, 1.0F);
					pLevel.addFreshEntity(bidentEntity);
					pLevel.playSound(null, bidentEntity, SoundEvents.TRIDENT_THROW, SoundSource.PLAYERS, 1.0F, 1.0F);
					if (player.getAbilities().instabuild) {
						bidentEntity.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
					} else {
						player.getInventory().removeItem(pStack);
					}
				}
			}
		}
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
		ItemStack itemStack = pPlayer.getItemInHand(pUsedHand);
		if (itemStack.getDamageValue() >= itemStack.getMaxDamage() - 1) {
			return InteractionResultHolder.fail(itemStack);
		} else {
			pPlayer.startUsingItem(pUsedHand);
			return InteractionResultHolder.consume(itemStack);
		}
	}

	@Override
	public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot pSlot) {
		return pSlot == EquipmentSlot.MAINHAND ? this.defaultModifiers : super.getDefaultAttributeModifiers(pSlot);
	}

	@Override
	public UseAnim getUseAnimation(ItemStack pStack) {
		return UseAnim.SPEAR;
	}
}

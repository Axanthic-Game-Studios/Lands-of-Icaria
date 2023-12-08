package com.axanthic.icaria.common.item;

import com.axanthic.icaria.common.entity.BidentEntity;
import com.axanthic.icaria.common.util.IcariaTier;

import com.google.common.collect.ImmutableMultimap;
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
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class BidentItem extends TieredItem implements Vanishable {
	public float attackDamage = 3.5F;
	public float attackSpeed = -2.5F;

	public Multimap<Attribute, AttributeModifier> multimap;

	public BidentItem(IcariaTier pTier, Properties pProperties) {
		super(pTier, pProperties);
		this.attackDamage += pTier.getAttackDamageBonus();
		ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
		builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(Item.BASE_ATTACK_DAMAGE_UUID, "Tool modifier", this.attackDamage, AttributeModifier.Operation.ADDITION));
		builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(Item.BASE_ATTACK_SPEED_UUID, "Tool modifier", this.attackSpeed, AttributeModifier.Operation.ADDITION));
		this.multimap = builder.build();
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
			if (this.getUseDuration(pStack) - pTimeCharged >= 10) {
				if (!pLevel.isClientSide()) {
					var entity = new BidentEntity(pLevel, player, pStack);
					entity.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.0F, 1.0F);
					player.awardStat(Stats.ITEM_USED.get(this));
					pLevel.addFreshEntity(entity);
					pLevel.playSound(null, entity, SoundEvents.TRIDENT_THROW, SoundSource.PLAYERS, 1.0F, 1.0F);
					pStack.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(pLivingEntity.getUsedItemHand()));
					if (player.getAbilities().instabuild) {
						entity.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
					} else {
						player.getInventory().removeItem(pStack);
					}
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

	@Override
	public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot pSlot) {
		return pSlot == EquipmentSlot.MAINHAND ? this.multimap : super.getDefaultAttributeModifiers(pSlot);
	}

	@Override
	public UseAnim getUseAnimation(ItemStack pStack) {
		return UseAnim.SPEAR;
	}
}

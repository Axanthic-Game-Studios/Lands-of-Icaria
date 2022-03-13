package com.axanthic.icaria.common.items;

import com.axanthic.icaria.common.entities.ThrownBidentEntity;
import com.axanthic.icaria.util.IcariaTier;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultimap.Builder;
import com.google.common.collect.Multimap;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Vanishable;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaBidentItem extends TieredItem implements Vanishable {
	public static final int THROW_THRESHOLD_TIME = 10;
	public static final float BASE_DAMAGE = 3.5F;
	public static final float SHOOT_POWER = 1.5F;
	private final Multimap<Attribute, AttributeModifier> defaultModifiers;
	public final Float attackDamage;

	public IcariaBidentItem(IcariaTier tier, Properties properties) {
		super(tier, properties);
		Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
		this.attackDamage = BASE_DAMAGE + tier.getAttackDamageBonus();
		builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Tool modifier", this.attackDamage, AttributeModifier.Operation.ADDITION));
		builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Tool modifier", -2.5D, AttributeModifier.Operation.ADDITION));
		this.defaultModifiers = builder.build();
	}

	@Override
	public boolean canAttackBlock(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer) {
		return !pPlayer.isCreative();
	}

	@Override
	public UseAnim getUseAnimation(ItemStack pStack) {
		return UseAnim.SPEAR;
	}

	@Override
	public int getUseDuration(ItemStack pStack) {
		return 72000;
	}

	@Override
	public void releaseUsing(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity, int pTimeCharged) {
		if (pLivingEntity instanceof Player player) {
			int i = this.getUseDuration(pStack) - pTimeCharged;
			if (i >= THROW_THRESHOLD_TIME) {
				int j = EnchantmentHelper.getRiptide(pStack);
				if (j <= 0 || player.isInWaterOrRain()) {
					if (!pLevel.isClientSide) {
						pStack.hurtAndBreak(1, player, (p_43388_) -> p_43388_.broadcastBreakEvent(pLivingEntity.getUsedItemHand()));
						if (j == 0) {
							ThrownBidentEntity thrownbident = new ThrownBidentEntity(pLevel, player, pStack);
							thrownbident.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, SHOOT_POWER + (float)j * 0.5F, 1.0F);
							if (player.getAbilities().instabuild) {
								thrownbident.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
							}

							pLevel.addFreshEntity(thrownbident);
							pLevel.playSound(null, thrownbident, SoundEvents.TRIDENT_THROW, SoundSource.PLAYERS, 1.0F, 1.0F);
							if (!player.getAbilities().instabuild) {
								player.getInventory().removeItem(pStack);
							}
						}
					}

					player.awardStat(Stats.ITEM_USED.get(this));
					if (j > 0) {
						float f7 = player.getYRot();
						float f = player.getXRot();
						float f1 = -Mth.sin(f7 * ((float)Math.PI / 180F)) * Mth.cos(f * ((float)Math.PI / 180F));
						float f2 = -Mth.sin(f * ((float)Math.PI / 180F));
						float f3 = Mth.cos(f7 * ((float)Math.PI / 180F)) * Mth.cos(f * ((float)Math.PI / 180F));
						float f4 = Mth.sqrt(f1 * f1 + f2 * f2 + f3 * f3);
						float f5 = 3.0F * ((1.0F + (float)j) / 4.0F);
						f1 *= f5 / f4;
						f2 *= f5 / f4;
						f3 *= f5 / f4;
						player.push(f1, f2, f3);
						player.startAutoSpinAttack(20);
						if (player.isOnGround()) {
							player.move(MoverType.SELF, new Vec3(0.0D, 1.1999999F, 0.0D));
						}

						SoundEvent soundevent;
						if (j >= 3) {
							soundevent = SoundEvents.TRIDENT_RIPTIDE_3;
						} else if (j == 2) {
							soundevent = SoundEvents.TRIDENT_RIPTIDE_2;
						} else {
							soundevent = SoundEvents.TRIDENT_RIPTIDE_1;
						}

						pLevel.playSound(null, player, soundevent, SoundSource.PLAYERS, 1.0F, 1.0F);
					}

				}
			}
		}
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
		ItemStack itemstack = pPlayer.getItemInHand(pUsedHand);
		if (itemstack.getDamageValue() >= itemstack.getMaxDamage() - 1) {
			return InteractionResultHolder.fail(itemstack);
		} else if (EnchantmentHelper.getRiptide(itemstack) > 0 && !pPlayer.isInWaterOrRain()) {
			return InteractionResultHolder.fail(itemstack);
		} else {
			pPlayer.startUsingItem(pUsedHand);
			return InteractionResultHolder.consume(itemstack);
		}
	}

	@Override
	public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
		pStack.hurtAndBreak(1, pAttacker, (entity) -> entity.broadcastBreakEvent(EquipmentSlot.MAINHAND));
		return true;
	}

	@Override
	public boolean mineBlock(ItemStack pStack, Level pLevel, BlockState pState, BlockPos pPos, LivingEntity pMiningEntity) {
		if ((double)pState.getDestroySpeed(pLevel, pPos) != 0.0D) {
			pStack.hurtAndBreak(2, pMiningEntity, (entity) -> entity.broadcastBreakEvent(EquipmentSlot.MAINHAND));
		}
		return true;
	}

	@Override
	public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot pSlot) {
		return pSlot == EquipmentSlot.MAINHAND ? this.defaultModifiers : super.getDefaultAttributeModifiers(pSlot);
	}
}
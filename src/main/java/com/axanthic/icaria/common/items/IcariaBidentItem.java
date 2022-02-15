package com.axanthic.icaria.common.items;

import com.axanthic.icaria.common.entities.ThrownBident;
import com.axanthic.icaria.util.IcariaTier;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultimap.Builder;
import com.google.common.collect.Multimap;

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

public class IcariaBidentItem extends TieredItem implements Vanishable {

	public static final int THROW_THRESHOLD_TIME = 10;
	public static final float BASE_DAMAGE = 3.5F;
	public static final float SHOOT_POWER = 1.5F;
	private final Multimap<Attribute, AttributeModifier> defaultModifiers;
	public final Float attackDamage;

	public IcariaBidentItem(IcariaTier tier, Properties prop) {
		super(tier, prop);
		Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
		this.attackDamage = BASE_DAMAGE + tier.getAttackDamageBonus();
		builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Tool modifier", this.attackDamage, AttributeModifier.Operation.ADDITION));
		builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Tool modifier", -2.5D, AttributeModifier.Operation.ADDITION));
		this.defaultModifiers = builder.build();
	}

	@Override
	public boolean canAttackBlock(BlockState state, Level world, BlockPos pos, Player player) {
		return !player.isCreative();
	}

	@Override
	public UseAnim getUseAnimation(ItemStack stack) {
		return UseAnim.SPEAR;
	}

	@Override
	public int getUseDuration(ItemStack stack) {
		return 72000;
	}

	@Override
	public void releaseUsing(ItemStack stack, Level world, LivingEntity entity, int duration) {
		if (entity instanceof Player) {
			Player player = (Player)entity;
			int i = this.getUseDuration(stack) - duration;
			if (i >= THROW_THRESHOLD_TIME) {
				int j = EnchantmentHelper.getRiptide(stack);
				if (j <= 0 || player.isInWaterOrRain()) {
					if (!world.isClientSide) {
						stack.hurtAndBreak(1, player, (p_43388_) -> {
							p_43388_.broadcastBreakEvent(entity.getUsedItemHand());
						});
						if (j == 0) {
							ThrownBident thrownbident = new ThrownBident(world, player, stack);
							thrownbident.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, SHOOT_POWER + (float)j * 0.5F, 1.0F);
							if (player.getAbilities().instabuild) {
								thrownbident.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
							}

							world.addFreshEntity(thrownbident);
							world.playSound((Player)null, thrownbident, SoundEvents.TRIDENT_THROW, SoundSource.PLAYERS, 1.0F, 1.0F);
							if (!player.getAbilities().instabuild) {
								player.getInventory().removeItem(stack);
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
						player.push((double)f1, (double)f2, (double)f3);
						player.startAutoSpinAttack(20);
						if (player.isOnGround()) {
							player.move(MoverType.SELF, new Vec3(0.0D, (double)1.1999999F, 0.0D));
						}

						SoundEvent soundevent;
						if (j >= 3) {
							soundevent = SoundEvents.TRIDENT_RIPTIDE_3;
						} else if (j == 2) {
							soundevent = SoundEvents.TRIDENT_RIPTIDE_2;
						} else {
							soundevent = SoundEvents.TRIDENT_RIPTIDE_1;
						}

						world.playSound((Player)null, player, soundevent, SoundSource.PLAYERS, 1.0F, 1.0F);
					}

				}
			}
		}
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		if (itemstack.getDamageValue() >= itemstack.getMaxDamage() - 1) {
			return InteractionResultHolder.fail(itemstack);
		} else if (EnchantmentHelper.getRiptide(itemstack) > 0 && !player.isInWaterOrRain()) {
			return InteractionResultHolder.fail(itemstack);
		} else {
			player.startUsingItem(hand);
			return InteractionResultHolder.consume(itemstack);
		}
	}

	@Override
	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		stack.hurtAndBreak(1, attacker, (entity) -> {
			entity.broadcastBreakEvent(EquipmentSlot.MAINHAND);
		});
		return true;
	}

	@Override
	public boolean mineBlock(ItemStack stack, Level world, BlockState state, BlockPos pos, LivingEntity breaker) {
		if ((double)state.getDestroySpeed(world, pos) != 0.0D) {
			stack.hurtAndBreak(2, breaker, (entity) -> {
				entity.broadcastBreakEvent(EquipmentSlot.MAINHAND);
			});
		}
		return true;
	}

	@Override
	public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot slot) {
		return slot == EquipmentSlot.MAINHAND ? this.defaultModifiers : super.getDefaultAttributeModifiers(slot);
	}
}
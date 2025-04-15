package com.axanthic.icaria.common.item;

import com.axanthic.icaria.common.entity.GreekFireGrenadeEntity;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileItem;
import net.minecraft.world.level.Level;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GreekFireGrenadeItem extends Item implements ProjectileItem {
	public GreekFireGrenadeItem(Properties pProperties) {
		super(pProperties);
	}

	public void handleAction(ItemStack pItemStack, Level pLevel, Player pPlayer) {
		if (pLevel instanceof ServerLevel serverLevel) {
			pLevel.playSound(null, pPlayer.blockPosition(), IcariaSoundEvents.GREEK_FIRE_GRENADE_THROW, SoundSource.PLAYERS);
			pPlayer.awardStat(Stats.ITEM_USED.get(this));
			pPlayer.getCooldowns().addCooldown(pItemStack, 20);
			pItemStack.consume(1, pPlayer);
			Projectile.spawnProjectileFromRotation(GreekFireGrenadeEntity::new, serverLevel, pItemStack, pPlayer, 0.0F, 1.0F, 1.0F);
		}
	}

	@Override
	public InteractionResult use(Level pLevel, Player pPlayer, InteractionHand pInteractionHand) {
		this.handleAction(pPlayer.getItemInHand(pInteractionHand), pLevel, pPlayer);
		return super.use(pLevel, pPlayer, pInteractionHand);
	}

	@Override
	public Projectile asProjectile(Level pLevel, Position pBlockPos, ItemStack pItemStack, Direction pDirection) {
		return new GreekFireGrenadeEntity(pLevel, pBlockPos.x(), pBlockPos.y(), pBlockPos.z(), pItemStack);
	}
}

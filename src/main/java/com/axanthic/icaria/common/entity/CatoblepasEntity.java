package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.properties.Trough;
import com.axanthic.icaria.common.registry.IcariaEntityTypes;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CatoblepasEntity extends IcariaAnimalEntity {
	public CatoblepasEntity(EntityType<? extends CatoblepasEntity> pEntityType, Level pLevel) {
		super(pEntityType, pLevel, 0.25F, 0.25F, 0.15F);
	}

	@Override
	public void playStepSound(BlockPos pBlockPos, BlockState pBlockState) {
		this.playSound(IcariaSoundEvents.CATOBLEPAS_STEP, 0.1F, 1.0F);
	}

	@Nullable
	@Override
	public IcariaAnimalEntity getBreedOffspring(ServerLevel pServerLevel) {
		return IcariaEntityTypes.CATOBLEPAS.get().create(pServerLevel, EntitySpawnReason.BREEDING);
	}

	@Override
	public InteractionResult mobInteract(Player pPlayer, InteractionHand pInteractionHand) {
		var itemStack = pPlayer.getItemInHand(pInteractionHand);
		if (itemStack.is(Items.BUCKET) && !this.isBaby()) {
			pPlayer.playSound(IcariaSoundEvents.CATOBLEPAS_MILK);
			pPlayer.setItemInHand(pInteractionHand, ItemUtils.createFilledResult(itemStack, pPlayer, new ItemStack(Items.MILK_BUCKET)));
			return InteractionResult.SUCCESS;
		} else {
			return super.mobInteract(pPlayer, pInteractionHand);
		}
	}

	@Override
	public Item getFood() {
		return IcariaItems.SPELT.get();
	}

	@Override
	public SoundEvent getAmbientSound() {
		return IcariaSoundEvents.CATOBLEPAS_AMBIENT;
	}

	@Override
	public SoundEvent getDeathSound() {
		return IcariaSoundEvents.CATOBLEPAS_DEATH;
	}

	@Override
	public SoundEvent getHurtSound(DamageSource pDamageSource) {
		return IcariaSoundEvents.CATOBLEPAS_HURT;
	}

	@Override
	public Trough getTrough() {
		return Trough.SPELT;
	}
}

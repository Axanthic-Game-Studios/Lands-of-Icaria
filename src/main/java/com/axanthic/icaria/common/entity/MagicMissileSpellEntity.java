package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.config.IcariaConfig;
import com.axanthic.icaria.common.helper.IcariaCommonHelper;
import com.axanthic.icaria.common.tags.IcariaBlockTags;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class MagicMissileSpellEntity extends SpellEntity {
	public MagicMissileSpellEntity(EntityType<? extends SpellEntity> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);
	}

	@Override
	public void onHitBlock(BlockHitResult pBlockHitResult) {
		super.onHitBlock(pBlockHitResult);
		var level = this.level();
		var blockPos = pBlockHitResult.getBlockPos();
		var blockState = level.getBlockState(blockPos);
		if (blockState.getDestroySpeed(level, blockPos) > 0 && level.getBlockEntity(blockPos) == null && !blockState.is(IcariaBlockTags.SPELL_IMMUNE_BLOCKS)) {
			level.destroyBlock(blockPos, false);
		}
	}

	@Override
	public void onHitEntity(EntityHitResult pEntityHitResult) {
		super.onHitEntity(pEntityHitResult);
		IcariaCommonHelper.hurt(this.level().damageSources().indirectMagic(this, this.getOwner()), pEntityHitResult.getEntity(), IcariaConfig.DAMAGE_MAGIC_MISSILE_SPELL.get().floatValue());
	}
}

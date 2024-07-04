package com.axanthic.icaria.common.item;

import com.axanthic.icaria.common.registry.IcariaEntityTypes;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.entity.EntityType;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class MagicMissileSpellItem extends SpellItem {
    public MagicMissileSpellItem(Properties pProperties, float pInaccuracy, float pVelocity, int pColor, int pCooldown) {
        super(pProperties, pInaccuracy, pVelocity, pColor, pCooldown);
    }

    @Override
    public EntityType<?> getEntity() {
        return IcariaEntityTypes.MAGIC_MISSILE_SPELL.get();
    }
}

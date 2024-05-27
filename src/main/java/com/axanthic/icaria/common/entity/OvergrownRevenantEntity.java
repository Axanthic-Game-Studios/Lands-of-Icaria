package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.client.helper.IcariaClientHelper;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;

@MethodsReturnNonnullByDefault

public class OvergrownRevenantEntity extends RevenantEntity {
    public float red;
    public float green;
    public float blue;

    public OvergrownRevenantEntity(EntityType<? extends OvergrownRevenantEntity> pType, Level pLevel) {
        super(pType, pLevel);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.level().isClientSide()) {
            this.tickRegisterRaysValues();
        }
    }

    public void tickRegisterRaysValues() {
        if (this.tickCount < 20) {
            this.red = IcariaClientHelper.getRed(this);
            this.green = IcariaClientHelper.getGreen(this);
            this.blue = IcariaClientHelper.getBlue(this);
        }
    }

    public static AttributeSupplier.Builder registerAttributes() {
        return Mob.createMobAttributes().add(Attributes.ATTACK_DAMAGE, 3.0D).add(Attributes.FOLLOW_RANGE, 32.0D).add(Attributes.MAX_HEALTH, 20.0D).add(Attributes.MOVEMENT_SPEED, 0.25D);
    }
}

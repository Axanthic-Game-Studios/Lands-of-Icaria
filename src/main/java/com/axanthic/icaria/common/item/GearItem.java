package com.axanthic.icaria.common.item;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GearItem extends Item {
    public GearItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public boolean isEnchantable(ItemStack pStack) {
        return false;
    }
}

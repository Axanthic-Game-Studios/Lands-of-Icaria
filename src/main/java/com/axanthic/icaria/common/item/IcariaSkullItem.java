package com.axanthic.icaria.common.item;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.level.block.Block;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaSkullItem extends StandingAndWallBlockItem {
    public IcariaSkullItem(Block pBlock, Block pWallBlock, Properties pProperties, Direction pAttachmentDirection) {
        super(pBlock, pWallBlock, pProperties, pAttachmentDirection);
    }

    @Override
    public EquipmentSlot getEquipmentSlot(ItemStack pStack) {
        return EquipmentSlot.HEAD;
    }
}

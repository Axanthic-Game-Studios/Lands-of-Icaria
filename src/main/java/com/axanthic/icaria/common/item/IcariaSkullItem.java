package com.axanthic.icaria.common.item;

import com.axanthic.icaria.client.renderer.IcariaSkullItemRenderer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.level.block.Block;

import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.minecraftforge.common.util.NonNullLazy;

import java.util.function.Consumer;

import javax.annotation.Nonnull;

public class IcariaSkullItem extends StandingAndWallBlockItem {
    public IcariaSkullItem(Block pBlock, Block pWallBlock, Properties pProperties, Direction pAttachmentDirection) {
        super(pBlock, pWallBlock, pProperties, pAttachmentDirection);
    }

    @Override
    public void initializeClient(@Nonnull Consumer<IClientItemExtensions> pConsumer) {
        pConsumer.accept(new IClientItemExtensions() {
            public final NonNullLazy<BlockEntityWithoutLevelRenderer> renderer = NonNullLazy.of(() -> new IcariaSkullItemRenderer(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels()));

            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                return this.renderer.get();
            }
        });
    }

    @Override
    public EquipmentSlot getEquipmentSlot(ItemStack pStack) {
        return EquipmentSlot.HEAD;
    }
}

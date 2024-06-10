package com.axanthic.icaria.common.item;

import com.axanthic.icaria.client.extensions.IcariaChestItemExtensions;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;

import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;

import java.util.function.Consumer;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class IcariaChestItem extends BlockItem {
    public IcariaChestItem(Block pBlock, Properties pProperties) {
        super(pBlock, pProperties);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> pConsumer) {
        pConsumer.accept(new IcariaChestItemExtensions());
    }
}

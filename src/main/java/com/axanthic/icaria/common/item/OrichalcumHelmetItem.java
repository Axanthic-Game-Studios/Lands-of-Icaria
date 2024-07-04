package com.axanthic.icaria.common.item;

import com.axanthic.icaria.client.extensions.OrichalcumHelmetItemExtensions;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;

import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.function.Consumer;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class OrichalcumHelmetItem extends ArmorItem {
    public OrichalcumHelmetItem(DeferredHolder<ArmorMaterial, ArmorMaterial> pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> pConsumer) {
        pConsumer.accept(new OrichalcumHelmetItemExtensions());
    }
}

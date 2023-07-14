package com.axanthic.icaria.common.item;

import com.axanthic.icaria.client.extensions.OrichalcumHelmetItemExtensions;
import com.axanthic.icaria.common.util.IcariaArmorMaterials;

import net.minecraft.world.item.ArmorItem;

import net.minecraftforge.client.extensions.common.IClientItemExtensions;

import java.util.function.Consumer;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class OrichalcumHelmetItem extends ArmorItem {
    public OrichalcumHelmetItem(IcariaArmorMaterials pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> pConsumer) {
        pConsumer.accept(new OrichalcumHelmetItemExtensions());
    }
}

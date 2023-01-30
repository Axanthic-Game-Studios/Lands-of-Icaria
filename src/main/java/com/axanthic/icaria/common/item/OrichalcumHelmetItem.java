package com.axanthic.icaria.common.item;

import com.axanthic.icaria.client.model.OrichalcumHelmetModel;
import com.axanthic.icaria.common.util.IcariaArmorMaterials;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;

import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.minecraftforge.common.util.NonNullLazy;

import java.util.function.Consumer;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class OrichalcumHelmetItem extends ArmorItem {
    public OrichalcumHelmetItem(IcariaArmorMaterials pMaterial, EquipmentSlot pSlot, Properties pProperties) {
        super(pMaterial, pSlot, pProperties);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> pConsumer) {
        pConsumer.accept(Rendering.INSTANCE);
    }

    public static class Rendering implements IClientItemExtensions {
        public static final Rendering INSTANCE = new OrichalcumHelmetItem.Rendering();

        public NonNullLazy<OrichalcumHelmetModel<LivingEntity>> helmet = NonNullLazy.of(() -> new OrichalcumHelmetModel<>(getModel().bakeLayer(OrichalcumHelmetModel.LAYER_LOCATION)));

        public Rendering() {

        }

        public EntityModelSet getModel() {
            return Minecraft.getInstance().getEntityModels();
        }

        @Override
        public @Nonnull HumanoidModel<?> getHumanoidArmorModel(LivingEntity pEntity, ItemStack pStack, EquipmentSlot pSlot, HumanoidModel<?> pModel) {
            return this.helmet.get();
        }
    }
}

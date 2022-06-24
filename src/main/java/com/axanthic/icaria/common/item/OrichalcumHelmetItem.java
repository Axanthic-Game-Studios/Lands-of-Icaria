package com.axanthic.icaria.common.item;

import com.axanthic.icaria.client.layer.OrichalcumHelmetLayer;
import com.axanthic.icaria.client.model.OrichalcumHelmetModel;
import com.axanthic.icaria.common.util.IcariaArmorMaterials;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.IItemRenderProperties;
import net.minecraftforge.common.util.NonNullLazy;

import java.util.function.Consumer;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class OrichalcumHelmetItem extends ArmorItem {
    public OrichalcumHelmetItem(IcariaArmorMaterials pMaterial, EquipmentSlot pSlot, Properties pProperties) {
        super(pMaterial, pSlot, pProperties);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void initializeClient(Consumer<IItemRenderProperties> pConsumer) {
        pConsumer.accept(Rendering.INSTANCE);
    }

    @OnlyIn(Dist.CLIENT)
    public static final class Rendering implements IItemRenderProperties {
        public static final Rendering INSTANCE = new OrichalcumHelmetItem.Rendering();
        public final NonNullLazy<OrichalcumHelmetModel<LivingEntity>> helmet = NonNullLazy.of(() -> new OrichalcumHelmetModel<>(getModel().bakeLayer(OrichalcumHelmetLayer.ORICHALCUM_HELMET)));

        @OnlyIn(Dist.CLIENT)
        public Rendering() {

        }

        @Override
        @OnlyIn(Dist.CLIENT)
        public HumanoidModel<?> getArmorModel(LivingEntity pEntity, ItemStack pStack, EquipmentSlot pSlot, HumanoidModel<?> pModel) {
            return this.helmet.get();
        }

        @OnlyIn(Dist.CLIENT)
        public static EntityModelSet getModel() {
            return Minecraft.getInstance().getEntityModels();
        }
    }
}

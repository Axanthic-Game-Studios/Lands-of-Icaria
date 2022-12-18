package com.axanthic.icaria.client.layer;

import com.axanthic.icaria.client.model.MyrmekeQueenModel;
import com.axanthic.icaria.common.entity.MyrmekeQueenEntity;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;

@MethodsReturnNonnullByDefault

public class MyrmekeQueenGlyphLayer extends EyesLayer<MyrmekeQueenEntity, MyrmekeQueenModel> {
    private static final RenderType GLYPH = RenderType.entityTranslucentEmissive(new ResourceLocation(IcariaInfo.MODID, "textures/entity/myrmeke_queen_glyph.png"));

    public MyrmekeQueenGlyphLayer(RenderLayerParent<MyrmekeQueenEntity, MyrmekeQueenModel> pRenderer) {
        super(pRenderer);
    }

    @Override
    public RenderType renderType() {
        return GLYPH;
    }
}

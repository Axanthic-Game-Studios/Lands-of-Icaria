package com.axanthic.loi.render;

import javax.vecmath.Matrix4f;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraft.client.renderer.block.model.BuiltInModel;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;

public class BakedModelBuiltInParticle extends BuiltInModel {

	public IBakedModel superModel;
	public TextureAtlasSprite particle;

	public BakedModelBuiltInParticle(IBakedModel itemModel, TextureAtlasSprite particle) {
		super(itemModel.getItemCameraTransforms(), itemModel.getOverrides());
		superModel = itemModel;
		this.particle = particle;
	}

	@Override
	public TextureAtlasSprite getParticleTexture() {
		return particle;
	}

	@Override
	public Pair<? extends IBakedModel, Matrix4f> handlePerspective(TransformType type) {
		net.minecraftforge.client.ForgeHooksClient.handlePerspective(this, type);
		return superModel.handlePerspective(type);
	}
}

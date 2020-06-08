package com.axanthic.loi.render;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.EnumFacing;
import javax.vecmath.Matrix4f;

import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

public class BakedModelScroll implements IBakedModel {

	public static TransformType transform;
	public IBakedModel superModel;

	public BakedModelScroll(IBakedModel itemModel) {
		superModel = itemModel;
	}

	@Override
	public boolean isBuiltInRenderer() {
		return transform == TransformType.FIRST_PERSON_LEFT_HAND || transform == TransformType.FIRST_PERSON_RIGHT_HAND;
	}

	@Override
	public List<BakedQuad> getQuads(IBlockState state, EnumFacing side, long rand) {
		if (transform == TransformType.FIRST_PERSON_LEFT_HAND || transform == TransformType.FIRST_PERSON_RIGHT_HAND)
			return Collections.<BakedQuad>emptyList();
		return superModel.getQuads(state, side, rand);
	}

	@Override
	public boolean isAmbientOcclusion() {
		return superModel.isAmbientOcclusion();
	}

	@Override
	public boolean isAmbientOcclusion(IBlockState state) {
		return superModel.isAmbientOcclusion(state);
	}

	@Override
	public boolean isGui3d() {
		return superModel.isGui3d();
	}

	@Override
	public TextureAtlasSprite getParticleTexture() {
		return superModel.getParticleTexture();
	}

	@Override
	public ItemOverrideList getOverrides() {
		return superModel.getOverrides();
	}

	@Override
	public ItemCameraTransforms getItemCameraTransforms() {
		return superModel.getItemCameraTransforms();
	}

	@Override
	public Pair<? extends IBakedModel, Matrix4f> handlePerspective(TransformType type) {
		transform = type;
		if (transform.equals(TransformType.FIRST_PERSON_LEFT_HAND) || transform.equals(TransformType.FIRST_PERSON_RIGHT_HAND)) {
			superModel.handlePerspective(type);
			return net.minecraftforge.client.ForgeHooksClient.handlePerspective(this, type);
		}
		net.minecraftforge.client.ForgeHooksClient.handlePerspective(this, type);
		return superModel.handlePerspective(type);
	}
}

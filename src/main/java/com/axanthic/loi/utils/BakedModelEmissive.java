package com.axanthic.loi.utils;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.client.model.pipeline.UnpackedBakedQuad;
import net.minecraftforge.client.model.pipeline.VertexLighterFlat;
import net.minecraftforge.common.ForgeModContainer;
import net.minecraftforge.common.property.IExtendedBlockState;
import net.minecraftforge.fml.client.FMLClientHandler;

import javax.annotation.Nullable;
import javax.vecmath.Matrix4f;

import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

public class BakedModelEmissive implements IBakedModel {

	private class CacheKey {
		private IBakedModel base;
		private Set<String> textures;
		private IBlockState state;
		private EnumFacing side;

		public CacheKey(IBakedModel base, Set<String> textures, IBlockState state, EnumFacing side) {
			this.base = base;
			this.textures = textures;
			this.state = state;
			this.side = side;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) {
				return true;
			}

			if (o == null || getClass() != o.getClass()) {
				return false;
			}

			CacheKey cacheKey = (CacheKey) o;

			if (cacheKey.side != side) {
				return false;
			}

			if (!state.equals(cacheKey.state)) {
				return false;
			}

			return true;
		}

		@Override
		public int hashCode() {
			return state.hashCode() + (31 * (side != null ? side.hashCode() : 0));
		}
	}

	private static final LoadingCache<CacheKey, List<BakedQuad>> CACHE = CacheBuilder.newBuilder().build(new CacheLoader<CacheKey, List<BakedQuad>>() {
		@Override
		public List<BakedQuad> load(CacheKey key) {
			return transformQuads(key.base.getQuads(key.state, key.side, 0), key.textures);
		}
	});

	private static final VertexFormat ITEM_FORMAT_WITH_LIGHTMAP = new VertexFormat(DefaultVertexFormats.ITEM).addElement(DefaultVertexFormats.TEX_2S);
	private Set<String> textures;
	protected final IBakedModel base;
	private boolean cacheDisabled = false;

	public BakedModelEmissive(IBakedModel base, String... textures) {
		this.base = base;
		this.textures = new HashSet<>(Arrays.asList(textures));
	}

	public BakedModelEmissive setCacheDisabled() {
		this.cacheDisabled = true;

		return this;
	}

	@Override
	public List<BakedQuad> getQuads(@Nullable IBlockState state, @Nullable EnumFacing side, long rand) {
		if (state == null) {
			return base.getQuads(state, side, rand);
		}

		if (cacheDisabled) {
			return transformQuads(base.getQuads(state, side, 0), textures);
		}

		return CACHE.getUnchecked(new CacheKey(base, textures, state instanceof IExtendedBlockState ? ((IExtendedBlockState) state).getClean() : state, side));
	}

	@Override
	public boolean isAmbientOcclusion() {
		return base.isAmbientOcclusion();
	}

	@Override
	public boolean isAmbientOcclusion(IBlockState state) {
		return base.isAmbientOcclusion(state);
	}

	@Override
	public boolean isGui3d() {
		return base.isGui3d();
	}

	@Override
	public boolean isBuiltInRenderer() {
		return base.isBuiltInRenderer();
	}

	@Override
	public TextureAtlasSprite getParticleTexture() {
		return base.getParticleTexture();
	}

	@Override
	public ItemOverrideList getOverrides() {
		return base.getOverrides();
	}

	@Override
	public ItemCameraTransforms getItemCameraTransforms() {
		return base.getItemCameraTransforms();
	}

	@Override
	public Pair<? extends IBakedModel, Matrix4f> handlePerspective(ItemCameraTransforms.TransformType cameraTransformType) {
		return base.handlePerspective(cameraTransformType);
	}

	private static List<BakedQuad> transformQuads(List<BakedQuad> oldQuads, Set<String> textures) {
		List<BakedQuad> quads = new ArrayList<>(oldQuads);

		for (int i = 0; i < quads.size(); ++i) {
			BakedQuad quad = quads.get(i);

			if (textures.contains(quad.getSprite().getIconName())) {
				quads.set(i, transformQuad(quad, 0.007F));
			}
		}

		return quads;
	}

	public static VertexFormat getFormatWithLightMap(VertexFormat format) {
		if (format == DefaultVertexFormats.BLOCK) {
			return DefaultVertexFormats.BLOCK;
		} else if (format == DefaultVertexFormats.ITEM) {
			return ITEM_FORMAT_WITH_LIGHTMAP;
		} else if (!format.hasUvOffset(1)) {
			VertexFormat result = new VertexFormat(format);

			result.addElement(DefaultVertexFormats.TEX_2S);

			return result;
		}

		return format;
	}

	private static BakedQuad transformQuad(BakedQuad quad, float light) {
		if (FMLClientHandler.instance().hasOptifine() || !ForgeModContainer.forgeLightPipelineEnabled) {
			return quad;
		}

		VertexFormat newFormat = getFormatWithLightMap(quad.getFormat());

		UnpackedBakedQuad.Builder builder = new UnpackedBakedQuad.Builder(newFormat);

		VertexLighterFlat trans = new VertexLighterFlat(Minecraft.getMinecraft().getBlockColors()) {
			@Override
			protected void updateLightmap(float[] normal, float[] lightmap, float x, float y, float z) {
				lightmap[0] = light;
				lightmap[1] = light;
			}

			@Override
			public void setQuadTint(int tint) {}
		};

		trans.setParent(builder);

		quad.pipe(trans);

		builder.setQuadTint(quad.getTintIndex());
		builder.setQuadOrientation(quad.getFace());
		builder.setTexture(quad.getSprite());
		builder.setApplyDiffuseLighting(false);

		return builder.build();
	}
}

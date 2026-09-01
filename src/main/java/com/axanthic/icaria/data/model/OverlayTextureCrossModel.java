package com.axanthic.icaria.data.model;

import com.axanthic.icaria.common.registry.IcariaKeys;
import com.axanthic.icaria.common.registry.IcariaTextureSlots;
import com.axanthic.icaria.data.provider.model.IcariaModelProvider;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.core.Direction;

import net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplate;
import net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplateBuilder;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class OverlayTextureCrossModel {

	public static ExtendedModelTemplate template() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaKeys.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(0.8000F, 0.0000F, 8.0000F).to(15.2000F, 16.0000F, 8.0000F).shade(false)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 45.0000F, 0.0000F).origin(8.0000F, 8.0000F, 8.0000F).rescale(true))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE)))
			.element(elementBuilder -> elementBuilder.from(8.0000F, 0.0000F, 0.8000F).to(8.0000F, 16.0000F, 15.2000F).shade(false)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 45.0000F, 0.0000F).origin(8.0000F, 8.0000F, 8.0000F).rescale(true))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE)))
			.element(elementBuilder -> elementBuilder.from(0.8000F, 0.0000F, 8.0000F).to(15.2000F, 16.0000F, 8.0000F).shade(false)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 45.0000F, 0.0000F).origin(8.0000F, 8.0000F, 8.0000F).rescale(true))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.OVERLAY).tintindex(0))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.OVERLAY).tintindex(0)))
			.element(elementBuilder -> elementBuilder.from(8.0000F, 0.0000F, 0.8000F).to(8.0000F, 16.0000F, 15.2000F).shade(false)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 45.0000F, 0.0000F).origin(8.0000F, 8.0000F, 8.0000F).rescale(true))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.OVERLAY).tintindex(0))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.OVERLAY).tintindex(0)))
			.build();
	}
}

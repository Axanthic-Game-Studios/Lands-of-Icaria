package com.axanthic.icaria.data.model;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.registry.IcariaIds;
import com.axanthic.icaria.common.registry.IcariaTextureSlots;
import com.axanthic.icaria.data.provider.model.IcariaModelProvider;

import net.minecraft.core.Direction;

import net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplate;
import net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplateBuilder;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class OverlayTextureCrossModel {

	public static ExtendedModelTemplate template() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIds.MC, "block"))
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

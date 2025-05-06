package com.axanthic.icaria.data.model;

import com.axanthic.icaria.common.registry.IcariaIdents;
import com.axanthic.icaria.common.registry.IcariaTextureSlots;
import com.axanthic.icaria.data.provider.model.IcariaModelProvider;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;

import net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplate;
import net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplateBuilder;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class OverlayTextureVineModel {

	public static ExtendedModelTemplate template() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(0.0F, 0.0F, 0.8F).to(16.0F, 16.0F, 0.8F).shade(false)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(16.0F, 0.0F, 0.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0F, 0.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE)))
			.element(elementBuilder -> elementBuilder.from(0.0F, 0.0F, 0.8F).to(16.0F, 16.0F, 0.8F).shade(false)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(16.0F, 0.0F, 0.0F, 16.0F).texture(IcariaTextureSlots.OVERLAY).tintindex(0))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0F, 0.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.OVERLAY).tintindex(0)))
			.build();
	}
}

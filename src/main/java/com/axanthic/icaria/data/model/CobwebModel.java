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

public class CobwebModel {

	public static ExtendedModelTemplate cross() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block")).ambientOcclusion(false)
			.element(elementBuilder -> elementBuilder.from(8.0000F, 0.0000F, 0.0000F).to(8.0000F, 16.0000F, 16.0000F)
				.shade(false)
				.rotation(rotationBuilder -> rotationBuilder.angle(45.0000F).axis(Direction.Axis.Y).origin(8.0000F, 8.0000F, 8.0000F).rescale(true))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_NEGATIVE)))
			.element(elementBuilder -> elementBuilder.from(8.0000F, 0.0000F, 0.0000F).to(8.0000F, 16.0000F, 16.0000F)
				.shade(false)
				.rotation(rotationBuilder -> rotationBuilder.angle(45.0000F).axis(Direction.Axis.Y).origin(8.0000F, 8.0000F, 8.0000F).rescale(true))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_NEGATIVE_OPPOSITE)))
			.element(elementBuilder -> elementBuilder.from(0.0000F, 0.0000F, 8.0000F).to(16.0000F, 16.0000F, 8.0000F)
				.shade(false)
				.rotation(rotationBuilder -> rotationBuilder.angle(45.0000F).axis(Direction.Axis.Y).origin(8.0000F, 8.0000F, 8.0000F).rescale(true))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_POSITIVE)))
			.element(elementBuilder -> elementBuilder.from(0.0000F, 0.0000F, 8.0000F).to(16.0000F, 16.0000F, 8.0000F)
				.shade(false)
				.rotation(rotationBuilder -> rotationBuilder.angle(45.0000F).axis(Direction.Axis.Y).origin(8.0000F, 8.0000F, 8.0000F).rescale(true))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.COBWEB_POSITIVE_OPPOSITE)))
			.build();
	}

	public static ExtendedModelTemplate plane() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block")).ambientOcclusion(false)
			.element(elementBuilder -> elementBuilder.from(0.0000F, 0.0000F, 0.8000F).to(16.0000F, 16.0000F, 0.8000F)
				.shade(false)
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(16.0000F, 0.0000F, 0.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE)))
			.build();
	}
}

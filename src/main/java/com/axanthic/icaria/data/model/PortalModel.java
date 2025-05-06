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

public class PortalModel {

	public static ExtendedModelTemplate x() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(0.0000F, 0.0000F, 6.0000F).to(16.0000F, 16.0000F, 10.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(6.0000F, 0.0000F, 10.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE).cullface(Direction.EAST))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(6.0000F, 0.0000F, 10.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE).cullface(Direction.WEST))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0000F, 6.0000F, 16.0000F, 10.0000F).texture(IcariaTextureSlots.TEXTURE).cullface(Direction.UP))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0000F, 6.0000F, 16.0000F, 10.0000F).texture(IcariaTextureSlots.TEXTURE).cullface(Direction.DOWN)))
			.build();
	}

	public static ExtendedModelTemplate z() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(6.0000F, 0.0000F, 0.0000F).to(10.0000F, 16.0000F, 16.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(6.0000F, 0.0000F, 10.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE).cullface(Direction.NORTH))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(6.0000F, 0.0000F, 10.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE).cullface(Direction.SOUTH))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(6.0000F, 0.0000F, 10.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE).cullface(Direction.UP))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(6.0000F, 0.0000F, 10.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE).cullface(Direction.DOWN)))
			.build();
	}
}

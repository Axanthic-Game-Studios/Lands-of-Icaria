package com.axanthic.icaria.data.model;

import com.axanthic.icaria.common.registry.IcariaIdents;
import com.axanthic.icaria.common.registry.IcariaTextureSlots;
import com.axanthic.icaria.data.provider.model.IcariaModelProvider;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;

import net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplate;
import net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplateBuilder;
import net.neoforged.neoforge.client.model.generators.template.FaceRotation;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class HorizontalBarsModel {

	public static ExtendedModelTemplate template() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(0.0F, 7.0F, 0.0F).to(0.0F, 9.0F, 16.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(7.0F, 0.0F, 9.0F, 16.0F).rotation(FaceRotation.CLOCKWISE_90).texture(IcariaTextureSlots.TEXTURE).cullface(Direction.WEST))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(7.0F, 0.0F, 9.0F, 16.0F).rotation(FaceRotation.CLOCKWISE_90).texture(IcariaTextureSlots.TEXTURE).cullface(Direction.WEST)))
			.element(elementBuilder -> elementBuilder.from(16.0F, 7.0F, 0.0F).to(16.0F, 9.0F, 16.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(7.0F, 0.0F, 9.0F, 16.0F).rotation(FaceRotation.CLOCKWISE_90).texture(IcariaTextureSlots.TEXTURE).cullface(Direction.EAST))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(7.0F, 0.0F, 9.0F, 16.0F).rotation(FaceRotation.CLOCKWISE_90).texture(IcariaTextureSlots.TEXTURE).cullface(Direction.EAST)))
			.element(elementBuilder -> elementBuilder.from(0.0F, 7.0F, 0.0F).to(16.0F, 9.0F, 0.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(7.0F, 0.0F, 9.0F, 16.0F).rotation(FaceRotation.CLOCKWISE_90).texture(IcariaTextureSlots.TEXTURE).cullface(Direction.NORTH))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(7.0F, 0.0F, 9.0F, 16.0F).rotation(FaceRotation.CLOCKWISE_90).texture(IcariaTextureSlots.TEXTURE).cullface(Direction.NORTH)))
			.element(elementBuilder -> elementBuilder.from(0.0F, 7.0F, 16.0F).to(16.0F, 9.0F, 16.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(7.0F, 0.0F, 9.0F, 16.0F).rotation(FaceRotation.CLOCKWISE_90).texture(IcariaTextureSlots.TEXTURE).cullface(Direction.SOUTH))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(7.0F, 0.0F, 9.0F, 16.0F).rotation(FaceRotation.CLOCKWISE_90).texture(IcariaTextureSlots.TEXTURE).cullface(Direction.SOUTH)))
			.element(elementBuilder -> elementBuilder.from(0.0F, 8.0F, 0.0F).to(16.0F, 8.0F, 16.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0F, 0.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0F, 0.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE)))
			.build();
	}
}

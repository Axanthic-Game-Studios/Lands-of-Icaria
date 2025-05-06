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

public class HorizontalPaneModel {

	public static ExtendedModelTemplate template() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(0.0F, 7.0F, 0.0F).to(16.0F, 9.0F, 16.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(7.0F, 0.0F, 9.0F, 16.0F).rotation(FaceRotation.CLOCKWISE_90).texture(IcariaTextureSlots.EDGE).cullface(Direction.NORTH))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(7.0F, 0.0F, 9.0F, 16.0F).rotation(FaceRotation.CLOCKWISE_90).texture(IcariaTextureSlots.EDGE).cullface(Direction.EAST))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(7.0F, 0.0F, 9.0F, 16.0F).rotation(FaceRotation.CLOCKWISE_90).texture(IcariaTextureSlots.EDGE).cullface(Direction.SOUTH))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(7.0F, 0.0F, 9.0F, 16.0F).rotation(FaceRotation.CLOCKWISE_90).texture(IcariaTextureSlots.EDGE).cullface(Direction.WEST))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0F, 0.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.PANE))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0F, 0.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.PANE)))
			.build();
	}
}

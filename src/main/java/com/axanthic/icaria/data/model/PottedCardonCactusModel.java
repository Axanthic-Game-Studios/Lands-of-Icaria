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

public class PottedCardonCactusModel {

	public static ExtendedModelTemplate template() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(5.0F, 0.0F, 5.0F).to(6.0F, 6.0F, 11.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(10.0F, 10.0F, 11.0F, 16.0F).texture(IcariaTextureSlots.FLOWER_POT))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(5.0F, 10.0F, 11.0F, 16.0F).texture(IcariaTextureSlots.FLOWER_POT))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(5.0F, 10.0F, 6.0F, 16.0F).texture(IcariaTextureSlots.FLOWER_POT))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(5.0F, 10.0F, 11.0F, 16.0F).texture(IcariaTextureSlots.FLOWER_POT))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(5.0F, 5.0F, 6.0F, 11.0F).texture(IcariaTextureSlots.FLOWER_POT))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(5.0F, 5.0F, 6.0F, 11.0F).texture(IcariaTextureSlots.FLOWER_POT).cullface(Direction.DOWN)))
			.element(elementBuilder -> elementBuilder.from(10.0F, 0.0F, 5.0F).to(11.0F, 6.0F, 11.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(5.0F, 10.0F, 6.0F, 16.0F).texture(IcariaTextureSlots.FLOWER_POT))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(5.0F, 10.0F, 11.0F, 16.0F).texture(IcariaTextureSlots.FLOWER_POT))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(10.0F, 10.0F, 11.0F, 16.0F).texture(IcariaTextureSlots.FLOWER_POT))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(5.0F, 10.0F, 11.0F, 16.0F).texture(IcariaTextureSlots.FLOWER_POT))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(10.0F, 5.0F, 11.0F, 11.0F).texture(IcariaTextureSlots.FLOWER_POT))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(10.0F, 5.0F, 11.0F, 11.0F).texture(IcariaTextureSlots.FLOWER_POT).cullface(Direction.DOWN)))
			.element(elementBuilder -> elementBuilder.from(6.0F, 0.0F, 5.0F).to(10.0F, 6.0F, 6.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(6.0F, 10.0F, 10.0F, 16.0F).texture(IcariaTextureSlots.FLOWER_POT))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(6.0F, 10.0F, 10.0F, 16.0F).texture(IcariaTextureSlots.FLOWER_POT))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(6.0F, 5.0F, 10.0F, 6.0F).texture(IcariaTextureSlots.FLOWER_POT))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(6.0F, 10.0F, 10.0F, 11.0F).texture(IcariaTextureSlots.FLOWER_POT).cullface(Direction.DOWN)))
			.element(elementBuilder -> elementBuilder.from(6.0F, 0.0F, 10.0F).to(10.0F, 6.0F, 11.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(6.0F, 10.0F, 10.0F, 16.0F).texture(IcariaTextureSlots.FLOWER_POT))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(6.0F, 10.0F, 10.0F, 16.0F).texture(IcariaTextureSlots.FLOWER_POT))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(6.0F, 10.0F, 10.0F, 11.0F).texture(IcariaTextureSlots.FLOWER_POT))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(6.0F, 5.0F, 10.0F, 6.0F).texture(IcariaTextureSlots.FLOWER_POT).cullface(Direction.DOWN)))
			.element(elementBuilder -> elementBuilder.from(6.0F, 0.0F, 6.0F).to(10.0F, 4.0F, 10.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(6.0F, 6.0F, 10.0F, 10.0F).texture(IcariaTextureSlots.DIRT))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(6.0F, 12.0F, 10.0F, 16.0F).texture(IcariaTextureSlots.FLOWER_POT).cullface(Direction.DOWN)))
			.element(elementBuilder -> elementBuilder.from(6.0F, 4.0F, 6.0F).to(10.0F, 16.0F, 10.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0F, 0.0F, 4.0F, 12.0F).texture(IcariaTextureSlots.CACTUS))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(4.0F, 0.0F, 8.0F, 12.0F).texture(IcariaTextureSlots.CACTUS))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(8.0F, 0.0F, 12.0F, 12.0F).texture(IcariaTextureSlots.CACTUS))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(12.0F, 0.0F, 16.0F, 12.0F).texture(IcariaTextureSlots.CACTUS))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(6.0F, 6.0F, 10.0F, 10.0F).texture(IcariaTextureSlots.CACTUS))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0F, 0.0F, 4.0F, 4.0F).texture(IcariaTextureSlots.CACTUS)))
			.build();
	}
}

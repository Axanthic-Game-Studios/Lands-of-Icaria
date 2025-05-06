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

public class PottedLargeBrownGroundShroomsModel {

	public static ExtendedModelTemplate template() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(5.0F, 0.0F, 5.0F).to(6.0F, 6.0F, 11.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(10.0F, 10.0F, 11.0F, 16.0F).texture(IcariaTextureSlots.POT))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(5.0F, 10.0F, 11.0F, 16.0F).texture(IcariaTextureSlots.POT))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(5.0F, 10.0F, 6.0F, 16.0F).texture(IcariaTextureSlots.POT))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(5.0F, 10.0F, 11.0F, 16.0F).texture(IcariaTextureSlots.POT))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(5.0F, 5.0F, 6.0F, 11.0F).texture(IcariaTextureSlots.POT))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(5.0F, 5.0F, 6.0F, 11.0F).texture(IcariaTextureSlots.POT).cullface(Direction.DOWN)))
			.element(elementBuilder -> elementBuilder.from(10.0F, 0.0F, 5.0F).to(11.0F, 6.0F, 11.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(5.0F, 10.0F, 6.0F, 16.0F).texture(IcariaTextureSlots.POT))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(5.0F, 10.0F, 11.0F, 16.0F).texture(IcariaTextureSlots.POT))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(10.0F, 10.0F, 11.0F, 16.0F).texture(IcariaTextureSlots.POT))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(5.0F, 10.0F, 11.0F, 16.0F).texture(IcariaTextureSlots.POT))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(10.0F, 5.0F, 11.0F, 11.0F).texture(IcariaTextureSlots.POT))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(10.0F, 5.0F, 11.0F, 11.0F).texture(IcariaTextureSlots.POT).cullface(Direction.DOWN)))
			.element(elementBuilder -> elementBuilder.from(6.0F, 0.0F, 5.0F).to(10.0F, 6.0F, 6.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(6.0F, 10.0F, 10.0F, 16.0F).texture(IcariaTextureSlots.POT))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(6.0F, 10.0F, 10.0F, 16.0F).texture(IcariaTextureSlots.POT))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(6.0F, 5.0F, 10.0F, 6.0F).texture(IcariaTextureSlots.POT))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(6.0F, 10.0F, 10.0F, 11.0F).texture(IcariaTextureSlots.POT).cullface(Direction.DOWN)))
			.element(elementBuilder -> elementBuilder.from(6.0F, 0.0F, 10.0F).to(10.0F, 6.0F, 11.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(6.0F, 10.0F, 10.0F, 16.0F).texture(IcariaTextureSlots.POT))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(6.0F, 10.0F, 10.0F, 16.0F).texture(IcariaTextureSlots.POT))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(6.0F, 10.0F, 10.0F, 11.0F).texture(IcariaTextureSlots.POT))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(6.0F, 5.0F, 10.0F, 6.0F).texture(IcariaTextureSlots.POT).cullface(Direction.DOWN)))
			.element(elementBuilder -> elementBuilder.from(6.0F, 0.0F, 6.0F).to(10.0F, 4.0F, 10.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(6.0F, 6.0F, 10.0F, 10.0F).texture(IcariaTextureSlots.DIRT))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(6.0F, 12.0F, 10.0F, 16.0F).texture(IcariaTextureSlots.POT).cullface(Direction.DOWN)))
			.element(elementBuilder -> elementBuilder.from(6.5F, 9.0F, 6.5F).to(11.5F, 10.0F, 11.5F)
				.rotation(rotationBuilder -> rotationBuilder.angle(22.5F).axis(Direction.Axis.Y).origin(9.0F, 9.5F, 9.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0F, 0.0F, 5.0F, 1.0F).texture(IcariaTextureSlots.SHROOM))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0F, 0.0F, 5.0F, 1.0F).texture(IcariaTextureSlots.SHROOM))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0F, 0.0F, 5.0F, 1.0F).texture(IcariaTextureSlots.SHROOM))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0F, 0.0F, 5.0F, 1.0F).texture(IcariaTextureSlots.SHROOM))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0F, 0.0F, 5.0F, 5.0F).texture(IcariaTextureSlots.SHROOM))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0F, 0.0F, 5.0F, 5.0F).texture(IcariaTextureSlots.SHROOM)))
			.element(elementBuilder -> elementBuilder.from(8.5F, 4.0F, 8.5F).to(9.5F, 9.0F, 9.5F)
				.rotation(rotationBuilder -> rotationBuilder.angle(22.5F).axis(Direction.Axis.Y).origin(9.0F, 6.5F, 9.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0F, 0.0F, 1.0F, 5.0F).texture(IcariaTextureSlots.STEM))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(1.0F, 0.0F, 2.0F, 5.0F).texture(IcariaTextureSlots.STEM))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(2.0F, 0.0F, 3.0F, 5.0F).texture(IcariaTextureSlots.STEM))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(3.0F, 0.0F, 4.0F, 5.0F).texture(IcariaTextureSlots.STEM)))
			.element(elementBuilder -> elementBuilder.from(5.5F, 7.0F, 5.5F).to(8.5F, 8.0F, 8.5F)
				.rotation(rotationBuilder -> rotationBuilder.angle(-22.5F).axis(Direction.Axis.Y).origin(7.0F, 6.5F, 7.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0F, 0.0F, 3.0F, 1.0F).texture(IcariaTextureSlots.SHROOM))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0F, 0.0F, 3.0F, 1.0F).texture(IcariaTextureSlots.SHROOM))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0F, 0.0F, 3.0F, 1.0F).texture(IcariaTextureSlots.SHROOM))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0F, 0.0F, 3.0F, 1.0F).texture(IcariaTextureSlots.SHROOM))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0F, 0.0F, 3.0F, 3.0F).texture(IcariaTextureSlots.SHROOM))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0F, 0.0F, 3.0F, 3.0F).texture(IcariaTextureSlots.SHROOM)))
			.element(elementBuilder -> elementBuilder.from(6.5F, 4.0F, 6.5F).to(7.5F, 7.0F, 7.5F)
				.rotation(rotationBuilder -> rotationBuilder.angle(-22.5F).axis(Direction.Axis.Y).origin(7.0F, 6.5F, 7.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0F, 0.0F, 1.0F, 3.0F).texture(IcariaTextureSlots.STEM))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(1.0F, 0.0F, 2.0F, 3.0F).texture(IcariaTextureSlots.STEM))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(2.0F, 0.0F, 3.0F, 3.0F).texture(IcariaTextureSlots.STEM))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(3.0F, 0.0F, 4.0F, 3.0F).texture(IcariaTextureSlots.STEM)))
			.build();
	}
}

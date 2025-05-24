package com.axanthic.icaria.data.model;

import com.axanthic.icaria.common.registry.IcariaIdents;
import com.axanthic.icaria.common.registry.IcariaTextureSlots;
import com.axanthic.icaria.data.provider.model.IcariaModelProvider;

import com.mojang.math.Quadrant;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;

import net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplate;
import net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplateBuilder;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class TroughModel {

	public static ExtendedModelTemplate template() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(1.0F, 4.0F, 8.0F).to(15.0F, 5.0F, 9.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(1.0F, 11.0F, 15.0F, 12.0F).texture(IcariaTextureSlots.ANVIL))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(1.0F, 11.0F, 15.0F, 12.0F).texture(IcariaTextureSlots.ANVIL))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(1.0F, 8.0F, 15.0F, 9.0F).texture(IcariaTextureSlots.ANVIL)))
			.element(elementBuilder -> elementBuilder.from(15.0F, 4.0F, 8.0F).to(16.0F, 5.0F, 16.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0F, 11.0F, 1.0F, 12.0F).texture(IcariaTextureSlots.ANVIL))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0F, 11.0F, 8.0F, 12.0F).texture(IcariaTextureSlots.ANVIL))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(15.0F, 11.0F, 16.0F, 12.0F).texture(IcariaTextureSlots.ANVIL))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(8.0F, 11.0F, 16.0F, 12.0F).texture(IcariaTextureSlots.ANVIL))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(15.0F, 8.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.ANVIL)))
			.element(elementBuilder -> elementBuilder.from(1.0F, 4.0F, 15.0F).to(15.0F, 5.0F, 16.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(1.0F, 11.0F, 15.0F, 12.0F).texture(IcariaTextureSlots.ANVIL))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(1.0F, 11.0F, 15.0F, 12.0F).texture(IcariaTextureSlots.ANVIL))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(1.0F, 15.0F, 15.0F, 16.0F).texture(IcariaTextureSlots.ANVIL)))
			.element(elementBuilder -> elementBuilder.from(0.0F, 4.0F, 8.0F).to(1.0F, 5.0F, 16.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(15.0F, 11.0F, 16.0F, 12.0F).texture(IcariaTextureSlots.ANVIL))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0F, 11.0F, 8.0F, 12.0F).texture(IcariaTextureSlots.ANVIL))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0F, 11.0F, 1.0F, 12.0F).texture(IcariaTextureSlots.ANVIL))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(8.0F, 11.0F, 16.0F, 12.0F).texture(IcariaTextureSlots.ANVIL))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0F, 8.0F, 1.0F, 16.0F).texture(IcariaTextureSlots.ANVIL)))
			.element(elementBuilder -> elementBuilder.from(1.0F, 1.0F, 8.0F).to(15.0F, 4.0F, 9.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(1.0F, 12.0F, 15.0F, 15.0F).texture(IcariaTextureSlots.PLANKS))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(1.0F, 12.0F, 15.0F, 15.0F).texture(IcariaTextureSlots.PLANKS)))
			.element(elementBuilder -> elementBuilder.from(15.0F, 1.0F, 8.0F).to(16.0F, 4.0F, 16.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0F, 12.0F, 1.0F, 15.0F).texture(IcariaTextureSlots.PLANKS))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0F, 12.0F, 8.0F, 15.0F).texture(IcariaTextureSlots.PLANKS))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(15.0F, 12.0F, 16.0F, 15.0F).texture(IcariaTextureSlots.PLANKS))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(8.0F, 12.0F, 16.0F, 15.0F).texture(IcariaTextureSlots.PLANKS)))
			.element(elementBuilder -> elementBuilder.from(1.0F, 1.0F, 15.0F).to(15.0F, 4.0F, 16.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(1.0F, 12.0F, 15.0F, 15.0F).texture(IcariaTextureSlots.PLANKS))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(1.0F, 12.0F, 15.0F, 15.0F).texture(IcariaTextureSlots.PLANKS)))
			.element(elementBuilder -> elementBuilder.from(0.0F, 1.0F, 8.0F).to(1.0F, 4.0F, 16.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(15.0F, 12.0F, 16.0F, 15.0F).texture(IcariaTextureSlots.PLANKS))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0F, 12.0F, 8.0F, 15.0F).texture(IcariaTextureSlots.PLANKS))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0F, 12.0F, 1.0F, 15.0F).texture(IcariaTextureSlots.PLANKS))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(8.0F, 12.0F, 16.0F, 15.0F).texture(IcariaTextureSlots.PLANKS)))
			.element(elementBuilder -> elementBuilder.from(0.0F, 0.0F, 8.0F).to(16.0F, 1.0F, 16.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0F, 15.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.LOG))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0F, 15.0F, 8.0F, 16.0F).texture(IcariaTextureSlots.LOG))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0F, 15.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.LOG))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(8.0F, 15.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.LOG))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0F, 8.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.PLANKS))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0F, 8.0F, 16.0F, 16.0F).rotation(Quadrant.R180).texture(IcariaTextureSlots.LOG)))
			.build();
	}
}

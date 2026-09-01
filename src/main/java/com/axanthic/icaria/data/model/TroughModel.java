package com.axanthic.icaria.data.model;

import com.axanthic.icaria.common.registry.IcariaKeys;
import com.axanthic.icaria.common.registry.IcariaTextureSlots;
import com.axanthic.icaria.data.provider.model.IcariaModelProvider;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;
import com.mojang.math.Quadrant;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.core.Direction;

import net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplate;
import net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplateBuilder;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class TroughModel {

	public static ExtendedModelTemplate template() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaKeys.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(1.0000F, 4.0000F, 8.0000F).to(15.0000F, 5.0000F, 9.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(1.0000F, 11.0000F, 15.0000F, 12.0000F).texture(IcariaTextureSlots.ANVIL))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(1.0000F, 11.0000F, 15.0000F, 12.0000F).texture(IcariaTextureSlots.ANVIL))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(1.0000F, 8.0000F, 15.0000F, 9.0000F).texture(IcariaTextureSlots.ANVIL)))
			.element(elementBuilder -> elementBuilder.from(15.0000F, 4.0000F, 8.0000F).to(16.0000F, 5.0000F, 16.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 11.0000F, 1.0000F, 12.0000F).texture(IcariaTextureSlots.ANVIL))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 11.0000F, 8.0000F, 12.0000F).texture(IcariaTextureSlots.ANVIL))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(15.0000F, 11.0000F, 16.0000F, 12.0000F).texture(IcariaTextureSlots.ANVIL))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(8.0000F, 11.0000F, 16.0000F, 12.0000F).texture(IcariaTextureSlots.ANVIL))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(15.0000F, 8.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.ANVIL)))
			.element(elementBuilder -> elementBuilder.from(1.0000F, 4.0000F, 15.0000F).to(15.0000F, 5.0000F, 16.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(1.0000F, 11.0000F, 15.0000F, 12.0000F).texture(IcariaTextureSlots.ANVIL))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(1.0000F, 11.0000F, 15.0000F, 12.0000F).texture(IcariaTextureSlots.ANVIL))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(1.0000F, 15.0000F, 15.0000F, 16.0000F).texture(IcariaTextureSlots.ANVIL)))
			.element(elementBuilder -> elementBuilder.from(0.0000F, 4.0000F, 8.0000F).to(1.0000F, 5.0000F, 16.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(15.0000F, 11.0000F, 16.0000F, 12.0000F).texture(IcariaTextureSlots.ANVIL))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 11.0000F, 8.0000F, 12.0000F).texture(IcariaTextureSlots.ANVIL))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 11.0000F, 1.0000F, 12.0000F).texture(IcariaTextureSlots.ANVIL))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(8.0000F, 11.0000F, 16.0000F, 12.0000F).texture(IcariaTextureSlots.ANVIL))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0000F, 8.0000F, 1.0000F, 16.0000F).texture(IcariaTextureSlots.ANVIL)))
			.element(elementBuilder -> elementBuilder.from(1.0000F, 1.0000F, 8.0000F).to(15.0000F, 4.0000F, 9.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(1.0000F, 12.0000F, 15.0000F, 15.0000F).texture(IcariaTextureSlots.PLANKS))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(1.0000F, 12.0000F, 15.0000F, 15.0000F).texture(IcariaTextureSlots.PLANKS)))
			.element(elementBuilder -> elementBuilder.from(15.0000F, 1.0000F, 8.0000F).to(16.0000F, 4.0000F, 16.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 12.0000F, 1.0000F, 15.0000F).texture(IcariaTextureSlots.PLANKS))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 12.0000F, 8.0000F, 15.0000F).texture(IcariaTextureSlots.PLANKS))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(15.0000F, 12.0000F, 16.0000F, 15.0000F).texture(IcariaTextureSlots.PLANKS))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(8.0000F, 12.0000F, 16.0000F, 15.0000F).texture(IcariaTextureSlots.PLANKS)))
			.element(elementBuilder -> elementBuilder.from(1.0000F, 1.0000F, 15.0000F).to(15.0000F, 4.0000F, 16.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(1.0000F, 12.0000F, 15.0000F, 15.0000F).texture(IcariaTextureSlots.PLANKS))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(1.0000F, 12.0000F, 15.0000F, 15.0000F).texture(IcariaTextureSlots.PLANKS)))
			.element(elementBuilder -> elementBuilder.from(0.0000F, 1.0000F, 8.0000F).to(1.0000F, 4.0000F, 16.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(15.0000F, 12.0000F, 16.0000F, 15.0000F).texture(IcariaTextureSlots.PLANKS))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 12.0000F, 8.0000F, 15.0000F).texture(IcariaTextureSlots.PLANKS))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 12.0000F, 1.0000F, 15.0000F).texture(IcariaTextureSlots.PLANKS))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(8.0000F, 12.0000F, 16.0000F, 15.0000F).texture(IcariaTextureSlots.PLANKS)))
			.element(elementBuilder -> elementBuilder.from(0.0000F, 0.0000F, 8.0000F).to(16.0000F, 1.0000F, 16.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 15.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 15.0000F, 8.0000F, 16.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 15.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(8.0000F, 15.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0000F, 8.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.PLANKS))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0000F, 8.0000F, 16.0000F, 16.0000F).rotation(Quadrant.R180).texture(IcariaTextureSlots.LOG)))
			.build();
	}
}

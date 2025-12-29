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

public class KitchenTableModel {

	public static ExtendedModelTemplate head() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(0.0000F, 14.0000F, 0.0000F).to(1.0000F, 16.0000F, 15.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(16.0000F, 0.0000F, 16.0000F))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 15.0000F, 2.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0000F, 1.0000F, 1.0000F, 16.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(15.0000F, 1.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.LOG)))
			.element(elementBuilder -> elementBuilder.from(1.0000F, 13.0000F, 0.0000F).to(15.0000F, 16.0000F, 15.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(16.0000F, 0.0000F, 16.0000F))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(1.0000F, 0.0000F, 16.0000F, 3.0000F).texture(IcariaTextureSlots.SMOOTH_LOG))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(1.0000F, 0.0000F, 15.0000F, 3.0000F).texture(IcariaTextureSlots.SMOOTH_LOG))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 15.0000F, 3.0000F).texture(IcariaTextureSlots.SMOOTH_LOG))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(1.0000F, 0.0000F, 15.0000F, 15.0000F).texture(IcariaTextureSlots.PLANKS))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(1.0000F, 0.0000F, 15.0000F, 15.0000F).texture(IcariaTextureSlots.SMOOTH_LOG)))
			.element(elementBuilder -> elementBuilder.from(15.0000F, 14.0000F, 0.0000F).to(16.0000F, 16.0000F, 15.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(16.0000F, 0.0000F, 16.0000F))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(1.0000F, 0.0000F, 16.0000F, 2.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(15.0000F, 1.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0000F, 1.0000F, 1.0000F, 16.0000F).texture(IcariaTextureSlots.LOG)))
			.element(elementBuilder -> elementBuilder.from(0.0000F, 14.0000F, 15.0000F).to(16.0000F, 16.0000F, 16.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(16.0000F, 0.0000F, 16.0000F))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 1.0000F, 2.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 2.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(15.0000F, 0.0000F, 16.0000F, 2.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 1.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 1.0000F).texture(IcariaTextureSlots.LOG)))
			.element(elementBuilder -> elementBuilder.from(2.0000F, 0.0000F, 12.0000F).to(4.0000F, 13.0000F, 14.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(16.0000F, 0.0000F, 16.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(14.0000F, 0.0000F, 16.0000F, 13.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 2.0000F, 13.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(2.0000F, 0.0000F, 4.0000F, 13.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(12.0000F, 0.0000F, 14.0000F, 13.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(14.0000F, 13.0000F, 16.0000F, 15.0000F).texture(IcariaTextureSlots.STRIPPED_LOG)))
			.element(elementBuilder -> elementBuilder.from(12.0000F, 0.0000F, 12.0000F).to(14.0000F, 13.0000F, 14.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(16.0000F, 0.0000F, 16.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(12.0000F, 0.0000F, 14.0000F, 13.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(14.0000F, 0.0000F, 16.0000F, 13.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 2.0000F, 13.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(2.0000F, 0.0000F, 4.0000F, 13.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(12.0000F, 13.0000F, 14.0000F, 15.0000F).texture(IcariaTextureSlots.STRIPPED_LOG)))
			.build();
	}

	public static ExtendedModelTemplate foot() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(0.0000F, 14.0000F, 0.0000F).to(16.0000F, 16.0000F, 1.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 2.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(15.0000F, 0.0000F, 16.0000F, 2.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 1.0000F, 2.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 1.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 1.0000F).texture(IcariaTextureSlots.LOG)))
			.element(elementBuilder -> elementBuilder.from(0.0000F, 14.0000F, 1.0000F).to(1.0000F, 16.0000F, 16.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(1.0000F, 0.0000F, 16.0000F, 2.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0000F, 1.0000F, 1.0000F, 16.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(15.0000F, 1.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.LOG)))
			.element(elementBuilder -> elementBuilder.from(1.0000F, 13.0000F, 1.0000F).to(15.0000F, 16.0000F, 16.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(1.0000F, 0.0000F, 15.0000F, 3.0000F).texture(IcariaTextureSlots.SMOOTH_LOG))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 15.0000F, 3.0000F).texture(IcariaTextureSlots.SMOOTH_LOG))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(1.0000F, 0.0000F, 16.0000F, 3.0000F).texture(IcariaTextureSlots.SMOOTH_LOG))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(1.0000F, 1.0000F, 15.0000F, 16.0000F).texture(IcariaTextureSlots.PLANKS))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(1.0000F, 1.0000F, 15.0000F, 16.0000F).texture(IcariaTextureSlots.SMOOTH_LOG)))
			.element(elementBuilder -> elementBuilder.from(15.0000F, 14.0000F, 1.0000F).to(16.0000F, 16.0000F, 16.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 15.0000F, 2.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(15.0000F, 1.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0000F, 1.0000F, 1.0000F, 16.0000F).texture(IcariaTextureSlots.LOG)))
			.element(elementBuilder -> elementBuilder.from(2.0000F, 0.0000F, 2.0000F).to(4.0000F, 13.0000F, 4.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 2.0000F, 13.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(2.0000F, 0.0000F, 4.0000F, 13.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(12.0000F, 0.0000F, 14.0000F, 13.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(14.0000F, 0.0000F, 16.0000F, 13.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0000F, 13.0000F, 2.0000F, 15.0000F).texture(IcariaTextureSlots.STRIPPED_LOG)))
			.element(elementBuilder -> elementBuilder.from(12.0000F, 0.0000F, 2.0000F).to(14.0000F, 13.0000F, 4.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(2.0000F, 0.0000F, 4.0000F, 13.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(12.0000F, 0.0000F, 14.0000F, 13.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(14.0000F, 0.0000F, 16.0000F, 13.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 2.0000F, 13.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(2.0000F, 13.0000F, 4.0000F, 15.0000F).texture(IcariaTextureSlots.STRIPPED_LOG)))
			.build();
	}
}

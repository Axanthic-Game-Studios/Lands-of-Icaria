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

public class SuspiciousSubstanceModel {

	public static ExtendedModelTemplate template() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(2.1250F, 0.7750F, 1.2500F).to(2.8750F, 0.7750F, 5.7500F)
				.rotation(rotationBuilder -> rotationBuilder.angle(22.5000F).axis(Direction.Axis.Y).origin(2.5000F, 0.0250F, 3.5000F))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 0.7500F, 6.0000F).texture(IcariaTextureSlots.RED_ARACHNE_STRING_BLOCK))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 0.7500F, 6.0000F).texture(IcariaTextureSlots.RED_ARACHNE_STRING_BLOCK).rotation(Quadrant.R180)))
			.element(elementBuilder -> elementBuilder.from(2.1250F, 0.0250F, 1.2500F).to(2.1250F, 0.7750F, 5.7500F)
				.rotation(rotationBuilder -> rotationBuilder.angle(22.5000F).axis(Direction.Axis.Y).origin(2.5000F, 0.0250F, 3.5000F))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 0.7500F, 6.0000F).texture(IcariaTextureSlots.RED_ARACHNE_STRING_BLOCK).rotation(Quadrant.R90))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 0.7500F, 6.0000F).texture(IcariaTextureSlots.RED_ARACHNE_STRING_BLOCK).rotation(Quadrant.R270)))
			.element(elementBuilder -> elementBuilder.from(2.1250F, 0.0250F, 1.2500F).to(2.8750F, 0.0250F, 5.7500F)
				.rotation(rotationBuilder -> rotationBuilder.angle(22.5000F).axis(Direction.Axis.Y).origin(2.5000F, 0.0250F, 3.5000F))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 0.7500F, 6.0000F).texture(IcariaTextureSlots.RED_ARACHNE_STRING_BLOCK))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 0.7500F, 6.0000F).texture(IcariaTextureSlots.RED_ARACHNE_STRING_BLOCK).rotation(Quadrant.R180)))
			.element(elementBuilder -> elementBuilder.from(2.8750F, 0.0250F, 1.2500F).to(2.8750F, 0.7750F, 5.7500F)
				.rotation(rotationBuilder -> rotationBuilder.angle(22.5000F).axis(Direction.Axis.Y).origin(2.5000F, 0.0250F, 3.5000F))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 0.7500F, 6.0000F).texture(IcariaTextureSlots.RED_ARACHNE_STRING_BLOCK).rotation(Quadrant.R90))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 0.7500F, 6.0000F).texture(IcariaTextureSlots.RED_ARACHNE_STRING_BLOCK).rotation(Quadrant.R270)))
			.element(elementBuilder -> elementBuilder.from(5.0000F, -0.2500F, 2.2500F).to(9.0000F, 0.2500F, 2.7500F)
				.rotation(rotationBuilder -> rotationBuilder.angle(-45.0000F).axis(Direction.Axis.X).origin(7.0000F, 0.0000F, 2.5000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 2.0000F).texture(IcariaTextureSlots.WHITE_CONCRETE_POWDER))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 8.0000F, 2.0000F, 10.0000F).texture(IcariaTextureSlots.WHITE_CONCRETE_POWDER))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 2.0000F, 16.0000F, 4.0000F).texture(IcariaTextureSlots.WHITE_CONCRETE_POWDER))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(14.0000F, 8.0000F, 16.0000F, 10.0000F).texture(IcariaTextureSlots.WHITE_CONCRETE_POWDER))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0000F, 4.0000F, 16.0000F, 6.0000F).texture(IcariaTextureSlots.WHITE_CONCRETE_POWDER))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0000F, 6.0000F, 16.0000F, 8.0000F).texture(IcariaTextureSlots.WHITE_CONCRETE_POWDER)))
			.element(elementBuilder -> elementBuilder.from(8.0000F, -0.2500F, 3.7500F).to(11.5000F, 0.2500F, 4.2500F)
				.rotation(rotationBuilder -> rotationBuilder.angle(-45.0000F).axis(Direction.Axis.X).origin(9.7500F, 0.0000F, 4.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 14.0000F, 2.0000F).texture(IcariaTextureSlots.WHITE_CONCRETE_POWDER))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 8.0000F, 2.0000F, 10.0000F).texture(IcariaTextureSlots.WHITE_CONCRETE_POWDER))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 2.0000F, 14.0000F, 4.0000F).texture(IcariaTextureSlots.WHITE_CONCRETE_POWDER))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(12.0000F, 8.0000F, 14.0000F, 10.0000F).texture(IcariaTextureSlots.WHITE_CONCRETE_POWDER))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0000F, 4.0000F, 14.0000F, 6.0000F).texture(IcariaTextureSlots.WHITE_CONCRETE_POWDER))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0000F, 6.0000F, 14.0000F, 8.0000F).texture(IcariaTextureSlots.WHITE_CONCRETE_POWDER)))
			.element(elementBuilder -> elementBuilder.from(4.0000F, -0.2500F, 4.2500F).to(7.0000F, 0.2500F, 4.7500F)
				.rotation(rotationBuilder -> rotationBuilder.angle(-45.0000F).axis(Direction.Axis.X).origin(5.5000F, 0.0000F, 4.5000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 12.0000F, 2.0000F).texture(IcariaTextureSlots.WHITE_CONCRETE_POWDER))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 8.0000F, 2.0000F, 10.0000F).texture(IcariaTextureSlots.WHITE_CONCRETE_POWDER))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 2.0000F, 12.0000F, 4.0000F).texture(IcariaTextureSlots.WHITE_CONCRETE_POWDER))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(10.0000F, 8.0000F, 12.0000F, 10.0000F).texture(IcariaTextureSlots.WHITE_CONCRETE_POWDER))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0000F, 4.0000F, 12.0000F, 6.0000F).texture(IcariaTextureSlots.WHITE_CONCRETE_POWDER))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0000F, 6.0000F, 12.0000F, 8.0000F).texture(IcariaTextureSlots.WHITE_CONCRETE_POWDER)))
			.element(elementBuilder -> elementBuilder.from(12.0000F, 0.0000F, 5.0000F).to(14.0000F, 2.0000F, 7.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(22.5000F).axis(Direction.Axis.Y).origin(13.0000F, 1.0000F, 6.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 4.0000F, 4.0000F).texture(IcariaTextureSlots.CALCITE))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 4.0000F, 4.0000F).texture(IcariaTextureSlots.CALCITE))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 4.0000F, 4.0000F).texture(IcariaTextureSlots.CALCITE))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 4.0000F, 4.0000F).texture(IcariaTextureSlots.CALCITE))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 4.0000F, 4.0000F).texture(IcariaTextureSlots.CALCITE))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 4.0000F, 4.0000F).texture(IcariaTextureSlots.CALCITE)))
			.element(elementBuilder -> elementBuilder.from(11.0000F, 0.0000F, 5.0000F).to(12.0000F, 1.0000F, 6.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(11.5000F, 0.5000F, 5.5000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(4.0000F, 4.0000F, 6.0000F, 6.0000F).texture(IcariaTextureSlots.CALCITE))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(4.0000F, 4.0000F, 6.0000F, 6.0000F).texture(IcariaTextureSlots.CALCITE))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(4.0000F, 4.0000F, 6.0000F, 6.0000F).texture(IcariaTextureSlots.CALCITE))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(4.0000F, 4.0000F, 6.0000F, 6.0000F).texture(IcariaTextureSlots.CALCITE))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(4.0000F, 4.0000F, 6.0000F, 6.0000F).texture(IcariaTextureSlots.CALCITE))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(4.0000F, 4.0000F, 6.0000F, 6.0000F).texture(IcariaTextureSlots.CALCITE)))
			.build();
	}
}

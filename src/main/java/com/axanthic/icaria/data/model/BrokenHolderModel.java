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

public class BrokenHolderModel {

	public static ExtendedModelTemplate template0() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(0.0000F, 8.0000F, 15.0000F).to(16.0000F, 12.0000F, 16.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0000F).axis(Direction.Axis.Y).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 8.0000F, 16.0000F, 12.0000F).texture(IcariaTextureSlots.PLANKS))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 8.0000F, 1.0000F, 12.0000F).texture(IcariaTextureSlots.PLANKS))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(16.0000F, 8.0000F, 0.0000F, 12.0000F).texture(IcariaTextureSlots.PLANKS))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(15.0000F, 8.0000F, 16.0000F, 12.0000F).texture(IcariaTextureSlots.PLANKS))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(16.0000F, 8.0000F, 0.0000F, 9.0000F).texture(IcariaTextureSlots.PLANKS))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(16.0000F, 11.0000F, 0.0000F, 12.0000F).texture(IcariaTextureSlots.PLANKS)))
			.build();
	}

	public static ExtendedModelTemplate template1() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(0.0000F, 8.0000F, 15.0000F).to(16.0000F, 12.0000F, 16.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(-22.5000F).axis(Direction.Axis.Z).origin(0.0000F, 8.0000F, 16.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 8.0000F, 16.0000F, 12.0000F).texture(IcariaTextureSlots.PLANKS))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 8.0000F, 1.0000F, 12.0000F).texture(IcariaTextureSlots.PLANKS))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(16.0000F, 8.0000F, 0.0000F, 12.0000F).texture(IcariaTextureSlots.PLANKS))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(15.0000F, 8.0000F, 16.0000F, 12.0000F).texture(IcariaTextureSlots.PLANKS))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(16.0000F, 8.0000F, 0.0000F, 9.0000F).texture(IcariaTextureSlots.PLANKS))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(16.0000F, 11.0000F, 0.0000F, 12.0000F).texture(IcariaTextureSlots.PLANKS)))
			.build();
	}

	public static ExtendedModelTemplate template2() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(0.0000F, 6.0000F, 15.0000F).to(16.0000F, 10.0000F, 16.0000F)
				.rotation(rotationBuilder -> rotationBuilder.angle(22.5000F).axis(Direction.Axis.Z).origin(16.0000F, 6.0000F, 16.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 8.0000F, 16.0000F, 12.0000F).texture(IcariaTextureSlots.PLANKS))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 8.0000F, 1.0000F, 12.0000F).texture(IcariaTextureSlots.PLANKS))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(16.0000F, 8.0000F, 0.0000F, 12.0000F).texture(IcariaTextureSlots.PLANKS))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(15.0000F, 8.0000F, 16.0000F, 12.0000F).texture(IcariaTextureSlots.PLANKS))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(16.0000F, 8.0000F, 0.0000F, 9.0000F).texture(IcariaTextureSlots.PLANKS))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(16.0000F, 11.0000F, 0.0000F, 12.0000F).texture(IcariaTextureSlots.PLANKS)))
			.build();
	}
}

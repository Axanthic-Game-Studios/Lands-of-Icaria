package com.axanthic.icaria.data.model;

import com.axanthic.icaria.common.registry.IcariaKeys;
import com.axanthic.icaria.common.registry.IcariaTextureSlots;
import com.axanthic.icaria.data.provider.model.IcariaModelProvider;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemDisplayContext;

import net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplate;
import net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplateBuilder;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class KitchenTableInventoryModel {

	public static ExtendedModelTemplate template() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaKeys.MC, "block"))
			.transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND, transformVecBuilder -> transformVecBuilder.rotation(0.0000F, 135.0000F, 0.0000F).translation(0.0000F, 0.0000F, 0.0000F).scale(0.3500F))
			.transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND, transformVecBuilder -> transformVecBuilder.rotation(0.0000F, 135.0000F, 0.0000F).translation(0.0000F, 0.0000F, 0.0000F).scale(0.3500F))
			.transform(ItemDisplayContext.FIXED, transformVecBuilder -> transformVecBuilder.rotation(0.0000F, 0.0000F, 0.0000F).translation(0.0000F, -3.0000F, 0.0000F).scale(0.3500F))
			.transform(ItemDisplayContext.GROUND, transformVecBuilder -> transformVecBuilder.rotation(0.0000F, 0.0000F, 0.0000F).translation(0.0000F, 4.5000F, 0.0000F).scale(0.3500F))
			.transform(ItemDisplayContext.GUI, transformVecBuilder -> transformVecBuilder.rotation(30.0000F, 225.0000F, 0.0000F).translation(0.0000F, -2.0000F, 0.0000F).scale(0.3500F))
			.transform(ItemDisplayContext.HEAD, transformVecBuilder -> transformVecBuilder.rotation(0.0000F, 0.0000F, 0.0000F).translation(0.0000F, 9.0000F, 0.0000F).scale(0.3500F))
			.transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND, transformVecBuilder -> transformVecBuilder.rotation(75.0000F, 135.0000F, 0.0000F).translation(0.0000F, 2.5000F, 0.0000F).scale(0.3500F))
			.transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND, transformVecBuilder -> transformVecBuilder.rotation(75.0000F, 135.0000F, 0.0000F).translation(0.0000F, 2.5000F, 0.0000F).scale(0.3500F))
			.element(elementBuilder -> elementBuilder.from(0.0000F, 14.0000F, -8.0000F).to(16.0000F, 16.0000F, -7.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, -8.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 2.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(15.0000F, 0.0000F, 16.0000F, 2.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 1.0000F, 2.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 1.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0000F, 15.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.LOG)))
			.element(elementBuilder -> elementBuilder.from(12.0000F, 0.0000F, 20.0000F).to(14.0000F, 13.0000F, 22.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(16.0000F, 0.0000F, 24.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(12.0000F, 0.0000F, 14.0000F, 13.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(14.0000F, 0.0000F, 16.0000F, 13.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 2.0000F, 13.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(2.0000F, 0.0000F, 4.0000F, 13.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(12.0000F, 13.0000F, 14.0000F, 15.0000F).texture(IcariaTextureSlots.STRIPPED_LOG)))
			.element(elementBuilder -> elementBuilder.from(2.0000F, 0.0000F, 20.0000F).to(4.0000F, 13.0000F, 22.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(16.0000F, 0.0000F, 24.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(14.0000F, 0.0000F, 16.0000F, 13.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 2.0000F, 13.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(2.0000F, 0.0000F, 4.0000F, 13.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(12.0000F, 0.0000F, 14.0000F, 13.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(14.0000F, 13.0000F, 16.0000F, 15.0000F).texture(IcariaTextureSlots.STRIPPED_LOG)))
			.element(elementBuilder -> elementBuilder.from(0.0000F, 14.0000F, 23.0000F).to(16.0000F, 16.0000F, 24.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(16.0000F, 0.0000F, 24.0000F))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 1.0000F, 2.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 2.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(15.0000F, 0.0000F, 16.0000F, 2.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0000F, 15.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 1.0000F).texture(IcariaTextureSlots.LOG)))
			.element(elementBuilder -> elementBuilder.from(15.0000F, 14.0000F, 8.0000F).to(16.0000F, 16.0000F, 23.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(16.0000F, 0.0000F, 24.0000F))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 15.0000F, 2.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(15.0000F, 1.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(15.0000F, 0.0000F, 16.0000F, 15.0000F).texture(IcariaTextureSlots.LOG)))
			.element(elementBuilder -> elementBuilder.from(1.0000F, 13.0000F, 8.0000F).to(15.0000F, 16.0000F, 23.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(16.0000F, 0.0000F, 24.0000F))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 15.0000F, 3.0000F).texture(IcariaTextureSlots.SMOOTH_LOG))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(1.0000F, 0.0000F, 15.0000F, 3.0000F).texture(IcariaTextureSlots.SMOOTH_LOG))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(1.0000F, 0.0000F, 16.0000F, 3.0000F).texture(IcariaTextureSlots.SMOOTH_LOG))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(1.0000F, 1.0000F, 15.0000F, 16.0000F).texture(IcariaTextureSlots.PLANKS))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(1.0000F, 0.0000F, 15.0000F, 15.0000F).texture(IcariaTextureSlots.SMOOTH_LOG)))
			.element(elementBuilder -> elementBuilder.from(0.0000F, 14.0000F, 8.0000F).to(1.0000F, 16.0000F, 23.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(16.0000F, 0.0000F, 24.0000F))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(1.0000F, 0.0000F, 16.0000F, 2.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0000F, 1.0000F, 1.0000F, 16.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 1.0000F, 15.0000F).texture(IcariaTextureSlots.LOG)))
			.element(elementBuilder -> elementBuilder.from(0.0000F, 14.0000F, -7.0000F).to(1.0000F, 16.0000F, 8.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, -8.0000F))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 15.0000F, 2.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 1.0000F, 15.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0000F, 1.0000F, 1.0000F, 16.0000F).texture(IcariaTextureSlots.LOG)))
			.element(elementBuilder -> elementBuilder.from(1.0000F, 13.0000F, -7.0000F).to(15.0000F, 16.0000F, 8.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, -8.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(1.0000F, 0.0000F, 15.0000F, 3.0000F).texture(IcariaTextureSlots.SMOOTH_LOG))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(1.0000F, 0.0000F, 16.0000F, 3.0000F).texture(IcariaTextureSlots.SMOOTH_LOG))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 15.0000F, 3.0000F).texture(IcariaTextureSlots.SMOOTH_LOG))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(1.0000F, 0.0000F, 15.0000F, 15.0000F).texture(IcariaTextureSlots.PLANKS))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(1.0000F, 1.0000F, 15.0000F, 16.0000F).texture(IcariaTextureSlots.SMOOTH_LOG)))
			.element(elementBuilder -> elementBuilder.from(15.0000F, 14.0000F, -7.0000F).to(16.0000F, 16.0000F, 8.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, -8.0000F))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(1.0000F, 0.0000F, 16.0000F, 2.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(15.0000F, 0.0000F, 16.0000F, 15.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(15.0000F, 1.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.LOG)))
			.element(elementBuilder -> elementBuilder.from(2.0000F, 0.0000F, -6.0000F).to(4.0000F, 13.0000F, -4.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, -8.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 2.0000F, 13.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(2.0000F, 0.0000F, 4.0000F, 13.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(12.0000F, 0.0000F, 14.0000F, 13.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(14.0000F, 0.0000F, 16.0000F, 13.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0000F, 13.0000F, 2.0000F, 15.0000F).texture(IcariaTextureSlots.STRIPPED_LOG)))
			.element(elementBuilder -> elementBuilder.from(12.0000F, 0.0000F, -6.0000F).to(14.0000F, 13.0000F, -4.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, -8.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(2.0000F, 0.0000F, 4.0000F, 13.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(12.0000F, 0.0000F, 14.0000F, 13.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(14.0000F, 0.0000F, 16.0000F, 13.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 2.0000F, 13.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(2.0000F, 13.0000F, 4.0000F, 15.0000F).texture(IcariaTextureSlots.STRIPPED_LOG)))
			.build();
	}
}

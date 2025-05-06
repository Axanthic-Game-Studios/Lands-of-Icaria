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

public class CardonCactusInventoryModel {

	public static ExtendedModelTemplate template() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(4.0F, 0.0F, 4.0F).to(12.0F, 12.0F, 12.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(4.0F, 4.0F, 12.0F, 16.0F).texture(IcariaTextureSlots.SIDE))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(4.0F, 4.0F, 12.0F, 16.0F).texture(IcariaTextureSlots.SIDE))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(4.0F, 4.0F, 12.0F, 16.0F).texture(IcariaTextureSlots.SIDE))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(4.0F, 4.0F, 12.0F, 16.0F).texture(IcariaTextureSlots.SIDE))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(4.0F, 4.0F, 12.0F, 12.0F).texture(IcariaTextureSlots.SIDE))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(4.0F, 4.0F, 12.0F, 12.0F).texture(IcariaTextureSlots.BOTTOM)))
			.build();
	}
}

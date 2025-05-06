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

public class StrawberryBushModel {

	public static ExtendedModelTemplate template() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(8.0F, 0.0F, 0.0F).to(8.0F, 8.0F, 16.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(45.0F).axis(Direction.Axis.Y).origin(8.0F, 9.0F, 8.0F))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0F, 8.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.BUSH))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0F, 8.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.BUSH)))
			.element(elementBuilder -> elementBuilder.from(8.0F, 0.0F, 0.0F).to(8.0F, 8.0F, 16.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(-45.0F).axis(Direction.Axis.Y).origin(8.0F, 9.0F, 8.0F))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0F, 8.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.BUSH))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0F, 8.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.BUSH)))
			.element(elementBuilder -> elementBuilder.from(0.0F, 2.0F, 0.0F).to(16.0F, 2.0F, 16.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(45.0F).axis(Direction.Axis.Y).origin(8.0F, 9.0F, 8.0F))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0F, 0.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.BUSH_HORIZONTAL))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0F, 0.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.BUSH_HORIZONTAL)))
			.build();
	}
}

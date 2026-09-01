package com.axanthic.icaria.data.model;

import com.axanthic.icaria.common.registry.IcariaKeys;
import com.axanthic.icaria.common.registry.IcariaTextureSlots;
import com.axanthic.icaria.data.provider.model.IcariaModelProvider;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.core.Direction;

import net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplate;
import net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplateBuilder;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class StrawberryBushModel {

	public static ExtendedModelTemplate template() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaKeys.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(8.0000F, 0.0000F, 0.0000F).to(8.0000F, 8.0000F, 16.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 45.0000F, 0.0000F).origin(8.0000F, 9.0000F, 8.0000F))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 8.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.BUSH))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 8.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.BUSH)))
			.element(elementBuilder -> elementBuilder.from(8.0000F, 0.0000F, 0.0000F).to(8.0000F, 8.0000F, 16.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, -45.0000F, 0.0000F).origin(8.0000F, 9.0000F, 8.0000F))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 8.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.BUSH))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 8.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.BUSH)))
			.element(elementBuilder -> elementBuilder.from(0.0000F, 2.0000F, 0.0000F).to(16.0000F, 2.0000F, 16.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 45.0000F, 0.0000F).origin(8.0000F, 9.0000F, 8.0000F))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.BUSH_HORIZONTAL))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.BUSH_HORIZONTAL)))
			.build();
	}
}

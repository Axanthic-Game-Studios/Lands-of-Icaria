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

public class HorizontalBarsModel {

	public static ExtendedModelTemplate template() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaKeys.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(0.0000F, 7.0000F, 0.0000F).to(0.0000F, 9.0000F, 16.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(7.0000F, 0.0000F, 9.0000F, 16.0000F).rotation(Quadrant.R90).texture(IcariaTextureSlots.TEXTURE).cullface(Direction.WEST))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(7.0000F, 0.0000F, 9.0000F, 16.0000F).rotation(Quadrant.R90).texture(IcariaTextureSlots.TEXTURE).cullface(Direction.WEST)))
			.element(elementBuilder -> elementBuilder.from(16.0000F, 7.0000F, 0.0000F).to(16.0000F, 9.0000F, 16.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(7.0000F, 0.0000F, 9.0000F, 16.0000F).rotation(Quadrant.R90).texture(IcariaTextureSlots.TEXTURE).cullface(Direction.EAST))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(7.0000F, 0.0000F, 9.0000F, 16.0000F).rotation(Quadrant.R90).texture(IcariaTextureSlots.TEXTURE).cullface(Direction.EAST)))
			.element(elementBuilder -> elementBuilder.from(0.0000F, 7.0000F, 0.0000F).to(16.0000F, 9.0000F, 0.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(7.0000F, 0.0000F, 9.0000F, 16.0000F).rotation(Quadrant.R90).texture(IcariaTextureSlots.TEXTURE).cullface(Direction.NORTH))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(7.0000F, 0.0000F, 9.0000F, 16.0000F).rotation(Quadrant.R90).texture(IcariaTextureSlots.TEXTURE).cullface(Direction.NORTH)))
			.element(elementBuilder -> elementBuilder.from(0.0000F, 7.0000F, 16.0000F).to(16.0000F, 9.0000F, 16.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(7.0000F, 0.0000F, 9.0000F, 16.0000F).rotation(Quadrant.R90).texture(IcariaTextureSlots.TEXTURE).cullface(Direction.SOUTH))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(7.0000F, 0.0000F, 9.0000F, 16.0000F).rotation(Quadrant.R90).texture(IcariaTextureSlots.TEXTURE).cullface(Direction.SOUTH)))
			.element(elementBuilder -> elementBuilder.from(0.0000F, 8.0000F, 0.0000F).to(16.0000F, 8.0000F, 16.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE)))
			.build();
	}
}

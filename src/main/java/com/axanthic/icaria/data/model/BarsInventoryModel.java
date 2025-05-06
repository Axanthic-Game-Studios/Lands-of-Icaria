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

public class BarsInventoryModel {

	public static ExtendedModelTemplate template() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(8.0F, 0.0F, 0.0F).to(8.0F, 16.0F, 16.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0F).axis(Direction.Axis.Y).origin(1.0F, 0.0F, 0.0F))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0F, 0.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0F, 0.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE)))
			.element(elementBuilder -> elementBuilder.from(7.0F, 0.0F, 0.0F).to(9.0F, 0.0F, 16.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0F).axis(Direction.Axis.Y).origin(7.0F, 0.0F, 0.0F))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(9.0F, 16.0F, 7.0F, 0.0F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(7.0F, 0.0F, 9.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE)))
			.element(elementBuilder -> elementBuilder.from(7.0F, 16.0F, 0.0F).to(9.0F, 16.0F, 16.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0F).axis(Direction.Axis.Y).origin(7.0F, 16.0F, 0.0F))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(9.0F, 16.0F, 7.0F, 0.0F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(7.0F, 0.0F, 9.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE)))
			.element(elementBuilder -> elementBuilder.from(7.0F, 0.0F, 0.0F).to(9.0F, 16.0F, 0.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0F).axis(Direction.Axis.Y).origin(7.0F, 0.0F, 0.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(7.0F, 0.0F, 9.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(9.0F, 0.0F, 7.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE)))
			.element(elementBuilder -> elementBuilder.from(7.0F, 0.0F, 16.0F).to(9.0F, 16.0F, 16.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0F).axis(Direction.Axis.Y).origin(7.0F, 0.0F, 16.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(9.0F, 0.0F, 7.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(7.0F, -1.0F, 9.0F, 16.0F).texture(IcariaTextureSlots.TEXTURE)))
			.build();
	}
}

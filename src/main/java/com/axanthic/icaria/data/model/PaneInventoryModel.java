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

public class PaneInventoryModel {

	public static ExtendedModelTemplate template() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIdents.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(7.0F, 0.0F, 0.0F).to(9.0F, 16.0F, 16.0F)
				.rotation(rotationBuilder -> rotationBuilder.angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(7.0F, 0.0F, 9.0F, 16.0F).texture(IcariaTextureSlots.EDGE))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0F, 0.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.PANE))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(7.0F, 0.0F, 9.0F, 16.0F).texture(IcariaTextureSlots.EDGE))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0F, 0.0F, 16.0F, 16.0F).texture(IcariaTextureSlots.PANE))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(9.0F, 16.0F, 7.0F, 0.0F).texture(IcariaTextureSlots.EDGE))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(9.0F, 16.0F, 7.0F, 0.0F).texture(IcariaTextureSlots.EDGE)))
			.build();
	}
}

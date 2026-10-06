package com.axanthic.icaria.data.model;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.registry.IcariaIds;
import com.axanthic.icaria.common.registry.IcariaTextureSlots;
import com.axanthic.icaria.data.provider.model.IcariaModelProvider;

import net.minecraft.core.Direction;

import net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplate;
import net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplateBuilder;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class PowderJarModel {

	public static ExtendedModelTemplate template() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIds.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(6.5000F, 10.0000F, 6.5000F).to(9.5000F, 12.0000F, 9.5000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 22.5000F, 0.0000F).origin(8.0000F, 11.0000F, 8.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(8.0000F, 12.0000F, 12.0000F, 16.0000F).texture(IcariaTextureSlots.KETTLE))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(8.0000F, 12.0000F, 12.0000F, 16.0000F).texture(IcariaTextureSlots.KETTLE))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(8.0000F, 12.0000F, 12.0000F, 16.0000F).texture(IcariaTextureSlots.KETTLE))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(8.0000F, 12.0000F, 12.0000F, 16.0000F).texture(IcariaTextureSlots.KETTLE))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(8.0000F, 12.0000F, 12.0000F, 16.0000F).texture(IcariaTextureSlots.KETTLE))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(8.0000F, 12.0000F, 12.0000F, 16.0000F).texture(IcariaTextureSlots.KETTLE)))
			.element(elementBuilder -> elementBuilder.from(4.2500F, 0.2500F, 4.2500F).to(11.7500F, 6.2500F, 11.7500F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 22.5000F, 0.0000F).origin(8.0000F, 3.2500F, 8.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 3.0000F, 15.0000F, 15.0000F).texture(IcariaTextureSlots.YELLOW_CONCRETE_POWDER))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 3.0000F, 15.0000F, 15.0000F).texture(IcariaTextureSlots.YELLOW_CONCRETE_POWDER))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 3.0000F, 15.0000F, 15.0000F).texture(IcariaTextureSlots.YELLOW_CONCRETE_POWDER))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 3.0000F, 15.0000F, 15.0000F).texture(IcariaTextureSlots.YELLOW_CONCRETE_POWDER))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 15.0000F, 15.0000F).texture(IcariaTextureSlots.YELLOW_CONCRETE_POWDER))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 15.0000F, 15.0000F).texture(IcariaTextureSlots.YELLOW_CONCRETE_POWDER)))
			.element(elementBuilder -> elementBuilder.from(4.0000F, 0.0000F, 4.0000F).to(12.0000F, 10.0000F, 12.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 22.5000F, 0.0000F).origin(8.0000F, 5.0000F, 8.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(12.0000F, 12.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.KETTLE))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(12.0000F, 12.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.KETTLE))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(12.0000F, 12.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.KETTLE))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(12.0000F, 12.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.KETTLE))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(12.0000F, 12.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.KETTLE))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(12.0000F, 12.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.KETTLE)))
			.build();
	}
}

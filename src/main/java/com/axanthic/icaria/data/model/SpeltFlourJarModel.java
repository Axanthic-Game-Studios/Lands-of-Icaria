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

public class SpeltFlourJarModel {

	public static ExtendedModelTemplate template() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIds.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(6.5000F, 10.0000F, 6.5000F).to(9.5000F, 12.0000F, 9.5000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 22.5000F, 0.0000F).origin(8.0000F, 11.0000F, 8.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(8.0000F, 8.0000F, 12.0000F, 12.0000F).texture(IcariaTextureSlots.KETTLE))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(8.0000F, 8.0000F, 12.0000F, 12.0000F).texture(IcariaTextureSlots.KETTLE))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(8.0000F, 8.0000F, 12.0000F, 12.0000F).texture(IcariaTextureSlots.KETTLE))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(8.0000F, 8.0000F, 12.0000F, 12.0000F).texture(IcariaTextureSlots.KETTLE))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(8.0000F, 8.0000F, 12.0000F, 12.0000F).texture(IcariaTextureSlots.KETTLE))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(8.0000F, 8.0000F, 12.0000F, 12.0000F).texture(IcariaTextureSlots.KETTLE)))
			.element(elementBuilder -> elementBuilder.from(4.2500F, 0.2500F, 4.2500F).to(11.7500F, 3.7500F, 11.7500F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 22.5000F, 0.0000F).origin(8.0000F, 3.2500F, 8.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(1.0000F, 9.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.SPELT_FLOUR_JAR))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(1.0000F, 9.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.SPELT_FLOUR_JAR))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(1.0000F, 9.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.SPELT_FLOUR_JAR))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(1.0000F, 9.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.SPELT_FLOUR_JAR))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(1.0000F, 1.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.SPELT_FLOUR_JAR))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(1.0000F, 1.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.SPELT_FLOUR_JAR)))
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

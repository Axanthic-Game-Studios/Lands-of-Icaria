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

public class TimberTableModel {

	public static ExtendedModelTemplate front() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIds.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(0.0000F, 11.0000F, 0.0000F).to(1.0000F, 16.0000F, 16.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(15.0000F, 8.0000F, 16.0000F, 13.0000F).texture(IcariaTextureSlots.LOG_TOP))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 8.0000F, 16.0000F, 13.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 1.0000F, 16.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 1.0000F, 16.0000F).texture(IcariaTextureSlots.LOG)))
			.element(elementBuilder -> elementBuilder.from(1.0000F, 9.0000F, 0.0000F).to(15.0000F, 16.0000F, 16.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(1.0000F, 8.0000F, 15.0000F, 15.0000F).texture(IcariaTextureSlots.LOG_TOP))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 8.0000F, 16.0000F, 15.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 8.0000F, 16.0000F, 15.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(1.0000F, 0.0000F, 15.0000F, 16.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(1.0000F, 0.0000F, 15.0000F, 16.0000F).texture(IcariaTextureSlots.LOG)))
			.element(elementBuilder -> elementBuilder.from(15.0000F, 11.0000F, 0.0000F).to(16.0000F, 16.0000F, 16.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 8.0000F, 1.0000F, 13.0000F).texture(IcariaTextureSlots.LOG_TOP))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 8.0000F, 16.0000F, 13.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(15.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(15.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.LOG)))
			.element(elementBuilder -> elementBuilder.from(3.0000F, 8.0000F, 0.0000F).to(13.0000F, 9.0000F, 16.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(3.0000F, 15.0000F, 13.0000F, 16.0000F).texture(IcariaTextureSlots.LOG_TOP))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 15.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 15.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(3.0000F, 0.0000F, 13.0000F, 16.0000F).texture(IcariaTextureSlots.LOG)))
			.element(elementBuilder -> elementBuilder.from(1.0000F, 0.0000F, 2.0000F).to(4.0000F, 10.0000F, 5.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, -22.5000F).origin(1.0000F, 0.0000F, 3.5000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 3.0000F, 3.0000F, 13.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(3.0000F, 3.0000F, 6.0000F, 13.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(10.0000F, 3.0000F, 13.0000F, 13.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(13.0000F, 3.0000F, 16.0000F, 13.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 3.0000F, 3.0000F).texture(IcariaTextureSlots.STRIPPED_LOG_TOP)))
			.element(elementBuilder -> elementBuilder.from(12.0000F, 0.0000F, 2.0000F).to(15.0000F, 10.0000F, 5.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 22.5000F).origin(15.0000F, 0.0000F, 3.5000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(13.0000F, 3.0000F, 16.0000F, 13.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(10.0000F, 3.0000F, 13.0000F, 13.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(3.0000F, 3.0000F, 6.0000F, 13.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 3.0000F, 3.0000F, 13.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(13.0000F, 0.0000F, 16.0000F, 3.0000F).texture(IcariaTextureSlots.STRIPPED_LOG_TOP)))
			.build();
	}

	public static ExtendedModelTemplate back() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIds.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(0.0000F, 11.0000F, 0.0000F).to(1.0000F, 16.0000F, 16.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 8.0000F, 1.0000F, 13.0000F).texture(IcariaTextureSlots.LOG_TOP))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 8.0000F, 16.0000F, 13.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 1.0000F, 16.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 1.0000F, 16.0000F).texture(IcariaTextureSlots.LOG)))
			.element(elementBuilder -> elementBuilder.from(1.0000F, 9.0000F, 0.0000F).to(15.0000F, 16.0000F, 16.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 8.0000F, 16.0000F, 15.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(1.0000F, 8.0000F, 15.0000F, 15.0000F).texture(IcariaTextureSlots.LOG_TOP))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 8.0000F, 16.0000F, 15.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(1.0000F, 0.0000F, 15.0000F, 16.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(1.0000F, 0.0000F, 15.0000F, 16.0000F).texture(IcariaTextureSlots.LOG)))
			.element(elementBuilder -> elementBuilder.from(15.0000F, 11.0000F, 0.0000F).to(16.0000F, 16.0000F, 16.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 8.0000F, 16.0000F, 13.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(15.0000F, 8.0000F, 16.0000F, 13.0000F).texture(IcariaTextureSlots.LOG_TOP))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(15.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(15.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.LOG)))
			.element(elementBuilder -> elementBuilder.from(3.0000F, 8.0000F, 0.0000F).to(13.0000F, 9.0000F, 16.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 15.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(3.0000F, 15.0000F, 13.0000F, 16.0000F).texture(IcariaTextureSlots.LOG_TOP))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 15.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.LOG))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(3.0000F, 0.0000F, 13.0000F, 16.0000F).texture(IcariaTextureSlots.LOG)))
			.element(elementBuilder -> elementBuilder.from(1.0000F, 0.0000F, 11.0000F).to(4.0000F, 10.0000F, 14.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, -22.5000F).origin(1.0000F, 0.0000F, 12.5000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 3.0000F, 3.0000F, 13.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(3.0000F, 3.0000F, 6.0000F, 13.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(10.0000F, 3.0000F, 13.0000F, 13.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(13.0000F, 3.0000F, 16.0000F, 13.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 3.0000F, 3.0000F).texture(IcariaTextureSlots.STRIPPED_LOG_TOP)))
			.element(elementBuilder -> elementBuilder.from(12.0000F, 0.0000F, 11.0000F).to(15.0000F, 10.0000F, 14.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 22.5000F).origin(15.0000F, 0.0000F, 12.5000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(13.0000F, 3.0000F, 16.0000F, 13.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(10.0000F, 3.0000F, 13.0000F, 13.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(3.0000F, 3.0000F, 6.0000F, 13.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 3.0000F, 3.0000F, 13.0000F).texture(IcariaTextureSlots.STRIPPED_LOG))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(13.0000F, 0.0000F, 16.0000F, 3.0000F).texture(IcariaTextureSlots.STRIPPED_LOG_TOP)))
			.build();
	}
}

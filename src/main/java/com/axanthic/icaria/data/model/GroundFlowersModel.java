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

public class GroundFlowersModel {

	public static ExtendedModelTemplate template1() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaKeys.MC, "block")).ambientOcclusion(false)
			.element(elementBuilder -> elementBuilder.from(0.0000F, 2.9900F, 0.0000F).to(8.0000F, 2.9900F, 8.0000F)
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 8.0000F, 8.0000F).texture(IcariaTextureSlots.FLOWERS))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0000F, 8.0000F, 8.0000F, 0.0000F).texture(IcariaTextureSlots.FLOWERS)))
			.element(elementBuilder -> elementBuilder.from(4.2500F, 0.0000F, -2.6000F).to(4.2500F, 2.9900F, -1.6000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, -45.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 4.0000F, 1.0000F, 7.0000F).texture(IcariaTextureSlots.STEM).tintindex(0))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 4.0000F, 1.0000F, 7.0000F).texture(IcariaTextureSlots.STEM).tintindex(0)))
			.element(elementBuilder -> elementBuilder.from(3.7500F, 0.0000F, -2.1000F).to(4.7500F, 2.9900F, -2.1000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, -45.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 4.0000F, 1.0000F, 7.0000F).texture(IcariaTextureSlots.STEM).tintindex(0))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 4.0000F, 1.0000F, 7.0000F).texture(IcariaTextureSlots.STEM).tintindex(0)))
			.element(elementBuilder -> elementBuilder.from(4.9000F, 0.0000F, 2.3000F).to(4.9000F, 2.9900F, 3.3000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, -45.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 4.0000F, 1.0000F, 7.0000F).texture(IcariaTextureSlots.STEM).tintindex(0))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 4.0000F, 1.0000F, 7.0000F).texture(IcariaTextureSlots.STEM).tintindex(0)))
			.element(elementBuilder -> elementBuilder.from(4.4000F, 0.0000F, 2.8000F).to(5.4000F, 2.9900F, 2.8000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, -45.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 4.0000F, 1.0000F, 7.0000F).texture(IcariaTextureSlots.STEM).tintindex(0))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 4.0000F, 1.0000F, 7.0000F).texture(IcariaTextureSlots.STEM).tintindex(0)))
			.element(elementBuilder -> elementBuilder.from(9.1500F, 0.0000F, -0.4500F).to(9.1500F, 2.9900F, 0.5500F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, -45.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 4.0000F, 1.0000F, 7.0000F).texture(IcariaTextureSlots.STEM).tintindex(0))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 4.0000F, 1.0000F, 7.0000F).texture(IcariaTextureSlots.STEM).tintindex(0)))
			.element(elementBuilder -> elementBuilder.from(8.6500F, 0.0000F, 0.0500F).to(9.6500F, 2.9900F, 0.0500F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, -45.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 4.0000F, 1.0000F, 7.0000F).texture(IcariaTextureSlots.STEM).tintindex(0))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 4.0000F, 1.0000F, 7.0000F).texture(IcariaTextureSlots.STEM).tintindex(0)))
			.build();
	}

	public static ExtendedModelTemplate template2() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaKeys.MC, "block")).ambientOcclusion(false)
			.element(elementBuilder -> elementBuilder.from(0.0000F, 1.0000F, 8.0000F).to(8.0000F, 1.0000F, 16.0000F)
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0000F, 8.0000F, 8.0000F, 16.0000F).texture(IcariaTextureSlots.FLOWERS))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0000F, 16.0000F, 8.0000F, 8.0000F).texture(IcariaTextureSlots.FLOWERS)))
			.element(elementBuilder -> elementBuilder.from(0.0000F, 1.0000F, 8.0000F).to(8.0000F, 1.0000F, 16.0000F)
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0000F, 8.0000F, 8.0000F, 16.0000F).texture(IcariaTextureSlots.FLOWERS))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0000F, 16.0000F, 8.0000F, 8.0000F).texture(IcariaTextureSlots.FLOWERS)))
			.element(elementBuilder -> elementBuilder.from(10.1500F, 0.0000F, 5.2500F).to(11.1500F, 1.0000F, 5.2500F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, -45.0000F, 0.0000F).origin(0.0000F, 0.0000F, 1.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 6.0000F, 1.0000F, 7.0000F).texture(IcariaTextureSlots.STEM).tintindex(0))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 6.0000F, 1.0000F, 7.0000F).texture(IcariaTextureSlots.STEM).tintindex(0)))
			.element(elementBuilder -> elementBuilder.from(10.6500F, 0.0000F, 4.7500F).to(10.6500F, 1.0000F, 5.7500F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, -45.0000F, 0.0000F).origin(0.0000F, 0.0000F, 1.0000F))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 6.0000F, 1.0000F, 7.0000F).texture(IcariaTextureSlots.STEM).tintindex(0))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 6.0000F, 1.0000F, 7.0000F).texture(IcariaTextureSlots.STEM).tintindex(0)))
			.build();
	}

	public static ExtendedModelTemplate template3() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaKeys.MC, "block")).ambientOcclusion(false)
			.element(elementBuilder -> elementBuilder.from(8.0000F, 2.0000F, 8.0000F).to(16.0000F, 2.0000F, 16.0000F)
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(8.0000F, 8.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.FLOWERS))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(8.0000F, 16.0000F, 16.0000F, 8.0000F).texture(IcariaTextureSlots.FLOWERS)))
			.element(elementBuilder -> elementBuilder.from(17.6500F, 0.0000F, 1.9000F).to(18.6500F, 2.0000F, 1.9000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, -45.0000F, 0.0000F).origin(0.5000F, 0.0000F, 0.5000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 5.0000F, 1.0000F, 7.0000F).texture(IcariaTextureSlots.STEM).tintindex(0))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 5.0000F, 1.0000F, 7.0000F).texture(IcariaTextureSlots.STEM).tintindex(0)))
			.element(elementBuilder -> elementBuilder.from(18.1500F, 0.0000F, 1.4000F).to(18.1500F, 2.0000F, 2.4000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, -45.0000F, 0.0000F).origin(0.5000F, 0.0000F, 0.5000F))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 5.0000F, 1.0000F, 7.0000F).texture(IcariaTextureSlots.STEM).tintindex(0))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 5.0000F, 1.0000F, 7.0000F).texture(IcariaTextureSlots.STEM).tintindex(0)))
			.element(elementBuilder -> elementBuilder.from(17.6500F, 0.0000F, -3.3500F).to(17.6500F, 2.0000F, -2.3500F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, -45.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 5.0000F, 1.0000F, 7.0000F).texture(IcariaTextureSlots.STEM).tintindex(0))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 5.0000F, 1.0000F, 7.0000F).texture(IcariaTextureSlots.STEM).tintindex(0)))
			.element(elementBuilder -> elementBuilder.from(17.1500F, 0.0000F, -2.8500F).to(18.1500F, 2.0000F, -2.8500F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, -45.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 5.0000F, 1.0000F, 7.0000F).texture(IcariaTextureSlots.STEM).tintindex(0))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 5.0000F, 1.0000F, 7.0000F).texture(IcariaTextureSlots.STEM).tintindex(0)))
			.element(elementBuilder -> elementBuilder.from(13.4000F, 0.0000F, -0.5000F).to(13.4000F, 2.0000F, 0.5000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, -45.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 5.0000F, 1.0000F, 7.0000F).texture(IcariaTextureSlots.STEM).tintindex(0))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 5.0000F, 1.0000F, 7.0000F).texture(IcariaTextureSlots.STEM).tintindex(0)))
			.element(elementBuilder -> elementBuilder.from(12.9000F, 0.0000F, 0.0000F).to(13.9000F, 2.0000F, 0.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, -45.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 5.0000F, 1.0000F, 7.0000F).texture(IcariaTextureSlots.STEM).tintindex(0))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 5.0000F, 1.0000F, 7.0000F).texture(IcariaTextureSlots.STEM).tintindex(0)))
			.build();
	}

	public static ExtendedModelTemplate template4() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaKeys.MC, "block")).ambientOcclusion(false)
			.element(elementBuilder -> elementBuilder.from(8.0000F, 2.0000F, 0.0000F).to(16.0000F, 2.0000F, 8.0000F)
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(8.0000F, 0.0000F, 16.0000F, 8.0000F).texture(IcariaTextureSlots.FLOWERS))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(8.0000F, 8.0000F, 16.0000F, 0.0000F).texture(IcariaTextureSlots.FLOWERS)))
			.element(elementBuilder -> elementBuilder.from(12.4000F, 0.0000F, -7.7000F).to(12.4000F, 2.0000F, -6.7000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, -45.0000F, 0.0000F).origin(-1.0000F, 0.0000F, -3.0000F))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 5.0000F, 1.0000F, 7.0000F).texture(IcariaTextureSlots.STEM).tintindex(0))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 5.0000F, 1.0000F, 7.0000F).texture(IcariaTextureSlots.STEM).tintindex(0)))
			.element(elementBuilder -> elementBuilder.from(11.9000F, 0.0000F, -7.2000F).to(12.9000F, 2.0000F, -7.2000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, -45.0000F, 0.0000F).origin(-1.0000F, 0.0000F, -3.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 5.0000F, 1.0000F, 7.0000F).texture(IcariaTextureSlots.STEM).tintindex(0))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 5.0000F, 1.0000F, 7.0000F).texture(IcariaTextureSlots.STEM).tintindex(0)))
			.build();
	}
}

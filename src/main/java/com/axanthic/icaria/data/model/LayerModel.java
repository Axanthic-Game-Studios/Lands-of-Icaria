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

public class LayerModel {

	public static ExtendedModelTemplate template1() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaKeys.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(0.0000F, 0.0000F, 0.0000F).to(16.0000F, 2.0000F, 16.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 14.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 14.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 14.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 14.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE)))
			.build();
	}

	public static ExtendedModelTemplate template2() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaKeys.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(0.0000F, 0.0000F, 0.0000F).to(16.0000F, 4.0000F, 16.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 12.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 12.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 12.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 12.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE)))
			.build();
	}

	public static ExtendedModelTemplate template3() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaKeys.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(0.0000F, 0.0000F, 0.0000F).to(16.0000F, 6.0000F, 16.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 10.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 10.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 10.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 10.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE)))
			.build();
	}

	public static ExtendedModelTemplate template4() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaKeys.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(0.0000F, 0.0000F, 0.0000F).to(16.0000F, 8.0000F, 16.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 8.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 8.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 8.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 8.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE)))
			.build();
	}

	public static ExtendedModelTemplate template5() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaKeys.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(0.0000F, 0.0000F, 0.0000F).to(16.0000F, 10.0000F, 16.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 6.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 6.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 6.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 6.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE)))
			.build();
	}

	public static ExtendedModelTemplate template6() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaKeys.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(0.0000F, 0.0000F, 0.0000F).to(16.0000F, 12.0000F, 16.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 4.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 4.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 4.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 4.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE)))
			.build();
	}

	public static ExtendedModelTemplate template7() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaKeys.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(0.0000F, 0.0000F, 0.0000F).to(16.0000F, 14.0000F, 16.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 2.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 2.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 2.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 2.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE)))
			.build();
	}

	public static ExtendedModelTemplate template8() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaKeys.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(0.0000F, 0.0000F, 0.0000F).to(16.0000F, 16.0000F, 16.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 16.0000F, 16.0000F).texture(IcariaTextureSlots.TEXTURE)))
			.build();
	}
}

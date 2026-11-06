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

public class SmithingHeftModel {

	public static ExtendedModelTemplate template() {
		return ExtendedModelTemplateBuilder.builder().parent(IcariaModelProvider.blockFile(IcariaIds.MC, "block"))
			.element(elementBuilder -> elementBuilder.from(6.0000F, 11.5750F, 0.6000F).to(10.0000F, 14.5750F, 3.6000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(45.0000F, 27.5000F, 90.0000F).origin(8.0000F, 13.5750F, 2.6000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(0.0000F, 1.0000F, 4.0000F, 4.0000F).texture(IcariaTextureSlots.SMOOTH_MOLIBOS_BLOCK))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(1.0000F, 1.0000F, 4.0000F, 4.0000F).texture(IcariaTextureSlots.SMOOTH_MOLIBOS_BLOCK))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(0.0000F, 1.0000F, 4.0000F, 4.0000F).texture(IcariaTextureSlots.SMOOTH_MOLIBOS_BLOCK)))
			.element(elementBuilder -> elementBuilder.from(5.5000F, 14.0000F, 13.0000F).to(10.5000F, 16.0000F, 16.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(0.0000F, 0.0000F, 3.0000F, 2.0000F).texture(IcariaTextureSlots.SMOOTH_MOLIBOS_BLOCK))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(5.0000F, 0.0000F, 10.0000F, 2.0000F).texture(IcariaTextureSlots.SMOOTH_MOLIBOS_BLOCK))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(13.0000F, 0.0000F, 16.0000F, 2.0000F).texture(IcariaTextureSlots.SMOOTH_MOLIBOS_BLOCK))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(5.0000F, 13.0000F, 10.0000F, 16.0000F).texture(IcariaTextureSlots.SMOOTH_MOLIBOS_BLOCK))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(6.0000F, 0.0000F, 11.0000F, 3.0000F).texture(IcariaTextureSlots.SMOOTH_MOLIBOS_BLOCK)))
			.element(elementBuilder -> elementBuilder.from(5.0000F, 12.0000F, 10.0000F).to(11.0000F, 16.0000F, 13.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(3.0000F, 0.0000F, 6.0000F, 4.0000F).texture(IcariaTextureSlots.SMOOTH_MOLIBOS_BLOCK))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(5.0000F, 0.0000F, 11.0000F, 4.0000F).texture(IcariaTextureSlots.SMOOTH_MOLIBOS_BLOCK))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(10.0000F, 0.0000F, 13.0000F, 4.0000F).texture(IcariaTextureSlots.SMOOTH_MOLIBOS_BLOCK))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(5.0000F, 10.0000F, 11.0000F, 13.0000F).texture(IcariaTextureSlots.SMOOTH_MOLIBOS_BLOCK))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(5.0000F, 3.0000F, 11.0000F, 6.0000F).texture(IcariaTextureSlots.SMOOTH_MOLIBOS_BLOCK)))
			.element(elementBuilder -> elementBuilder.from(4.0000F, 10.0000F, 1.0000F).to(12.0000F, 16.0000F, 10.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(4.0000F, 0.0000F, 12.0000F, 6.0000F).texture(IcariaTextureSlots.SMOOTH_MOLIBOS_BLOCK))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(6.0000F, 0.0000F, 15.0000F, 6.0000F).texture(IcariaTextureSlots.SMOOTH_MOLIBOS_BLOCK))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(4.0000F, 0.0000F, 12.0000F, 6.0000F).texture(IcariaTextureSlots.SMOOTH_MOLIBOS_BLOCK))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(2.0000F, 0.0000F, 11.0000F, 6.0000F).texture(IcariaTextureSlots.SMOOTH_MOLIBOS_BLOCK))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(4.0000F, 1.0000F, 12.0000F, 10.0000F).texture(IcariaTextureSlots.SMOOTH_MOLIBOS_BLOCK))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(4.0000F, 6.0000F, 12.0000F, 15.0000F).texture(IcariaTextureSlots.SMOOTH_MOLIBOS_BLOCK)))
			.element(elementBuilder -> elementBuilder.from(6.5000F, 8.0000F, 5.0000F).to(9.5000F, 10.0000F, 10.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(6.0000F, 6.0000F, 9.0000F, 8.0000F).texture(IcariaTextureSlots.SMOOTH_MOLIBOS_BLOCK))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(5.0000F, 6.0000F, 10.0000F, 8.0000F).texture(IcariaTextureSlots.SMOOTH_MOLIBOS_BLOCK))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(6.0000F, 6.0000F, 9.0000F, 8.0000F).texture(IcariaTextureSlots.SMOOTH_MOLIBOS_BLOCK))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(6.0000F, 6.0000F, 11.0000F, 8.0000F).texture(IcariaTextureSlots.SMOOTH_MOLIBOS_BLOCK)))
			.element(elementBuilder -> elementBuilder.from(6.5000F, 6.0000F, 5.0000F).to(9.5000F, 8.0000F, 11.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(6.0000F, 8.0000F, 9.0000F, 10.0000F).texture(IcariaTextureSlots.SMOOTH_MOLIBOS_BLOCK))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(4.0000F, 8.0000F, 10.0000F, 10.0000F).texture(IcariaTextureSlots.SMOOTH_MOLIBOS_BLOCK))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(6.0000F, 8.0000F, 9.0000F, 10.0000F).texture(IcariaTextureSlots.SMOOTH_MOLIBOS_BLOCK))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(6.0000F, 8.0000F, 12.0000F, 10.0000F).texture(IcariaTextureSlots.SMOOTH_MOLIBOS_BLOCK))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(6.0000F, 5.0000F, 9.0000F, 11.0000F).texture(IcariaTextureSlots.SMOOTH_MOLIBOS_BLOCK)))
			.element(elementBuilder -> elementBuilder.from(6.0000F, 3.0000F, 4.0000F).to(10.0000F, 6.0000F, 11.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(6.0000F, 10.0000F, 10.0000F, 13.0000F).texture(IcariaTextureSlots.SMOOTH_MOLIBOS_BLOCK))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(5.0000F, 10.0000F, 12.0000F, 13.0000F).texture(IcariaTextureSlots.SMOOTH_MOLIBOS_BLOCK))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(6.0000F, 10.0000F, 10.0000F, 13.0000F).texture(IcariaTextureSlots.SMOOTH_MOLIBOS_BLOCK))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(4.0000F, 10.0000F, 11.0000F, 13.0000F).texture(IcariaTextureSlots.SMOOTH_MOLIBOS_BLOCK))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(6.0000F, 4.0000F, 10.0000F, 11.0000F).texture(IcariaTextureSlots.SMOOTH_MOLIBOS_BLOCK)))
			.element(elementBuilder -> elementBuilder.from(5.0000F, 0.0000F, 3.0000F).to(11.0000F, 3.0000F, 12.0000F)
				.rotation(rotationBuilder -> rotationBuilder.eulerXYZ(0.0000F, 0.0000F, 0.0000F).origin(0.0000F, 0.0000F, 0.0000F))
				.face(Direction.NORTH, faceBuilder -> faceBuilder.uvs(5.0000F, 13.0000F, 11.0000F, 16.0000F).texture(IcariaTextureSlots.SMOOTH_MOLIBOS_BLOCK))
				.face(Direction.EAST, faceBuilder -> faceBuilder.uvs(3.0000F, 13.0000F, 12.0000F, 16.0000F).texture(IcariaTextureSlots.SMOOTH_MOLIBOS_BLOCK))
				.face(Direction.SOUTH, faceBuilder -> faceBuilder.uvs(5.0000F, 13.0000F, 11.0000F, 16.0000F).texture(IcariaTextureSlots.SMOOTH_MOLIBOS_BLOCK))
				.face(Direction.WEST, faceBuilder -> faceBuilder.uvs(4.0000F, 13.0000F, 13.0000F, 16.0000F).texture(IcariaTextureSlots.SMOOTH_MOLIBOS_BLOCK))
				.face(Direction.UP, faceBuilder -> faceBuilder.uvs(5.0000F, 4.0000F, 11.0000F, 13.0000F).texture(IcariaTextureSlots.SMOOTH_MOLIBOS_BLOCK))
				.face(Direction.DOWN, faceBuilder -> faceBuilder.uvs(5.0000F, 3.0000F, 11.0000F, 12.0000F).texture(IcariaTextureSlots.SMOOTH_MOLIBOS_BLOCK)))
			.build();
	}
}

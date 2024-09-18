package com.axanthic.icaria.data.model;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;

import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.ModelBuilder;
import net.neoforged.neoforge.client.model.generators.ModelFile;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class TroughModel {

	public static void template(BlockModelBuilder pBuilder, ModelFile.UncheckedModelFile pFile) {
		pBuilder
			.parent(pFile)
		.element().from(1.0F, 4.0F, 8.0F).to(15.0F, 5.0F, 9.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(1.0F, 11.0F, 15.0F, 12.0F).texture("#anvil").end()
			.face(Direction.SOUTH).uvs(1.0F, 11.0F, 15.0F, 12.0F).texture("#anvil").end()
			.face(Direction.UP).uvs(1.0F, 8.0F, 15.0F, 9.0F).texture("#anvil").end()
			.end()
		.element().from(15.0F, 4.0F, 8.0F).to(16.0F, 5.0F, 16.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 11.0F, 1.0F, 12.0F).texture("#anvil").end()
			.face(Direction.EAST).uvs(0.0F, 11.0F, 8.0F, 12.0F).texture("#anvil").end()
			.face(Direction.SOUTH).uvs(15.0F, 11.0F, 16.0F, 12.0F).texture("#anvil").end()
			.face(Direction.WEST).uvs(8.0F, 11.0F, 16.0F, 12.0F).texture("#anvil").end()
			.face(Direction.UP).uvs(15.0F, 8.0F, 16.0F, 16.0F).texture("#anvil").end()
			.end()
		.element().from(1.0F, 4.0F, 15.0F).to(15.0F, 5.0F, 16.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(1.0F, 11.0F, 15.0F, 12.0F).texture("#anvil").end()
			.face(Direction.SOUTH).uvs(1.0F, 11.0F, 15.0F, 12.0F).texture("#anvil").end()
			.face(Direction.UP).uvs(1.0F, 15.0F, 15.0F, 16.0F).texture("#anvil").end()
			.end()
		.element().from(0.0F, 4.0F, 8.0F).to(1.0F, 5.0F, 16.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(15.0F, 11.0F, 16.0F, 12.0F).texture("#anvil").end()
			.face(Direction.EAST).uvs(0.0F, 11.0F, 8.0F, 12.0F).texture("#anvil").end()
			.face(Direction.SOUTH).uvs(0.0F, 11.0F, 1.0F, 12.0F).texture("#anvil").end()
			.face(Direction.WEST).uvs(8.0F, 11.0F, 16.0F, 12.0F).texture("#anvil").end()
			.face(Direction.UP).uvs(0.0F, 8.0F, 1.0F, 16.0F).texture("#anvil").end()
			.end()
		.element().from(1.0F, 1.0F, 8.0F).to(15.0F, 4.0F, 9.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(1.0F, 12.0F, 15.0F, 15.0F).texture("#planks").end()
			.face(Direction.SOUTH).uvs(1.0F, 12.0F, 15.0F, 15.0F).texture("#planks").end()
			.end()
		.element().from(15.0F, 1.0F, 8.0F).to(16.0F, 4.0F, 16.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 12.0F, 1.0F, 15.0F).texture("#planks").end()
			.face(Direction.EAST).uvs(0.0F, 12.0F, 8.0F, 15.0F).texture("#planks").end()
			.face(Direction.SOUTH).uvs(15.0F, 12.0F, 16.0F, 15.0F).texture("#planks").end()
			.face(Direction.WEST).uvs(8.0F, 12.0F, 16.0F, 15.0F).texture("#planks").end()
			.end()
		.element().from(1.0F, 1.0F, 15.0F).to(15.0F, 4.0F, 16.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(1.0F, 12.0F, 15.0F, 15.0F).texture("#planks").end()
			.face(Direction.SOUTH).uvs(1.0F, 12.0F, 15.0F, 15.0F).texture("#planks").end()
			.end()
		.element().from(0.0F, 1.0F, 8.0F).to(1.0F, 4.0F, 16.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(15.0F, 12.0F, 16.0F, 15.0F).texture("#planks").end()
			.face(Direction.EAST).uvs(0.0F, 12.0F, 8.0F, 15.0F).texture("#planks").end()
			.face(Direction.SOUTH).uvs(0.0F, 12.0F, 1.0F, 15.0F).texture("#planks").end()
			.face(Direction.WEST).uvs(8.0F, 12.0F, 16.0F, 15.0F).texture("#planks").end()
			.end()
		.element().from(0.0F, 0.0F, 8.0F).to(16.0F, 1.0F, 16.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 15.0F, 16.0F, 16.0F).texture("#log").end()
			.face(Direction.EAST).uvs(0.0F, 15.0F, 8.0F, 16.0F).texture("#log").end()
			.face(Direction.SOUTH).uvs(0.0F, 15.0F, 16.0F, 16.0F).texture("#log").end()
			.face(Direction.WEST).uvs(8.0F, 15.0F, 16.0F, 16.0F).texture("#log").end()
			.face(Direction.UP).uvs(0.0F, 8.0F, 16.0F, 16.0F).texture("#planks").end()
			.face(Direction.DOWN).uvs(0.0F, 8.0F, 16.0F, 16.0F).rotation(ModelBuilder.FaceRotation.UPSIDE_DOWN).texture("#log").end()
			.end();
	}
}

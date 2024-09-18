package com.axanthic.icaria.data.model;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;

import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.ModelBuilder;
import net.neoforged.neoforge.client.model.generators.ModelFile;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class HorizontalBarsModel {

	public static void template(BlockModelBuilder pBuilder, ModelFile.UncheckedModelFile pFile) {
		pBuilder
			.parent(pFile)
		.element().from(0.0F, 7.0F, 0.0F).to(0.0F, 9.0F, 16.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.EAST).uvs(7.0F, 0.0F, 9.0F, 16.0F).rotation(ModelBuilder.FaceRotation.CLOCKWISE_90).texture("#texture").cullface(Direction.WEST).end()
			.face(Direction.WEST).uvs(7.0F, 0.0F, 9.0F, 16.0F).rotation(ModelBuilder.FaceRotation.CLOCKWISE_90).texture("#texture").cullface(Direction.WEST).end()
			.end()
		.element().from(16.0F, 7.0F, 0.0F).to(16.0F, 9.0F, 16.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.EAST).uvs(7.0F, 0.0F, 9.0F, 16.0F).rotation(ModelBuilder.FaceRotation.CLOCKWISE_90).texture("#texture").cullface(Direction.EAST).end()
			.face(Direction.WEST).uvs(7.0F, 0.0F, 9.0F, 16.0F).rotation(ModelBuilder.FaceRotation.CLOCKWISE_90).texture("#texture").cullface(Direction.EAST).end()
			.end()
		.element().from(0.0F, 7.0F, 0.0F).to(16.0F, 9.0F, 0.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(7.0F, 0.0F, 9.0F, 16.0F).rotation(ModelBuilder.FaceRotation.CLOCKWISE_90).texture("#texture").cullface(Direction.NORTH).end()
			.face(Direction.SOUTH).uvs(7.0F, 0.0F, 9.0F, 16.0F).rotation(ModelBuilder.FaceRotation.CLOCKWISE_90).texture("#texture").cullface(Direction.NORTH).end()
			.end()
		.element().from(0.0F, 7.0F, 16.0F).to(16.0F, 9.0F, 16.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(7.0F, 0.0F, 9.0F, 16.0F).rotation(ModelBuilder.FaceRotation.CLOCKWISE_90).texture("#texture").cullface(Direction.SOUTH).end()
			.face(Direction.SOUTH).uvs(7.0F, 0.0F, 9.0F, 16.0F).rotation(ModelBuilder.FaceRotation.CLOCKWISE_90).texture("#texture").cullface(Direction.SOUTH).end()
			.end()
		.element().from(0.0F, 8.0F, 0.0F).to(16.0F, 8.0F, 16.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 16.0F, 16.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 16.0F, 16.0F).texture("#texture").end()
			.end();
	}
}

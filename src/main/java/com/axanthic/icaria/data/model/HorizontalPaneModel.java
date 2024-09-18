package com.axanthic.icaria.data.model;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;

import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.ModelBuilder;
import net.neoforged.neoforge.client.model.generators.ModelFile;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class HorizontalPaneModel {

	public static void template(BlockModelBuilder pBuilder, ModelFile.UncheckedModelFile pFile) {
		pBuilder
			.parent(pFile)
		.element().from(0.0F, 7.0F, 0.0F).to(16.0F, 9.0F, 16.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(7.0F, 0.0F, 9.0F, 16.0F).rotation(ModelBuilder.FaceRotation.CLOCKWISE_90).texture("#edge").cullface(Direction.NORTH).end()
			.face(Direction.EAST).uvs(7.0F, 0.0F, 9.0F, 16.0F).rotation(ModelBuilder.FaceRotation.CLOCKWISE_90).texture("#edge").cullface(Direction.EAST).end()
			.face(Direction.SOUTH).uvs(7.0F, 0.0F, 9.0F, 16.0F).rotation(ModelBuilder.FaceRotation.CLOCKWISE_90).texture("#edge").cullface(Direction.SOUTH).end()
			.face(Direction.WEST).uvs(7.0F, 0.0F, 9.0F, 16.0F).rotation(ModelBuilder.FaceRotation.CLOCKWISE_90).texture("#edge").cullface(Direction.WEST).end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 16.0F, 16.0F).texture("#pane").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 16.0F, 16.0F).texture("#pane").end()
			.end();
	}
}

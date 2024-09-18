package com.axanthic.icaria.data.model;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;

import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.ModelFile;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class PaneInventoryModel {

	public static void template(BlockModelBuilder pBuilder, ModelFile.UncheckedModelFile pFile) {
		pBuilder
			.parent(pFile)
		.element().from(7.0F, 0.0F, 0.0F).to(9.0F, 16.0F, 16.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(7.0F, 0.0F, 9.0F, 16.0F).texture("#edge").end()
			.face(Direction.EAST).uvs(0.0F, 0.0F, 16.0F, 16.0F).texture("#pane").end()
			.face(Direction.SOUTH).uvs(7.0F, 0.0F, 9.0F, 16.0F).texture("#edge").end()
			.face(Direction.WEST).uvs(0.0F, 0.0F, 16.0F, 16.0F).texture("#pane").end()
			.face(Direction.UP).uvs(9.0F, 16.0F, 7.0F, 0.0F).texture("#edge").end()
			.face(Direction.DOWN).uvs(9.0F, 16.0F, 7.0F, 0.0F).texture("#edge").end()
			.end();
	}
}

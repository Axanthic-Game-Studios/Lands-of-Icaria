package com.axanthic.icaria.data.model;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;

import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.ModelFile;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class StrawberryBushModel {

	public static void template(BlockModelBuilder pBuilder, ModelFile.UncheckedModelFile pFile) {
		pBuilder
			.parent(pFile)
		.element().from(8.0F, 0.0F, 0.0F).to(8.0F, 8.0F, 16.0F).rotation().angle(45.0F).axis(Direction.Axis.Y).origin(8.0F, 9.0F, 8.0F).end()
			.face(Direction.EAST).uvs(0.0F, 8.0F, 16.0F, 16.0F).texture("#bush").end()
			.face(Direction.WEST).uvs(0.0F, 8.0F, 16.0F, 16.0F).texture("#bush").end()
			.end()
		.element().from(8.0F, 0.0F, 0.0F).to(8.0F, 8.0F, 16.0F).rotation().angle(-45.0F).axis(Direction.Axis.Y).origin(8.0F, 9.0F, 8.0F).end()
			.face(Direction.EAST).uvs(0.0F, 8.0F, 16.0F, 16.0F).texture("#bush").end()
			.face(Direction.WEST).uvs(0.0F, 8.0F, 16.0F, 16.0F).texture("#bush").end()
			.end()
		.element().from(0.0F, 2.0F, 0.0F).to(16.0F, 2.0F, 16.0F).rotation().angle(45.0F).axis(Direction.Axis.Y).origin(8.0F, 9.0F, 8.0F).end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 16.0F, 16.0F).texture("#bush_horizontal").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 16.0F, 16.0F).texture("#bush_horizontal").end()
			.end();
	}
}

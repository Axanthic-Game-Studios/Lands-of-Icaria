package com.axanthic.icaria.data.model;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;

import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.ModelFile;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class BarsInventoryModel {

	public static void template(BlockModelBuilder pBuilder, ModelFile.UncheckedModelFile pFile) {
		pBuilder
			.parent(pFile)
		.element().from(8.0F, 0.0F, 0.0F).to(8.0F, 16.0F, 16.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(1.0F, 0.0F, 0.0F).end()
			.face(Direction.EAST).uvs(0.0F, 0.0F, 16.0F, 16.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(0.0F, 0.0F, 16.0F, 16.0F).texture("#texture").end()
			.end()
		.element().from(7.0F, 0.0F, 0.0F).to(9.0F, 0.0F, 16.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(7.0F, 0.0F, 0.0F).end()
			.face(Direction.UP).uvs(9.0F, 16.0F, 7.0F, 0.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(7.0F, 0.0F, 9.0F, 16.0F).texture("#texture").end()
			.end()
		.element().from(7.0F, 16.0F, 0.0F).to(9.0F, 16.0F, 16.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(7.0F, 16.0F, 0.0F).end()
			.face(Direction.UP).uvs(9.0F, 16.0F, 7.0F, 0.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(7.0F, 0.0F, 9.0F, 16.0F).texture("#texture").end()
			.end()
		.element().from(7.0F, 0.0F, 0.0F).to(9.0F, 16.0F, 0.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(7.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(7.0F, 0.0F, 9.0F, 16.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(9.0F, 0.0F, 7.0F, 16.0F).texture("#texture").end()
			.end()
		.element().from(7.0F, 0.0F, 16.0F).to(9.0F, 16.0F, 16.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(7.0F, 0.0F, 16.0F).end()
			.face(Direction.NORTH).uvs(9.0F, 0.0F, 7.0F, 16.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(7.0F, -1.0F, 9.0F, 16.0F).texture("#texture").end()
			.end();
	}
}

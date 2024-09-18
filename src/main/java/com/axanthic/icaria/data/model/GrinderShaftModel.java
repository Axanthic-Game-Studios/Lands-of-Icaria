package com.axanthic.icaria.data.model;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;

import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.ModelFile;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GrinderShaftModel {

	public static void template(BlockModelBuilder pBuilder, ModelFile.UncheckedModelFile pFile) {
		pBuilder
			.parent(pFile)
		.element().from(7.0F, 5.0F, 7.0F).to(9.0F, 9.0F, 9.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 10.0F, 2.0F, 14.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(2.0F, 10.0F, 4.0F, 14.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(4.0F, 10.0F, 6.0F, 14.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(6.0F, 10.0F, 8.0F, 14.0F).texture("#texture").end()
			.face(Direction.UP).uvs(0.0F, 8.0F, 2.0F, 10.0F).texture("#texture").end()
			.end();
	}
}

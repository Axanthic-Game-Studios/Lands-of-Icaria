package com.axanthic.icaria.data.model;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;

import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.ModelFile;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class OverlayTextureCrossModel {

	public static void template(BlockModelBuilder pBuilder, ModelFile.UncheckedModelFile pFile) {
		pBuilder
			.parent(pFile)
		.element().from(0.8F, 0.0F, 8.0F).to(15.2F, 16.0F, 8.0F).shade(false).rotation().angle(45.0F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 8.0F).rescale(true).end()
			.face(Direction.NORTH).uvs(0.0F, 0.0F, 16.0F, 16.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(0.0F, 0.0F, 16.0F, 16.0F).texture("#texture").end()
			.end()
		.element().from(8.0F, 0.0F, 0.8F).to(8.0F, 16.0F, 15.2F).shade(false).rotation().angle(45.0F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 8.0F).rescale(true).end()
			.face(Direction.EAST).uvs(0.0F, 0.0F, 16.0F, 16.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(0.0F, 0.0F, 16.0F, 16.0F).texture("#texture").end()
			.end()
		.element().from(0.8F, 0.0F, 8.0F).to(15.2F, 16.0F, 8.0F).shade(false).rotation().angle(45.0F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 8.0F).rescale(true).end()
			.face(Direction.NORTH).uvs(0.0F, 0.0F, 16.0F, 16.0F).texture("#overlay").tintindex(0).end()
			.face(Direction.SOUTH).uvs(0.0F, 0.0F, 16.0F, 16.0F).texture("#overlay").tintindex(0).end()
			.end()
		.element().from(8.0F, 0.0F, 0.8F).to(8.0F, 16.0F, 15.2F).shade(false).rotation().angle(45.0F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 8.0F).rescale(true).end()
			.face(Direction.EAST).uvs(0.0F, 0.0F, 16.0F, 16.0F).texture("#overlay").tintindex(0).end()
			.face(Direction.WEST).uvs(0.0F, 0.0F, 16.0F, 16.0F).texture("#overlay").tintindex(0).end()
			.end();
	}
}

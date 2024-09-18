package com.axanthic.icaria.data.model;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;

import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.ModelFile;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class OverlayTextureBlockModel {

	public static void template(BlockModelBuilder pBuilder, ModelFile.UncheckedModelFile pFile) {
		pBuilder
			.parent(pFile)
		.element().from(0.0F, 0.0F, 0.0F).to(16.0F, 16.0F, 16.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 0.0F, 16.0F, 16.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(0.0F, 0.0F, 16.0F, 16.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(0.0F, 0.0F, 16.0F, 16.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(0.0F, 0.0F, 16.0F, 16.0F).texture("#texture").end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 16.0F, 16.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 16.0F, 16.0F).texture("#texture").end()
			.end()
		.element().from(0.0F, 0.0F, 0.0F).to(16.0F, 16.0F, 16.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 0.0F, 16.0F, 16.0F).texture("#overlay").emissivity(15, 15).end()
			.face(Direction.EAST).uvs(0.0F, 0.0F, 16.0F, 16.0F).texture("#overlay").emissivity(15, 15).end()
			.face(Direction.SOUTH).uvs(0.0F, 0.0F, 16.0F, 16.0F).texture("#overlay").emissivity(15, 15).end()
			.face(Direction.WEST).uvs(0.0F, 0.0F, 16.0F, 16.0F).texture("#overlay").emissivity(15, 15).end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 16.0F, 16.0F).texture("#overlay").emissivity(15, 15).end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 16.0F, 16.0F).texture("#overlay").emissivity(15, 15).end()
			.end();
	}
}

package com.axanthic.icaria.data.model;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;

import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.ModelFile;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class OverlayTextureFlowerPotCrossModel {

	public static void template(BlockModelBuilder pBuilder, ModelFile.UncheckedModelFile pFile) {
		pBuilder
			.parent(pFile)
		.element().from(5.0F, 0.0F, 5.0F).to(6.0F, 6.0F, 11.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(10.0F, 10.0F, 11.0F, 16.0F).texture("#pot").end()
			.face(Direction.EAST).uvs(5.0F, 10.0F, 11.0F, 16.0F).texture("#pot").end()
			.face(Direction.SOUTH).uvs(5.0F, 10.0F, 6.0F, 16.0F).texture("#pot").end()
			.face(Direction.WEST).uvs(5.0F, 10.0F, 11.0F, 16.0F).texture("#pot").end()
			.face(Direction.UP).uvs(5.0F, 5.0F, 6.0F, 11.0F).texture("#pot").end()
			.face(Direction.DOWN).uvs(5.0F, 5.0F, 6.0F, 11.0F).texture("#pot").cullface(Direction.DOWN).end()
			.end()
		.element().from(10.0F, 0.0F, 5.0F).to(11.0F, 6.0F, 11.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(5.0F, 10.0F, 6.0F, 16.0F).texture("#pot").end()
			.face(Direction.EAST).uvs(5.0F, 10.0F, 11.0F, 16.0F).texture("#pot").end()
			.face(Direction.SOUTH).uvs(10.0F, 10.0F, 11.0F, 16.0F).texture("#pot").end()
			.face(Direction.WEST).uvs(5.0F, 10.0F, 11.0F, 16.0F).texture("#pot").end()
			.face(Direction.UP).uvs(10.0F, 5.0F, 11.0F, 11.0F).texture("#pot").end()
			.face(Direction.DOWN).uvs(10.0F, 5.0F, 11.0F, 11.0F).texture("#pot").cullface(Direction.DOWN).end()
			.end()
		.element().from(6.0F, 0.0F, 5.0F).to(10.0F, 6.0F, 6.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(6.0F, 10.0F, 10.0F, 16.0F).texture("#pot").end()
			.face(Direction.SOUTH).uvs(6.0F, 10.0F, 10.0F, 16.0F).texture("#pot").end()
			.face(Direction.UP).uvs(6.0F, 5.0F, 10.0F, 6.0F).texture("#pot").end()
			.face(Direction.DOWN).uvs(6.0F, 10.0F, 10.0F, 11.0F).texture("#pot").cullface(Direction.DOWN).end()
			.end()
		.element().from(6.0F, 0.0F, 10.0F).to(10.0F, 6.0F, 11.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(6.0F, 10.0F, 10.0F, 16.0F).texture("#pot").end()
			.face(Direction.SOUTH).uvs(6.0F, 10.0F, 10.0F, 16.0F).texture("#pot").end()
			.face(Direction.UP).uvs(6.0F, 10.0F, 10.0F, 11.0F).texture("#pot").end()
			.face(Direction.DOWN).uvs(6.0F, 5.0F, 10.0F, 6.0F).texture("#pot").cullface(Direction.DOWN).end()
			.end()
		.element().from(6.0F, 0.0F, 6.0F).to(10.0F, 4.0F, 10.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.UP).uvs(6.0F, 6.0F, 10.0F, 10.0F).texture("#dirt").end()
			.face(Direction.DOWN).uvs(6.0F, 12.0F, 10.0F, 16.0F).texture("#pot").cullface(Direction.DOWN).end()
			.end()
		.element().from(2.6F, 4.0F, 8.0F).to(13.4F, 16.0F, 8.0F).rotation().angle(45.0F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 8.0F).rescale(true).end()
			.face(Direction.NORTH).uvs(0.0F, 0.0F, 16.0F, 16.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(0.0F, 0.0F, 16.0F, 16.0F).texture("#texture").end()
			.end()
		.element().from(8.0F, 4.0F, 2.6F).to(8.0F, 16.0F, 13.4F).rotation().angle(45.0F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 8.0F).rescale(true).end()
			.face(Direction.EAST).uvs(0.0F, 0.0F, 16.0F, 16.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(0.0F, 0.0F, 16.0F, 16.0F).texture("#texture").end()
			.end()
		.element().from(2.6F, 4.0F, 8.0F).to(13.4F, 16.0F, 8.0F).rotation().angle(45.0F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 8.0F).rescale(true).end()
			.face(Direction.NORTH).uvs(0.0F, 0.0F, 16.0F, 16.0F).texture("#overlay").tintindex(0).end()
			.face(Direction.SOUTH).uvs(0.0F, 0.0F, 16.0F, 16.0F).texture("#overlay").tintindex(0).end()
			.end()
		.element().from(8.0F, 4.0F, 2.6F).to(8.0F, 16.0F, 13.4F).rotation().angle(45.0F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 8.0F).rescale(true).end()
			.face(Direction.EAST).uvs(0.0F, 0.0F, 16.0F, 16.0F).texture("#overlay").tintindex(0).end()
			.face(Direction.WEST).uvs(0.0F, 0.0F, 16.0F, 16.0F).texture("#overlay").tintindex(0).end()
			.end();
	}
}

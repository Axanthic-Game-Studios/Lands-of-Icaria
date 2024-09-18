package com.axanthic.icaria.data.model;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;

import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.ModelFile;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class PottedLargeBrownGroundShroomsModel {

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
		.element().from(6.5F, 9.0F, 6.5F).to(11.5F, 10.0F, 11.5F).rotation().angle(22.5F).axis(Direction.Axis.Y).origin(9.0F, 9.5F, 9.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 0.0F, 5.0F, 1.0F).texture("#shroom").end()
			.face(Direction.EAST).uvs(0.0F, 0.0F, 5.0F, 1.0F).texture("#shroom").end()
			.face(Direction.SOUTH).uvs(0.0F, 0.0F, 5.0F, 1.0F).texture("#shroom").end()
			.face(Direction.WEST).uvs(0.0F, 0.0F, 5.0F, 1.0F).texture("#shroom").end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 5.0F, 5.0F).texture("#shroom").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 5.0F, 5.0F).texture("#shroom").end()
			.end()
		.element().from(8.5F, 4.0F, 8.5F).to(9.5F, 9.0F, 9.5F).rotation().angle(22.5F).axis(Direction.Axis.Y).origin(9.0F, 6.5F, 9.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 0.0F, 1.0F, 5.0F).texture("#stem").end()
			.face(Direction.EAST).uvs(1.0F, 0.0F, 2.0F, 5.0F).texture("#stem").end()
			.face(Direction.SOUTH).uvs(2.0F, 0.0F, 3.0F, 5.0F).texture("#stem").end()
			.face(Direction.WEST).uvs(3.0F, 0.0F, 4.0F, 5.0F).texture("#stem").end()
			.end()
		.element().from(5.5F, 7.0F, 5.5F).to(8.5F, 8.0F, 8.5F).rotation().angle(-22.5F).axis(Direction.Axis.Y).origin(7.0F, 6.5F, 7.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 0.0F, 3.0F, 1.0F).texture("#shroom").end()
			.face(Direction.EAST).uvs(0.0F, 0.0F, 3.0F, 1.0F).texture("#shroom").end()
			.face(Direction.SOUTH).uvs(0.0F, 0.0F, 3.0F, 1.0F).texture("#shroom").end()
			.face(Direction.WEST).uvs(0.0F, 0.0F, 3.0F, 1.0F).texture("#shroom").end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 3.0F, 3.0F).texture("#shroom").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 3.0F, 3.0F).texture("#shroom").end()
			.end()
		.element().from(6.5F, 4.0F, 6.5F).to(7.5F, 7.0F, 7.5F).rotation().angle(-22.5F).axis(Direction.Axis.Y).origin(7.0F, 6.5F, 7.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 0.0F, 1.0F, 3.0F).texture("#stem").end()
			.face(Direction.EAST).uvs(1.0F, 0.0F, 2.0F, 3.0F).texture("#stem").end()
			.face(Direction.SOUTH).uvs(2.0F, 0.0F, 3.0F, 3.0F).texture("#stem").end()
			.face(Direction.WEST).uvs(3.0F, 0.0F, 4.0F, 3.0F).texture("#stem").end()
			.end();
	}
}

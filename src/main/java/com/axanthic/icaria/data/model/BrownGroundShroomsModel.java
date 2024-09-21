package com.axanthic.icaria.data.model;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;

import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.ModelFile;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class BrownGroundShroomsModel {

	public static void template0(BlockModelBuilder pBuilder, ModelFile.UncheckedModelFile pFile) {
		pBuilder
			.parent(pFile)
		.element().from(3.0F, 0.0F, 4.0F).to(5.0F, 6.0F, 6.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 0.0F, 2.0F, 6.0F).texture("#stem").end()
			.face(Direction.EAST).uvs(2.0F, 0.0F, 4.0F, 6.0F).texture("#stem").end()
			.face(Direction.SOUTH).uvs(4.0F, 0.0F, 6.0F, 6.0F).texture("#stem").end()
			.face(Direction.WEST).uvs(6.0F, 0.0F, 8.0F, 6.0F).texture("#stem").end()
			.face(Direction.UP).uvs(14.0F, 0.0F, 16.0F, 2.0F).texture("#stem").end()
			.face(Direction.DOWN).uvs(14.0F, 2.0F, 16.0F, 4.0F).texture("#stem").end()
			.end()
		.element().from(11.0F, 0.0F, 6.0F).to(13.0F, 7.0F, 8.0F).rotation().angle(-45.0F).axis(Direction.Axis.Y).origin(12.0F, 8.0F, 7.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 0.0F, 2.0F, 7.0F).texture("#stem").end()
			.face(Direction.EAST).uvs(2.0F, 0.0F, 4.0F, 7.0F).texture("#stem").end()
			.face(Direction.SOUTH).uvs(4.0F, 0.0F, 6.0F, 7.0F).texture("#stem").end()
			.face(Direction.WEST).uvs(6.0F, 0.0F, 8.0F, 7.0F).texture("#stem").end()
			.face(Direction.UP).uvs(14.0F, 0.0F, 16.0F, 2.0F).texture("#stem").end()
			.face(Direction.DOWN).uvs(14.0F, 2.0F, 16.0F, 4.0F).texture("#stem").end()
			.end()
		.element().from(6.0F, 0.0F, 11.0F).to(8.0F, 8.0F, 13.0F).rotation().angle(-22.5F).axis(Direction.Axis.Y).origin(7.0F, 8.0F, 12.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 0.0F, 2.0F, 8.0F).texture("#stem").end()
			.face(Direction.EAST).uvs(2.0F, 0.0F, 4.0F, 8.0F).texture("#stem").end()
			.face(Direction.SOUTH).uvs(4.0F, 0.0F, 6.0F, 8.0F).texture("#stem").end()
			.face(Direction.WEST).uvs(6.0F, 0.0F, 8.0F, 8.0F).texture("#stem").end()
			.face(Direction.UP).uvs(14.0F, 0.0F, 16.0F, 2.0F).texture("#stem").end()
			.face(Direction.DOWN).uvs(14.0F, 2.0F, 16.0F, 4.0F).texture("#stem").end()
			.end()
		.element().from(0.5F, 6.0F, 1.5F).to(7.5F, 7.0F, 8.5F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 0.0F, 7.0F, 1.0F).texture("#shroom").end()
			.face(Direction.EAST).uvs(0.0F, 0.0F, 7.0F, 1.0F).texture("#shroom").end()
			.face(Direction.SOUTH).uvs(0.0F, 0.0F, 7.0F, 1.0F).texture("#shroom").end()
			.face(Direction.WEST).uvs(0.0F, 0.0F, 7.0F, 1.0F).texture("#shroom").end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 7.0F, 7.0F).texture("#shroom").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 7.0F, 7.0F).texture("#shroom").end()
			.end()
		.element().from(8.5F, 7.0F, 3.5F).to(15.5F, 8.0F, 10.5F).rotation().angle(-45.0F).axis(Direction.Axis.Y).origin(12.0F, 8.0F, 7.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 0.0F, 7.0F, 1.0F).texture("#shroom").end()
			.face(Direction.EAST).uvs(0.0F, 0.0F, 7.0F, 1.0F).texture("#shroom").end()
			.face(Direction.SOUTH).uvs(0.0F, 0.0F, 7.0F, 1.0F).texture("#shroom").end()
			.face(Direction.WEST).uvs(0.0F, 0.0F, 7.0F, 1.0F).texture("#shroom").end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 7.0F, 7.0F).texture("#shroom").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 7.0F, 7.0F).texture("#shroom").end()
			.end()
		.element().from(3.5F, 8.0F, 8.5F).to(10.5F, 9.0F, 15.5F).rotation().angle(-22.5F).axis(Direction.Axis.Y).origin(7.0F, 8.0F, 12.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 0.0F, 7.0F, 1.0F).texture("#shroom").end()
			.face(Direction.EAST).uvs(0.0F, 0.0F, 7.0F, 1.0F).texture("#shroom").end()
			.face(Direction.SOUTH).uvs(0.0F, 0.0F, 7.0F, 1.0F).texture("#shroom").end()
			.face(Direction.WEST).uvs(0.0F, 0.0F, 7.0F, 1.0F).texture("#shroom").end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 7.0F, 7.0F).texture("#shroom").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 7.0F, 7.0F).texture("#shroom").end()
			.end();
	}

	public static void template1(BlockModelBuilder pBuilder, ModelFile.UncheckedModelFile pFile) {
		pBuilder
			.parent(pFile)
		.element().from(3.0F, 0.0F, 4.0F).to(5.0F, 5.0F, 6.0F).rotation().angle(-22.5F).axis(Direction.Axis.Y).origin(4.0F, 8.0F, 5.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 0.0F, 2.0F, 5.0F).texture("#stem").end()
			.face(Direction.EAST).uvs(2.0F, 0.0F, 4.0F, 5.0F).texture("#stem").end()
			.face(Direction.SOUTH).uvs(4.0F, 0.0F, 6.0F, 5.0F).texture("#stem").end()
			.face(Direction.WEST).uvs(6.0F, 0.0F, 8.0F, 5.0F).texture("#stem").end()
			.face(Direction.UP).uvs(14.0F, 0.0F, 16.0F, 2.0F).texture("#stem").end()
			.face(Direction.DOWN).uvs(14.0F, 2.0F, 16.0F, 4.0F).texture("#stem").end()
			.end()
		.element().from(11.0F, 0.0F, 6.0F).to(13.0F, 4.0F, 8.0F).rotation().angle(22.5F).axis(Direction.Axis.Y).origin(12.0F, 8.0F, 7.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 0.0F, 2.0F, 4.0F).texture("#stem").end()
			.face(Direction.EAST).uvs(2.0F, 0.0F, 4.0F, 4.0F).texture("#stem").end()
			.face(Direction.SOUTH).uvs(4.0F, 0.0F, 6.0F, 4.0F).texture("#stem").end()
			.face(Direction.WEST).uvs(6.0F, 0.0F, 8.0F, 4.0F).texture("#stem").end()
			.face(Direction.UP).uvs(14.0F, 0.0F, 16.0F, 2.0F).texture("#stem").end()
			.face(Direction.DOWN).uvs(14.0F, 2.0F, 16.0F, 4.0F).texture("#stem").end()
			.end()
		.element().from(6.0F, 0.0F, 11.0F).to(8.0F, 6.0F, 13.0F).rotation().angle(45.0F).axis(Direction.Axis.Y).origin(7.0F, 8.0F, 12.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 0.0F, 2.0F, 6.0F).texture("#stem").end()
			.face(Direction.EAST).uvs(2.0F, 0.0F, 4.0F, 6.0F).texture("#stem").end()
			.face(Direction.SOUTH).uvs(4.0F, 0.0F, 6.0F, 6.0F).texture("#stem").end()
			.face(Direction.WEST).uvs(6.0F, 0.0F, 8.0F, 6.0F).texture("#stem").end()
			.face(Direction.UP).uvs(14.0F, 0.0F, 16.0F, 2.0F).texture("#stem").end()
			.face(Direction.DOWN).uvs(14.0F, 2.0F, 16.0F, 4.0F).texture("#stem").end()
			.end()
		.element().from(0.5F, 5.0F, 1.5F).to(7.5F, 6.0F, 8.5F).rotation().angle(-22.5F).axis(Direction.Axis.Y).origin(4.0F, 8.0F, 5.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 0.0F, 7.0F, 1.0F).texture("#shroom").end()
			.face(Direction.EAST).uvs(0.0F, 0.0F, 7.0F, 1.0F).texture("#shroom").end()
			.face(Direction.SOUTH).uvs(0.0F, 0.0F, 7.0F, 1.0F).texture("#shroom").end()
			.face(Direction.WEST).uvs(0.0F, 0.0F, 7.0F, 1.0F).texture("#shroom").end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 7.0F, 7.0F).texture("#shroom").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 7.0F, 7.0F).texture("#shroom").end()
			.end()
		.element().from(8.5F, 4.0F, 3.5F).to(15.5F, 5.0F, 10.5F).rotation().angle(22.5F).axis(Direction.Axis.Y).origin(12.0F, 8.0F, 7.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 0.0F, 7.0F, 1.0F).texture("#shroom").end()
			.face(Direction.EAST).uvs(0.0F, 0.0F, 7.0F, 1.0F).texture("#shroom").end()
			.face(Direction.SOUTH).uvs(0.0F, 0.0F, 7.0F, 1.0F).texture("#shroom").end()
			.face(Direction.WEST).uvs(0.0F, 0.0F, 7.0F, 1.0F).texture("#shroom").end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 7.0F, 7.0F).texture("#shroom").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 7.0F, 7.0F).texture("#shroom").end()
			.end()
		.element().from(3.5F, 6.0F, 8.5F).to(10.5F, 7.0F, 15.5F).rotation().angle(45.0F).axis(Direction.Axis.Y).origin(7.0F, 8.0F, 12.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 0.0F, 7.0F, 1.0F).texture("#shroom").end()
			.face(Direction.EAST).uvs(0.0F, 0.0F, 7.0F, 1.0F).texture("#shroom").end()
			.face(Direction.SOUTH).uvs(0.0F, 0.0F, 7.0F, 1.0F).texture("#shroom").end()
			.face(Direction.WEST).uvs(0.0F, 0.0F, 7.0F, 1.0F).texture("#shroom").end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 7.0F, 7.0F).texture("#shroom").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 7.0F, 7.0F).texture("#shroom").end()
			.end();
	}

	public static void template2(BlockModelBuilder pBuilder, ModelFile.UncheckedModelFile pFile) {
		pBuilder
			.parent(pFile)
		.element().from(3.0F, 0.0F, 4.0F).to(5.0F, 8.0F, 6.0F).rotation().angle(45.0F).axis(Direction.Axis.Y).origin(4.0F, 8.0F, 5.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 0.0F, 2.0F, 8.0F).texture("#stem").end()
			.face(Direction.EAST).uvs(2.0F, 0.0F, 4.0F, 8.0F).texture("#stem").end()
			.face(Direction.SOUTH).uvs(4.0F, 0.0F, 6.0F, 8.0F).texture("#stem").end()
			.face(Direction.WEST).uvs(6.0F, 0.0F, 8.0F, 8.0F).texture("#stem").end()
			.face(Direction.UP).uvs(14.0F, 0.0F, 16.0F, 2.0F).texture("#stem").end()
			.face(Direction.DOWN).uvs(14.0F, 2.0F, 16.0F, 4.0F).texture("#stem").end()
			.end()
		.element().from(13.0F, -0.3F, 6.0F).to(15.0F, 3.7F, 8.0F).rotation().angle(-22.5F).axis(Direction.Axis.Z).origin(12.0F, 8.0F, 7.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 0.0F, 2.0F, 4.0F).texture("#stem").end()
			.face(Direction.EAST).uvs(2.0F, 0.0F, 4.0F, 4.0F).texture("#stem").end()
			.face(Direction.SOUTH).uvs(4.0F, 0.0F, 6.0F, 4.0F).texture("#stem").end()
			.face(Direction.WEST).uvs(6.0F, 0.0F, 8.0F, 4.0F).texture("#stem").end()
			.face(Direction.UP).uvs(14.0F, 0.0F, 16.0F, 2.0F).texture("#stem").end()
			.face(Direction.DOWN).uvs(14.0F, 2.0F, 16.0F, 4.0F).texture("#stem").end()
			.end()
		.element().from(4.0F, 0.0F, 11.0F).to(6.0F, 6.0F, 13.0F).rotation().angle(-22.5F).axis(Direction.Axis.Y).origin(7.0F, 8.0F, 12.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 0.0F, 2.0F, 6.0F).texture("#stem").end()
			.face(Direction.EAST).uvs(2.0F, 0.0F, 4.0F, 6.0F).texture("#stem").end()
			.face(Direction.SOUTH).uvs(4.0F, 0.0F, 6.0F, 6.0F).texture("#stem").end()
			.face(Direction.WEST).uvs(6.0F, 0.0F, 8.0F, 6.0F).texture("#stem").end()
			.face(Direction.UP).uvs(14.0F, 0.0F, 16.0F, 2.0F).texture("#stem").end()
			.face(Direction.DOWN).uvs(14.0F, 2.0F, 16.0F, 4.0F).texture("#stem").end()
			.end()
		.element().from(0.5F, 8.0F, 1.5F).to(7.5F, 9.0F, 8.5F).rotation().angle(45.0F).axis(Direction.Axis.Y).origin(4.0F, 8.0F, 5.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 0.0F, 7.0F, 1.0F).texture("#shroom").end()
			.face(Direction.EAST).uvs(0.0F, 0.0F, 7.0F, 1.0F).texture("#shroom").end()
			.face(Direction.SOUTH).uvs(0.0F, 0.0F, 7.0F, 1.0F).texture("#shroom").end()
			.face(Direction.WEST).uvs(0.0F, 0.0F, 7.0F, 1.0F).texture("#shroom").end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 7.0F, 7.0F).texture("#shroom").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 7.0F, 7.0F).texture("#shroom").end()
			.end()
		.element().from(10.5F, 3.7F, 3.5F).to(17.5F, 4.7F, 10.5F).rotation().angle(-22.5F).axis(Direction.Axis.Z).origin(12.0F, 8.0F, 7.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 0.0F, 7.0F, 1.0F).texture("#shroom").end()
			.face(Direction.EAST).uvs(0.0F, 0.0F, 7.0F, 1.0F).texture("#shroom").end()
			.face(Direction.SOUTH).uvs(0.0F, 0.0F, 7.0F, 1.0F).texture("#shroom").end()
			.face(Direction.WEST).uvs(0.0F, 0.0F, 7.0F, 1.0F).texture("#shroom").end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 7.0F, 7.0F).texture("#shroom").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 7.0F, 7.0F).texture("#shroom").end()
			.end()
		.element().from(1.5F, 6.0F, 8.5F).to(8.5F, 7.0F, 15.5F).rotation().angle(-22.5F).axis(Direction.Axis.Y).origin(7.0F, 8.0F, 12.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 0.0F, 7.0F, 1.0F).texture("#shroom").end()
			.face(Direction.EAST).uvs(0.0F, 0.0F, 7.0F, 1.0F).texture("#shroom").end()
			.face(Direction.SOUTH).uvs(0.0F, 0.0F, 7.0F, 1.0F).texture("#shroom").end()
			.face(Direction.WEST).uvs(0.0F, 0.0F, 7.0F, 1.0F).texture("#shroom").end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 7.0F, 7.0F).texture("#shroom").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 7.0F, 7.0F).texture("#shroom").end()
			.end();
	}
}
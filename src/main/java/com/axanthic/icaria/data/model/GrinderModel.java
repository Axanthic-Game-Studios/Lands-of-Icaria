package com.axanthic.icaria.data.model;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;

import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.ModelBuilder;
import net.neoforged.neoforge.client.model.generators.ModelFile;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GrinderModel {

	public static void left(BlockModelBuilder pBuilder, ModelFile.UncheckedModelFile pFile) {
		pBuilder
			.parent(pFile)
		.element().from(0.0F, 0.0F, 0.0F).to(16.0F, 1.0F, 16.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 15.0F, 16.0F, 16.0F).texture("#loam_bricks").end()
			.face(Direction.EAST).uvs(0.0F, 15.0F, 16.0F, 16.0F).texture("#loam_bricks").end()
			.face(Direction.SOUTH).uvs(0.0F, 15.0F, 16.0F, 16.0F).texture("#loam_bricks").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 16.0F, 16.0F).rotation(ModelBuilder.FaceRotation.UPSIDE_DOWN).texture("#loam_bricks").end()
			.end()
		.element().from(0.0F, 1.0F, 0.0F).to(15.0F, 3.0F, 16.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(1.0F, 13.0F, 16.0F, 15.0F).texture("#sunstone_bricks").end()
			.face(Direction.SOUTH).uvs(0.0F, 13.0F, 15.0F, 15.0F).texture("#sunstone_bricks").end()
			.end()
		.element().from(15.0F, 1.0F, 1.0F).to(16.0F, 3.0F, 15.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.EAST).uvs(1.0F, 13.0F, 15.0F, 15.0F).texture("#sunstone_bricks").end()
			.end()
		.element().from(15.0F, 1.0F, 15.0F).to(16.0F, 3.0F, 16.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.EAST).uvs(0.0F, 13.0F, 1.0F, 15.0F).texture("#loam_bricks").end()
			.face(Direction.SOUTH).uvs(15.0F, 13.0F, 16.0F, 15.0F).texture("#loam_bricks").end()
			.end()
		.element().from(15.0F, 1.0F, 0.0F).to(16.0F, 3.0F, 1.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 13.0F, 1.0F, 15.0F).texture("#loam_bricks").end()
			.face(Direction.EAST).uvs(15.0F, 13.0F, 16.0F, 15.0F).texture("#loam_bricks").end()
			.end()
		.element().from(0.0F, 3.0F, 0.0F).to(16.0F, 4.0F, 16.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 12.0F, 16.0F, 13.0F).texture("#loam_bricks").end()
			.face(Direction.EAST).uvs(0.0F, 12.0F, 16.0F, 13.0F).texture("#loam_bricks").end()
			.face(Direction.SOUTH).uvs(0.0F, 12.0F, 16.0F, 13.0F).texture("#loam_bricks").end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 16.0F, 16.0F).texture("#loam_bricks").end()
			.end()
		.element().from(3.0F, 4.0F, 4.0F).to(13.0F, 5.0F, 12.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.UP).uvs(3.0F, 4.0F, 13.0F, 12.0F).texture("#anthracite_block").end()
			.end()
		.element().from(13.0F, 4.0F, 3.0F).to(15.0F, 12.0F, 13.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(1.0F, 4.0F, 3.0F, 12.0F).texture("#sunstone_bricks").end()
			.face(Direction.EAST).uvs(3.0F, 4.0F, 13.0F, 12.0F).texture("#sunstone_bricks").end()
			.face(Direction.SOUTH).uvs(13.0F, 4.0F, 15.0F, 12.0F).texture("#sunstone_bricks").end()
			.face(Direction.WEST).uvs(3.0F, 4.0F, 13.0F, 12.0F).texture("#sunstone_bricks").end()
			.face(Direction.UP).uvs(13.0F, 3.0F, 15.0F, 13.0F).texture("#sunstone_bricks").end()
			.end()
		.element().from(1.0F, 4.0F, 3.0F).to(3.0F, 10.0F, 13.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(13.0F, 6.0F, 15.0F, 12.0F).texture("#sunstone_bricks").end()
			.face(Direction.EAST).uvs(3.0F, 6.0F, 13.0F, 12.0F).texture("#sunstone_bricks").end()
			.face(Direction.SOUTH).uvs(1.0F, 6.0F, 3.0F, 12.0F).texture("#sunstone_bricks").end()
			.face(Direction.WEST).uvs(3.0F, 6.0F, 13.0F, 12.0F).texture("#grinder_feeder").end()
			.end()
		.element().from(1.0F, 10.0F, 3.0F).to(3.0F, 12.0F, 6.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(13.0F, 4.0F, 15.0F, 6.0F).texture("#sunstone_bricks").end()
			.face(Direction.EAST).uvs(10.0F, 4.0F, 13.0F, 6.0F).texture("#sunstone_bricks").end()
			.face(Direction.WEST).uvs(3.0F, 4.0F, 6.0F, 6.0F).texture("#sunstone_bricks").end()
			.face(Direction.UP).uvs(1.0F, 3.0F, 3.0F, 6.0F).texture("#sunstone_bricks").end()
			.end()
		.element().from(1.0F, 10.0F, 10.0F).to(3.0F, 12.0F, 13.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.EAST).uvs(3.0F, 4.0F, 6.0F, 6.0F).texture("#sunstone_bricks").end()
			.face(Direction.SOUTH).uvs(1.0F, 4.0F, 3.0F, 6.0F).texture("#sunstone_bricks").end()
			.face(Direction.WEST).uvs(10.0F, 4.0F, 13.0F, 6.0F).texture("#sunstone_bricks").end()
			.face(Direction.UP).uvs(1.0F, 10.0F, 3.0F, 13.0F).texture("#sunstone_bricks").end()
			.end()
		.element().from(3.0F, 4.0F, 13.0F).to(13.0F, 12.0F, 15.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(3.0F, 4.0F, 13.0F, 12.0F).texture("#sunstone_bricks").end()
			.face(Direction.EAST).uvs(1.0F, 4.0F, 3.0F, 12.0F).texture("#sunstone_bricks").end()
			.face(Direction.SOUTH).uvs(3.0F, 4.0F, 13.0F, 12.0F).texture("#sunstone_bricks").end()
			.face(Direction.WEST).uvs(13.0F, 4.0F, 15.0F, 12.0F).texture("#sunstone_bricks").end()
			.face(Direction.UP).uvs(3.0F, 13.0F, 13.0F, 15.0F).texture("#sunstone_bricks").end()
			.end()
		.element().from(3.0F, 6.0F, 1.0F).to(6.0F, 8.0F, 3.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(10.0F, 8.0F, 13.0F, 10.0F).texture("#sunstone_bricks").end()
			.face(Direction.SOUTH).uvs(3.0F, 8.0F, 6.0F, 10.0F).texture("#sunstone_bricks").end()
			.face(Direction.WEST).uvs(1.0F, 8.0F, 3.0F, 10.0F).texture("#sunstone_bricks").end()
			.end()
		.element().from(6.0039F, 4.3633F, 0.9492F).to(9.9961F, 6.3633F, 4.9492F).rotation().angle(-45.0F).axis(Direction.Axis.X).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 0.0F, 4.0F, 2.0F).texture("#grinder").end()
			.face(Direction.EAST).uvs(0.0F, 0.0F, 4.0F, 2.0F).texture("#grinder").end()
			.face(Direction.SOUTH).uvs(0.0F, 0.0F, 4.0F, 2.0F).texture("#grinder").end()
			.face(Direction.WEST).uvs(0.0F, 0.0F, 4.0F, 2.0F).texture("#grinder").end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 4.0F, 4.0F).texture("#grinder").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 4.0F, 4.0F).rotation(ModelBuilder.FaceRotation.UPSIDE_DOWN).texture("#grinder").end()
			.end()
		.element().from(6.0F, 6.0F, -1.0F).to(10.0F, 8.0F, 3.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 0.0F, 4.0F, 2.0F).texture("#grinder").end()
			.face(Direction.EAST).uvs(0.0F, 0.0F, 4.0F, 2.0F).texture("#grinder").end()
			.face(Direction.SOUTH).uvs(0.0F, 0.0F, 4.0F, 2.0F).texture("#grinder").end()
			.face(Direction.WEST).uvs(0.0F, 0.0F, 4.0F, 2.0F).texture("#grinder").end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 4.0F, 4.0F).texture("#grinder").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 4.0F, 4.0F).rotation(ModelBuilder.FaceRotation.UPSIDE_DOWN).texture("#grinder").end()
			.end()
		.element().from(3.0F, 4.0F, 3.0F).to(4.0F, 12.0F, 4.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.EAST).uvs(12.0F, 4.0F, 13.0F, 12.0F).texture("#sunstone_bricks").end()
			.face(Direction.SOUTH).uvs(3.0F, 4.0F, 4.0F, 12.0F).texture("#sunstone_bricks").end()
			.face(Direction.UP).uvs(3.0F, 3.0F, 4.0F, 4.0F).texture("#sunstone_bricks").end()
			.end()
		.element().from(2.0F, 4.0F, 2.0F).to(3.0F, 12.0F, 3.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(13.0F, 4.0F, 14.0F, 12.0F).texture("#sunstone_bricks").end()
			.face(Direction.WEST).uvs(2.0F, 4.0F, 3.0F, 12.0F).texture("#sunstone_bricks").end()
			.face(Direction.UP).uvs(2.0F, 2.0F, 3.0F, 3.0F).texture("#sunstone_bricks").end()
			.end()
		.element().from(13.0F, 4.0F, 2.0F).to(14.0F, 12.0F, 3.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(2.0F, 4.0F, 3.0F, 12.0F).texture("#sunstone_bricks").end()
			.face(Direction.EAST).uvs(13.0F, 4.0F, 14.0F, 12.0F).texture("#sunstone_bricks").end()
			.face(Direction.UP).uvs(2.0F, 13.0F, 3.0F, 14.0F).texture("#sunstone_bricks").end()
			.end()
		.element().from(12.0F, 4.0F, 3.0F).to(13.0F, 12.0F, 4.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.SOUTH).uvs(12.0F, 4.0F, 13.0F, 12.0F).texture("#sunstone_bricks").end()
			.face(Direction.WEST).uvs(3.0F, 4.0F, 4.0F, 12.0F).texture("#sunstone_bricks").end()
			.face(Direction.UP).uvs(3.0F, 12.0F, 4.0F, 13.0F).texture("#sunstone_bricks").end()
			.end()
		.element().from(13.0F, 4.0F, 13.0F).to(14.0F, 12.0F, 14.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.EAST).uvs(2.0F, 4.0F, 3.0F, 12.0F).texture("#sunstone_bricks").end()
			.face(Direction.SOUTH).uvs(13.0F, 4.0F, 14.0F, 12.0F).texture("#sunstone_bricks").end()
			.face(Direction.UP).uvs(13.0F, 13.0F, 14.0F, 14.0F).texture("#sunstone_bricks").end()
			.end()
		.element().from(12.0F, 4.0F, 12.0F).to(13.0F, 12.0F, 13.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(3.0F, 4.0F, 4.0F, 12.0F).texture("#sunstone_bricks").end()
			.face(Direction.WEST).uvs(12.0F, 4.0F, 13.0F, 12.0F).texture("#sunstone_bricks").end()
			.face(Direction.UP).uvs(12.0F, 12.0F, 13.0F, 13.0F).texture("#sunstone_bricks").end()
			.end()
		.element().from(3.0F, 4.0F, 12.0F).to(4.0F, 12.0F, 13.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(12.0F, 4.0F, 13.0F, 12.0F).texture("#sunstone_bricks").end()
			.face(Direction.EAST).uvs(3.0F, 4.0F, 4.0F, 12.0F).texture("#sunstone_bricks").end()
			.face(Direction.UP).uvs(3.0F, 12.0F, 4.0F, 13.0F).texture("#sunstone_bricks").end()
			.end()
		.element().from(2.0F, 4.0F, 13.0F).to(3.0F, 12.0F, 14.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.EAST).uvs(12.0F, 4.0F, 13.0F, 12.0F).end()
			.face(Direction.SOUTH).uvs(2.0F, 4.0F, 3.0F, 12.0F).texture("#sunstone_bricks").end()
			.face(Direction.WEST).uvs(13.0F, 4.0F, 14.0F, 12.0F).texture("#sunstone_bricks").end()
			.face(Direction.UP).uvs(2.0F, 13.0F, 3.0F, 14.0F).texture("#sunstone_bricks").end()
			.end()
		.element().from(4.0F, 4.0F, 3.0F).to(12.0F, 5.0F, 4.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.UP).uvs(4.0F, 3.0F, 12.0F, 4.0F).texture("#anthracite_block").end()
			.end()
		.element().from(4.0F, 4.0F, 12.0F).to(12.0F, 5.0F, 13.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.UP).uvs(4.0F, 12.0F, 12.0F, 13.0F).texture("#anthracite_block").end()
			.end()
		.element().from(3.0F, 8.0F, 1.0F).to(13.0F, 12.0F, 3.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(3.0F, 4.0F, 13.0F, 8.0F).texture("#sunstone_bricks").end()
			.face(Direction.EAST).uvs(13.0F, 4.0F, 15.0F, 8.0F).texture("#sunstone_bricks").end()
			.face(Direction.SOUTH).uvs(3.0F, 4.0F, 13.0F, 8.0F).texture("#sunstone_bricks").end()
			.face(Direction.WEST).uvs(1.0F, 4.0F, 3.0F, 8.0F).texture("#sunstone_bricks").end()
			.face(Direction.UP).uvs(3.0F, 1.0F, 13.0F, 3.0F).texture("#sunstone_bricks").end()
			.end()
		.element().from(3.0F, 4.0F, 1.0F).to(13.0F, 6.0F, 3.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(3.0F, 10.0F, 13.0F, 12.0F).texture("#sunstone_bricks").end()
			.face(Direction.EAST).uvs(13.0F, 10.0F, 15.0F, 12.0F).texture("#sunstone_bricks").end()
			.face(Direction.SOUTH).uvs(3.0F, 10.0F, 13.0F, 12.0F).texture("#sunstone_bricks").end()
			.face(Direction.WEST).uvs(1.0F, 10.0F, 3.0F, 12.0F).texture("#sunstone_bricks").end()
			.end()
		.element().from(10.0F, 6.0F, 1.0F).to(13.0F, 8.0F, 3.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(3.0F, 8.0F, 6.0F, 10.0F).texture("#sunstone_bricks").end()
			.face(Direction.EAST).uvs(13.0F, 8.0F, 15.0F, 10.0F).texture("#sunstone_bricks").end()
			.face(Direction.SOUTH).uvs(10.0F, 8.0F, 13.0F, 10.0F).texture("#sunstone_bricks").end()
			.end()
		.element().from(0.0F, 11.0F, 6.0F).to(3.0F, 13.0F, 7.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(13.0F, 1.0F, 16.0F, 3.0F).texture("#grinder").end()
			.face(Direction.EAST).uvs(2.0F, 1.0F, 3.0F, 3.0F).texture("#grinder").end()
			.face(Direction.SOUTH).uvs(0.0F, 1.0F, 3.0F, 3.0F).texture("#grinder").end()
			.end()
		.element().from(0.0F, 13.0F, 6.0F).to(3.0F, 14.0F, 10.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(13.0F, 0.0F, 16.0F, 1.0F).texture("#grinder").end()
			.face(Direction.EAST).uvs(0.0F, 0.0F, 4.0F, 1.0F).texture("#grinder").end()
			.face(Direction.SOUTH).uvs(0.0F, 0.0F, 3.0F, 1.0F).texture("#grinder").end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 3.0F, 4.0F).texture("#grinder").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 3.0F, 4.0F).rotation(ModelBuilder.FaceRotation.UPSIDE_DOWN).texture("#grinder").end()
			.end()
		.element().from(0.0F, 11.0F, 9.0F).to(3.0F, 13.0F, 10.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(13.0F, 1.0F, 16.0F, 3.0F).texture("#grinder").end()
			.face(Direction.EAST).uvs(0.0F, 1.0F, 1.0F, 3.0F).texture("#grinder").end()
			.face(Direction.SOUTH).uvs(0.0F, 1.0F, 3.0F, 3.0F).texture("#grinder").end()
			.end()
		.element().from(0.0F, 10.0F, 6.0F).to(3.0F, 11.0F, 10.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(13.0F, 3.0F, 16.0F, 4.0F).texture("#grinder").end()
			.face(Direction.EAST).uvs(0.0F, 3.0F, 4.0F, 4.0F).texture("#grinder").end()
			.face(Direction.SOUTH).uvs(0.0F, 3.0F, 3.0F, 4.0F).texture("#grinder").end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 3.0F, 4.0F).texture("#grinder").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 3.0F, 4.0F).rotation(ModelBuilder.FaceRotation.UPSIDE_DOWN).texture("#grinder").end()
			.end();
	}

	public static void right(BlockModelBuilder pBuilder, ModelFile.UncheckedModelFile pFile) {
		pBuilder
			.parent(pFile)
		.element().from(0.0F, 0.0F, 0.0F).to(16.0F, 1.0F, 16.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 15.0F, 16.0F, 16.0F).texture("#loam_bricks").end()
			.face(Direction.SOUTH).uvs(0.0F, 15.0F, 16.0F, 16.0F).texture("#loam_bricks").end()
			.face(Direction.WEST).uvs(0.0F, 15.0F, 16.0F, 16.0F).texture("#loam_bricks").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 16.0F, 16.0F).rotation(ModelBuilder.FaceRotation.UPSIDE_DOWN).texture("#loam_bricks").end()
			.end()
		.element().from(1.0F, 1.0F, 0.0F).to(16.0F, 3.0F, 16.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 13.0F, 15.0F, 15.0F).texture("#sunstone_bricks").end()
			.face(Direction.SOUTH).uvs(1.0F, 13.0F, 16.0F, 15.0F).texture("#sunstone_bricks").end()
			.end()
		.element().from(0.0F, 1.0F, 1.0F).to(1.0F, 3.0F, 15.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.WEST).uvs(1.0F, 13.0F, 15.0F, 15.0F).texture("#sunstone_bricks").end()
			.end()
		.element().from(0.0F, 1.0F, 0.0F).to(1.0F, 3.0F, 1.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(15.0F, 13.0F, 16.0F, 15.0F).texture("#loam_bricks").end()
			.face(Direction.WEST).uvs(0.0F, 13.0F, 1.0F, 15.0F).texture("#loam_bricks").end()
			.end()
		.element().from(0.0F, 1.0F, 15.0F).to(1.0F, 3.0F, 16.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.SOUTH).uvs(0.0F, 13.0F, 1.0F, 15.0F).texture("#loam_bricks").end()
			.face(Direction.WEST).uvs(15.0F, 13.0F, 16.0F, 15.0F).texture("#loam_bricks").end()
			.end()
		.element().from(0.0F, 3.0F, 0.0F).to(5.0F, 4.0F, 16.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(11.0F, 12.0F, 16.0F, 13.0F).texture("#loam_bricks").end()
			.face(Direction.SOUTH).uvs(0.0F, 12.0F, 5.0F, 13.0F).texture("#loam_bricks").end()
			.face(Direction.WEST).uvs(0.0F, 12.0F, 16.0F, 13.0F).texture("#loam_bricks").end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 5.0F, 16.0F).texture("#loam_bricks").end()
			.end()
		.element().from(1.0F, 4.0F, 1.0F).to(15.0F, 5.0F, 11.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(1.0F, 11.0F, 15.0F, 12.0F).texture("#anthracite_block").end()
			.face(Direction.EAST).uvs(5.0F, 11.0F, 15.0F, 12.0F).texture("#anthracite_block").end()
			.face(Direction.WEST).uvs(1.0F, 11.0F, 11.0F, 12.0F).texture("#anthracite_block").end()
			.face(Direction.UP).uvs(1.0F, 1.0F, 15.0F, 11.0F).texture("#anthracite_block").end()
			.end()
		.element().from(2.0F, 4.0F, 11.0F).to(14.0F, 11.0F, 15.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(2.0F, 5.0F, 14.0F, 12.0F).texture("#grinder_engine").end()
			.face(Direction.EAST).uvs(1.0F, 5.0F, 5.0F, 12.0F).texture("#sunstone_bricks").end()
			.face(Direction.SOUTH).uvs(2.0F, 5.0F, 14.0F, 12.0F).texture("#sunstone_bricks").end()
			.face(Direction.WEST).uvs(11.0F, 5.0F, 15.0F, 12.0F).texture("#sunstone_bricks").end()
			.face(Direction.UP).uvs(2.0F, 11.0F, 14.0F, 15.0F).rotation(ModelBuilder.FaceRotation.UPSIDE_DOWN).texture("#sunstone_bricks").end()
			.end()
		.element().from(5.0F, 3.0F, 15.0F).to(11.0F, 9.0F, 16.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.EAST).uvs(0.0F, 7.0F, 1.0F, 13.0F).texture("#voidshale").end()
			.face(Direction.SOUTH).uvs(5.0F, 7.0F, 11.0F, 13.0F).texture("#voidshale").end()
			.face(Direction.WEST).uvs(15.0F, 7.0F, 16.0F, 13.0F).texture("#voidshale").end()
			.face(Direction.UP).uvs(5.0F, 15.0F, 11.0F, 16.0F).texture("#voidshale").end()
			.end()
		.element().from(10.0F, 10.0F, 6.0F).to(16.0F, 11.0F, 10.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 3.0F, 6.0F, 4.0F).texture("#grinder").end()
			.face(Direction.SOUTH).uvs(10.0F, 3.0F, 16.0F, 4.0F).texture("#grinder").end()
			.face(Direction.UP).uvs(10.0F, 0.0F, 16.0F, 4.0F).texture("#grinder").end()
			.face(Direction.DOWN).uvs(10.0F, 0.0F, 16.0F, 4.0F).rotation(ModelBuilder.FaceRotation.UPSIDE_DOWN).texture("#grinder").end()
			.end()
		.element().from(5.0F, 15.0F, 5.0F).to(10.0F, 16.0F, 6.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(1.0F, 0.0F, 6.0F, 1.0F).texture("#grinder").end()
			.face(Direction.SOUTH).uvs(0.0F, 0.0F, 5.0F, 1.0F).texture("#grinder").end()
			.face(Direction.WEST).uvs(0.0F, 0.0F, 1.0F, 1.0F).texture("#grinder").end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 5.0F, 1.0F).texture("#grinder").end()
			.face(Direction.DOWN).uvs(1.0F, 0.0F, 6.0F, 1.0F).rotation(ModelBuilder.FaceRotation.UPSIDE_DOWN).texture("#grinder").end()
			.end()
		.element().from(6.0F, 15.0F, 10.0F).to(11.0F, 16.0F, 11.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 0.0F, 5.0F, 1.0F).texture("#grinder").end()
			.face(Direction.EAST).uvs(0.0F, 0.0F, 1.0F, 1.0F).texture("#grinder").end()
			.face(Direction.SOUTH).uvs(1.0F, 0.0F, 6.0F, 1.0F).texture("#grinder").end()
			.face(Direction.UP).uvs(1.0F, 5.0F, 6.0F, 6.0F).texture("#grinder").end()
			.face(Direction.DOWN).uvs(0.0F, 5.0F, 5.0F, 6.0F).rotation(ModelBuilder.FaceRotation.UPSIDE_DOWN).texture("#grinder").end()
			.end()
		.element().from(5.0F, 15.0F, 6.0F).to(6.0F, 16.0F, 11.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.EAST).uvs(0.0F, 0.0F, 5.0F, 1.0F).texture("#grinder").end()
			.face(Direction.SOUTH).uvs(0.0F, 0.0F, 1.0F, 1.0F).texture("#grinder").end()
			.face(Direction.WEST).uvs(1.0F, 0.0F, 6.0F, 1.0F).texture("#grinder").end()
			.face(Direction.UP).uvs(0.0F, 1.0F, 1.0F, 6.0F).texture("#grinder").end()
			.face(Direction.DOWN).uvs(5.0F, 1.0F, 6.0F, 6.0F).rotation(ModelBuilder.FaceRotation.UPSIDE_DOWN).texture("#grinder").end()
			.end()
		.element().from(1.0F, 4.0F, 11.0F).to(2.0F, 5.0F, 13.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.SOUTH).uvs(1.0F, 11.0F, 2.0F, 12.0F).texture("#anthracite_block").end()
			.face(Direction.WEST).uvs(11.0F, 11.0F, 13.0F, 12.0F).texture("#anthracite_block").end()
			.face(Direction.UP).uvs(1.0F, 11.0F, 2.0F, 13.0F).texture("#anthracite_block").end()
			.end()
		.element().from(14.0F, 4.0F, 11.0F).to(15.0F, 5.0F, 13.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.EAST).uvs(3.0F, 11.0F, 5.0F, 12.0F).texture("#anthracite_block").end()
			.face(Direction.SOUTH).uvs(14.0F, 11.0F, 15.0F, 12.0F).texture("#anthracite_block").end()
			.face(Direction.UP).uvs(14.0F, 11.0F, 15.0F, 13.0F).texture("#anthracite_block").end()
			.end()
		.element().from(5.0F, 3.0F, 0.0F).to(11.0F, 4.0F, 15.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(5.0F, 12.0F, 11.0F, 13.0F).texture("#loam_bricks").end()
			.face(Direction.UP).uvs(5.0F, 0.0F, 11.0F, 16.0F).texture("#loam_bricks").end()
			.end()
		.element().from(11.0F, 3.0F, 0.0F).to(16.0F, 4.0F, 16.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 12.0F, 5.0F, 13.0F).texture("#loam_bricks").end()
			.face(Direction.SOUTH).uvs(11.0F, 12.0F, 16.0F, 13.0F).texture("#loam_bricks").end()
			.face(Direction.UP).uvs(11.0F, 0.0F, 16.0F, 16.0F).texture("#loam_bricks").end()
			.end()
		.element().from(10.0F, 13.0F, 6.0F).to(16.0F, 14.0F, 10.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 0.0F, 6.0F, 1.0F).texture("#grinder").end()
			.face(Direction.SOUTH).uvs(10.0F, 0.0F, 16.0F, 1.0F).texture("#grinder").end()
			.face(Direction.WEST).uvs(0.0F, 0.0F, 4.0F, 1.0F).texture("#grinder").end()
			.face(Direction.UP).uvs(10.0F, 0.0F, 16.0F, 4.0F).texture("#grinder").end()
			.face(Direction.DOWN).uvs(10.0F, 0.0F, 16.0F, 4.0F).rotation(ModelBuilder.FaceRotation.UPSIDE_DOWN).texture("#grinder").end()
			.end()
		.element().from(10.0F, 11.0F, 6.0F).to(16.0F, 13.0F, 7.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 1.0F, 6.0F, 3.0F).texture("#grinder").end()
			.face(Direction.SOUTH).uvs(10.0F, 1.0F, 16.0F, 3.0F).texture("#grinder").end()
			.end()
		.element().from(10.0F, 11.0F, 9.0F).to(16.0F, 13.0F, 10.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 1.0F, 6.0F, 3.0F).texture("#grinder").end()
			.face(Direction.SOUTH).uvs(10.0F, 1.0F, 16.0F, 3.0F).texture("#grinder").end()
			.end()
		.element().from(10.0F, 15.0F, 5.0F).to(11.0F, 16.0F, 10.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 0.0F, 1.0F, 1.0F).texture("#grinder").end()
			.face(Direction.EAST).uvs(1.0F, 0.0F, 6.0F, 1.0F).texture("#grinder").end()
			.face(Direction.WEST).uvs(0.0F, 0.0F, 5.0F, 1.0F).texture("#grinder").end()
			.face(Direction.UP).uvs(5.0F, 0.0F, 6.0F, 5.0F).texture("#grinder").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 1.0F, 5.0F).rotation(ModelBuilder.FaceRotation.UPSIDE_DOWN).texture("#grinder").end()
			.end()
		.element().from(4.3438F, 10.0F, 6.0039F).to(10.0F, 10.707F, 9.9961F).rotation().angle(-45.0F).axis(Direction.Axis.Z).origin(10.0F, 10.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(5.0F, 3.0F, 6.0F, 4.0F).texture("#grinder").end()
			.face(Direction.SOUTH).uvs(10.0F, 3.0F, 11.0F, 4.0F).texture("#grinder").end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 6.0F, 4.0F).texture("#grinder").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 6.0F, 4.0F).rotation(ModelBuilder.FaceRotation.UPSIDE_DOWN).texture("#grinder").end()
			.end()
		.element().from(9.0F, 14.0F, 6.0F).to(10.0F, 15.0F, 9.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(5.0F, 0.0F, 6.0F, 1.0F).texture("#grinder").end()
			.face(Direction.EAST).uvs(1.0F, 0.0F, 4.0F, 1.0F).texture("#grinder").end()
			.face(Direction.WEST).uvs(0.0F, 0.0F, 3.0F, 1.0F).texture("#grinder").end()
			.face(Direction.UP).uvs(4.0F, 1.0F, 5.0F, 4.0F).texture("#grinder").end()
			.end()
		.element().from(6.0F, 14.0F, 6.0F).to(9.0F, 15.0F, 7.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(5.0F, 1.0F, 6.0F, 4.0F).rotation(ModelBuilder.FaceRotation.COUNTERCLOCKWISE_90).texture("#grinder").end()
			.face(Direction.SOUTH).uvs(10.0F, 1.0F, 11.0F, 4.0F).rotation(ModelBuilder.FaceRotation.CLOCKWISE_90).texture("#grinder").end()
			.face(Direction.WEST).uvs(0.0F, 0.0F, 1.0F, 1.0F).texture("#grinder").end()
			.face(Direction.UP).uvs(1.0F, 1.0F, 4.0F, 2.0F).texture("#grinder").end()
			.end()
		.element().from(6.0F, 14.0F, 7.0F).to(7.0F, 15.0F, 10.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.EAST).uvs(0.0F, 0.0F, 3.0F, 1.0F).texture("#grinder").end()
			.face(Direction.SOUTH).uvs(10.0F, 3.0F, 11.0F, 4.0F).texture("#grinder").end()
			.face(Direction.WEST).uvs(1.0F, 0.0F, 4.0F, 1.0F).texture("#grinder").end()
			.face(Direction.UP).uvs(1.0F, 2.0F, 2.0F, 5.0F).texture("#grinder").end()
			.end()
		.element().from(7.0F, 14.0F, 9.0F).to(10.0F, 15.0F, 10.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(5.0F, 0.0F, 6.0F, 3.0F).rotation(ModelBuilder.FaceRotation.COUNTERCLOCKWISE_90).texture("#grinder").end()
			.face(Direction.EAST).uvs(0.0F, 0.0F, 1.0F, 1.0F).texture("#grinder").end()
			.face(Direction.SOUTH).uvs(10.0F, 0.0F, 11.0F, 3.0F).rotation(ModelBuilder.FaceRotation.CLOCKWISE_90).texture("#grinder").end()
			.face(Direction.UP).uvs(2.0F, 4.0F, 5.0F, 5.0F).texture("#grinder").end()
			.end()
		.element().from(7.1719F, 12.4141F, 6.0039F).to(8.5859F, 13.1211F, 7.0039F).rotation().angle(-45.0F).axis(Direction.Axis.Z).origin(10.0F, 11.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(5.0F, 0.0F, 6.0F, 1.0F).texture("#grinder").end()
			.face(Direction.SOUTH).uvs(10.0F, 0.0F, 11.0F, 1.0F).texture("#grinder").end()
			.end()
		.element().from(6.4648F, 11.707F, 6.0039F).to(9.293F, 12.4141F, 7.0039F).rotation().angle(-45.0F).axis(Direction.Axis.Z).origin(10.0F, 11.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(5.0F, 1.0F, 6.0F, 2.0F).texture("#grinder").end()
			.face(Direction.SOUTH).uvs(10.0F, 1.0F, 11.0F, 2.0F).texture("#grinder").end()
			.end()
		.element().from(5.7578F, 11.0F, 6.0039F).to(10.0F, 11.707F, 7.0039F).rotation().angle(-45.0F).axis(Direction.Axis.Z).origin(10.0F, 11.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(5.0F, 2.0F, 6.0F, 3.0F).texture("#grinder").end()
			.face(Direction.SOUTH).uvs(10.0F, 2.0F, 11.0F, 3.0F).texture("#grinder").end()
			.end()
		.element().from(5.7578F, 11.0F, 8.9961F).to(10.0F, 11.707F, 9.9961F).rotation().angle(-45.0F).axis(Direction.Axis.Z).origin(10.0F, 11.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(5.0F, 2.0F, 6.0F, 3.0F).texture("#grinder").end()
			.face(Direction.SOUTH).uvs(10.0F, 2.0F, 11.0F, 3.0F).texture("#grinder").end()
			.end()
		.element().from(6.4648F, 11.707F, 8.9961F).to(9.293F, 12.4141F, 9.9961F).rotation().angle(-45.0F).axis(Direction.Axis.Z).origin(10.0F, 11.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(5.0F, 1.0F, 6.0F, 2.0F).texture("#grinder").end()
			.face(Direction.SOUTH).uvs(10.0F, 1.0F, 11.0F, 2.0F).texture("#grinder").end()
			.end()
		.element().from(7.1719F, 12.4141F, 8.9961F).to(8.5859F, 13.1211F, 9.9961F).rotation().angle(-45.0F).axis(Direction.Axis.Z).origin(10.0F, 11.0F, 8.0F).end()
			.face(Direction.NORTH).uvs(5.0F, 0.0F, 6.0F, 1.0F).texture("#grinder").end()
			.face(Direction.SOUTH).uvs(10.0F, 0.0F, 11.0F, 1.0F).texture("#grinder").end()
			.end();
	}
}

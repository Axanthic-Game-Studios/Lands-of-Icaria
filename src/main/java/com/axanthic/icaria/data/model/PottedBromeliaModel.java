package com.axanthic.icaria.data.model;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;

import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.ModelFile;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class PottedBromeliaModel {

	public static void template(BlockModelBuilder pBuilder, ModelFile.UncheckedModelFile pFile) {
		pBuilder
			.parent(pFile)
		.element().from(5.0F, 0.0F, 5.0F).to(6.0F, 6.0F, 11.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(10.0F, 10.0F, 11.0F, 16.0F).texture("#pot").end()
			.face(Direction.SOUTH).uvs(5.0F, 10.0F, 6.0F, 16.0F).texture("#pot").end()
			.face(Direction.WEST).uvs(5.0F, 10.0F, 11.0F, 16.0F).texture("#pot").end()
			.face(Direction.UP).uvs(5.0F, 5.0F, 6.0F, 11.0F).texture("#pot").end()
			.face(Direction.DOWN).uvs(5.0F, 5.0F, 6.0F, 11.0F).texture("#pot").cullface(Direction.DOWN).end()
			.end()
		.element().from(10.0F, 0.0F, 5.0F).to(11.0F, 6.0F, 11.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(5.0F, 10.0F, 6.0F, 16.0F).texture("#pot").end()
			.face(Direction.EAST).uvs(5.0F, 10.0F, 11.0F, 16.0F).texture("#pot").end()
			.face(Direction.SOUTH).uvs(10.0F, 10.0F, 11.0F, 16.0F).texture("#pot").end()
			.face(Direction.UP).uvs(10.0F, 5.0F, 11.0F, 11.0F).texture("#pot").end()
			.face(Direction.DOWN).uvs(10.0F, 5.0F, 11.0F, 11.0F).texture("#pot").cullface(Direction.DOWN).end()
			.end()
		.element().from(6.0F, 0.0F, 5.0F).to(10.0F, 6.0F, 6.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(6.0F, 10.0F, 10.0F, 16.0F).texture("#pot").end()
			.face(Direction.UP).uvs(6.0F, 5.0F, 10.0F, 6.0F).texture("#pot").end()
			.face(Direction.DOWN).uvs(6.0F, 10.0F, 10.0F, 11.0F).texture("#pot").cullface(Direction.DOWN).end()
			.end()
		.element().from(6.0F, 0.0F, 10.0F).to(10.0F, 6.0F, 11.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.SOUTH).uvs(6.0F, 10.0F, 10.0F, 16.0F).texture("#pot").end()
			.face(Direction.UP).uvs(6.0F, 10.0F, 10.0F, 11.0F).texture("#pot").end()
			.face(Direction.DOWN).uvs(6.0F, 5.0F, 10.0F, 6.0F).texture("#pot").cullface(Direction.DOWN).end()
			.end()
		.element().from(6.0F, 0.0F, 6.0F).to(10.0F, 6.0F, 10.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 8.0F, 0.0F).end()
			.face(Direction.UP).uvs(5.0F, 0.0F, 9.0F, 4.0F).texture("#overlay").tintindex(0).end()
			.face(Direction.DOWN).uvs(12.0F, 6.0F, 16.0F, 10.0F).texture("#pot").cullface(Direction.DOWN).end()
			.end()
		.element().from(7.5F, 15.0F, 7.5F).to(8.5F, 16.0F, 8.5F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 2.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(1.0F, 4.0F, 2.0F, 5.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(1.0F, 4.0F, 2.0F, 5.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(1.0F, 4.0F, 2.0F, 5.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(1.0F, 4.0F, 2.0F, 5.0F).texture("#texture").end()
			.face(Direction.UP).uvs(1.0F, 4.0F, 2.0F, 5.0F).texture("#texture").end()
			.end()
		.element().from(6.5F, 11.0F, 6.5F).to(9.5F, 15.0F, 9.5F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 2.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 0.0F, 3.0F, 4.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(0.0F, 0.0F, 3.0F, 4.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(0.0F, 0.0F, 3.0F, 4.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(0.0F, 0.0F, 3.0F, 4.0F).texture("#texture").end()
			.face(Direction.UP).uvs(3.0F, 0.0F, 6.0F, 3.0F).texture("#texture").end()
			.face(Direction.DOWN).uvs(3.0F, 3.0F, 6.0F, 6.0F).texture("#texture").end()
			.end()
		.element().from(7.5F, 6.0F, 7.5F).to(8.5F, 11.0F, 8.5F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 4.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 4.0F, 1.0F, 9.0F).texture("#texture").end()
			.face(Direction.EAST).uvs(0.0F, 4.0F, 1.0F, 9.0F).texture("#texture").end()
			.face(Direction.SOUTH).uvs(0.0F, 4.0F, 1.0F, 9.0F).texture("#texture").end()
			.face(Direction.WEST).uvs(0.0F, 4.0F, 1.0F, 9.0F).texture("#texture").end()
			.end()
		.element().from(6.5F, 6.0F, 9.0F).to(9.5F, 11.0F, 9.0F).rotation().angle(22.5F).axis(Direction.Axis.X).origin(8.0F, 6.0F, 9.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 8.0F, 3.0F, 13.0F).texture("#overlay").tintindex(0).end()
			.face(Direction.SOUTH).uvs(0.0F, 8.0F, 3.0F, 13.0F).texture("#overlay").tintindex(0).end()
			.end()
		.element().from(6.5F, 6.0F, 7.0F).to(9.5F, 11.0F, 7.0F).rotation().angle(-22.5F).axis(Direction.Axis.X).origin(8.0F, 6.0F, 7.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 8.0F, 3.0F, 13.0F).texture("#overlay").tintindex(0).end()
			.face(Direction.SOUTH).uvs(0.0F, 8.0F, 3.0F, 13.0F).texture("#overlay").tintindex(0).end()
			.end()
		.element().from(9.0F, 6.0F, 6.5F).to(9.0F, 11.0F, 9.5F).rotation().angle(-22.5F).axis(Direction.Axis.Z).origin(9.0F, 6.0F, 8.0F).end()
			.face(Direction.EAST).uvs(0.0F, 8.0F, 3.0F, 13.0F).texture("#overlay").tintindex(0).end()
			.face(Direction.WEST).uvs(0.0F, 8.0F, 3.0F, 13.0F).texture("#overlay").tintindex(0).end()
			.end()
		.element().from(7.0F, 6.0F, 6.5F).to(7.0F, 11.0F, 9.5F).rotation().angle(22.5F).axis(Direction.Axis.Z).origin(7.0F, 6.0F, 8.0F).end()
			.face(Direction.EAST).uvs(0.0F, 8.0F, 3.0F, 13.0F).texture("#overlay").tintindex(0).end()
			.face(Direction.WEST).uvs(0.0F, 8.0F, 3.0F, 13.0F).texture("#overlay").tintindex(0).end()
			.end()
		.element().from(5.5F, 10.25F, 10.125F).to(10.5F, 14.25F, 10.125F).rotation().angle(45.0F).axis(Direction.Axis.X).origin(8.0F, 8.25F, 10.125F).end()
			.face(Direction.NORTH).uvs(0.0F, 4.0F, 5.0F, 8.0F).texture("#overlay").tintindex(0).end()
			.face(Direction.SOUTH).uvs(0.0F, 4.0F, 5.0F, 8.0F).texture("#overlay").tintindex(0).end()
			.end()
		.element().from(5.5F, 6.0F, 10.0F).to(10.5F, 10.0F, 10.0F).rotation().angle(22.5F).axis(Direction.Axis.X).origin(8.0F, 6.0F, 10.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 0.0F, 5.0F, 4.0F).texture("#overlay").tintindex(0).end()
			.face(Direction.SOUTH).uvs(0.0F, 0.0F, 5.0F, 4.0F).texture("#overlay").tintindex(0).end()
			.end()
		.element().from(5.5F, 10.875F, 7.25F).to(10.5F, 14.875F, 7.25F).rotation().angle(-45.0F).axis(Direction.Axis.X).origin(8.0F, 6.875F, 7.25F).end()
			.face(Direction.NORTH).uvs(0.0F, 4.0F, 5.0F, 8.0F).texture("#overlay").tintindex(0).end()
			.face(Direction.SOUTH).uvs(0.0F, 4.0F, 5.0F, 8.0F).texture("#overlay").tintindex(0).end()
			.end()
		.element().from(5.5F, 6.0F, 6.0F).to(10.5F, 10.0F, 6.0F).rotation().angle(-22.5F).axis(Direction.Axis.X).origin(8.0F, 6.0F, 6.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 0.0F, 5.0F, 4.0F).texture("#overlay").tintindex(0).end()
			.face(Direction.SOUTH).uvs(0.0F, 0.0F, 5.0F, 4.0F).texture("#overlay").tintindex(0).end()
			.end()
		.element().from(8.75F, 10.875F, 5.5F).to(8.75F, 14.875F, 10.5F).rotation().angle(-45.0F).axis(Direction.Axis.Z).origin(8.75F, 6.875F, 8.0F).end()
			.face(Direction.EAST).uvs(0.0F, 4.0F, 5.0F, 8.0F).texture("#overlay").tintindex(0).end()
			.face(Direction.WEST).uvs(0.0F, 4.0F, 5.0F, 8.0F).texture("#overlay").tintindex(0).end()
			.end()
		.element().from(10.0F, 6.0F, 5.5F).to(10.0F, 10.0F, 10.5F).rotation().angle(-22.5F).axis(Direction.Axis.Z).origin(10.0F, 6.0F, 8.0F).end()
			.face(Direction.EAST).uvs(0.0F, 0.0F, 5.0F, 4.0F).texture("#overlay").tintindex(0).end()
			.face(Direction.WEST).uvs(0.0F, 0.0F, 5.0F, 4.0F).texture("#overlay").tintindex(0).end()
			.end()
		.element().from(7.25F, 10.875F, 5.5F).to(7.25F, 14.875F, 10.5F).rotation().angle(45.0F).axis(Direction.Axis.Z).origin(7.25F, 6.875F, 8.0F).end()
			.face(Direction.EAST).uvs(0.0F, 4.0F, 5.0F, 8.0F).texture("#overlay").tintindex(0).end()
			.face(Direction.WEST).uvs(0.0F, 4.0F, 5.0F, 8.0F).texture("#overlay").tintindex(0).end()
			.end()
		.element().from(6.0F, 6.0F, 5.5F).to(6.0F, 10.0F, 10.5F).rotation().angle(22.5F).axis(Direction.Axis.Z).origin(6.0F, 6.0F, 8.0F).end()
			.face(Direction.EAST).uvs(0.0F, 0.0F, 5.0F, 4.0F).texture("#overlay").tintindex(0).end()
			.face(Direction.WEST).uvs(0.0F, 0.0F, 5.0F, 4.0F).texture("#overlay").tintindex(0).end()
			.end();
	}
}

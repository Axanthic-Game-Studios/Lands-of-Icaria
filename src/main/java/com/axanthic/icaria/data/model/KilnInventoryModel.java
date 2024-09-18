package com.axanthic.icaria.data.model;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemDisplayContext;

import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.ModelBuilder;
import net.neoforged.neoforge.client.model.generators.ModelFile;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class KilnInventoryModel {

	public static void template(BlockModelBuilder pBuilder, ModelFile.UncheckedModelFile pFile) {
		pBuilder
			.parent(pFile)
		.transforms()
			.transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND).rotation(0, 135, 0).translation(0.0F, 0.0F, 0.0F).scale(0.35F).end()
			.transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND).rotation(0, 135, 0).translation(0.0F, 0.0F, 0.0F).scale(0.35F).end()
			.transform(ItemDisplayContext.FIXED).rotation(0, 0, 0).translation(0.0F, -3.0F, 0.0F).scale(0.35F).end()
			.transform(ItemDisplayContext.GROUND).rotation(0, 0, 0).translation(0.0F, 4.5F, 0.0F).scale(0.35F).end()
			.transform(ItemDisplayContext.GUI).rotation(30, 225, 0).translation(0.0F, -2.0F, 0.0F).scale(0.35F).end()
			.transform(ItemDisplayContext.HEAD).rotation(0, 0, 0).translation(0.0F, 9.0F, 0.0F).scale(0.35F).end()
			.transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND).rotation(75, 135, 0).translation(0.0F, 2.5F, 0.0F).scale(0.35F).end()
			.transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND).rotation(75, 135, 0).translation(0.0F, 2.5F, 0.0F).scale(0.35F).end()
			.end()
		.element().from(3.0F, 16.0F, 10.0F).to(13.0F, 30.0F, 13.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(16.0F, 16.0F, 15.0F).end()
			.face(Direction.NORTH).uvs(3.0F, 2.0F, 13.0F, 16.0F).texture("#yellowstone_bricks").end()
			.face(Direction.EAST).uvs(3.0F, 2.0F, 6.0F, 16.0F).texture("#yellowstone_bricks").end()
			.face(Direction.SOUTH).uvs(3.0F, 2.0F, 13.0F, 16.0F).texture("#yellowstone_bricks").end()
			.face(Direction.WEST).uvs(10.0F, 2.0F, 13.0F, 16.0F).texture("#yellowstone_bricks").end()
			.face(Direction.UP).uvs(3.0F, 10.0F, 13.0F, 13.0F).texture("#yellowstone_bricks").end()
			.end()
		.element().from(3.0F, 16.0F, 3.0F).to(13.0F, 30.0F, 6.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(16.0F, 16.0F, 15.0F).end()
			.face(Direction.NORTH).uvs(3.0F, 2.0F, 13.0F, 16.0F).texture("#yellowstone_bricks").end()
			.face(Direction.EAST).uvs(10.0F, 2.0F, 13.0F, 16.0F).texture("#yellowstone_bricks").end()
			.face(Direction.SOUTH).uvs(3.0F, 2.0F, 13.0F, 16.0F).texture("#yellowstone_bricks").end()
			.face(Direction.WEST).uvs(3.0F, 2.0F, 6.0F, 16.0F).texture("#yellowstone_bricks").end()
			.face(Direction.UP).uvs(3.0F, 3.0F, 13.0F, 6.0F).texture("#yellowstone_bricks").end()
			.end()
		.element().from(10.0F, 16.0F, 6.0F).to(13.0F, 30.0F, 10.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(16.0F, 16.0F, 15.0F).end()
			.face(Direction.EAST).uvs(6.0F, 2.0F, 10.0F, 16.0F).texture("#yellowstone_bricks").end()
			.face(Direction.WEST).uvs(6.0F, 2.0F, 10.0F, 16.0F).texture("#yellowstone_bricks").end()
			.face(Direction.UP).uvs(10.0F, 6.0F, 13.0F, 10.0F).texture("#yellowstone_bricks").end()
			.end()
		.element().from(3.0F, 16.0F, 6.0F).to(6.0F, 30.0F, 10.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(16.0F, 16.0F, 15.0F).end()
			.face(Direction.EAST).uvs(6.0F, 2.0F, 10.0F, 16.0F).texture("#yellowstone_bricks").end()
			.face(Direction.WEST).uvs(6.0F, 2.0F, 10.0F, 16.0F).texture("#yellowstone_bricks").end()
			.face(Direction.UP).uvs(3.0F, 6.0F, 6.0F, 10.0F).texture("#yellowstone_bricks").end()
			.end()
		.element().from(3.0F, 21.0F, -1.0F).to(13.0F, 23.0F, 3.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(16.0F, 15.0F, 15.0F).end()
			.face(Direction.NORTH).uvs(3.0F, 8.0F, 13.0F, 10.0F).texture("#laurel_planks").end()
			.face(Direction.EAST).uvs(12.0F, 8.0F, 16.0F, 10.0F).rotation(ModelBuilder.FaceRotation.UPSIDE_DOWN).texture("#laurel_planks").end()
			.face(Direction.WEST).uvs(0.0F, 8.0F, 4.0F, 10.0F).texture("#laurel_planks").end()
			.face(Direction.UP).uvs(3.0F, 0.0F, 13.0F, 4.0F).texture("#laurel_planks").end()
			.face(Direction.DOWN).uvs(3.0F, 0.0F, 13.0F, 4.0F).rotation(ModelBuilder.FaceRotation.UPSIDE_DOWN).texture("#laurel_planks").end()
			.end()
		.element().from(4.0F, 23.0F, 0.75F).to(11.0F, 24.0F, 1.25F).rotation().angle(-22.5F).axis(Direction.Axis.Y).origin(8.5F, 40.0F, 1.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 8.0F, 7.0F, 9.0F).texture("#kiln").end()
			.face(Direction.SOUTH).uvs(0.0F, 8.0F, 7.0F, 9.0F).texture("#kiln").end()
			.face(Direction.WEST).uvs(0.0F, 8.0F, 1.0F, 9.0F).texture("#kiln").end()
			.face(Direction.UP).uvs(0.0F, 8.0F, 7.0F, 9.0F).texture("#kiln").end()
			.end()
		.element().from(11.0F, 23.0F, -0.75F).to(11.5F, 24.0F, 1.25F).rotation().angle(-22.5F).axis(Direction.Axis.Y).origin(8.5F, 40.0F, 1.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 8.0F, 1.0F, 9.0F).texture("#kiln").end()
			.face(Direction.EAST).uvs(0.0F, 8.0F, 2.0F, 9.0F).texture("#kiln").end()
			.face(Direction.SOUTH).uvs(0.0F, 8.0F, 1.0F, 9.0F).texture("#kiln").end()
			.face(Direction.WEST).uvs(0.0F, 8.0F, 2.0F, 9.0F).texture("#kiln").end()
			.face(Direction.UP).uvs(0.0F, 8.0F, 1.0F, 10.0F).texture("#kiln").end()
			.end()
		.element().from(13.0F, 19.0F, 5.0F).to(16.0F, 25.0F, 11.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(16.0F, 16.0F, 15.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 0.0F, 3.0F, 6.0F).texture("#kiln").end()
			.face(Direction.EAST).uvs(0.0F, 0.0F, 6.0F, 6.0F).texture("#kiln").end()
			.face(Direction.SOUTH).uvs(0.0F, 0.0F, 3.0F, 6.0F).texture("#kiln").end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 3.0F, 6.0F).texture("#kiln").end()
			.end()
		.element().from(10.875F, 13.875F, 5.0125F).to(13.875F, 18.125F, 10.9875F).rotation().angle(-45.0F).axis(Direction.Axis.Z).origin(16.0F, 16.0F, 15.0F).end()
			.face(Direction.NORTH).uvs(0.0F, 0.0F, 3.0F, 4.0F).texture("#kiln").end()
			.face(Direction.EAST).uvs(0.0F, 0.0F, 6.0F, 4.0F).texture("#kiln").end()
			.face(Direction.SOUTH).uvs(0.0F, 0.0F, 3.0F, 6.0F).texture("#kiln").end()
			.end()
		.element().from(1.0F, 0.0F, 1.0F).to(15.0F, 3.0F, 15.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(1.0F, 13.0F, 15.0F, 16.0F).texture("#yellowstone_bricks").end()
			.face(Direction.EAST).uvs(1.0F, 13.0F, 15.0F, 16.0F).texture("#yellowstone_bricks").end()
			.face(Direction.SOUTH).uvs(1.0F, 13.0F, 15.0F, 16.0F).texture("#yellowstone_bricks").end()
			.face(Direction.WEST).uvs(1.0F, 13.0F, 15.0F, 16.0F).texture("#yellowstone_bricks").end()
			.face(Direction.UP).uvs(1.0F, 1.0F, 15.0F, 15.0F).texture("#yellowstone_bricks").end()
			.face(Direction.DOWN).uvs(1.0F, 1.0F, 15.0F, 15.0F).rotation(ModelBuilder.FaceRotation.UPSIDE_DOWN).texture("#yellowstone_bricks").end()
			.end()
		.element().from(10.0F, 3.0F, 1.0F).to(15.0F, 8.0F, 15.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(1.0F, 8.0F, 6.0F, 13.0F).texture("#yellowstone_bricks").end()
			.face(Direction.EAST).uvs(1.0F, 8.0F, 15.0F, 13.0F).texture("#yellowstone_bricks").end()
			.face(Direction.SOUTH).uvs(10.0F, 8.0F, 15.0F, 13.0F).texture("#yellowstone_bricks").end()
			.face(Direction.WEST).uvs(1.0F, 8.0F, 15.0F, 13.0F).texture("#yellowstone_bricks").end()
			.face(Direction.UP).uvs(10.0F, 1.0F, 15.0F, 15.0F).texture("#yellowstone_bricks").end()
			.end()
		.element().from(1.0F, 3.0F, 1.0F).to(6.0F, 8.0F, 15.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(10.0F, 8.0F, 15.0F, 13.0F).texture("#yellowstone_bricks").end()
			.face(Direction.EAST).uvs(1.0F, 8.0F, 15.0F, 13.0F).texture("#yellowstone_bricks").end()
			.face(Direction.SOUTH).uvs(1.0F, 8.0F, 6.0F, 13.0F).texture("#yellowstone_bricks").end()
			.face(Direction.WEST).uvs(1.0F, 8.0F, 15.0F, 13.0F).texture("#yellowstone_bricks").end()
			.face(Direction.UP).uvs(1.0F, 1.0F, 6.0F, 15.0F).texture("#yellowstone_bricks").end()
			.end()
		.element().from(6.0F, 3.0F, 10.0F).to(10.0F, 8.0F, 15.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(6.0F, 8.0F, 10.0F, 13.0F).texture("#yellowstone_bricks").end()
			.end()
		.element().from(2.0F, 8.0F, 2.0F).to(14.0F, 10.0F, 14.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(2.0F, 0.0F, 14.0F, 2.0F).rotation(ModelBuilder.FaceRotation.UPSIDE_DOWN).texture("#loam_bricks").end()
			.face(Direction.EAST).uvs(14.0F, 6.0F, 2.0F, 4.0F).texture("#loam_bricks").end()
			.face(Direction.SOUTH).uvs(2.0F, 12.0F, 14.0F, 14.0F).texture("#loam_bricks").end()
			.face(Direction.WEST).uvs(0.0F, 2.0F, 2.0F, 14.0F).rotation(ModelBuilder.FaceRotation.COUNTERCLOCKWISE_90).texture("#loam_bricks").end()
			.face(Direction.UP).uvs(2.0F, 2.0F, 14.0F, 14.0F).texture("#loam_bricks").end()
			.face(Direction.DOWN).uvs(14.0F, 2.0F, 2.0F, 14.0F).rotation(ModelBuilder.FaceRotation.UPSIDE_DOWN).texture("#loam_bricks").end()
			.end()
		.element().from(10.0F, 10.0F, 2.0F).to(14.0F, 14.0F, 14.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(2.0F, 2.0F, 6.0F, 6.0F).texture("#yellowstone_bricks").end()
			.face(Direction.EAST).uvs(2.0F, 2.0F, 14.0F, 6.0F).texture("#yellowstone_bricks").end()
			.face(Direction.SOUTH).uvs(10.0F, 2.0F, 14.0F, 6.0F).texture("#yellowstone_bricks").end()
			.face(Direction.WEST).uvs(2.0F, 2.0F, 14.0F, 6.0F).texture("#yellowstone_bricks").end()
			.face(Direction.UP).uvs(10.0F, 2.0F, 14.0F, 14.0F).texture("#yellowstone_bricks").end()
			.end()
		.element().from(2.0F, 10.0F, 2.0F).to(6.0F, 14.0F, 14.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(10.0F, 2.0F, 14.0F, 6.0F).texture("#yellowstone_bricks").end()
			.face(Direction.EAST).uvs(2.0F, 2.0F, 14.0F, 6.0F).texture("#yellowstone_bricks").end()
			.face(Direction.SOUTH).uvs(2.0F, 2.0F, 6.0F, 6.0F).texture("#yellowstone_bricks").end()
			.face(Direction.WEST).uvs(2.0F, 2.0F, 14.0F, 6.0F).texture("#yellowstone_bricks").end()
			.face(Direction.UP).uvs(2.0F, 2.0F, 6.0F, 14.0F).texture("#yellowstone_bricks").end()
			.end()
		.element().from(6.0F, 10.0F, 10.0F).to(10.0F, 14.0F, 14.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(6.0F, 2.0F, 10.0F, 6.0F).texture("#yellowstone_bricks").end()
			.face(Direction.SOUTH).uvs(6.0F, 2.0F, 10.0F, 6.0F).texture("#yellowstone_bricks").end()
			.face(Direction.UP).uvs(6.0F, 10.0F, 10.0F, 14.0F).texture("#yellowstone_bricks").end()
			.end()
		.element().from(5.0F, 3.0F, 14.0F).to(11.0F, 9.0F, 16.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.EAST).uvs(0.0F, 0.0F, 2.0F, 6.0F).texture("#kiln").end()
			.face(Direction.SOUTH).uvs(0.0F, 0.0F, 6.0F, 6.0F).texture("#kiln").end()
			.face(Direction.WEST).uvs(0.0F, 0.0F, 2.0F, 6.0F).texture("#kiln").end()
			.face(Direction.UP).uvs(0.0F, 0.0F, 6.0F, 2.0F).texture("#kiln").end()
			.face(Direction.DOWN).uvs(0.0F, 0.0F, 6.0F, 2.0F).texture("#kiln").end()
			.end()
		.element().from(3.0F, 14.0F, 3.0F).to(13.0F, 16.0F, 6.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(3.0F, 0.0F, 13.0F, 2.0F).rotation(ModelBuilder.FaceRotation.UPSIDE_DOWN).texture("#loam_bricks").end()
			.face(Direction.EAST).uvs(0.0F, 0.0F, 3.0F, 2.0F).texture("#loam_bricks").end()
			.face(Direction.SOUTH).uvs(3.0F, 4.0F, 13.0F, 6.0F).texture("#loam_bricks").end()
			.face(Direction.WEST).uvs(0.0F, 3.0F, 2.0F, 6.0F).rotation(ModelBuilder.FaceRotation.COUNTERCLOCKWISE_90).texture("#loam_bricks").end()
			.face(Direction.DOWN).uvs(13.0F, 3.0F, 3.0F, 6.0F).rotation(ModelBuilder.FaceRotation.UPSIDE_DOWN).texture("#loam_bricks").end()
			.end()
		.element().from(3.0F, 14.0F, 10.0F).to(13.0F, 16.0F, 13.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.NORTH).uvs(3.0F, 8.0F, 13.0F, 10.0F).rotation(ModelBuilder.FaceRotation.UPSIDE_DOWN).texture("#loam_bricks").end()
			.face(Direction.EAST).uvs(0.0F, 10.0F, 2.0F, 13.0F).rotation(ModelBuilder.FaceRotation.CLOCKWISE_90).texture("#loam_bricks").end()
			.face(Direction.SOUTH).uvs(3.0F, 13.0F, 13.0F, 15.0F).texture("#loam_bricks").end()
			.face(Direction.WEST).uvs(10.0F, 9.0F, 13.0F, 11.0F).texture("#loam_bricks").end()
			.end()
		.element().from(10.0F, 14.0F, 6.0F).to(13.0F, 16.0F, 10.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.EAST).uvs(0.0F, 6.0F, 2.0F, 10.0F).rotation(ModelBuilder.FaceRotation.CLOCKWISE_90).texture("#loam_bricks").end()
			.face(Direction.WEST).uvs(6.0F, 0.0F, 10.0F, 2.0F).texture("#loam_bricks").end()
			.end()
		.element().from(3.0F, 14.0F, 6.0F).to(6.0F, 16.0F, 10.0F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(0.0F, 0.0F, 0.0F).end()
			.face(Direction.EAST).uvs(0.0F, 6.0F, 2.0F, 10.0F).rotation(ModelBuilder.FaceRotation.CLOCKWISE_90).texture("#loam_bricks").end()
			.face(Direction.WEST).uvs(0.0F, 6.0F, 2.0F, 10.0F).rotation(ModelBuilder.FaceRotation.COUNTERCLOCKWISE_90).texture("#loam_bricks").end()
			.end();
	}
}

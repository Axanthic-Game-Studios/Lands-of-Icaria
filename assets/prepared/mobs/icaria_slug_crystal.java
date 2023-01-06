// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports


public class icaria_slug_crystal<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "icaria_slug_crystal"), "main");
	private final ModelPart bone;
	private final ModelPart crystal_main_left;
	private final ModelPart crystal_rear_right;
	private final ModelPart bb_main;

	public icaria_slug_crystal(ModelPart root) {
		this.bone = root.getChild("bone");
		this.crystal_main_left = root.getChild("crystal_main_left");
		this.crystal_rear_right = root.getChild("crystal_rear_right");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 20).addBox(-3.5F, -5.0F, -6.0F, 7.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 24.0F, -12.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition bone2 = bone.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(0, 10).addBox(-3.0F, -5.0F, -5.0F, 6.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -6.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition crystal_neck = bone2.addOrReplaceChild("crystal_neck", CubeListBuilder.create(), PartPose.offset(-3.5F, -5.0F, 0.0F));

		PartDefinition north_r1 = crystal_neck.addOrReplaceChild("north_r1", CubeListBuilder.create().texOffs(0, 38).addBox(-0.5F, -3.5F, -5.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3927F, -0.3927F, -0.0873F));

		PartDefinition west_r1 = crystal_neck.addOrReplaceChild("west_r1", CubeListBuilder.create().texOffs(12, 37).addBox(3.5F, -1.0F, -2.5F, 3.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1963F, 0.0873F, 0.0F));

		PartDefinition south_r1 = crystal_neck.addOrReplaceChild("south_r1", CubeListBuilder.create().texOffs(0, 52).addBox(0.5F, -1.0F, -0.5F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3927F, 0.0873F, 0.0F));

		PartDefinition east_r1 = crystal_neck.addOrReplaceChild("east_r1", CubeListBuilder.create().texOffs(18, 52).addBox(-1.5F, 0.0F, -4.5F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0873F, -0.0873F, -0.3927F));

		PartDefinition main_r1 = crystal_neck.addOrReplaceChild("main_r1", CubeListBuilder.create().texOffs(0, 44).addBox(-0.5F, -1.0F, -4.0F, 5.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.0873F, -0.1963F));

		PartDefinition bone3 = bone2.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -5.0F, -5.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition bone5 = bone3.addOrReplaceChild("bone5", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition bottom_feeler_left_r1 = bone5.addOrReplaceChild("bottom_feeler_left_r1", CubeListBuilder.create().texOffs(20, 20).addBox(-0.75F, -0.25F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, -0.5F, 0.1963F, 0.0F, -0.1963F));

		PartDefinition bottom_feeler_right_r1 = bone5.addOrReplaceChild("bottom_feeler_right_r1", CubeListBuilder.create().texOffs(20, 20).addBox(-0.25F, -0.75F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, -0.5F, 0.1963F, 0.0F, 0.1963F));

		PartDefinition bone4 = bone3.addOrReplaceChild("bone4", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -5.0F));

		PartDefinition eye_left_r1 = bone4.addOrReplaceChild("eye_left_r1", CubeListBuilder.create().texOffs(28, 0).addBox(-1.0F, -0.7F, -7.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(20, 0).addBox(-0.5F, -0.2F, -5.75F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -1.0F, 0.0F, 0.2618F, 0.0F, -0.7854F));

		PartDefinition eye_right_r1 = bone4.addOrReplaceChild("eye_right_r1", CubeListBuilder.create().texOffs(15, 0).addBox(-1.0F, -0.7F, -6.75F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(21, 1).addBox(-0.5F, -0.2F, -4.75F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -1.0F, 0.0F, 0.2618F, 0.0F, 0.7854F));

		PartDefinition crystal_main_left = partdefinition.addOrReplaceChild("crystal_main_left", CubeListBuilder.create(), PartPose.offset(4.0F, 19.0F, -3.0F));

		PartDefinition north_r2 = crystal_main_left.addOrReplaceChild("north_r2", CubeListBuilder.create().texOffs(64, 0).addBox(-2.5F, -2.25F, -5.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.3927F));

		PartDefinition west_r2 = crystal_main_left.addOrReplaceChild("west_r2", CubeListBuilder.create().texOffs(46, 0).addBox(0.0F, -0.5F, -1.0F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.3927F, 0.3927F));

		PartDefinition south_r2 = crystal_main_left.addOrReplaceChild("south_r2", CubeListBuilder.create().texOffs(64, 17).addBox(-4.5F, -3.25F, 0.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.3927F));

		PartDefinition east_r2 = crystal_main_left.addOrReplaceChild("east_r2", CubeListBuilder.create().texOffs(48, 17).addBox(-5.0F, -2.35F, -2.75F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition main_r2 = crystal_main_left.addOrReplaceChild("main_r2", CubeListBuilder.create().texOffs(56, 7).addBox(-4.0F, -1.0F, -3.0F, 6.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition crystal_rear_right = partdefinition.addOrReplaceChild("crystal_rear_right", CubeListBuilder.create(), PartPose.offset(-3.5F, 20.0F, 10.0F));

		PartDefinition west_r3 = crystal_rear_right.addOrReplaceChild("west_r3", CubeListBuilder.create().texOffs(62, 37).addBox(2.5F, -0.88F, 1.0F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0654F, 0.0654F, 0.2182F));

		PartDefinition south_r3 = crystal_rear_right.addOrReplaceChild("south_r3", CubeListBuilder.create().texOffs(72, 39).addBox(0.5F, -0.9F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0218F, -0.7854F, 0.1745F));

		PartDefinition south_r4 = crystal_rear_right.addOrReplaceChild("south_r4", CubeListBuilder.create().texOffs(68, 51).addBox(0.5F, -0.9F, 4.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0218F, 0.1963F, 0.1745F));

		PartDefinition east_r3 = crystal_rear_right.addOrReplaceChild("east_r3", CubeListBuilder.create().texOffs(56, 51).addBox(-2.0F, 1.1F, 1.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0218F, 0.1963F, -0.0873F));

		PartDefinition main_r3 = crystal_rear_right.addOrReplaceChild("main_r3", CubeListBuilder.create().texOffs(60, 43).addBox(-1.0F, -1.0F, 0.1F, 5.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1963F, 0.0F, -0.0873F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 59).addBox(-4.0F, -5.0F, -12.0F, 8.0F, 5.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(32, 61).addBox(-3.5F, -4.0F, 4.0F, 7.0F, 4.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(56, 62).addBox(-3.0F, -3.0F, 14.0F, 6.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(62, 74).addBox(-2.5F, -2.0F, 20.0F, 5.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 80, 80);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		crystal_main_left.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		crystal_rear_right.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
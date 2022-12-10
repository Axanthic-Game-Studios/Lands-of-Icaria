// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports


public class icaria_arachne_drone<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "icaria_arachne_drone"), "main");
	private final ModelPart bone;
	private final ModelPart bone2;
	private final ModelPart leg_left_front;
	private final ModelPart leg_left_middle;
	private final ModelPart leg_left_rear;
	private final ModelPart leg_right_front;
	private final ModelPart leg_right_middle;
	private final ModelPart leg_right_rear;
	private final ModelPart bone9;
	private final ModelPart bb_main;

	public icaria_arachne_drone(ModelPart root) {
		this.bone = root.getChild("bone");
		this.bone2 = root.getChild("bone2");
		this.leg_left_front = root.getChild("leg_left_front");
		this.leg_left_middle = root.getChild("leg_left_middle");
		this.leg_left_rear = root.getChild("leg_left_rear");
		this.leg_right_front = root.getChild("leg_right_front");
		this.leg_right_middle = root.getChild("leg_right_middle");
		this.leg_right_rear = root.getChild("leg_right_rear");
		this.bone9 = root.getChild("bone9");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(132, 136).addBox(-5.0F, 2.0F, 1.0F, 10.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, 2.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition tail_rear_r1 = bone.addOrReplaceChild("tail_rear_r1", CubeListBuilder.create().texOffs(146, 48).addBox(-2.0F, -3.75F, -1.25F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.5F, 28.5F, -0.7854F, 0.0F, 0.0F));

		PartDefinition tail_mid_r1 = bone.addOrReplaceChild("tail_mid_r1", CubeListBuilder.create().texOffs(142, 55).addBox(-3.0F, -4.5F, 0.25F, 6.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.5F, 26.0F, -0.6109F, 0.0F, 0.0F));

		PartDefinition tail_front_r1 = bone.addOrReplaceChild("tail_front_r1", CubeListBuilder.create().texOffs(136, 63).addBox(-4.0F, -6.0F, -1.0F, 8.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.5F, 24.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition body_rear_end_r1 = bone.addOrReplaceChild("body_rear_end_r1", CubeListBuilder.create().texOffs(130, 73).addBox(-5.0F, -8.0F, -1.0F, 10.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.0F, 20.5F, -0.2182F, 0.0F, 0.0F));

		PartDefinition body_rear_back_r1 = bone.addOrReplaceChild("body_rear_back_r1", CubeListBuilder.create().texOffs(124, 86).addBox(-6.0F, -10.0F, -1.0F, 12.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 10.5F, 15.75F, -0.1309F, 0.0F, 0.0F));

		PartDefinition body_rear_center_r1 = bone.addOrReplaceChild("body_rear_center_r1", CubeListBuilder.create().texOffs(120, 102).addBox(-7.0F, -12.0F, 0.0F, 14.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 12.0F, 10.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition body_rear_front_r1 = bone.addOrReplaceChild("body_rear_front_r1", CubeListBuilder.create().texOffs(124, 120).addBox(-6.0F, -10.0F, 0.0F, 12.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 11.0F, 5.0F, -0.0436F, 0.0F, 0.0F));

		PartDefinition bone5 = bone.addOrReplaceChild("bone5", CubeListBuilder.create().texOffs(148, 0).addBox(-1.5F, -3.0F, -0.75F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.25F, 29.25F, -1.0036F, 0.0F, 0.0F));

		PartDefinition bone6 = bone5.addOrReplaceChild("bone6", CubeListBuilder.create().texOffs(150, 6).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 1.75F, -0.1745F, 0.0F, 0.0F));

		PartDefinition bone7 = bone6.addOrReplaceChild("bone7", CubeListBuilder.create(), PartPose.offset(0.0F, -0.5F, 3.0F));

		PartDefinition stinger_tip_r1 = bone7.addOrReplaceChild("stinger_tip_r1", CubeListBuilder.create().texOffs(154, 11).addBox(-0.5F, -1.0F, -0.25F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition bone2 = partdefinition.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(6, 0).addBox(-4.5F, -4.0F, -7.0F, 9.0F, 5.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(0, 27).addBox(-4.5F, -5.0F, -4.0F, 9.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 31.0F, -7.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition jaw_right_r1 = bone2.addOrReplaceChild("jaw_right_r1", CubeListBuilder.create().texOffs(12, 12).addBox(-2.5F, -4.0F, -0.25F, 3.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -4.0F, -7.0F, 0.3927F, 0.0F, -0.1309F));

		PartDefinition jaw_left_r1 = bone2.addOrReplaceChild("jaw_left_r1", CubeListBuilder.create().texOffs(22, 12).addBox(-0.5F, -4.5F, -0.25F, 3.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -4.0F, -7.0F, 0.3927F, 0.0F, 0.1309F));

		PartDefinition bone8 = bone2.addOrReplaceChild("bone8", CubeListBuilder.create().texOffs(38, 7).addBox(4.0F, 19.5F, -7.5F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(35, 3).addBox(3.0F, 19.75F, -10.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(31, 0).addBox(0.5F, 20.5F, -10.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(31, 5).addBox(2.75F, 22.5F, -9.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 7).addBox(-5.0F, 19.25F, -7.5F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1, 3).addBox(-5.0F, 20.0F, -10.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(7, 0).addBox(-2.5F, 20.75F, -10.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(9, 5).addBox(-3.5F, 22.5F, -9.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -22.0F, 3.0F));

		PartDefinition bone3 = bone2.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(32, 12).addBox(-2.0F, -2.6F, -4.5F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -3.0F, -4.0F, 0.7854F, -0.576F, 0.0F));

		PartDefinition biter_left_front_r1 = bone3.addOrReplaceChild("biter_left_front_r1", CubeListBuilder.create().texOffs(30, 19).addBox(-2.75F, 0.5F, -8.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -3.5F, 1.5F, 0.0F, 0.0F, -0.7854F));

		PartDefinition bone4 = bone2.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(0, 14).addBox(0.0F, -2.6F, -4.5F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -3.0F, -4.0F, 0.7854F, 0.576F, 0.0F));

		PartDefinition biter_left_front_r2 = bone4.addOrReplaceChild("biter_left_front_r2", CubeListBuilder.create().texOffs(0, 21).addBox(-2.25F, 0.5F, -8.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -3.5F, 1.5F, 0.0F, 0.0F, 0.6981F));

		PartDefinition leg_left_front = partdefinition.addOrReplaceChild("leg_left_front", CubeListBuilder.create().texOffs(0, 130).addBox(-1.5F, 0.0F, -0.5F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(38, 105).addBox(11.5F, -3.0F, -0.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 9.0F, 0.0F, -0.2618F, 0.576F, -0.3927F));

		PartDefinition foot_r1 = leg_left_front.addOrReplaceChild("foot_r1", CubeListBuilder.create().texOffs(76, 135).addBox(-1.0F, -12.25F, -1.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.0F, -1.5F, 1.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition leg_left_middle = partdefinition.addOrReplaceChild("leg_left_middle", CubeListBuilder.create().texOffs(0, 136).addBox(-1.5F, 1.0F, -0.5F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(47, 110).addBox(11.5F, -3.0F, -0.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 8.0F, 2.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition foot_r2 = leg_left_middle.addOrReplaceChild("foot_r2", CubeListBuilder.create().texOffs(68, 135).addBox(-0.75F, -12.9F, -1.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.0F, -0.5F, 1.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition leg_left_rear = partdefinition.addOrReplaceChild("leg_left_rear", CubeListBuilder.create().texOffs(0, 142).addBox(-2.0F, -1.0F, -0.5F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(38, 115).addBox(11.0F, -6.0F, -0.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 10.0F, 4.0F, 0.1745F, -0.576F, -0.3927F));

		PartDefinition foot_r3 = leg_left_rear.addOrReplaceChild("foot_r3", CubeListBuilder.create().texOffs(60, 137).addBox(-0.75F, -12.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.0F, -2.5F, 1.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition leg_right_front = partdefinition.addOrReplaceChild("leg_right_front", CubeListBuilder.create().texOffs(0, 105).addBox(-14.5F, 0.0F, -0.5F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(38, 129).addBox(-14.5F, -4.0F, -0.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 9.0F, 0.0F, -0.2618F, -0.576F, 0.3927F));

		PartDefinition foot_r4 = leg_right_front.addOrReplaceChild("foot_r4", CubeListBuilder.create().texOffs(76, 110).addBox(-2.5F, -11.95F, -1.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, -1.5F, 1.0F, 0.0F, 0.0F, -0.2618F));

		PartDefinition leg_right_middle = partdefinition.addOrReplaceChild("leg_right_middle", CubeListBuilder.create().texOffs(0, 111).addBox(-14.5F, 1.0F, -0.5F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(47, 136).addBox(-14.5F, -2.0F, -0.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 8.0F, 2.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition foot_r5 = leg_right_middle.addOrReplaceChild("foot_r5", CubeListBuilder.create().texOffs(68, 109).addBox(-2.0F, -12.8F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, -0.5F, 1.0F, 0.0F, 0.0F, -0.2618F));

		PartDefinition leg_right_rear = partdefinition.addOrReplaceChild("leg_right_rear", CubeListBuilder.create().texOffs(0, 117).addBox(-14.0F, -1.0F, -0.5F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(38, 141).addBox(-14.0F, -5.0F, -0.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 10.0F, 4.0F, 0.1745F, 0.576F, 0.3927F));

		PartDefinition foot_r6 = leg_right_rear.addOrReplaceChild("foot_r6", CubeListBuilder.create().texOffs(60, 110).addBox(-2.25F, -11.9F, -1.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, -2.5F, 1.0F, 0.0F, 0.0F, -0.2618F));

		PartDefinition bone9 = partdefinition.addOrReplaceChild("bone9", CubeListBuilder.create().texOffs(114, 151).addBox(-3.5F, -1.0F, -3.0F, 7.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 10.5F, -2.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition bone10 = bone9.addOrReplaceChild("bone10", CubeListBuilder.create().texOffs(86, 150).addBox(-4.0F, 0.0F, -6.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, -3.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition bone11 = bone10.addOrReplaceChild("bone11", CubeListBuilder.create().texOffs(54, 150).addBox(-5.0F, 0.25F, -6.0F, 10.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -6.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition bone12 = bone11.addOrReplaceChild("bone12", CubeListBuilder.create().texOffs(14, 148).addBox(-7.0F, -0.75F, -6.0F, 14.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.25F, -6.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition leg_right_middle2 = bone12.addOrReplaceChild("leg_right_middle2", CubeListBuilder.create().texOffs(10, 99).addBox(-12.5F, -1.0F, -0.5F, 11.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(47, 124).addBox(-12.5F, -4.0F, -0.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 0.75F, -4.0F, 0.3927F, 0.0F, 0.3927F));

		PartDefinition foot_r7 = leg_right_middle2.addOrReplaceChild("foot_r7", CubeListBuilder.create().texOffs(84, 109).addBox(0.0F, -11.3F, 0.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, -4.0F, 0.0F, 0.0436F, 0.0F, -0.2618F));

		PartDefinition leg_left_middle2 = bone12.addOrReplaceChild("leg_left_middle2", CubeListBuilder.create().texOffs(10, 124).addBox(1.5F, -1.0F, -0.5F, 11.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(47, 98).addBox(9.5F, -5.0F, -0.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.75F, -4.0F, 0.3927F, 0.0F, -0.3927F));

		PartDefinition foot_r8 = leg_left_middle2.addOrReplaceChild("foot_r8", CubeListBuilder.create().texOffs(84, 135).addBox(-1.75F, -11.4F, 0.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0F, -4.0F, 0.0F, 0.0436F, 0.0F, 0.2618F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(136, 148).addBox(-3.0F, 9.0F, -2.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 160, 160);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg_left_front.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg_left_middle.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg_left_rear.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg_right_front.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg_right_middle.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg_right_rear.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone9.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
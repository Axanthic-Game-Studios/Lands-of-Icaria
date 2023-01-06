// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports


public class icaria_wretch<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "icaria_wretch"), "main");
	private final ModelPart body;

	public icaria_wretch(ModelPart root) {
		this.body = root.getChild("body");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, 0.0F, -2.5F, 12.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.9F, 0.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition lower_body = body.addOrReplaceChild("lower_body", CubeListBuilder.create().texOffs(34, 0).addBox(-3.0F, 0.0F, -2.0F, 6.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.8F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition hip = lower_body.addOrReplaceChild("hip", CubeListBuilder.create().texOffs(0, 20).addBox(-2.0F, 1.0F, -1.5F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.8F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition leg_right = hip.addOrReplaceChild("leg_right", CubeListBuilder.create().texOffs(55, 17).addBox(-1.0F, -0.4F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 5.1F, 0.0F, -0.7854F, 0.0F, 0.0524F));

		PartDefinition leg_right_1 = leg_right.addOrReplaceChild("leg_right_1", CubeListBuilder.create().texOffs(70, 0).addBox(-1.0F, -0.4F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.5F, -0.2F, 0.576F, 0.0F, -0.0524F));

		PartDefinition leg_left = hip.addOrReplaceChild("leg_left", CubeListBuilder.create().texOffs(14, 20).mirror().addBox(-1.0F, -0.4F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, 5.1F, 0.0F, -0.7854F, 0.0F, -0.0524F));

		PartDefinition leg_left_1 = leg_left.addOrReplaceChild("leg_left_1", CubeListBuilder.create().texOffs(22, 20).addBox(-1.0F, -0.4F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.5F, -0.2F, 0.576F, 0.0F, 0.0524F));

		PartDefinition leg_protecc = leg_left_1.addOrReplaceChild("leg_protecc", CubeListBuilder.create().texOffs(30, 21).addBox(-1.5F, -2.9F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.2F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition arm_left = body.addOrReplaceChild("arm_left", CubeListBuilder.create().texOffs(62, 0).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 15.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.0F, 0.5F, 0.0F, 0.0F, 0.0F, -0.1745F));

		PartDefinition arm_left_1 = arm_left.addOrReplaceChild("arm_left_1", CubeListBuilder.create().texOffs(30, 29).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 15.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 14.7F, 0.0F, -0.0911F, 0.0F, 0.1745F));

		PartDefinition arm_right = body.addOrReplaceChild("arm_right", CubeListBuilder.create().texOffs(54, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 15.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, 0.5F, 0.0F, 0.0F, 0.0F, 0.1745F));

		PartDefinition arm_right_1 = arm_right.addOrReplaceChild("arm_right_1", CubeListBuilder.create().texOffs(42, 21).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 15.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 14.9F, 0.0F, -0.0911F, 0.0F, -0.1745F));

		PartDefinition arm_protecc = arm_right_1.addOrReplaceChild("arm_protecc", CubeListBuilder.create().texOffs(0, 27).addBox(-1.5F, -0.5F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.5F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition chestplate = body.addOrReplaceChild("chestplate", CubeListBuilder.create().texOffs(0, 9).addBox(-6.5F, 0.0F, -3.0F, 9.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.5F, 0.0F));

		PartDefinition spear = chestplate.addOrReplaceChild("spear", CubeListBuilder.create().texOffs(35, 62).addBox(-0.5F, -3.5F, -7.0F, 1.0F, 1.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 5.9F, 0.0F, 0.1745F, 0.3187F, 0.0F));

		PartDefinition speartip_1 = spear.addOrReplaceChild("speartip_1", CubeListBuilder.create().texOffs(54, 73).addBox(0.0F, -1.5F, -1.5F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, -7.0F, 0.7854F, 0.0F, 1.5708F));

		PartDefinition speartip = spear.addOrReplaceChild("speartip", CubeListBuilder.create().texOffs(54, 73).addBox(0.0F, -1.5F, -1.5F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, -7.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition chestplate_1 = chestplate.addOrReplaceChild("chestplate_1", CubeListBuilder.create().texOffs(38, 39).addBox(-4.0F, -4.4F, -3.0F, 8.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 9.4F, 0.5F));

		PartDefinition chestplate_side = chestplate.addOrReplaceChild("chestplate_side", CubeListBuilder.create().texOffs(6, 32).addBox(3.0F, 0.0F, -3.0F, 3.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 3.0F, 0.0F));

		PartDefinition chestplate_tear = chestplate_side.addOrReplaceChild("chestplate_tear", CubeListBuilder.create().texOffs(62, 33).addBox(3.0F, 0.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 0.0F));

		PartDefinition strap = chestplate.addOrReplaceChild("strap", CubeListBuilder.create().texOffs(50, 29).addBox(-5.0F, 0.0F, -3.5F, 2.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition bagstrap = body.addOrReplaceChild("bagstrap", CubeListBuilder.create().texOffs(63, 10).addBox(-0.5F, 0.0F, -3.5F, 1.0F, 15.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, -1.0F, 0.0F, 0.0F, 0.0F, -0.5236F));

		PartDefinition bag = bagstrap.addOrReplaceChild("bag", CubeListBuilder.create().texOffs(28, 62).addBox(-1.0F, -0.25F, -4.0F, 3.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 14.4F, 0.0F, 0.0F, 0.0F, 0.5236F));

		PartDefinition shoulderpad = body.addOrReplaceChild("shoulderpad", CubeListBuilder.create().texOffs(31, 10).addBox(3.0F, 0.0F, -3.5F, 5.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, 0.0F));

		PartDefinition shoulderpad_side = shoulderpad.addOrReplaceChild("shoulderpad_side", CubeListBuilder.create().texOffs(54, 56).addBox(-1.0F, -0.5F, -3.0F, 5.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 1.9F, 0.0F, 0.0F, 0.0F, 1.0472F));

		PartDefinition neck = body.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(24, 10).addBox(-2.0F, 0.0F, -1.5F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition jaw = neck.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(0, 40).addBox(-3.5F, -8.0F, -3.5F, 7.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.5F, 0.0F, 0.0911F, 0.0F, 0.1396F));

		PartDefinition head = jaw.addOrReplaceChild("head", CubeListBuilder.create().texOffs(28, 46).addBox(-4.0F, -9.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.8F, 0.1F, 0.0349F, 0.0F, 0.0F));

		PartDefinition hat = head.addOrReplaceChild("hat", CubeListBuilder.create().texOffs(0, 55).addBox(-5.5F, -8.0F, -5.5F, 9.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3F, -2.5F, 0.3F, -0.0873F, 0.0F, 0.0873F));

		return LayerDefinition.create(meshdefinition, 80, 80);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
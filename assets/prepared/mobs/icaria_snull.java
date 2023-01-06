// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports


public class icaria_snull<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "icaria_snull"), "main");
	private final ModelPart skull;
	private final ModelPart body_rear;
	private final ModelPart neck;
	private final ModelPart bb_main;

	public icaria_snull(ModelPart root) {
		this.skull = root.getChild("skull");
		this.body_rear = root.getChild("body_rear");
		this.neck = root.getChild("neck");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition skull = partdefinition.addOrReplaceChild("skull", CubeListBuilder.create().texOffs(68, 0).addBox(-3.5F, 0.6F, -5.0F, 7.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, 5.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition body_in_skull_r1 = skull.addOrReplaceChild("body_in_skull_r1", CubeListBuilder.create().texOffs(78, 15).addBox(-2.0F, 2.0F, 1.5F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, -5.0F, -0.0436F, 0.0F, 0.0F));

		PartDefinition jaw_bottom_r1 = skull.addOrReplaceChild("jaw_bottom_r1", CubeListBuilder.create().texOffs(70, 8).addBox(-2.5F, -0.65F, -5.95F, 5.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.8F, 0.1745F, 0.0F, -0.0175F));

		PartDefinition jaw_top_r1 = skull.addOrReplaceChild("jaw_top_r1", CubeListBuilder.create().texOffs(70, 7).addBox(-2.5F, -0.9F, -6.05F, 5.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.6F, 1.8F, 0.0F, 0.0F, 0.0175F));

		PartDefinition feelers2 = skull.addOrReplaceChild("feelers2", CubeListBuilder.create(), PartPose.offset(0.0F, -4.0F, -18.0F));

		PartDefinition eye_left_r1 = feelers2.addOrReplaceChild("eye_left_r1", CubeListBuilder.create().texOffs(14, 0).addBox(-2.0F, -0.4F, -6.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 5.5F, 13.0F, -0.2618F, -0.1745F, 0.0F));

		PartDefinition feeler_left_r1 = feelers2.addOrReplaceChild("feeler_left_r1", CubeListBuilder.create().texOffs(19, 1).addBox(-0.5F, 0.1F, -4.5F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 5.5F, 13.0F, -0.2618F, -0.1745F, 0.0F));

		PartDefinition eye_right_r1 = feelers2.addOrReplaceChild("eye_right_r1", CubeListBuilder.create().texOffs(14, 0).addBox(-1.0F, -0.45F, -7.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(18, 0).addBox(-0.5F, 0.05F, -5.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 5.5F, 13.0F, -0.2618F, 0.1745F, 0.0F));

		PartDefinition body_rear = partdefinition.addOrReplaceChild("body_rear", CubeListBuilder.create().texOffs(0, 42).addBox(-2.6F, 0.0F, 0.0F, 5.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(26, 0).addBox(-1.6F, 2.5F, 4.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 5.0F));

		PartDefinition tail = body_rear.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 35).addBox(-1.9F, 0.0F, 0.0F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 7.0F));

		PartDefinition neck = partdefinition.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(0, 29).addBox(-2.95F, 0.0F, -2.0F, 6.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -3.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition bone = neck.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 21).addBox(-2.6F, 0.0F, -4.0F, 5.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition bone2 = bone.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(0, 42).addBox(-2.95F, 1.0F, -3.5F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 13).addBox(-2.55F, 0.0F, -4.0F, 5.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -4.0F, -0.5236F, 0.0F, 0.0F));

		PartDefinition neccc_sack_r1 = bone2.addOrReplaceChild("neccc_sack_r1", CubeListBuilder.create().texOffs(18, 7).addBox(-1.8F, -0.25F, -0.75F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 0.5F, -1.5F, 0.1309F, -0.0873F, 0.6109F));

		PartDefinition head = bone2.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, 0.0F, -4.0F, 5.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(26, 0).addBox(-1.5F, 3.5F, -3.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -4.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition jaw_sack_r1 = head.addOrReplaceChild("jaw_sack_r1", CubeListBuilder.create().texOffs(0, 8).addBox(-3.15F, 0.25F, -0.5F, 5.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, -0.3491F, 0.3054F, 0.0305F));

		PartDefinition feelers = head.addOrReplaceChild("feelers", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition eye_left_r2 = feelers.addOrReplaceChild("eye_left_r2", CubeListBuilder.create().texOffs(14, 0).addBox(-1.0F, -0.7F, -6.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(19, 1).addBox(-0.5F, -0.2F, -4.5F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.5F, -4.0F, 0.2618F, 0.0F, -0.7854F));

		PartDefinition eye_right_r2 = feelers.addOrReplaceChild("eye_right_r2", CubeListBuilder.create().texOffs(14, 0).addBox(-1.0F, -0.7F, -7.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(18, 0).addBox(-0.5F, -0.2F, -5.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.5F, -4.0F, 0.2618F, 0.0F, 0.7854F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 52).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 42).addBox(-3.5F, 1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(26, 0).addBox(-0.5F, 3.5F, -2.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 42).addBox(2.5F, 1.0F, 2.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 96, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		skull.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body_rear.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		neck.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
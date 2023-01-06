// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports


public class icaria_greek_ghast<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "icaria_greek_ghast"), "main");
	private final ModelPart bb_main;

	public icaria_greek_ghast(ModelPart root) {
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(-7.5F, -24.0F, -8.0F, 15.0F, 8.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(24, 67).addBox(-1.5F, -25.0F, -9.0F, 3.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 37).addBox(-1.5F, -25.0F, -8.0F, 3.0F, 2.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(31, 20).addBox(-6.75F, -16.0F, -1.0F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(25, 41).addBox(-7.0F, -16.0F, -4.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 25).addBox(-6.75F, -16.0F, -6.75F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(31, 25).addBox(-4.0F, -16.5F, -7.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 20).addBox(0.0F, -16.0F, -7.25F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(5, 0).addBox(3.0F, -16.0F, -7.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 6).addBox(4.75F, -16.0F, -6.75F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(6.0F, -16.0F, -4.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(39, 20).addBox(5.75F, -16.5F, 0.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition tentacle_r1 = bb_main.addOrReplaceChild("tentacle_r1", CubeListBuilder.create().texOffs(0, 62).addBox(-1.0F, 0.0F, -2.0F, 3.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.0F, 10.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition tentacle_r2 = bb_main.addOrReplaceChild("tentacle_r2", CubeListBuilder.create().texOffs(0, 37).addBox(-0.5F, 0.0F, -2.0F, 3.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -13.0F, 7.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition tentacle_r3 = bb_main.addOrReplaceChild("tentacle_r3", CubeListBuilder.create().texOffs(54, 23).addBox(-1.0F, 0.0F, -2.0F, 3.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -12.5F, 0.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition tentacle_r4 = bb_main.addOrReplaceChild("tentacle_r4", CubeListBuilder.create().texOffs(12, 62).addBox(-2.0F, 0.0F, -1.0F, 3.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -13.0F, 1.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition tentacle_r5 = bb_main.addOrReplaceChild("tentacle_r5", CubeListBuilder.create().texOffs(66, 23).addBox(-1.5F, 0.0F, -1.0F, 3.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -12.0F, 5.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition lower_jaw_r1 = bb_main.addOrReplaceChild("lower_jaw_r1", CubeListBuilder.create().texOffs(0, 52).addBox(-6.0F, 2.5F, -8.0F, 6.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.0F, 2.0F, 0.3927F, 0.0F, 0.1745F));

		PartDefinition tentacle_r6 = bb_main.addOrReplaceChild("tentacle_r6", CubeListBuilder.create().texOffs(62, 43).addBox(-2.0F, 0.0F, -1.0F, 3.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition back_r1 = bb_main.addOrReplaceChild("back_r1", CubeListBuilder.create().texOffs(30, 25).addBox(-1.49F, 0.0F, 0.0F, 3.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -25.0F, 5.0F, -1.0472F, 0.0F, 0.0F));

		PartDefinition body_r1 = bb_main.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(38, 43).addBox(-4.0F, -8.0F, 2.8F, 8.0F, 15.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 20).addBox(-5.0F, -6.0F, -6.0F, 10.0F, 6.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.0F, 2.0F, -1.1781F, 0.0F, 0.0F));

		PartDefinition lower_jaw_r2 = bb_main.addOrReplaceChild("lower_jaw_r2", CubeListBuilder.create().texOffs(46, 12).addBox(0.0F, 2.0F, -8.0F, 6.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.0F, 2.0F, 0.3927F, 0.0F, -0.1745F));

		PartDefinition upper_jaw_r1 = bb_main.addOrReplaceChild("upper_jaw_r1", CubeListBuilder.create().texOffs(42, 0).addBox(-6.0F, -0.6F, -4.5F, 12.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.0F, -1.5F, 0.0F, 0.0F, 0.0873F));

		return LayerDefinition.create(meshdefinition, 96, 96);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
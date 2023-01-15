// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports


public class icaria_crocotta<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "icaria_crocotta"), "main");
	private final ModelPart bone;
	private final ModelPart bone3;
	private final ModelPart bb_main;

	public icaria_crocotta(ModelPart root) {
		this.bone = root.getChild("bone");
		this.bone3 = root.getChild("bone3");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(15, 68).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, 3.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition bone12 = bone.addOrReplaceChild("bone12", CubeListBuilder.create().texOffs(66, 64).addBox(-2.5F, 0.0F, 0.0F, 5.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 4.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition bone13 = bone12.addOrReplaceChild("bone13", CubeListBuilder.create().texOffs(66, 72).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.5F, 2.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r1 = bone13.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(69, 77).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 4.0F, -0.1963F, 0.0F, 0.0F));

		PartDefinition bone2 = bone.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(35, 70).addBox(-4.0F, 0.75F, -1.25F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(1, 70).addBox(1.0F, 0.75F, -1.25F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 2.0F, 0.0436F, 0.0F, 0.0F));

		PartDefinition bone15 = bone2.addOrReplaceChild("bone15", CubeListBuilder.create().texOffs(38, 60).addBox(-3.5F, -0.5F, -0.5F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(4, 60).addBox(1.5F, -0.5F, -0.5F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, 0.2182F, 0.0F, 0.0F));

		PartDefinition bone17 = bone15.addOrReplaceChild("bone17", CubeListBuilder.create().texOffs(38, 55).addBox(-4.0F, -1.15F, -1.75F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 55).addBox(1.0F, -1.15F, -1.75F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition bone3 = partdefinition.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(14, 40).addBox(-3.0F, -9.0F, -5.0F, 6.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.25F, -3.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition bone4 = bone3.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(36, 42).addBox(-4.0F, 0.0F, -3.0F, 3.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 42).addBox(1.0F, 0.0F, -3.0F, 3.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.25F, -3.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition bone14 = bone4.addOrReplaceChild("bone14", CubeListBuilder.create().texOffs(34, 32).addBox(-3.5F, 0.0F, -2.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(8, 32).addBox(1.5F, 0.0F, -2.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition bone16 = bone14.addOrReplaceChild("bone16", CubeListBuilder.create().texOffs(30, 27).addBox(-4.0F, -0.5F, -3.25F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(8, 27).addBox(1.0F, -0.5F, -3.25F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.0436F, 0.0F, 0.0F));

		PartDefinition bone5 = bone3.addOrReplaceChild("bone5", CubeListBuilder.create().texOffs(16, 30).addBox(-2.5F, -6.0F, -3.0F, 5.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.25F, -5.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition bone10 = bone5.addOrReplaceChild("bone10", CubeListBuilder.create().texOffs(66, 9).addBox(-0.5F, -8.0F, -3.0F, 1.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition back = bone10.addOrReplaceChild("back", CubeListBuilder.create(), PartPose.offset(0.0F, -8.0F, 3.0F));

		PartDefinition brush_back_r1 = back.addOrReplaceChild("brush_back_r1", CubeListBuilder.create().texOffs(67, 18).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition front = bone10.addOrReplaceChild("front", CubeListBuilder.create(), PartPose.offset(0.0F, -8.0F, -3.0F));

		PartDefinition brush_front_r1 = front.addOrReplaceChild("brush_front_r1", CubeListBuilder.create().texOffs(66, 0).addBox(-0.5F, 0.0F, -6.0F, 1.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2182F, 0.0F, 0.0F));

		PartDefinition bone6 = bone5.addOrReplaceChild("bone6", CubeListBuilder.create().texOffs(19, 24).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, -3.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition bone7 = bone6.addOrReplaceChild("bone7", CubeListBuilder.create().texOffs(18, 17).addBox(-2.5F, -0.5F, -2.0F, 5.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition bone8 = bone7.addOrReplaceChild("bone8", CubeListBuilder.create().texOffs(13, 5).addBox(-3.0F, -0.9F, -6.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, -1.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition bone9 = bone8.addOrReplaceChild("bone9", CubeListBuilder.create().texOffs(18, 0).addBox(-2.0F, -2.75F, -2.4F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(29, 0).addBox(-1.5F, -2.75F, -3.4F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.75F, -6.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition mouth_r1 = bone9.addOrReplaceChild("mouth_r1", CubeListBuilder.create().texOffs(45, 0).addBox(-1.5F, 0.25F, -3.3F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(34, 0).addBox(-2.0F, 0.25F, -2.3F, 4.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition bone11 = bone8.addOrReplaceChild("bone11", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -0.9F, -2.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition cube_r2 = bone11.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(37, 13).addBox(-4.25F, -1.1F, 0.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1309F));

		PartDefinition cube_r3 = bone11.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(7, 13).addBox(2.25F, -1.1F, 0.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1309F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(12, 53).addBox(-3.5F, -18.0F, -3.0F, 7.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 80, 80);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
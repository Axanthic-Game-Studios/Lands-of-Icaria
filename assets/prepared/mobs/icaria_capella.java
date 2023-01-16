// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports


public class icaria_capella<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "icaria_capella"), "main");
	private final ModelPart bone;
	private final ModelPart bone7;
	private final ModelPart bb_main;

	public icaria_capella(ModelPart root) {
		this.bone = root.getChild("bone");
		this.bone7 = root.getChild("bone7");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(18, 30).addBox(-4.0F, -7.0F, -6.0F, 8.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 18.0F, -2.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition bone8 = bone.addOrReplaceChild("bone8", CubeListBuilder.create().texOffs(4, 34).addBox(2.0F, -4.0F, -1.0F, 3.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(46, 34).addBox(-5.0F, -4.0F, -1.0F, 3.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition bone10 = bone8.addOrReplaceChild("bone10", CubeListBuilder.create().texOffs(56, 30).addBox(-4.5F, -0.2F, -2.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 30).addBox(2.5F, -0.2F, -2.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 2.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition bone2 = bone.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(24, 23).addBox(-3.5F, -6.5F, -1.0F, 7.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -6.0F, -0.0436F, 0.0F, 0.0F));

		PartDefinition bone3 = bone2.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(25, 16).addBox(-2.0F, -4.0F, -3.0F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.5F, -1.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition bone4 = bone3.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(23, 6).addBox(-2.5F, -1.0F, -3.0F, 5.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, -3.0F, -0.2443F, 0.0F, 0.0F));

		PartDefinition bone12 = bone4.addOrReplaceChild("bone12", CubeListBuilder.create().texOffs(15, 4).addBox(-2.0F, -2.0F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 1.0F, -2.0F, -0.7854F, -0.7854F, 0.0F));

		PartDefinition bone14 = bone12.addOrReplaceChild("bone14", CubeListBuilder.create().texOffs(11, 10).addBox(-1.0F, -1.0F, -3.5F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -0.5F, -1.0F, -0.576F, -0.7854F, 0.0F));

		PartDefinition bone16 = bone14.addOrReplaceChild("bone16", CubeListBuilder.create().texOffs(11, 16).addBox(-1.0F, -1.0F, -3.5F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -3.5F, 0.7854F, -0.7854F, 0.0F));

		PartDefinition bone19 = bone16.addOrReplaceChild("bone19", CubeListBuilder.create().texOffs(11, 22).addBox(-1.0F, -1.0F, -3.5F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -3.0F, 0.7854F, -0.1963F, -0.7854F));

		PartDefinition bone21 = bone19.addOrReplaceChild("bone21", CubeListBuilder.create().texOffs(11, 28).addBox(-0.5F, -0.75F, -4.5F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -3.0F, 0.7854F, 0.1963F, 0.0F));

		PartDefinition bone13 = bone4.addOrReplaceChild("bone13", CubeListBuilder.create().texOffs(37, 4).addBox(-1.0F, -1.0F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, 1.0F, -2.0F, 0.7854F, 0.7854F, 0.0F));

		PartDefinition bone15 = bone13.addOrReplaceChild("bone15", CubeListBuilder.create().texOffs(41, 10).addBox(-1.0F, -3.5F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -1.0F, 0.5F, -0.576F, 0.0F, -0.7854F));

		PartDefinition bone17 = bone15.addOrReplaceChild("bone17", CubeListBuilder.create().texOffs(41, 16).addBox(-1.0F, -3.5F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.5F, 0.0F, 0.7854F, 0.0F, -0.7854F));

		PartDefinition bone18 = bone17.addOrReplaceChild("bone18", CubeListBuilder.create().texOffs(41, 22).addBox(-1.0F, -3.5F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.7854F, 0.7854F, -0.1963F));

		PartDefinition bone20 = bone18.addOrReplaceChild("bone20", CubeListBuilder.create(), PartPose.offset(0.0F, -3.0F, 0.0F));

		PartDefinition cube_r1 = bone20.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(43, 28).addBox(-0.5F, -4.5F, -0.25F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.1963F));

		PartDefinition bone5 = bone4.addOrReplaceChild("bone5", CubeListBuilder.create().texOffs(24, 0).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, -3.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition bone6 = bone5.addOrReplaceChild("bone6", CubeListBuilder.create().texOffs(36, 0).addBox(-1.5F, 0.0F, 0.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition bone7 = partdefinition.addOrReplaceChild("bone7", CubeListBuilder.create().texOffs(25, 57).addBox(-2.5F, 0.0F, 0.0F, 5.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(46, 48).addBox(-4.0F, 1.0F, -2.5F, 3.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(4, 48).addBox(1.0F, 1.0F, -2.5F, 3.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 12.5F, 6.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition bone11 = bone7.addOrReplaceChild("bone11", CubeListBuilder.create().texOffs(21, 60).addBox(-0.5F, 0.0F, -1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, 0.576F, 0.0F, 0.0F));

		PartDefinition bone9 = bone7.addOrReplaceChild("bone9", CubeListBuilder.create().texOffs(56, 44).addBox(-3.5F, -0.25F, 0.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 44).addBox(1.5F, -0.25F, 0.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, -1.5F, 0.2182F, 0.0F, 0.0F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(18, 43).addBox(-3.0F, -12.0F, -2.0F, 6.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone7.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
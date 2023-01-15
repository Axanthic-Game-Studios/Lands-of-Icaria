// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports


public class icaria_odontotyrannos<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "icaria_odontotyrannos"), "main");
	private final ModelPart bone;
	private final ModelPart bone5;
	private final ModelPart bone12;
	private final ModelPart bb_main;

	public icaria_odontotyrannos(ModelPart root) {
		this.bone = root.getChild("bone");
		this.bone5 = root.getChild("bone5");
		this.bone12 = root.getChild("bone12");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(19, 28).addBox(-3.0F, -5.5F, 0.0F, 6.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 11.5F, 4.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition body_spike_center_r1 = bone.addOrReplaceChild("body_spike_center_r1", CubeListBuilder.create().texOffs(66, 26).addBox(-0.5F, -5.5F, -0.25F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0087F, 0.0F, 0.0F));

		PartDefinition body_spike_center_r2 = bone.addOrReplaceChild("body_spike_center_r2", CubeListBuilder.create().texOffs(66, 22).addBox(-0.5F, -5.5F, 2.75F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0175F, 0.0F, 0.0F));

		PartDefinition bone2 = bone.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(19, 39).addBox(-2.5F, -5.0F, 0.0F, 5.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 5.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition tail_spike_center_r1 = bone2.addOrReplaceChild("tail_spike_center_r1", CubeListBuilder.create().texOffs(66, 18).addBox(-0.5F, -5.55F, 1.1F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0262F, 0.0F, 0.0F));

		PartDefinition tail_spike_center_r2 = bone2.addOrReplaceChild("tail_spike_center_r2", CubeListBuilder.create().texOffs(66, 14).addBox(-0.5F, -5.65F, 4.1F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0349F, 0.0F, 0.0F));

		PartDefinition bone3 = bone2.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(21, 49).addBox(-2.0F, -4.0F, 0.0F, 4.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 6.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition tail_spike_right_r1 = bone3.addOrReplaceChild("tail_spike_right_r1", CubeListBuilder.create().texOffs(72, 10).addBox(-0.25F, -4.25F, 1.25F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, -0.0436F, 0.0F, -0.576F));

		PartDefinition tail_spike_left_r1 = bone3.addOrReplaceChild("tail_spike_left_r1", CubeListBuilder.create().texOffs(60, 10).addBox(-0.75F, -4.25F, 1.25F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, -0.0436F, 0.0F, 0.576F));

		PartDefinition tail_spike_center_r3 = bone3.addOrReplaceChild("tail_spike_center_r3", CubeListBuilder.create().texOffs(66, 10).addBox(-0.5F, -5.5F, 1.25F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, -0.0436F, 0.0F, 0.0F));

		PartDefinition bone4 = bone3.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(22, 57).addBox(-1.5F, -3.0F, 0.0F, 3.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 5.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition tail_spike_center_r4 = bone4.addOrReplaceChild("tail_spike_center_r4", CubeListBuilder.create().texOffs(66, 5).addBox(-0.5F, -5.75F, -0.5F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition tail_spike_right_r2 = bone4.addOrReplaceChild("tail_spike_right_r2", CubeListBuilder.create().texOffs(72, 5).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, -0.0436F, 0.0F, -0.576F));

		PartDefinition tail_spike_right_r3 = bone4.addOrReplaceChild("tail_spike_right_r3", CubeListBuilder.create().texOffs(72, 0).addBox(-0.5F, -5.0F, 2.5F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0436F, 0.0F, -0.576F));

		PartDefinition tail_spike_left_r2 = bone4.addOrReplaceChild("tail_spike_left_r2", CubeListBuilder.create().texOffs(60, 5).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, -0.0436F, 0.0F, 0.576F));

		PartDefinition tail_spike_left_r3 = bone4.addOrReplaceChild("tail_spike_left_r3", CubeListBuilder.create().texOffs(60, 0).addBox(-0.5F, -5.0F, 2.5F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0436F, 0.0F, 0.576F));

		PartDefinition tail_spike_center_r5 = bone4.addOrReplaceChild("tail_spike_center_r5", CubeListBuilder.create().texOffs(66, 0).addBox(-0.5F, -6.0F, 2.5F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0436F, 0.0F, 0.0F));

		PartDefinition bone5 = partdefinition.addOrReplaceChild("bone5", CubeListBuilder.create().texOffs(16, 0).addBox(-3.5F, -6.0F, -7.0F, 7.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 11.5F, -4.0F, -0.0436F, 0.0F, 0.0F));

		PartDefinition bone19 = bone5.addOrReplaceChild("bone19", CubeListBuilder.create().texOffs(11, 0).addBox(-2.0F, 0.0F, -1.0F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -3.0F, -5.0F, 0.1309F, -0.0873F, -0.1309F));

		PartDefinition bone21 = bone19.addOrReplaceChild("bone21", CubeListBuilder.create().texOffs(0, 1).addBox(-1.5F, -1.0F, -6.0F, 2.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, 2.0F, 0.1963F, 0.0F, 0.0F));

		PartDefinition bone24 = bone21.addOrReplaceChild("bone24", CubeListBuilder.create().texOffs(0, 4).addBox(-0.9F, -0.25F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -1.0F, -6.0F, -0.2618F, 0.0F, 0.0873F));

		PartDefinition claws_left_r1 = bone24.addOrReplaceChild("claws_left_r1", CubeListBuilder.create().texOffs(46, 0).addBox(-1.0F, -0.25F, -0.2F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -0.5F, 0.0873F, 0.0873F, 0.1745F));

		PartDefinition claws_left_o_r1 = bone24.addOrReplaceChild("claws_left_o_r1", CubeListBuilder.create().texOffs(54, 0).addBox(0.2F, -0.25F, -0.2F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -0.5F, 0.0873F, -0.0873F, -0.1745F));

		PartDefinition bone20 = bone5.addOrReplaceChild("bone20", CubeListBuilder.create().texOffs(37, 0).addBox(-1.0F, 0.0F, -1.0F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, -3.0F, -5.0F, 0.1309F, 0.0873F, 0.1309F));

		PartDefinition bone22 = bone20.addOrReplaceChild("bone22", CubeListBuilder.create().texOffs(44, 1).addBox(-0.5F, -1.0F, -6.0F, 2.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, 2.0F, 0.1963F, 0.0F, 0.0F));

		PartDefinition bone23 = bone22.addOrReplaceChild("bone23", CubeListBuilder.create().texOffs(54, 4).addBox(-1.1F, -0.25F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -1.0F, -6.0F, 0.0F, 0.0F, -0.0873F));

		PartDefinition claws_right_o_r1 = bone23.addOrReplaceChild("claws_right_o_r1", CubeListBuilder.create().texOffs(2, 0).addBox(-1.2F, -0.25F, -0.2F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -0.5F, 0.0873F, 0.0873F, 0.1745F));

		PartDefinition claws_right_r1 = bone23.addOrReplaceChild("claws_right_r1", CubeListBuilder.create().texOffs(10, 0).addBox(0.0F, -0.25F, -0.2F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -0.5F, 0.0873F, -0.0873F, -0.1745F));

		PartDefinition bone6 = bone5.addOrReplaceChild("bone6", CubeListBuilder.create().texOffs(44, 77).addBox(-2.5F, -4.0F, -2.0F, 5.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -8.0F, -0.5672F, 0.0F, 0.0F));

		PartDefinition bone7 = bone6.addOrReplaceChild("bone7", CubeListBuilder.create().texOffs(44, 68).addBox(-2.0F, -4.0F, -5.0F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition bone8 = bone7.addOrReplaceChild("bone8", CubeListBuilder.create().texOffs(44, 60).addBox(-2.5F, 0.0F, -4.0F, 5.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, -5.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition bone9 = bone8.addOrReplaceChild("bone9", CubeListBuilder.create().texOffs(44, 43).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -4.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition bone11 = bone9.addOrReplaceChild("bone11", CubeListBuilder.create().texOffs(46, 50).addBox(-1.5F, 0.0F, -4.0F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(46, 55).addBox(-1.5F, -1.0F, -3.85F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, -3.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition bone10 = bone9.addOrReplaceChild("bone10", CubeListBuilder.create().texOffs(41, 32).addBox(-2.0F, -0.5F, -5.0F, 4.0F, 3.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(7, 37).addBox(-0.5F, -1.5F, 2.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(42, 24).addBox(-2.0F, 2.5F, -4.75F, 4.0F, 1.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(37, 35).addBox(1.5F, -0.25F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(57, 35).addBox(-3.5F, -0.25F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -3.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition right_horn_tip_r1 = bone10.addOrReplaceChild("right_horn_tip_r1", CubeListBuilder.create().texOffs(9, 33).addBox(-0.65F, -2.0F, -0.6F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.25F, -1.0F, -3.8F, 0.0F, -0.7854F, 0.0F));

		PartDefinition right_horn_r1 = bone10.addOrReplaceChild("right_horn_r1", CubeListBuilder.create().texOffs(9, 28).addBox(-0.5F, -1.0F, -3.0F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -0.5F, -1.0F, -0.1309F, 0.1309F, 0.0F));

		PartDefinition left_horn_tip_r1 = bone10.addOrReplaceChild("left_horn_tip_r1", CubeListBuilder.create().texOffs(5, 33).addBox(-0.55F, -2.0F, -0.6F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.25F, -1.0F, -3.8F, 0.0F, -0.7854F, 0.0F));

		PartDefinition left_horn_r1 = bone10.addOrReplaceChild("left_horn_r1", CubeListBuilder.create().texOffs(1, 28).addBox(-0.5F, -1.0F, -3.0F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -0.5F, -1.0F, -0.1309F, -0.1309F, 0.0F));

		PartDefinition center_horn_tip_r1 = bone10.addOrReplaceChild("center_horn_tip_r1", CubeListBuilder.create().texOffs(7, 27).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -4.3F, 0.0F, -0.7854F, 0.0F));

		PartDefinition center_horn_r1 = bone10.addOrReplaceChild("center_horn_r1", CubeListBuilder.create().texOffs(4, 21).addBox(-0.5F, -1.0F, -3.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, -1.5F, -0.1309F, 0.0F, 0.0F));

		PartDefinition comb_right_r1 = bone10.addOrReplaceChild("comb_right_r1", CubeListBuilder.create().texOffs(11, 37).addBox(-0.5F, -1.0F, 1.1F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 0.0F, 1.5F, 0.0F, -0.6109F, 0.0F));

		PartDefinition comb_left_r1 = bone10.addOrReplaceChild("comb_left_r1", CubeListBuilder.create().texOffs(3, 37).addBox(-0.5F, -1.0F, 1.1F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 1.5F, 0.0F, 0.6109F, 0.0F));

		PartDefinition bone12 = partdefinition.addOrReplaceChild("bone12", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 9.0F, 4.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition right_thigh_r1 = bone12.addOrReplaceChild("right_thigh_r1", CubeListBuilder.create().texOffs(38, 8).addBox(-4.5F, -1.75F, -4.0F, 4.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0873F, 0.1309F));

		PartDefinition left_thigh_r1 = bone12.addOrReplaceChild("left_thigh_r1", CubeListBuilder.create().texOffs(0, 8).addBox(0.5F, -1.75F, -4.0F, 4.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.0873F, -0.1309F));

		PartDefinition bone13 = bone12.addOrReplaceChild("bone13", CubeListBuilder.create().texOffs(30, 64).addBox(-0.5F, 0.5F, 0.0F, 2.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(10, 70).addBox(1.0F, 0.5F, 0.0F, 1.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 3.0F, -2.5F, 0.5236F, 0.0873F, 0.1309F));

		PartDefinition bone14 = bone13.addOrReplaceChild("bone14", CubeListBuilder.create().texOffs(10, 57).addBox(-1.25F, 0.0F, -3.0F, 2.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 6.5F, 3.75F, -0.6763F, 0.0F, 0.0F));

		PartDefinition bone17 = bone14.addOrReplaceChild("bone17", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0F, 8.0F, -0.25F, 0.3054F, -0.2618F, -0.2182F));

		PartDefinition foot_inner_r1 = bone17.addOrReplaceChild("foot_inner_r1", CubeListBuilder.create().texOffs(10, 52).addBox(-2.0F, -1.0F, -3.85F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.4363F, 0.0F));

		PartDefinition foot_inner_r2 = bone17.addOrReplaceChild("foot_inner_r2", CubeListBuilder.create().texOffs(10, 47).addBox(-1.25F, -1.0F, -3.5F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.1745F, 0.0F));

		PartDefinition bone15 = bone12.addOrReplaceChild("bone15", CubeListBuilder.create().texOffs(18, 64).addBox(-1.5F, 0.5F, 0.0F, 2.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 70).addBox(-2.0F, 0.5F, 0.0F, 1.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 3.0F, -2.5F, 0.5236F, -0.0873F, -0.1309F));

		PartDefinition bone16 = bone15.addOrReplaceChild("bone16", CubeListBuilder.create().texOffs(0, 57).addBox(-0.75F, 0.0F, -3.0F, 2.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 6.5F, 3.75F, -0.6763F, 0.0F, 0.0F));

		PartDefinition bone18 = bone16.addOrReplaceChild("bone18", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.0F, 8.0F, -0.25F, 0.3054F, 0.2618F, 0.2182F));

		PartDefinition foot_inner_r3 = bone18.addOrReplaceChild("foot_inner_r3", CubeListBuilder.create().texOffs(0, 52).addBox(1.0F, -1.0F, -3.85F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.4363F, 0.0F));

		PartDefinition foot_inner_r4 = bone18.addOrReplaceChild("foot_inner_r4", CubeListBuilder.create().texOffs(0, 47).addBox(0.25F, -1.0F, -3.5F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.1745F, 0.0F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(14, 13).addBox(-4.0F, -18.75F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 80, 88);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone12.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
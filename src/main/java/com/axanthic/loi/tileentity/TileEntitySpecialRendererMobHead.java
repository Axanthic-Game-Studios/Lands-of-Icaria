package com.axanthic.loi.tileentity;

import com.axanthic.loi.ModInformation;
import com.axanthic.loi.render.ModelAeternaeHead;
import com.axanthic.loi.render.ModelArganHoundHead;
import com.axanthic.loi.render.ModelCatoblepasHead;
import com.axanthic.loi.render.ModelCerverHead;
import com.axanthic.loi.render.ModelHagHead;
import com.axanthic.loi.render.ModelHagHeadLaurel;
import com.axanthic.loi.render.ModelMyrmekeHead;
import com.axanthic.loi.render.ModelSowHead;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelSkeletonHead;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;

public class TileEntitySpecialRendererMobHead extends TileEntitySpecialRenderer<TileEntityMobHead> {

	public static final ResourceLocation REVENANT_TEXTURES = new ResourceLocation(ModInformation.ID, "textures/entity/mob_revenant.png");
	public static final ResourceLocation ARACHNE_TEXTURES = new ResourceLocation(ModInformation.ID, "textures/entity/mob_arachne.png");
	public static final ResourceLocation ARACHNE_DRONE_TEXTURES = new ResourceLocation(ModInformation.ID, "textures/entity/mob_arachne_drone.png");
	public static final ResourceLocation MYRMEKE_TEXTURES = new ResourceLocation(ModInformation.ID, "textures/entity/mob_myrmeke.png");
	public static final ResourceLocation CERVER_TEXTURES = new ResourceLocation(ModInformation.ID, "textures/entity/mob_cerver.png");
	public static final ResourceLocation ARGAN_HOUND_TEXTURES = new ResourceLocation(ModInformation.ID, "textures/entity/mob_argan_hound.png");
	public static final ResourceLocation FORESTHAG_PLANE_TEXTURES = new ResourceLocation(ModInformation.ID, "textures/entity/mob_foresthag_plane.png");
	public static final ResourceLocation FORESTHAG_POPULUS_TEXTURES = new ResourceLocation(ModInformation.ID, "textures/entity/mob_foresthag_populus.png");
	public static final ResourceLocation FORESTHAG_CYPRESS_TEXTURES = new ResourceLocation(ModInformation.ID, "textures/entity/mob_foresthag_cypress.png");
	public static final ResourceLocation FORESTHAG_FIR_TEXTURES = new ResourceLocation(ModInformation.ID, "textures/entity/mob_foresthag_fir.png");
	public static final ResourceLocation FORESTHAG_OLIVE_TEXTURES = new ResourceLocation(ModInformation.ID, "textures/entity/mob_foresthag_olive.png");
	public static final ResourceLocation FORESTHAG_LAUREL_TEXTURES = new ResourceLocation(ModInformation.ID, "textures/entity/mob_foresthag_laurel.png");
	public static final ResourceLocation FORESTHAG_DROUGHTROOT_TEXTURES = new ResourceLocation(ModInformation.ID, "textures/entity/mob_foresthag_droughtroot.png");
	public static final ResourceLocation AETERNAE_TEXTURES = new ResourceLocation(ModInformation.ID, "textures/entity/mob_aeternae.png");
	public static final ResourceLocation CATOBLEPAS_TEXTURES = new ResourceLocation(ModInformation.ID, "textures/entity/mob_catoblepas.png");
	public static final ResourceLocation SOW_TEXTURES = new ResourceLocation(ModInformation.ID, "textures/entity/mob_sow.png");

	public static TileEntitySpecialRendererMobHead instance;

	public static final ModelSkeletonHead revenantHead = new ModelSkeletonHead(0, 0, 64, 128);
	public static final ModelSkeletonHead arachneHead = new ModelSkeletonHead(0, 0, 64, 64);
	public static final ModelSkeletonHead arachneDroneHead = new ModelSkeletonHead(0, 16, 64, 32);
	public static final ModelMyrmekeHead myrmekeHead = new ModelMyrmekeHead();
	public static final ModelCerverHead cerverHead = new ModelCerverHead();
	public static final ModelArganHoundHead arganHoundHead = new ModelArganHoundHead();
	public static final ModelSkeletonHead forestHagHead = new ModelSkeletonHead(0, 0, 64, 32);
	public static final ModelHagHead forestHagCypressHead = new ModelHagHead(22, 24, 128, 128);
	public static final ModelHagHead forestHagDroughtrootHead = new ModelHagHead(66, 30, 128, 128);
	public static final ModelHagHead forestHagFirHead = new ModelHagHead(58, 49, 128, 128);
	public static final ModelHagHead forestHagOliveHead = new ModelHagHead(104, 0, 128, 128);
	public static final ModelHagHeadLaurel forestHagLaurelHead = new ModelHagHeadLaurel();
	public static final ModelAeternaeHead aeternaeHead = new ModelAeternaeHead();
	public static final ModelCatoblepasHead catoblepasHead = new ModelCatoblepasHead();
	public static final ModelSowHead sowHead = new ModelSowHead();

	@Override
	public void render(TileEntityMobHead te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
		EnumFacing enumfacing = EnumFacing.getFront(te.getBlockMetadata() & 7);
		this.renderSkull((float)x, (float)y, (float)z, enumfacing, (float)(te.getSkullRotation() * 360) / 16.0F, te.getSkullType(), destroyStage, 1);
	}

	@Override
	public void setRendererDispatcher(TileEntityRendererDispatcher rendererDispatcherIn) {
		super.setRendererDispatcher(rendererDispatcherIn);
		instance = this;
	}

	public void renderSkull(float x, float y, float z, EnumFacing facing, float rotationIn, String skullType, int destroyStage, float scale) {
		ModelBase modelbase = this.revenantHead;

		float wallOffset = 0.0f;
		float floorOffset = 0.0f;
		float pitch = 0.0f;

		if (skullType.equals("revenant"))
			this.bindTexture(REVENANT_TEXTURES);
		else if (skullType.equals("arachne")) {
			this.bindTexture(ARACHNE_TEXTURES);
			modelbase = this.arachneHead;
		} else if (skullType.equals("arachne_drone")) {
			this.bindTexture(ARACHNE_DRONE_TEXTURES);
			modelbase = this.arachneDroneHead;
		} else if (skullType.equals("myrmeke")) {
			this.bindTexture(MYRMEKE_TEXTURES);
			modelbase = this.myrmekeHead;
		} else if (skullType.equals("cerver")) {
			this.bindTexture(CERVER_TEXTURES);
			modelbase = this.cerverHead;
			wallOffset = 0.0625f;
		} else if (skullType.equals("argan_hound")) {
			this.bindTexture(ARGAN_HOUND_TEXTURES);
			modelbase = this.arganHoundHead;
			wallOffset = 0.0625f;
		} else if (skullType.equals("foresthag_plane")) {
			this.bindTexture(FORESTHAG_PLANE_TEXTURES);
			modelbase = this.forestHagHead;
		} else if (skullType.equals("foresthag_populus")) {
			this.bindTexture(FORESTHAG_POPULUS_TEXTURES);
			modelbase = this.forestHagHead;
		} else if (skullType.equals("foresthag_cypress")) {
			this.bindTexture(FORESTHAG_CYPRESS_TEXTURES);
			modelbase = this.forestHagCypressHead;
			wallOffset = 0.0625f;
		} else if (skullType.equals("foresthag_fir")) {
			this.bindTexture(FORESTHAG_FIR_TEXTURES);
			modelbase = this.forestHagFirHead;
			wallOffset = 0.0625f;
		} else if (skullType.equals("foresthag_olive")) {
			this.bindTexture(FORESTHAG_OLIVE_TEXTURES);
			modelbase = this.forestHagOliveHead;
			wallOffset = 0.0625f;
		} else if (skullType.equals("foresthag_laurel")) {
			this.bindTexture(FORESTHAG_LAUREL_TEXTURES);
			modelbase = this.forestHagLaurelHead;
			wallOffset = 0.0625f;
		} else if (skullType.equals("foresthag_droughtroot")) {
			this.bindTexture(FORESTHAG_DROUGHTROOT_TEXTURES);
			modelbase = this.forestHagDroughtrootHead;
			wallOffset = 0.0625f;
		} else if (skullType.equals("aeternae")) {
			this.bindTexture(AETERNAE_TEXTURES);
			modelbase = this.aeternaeHead;
			if (facing != EnumFacing.UP && facing != EnumFacing.DOWN)
				pitch = 35.0F;
		} else if (skullType.equals("catoblepas")) {
			this.bindTexture(CATOBLEPAS_TEXTURES);
			modelbase = this.catoblepasHead;
			wallOffset = 0.0625f;
			if (facing == EnumFacing.UP)
				pitch = -5.0F;
			if (facing == EnumFacing.DOWN)
				floorOffset = -0.02F;
		} else if (skullType.equals("sow")) {
			this.bindTexture(SOW_TEXTURES);
			modelbase = this.sowHead;
		} else
			this.bindTexture(REVENANT_TEXTURES);

		if (destroyStage >= 0) {
			this.bindTexture(DESTROY_STAGES[destroyStage]);
			//GlStateManager.matrixMode(5890);
			//GlStateManager.pushMatrix();
			//GlStateManager.scale(4.0F, 8.0F, 1.0F);
			//GlStateManager.translate(0.0625F, 0.0625F, 0.0625F);
			//GlStateManager.matrixMode(5888);
		} 

		GlStateManager.pushMatrix();
		GlStateManager.disableCull();

		if (facing == EnumFacing.UP || facing == EnumFacing.DOWN) {
			GlStateManager.translate(x + 0.5F, y + floorOffset, z + 0.5F);
		} else {
			switch (facing) {
			case NORTH:
				GlStateManager.translate(x + 0.5F, y + 0.25F + floorOffset, z + 0.749F + wallOffset);
				break;
			case SOUTH:
				GlStateManager.translate(x + 0.5F, y + 0.25F + floorOffset, z + 0.259F - wallOffset);
				rotationIn = 180.0F;
				break;
			case WEST:
				GlStateManager.translate(x + 0.749F + wallOffset, y + 0.25F + floorOffset, z + 0.5F);
				rotationIn = 270.0F;
				break;
			case EAST:
			default:
				GlStateManager.translate(x + 0.259F - wallOffset, y + 0.25F + floorOffset, z + 0.5F);
				rotationIn = 90.0F;
			}
		}

		GlStateManager.enableRescaleNormal();
		GlStateManager.scale(-scale, -scale, scale);
		GlStateManager.enableAlpha();

		modelbase.render(null, 0.0F, 0.0F, 0.0F, rotationIn, pitch, 0.0625F);
		GlStateManager.popMatrix();

		if (destroyStage >= 0) {
			//GlStateManager.matrixMode(5890);
			//GlStateManager.popMatrix();
			//GlStateManager.matrixMode(5888);
		}
	}
}
package com.axanthic.loi.tileentity;

import com.axanthic.loi.ModInformation;
import com.axanthic.loi.entity.ModelAeternaeHead;
import com.axanthic.loi.entity.ModelArganHoundHead;
import com.axanthic.loi.entity.ModelCatoblepasHead;
import com.axanthic.loi.entity.ModelCerverHead;
import com.axanthic.loi.entity.ModelHagHead;
import com.axanthic.loi.entity.ModelMyrmekeHead;
import com.axanthic.loi.entity.ModelSowHead;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelSkeletonHead;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;

public class TileEntitySpecialRendererMobHead extends TileEntitySpecialRenderer<TileEntityMobHead> {

	private static final ResourceLocation REVENANT_TEXTURES = new ResourceLocation(ModInformation.ID, "textures/entity/mob_revenant.png");
	private static final ResourceLocation ARACHNE_TEXTURES = new ResourceLocation(ModInformation.ID, "textures/entity/mob_arachne.png");
	private static final ResourceLocation ARACHNE_DRONE_TEXTURES = new ResourceLocation(ModInformation.ID, "textures/entity/mob_arachne_drone.png");
	private static final ResourceLocation MYRMEKE_TEXTURES = new ResourceLocation(ModInformation.ID, "textures/entity/mob_myrmeke.png");
	private static final ResourceLocation CERVER_TEXTURES = new ResourceLocation(ModInformation.ID, "textures/entity/mob_cerver.png");
	private static final ResourceLocation ARGAN_HOUND_TEXTURES = new ResourceLocation(ModInformation.ID, "textures/entity/mob_argan_hound.png");
	private static final ResourceLocation FORESTHAG_PLANE_TEXTURES = new ResourceLocation(ModInformation.ID, "textures/entity/mob_foresthag_plane.png");
	private static final ResourceLocation FORESTHAG_POPULUS_TEXTURES = new ResourceLocation(ModInformation.ID, "textures/entity/mob_foresthag_populus.png");
	private static final ResourceLocation FORESTHAG_CYPRESS_TEXTURES = new ResourceLocation(ModInformation.ID, "textures/entity/mob_foresthag_cypress.png");
	private static final ResourceLocation FORESTHAG_FIR_TEXTURES = new ResourceLocation(ModInformation.ID, "textures/entity/mob_foresthag_fir.png");
	private static final ResourceLocation FORESTHAG_OLIVE_TEXTURES = new ResourceLocation(ModInformation.ID, "textures/entity/mob_foresthag_olive.png");
	private static final ResourceLocation FORESTHAG_LAUREL_TEXTURES = new ResourceLocation(ModInformation.ID, "textures/entity/mob_foresthag_laurel.png");
	private static final ResourceLocation FORESTHAG_DROUGHTROOT_TEXTURES = new ResourceLocation(ModInformation.ID, "textures/entity/mob_foresthag_droughtroot.png");
	private static final ResourceLocation AETERNAE_TEXTURES = new ResourceLocation(ModInformation.ID, "textures/entity/mob_aeternae.png");
	private static final ResourceLocation CATOBLEPAS_TEXTURES = new ResourceLocation(ModInformation.ID, "textures/entity/mob_catoblepas.png");
	private static final ResourceLocation SOW_TEXTURES = new ResourceLocation(ModInformation.ID, "textures/entity/mob_sow.png");
	public static TileEntitySpecialRendererMobHead instance;
	private final ModelSkeletonHead revenantHead = new ModelSkeletonHead(0, 0, 64, 128);
	private final ModelSkeletonHead arachneHead = new ModelSkeletonHead(0, 0, 64, 64);
	private final ModelSkeletonHead arachneDroneHead = new ModelSkeletonHead(0, 16, 64, 32);
	private final ModelMyrmekeHead myrmekeHead = new ModelMyrmekeHead();
	private final ModelCerverHead cerverHead = new ModelCerverHead();
	private final ModelArganHoundHead arganHoundHead = new ModelArganHoundHead();
	private final ModelSkeletonHead forestHagHead = new ModelSkeletonHead(0, 0, 64, 32);
	private final ModelHagHead forestHagCypressHead = new ModelHagHead(22, 24, 128, 128);
	private final ModelHagHead forestHagDroughtrootHead = new ModelHagHead(66, 30, 128, 128);
	private final ModelHagHead forestHagFirHead = new ModelHagHead(58, 49, 128, 128);
	private final ModelAeternaeHead aeternaeHead = new ModelAeternaeHead();
	private final ModelCatoblepasHead catoblepasHead = new ModelCatoblepasHead();
	private final ModelSowHead sowHead = new ModelSowHead();

	@Override
	public void render(TileEntityMobHead te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
		EnumFacing enumfacing = EnumFacing.getFront(te.getBlockMetadata() & 7);
		this.renderSkull((float)x, (float)y, (float)z, enumfacing, (float)(te.getSkullRotation() * 360) / 16.0F, te.getSkullType(), destroyStage);
	}

	@Override
	public void setRendererDispatcher(TileEntityRendererDispatcher rendererDispatcherIn) {
		super.setRendererDispatcher(rendererDispatcherIn);
		instance = this;
	}

	public void renderSkull(float x, float y, float z, EnumFacing facing, float rotationIn, String skullType, int destroyStage) {
		ModelBase modelbase = this.revenantHead;
		
		float wallOffset = 0.0f;

		if (destroyStage >= 0) {
			this.bindTexture(DESTROY_STAGES[destroyStage]);
			GlStateManager.matrixMode(5890);
			GlStateManager.pushMatrix();
			GlStateManager.scale(4.0F, 8.0F, 1.0F);
			GlStateManager.translate(0.0625F, 0.0625F, 0.0625F);
			GlStateManager.matrixMode(5888);
		} else {
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
			} else if (skullType.equals("argan_hound")) {
				this.bindTexture(ARGAN_HOUND_TEXTURES);
				modelbase = this.arganHoundHead;
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
				modelbase = this.forestHagHead;
			} else if (skullType.equals("foresthag_laurel")) {
				this.bindTexture(FORESTHAG_LAUREL_TEXTURES);
				modelbase = this.forestHagHead;
			} else if (skullType.equals("foresthag_droughtroot")) {
				this.bindTexture(FORESTHAG_DROUGHTROOT_TEXTURES);
				modelbase = this.forestHagDroughtrootHead;
				wallOffset = 0.0625f;
			} else if (skullType.equals("aeternae")) {
				this.bindTexture(AETERNAE_TEXTURES);
				modelbase = this.aeternaeHead;
			} else if (skullType.equals("catoblepas")) {
				this.bindTexture(CATOBLEPAS_TEXTURES);
				modelbase = this.catoblepasHead;
			} else if (skullType.equals("sow")) {
				this.bindTexture(SOW_TEXTURES);
				modelbase = this.sowHead;
			} else
				this.bindTexture(REVENANT_TEXTURES);
		}

		GlStateManager.pushMatrix();
		GlStateManager.disableCull();

		if (facing == EnumFacing.UP) {
			GlStateManager.translate(x + 0.5F, y, z + 0.5F);
		} else {
			switch (facing) {
			case NORTH:
				GlStateManager.translate(x + 0.5F, y + 0.25F, z + 0.74F + wallOffset);
				break;
			case SOUTH:
				GlStateManager.translate(x + 0.5F, y + 0.25F, z + 0.26F - wallOffset);
				rotationIn = 180.0F;
				break;
			case WEST:
				GlStateManager.translate(x + 0.74F + wallOffset, y + 0.25F, z + 0.5F);
				rotationIn = 270.0F;
				break;
			case EAST:
			default:
				GlStateManager.translate(x + 0.26F - wallOffset, y + 0.25F, z + 0.5F);
				rotationIn = 90.0F;
			}
		}

		float f = 0.0625F;
		GlStateManager.enableRescaleNormal();
		GlStateManager.scale(-1.0F, -1.0F, 1.0F);
		GlStateManager.enableAlpha();

		modelbase.render((Entity)null, 0.0F, 0.0F, 0.0F, rotationIn, 0.0F, 0.0625F);
		GlStateManager.popMatrix();

		if (destroyStage >= 0) {
			GlStateManager.matrixMode(5890);
			GlStateManager.popMatrix();
			GlStateManager.matrixMode(5888);
		}
	}
}
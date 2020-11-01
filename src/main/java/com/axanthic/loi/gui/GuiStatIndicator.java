package com.axanthic.loi.gui;

import com.axanthic.loi.LOIConfig;
import com.axanthic.loi.utils.MobInfoRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

@SideOnly(Side.CLIENT)
public class GuiStatIndicator {
	public Minecraft mc;
	public MobInfoRenderer lifeGaugeRenderer;
	public EntityLivingBase lastEntity;
	private Entity pointedEntity;
	public int offsetGoal;
	public float offset;
	private int duration;

	public GuiStatIndicator() {
		this.mc = Minecraft.getMinecraft();
		this.lifeGaugeRenderer = new MobInfoRenderer();
		this.offsetGoal = 0;
		this.offset = 0.0f;
	}

	@SubscribeEvent
	public void onClientTick(final TickEvent.ClientTickEvent event) {
		if (event.phase == TickEvent.Phase.START && !Minecraft.getMinecraft().isGamePaused()) {
			if (this.duration > 0) {
				--this.duration;
			}
		}
	}

	@Nullable
	@SideOnly(Side.CLIENT)
	public RayTraceResult rayTrace(final Entity e, final double blockReachDistance, final float partialTicks) {
		final Vec3d vec3d = e.getPositionEyes(partialTicks);
		final Vec3d vec3d2 = e.getLook(partialTicks);
		final Vec3d vec3d3 = vec3d.addVector(vec3d2.x * blockReachDistance, vec3d2.y * blockReachDistance,
				vec3d2.z * blockReachDistance);
		return this.mc.world.rayTraceBlocks(vec3d, vec3d3, false, true, true);
	}

	public RayTraceResult getMouseOver(final float partialTicks) {
		RayTraceResult objectMouseOver = null;
		final Entity observer = this.mc.getRenderViewEntity();
		if (observer == null || this.mc.world == null) {
			return objectMouseOver;
		}
		this.mc.pointedEntity = null;
		final double targetingRange = LOIConfig.hud.indicatorTargetingRange;
		objectMouseOver = this.rayTrace(observer, targetingRange, partialTicks);
		final Vec3d observerPositionEyes = observer.getPositionEyes(partialTicks);
		double distance = targetingRange;
		if (objectMouseOver != null) {
			distance = objectMouseOver.hitVec.distanceTo(observerPositionEyes);
		}
		final Vec3d lookVector = observer.getLook(partialTicks);
		final Vec3d lookVectorFromEyePosition = observerPositionEyes.addVector(lookVector.x * targetingRange,
				lookVector.y * targetingRange, lookVector.z * targetingRange);
		this.pointedEntity = null;
		Vec3d hitVector = null;
		final List<Entity> list = this.mc.world.getEntitiesInAABBexcluding(
				observer, observer.getEntityBoundingBox().expand(lookVector.x * targetingRange,
						lookVector.y * targetingRange, lookVector.z * targetingRange).expand(1.0, 1.0, 1.0),
				EntitySelectors.NOT_SPECTATING);
		double d2 = distance;
		for (int j = 0; j < list.size(); ++j) {
			final Entity entity1 = list.get(j);
			final AxisAlignedBB axisalignedbb = entity1.getEntityBoundingBox()
					.grow((double) entity1.getCollisionBorderSize());
			final RayTraceResult raytraceresult = axisalignedbb.calculateIntercept(observerPositionEyes,
					lookVectorFromEyePosition);
			if (axisalignedbb.contains(observerPositionEyes)) {
				if (d2 >= 0.0) {
					this.pointedEntity = entity1;
					hitVector = ((raytraceresult == null) ? observerPositionEyes : raytraceresult.hitVec);
					d2 = 0.0;
				}
			} else if (raytraceresult != null) {
				final double d3 = observerPositionEyes.distanceTo(raytraceresult.hitVec);
				if (d3 < d2 || d2 == 0.0) {
					if (entity1.getLowestRidingEntity() == observer.getLowestRidingEntity()
							&& !observer.canRiderInteract()) {
						if (d2 == 0.0) {
							this.pointedEntity = entity1;
							hitVector = raytraceresult.hitVec;
						}
					} else {
						this.pointedEntity = entity1;
						hitVector = raytraceresult.hitVec;
						d2 = d3;
					}
				}
			}
		}
		objectMouseOver = new RayTraceResult(this.pointedEntity, hitVector);
		if (this.pointedEntity instanceof EntityLivingBase) {
			this.mc.pointedEntity = this.pointedEntity;
		}
		return objectMouseOver;
	}

	@SubscribeEvent
	public void onRenderGameOverlay(final RenderGameOverlayEvent.Pre event) {
		final FontRenderer fontRenderer = this.mc.fontRenderer;
		if (Minecraft.isGuiEnabled() && LOIConfig.hud.indicatorEnabled) {
			final RayTraceResult r = this.getMouseOver(1.0F);
			if (r != null && RayTraceResult.Type.ENTITY.equals(r.typeOfHit)
					&& r.entityHit instanceof EntityLivingBase) {
				this.lastEntity = (EntityLivingBase) r.entityHit;
				this.offsetGoal = 0;
				this.duration = LOIConfig.hud.indicatorLockOnDuration;
			}
			if (this.lastEntity != null && this.duration > 0 && this.lastEntity.isEntityAlive()) {
				if (event.getType() == RenderGameOverlayEvent.ElementType.HOTBAR) {
					this.lifeGaugeRenderer.renderMobInfo(this.mc, fontRenderer, this.lastEntity,
							(int) (-this.offset) + LOIConfig.hud.indicatorPosX, LOIConfig.hud.indicatorPosY);
				} else if (event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
					this.lifeGaugeRenderer.renderHealthText(this.lastEntity,
							(int) (-this.offset) + LOIConfig.hud.indicatorPosX, LOIConfig.hud.indicatorPosY);
					this.lifeGaugeRenderer.renderAttackText(this.lastEntity,
							(int) (-this.offset) + LOIConfig.hud.indicatorPosX, LOIConfig.hud.indicatorPosY);
					this.lifeGaugeRenderer.renderDefenseText(this.lastEntity,
							(int) (-this.offset) + LOIConfig.hud.indicatorPosX, LOIConfig.hud.indicatorPosY);
				}
			}
		}
	}
}
package com.axanthic.icaria.client.particle;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaSteamParticle extends TextureSheetParticle {
	public SpriteSet spriteSet;

	public IcariaSteamParticle(ClientLevel pClientLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed, SpriteSet pSpriteSet) {
		super(pClientLevel, pX, pY, pZ);
		this.spriteSet = pSpriteSet;
		this.xd = pXSpeed;
		this.yd = pYSpeed;
		this.zd = pZSpeed;
		this.lifetime = 80;
		this.quadSize = (this.random.nextFloat() * 0.5F + 0.5F) * 0.25F;
		this.setSize(0.1F, 0.1F);
		this.setSpriteFromAge(pSpriteSet);
	}

	@Override
	public void tick() {
		this.xo = this.x;
		this.yo = this.y;
		this.zo = this.z;
		if (this.age++ >= this.lifetime) {
			this.remove();
		} else {
			this.yd += 0.0005D;
			this.move(this.xd, this.yd, this.zd);
			this.setSpriteFromAge(this.spriteSet);
		}
	}

	@Override
	public ParticleRenderType getRenderType() {
		return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
	}
}

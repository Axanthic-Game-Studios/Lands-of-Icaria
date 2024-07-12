package com.axanthic.icaria.client.particle;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaSteamParticle extends TextureSheetParticle {
	public SpriteSet set;

	public IcariaSteamParticle(ClientLevel pLevel, double pX, double pY, double pZ, double pSpeedX, double pSpeedY, double pSpeedZ, SpriteSet pSet) {
		super(pLevel, pX, pY, pZ);
		this.set = pSet;
		this.xd = pSpeedX;
		this.yd = pSpeedY;
		this.zd = pSpeedZ;
		this.lifetime = 80;
		this.quadSize = (this.random.nextFloat() * 0.5F + 0.5F) * 0.25F;
		this.setSize(0.1F, 0.1F);
		this.setSpriteFromAge(pSet);
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
			this.setSpriteFromAge(this.set);
		}
	}

	@Override
	public ParticleRenderType getRenderType() {
		return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
	}
}

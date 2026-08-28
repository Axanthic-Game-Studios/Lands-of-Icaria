package com.axanthic.icaria.client.particle;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.SingleQuadParticle;
import net.minecraft.client.particle.SpriteSet;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaBubbleParticle extends SingleQuadParticle {
	public SpriteSet spriteSet;

	public IcariaBubbleParticle(ClientLevel pClientLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed, SpriteSet pSpriteSet) {
		super(pClientLevel, pX, pY, pZ, pSpriteSet.first());
		this.spriteSet = pSpriteSet;
		this.xd = pXSpeed;
		this.yd = pYSpeed;
		this.zd = pZSpeed;
		this.lifetime = 20;
		this.quadSize = (this.random.nextFloat() * 0.5F + 0.5F) * 0.05F;
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
	public Layer getLayer() {
		return Layer.TRANSLUCENT;
	}
}

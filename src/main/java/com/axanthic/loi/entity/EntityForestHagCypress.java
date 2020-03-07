package com.axanthic.loi.entity;

import net.minecraft.world.World;

public class EntityForestHagCypress extends EntityForestHag {

	public EntityForestHagCypress(World worldIn) {
		super(worldIn, 2);
		this.setSize(0.8f, 2.9f);
		this.eyeHeight = 2.4f;
	}
}

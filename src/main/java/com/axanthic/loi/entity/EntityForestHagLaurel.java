package com.axanthic.loi.entity;

import net.minecraft.world.World;

public class EntityForestHagLaurel extends EntityForestHag {

	public EntityForestHagLaurel(World worldIn) {
		super(worldIn, 5);
		this.setSize(0.9f, 2.55f);
		this.eyeHeight = 2.2f;
	}
}

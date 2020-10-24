package com.axanthic.loi.entity;

import net.minecraft.world.World;

public class EntityForestHagPopulus extends EntityForestHag {

	public EntityForestHagPopulus(World worldIn) {
		super(worldIn, 1);
		this.setSize(0.8f, 2.5f);
		this.eyeHeight = 2.25f;
	}
}

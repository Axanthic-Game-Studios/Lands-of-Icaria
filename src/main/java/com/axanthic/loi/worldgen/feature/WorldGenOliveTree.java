package com.axanthic.loi.worldgen.feature;

import com.axanthic.blab.Resources;

public class WorldGenOliveTree extends WorldGenLOITree {

	public WorldGenOliveTree(boolean notify) {
		super(notify);
	}

	public WorldGenOliveTree init() {
		this.TRUNK = Resources.olive.log.getBlock().getDefaultState();
		this.LEAF = Resources.olive.leaf.getBlock().getDefaultState();
		return this;
	}
}

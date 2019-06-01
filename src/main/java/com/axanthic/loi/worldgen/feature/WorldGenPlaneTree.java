package com.axanthic.loi.worldgen.feature;

import com.axanthic.blab.Resources;

public class WorldGenPlaneTree extends WorldGenLOITree {

	public WorldGenPlaneTree(boolean notify) {
		super(notify);
	}

	public WorldGenPlaneTree init() {
		this.TRUNK = Resources.plane.log.getBlock().getDefaultState();
		this.LEAF = Resources.plane.leaf.getBlock().getDefaultState();
		return this;
	}
}

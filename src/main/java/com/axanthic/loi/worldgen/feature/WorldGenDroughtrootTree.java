package com.axanthic.loi.worldgen.feature;

import com.axanthic.blab.Resources;

public class WorldGenDroughtrootTree extends WorldGenLOITree {

	public WorldGenDroughtrootTree(boolean notify) {
		super(notify);
	}

	public WorldGenDroughtrootTree init() {
		this.TRUNK = Resources.droughtroot.log.getBlock().getDefaultState();
		this.LEAF = Resources.droughtroot.leaf.getBlock().getDefaultState();
		return this;
	}
}

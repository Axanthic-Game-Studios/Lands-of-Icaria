package com.axanthic.loi.worldgen.feature;

import com.axanthic.blab.Resources;

public class WorldGenFirTree extends WorldGenLOITree {

	public WorldGenFirTree(boolean notify) {
		super(notify);
	}

	public WorldGenFirTree init() {
		this.TRUNK = Resources.fir.log.getBlock().getDefaultState();
		this.LEAF = Resources.fir.leaf.getBlock().getDefaultState();
		return this;
	}
}

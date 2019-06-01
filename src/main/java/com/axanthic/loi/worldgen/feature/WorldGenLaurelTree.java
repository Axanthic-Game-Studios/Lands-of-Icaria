package com.axanthic.loi.worldgen.feature;

import com.axanthic.blab.Resources;

public class WorldGenLaurelTree extends WorldGenLOITree {

	public WorldGenLaurelTree(boolean notify) {
		super(notify);
	}

	public WorldGenLaurelTree init() {
		this.TRUNK = Resources.laurel.log.getBlock().getDefaultState();
		this.LEAF = Resources.laurel.leaf.getBlock().getDefaultState();
		return this;
	}
}

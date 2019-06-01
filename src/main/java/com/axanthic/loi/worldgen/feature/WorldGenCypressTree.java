package com.axanthic.loi.worldgen.feature;

import com.axanthic.blab.Resources;

public class WorldGenCypressTree extends WorldGenLOITree {

	public WorldGenCypressTree(boolean notify) {
		super(notify);
	}

	public WorldGenCypressTree init() {
		this.TRUNK = Resources.cypress.log.getBlock().getDefaultState();
		this.LEAF = Resources.cypress.leaf.getBlock().getDefaultState();
		return this;
	}
}

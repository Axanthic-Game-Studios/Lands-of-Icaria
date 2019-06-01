package com.axanthic.loi.worldgen.feature;

import com.axanthic.blab.Resources;

public class WorldGenPopulusTree extends WorldGenLOITree {

	public WorldGenPopulusTree(boolean notify) {
		super(notify);
	}

	public WorldGenPopulusTree init() {
		this.TRUNK = Resources.populus.log.getBlock().getDefaultState();
		this.LEAF = Resources.populus.leaf.getBlock().getDefaultState();
		return this;
	}
}

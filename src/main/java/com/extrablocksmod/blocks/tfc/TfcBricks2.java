package com.extrablocksmod.blocks.tfc;

import com.extrablocksmod.blocks.AbstractMetaBlock;
import com.extrablocksmod.blocks.blockstates.BlockStates;
import com.extrablocksmod.blocks.blockstates.TfcBlocktypes2;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;

public class TfcBricks2 extends AbstractMetaBlock<TfcBlocktypes2> {

	public TfcBricks2() {
		super(Material.ROCK, "tfcbricks2");
	}

	@Override
	protected TfcBlocktypes2 getDefaultStateVariant() {
		return TfcBlocktypes2.Rhyolite;
	}

	@Override
	protected TfcBlocktypes2 fromMeta(int meta) {
		return TfcBlocktypes2.fromMeta(meta);
	}

	@Override
	protected PropertyEnum<TfcBlocktypes2> getVariantEnum() {
		return BlockStates.TfcStones2;
	}
}

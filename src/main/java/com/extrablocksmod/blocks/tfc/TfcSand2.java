package com.extrablocksmod.blocks.tfc;

import com.extrablocksmod.blocks.AbstractFallingMetaBlock;
import com.extrablocksmod.blocks.blockstates.BlockStates;
import com.extrablocksmod.blocks.blockstates.TfcBlocktypes2;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;

public class TfcSand2  extends AbstractFallingMetaBlock<TfcBlocktypes2> {

	public TfcSand2() {
		super(Material.ROCK, "tfcsand2");
		setHarvestLevel("shovel", 0);
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

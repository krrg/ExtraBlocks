package com.extrablocksmod.blocks.tfc;

import com.extrablocksmod.blocks.AbstractMetaBlock;
import com.extrablocksmod.blocks.blockstates.BlockStates;
import com.extrablocksmod.blocks.blockstates.TfcBlocktypes1;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;

public class TfcSmooth extends AbstractMetaBlock<TfcBlocktypes1> {

	public TfcSmooth() {
		super(Material.ROCK, "tfcsmooth");
	}

	@Override
	protected TfcBlocktypes1 getDefaultStateVariant() {
		return TfcBlocktypes1.Andesite;
	}

	@Override
	protected TfcBlocktypes1 fromMeta(int meta) {
		return TfcBlocktypes1.fromMeta(meta);
	}

	@Override
	protected PropertyEnum<TfcBlocktypes1> getVariantEnum() {
		return BlockStates.TfcStones1;
	}
}
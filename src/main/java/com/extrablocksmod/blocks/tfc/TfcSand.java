package com.extrablocksmod.blocks.tfc;

import com.extrablocksmod.blocks.AbstractFallingMetaBlock;
import com.extrablocksmod.blocks.blockstates.BlockStates;
import com.extrablocksmod.blocks.blockstates.TfcBlocktypes1;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;

public class TfcSand extends AbstractFallingMetaBlock<TfcBlocktypes1> {

	public TfcSand() {
		super(Material.ROCK, "tfcsand");
		setHarvestLevel("shovel", 0);
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
package com.extrablocksmod.blocks.blockstates;

import com.extrablocksmod.blocks.IVariantDefinition;

import net.minecraft.util.IStringSerializable;

public enum TfcBlocktypes1 implements IStringSerializable, IVariantDefinition {
	Andesite(0, "andesite"),
	Basalt(1, "basalt"),
	Chalk(2, "chalk"),
	Chert(3, "chert"),
	Claystone(4, "claystone"),
	Conglomerate(5, "conglomerate"),
	Dacite(6, "dacite"),
	Diorite(7, "diorite"),
	Dolomite(8, "dolomite"),
	Gabbro(9, "gabbro"),
	Gneiss(10, "gneiss"),
	Granite(11, "granite"),
	Limestone(12, "limestone"),
	Marble(13, "marble"),
	Phyllite(14, "phyllite"),
	Quartzite(15, "quartzite");
	
	private final int meta;
	private final String name;
	
	private TfcBlocktypes1(int id, String name) {
		this.meta = id;
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}
	
	public int getMeta() {
		return meta;
	}
	
	public static TfcBlocktypes1 fromMeta(int meta) {
		for (TfcBlocktypes1 type : TfcBlocktypes1.values()) {
			if (type.getMeta() == meta) {
				return type;
			}
		}
		
		throw new IllegalArgumentException("meta cannot be " + meta);
	}

	@Override
	public String getVariantName() {
		return "type";
	}
}

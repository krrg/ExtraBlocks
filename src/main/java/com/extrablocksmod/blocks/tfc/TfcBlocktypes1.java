package com.extrablocksmod.blocks.tfc;

import net.minecraft.util.IStringSerializable;

public enum TfcBlocktypes1 implements IStringSerializable {
	Andesite(0, "andesite"),
	Basalt(1, "basalt");
//	Chalk(2, "chalk"),
//	Chert(3, "chert"),
//	Claystone(4, "claystone"),
//	Conglomerate(5, "conglomerate"),
//	Dacite(6, "dacite"),
//	Diorite(7, "diorite"),
//	Dolomite(8, "dolomite"),
//	Gneiss(9, "gneiss"),
//	Granite(10, "granite"),
//	Limestone(11, "limestone"),
//	Marble(12, "marble"),
//	Phyllite(13, "phyllite"),
//	Quartzite(14, "quartzite"),
//	Rhyolite(15, "rhyolite");
	
	private final int id;
	private final String name;
	
	private TfcBlocktypes1(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
	}
	
	public static TfcBlocktypes1 fromMeta(int meta) {
		for (TfcBlocktypes1 type : TfcBlocktypes1.values()) {
			if (type.getId() == meta) {
				return type;
			}
		}
		
		throw new IllegalArgumentException("meta cannot be " + meta);
	}

}

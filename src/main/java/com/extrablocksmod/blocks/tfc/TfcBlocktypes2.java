package com.extrablocksmod.blocks.tfc;

import net.minecraft.util.IStringSerializable;

public enum TfcBlocktypes2 implements IStringSerializable {
	RockSalt(0, "Rock salt"),
	Schist(1, "Schist"),
	Shale(2, "Shale"),
	Slate(3, "Slate");
	
	private final int id;
	private final String name;
	
	private TfcBlocktypes2(int id, String name) {
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

	public static TfcBlocktypes2 fromMeta(int meta) {
		for (TfcBlocktypes2 type : TfcBlocktypes2.values()) {
			if (type.getId() == meta) {
				return type;
			}
		}
		
		throw new IllegalArgumentException("meta cannot be " + meta);
	}
}

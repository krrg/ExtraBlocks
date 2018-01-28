package com.extrablocksmod.blocks.blockstates;

import com.extrablocksmod.blocks.IVariantDefinition;

import net.minecraft.util.IStringSerializable;

public enum TfcBlocktypes2 implements IStringSerializable, IVariantDefinition {
	Rhyolite(0, "rhyolite"),
	RockSalt(1, "rock_salt"),
	Schist(2, "schist"),
	Shale(3, "shale"),
	Slate(4, "slate"),
	RedGneiss(5, "redgneiss");

	
	private final int meta;
	private final String name;
	
	private TfcBlocktypes2(int meta, String name) {
		this.meta = meta;
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	public static TfcBlocktypes2 fromMeta(int meta) {
		for (TfcBlocktypes2 type : TfcBlocktypes2.values()) {
			if (type.getMeta() == meta) {
				return type;
			}
		}
		
		throw new IllegalArgumentException("meta cannot be " + meta);
	}

	@Override
	public int getMeta() {
		return meta;
	}

	@Override
	public String getVariantName() {
		return "type";
	}
}

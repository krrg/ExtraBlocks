package com.extrablocksmod.blocks;

import com.extrablocksmod.blocks.tfc.TfcBricks;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks {

public static TfcBricks TfcBricks;
	
	public static void setup() {
		createBlocks();
		registerBlocks();
	}
	
	@SideOnly(Side.CLIENT)
	public static void initModels() {
		TfcBricks.initModel();
	}
	
	private static void createBlocks() {
		TfcBricks = new TfcBricks();
	}
	
	private static void registerBlocks() {
		GameRegistry.register(TfcBricks);
	}
}

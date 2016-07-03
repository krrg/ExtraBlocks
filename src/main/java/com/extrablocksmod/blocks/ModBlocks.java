package com.extrablocksmod.blocks;

import com.extrablocksmod.blocks.tfc.TfcBricks;
import com.extrablocksmod.blocks.tfc.TfcBricks2;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks {

	public static TfcBricks TfcBricks = new TfcBricks();
	public static TfcBricks2 TfcBricks2 = new TfcBricks2();
	
	public static void setup() {
		registerBlocks();
	}
	
	@SideOnly(Side.CLIENT)
	public static void initModels() {
		TfcBricks.initModel();
		TfcBricks2.initModel();
	}
	
	private static void registerBlocks() {
		GameRegistry.register(TfcBricks);
		GameRegistry.register(TfcBricks2);
	}
}

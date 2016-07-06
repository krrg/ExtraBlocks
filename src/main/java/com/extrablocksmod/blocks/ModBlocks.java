package com.extrablocksmod.blocks;

import com.extrablocksmod.blocks.tfc.TfcBricks;
import com.extrablocksmod.blocks.tfc.TfcBricks2;
import com.extrablocksmod.blocks.tfc.TfcCobble;
import com.extrablocksmod.blocks.tfc.TfcCobble2;
import com.extrablocksmod.blocks.tfc.TfcDirt;
import com.extrablocksmod.blocks.tfc.TfcDirt2;
import com.extrablocksmod.blocks.tfc.TfcGravel;
import com.extrablocksmod.blocks.tfc.TfcGravel2;
import com.extrablocksmod.blocks.tfc.TfcRaw;
import com.extrablocksmod.blocks.tfc.TfcRaw2;
import com.extrablocksmod.blocks.tfc.TfcSand;
import com.extrablocksmod.blocks.tfc.TfcSand2;
import com.extrablocksmod.blocks.tfc.TfcSmooth;
import com.extrablocksmod.blocks.tfc.TfcSmooth2;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks {

	public static TfcBricks TfcBricks = new TfcBricks();
	public static TfcBricks2 TfcBricks2 = new TfcBricks2();
	public static TfcCobble TfcCobble = new TfcCobble();
	public static TfcCobble2 TfcCobble2 = new TfcCobble2();
	public static TfcRaw TfcRaw = new TfcRaw();
	public static TfcRaw2 TfcRaw2 = new TfcRaw2();
	public static TfcSmooth TfcSmooth = new TfcSmooth();
	public static TfcSmooth2 TfcSmooth2 = new TfcSmooth2();
	public static TfcDirt TfcDirt = new TfcDirt();
	public static TfcDirt2 TfcDirt2 = new TfcDirt2();
	public static TfcGravel TfcGravel = new TfcGravel();
	public static TfcGravel2 TfcGravel2 = new TfcGravel2();
	public static TfcSand TfcSand = new TfcSand();
	public static TfcSand2 TfcSand2 = new TfcSand2();
	
	public static void setup() {
		registerBlocks();
	}
	
	@SideOnly(Side.CLIENT)
	public static void initModels() {
		TfcBricks.initModel();
		TfcBricks2.initModel();
		TfcCobble.initModel();
		TfcCobble2.initModel();
		TfcRaw.initModel();
		TfcRaw2.initModel();
		TfcSmooth.initModel();
		TfcSmooth2.initModel();
		TfcDirt.initModel();
		TfcDirt2.initModel();
		TfcGravel.initModel();
		TfcGravel2.initModel();
		TfcSand.initModel();
		TfcSand2.initModel();
	}
	
	private static void registerBlocks() {
		GameRegistry.register(TfcBricks);
		GameRegistry.register(TfcBricks2);
		GameRegistry.register(TfcCobble);
		GameRegistry.register(TfcCobble2);
		GameRegistry.register(TfcRaw);
		GameRegistry.register(TfcRaw2);
		GameRegistry.register(TfcSmooth);
		GameRegistry.register(TfcSmooth2);
		GameRegistry.register(TfcDirt);
		GameRegistry.register(TfcDirt2);
		GameRegistry.register(TfcGravel);
		GameRegistry.register(TfcGravel2);
		GameRegistry.register(TfcSand);
		GameRegistry.register(TfcSand2);
	}
}

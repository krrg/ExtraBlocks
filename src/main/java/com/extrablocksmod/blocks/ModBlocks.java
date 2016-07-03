package com.extrablocksmod.blocks;

import com.extrablocksmod.blocks.tfc.TfcBricks;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
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
		
		preInit();
	}
	
	public static void preInit() {
//		reg(TfcBricks, 0, "tfcbricks_andesite");
//		reg(TfcBricks, 0, "tfcbricks_basalt");
	}
	
	public static void reg(Block block, int meta, String file) {
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta, new ModelResourceLocation("extrablocks" + ":" + file, "inventory"));
	}
}

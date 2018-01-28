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

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Arrays;
import java.util.List;

@Mod.EventBusSubscriber
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

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(
				TfcBricks,
				TfcBricks2,
				TfcCobble,
				TfcCobble2,
				TfcRaw,
				TfcRaw2,
				TfcSmooth,
				TfcSmooth2,
				TfcDirt,
				TfcDirt2,
				TfcGravel,
				TfcGravel2,
				TfcSand,
				TfcSand2
		);
	}

	@SubscribeEvent
	public static void registerBlockMetadata(RegistryEvent.Register<Item> event) {
		Arrays.asList(
				TfcBricks,
				TfcBricks2,
				TfcCobble,
				TfcCobble2,
				TfcRaw,
				TfcRaw2,
				TfcSmooth,
				TfcSmooth2,
				TfcDirt,
				TfcDirt2,
				TfcGravel,
				TfcGravel2,
				TfcSand,
				TfcSand2
		).forEach(block-> {
			ItemBlock itemBlock = new ItemBlock(block);
			itemBlock.setRegistryName(block.getRegistryName());
			event.getRegistry().register(itemBlock);
		});
	}
	

}

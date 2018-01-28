package com.extrablocksmod.recipes;

import com.extrablocksmod.ExtraBlocksMod;
import com.extrablocksmod.blocks.ModBlocks;
import com.extrablocksmod.blocks.blockstates.TfcBlocktypes1;
import com.extrablocksmod.blocks.blockstates.TfcBlocktypes2;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {

	public static void setup() {
		addSmeltingForCobblestoneToRawStone();
		addCraftingOfRawStoneToBricks();
	}

	private static void addCraftingOfRawStoneToBricks() {



		for (TfcBlocktypes1 type : TfcBlocktypes1.values()) {
			IBlockState brickState = ModBlocks.TfcBricks.getStateFromMeta(type.getMeta());
			IBlockState rawState = ModBlocks.TfcRaw.getStateFromMeta(type.getMeta());

			System.out.println("[EXTRA BLOCKS] trying to add recipe " + new ItemStack(rawState.getBlock(), 1, type.getMeta()).toString() + " and " + type.getVariantName() + ">" + type.getName());



			ItemStack output = new ItemStack(brickState.getBlock(), 4, type.getMeta());

			GameRegistry.addShapedRecipe(
					new ResourceLocation("extrablocks"),
					null,
					output,
					"RR", "RR", "R", new ItemStack(rawState.getBlock(), 1, type.getMeta())
			);

		}
		
		for (TfcBlocktypes2 type : TfcBlocktypes2.values()) {
			IBlockState brickState = ModBlocks.TfcBricks2.getStateFromMeta(type.getMeta());
			IBlockState rawState = ModBlocks.TfcRaw2.getStateFromMeta(type.getMeta());
			
			ItemStack output = new ItemStack(brickState.getBlock(),4, type.getMeta());

			ResourceLocation resourceLocation = new ResourceLocation(null);
			ResourceLocation group = null;

			GameRegistry.addShapedRecipe(
					new ResourceLocation("extrablocks"),
					null,
					output,
					"RR", "RR", "R", new ItemStack(rawState.getBlock(), 1, type.getMeta())
			);
			
		}
	}
	
	private static void addSmeltingForCobblestoneToRawStone() {
		for (TfcBlocktypes1 type : TfcBlocktypes1.values()) {
			IBlockState cobbleState = ModBlocks.TfcCobble.getStateFromMeta(type.getMeta());
			IBlockState rawState = ModBlocks.TfcRaw.getStateFromMeta(type.getMeta());
			
			ItemStack inStack = new ItemStack(cobbleState.getBlock(), 1, type.getMeta());
			ItemStack outStack = new ItemStack(rawState.getBlock(), 1, type.getMeta());
			GameRegistry.addSmelting(inStack, outStack, 1);
		}
		
		for (TfcBlocktypes2 type : TfcBlocktypes2.values()) {
			IBlockState cobbleState = ModBlocks.TfcCobble2.getStateFromMeta(type.getMeta());
			IBlockState rawState = ModBlocks.TfcRaw2.getStateFromMeta(type.getMeta());
			
			ItemStack inStack = new ItemStack(cobbleState.getBlock(), 1, type.getMeta());
			ItemStack outStack = new ItemStack(rawState.getBlock(), 1, type.getMeta());
			GameRegistry.addSmelting(inStack, outStack, 1);
		}
	}
}

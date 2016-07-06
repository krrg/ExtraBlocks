package com.extrablocksmod.integration;

import com.extrablocksmod.blocks.ModBlocks;
import com.extrablocksmod.blocks.blockstates.TfcBlocktypes1;
import com.extrablocksmod.blocks.blockstates.TfcBlocktypes2;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import team.chisel.api.carving.CarvingUtils;
import team.chisel.api.carving.ICarvingGroup;
import team.chisel.api.carving.ICarvingRegistry;

public class ChiselIntegrations {

	public void integrate() {
		ICarvingRegistry chisel = CarvingUtils.getChiselRegistry();
		if (chisel == null) {
			return;
		}
		
		
		ICarvingGroup cobbleGroup = getGroup(chisel, Blocks.COBBLESTONE.getDefaultState());
		ICarvingGroup stoneGroup = getGroup(chisel, Blocks.STONE.getDefaultState());
		ICarvingGroup dirtGroup = getGroup(chisel, Blocks.DIRT.getDefaultState());
		
		ICarvingGroup sandGroup = CarvingUtils.getDefaultGroupFor(Blocks.SAND.getDefaultState().toString());
		ICarvingGroup gravelGroup = CarvingUtils.getDefaultGroupFor(Blocks.GRAVEL.getDefaultState().toString());
		
		chisel.addGroup(sandGroup);
		chisel.addGroup(gravelGroup);
		
		chisel.addVariation(sandGroup.getName(), Blocks.SAND.getDefaultState(), 1);
		chisel.addVariation(gravelGroup.getName(), Blocks.GRAVEL.getDefaultState(), 1);
		
		for (TfcBlocktypes1 type : TfcBlocktypes1.values()) {
			IBlockState cobblestate = ModBlocks.TfcCobble.getStateFromMeta(type.getMeta());
			IBlockState brickState = ModBlocks.TfcBricks.getStateFromMeta(type.getMeta());
			IBlockState smoothState = ModBlocks.TfcSmooth.getStateFromMeta(type.getMeta());
			IBlockState rawState = ModBlocks.TfcRaw.getStateFromMeta(type.getMeta());
			IBlockState sandState = ModBlocks.TfcSand.getStateFromMeta(type.getMeta());
			IBlockState dirtState = ModBlocks.TfcDirt.getStateFromMeta(type.getMeta());
			IBlockState gravelState = ModBlocks.TfcGravel.getStateFromMeta(type.getMeta());
			
			chisel.addVariation(cobbleGroup.getName(), cobblestate, 99);
			chisel.addVariation(stoneGroup.getName(), brickState, 99);
			chisel.addVariation(stoneGroup.getName(), smoothState, 99);
			chisel.addVariation(stoneGroup.getName(), rawState, 99);
			chisel.addVariation(sandGroup.getName(), sandState, 99);
			chisel.addVariation(dirtGroup.getName(), dirtState, 99);
			chisel.addVariation(gravelGroup.getName(), gravelState, 99);
		}
		
		for (TfcBlocktypes2 type : TfcBlocktypes2.values()) {
			IBlockState cobblestate = ModBlocks.TfcCobble2.getStateFromMeta(type.getMeta());
			IBlockState brickState = ModBlocks.TfcBricks2.getStateFromMeta(type.getMeta());
			IBlockState smoothState = ModBlocks.TfcSmooth2.getStateFromMeta(type.getMeta());
			IBlockState rawState = ModBlocks.TfcRaw2.getStateFromMeta(type.getMeta());
			IBlockState sandState = ModBlocks.TfcSand2.getStateFromMeta(type.getMeta());
			IBlockState dirtState = ModBlocks.TfcDirt2.getStateFromMeta(type.getMeta());
			IBlockState gravelState = ModBlocks.TfcGravel2.getStateFromMeta(type.getMeta());
			
			chisel.addVariation(cobbleGroup.getName(), cobblestate, 99);
			chisel.addVariation(stoneGroup.getName(), brickState, 99);
			chisel.addVariation(stoneGroup.getName(), smoothState, 99);
			chisel.addVariation(stoneGroup.getName(), rawState, 99);
			chisel.addVariation(sandGroup.getName(), sandState, 99);
			chisel.addVariation(dirtGroup.getName(), dirtState, 99);
			chisel.addVariation(gravelGroup.getName(), gravelState, 99);
		}
	}
	
	private ICarvingGroup getGroup(ICarvingRegistry chisel, IBlockState state) {
		ICarvingGroup group = chisel.getGroup(state);
		if (group != null) {
			return group;
		}
		
		return CarvingUtils.getDefaultGroupFor(state.toString());
	}
}

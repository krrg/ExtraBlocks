package com.extrablocksmod.integration;

import java.util.ArrayList;
import java.util.List;

import com.extrablocksmod.blocks.ModBlocks;
import com.extrablocksmod.blocks.blockstates.TfcBlocktypes1;
import com.extrablocksmod.blocks.blockstates.TfcBlocktypes2;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import team.chisel.api.carving.CarvingUtils;
import team.chisel.api.carving.CarvingUtils.SimpleCarvingVariation;
import team.chisel.api.carving.ICarvingGroup;
import team.chisel.api.carving.ICarvingRegistry;

public class ChiselIntegrations {

	public void integrate() {
		ICarvingRegistry chisel = CarvingUtils.getChiselRegistry();
		if (chisel == null) {
			return;
		}
		
		ICarvingGroup cobbleGroup = chisel.getGroup(Blocks.COBBLESTONE.getDefaultState());
		ICarvingGroup stoneGroup = chisel.getGroup(Blocks.STONE.getDefaultState());
		
		List<ICarvingGroup> reverseCobbleGroups = new ArrayList<ICarvingGroup>();
		LIst<ICarvingGroup> reverseStoneGroups = new ArrayList<ICarvingGroup>();
		
		for (TfcBlocktypes1 type : TfcBlocktypes1.values()) {
			IBlockState cobblestate = ModBlocks.TfcCobble.getStateFromMeta(type.getMeta());
			IBlockState brickState = ModBlocks.TfcBricks.getStateFromMeta(type.getMeta());
			
			cobbleGroup.addVariation(new SimpleCarvingVariation(cobblestate, 99));
			stoneGroup.addVariation(new SimpleCarvingVariation(brickState, 99));
			
			
		}
		
		for (TfcBlocktypes2 type : TfcBlocktypes2.values()) {
			IBlockState cobblestate = ModBlocks.TfcCobble2.getStateFromMeta(type.getMeta());
			IBlockState brickState = ModBlocks.TfcBricks2.getStateFromMeta(type.getMeta());
			
			cobbleGroup.addVariation(new SimpleCarvingVariation(cobblestate, 99));
			stoneGroup.addVariation(new SimpleCarvingVariation(brickState, 99));
		}
	}
}

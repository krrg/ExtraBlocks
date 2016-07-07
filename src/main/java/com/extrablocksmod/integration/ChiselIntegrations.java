package com.extrablocksmod.integration;

import com.extrablocksmod.blocks.ModBlocks;
import com.extrablocksmod.blocks.blockstates.BlockStates;
import com.extrablocksmod.blocks.blockstates.TfcBlocktypes1;
import com.extrablocksmod.blocks.blockstates.TfcBlocktypes2;

import net.minecraft.block.BlockStone;
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
		
		ICarvingGroup cobbleGroup = getGroup(chisel, "cobblestone");
		ICarvingGroup stoneGroup = getGroup(chisel, "stone");
		ICarvingGroup dirtGroup = getGroup(chisel, "dirt");
		ICarvingGroup brickGroup = getGroup(chisel, "stonebrick");
		
		ICarvingGroup sandGroup = getGroup(chisel, "sand");
		ICarvingGroup gravelGroup = getGroup(chisel, "gravel");
		
		chisel.addGroup(sandGroup);
		chisel.addGroup(gravelGroup);
		
		chisel.addVariation(sandGroup.getName(), Blocks.SAND.getDefaultState(), 1);
		chisel.addVariation(gravelGroup.getName(), Blocks.GRAVEL.getDefaultState(), 1);
		
		addChiselGroupForAndesite(chisel);
		addChiselGroupForGranite(chisel);
		addChiselGroupForDiorite(chisel);
		
		for (TfcBlocktypes1 type : TfcBlocktypes1.values()) {
			IBlockState cobblestate = ModBlocks.TfcCobble.getStateFromMeta(type.getMeta());
			IBlockState brickState = ModBlocks.TfcBricks.getStateFromMeta(type.getMeta());
			IBlockState smoothState = ModBlocks.TfcSmooth.getStateFromMeta(type.getMeta());
			IBlockState rawState = ModBlocks.TfcRaw.getStateFromMeta(type.getMeta());
			IBlockState sandState = ModBlocks.TfcSand.getStateFromMeta(type.getMeta());
			IBlockState dirtState = ModBlocks.TfcDirt.getStateFromMeta(type.getMeta());
			IBlockState gravelState = ModBlocks.TfcGravel.getStateFromMeta(type.getMeta());
			
			chisel.addVariation(cobbleGroup.getName(), cobblestate, 99);
			chisel.addVariation(brickGroup.getName(), brickState, 99);
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
			chisel.addVariation(brickGroup.getName(), brickState, 99);
			chisel.addVariation(stoneGroup.getName(), smoothState, 99);
			chisel.addVariation(stoneGroup.getName(), rawState, 99);
			chisel.addVariation(sandGroup.getName(), sandState, 99);
			chisel.addVariation(dirtGroup.getName(), dirtState, 99);
			chisel.addVariation(gravelGroup.getName(), gravelState, 99);
		}
	}

	private void addChiselGroupForDiorite(ICarvingRegistry chisel) {
		ICarvingGroup dioriteGroup = getGroup(chisel, "diorite");
		chisel.addVariation(dioriteGroup.getName(), Blocks.STONE.getBlockState().getBaseState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.DIORITE), 1);
		chisel.addVariation(dioriteGroup.getName(), Blocks.STONE.getBlockState().getBaseState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.DIORITE_SMOOTH), 1);
		chisel.addVariation(dioriteGroup.getName(), ModBlocks.TfcRaw.getBlockState().getBaseState().withProperty(BlockStates.TfcStones1, TfcBlocktypes1.Diorite), 2);
		chisel.addVariation(dioriteGroup.getName(), ModBlocks.TfcSmooth.getBlockState().getBaseState().withProperty(BlockStates.TfcStones1, TfcBlocktypes1.Diorite), 2);
		chisel.addVariation(dioriteGroup.getName(), ModBlocks.TfcBricks.getBlockState().getBaseState().withProperty(BlockStates.TfcStones1, TfcBlocktypes1.Diorite), 2);
		chisel.addVariation(dioriteGroup.getName(), ModBlocks.TfcCobble.getBlockState().getBaseState().withProperty(BlockStates.TfcStones1, TfcBlocktypes1.Diorite), 2);
	}

	private void addChiselGroupForGranite(ICarvingRegistry chisel) {
		ICarvingGroup graniteGroup = getGroup(chisel, "granite");
		chisel.addVariation(graniteGroup.getName(), Blocks.STONE.getBlockState().getBaseState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.GRANITE), 1);
		chisel.addVariation(graniteGroup.getName(), Blocks.STONE.getBlockState().getBaseState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.GRANITE_SMOOTH), 1);
		chisel.addVariation(graniteGroup.getName(), ModBlocks.TfcRaw.getBlockState().getBaseState().withProperty(BlockStates.TfcStones1, TfcBlocktypes1.Granite), 2);
		chisel.addVariation(graniteGroup.getName(), ModBlocks.TfcSmooth.getBlockState().getBaseState().withProperty(BlockStates.TfcStones1, TfcBlocktypes1.Granite), 2);
		chisel.addVariation(graniteGroup.getName(), ModBlocks.TfcBricks.getBlockState().getBaseState().withProperty(BlockStates.TfcStones1, TfcBlocktypes1.Granite), 2);
		chisel.addVariation(graniteGroup.getName(), ModBlocks.TfcCobble.getBlockState().getBaseState().withProperty(BlockStates.TfcStones1, TfcBlocktypes1.Granite), 2);
	}

	private void addChiselGroupForAndesite(ICarvingRegistry chisel) {
		ICarvingGroup andesiteGroup = getGroup(chisel, "andesite");
		chisel.addVariation(andesiteGroup.getName(), Blocks.STONE.getBlockState().getBaseState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.ANDESITE), 1);
		chisel.addVariation(andesiteGroup.getName(), Blocks.STONE.getBlockState().getBaseState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.ANDESITE_SMOOTH), 1);
		chisel.addVariation(andesiteGroup.getName(), ModBlocks.TfcRaw.getBlockState().getBaseState().withProperty(BlockStates.TfcStones1, TfcBlocktypes1.Andesite), 2);
		chisel.addVariation(andesiteGroup.getName(), ModBlocks.TfcSmooth.getBlockState().getBaseState().withProperty(BlockStates.TfcStones1, TfcBlocktypes1.Andesite), 2);
		chisel.addVariation(andesiteGroup.getName(), ModBlocks.TfcBricks.getBlockState().getBaseState().withProperty(BlockStates.TfcStones1, TfcBlocktypes1.Andesite), 2);
		chisel.addVariation(andesiteGroup.getName(), ModBlocks.TfcCobble.getBlockState().getBaseState().withProperty(BlockStates.TfcStones1, TfcBlocktypes1.Andesite), 2);
	}
	
	private ICarvingGroup getGroup(ICarvingRegistry chisel, String name) {
		ICarvingGroup group = CarvingUtils.getDefaultGroupFor(name);
		chisel.addGroup(group);
		return group;
	}
}

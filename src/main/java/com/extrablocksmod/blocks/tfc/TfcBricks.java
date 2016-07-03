package com.extrablocksmod.blocks.tfc;

import java.util.List;

import com.extrablocksmod.blocks.IMetaBlockName;
import com.extrablocksmod.blocks.ItemBlockMeta;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TfcBricks extends Block implements IMetaBlockName{

	public static final PropertyEnum<TfcBlocktypes1> TYPE = PropertyEnum.create("type", TfcBlocktypes1.class);
	
	public TfcBricks() {
		super(Material.ROCK);
		this.setUnlocalizedName("tfcbricks");
		this.setRegistryName("tfcbricks");
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        this.setHardness(1.5F);
        this.setResistance(10.0F);
		this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, TfcBlocktypes1.Andesite));
		GameRegistry.register(new ItemBlockMeta(this));
	}
	
	@SideOnly(Side.CLIENT)
    public void initModel() {
		for (TfcBlocktypes1 type : TfcBlocktypes1.values()) {
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), type.getId(), new ModelResourceLocation(getRegistryName(), type.getName()));
		}
    }
	
	@Override
	protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] { TYPE });
    }

	@Override
	public IBlockState getStateFromMeta(int meta) {
	    return getDefaultState().withProperty(TYPE, TfcBlocktypes1.fromMeta(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		TfcBlocktypes1 type = state.getValue(TYPE);
	    return type.getId();
	}
	
	@Override
	public int damageDropped(IBlockState state) {
	    return getMetaFromState(state);
	}
	
	@Override
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list) {
		for (int meta = 0; meta < TfcBlocktypes1.values().length; meta++) {
			list.add(new ItemStack(itemIn, 1, meta)); 
		}
	}

	@Override
	public String getSpecialName(ItemStack stack) {
		return TfcBlocktypes1.fromMeta(stack.getItemDamage()).getName();
	}
	
	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
	    return new ItemStack(Item.getItemFromBlock(this), 1, this.getMetaFromState(world.getBlockState(pos)));
	}
}

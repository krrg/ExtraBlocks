package com.extrablocksmod.blocks;

import java.util.Collection;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
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
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class AbstractFallingMetaBlock<T extends Enum<T> & IStringSerializable & IVariantDefinition> extends BlockFalling implements IMetaBlockName{

	private final Collection<T> variantValues;
	
	protected AbstractFallingMetaBlock(Material materialIn, String registryName) {
		super(materialIn);
		
		variantValues = getVariantEnum().getAllowedValues();
		
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        setHardness(1.5F);
        setResistance(10.0F);
        
        setDefaultState(this.blockState.getBaseState().withProperty(getVariantEnum(), getDefaultStateVariant()));
        setRegistryName(registryName);
        setUnlocalizedName("extrablocks:" + registryName);
	}

	@SubscribeEvent
	public void registerBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().register(this);
	}
	
	protected abstract T getDefaultStateVariant();
	
	protected abstract PropertyEnum<T> getVariantEnum();
	
	protected abstract T fromMeta(int meta);
	
	@SideOnly(Side.CLIENT)
    public void initModel() {
		for (T variant : variantValues) {
			ModelResourceLocation modelResourceLocation = new ModelResourceLocation(getRegistryName(), variant.getVariantName() + "=" + variant.getName());
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), variant.getMeta(), modelResourceLocation);
		}
    }
	
	@Override
	protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] { getVariantEnum() });
    }
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
	    return getDefaultState().withProperty(getVariantEnum(), fromMeta(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		T type = state.getValue(getVariantEnum());
	    return type.getMeta();
	}
	
	@Override
	public int damageDropped(IBlockState state) {
	    return getMetaFromState(state);
	}
	
//	@Override
//	public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list) {
//		for (T variant : variantValues) {
//			list.add(new ItemStack(itemIn, 1, variant.getMeta()));
//		}
//	}

	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
		for (T variant: variantValues) {
			items.add(new ItemStack(this, 1, variant.getMeta()));
		}
	}

	@Override
	public String getSpecialName(ItemStack stack) {
		return fromMeta(stack.getItemDamage()).getName();
	}
	
	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
	    return new ItemStack(Item.getItemFromBlock(this), 1, this.getMetaFromState(world.getBlockState(pos)));
	}
}

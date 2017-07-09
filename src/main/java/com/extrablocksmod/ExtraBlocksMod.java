package com.extrablocksmod;

import com.extrablocksmod.blocks.ModBlocks;
import com.extrablocksmod.integration.ChiselIntegrations;
import com.extrablocksmod.recipes.ModRecipes;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Constants.ModId, name=Constants.ModId, version=Constants.Version, dependencies=Constants.Dependencies)
public class ExtraBlocksMod {
	
	@SidedProxy
    public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.preInit(event);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init(event);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
	}
	
	public static class CommonProxy {
		public CommonProxy() {
		}
		
		public void preInit(FMLPreInitializationEvent e) {
	        ModBlocks.setup();
	    }

	    public void init(FMLInitializationEvent e) {
	    	ModRecipes.setup();
	    }

	    public void postInit(FMLPostInitializationEvent e) {
	    	 if (Loader.isModLoaded("chisel")) {
	    		 new ChiselIntegrations().integrate();
	    	 }
	    }
	}
	
	public static class ClientProxy extends CommonProxy {
		
		public ClientProxy() {
		}
		
		@Override
	    public void preInit(FMLPreInitializationEvent e) {
	        super.preInit(e);

	        ModBlocks.initModels();
	    }
	}
	
	public static class ServerProxy extends CommonProxy {
		
		public ServerProxy() {
		}
	}
}
package com.cpu.chiselbp.compat;

import codechicken.nei.api.API;
import cpw.mods.fml.common.Loader;

public class ChiselNEI {

    public static ChiselRecipeHandler handler;

    public static void load() {

        if(!Loader.isModLoaded("NotEnoughItems"))return;

        System.out.println("Loading Chisel NEI Compat.");

        handler = new ChiselRecipeHandler();

        API.registerRecipeHandler(handler);
        API.registerUsageHandler(handler);
    }
}

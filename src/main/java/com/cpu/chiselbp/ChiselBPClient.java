package com.cpu.chiselbp;


import com.cpu.chiselbp.bputils.external.InterpolatedIcon;
import cpw.mods.fml.client.registry.RenderingRegistry;
import info.jbcs.minecraft.chisel.BPEmissiveBlockRenderer;

public class ChiselBPClient extends Proxy {
    public void preInit() {

        InterpolatedIcon.init();
    }

    public void init() {
        RenderingRegistry.registerBlockHandler(new LayeredBlockRenderer());
        RenderingRegistry.registerBlockHandler(new BPEmissiveBlockRenderer());
        RenderingRegistry.registerBlockHandler(new CTMBlockRenderer());
    }
}

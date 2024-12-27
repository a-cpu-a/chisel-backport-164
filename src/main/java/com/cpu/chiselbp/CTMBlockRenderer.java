package com.cpu.chiselbp;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import info.jbcs.minecraft.chisel.BPRenderingUtilsCTM;
import info.jbcs.minecraft.utilities.Drawing;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.IBlockAccess;

import static info.jbcs.minecraft.chisel.BPRenderingUtilsCTM.rendererBP;

public class CTMBlockRenderer implements ISimpleBlockRenderingHandler {
    public static int id;
    public CTMBlockRenderer(){
        id= RenderingRegistry.getNextAvailableRenderId();
    }


    @Override
    public void renderInventoryBlock(Block block, int metadata, int model, RenderBlocks renderer) {
        BPRenderingUtilsCTM.renderInventoryBlockInit(block,metadata,renderer);
        Drawing.drawBlock(block,metadata,renderer);
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int model, RenderBlocks renderer) {

        int a = BPRenderingUtilsCTM.renderWorldBlockInit(world,x,y,z,block,renderer);

        if(a==1)
            BPRenderingUtilsCTM.rendererBP.func_78578_a(block,x,y,z,1.0f,1.0f,1.0f);
        else if(a==2)
            renderer.func_78570_q(block,x,y,z);
        else if(a==3)
            rendererBP.func_78578_a(block,x,y,z,1.0f,1.0f,1.0f);

        BPRenderingUtilsCTM.renderWorldBlockDone(a,world,x,y,z,block,renderer);

        return true;
    }

    @Override
    public boolean shouldRender3DInInventory() {
        return true;
    }

    @Override
    public int getRenderId() {
        return id;
    }
}

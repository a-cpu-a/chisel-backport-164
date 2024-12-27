package com.cpu.chiselbp;

import com.cpu.chiselbp.bputils.BPDrawing;
import com.cpu.chiselbp.bputils.Color3;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import info.jbcs.minecraft.chisel.BPRenderingUtilsCTM;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.IBlockAccess;
import org.lwjgl.opengl.GL11;

import static info.jbcs.minecraft.chisel.BPRenderingUtilsCTM.rendererBP;

public class LayeredBlockRenderer implements ISimpleBlockRenderingHandler {
    public static int renderpass = 0;

    public static int id;
    public LayeredBlockRenderer(){
        id= RenderingRegistry.getNextAvailableRenderId();
    }
    static float bot=0.0f,top=1.0f;

    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
        if(!(block instanceof ILayeredBlock))return;
        ILayeredBlock bl = (ILayeredBlock) block;

        //renderer.field_78677_m = false;
        //renderer.field_78674_ar = 0.5f;
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);

        //Tessellator tes = Tessellator.field_78398_a;
        //tes.func_78369_a(1.0f,0.2f,0.5f,0.5f);

        renderer.func_83020_a(bot, bot, bot, top, top, top);
        Color3 underlayColor = bl.getUnderlayColor(metadata);
        Color3 overlayColor = bl.getOverlayColor(metadata);
        int emissivity = bl.getEmissiveProps(metadata);

        boolean uEmissive =(emissivity&1)!=0;
        boolean oEmissive =(emissivity&2)!=0;

        if(uEmissive)
            GL11.glDisable(GL11.GL_LIGHTING);
        BPDrawing.drawBlock(block,bl.getItemUnderlayIcon(metadata),underlayColor,uEmissive, renderer);
        if(!uEmissive && oEmissive)
            GL11.glDisable(GL11.GL_LIGHTING);
        else if(uEmissive && !oEmissive)
            GL11.glEnable(GL11.GL_LIGHTING);
        BPDrawing.drawBlock(block,bl.getItemOverlayIcon(metadata),overlayColor,oEmissive, renderer);
        if(oEmissive)
            GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_BLEND);
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        if(!(block instanceof ILayeredBlock))return false;
        ILayeredBlock bl = (ILayeredBlock) block;

        int metadata = world.func_72805_g(x,y,z);

        Color3 underlayColor = bl.getUnderlayColor(metadata);
        Color3 overlayColor = bl.getOverlayColor(metadata);

        boolean multiPass = block.func_71856_s_()==1;

        int emissivity = bl.getEmissiveProps(metadata);
        boolean uEmissive =(emissivity&1)!=0;
        boolean oEmissive =(emissivity&2)!=0;

        if(!multiPass || renderpass==0)
        {
            renderer.func_83020_a(bot, bot, bot, top, top, top);
            renderer.field_78664_d = bl.getBlockUnderlay(metadata);
            if(uEmissive)
                renderer.func_78609_c(block, x, y, z,underlayColor.r,underlayColor.g,underlayColor.b);
            else
                renderer.func_78570_q(block,x,y,z);
            renderer.field_78664_d = null;
        }
        if(!multiPass || renderpass==1)
        {
            renderpass = 1;
            int a = BPRenderingUtilsCTM.renderWorldBlockInit(world,x,y,z,block,renderer);

            if(a==1)
            {
                //BPRenderingUtilsCTM.rendererCTM.func_83020_a(bot-0.001f, bot-0.001f, bot-0.001f, top+0.001f, top+0.001f, top+0.001f);
                BPRenderingUtilsCTM.rendererBP.func_78578_a(block,x,y,z,overlayColor.r,overlayColor.g,overlayColor.b);
            }
            else if(a==2)
            {
                renderer.func_83020_a(bot, bot, bot, top, top, top);
                if(oEmissive)
                    renderer.func_78609_c(block, x, y, z,overlayColor.r,overlayColor.g,overlayColor.b);
                else
                    renderer.func_78570_q(block,x,y,z);
            }
            else if(a==3)
            {
                rendererBP.func_83020_a(bot, bot, bot, top, top, top);
                rendererBP.func_78578_a(block,x,y,z,overlayColor.r,overlayColor.g,overlayColor.b);
            }


            BPRenderingUtilsCTM.renderWorldBlockDone(a,world,x,y,z,block,renderer);
            //renderer.func_78578_a(block, x, y, z,1.0f,1.0f,1.0f);
        }

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

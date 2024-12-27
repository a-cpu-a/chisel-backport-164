package com.cpu.chiselbp.bputils;

import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.block.Block;
import net.minecraft.src.Tessellator;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;

public class BPDrawing {

    public static void drawBlock(Block block, Icon icon, Color3 rgb, boolean emissive, RenderBlocks renderer)
    {
        Tessellator tes = Tessellator.field_78398_a;
        tes.func_78382_b();
        if(emissive)
            tes.func_78380_c(0xF00000);
        tes.func_78386_a(rgb.r,rgb.g,rgb.b);
        tes.func_78375_b(0.0F, -1.0F, 0.0F);
        renderer.func_78613_a(block, 0.0D, 0.0D, 0.0D, icon);
        tes.func_78375_b(0.0F, 1.0F, 0.0F);
        renderer.func_78617_b(block, 0.0D, 0.0D, 0.0D, icon);
        tes.func_78375_b(-1.0F, 0.0F, 0.0F);
        renderer.func_78573_e(block, 0.0D, 0.0D, 0.0D, icon);
        tes.func_78375_b(1.0F, 0.0F, 0.0F);
        renderer.func_78605_f(block, 0.0D, 0.0D, 0.0D, icon);
        tes.func_78375_b(0.0F, 0.0F, -1.0F);
        renderer.func_78611_c(block, 0.0D, 0.0D, 0.0D, icon);
        tes.func_78375_b(0.0F, 0.0F, 1.0F);
        renderer.func_78622_d(block, 0.0D, 0.0D, 0.0D, icon);
        tes.func_78381_a();
    }
    public static void drawWorldBlock(IBlockAccess access, Block block, boolean emissive, int x, int y, int z, RenderBlocks renderer)
    {
        Tessellator tes = Tessellator.field_78398_a;
        //tes.func_78382_b();
        if(emissive)
            tes.func_78380_c(0xF00000);
        tes.func_78376_a(255,255,255);

        tes.func_78375_b(0.0F, -1.0F, 0.0F);
        renderer.func_78613_a(block, x,y,z, block.func_71895_b(access,x,y,z,0));
        tes.func_78375_b(0.0F, 1.0F, 0.0F);
        renderer.func_78617_b(block,  x,y,z, block.func_71895_b(access,x,y,z,1));
        tes.func_78375_b(-1.0F, 0.0F, 0.0F);
        renderer.func_78573_e(block,  x,y,z, block.func_71895_b(access,x,y,z,2));
        tes.func_78375_b(1.0F, 0.0F, 0.0F);
        renderer.func_78605_f(block,  x,y,z, block.func_71895_b(access,x,y,z,3));
        tes.func_78375_b(0.0F, 0.0F, -1.0F);
        renderer.func_78611_c(block,  x,y,z, block.func_71895_b(access,x,y,z,4));
        tes.func_78375_b(0.0F, 0.0F, 1.0F);
        renderer.func_78622_d(block,  x,y,z, block.func_71895_b(access,x,y,z,5));
        //tes.func_78381_a();
    }
}

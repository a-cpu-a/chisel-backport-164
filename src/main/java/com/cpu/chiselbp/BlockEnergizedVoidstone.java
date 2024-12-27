package com.cpu.chiselbp;

import com.cpu.chiselbp.bputils.Color3;
import info.jbcs.minecraft.chisel.BlockMarble;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;

public class BlockEnergizedVoidstone extends BlockMarble implements ILayeredBlock {
    public BlockEnergizedVoidstone(int i) {
        super(i);
    }

    public static Icon hades;

    @Override
    public int func_71857_b() {
        return LayeredBlockRenderer.id;
    }
    //@Override public boolean func_71886_c() {  return false; }
    public boolean canRenderInPass(int pass) {
        LayeredBlockRenderer.renderpass = pass;
        return pass==0 || pass==1;
    }
    @Override
    public int func_71856_s_(){return 1;}

    @Override
    public Icon getItemUnderlayIcon(int metadata) {
        return hades;
    }
    @Override
    public Icon getItemOverlayIcon(int metadata) {
        return this.func_71858_a(0, metadata);
    }
    @Override
    public Icon getBlockUnderlay(int metadata) {
        return hades;
    }
    @Override
    public Color3 getUnderlayColor(int metadata) {
        return Color3.WHITE;
    }
    @Override
    public int getEmissiveProps(int metadata) {
        return 1;
    }

    @Override
    public Color3 getOverlayColor(int metadata) {
        return Color3.WHITE;
    }

    @Override
    public void func_94332_a(IconRegister register) {
        super.func_94332_a(register);
        hades = register.func_94245_a("chisel:animations/hades");
    }
}

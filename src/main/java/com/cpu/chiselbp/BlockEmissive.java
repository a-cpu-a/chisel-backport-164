package com.cpu.chiselbp;

import info.jbcs.minecraft.chisel.BlockMarble;
import info.jbcs.minecraft.chisel.BPEmissiveBlockRenderer;
import net.minecraft.block.material.Material;

public class BlockEmissive extends BlockMarble {

    public BlockEmissive(int i, Material material) {
        super(i,material);
    }
    public BlockEmissive(int i) {
        super(i);
    }

    @Override
    public int func_71857_b() {
        return BPEmissiveBlockRenderer.id;
    }
    /*@Override
    public boolean func_71886_c() {
        return false;
    }*/
    public boolean canRenderInPass(int pass) {
        return pass==0;
    }
    /*public boolean func_71932_i(int metadata) {
        return true;
    }
    public boolean func_71926_d() {
        return true;
    }
    public boolean func_71924_d(IBlockAccess access,int x,int y,int z,int side) {
        return true;
    }
    public boolean func_71877_c(IBlockAccess access,int x,int y,int z,int side) {
        return true;
    }
    public boolean func_72125_l(World access, int x, int y, int z) {
        return true;
    }*/
}

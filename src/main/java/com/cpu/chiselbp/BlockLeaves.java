package com.cpu.chiselbp;

import info.jbcs.minecraft.chisel.BlockMarble;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;

public class BlockLeaves extends BlockMarble {
    boolean graphicsLevel;
    public BlockLeaves(int i) {
        super(i, Material.field_76257_i);
    }
    public BlockLeaves(int i,Material mat) {
        super(i, mat);
    }

    public boolean func_71877_c(IBlockAccess access,int x,int y,int z,int side) {
        int var6 = access.func_72798_a(x, y, z);
        int meta = access.func_72805_g(x, y, z);
        int meta2 = Utils.getSideMeta(access,x,y,z,side);

        return (this.graphicsLevel || var6 != this.field_71990_ca || meta!=meta2) && super.func_71877_c(access, x, y, z, side);}
    @Override
    public boolean func_71926_d() {return false;}
}

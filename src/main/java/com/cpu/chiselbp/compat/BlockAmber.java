package com.cpu.chiselbp.compat;

import info.jbcs.minecraft.chisel.BlockMarble;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockAmber extends BlockMarble {
    public BlockAmber(int i, Material material) {
        super(i, material);
    }

    @Override
    public int func_71856_s_() {
        return 1;
    }


    @Override
    public int getLightOpacity(World world, int x, int y, int z) {
        return 3;
    }

    @Override
    public boolean func_71926_d() {
        return false;
    }

    @Override
    public boolean isBlockNormalCube(World world, int x, int y, int z) {
        return true;
    }

    @Override
    public boolean isBlockSolidOnSide(World world, int x, int y, int z, ForgeDirection side) {
        return true;
    }
}

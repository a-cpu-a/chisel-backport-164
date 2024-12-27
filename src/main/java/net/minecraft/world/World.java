package net.minecraft.world;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.src.Entity;
import net.minecraft.src.TileEntity;
import net.minecraft.src.WorldInfo;
import net.minecraft.src.WorldProvider;

public abstract class World implements IBlockAccess {
    public WorldProvider field_73011_w;
    /**isClientWorld*/
    public boolean field_72995_K;

    public boolean func_72804_r(int x, int y, int z) {return false;
    }

    /**canMineBlock*/
    public boolean func_72962_a(EntityPlayer player, int x, int y, int z) {
        return false;
    }

    /**getTime*/
    public long func_82737_E() {
        return 0;
    }

    /**setBlock*/
    public boolean func_72832_d(int x, int y, int z, int blockId, int i, int i1) {
        return false;
    }

    /**getBlockMat*/
    public Material func_72803_f(int x, int y, int z) {
        return null;
    }

    /**isAir*/
    public boolean func_72799_c(int x, int y, int z) {
        return false;
    }

    /**getTE*/
    public TileEntity func_72796_p(int x, int y, int z) {
        return null;
    }


    /**destroyBlock*/
    public boolean func_94578_a(int x, int y, int z, boolean b) {
        return b;
    }

    /**set2air*/
    public boolean func_94571_i(int x, int y, int z) {
        return false;
    }

    /**getMetadata*/
    public int func_72805_g(int x, int y, int z) {
        return 0;
    }

    /**getId*/
    public int func_72798_a(int x, int y, int z) {
        return x;
    }

    public boolean func_72931_a(int i, int x, int y, int z, boolean b, int side, Entity entity, ItemStack stack) {
        return false;
    }

    public void func_72956_a(Entity player, String sound, float v, float v1) {

    }

    public WorldInfo func_72912_H() {
        return null;
    }
}

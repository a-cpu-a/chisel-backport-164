package net.minecraft.world;

public interface IBlockAccess {

    /**
     * get metadata
     */
    int func_72805_g(int x, int y, int z);
    /**
     * get skylight
     */
    int func_72802_i(int x, int y, int z, int w);

    int func_72798_a(int x, int y, int z);
}

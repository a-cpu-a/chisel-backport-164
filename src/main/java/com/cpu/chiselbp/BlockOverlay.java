package com.cpu.chiselbp;

import com.cpu.chiselbp.bputils.Color3;
import net.minecraft.world.IBlockAccess;

public class BlockOverlay extends BlockDyeableGlowingOverlay{
    public BlockOverlay(int i, String underlayIcon,boolean overlayAlpha) {
        super(i, underlayIcon,overlayAlpha);
    }


    @Override
    public Color3 getUnderlayColor(int metadata) {
        return Color3.WHITE;
    }
    @Override
    public int getEmissiveProps(int metadata) {
        return 0;
    }


    @Override
    public int func_71874_e(IBlockAccess access, int x, int y, int z){
        return access.func_72802_i(x,y,z,0);
    }//int r = access.func_72802_i(x,y,z,0);System.out.println(r);return r;
}

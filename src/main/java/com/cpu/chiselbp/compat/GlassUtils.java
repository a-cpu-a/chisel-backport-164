package com.cpu.chiselbp.compat;

import com.cpu.chiselbp.BlockGlassCarvableTranslucent;
import com.cpu.chiselbp.ChiselBP;
import com.cpu.chiselbp.ExtensionUtilities;
import com.cpu.chiselbp.Utils;
import info.jbcs.minecraft.chisel.BlockGlassCarvable;
import info.jbcs.minecraft.chisel.CarvableHelper;
import net.minecraft.block.Block;

import java.lang.reflect.Field;

public class GlassUtils {
    public static Field f = null;
    static {

        try {
            f = BlockGlassCarvable.class.getDeclaredField("carverHelper");
            f.setAccessible(true);

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
    public static BlockGlassCarvable addGlassType(String configId, int id,String name,String upperName)
    {
        BlockGlassCarvableTranslucent block = new BlockGlassCarvableTranslucent(ChiselBP.getBlock(configId, id));
        block.func_71848_c(0.3F).func_71884_a(Block.field_71974_j);


        CarvableHelper ch = null;
        try {
            ch = ((CarvableHelper) f.get(block));
            for (int i = 0; i < 16; i++) {
                ch.setBlockName(Utils.textColors[i]+" "+upperName+" Glass Block");
                ch.addVariation(Utils.textColors[i]+" "+name+" glass",i,"glassdyed/"+ Utils.colors[i]+"-"+name);
            }
            ExtensionUtilities.registerDupe(ch,block,"dyedGlass","glassdyed"+upperName);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return block;
    }
}

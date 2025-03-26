package com.cpu.chiselbp.compat;

import com.cpu.chiselbp.ChiselBP;
import info.jbcs.minecraft.chisel.*;
import net.minecraft.block.Block;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MetalUtils {

    public static Field f = null;
    public static Method register = null;
    static {

        try {
            f = BlockMarble.class.getDeclaredField("carverHelper");
            register = CarvableHelper.class.getDeclaredMethod("register", Block.class, String.class);


            f.setAccessible(true);
            register.setAccessible(true);

        } catch (NoSuchFieldException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
    public static BlockMarble createModMetal(String configId,int defaultId,String name,String upperName,String oreDict)
    {
        return createModMetal(configId, defaultId, name, upperName, oreDict,name,true);
    }
    public static BlockMarble createModMetal(String configId,int defaultId,String name,String upperName,String oreDict,String folder,boolean hasCard)
    {
        BlockMarble block = new BlockMarble(ChiselBP.getBlock(configId,defaultId));
        block.func_71884_a(Block.field_71977_i).func_71848_c(2.0F).func_71894_b(10.0f);

        try {

            CarvableHelper ch = ((CarvableHelper)f.get(block));
            ch.setBlockName(upperName+" Block");
            ch.addVariation("Advanced "+name+" mechanism", 0, folder+"/adv");
            ch.addVariation("Bolted "+name, 1, folder+"/bolted");
            if(hasCard)
                ch.addVariation(upperName+" card", 2, folder+"/card");
            ch.addVariation(upperName+" caution block", 3, folder+"/caution");
            ch.addVariation(upperName+" crate", 4, folder+"/crate");
            ch.addVariation(upperName+" with a iron border", 5, folder+"/egregious");
            ch.addVariation("Thermal style "+name+" block", 6, folder+"/thermal");
            ch.addVariation("Eye of "+name, 7, folder+"/elementiumEye");

            register.invoke(ch,block,name);
            Carving.chisel.registerOre(name, oreDict);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return block;
    }
}

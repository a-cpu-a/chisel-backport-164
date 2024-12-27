package com.cpu.chiselbp.compat;

import com.cpu.chiselbp.ChiselBP;
import info.jbcs.minecraft.chisel.BlockMarble;
import info.jbcs.minecraft.chisel.CarvableHelper;
import info.jbcs.minecraft.chisel.Carving;
import net.minecraft.block.Block;

import java.lang.reflect.InvocationTargetException;

public class Metals {
    public static BlockMarble registerMetal(String name,String upperName,int id,String oreDict)
    {
        BlockMarble block = new BlockMarble(ChiselBP.getBlock(name,id));
        block.func_71884_a(Block.field_71977_i).func_71848_c(2.0F).func_71894_b(15.0f);

        try {

            String folder = "metals/"+name+"/";

            CarvableHelper ch = ((CarvableHelper)MetalUtils.f.get(block));
            ch.setBlockName(upperName+" Block");
            ch.addVariation("Bolted "+name+" plates", 0, folder+"badGreggy");
            ch.addVariation("Bolted "+name, 1, folder+"bolted");
            ch.addVariation(upperName+" caution block", 2, folder+"caution");
            ch.addVariation(upperName+" crate", 3, folder+"crate");
            ch.addVariation(upperName+" machine", 4, folder+"machine");
            ch.addVariation(upperName+" scaffolding", 5, folder+"scaffold");
            ch.addVariation("Thermal style block of "+name, 6, folder+"thermal");
            MetalUtils.register.invoke(ch,block,name);
            if(!name.equals("iron"))
                Carving.chisel.registerOre(name, oreDict);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return block;
    }
}

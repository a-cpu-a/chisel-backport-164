package com.cpu.chiselbp.compat;

import com.cpu.chiselbp.ChiselBP;
import info.jbcs.minecraft.chisel.BlockMarble;
import info.jbcs.minecraft.chisel.CarvableHelper;
import net.minecraft.block.Block;

import java.lang.reflect.InvocationTargetException;

import static com.cpu.chiselbp.compat.MetalUtils.f;

public class RockUtils {

    public static BlockMarble registerRock(String name,String upName,int defaultId) throws InvocationTargetException, IllegalAccessException {
        BlockMarble b = new BlockMarble(ChiselBP.getBlock("block"+upName,defaultId));
        b.func_71884_a(Block.field_71976_h).func_71848_c(6.0F).func_71894_b(1.5f);

        String path = name+"/";

        CarvableHelper ch = ((CarvableHelper)f.get(b));
        ch.setBlockName(upName+" Block");
        ch.addVariation(upName, 0, path+name);
        ch.addVariation("Bordered "+name+" bricks", 1, path+name+"DiagonalBricks");
        ch.addVariation(upName+" prims", 2, path+name+"Prism");
        ch.addVariation("Polished "+name, 3, path+name+"Polished");
        ch.addVariation(upName+" pillar", 4, path+name+"Pillar");
        ch.addVariation("Large "+name+" bricks", 5, path+name+"LBrick");
        ch.addVariation("Ornate "+name, 6, path+name+"Ornate");
        ch.addVariation(upName+" prismarine", 7, path+name+"Prismatic");
        ch.addVariation("Small "+name+" tiles", 8, path+name+"Tiles");
        MetalUtils.register.invoke(ch,b,name);
        return b;
    }
}

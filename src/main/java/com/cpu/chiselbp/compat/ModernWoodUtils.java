package com.cpu.chiselbp.compat;

import com.cpu.chiselbp.BlockEmissive;
import com.cpu.chiselbp.ExtensionUtilities;
import info.jbcs.minecraft.chisel.BlockMarble;
import info.jbcs.minecraft.chisel.CarvableHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.MinecraftForge;

import static com.cpu.chiselbp.ChiselBP.getBlock;
import static com.cpu.chiselbp.compat.MetalUtils.f;

public class ModernWoodUtils {
    public static BlockMarble makePlanks(String name,String blockName,int defaultId) {


        BlockMarble ret = new BlockMarble(getBlock("blockModernPlanks_"+name,defaultId), Material.field_76245_d);
        ret.func_71848_c(2.0F).func_71894_b(5.0F).func_71884_a(Block.field_71967_e);

        try {
            CarvableHelper ch = ((CarvableHelper)f.get(ret));

            ch.setBlockName(blockName);

            String pfix = "planks/"+name;

            ch.addVariation("Full "+blockName+" block",0,pfix+"/0_FullBlock");
            ch.addVariation("Braced "+blockName,1,pfix+"/braced_planks");
            ch.addVariation("Braided "+blockName,2,pfix+"/braid");
            ch.addVariation("Crude "+blockName+" planks",3,pfix+"/crude_horizontal_planks");
            ch.addVariation("Crude "+blockName+" vertical planks",4,pfix+"/crude_vertical_planks");
            ch.addVariation("Crude "+blockName+" paneling",5,pfix+"/crude_paneling");
            ch.addVariation("Large encased "+blockName+" planks",6,pfix+"/encased_large_planks");
            ch.addVariation("Encased "+blockName+" planks",7,pfix+"/encased_planks");
            ch.addVariation("Encased smooth "+blockName,8,pfix+"/encased_smooth");
            ch.addVariation("Large "+blockName+" planks",9,pfix+"/large_planks");
            ch.addVariation("Bordered "+blockName+" log",10,pfix+"/log_bordered");
            ch.addVariation("East-west "+blockName+" log cabin",11,pfix+"/log_cabin-ew");
            ch.addVariation("North-south "+blockName+" log cabin",12,pfix+"/log_cabin-ns");
            ch.addVariation(blockName+" paneling",13,pfix+"/paneling");
            ch.addVariation(blockName+" shipping crate",14,pfix+"/shipping_crate");
            ch.addVariation("Smooth "+blockName,15,pfix+"/smooth");

            ch.setBlockHarvestLevel(ret,"axe",0);

            ExtensionUtilities.registerDupe(ch,ret,"wood-"+name,name+"M");


            //MinecraftForge.setBlockHarvestLevel(Block.planks, i, "chisel", 0);
            MinecraftForge.setBlockHarvestLevel(ret,"axe",0);

        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        return ret;
    }
    public static BlockMarble makePlanks2(String name,String blockName,int defaultId,boolean hasUnevenLog) {


        BlockMarble ret = new BlockMarble(getBlock("blockModernPlanks2_"+name,defaultId), Material.field_76245_d);
        ret.func_71848_c(2.0F).func_71894_b(5.0F).func_71884_a(Block.field_71967_e);


        try {
            CarvableHelper ch = ((CarvableHelper)f.get(ret));

            ch.setBlockName(blockName+" Planks");

            String pfix = "planks/"+name;

            ch.addVariation("Stacked "+blockName+" planks",0,pfix+"/stacked");
            ch.addVariation("Vertical "+blockName+" planks",1,pfix+"/vertical_planks");
            if(hasUnevenLog)
                ch.addVariation("Uneven vertical "+blockName+" log",15,pfix+"/vertical-uneven_Log");

            ch.setBlockHarvestLevel(ret,"axe",0);

            ExtensionUtilities.registerDupe(ch,ret,"wood-"+name,name+"M2");


            //MinecraftForge.setBlockHarvestLevel(Block.planks, i, "chisel", 0);
            MinecraftForge.setBlockHarvestLevel(ret,"axe",0);

        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        return ret;
    }
}

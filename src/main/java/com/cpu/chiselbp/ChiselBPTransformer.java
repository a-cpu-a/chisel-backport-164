package com.cpu.chiselbp;

import com.cpu.chiselbp.bputils.BPTransformerUtils;
import net.minecraft.launchwrapper.IClassTransformer;

public class ChiselBPTransformer implements IClassTransformer {


    static public boolean isFirst = true;

    @Override
    public byte[] transform(String name, String obfName, byte[] bytecode) {


            isFirst = false;
            {
                BPTransformerUtils.BPReplaceGetStatic p = new BPTransformerUtils.BPReplaceGetStatic();
                p.clazz = "info.jbcs.minecraft.chisel.BlockMarble";
                p.methodName = "func_71857_b"; p.methodDesc = "()I";

                p.varName="RenderCTMId"; p.varDesc="I";
                p.varFromClass="info/jbcs/minecraft/chisel/Chisel";

                p.newVarName="id"; p.newVarDesc="I";
                p.newVarFromClass="com/cpu/chiselbp/CTMBlockRenderer";
                BPTransformerUtils.actions.add(p);
            }
            {
                BPTransformerUtils.BPReplaceNew p = new BPTransformerUtils.BPReplaceNew();
                p.clazz = "info.jbcs.minecraft.chisel.BlockMarble";
                p.methodName = "<init>"; p.methodDesc = "(Ljava/lang/String;ILnet/minecraft/block/material/Material;)V";

                p.oldMethodDesc="()V";
                p.oldNewClass="info/jbcs/minecraft/chisel/CarvableHelper";

                p.newNewClass="info/jbcs/minecraft/chisel/BPCarverHelper";
                BPTransformerUtils.actions.add(p);
            }
            {
                BPTransformerUtils.BPReplaceNew p = new BPTransformerUtils.BPReplaceNew();
                p.clazz = "info.jbcs.minecraft.chisel.BlockGlassCarvable";
                p.methodName = "<init>"; p.methodDesc = "(I)V";

                p.oldMethodDesc="()V";
                p.oldNewClass="info/jbcs/minecraft/chisel/CarvableHelper";

                p.newNewClass="info/jbcs/minecraft/chisel/BPCarverHelper";
                BPTransformerUtils.actions.add(p);
            }
            {
                BPTransformerUtils.BPReplaceNew p = new BPTransformerUtils.BPReplaceNew();
                p.clazz = "info.jbcs.minecraft.chisel.Chisel";
                p.methodName = "init"; p.methodDesc = "(Lcpw/mods/fml/common/event/FMLInitializationEvent;)V";

                p.oldMethodDesc="(ILinfo/jbcs/minecraft/chisel/Carving;)V";
                p.oldNewClass="info/jbcs/minecraft/chisel/ItemChisel";

                p.newNewClass="info/jbcs/minecraft/chisel/BPItemChisel";
                BPTransformerUtils.actions.add(p);
            }
            {
                BPTransformerUtils.BPRenameMethod p = new BPTransformerUtils.BPRenameMethod();
                p.clazz = "info.jbcs.minecraft.chisel.BlockCloud";
                p.methodName = "func_71899_b"; p.methodDesc = "(I)I";

                p.newMethodName = "defused_func_71899_b";

                BPTransformerUtils.actions.add(p);
            }
            {
                BPTransformerUtils.BPAddDefaultConstructor p = new BPTransformerUtils.BPAddDefaultConstructor();
                p.clazz = "info.jbcs.minecraft.chisel.TextureSubmap";
                p.methodName = "<init>"; p.methodDesc = "()V";
                p.classSig = "Linfo/jbcs/minecraft/chisel/TextureSubmap;";

                BPTransformerUtils.actions.add(p);
            }
            //System.out.println("\n\n\n\n\n\n\nInited " +BPTransformerUtils.actions.size()+" actions");

        if(BPTransformerUtils.actions.size()>100)throw new IllegalStateException("hello, the coremod static state was not reset (i dont know why it normally is!)");

        return BPTransformerUtils.tryApply(name,obfName,bytecode);

    }
}

package com.cpu.chiselbp.compat;

import com.cpu.chiselbp.Utils;
import com.cpu.chiselbp.bputils.Color3;
import com.cpu.chiselbp.ILayeredBlock;
import com.cpu.chiselbp.LayeredBlockRenderer;
import info.jbcs.minecraft.chisel.BPCarverHelper;
import info.jbcs.minecraft.chisel.BlockMarble;
import info.jbcs.minecraft.chisel.CarvableHelper;
import info.jbcs.minecraft.utilities.GeneralClient;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;

public class BlockGlowingArcaneRune extends BlockMarble implements ILayeredBlock {
    public BPCarverHelper underlayCH;
    public BlockGlowingArcaneRune(int i) {
        super(i);
        underlayCH = new BPCarverHelper();
    }

    @Override
    public int func_71857_b() {
        return LayeredBlockRenderer.id;
    }
    @Override
    public int func_71856_s_() {
        return 1;
    }
    //@Override public boolean func_71886_c() { return false; }


    public Icon itemUnderlayIcon;
    public Icon itemOverlayIcon;

    @Override
    public Icon func_71895_b(IBlockAccess access, int x, int y, int z, int side) {
        if(LayeredBlockRenderer.renderpass==0)
            return underlayCH.getBlockTexture(access,x,y,z,side);
        try {
            return ((CarvableHelper)MetalUtils.f.get(this)).getBlockTexture(access,x,y,z,side);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return GeneralClient.getMissingIcon();
    }
    @Override
    public void func_94332_a(IconRegister register) {
        super.func_94332_a(register);
        underlayCH.registerIcons("chisel",this,register);
        itemUnderlayIcon = register.func_94245_a("chisel:arcane/runesGlowBase");
        itemOverlayIcon = register.func_94245_a("chisel:arcane/runesGlowOverlay");
    }

    @Override
    public Icon getItemUnderlayIcon(int metadata) {
        return itemUnderlayIcon;
    }//underlayCH.getIcon(0,0)
    @Override
    public Icon getItemOverlayIcon(int metadata) {
        return itemOverlayIcon;
    }
    @Override
    public Icon getBlockUnderlay(int metadata) {
        return null;
    }//underlayCH.getIcon(0,metadata)
    @Override
    public Color3 getUnderlayColor(int metadata) {
        return Color3.WHITE;
    }
    @Override
    public Color3 getOverlayColor(int metadata) {
        return Utils.colorValues[metadata];
    }
    @Override
    public int getEmissiveProps(int metadata) {
        return 2;
    }

    //@Override
    //public int func_71920_b(IBlockAccess access,int x,int y,int z){return ChiselBP.colorValues[access.func_72805_g(x,y,z)].toInt();}

    public boolean canRenderInPass(int pass) {
        LayeredBlockRenderer.renderpass = pass;
        return pass==0||pass==1;
    }
    @Override
    public int func_71874_e(IBlockAccess access, int x, int y, int z){
        if(LayeredBlockRenderer.renderpass==1)
            return 0xF00000;
        //return (int) (Math.random()*0xFFFFFF);
        return access.func_72802_i(x,y,z,0);
    }//int r = access.func_72802_i(x,y,z,0);System.out.println(r);return r;
}

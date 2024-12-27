package com.cpu.chiselbp;

import com.cpu.chiselbp.bputils.Color3;
import com.cpu.chiselbp.compat.MetalUtils;
import info.jbcs.minecraft.chisel.BlockMarble;
import info.jbcs.minecraft.chisel.CarvableHelper;
import info.jbcs.minecraft.utilities.GeneralClient;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;

public class BlockDyeableGlowingOverlay extends BlockMarble implements ILayeredBlock {

    public boolean overlayAlpha = false;

    public BlockDyeableGlowingOverlay(int i, String underlayIcon) {
        super(i);
        this.underlayIconPath= underlayIcon;
    }
    public BlockDyeableGlowingOverlay(int i, String underlayIcon,boolean overlayAlpha) {
        super(i);
        this.underlayIconPath= underlayIcon;
        this.overlayAlpha = overlayAlpha;
    }
    public BlockDyeableGlowingOverlay(int i, String underlayIcon, String itemOverlayIcon, String itemUnderlayIcon) {
        super(i);
        this.underlayIconPath= underlayIcon;
        this.itemOverlayIconPath= itemOverlayIcon;
        this.itemUnderlayIconPath= itemUnderlayIcon;
    }


    public int func_71856_s_(){return overlayAlpha?1:0;}

    @Override
    public int func_71857_b() {
        return LayeredBlockRenderer.id;
    }
    //@Override public boolean func_71886_c() { return false; }

    public Icon itemOverlayIcon;
    public Icon itemUnderlayIcon;
    public Icon blockUnderlayIcon;

    public String underlayIconPath; //"chisel:animations/shroud"
    public String itemOverlayIconPath; // "chisel:hexPlating/hexBase"
    public String itemUnderlayIconPath; // "chisel:hexPlating/hexOverlay"

    @Override
    public Icon getItemUnderlayIcon(int metadata) {
        if(itemUnderlayIcon==null) {
            return blockUnderlayIcon;
        }
        return itemUnderlayIcon;
    }
    @Override
    public Icon getItemOverlayIcon(int metadata) {
        if(itemOverlayIcon==null) {
            try {
                return ((CarvableHelper)MetalUtils.f.get(this)).getIcon(0,metadata);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return GeneralClient.getMissingIcon();
            }
        }
        return itemOverlayIcon;
    }
    @Override
    public Icon getBlockUnderlay(int metadata) {
        return blockUnderlayIcon;
    }
    @Override
    public Color3 getUnderlayColor(int metadata) {
        return Utils.colorValues[metadata];
    }
    @Override
    public Color3 getOverlayColor(int metadata) {
        return Color3.WHITE;
    }
    @Override
    public int getEmissiveProps(int metadata) {
        return 1;
    }

    @Override
    public void func_94332_a(IconRegister register) {
        super.func_94332_a(register);
        if(itemUnderlayIconPath!=null)
            itemUnderlayIcon = register.func_94245_a(itemUnderlayIconPath);
        if(itemOverlayIconPath!=null)
            itemOverlayIcon = register.func_94245_a(itemOverlayIconPath);
        blockUnderlayIcon = register.func_94245_a(underlayIconPath);
    }
    public boolean canRenderInPass(int pass) {
        LayeredBlockRenderer.renderpass = pass;
        return true;
    }
    @Override
    public int func_71874_e(IBlockAccess access, int x, int y, int z){
        if(LayeredBlockRenderer.renderpass==0)
            return 0xF00000;
            //return (int) (Math.random()*0xFFFFFF);
        return access.func_72802_i(x,y,z,0);
    }//int r = access.func_72802_i(x,y,z,0);System.out.println(r);return r;
}

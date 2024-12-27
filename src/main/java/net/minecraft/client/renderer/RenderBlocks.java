package net.minecraft.client.renderer;

import net.minecraft.block.Block;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;

public class RenderBlocks {

    /**
     * override icon
     */
    public Icon field_78664_d;
    public float field_78674_ar;
    public IBlockAccess field_78669_a;
    public double field_83026_h;
    public double field_83024_j;
    public double field_83022_l;
    /**
     * enable ao
     */
    public boolean field_78677_m;

    /**setRenderBounds*/
    public void func_83020_a(double mx,double my,double mz,double px,double py, double pz){}
    /**
     * render block as item
     */
    public void func_78600_a(Block bl,int metadata,float scaleOrSmth){}
    /**
     * renderStandardBlock
     */
    public boolean func_78570_q(Block bl,int x,int y,int z){return  true;}
    /**
     * renderStandardBlockWithColorMultiplier
     */
    public boolean func_78609_c(Block bl,int x,int y,int z,float r,float g,float b){return  true;}
    /**
     * renderStandardBlockWithAmbientOcclusion
     */
    public boolean func_78578_a(Block bl,int x,int y,int z,float r,float g,float b){return  true;}
    /**
     * renderStandardBlockWithAmbientOcclusionPartial
     */
    public boolean func_102027_b(Block bl,int x,int y,int z,float r,float g,float b){return  true;}

    /**
     * renderFace-Y
     */
    public void func_78613_a(Block block, double v, double v1, double v2, Icon icon) {
    }
    /**
     * renderFace+Y
     */
    public void func_78617_b(Block block, double v, double v1, double v2, Icon icon) {
    }
    /**
     * renderFace-X
     */
    public void func_78573_e(Block block, double v, double v1, double v2, Icon icon) {
    }
    /**
     * renderFace+X
     */
    public void func_78605_f(Block block, double v, double v1, double v2, Icon icon) {
    }
    /**
     * renderFace-Z
     */
    public void func_78611_c(Block block, double v, double v1, double v2, Icon icon) {
    }
    /**
     * renderFace+Z
     */
    public void func_78622_d(Block block, double v, double v1, double v2, Icon icon) {
    }
}

package info.jbcs.minecraft.chisel;

import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.block.Block;
import net.minecraft.src.Tessellator;

public class RenderBlocksCTM extends RenderBlocks {
    Tessellator tessellator;
    double[] X = new double[26];
    double[] Y = new double[26];
    double[] Z = new double[26];
    double[] U = new double[26];
    double[] V = new double[26];
    int[] L = new int[26];
    float[] R = new float[26];
    float[] G = new float[26];
    float[] B = new float[26];
    TextureSubmap submap;
    TextureSubmap submapSmall;
    RenderBlocks rendererOld;
    int bx;
    int by;
    int bz;
    @Override
    public boolean func_78570_q(Block bl, int x, int y, int z){return  true;}


    void setupSides(int a, int b, int c, int d, int xa, int xb, int xc, int xd, int e) {}
    void side(int a, int b, int c, int d, int iconIndex, boolean flip) {}
}

package info.jbcs.minecraft.chisel;

import com.cpu.chiselbp.Utils;
import net.minecraft.block.Block;
import net.minecraft.util.Icon;

public class BPRenderBlocksCTM extends RenderBlocksCTM{

    public BPCarvableVariation var;
    public int w;
    public int h;

    public boolean notSlab = true;
    public boolean topSlab = false;



    public void func_78573_e(Block block, double x, double y, double z, Icon icon) {
        if(var.isV9Ctm) {
            int idx = Utils.xyzs2Idx((int)x,(int)y,(int)z,4,w,h);
            submapSmall = var.v9CtmSmallSubmaps[idx];
            submap = var.v9CtmSubmaps[idx];
        }
        int[] tex = CTM.getSubmapIndices(this.field_78669_a, this.bx, this.by, this.bz, 4);
        this.setupSides(1, 0, 4, 5, 14, 19, 17, 23, 9);
        if(notSlab || topSlab) {
            this.side(1, 14, 9, 23, tex[0], false);
            this.side(23, 9, 17, 5, tex[1], false);
        }
        if(notSlab || !topSlab) {
            this.side(9, 19, 4, 17, tex[3], false);
            this.side(14, 0, 19, 9, tex[2], false);
        }
    }

    public void func_78605_f(Block block, double x, double y, double z, Icon icon) {
        if(var.isV9Ctm) {
            int idx = Utils.xyzs2Idx((int)x,(int)y,(int)z,5,w,h);
            submapSmall = var.v9CtmSmallSubmaps[idx];
            submap = var.v9CtmSubmaps[idx];
        }
        int[] tex = CTM.getSubmapIndices(this.field_78669_a, this.bx, this.by, this.bz, 5);
        this.setupSides(3, 2, 6, 7, 15, 25, 16, 21, 11);
        if(notSlab || topSlab) {
            this.side(6, 16, 11, 25, tex[0], false);
            this.side(25, 11, 15, 2, tex[1], false);
        }
        if(notSlab || !topSlab) {
            this.side(16, 7, 21, 11, tex[2], false);
            this.side(11, 21, 3, 15, tex[3], false);
        }
    }

    public void func_78611_c(Block block, double x, double y, double z, Icon icon) {
        if(var.isV9Ctm) {
            int idx = Utils.xyzs2Idx((int)x,(int)y,(int)z,2,w,h);
            submapSmall = var.v9CtmSmallSubmaps[idx];
            submap = var.v9CtmSubmaps[idx];
        }
        int[] tex = CTM.getSubmapIndices(this.field_78669_a, this.bx, this.by, this.bz, 2);
        this.setupSides(2, 3, 0, 1, 15, 18, 14, 22, 8);
        if(notSlab || topSlab) {
            this.side(2, 15, 8, 22, tex[0], false);
            this.side(22, 8, 14, 1, tex[1], false);
        }
        if(notSlab || !topSlab) {
            this.side(15, 3, 18, 8, tex[2], false);
            this.side(8, 18, 0, 14, tex[3], false);
        }
    }

    public void func_78622_d(Block block, double x, double y, double z, Icon icon) {
        if(var.isV9Ctm) {
            int idx = Utils.xyzs2Idx((int)x,(int)y,(int)z,3,w,h);
            submapSmall = var.v9CtmSmallSubmaps[idx];
            submap = var.v9CtmSubmaps[idx];
        }
        int[] tex = CTM.getSubmapIndices(this.field_78669_a, this.bx, this.by, this.bz, 3);
        this.setupSides(4, 7, 6, 5, 20, 16, 24, 17, 10);
        if(notSlab || topSlab) {
            this.side(5, 17, 10, 24, tex[0], false);
            this.side(24, 10, 16, 6, tex[1], false);
        }
        if(notSlab || !topSlab) {
            this.side(17, 4, 20, 10, tex[2], false);
            this.side(10, 20, 7, 16, tex[3], false);
        }
    }

    public void func_78613_a(Block block, double x, double y, double z, Icon icon) {
        if(var.isV9Ctm) {
            int idx = Utils.xyzs2Idx((int)x,(int)y,(int)z,0,w,h);
            submapSmall = var.v9CtmSmallSubmaps[idx];
            submap = var.v9CtmSubmaps[idx];
        }
        int[] tex = CTM.getSubmapIndices(this.field_78669_a, this.bx, this.by, this.bz, 0);
        this.setupSides(0, 3, 7, 4, 18, 21, 20, 19, 13);
        this.side(13, 21, 7, 20, tex[3], true);
        this.side(19, 13, 20, 4, tex[2], true);
        this.side(0, 18, 13, 19, tex[0], true);
        this.side(18, 3, 21, 13, tex[1], true);

    }

    public void func_78617_b(Block block, double x, double y, double z, Icon icon) {
        if(var.isV9Ctm) {
            int idx = Utils.xyzs2Idx((int) x, (int) y, (int) z, 1, w, h);
            submapSmall = var.v9CtmSmallSubmaps[idx];
            submap = var.v9CtmSubmaps[idx];
        }
        int[] tex = CTM.getSubmapIndices(this.field_78669_a, this.bx, this.by, this.bz, 1);
        this.setupSides(2, 1, 5, 6, 22, 23, 24, 25, 12);
        this.side(12, 24, 6, 25, tex[3], false);
        this.side(22, 12, 25, 2, tex[1], false);
        this.side(1, 23, 12, 22, tex[0], false);
        this.side(23, 5, 24, 12, tex[2], false);
    }


    void vert(int index) {
        if (this.field_78677_m) {
            this.tessellator.func_78386_a(this.R[index], this.G[index], this.B[index]);
            this.tessellator.func_78380_c(this.L[index]);
        }

        this.tessellator.func_78374_a(inflateCoord(this.X[index]), inflateCoord(this.Y[index]), inflateCoord(this.Z[index]), this.U[index], this.V[index]);
    }

    public double inflateCoord(double v) {
        return (v-0.5)*1.001+0.5;
    }

    public int[] nYIdxs = {0,3,4,7,
    13,18,19,20,
    21};

    public int[] pYIdxs = {1,2,5,6,
            12,22,23,24,
            25};

    public boolean wasSlab = false;
    public boolean wasTopSlab = false;

    public void initPoses() {

        if(wasSlab == notSlab)
        {
            wasSlab = !notSlab;

            if(notSlab) {

                for (int yIdx : pYIdxs) {
                    this.Y[yIdx] = 1.0;
                }
                for (int yIdx : nYIdxs) {
                    this.Y[yIdx] = 0.0;
                }
            }
            else {

                wasTopSlab = topSlab;

                if(topSlab) {
                    for (int yIdx : nYIdxs) {
                        this.Y[yIdx] = 0.5;
                    }
                }
                else {
                    for (int yIdx : pYIdxs) {
                        this.Y[yIdx] = 0.5;
                    }
                }
            }
        }
        else if(!notSlab && wasTopSlab!=topSlab)
        {
            wasTopSlab = topSlab;

            if(topSlab) {
                for (int yIdx : nYIdxs) {
                    this.Y[yIdx] = 0.5;
                }
                for (int yIdx : pYIdxs) {
                    this.Y[yIdx] = 1.0;
                }
            }
            else {
                for (int yIdx : pYIdxs) {
                    this.Y[yIdx] = 0.5;
                }
                for (int yIdx : nYIdxs) {
                    this.Y[yIdx] = 0.0;
                }
            }
        }
    }
}

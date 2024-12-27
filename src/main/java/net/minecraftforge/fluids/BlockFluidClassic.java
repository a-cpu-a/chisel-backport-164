package net.minecraftforge.fluids;

import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraft.world.IBlockAccess;

public class BlockFluidClassic extends BlockFluidBase {
    protected boolean[] isOptimalFlowDirection = new boolean[4];
    protected int[] flowCost = new int[4];
    protected FluidStack stack;


    public BlockFluidClassic(int id, Fluid fluid, Material material) {
        super(id,fluid,material);
    }


    public BlockFluidClassic setFluidStack(FluidStack stack) {return null;}

    public BlockFluidClassic setFluidStackAmount(int amount) {return null;}

    public int getQuantaValue(IBlockAccess world, int x, int y, int z) {return 0;}


    public int getMaxRenderHeightMeta() {
        return 0;
    }

    public int getLightValue(IBlockAccess world, int x, int y, int z) {return 0;}



    public boolean isFlowingVertically(IBlockAccess world, int x, int y, int z) {return  false;    }

    public boolean isSourceBlock(IBlockAccess world, int x, int y, int z) {return false;    }

    protected boolean[] getOptimalFlowDirections(World world, int x, int y, int z) {return null;    }

    protected int calculateFlowCost(World world, int x, int y, int z, int recurseDepth, int side) {        return 0;}

    protected void flowIntoBlock(World world, int x, int y, int z, int meta) {    }

    protected boolean canFlowInto(IBlockAccess world, int x, int y, int z) {return false;}

    protected int getLargerQuanta(IBlockAccess world, int x, int y, int z, int compare) {return 0;}

    public FluidStack drain(World world, int x, int y, int z, boolean doDrain) {return null;}

    public boolean canDrain(World world, int x, int y, int z) {        return false;    }

}

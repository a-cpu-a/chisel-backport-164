package net.minecraftforge.fluids;

import net.minecraft.block.material.Material;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.IBlockAccess;

public class BlockFluidFinite extends Block {

    public BlockFluidFinite(int id, Fluid fluid, Material material){}


    public int getQuantaValue(IBlockAccess world, int x, int y, int z){return 0;}


    public int getMaxRenderHeightMeta() {
        return 0;
    }
    public int tryToFlowVerticallyInto(World world, int x, int y, int z, int amtToInput) {return 0;}

    public FluidStack drain(World world, int x, int y, int z, boolean doDrain) {
        return null;
    }
    public boolean canDrain(World world, int x, int y, int z) {
        return false;
    }
}

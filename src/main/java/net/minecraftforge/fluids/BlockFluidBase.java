package net.minecraftforge.fluids;

import net.minecraft.block.material.Material;
import net.minecraft.block.Block;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.Map;

public class BlockFluidBase extends Block {
    protected static final Map<Integer, Boolean> defaultDisplacementIds = new HashMap();
    protected Map<Integer, Boolean> displacementIds = new HashMap();
    protected int quantaPerBlock = 8;
    protected float quantaPerBlockFloat = 8.0F;
    protected int density = 1;
    protected int densityDir = -1;
    protected int temperature = 295;
    protected int tickRate = 20;
    protected int renderPass = 1;
    protected int maxScaledLight = 0;
    protected final String fluidName = "";


    public BlockFluidBase(int id, Fluid fluid, Material material) {}

    public BlockFluidBase setQuantaPerBlock(int quantaPerBlock) {return null;}
    public Fluid getFluid() {
        return null;
    }
    public float getFilledPercentage(World world, int x, int y, int z) {return 0;}
}

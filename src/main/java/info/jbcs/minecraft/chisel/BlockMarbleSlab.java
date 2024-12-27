package info.jbcs.minecraft.chisel;

import net.minecraft.block.Block;

public class BlockMarbleSlab extends BlockMarble{
    Block master;
    BlockMarbleSlab bottom;
    BlockMarbleSlab top;
    boolean isBottom;
    public BlockMarbleSlab(int i) {
        super(i);
    }
}

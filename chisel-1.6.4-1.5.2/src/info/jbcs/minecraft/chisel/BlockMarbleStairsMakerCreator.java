package info.jbcs.minecraft.chisel;

import net.minecraft.src.Block;

public interface BlockMarbleStairsMakerCreator {
	public BlockMarbleStairs create(String name,int i, Block block,int meta, CarvableHelper helper);
}

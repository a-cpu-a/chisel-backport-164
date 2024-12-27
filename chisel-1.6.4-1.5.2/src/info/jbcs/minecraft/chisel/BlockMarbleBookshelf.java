package info.jbcs.minecraft.chisel;

import java.util.Random;

import net.minecraft.src.Block;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockMarbleBookshelf extends BlockMarble {

	public BlockMarbleBookshelf(int i) {
		super(i);
	}


	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int metadata) {
		if(side<2)
			return Block.planks.getBlockTextureFromSide(side);
		return super.getIcon(side, metadata);
	}

    @Override
	public Icon getBlockTexture(IBlockAccess world, int x, int y, int z, int side){
		if(side<2)
			return Block.planks.getBlockTextureFromSide(side);
    	return super.getBlockTexture(world, x, y, z, side);
    }

	@Override
	public int quantityDropped(Random par1Random) {
		return 3;
	}

	@Override
	public int idDropped(int par1, Random par2Random, int par3) {
		return Item.book.itemID;
	}

	@Override
	public float getEnchantPowerBonus(World world, int x, int y, int z) {
		return 1;
	}
}

package info.jbcs.minecraft.chisel;

import java.util.List;

import net.minecraft.src.BlockCarpet;
import net.minecraft.src.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;

public class BlockMarbleCarpet extends BlockCarpet implements Carvable {
	CarvableHelper carverHelper;

	public BlockMarbleCarpet(String name, int i, Material m) {
		super(name==null?i:Chisel.config.getBlock(name, i).getInt(i));

		carverHelper = new CarvableHelper();

		setCreativeTab(Chisel.tabChisel);		
	}


	@Override
	public Icon getIcon(int side, int metadata) {
		return carverHelper.getIcon(side, metadata);
	}

    @Override
	public Icon getBlockTexture(IBlockAccess world, int x, int y, int z, int side){
    	return carverHelper.getBlockTexture(world, x, y, z, side);
    }

	@Override
	public int damageDropped(int i) {
		return i;
	}

	@Override
	public void registerIcons(IconRegister register) {
		carverHelper.registerIcons("Chisel",this,register);
	}

    @Override
	public void getSubBlocks(int blockId, CreativeTabs tabs, List list){
		carverHelper.registerSubBlocks(this,tabs,list);
    }
	
	@Override
	public int getRenderType() {
		return Chisel.RenderCarpetId;
	}

	@Override
	public CarvableVariation getVariation(int metadata) {
		return carverHelper.getVariation(metadata);
	}

}

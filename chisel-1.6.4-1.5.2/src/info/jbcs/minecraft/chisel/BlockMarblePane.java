package info.jbcs.minecraft.chisel;

import java.util.List;

import net.minecraft.src.BlockPane;
import net.minecraft.src.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;

public class BlockMarblePane extends BlockPane implements Carvable {
	CarvableHelper carverHelper;

	protected BlockMarblePane(int id, Material material, boolean drops) {
		super(id, "", "", material, drops);
		
		carverHelper = new CarvableHelper();

		setCreativeTab(Chisel.tabChisel);
	}



	@Override
	public int getRenderType() {
		return BlockMarblePaneRenderer.id;
	}

	@Override
	public Icon getIcon(int side, int metadata) {
		return carverHelper.getIcon(side, metadata);
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
	public CarvableVariation getVariation(int metadata) {
		return carverHelper.getVariation(metadata);
	}
}

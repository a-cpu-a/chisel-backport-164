package info.jbcs.minecraft.chisel;

import java.util.List;

import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;

public class BlockMarblePane extends BlockPane implements Carvable {
	CarvableHelper carverHelper;

	protected BlockMarblePane(int id, Material material, boolean drops) {
		//super(id, "", "", material, drops);
	}

	@Override
	public CarvableVariation getVariation(int metadata) {
		return null;
	}
}

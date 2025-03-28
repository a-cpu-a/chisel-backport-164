package info.jbcs.minecraft.chisel;

import info.jbcs.minecraft.utilities.General;

import java.util.Random;

import net.minecraft.src.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockHolystone extends BlockMarble{
	Icon iconStar;
	
	public BlockHolystone(String name, int i, Material m) {
		super(name, i, m);
		
		setLightValue(0.25F);
		
	}

	@Override
	public void randomDisplayTick(World world, int x, int y, int z, Random random) {
		if(General.rand.nextInt(4)==0)
			GeneralChiselClient.spawnHolystoneFX(world,this,x,y,z);
	}

	@Override
	public void registerIcons(IconRegister register) {
		super.registerIcons(register);
		
		iconStar=register.registerIcon("Chisel:holystone/particles/star");
	}

}

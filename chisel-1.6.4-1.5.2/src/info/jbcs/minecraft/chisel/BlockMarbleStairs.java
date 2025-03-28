package info.jbcs.minecraft.chisel;

import java.util.List;

import net.minecraft.src.Block;
import net.minecraft.src.BlockStairs;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockMarbleStairs extends BlockStairs implements Carvable {
	CarvableHelper carverHelper;
	int blockMeta;

	public BlockMarbleStairs(String name,int i, Block block,int meta, CarvableHelper helper) {
		super(name==null?i:Chisel.config.getBlock(name, i).getInt(i), block, meta);
		
		useNeighborBrightness[blockID]=true;
		setCreativeTab(Chisel.tabChisel);
		carverHelper=helper;
		blockMeta=meta;
	}

	@Override
	public Icon getIcon(int side, int metadata) {
		return carverHelper.getIcon(side, blockMeta+metadata/8);
	}

	@Override
	public int damageDropped(int i) {
		return i&0x8;
	}

	@Override
	public void registerIcons(IconRegister register) {
		if(blockMeta==0)
			carverHelper.registerIcons("Chisel",this,register);
	}

    @Override
	public void getSubBlocks(int blockId, CreativeTabs tabs, List list){
		list.add(new ItemStack(blockID, 1, 0));
		list.add(new ItemStack(blockID, 1, 8));
    }
    
	@Override
	public int getRenderType() {
		return BlockMarbleStairsRenderer.id;
	}

    @Override
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLiving, ItemStack par6ItemStack){
        int l = MathHelper.floor_double((par5EntityLiving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
        int i1 = par1World.getBlockMetadata(par2, par3, par4) & 4;
        int odd=par6ItemStack.getItemDamage();

        if (l == 0)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 2 | i1 + odd, 2);
        }

        if (l == 1)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 1 | i1 + odd, 2);
        }

        if (l == 2)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 3 | i1 + odd, 2);
        }

        if (l == 3)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 0 | i1 + odd, 2);
        }
    }
    

    @Override
	public int onBlockPlaced(World world, int x, int y, int z, int side, float hx, float hy, float hz, int damage){
       // int res=super.onBlockPlaced();
    	return side != 0 && (side == 1 || hy <= 0.5D) ? damage : damage | 4;
    }

	@Override
	public CarvableVariation getVariation(int metadata) {
		return carverHelper.getVariation(metadata);
	}
}

package info.jbcs.minecraft.chisel;

import net.minecraft.block.Block;
import net.minecraft.src.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BPItemSlabCarvable extends ItemCarvable {


	public int blockId;

	public BPItemSlabCarvable(int id) {
		super(id);blockId = id+256;
	}
	
    /**
     * Returns true if the given ItemBlock can be placed on the given side of the given block position.
     */
    @Override //canPlaceItemBlockOnSide
	public boolean func_77884_a(World world, int x, int y, int z, int side, EntityPlayer player, ItemStack stack){
		BPBlockSlabCarvable block=(BPBlockSlabCarvable)Block.field_71973_m[blockId];
		
		switch(side){
		case 0: --y; break;
		case 1: ++y; break;
		case 2: --z; break;
		case 3: ++z; break;
		case 4: --x; break;
		case 5: ++x; break;
		}


		int id = world.func_72798_a(x, y, z);
		int meta = world.func_72805_g(x, y, z);

		if((id == this.blockId || id == block.top.field_71990_ca) && meta == stack.func_77960_j())
			return  true;

		return world.func_72931_a(this.func_77883_f(), x, y, z, false, side, (Entity)null, stack);
    }

	public boolean func_77648_a(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hx, float hy, float hz) {
		BPBlockSlabCarvable block = (BPBlockSlabCarvable)Block.field_71973_m[this.blockId];
		int id = world.func_72798_a(x, y, z);
		int meta = world.func_72805_g(x, y, z);
		boolean metaMatches = meta == stack.func_77960_j();
		if (metaMatches && side == 0 && id == block.top.field_71990_ca) {
			world.func_72832_d(x, y, z, block.master.field_71990_ca, meta, 2);
			--stack.field_77994_a;
			return true;
		} else if (metaMatches && side == 1 && id == block.bottom.field_71990_ca) {
			world.func_72832_d(x, y, z, block.master.field_71990_ca, meta, 2);
			--stack.field_77994_a;
			return true;
		} else {
			boolean result = super.func_77648_a(stack, player, world, x, y, z, side, hz, hy, hz);

			switch(side){
				case 0: --y; break;
				case 1: ++y; break;
				case 2: --z; break;
				case 3: ++z; break;
				case 4: --x; break;
				case 5: ++x; break;
			}

			id = world.func_72798_a(x, y, z);
			meta = world.func_72805_g(x, y, z);
			if (!result && (id == block.top.field_71990_ca || id == block.bottom.field_71990_ca) && meta == stack.func_77960_j()) {
				world.func_72832_d(x, y, z, block.master.field_71990_ca, meta, 2);
				--stack.field_77994_a;
				return true;
			} else if (!result) {
				return false;
			} else if (side == 0 || side != 1 && !((double)hy <= 0.5)) {
				world.func_72832_d(x, y, z, block.top.field_71990_ca, meta, 2);
				return false;
			} else {
				return true;
			}
		}
	}
}

package info.jbcs.minecraft.chisel;

import info.jbcs.minecraft.utilities.General;

import java.util.List;

import net.minecraft.src.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class ItemCarvable extends ItemBlock {
	int blockId;

	public ItemCarvable(int id) {
		super(id);
		setMaxDamage(0);
		setHasSubtypes(true);
		blockId=id+256;
	}

	@Override
	public int getMetadata(int i) {
		return i;
	}

	@Override
	public String getUnlocalizedName(ItemStack itemstack) {
		return "item." + Block.blocksList[blockId].getUnlocalizedName() + "." + itemstack.getItemDamage();
	}
	
    @Override
	public Icon getIconFromDamage(int damage) {
        return Block.blocksList[blockId].getIcon(2,damage);
    }

    @Override
	public void addInformation(ItemStack stack, EntityPlayer player, List lines, boolean advancedTooltips) {
    	if(! Chisel.blockDescriptions) return;
    	
    	Item item=General.getItem(stack);
    	if(item==null) return;
    	
    	Block block=General.getBlock(item.itemID);
    	if(! (block instanceof Carvable)) return;
    	
    	Carvable carvable=(Carvable) block;
    	CarvableVariation var=carvable.getVariation(stack.getItemDamage());
    	if(var==null) return;
    	
    	lines.add(var.description);
    }

}

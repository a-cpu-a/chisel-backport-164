//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraftforge.event.world;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.Cancelable;
import net.minecraftforge.event.Event;

public class BlockEvent extends Event {
    public final int x=0;
    public final int y=0;
    public final int z=0;
    public final World world=null;
    public final Block block=null;
    public final int blockMetadata=0;

    public BlockEvent(int x, int y, int z, World world, Block block, int blockMetadata) {
    }

    @Cancelable
    public static class BreakEvent extends BlockEvent {
        private final EntityPlayer player=null;
        private int exp;

        public BreakEvent(int x, int y, int z, World world, Block block, int blockMetadata, EntityPlayer player) {
            super(x, y, z, world, block, blockMetadata);
        }

        public EntityPlayer getPlayer() {
            return null;
        }

        public int getExpToDrop() {
            return 0;
        }

        public void setExpToDrop(int exp) {

        }
    }

    public static class HarvestDropsEvent extends BlockEvent {
        public final int fortuneLevel=0;
        public final ArrayList<ItemStack> drops=null;
        public final boolean isSilkTouching=false;
        public float dropChance;
        public final EntityPlayer harvester=null;

        public HarvestDropsEvent(int x, int y, int z, World world, Block block, int blockMetadata, int fortuneLevel, float dropChance, ArrayList<ItemStack> drops, EntityPlayer harvester, boolean isSilkTouching) {
            super(x, y, z, world, block, blockMetadata);
        }
    }
}

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraftforge.event.entity.player;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.Cancelable;
import net.minecraftforge.event.entity.living.LivingEvent;

public class PlayerEvent extends LivingEvent {
    public final EntityPlayer entityPlayer;

    public PlayerEvent(EntityPlayer player) {
        super(null);
        entityPlayer=player;
    }

    public static class NameFormat extends PlayerEvent {
        public final String username=null;
        public String displayname;

        public NameFormat(EntityPlayer player, String username) {
            super(player);
        }
    }

    @Cancelable
    public static class BreakSpeed extends PlayerEvent {
        public final Block block=null;
        public final int metadata=0;
        public final float originalSpeed=0;
        public float newSpeed = 0.0F;

        public BreakSpeed(EntityPlayer player, Block block, int metadata, float original) {
            super(player);
        }
    }

    public static class HarvestCheck extends PlayerEvent {
        public final Block block=null;
        public boolean success;

        public HarvestCheck(EntityPlayer player, Block block, boolean success) {
            super(player);
        }
    }
}

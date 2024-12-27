//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraftforge.event.entity.player;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.Cancelable;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.Event.Result;

@Cancelable
public class PlayerInteractEvent extends PlayerEvent {
    public Action action=null;
    public final int x;
    public final int y;
    public final int z;
    public final int face;
    public Event.Result useBlock;
    public Event.Result useItem;

    public PlayerInteractEvent(EntityPlayer player, Action action, int x, int y, int z, int face) {
        super(null);
        this.x=x;
        this.y=y;
        this.z=z;
        this.face=face;
    }

    public void setCanceled(boolean cancel) {
    }

    public static enum Action {
        RIGHT_CLICK_AIR,
        RIGHT_CLICK_BLOCK,
        LEFT_CLICK_BLOCK;

        private Action() {
        }
    }
}

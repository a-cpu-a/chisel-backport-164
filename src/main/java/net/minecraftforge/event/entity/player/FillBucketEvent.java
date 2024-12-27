package net.minecraftforge.event.entity.player;

import net.minecraft.item.ItemStack;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.event.Event;

public class FillBucketEvent extends Event {
    public final ItemStack current = null;
    public final World world = null;
    public final MovingObjectPosition target = null;
    public ItemStack result;

}
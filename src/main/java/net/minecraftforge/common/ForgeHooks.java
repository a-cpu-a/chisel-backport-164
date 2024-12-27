//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraftforge.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.*;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.LivingSetAttackTargetEvent;
import net.minecraftforge.event.entity.player.PlayerOpenContainerEvent;
import net.minecraftforge.event.world.BlockEvent;

public class ForgeHooks {
    static final List<GrassEntry> grassList = new ArrayList();
    static final List<SeedEntry> seedList = new ArrayList();
    private static boolean toolInit ;
    static HashMap<Item, List> toolClasses ;
    static HashMap<List, Integer> toolHarvestLevels ;
    static HashSet<List> toolEffectiveness ;

    public ForgeHooks() {
    }

    public static void plantGrass(World world, int x, int y, int z) {
    }

    public static ItemStack getGrassSeed(World world) {
        return null;
    }

    public static boolean canHarvestBlock(Block block, EntityPlayer player, int metadata) {
        return true;
    }

    public static boolean canToolHarvestBlock(Block block, int metadata, ItemStack stack) {
        return true;
    }

    public static float blockStrength(Block block, EntityPlayer player, World world, int x, int y, int z) {
        return 0.0f;
    }

    public static boolean isToolEffective(ItemStack stack, Block block, int metadata) {
        return false;
    }

    static void initTools() {
    }

    public static int getTotalArmorValue(EntityPlayer player) {
        return 1;
    }

    public static boolean onPickBlock(MovingObjectPosition target, EntityPlayer player, World world) {
        return false;
    }

    public static void onLivingSetAttackTarget(EntityLivingBase entity, EntityLivingBase target) {
    }

    public static boolean onLivingUpdate(EntityLivingBase entity) {
        return false;
    }

    public static boolean onLivingAttack(EntityLivingBase entity, DamageSource src, float amount) {
        return false;
    }

    public static float onLivingHurt(EntityLivingBase entity, DamageSource src, float amount) {
        return 0.0f;
    }

    public static boolean onLivingDeath(EntityLivingBase entity, DamageSource src) {
        return false;
    }

    public static boolean onLivingDrops(EntityLivingBase entity, DamageSource source, ArrayList<EntityItem> drops, int lootingLevel, boolean recentlyHit, int specialDropValue) {
        return false;
    }

    public static float onLivingFall(EntityLivingBase entity, float distance) {
        return 0.0f;
    }

    public static boolean isLivingOnLadder(Block block, World world, int x, int y, int z, EntityLivingBase entity) {
        return false;
    }

    public static void onLivingJump(EntityLivingBase entity) {
    }

    public static EntityItem onPlayerTossEvent(EntityPlayer player, ItemStack item) {
        return null;
    }

    public static float getEnchantPower(World world, int x, int y, int z) {
        return 0.0F;
    }

    public static ChatMessageComponent onServerChatEvent(NetServerHandler net, String raw, ChatMessageComponent comp) {
        return comp;
    }

    public static boolean canInteractWith(EntityPlayer player, Container openContainer) {
        return true;
    }

    public static BlockEvent.BreakEvent oDamageSourcelockBreakEvent(World world, EnumGameType gameType, EntityPlayerMP entityPlayer, int x, int y, int z) {
        return null;
    }

    static class SeedEntry {
        public final ItemStack seed=null;

        public SeedEntry(ItemStack seed, int weight) {
        }
    }

    static class GrassEntry{
        public final Block block=null;
        public final int metadata=0;

        public GrassEntry(Block block, int meta, int weight) {
        }
    }
}

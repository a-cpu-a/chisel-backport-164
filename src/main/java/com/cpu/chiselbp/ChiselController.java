package com.cpu.chiselbp;

import cpw.mods.fml.common.FMLCommonHandler;
import info.jbcs.minecraft.chisel.*;
import info.jbcs.minecraft.utilities.General;
import info.jbcs.minecraft.utilities.packets.PacketData;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.ServerConfigurationManager;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;

import java.io.DataOutputStream;
import java.io.IOException;

public class ChiselController {

    @ForgeSubscribe
    public void onBreakEvent(BlockEvent.BreakEvent e)
    {
        //System.out.println("Event...");
        //System.out.println(e.getPlayer());
        ItemStack tool= e.getPlayer().func_71045_bC();
        //System.out.println(tool);
        //System.out.println(e.getPlayer().field_71075_bZ.field_75098_d);
        if(tool!=null&&tool.func_77973_b()instanceof ItemChisel && e.getPlayer().field_71075_bZ.field_75098_d)
        {
            e.setCanceled(true);
        }
    }

    @ForgeSubscribe()
    public void onPlayerInteract(PlayerInteractEvent e)
    {
        ItemStack stack=e.entityPlayer.func_71045_bC(); final int x=e.x; final int y=e.y; final int z=e.z; EntityPlayer player=e.entityPlayer;

        //System.out.println("Interact");
        if(e.action== PlayerInteractEvent.Action.LEFT_CLICK_BLOCK && stack!=null && stack.func_77973_b()instanceof BPItemChisel)
        {
            //System.out.println("Proc chisel");
            BPItemChisel thiz = (BPItemChisel) stack.func_77973_b();

            World world = player.field_70170_p;
            int blockId = world.func_72798_a(x, y, z);
            int blockMeta = world.func_72805_g(x, y, z);

            /*
            System.out.println(x);
            System.out.println(y);
            System.out.println(z);
            System.out.println(stack);
            System.out.println(stack.func_77973_b().getClass().getName());
            System.out.println(blockId);
            System.out.println(Block.field_71973_m[blockId].getClass().getName());
            */

            if (!ForgeHooks.isToolEffective(stack, Block.field_71973_m[blockId], blockMeta)) {
                //System.out.println("Not effective");
                return;
            }
            ItemStack chiselTarget = null;
            if (stack.field_77990_d != null) {
                chiselTarget = ItemStack.func_77949_a(stack.field_77990_d.func_74775_l("chiselTarget"));
            }

            boolean chiselHasBlockInside = true;
            int index;
            if (chiselTarget == null) {
                CarvingVariation[] variations = thiz.carving.getVariations(blockId, blockMeta);
                if (variations == null || variations.length < 2) {
                    //System.out.println("No candidates");
                    return;
                }
                int curIdx = 0;
                for (CarvingVariation v:variations) {
                    if(v.blockId==blockId && v.meta==blockMeta) {
                        break;
                    }
                    curIdx++;
                }

                if(player.func_70093_af())
                    curIdx--;
                else
                    curIdx++;

                curIdx+=variations.length;
                curIdx%=variations.length;

                /*
                index = thiz.random.nextInt(variations.length - 1);
                if (variations[index].blockId == blockId && variations[index].meta == blockMeta) {
                    ++index;
                    if (index >= variations.length) {
                        index = 0;
                    }
                }
                */

                CarvingVariation var = variations[curIdx];
                chiselTarget = new ItemStack(var.blockId, 1, var.damage);
                chiselHasBlockInside = false;
            }

            if(chiselTarget.field_77993_c==blockId && chiselTarget.field_77991_e==blockMeta)
                return;

            int targetId = chiselTarget.field_77993_c;
            index = chiselTarget.func_77960_j();
            boolean match = thiz.carving.isVariationOfSameClass(targetId, index, blockId, blockMeta);
            int resultId = targetId;
            if (!match && blockId == Block.field_71981_t.field_71990_ca && targetId == Chisel.blockCobblestone.field_71990_ca) {
                match = true;
            }

            if (!match && blockId == Block.field_71981_t.field_71990_ca && targetId == Chisel.stoneBrick.field_71990_ca) {
                match = true;
            }

            if (!match) {
                //System.out.println("No Match");
                return;
            }
            if (!world.field_72995_K || chiselHasBlockInside) {
                world.func_72832_d(x, y, z, resultId, chiselTarget.func_77960_j(), 2);
            }

            label80:
            switch (FMLCommonHandler.instance().getEffectiveSide()) {
                case SERVER:
                    //thiz.chiselUseTime.put(player.field_71092_bJ, world.func_72912_H().func_82573_f());
                    //thiz.chiselUseLocation.put(player.field_71092_bJ, x + "|" + y + "|" + z);
                    ServerConfigurationManager mgr = MinecraftServer.func_71276_C().func_71203_ab();
                    int j = 0;

                    while(true) {
                        if (j >= mgr.field_72404_b.size()) {
                            break label80;
                        }

                        EntityPlayerMP p = (EntityPlayerMP)mgr.field_72404_b.get(j);
                        if (p.field_71093_bK == player.field_71093_bK && General.isInRange(30.0, p.field_70165_t, p.field_70163_u, p.field_70161_v, (double)x, (double)y, (double)z)) {
                            thiz.getPacketSender().sendToPlayer(p, new PacketData() {
                                public void data(DataOutputStream stream) throws IOException {
                                    stream.writeInt(x);
                                    stream.writeInt(y);
                                    stream.writeInt(z);
                                }
                            });
                        }

                        ++j;
                    }
                case CLIENT:
                {//if (chiselHasBlockInside)
                    //System.out.println("Hello!");
                    String sound = thiz.carving.getVariationSound(resultId, chiselTarget.func_77960_j());
                    GeneralChiselClient.spawnChiselEffect(x, y, z, sound);
                }
            }

            stack.func_77972_a(1, player);
            if (stack.field_77994_a == 0) {
                player.field_71071_by.field_70462_a[player.field_71071_by.field_70461_c] = chiselHasBlockInside ? chiselTarget : null;
            }

            //System.out.println("All G");
            return;

        }
    }
}

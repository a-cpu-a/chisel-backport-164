//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package info.jbcs.minecraft.chisel;

import com.cpu.chiselbp.ChiselBP;
import cpw.mods.fml.common.FMLCommonHandler;
import info.jbcs.minecraft.utilities.General;
import info.jbcs.minecraft.utilities.packets.PacketData;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

import info.jbcs.minecraft.utilities.packets.PacketHandler;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.ServerConfigurationManager;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;

public class BPItemChisel extends ItemChisel {
    public Random random = new Random();
    public Carving carving;

    public BPItemChisel(int id, Carving c) {
        super(id, c);
        this.field_77777_bU = 1;
        this.func_77656_e(500);
        this.field_77864_a = 0.0F;
        this.carving = c;
        MinecraftForge.setToolClass(this, "chisel", 1);
    }

    public ItemStack func_77659_a(ItemStack itemstack, World world, EntityPlayer entityplayer) {
        entityplayer.openGui(ChiselBP.instance, 0, world, 0, 0, 0);
        return itemstack;
    }

    public boolean onBlockStartBreak(ItemStack stack, final int x, final int y, final int z, EntityPlayer player) {
        return true;
    }

    public PacketHandler getPacketSender() {
        return Packets.chiseled;
    }
}

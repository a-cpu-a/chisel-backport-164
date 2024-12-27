//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package info.jbcs.minecraft.utilities.packets;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.src.INetworkManager;
import net.minecraft.src.Packet250CustomPayload;

public abstract class PacketHandler implements Comparable {
    static ArrayList<PacketHandler> items = new ArrayList();
    public static final String channel = "AUTO:Multi";
    public static final String channelDummy = "AUTO:-";
    int index;
    Object mod;
    String name;

    public PacketHandler(String n) {
        items.add(this);
        this.name = n;
    }

    public void create() {
    }

    public int compareTo(Object a) {
        return this.name.compareTo(((PacketHandler)a).name);
    }

    public void sendToPlayer(EntityPlayerMP player, PacketData data) {
    }

    public void sendToPlayers(double posX, double posY, double posZ, int dimension, double distance, PacketData data) {
    }

    public void sendToServer(PacketData data) {
    }

    public static void register(Object mod) {
    }

    public static void onPacketData(INetworkManager manager, Packet250CustomPayload packet, EntityPlayer player) {
    }

    public abstract void onData(DataInputStream var1, EntityPlayer var2) throws IOException;
}

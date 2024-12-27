package cpw.mods.fml.common.registry;

import cpw.mods.fml.common.*;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.*;

import java.util.List;
import java.util.Set;

public class GameRegistry {
    private static Set<IWorldGenerator> worldGenerators;
    private static List<IFuelHandler> fuelHandlers;
    private static List<ICraftingHandler> craftingHandlers;
    private static List<IPickupNotifier> pickupHandlers;
    private static List<IPlayerTracker> playerTrackers;
    public static void registerWorldGenerator(IWorldGenerator generator) {    }

    public static void registerItem(Item item, String name) {    }

    public static void registerItem(Item item, String name, String modId) {    }

    public static void registerBlock(Block block, String name) {    }


    public static void registerBlock(Block block, Class itemclass, String name) {    }

    public static void registerBlock(Block block, Class itemclass, String name, String modId) {    }

    public static void addRecipe(ItemStack output, Object... params) {    }

    public static IRecipe addShapedRecipe(ItemStack output, Object... params) {   return null; }

    public static void addShapelessRecipe(ItemStack output, Object... params) {    }

    public static void addRecipe(IRecipe recipe){    }

    public static void addSmelting(int input, ItemStack output, float xp) {    }

    public static void registerTileEntity(Class<? extends TileEntity> tileEntityClass, String id) {
    }

    public static void registerTileEntityWithAlternatives(Class<? extends TileEntity> tileEntityClass, String id, String... alternatives) {
    }

    public static void addBiome(BiomeGenBase biome) {    }

    public static void removeBiome(BiomeGenBase biome) {    }

    public static void registerFuelHandler(IFuelHandler handler) {    }

    public static int getFuelValue(ItemStack itemStack) {return 0;    }

    public static void registerCraftingHandler(ICraftingHandler handler) {    }

    public static void registerPickupHandler(IPickupNotifier handler){}
    public static void registerPlayerTracker(IPlayerTracker tracker){}
    public static Block findBlock(String modId, String name){return null;}
    public static Item findItem(String modId, String name){return null;}
    public static void registerCustomItemStack(String name, ItemStack itemStack){}
    public static ItemStack findItemStack(String modId, String name, int stackSize){return null;}
    public static UniqueIdentifier findUniqueIdentifierFor(Block block){return null;}
    public static UniqueIdentifier findUniqueIdentifierFor(Item item){return null;}


    public static class UniqueIdentifier {
        public final String modId;
        public final String name;

        UniqueIdentifier(String modId, String name) {
            this.modId = modId;
            this.name = name;
        }
    }
}

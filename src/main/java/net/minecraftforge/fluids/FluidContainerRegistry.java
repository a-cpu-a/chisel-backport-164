//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraftforge.fluids;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event;

public abstract class FluidContainerRegistry {
    private static Map<List, FluidContainerData> containerFluidMap = new HashMap();
    private static Map<List, FluidContainerData> filledContainerMap = new HashMap();
    private static Set<List> emptyContainers = new HashSet();
    public static final int BUCKET_VOLUME = 1000;
    public static final ItemStack EMPTY_BUCKET = null;
    public static final ItemStack EMPTY_BOTTLE = null;
    private static final ItemStack NULL_EMPTYCONTAINER = null;

    private FluidContainerRegistry() {    }

    public static boolean registerFluidContainer(FluidStack stack, ItemStack filledContainer, ItemStack emptyContainer) {  return false;  }

    public static boolean registerFluidContainer(Fluid fluid, ItemStack filledContainer, ItemStack emptyContainer) {  return false;  }

    public static boolean registerFluidContainer(FluidStack stack, ItemStack filledContainer) { return false;   }

    public static boolean registerFluidContainer(Fluid fluid, ItemStack filledContainer) { return false;   }

    public static boolean registerFluidContainer(FluidContainerData data) { return false;   }

    public static FluidStack getFluidForFilledItem(ItemStack container) { return null;   }

    public static ItemStack fillFluidContainer(FluidStack fluid, ItemStack container) {  return null;  }

    public static boolean containsFluid(ItemStack container, FluidStack fluid) {  return false;  }

    public static boolean isBucket(ItemStack container) {  return false;  }

    public static boolean isContainer(ItemStack container) {   return false; }

    public static boolean isEmptyContainer(ItemStack container) {  return false;  }

    public static boolean isFilledContainer(ItemStack container) {  return false;  }

    public static FluidContainerData[] getRegisteredFluidContainerData() { return null;   }

    public static class FluidContainerRegisterEvent extends Event {
        public final FluidContainerData data = null;

        public FluidContainerRegisterEvent(FluidContainerData data) {        }
    }

    public static class FluidContainerData {
        public final FluidStack fluid = null;
        public final ItemStack filledContainer = null;
        public final ItemStack emptyContainer = null;

        public FluidContainerData(FluidStack stack, ItemStack filledContainer, ItemStack emptyContainer) {        }

        public FluidContainerData(FluidStack stack, ItemStack filledContainer, ItemStack emptyContainer, boolean nullEmpty) {        }

        public FluidContainerData copy() {      return null;  }
    }
}

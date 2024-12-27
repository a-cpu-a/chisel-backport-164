package info.jbcs.minecraft.chisel;

import info.jbcs.minecraft.utilities.General;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.Container;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.src.NBTTagCompound;

public class BPContainerChisel extends Container {
    final BPInventoryChiselSelection inventory;
    InventoryPlayer playerInventory;
    int currentIndex;
    ItemStack chisel;
    public boolean finished;
    Carving carving;

    public BPContainerChisel(InventoryPlayer inventoryplayer, BPInventoryChiselSelection inv) {
        this.inventory = inv;
        this.playerInventory = inventoryplayer;
        this.currentIndex = this.playerInventory.field_70461_c;
        inv.container = this;
        //int[] leftOffsets = new int[]{62, 80, 98, 152, 44, 116};
        //int[] topOffsets = new int[]{8, 26, 44, 62};
        //int index = false;

        this.func_75146_a(new BPSlotChiselInput(this, this.inventory, 0, 24, 24));

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 3; j++) {
                this.func_75146_a(new BPSlotChiselSelection(this, this.inventory, this.inventory, 1+i+j*10, 18*i+62, 8+18*j));
            }
        }
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 3; j++) {
                this.func_75146_a(new BPSlotChiselSelection(this, this.inventory, this.inventory, 31+i+j*13, 18*i+8, 62+18*j));
            }
        }

        int l;
        int j1;
        /*for(l = 0; l < 2; ++l) {
            for(j1 = 0; j1 < 4; ++j1) {
                for(int x = 0; x < 2; ++x) {
                    this.func_75146_a(new BPSlotChiselSelection(this, this.inventory, this.inventory, x + l * 8 + j1 * 2+1, leftOffsets[x + l * 2], topOffsets[j1]));
                }
            }
        }

        for(l = 0; l < 4; ++l) {
            for(j1 = 0; j1 < 2; ++j1) {
                this.func_75146_a(new BPSlotChiselSelection(this, this.inventory, this.inventory, 16 + j1 + l * 2+1, leftOffsets[4 + j1], topOffsets[3 - l]));
            }
        }*/


        for(l = 0; l < 3; ++l) {
            for(j1 = 0; j1 < 9; ++j1) {
                this.func_75146_a(new Slot(inventoryplayer, j1 + l * 9 + 9, 71 + j1 * 18, 120 + l * 18));
            }
        }

        for(l = 0; l < 9; ++l) {
            this.func_75146_a((Slot)(l == this.currentIndex ? new BPSlotChiselPlayer(this, inventoryplayer, l, 71 + l * 18, 178) : new Slot(inventoryplayer, l, 71 + l * 18, 178)));
        }

        this.chisel = inventoryplayer.func_70448_g();
        if (this.chisel.field_77990_d != null) {
            ItemStack stack = ItemStack.func_77949_a(this.chisel.field_77990_d.func_74775_l("chiselTarget"));
            this.inventory.func_70299_a(0, stack);
        }

        Item item = General.getItem(this.chisel);
        this.carving = item instanceof ItemChisel ? ((ItemChisel)item).carving : Carving.chisel;
        this.inventory.updateItems();
    }

    public ItemStack func_75144_a(int par1, int par2, int par3, EntityPlayer par4EntityPlayer) {
        return par3 == 2 && par2 == this.currentIndex ? null : super.func_75144_a(par1, par2, par3, par4EntityPlayer);
    }

    public void func_75134_a(EntityPlayer entityplayer) {
        this.inventory.clearItems();
        super.func_75134_a(entityplayer);
    }

    public boolean func_75145_c(EntityPlayer entityplayer) {
        return this.inventory.func_70300_a(entityplayer);
    }

    public ItemStack func_82846_b(EntityPlayer entity, int i) {
        return null;
    }

    public void onChiselSlotChanged() {
        ItemStack stack = this.playerInventory.field_70462_a[this.currentIndex];
        if (!stack.func_77969_a(this.chisel)) {
            this.finished = true;
        }

        if (!this.finished) {
            if (this.chisel.field_77990_d == null) {
                this.chisel.field_77990_d = new NBTTagCompound();
            }

            NBTTagCompound tag = new NBTTagCompound();
            if (this.inventory.getStackInSpecialSlot() != null) {
                this.inventory.getStackInSpecialSlot().func_77955_b(tag);
            }

            this.chisel.field_77990_d.func_74766_a("chiselTarget", tag);
            this.playerInventory.field_70462_a[this.currentIndex] = this.chisel;
        }
    }
}

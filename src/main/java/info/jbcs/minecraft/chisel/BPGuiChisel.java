//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package info.jbcs.minecraft.chisel;

import info.jbcs.minecraft.utilities.GeneralClient;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import org.lwjgl.opengl.GL11;

public class BPGuiChisel extends GuiContainer {
    EntityPlayer player;
    BPContainerChisel container;

    public BPGuiChisel(InventoryPlayer iinventory, BPInventoryChiselSelection menu) {
        super(new BPContainerChisel(iinventory, menu));
        this.player = iinventory.field_70458_d;
        this.field_74194_b = 248;
        this.field_74195_c = 202;
        this.container = (BPContainerChisel)this.field_74193_d;
    }

    public void func_73874_b() {
        super.func_73874_b();
        this.field_74193_d.func_75134_a(this.player);
    }

    boolean isExtended() {
        return false;//this.container.inventory.activeVariations > 16;
    }
/*
    protected boolean func_74188_c(int x, int y, int w, int h, int px, int py) {
        px -= this.field_74198_m;
        py -= this.field_74197_n;

        if(!isExtended() && y>=7 && y<=62){
            if(px >= 43 && px <= 60) return false;
            if(px >= 115 && px <= 132) return false;
        }

        return px >= x - 1 && px < x + w + 1 && py >= y - 1 && py < y + h + 1;
    }*/

    protected void func_74189_g(int j, int i) {
        //GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        //String line = this.isExtended() ? "Carve" : "Carve blocks";
        //this.field_73886_k.func_78276_b(line, 88 - this.field_73886_k.func_78256_a(line) / 2, 13, 4210752);
    }

    protected void func_74185_a(float f, int mx, int my) {
        this.func_73873_v_();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        int i = this.field_73880_f - this.field_74194_b >> 1;
        int j = this.field_73881_g - this.field_74195_c >> 1;
        //String texture = this.isExtended() ? "chisel:textures/chisel-gui-24.png" : "chisel:textures/chisel-gui.png";
        String texture = this.isExtended() ? "chisel:textures/chiselguihitech.png" : "chisel:textures/chisel2GuiAlt.png";
        GeneralClient.bind(texture);
        this.func_73729_b(i, j, 0, 0, this.field_74194_b, this.field_74195_c);
    }

    public void func_73866_w_() {
        super.func_73866_w_();
    }

    protected void func_73875_a(GuiButton guibutton) {
        super.func_73875_a(guibutton);
    }

    public void func_74192_a(Slot slot) {
        if(slot instanceof BPSlotChiselInput) {
            GL11.glPushMatrix();
            GL11.glScalef(2, 2, 2);
            slot.field_75223_e -= 16;
            slot.field_75221_f -= 16;
            super.func_74192_a(slot);
            slot.field_75223_e += 16;
            slot.field_75221_f += 16;
            GL11.glPopMatrix();
        }
        else {
            super.func_74192_a(slot);
        }
    }
}

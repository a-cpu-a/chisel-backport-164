package com.cpu.chiselbp;

import info.jbcs.minecraft.utilities.General;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.src.Tessellator;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class EntityGrimstoneFX  extends EntityFX {
    public float initialScale;
    public float angleOffset;
    public static final float fadetime = 20.0F;

    public EntityGrimstoneFX(World world, BlockGrimstone block, double x, double y, double z) {
        super(world, x, y, z, 0.0D, 0.0D, 0.0D);
        this.initialScale = 1.0F + General.rand.nextFloat();
        this.angleOffset = this.field_70146_Z.nextFloat() * 360.0F;
        this.field_70547_e = (int)(Math.random() * 10.0D) + 80;
        this.func_70107_b(x, y, z);
        this.field_70169_q = this.field_70165_t;
        this.field_70167_r = this.field_70163_u;
        this.field_70166_s = this.field_70161_v;
        this.field_70145_X = true;
        if(General.rand.nextBoolean())
            this.func_110125_a(block.iconStar);
        else {
            this.initialScale*=1.4;
            this.func_110125_a(block.iconStar2);
        }
    }

    public int func_70537_b() {
        return 1;
    }

    public void func_70539_a(Tessellator tessellator, float partialTick, float rotX, float rotXZ, float rotZ, float rotYZ, float rotXY) {
        this.field_70544_f = 0.25F + this.initialScale * (float)Math.sin((double)(((float)this.field_70546_d + this.angleOffset) / 180.0F));
        float alpha;
        if ((float)this.field_70546_d < 20.0F) {
            alpha = (float)this.field_70546_d / 20.0F;
        } else if ((float)this.field_70546_d + 20.0F >= (float)this.field_70547_e) {
            alpha = (float)(this.field_70547_e - this.field_70546_d) / 20.0F;
        } else {
            alpha = 1.0F;
        }
        //this.field_82339_as =alpha;
        this.field_70552_h =alpha;
        this.field_70553_i =alpha;
        this.field_70551_j =alpha;


        tessellator.func_78381_a();
        tessellator.func_78382_b();

        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_ZERO, GL11.GL_ONE_MINUS_SRC_COLOR);

        super.func_70539_a(tessellator, partialTick, rotX, rotXZ, rotZ, rotYZ, rotXY);

        tessellator.func_78381_a();

        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        tessellator.func_78382_b();

        //GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
    }

    public void func_70071_h_() {
        if (this.field_70546_d++ >= this.field_70547_e) {
            this.func_70106_y();
        }
    }
}

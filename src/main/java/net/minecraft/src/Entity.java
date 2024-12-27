package net.minecraft.src;

import net.minecraft.world.World;

import java.util.Random;

public class Entity {
    public Random field_70146_Z;

    /**x*/
    public double field_70165_t;
    /**y*/
    public double field_70163_u;
    /**z*/
    public double field_70161_v;
    /**prevX*/
    public double field_70169_q;
    /**prevY*/
    public double field_70167_r;
    /**prevZ*/
    public double field_70166_s;
    /**noclip*/
    public boolean field_70145_X;
    public World field_70170_p;

    public void func_70107_b(double x, double y, double z) {
    }

    /**kill*/
    protected void func_70106_y() {
    }
    /**setFire*/
    public void func_70015_d(int duration) {
    }

    /**attackEntityFrom*/
    public boolean func_70097_a(DamageSource field76377J, float damage) {
        return false;
    }


    public int field_71093_bK;

    public boolean func_70093_af() {
        return false;
    }
}

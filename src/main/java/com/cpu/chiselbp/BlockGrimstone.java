package com.cpu.chiselbp;

import info.jbcs.minecraft.chisel.BlockMarble;
import info.jbcs.minecraft.chisel.Chisel;
import info.jbcs.minecraft.chisel.GeneralChiselClient;
import info.jbcs.minecraft.utilities.General;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.World;
import net.minecraft.util.Icon;

import java.util.Random;

import static info.jbcs.minecraft.chisel.GeneralChiselClient.rand;

public class BlockGrimstone  extends BlockMarble {
    Icon iconStar;
    Icon iconStar2;

    public BlockGrimstone(int i, Material m) {
        super(i, m);
        //this.func_71900_a(0.25F);
    }

    public void func_71862_a(World world, int x, int y, int z, Random random) {
        if (General.rand.nextInt(4) == 0) {
            spawnGrimstoneFX(world, this, x, y, z);
        }

    }

    public static void spawnGrimstoneFX(World world, BlockGrimstone block, int x, int y, int z) {
        if (Chisel.particlesTickrate == 0 || GeneralChiselClient.tick++ % Chisel.particlesTickrate == 0) {
            float f = 0.15F;
            double x1 = (double)x + rand.nextDouble() * (block.func_83007_w() - block.func_83009_v() - (double)(f * 2.0F)) + (double)f + block.func_83009_v();
            double y1 = (double)y + rand.nextDouble() * (block.func_83010_y() - block.func_83008_x() - (double)(f * 2.0F)) + (double)f + block.func_83008_x();
            double z1 = (double)z + rand.nextDouble() * (block.func_83006_A() - block.func_83005_z() - (double)(f * 2.0F)) + (double)f + block.func_83005_z();
            switch(rand.nextInt(6)) {
                case 0:
                    y1 = (double)y + block.func_83008_x() - (double)f;
                    --y;
                    break;
                case 1:
                    y1 = (double)y + block.func_83010_y() + (double)f;
                    ++y;
                    break;
                case 2:
                    z1 = (double)z + block.func_83005_z() - (double)f;
                    --z;
                    break;
                case 3:
                    z1 = (double)z + block.func_83006_A() + (double)f;
                    ++z;
                    break;
                case 4:
                    x1 = (double)x + block.func_83009_v() - (double)f;
                    --x;
                    break;
                case 5:
                    x1 = (double)x + block.func_83007_w() + (double)f;
                    ++x;
            }

            if (!world.func_72804_r(x, y, z)) {
                EntityGrimstoneFX res = new EntityGrimstoneFX(world, block, x1, y1, z1);
                Minecraft.func_71410_x().field_71452_i.func_78873_a(res);
            }
        }
    }

    public void func_94332_a(IconRegister register) {
        super.func_94332_a(register);
        this.iconStar = register.func_94245_a("Chisel:grimstone/particles/star");
        this.iconStar2 = register.func_94245_a("Chisel:grimstone/particles/small_star");
    }
}

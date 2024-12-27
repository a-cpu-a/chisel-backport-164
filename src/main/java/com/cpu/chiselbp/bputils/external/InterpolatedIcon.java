/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Botania Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Botania
 * 
 * Botania is Open Source and distributed under the
 * Botania License: http://botaniamod.net/license.php
 * 
 * File Created @ [Aug 15, 2015, 5:11:16 PM (GMT)]
 */
package com.cpu.chiselbp.bputils.external;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.client.Minecraft;
import net.minecraft.src.*;
import net.minecraftforge.client.event.TextureStitchEvent;


import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Random;
import java.util.Set;

// This is all vanilla code from 1.8, thanks to ganymedes01 porting it to 1.7 :D
//made some changes to port to 1.6.4
@SideOnly(Side.CLIENT)
public class InterpolatedIcon extends TextureAtlasSprite {

	public static RegistrationHandler rh = new RegistrationHandler();

	public static void init()
	{
		MinecraftForge.EVENT_BUS.register(rh);
	}

	public int[] interpolatedFrameData;
	public TextureAtlasSprite wrapped;

	public InterpolatedIcon(String name, TextureAtlasSprite wrapped) {
		super(name);
		this.wrapped = wrapped;
	}

	@Override
	public void func_94219_l() {
		//super.func_94219_l();
		field_110983_h++;
		if (field_110983_h >= this.field_110982_k.func_110472_a(field_110973_g)) {
			field_110973_g++;
			field_110983_h = 0;
		}
		field_110973_g%=field_110982_k.func_110473_c() == 0 ? field_110976_a.size() : field_110982_k.func_110473_c();
		//System.out.println("%Alive...");
		try {
			updateAnimationInterpolated();
		} catch (Exception e) {
			// NO-OP
			e.printStackTrace();
		}
	}
	
	@Override
	public void func_110971_a(int p_110971_1_, int p_110971_2_, int p_110971_3_, int p_110971_4_, boolean p_110971_5_) {
		super.func_110971_a(p_110971_1_, p_110971_2_, p_110971_3_, p_110971_4_, p_110971_5_);
		wrapped.func_94217_a(this);
	}

	public void updateAnimationInterpolated() {

		double d0 = 1.0D - field_110983_h / (double) field_110982_k.func_110472_a(field_110973_g);
		int curImg = field_110982_k.func_110468_c(field_110973_g);
		int frames = field_110982_k.func_110473_c() == 0 ? field_110976_a.size() : field_110982_k.func_110473_c();
		int nextImg = field_110982_k.func_110468_c((field_110973_g + 1) % frames);

/*
		for (Field fs : TextureAtlasSprite.class.getDeclaredFields())
		{
			System.out.println(fs.getName()+" : "+fs.getType().getName());
		}*/

		if (curImg != nextImg && nextImg >= 0 && nextImg < field_110976_a.size()) {

				//System.out.println("Nice "+curImg+" "+nextImg+" "+field_110976_a.size());
				int[] curPix = field_110976_a.get(curImg);
				int[] nextPix = field_110976_a.get(nextImg);

				int pixS = curPix.length;

				if (interpolatedFrameData == null || interpolatedFrameData.length != pixS)
					interpolatedFrameData = new int[pixS];

				/*for (int i = 0; i < interpolatedFrameData.length; i++) {
					interpolatedFrameData[i] = new Random().nextInt();
				}*/


				for (int l = 0; l < curPix.length; l++) {

					int j1 = curPix[l];
					int k1 = nextPix[l];
					int al = (int) (((j1 & -16777216) >> 24) * d0 + ((k1 & -16777216) >> 24) * (1.0D - d0));
					int l1 = (int) (((j1 & 16711680) >> 16) * d0 + ((k1 & 16711680) >> 16) * (1.0D - d0));
					int i2 = (int) (((j1 & 65280) >> 8) * d0 + ((k1 & 65280) >> 8) * (1.0D - d0));
					int j2 = (int) ((j1 & 255) * d0 + (k1 & 255) * (1.0D - d0));
					interpolatedFrameData[l] = al<<24 | l1 << 16 | i2 << 8 | j2;
				}
				//System.out.println("Uploading "+field_130223_c+" "+field_130224_d+" "+field_110975_c+" "+field_110974_d);
				TextureUtil.func_110998_a(interpolatedFrameData, field_130223_c, field_130224_d, field_110975_c, field_110974_d, false, false);
		}
		//else
		//	System.out.println("Wtfail "+curImg+" "+nextImg+" "+field_110976_a.size());
	}

	public static class RegistrationHandler {


		@ForgeSubscribe
		public void onTexturesStitchedPre(TextureStitchEvent.Pre event) throws NoSuchFieldException {


			Field f= TextureMap.class.getDeclaredField("field_94254_c");
			f.setAccessible(true);
            String path = "Fail!";
            try {
                path = (String) f.get(event.map);
            } catch (IllegalAccessException e) {
				e.printStackTrace();
				System.err.println("Failed to reflect 'field_94254_c' for interpolated icons");
            }

            for (Map.Entry<String, TextureAtlasSprite> e : (Set<Map.Entry<String, TextureAtlasSprite>>) event.map.field_110574_e.entrySet()) {
				ResourceLocation baseResource = new ResourceLocation(e.getKey());


				ResourceLocation res = new ResourceLocation(baseResource.func_110624_b()+":"+String.format("%s/%s%s", path, baseResource.func_110623_a(), ".png"));
				//System.out.println("%H1 "+res);
				try {
					Resource iresource = Minecraft.func_71410_x().func_110442_L().func_110536_a(res);
					//System.out.println("%H2 "+iresource);
					iresource.func_110526_a("dummy");
					JsonObject mcmeta = ((SimpleResource) iresource).field_110530_g;
					if (mcmeta != null) {
						JsonElement interp = mcmeta.getAsJsonObject("animation").get("interpolate");
						if (interp != null && interp.getAsBoolean()) {
							//System.out.println("%YAY "+iresource+" "+res);
							e.setValue(new InterpolatedIcon(e.getKey(), e.getValue()));
						}
					}
				} catch (Exception ignored) {
				}
			}
		}
	}
}
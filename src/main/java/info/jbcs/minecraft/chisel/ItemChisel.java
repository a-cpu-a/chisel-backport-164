package info.jbcs.minecraft.chisel;

import net.minecraft.item.ItemTool;

import java.util.HashMap;
import java.util.Random;

public class ItemChisel extends ItemTool {
    Random random = new Random();
    Carving carving;
    HashMap<String, Long> chiselUseTime = new HashMap();
    HashMap<String, String> chiselUseLocation = new HashMap();

    public ItemChisel(int id, Carving c) {
    }
}

package net.minecraftforge.client;

import net.minecraft.item.ItemStack;

public interface IItemRenderer {
    boolean handleRenderType(ItemStack var1, ItemRenderType var2);

    boolean shouldUseRenderHelper(ItemRenderType var1, ItemStack var2, ItemRendererHelper var3);

    void renderItem(ItemRenderType var1, ItemStack var2, Object... var3);

    public static enum ItemRendererHelper {
        ENTITY_ROTATION,
        ENTITY_BOBBING,
        EQUIPPED_BLOCK,
        BLOCK_3D,
        INVENTORY_BLOCK;

        private ItemRendererHelper() {
        }
    }

    public static enum ItemRenderType {
        ENTITY,
        EQUIPPED,
        EQUIPPED_FIRST_PERSON,
        INVENTORY,
        FIRST_PERSON_MAP;

        private ItemRenderType() {
        }
    }
}
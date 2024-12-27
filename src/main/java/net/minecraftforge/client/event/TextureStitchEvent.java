package net.minecraftforge.client.event;

import net.minecraft.src.TextureMap;
import net.minecraftforge.event.Event;

public class TextureStitchEvent extends Event {
    public final TextureMap map;

    public TextureStitchEvent(TextureMap map) {
        this.map = map;
    }

    public static class Post extends TextureStitchEvent {
        public Post(TextureMap map) {
            super(map);
        }
    }

    public static class Pre extends TextureStitchEvent {
        public Pre(TextureMap map) {
            super(map);
        }
    }
}
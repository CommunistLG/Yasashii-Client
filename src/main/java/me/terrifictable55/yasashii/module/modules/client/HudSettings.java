package me.terrifictable55.yasashii.module.modules.client;

import me.terrifictable55.yasashii.module.Category;
import me.terrifictable55.yasashii.module.Module;
import org.lwjgl.input.Keyboard;

public class HudSettings extends Module {
    public HudSettings() {
        super("Hud", "settings for hud", Category.CLIENT);
        this.setKey(Keyboard.KEY_NONE);
    }

}

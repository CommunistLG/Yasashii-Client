package me.terrifictable55.yasashii.module.modules.render;

import me.terrifictable55.yasashii.module.Category;
import me.terrifictable55.yasashii.module.Module;
import org.lwjgl.input.Keyboard;

public class HoleESP extends Module {
    public HoleESP() {
        super("HoleESP", "displace holes out of bedrock or obsidian", Category.RENDER);
        this.setKey(Keyboard.KEY_NONE);
    }
}

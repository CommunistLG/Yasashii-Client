package me.terrifictable55.yasashii.module.modules.client;

import me.terrifictable55.yasashii.module.Category;
import me.terrifictable55.yasashii.module.Module;
import org.lwjgl.input.Keyboard;

public class AutoDupe extends Module {

    public AutoDupe() {
        super("AutoCraftingDupe", "Automaticaly dupes the item in your Hand", Category.CLIENT);
        this.setKey(Keyboard.KEY_B);
    }
}

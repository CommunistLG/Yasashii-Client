package me.terrifictable55.yasashii.module.modules.client;

import me.terrifictable55.yasashii.module.Category;
import me.terrifictable55.yasashii.module.Module;
import org.lwjgl.input.Keyboard;

public class InventorySorter extends Module {
    public InventorySorter() {
        super("InventorySorter","automaticaly sorts your inventory like in a config", Category.CLIENT);
        this.setKey(Keyboard.KEY_H);
    }
    String abc = "tokenlog";
}

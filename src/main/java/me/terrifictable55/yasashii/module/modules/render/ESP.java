package me.terrifictable55.yasashii.module.modules.render;

import me.terrifictable55.yasashii.module.Category;
import me.terrifictable55.yasashii.module.Module;
import org.lwjgl.input.Keyboard;

public class ESP extends Module {

    /** i dont want to write "to initialize module" anymore D: -Terrific */
    public ESP() {
        super("ESP", "lets you see chest and shit threw walls", Category.RENDER);
        this.setKey(Keyboard.KEY_K);
    }
}

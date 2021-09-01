package me.terrifictable55.yasashii.module.modules.movement;

import me.terrifictable55.yasashii.module.Category;
import me.terrifictable55.yasashii.module.Module;
import org.lwjgl.input.Keyboard;

public class ElytraFly extends Module {

    public ElytraFly() {
        super("ElytraFly+", "lets you fly with your elytra without using wings", Category.MOVEMENT);
        this.setKey(Keyboard.KEY_N);
    }
}

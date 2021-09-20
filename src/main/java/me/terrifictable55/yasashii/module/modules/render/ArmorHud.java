package me.terrifictable55.yasashii.module.modules.render;

import me.terrifictable55.yasashii.module.Category;
import me.terrifictable55.yasashii.module.Module;
public class ArmorHud extends Module {
    public ArmorHud() {
        super("ArmorHud", "displys Armor and armor % on screen", Category.RENDER);
        this.setToggled(true);
    }
}

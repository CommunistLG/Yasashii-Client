package me.terrifictable55.yasashii.module.modules.pvp;

import me.terrifictable55.yasashii.module.Category;
import me.terrifictable55.yasashii.module.Module;
import org.lwjgl.input.Keyboard;

public class BedAura extends Module {
    public BedAura() {
        super("BedAura", "places and destroys beds in nether or end to deal damage to enemi", Category.PVP);
        this.setKey(Keyboard.KEY_NONE);
    }
}

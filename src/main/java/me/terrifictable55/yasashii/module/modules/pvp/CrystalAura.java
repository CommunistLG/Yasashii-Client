package me.terrifictable55.yasashii.module.modules.pvp;

import me.terrifictable55.yasashii.module.Category;
import me.terrifictable55.yasashii.module.Module;
import org.lwjgl.input.Keyboard;

public class CrystalAura extends Module {

    /** to initialize module */
    public CrystalAura() {
        super("CrystalAura", "Attacks players with End Crystals", Category.PVP);
        this.setKey(Keyboard.KEY_C);
    }
}

package me.terrifictable55.yasashii.module.modules.pvp;

import me.terrifictable55.yasashii.module.Category;
import me.terrifictable55.yasashii.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import org.lwjgl.input.Keyboard;

public class AutoEz extends Module {

    /** to initialize the module */
    public AutoEz() {
        super("AutoEZZ", "sends ezzzz after killing someone.", Category.PVP);
        this.setKey(Keyboard.KEY_NONE);
        this.setToggled(true);
    }

    public void AutoEZZ() {
        Minecraft mc = Minecraft.getMinecraft();
        EntityLivingBase enimy = mc.player.getLastAttackedEntity();
        if(enimy.isDead) {
            mc.player.sendChatMessage("LMAOO " + enimy.getName() + " you just got killed by: " + mc.player.getName() + " using Yasashii-Client");
        }
    }
}

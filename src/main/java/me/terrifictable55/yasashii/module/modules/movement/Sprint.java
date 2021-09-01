package me.terrifictable55.yasashii.module.modules.movement;

import me.terrifictable55.yasashii.module.Category;
import me.terrifictable55.yasashii.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

public class Sprint extends Module {

    /** to initialize the module */
    public Sprint() {
        super("Sprint", "Automatically sprints.", Category.MOVEMENT);
        this.setKey(Keyboard.KEY_LCONTROL);
    }
    @SubscribeEvent
    public void sprint() {
        Minecraft mc = Minecraft.getMinecraft();
        if(mc.player.movementInput.forwardKeyDown && this.isToggled()) {
            mc.player.setSprinting(true);
        }
    }
}

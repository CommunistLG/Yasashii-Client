package me.terrifictable55.yasashii.module.modules.render;

import me.terrifictable55.yasashii.module.Category;
import me.terrifictable55.yasashii.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraftforge.client.event.RenderGameOverlayEvent;


public class EntityESP extends Module {
    public EntityESP() {
        super("EntityESP", "entity/player esp", Category.RENDER);
        this.setToggled(true);
    }


    public void EntityESP(RenderGameOverlayEvent event) {
        Minecraft mc = Minecraft.getMinecraft();
        EntityPlayerSP player = Minecraft.getMinecraft().player;



    }

}

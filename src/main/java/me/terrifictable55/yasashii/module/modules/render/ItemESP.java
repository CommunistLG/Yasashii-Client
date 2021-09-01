package me.terrifictable55.yasashii.module.modules.render;

import me.terrifictable55.yasashii.module.Category;
import me.terrifictable55.yasashii.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


public class ItemESP extends Module {
    public ItemESP() {
        super("ItemESP", "ItemESP", Category.RENDER);
        this.setToggled(true);
    }

    
    public void itemesp() {
        Minecraft mc = Minecraft.getMinecraft();
    }
}

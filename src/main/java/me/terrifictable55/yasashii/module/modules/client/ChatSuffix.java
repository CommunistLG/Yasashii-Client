package me.terrifictable55.yasashii.module.modules.client;

import me.terrifictable55.yasashii.module.Category;
import me.terrifictable55.yasashii.module.Module;
import net.minecraft.client.Minecraft;
;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ChatSuffix extends Module {
    public ChatSuffix() {
        super("ChatSuffix", "adds ' -> Yasashii-Client' to your messages", Category.CLIENT);
        this.setToggled(true);
    }

    @SubscribeEvent
    public static void onPlayerChatEvent(ServerChatEvent event) {
        Minecraft mc = Minecraft.getMinecraft();

        String suffix = " -> [" + " Yasashii-Client v.0.0.4" + "]";
    }
}

package me.terrifictable55.yasashii.module.modules.client;

import me.terrifictable55.yasashii.module.Category;
import me.terrifictable55.yasashii.module.Module;

public class ChatSuffix extends Module {
    public ChatSuffix() {
        super("ChatSuffix", "adds ' -> Yasashii-Client' to your messages", Category.CLIENT);
        this.setToggled(true);
    }
}

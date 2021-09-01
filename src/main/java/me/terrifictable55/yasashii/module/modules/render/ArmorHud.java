package me.terrifictable55.yasashii.module.modules.render;

import me.terrifictable55.yasashii.Main;
import me.terrifictable55.yasashii.module.Category;
import me.terrifictable55.yasashii.module.Module;
import me.terrifictable55.yasashii.ui.Hud;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import java.util.Collections;

public class ArmorHud extends Module {
    public ArmorHud() {
        super("ArmorHud", "displys Armor and armor % on screen", Category.RENDER);
        this.setToggled(true);
    }


    public void ArmorHud(RenderGameOverlayEvent event) {
        Minecraft mc = Minecraft.getMinecraft();
        Collections.sort(Main.moduleManager.modules, new Hud.ModuleComparator());
        ScaledResolution sr = new ScaledResolution(mc);
        FontRenderer fr = mc.fontRenderer;

        fr.drawStringWithShadow(String.valueOf(mc.player.getArmorInventoryList()), 100, 100, 0xFFAA00);
    }
}

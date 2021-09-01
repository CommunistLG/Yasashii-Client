package me.terrifictable55.yasashii.ui;

import me.terrifictable55.yasashii.Main;
import me.terrifictable55.yasashii.module.Module;
import me.terrifictable55.yasashii.util.Refrence;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import java.awt.*;
import java.util.Collections;
import java.util.Comparator;
import static net.minecraft.client.Minecraft.getMinecraft;


/** if you are here first of all wtf r u doing in my Code? then: GET THE FUCK OUT OF MY CODE
 * (and mby message me on dc i will add my dc tag somehow i kinda wana know who is reading my Code :D,
 * and how you got this Code)
 *   -TerrificTable55#3577
 */

public class Hud extends Gui {
    Minecraft mc = getMinecraft();

    boolean YawC = false;

    /** ArrayList Sorter */
    public static class ModuleComparator implements Comparator<Module> {
        @Override
        public int compare(Module arg0, Module arg1) {
            if(getMinecraft().fontRenderer.getStringWidth(arg0.getName()) > getMinecraft().fontRenderer.getStringWidth(arg1.getName())) {
                return -1;
            }
            if(getMinecraft().fontRenderer.getStringWidth(arg0.getName()) > getMinecraft().fontRenderer.getStringWidth(arg1.getName())) {
                return 1;
            }
            return 0;
        }
    }


    /** renders stuff on screen */
    @SubscribeEvent
    public void renderOverlay(RenderGameOverlayEvent event) {
        Collections.sort(Main.moduleManager.modules, new ModuleComparator());
        ScaledResolution sr = new ScaledResolution(mc);
        FontRenderer fr = mc.fontRenderer;
        boolean abc = false;



        /** Renders The Clinet Name and Version */
        if(event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
            fr.drawStringWithShadow("Yasashii " + "v." + Refrence.VERSION, 2, 1, 0xfffff);
        }


        if(event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
            /** Coords */
                int posX = (int) Math.round(mc.player.posX);
                int posY = (int) Math.round(mc.player.posY);
                int posZ = (int) Math.round(mc.player.posZ);

                if(mc.ingameGUI.getChatGUI().getChatOpen()) {
                    fr.drawStringWithShadow("[XYZ]: ", 2, sr.getScaledHeight() - 42, 0xFF5B5B);
                    fr.drawStringWithShadow(posX + ", " + posY + ", " + posZ, 40, sr.getScaledHeight() -42, 0xFFFFFF);
                } else {
                    fr.drawStringWithShadow("[XYZ]: ", 2, sr.getScaledHeight() - 22, 0xFF5B5B);
                    fr.drawStringWithShadow(posX + ", " + posY + ", " + posZ, 40, sr.getScaledHeight() -22, 0xFFFFFF);
                }


            /** Yaw */
            if(YawC == true) {
                if (mc.player.getRotationYawHead() >= 361 || mc.player.getRotationYawHead() <= -361) {
                    mc.player.setRotationYawHead(0);
                }
                int YawRaw = (int) mc.player.getRotationYawHead();
                int Yaw = YawRaw;

                fr.drawStringWithShadow("Yaw: ", 2, sr.getScaledHeight() - 32, 0xFF5B5B);
                fr.drawStringWithShadow(String.valueOf(Yaw), 25, sr.getScaledHeight() - 32, 0xFFFFFF);
            }


            /** renders FPS */
                 int FPS = Minecraft.getDebugFPS();
                 fr.drawStringWithShadow("[FPS]:", 2, 30, 0xFFAA00);
                 fr.drawStringWithShadow(String.valueOf(FPS), 35, 30, 0xFFFFFF);


            /** renders Memory used */
               final long K = 1024;
               final long M = K * K;
               final long G = M * K;
               final long T = G * K;

               /** calculate byte size to mb */
                long usedMemory = Runtime.getRuntime().freeMemory();
                long totalMemory = Runtime.getRuntime().totalMemory();
                double usedmemory = usedMemory/M;
                fr.drawStringWithShadow("[Memory]:", 2, 60, 0xFFAA00);
                fr.drawStringWithShadow( usedmemory + " / 3000", 55, 60, 0xFFFFFF);
        }


        /** renders Server related stuff */
           if(!mc.isSingleplayer()) {
            /** renders Ping */
            if(event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
                long ping = mc.getCurrentServerData().pingToServer;
                fr.drawStringWithShadow("[Ping]:", 2, 50, 0xFFAA00);
                fr.drawStringWithShadow(String.valueOf(ping), 37, 50, 0xFFFFFF);
            }


            /** renders Server Name and Ip */
            if(event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
                String serverip = mc.getCurrentServerData().serverIP;
                String servername = mc.getCurrentServerData().serverName;
                fr.drawStringWithShadow("ServerName:", sr.getScaledWidth() - (126), 1, 0xFFAA00);
                fr.drawStringWithShadow("ServerIp:", sr.getScaledWidth() - (112), 10, 0xFFAA00);
                fr.drawStringWithShadow(serverip, sr.getScaledWidth() -60, 1, 0xFFFFFF);
                fr.drawStringWithShadow(serverip, sr.getScaledWidth() -60, 10, 0xFFFFFF);
            }


            /** render TPS */
            if(event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
                int Tps = (int) mc.getCurrentServerData().pingToServer;
                int TPS = Math.round(Tps);
                fr.drawStringWithShadow("[TPS]:", 2, 40, 0xFFAA00);
                fr.drawStringWithShadow(String.valueOf(TPS), 35, 40, 0xFFFFFF);
            }


            /** render radar */
            boolean radar = false;
            if(event.getType() == RenderGameOverlayEvent.ElementType.TEXT && radar == true) {
                String players = mc.getCurrentServerData().playerList;
                fr.drawStringWithShadow("Players:", 2, 55, 0xFFAA00);
                fr.drawStringWithShadow(players, 2, 60, 0xFFFFFF);
            }
        }


        /** just some testing stuff */
          if(event.getType() == RenderGameOverlayEvent.ElementType.EXPERIENCE) {

          }


          /** renders arraylist */
          if(event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
              int y = 30;
              final int[] counter = {1};
                for(Module mod : Main.moduleManager.getModuleList()) {
                   if(!mod.getName().equalsIgnoreCase("ChatSuffix Hud ClickGui Gui TabGui") && mod.isToggled()) {
                       String array1 = mod.getName() + " <";
                       fr.drawStringWithShadow(array1, sr.getScaledWidth() - fr.getStringWidth(mod.getName()) - 4, y, rainbow(counter[0] * 300));
                       y += fr.FONT_HEIGHT;
                       counter[0]++;
                }
            }
        }
    }
    /** Rainbow color */
    public static int rainbow(int delay) {
            double rainbowState = Math.ceil(System.currentTimeMillis() + delay) / 20.0;
            rainbowState %= 360;
            return Color.getHSBColor((float) (rainbowState / 360f), 0.5f, 1f).getRGB();
    }
}

package me.terrifictable55.yasashii.module.modules.tabgui;

import me.terrifictable55.yasashii.module.Category;
import me.terrifictable55.yasashii.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;
import java.awt.*;

import static me.terrifictable55.yasashii.Main.moduleManager;

/** warning scuffed code */
public class TabGui extends Gui {
    public String name, description;
    private int key;
    private Category category;
    private boolean toggled;

    /** Render stuff */
    @SubscribeEvent
    public void renderOverlay(RenderGameOverlayEvent event) {
        Minecraft mc = Minecraft.getMinecraft();
        ScaledResolution sr = new ScaledResolution(mc);
        FontRenderer fr = mc.fontRenderer;

        int xModules = 90;
        int yModules = 95;

        /** some booleans for the TabGui */
        boolean combatIsTabed = false;
        boolean movementIsTabed = false;
        boolean renderIsTabed = false;
        boolean clientIsTabed = false;
        boolean exploitIsTabed = false;
        boolean nothing = true;
        /** extended, useless */
        boolean extendedExploit = false;
        boolean extendedCombat = false;
        boolean extendedMovement = false;
        boolean extendedRender = false;
        boolean extendedClient = false;


        /** module names */
        /** Movement */
        String elytrafly = "ElytraFly";
        String sprint = "Sprint";
        /** Render*/
        String esp = "ESP";
        String holeesp = "HoleESP";
        /** Client */
        String invsorter = "InvSorter";
        String chatsuffix = "ChatSuffix";
        String autodupe = "Autodupe";
        String HudSettings = "Hud";
        /** Exploits */
        String portalgodmode = "PortalGodMode";
        String packetfly = "PacketFly";
        String seko = "SeK0";
        /** Combat */
        String crystalaura = "CrystalAura";
        String pistonaura = "PistonAura";
        String offhand = "Offhand";
        String armorbreaker = "ArmorBreaker";
        String bedaura = "BedAura";


        /** Color's */
        int white = 0xFFFFFF;
        //Combat
        int colorCombat = 0xFF0004;
        //Movement
        int colorMovement = 0x19FF00;
        //Render
        int colorRender = 0xF600FF;
        //Client
        int colorClient = 0x00F6FF;
        //Exploit
        int colorExploit = 0x6B0001;


        /** TabGui Name */
        if (event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
            final int[] counter = {1};
            fr.drawStringWithShadow("TabGui", 2, 81, rainbow(counter[0] * 300));
            fr.drawStringWithShadow("_________", 2, 86, 0xffffff);
            counter[0]++;
        }



        /** Select a Category */
        if (event.getType() == RenderGameOverlayEvent.ElementType.TEXT && !extendedRender && !extendedClient && !extendedExploit && !extendedMovement) {
            /** Combat */
            if(extendedCombat) {
                fr.drawStringWithShadow("|> Combat", 2, 100, colorCombat);
                fr.drawStringWithShadow(crystalaura, xModules, yModules, white);
                fr.drawStringWithShadow(pistonaura, xModules, yModules +10, white);
                fr.drawStringWithShadow(offhand, xModules, yModules +20, white);
                fr.drawStringWithShadow(armorbreaker, xModules, yModules +30, white);
                fr.drawStringWithShadow(bedaura, xModules, (yModules +40), white);

                nothing = false;
                combatIsTabed = true;
                extendedCombat = true;
            }else {
                if(extendedCombat) {
                    extendedCombat = false;
                    return;
                }
            }
        }

        /** Movement */
        if (event.getType() == RenderGameOverlayEvent.ElementType.TEXT &&!extendedCombat && !extendedRender && !extendedClient && !extendedExploit) {
            if(extendedMovement) {
                fr.drawStringWithShadow("|> Movement", 2, 110, colorMovement);
                fr.drawStringWithShadow(sprint, xModules, yModules, white);
                fr.drawStringWithShadow(elytrafly, xModules, yModules +10, white);

                movementIsTabed = true;
                extendedMovement = true;
            }else {
                if(extendedMovement) {
                    extendedMovement = false;
                    return;
                }
            }
        }

        /** Render */
        if (event.getType() == RenderGameOverlayEvent.ElementType.TEXT && !extendedClient && !extendedCombat && !extendedExploit && !extendedMovement) {
            if(extendedRender) {
                fr.drawStringWithShadow("|> Render", 2, 120, colorRender);
                fr.drawStringWithShadow(esp, xModules, yModules, white);
                fr.drawStringWithShadow(holeesp, xModules, (yModules + 10), white);

                renderIsTabed = true;
                extendedRender = true;
            } else {
                if(extendedRender) {
                    extendedRender = false;
                    return;
                }
            }
        }

        /** Client */
        if (event.getType() == RenderGameOverlayEvent.ElementType.TEXT && !extendedCombat && !extendedMovement && !extendedRender) {
            if(extendedClient) {
                fr.drawStringWithShadow("|> Client", 2, 130, colorClient);
                fr.drawStringWithShadow(autodupe, xModules, yModules, white);
                fr.drawStringWithShadow(invsorter, xModules, yModules +10, white);
                fr.drawStringWithShadow(chatsuffix, xModules, yModules + 20, white);
                fr.drawStringWithShadow(HudSettings, xModules, yModules + 30, white);

                renderIsTabed = false;
                extendedClient =true;
            } else {
                if(extendedClient) {
                    extendedClient = false;
                    return;
                }
            }
        }

        /** Exploits */
        if (event.getType() == RenderGameOverlayEvent.ElementType.TEXT && !extendedCombat && !extendedClient && !extendedRender && !extendedMovement) {
            if(extendedExploit) {
                fr.drawStringWithShadow("|> Exploit", 2, 140, colorExploit);
                fr.drawStringWithShadow(packetfly, xModules, yModules, white);
                fr.drawStringWithShadow(portalgodmode, xModules, yModules +10, white);
                fr.drawStringWithShadow(seko, xModules, (yModules + 20), white);

                exploitIsTabed = true;
                extendedExploit = true;
            } else {
                if(extendedExploit) {
                    extendedExploit = false;
                    return;
                }
            }
        }
        //if nothing == true;
        if (event.getType() == RenderGameOverlayEvent.ElementType.TEXT && !exploitIsTabed && !clientIsTabed && !combatIsTabed && !renderIsTabed && !movementIsTabed) {
            nothing = true;
            extendedExploit = false;
            return;
        }



        /** Modules Renderer + Color + Tabable */
        if (event.getType() == RenderGameOverlayEvent.ElementType.TEXT && extendedCombat == false) {
            fr.drawStringWithShadow("Combat", 2, 100, white);
        }
        if (event.getType() == RenderGameOverlayEvent.ElementType.TEXT && extendedMovement  == false) {
            fr.drawStringWithShadow("Movement", 2, 110, white);
        }
        if (event.getType() == RenderGameOverlayEvent.ElementType.TEXT && extendedRender  == false) {
            fr.drawStringWithShadow("Render", 2, 120, white);
        }
        if (event.getType() == RenderGameOverlayEvent.ElementType.TEXT && extendedClient  == false) {
            fr.drawStringWithShadow("Client", 2, 130, white);
        }
        if (event.getType() == RenderGameOverlayEvent.ElementType.TEXT && extendedExploit  == false) {
            fr.drawStringWithShadow("Exploit", 2, 140, white);
        }

    }
    /** rainbow color */
    public static int rainbow(int delay) {
        double rainbowState = Math.ceil(System.currentTimeMillis() + delay) / 30.0;
        rainbowState %= 360;
        return Color.getHSBColor((float) (rainbowState / 360f), 0.5f, 1f).getRGB();
    }
    @SubscribeEvent
    public void key(InputEvent.KeyInputEvent e) {
        if(Minecraft.getMinecraft().world == null || Minecraft.getMinecraft().player == null)
            return;
        try {
            if (Keyboard.isCreated()) {
                if (Keyboard.getEventKeyState()) {
                    int keyCode1 = Keyboard.getEventKey();
                    if(keyCode1 <= 0)
                        return;
                    for(Module a : moduleManager.modules) {
                        if(a.getKey() == keyCode1 && keyCode1 > 0) {
                            a.toggle();
                        }
                    }
                }
            }
        }catch(Exception q) {q.printStackTrace(); }
    }
}


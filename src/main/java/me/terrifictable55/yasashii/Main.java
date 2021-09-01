package me.terrifictable55.yasashii;

import me.terrifictable55.yasashii.module.Module;
import me.terrifictable55.yasashii.module.ModuleManager;
import me.terrifictable55.yasashii.module.modules.tabgui.TabGui;
import me.terrifictable55.yasashii.proxy.CommonProxy;
import me.terrifictable55.yasashii.ui.Hud;
import me.terrifictable55.yasashii.util.Refrence;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

@Mod(modid = Refrence.MOD_ID, name = Refrence.NAME, version = Refrence.VERSION)
public class Main {

    /** TerrificTable55's notes:
     * - The modules doesnt work yet, just to remind me that i wana make them sometime so dont expect them to do anything :D - 05.18.2021 0:38am
     */

    Minecraft mc = Minecraft.getMinecraft();
    public static ModuleManager moduleManager;
    public static Hud hud;
    public static TabGui tabgui;

    @Mod.Instance
    public Main instance;

    @SidedProxy(clientSide = Refrence.CLIENT_PROXY_CLASS, serverSide = Refrence.COMMON_PROXY_CLASS)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void PreInit (FMLPreInitializationEvent event) {

    }

    /** to Initalize stuff thats not a module like Gui things */
    @Mod.EventHandler
    public void init (FMLPreInitializationEvent event) {
        /** Initalize not module stuff here */
        MinecraftForge.EVENT_BUS.register(instance);
        MinecraftForge.EVENT_BUS.register(new Hud());
        //MinecraftForge.EVENT_BUS.register(new TabGui());

        /** Initalize not module stuff here */
        moduleManager = new ModuleManager();
        hud = new Hud();
        tabgui = new TabGui();
    }

    @Mod.EventHandler
    public void PostInit (FMLPreInitializationEvent event) {
        Display.setTitle("Yasashii-Client v." + Refrence.VERSION);
    }

    /** keyInputEvent */
    @SubscribeEvent
    public void key(InputEvent.KeyInputEvent e) {
        if(Minecraft.getMinecraft().world == null || Minecraft.getMinecraft().player == null)
            return;
        try {
            if (Keyboard.isCreated()) {
                if (Keyboard.getEventKeyState()) {
                    int keyCode = Keyboard.getEventKey();
                    if(keyCode <= 0)
                        return;
                    for(Module m : moduleManager.modules) {
                        if(m.getKey() == keyCode && keyCode > 0) {
                            m.toggle();
                        }
                    }
                }
            }
        }catch(Exception q) {q.printStackTrace(); }
    }

    /** auth */
    //https://pastebin.com/d4VT2Zxt
}

package me.terrifictable55.yasashii.module;

import me.terrifictable55.yasashii.Main;
import me.terrifictable55.yasashii.module.modules.client.*;
import me.terrifictable55.yasashii.module.modules.exploits.*;
import me.terrifictable55.yasashii.module.modules.movement.*;
import me.terrifictable55.yasashii.module.modules.pvp.*;
import me.terrifictable55.yasashii.module.modules.render.*;
import me.terrifictable55.yasashii.module.modules.tabgui.*;
import java.util.ArrayList;
import java.util.List;

public class ModuleManager {
    public ArrayList<Module> modules;

    /** Initalize modules here*/
    public ModuleManager() {
        (modules = new ArrayList<Module>()).clear();


        /** Client */
        this.modules.add(new AutoDupe());
        this.modules.add(new InventorySorter());
        this.modules.add(new ChatSuffix());
        this.modules.add(new HudSettings());

        /** Movement */
        this.modules.add(new Sprint());
        this.modules.add(new ElytraFly());


        /** Exploits */
        this.modules.add(new PortalGodMode());
        this.modules.add(new PacketFly());
        this.modules.add(new seko());


        /** Combat */
        this.modules.add(new ArmorBreaker());
        this.modules.add(new AutoEz());
        this.modules.add(new BedAura());
        this.modules.add(new CrystalAura());
        this.modules.add(new Offhand());
        this.modules.add(new PistonAura());


        /** Render */
        this.modules.add(new ESP());
        this.modules.add(new HoleESP());
        this.modules.add(new ItemESP());
        this.modules.add(new EntityESP());
        this.modules.add(new ArmorHud());


        /** TabGui */
        //nothing here, YET!
    }

    /** ArrayList or a peace of it */
    public Module getModule(String name) {
        for(Module m : this.modules) {
            if(m.getName().equalsIgnoreCase(name)) {return m;}
        } return null;
    }

    public ArrayList<Module> getModuleList() {return this.modules;}

    public static List<Module> getModulesByCategory(Category c) {
        List<Module> modules = new ArrayList<Module>();

        for(Module m : Main.moduleManager.modules) {
            if(m.getCategory() == c)modules.add(m);
        } return modules;
    }
}

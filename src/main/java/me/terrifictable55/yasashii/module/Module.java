package me.terrifictable55.yasashii.module;


import net.minecraftforge.common.MinecraftForge;

public class Module {

    public String name, description;
    private int key;
    private Category category;
    private boolean toggled;

    public Module(String name, String description, Category category) {
        super();
        this.name = name;
        this.description = description;
        this.key = 0;
        this.category = category;
        this.toggled = false;
    }

    /** description */
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /** Key */
    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    /** Toggled */
    public boolean isToggled() {
        return toggled;
    }

    public void setToggled(boolean toggled) {
        this.toggled = toggled;

        if(this.toggled) {
            this.onEnable();
        }else {
            this.onDisable();
        }
    }

    public void toggle() {
        this.toggled = !this.toggled;

        if(this.toggled) {
            this.onEnable();
        }else {
            this.onDisable();
        }
    }

    /** when mod gets enabled/diabled */
    public void onEnable() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    public void onDisable() {
        MinecraftForge.EVENT_BUS.unregister(this);
    }

    /** Name */
    public String getName() {
        return this.name;
    }

    /** Category */
    public Category getCategory() {
        return this.category;
    }
}

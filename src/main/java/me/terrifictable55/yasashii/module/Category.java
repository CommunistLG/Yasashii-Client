package me.terrifictable55.yasashii.module;

public enum Category {
    PVP("Combat"), EXPLOITS("Exploits"), RENDER("Render"), MOVEMENT("Movement"), CLIENT("Client");

    /** for super(name: "", descroton: "", category.a) */
    public String name;
    public int moduleIndex;

    Category(String name) {
        this.name = name;
    }
}

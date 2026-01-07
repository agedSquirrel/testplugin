package me.squirrly.pluginyay;

import org.bukkit.plugin.java.JavaPlugin;

public final class Pluginyay extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().warning("Hehehe it works :|");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

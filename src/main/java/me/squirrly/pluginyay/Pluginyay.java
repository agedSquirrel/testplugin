package me.squirrly.pluginyay;

import org.bukkit.plugin.java.JavaPlugin;
import me.squirrly.pluginyay.commands.WelcomePlayer;
import me.squirrly.pluginyay.listeners.JoinListener;

public final class Pluginyay extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().warning("Hehehe it works :))");
        getServer().getPluginManager().registerEvents(new JoinListener(), this);

        getCommand("hello").setExecutor(new WelcomePlayer());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

package me.squirrly.pluginyay;

import me.squirrly.pluginyay.commands.GiveRpgItem;
import me.squirrly.pluginyay.listener.PlayerJoinInitListener;
import org.bukkit.plugin.java.JavaPlugin;
import me.squirrly.pluginyay.commands.WelcomePlayer;
import me.squirrly.pluginyay.listener.JoinListener;
import me.squirrly.pluginyay.temporary_data.SessionDataStorage;

public final class Pluginyay extends JavaPlugin {
    private static Pluginyay instance;
    private static SessionDataStorage sessions;

    @Override
    public void onEnable() {
        Pluginyay.instance = this;
        getLogger().warning("Hehehe it works :))");
        getServer().getPluginManager().registerEvents(new JoinListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinInitListener(sessions), this);

        getCommand("hello").setExecutor(new WelcomePlayer());
        getCommand("rpgitems").setExecutor(new GiveRpgItem());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Pluginyay getPlugin() {
        return instance;
    }
}

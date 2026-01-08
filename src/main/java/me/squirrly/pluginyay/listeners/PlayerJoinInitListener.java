
package me.squirrly.pluginyay.listeners;

import me.squirrly.pluginyay.data.PlayerTags;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;


public final class PlayerJoinInitListener implements Listener {
    private final Plugin plugin;
    private final PlayerTags playerTags;

    public PlayerJoinInitListener(Plugin plugin) {
        this.plugin = plugin;
        this.playerTags = new PlayerTags(plugin);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent playerJoin) {
        var player = playerJoin.getPlayer();
        var pdc = player.getPersistentDataContainer();

        // Initialize defaults if not set:
        if (!pdc.has(playerTags.CLASS, PersistentDataType.STRING)) {
            pdc.set(playerTags.CLASS, PersistentDataType.STRING, "CLASSLESS");
        }
        if (!pdc.has(playerTags.LEVEL, PersistentDataType.INTEGER)) {
            pdc.set(playerTags.LEVEL, PersistentDataType.INTEGER, 0);
        }
        if (!pdc.has(playerTags.XP_POINTS, PersistentDataType.INTEGER)) {
            pdc.set(playerTags.XP_POINTS, PersistentDataType.INTEGER, 0);
        }

        // Read and greet:
        String player_class = pdc.get(playerTags.CLASS, PersistentDataType.STRING);
        Integer level = pdc.get(playerTags.LEVEL, PersistentDataType.INTEGER);
        Integer xp = pdc.get(playerTags.XP_POINTS, PersistentDataType.INTEGER);
        String greeting = "Welcome back, " + player_class + " (lvl:" + level + ", xp: " + xp + "/" + "1000" + ")";
        Bukkit.broadcastMessage(greeting);
    }
}

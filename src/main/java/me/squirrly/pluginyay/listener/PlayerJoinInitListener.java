
package me.squirrly.pluginyay.listener;

import me.squirrly.pluginyay.data.PlayerTags;
import me.squirrly.pluginyay.util.LoginMessageRandomizer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.persistence.PersistentDataType;
import me.squirrly.pluginyay.temporary_data.SessionDataStorage;

public final class PlayerJoinInitListener implements Listener {
    private final SessionDataStorage sessions;

    public PlayerJoinInitListener(SessionDataStorage sessions) {
        this.sessions = sessions;
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onJoin(PlayerJoinEvent playerJoin) {
        var player = playerJoin.getPlayer();
        var pdc = player.getPersistentDataContainer();

        // Initialize defaults if not set:
        if (!pdc.has(PlayerTags.CLASS, PersistentDataType.STRING)) {
            pdc.set(PlayerTags.CLASS, PersistentDataType.STRING, "CLASSLESS");
        }
        if (!pdc.has(PlayerTags.LEVEL, PersistentDataType.INTEGER)) {
            pdc.set(PlayerTags.LEVEL, PersistentDataType.INTEGER, 1);
        }
        if (!pdc.has(PlayerTags.XP_POINTS, PersistentDataType.INTEGER)) {
            pdc.set(PlayerTags.XP_POINTS, PersistentDataType.INTEGER, 0);
        }

        sessions.createSessionData(player);

        player.sendMessage(LoginMessageRandomizer.loginMessage(player.getName()));
        player.sendMessage("Class: " + player.getPersistentDataContainer().get(PlayerTags.CLASS, PersistentDataType.STRING));
        player.sendMessage("Level: " + player.getPersistentDataContainer().get(PlayerTags.LEVEL, PersistentDataType.INTEGER));
        player.sendMessage("XP: " + player.getPersistentDataContainer().get(PlayerTags.XP_POINTS, PersistentDataType.INTEGER));
    }
}

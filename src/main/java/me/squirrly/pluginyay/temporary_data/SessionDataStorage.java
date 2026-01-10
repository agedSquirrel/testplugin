
package me.squirrly.pluginyay.temporary_data;

import org.bukkit.entity.Player;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class SessionDataStorage {

    public static class PlayerSessionData {
        private int maxHealthPoints;
        private int speed;


        public PlayerSessionData() {
            this.maxHealthPoints = 1;
            this.speed = 1;
        }

        public int getSpeed() {return this.speed;}
        public int getMaxHealth() {return this.maxHealthPoints;}
    }

    private final Map<UUID, PlayerSessionData> sessions = new ConcurrentHashMap<>();

    /** Create player data on login if missing. */
    public void createSessionData(Player player) {
        sessions.computeIfAbsent(player.getUniqueId(), id -> new PlayerSessionData());
    }

    /** Remove player data on logout. */
    public void removeSessionData(Player player) {
        sessions.remove(player.getUniqueId());
    }

    /** Get the data if present; return null if player not tracked. */
    public PlayerSessionData getSessionData(Player player) {
        return sessions.get(player.getUniqueId());
    }
}

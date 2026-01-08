package me.squirrly.pluginyay.data;

import org.bukkit.NamespacedKey;
import org.bukkit.plugin.Plugin;

/**
 * Centralized player tag keys (Player/Entity PDC).
 */
public final class PlayerTags {
    public final NamespacedKey CLASS;
    public final NamespacedKey LEVEL;
    public final NamespacedKey XP_POINTS;

    public PlayerTags(Plugin plugin) {
        CLASS = new NamespacedKey(plugin, "class");     // STRING
        LEVEL  = new NamespacedKey(plugin, "level");      // STRING
        XP_POINTS = new NamespacedKey(plugin, "xp_points");          // INTEGER
    }
}

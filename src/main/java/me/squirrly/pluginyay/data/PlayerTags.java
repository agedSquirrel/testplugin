package me.squirrly.pluginyay.data;

import me.squirrly.pluginyay.Pluginyay;
import org.bukkit.NamespacedKey;

public final class PlayerTags {
    public static final NamespacedKey CLASS;
    public static final NamespacedKey LEVEL;
    public static final NamespacedKey XP_POINTS;

    static {
        Pluginyay plugin = Pluginyay.getPlugin();
        CLASS = new NamespacedKey(plugin, "class");
        LEVEL  = new NamespacedKey(plugin, "level");
        XP_POINTS = new NamespacedKey(plugin, "xp_points");
    }
}


package me.squirrly.pluginyay.data;

import org.bukkit.NamespacedKey;
import org.bukkit.plugin.Plugin;

/**
 * Centralized item tag keys (PDC keys) – reuse everywhere.
 */
public final class ItemTags {
    public final NamespacedKey CUSTOM_ITEM_ID;
    public final NamespacedKey LEVEL;

    public ItemTags(Plugin plugin) {
        CUSTOM_ITEM_ID = new NamespacedKey(plugin, "custom_item_id");
        LEVEL = new NamespacedKey(plugin, "level");
    }
}

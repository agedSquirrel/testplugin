
package me.squirrly.pluginyay.data;

import me.squirrly.pluginyay.Pluginyay;
import org.bukkit.NamespacedKey;

public final class ArmorTags {
    public static final NamespacedKey MATERIAL;
    public static final NamespacedKey DEFENCE_KEYS;
    public static final NamespacedKey GEM_KEYS;
    public static final NamespacedKey FORGE_TYPE;

    static {
        Pluginyay plugin = Pluginyay.getPlugin();
        MATERIAL = new NamespacedKey(plugin, "material");
        DEFENCE_KEYS = new NamespacedKey(plugin, "defence_keys");
        GEM_KEYS = new NamespacedKey(plugin, "gem_keys");
        FORGE_TYPE = new NamespacedKey(plugin, "forge_type");
    }
}

package me.squirrly.pluginyay.data;

import me.squirrly.pluginyay.Pluginyay;
import org.bukkit.NamespacedKey;

public final class WeaponTags {
    public static final NamespacedKey MATERIAL;
    public static final NamespacedKey TYPE;
    public static final NamespacedKey DAMAGE_KEYS;
    public static final NamespacedKey GEM_KEYS;
    public static final NamespacedKey FORGE_TYPE;

    static {
        Pluginyay plugin = Pluginyay.getPlugin();
        MATERIAL = new NamespacedKey(plugin, "material");
        TYPE = new NamespacedKey(plugin, "type");
        DAMAGE_KEYS = new NamespacedKey(plugin, "damage_keys");
        GEM_KEYS = new NamespacedKey(plugin, "gem_keys");
        FORGE_TYPE = new NamespacedKey(plugin, "weapon_forge_type");
    }
}
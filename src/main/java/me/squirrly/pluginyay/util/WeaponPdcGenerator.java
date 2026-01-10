package me.squirrly.pluginyay.util;

import me.squirrly.pluginyay.data.*;
import me.squirrly.pluginyay.enum_lists.DamageTypes;
import me.squirrly.pluginyay.enum_lists.WeaponForgeTypes;
import me.squirrly.pluginyay.enum_lists.MaterialList;
import me.squirrly.pluginyay.enum_lists.MeleeWeaponTypes;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WeaponPdcGenerator {
    public static void generatePDC(ItemMeta itemmeta, MeleeWeaponTypes type, MaterialList material, Map<DamageTypes, Integer> damageKeys, String gemKeys, WeaponForgeTypes forgeType) {
        PersistentDataContainer pdc = itemmeta.getPersistentDataContainer();
        if (material == null) material = MaterialList.BRONZE;
        if (type == null) type = MeleeWeaponTypes.SWORD;
        if (damageKeys == null) damageKeys = Map.of();
        if (gemKeys == null) gemKeys = "";
        if (forgeType == null) forgeType = WeaponForgeTypes.BASIC;

        List<String> damageKeyList = new ArrayList<String>();
        for (var entry : damageKeys.entrySet()) {
            damageKeyList.add(entry.getKey().serialize(entry.getValue()));
        }

        pdc.set(WeaponTags.TYPE, PersistentDataType.STRING, type.name());
        pdc.set(WeaponTags.MATERIAL, PersistentDataType.STRING, material.name());
        pdc.set(WeaponTags.DAMAGE_KEYS, PersistentDataType.LIST.strings(), damageKeyList);
        pdc.set(WeaponTags.GEM_KEYS, PersistentDataType.STRING, gemKeys);
        pdc.set(WeaponTags.FORGE_TYPE, PersistentDataType.STRING, forgeType.name());
    }
}
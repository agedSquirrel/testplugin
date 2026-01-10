package me.squirrly.pluginyay.enum_lists;

import java.util.HashMap;
import java.util.Map;

public enum DamageTypes {
    PHYSICAL,
    MAGIC,
    FIRE;

    public String serialize(int value) {
        return this.toString() + ":" + value;
    }

    public static Map<DamageTypes, Integer> deserialize(String serializedValue) {
        Map<DamageTypes, Integer> returnMap = new HashMap<>();
        String[] splitValue = serializedValue.split(":");
        if (splitValue.length != 2) {
            return returnMap;
        }

        DamageTypes damageType;
        int value;

        try {
            value = Integer.parseInt(splitValue[1]);
            damageType = DamageTypes.valueOf(splitValue[0]);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return returnMap;
        }

        returnMap.put(damageType, value);
        return returnMap;
    }
}
package me.squirrly.pluginyay.util;

import java.util.*;

public class CommandCompleter {
    public List<String> completeLiteral(String partial, String literal) {
        String p = (partial == null) ? "" : partial.toLowerCase(Locale.ROOT);
        return literal.toLowerCase(Locale.ROOT).startsWith(p) ? List.of(literal) : List.of();
    }

    public List<String> completeChoice(String partial, List<String> choices) {
        String p = (partial == null) ? "" : partial.toLowerCase(Locale.ROOT);
        List<String> out = new ArrayList<>();
        for (String c : choices) {
            if (c.toLowerCase(Locale.ROOT).startsWith(p)) out.add(c);
        }
        return out;
    }

}

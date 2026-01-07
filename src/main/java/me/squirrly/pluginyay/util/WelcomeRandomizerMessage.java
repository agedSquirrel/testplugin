package me.squirrly.pluginyay.util;

import java.lang.Math;

public final class WelcomeRandomizerMessage {
    public static String welcomeMessage(String name) {
        int greetOption = (int)(Math.random()*3)+1;
        if (greetOption == 1) {
            return "Hello " + name + "!";
        } else if (greetOption == 2) {
            return "Nice to see you " + name + ".";
        } else {
            return "Welcome back " + name + ".";
        }
    }
}

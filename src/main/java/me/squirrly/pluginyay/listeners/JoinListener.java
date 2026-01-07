package me.squirrly.pluginyay.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import me.squirrly.pluginyay.util.WelcomeRandomizerMessage;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        var player = event.getPlayer();
        player.sendMessage(WelcomeRandomizerMessage.welcomeMessage(player.getName()));
    }
}
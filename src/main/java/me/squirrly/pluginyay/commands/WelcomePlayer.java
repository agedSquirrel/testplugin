package me.squirrly.pluginyay.commands;

import me.squirrly.pluginyay.util.WelcomeRandomizerMessage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;


public class WelcomePlayer implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String who = sender.getName();
        String sayHi = WelcomeRandomizerMessage.welcomeMessage(who);

        sender.sendMessage(sayHi);
        return true;
    }
}

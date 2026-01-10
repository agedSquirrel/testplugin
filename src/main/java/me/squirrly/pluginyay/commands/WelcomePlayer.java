package me.squirrly.pluginyay.commands;

import me.squirrly.pluginyay.util.LoginMessageRandomizer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;


public class WelcomePlayer implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage(LoginMessageRandomizer.loginMessage(sender.getName()));

        return true;
    }
}

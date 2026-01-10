
package me.squirrly.pluginyay.commands;

import me.squirrly.pluginyay.data.*;
import me.squirrly.pluginyay.enum_lists.DamageTypes;
import me.squirrly.pluginyay.enum_lists.WeaponForgeTypes;
import me.squirrly.pluginyay.enum_lists.MaterialList;
import me.squirrly.pluginyay.enum_lists.MeleeWeaponTypes;
import me.squirrly.pluginyay.util.WeaponPdcGenerator;
import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.*;
import java.util.*;
import me.squirrly.pluginyay.util.CommandCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class GiveRpgItem implements CommandExecutor, TabCompleter {

    private CommandCompleter completeCommand = new CommandCompleter();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Only players can use this very cool command");
            return true;
        }

        if (args.length < 1) {
            sender.sendMessage(ChatColor.RED + "Enter a weapon type");
            return true;
        }

        if (args.length < 2) {
            sender.sendMessage(ChatColor.RED + "Enter a weapon material");
            return true;
        }

        ItemStack item = new ItemStack(Material.IRON_SWORD);
        ItemMeta itemmeta = item.getItemMeta();


        Map<DamageTypes, Integer> damageKeys = new HashMap<>();
        damageKeys.put(DamageTypes.PHYSICAL, 10);


        WeaponPdcGenerator.generatePDC(itemmeta, MeleeWeaponTypes.valueOf(args[0].toUpperCase()), MaterialList.valueOf(args[1].toUpperCase()), damageKeys, "Empty", WeaponForgeTypes.SHARP);


        itemmeta.customName(Component.text(  itemmeta.getPersistentDataContainer().get(WeaponTags.FORGE_TYPE, PersistentDataType.STRING) + " "
                + itemmeta.getPersistentDataContainer().get(WeaponTags.MATERIAL, PersistentDataType.STRING) + " "
                + itemmeta.getPersistentDataContainer().get(WeaponTags.TYPE, PersistentDataType.STRING)));
        item.setItemMeta(itemmeta);


        player.getInventory().addItem(item);
        sender.sendMessage(ChatColor.AQUA + "Item given");

        return true;
    }

    //Tab Completion

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 0) {
            return List.of("giverpgitem");
        }

        if (args.length == 1) {
            List<String> completitions = new ArrayList<>();
            for (MeleeWeaponTypes name : MeleeWeaponTypes.values()) {
                completitions.add(name.name());
            }

            return completeCommand.completeChoice(args[0], completitions);
        }

        if (args.length == 2) {
            List<String> completitions = new ArrayList<>();
            for (MaterialList name : MaterialList.values()) {
                completitions.add(name.name());
            }

            return completeCommand.completeChoice(args[1], completitions);
        }


        return List.of();
    }

    private void usage(CommandSender sender, String label) {
        sender.sendMessage(ChatColor.AQUA + "Flow Command Tree:");
        sender.sendMessage(ChatColor.GRAY + "/" + label + " flow branch <1|2> name <value> mode <1|2>");
        sender.sendMessage(ChatColor.DARK_GRAY + "Example: /" + label + " flow branch 1 name Alpha mode 2");
    }
}

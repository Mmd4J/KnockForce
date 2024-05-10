package me.gameisntover.knockforce.command.impl.arena;

import me.gameisntover.knockforce.command.SubCommand;
import me.gameisntover.knockforce.entity.KPlayer;
import me.gameisntover.knockforce.item.items.RegionWand;
import org.bukkit.command.CommandSender;

import java.util.List;

public class RegionWandCommand implements SubCommand {
    @Override
    public boolean perform(KPlayer player, String name, String[] args) {
        player.giveItem(new RegionWand());
        player.sendMessage("Here's the magical wand!");
        return true;
    }

    @Override
    public boolean perform(CommandSender sender, String name, String[] args) {
        sender.sendMessage("No sense of giving console a wand...");
        return false;
    }

    @Override
    public List<String> tabComplete(CommandSender sender, String name, String[] args) {
        return SubCommand.super.tabComplete(sender, name, args);
    }

    @Override
    public String getName() {
        return "regionwand";
    }

    @Override
    public String getDescription() {
        return "Gives you a region wand";
    }

    @Override
    public Category getCategory() {
        return Category.UTILS;
    }
}

package me.gameisntover.knockforce.command.impl.arena;

import me.gameisntover.knockforce.command.SubCommand;
import me.gameisntover.knockforce.entity.KPlayer;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class ArenaCreateCommand implements SubCommand {
    @Override
    public boolean perform(KPlayer player, String c, String[] args) {
        if (args.length < 2) return false;
        StringBuilder name = new StringBuilder(args[1]);
        Iterator<String> it = Arrays.stream(args).skip(2).iterator();
        while (it.hasNext()) {
            name.append(" ").append(it.next());
        }
        List<Location> loc = Arrays.stream(player.getStoredPositions()).filter(Objects::nonNull).collect(Collectors.toList());
        if (loc.size() != 2) return false;


        player.sendPluginMessage("Arena was being created successfully!");
        return false;
    }

    @Override
    public boolean perform(CommandSender sender, String name, String[] args) {
        sender.sendMessage("That's a dumb idea tbh");
        return false;
    }

    @Override
    public String getName() {
        return "createarena";
    }

    @Override
    public String getDescription() {
        return "Creates the arena";
    }

    @Override
    public Category getCategory() {
        return Category.ARENA;
    }
}

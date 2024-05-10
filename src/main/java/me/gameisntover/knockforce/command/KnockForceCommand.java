package me.gameisntover.knockforce.command;

import me.gameisntover.knockforce.command.impl.arena.RegionWandCommand;
import me.gameisntover.knockforce.utils.CastUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.HashMap;
import java.util.Map;

public class KnockForceCommand extends Command {
    public Map<String, SubCommand> map = new HashMap<>();

    public KnockForceCommand() {
        super("knockforce");
        this.registerCommand(new RegionWandCommand());
    }

    @Override
    public String getPermission() {
        return "knockforce.*";
    }

    @Override
    public boolean execute(CommandSender sender, String name, String[] args) {
        if (args.length == 0) return false;
        if (map.containsKey(args[0].toLowerCase()))
            return map.get(args[0]).perform(CastUtils.cast(sender), name, args);
        return false;
    }


    public void registerCommand(SubCommand command) {
        map.put(command.getName(), command);
    }
}

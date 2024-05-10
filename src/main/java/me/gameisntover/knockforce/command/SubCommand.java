package me.gameisntover.knockforce.command;

import me.gameisntover.knockforce.entity.KPlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;

import java.util.List;

public interface SubCommand {
    boolean perform(KPlayer player, String name, String[] args);

    boolean perform(CommandSender sender, String name, String[] args);

    default List<String> tabComplete(CommandSender sender, String name, String[] args) {
        return null;
    }

    String getName();

    String getDescription();

    Category getCategory();

    default PermissionDefault getDefaultPermission() {
        return PermissionDefault.OP;
    }

    default Permission getPermission() {
        return new Permission("knockforce." + getCategory() + "." + getName());
    }

    public static enum ExecutionError {
        INVALID_ARGS,
        NOT_ENOUGH_ARGS,
        CUSTOM,
        PERMISSION_ERROR
    }

    public static enum Category {
        IN_GAME, ARENA, GAME, MODERATION, UTILS
    }
}

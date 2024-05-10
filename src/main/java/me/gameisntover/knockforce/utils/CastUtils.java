package me.gameisntover.knockforce.utils;

import lombok.experimental.UtilityClass;
import me.gameisntover.knockforce.entity.KPlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@UtilityClass
public class CastUtils {
    private static final Map<UUID, KPlayer> map = new HashMap<>();

    public KPlayer cast(CommandSender sender) {
        if (sender instanceof Player) {
            return cast((Player) sender);
        }
        return null;
    }

    public KPlayer cast(Player p) {
        if (!map.containsKey(p.getUniqueId()))
            map.put(p.getUniqueId(), new KPlayer(p));
        return map.get(p.getUniqueId());
    }
}

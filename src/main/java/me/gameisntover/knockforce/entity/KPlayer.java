package me.gameisntover.knockforce.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import me.gameisntover.knockforce.KnockForce;
import me.gameisntover.knockforce.database.DataTag;
import me.gameisntover.knockforce.database.Database;
import me.gameisntover.knockforce.database.DatabaseObject;
import me.gameisntover.knockforce.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.UUID;

@Getter
@Setter
public class KPlayer implements DatabaseObject {
    private Location posA;
    private Location posB;

    @DataTag(primaryKey = true)
    private final UUID uniqueId;
    @DataTag
    private int kills;
    @DataTag
    private int deaths;

    private final KnockForce plugin = KnockForce.getInstance();

    @Getter(AccessLevel.NONE)
    private Database database = plugin.getDatabase();

    public KPlayer(UUID uniqueId) {
        this.uniqueId = uniqueId;
        database.insertData(this);
        database.selectData(this);
    }

    public static KPlayer of(Player player) {
        return null;
    }

    public static KPlayer of(UUID id) {
        return null;
    }

    public Player player() {
        return Bukkit.getPlayer(uniqueId);
    }

    public void sendMessage(String msg) {
        player().sendMessage(ChatUtils.color(msg));
    }

    public void sendPluginMessage(String msg) {
        String prefix = plugin.getMessages().getPrefix();
        player().sendMessage(prefix + msg);
    }
}

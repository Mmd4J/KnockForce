package me.gameisntover.knockforce.entity;

import com.cryptomorin.xseries.XItemStack;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import me.gameisntover.knockforce.KnockForce;
import me.gameisntover.knockforce.database.DataTag;
import me.gameisntover.knockforce.database.Database;
import me.gameisntover.knockforce.database.DatabaseObject;
import me.gameisntover.knockforce.item.items.RegionWand;
import me.gameisntover.knockforce.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

@Getter
@Setter
public class KPlayer implements DatabaseObject {
    private Location[] storedPositions = new Location[2];

    @DataTag(primaryKey = true)
    private final UUID uniqueId;
    @DataTag
    private int kills;
    @DataTag
    private int deaths;

    private final KnockForce plugin = KnockForce.getInstance();

    @Getter(AccessLevel.NONE)
    private Database database = plugin.getDb();

    public Player player;

    public KPlayer(Player player) {
        this.player = player;
        this.uniqueId = player.getUniqueId();
        database.insertData(this);
        database.selectData(this);
    }

    public void sendMessage(String msg) {
        player.sendMessage(ChatUtils.color(msg));
    }

    public void sendPluginMessage(String msg) {
        String prefix = plugin.getMessages().getPrefix();
        player.sendMessage(prefix + msg);
    }

    public void giveItem(ItemStack item) {
        player.getInventory().addItem(new RegionWand());
    }

    public Location getTheFirstPosition() {
        return storedPositions[0];
    }

    public Location getTheSecondPosition() {
        return storedPositions[1];
    }
}

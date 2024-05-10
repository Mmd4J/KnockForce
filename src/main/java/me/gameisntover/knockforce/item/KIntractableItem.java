package me.gameisntover.knockforce.item;

import com.cryptomorin.xseries.XMaterial;
import me.gameisntover.knockforce.entity.KPlayer;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.meta.ItemMeta;

public class KIntractableItem extends KItem {
    public KIntractableItem(XMaterial type, String name) {
        super(type, name);
    }

    public boolean onInteractCall(KPlayer player, Action action, Block block, BlockFace face) {
        return false;
    }
}

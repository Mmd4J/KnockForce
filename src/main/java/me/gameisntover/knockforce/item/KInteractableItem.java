package me.gameisntover.knockforce.item;

import com.cryptomorin.xseries.XMaterial;
import me.gameisntover.knockforce.entity.KPlayer;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.block.Action;

public class KInteractableItem extends KItem {
    public KInteractableItem(XMaterial type, String name) {
        super(type, name);
    }

    public boolean onInteractCall(KPlayer player, Action action, Block block, BlockFace face) {
        return false;
    }
}

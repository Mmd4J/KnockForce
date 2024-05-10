package me.gameisntover.knockforce.item.items;

import com.cryptomorin.xseries.XEnchantment;
import com.cryptomorin.xseries.XMaterial;
import me.gameisntover.knockforce.KnockForce;
import me.gameisntover.knockforce.entity.KPlayer;
import me.gameisntover.knockforce.item.KIntractableItem;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemFlag;

public class RegionWand extends KIntractableItem {
    private KnockForce plugin = KnockForce.getInstance();

    public RegionWand() {
        super(XMaterial.BLAZE_ROD, "&bWand");
        addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);
        addEnchantment(XEnchantment.DURABILITY, 1);

    }

    @Override
    public boolean onInteractCall(KPlayer player, Action action, Block block, BlockFace face) {
        switch (action) {
            case LEFT_CLICK_BLOCK:
                player.setPosA(block.getLocation());
                player.sendPluginMessage(String.format("Position 1 was selected at %s , %s , %s", block.getX(), block.getY(), block.getZ()));
                break;
            case RIGHT_CLICK_BLOCK:
                player.setPosB(block.getLocation());
                player.sendPluginMessage(String.format("Position 2 was selected at %s , %s , %s", block.getX(), block.getY(), block.getZ()));
            default:
                return false;
        }
        return true;
    }
}

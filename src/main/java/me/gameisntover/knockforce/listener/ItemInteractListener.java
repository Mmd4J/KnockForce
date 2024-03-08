package me.gameisntover.knockforce.listener;

import me.gameisntover.knockforce.entity.KPlayer;
import me.gameisntover.knockforce.item.KInteractableItem;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;


public class ItemInteractListener implements Listener {
    @EventHandler
    public void onItemInteractEvent(PlayerInteractEvent e) {
        if (e.getItem() instanceof KInteractableItem) {
            KInteractableItem item = (KInteractableItem) e.getItem();
            e.setCancelled(item.onInteractCall(KPlayer.of(e.getPlayer()), e.getAction(), e.getClickedBlock(), e.getBlockFace()));
        }
            e.getAction().equals(Action.RIGHT_CLICK_BLOCK)

    }

}

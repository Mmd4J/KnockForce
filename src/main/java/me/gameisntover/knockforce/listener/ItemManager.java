package me.gameisntover.knockforce.listener;

import me.gameisntover.knockforce.item.KIntractableItem;
import me.gameisntover.knockforce.utils.CastUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class ItemManager implements Listener {
    private final List<KIntractableItem> items = new ArrayList<>();

    @EventHandler
    public void onItemInteractEvent(PlayerInteractEvent e) {
        Optional<KIntractableItem> item = items.stream().filter(i -> i.isSimilar(e.getItem())).findFirst();
        item.ifPresent(kIntractableItem ->
                e.setCancelled(
                        kIntractableItem.onInteractCall(
                                CastUtils.cast(e.getPlayer()), e.getAction(),
                                e.getClickedBlock(), e.getBlockFace())));
    }

    public void registerItem(KIntractableItem item) {
        this.items.add(item);
    }
}

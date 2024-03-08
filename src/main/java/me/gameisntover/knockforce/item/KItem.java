package me.gameisntover.knockforce.item;

import com.cryptomorin.xseries.XEnchantment;
import com.cryptomorin.xseries.XMaterial;
import me.gameisntover.knockforce.utils.ChatUtils;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class KItem extends ItemStack {
    public String getName() {
        return getItemMeta().getDisplayName();
    }

    public void setName(String s) {
        ItemMeta meta = getItemMeta();
        meta.setDisplayName(ChatUtils.color(s));
        setItemMeta(meta);
    }

    public void setType(XMaterial type) {
        setType(type.parseMaterial());
        setData(type.parseItem().getData());
    }

    public KItem(XMaterial type) {
        setType(type);
    }

    public KItem(XMaterial type, String name) {
        setType(type);
        setName(name);
    }

    public void addItemFlags(ItemFlag... flags) {
        ItemMeta meta = getItemMeta();
        meta.addItemFlags(flags);
        setItemMeta(meta);
    }

    public void addEnchantment(XEnchantment ench, int level) {
        ItemMeta meta = getItemMeta();
        meta.addEnchant(ench.getEnchant(), level, true);
        setItemMeta(meta);
    }


}

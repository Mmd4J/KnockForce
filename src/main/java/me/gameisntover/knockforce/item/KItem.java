package me.gameisntover.knockforce.item;

import com.cryptomorin.xseries.XEnchantment;
import com.cryptomorin.xseries.XMaterial;
import me.gameisntover.knockforce.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;

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
        this.setType(type.parseMaterial());
        this.setData(type.parseItem().getData());
    }

    public KItem(XMaterial type) {
        setType(type);
    }

    public KItem(XMaterial type, String name) {
        super(type.parseMaterial(), 1);
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

    @Override
    public boolean isSimilar(ItemStack stack) {
        if (stack == null) {
            return false;
        } else if (stack == this) {
            return true;
        } else {
            return this.getType() == stack.getType() && this.hasItemMeta() == stack.hasItemMeta() && (!this.hasItemMeta() || Bukkit.getItemFactory().equals(this.getItemMeta(), stack.getItemMeta()));
        }
    }
}

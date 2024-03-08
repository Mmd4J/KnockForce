package me.gameisntover.knockforce.utils;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;

public class ChatUtils {
    public static String color(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public static BaseComponent[] text(String message){
        return TextComponent.fromLegacyText(color(message));
    }
}

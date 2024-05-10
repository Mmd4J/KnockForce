package me.gameisntover.knockforce.entity;

import org.bukkit.Location;

import java.util.UUID;

public interface KEntity {
    String getName();

    UUID getUniqueId();

    Location getLocation();


}

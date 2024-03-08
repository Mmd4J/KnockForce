package me.gameisntover.knockforce.configuration;

import lombok.Getter;
import lombok.SneakyThrows;
import me.gameisntover.knockforce.KnockForce;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.InvalidConfigurationException;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

public class YamlConfiguration extends org.bukkit.configuration.file.YamlConfiguration {
    private final KnockForce plugin = KnockForce.getInstance();
    @Getter
    private final File file;

    public YamlConfiguration(String name) {
        file = new File(plugin.getDataFolder(), name);
        if (!file.exists()) {
            KnockForce.getInstance().saveResource(name, true);
            try {
                load(file);
            } catch (IOException | InvalidConfigurationException e) {
                e.printStackTrace();
            }
        }
    }

    public Location getLocation(String key) {
        double x = getDouble(String.format("%s.x", key));
        double y = getDouble(String.format("%s.y", key));
        double z = getDouble(String.format("%s.z", key));
        float yaw = getInt(String.format("%s.yaw", key));
        World world = getWorld(String.format("%s.world", key));
        float pitch = getInt(String.format("%s.pitch", key));
        return new Location(world, x, y, z, yaw, pitch);
    }


    public World getWorld(String key) {
        return Bukkit.getWorld(getString(key));
    }

    public void reload() {
        try {
            load(getFile());
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }
}

package me.gameisntover.knockforce.utils;

import lombok.experimental.UtilityClass;
import org.bukkit.Location;

@UtilityClass
public class MathUtils {
    public int[] calculateMaxCords(Location a, Location b) {
        int maxX = Math.max(a.getBlockX(), b.getBlockX());
        int maxY = Math.max(a.getBlockY(), b.getBlockY());
        int maxZ = Math.max(a.getBlockZ(), b.getBlockZ());
        int[] max = new int[3];
        max[0] = maxX == a.getBlockX() ? 0 : 1;
        max[1] = maxY == a.getBlockY() ? 0 : 1;
        max[2] = maxZ == a.getBlockZ() ? 0 : 1;
        return max;
    }
}

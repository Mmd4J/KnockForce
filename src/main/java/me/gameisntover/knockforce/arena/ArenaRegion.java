package me.gameisntover.knockforce.arena;

import com.cryptomorin.xseries.XMaterial;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javafx.geometry.BoundingBox;
import me.gameisntover.knockforce.KnockForce;
import me.gameisntover.knockforce.utils.MathUtils;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class ArenaRegion {
    @JsonIgnore
    public KnockForce plugin = KnockForce.getInstance();
    public Location[] borders = new Location[2];

    protected ArenaRegion(Location[] borders) {
        this.borders = borders;
    }

    public ArenaRegion() {

    }

    public void reset(Map<Location, XMaterial> map) {
        plugin.executorService.submit(() -> {
            map.forEach((location, mat) -> {
                location.getWorld().getBlockAt(location).setType(mat.parseMaterial());
                location.getWorld().getBlockAt(location).setData(mat.getData());
            });
        });
    }

    public List<Location> calculateLocations() {
        List<Location> locs = new ArrayList<>();
        if ((borders[0] == null || borders[1] == null)
                || borders[0].getWorld().equals(borders[1].getWorld()))
            return locs;
        plugin.executorService.submit(() -> {
            int[] maxes = MathUtils.calculateMaxCords(borders[0], borders[1]);
            Location maxX = borders[maxes[0]];
            Location maxY = borders[maxes[1]];
            Location maxZ = borders[maxes[2]];
            Location minX = borders[Math.abs(maxes[0] - 1)];
            Location minY = borders[Math.abs(maxes[1] - 1)];
            Location minZ = borders[Math.abs(maxes[2] - 1)];
            int distX = maxX.getBlockX() - minX.getBlockX();
            int distY = maxY.getBlockY() - minY.getBlockY();
            int distZ = maxZ.getBlockZ() - minZ.getBlockZ();
            for (int x = 0; x < distX; x++) {
                for (int y = 0; y < distY; y++) {
                    for (int z = 0; z < distZ; z++) {
                        locs.add(new Location(maxX.getWorld(),
                                minX.getBlockX() + x,
                                minY.getBlockY() + y,
                                minZ.getBlockZ() + z));
                    }
                }
            }
        });
        return locs;
    }
}

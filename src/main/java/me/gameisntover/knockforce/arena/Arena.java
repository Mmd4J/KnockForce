package me.gameisntover.knockforce.arena;

import com.cryptomorin.xseries.XBlock;
import com.cryptomorin.xseries.XMaterial;
import com.fasterxml.jackson.annotation.JsonIgnore;
import me.gameisntover.knockforce.KnockForce;
import org.bukkit.Location;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Arena {
    public String name;
    public Map<Location, XMaterial> blocks = new HashMap<>();
    public ArenaRegion region;

    @JsonIgnore
    private KnockForce plugin = KnockForce.getInstance();

    public Arena() {

    }

    public Arena(String name, Location[] borders) {
        this.name = name;
        this.region = new ArenaRegion(borders);
        region.calculateLocations().forEach(l -> {
            blocks.put(l, XMaterial.matchXMaterial(l.getBlock().getType()));
        });
    }

}

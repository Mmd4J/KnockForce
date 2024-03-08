package me.gameisntover.knockforce;

import lombok.var;
import me.gameisntover.knockforce.entity.KPlayer;
import org.junit.Test;

import java.util.Map;
import java.util.UUID;

public class TestFunctions {
    @Test
    public void testDatabaseObject() {
        KPlayer player = new KPlayer(UUID.randomUUID());
        var map = player.getMap();
        for (String key : player.getMap().keySet()) {
            System.out.println(key + ": " + map.get(key).getValue());
        }
    }
}

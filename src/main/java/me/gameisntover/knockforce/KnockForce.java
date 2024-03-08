package me.gameisntover.knockforce;

import com.samjakob.spigui.SpiGUI;
import lombok.Getter;
import me.gameisntover.knockforce.configuration.files.ConfigYaml;
import me.gameisntover.knockforce.configuration.files.MessagesYaml;
import me.gameisntover.knockforce.database.Database;
import org.bukkit.plugin.java.JavaPlugin;
import party.iroiro.luajava.lua54.Lua54;

@Getter
public final class KnockForce extends JavaPlugin {
    @Getter
    private static KnockForce instance;
    private Database database;
    private SpiGUI guiManager;
    private Lua54 lua;
    private ConfigYaml config;
    private MessagesYaml messages;

    @Override
    public void onEnable() {
        instance = this;
        guiManager = new SpiGUI(this);
        getLogger().info("KnockForce is now loading...");
        this.selectDatabase();
        getLogger().info(String.format("Database was loaded! current database is %s", database.getName()));
        this.config = new ConfigYaml();
        this.messages = new MessagesYaml();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void selectDatabase() {

    }

}

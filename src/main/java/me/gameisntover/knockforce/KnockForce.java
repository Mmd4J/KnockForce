package me.gameisntover.knockforce;

import com.samjakob.spigui.SpiGUI;
import lombok.Getter;
import lombok.SneakyThrows;
import me.gameisntover.knockforce.command.KnockForceCommand;
import me.gameisntover.knockforce.configuration.files.ConfigYaml;
import me.gameisntover.knockforce.configuration.files.MessagesYaml;
import me.gameisntover.knockforce.database.Database;
import me.gameisntover.knockforce.database.DatabaseObject;
import me.gameisntover.knockforce.item.items.RegionWand;
import me.gameisntover.knockforce.listener.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.command.SimpleCommandMap;
import org.bukkit.plugin.SimplePluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import party.iroiro.luajava.lua54.Lua54;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Getter
public final class KnockForce extends JavaPlugin {
    @Getter
    private static KnockForce instance;
    private Database db;
    private SpiGUI guiManager;
    private Lua54 lua;
    private ConfigYaml config;
    private MessagesYaml messages;
    private ItemManager itemManager;
    public ExecutorService executorService;

    @Override
    public void onEnable() {
        instance = this;
        guiManager = new SpiGUI(this);
        this.itemManager = new ItemManager();
        getLogger().info("KnockForce is now loading...");
        this.selectDatabase();
        this.itemManager.registerItem(new RegionWand());
        this.executorService = Executors.newSingleThreadExecutor();
        db = new Database() {
            @Override
            public void insertData(DatabaseObject obj) {

            }

            @Override
            public void selectData(DatabaseObject obj, Map.Entry... primaryArgs) {

            }

            @Override
            public void updateData(DatabaseObject obj) {

            }

            @Override
            public String getName() {
                return "MySQL";
            }
        };
        this.registerCommand();
        getLogger().info(String.format("Database was loaded! current database is %s", db.getName()));
        this.config = new ConfigYaml();
        this.messages = new MessagesYaml();
        this.registerListener();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void registerListener() {
        Bukkit.getPluginManager().registerEvents(itemManager, this);
    }

    public void selectDatabase() {

    }

    @SneakyThrows
    public void registerCommand() {
        Field f = SimplePluginManager.class.getDeclaredField("commandMap");
        f.setAccessible(true);
        SimpleCommandMap commandMap = (SimpleCommandMap) f.get(Bukkit.getPluginManager());
        commandMap.register("knockforce", new KnockForceCommand());
    }
}

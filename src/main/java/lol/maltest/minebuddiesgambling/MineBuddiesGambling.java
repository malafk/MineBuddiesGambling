package lol.maltest.minebuddiesgambling;

import lol.maltest.minebuddiesgambling.impl.ActiveGameObject;
import lol.maltest.minebuddiesgambling.util.ConfigUtil;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;

public final class MineBuddiesGambling extends JavaPlugin {

    public ArrayList<ActiveGameObject> activeGameObjects = new ArrayList<>();

    public ConfigUtil configUtil;

    @Override
    public void onEnable() {
        FileConfiguration config = this.getConfig();
        config.options().copyDefaults(true);
        saveDefaultConfig();

        this.configUtil = configUtil;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

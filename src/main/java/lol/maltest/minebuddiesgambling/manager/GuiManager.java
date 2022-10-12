package lol.maltest.minebuddiesgambling.manager;

import lol.maltest.minebuddiesgambling.MineBuddiesGambling;
import lol.maltest.minebuddiesgambling.util.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

public class GuiManager {

    private MineBuddiesGambling plugin;

    public GuiManager(MineBuddiesGambling plugin) {
        this.plugin = plugin;
    }

    public void openMinesGui() {
        Inventory inventory = Bukkit.createInventory(null, 27, plugin.configUtil.getMineTitle());
    }
}

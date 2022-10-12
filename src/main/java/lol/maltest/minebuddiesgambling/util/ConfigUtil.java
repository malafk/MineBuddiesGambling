package lol.maltest.minebuddiesgambling.util;

import lol.maltest.minebuddiesgambling.MineBuddiesGambling;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class ConfigUtil {

    public MineBuddiesGambling plugin;

    public ConfigUtil(MineBuddiesGambling plugin) {
        this.plugin = plugin;
    }

    public String getMineTitle() {
        return get("games.mines.title");
    }

    public ItemStack getAddMoneyButton() {
        return new ItemUtil(Material.GREEN_DYE).setDisplayName(get("buttons.add.title")).setLore(getList("buttons.add.lore")).build();
    }

    public ItemStack getRemoveMoneyButton() {
        return new ItemUtil(Material.RED_DYE).setDisplayName(get("buttons.remove.title")).setLore(getList("buttons.remove.lore")).build();
    }


    private String get(String path) {
        return ChatUtil.color(plugin.getConfig().getString(path, path + " not found."));
    }

    private ArrayList<String> getList(String path) {
        ArrayList<String> colouredList = new ArrayList<>();
        for(String string : plugin.getConfig().getStringList(path)) {
            colouredList.add(ChatUtil.color(string));
        }
        return colouredList;
    }

}

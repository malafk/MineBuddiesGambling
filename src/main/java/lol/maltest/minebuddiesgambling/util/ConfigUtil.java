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

    public ItemStack getMinesButton() {
        return new ItemUtil(getMaterial("games.mines.buttons.minesonboard.type")).setDisplayName(get("games.mines.buttons.minesonboard.title")).setLore(getList("games.mines.buttons.minesonboard.lore")).build();
    }

    public ItemStack getTotalBet(String bet) {
        return new ItemUtil(Material.LIGHT_BLUE_DYE).setDisplayName(get("buttons.total.title")).setLore(replaceInList(getList("buttons.total.lore"), "%bet%", bet)).build();
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

    private ArrayList<String> replaceInList(ArrayList<String> list, String replace, String to) {
        ArrayList<String> newList = new ArrayList<>();
        for(String s : list) {
            newList.add(s.replace(replace, to));
        }
        return newList;
    }

    private Material getMaterial(String path) {
        return Material.valueOf(plugin.getConfig().getString(path));
    }

}

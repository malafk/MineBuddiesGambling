package lol.maltest.minebuddiesgambling.util;

import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.Collections;

public class ItemUtil {

    private ItemStack stack;

    public ItemUtil(Material mat) {
        stack = new ItemStack(mat);
    }

    public ItemUtil(Material mat, short sh) {
        stack = new ItemStack(mat, 1, sh);
    }

    public ItemMeta getItemMeta() {
        return stack.getItemMeta();
    }

    public ItemUtil setColor(Color color) {
        LeatherArmorMeta meta = (LeatherArmorMeta) stack.getItemMeta();
        meta.setColor(color);
        setItemMeta(meta);
        return this;
    }

    public ItemUtil setGlow (boolean glow) {
        if (glow) {
            addEnchant(Enchantment.KNOCKBACK, 1);
            addItemFlag(ItemFlag.HIDE_ENCHANTS);
        } else {
            ItemMeta meta = getItemMeta();
            for (Enchantment enchantment : meta.getEnchants().keySet()) {
                meta.removeEnchant(enchantment);
            }
        }
        return this;
    }

    public ItemUtil setUnbreakable (boolean unbreakable) {
        ItemMeta meta = stack.getItemMeta();
        meta.setUnbreakable(unbreakable);
        stack.setItemMeta(meta);
        return this;
    }

    public ItemUtil setBannerColor (DyeColor color) {
        BannerMeta meta = (BannerMeta) stack.getItemMeta();
        meta.setBaseColor(color);
        setItemMeta(meta);
        return this;
    }

    public ItemUtil setAmount(int amount) {
        stack.setAmount(amount);
        return this;
    }

    public ItemUtil setItemMeta(ItemMeta meta) {
        stack.setItemMeta(meta);
        return this;
    }

    public ItemUtil setHead(String owner) {
        SkullMeta meta = (SkullMeta) stack.getItemMeta();
        meta.setOwner(owner);
        setItemMeta(meta);
        return this;
    }

    public ItemUtil setDisplayName(String displayname) {
        ItemMeta meta = getItemMeta();
        meta.setDisplayName(displayname);
        setItemMeta(meta);
        return this;
    }

    public ItemUtil setItemStack (ItemStack stack) {
        this.stack = stack;
        return this;
    }

    public ItemUtil setLore(ArrayList<String> lore) {
        ArrayList<String> coloredLore = new ArrayList<>();
        for(String lores : lore) {
            coloredLore.add(ChatUtil.color(lores));
        }
        ItemMeta meta = getItemMeta();
        meta.setLore(coloredLore);
        setItemMeta(meta);
        return this;
    }

    public ItemUtil setLore(String... lore) {
        ArrayList<String> loreList = new ArrayList<>();
        Collections.addAll(loreList, lore);
        ArrayList<String> coloredLore = new ArrayList<>();
        for(String lores : loreList) {
            coloredLore.add(ChatUtil.color(lores));
        }
        ItemMeta meta = getItemMeta();
        meta.setLore(coloredLore);
        setItemMeta(meta);
        return this;
    }

    public ItemUtil setGlow() {
        ItemMeta meta = getItemMeta();
        meta.addEnchant(Enchantment.LUCK, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        setItemMeta(meta);
        return this;
    }

    public ItemUtil addEnchant(Enchantment enchantment, int level) {
        ItemMeta meta = getItemMeta();
        meta.addEnchant(enchantment, level, true);
        setItemMeta(meta);
        return this;
    }

    public ItemUtil addItemFlag(ItemFlag flag) {
        ItemMeta meta = getItemMeta();
        meta.addItemFlags(flag);
        setItemMeta(meta);
        return this;
    }

    public ItemStack build() {
        return stack;
    }

}

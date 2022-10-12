package lol.maltest.minebuddiesgambling.commands;

import lol.maltest.minebuddiesgambling.MineBuddiesGambling;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MinesCommand implements CommandExecutor {

    private MineBuddiesGambling plugin;

    public MinesCommand(MineBuddiesGambling plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        return false;
    }
}

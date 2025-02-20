package com.skrewbar.snowFight;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.Arrays;
import java.util.List;

public class ToggleCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        SnowFight plugin = SnowFight.getPlugin();
        switch (args[0]) {
            case "켜기":
                if (plugin.on) sender.sendMessage("이미 눈싸움 모드가 켜져 있습니다.");
                else {
                    SnowFight.getPlugin().on = true;
                    sender.sendMessage("눈싸움 모드가 켜졌습니다.");
                }
                return true;
            case "끄기":
                if (!plugin.on) sender.sendMessage("이미 눈싸움 모드가 꺼져 있습니다.");
                else {
                    SnowFight.getPlugin().on = false;
                    sender.sendMessage("눈싸움 모드가 꺼졌습니다.");
                }
                return true;
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) {
            return Arrays.asList("켜기", "끄기");
        }
        return List.of();
    }
}

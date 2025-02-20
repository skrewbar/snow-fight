package com.skrewbar.snowFight.commands;

import com.skrewbar.snowFight.SnowFight;
import net.kyori.adventure.text.Component;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.*;

import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class CreateSpotCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;

        TreeMap<String, TextDisplay> snowballSpot = SnowFight.snowballSpot;

        Player player = (Player) sender;
        if (args.length < 1) {
            player.sendMessage("스팟을 생성할지 제거할지 정해주세요.");
            return false;
        }

        String name;
        switch (args[0]) {
            case "생성":
                if (args.length < 2) {
                    player.sendMessage("스팟의 이름을 입력해 주세요.");
                    return false;
                }

                name = args[1];
                if (snowballSpot.containsKey(name)) {
                    player.sendMessage("이미 같은 이름의 스팟이 존재합니다.");
                    return false;
                }

                TextDisplay spot = (TextDisplay) player.getWorld().spawnEntity(player.getLocation(), EntityType.TEXT_DISPLAY);
                spot.text(Component.text("눈덩이 스팟"));
                spot.setBillboard(Display.Billboard.CENTER);
                snowballSpot.put(name, spot);

                player.sendMessage("성공적으로 스팟이 생성되었습니다.");
                return true;
            case "제거":
                if (args.length < 2) {
                    player.sendMessage("스팟의 이름을 입력해 주세요.");
                    return false;
                }

                name = args[1];
                if (!snowballSpot.containsKey(name)) {
                    player.sendMessage("해당 이름의 스팟은 존재하지 않습니다.");
                    return false;
                }

                snowballSpot.remove(name).remove();
                player.sendMessage("성공적으로 스팟이 제거되었습니다.");
                return true;
            case "목록":
                if (args.length > 1) return false;
                if (snowballSpot.isEmpty()) {
                    player.sendMessage("생성된 눈스팟이 없습니다.");
                    return true;
                }

                player.sendMessage("눈스팟 목록");
                for (String key : snowballSpot.keySet()) {
                    player.sendMessage(" - " + key);
                }
                return true;
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        switch (args.length) {
            case 1:
                return Arrays.asList("생성", "제거", "목록");
            case 2:
                if (!args[0].equals("제거")) return List.of();
                TreeMap<String, TextDisplay> snowballSpot = SnowFight.snowballSpot;
                return List.copyOf(snowballSpot.keySet());
        }
        return List.of();
    }
}

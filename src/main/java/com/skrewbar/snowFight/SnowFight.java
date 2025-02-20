package com.skrewbar.snowFight;

import com.skrewbar.snowFight.commands.CreateSpotCommand;
import com.skrewbar.snowFight.commands.ToggleCommand;
import org.bukkit.entity.TextDisplay;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.TreeMap;

public final class SnowFight extends JavaPlugin {
    private static SnowFight plugin;
    public boolean on = false;

    public static TreeMap<String, TextDisplay> snowballSpot = new TreeMap<>();

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        getServer().getPluginCommand("눈싸움").setExecutor(new ToggleCommand());
        getServer().getPluginCommand("눈싸움").setTabCompleter(new ToggleCommand());
        getServer().getPluginCommand("눈스팟").setExecutor(new CreateSpotCommand());
        getServer().getPluginCommand("눈스팟").setTabCompleter(new CreateSpotCommand());
        getServer().getPluginManager().registerEvents(new SnowballHitEvent(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static SnowFight getPlugin() {
        return plugin;
    }
}

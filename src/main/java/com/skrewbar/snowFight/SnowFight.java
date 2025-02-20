package com.skrewbar.snowFight;

import org.bukkit.plugin.java.JavaPlugin;

public final class SnowFight extends JavaPlugin {
    private static SnowFight plugin;
    public boolean on = false;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        getServer().getPluginCommand("눈싸움").setExecutor(new ToggleCommand());
        getServer().getPluginCommand("눈싸움").setTabCompleter(new ToggleCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static SnowFight getPlugin() {
        return plugin;
    }
}

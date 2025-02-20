package com.skrewbar.snowFight;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class SnowballHitEvent implements Listener {
    @EventHandler
    public void onSnowballHit(ProjectileHitEvent event) {
        if (!SnowFight.getPlugin().on) return;
        if (event.getHitEntity() instanceof Player player) {
            player.setGameMode(GameMode.SPECTATOR);
        }
    }
}

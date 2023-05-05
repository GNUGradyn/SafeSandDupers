package com.gradyn.safesanddupers;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPortalEnterEvent;

import java.util.logging.Logger;

public class portalEnterListener implements Listener {
    @EventHandler
    public final void onEntityPortalEnterEvent(EntityPortalEnterEvent event) {
        if (event.getLocation().getBlock().getType() != Material.END_PORTAL) return;
        if (event.getLocation().getWorld().getEnvironment() != World.Environment.NORMAL) return;

        double y = 2032;
        if (SafeSandDupers.config.getString("location.y").toLowerCase().equals("auto")) {
            while (y > -2032) {
                Block block = new Location(
                        Bukkit.getWorld(SafeSandDupers.config.getString("world")),
                        SafeSandDupers.config.getDouble("location.x"),
                        y,
                        SafeSandDupers.config.getDouble("location.z")
                ).getBlock();
                if (block.getType() != Material.AIR && block.getType() != Material.VOID_AIR && block.getType() != Material.CAVE_AIR) {
                    break;
                }
                y--;
            }
            if (y == -2035) {
                Logger.getAnonymousLogger().warning("No safe block at end entity teleport location found. Cancelling teleportation");
                return;
            }
        } else {
            y = SafeSandDupers.config.getDouble("location.y");
        }


    }
}

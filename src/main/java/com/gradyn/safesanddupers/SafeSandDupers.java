package com.gradyn.safesanddupers;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class SafeSandDupers extends JavaPlugin {
    public static FileConfiguration config;

    @Override
    public void onLoad() {
        this.saveDefaultConfig();
        config = this.getConfig();
        Logger.getAnonymousLogger().info("SafeSandDupers Loaded");
    }

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new portalEnterListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

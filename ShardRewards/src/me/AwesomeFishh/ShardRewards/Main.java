package me.AwesomeFishh.ShardRewards;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import me.AwesomeFishh.ShardRewards.Events.Events;

public class Main extends JavaPlugin {
	
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new Events(), this);
		getCommand("");
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[ShardRewards] Enabled!");
		loadConfig();
	}
	
	public void onDisable() {
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[ShardRewards] Disabled!");
		saveConfig();
	}
	
	public void loadConfig() {
		getConfig().getDefaults().options().copyDefaults(true);
		saveConfig();
	}

}

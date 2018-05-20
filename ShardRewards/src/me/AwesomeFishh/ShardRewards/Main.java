package me.AwesomeFishh.ShardRewards;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import me.AwesomeFishh.ShardRewards.Commands.RegisterChest;
import me.AwesomeFishh.ShardRewards.Configurations.ChestConfig;
import me.AwesomeFishh.ShardRewards.Configurations.ConfigManager;
import me.AwesomeFishh.ShardRewards.Events.Events;

public class Main extends JavaPlugin {
	
	public String prefix = ChatColor.GOLD + "[ShardRewards]";
	public ConfigManager configManager = new ConfigManager();
	public ChestConfig chestConfig = new ChestConfig();
	
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new Events(), this);
		getCommand("registerchests").setExecutor(new RegisterChest());
		configManager.setupChestFile();
		loadConfig();
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[ShardRewards] Enabled!");
	}
	
	public void onDisable() {
		saveConfig();
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[ShardRewards] Disabled!");
	}
	
	public void loadConfig() {
		getConfig().getDefaults().options().copyDefaults(true);
		saveConfig();
	}

}

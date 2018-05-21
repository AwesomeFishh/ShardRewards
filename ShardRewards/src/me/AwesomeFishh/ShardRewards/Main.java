package me.AwesomeFishh.ShardRewards;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import me.AwesomeFishh.ShardRewards.Commands.RegisterChest;
import me.AwesomeFishh.ShardRewards.Configurations.ChestConfig;
import me.AwesomeFishh.ShardRewards.Configurations.ConfigManager;
import me.AwesomeFishh.ShardRewards.Events.Events;

public class Main extends JavaPlugin {

	public String prefix = ChatColor.GOLD + "[ShardRewards]";
	public ConfigManager configManager;
	public ChestConfig chestConfig;
	
	public void onEnable() {

		configManager = new ConfigManager(this);
		chestConfig = new ChestConfig(this);
		this.getServer().getPluginManager().registerEvents(new Events(this), this);
		this.getCommand("registerchest").setExecutor(new RegisterChest(this));
		configManager.setupChestFile();
		loadConfig();
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[ShardRewards] Enabled!");
	}
	
	public void onDisable() {
		saveConfig();
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[ShardRewards] Disabled!");
	}
	
	public void loadConfig() {
		getConfig().addDefault("chests.1.item", "COOKED_BEEF");
		getConfig().addDefault("chests.1.amount", 1);
		getConfig().addDefault("chests.1.name", "&6Steak");
		getConfig().addDefault("chests.1.command.1", "/give %p minecraft:steak 1");
		getConfig().addDefault("chests.1.command.2", "/spawn %p");
		getConfig().addDefault("chests.1.shardscost", "1");
		getConfig().getDefaults().options().copyDefaults(true);
		saveConfig();
	}

}

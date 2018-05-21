package me.AwesomeFishh.ShardRewards.Configurations;

import me.AwesomeFishh.ShardRewards.Main;

public class ConfigManager {
	
	Main plugin;
	ChestConfig chestClass = plugin.chestConfig;
	
	public ConfigManager(Main plugin) {
		this.plugin = plugin;
	}
	
	public void setupChestFile() {
		chestClass.createChests();
		chestClass.saveChestsCfg();
		chestClass.reloadChestsCfg();
	}

}

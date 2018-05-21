package me.AwesomeFishh.ShardRewards.Configurations;

import me.AwesomeFishh.ShardRewards.Main;

public class ConfigManager {

	Main plugin;
	ChestConfig chestClass;
	
	public ConfigManager(Main plugin) {
		this.plugin = plugin;
	}

	public void setupChestFile() {
		chestClass = plugin.chestConfig;
		chestClass.createChests();
		chestClass.saveChestsCfg();
		chestClass.reloadChestsCfg();
	}

}

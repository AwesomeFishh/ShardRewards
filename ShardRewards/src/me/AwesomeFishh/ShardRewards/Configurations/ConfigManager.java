package me.AwesomeFishh.ShardRewards.Configurations;

import me.AwesomeFishh.ShardRewards.Main;

public class ConfigManager {
	
	private Main plugin = Main.getPlugin(Main.class);
	ChestConfig chestClass = plugin.chestConfig;
	
	public void setupChestFile() {
		chestClass.createChests();
		chestClass.saveChestsCfg();
		chestClass.reloadChestsCfg();
	}

}

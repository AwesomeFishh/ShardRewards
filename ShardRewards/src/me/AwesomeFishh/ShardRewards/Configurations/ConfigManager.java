package me.AwesomeFishh.ShardRewards.Configurations;

public class ConfigManager {
	
	private ChestConfig chestClass = new ChestConfig();
	
	public void setupChestFile() {
		chestClass.createChests();
		chestClass.saveChestsCfg();
		chestClass.reloadChestsCfg();
		
	}

}

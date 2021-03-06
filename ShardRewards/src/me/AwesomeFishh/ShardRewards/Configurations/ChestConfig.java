package me.AwesomeFishh.ShardRewards.Configurations;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import me.AwesomeFishh.ShardRewards.Main;

public class ChestConfig {

	Main plugin;

	public ChestConfig(Main plugin) {
		this.plugin = plugin;
	}

	public FileConfiguration chestcfg;
	public File chestfile;

	public void createChests() {

		if (!plugin.getDataFolder().exists()) {
			plugin.getDataFolder().mkdir();
		}

		chestfile = new File(plugin.getDataFolder(), "chests.yml");

		if (!chestfile.exists()) {
			try {
				chestfile.createNewFile();
				Bukkit.getServer().getConsoleSender()
						.sendMessage(plugin.prefix + ChatColor.GREEN + "Chests.yml file has been created!");
			} catch (IOException e) {
				Bukkit.getServer().getConsoleSender()
						.sendMessage(plugin.prefix + ChatColor.RED + "Could not create chests.yml file!");
			}
		}

		chestcfg = YamlConfiguration.loadConfiguration(chestfile);
	}

	public FileConfiguration getChestsCfg() {
		return chestcfg;
	}

	public void saveChestsCfg() {
		try {
			chestcfg.save(chestfile);
			Bukkit.getServer().getConsoleSender()
					.sendMessage(plugin.prefix + ChatColor.GREEN + "Chests.yml file has been saved!");
		} catch (IOException e) {
			Bukkit.getServer().getConsoleSender()
					.sendMessage(plugin.prefix + ChatColor.RED + "Could not save chests.yml file!");
		}
	}

	public void reloadChestsCfg() {
		chestcfg = YamlConfiguration.loadConfiguration(chestfile);
		Bukkit.getServer().getConsoleSender()
				.sendMessage(plugin.prefix + ChatColor.GREEN + "Chests.yml file has been reloaded!");
	}

}

package me.AwesomeFishh.ShardRewards.Commands;

import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.AwesomeFishh.ShardRewards.Main;
import me.AwesomeFishh.ShardRewards.Configurations.ChestConfig;
import me.AwesomeFishh.ShardRewards.Configurations.ConfigManager;

public class RegisterChest implements CommandExecutor {

	Main plugin;
	
	ChestConfig chestConfig = plugin.chestConfig;
	ConfigManager configManager = plugin.configManager;

	public RegisterChest(Main plugin) {
		this.plugin = plugin;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

		if (cmd.getName().equalsIgnoreCase("registerchest")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (args.length == 1) {
					Block block = player.getTargetBlock(null, 200);
					if (args[0].matches("^[0-9]*$")) {
						int id = Integer.parseInt(args[0]);
						if (!chestConfig.getChestsCfg().contains("chest." + id)) {
							if (block.getType().getId() == 54) {
								chestConfig.getChestsCfg().set("chest." + id + ".world", player.getWorld());
								chestConfig.getChestsCfg().set("chest." + id + ".x", block.getLocation().getX());
								chestConfig.getChestsCfg().set("chest." + id + ".y", block.getLocation().getY());
								chestConfig.getChestsCfg().set("chest." + id + ".z", block.getLocation().getZ());
								player.sendMessage(plugin.prefix + ChatColor.YELLOW + " Chest with id " + id
										+ "has been successfully registered!");
							} else {
								player.sendMessage(plugin.prefix + ChatColor.YELLOW
										+ " Please look at a chest while using this command!");
							}
						} else {
							player.sendMessage(
									plugin.prefix + ChatColor.YELLOW + " A chest with that ID already exists!");
						}
					} else {
						player.sendMessage(plugin.prefix + ChatColor.RED + " Please specificy a number for the ID!");
					}
				}
			}
		}

		return false;
	}

}

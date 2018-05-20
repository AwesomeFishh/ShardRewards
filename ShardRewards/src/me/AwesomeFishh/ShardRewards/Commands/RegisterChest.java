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

	private Main plugin = Main.getPlugin(Main.class);
	ChestConfig chestConfig = plugin.chestConfig;
	ConfigManager configManager = plugin.configManager;
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

		if (cmd.getName().equalsIgnoreCase("registerchest")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (args.length == 0) {
					Block block = player.getTargetBlock(null, 200);
					if(block.getType().getId() == 54) {
						
					} else {
						player.sendMessage(plugin.prefix + ChatColor.YELLOW + " Please look at a chest while using this command!");
					}
				}
			}
		}

		return false;
	}

}

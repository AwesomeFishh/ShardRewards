package me.AwesomeFishh.ShardRewards.Events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.AwesomeFishh.ShardRewards.Main;

public class Events implements Listener {

	private Main plugin = Main.getPlugin(Main.class);

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onBlockBreakEvent(BlockBreakEvent e) {
		if (e.getPlayer() instanceof Player) {
			Player p = e.getPlayer();
			Block block = e.getBlock();
			int configID = plugin.getConfig().getInt("block");
			if (block.getType().getId() == configID) {
				int percentage = plugin.getConfig().getInt("chance");
				double d = Math.random() * 100;
				if (d < percentage) {
					Inventory pinv = p.getInventory();
					ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
					ItemMeta itemMeta = item.getItemMeta();
					itemMeta.setDisplayName(ChatColor.GOLD + "Shard");
					pinv.addItem(item);
					String blockName = block.getType().toString().toLowerCase();
					p.sendMessage(plugin.prefix + ChatColor.YELLOW + " You mined a " + ChatColor.AQUA + blockName
							+ ChatColor.YELLOW + " and got a shard!");
				}
			}
		}
	}

}

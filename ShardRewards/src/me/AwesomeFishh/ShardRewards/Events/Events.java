package me.AwesomeFishh.ShardRewards.Events;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.AwesomeFishh.ShardRewards.Main;
import me.AwesomeFishh.ShardRewards.Configurations.ChestConfig;

public class Events implements Listener {

	Main plugin;
	
	ChestConfig chestCfg = plugin.chestConfig;
	
	public Events(Main plugin) {
		this.plugin = plugin;
	}

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
					ItemStack item = new ItemStack(Material.PRISMARINE_SHARD, 1);
					ItemMeta itemMeta = item.getItemMeta();
					itemMeta.setDisplayName(ChatColor.GOLD + "Shard");
					ArrayList<String> lore = new ArrayList<String>();
					lore.add(ChatColor.YELLOW + "Spend this in a shop!");
					itemMeta.setLore(lore);
					item.setItemMeta(itemMeta);
					pinv.addItem(item);
					String blockName = block.getType().toString().toLowerCase();
					p.sendMessage(plugin.prefix + ChatColor.YELLOW + " You mined a " + ChatColor.AQUA + blockName
							+ ChatColor.YELLOW + " and got a shard!");
				}
			}
		}
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onChestInteract(PlayerInteractEvent e) {
		if (e.hasBlock()) {
			if (e.getClickedBlock().getType() == Material.CHEST) {
				Block b = e.getClickedBlock();
				Chest chest = (Chest) b.getState();
				Player p = e.getPlayer();
				String chestWorld = chest.getLocation().getWorld().getName();
				double chestX = chest.getLocation().getX();
				double chestY = chest.getLocation().getY();
				double chestZ = chest.getLocation().getZ();
				for (String id : chestCfg.getChestsCfg().getConfigurationSection("chest").getKeys(false)) {
					String configWorld = chestCfg.getChestsCfg().getString("chest." + id + ".world");
					double configX = chestCfg.getChestsCfg().getDouble("chest." + id + ".x");
					double configY = chestCfg.getChestsCfg().getDouble("chest." + id + ".y");
					double configZ = chestCfg.getChestsCfg().getDouble("chest." + id + ".z");
					if (chestWorld == configWorld && chestX == configX && chestY == configY && chestZ == configZ) {
						Inventory chestInv = chest.getBlockInventory();
						for (String slot : plugin.getConfig().getConfigurationSection("chests").getKeys(false)) {
							ItemStack item = new ItemStack(
									Material.getMaterial(plugin.getConfig().getString("chests." + slot + ".item")),
									plugin.getConfig().getInt("chests." + slot + ".amount"));
							String name = ChatColor.translateAlternateColorCodes('&',
									plugin.getConfig().getString("chests." + slot + ".name"));
							for (String commandid : plugin.getConfig()
									.getConfigurationSection("chests." + slot + ".command").getKeys(false)) {
								String command = plugin.getConfig()
										.getString("chests." + slot + ".command." + commandid);
							}
							int shardscost = plugin.getConfig().getInt("chests." + slot + ".shardscost");
							ItemMeta meta = item.getItemMeta();
							meta.setDisplayName(name);
							ArrayList<String> lore = new ArrayList<String>();
							lore.add(ChatColor.GRAY + "Buy this item with shards!");
							lore.add(ChatColor.GRAY + "Cost: " + ChatColor.RED + shardscost + ChatColor.GRAY
									+ " shards!");
							meta.setLore(lore);
							item.setItemMeta(meta);
							chestInv.setItem(Integer.parseInt(slot), item);
						}
					}
				}
			}
		}
	}
}

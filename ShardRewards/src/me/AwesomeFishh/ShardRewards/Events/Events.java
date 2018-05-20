package me.AwesomeFishh.ShardRewards.Events;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import me.AwesomeFishh.ShardRewards.Main;

public class Events implements Listener {
	
	private Main plugin = Main.getPlugin(Main.class);

	public void onBlockBreakEvent(BlockBreakEvent e) { 
		if(e.getPlayer() instanceof Player) {
			Player p = e.getPlayer();
			Block block = e.getBlock();
			if(block.getType().toString().toUpperCase().equals(plugin.getConfig().getString("block"))) {
				int percentage = plugin.getConfig().getInt("chance");
			}
		}
	}
	
}

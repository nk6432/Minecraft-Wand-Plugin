package com.minecraft.plugins;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.inventory.meta.ItemMeta;

public class Listeners extends OtherStuff implements Listener {
	@EventHandler
	public void giveItems(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		player.getInventory().addItem(Glock17());
		player.getInventory().addItem(RPG());
	}
	@EventHandler
	public void netherWand(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
			if (meta.getDisplayName().equalsIgnoreCase(ChatColor.DARK_PURPLE + "Nether Wand")) {
				if (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {	
					BlockFace face = BlockFace.WEST;
					Location front2 = player.getTargetBlockExact(50).getLocation();
					Location front3 = new Location(Bukkit.getWorld("world"), player.getTargetBlockExact(50).getX() + 0, player.getTargetBlockExact(50).getY() + 4, player.getTargetBlockExact(50).getZ() + 3);
					Portal nether_portal = new Portal();
					nether_portal.NetherPortal(front2, front3, face);
				}
				if (event.getAction().equals(Action.LEFT_CLICK_AIR) || event.getAction().equals(Action.LEFT_CLICK_BLOCK)) {	
					BlockFace face = BlockFace.NORTH;
					Location front2 = player.getTargetBlockExact(50).getLocation();
					Location front3 = new Location(Bukkit.getWorld("world"), player.getTargetBlockExact(50).getX() + 3, player.getTargetBlockExact(50).getY() + 4, player.getTargetBlockExact(50).getZ());
					Portal nether_portal = new Portal();
					nether_portal.NetherPortal(front2, front3, face);
				}
			}
		}
	@EventHandler
	public void endWand(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
		if (meta.getDisplayName().equalsIgnoreCase(ChatColor.DARK_PURPLE + "End Wand")) {
			if (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {	
				BlockFace face = BlockFace.WEST;					Location front2 = new Location(Bukkit.getWorld("world"), player.getTargetBlockExact(50).getX(), player.getTargetBlockExact(50).getY() + 1, player.getTargetBlockExact(50).getZ());
				Location front3 = new Location(Bukkit.getWorld("world"), player.getTargetBlockExact(50).getX() + 4, player.getTargetBlockExact(50).getY() + 1, player.getTargetBlockExact(50).getZ() + 4);
				Portal end_portal = new Portal();
				end_portal.EndPortal(front2, front3, face);
			}
			if (event.getAction().equals(Action.LEFT_CLICK_AIR) || event.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
				BlockFace face = BlockFace.NORTH;
				Location front2 = player.getTargetBlockExact(50).getLocation();
				Location front3 = new Location(Bukkit.getWorld("world"), player.getTargetBlockExact(50).getX() + 4, player.getTargetBlockExact(50).getY(), player.getTargetBlockExact(50).getZ() + 4);
				Portal end_portal = new Portal();
				end_portal.EndPortal(front2, front3, face);
			}
		}
	}
}

package de.sxlverc.villagerBreedBypass;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public final class VillagerBreedBypass extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
        if (event.getRightClicked().getType() == EntityType.VILLAGER) {
            Villager villager = (Villager) event.getRightClicked();
            ItemStack item = event.getPlayer().getInventory().getItemInMainHand();

            if (isFood(item.getType())) {
                ItemStack singleItem = item.clone();
                singleItem.setAmount(1);
                villager.getInventory().addItem(singleItem);
                item.setAmount(item.getAmount() - 1);
                event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_VILLAGER_YES, 1, 1);
                event.setCancelled(true); // Cancel the event to prevent the trading window from opening
            }
        }
    }

    @EventHandler
    public void onEntityPickupItem(EntityPickupItemEvent event) {
        if (event.getEntityType() == EntityType.VILLAGER) {
            Villager villager = (Villager) event.getEntity();
            ItemStack item = event.getItem().getItemStack();

            if (isFood(item.getType())) {
                villager.getInventory().addItem(item.clone());
                event.getItem().remove();
                event.setCancelled(true);
            }
        }
    }

    private boolean isFood(Material material) {
        return material == Material.BREAD || material == Material.CARROT || material == Material.POTATO || material == Material.BEETROOT;
    }
}
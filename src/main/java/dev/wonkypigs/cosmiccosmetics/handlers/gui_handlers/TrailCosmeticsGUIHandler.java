package dev.wonkypigs.cosmiccosmetics.handlers.gui_handlers;

import dev.wonkypigs.cosmiccosmetics.CosmicCosmetics;
import dev.wonkypigs.cosmiccosmetics.commands.CosmeticsMenu;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class TrailCosmeticsGUIHandler implements Listener {

    private final CosmicCosmetics plugin = CosmicCosmetics.getPlugin(CosmicCosmetics.class);

    @EventHandler
    public void onMenuClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        PersistentDataContainer pdata = player.getPersistentDataContainer();
        if(e.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "" + ChatColor.BOLD + "Trail Effects")) {
            e.setCancelled(true);
            player.closeInventory();
            if(e.getCurrentItem().getType().equals(Material.CRYING_OBSIDIAN)) {
                if(player.hasPermission("ccosmetics.trail.tears")) {
                    pdata.set(new NamespacedKey(plugin, "trail_effect"), PersistentDataType.STRING, "FALLING_OBSIDIAN_TEAR");
                    player.sendMessage(plugin.prefix + "Activated Tears Trail effect");
                }else {
                    player.sendMessage(plugin.prefix + plugin.getConfigValue("no-permission"));
                }
            }
            else if(e.getCurrentItem().getType().equals(Material.LAVA_BUCKET)) {
                if(player.hasPermission("ccosmetics.trail.lava")) {
                    pdata.set(new NamespacedKey(plugin, "trail_effect"), PersistentDataType.STRING, "DRIPPING_DRIPSTONE_LAVA");
                    player.sendMessage(plugin.prefix + "Activated Lava Trail effect");
                }else {
                    player.sendMessage(plugin.prefix + plugin.getConfigValue("no-permission"));
                }
            }
            else if(e.getCurrentItem().getType().equals(Material.WATER_BUCKET)) {
                if(player.hasPermission("ccosmetics.trail.water")) {
                    pdata.set(new NamespacedKey(plugin, "trail_effect"), PersistentDataType.STRING, "FALLING_WATER");
                    player.sendMessage(plugin.prefix + "Activated Water Trail effect");
                }else {
                    player.sendMessage(plugin.prefix + plugin.getConfigValue("no-permission"));
                }
            }
            else if(e.getCurrentItem().getType().equals(Material.SALMON)) {
                if(player.hasPermission("ccosmetics.trail.smoke")) {
                    pdata.set(new NamespacedKey(plugin, "trail_effect"), PersistentDataType.STRING, "SMOKE");
                    player.sendMessage(plugin.prefix + "Activated Smoke Trail effect");
                }else {
                    player.sendMessage(plugin.prefix + plugin.getConfigValue("no-permission"));
                }
            }
            else if(e.getCurrentItem().getType().equals(Material.NETHER_STAR)) {
                if(player.hasPermission("ccosmetics.trail.sparkle")) {
                    pdata.set(new NamespacedKey(plugin, "trail_effect"), PersistentDataType.STRING, "WAX_OFF");
                    player.sendMessage(plugin.prefix + "Activated Sparkle Trail effect");
                }else {
                    player.sendMessage(plugin.prefix + plugin.getConfigValue("no-permission"));
                }
            }
            else if(e.getCurrentItem().getType().equals(Material.RED_DYE)) {
                if(player.hasPermission("ccosmetics.trail.love")) {
                    pdata.set(new NamespacedKey(plugin, "trail_effect"), PersistentDataType.STRING, "HEART");
                    player.sendMessage(plugin.prefix + "Activated Love Trail effect");
                }else {
                    player.sendMessage(plugin.prefix + plugin.getConfigValue("no-permission"));
                }
            }
            else if(e.getCurrentItem().getType().equals(Material.DIAMOND_SWORD)) {
                if(player.hasPermission("ccosmetics.trail.crit")) {
                    pdata.set(new NamespacedKey(plugin, "trail_effect"), PersistentDataType.STRING, "CRIT");
                    player.sendMessage(plugin.prefix + "Activated Crit Trail effect");
                }else {
                    player.sendMessage(plugin.prefix + plugin.getConfigValue("no-permission"));
                }
            }
            else if(e.getCurrentItem().getType().equals(Material.DRAGON_BREATH)) {
                if(player.hasPermission("ccosmetics.trail.dragon")) {
                    pdata.set(new NamespacedKey(plugin, "trail_effect"), PersistentDataType.STRING, "REVERSE_PORTAL");
                    player.sendMessage(plugin.prefix + "Activated Dragon Trail effect");
                }else {
                    player.sendMessage(plugin.prefix + plugin.getConfigValue("no-permission"));
                }
            }
            else if(e.getCurrentItem().getType().equals(Material.SPORE_BLOSSOM)) {
                if(player.hasPermission("ccosmetics.trail.blossom")) {
                    pdata.set(new NamespacedKey(plugin, "trail_effect"), PersistentDataType.STRING, "FALLING_SPORE_BLOSSOM");
                    player.sendMessage(plugin.prefix + "Activated Blossom Trail effect");
                }else {
                    player.sendMessage(plugin.prefix + plugin.getConfigValue("no-permission"));
                }
            }
            else if(e.getCurrentItem().getType().equals(Material.LEATHER_BOOTS)) {
                pdata.set(new NamespacedKey(plugin, "trail_effect"), PersistentDataType.STRING, "NONE");
                player.sendMessage(plugin.prefix + "Reset All Trail effects");
            }
            else if(e.getCurrentItem().getType().equals(Material.BARRIER)) {
                CosmeticsMenu.openMainCosmeticsGUI(player);
            }
        }
    }
}
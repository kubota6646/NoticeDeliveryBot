package com.kubota6646.notice;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.Set;

/**
 * Manages messages from message.yml
 */
public class MessageManager {
    
    private final NoticePlugin plugin;
    private FileConfiguration messageConfig;
    private File messageFile;
    
    /**
     * Constructor for MessageManager
     * @param plugin The main plugin instance
     */
    public MessageManager(NoticePlugin plugin) {
        this.plugin = plugin;
        loadMessages();
    }
    
    /**
     * Load messages from message.yml
     */
    private void loadMessages() {
        messageFile = new File(plugin.getDataFolder(), "message.yml");
        
        if (!messageFile.exists()) {
            plugin.saveResource("message.yml", false);
        }
        
        messageConfig = YamlConfiguration.loadConfiguration(messageFile);
    }
    
    /**
     * Reload messages from message.yml
     */
    public void reloadMessages() {
        messageConfig = YamlConfiguration.loadConfiguration(messageFile);
    }
    
    /**
     * Get a message by key
     * @param key The message key
     * @return The message with color codes translated, or null if not found
     */
    public String getMessage(String key) {
        String message = messageConfig.getString("messages." + key);
        if (message != null) {
            return ChatColor.translateAlternateColorCodes('&', message);
        }
        return null;
    }
    
    /**
     * Get all available message keys
     * @return Set of message keys
     */
    public Set<String> getMessageKeys() {
        if (messageConfig.getConfigurationSection("messages") != null) {
            return messageConfig.getConfigurationSection("messages").getKeys(false);
        }
        return Set.of();
    }
    
    /**
     * Check if a message key exists
     * @param key The message key
     * @return true if the key exists, false otherwise
     */
    public boolean hasMessage(String key) {
        return messageConfig.contains("messages." + key);
    }
}

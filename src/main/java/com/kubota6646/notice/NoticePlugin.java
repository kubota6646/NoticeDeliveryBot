package com.kubota6646.notice;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Main plugin class for NoticePlugin
 * Handles plugin initialization and shutdown
 */
public class NoticePlugin extends JavaPlugin {
    
    private MessageManager messageManager;
    
    @Override
    public void onEnable() {
        // Save default config files if they don't exist
        saveDefaultConfig();
        saveResource("message.yml", false);
        
        // Initialize message manager
        messageManager = new MessageManager(this);
        
        // Register commands
        NoticeCommand noticeCommand = new NoticeCommand(messageManager);
        getCommand("notice").setExecutor(noticeCommand);
        getCommand("notice").setTabCompleter(noticeCommand);
        
        getLogger().info("NoticePlugin has been enabled!");
    }
    
    @Override
    public void onDisable() {
        getLogger().info("NoticePlugin has been disabled!");
    }
    
    /**
     * Get the message manager instance
     * @return MessageManager instance
     */
    public MessageManager getMessageManager() {
        return messageManager;
    }
}

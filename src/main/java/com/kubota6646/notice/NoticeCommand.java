package com.kubota6646.notice;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

/**
 * Command executor for /notice command
 */
public class NoticeCommand implements CommandExecutor, TabCompleter {
    
    private final MessageManager messageManager;
    
    /**
     * Constructor for NoticeCommand
     * @param messageManager The message manager instance
     */
    public NoticeCommand(MessageManager messageManager) {
        this.messageManager = messageManager;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Check if a message key was provided
        if (args.length == 0) {
            sender.sendMessage(ChatColor.RED + "Usage: /notice <message-key>");
            sender.sendMessage(ChatColor.YELLOW + "Available keys: " + String.join(", ", messageManager.getMessageKeys()));
            return true;
        }
        
        String messageKey = args[0];
        
        // Check if the message key exists
        if (!messageManager.hasMessage(messageKey)) {
            sender.sendMessage(ChatColor.RED + "Message key '" + messageKey + "' not found in message.yml");
            sender.sendMessage(ChatColor.YELLOW + "Available keys: " + String.join(", ", messageManager.getMessageKeys()));
            return true;
        }
        
        // Get the message
        String message = messageManager.getMessage(messageKey);
        
        if (message == null) {
            sender.sendMessage(ChatColor.RED + "Failed to retrieve message for key: " + messageKey);
            return true;
        }
        
        // Broadcast the message to all players
        Bukkit.broadcastMessage(message);
        
        // Send confirmation to sender
        sender.sendMessage(ChatColor.GREEN + "Message broadcasted successfully!");
        
        return true;
    }
    
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        List<String> completions = new ArrayList<>();
        
        // Only provide completions for the first argument (message key)
        if (args.length == 1) {
            String partial = args[0].toLowerCase();
            for (String key : messageManager.getMessageKeys()) {
                if (key.toLowerCase().startsWith(partial)) {
                    completions.add(key);
                }
            }
        }
        
        return completions;
    }
}

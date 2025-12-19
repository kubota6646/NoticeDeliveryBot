package com.kubota6646.notice;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.Collections;
import java.util.Set;

/**
 * message.ymlからメッセージを管理するクラス
 */
public class MessageManager {
    
    private final NoticePlugin plugin;
    private FileConfiguration messageConfig;
    private File messageFile;
    
    public MessageManager(NoticePlugin plugin) {
        this.plugin = plugin;
        loadMessages();
    }
    
    /**
     * message.ymlを読み込む
     */
    private void loadMessages() {
        messageFile = new File(plugin.getDataFolder(), "message.yml");
        
        if (!messageFile.exists()) {
            plugin.saveResource("message.yml", false);
        }
        
        messageConfig = YamlConfiguration.loadConfiguration(messageFile);
    }
    
    /**
     * message.ymlを再読み込みする
     */
    public void reloadMessages() {
        messageConfig = YamlConfiguration.loadConfiguration(messageFile);
    }
    
    /**
     * キーからメッセージを取得する
     * @param key メッセージキー
     * @return カラーコードが適用されたメッセージ、キーが存在しない場合はnull
     */
    public String getMessage(String key) {
        String message = messageConfig.getString("messages." + key);
        if (message != null) {
            return ChatColor.translateAlternateColorCodes('&', message);
        }
        return null;
    }
    
    /**
     * 利用可能なメッセージキーを取得する
     * @return メッセージキーのセット
     */
    public Set<String> getMessageKeys() {
        if (messageConfig.getConfigurationSection("messages") != null) {
            return messageConfig.getConfigurationSection("messages").getKeys(false);
        }
        return Collections.emptySet();
    }
    
    /**
     * メッセージキーが存在するか確認する
     * @param key メッセージキー
     * @return 存在する場合true、存在しない場合false
     */
    public boolean hasMessage(String key) {
        return messageConfig.contains("messages." + key);
    }
}

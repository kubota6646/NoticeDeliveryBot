package com.kubota6646.notice;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

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
     * リロードコマンドで使用
     * @return 再読み込みに成功した場合true、失敗した場合false
     */
    public boolean reload() {
        try {
            messageConfig = YamlConfiguration.loadConfiguration(messageFile);
            return true;
        } catch (Exception e) {
            plugin.getLogger().warning("message.ymlの再読み込みに失敗しました: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * キーからメッセージを取得する（カラーコード適用）
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
     * キーからメッセージを取得する（プレーンテキスト）
     * ログ出力など、カラーコードが不要な場合に使用
     * @param key メッセージキー
     * @return プレーンテキストのメッセージ、キーが存在しない場合はnull
     */
    public String getPlainMessage(String key) {
        return messageConfig.getString("messages." + key);
    }
}

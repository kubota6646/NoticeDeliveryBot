package com.kubota6646.notice;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * NoticePluginのメインクラス
 * プラグインの初期化と終了処理を行います
 */
public class NoticePlugin extends JavaPlugin {
    
    private MessageManager messageManager;
    
    @Override
    public void onEnable() {
        // message.ymlがない場合はデフォルトファイルを作成
        saveResource("message.yml", false);
        
        // メッセージマネージャーを初期化
        messageManager = new MessageManager(this);
        
        // コマンドを登録
        NoticeCommand noticeCommand = new NoticeCommand(messageManager);
        getCommand("notice").setExecutor(noticeCommand);
        
        getLogger().info("NoticePluginが有効になりました！");
    }
    
    @Override
    public void onDisable() {
        getLogger().info("NoticePluginが無効になりました！");
    }
    
    /**
     * メッセージマネージャーのインスタンスを取得
     * @return MessageManagerインスタンス
     */
    public MessageManager getMessageManager() {
        return messageManager;
    }
}

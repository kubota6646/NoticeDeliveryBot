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
        
        ReloadCommand reloadCommand = new ReloadCommand(this);
        getCommand("noticereload").setExecutor(reloadCommand);
        
        // 起動メッセージをmessage.ymlから取得
        String enableMessage = messageManager.getPlainMessage("plugin-enabled");
        if (enableMessage != null) {
            getLogger().info(enableMessage);
        }
    }
    
    @Override
    public void onDisable() {
        // 停止メッセージをmessage.ymlから取得
        String disableMessage = messageManager.getPlainMessage("plugin-disabled");
        if (disableMessage != null) {
            getLogger().info(disableMessage);
        }
    }
    
    /**
     * メッセージマネージャーのインスタンスを取得
     * @return MessageManagerインスタンス
     */
    public MessageManager getMessageManager() {
        return messageManager;
    }
}

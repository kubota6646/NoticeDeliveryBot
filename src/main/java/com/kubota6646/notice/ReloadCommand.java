package com.kubota6646.notice;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * /noticereloadコマンドの実行処理
 * message.ymlを再読み込みします
 */
public class ReloadCommand implements CommandExecutor {
    
    private final NoticePlugin plugin;
    
    public ReloadCommand(NoticePlugin plugin) {
        this.plugin = plugin;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // message.ymlを再読み込み
        plugin.getMessageManager().reload();
        
        // 成功メッセージを送信
        String successMessage = plugin.getMessageManager().getMessage("reload-success");
        if (successMessage != null) {
            sender.sendMessage(successMessage);
        }
        
        return true;
    }
}

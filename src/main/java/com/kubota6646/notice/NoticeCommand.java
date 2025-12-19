package com.kubota6646.notice;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * /noticeコマンドの実行処理
 * 現在ログイン中のプレイヤー全員にお知らせメッセージを送信します
 */
public final class NoticeCommand implements CommandExecutor {
    
    private final MessageManager messageManager;
    
    public NoticeCommand(MessageManager messageManager) {
        this.messageManager = messageManager;
    }
    
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        // メッセージを取得して、現在ログイン中の全プレイヤーに送信
        String message = messageManager.getMessage("notice");
        
        if (message == null) {
            // エラーメッセージもmessage.ymlから取得
            String errorMessage = messageManager.getMessage("error-load-failed");
            if (errorMessage != null) {
                sender.sendMessage(errorMessage);
            }
            return true;
        }
        
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.sendMessage(message);
        }
        
        // 送信完了メッセージもmessage.ymlから取得
        String successMessage = messageManager.getMessage("success-sent");
        if (successMessage != null) {
            sender.sendMessage(successMessage);
        }
        
        return true;
    }
}

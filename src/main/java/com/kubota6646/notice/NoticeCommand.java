package com.kubota6646.notice;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * /noticeコマンドの実行処理
 * 現在ログイン中のプレイヤー全員にお知らせメッセージを送信します
 */
public class NoticeCommand implements CommandExecutor {
    
    private final MessageManager messageManager;
    
    public NoticeCommand(MessageManager messageManager) {
        this.messageManager = messageManager;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // メッセージを取得して、現在ログイン中の全プレイヤーに送信
        String message = messageManager.getMessage("notice");
        
        if (message == null) {
            sender.sendMessage(ChatColor.RED + "メッセージの読み込みに失敗しました");
            return true;
        }
        
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.sendMessage(message);
        }
        
        // 送信完了メッセージ
        sender.sendMessage(ChatColor.GREEN + "お知らせを送信しました！");
        
        return true;
    }
}

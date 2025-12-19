package com.kubota6646.notice;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * /noticeコマンドの実行処理
 * 現在ログイン中のプレイヤー全員にメッセージを送信します
 */
public class NoticeCommand implements CommandExecutor, TabCompleter {
    
    private final MessageManager messageManager;
    
    public NoticeCommand(MessageManager messageManager) {
        this.messageManager = messageManager;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // メッセージキーが指定されていない場合
        if (args.length == 0) {
            sender.sendMessage(ChatColor.RED + "使用方法: /notice <メッセージキー>");
            sender.sendMessage(ChatColor.YELLOW + "利用可能なキー: " + String.join(", ", messageManager.getMessageKeys()));
            return true;
        }
        
        String messageKey = args[0];
        
        // メッセージキーが存在しない場合
        if (!messageManager.hasMessage(messageKey)) {
            sender.sendMessage(ChatColor.RED + "メッセージキー '" + messageKey + "' が見つかりません");
            sender.sendMessage(ChatColor.YELLOW + "利用可能なキー: " + String.join(", ", messageManager.getMessageKeys()));
            return true;
        }
        
        // メッセージを取得して、現在ログイン中の全プレイヤーに送信
        String message = messageManager.getMessage(messageKey);
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.sendMessage(message);
        }
        
        // 送信完了メッセージ
        sender.sendMessage(ChatColor.GREEN + "メッセージを送信しました！");
        
        return true;
    }
    
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        List<String> completions = new ArrayList<>();
        
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

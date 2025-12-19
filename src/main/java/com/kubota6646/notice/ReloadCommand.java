package com.kubota6646.notice;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

/**
 * /noticereloadコマンドの実行処理
 * message.ymlを再読み込みします
 */
public final class ReloadCommand implements CommandExecutor {
    
    private final NoticePlugin plugin;
    
    public ReloadCommand(NoticePlugin plugin) {
        this.plugin = plugin;
    }
    
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        // message.ymlを再読み込み
        boolean success = plugin.getMessageManager().reload();
        
        if (success) {
            // 成功メッセージを送信
            String successMessage = plugin.getMessageManager().getMessage("reload-success");
            if (successMessage != null) {
                sender.sendMessage(successMessage);
            }
        } else {
            // 失敗メッセージを送信
            String errorMessage = plugin.getMessageManager().getMessage("reload-failed");
            if (errorMessage != null) {
                sender.sendMessage(errorMessage);
            }
        }
        
        return true;
    }
}

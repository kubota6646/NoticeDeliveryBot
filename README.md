# NoticePlugin

MinecraftJAVA版のプラグイン - message.ymlに記載したメッセージを/noticeコマンドで配信

## 概要 (Overview)

NoticePluginは、Minecraft JAVA版のSpigot/Bukkitサーバー向けのプラグインです。
`message.yml`ファイルに設定したメッセージを`/notice`コマンドで全プレイヤーに配信できます。

This is a Minecraft JAVA Edition plugin for Spigot/Bukkit servers.
It allows you to broadcast messages configured in `message.yml` using the `/notice` command.

## 機能 (Features)

- 📝 `message.yml`で複数のメッセージを管理
- 📢 `/notice <メッセージキー>`でメッセージを全プレイヤーに配信
- 🎨 カラーコード対応（&文字を使用）
- ✨ タブ補完機能
- 🔒 権限システム対応

## インストール方法 (Installation)

1. プラグインをビルド:
```bash
mvn clean package
```

2. 生成された`notice-plugin-1.0.0.jar`を`plugins/`フォルダにコピー

3. サーバーを再起動

## 使い方 (Usage)

### コマンド (Commands)

```
/notice <message-key>
```

メッセージキーを指定して、全プレイヤーにメッセージを配信します。

**例 (Examples):**
```
/notice welcome
/notice maintenance
/notice event
```

### 権限 (Permissions)

- `notice.use` - /noticeコマンドの使用権限（デフォルト: op）

### メッセージの設定 (Message Configuration)

`plugins/NoticePlugin/message.yml`ファイルでメッセージを管理できます：

```yaml
messages:
  welcome: "&aWelcome to our server!"
  maintenance: "&cServer maintenance will start in 10 minutes."
  event: "&6Special event starting now!"
```

#### カラーコード (Color Codes)

- `&0` - 黒 (Black)
- `&1` - 濃い青 (Dark Blue)
- `&2` - 濃い緑 (Dark Green)
- `&3` - 濃い水色 (Dark Aqua)
- `&4` - 濃い赤 (Dark Red)
- `&5` - 濃い紫 (Dark Purple)
- `&6` - 金色 (Gold)
- `&7` - 灰色 (Gray)
- `&8` - 濃い灰色 (Dark Gray)
- `&9` - 青 (Blue)
- `&a` - 緑 (Green)
- `&b` - 水色 (Aqua)
- `&c` - 赤 (Red)
- `&d` - 明るい紫 (Light Purple)
- `&e` - 黄色 (Yellow)
- `&f` - 白 (White)

## 動作環境 (Requirements)

- Minecraft 1.20.1以上
- Spigot/Bukkit API
- Java 17以上

## ビルド方法 (Building)

```bash
mvn clean package
```

ビルドされたJARファイルは`target/`ディレクトリに生成されます。

## ライセンス (License)

このプロジェクトのライセンスについては[LICENSE](LICENSE)ファイルを参照してください。
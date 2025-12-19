# NoticePlugin

MinecraftJAVA版のプラグイン - /noticeコマンドで現在ログイン中のプレイヤーにお知らせを送信

## 概要 (Overview)

NoticePluginは、Minecraft JAVA版のSpigot/Bukkitサーバー向けのプラグインです。
`/notice`コマンドで現在ログイン中の全プレイヤーにお知らせメッセージを送信できます。

This is a Minecraft JAVA Edition plugin for Spigot/Bukkit servers.
It allows you to send notification messages to all currently logged-in players using the `/notice` command.

## 機能 (Features)

- 📢 `/notice`コマンドで現在ログイン中のプレイヤーにお知らせを送信
- 🎨 カラーコード対応（&文字を使用）
- 🔒 権限システム対応

## インストール方法 (Installation)

1. プラグインをビルド:
```bash
# Mavenの場合
mvn clean package

# Gradleの場合（推奨）
./gradlew clean build
```

2. 生成された`notice-plugin-0.0.1.jar`を`plugins/`フォルダにコピー
   - Maven: `target/notice-plugin-0.0.1.jar`
   - Gradle: `build/libs/notice-plugin-0.0.1.jar`

3. サーバーを再起動

## 使い方 (Usage)

### コマンド (Commands)

```
/notice
```

現在ログイン中の全プレイヤーにお知らせメッセージを送信します。

### 権限 (Permissions)

- `notice.use` - /noticeコマンドの使用権限（デフォルト: op）

### メッセージの設定 (Message Configuration)

`plugins/NoticePlugin/message.yml`ファイルでメッセージを変更できます：

```yaml
messages:
  notice: "&a新しいお知らせが配信されました！詳細はDiscordをご覧ください"
```

#### カラーコード (Color Codes)

メッセージ内で以下のカラーコードが使用できます：

- `&a` - 緑 (Green)
- `&c` - 赤 (Red)
- `&e` - 黄色 (Yellow)
- `&6` - 金色 (Gold)
- `&b` - 水色 (Aqua)
- その他のMinecraftカラーコード

## 動作環境 (Requirements)

- Minecraft 1.19.4以上
- Spigot/Bukkit API
- Java 17以上

## ビルド方法 (Building)

```bash
# Mavenの場合
mvn clean package

# Gradleの場合（推奨）
./gradlew clean build
```

ビルドされたJARファイルは`target/`（Maven）または`build/libs/`（Gradle）ディレクトリに生成されます。

## ライセンス (License)

このプロジェクトのライセンスについては[LICENSE](LICENSE)ファイルを参照してください。
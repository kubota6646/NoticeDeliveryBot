# NoticePlugin

**バージョン:** 0.0.3

MinecraftJAVA版のプラグイン - /noticeコマンドで現在ログイン中のプレイヤーにお知らせを送信

## 概要 (Overview)

NoticePluginは、Minecraft JAVA版のSpigot/Bukkitサーバー向けのプラグインです。
`/notice`コマンドで現在ログイン中の全プレイヤーにお知らせメッセージを送信できます。

This is a Minecraft JAVA Edition plugin for Spigot/Bukkit servers.
It allows you to send notification messages to all currently logged-in players using the `/notice` command.

## 機能 (Features)

- 📢 `/notice`コマンドで現在ログイン中のプレイヤーにお知らせを送信
- 🔄 `/noticereload`コマンドでサーバーを再起動せずに設定を再読み込み
- 🎨 カラーコード対応（&文字を使用）
- 📝 全てのメッセージをmessage.ymlでカスタマイズ可能
- 🔒 権限システム対応

## インストール方法 (Installation)

1. プラグインをビルド:
```bash
# Mavenの場合
mvn clean package

# Gradleの場合（推奨）
./gradlew clean build
```

2. 生成された`notice-plugin-0.0.3.jar`を`plugins/`フォルダにコピー
   - Maven: `target/notice-plugin-0.0.3.jar`
   - Gradle: `build/libs/notice-plugin-0.0.3.jar`

3. サーバーを再起動

## 使い方 (Usage)

### コマンド (Commands)

#### /notice
現在ログイン中の全プレイヤーにお知らせメッセージを送信します。

**使用例:**
```
/notice
```

実行すると、message.ymlの`notice`キーに設定されたメッセージが全オンラインプレイヤーに送信されます。

#### /noticereload
message.ymlを再読み込みします。設定ファイルを編集した後、サーバーを再起動せずに変更を反映できます。

**使用例:**
```
/noticereload
```

メッセージ設定を変更した後、このコマンドを実行すると即座に反映されます。

### 権限 (Permissions)

| 権限 | 説明 | デフォルト |
|------|------|-----------|
| `notice.use` | /noticeコマンドの使用権限 | op |
| `notice.reload` | /noticereloadコマンドの使用権限 | op |

**権限設定例（permissions.ymlまたは権限プラグイン）:**
```yaml
groups:
  moderator:
    permissions:
      - notice.use
      - notice.reload
```

### メッセージの設定 (Message Configuration)

`plugins/NoticePlugin/message.yml`ファイルで全てのメッセージを変更できます：

```yaml
messages:
  # プレイヤーに送信されるお知らせメッセージ
  notice: "&a新しいお知らせが配信されました！詳細はDiscordをご覧ください"
  
  # システムメッセージ
  error-load-failed: "&cメッセージの読み込みに失敗しました"
  success-sent: "&aお知らせを送信しました！"
  reload-success: "&amessage.ymlを再読み込みしました！"
  reload-failed: "&cmessage.ymlの再読み込みに失敗しました"
  
  # プラグインライフサイクルメッセージ
  plugin-enabled: "NoticePluginが有効になりました！"
  plugin-disabled: "NoticePluginが無効になりました！"
```

#### メッセージのカスタマイズ例

**サーバーメンテナンス通知:**
```yaml
notice: "&c【重要】30分後にメンテナンスを開始します。進行状況を保存してください。"
```

**イベント告知:**
```yaml
notice: "&6&l【イベント】特別イベントが開始されました！スポーンに集合してください！"
```

**日常的な通知:**
```yaml
notice: "&e【お知らせ】おはようございます！今日も良い一日を！"
```

#### カラーコード (Color Codes)

メッセージ内で`&`に続けて文字を入力することで、テキストに色を付けることができます：

**主要な色コード:**

| コード | 色 | 例 |
|--------|------|------|
| `&0` | 黒 | `&0黒色のテキスト` |
| `&1` | 濃い青 | `&1濃い青色のテキスト` |
| `&2` | 濃い緑 | `&2濃い緑色のテキスト` |
| `&3` | 濃い水色 | `&3濃い水色のテキスト` |
| `&4` | 濃い赤 | `&4濃い赤色のテキスト` |
| `&5` | 濃い紫 | `&5濃い紫色のテキスト` |
| `&6` | 金色 | `&6金色のテキスト` |
| `&7` | 灰色 | `&7灰色のテキスト` |
| `&8` | 濃い灰色 | `&8濃い灰色のテキスト` |
| `&9` | 青 | `&9青色のテキスト` |
| `&a` | 緑 | `&a緑色のテキスト` |
| `&b` | 水色 | `&b水色のテキスト` |
| `&c` | 赤 | `&c赤色のテキスト` |
| `&d` | 明るい紫 | `&d明るい紫色のテキスト` |
| `&e` | 黄色 | `&e黄色のテキスト` |
| `&f` | 白 | `&f白色のテキスト` |

**書式コード:**

| コード | 書式 | 例 |
|--------|------|------|
| `&l` | 太字 | `&l太字のメッセージ` |
| `&m` | 取り消し線 | `&m取り消し線` |
| `&n` | 下線 | `&n下線付き` |
| `&o` | 斜体 | `&o斜体` |
| `&r` | リセット | `&r通常に戻す` |

**組み合わせ例:**
```yaml
notice: "&c&l赤色で太字のメッセージ"
notice: "&a緑色&bと水色&cと赤色"
```

## 動作環境 (Requirements)

- Minecraft 1.19.4以上
- Spigot/Bukkit API
- Java 17以上

## 変更履歴 (Changelog)

### Version 0.0.3
- コード品質の改善（IntelliJ IDEA警告の修正）
- `@NotNull`アノテーションを追加してnull安全性を向上
- コマンド登録時のNullPointerException対策を追加
- クラスを`final`にして継承を防止

### Version 0.0.2
- プラグインで使用する全てのメッセージをmessage.ymlで編集可能に変更
- エラーメッセージ、成功メッセージ、プラグイン起動/停止メッセージを追加
- MessageManagerに`getPlainMessage()`メソッドを追加（ログ出力用）
- `/noticereload`コマンドを追加（サーバー再起動不要でmessage.ymlを再読み込み）
- エラーハンドリングの改善
- ドキュメント統合（USAGE_JP.mdの内容をREADME.mdに統合）

### Version 0.0.1
- 初期リリース
- Minecraft 1.19.4対応
- Gradle ビルドシステム追加
- 単一のお知らせメッセージ機能を実装
- 全メッセージの日本語化

## トラブルシューティング (Troubleshooting)

### メッセージが表示されない

1. `message.yml`ファイルの構文が正しいか確認してください
2. インデント（空白）が正しく設定されているか確認してください
3. メッセージキーが`messages:`セクション内にあるか確認してください
4. `/noticereload`コマンドで設定を再読み込みしてください

### プラグインが起動しない

1. サーバーログでエラーを確認してください
2. Minecraftのバージョンが1.19.4以上であることを確認してください
3. Javaのバージョンが17以上であることを確認してください
4. 他のプラグインとの競合がないか確認してください

### コマンドが実行できない

1. 権限設定を確認してください（`notice.use`権限が必要）
2. プラグインが正常に有効化されているか確認してください（`/plugins`コマンドで確認）
3. コマンド名が正しいか確認してください（`/notice`、`/noticereload`）

### リロードコマンドが失敗する

1. message.ymlファイルが正しい場所にあるか確認してください（`plugins/NoticePlugin/message.yml`）
2. ファイルのYAML構文が正しいか確認してください
3. ファイルの読み取り権限があるか確認してください
4. サーバーログでエラーメッセージを確認してください

## ビルド方法 (Building)

### 必要な環境
- Java 17以上
- Maven 3.6以上 または Gradle 7.0以上

### Maven でビルド
```bash
mvn clean package
```

### Gradle でビルド（推奨）
```bash
./gradlew clean build
```

ビルドされたJARファイルは以下の場所に生成されます：
- Maven: `target/notice-plugin-0.0.3.jar`
- Gradle: `build/libs/notice-plugin-0.0.3.jar`

### IntelliJ IDEA でのビルド

1. プロジェクトフォルダを開く
2. IntelliJ IDEAが自動的にMavenまたはGradleプロジェクトとして認識
3. `Build` → `Build Project` でビルド実行

詳細は[BUILD.md](BUILD.md)を参照してください。

## 開発情報 (Development)

### プロジェクト構造
```
NoticeDeliveryBot/
├── src/
│   └── main/
│       ├── java/com/kubota6646/notice/
│       │   ├── NoticePlugin.java          # メインプラグインクラス
│       │   ├── NoticeCommand.java         # /noticeコマンド処理
│       │   ├── ReloadCommand.java         # /noticereloadコマンド処理
│       │   └── MessageManager.java        # メッセージ管理
│       └── resources/
│           ├── plugin.yml                 # プラグイン設定
│           └── message.yml                # メッセージ設定
├── pom.xml                                # Maven設定
├── build.gradle                           # Gradle設定
└── README.md                              # このファイル
```

### 使用API
- Spigot API 1.19.4-R0.1-SNAPSHOT
- Bukkit ChatColor
- Bukkit Configuration API
- JetBrains Annotations (@NotNull)

### コード品質
- IntelliJ IDEA警告のゼロ化対応
- Null安全性の保証（@NotNullアノテーション使用）
- 適切な例外処理とエラーハンドリング
- 最終クラス（final）による安全な設計

## よくある質問 (FAQ)

### Q: プラグインが動作しない
A: 以下を確認してください：
1. Minecraftバージョンが1.19.4以上であること
2. Java 17以上がインストールされていること
3. plugin.ymlがプラグインフォルダに正しく配置されていること
4. サーバーログでエラーメッセージを確認すること

### Q: メッセージが表示されない
A: `/noticereload`コマンドを実行してmessage.ymlを再読み込みしてください。また、message.ymlの構文が正しいか確認してください。

### Q: 権限設定はどうすればいいですか？
A: 権限プラグイン（LuckPermsなど）を使用して、`notice.use`および`notice.reload`権限を付与してください。デフォルトではオペレーターのみが使用可能です。

### Q: カスタムメッセージを追加できますか？
A: 現在のバージョンでは、message.ymlの既存のメッセージキーを編集することで、メッセージ内容をカスタマイズできます。新しいメッセージキーの追加は今後のバージョンで検討中です。

## サポート (Support)

問題が発生した場合やご質問がある場合は、[GitHubのIssues](https://github.com/kubota6646/NoticeDeliveryBot/issues)ページで報告してください。

## 貢献 (Contributing)

プルリクエストを歓迎します！大きな変更の場合は、まずissueを開いて変更内容を議論してください。

## ライセンス (License)

このプロジェクトのライセンスについては[LICENSE](LICENSE)ファイルを参照してください。

---

### プロジェクト情報 (Project Information)

**作成者:** kubota6646  
**現在のバージョン:** 0.0.3  
**対応Minecraftバージョン:** 1.19.4以上  
**ビルドシステム:** Maven 3.6+ / Gradle 7.0+  
**開発環境:** IntelliJ IDEA Community Edition 2025.2.4  

### リンク (Links)
- [GitHubリポジトリ](https://github.com/kubota6646/NoticeDeliveryBot)
- [Issues](https://github.com/kubota6646/NoticeDeliveryBot/issues)
- [Pull Requests](https://github.com/kubota6646/NoticeDeliveryBot/pulls)

### 技術スタック (Tech Stack)
- Java 17
- Spigot/Bukkit API 1.19.4
- Maven / Gradle
- JetBrains Annotations
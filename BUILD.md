# ビルド手順 (Build Instructions)

## 必要な環境 (Requirements)

- Java Development Kit (JDK) 17以上
- Apache Maven 3.6以上 または Gradle 7.0以上
- インターネット接続（依存関係のダウンロードのため）

## ビルド方法 (How to Build)

### 1. リポジトリのクローン

```bash
git clone https://github.com/kubota6646/NoticeDeliveryBot.git
cd NoticeDeliveryBot
```

### 2. ビルド方法の選択

このプロジェクトはMavenとGradleの両方でビルドできます。

#### 2-A. Mavenでビルド

```bash
mvn clean package
```

ビルドが成功すると、以下の場所にJARファイルが生成されます：

```
target/notice-plugin-1.0.0.jar
```

#### 2-B. Gradleでビルド

```bash
gradle clean build
```

または、Gradle Wrapperを使用（推奨）：

```bash
./gradlew clean build
```

ビルドが成功すると、以下の場所にJARファイルが生成されます：

```
build/libs/notice-plugin-1.0.0.jar
```

## ビルドの確認 (Verify Build)

ビルドが正常に完了すると、以下のようなメッセージが表示されます：

```
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
```

## トラブルシューティング (Troubleshooting)

### Maven が見つからない

Mavenがインストールされていない場合：

**Windows:**
1. https://maven.apache.org/download.cgi からダウンロード
2. 環境変数PATHに追加

**Linux/Mac:**
```bash
# Ubuntu/Debian
sudo apt-get install maven

# Mac (Homebrew)
brew install maven
```

### Gradle が見つからない

Gradleがインストールされていない場合：

**Windows:**
1. https://gradle.org/releases/ からダウンロード
2. 環境変数PATHに追加

**Linux/Mac:**
```bash
# Ubuntu/Debian
sudo apt-get install gradle

# Mac (Homebrew)
brew install gradle
```

### Spigot APIのダウンロードに失敗する

ネットワークの問題でSpigot APIがダウンロードできない場合は、以下を確認してください：

1. インターネット接続が正常か確認
2. ファイアウォールやプロキシの設定を確認
3. Maven設定ファイル（~/.m2/settings.xml）を確認

### Java のバージョンエラー

Java 17以上が必要です。バージョンを確認：

```bash
java -version
```

Java 17未満の場合は、新しいバージョンをインストールしてください：
- https://adoptium.net/ (推奨)
- https://www.oracle.com/java/technologies/downloads/

## 開発環境のセットアップ (Development Setup)

### IntelliJ IDEA (推奨)

IntelliJ IDEA Community Edition 2025.2.4以降で動作確認済みです。

#### プロジェクトを開く

1. IntelliJ IDEAを起動
2. `File` → `Open` を選択
3. プロジェクトフォルダを選択
4. ビルドシステムを選択（MavenまたはGradle）

#### Mavenプロジェクトとして開く場合

1. `pom.xml`を含むフォルダを開く
2. IntelliJ IDEAがMavenプロジェクトとして自動認識
3. 依存関係が自動的にダウンロードされます
4. ビルドは `View` → `Tool Windows` → `Maven` から実行可能

#### Gradleプロジェクトとして開く場合（推奨）

1. `build.gradle`を含むフォルダを開く
2. IntelliJ IDEAがGradleプロジェクトとして自動認識
3. Gradle Wrapperを使用して依存関係が自動的にダウンロードされます
4. ビルドは `View` → `Tool Windows` → `Gradle` から実行可能

#### IDEからビルドする

- **Maven**: Maven ツールウィンドウから `Lifecycle` → `package` を実行
- **Gradle**: Gradle ツールウィンドウから `Tasks` → `build` → `build` を実行

#### トラブルシューティング

- JDK 17が設定されていることを確認: `File` → `Project Structure` → `Project` → `SDK`
- Gradleの場合、Gradle JVMもJDK 17を使用: `Settings` → `Build, Execution, Deployment` → `Build Tools` → `Gradle` → `Gradle JVM`

### Eclipse

**Mavenの場合:**
1. プロジェクトをインポート: `File` → `Import` → `Existing Maven Projects`
2. プロジェクトフォルダを選択
3. 依存関係が自動的にダウンロードされます

**Gradleの場合:**
1. プロジェクトをインポート: `File` → `Import` → `Existing Gradle Projects`
2. プロジェクトフォルダを選択
3. 依存関係が自動的にダウンロードされます

### Visual Studio Code

1. プロジェクトフォルダを開く
2. Java Extension Pack をインストール
3. Maven for Java または Gradle for Java 拡張機能をインストール

## ビルド成果物 (Build Artifacts)

ビルドが成功すると、以下のファイルが生成されます：

**Mavenの場合:**
```
target/
├── notice-plugin-1.0.0.jar          # 最終的なプラグインファイル
├── classes/                         # コンパイル済みクラスファイル
├── maven-archiver/                  # Mavenメタデータ
└── maven-status/                    # ビルド状態
```

**Gradleの場合:**
```
build/
├── libs/
│   └── notice-plugin-1.0.0.jar      # 最終的なプラグインファイル
├── classes/                         # コンパイル済みクラスファイル
└── resources/                       # リソースファイル
```

生成された`notice-plugin-1.0.0.jar`をMinecraftサーバーの`plugins/`フォルダにコピーして使用してください。

## クリーンビルド (Clean Build)

前回のビルド成果物を削除してクリーンにビルドする場合：

```bash
mvn clean package
```

## 依存関係の確認 (Check Dependencies)

プロジェクトの依存関係を確認：

```bash
mvn dependency:tree
```

## ビルドのスキップ (Skip Tests)

テストをスキップしてビルド（このプロジェクトにはテストがありませんが）：

```bash
mvn clean package -DskipTests
```

## ライセンス (License)

このプロジェクトのライセンスについては [LICENSE](LICENSE) ファイルを参照してください。

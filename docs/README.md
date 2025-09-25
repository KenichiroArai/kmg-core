# KMG プロジェクト ドキュメント

[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)
[![Maven](https://img.shields.io/badge/Maven-3.x-blue.svg)](https://maven.apache.org/)
[![License](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)

KMG プロジェクトは、Java アプリケーション開発のための包括的なツールセットとライブラリを提供するオープンソースプロジェクトです。

## 📋 目次

- [プロジェクト概要](#-プロジェクト概要)
- [モジュール構成](#️-モジュール構成)
- [クイックスタート](#-クイックスタート)
- [ドキュメント](#-ドキュメント)
- [API リファレンス](#-api-リファレンス)
- [開発者向け情報](#-開発者向け情報)
- [ライセンス](#-ライセンス)
- [貢献について](#-貢献について)

## 🎯 プロジェクト概要

KMG プロジェクトは、Java 開発における効率化と標準化を目的として開発されたツール群です。以下の特徴を持ちます：

- **軽量設計**: 依存関係を最小限に抑えた設計
- **高品質**: 100% テストカバレッジを維持
- **標準化**: 統一されたコーディング規約とメッセージ処理
- **拡張性**: モジュール化された設計による柔軟な拡張

## 🏗️ モジュール構成

### 📦 kmg-core

Java アプリケーション開発のための基盤ライブラリです。

**主要機能:**

- 共通ユーティリティクラス群
- 基本データ型の拡張機能
- 標準化された型定義
- 汎用的なメッセージ処理

**バージョン:** 0.2.0
**詳細:** [kmg-core README](../README.md)

### 🛠️ kmg-tool

Java 開発における様々な自動化処理を提供するツール集です。

**主要機能:**

- Javadoc 関連ツール（タグ設定、行削除）
- アクセサメソッド生成ツール
- フィールド・データベース関連ツール
- コード生成ツール
- 変換・マッピングツール

**詳細:** [kmg-tool README](../kmg-tool/README.md)

### 🔧 kmg-fund

開発中の基盤ライブラリです。

**詳細:** [kmg-fund README](../kmg-fund/README.md)

## 🚀 クイックスタート

### 前提条件

- Java 21
- Maven 3.x
- Git

### インストール

```bash
# リポジトリのクローン
git clone https://github.com/your-org/DictOpeProj.git
cd DictOpeProj

# ビルド
mvn clean install
```

### 使用例

#### kmg-core の使用

```java
// ユーティリティクラスの使用例
import kmg.core.infrastructure.utils.KmgArrayUtils;
import kmg.core.infrastructure.utils.KmgListUtils;

// 配列操作
String[] array = {"item1", "item2", "item3"};
boolean isEmpty = KmgArrayUtils.isEmpty(array);

// リスト操作
List<String> list = KmgListUtils.createList("item1", "item2");
```

#### kmg-tool の使用

```bash
# Javadocタグ設定ツールの実行例
mvn exec:java -Dexec.mainClass="kmg.tool.jdts.presentation.ui.cli.JavadocTagSetterTool"
```

## 📚 ドキュメント

### 📖 操作手順書

各ツールの詳細な使用方法については、以下のドキュメントを参照してください：

| ツール名               | 説明                                                         | リンク                                                                       |
| ---------------------- | ------------------------------------------------------------ | ---------------------------------------------------------------------------- |
| Javadoc タグ設定ツール | Java ファイルの Javadoc コメントにタグを自動追加             | [操作手順書](../kmg-tool/docs/操作手順書/Javadocタグ設定ツール操作手順書.md) |
| Javadoc 行削除ツール   | 指定された行から Javadoc コメント行を削除                    | [操作手順書](../kmg-tool/docs/操作手順書/Javadoc行削除ツール操作手順書.md)   |
| アクセサ作成ツール     | フィールド定義から getter/setter メソッドを自動生成          | [操作手順書](../kmg-tool/docs/操作手順書/アクセサ作成ツール操作手順書.md)    |
| フィールド作成ツール   | データベースフィールド定義から Java フィールド宣言を自動生成 | [操作手順書](../kmg-tool/docs/操作手順書/フィールド作成ツール操作手順書.md)  |

### 🏗️ 設計書

システム設計図とアーキテクチャについては、以下のドキュメントを参照してください：

- [共通の設計図](../kmg-tool/docs/設計書/共通の設計図.md)
- [Javadoc 処理の設計図](../kmg-tool/docs/設計書/Javadoc処理の設計図.md)
- [バリデーション機能の設計図](../kmg-tool/docs/設計書/バリデーション機能の設計図.md)

### 📋 リリース情報

- [リリース手順](RELEASE.md)
- [メッセージ一覧](メッセージ一覧.xlsx)

## 📖 API リファレンス

### kmg-core API ドキュメント

- [Javadoc API リファレンス](javadoc/index.html)
- [パッケージ一覧](javadoc/allpackages-index.html)
- [クラス一覧](javadoc/allclasses-index.html)

### 主要クラス

#### ユーティリティクラス

- `KmgArrayUtils` - 配列操作
- `KmgListUtils` - リスト操作
- `KmgMapUtils` - マップ操作
- `KmgMessageUtils` - メッセージ処理
- `KmgPathUtils` - パス操作
- `KmgLocalDateUtils` - 日付操作
- `KmgLocalDateTimeUtils` - 日時操作

#### 型定義

- `KmgTemplateTypes` - テンプレート型
- `KmgDbTypes` - データベース関連型
- `KmgCharsetTypes` - 文字セット型
- `KmgTimeUnitTypes` - 時間単位型
- `KmgDelimiterTypes` - 区切り文字型
- `KmgDbDataTypeTypes` - データベースデータ型
- `JavaClassificationTypes` - Java 分類型
- `KmgJavadocTagTypes` - Javadoc タグ型
- `KmgJavaKeywordTypes` - Java キーワード型

## 👨‍💻 開発者向け情報

### 開発環境

- **Java**: 21
- **Maven**: 3.x
- **JUnit**: 5.13.4
- **Mockito**: 5.18.0
- **SLF4J**: 2.0.17

### ビルドツール

- **Maven Compiler Plugin**: 3.12.1
- **Maven Surefire Plugin**: 3.2.5（JUnit テストレポート用）
- **JaCoCo Maven Plugin**: 0.8.11（カバレッジレポート用）

### プロジェクト情報

| 項目                | 値       |
| ------------------- | -------- |
| グループ ID         | kmg.core |
| アーティファクト ID | kmg-core |
| バージョン          | 0.2.0    |
| エンコーディング    | UTF-8    |

### ビルド方法

```bash
# 全プロジェクトのビルド
mvn clean install

# テスト実行
mvn test

# カバレッジレポート生成
mvn jacoco:report
```

### 品質基準

各リリースは以下の品質基準を満たす必要があります：

- ✅ テストカバレッジ 100%
- ✅ すべてのテストが成功
- ✅ セキュリティチェックをパス
- ✅ コード品質チェックをパス

### リリースプロセス

リリースは以下の 2 つの方法で実行できます：

1. **自動リリーススクリプト**（`scripts/release.bat`）を使用
2. **手動でリリースプロセス**を実行

詳細については、[リリース手順](RELEASE.md)を参照してください。

## 📄 ライセンス

本プロジェクトは MIT ライセンスの下で公開されています。詳細は[LICENSE](../LICENSE)ファイルを参照してください。

## 🤝 貢献について

バグ報告や機能改善の提案は、GitHub の Issue を通じてお願いします。

### 貢献の方法

1. リポジトリをフォーク
2. 機能ブランチを作成（`git checkout -b feature/amazing-feature`）
3. 変更をコミット（`git commit -m 'Add some amazing feature'`）
4. ブランチにプッシュ（`git push origin feature/amazing-feature`）
5. プルリクエストを作成

### コーディング規約

- Java コーディング規約に従う
- 適切な Javadoc コメントを記述
- 単体テストを必ず作成
- テストカバレッジ 100% を維持

---

**KMG プロジェクト** - Java 開発の効率化を目指すオープンソースプロジェクト

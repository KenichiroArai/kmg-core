# kmg-core ドキュメント

[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)
[![Maven](https://img.shields.io/badge/Maven-3.x-blue.svg)](https://maven.apache.org/)
[![License](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)

kmg-core（以降は、「KMG コア」と言う。）は、KMG シリーズの Java アプリケーション開発のための基盤となるコアです。

特徴は、フレームワークなどを依存関係が少なく多くのプロジェクトで使用できるように構成されています。

## 📋 目次

- [プロジェクト概要](#-プロジェクト概要)
- [クイックスタート](#-クイックスタート)
- [ドキュメント](#-ドキュメント)
- [API リファレンス](#-api-リファレンス)
- [開発者向け情報](#-開発者向け情報)
- [ライセンス](#-ライセンス)
- [貢献について](#-貢献について)

## 🎯 プロジェクト概要

kmg-core は、Java アプリケーション開発のための基盤ライブラリです。以下の特徴を持ちます：

- **軽量設計**: 依存関係を最小限に抑えた設計
- **高品質**: 100% テストカバレッジを維持
- **標準化**: 統一されたコーディング規約とメッセージ処理
- **拡張性**: モジュール化された設計による柔軟な拡張

**主要機能:**

- 共通ユーティリティクラス群
- 基本データ型の拡張機能
- 標準化された型定義
- 汎用的なメッセージ処理

**バージョン:** 0.2.0

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

# kmg-coreのビルド
cd kmg-core
mvn clean install
```

### 使用例

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

## 📚 ドキュメント

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
# kmg-coreのビルド
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

本プロジェクトは MIT ライセンスの下で公開されています。詳細は[LICENSE](https://github.com/KenichiroArai/kmg-core/blob/main/LICENSE)ファイルを参照してください。

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

**kmg-core** - Java アプリケーション開発のための基盤ライブラリ

# kmg-core-src について

kmg-core-src（以降は、「KMGコア」と言う。）は、KMGシリーズのJavaアプリケーション開発のための基盤となるコアです。

特徴は、フレームワークなどを依存関係が少なく多くのプロジェクトで使用できるように構成されています。

## 概要

本プロジェクトは、以下の機能を提供します：

- 共通ユーティリティクラス群
- 基本データ型の拡張機能
- 標準化された型定義
- 汎用的なメッセージ処理

## プロジェクト構成

```bash
kmg-core-src/
├── src/
│   ├── main/java/kmg/core/
│   │   └── infrastructure/
│   │       ├── types/     # 型定義
│   │       └── utils/     # ユーティリティクラス
│   └── test/java/kmg/core/
│       └── infrastructure/
│           ├── types/     # 型定義のテスト
│           └── utils/     # ユーティリティクラスのテスト
├── doc/                   # ドキュメント
│   ├── RELEASE.md        # リリース手順
│   └── メッセージ一覧.xlsx  # メッセージ定義
└── pom.xml               # Maven設定ファイル
```

## 開発環境

- Java 21
- Maven 3.x
- JUnit Jupiter 5.10.2
- Apache POI 5.2.5
- Mockito 5.11.0

### ビルドツール

- Maven Compiler Plugin 3.12.1
- Maven Surefire Plugin 3.2.5（JUnitテストレポート用）
- JaCoCo Maven Plugin 0.8.11（カバレッジレポート用）

### プロジェクト情報

- グループID: kmg.core
- アーティファクトID: kmg-core
- バージョン: 1.0.0
- エンコーディング: UTF-8

## ビルド方法

```bash
mvn clean install
```

## テスト実行

```bash
mvn test
```

## リリース

リリースプロセスの詳細については、[リリース手順](doc/RELEASE.md)を参照してください。

リリースは以下の2つの方法で実行できます：

1. 自動リリーススクリプト（`scripts/release.bat`）を使用
2. 手動でリリースプロセスを実行

各リリースは以下の品質基準を満たす必要があります：
- テストカバレッジ100%
- すべてのテストが成功
- セキュリティチェックをパス

## 主要機能

### ユーティリティクラス

- `KmgArrayUtils` - 配列操作
- `KmgListUtils` - リスト操作
- `KmgMapUtils` - マップ操作
- `KmgMessageUtils` - メッセージ処理
- `KmgPathUtils` - パス操作
- `KmgPoiUtils` - Excel操作
- `KmgLocalDateUtils` - 日付操作
- `KmgLocalDateTimeUtils` - 日時操作

### 型定義

- `KmgTemplateTypes` - テンプレート型
- `KmgDbTypes` - データベース関連型
- `KmgCharsetTypes` - 文字セット型
- `KmgTimeUnitTypes` - 時間単位型
- `KmgLogMessageTypes` - ログメッセージ型
- `KmgDelimiterTypes` - 区切り文字型
- `KmgDbDataTypeTypes` - データベースデータ型

## ライセンス

本プロジェクトはLICENSEファイルに記載の条件の下で提供されています。

## 貢献について

バグ報告や機能改善の提案は、GitHubのIssueを通じてお願いします。

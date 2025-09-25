# kmg-core について

[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)
[![Maven](https://img.shields.io/badge/Maven-3.x-blue.svg)](https://maven.apache.org/)
[![License](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)

kmg-core（以降は、「KMG コア」と言う。）は、KMG シリーズの Java アプリケーション開発のための基盤となるコアです。

特徴は、フレームワークなどを依存関係が少なく多くのプロジェクトで使用できるように構成されています。

## 概要

本プロジェクトは、以下の機能を提供します：

- 共通ユーティリティクラス群
- 基本データ型の拡張機能
- 標準化された型定義
- 汎用的なメッセージ処理

## プロジェクト構成

```bash
kmg-core/
├── src/
│   ├── main/java/kmg/core/
│   │   ├── domain/
│   │   │   └── service/     # ドメインサービス
│   │   │       └── impl/   # サービス実装
│   │   └── infrastructure/
│   │       ├── cmn/         # 共通機能
│   │       ├── exception/   # 例外処理
│   │       ├── model/       # モデル
│   │       │   ├── impl/   # モデル実装
│   │       │   └── val/    # バリデーションモデル
│   │       │       └── impl/ # バリデーション実装
│   │       ├── test/        # テスト基盤
│   │       ├── type/        # 型定義
│   │       ├── types/       # 型定義（列挙型など）
│   │       │   ├── msg/    # メッセージ型
│   │       │   └── template/ # テンプレート型
│   │       └── utils/       # ユーティリティクラス
│   └── test/java/kmg/core/
│       ├── domain/
│       │   └── service/     # サービステスト
│       │       └── impl/   # 実装テスト
│       └── infrastructure/
│           ├── exception/   # 例外テスト
│           ├── model/       # モデルテスト
│           │   ├── impl/   # 実装テスト
│           │   └── val/    # バリデーションテスト
│           │       └── impl/ # バリデーション実装テスト
│           ├── test/        # テスト基盤テスト
│           ├── type/        # 型テスト
│           ├── types/       # 型定義テスト
│           │   ├── msg/    # メッセージ型テスト
│           │   └── template/ # テンプレートテスト
│           └── utils/       # ユーティリティテスト
├── doc/                     # ドキュメント
│   ├── RELEASE.md          # リリース手順
│   └── メッセージ一覧.xlsx    # メッセージ定義
└── pom.xml                 # Maven設定ファイル
```

## 開発環境

- Java 21
- Maven 3.x
- JUnit Jupiter 5.13.4
- Mockito 5.18.0
- SLF4J 2.0.17

### ビルドツール

- Maven Compiler Plugin 3.12.1
- Maven Surefire Plugin 3.2.5（JUnit テストレポート用）
- JaCoCo Maven Plugin 0.8.11（カバレッジレポート用）

### プロジェクト情報

- グループ ID: kmg.core
- アーティファクト ID: kmg-core
- バージョン: 0.2.0
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

リリースは以下の 2 つの方法で実行できます：

1. 自動リリーススクリプト（`scripts/release.bat`）を使用
2. 手動でリリースプロセスを実行

各リリースは以下の品質基準を満たす必要があります：

- テストカバレッジ 100%
- すべてのテストが成功
- セキュリティチェックをパス

## 主要機能

### ユーティリティクラス

- `KmgArrayUtils` - 配列操作
- `KmgListUtils` - リスト操作
- `KmgMapUtils` - マップ操作
- `KmgMessageUtils` - メッセージ処理
- `KmgPathUtils` - パス操作
- `KmgLocalDateUtils` - 日付操作
- `KmgLocalDateTimeUtils` - 日時操作

### 型定義

- `KmgTemplateTypes` - テンプレート型
- `KmgDbTypes` - データベース関連型
- `KmgCharsetTypes` - 文字セット型
- `KmgTimeUnitTypes` - 時間単位型
- `KmgDelimiterTypes` - 区切り文字型
- `KmgDbDataTypeTypes` - データベースデータ型
- `JavaClassificationTypes` - Java 分類型
- `KmgJavadocTagTypes` - Javadoc タグ型
- `KmgJavaKeywordTypes` - Java キーワード型

## テンプレート機能

`kmg.core.infrastructure.types.template`パッケージには、他のプロジェクトで再利用可能なテンプレートコードが含まれています。

### 使用方法

1. 必要なテンプレートコードを対象プロジェクトにコピー
2. パッケージ名を対象プロジェクトに合わせて変更
3. 必要に応じてカスタマイズ

### 提供されているテンプレート

- `KmgTemplateTypes`: 列挙型のテンプレート
  - 表示名、キー、詳細情報を持つ基本的な列挙型の実装例
  - マップによる値の管理とルックアップ機能の実装例

## メッセージ機能

`kmg.core.infrastructure.types.msg`パッケージには、アプリケーションで使用するメッセージ型が定義されています。

### 提供されているメッセージ型

- `KmgCoreGenMsgTypes`: 汎用メッセージ型
- `KmgCoreLogMsgTypes`: ログメッセージ型
- `KmgCoreValMsgTypes`: バリデーションメッセージ型

## ライセンス

本プロジェクトは LICENSE ファイルに記載の条件の下で提供されています。

## 貢献について

バグ報告や機能改善の提案は、GitHub の Issue を通じてお願いします。

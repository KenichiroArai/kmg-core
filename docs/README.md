# KMG コア（kmg-core） ドキュメント

[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)
[![Maven](https://img.shields.io/badge/Maven-3.x-blue.svg)](https://maven.apache.org/)
[![License](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)

## 📋 目次

- [クイックスタート](#-クイックスタート)
- [ドキュメント](#-ドキュメント)
- [API リファレンス](#-api-リファレンス)
- [開発者向け情報](#-開発者向け情報)

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

詳細なクラス一覧については、[Javadoc API リファレンス](javadoc/index.html)を参照してください。

## 👨‍💻 開発者向け情報

### 開発環境

- **Java**: 21
- **Maven**: 3.x
- **JUnit**: 5.13.4
- **Mockito**: 5.18.0
- **SLF4J**: 2.0.17

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

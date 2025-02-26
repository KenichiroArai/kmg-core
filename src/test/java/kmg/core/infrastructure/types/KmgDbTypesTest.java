package kmg.core.infrastructure.types;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * KMGＤＢの種類のテスト<br>
 *
 * @author KenichiroArai
 *
 * @since 0.1.0
 *
 * @version 0.1.0
 */
@SuppressWarnings({
    "nls", "static-method"
})
public class KmgDbTypesTest {

    /**
     * デフォルトコンストラクタ<br>
     *
     * @since 0.1.0
     */
    public KmgDbTypesTest() {

        // 処理なし
    }

    /**
     * get メソッドのテスト - 正常系:基本的な値の取得
     *
     * @since 0.1.0
     */
    @Test
    public void testGet_normalBasicValue() {

        /* 期待値の定義 */
        final String expected = "PostgreSQL";

        /* 準備 */
        final KmgDbTypes testType = KmgDbTypes.POSTGRE_SQL;

        /* テスト対象の実行 */
        final String actual = testType.get();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "取得値が一致しません");

    }

    /**
     * getAliasArray メソッドのテスト - 正常系:別名配列の取得
     *
     * @since 0.1.0
     */
    @Test
    public void testGetAliasArray_normalBasicArray() {

        /* 期待値の定義 */
        final String[] expected = {
            "Postgres"
        };

        /* 準備 */
        final KmgDbTypes testType = KmgDbTypes.POSTGRE_SQL;

        /* テスト対象の実行 */
        final String[] actual = testType.getAliasArray();

        /* 検証の実施 */
        Assertions.assertArrayEquals(expected, actual, "別名配列が一致しません");

    }

    /**
     * getDefault メソッドのテスト - 正常系:デフォルト値の取得
     *
     * @since 0.1.0
     */
    @Test
    public void testGetDefault_normalDefaultValue() {

        /* 期待値の定義 */
        final KmgDbTypes expected = KmgDbTypes.NONE;

        /* テスト対象の実行 */
        final KmgDbTypes actual = KmgDbTypes.getDefault();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "デフォルト値が一致しません");

    }

    /**
     * getDetail メソッドのテスト - 正常系:基本的な詳細情報の取得
     *
     * @since 0.1.0
     */
    @Test
    public void testGetDetail_normalBasicValue() {

        /* 期待値の定義 */
        final String expected = "PostgreSQL";

        /* 準備 */
        final KmgDbTypes testType = KmgDbTypes.POSTGRE_SQL;

        /* テスト対象の実行 */
        final String actual = testType.getDetail();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "詳細情報が一致しません");

    }

    /**
     * getDisplayName メソッドのテスト - 正常系:基本的な表示名の取得
     *
     * @since 0.1.0
     */
    @Test
    public void testGetDisplayName_normalBasicValue() {

        /* 期待値の定義 */
        final String expected = "PostgreSQL";

        /* 準備 */
        final KmgDbTypes testType = KmgDbTypes.POSTGRE_SQL;

        /* テスト対象の実行 */
        final String actual = testType.getDisplayName();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "表示名が一致しません");

    }

    /**
     * getEnum メソッドのテスト - 正常系:存在する値の取得
     *
     * @since 0.1.0
     */
    @Test
    public void testGetEnum_normalExistingValue() {

        /* 期待値の定義 */
        final KmgDbTypes expected = KmgDbTypes.POSTGRE_SQL;

        /* 準備 */
        final String testValue = "PostgreSQL";

        /* テスト対象の実行 */
        final KmgDbTypes actual = KmgDbTypes.getEnum(testValue);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "値が一致しません");

    }

    /**
     * getEnum メソッドのテスト - 準正常系:存在しない値の取得
     *
     * @since 0.1.0
     */
    @Test
    public void testGetEnum_semiNonExistingValue() {

        /* 期待値の定義 */
        final KmgDbTypes expected = KmgDbTypes.NONE;

        /* 準備 */
        final String testValue = "INVALID";

        /* テスト対象の実行 */
        final KmgDbTypes actual = KmgDbTypes.getEnum(testValue);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "値が一致しません");

    }

    /**
     * getEnum メソッドのテスト - 準正常系:nullの場合の取得
     *
     * @since 0.1.0
     */
    @Test
    public void testGetEnum_semiNullValue() {

        /* 期待値の定義 */
        final KmgDbTypes expected = KmgDbTypes.NONE;

        /* 準備 */
        final String testValue = null;

        /* テスト対象の実行 */
        final KmgDbTypes actual = KmgDbTypes.getEnum(testValue);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "nullの場合、NONEが返されること");

    }

    /**
     * getEnumByTarget メソッドのテスト - 正常系:別名による検索
     *
     * @since 0.1.0
     */
    @Test
    public void testGetEnumByTarget_normalByAlias() {

        /* 期待値の定義 */
        final KmgDbTypes expected = KmgDbTypes.POSTGRE_SQL;

        /* 準備 */
        final String testTarget = "Postgres";

        /* テスト対象の実行 */
        final KmgDbTypes actual = KmgDbTypes.getEnumByTarget(testTarget);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "別名による検索結果が一致しません");

    }

    /**
     * getEnumByTarget メソッドのテスト - 正常系:値による検索
     *
     * @since 0.1.0
     */
    @Test
    public void testGetEnumByTarget_normalByValue() {

        /* 期待値の定義 */
        final KmgDbTypes expected = KmgDbTypes.POSTGRE_SQL;

        /* 準備 */
        final String testTarget = "PostgreSQL";

        /* テスト対象の実行 */
        final KmgDbTypes actual = KmgDbTypes.getEnumByTarget(testTarget);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "値による検索結果が一致しません");

    }

    /**
     * getEnumByTarget メソッドのテスト - 正常系:大文字小文字を区別しない比較
     *
     * @since 0.1.0
     */
    @Test
    public void testGetEnumByTarget_normalCaseInsensitive() {

        /* 期待値の定義 */
        final KmgDbTypes expected = KmgDbTypes.POSTGRE_SQL;

        /* 準備 */
        final String testTarget = "postgres";

        /* テスト対象の実行 */
        final KmgDbTypes actual = KmgDbTypes.getEnumByTarget(testTarget);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "大文字小文字を区別しない比較での検索結果が一致しません");

    }

    /**
     * getEnumByTarget メソッドのテスト - 正常系:別名が存在しない場合の検索
     *
     * @since 0.1.0
     */
    @Test
    public void testGetEnumByTarget_normalNoAlias() {

        /* 期待値の定義 */
        final KmgDbTypes expected = KmgDbTypes.MYSQL;

        /* 準備 */
        final String testTarget = "MySQL";

        /* テスト対象の実行 */
        final KmgDbTypes actual = KmgDbTypes.getEnumByTarget(testTarget);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "別名が存在しない場合の検索結果が一致しません");

    }

    /**
     * getEnumByTarget メソッドのテスト - 正常系:値の大文字小文字を区別しない比較
     *
     * @since 0.1.0
     */
    @Test
    public void testGetEnumByTarget_normalValueIgnoreCase() {

        /* 期待値の定義 */
        final KmgDbTypes expected = KmgDbTypes.POSTGRE_SQL;

        /* 準備 */
        final String testTarget = "postgresql";

        /* テスト対象の実行 */
        final KmgDbTypes actual = KmgDbTypes.getEnumByTarget(testTarget);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "値の大文字小文字を区別しない比較での検索結果が一致しません");

    }

    /**
     * getEnumByTarget メソッドのテスト - 準正常系:別名が一致しない場合の取得
     *
     * @since 0.1.0
     */
    @Test
    public void testGetEnumByTarget_semiAliasNotMatch() {

        /* 期待値の定義 */
        final KmgDbTypes expected = KmgDbTypes.NONE;

        /* 準備 */
        final String testTarget = "NotMatchingAlias";

        /* テスト対象の実行 */
        final KmgDbTypes actual = KmgDbTypes.getEnumByTarget(testTarget);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "別名が一致しない場合の検索結果が一致しません");

    }

    /**
     * getEnumByTarget メソッドのテスト - 準正常系:存在しない対象の検索
     *
     * @since 0.1.0
     */
    @Test
    public void testGetEnumByTarget_semiNonExistingTarget() {

        /* 期待値の定義 */
        final KmgDbTypes expected = KmgDbTypes.NONE;

        /* 準備 */
        final String testTarget = "NonExistingDB";

        /* テスト対象の実行 */
        final KmgDbTypes actual = KmgDbTypes.getEnumByTarget(testTarget);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "存在しない対象の場合の検索結果が一致しません");

    }

    /**
     * getInitValue メソッドのテスト - 正常系:初期値の取得
     *
     * @since 0.1.0
     */
    @Test
    public void testGetInitValue_normalBasicValue() {

        /* 期待値の定義 */
        final KmgDbTypes expected = KmgDbTypes.NONE;

        /* テスト対象の実行 */
        final KmgDbTypes actual = KmgDbTypes.getInitValue();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "初期値が一致しません");

    }

    /**
     * toString メソッドのテスト - 正常系:MySQLの文字列表現
     *
     * @since 0.1.0
     */
    @Test
    public void testToString_normalMysql() {

        /* 期待値の定義 */
        final String expected = "MySQL";

        /* 準備 */
        final KmgDbTypes testType = KmgDbTypes.MYSQL;

        /* テスト対象の実行 */
        final String actual = testType.toString();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "MySQLの場合、'MySQL'が返されること");

    }

    /**
     * toString メソッドのテスト - 正常系:NONEの文字列表現
     *
     * @since 0.1.0
     */
    @Test
    public void testToString_normalNone() {

        /* 期待値の定義 */
        final String expected = null;

        /* 準備 */
        final KmgDbTypes testType = KmgDbTypes.NONE;

        /* テスト対象の実行 */
        final String actual = testType.toString();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "NONEの場合、nullが返されること");

    }

    /**
     * toString メソッドのテスト - 正常系:PostgreSQLの文字列表現
     *
     * @since 0.1.0
     */
    @Test
    public void testToString_normalPostgresql() {

        /* 期待値の定義 */
        final String expected = "PostgreSQL";

        /* 準備 */
        final KmgDbTypes testType = KmgDbTypes.POSTGRE_SQL;

        /* テスト対象の実行 */
        final String actual = testType.toString();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "PostgreSQLの場合、'PostgreSQL'が返されること");

    }
}

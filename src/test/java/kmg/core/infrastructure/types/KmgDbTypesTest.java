package kmg.core.infrastructure.types;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * KMGＤＢの種類のテスト<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
@SuppressWarnings({
    "nls", "static-method"
})
public class KmgDbTypesTest {

    /**
     * get メソッドのテスト
     */
    @Test
    public void testGet() {

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
     * getAliasArray メソッドのテスト
     */
    @Test
    public void testGetAliasArray() {

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
     * getDefault メソッドのテスト
     */
    @Test
    public void testGetDefault() {

        /* 期待値の定義 */
        final KmgDbTypes expected = KmgDbTypes.NONE;

        /* テスト対象の実行 */
        final KmgDbTypes actual = KmgDbTypes.getDefault();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "デフォルト値が一致しません");

    }

    /**
     * getEnum メソッドのテスト - 存在する値の場合
     */
    @Test
    public void testGetEnum_existingValue() {

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
     * getEnum メソッドのテスト - 存在しない値の場合
     */
    @Test
    public void testGetEnum_nonExistingValue() {

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
     * getEnumByTarget メソッドのテスト - 別名が一致しない場合
     */
    @Test
    public void testGetEnumByTarget_aliasNotMatch() {

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
     * getEnumByTarget メソッドのテスト - 別名で検索する場合
     */
    @Test
    public void testGetEnumByTarget_byAlias() {

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
     * getEnumByTarget メソッドのテスト - 値で検索する場合
     */
    @Test
    public void testGetEnumByTarget_byValue() {

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
     * getInitValue メソッドのテスト
     */
    @Test
    public void testGetInitValue() {

        /* 期待値の定義 */
        final KmgDbTypes expected = KmgDbTypes.NONE;

        /* テスト対象の実行 */
        final KmgDbTypes actual = KmgDbTypes.getInitValue();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "初期値が一致しません");

    }

    /**
     * getName メソッドのテスト
     */
    @Test
    public void testGetName() {

        /* 期待値の定義 */
        final String expected = "PostgreSQL";

        /* 準備 */
        final KmgDbTypes testType = KmgDbTypes.POSTGRE_SQL;

        /* テスト対象の実行 */
        final String actual = testType.getName();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "名称が一致しません");

    }

    /**
     * getValue メソッドのテスト
     */
    @Test
    public void testGetValue() {

        /* 期待値の定義 */
        final String expected = "PostgreSQL";

        /* 準備 */
        final KmgDbTypes testType = KmgDbTypes.POSTGRE_SQL;

        /* テスト対象の実行 */
        final String actual = testType.getValue();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "値が一致しません");

    }

    /**
     * toString メソッドのテスト - MySQLの場合
     */
    @Test
    public void testToString_mysql() {

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
     * toString メソッドのテスト - NONEの場合
     */
    @Test
    public void testToString_none() {

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
     * toString メソッドのテスト - PostgreSQLの場合
     */
    @Test
    public void testToString_postgresql() {

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

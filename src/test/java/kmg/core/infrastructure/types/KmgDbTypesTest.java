package kmg.core.infrastructure.types;

import java.util.Arrays;
import java.util.List;

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
     * join メソッドのテスト - リストを結合する場合
     */
    @Test
    public void testJoin_list() {

        /* 期待値の定義 */
        final String expected = "test1,test2,test3";

        /* 準備 */
        final KmgDbTypes   testType = KmgDbTypes.MYSQL;
        final List<String> testList = Arrays.asList("test1", "test2", "test3");

        /* テスト対象の実行 */
        final String actual = testType.join(testList);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "リストの結合結果が一致しません");

    }

    /**
     * join メソッドのテスト - 可変長引数を結合する場合
     */
    @Test
    public void testJoin_varargs() {

        /* 期待値の定義 */
        final String expected = "test1,test2,test3";

        /* 準備 */
        final KmgDbTypes testType = KmgDbTypes.MYSQL;

        /* テスト対象の実行 */
        final String actual = testType.join("test1", "test2", "test3");

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "可変長引数の結合結果が一致しません");

    }

    /**
     * split メソッドのテスト
     */
    @Test
    public void testSplit() {

        /* 期待値の定義 */
        final String[] expected = {
            "test1", "test2", "test3"
        };

        /* 準備 */
        final KmgDbTypes testType   = KmgDbTypes.MYSQL;
        final String     testString = "test1,test2,test3";

        /* テスト対象の実行 */
        final String[] actual = testType.split(testString);

        /* 検証の実施 */
        Assertions.assertArrayEquals(expected, actual, "分割結果が一致しません");

    }

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
}

package kmg.core.infrastructure.types;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import kmg.core.infrastructure.type.KmgString;

/**
 * KMG区切り文字の種類のテスト<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
@SuppressWarnings({
    "nls", "static-method"
})
public class KmgDelimiterTypesTest {

    /**
     * get メソッドのテスト
     */
    @Test
    public void testGet() {

        /* 期待値の定義 */
        final String expected = ",";

        /* 準備 */
        final KmgDelimiterTypes testType = KmgDelimiterTypes.COMMA;

        /* テスト対象の実行 */
        final String actual = testType.get();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "取得値が一致しません");

    }

    /**
     * getDefault メソッドのテスト
     */
    @Test
    public void testGetDefault() {

        /* 期待値の定義 */
        final KmgDelimiterTypes expected = KmgDelimiterTypes.NONE;

        /* テスト対象の実行 */
        final KmgDelimiterTypes actual = KmgDelimiterTypes.getDefault();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "デフォルト値が一致しません");

    }

    /**
     * getEnum メソッドのテスト - 存在する値の場合
     */
    @Test
    public void testGetEnum_existingValue() {

        /* 期待値の定義 */
        final KmgDelimiterTypes expected = KmgDelimiterTypes.COMMA;

        /* 準備 */
        final String testValue = ",";

        /* テスト対象の実行 */
        final KmgDelimiterTypes actual = KmgDelimiterTypes.getEnum(testValue);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "値が一致しません");

    }

    /**
     * getEnum メソッドのテスト - 存在しない値の場合
     */
    @Test
    public void testGetEnum_nonExistingValue() {

        /* 期待値の定義 */
        final KmgDelimiterTypes expected = KmgDelimiterTypes.NONE;

        /* 準備 */
        final String testValue = "INVALID";

        /* テスト対象の実行 */
        final KmgDelimiterTypes actual = KmgDelimiterTypes.getEnum(testValue);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "値が一致しません");

    }

    /**
     * getInitValue メソッドのテスト
     */
    @Test
    public void testGetInitValue() {

        /* 期待値の定義 */
        final KmgDelimiterTypes expected = KmgDelimiterTypes.NONE;

        /* テスト対象の実行 */
        final KmgDelimiterTypes actual = KmgDelimiterTypes.getInitValue();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "初期値が一致しません");

    }

    /**
     * getName メソッドのテスト
     */
    @Test
    public void testGetName() {

        /* 期待値の定義 */
        final String expected = "カンマ";

        /* 準備 */
        final KmgDelimiterTypes testType = KmgDelimiterTypes.COMMA;

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
        final String expected = ",";

        /* 準備 */
        final KmgDelimiterTypes testType = KmgDelimiterTypes.COMMA;

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
        final KmgDelimiterTypes testType = KmgDelimiterTypes.COMMA;
        final List<String>      testList = Arrays.asList("test1", "test2", "test3");

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
        final KmgDelimiterTypes testType = KmgDelimiterTypes.COMMA;

        /* テスト対象の実行 */
        final String actual = testType.join("test1", "test2", "test3");

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "可変長引数の結合結果が一致しません");

    }

    /**
     * joinAll メソッドのテスト - リストを結合する場合
     */
    @Test
    public void testJoinAll_list() {

        /* 期待値の定義 */
        final String expected = "test1,null,test3";

        /* 準備 */
        final KmgDelimiterTypes testType = KmgDelimiterTypes.COMMA;
        final List<String>      testList = Arrays.asList("test1", null, "test3");

        /* テスト対象の実行 */
        final String actual = testType.joinAll(testList);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "リストの結合結果が一致しません");

    }

    /**
     * joinAll メソッドのテスト - 可変長引数を結合する場合
     */
    @Test
    public void testJoinAll_varargs() {

        /* 期待値の定義 */
        final String expected = "test1,null,test3";

        /* 準備 */
        final KmgDelimiterTypes testType = KmgDelimiterTypes.COMMA;

        /* テスト対象の実行 */
        final String actual = testType.joinAll("test1", null, "test3");

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "可変長引数の結合結果が一致しません");

    }

    /**
     * split メソッドのテスト - 空文字の場合
     */
    @Test
    public void testSplit_empty() {

        /* 期待値の定義 */
        final String[] expected = null;

        /* 準備 */
        final KmgDelimiterTypes testType   = KmgDelimiterTypes.COMMA;
        final String            testString = KmgString.EMPTY;

        /* テスト対象の実行 */
        final String[] actual = testType.split(testString);

        /* 検証の実施 */
        Assertions.assertArrayEquals(expected, actual, "空文字の分割結果が一致しません");

    }

    /**
     * split メソッドのテスト - 通常の場合
     */
    @Test
    public void testSplit_normal() {

        /* 期待値の定義 */
        final String[] expected = {
            "test1", "test2", "test3"
        };

        /* 準備 */
        final KmgDelimiterTypes testType   = KmgDelimiterTypes.COMMA;
        final String            testString = "test1,test2,test3";

        /* テスト対象の実行 */
        final String[] actual = testType.split(testString);

        /* 検証の実施 */
        Assertions.assertArrayEquals(expected, actual, "分割結果が一致しません");

    }
}

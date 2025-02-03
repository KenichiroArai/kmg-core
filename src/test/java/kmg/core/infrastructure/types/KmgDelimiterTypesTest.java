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
     * join メソッドのテスト - 空文字を含む可変長引数を結合する場合
     */
    @Test
    public void testJoin_varargs_withEmpty() {

        /* 期待値の定義 */
        final String expected = "test1,test3";

        /* 準備 */
        final KmgDelimiterTypes testType = KmgDelimiterTypes.COMMA;

        /* テスト対象の実行 */
        final String actual = testType.join("test1", "", "test3");

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "空文字を含む可変長引数の結合結果が一致しません");

    }

    /**
     * join メソッドのテスト - nullを含む可変長引数を結合する場合
     */
    @Test
    public void testJoin_varargs_withNull() {

        /* 期待値の定義 */
        final String expected = "test1,test3";

        /* 準備 */
        final KmgDelimiterTypes testType = KmgDelimiterTypes.COMMA;

        /* テスト対象の実行 */
        final String actual = testType.join("test1", null, "test3");

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "nullを含む可変長引数の結合結果が一致しません");

    }

    /**
     * join メソッドのテスト - リストを結合する場合
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
     * join メソッドのテスト - 可変長引数を結合する場合
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

    /**
     * split メソッドのテスト - 制限付きの場合
     */
    @Test
    public void testSplit_withLimit() {

        /* 期待値の定義 */
        final String[] expected = {
            "test1", "test2,test3"
        };

        /* 準備 */
        final KmgDelimiterTypes testType   = KmgDelimiterTypes.COMMA;
        final String            testString = "test1,test2,test3";
        final int               testLimit  = 2;

        /* テスト対象の実行 */
        final String[] actual = testType.split(testString, testLimit);

        /* 検証の実施 */
        Assertions.assertArrayEquals(expected, actual, "制限付き分割結果が一致しません");

    }

    /**
     * split メソッドのテスト - 制限付き、空文字の場合
     */
    @Test
    public void testSplit_withLimit_empty() {

        /* 期待値の定義 */
        final String[] expected = null;

        /* 準備 */
        final KmgDelimiterTypes testType   = KmgDelimiterTypes.COMMA;
        final String            testString = KmgString.EMPTY;
        final int               testLimit  = 2;

        /* テスト対象の実行 */
        final String[] actual = testType.split(testString, testLimit);

        /* 検証の実施 */
        Assertions.assertArrayEquals(expected, actual, "空文字の制限付き分割結果が一致しません");

    }

    /**
     * split メソッドのテスト - 制限が文字列の分割数より大きい場合
     */
    @Test
    public void testSplit_withLimit_largerLimit() {

        /* 期待値の定義 */
        final String[] expected = {
            "test1", "test2", "test3"
        };

        /* 準備 */
        final KmgDelimiterTypes testType   = KmgDelimiterTypes.COMMA;
        final String            testString = "test1,test2,test3";
        final int               testLimit  = 5;

        /* テスト対象の実行 */
        final String[] actual = testType.split(testString, testLimit);

        /* 検証の実施 */
        Assertions.assertArrayEquals(expected, actual, "制限が大きい場合の分割結果が一致しません");

    }

    /**
     * toString メソッドのテスト - HALF_SPACEの場合
     */
    @Test
    public void testToString_halfSpace() {

        /* 期待値の定義 */
        final String expected = KmgString.HALF_SPACE;

        /* 準備 */
        final KmgDelimiterTypes testType = KmgDelimiterTypes.HALF_SPACE;

        /* テスト対象の実行 */
        final String actual = testType.toString();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "HALF_SPACEの場合、半角スペースが返されること");

    }

    /**
     * toString メソッドのテスト - NONEの場合
     */
    @Test
    public void testToString_none() {

        /* 期待値の定義 */
        final String expected = null;

        /* 準備 */
        final KmgDelimiterTypes testType = KmgDelimiterTypes.NONE;

        /* テスト対象の実行 */
        final String actual = testType.toString();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "NONEの場合、nullが返されること");

    }

    /**
     * toString メソッドのテスト - PERIODの場合
     */
    @Test
    public void testToString_period() {

        /* 期待値の定義 */
        final String expected = ".";

        /* 準備 */
        final KmgDelimiterTypes testType = KmgDelimiterTypes.PERIOD;

        /* テスト対象の実行 */
        final String actual = testType.toString();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "PERIODの場合、'.'が返されること");

    }
}

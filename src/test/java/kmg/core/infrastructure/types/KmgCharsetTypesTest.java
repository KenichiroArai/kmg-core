package kmg.core.infrastructure.types;

import java.nio.charset.Charset;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * KMG文字セットの種類のテスト<br>
 *
 * @author KenichiroArai
 *
 * @sine 1.0.0
 *
 * @version 1.0.0
 */
@SuppressWarnings({
    "nls", "static-method"
})
public class KmgCharsetTypesTest {

    /**
     * get メソッドのテスト - 正常系：UTF-8の値を取得する場合
     */
    @Test
    public void testGet_normalGetUtf8Value() {

        /* 期待値の定義 */
        final String expected = "UTF-8";

        /* 準備 */
        final KmgCharsetTypes testType = KmgCharsetTypes.UTF8;

        /* テスト対象の実行 */
        final String actual = testType.get();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "値が一致しません");

    }

    /**
     * getDefault メソッドのテスト - 正常系：デフォルト値を取得する場合
     */
    @Test
    public void testGetDefault_normalGetDefaultValue() {

        /* 期待値の定義 */
        final KmgCharsetTypes expected = KmgCharsetTypes.NONE;

        /* テスト対象の実行 */
        final KmgCharsetTypes actual = KmgCharsetTypes.getDefault();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "デフォルト値が一致しません");

    }

    /**
     * getDisplayName メソッドのテスト - 正常系：UTF-8の名称を取得する場合
     */
    @Test
    public void testGetDisplayName_normalGetUtf8Name() {

        /* 期待値の定義 */
        final String expected = "UTF-8";

        /* 準備 */
        final KmgCharsetTypes testType = KmgCharsetTypes.UTF8;

        /* テスト対象の実行 */
        final String actual = testType.getDisplayName();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "名称が一致しません");

    }

    /**
     * getEnum メソッドのテスト - 正常系：存在する値を取得する場合
     */
    @Test
    public void testGetEnum_normalGetExistingValue() {

        /* 期待値の定義 */
        final KmgCharsetTypes expected = KmgCharsetTypes.UTF8;

        /* 準備 */
        final String testValue = "UTF-8";

        /* テスト対象の実行 */
        final KmgCharsetTypes actual = KmgCharsetTypes.getEnum(testValue);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "値が一致しません");

    }

    /**
     * getEnum メソッドのテスト - 準正常系：存在しない値を取得する場合
     */
    @Test
    public void testGetEnum_semiGetNonExistingValue() {

        /* 期待値の定義 */
        final KmgCharsetTypes expected = KmgCharsetTypes.NONE;

        /* 準備 */
        final String testValue = "INVALID";

        /* テスト対象の実行 */
        final KmgCharsetTypes actual = KmgCharsetTypes.getEnum(testValue);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "値が一致しません");

    }

    /**
     * getInitValue メソッドのテスト - 正常系：初期値を取得する場合
     */
    @Test
    public void testGetInitValue_normalGetInitialValue() {

        /* 期待値の定義 */
        final KmgCharsetTypes expected = KmgCharsetTypes.NONE;

        /* テスト対象の実行 */
        final KmgCharsetTypes actual = KmgCharsetTypes.getInitValue();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "初期値が一致しません");

    }

    /**
     * toCharset メソッドのテスト - 正常系：有効な文字セットの場合
     */
    @Test
    public void testToCharset_normalValidCharset() {

        /* 期待値の定義 */
        final Charset expected = Charset.forName("UTF-8");

        /* 準備 */
        final KmgCharsetTypes testType = KmgCharsetTypes.UTF8;

        /* テスト対象の実行 */
        final Charset actual = testType.toCharset();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "文字セットが一致しません");

    }

    /**
     * toCharset メソッドのテスト - 準正常系：NONEの場合
     */
    @Test
    public void testToCharset_semiNone() {

        /* 期待値の定義 */
        final Charset expected = null;

        /* 準備 */
        final KmgCharsetTypes testType = KmgCharsetTypes.NONE;

        /* テスト対象の実行 */
        final Charset actual = testType.toCharset();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "NONEの文字セットがnullではありません");

    }

    /**
     * toString メソッドのテスト - 正常系：MS932の場合
     */
    @Test
    public void testToString_normalMs932() {

        /* 期待値の定義 */
        final String expected = "MS932";

        /* 準備 */
        final KmgCharsetTypes testType = KmgCharsetTypes.MS932;

        /* テスト対象の実行 */
        final String actual = testType.toString();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "MS932の場合、'MS932'が返されること");

    }

    /**
     * toString メソッドのテスト - 正常系：UTF8の場合
     */
    @Test
    public void testToString_normalUtf8() {

        /* 期待値の定義 */
        final String expected = "UTF-8";

        /* 準備 */
        final KmgCharsetTypes testType = KmgCharsetTypes.UTF8;

        /* テスト対象の実行 */
        final String actual = testType.toString();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "UTF8の場合、'UTF-8'が返されること");

    }

    /**
     * toString メソッドのテスト - 準正常系：NONEの場合
     */
    @Test
    public void testToString_semiNone() {

        /* 期待値の定義 */
        final String expected = null;

        /* 準備 */
        final KmgCharsetTypes testType = KmgCharsetTypes.NONE;

        /* テスト対象の実行 */
        final String actual = testType.toString();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "NONEの場合、nullが返されること");

    }

    /**
     * getDetail メソッドのテスト - 正常系：UTF-8の詳細情報を取得する場合
     */
    @Test
    public void testGetDetail_normalGetUtf8Detail() {

        /* 期待値の定義 */
        final String expected = "UTF-8";

        /* 準備 */
        final KmgCharsetTypes testType = KmgCharsetTypes.UTF8;

        /* テスト対象の実行 */
        final String actual = testType.getDetail();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "詳細情報が一致しません");

    }

    /**
     * getDetail メソッドのテスト - 正常系：MS932の詳細情報を取得する場合
     */
    @Test
    public void testGetDetail_normalGetMs932Detail() {

        /* 期待値の定義 */
        final String expected = "MS932";

        /* 準備 */
        final KmgCharsetTypes testType = KmgCharsetTypes.MS932;

        /* テスト対象の実行 */
        final String actual = testType.getDetail();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "詳細情報が一致しません");

    }

    /**
     * getDetail メソッドのテスト - 準正常系：NONEの詳細情報を取得する場合
     */
    @Test
    public void testGetDetail_semiGetNoneDetail() {

        /* 期待値の定義 */
        final String expected = "指定無し";

        /* 準備 */
        final KmgCharsetTypes testType = KmgCharsetTypes.NONE;

        /* テスト対象の実行 */
        final String actual = testType.getDetail();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "詳細情報が一致しません");

    }
}

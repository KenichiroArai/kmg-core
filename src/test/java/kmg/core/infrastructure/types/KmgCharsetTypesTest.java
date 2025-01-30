package kmg.core.infrastructure.types;

import java.nio.charset.Charset;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * KMG文字セットの種類のテスト<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
@SuppressWarnings({
    "nls", "static-method"
})
public class KmgCharsetTypesTest {

    /**
     * get メソッドのテスト
     */
    @Test
    public void testGet() {

        /* 期待値の定義 */
        final String expected = "UTF-8";

        /* 準備 */
        final KmgCharsetTypes testType = KmgCharsetTypes.UTF8;

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
        final KmgCharsetTypes expected = KmgCharsetTypes.NONE;

        /* テスト対象の実行 */
        final KmgCharsetTypes actual = KmgCharsetTypes.getDefault();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "デフォルト値が一致しません");

    }

    /**
     * getEnum メソッドのテスト - 存在する値の場合
     */
    @Test
    public void testGetEnum_existingValue() {

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
     * getEnum メソッドのテスト - 存在しない値の場合
     */
    @Test
    public void testGetEnum_nonExistingValue() {

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
     * getInitValue メソッドのテスト
     */
    @Test
    public void testGetInitValue() {

        /* 期待値の定義 */
        final KmgCharsetTypes expected = KmgCharsetTypes.NONE;

        /* テスト対象の実行 */
        final KmgCharsetTypes actual = KmgCharsetTypes.getInitValue();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "初期値が一致しません");

    }

    /**
     * getName メソッドのテスト
     */
    @Test
    public void testGetName() {

        /* 期待値の定義 */
        final String expected = "UTF-8";

        /* 準備 */
        final KmgCharsetTypes testType = KmgCharsetTypes.UTF8;

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
        final String expected = "UTF-8";

        /* 準備 */
        final KmgCharsetTypes testType = KmgCharsetTypes.UTF8;

        /* テスト対象の実行 */
        final String actual = testType.getValue();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "値が一致しません");

    }

    /**
     * toCharset メソッドのテスト - NONEの場合
     */
    @Test
    public void testToCharset_none() {

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
     * toCharset メソッドのテスト - 有効な文字セットの場合
     */
    @Test
    public void testToCharset_validCharset() {

        /* 期待値の定義 */
        final Charset expected = Charset.forName("UTF-8");

        /* 準備 */
        final KmgCharsetTypes testType = KmgCharsetTypes.UTF8;

        /* テスト対象の実行 */
        final Charset actual = testType.toCharset();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "文字セットが一致しません");

    }
}

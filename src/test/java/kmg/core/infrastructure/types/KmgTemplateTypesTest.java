package kmg.core.infrastructure.types;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * KMGテンプレートの種類のテスト<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
@SuppressWarnings({
    "nls", "static-method"
})
public class KmgTemplateTypesTest {

    /**
     * get メソッドのテスト
     */
    @Test
    public void testGet() {

        /* 期待値の定義 */
        final String expected = null;

        /* 準備 */
        final KmgTemplateTypes testType = KmgTemplateTypes.NONE;

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
        final KmgTemplateTypes expected = KmgTemplateTypes.NONE;

        /* テスト対象の実行 */
        final KmgTemplateTypes actual = KmgTemplateTypes.getDefault();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "デフォルト値が一致しません");

    }

    /**
     * getEnum メソッドのテスト - 存在しない値の場合
     */
    @Test
    public void testGetEnum_nonExistingValue() {

        /* 期待値の定義 */
        final KmgTemplateTypes expected = KmgTemplateTypes.NONE;

        /* 準備 */
        final String testValue = "INVALID";

        /* テスト対象の実行 */
        final KmgTemplateTypes actual = KmgTemplateTypes.getEnum(testValue);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "値が一致しません");

    }

    /**
     * getInitValue メソッドのテスト
     */
    @Test
    public void testGetInitValue() {

        /* 期待値の定義 */
        final KmgTemplateTypes expected = KmgTemplateTypes.NONE;

        /* テスト対象の実行 */
        final KmgTemplateTypes actual = KmgTemplateTypes.getInitValue();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "初期値が一致しません");

    }

    /**
     * getName メソッドのテスト
     */
    @Test
    public void testGetName() {

        /* 期待値の定義 */
        final String expected = "指定無し";

        /* 準備 */
        final KmgTemplateTypes testType = KmgTemplateTypes.NONE;

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
        final String expected = null;

        /* 準備 */
        final KmgTemplateTypes testType = KmgTemplateTypes.NONE;

        /* テスト対象の実行 */
        final String actual = testType.getValue();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "値が一致しません");

    }

    /**
     * toString メソッドのテスト - NONEの場合
     */
    @Test
    public void testToString_none() {

        /* 期待値の定義 */
        final String expected = null;

        /* 準備 */
        final KmgTemplateTypes testType = KmgTemplateTypes.NONE;

        /* テスト対象の実行 */
        final String actual = testType.toString();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "NONEの場合、nullが返されること");

    }
}

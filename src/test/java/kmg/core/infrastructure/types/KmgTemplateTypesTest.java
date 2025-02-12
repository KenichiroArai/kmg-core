package kmg.core.infrastructure.types;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * KMGテンプレートの種類のテスト<br>
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
public class KmgTemplateTypesTest {

    /**
     * get メソッドのテスト - 正常系:基本的な値の取得
     */
    @Test
    public void testGet_normalBasicValue() {

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
     * getDefault メソッドのテスト - 正常系:デフォルト値の取得
     */
    @Test
    public void testGetDefault_normalDefaultValue() {

        /* 期待値の定義 */
        final KmgTemplateTypes expected = KmgTemplateTypes.NONE;

        /* テスト対象の実行 */
        final KmgTemplateTypes actual = KmgTemplateTypes.getDefault();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "デフォルト値が一致しません");

    }

    /**
     * getEnum メソッドのテスト - 準正常系:存在しない値の取得
     */
    @Test
    public void testGetEnum_semiNonExistingValue() {

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
     * getEnum メソッドのテスト - 準正常系:null値の取得
     */
    @Test
    public void testGetEnum_semiNullValue() {

        /* 期待値の定義 */
        final KmgTemplateTypes expected = KmgTemplateTypes.NONE;

        /* 準備 */
        final String testValue = null;

        /* テスト対象の実行 */
        final KmgTemplateTypes actual = KmgTemplateTypes.getEnum(testValue);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "null値の場合、NONEが返されること");

    }

    /**
     * getInitValue メソッドのテスト - 正常系:初期値の取得
     */
    @Test
    public void testGetInitValue_normalInitialValue() {

        /* 期待値の定義 */
        final KmgTemplateTypes expected = KmgTemplateTypes.NONE;

        /* テスト対象の実行 */
        final KmgTemplateTypes actual = KmgTemplateTypes.getInitValue();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "初期値が一致しません");

    }

    /**
     * getName メソッドのテスト - 正常系:名前の取得
     */
    @Test
    public void testGetName_normalBasicName() {

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
     * getValue メソッドのテスト - 正常系:値の取得
     */
    @Test
    public void testGetValue_normalBasicValue() {

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
     * toString メソッドのテスト - 正常系:NONEの文字列表現
     */
    @Test
    public void testToString_normalNone() {

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

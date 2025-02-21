package kmg.core.infrastructure.types;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * KMGメッセージメッセージの種類のテスト<br>
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
public class KmgMsgMessageTypesTest {

    /**
     * get メソッドのテスト - 正常系:基本的な値の取得
     */
    @Test
    public void testGet_normalBasicValue() {

        /* 期待値の定義 */
        final String expected = "KMGMSGE11100";

        /* 準備 */
        final KmgMsgMessageTypes testType = KmgMsgMessageTypes.KMGMSGE11100;

        /* テスト対象の実行 */
        final String actual = testType.get();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "取得値が一致しません");

    }

    /**
     * getCode メソッドのテスト - 正常系:コードの取得
     */
    @Test
    public void testGetCode_normalBasicCode() {

        /* 期待値の定義 */
        final String expected = "KMGMSGE11100";

        /* 準備 */
        final KmgMsgMessageTypes testType = KmgMsgMessageTypes.KMGMSGE11100;

        /* テスト対象の実行 */
        final String actual = testType.getCode();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "getCodeの返り値が一致しません");

    }

    /**
     * getDefault メソッドのテスト - 正常系:デフォルト値の取得
     */
    @Test
    public void testGetDefault_normalDefaultValue() {

        /* 期待値の定義 */
        final KmgMsgMessageTypes expected = KmgMsgMessageTypes.NONE;

        /* テスト対象の実行 */
        final KmgMsgMessageTypes actual = KmgMsgMessageTypes.getDefault();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "デフォルト値が一致しません");

    }

    /**
     * getEnum メソッドのテスト - 正常系:存在する値の取得
     */
    @Test
    public void testGetEnum_normalExistingValue() {

        /* 期待値の定義 */
        final KmgMsgMessageTypes expected = KmgMsgMessageTypes.KMGMSGE11100;

        /* 準備 */
        final String testValue = "KMGMSGE11100";

        /* テスト対象の実行 */
        final KmgMsgMessageTypes actual = KmgMsgMessageTypes.getEnum(testValue);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "値が一致しません");

    }

    /**
     * getEnum メソッドのテスト - 準正常系:存在しない値の取得
     */
    @Test
    public void testGetEnum_semiNonExistingValue() {

        /* 期待値の定義 */
        final KmgMsgMessageTypes expected = KmgMsgMessageTypes.NONE;

        /* 準備 */
        final String testValue = "INVALID";

        /* テスト対象の実行 */
        final KmgMsgMessageTypes actual = KmgMsgMessageTypes.getEnum(testValue);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "値が一致しません");

    }

    /**
     * getInitValue メソッドのテスト - 正常系:初期値の取得
     */
    @Test
    public void testGetInitValue_normalInitialValue() {

        /* 期待値の定義 */
        final KmgMsgMessageTypes expected = KmgMsgMessageTypes.NONE;

        /* テスト対象の実行 */
        final KmgMsgMessageTypes actual = KmgMsgMessageTypes.getInitValue();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "初期値が一致しません");

    }

    /**
     * getDisplayName メソッドのテスト - 正常系:表示名の取得
     */
    @Test
    public void testGetDisplayName_normalBasicDisplayName() {

        /* 期待値の定義 */
        final String expected = "{0}がありません。";

        /* 準備 */
        final KmgMsgMessageTypes testType = KmgMsgMessageTypes.KMGMSGE11100;

        /* テスト対象の実行 */
        final String actual = testType.getDisplayName();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "表示名が一致しません");

    }

    /**
     * getValue メソッドのテスト - 正常系:値の取得
     */
    @Test
    public void testGetValue_normalBasicValue() {

        /* 期待値の定義 */
        final String expected = "{0}がありません。";

        /* 準備 */
        final KmgMsgMessageTypes testType = KmgMsgMessageTypes.KMGMSGE11100;

        /* テスト対象の実行 */
        final String actual = testType.getValue();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "値が一致しません");

    }

    /**
     * toString メソッドのテスト - 正常系:KMGMSGE11100の文字列表現
     */
    @Test
    public void testToString_normalKmgmsge11100() {

        /* 期待値の定義 */
        final String expected = "KMGMSGE11100";

        /* 準備 */
        final KmgMsgMessageTypes testType = KmgMsgMessageTypes.KMGMSGE11100;

        /* テスト対象の実行 */
        final String actual = testType.toString();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "KMGMSGE11100の場合、'KMGMSGE11100'が返されること");

    }

    /**
     * toString メソッドのテスト - 正常系:NONEの文字列表現
     */
    @Test
    public void testToString_normalNone() {

        /* 期待値の定義 */
        final String expected = "NONE";

        /* 準備 */
        final KmgMsgMessageTypes testType = KmgMsgMessageTypes.NONE;

        /* テスト対象の実行 */
        final String actual = testType.toString();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "NONEの場合、\"NONE\"が返されること");

    }
}

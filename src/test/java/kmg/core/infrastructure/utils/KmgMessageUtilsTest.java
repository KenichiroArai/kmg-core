package kmg.core.infrastructure.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import kmg.core.infrastructure.type.KmgString;
import kmg.core.infrastructure.types.KmgMsgMessageTypes;

/**
 * KMGメッセージユーティリティのテスト<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
public class KmgMessageUtilsTest {

    /**
     * getMessage メソッドのテスト - 正常系：メッセージと引数が正しく設定される場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGetMessage_normalCase() {

        /* 期待値の定義 */
        final String expectedMessage = "テスト名がありません。";

        /* 準備 */
        final Object[] testArgs = {
            "テスト名"
        };

        /* テスト対象の実行 */
        final String testResult = KmgMessageUtils.getMessage(KmgMsgMessageTypes.KMGMSGE11100, testArgs);

        /* 検証の準備 */
        final String actualMessage = testResult;

        /* 検証の実施 */
        Assertions.assertEquals(expectedMessage, actualMessage, "メッセージが一致しません");

    }

    /**
     * getMessage メソッドのテスト - 異常系：typeがnullの場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGetMessage_typeNull() {

        /* 期待値の定義 */
        final String expectedMessage = KmgString.EMPTY;

        /* 準備 */
        final Object[] testArgs = {
            "test"
        };

        /* テスト対象の実行 */
        final String testResult = KmgMessageUtils.getMessage(null, testArgs);

        /* 検証の準備 */
        final String actualMessage = testResult;

        /* 検証の実施 */
        Assertions.assertEquals(expectedMessage, actualMessage, "空文字が返却されていません");

    }

    /**
     * getMessage メソッドのテスト - 異常系：type.getCodeがnullの場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGetMessage_codeNull() {

        /* 期待値の定義 */
        final String expectedMessage = KmgString.EMPTY;

        /* 準備 */
        final Object[]           testArgs = {
            "test"
        };
        final KmgMsgMessageTypes testType = KmgMsgMessageTypes.NONE;

        /* テスト対象の実行 */
        final String testResult = KmgMessageUtils.getMessage(testType, testArgs);

        /* 検証の準備 */
        final String actualMessage = testResult;

        /* 検証の実施 */
        Assertions.assertEquals(expectedMessage, actualMessage, "空文字が返却されていません");

    }

    /**
     * getMessage メソッドのテスト - 異常系：messageArgsがnullの場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGetMessage_argsNull() {

        /* 期待値の定義 */
        final String expectedMessage = "{0}がありません。";

        /* 準備 */

        /* テスト対象の実行 */
        final String testResult = KmgMessageUtils.getMessage(KmgMsgMessageTypes.KMGMSGE11100, null);

        /* 検証の準備 */
        final String actualMessage = testResult;

        /* 検証の実施 */
        Assertions.assertEquals(expectedMessage, actualMessage, "メッセージパターンがそのまま返却されていません");

    }

    /**
     * getMessage メソッドのテスト - 異常系：messageArgsが空配列の場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGetMessage_argsEmpty() {

        /* 期待値の定義 */
        final String expectedMessage = "{0}がありません。";

        /* 準備 */
        final Object[] testArgs = {};

        /* テスト対象の実行 */
        final String testResult = KmgMessageUtils.getMessage(KmgMsgMessageTypes.KMGMSGE11100, testArgs);

        /* 検証の準備 */
        final String actualMessage = testResult;

        /* 検証の実施 */
        Assertions.assertEquals(expectedMessage, actualMessage, "メッセージパターンがそのまま返却されていません");

    }

    /**
     * getMessage メソッドのテスト - 異常系：存在しないメッセージコードの場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGetMessage_nonExistentCode() {

        /* 期待値の定義 */
        final String expectedMessage = KmgString.EMPTY;

        /* 準備 */
        final Object[]           testArgs = {
            "test"
        };
        final KmgMsgMessageTypes testType = KmgMsgMessageTypes.NONE;

        /* テスト対象の実行 */
        final String testResult = KmgMessageUtils.getMessage(testType, testArgs);

        /* 検証の準備 */
        final String actualMessage = testResult;

        /* 検証の実施 */
        Assertions.assertEquals(expectedMessage, actualMessage, "空文字が返却されていません");

    }
}

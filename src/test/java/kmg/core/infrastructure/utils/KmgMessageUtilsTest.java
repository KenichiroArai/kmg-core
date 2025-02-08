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

    /**
     * checkMessageArgsCount メソッドのテスト - メッセージパターンがnullの場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testCheckMessageArgsCount_nullPattern() {

        /* 期待値の定義 */
        final boolean expectedResult = false;

        /* 準備 */
        final String   testPattern = null;
        final Object[] testArgs    = new Object[] {
            "test"
        };

        /* テスト対象の実行 */
        final boolean actualResult = KmgMessageUtils.checkMessageArgsCount(testPattern, testArgs);

        /* 検証の実施 */
        Assertions.assertEquals(expectedResult, actualResult, "メッセージパターンがnullの場合はfalseを返すこと");

    }

    /**
     * checkMessageArgsCount メソッドのテスト - メッセージ引数がnullの場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testCheckMessageArgsCount_nullArgs() {

        /* 期待値の定義 */
        final boolean expectedResult = true;

        /* 準備 */
        final String   testPattern = "テスト";
        final Object[] testArgs    = null;

        /* テスト対象の実行 */
        final boolean actualResult = KmgMessageUtils.checkMessageArgsCount(testPattern, testArgs);

        /* 検証の実施 */
        Assertions.assertEquals(expectedResult, actualResult, "引数を含まないメッセージパターンで引数がnullの場合はtrueを返すこと");

    }

    /**
     * checkMessageArgsCount メソッドのテスト - 引数の数が一致する場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testCheckMessageArgsCount_matchCount() {

        /* 期待値の定義 */
        final boolean expectedResult = true;

        /* 準備 */
        final String   testPattern = "テスト{0} {1}です。{2}";
        final Object[] testArgs    = new Object[] {
            "A", "B", "C"
        };

        /* テスト対象の実行 */
        final boolean actualResult = KmgMessageUtils.checkMessageArgsCount(testPattern, testArgs);

        /* 検証の実施 */
        Assertions.assertTrue(actualResult, "引数の数が一致する場合はtrueを返すこと");

    }

    /**
     * checkMessageArgsCount メソッドのテスト - 引数の数が一致しない場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testCheckMessageArgsCount_unmatchCount() {

        /* 期待値の定義 */
        final boolean expectedResult = false;

        /* 準備 */
        final String   testPattern = "テスト{0} {1}です。{2}";
        final Object[] testArgs    = new Object[] {
            "A", "B"
        };

        /* テスト対象の実行 */
        final boolean actualResult = KmgMessageUtils.checkMessageArgsCount(testPattern, testArgs);

        /* 検証の実施 */
        Assertions.assertFalse(actualResult, "引数の数が一致しない場合はfalseを返すこと");

    }

    /**
     * checkMessageArgsCount メソッドのテスト - 引数を含まないメッセージパターンの場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testCheckMessageArgsCount_noArgs() {

        /* 期待値の定義 */
        final boolean expectedResult = true;

        /* 準備 */
        final String   testPattern = "テストです。";
        final Object[] testArgs    = new Object[] {};

        /* テスト対象の実行 */
        final boolean actualResult = KmgMessageUtils.checkMessageArgsCount(testPattern, testArgs);

        /* 検証の実施 */
        Assertions.assertTrue(actualResult, "引数を含まないメッセージパターンで空の引数配列の場合はtrueを返すこと");

    }

    /**
     * checkMessageArgsCount メソッドのテスト - 不正なメッセージパターンの場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testCheckMessageArgsCount_invalidPattern() {

        /* 期待値の定義 */
        final boolean expectedResult = false;

        /* 準備 */
        final String   testPattern = "テスト{invalid}";
        final Object[] testArgs    = new Object[] {
            "test"
        };

        /* テスト対象の実行 */
        final boolean actualResult = KmgMessageUtils.checkMessageArgsCount(testPattern, testArgs);

        /* 検証の実施 */
        Assertions.assertFalse(actualResult, "不正なメッセージパターンの場合はfalseを返すこと");

    }

    /**
     * getMessageArgsCount メソッドのテスト - nullパターンの場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGetMessageArgsCount_nullPattern() {

        /* 期待値の定義 */
        final int expectedCount = 0;

        /* 準備 */
        final String testPattern = null;

        /* テスト対象の実行 */
        final int actualCount = KmgMessageUtils.getMessageArgsCount(testPattern);

        /* 検証の実施 */
        Assertions.assertEquals(expectedCount, actualCount, "nullパターンの場合は0を返すこと");

    }

    /**
     * getMessageArgsCount メソッドのテスト - 不正なパターンの場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGetMessageArgsCount_invalidPattern() {

        /* 期待値の定義 */
        final int expectedCount = 0;

        /* 準備 */
        final String testPattern = "テスト{invalid}";

        /* テスト対象の実行 */
        final int actualCount = KmgMessageUtils.getMessageArgsCount(testPattern);

        /* 検証の実施 */
        Assertions.assertEquals(expectedCount, actualCount, "不正なパターンの場合は0を返すこと");

    }

    /**
     * getMessagePattern メソッドのテスト - typeがnullの場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGetMessagePattern_nullType() {

        /* 期待値の定義 */
        final String expectedPattern = KmgString.EMPTY;

        /* 準備 */

        /* テスト対象の実行 */
        final String actualPattern = KmgMessageUtils.getMessagePattern(null);

        /* 検証の実施 */
        Assertions.assertEquals(expectedPattern, actualPattern, "typeがnullの場合は空文字を返すこと");

    }

    /**
     * getMessagePattern メソッドのテスト - 存在しないメッセージコードの場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGetMessagePattern_nonExistentCode() {

        /* 期待値の定義 */
        final String expectedPattern = KmgString.EMPTY;

        /* 準備 */
        final KmgMsgMessageTypes testType = KmgMsgMessageTypes.NONE;

        /* テスト対象の実行 */
        final String actualPattern = KmgMessageUtils.getMessagePattern(testType);

        /* 検証の実施 */
        Assertions.assertEquals(expectedPattern, actualPattern, "存在しないメッセージコードの場合は空文字を返すこと");

    }
}

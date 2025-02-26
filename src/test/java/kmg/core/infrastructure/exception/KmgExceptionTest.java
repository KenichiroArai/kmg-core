package kmg.core.infrastructure.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import kmg.core.domain.types.KmgMsgMessageTypes;
import kmg.core.infrastructure.common.KmgMessageTypes;
import kmg.core.infrastructure.model.impl.KmgReflectionModelImpl;

/**
 * KMG例外テスト<br>
 *
 * @author KenichiroArai
 *
 * @since 0.1.0
 *
 * @version 0.1.0
 */
@SuppressWarnings({
    "nls", "static-method"
})
@ExtendWith(MockitoExtension.class)
public class KmgExceptionTest {

    /**
     * デフォルトコンストラクタ<br>
     *
     * @since 0.1.0
     */
    public KmgExceptionTest() {

        // 処理なし
    }

    /**
     * コンストラクタのテスト - 正常系：メッセージタイプとメッセージ引数を指定した場合
     *
     * @since 0.1.0
     */
    @Test
    public void testConstructor_normalWithMessageTypesAndArgs() {

        /* 期待値の定義 */
        final KmgMessageTypes expectedMsgTypes = KmgMsgMessageTypes.KMGMSGE11100;
        final Object[]        expectedMsgArgs  = {
            "テスト引数1", "テスト引数2"
        };
        final String          expectedMessage  = "テスト引数1がありません。";

        /* テスト対象の実行 */
        final KmgException testException = new KmgException(expectedMsgTypes, expectedMsgArgs);

        /* 検証の準備 */
        final String          actualMessage  = testException.getMessage();
        final KmgMessageTypes actualMsgTypes = testException.getMessageTypes();
        final Object[]        actualMsgArgs  = testException.getMessageArgs();

        /* 検証の実施 */
        Assertions.assertEquals(expectedMsgTypes, actualMsgTypes, "メッセージタイプが一致しません");
        Assertions.assertEquals(expectedMessage, actualMessage, "メッセージが一致しません");
        Assertions.assertArrayEquals(expectedMsgArgs, actualMsgArgs, "メッセージ引数が一致しません");

    }

    /**
     * コンストラクタのテスト - 正常系：メッセージタイプと原因を指定した場合
     *
     * @since 0.1.0
     */
    @Test
    public void testConstructor_normalWithMessageTypesAndCause() {

        /* 期待値の定義 */
        final KmgMessageTypes expectedMsgTypes = KmgMsgMessageTypes.KMGMSGE11100;
        final String          expectedMessage  = "{0}がありません。";
        final Throwable       expectedCause    = new RuntimeException("テスト原因");

        /* テスト対象の実行 */
        final KmgException testException = new KmgException(expectedMsgTypes, expectedCause);

        /* 検証の準備 */
        final String          actualMessage  = testException.getMessage();
        final KmgMessageTypes actualMsgTypes = testException.getMessageTypes();
        final Throwable       actualCause    = testException.getCause();

        /* 検証の実施 */
        Assertions.assertEquals(expectedMsgTypes, actualMsgTypes, "メッセージタイプが一致しません");
        Assertions.assertEquals(expectedMessage, actualMessage, "メッセージが一致しません");
        Assertions.assertEquals(expectedCause, actualCause, "原因が一致しません");

    }

    /**
     * コンストラクタのテスト - 正常系：メッセージタイプ、メッセージ引数、原因を指定した場合
     *
     * @since 0.1.0
     */
    @Test
    public void testConstructor_normalWithMessageTypesArgsAndCause() {

        /* 期待値の定義 */
        final KmgMessageTypes expectedMsgTypes = KmgMsgMessageTypes.KMGMSGE11100;
        final Object[]        expectedMsgArgs  = {
            "テスト引数1", "テスト引数2"
        };
        final String          expectedMessage  = "テスト引数1がありません。";
        final Throwable       expectedCause    = new RuntimeException("テスト原因");

        /* テスト対象の実行 */
        final KmgException testException = new KmgException(expectedMsgTypes, expectedMsgArgs, expectedCause);

        /* 検証の準備 */
        final String          actualMessage  = testException.getMessage();
        final KmgMessageTypes actualMsgTypes = testException.getMessageTypes();
        final Object[]        actualMsgArgs  = testException.getMessageArgs();
        final Throwable       actualCause    = testException.getCause();

        /* 検証の実施 */
        Assertions.assertEquals(expectedMsgTypes, actualMsgTypes, "メッセージタイプが一致しません");
        Assertions.assertEquals(expectedMessage, actualMessage, "メッセージが一致しません");
        Assertions.assertArrayEquals(expectedMsgArgs, actualMsgArgs, "メッセージ引数が一致しません");
        Assertions.assertEquals(expectedCause, actualCause, "原因が一致しません");

    }

    /**
     * コンストラクタのテスト - 正常系：メッセージタイプのみを指定した場合
     *
     * @since 0.1.0
     */
    @Test
    public void testConstructor_normalWithMessageTypesOnly() {

        /* 期待値の定義 */
        final KmgMessageTypes expectedMsgTypes = KmgMsgMessageTypes.KMGMSGE11100;
        final String          expectedMessage  = "{0}がありません。";

        /* テスト対象の実行 */
        final KmgException testException = new KmgException(expectedMsgTypes);

        /* 検証の準備 */
        final String          actualMessage  = testException.getMessage();
        final KmgMessageTypes actualMsgTypes = testException.getMessageTypes();

        /* 検証の実施 */
        Assertions.assertEquals(expectedMsgTypes, actualMsgTypes, "メッセージタイプが一致しません");
        Assertions.assertEquals(expectedMessage, actualMessage, "メッセージが一致しません");

    }

    /**
     * getMessageArgsCount メソッドのテスト - 正常系：メッセージ引数がある場合
     *
     * @since 0.1.0
     */
    @Test
    public void testGetMessageArgsCount_normalWithArgs() {

        /* 期待値の定義 */
        final int expectedCount = 2;

        /* 準備 */
        final Object[] testMsgArgs = {
            "テスト引数1", "テスト引数2"
        };

        /* テスト対象の実行 */
        final KmgException testException = new KmgException(KmgMsgMessageTypes.KMGMSGE11100, testMsgArgs);

        /* 検証の準備 */
        final int actualCount = testException.getMessageArgsCount();

        /* 検証の実施 */
        Assertions.assertEquals(expectedCount, actualCount, "メッセージ引数の数が一致しません");

    }

    /**
     * getMessageArgsCount メソッドのテスト - 準正常系：メッセージ引数がnullの場合
     *
     * @since 0.1.0
     */
    @Test
    public void testGetMessageArgsCount_semiWithNullArgs() {

        /* 期待値の定義 */
        final int expectedCount = 0;

        /* テスト対象の実行 */
        final KmgException testException = new KmgException(KmgMsgMessageTypes.KMGMSGE11100);

        /* 検証の準備 */
        final int actualCount = testException.getMessageArgsCount();

        /* 検証の実施 */
        Assertions.assertEquals(expectedCount, actualCount, "メッセージ引数の数が0であること");

    }

    /**
     * getMessagePattern メソッドのテスト - 正常系：メッセージパターンを取得する場合
     *
     * @since 0.1.0
     */
    @Test
    public void testGetMessagePattern_normalGetPattern() {

        /* 期待値の定義 */
        final String expectedPattern = "{0}がありません。";

        /* テスト対象の実行 */
        final KmgException testException = new KmgException(KmgMsgMessageTypes.KMGMSGE11100);

        /* 検証の準備 */
        final String actualPattern = testException.getMessagePattern();

        /* 検証の実施 */
        Assertions.assertEquals(expectedPattern, actualPattern, "メッセージパターンが一致しません");

    }

    /**
     * getMessagePatternArgsCount メソッドのテスト - 正常系：メッセージパターンの引数の数を取得する場合
     *
     * @since 0.1.0
     */
    @Test
    public void testGetMessagePatternArgsCount_normalGetCount() {

        /* 期待値の定義 */
        final int expectedCount = 1;

        /* テスト対象の実行 */
        final KmgException testException = new KmgException(KmgMsgMessageTypes.KMGMSGE11100);

        /* 検証の準備 */
        final int actualCount = testException.getMessagePatternArgsCount();

        /* 検証の実施 */
        Assertions.assertEquals(expectedCount, actualCount, "メッセージパターンの引数の数が一致しません");

    }

    /**
     * isMatchMessageArgsCount メソッドのテスト - 正常系：メッセージ引数の数が一致する場合
     *
     * @since 0.1.0
     */
    @Test
    public void testIsMatchMessageArgsCount_normalMatching() {

        /* 期待値の定義 */

        /* 準備 */
        final Object[] testMsgArgs = {
            "テスト引数1"
        };

        /* テスト対象の実行 */
        final KmgException testException = new KmgException(KmgMsgMessageTypes.KMGMSGE11100, testMsgArgs);

        /* 検証の準備 */
        final boolean actualIsMatch = testException.isMatchMessageArgsCount();

        /* 検証の実施 */
        Assertions.assertTrue(actualIsMatch, "メッセージ引数の数が一致しているか");

    }

    /**
     * isMatchMessageArgsCount メソッドのテスト - 準正常系：メッセージ引数の数が一致しない場合
     *
     * @since 0.1.0
     */
    @Test
    public void testIsMatchMessageArgsCount_semiNotMatching() {

        /* 期待値の定義 */
        final boolean expectedIsMatch = false;

        /* 準備 */
        final Object[] testMsgArgs = {
            "テスト引数1", "テスト引数2"
        };

        /* テスト対象の実行 */
        final KmgException testException = new KmgException(KmgMsgMessageTypes.KMGMSGE11100, testMsgArgs);

        /* 検証の準備 */
        final boolean actualIsMatch = testException.isMatchMessageArgsCount();

        /* 検証の実施 */
        Assertions.assertEquals(expectedIsMatch, actualIsMatch, "メッセージ引数の数が一致していないか");

    }

    /**
     * setMessageCounts メソッドのテスト - 準正常系：メッセージパターンが空の場合
     *
     * @since 0.1.0
     *
     * @throws Exception
     *                   リフレクション操作で発生する可能性のある例外
     */
    @Test
    public void testSetMessageCounts_semiEmptyPattern() throws Exception {

        /* 期待値の定義 */
        final int expectedMessageArgsCount        = 0;
        final int expectedMessagePatternArgsCount = 0;

        /* 準備 */
        final KmgException           testException   = new KmgException(KmgMsgMessageTypes.KMGMSGE11100);
        final KmgReflectionModelImpl reflectionModel = new KmgReflectionModelImpl(testException);

        // privateフィールドのmessagePatternを空文字列に設定
        reflectionModel.set("messagePattern", "");
        reflectionModel.getMethod("setMessageCounts");

        /* 検証の準備 */
        final int     actualMessageArgsCount        = testException.getMessageArgsCount();
        final int     actualMessagePatternArgsCount = testException.getMessagePatternArgsCount();
        final boolean actualIsMatchMessageArgsCount = testException.isMatchMessageArgsCount();

        /* 検証の実施 */
        Assertions.assertEquals(expectedMessageArgsCount, actualMessageArgsCount, "メッセージ引数の数が一致する");
        Assertions.assertEquals(expectedMessagePatternArgsCount, actualMessagePatternArgsCount, "メッセージパターンの引数の数が一致する");
        Assertions.assertTrue(actualIsMatchMessageArgsCount, "メッセージ引数の数が一致しているか");

    }
}

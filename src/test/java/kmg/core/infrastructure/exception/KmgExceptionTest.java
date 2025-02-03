package kmg.core.infrastructure.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import kmg.core.infrastructure.types.KmgMsgMessageTypes;

/**
 * KMG例外テスト<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
public class KmgExceptionTest {

    /**
     * コンストラクタのテスト - 全パラメータを指定した場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testConstructor_withAllParameters() {

        /* 期待値の定義 */
        final KmgMsgMessageTypes expectedMsgTypes = KmgMsgMessageTypes.NONE;
        final Object[]           expectedMsgArgs  = {
            "arg1", "arg2"
        };
        final Throwable          expectedCause    = new RuntimeException("テスト原因");

        /* 準備 */

        /* テスト対象の実行 */
        final KmgException testException = new KmgException(expectedMsgTypes, expectedMsgArgs, expectedCause);

        /* 検証の準備 */
        final KmgMsgMessageTypes actualMsgTypes = testException.getMessageTypes();
        final Object[]           actualMsgArgs  = testException.getMessageArgs();
        final Throwable          actualCause    = testException.getCause();

        /* 検証の実施 */
        Assertions.assertEquals(expectedMsgTypes, actualMsgTypes, "メッセージの種類が一致しません");
        Assertions.assertArrayEquals(expectedMsgArgs, actualMsgArgs, "メッセージの引数が一致しません");
        Assertions.assertNotNull(actualCause, "原因がnullです");
        Assertions.assertEquals(expectedCause, actualCause, "原因が一致しません");

    }

    /**
     * コンストラクタのテスト - メッセージの種類とメッセージの引数を指定した場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testConstructor_withTypeAndArgs() {

        /* 期待値の定義 */
        final KmgMsgMessageTypes expectedMsgTypes = KmgMsgMessageTypes.NONE;
        final Object[]           expectedMsgArgs  = {
            "arg1", "arg2"
        };

        /* 準備 */

        /* テスト対象の実行 */
        final KmgException testException = new KmgException(expectedMsgTypes, expectedMsgArgs);

        /* 検証の準備 */
        final KmgMsgMessageTypes actualMsgTypes = testException.getMessageTypes();
        final Object[]           actualMsgArgs  = testException.getMessageArgs();

        /* 検証の実施 */
        Assertions.assertEquals(expectedMsgTypes, actualMsgTypes, "メッセージの種類が一致しません");
        Assertions.assertArrayEquals(expectedMsgArgs, actualMsgArgs, "メッセージの引数が一致しません");

    }

    /**
     * コンストラクタのテスト - メッセージの種類と原因を指定した場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testConstructor_withTypeAndCause() {

        /* 期待値の定義 */
        final KmgMsgMessageTypes expectedMsgTypes = KmgMsgMessageTypes.NONE;
        final Throwable          expectedCause    = new RuntimeException("テスト原因");

        /* 準備 */

        /* テスト対象の実行 */
        final KmgException testException = new KmgException(expectedMsgTypes, expectedCause);

        /* 検証の準備 */
        final KmgMsgMessageTypes actualMsgTypes = testException.getMessageTypes();
        final Throwable          actualCause    = testException.getCause();

        /* 検証の実施 */
        Assertions.assertEquals(expectedMsgTypes, actualMsgTypes, "メッセージの種類が一致しません");
        Assertions.assertNotNull(actualCause, "原因がnullです");
        Assertions.assertEquals(expectedCause, actualCause, "原因が一致しません");

    }
}

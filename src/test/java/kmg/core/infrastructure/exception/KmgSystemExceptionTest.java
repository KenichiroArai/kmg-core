package kmg.core.infrastructure.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import kmg.core.infrastructure.types.KmgLogMessageTypes;

/**
 * KMGシステム例外テスト<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
public class KmgSystemExceptionTest {

    /**
     * コンストラクタのテスト - 全パラメータを指定した場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testConstructor_withAllParameters() {

        /* 期待値の定義 */
        final String             expectedErrMsg      = "テストエラーメッセージ";
        final KmgLogMessageTypes expectedLogMsgTypes = KmgLogMessageTypes.NONE;
        final Object[]           expectedLogMsgArgs  = {
            "arg1", "arg2"
        };
        final Throwable          expectedCause       = new RuntimeException("テスト原因");

        /* 準備 */

        /* テスト対象の実行 */
        final KmgSystemException testException
            = new KmgSystemException(expectedErrMsg, expectedLogMsgTypes, expectedLogMsgArgs, expectedCause);

        /* 検証の準備 */
        final String             actualErrMsg      = testException.getMessage();
        final KmgLogMessageTypes actualLogMsgTypes = testException.getLogMsgTypes();
        final Object[]           actualLogMsgArgs  = testException.getLogMsgArgs();
        final Throwable          actualCause       = testException.getCause();

        /* 検証の実施 */
        Assertions.assertEquals(expectedErrMsg, actualErrMsg, "エラーメッセージが一致しません");
        Assertions.assertEquals(expectedLogMsgTypes, actualLogMsgTypes, "ログメッセージの種類が一致しません");
        Assertions.assertArrayEquals(expectedLogMsgArgs, actualLogMsgArgs, "ログメッセージの引数が一致しません");
        Assertions.assertNotNull(actualCause, "原因がnullです");
        Assertions.assertEquals(expectedCause, actualCause, "原因が一致しません");

    }

    /**
     * コンストラクタのテスト - エラーメッセージとログメッセージの種類とログメッセージの引数を指定した場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testConstructor_withMessageAndTypeAndArgs() {

        /* 期待値の定義 */
        final String             expectedErrMsg      = "テストエラーメッセージ";
        final KmgLogMessageTypes expectedLogMsgTypes = KmgLogMessageTypes.NONE;
        final Object[]           expectedLogMsgArgs  = {
            "arg1", "arg2"
        };

        /* 準備 */

        /* テスト対象の実行 */
        final KmgSystemException testException
            = new KmgSystemException(expectedErrMsg, expectedLogMsgTypes, expectedLogMsgArgs);

        /* 検証の準備 */
        final String             actualErrMsg      = testException.getMessage();
        final KmgLogMessageTypes actualLogMsgTypes = testException.getLogMsgTypes();
        final Object[]           actualLogMsgArgs  = testException.getLogMsgArgs();

        /* 検証の実施 */
        Assertions.assertEquals(expectedErrMsg, actualErrMsg, "エラーメッセージが一致しません");
        Assertions.assertEquals(expectedLogMsgTypes, actualLogMsgTypes, "ログメッセージの種類が一致しません");
        Assertions.assertArrayEquals(expectedLogMsgArgs, actualLogMsgArgs, "ログメッセージの引数が一致しません");

    }
}

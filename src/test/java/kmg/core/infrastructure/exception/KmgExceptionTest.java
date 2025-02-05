package kmg.core.infrastructure.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import kmg.core.infrastructure.model.KmgMessageModel;

/**
 * KMG例外テスト<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
@ExtendWith(MockitoExtension.class)
public class KmgExceptionTest {

    /**
     * コンストラクタのテスト - メッセージモデルのみを指定した場合
     *
     * @param kmgMessageModel
     *                        メッセージモデル
     */
    @Test
    @SuppressWarnings("static-method")
    public void testConstructor_withMessageModel(@Mock final KmgMessageModel kmgMessageModel) {

        /* 期待値の定義 */
        final String expectedMessage = "テストメッセージ";

        /* 準備 */
        Mockito.when(kmgMessageModel.getMessage()).thenReturn(expectedMessage);

        /* テスト対象の実行 */
        final KmgException testException = new KmgException(kmgMessageModel);

        /* 検証の準備 */
        final String          actualMessage      = testException.getMessage();
        final KmgMessageModel actualMessageModel = testException.getMessageInfo();

        /* 検証の実施 */
        Assertions.assertEquals(expectedMessage, actualMessage, "メッセージが一致しません");
        Assertions.assertEquals(kmgMessageModel, actualMessageModel, "メッセージモデルが一致しません");

    }

    /**
     * コンストラクタのテスト - メッセージモデルと原因を指定した場合
     *
     * @param kmgMessageModel
     *                        メッセージモデル
     */
    @Test
    @SuppressWarnings("static-method")
    public void testConstructor_withMessageModelAndCause(@Mock final KmgMessageModel kmgMessageModel) {

        /* 期待値の定義 */
        final String    expectedMessage = "テストメッセージ";
        final Throwable expectedCause   = new RuntimeException("テスト原因");

        /* 準備 */
        Mockito.when(kmgMessageModel.getMessage()).thenReturn(expectedMessage);

        /* テスト対象の実行 */
        final KmgException testException = new KmgException(kmgMessageModel, expectedCause);

        /* 検証の準備 */
        final String          actualMessage      = testException.getMessage();
        final KmgMessageModel actualMessageModel = testException.getMessageInfo();
        final Throwable       actualCause        = testException.getCause();

        /* 検証の実施 */
        Assertions.assertEquals(expectedMessage, actualMessage, "メッセージが一致しません");
        Assertions.assertEquals(kmgMessageModel, actualMessageModel, "メッセージモデルが一致しません");
        Assertions.assertEquals(expectedCause, actualCause, "原因が一致しません");

    }
}

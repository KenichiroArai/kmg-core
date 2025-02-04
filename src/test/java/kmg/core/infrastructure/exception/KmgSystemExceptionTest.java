package kmg.core.infrastructure.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import kmg.core.infrastructure.model.KmgMessageModel;

/**
 * KMGシステム例外テスト<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
@ExtendWith(MockitoExtension.class)
public class KmgSystemExceptionTest {

    /** メッセージモデルのモック */
    @Mock
    private KmgMessageModel kmgMessageModel;

    /**
     * コンストラクタのテスト - メッセージモデルを指定した場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testConstructor_withMessageModel() {

        /* 期待値の定義 */
        final String expectedMessage = "テストメッセージ";

        /* 準備 */
        final KmgMessageModel testMessageModel = Mockito.mock(KmgMessageModel.class);
        Mockito.when(testMessageModel.toString()).thenReturn(expectedMessage);

        /* テスト対象の実行 */
        final KmgSystemException testException = new KmgSystemException(testMessageModel);

        /* 検証の準備 */
        final String actualMessage = testException.getMessage();

        /* 検証の実施 */
        Assertions.assertEquals(expectedMessage, actualMessage, "メッセージが一致しません");

    }

    /**
     * コンストラクタのテスト - メッセージモデルと原因を指定した場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testConstructor_withMessageModelAndCause() {

        /* 期待値の定義 */
        final String    expectedMessage = "テストメッセージ";
        final Throwable expectedCause   = new RuntimeException("テスト原因");

        /* 準備 */
        final KmgMessageModel testMessageModel = Mockito.mock(KmgMessageModel.class);
        Mockito.when(testMessageModel.toString()).thenReturn(expectedMessage);

        /* テスト対象の実行 */
        final KmgSystemException testException = new KmgSystemException(testMessageModel, expectedCause);

        /* 検証の準備 */
        final String    actualMessage = testException.getMessage();
        final Throwable actualCause   = testException.getCause();

        /* 検証の実施 */
        Assertions.assertEquals(expectedMessage, actualMessage, "メッセージが一致しません");
        Assertions.assertNotNull(actualCause, "原因がnullです");
        Assertions.assertEquals(expectedCause, actualCause, "原因が一致しません");

    }
}

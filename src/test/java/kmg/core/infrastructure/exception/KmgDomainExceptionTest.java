package kmg.core.infrastructure.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import kmg.core.infrastructure.model.KmgMessageModel;
import kmg.core.infrastructure.types.KmgMsgMessageTypes;

/**
 * KMGドメイン例外テスト<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
@ExtendWith(MockitoExtension.class)
public class KmgDomainExceptionTest {

    /** メッセージモデルのモック */
    @Mock
    private KmgMessageModel kmgMessageModel;

    /**
     * コンストラクタのテスト - メッセージモデルを指定した場合
     *
     * @param mockMessageModel
     *                         メッセージモデルのモック
     */
    @Test
    @SuppressWarnings("static-method")
    public void testConstructor_withMessageModel(@Mock final KmgMessageModel mockMessageModel) {

        /* 期待値の定義 */
        final KmgMsgMessageTypes expectedMsgTypes = KmgMsgMessageTypes.NONE;
        final Object[]           expectedMsgArgs  = {
            "arg1", "arg2"
        };
        final String             expectedMessage  = "テストメッセージ";

        /* 準備 */
        Mockito.when(mockMessageModel.getMessageTypes()).thenReturn(expectedMsgTypes);
        Mockito.when(mockMessageModel.getMessageArgs()).thenReturn(expectedMsgArgs);
        Mockito.when(mockMessageModel.getMessage()).thenReturn(expectedMessage);

        /* テスト対象の実行 */
        final KmgDomainException testException = new KmgDomainException(mockMessageModel);

        /* 検証の実施 */
        Assertions.assertNotNull(testException, "例外オブジェクトがnullです");
        Assertions.assertEquals(expectedMessage, testException.getMessage(), "メッセージが一致しません");

    }

    /**
     * コンストラクタのテスト - メッセージモデルと原因を指定した場合
     *
     * @param mockMessageModel
     *                         メッセージモデルのモック
     */
    @Test
    @SuppressWarnings("static-method")
    public void testConstructor_withMessageModelAndCause(@Mock final KmgMessageModel mockMessageModel) {

        /* 期待値の定義 */
        final KmgMsgMessageTypes expectedMsgTypes = KmgMsgMessageTypes.NONE;
        final Object[]           expectedMsgArgs  = {
            "arg1", "arg2"
        };
        final String             expectedMessage  = "テストメッセージ";
        final Throwable          expectedCause    = new RuntimeException("テスト原因");

        /* 準備 */
        Mockito.when(mockMessageModel.getMessageTypes()).thenReturn(expectedMsgTypes);
        Mockito.when(mockMessageModel.getMessageArgs()).thenReturn(expectedMsgArgs);
        Mockito.when(mockMessageModel.getMessage()).thenReturn(expectedMessage);

        /* テスト対象の実行 */
        final KmgDomainException testException = new KmgDomainException(mockMessageModel, expectedCause);

        /* 検証の実施 */
        Assertions.assertNotNull(testException, "例外オブジェクトがnullです");
        Assertions.assertEquals(expectedMessage, testException.getMessage(), "メッセージが一致しません");
        Assertions.assertEquals(expectedCause, testException.getCause(), "原因が一致しません");

    }
}

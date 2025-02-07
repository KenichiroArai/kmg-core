package kmg.core.infrastructure.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

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

    /**
     * コンストラクタのテスト - メッセージタイプのみを指定した場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testConstructor_withMessageTypes() {

        /* 期待値の定義 */
        final KmgMsgMessageTypes expectedMsgTypes = KmgMsgMessageTypes.NONE;
        final String             expectedMessage  = "テストメッセージ";

        /* テスト対象の実行 */
        final KmgDomainException testException = new KmgDomainException(expectedMsgTypes);

        /* 検証の準備 */
        final String             actualMessage  = testException.getMessage();
        final KmgMsgMessageTypes actualMsgTypes = testException.getMessageTypes();

        /* 検証の実施 */
        Assertions.assertEquals(expectedMsgTypes, actualMsgTypes, "メッセージタイプが一致しません");
        Assertions.assertEquals(expectedMessage, actualMessage, "メッセージが一致しません");

    }

    /**
     * コンストラクタのテスト - メッセージタイプと原因を指定した場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testConstructor_withMessageTypesAndCause() {

        /* 期待値の定義 */
        final KmgMsgMessageTypes expectedMsgTypes = KmgMsgMessageTypes.NONE;
        final String             expectedMessage  = "テストメッセージ";
        final Throwable          expectedCause    = new RuntimeException("テスト原因");

        /* テスト対象の実行 */
        final KmgDomainException testException = new KmgDomainException(expectedMsgTypes, expectedCause);

        /* 検証の準備 */
        final String             actualMessage  = testException.getMessage();
        final KmgMsgMessageTypes actualMsgTypes = testException.getMessageTypes();
        final Throwable          actualCause    = testException.getCause();

        /* 検証の実施 */
        Assertions.assertEquals(expectedMsgTypes, actualMsgTypes, "メッセージタイプが一致しません");
        Assertions.assertEquals(expectedMessage, actualMessage, "メッセージが一致しません");
        Assertions.assertEquals(expectedCause, actualCause, "原因が一致しません");

    }
}

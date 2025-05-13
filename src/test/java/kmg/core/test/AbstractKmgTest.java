package kmg.core.test;

import org.junit.jupiter.api.Assertions;

import kmg.core.infrastructure.common.msg.KmgComExcMsgTypes;
import kmg.core.infrastructure.common.msg.KmgComGenMsgTypes;
import kmg.core.infrastructure.exception.KmgMsgException;

/**
 * KMGのテストの抽象クラス<br>
 *
 * @author KenichiroArai
 *
 * @since 0.1.0
 *
 * @version 0.2.0
 */
@SuppressWarnings("nls")
public abstract class AbstractKmgTest {

    /**
     * デフォルトコンストラクタ<br>
     *
     * @since 0.1.0
     */
    public AbstractKmgTest() {

        // 処理なし
    }

    /**
     * KMG例外の検証を行う<br>
     *
     * @since 0.1.0
     *
     * @param actualException
     *                              実際の例外
     * @param expectedCauseClass
     *                              期待する原因のクラス
     * @param expectedDomainMessage
     *                              期待するドメインメッセージ
     * @param expectedMessageTypes
     *                              期待するメッセージの種類
     */
    @SuppressWarnings("static-method")
    protected void verifyKmgMsgException(final KmgMsgException actualException, final Class<?> expectedCauseClass,
        final String expectedDomainMessage, final KmgComGenMsgTypes expectedMessageTypes) {

        /* 検証の準備 */
        final Throwable         actualCause                   = actualException.getCause();                // 実際の例外の原因
        final String            actualDomainMessage           = actualException.getMessage();              // 実際のドメインメッセージ
        final KmgComExcMsgTypes actualMessageTypes            = actualException.getMessageTypes();         // 実際のメッセージタイプ
        final boolean           actualIsMatchMessageArgsCount = actualException.isMatchMessageArgsCount(); // 実際のメッセージ引数の数

        /* 検証の実施 */
        Assertions.assertTrue(expectedCauseClass.isInstance(actualCause),
            String.format("KmgDomainExceptionの原因が%sであること", expectedCauseClass.getSimpleName()));
        Assertions.assertEquals(expectedDomainMessage, actualDomainMessage, "KmgDomainExceptionのメッセージが正しいこと");
        Assertions.assertEquals(expectedMessageTypes, actualMessageTypes, "メッセージの種類が正しいこと");
        Assertions.assertTrue(actualIsMatchMessageArgsCount, "メッセージ引数の数が一致していること");

    }
}

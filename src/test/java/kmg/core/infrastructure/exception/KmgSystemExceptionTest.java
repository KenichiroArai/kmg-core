package kmg.core.infrastructure.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import kmg.core.domain.types.KmgCoreGenMessageTypes;
import kmg.core.infrastructure.common.KmgComGenMessageTypes;

/**
 * KMGシステム例外テスト<br>
 *
 * @author KenichiroArai
 *
 * @since 0.1.0
 *
 * @version 0.2.0
 */
@SuppressWarnings({
    "nls", "static-method"
})
@ExtendWith(MockitoExtension.class)
public class KmgSystemExceptionTest {

    /**
     * デフォルトコンストラクタ<br>
     *
     * @since 0.1.0
     */
    public KmgSystemExceptionTest() {

        // 処理なし
    }

    /**
     * コンストラクタ メソッドのテスト - 正常系：メッセージタイプのみを指定した場合
     *
     * @since 0.1.0
     */
    @Test
    public void testConstructor_normalMessageTypes() {

        /* 期待値の定義 */
        final KmgCoreGenMessageTypes expectedMsgTypes = KmgCoreGenMessageTypes.KMGCOREGEN11100;
        final String             expectedMessage  = "{0}がありません。";

        /* テスト対象の実行 */
        final KmgSystemException testException = new KmgSystemException(expectedMsgTypes);

        /* 検証の準備 */
        final String                   actualMessage  = testException.getMessage();
        final KmgComGenMessageTypes actualMsgTypes = testException.getMessageTypes();

        /* 検証の実施 */
        Assertions.assertEquals(expectedMsgTypes, actualMsgTypes, "メッセージタイプが一致しません");
        Assertions.assertEquals(expectedMessage, actualMessage, "メッセージが一致しません");

    }

    /**
     * コンストラクタ メソッドのテスト - 正常系：メッセージタイプとメッセージ引数を指定した場合
     *
     * @since 0.1.0
     */
    @Test
    public void testConstructor_normalMessageTypesAndArgs() {

        /* 期待値の定義 */
        final KmgCoreGenMessageTypes expectedMsgTypes = KmgCoreGenMessageTypes.KMGCOREGEN11100;
        final Object[]           expectedMsgArgs  = {
            "テスト引数1", "テスト引数2"
        };
        final String             expectedMessage  = "テスト引数1がありません。";

        /* テスト対象の実行 */
        final KmgSystemException testException = new KmgSystemException(expectedMsgTypes, expectedMsgArgs);

        /* 検証の準備 */
        final String                   actualMessage  = testException.getMessage();
        final KmgComGenMessageTypes actualMsgTypes = testException.getMessageTypes();
        final Object[]                 actualMsgArgs  = testException.getMessageArgs();

        /* 検証の実施 */
        Assertions.assertEquals(expectedMsgTypes, actualMsgTypes, "メッセージタイプが一致しません");
        Assertions.assertEquals(expectedMessage, actualMessage, "メッセージが一致しません");
        Assertions.assertArrayEquals(expectedMsgArgs, actualMsgArgs, "メッセージ引数が一致しません");

    }

    /**
     * コンストラクタ メソッドのテスト - 正常系：メッセージタイプと原因を指定した場合
     *
     * @since 0.1.0
     */
    @Test
    public void testConstructor_normalMessageTypesAndCause() {

        /* 期待値の定義 */
        final KmgCoreGenMessageTypes expectedMsgTypes = KmgCoreGenMessageTypes.KMGCOREGEN11100;
        final String             expectedMessage  = "{0}がありません。";
        final Throwable          expectedCause    = new RuntimeException("テスト原因");

        /* テスト対象の実行 */
        final KmgSystemException testException = new KmgSystemException(expectedMsgTypes, expectedCause);

        /* 検証の準備 */
        final String                   actualMessage  = testException.getMessage();
        final KmgComGenMessageTypes actualMsgTypes = testException.getMessageTypes();
        final Throwable                actualCause    = testException.getCause();

        /* 検証の実施 */
        Assertions.assertEquals(expectedMsgTypes, actualMsgTypes, "メッセージタイプが一致しません");
        Assertions.assertEquals(expectedMessage, actualMessage, "メッセージが一致しません");
        Assertions.assertEquals(expectedCause, actualCause, "原因が一致しません");

    }
}

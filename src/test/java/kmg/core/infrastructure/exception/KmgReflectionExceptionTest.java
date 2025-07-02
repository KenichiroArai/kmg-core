package kmg.core.infrastructure.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import kmg.core.infrastructure.cmn.msg.KmgComExcMsgTypes;
import kmg.core.infrastructure.model.KmgReflectionModel;
import kmg.core.infrastructure.types.msg.KmgCoreGenMsgTypes;

/**
 * KMGリフレクション例外テスト<br>
 *
 * @author KenichiroArai
 *
 * @since 0.1.0
 *
 * @version 0.2.0
 */
@SuppressWarnings({
    "nls",
})
@ExtendWith(MockitoExtension.class)
public class KmgReflectionExceptionTest {

    /**
     * KMGリフレクションモデル
     *
     * @since 0.1.0
     */
    @Mock
    private KmgReflectionModel kmgReflectionModel;

    /**
     * デフォルトコンストラクタ<br>
     *
     * @since 0.1.0
     */
    public KmgReflectionExceptionTest() {

        // 処理なし
    }

    /**
     * constructor メソッドのテスト - 正常系：メッセージタイプ、メッセージ引数、原因、KMGリフレクションモデルを指定した場合
     *
     * @since 0.1.0
     */
    @Test
    public void testConstructor_normalWithMessageTypesAndArgsAndCauseAndModel() {

        /* 期待値の定義 */
        final KmgCoreGenMsgTypes expectedMsgTypes = KmgCoreGenMsgTypes.KMGCORE_GEN11100;

        final Object[]  expectedMsgArgs = {
            "テスト引数1", "テスト引数2"
        };
        final String    expectedMessage = "[KMGCORE_GEN11100] テスト引数1がありません。";
        final Throwable expectedCause   = new RuntimeException("テスト原因");

        /* テスト対象の実行 */
        final KmgReflectionException testException
            = new KmgReflectionException(this.kmgReflectionModel, expectedMsgTypes, expectedMsgArgs, expectedCause);

        /* 検証の準備 */
        final String             actualMessage  = testException.getMessage();
        final KmgComExcMsgTypes  actualMsgTypes = testException.getMessageTypes();
        final Object[]           actualMsgArgs  = testException.getMessageArgs();
        final Throwable          actualCause    = testException.getCause();
        final KmgReflectionModel actualModel    = testException.getKmgReflectionModel();

        /* 検証の実施 */
        Assertions.assertEquals(expectedMsgTypes, actualMsgTypes, "メッセージタイプが一致しません");
        Assertions.assertEquals(expectedMessage, actualMessage, "メッセージが一致しません");
        Assertions.assertArrayEquals(expectedMsgArgs, actualMsgArgs, "メッセージ引数が一致しません");
        Assertions.assertEquals(expectedCause, actualCause, "原因が一致しません");
        Assertions.assertEquals(this.kmgReflectionModel, actualModel, "KMGリフレクションモデルが一致しません");

    }

    /**
     * constructor メソッドのテスト - 正常系：メッセージタイプ、メッセージ引数、KMGリフレクションモデルを指定した場合
     *
     * @since 0.1.0
     */
    @Test
    public void testConstructor_normalWithMessageTypesAndArgsAndModel() {

        /* 期待値の定義 */
        final KmgCoreGenMsgTypes expectedMsgTypes = KmgCoreGenMsgTypes.KMGCORE_GEN11100;

        final Object[] expectedMsgArgs = {
            "テスト引数1", "テスト引数2"
        };
        final String   expectedMessage = "[KMGCORE_GEN11100] テスト引数1がありません。";

        /* テスト対象の実行 */
        final KmgReflectionException testException
            = new KmgReflectionException(this.kmgReflectionModel, expectedMsgTypes, expectedMsgArgs);

        /* 検証の準備 */
        final String             actualMessage  = testException.getMessage();
        final KmgComExcMsgTypes  actualMsgTypes = testException.getMessageTypes();
        final Object[]           actualMsgArgs  = testException.getMessageArgs();
        final KmgReflectionModel actualModel    = testException.getKmgReflectionModel();

        /* 検証の実施 */
        Assertions.assertEquals(expectedMsgTypes, actualMsgTypes, "メッセージタイプが一致しません");
        Assertions.assertEquals(expectedMessage, actualMessage, "メッセージが一致しません");
        Assertions.assertArrayEquals(expectedMsgArgs, actualMsgArgs, "メッセージ引数が一致しません");
        Assertions.assertEquals(this.kmgReflectionModel, actualModel, "KMGリフレクションモデルが一致しません");

    }

    /**
     * constructor メソッドのテスト - 正常系：メッセージタイプ、原因、KMGリフレクションモデルを指定した場合
     *
     * @since 0.1.0
     */
    @Test
    public void testConstructor_normalWithMessageTypesAndCauseAndModel() {

        /* 期待値の定義 */
        final KmgCoreGenMsgTypes expectedMsgTypes = KmgCoreGenMsgTypes.KMGCORE_GEN11100;
        final String             expectedMessage  = "{0}がありません。";

        final Throwable expectedCause = new RuntimeException("テスト原因");

        /* テスト対象の実行 */
        final KmgReflectionException testException
            = new KmgReflectionException(this.kmgReflectionModel, expectedMsgTypes, expectedCause);

        /* 検証の準備 */
        final String             actualMessage  = testException.getMessage();
        final KmgComExcMsgTypes  actualMsgTypes = testException.getMessageTypes();
        final Throwable          actualCause    = testException.getCause();
        final KmgReflectionModel actualModel    = testException.getKmgReflectionModel();

        /* 検証の実施 */
        Assertions.assertEquals(expectedMsgTypes, actualMsgTypes, "メッセージタイプが一致しません");
        Assertions.assertEquals(expectedMessage, actualMessage, "メッセージが一致しません");
        Assertions.assertEquals(expectedCause, actualCause, "原因が一致しません");
        Assertions.assertEquals(this.kmgReflectionModel, actualModel, "KMGリフレクションモデルが一致しません");

    }

    /**
     * constructor メソッドのテスト - 正常系：メッセージタイプとKMGリフレクションモデルを指定した場合
     *
     * @since 0.1.0
     */
    @Test
    public void testConstructor_normalWithMessageTypesAndModel() {

        /* テスト対象の実行 */
        final KmgCoreGenMsgTypes expectedMsgTypes = KmgCoreGenMsgTypes.KMGCORE_GEN11100;
        final String             expectedMessage  = "{0}がありません。";

        final KmgReflectionException testException
            = new KmgReflectionException(this.kmgReflectionModel, expectedMsgTypes);

        /* 検証の準備 */
        final String             actualMessage  = testException.getMessage();
        final KmgComExcMsgTypes  actualMsgTypes = testException.getMessageTypes();
        final KmgReflectionModel actualModel    = testException.getKmgReflectionModel();

        /* 検証の実施 */
        Assertions.assertEquals(expectedMsgTypes, actualMsgTypes, "メッセージタイプが一致しません");
        Assertions.assertEquals(expectedMessage, actualMessage, "メッセージが一致しません");
        Assertions.assertEquals(this.kmgReflectionModel, actualModel, "KMGリフレクションモデルが一致しません");

    }
}

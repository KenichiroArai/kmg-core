package kmg.core.infrastructure.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import kmg.core.domain.types.KmgCoreGenMessageTypes;
import kmg.core.infrastructure.common.KmgComGenMessageTypes;
import kmg.core.infrastructure.model.KmgReflectionModel;

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
     * メッセージタイプ
     *
     * @since 0.1.0
     */
    private KmgCoreGenMessageTypes messageTypes;

    /**
     * メッセージ
     *
     * @since 0.1.0
     */
    private String message;

    /**
     * デフォルトコンストラクタ<br>
     *
     * @since 0.1.0
     */
    public KmgReflectionExceptionTest() {

        // 処理なし
    }

    /**
     * 初期化処理<br>
     *
     * @since 0.1.0
     */
    @BeforeEach
    public void setUp() {

        /* 期待値の定義 */
        this.messageTypes = KmgCoreGenMessageTypes.KMGCORE_GEN11100;
        this.message = "{0}がありません。";

    }

    /**
     * constructor メソッドのテスト - 正常系：メッセージタイプ、メッセージ引数、原因、KMGリフレクションモデルを指定した場合
     *
     * @since 0.1.0
     */
    @Test
    public void testConstructor_normalWithMessageTypesAndArgsAndCauseAndModel() {

        /* 期待値の定義 */
        final Object[]  expectedMsgArgs = {
            "テスト引数1", "テスト引数2"
        };
        final String    expectedMessage = "テスト引数1がありません。";
        final Throwable expectedCause   = new RuntimeException("テスト原因");

        /* テスト対象の実行 */
        final KmgReflectionException testException
            = new KmgReflectionException(this.kmgReflectionModel, this.messageTypes, expectedMsgArgs, expectedCause);

        /* 検証の準備 */
        final String                   actualMessage  = testException.getMessage();
        final KmgComGenMessageTypes actualMsgTypes = testException.getMessageTypes();
        final Object[]                 actualMsgArgs  = testException.getMessageArgs();
        final Throwable                actualCause    = testException.getCause();
        final KmgReflectionModel       actualModel    = testException.getKmgReflectionModel();

        /* 検証の実施 */
        Assertions.assertEquals(this.messageTypes, actualMsgTypes, "メッセージタイプが一致しません");
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
        final Object[] expectedMsgArgs = {
            "テスト引数1", "テスト引数2"
        };
        final String   expectedMessage = "テスト引数1がありません。";

        /* テスト対象の実行 */
        final KmgReflectionException testException
            = new KmgReflectionException(this.kmgReflectionModel, this.messageTypes, expectedMsgArgs);

        /* 検証の準備 */
        final String                   actualMessage  = testException.getMessage();
        final KmgComGenMessageTypes actualMsgTypes = testException.getMessageTypes();
        final Object[]                 actualMsgArgs  = testException.getMessageArgs();
        final KmgReflectionModel       actualModel    = testException.getKmgReflectionModel();

        /* 検証の実施 */
        Assertions.assertEquals(this.messageTypes, actualMsgTypes, "メッセージタイプが一致しません");
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
        final Throwable expectedCause = new RuntimeException("テスト原因");

        /* テスト対象の実行 */
        final KmgReflectionException testException
            = new KmgReflectionException(this.kmgReflectionModel, this.messageTypes, expectedCause);

        /* 検証の準備 */
        final String                   actualMessage  = testException.getMessage();
        final KmgComGenMessageTypes actualMsgTypes = testException.getMessageTypes();
        final Throwable                actualCause    = testException.getCause();
        final KmgReflectionModel       actualModel    = testException.getKmgReflectionModel();

        /* 検証の実施 */
        Assertions.assertEquals(this.messageTypes, actualMsgTypes, "メッセージタイプが一致しません");
        Assertions.assertEquals(this.message, actualMessage, "メッセージが一致しません");
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
        final KmgReflectionException testException
            = new KmgReflectionException(this.kmgReflectionModel, this.messageTypes);

        /* 検証の準備 */
        final String                   actualMessage  = testException.getMessage();
        final KmgComGenMessageTypes actualMsgTypes = testException.getMessageTypes();
        final KmgReflectionModel       actualModel    = testException.getKmgReflectionModel();

        /* 検証の実施 */
        Assertions.assertEquals(this.messageTypes, actualMsgTypes, "メッセージタイプが一致しません");
        Assertions.assertEquals(this.message, actualMessage, "メッセージが一致しません");
        Assertions.assertEquals(this.kmgReflectionModel, actualModel, "KMGリフレクションモデルが一致しません");

    }
}

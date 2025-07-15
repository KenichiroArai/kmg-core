package kmg.core.infrastructure.model.val.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import kmg.core.infrastructure.cmn.msg.KmgCmnValMsgTypes;
import kmg.core.infrastructure.types.msg.KmgCoreValMsgTypes;

/**
 * KMGバリデーションデータモデルのテスト<br>
 *
 * @author KenichiroArai
 *
 * @since 0.2.0
 */
@SuppressWarnings({
    "nls", "static-method"
})
public class KmgValDataModelImplTest {

    /**
     * テスト用のメッセージタイプ
     */
    private static final KmgCoreValMsgTypes TEST_MESSAGE_TYPE = KmgCoreValMsgTypes.NONE;

    /**
     * テスト用のメッセージ引数
     */
    private static final Object[] TEST_MESSAGE_ARGS = {
        "テスト引数"
    };

    /**
     * コンストラクタのテスト - 正常系：正常にインスタンスが作成される場合
     */
    @Test
    public void testConstructor_normal() {

        /* 期待値の定義 */
        final KmgCoreValMsgTypes expectedMsgTypes = KmgValDataModelImplTest.TEST_MESSAGE_TYPE;
        final Object[]           expectedMsgArgs  = KmgValDataModelImplTest.TEST_MESSAGE_ARGS;

        /* テスト対象の実行 */
        final KmgValDataModelImpl testTarget = new KmgValDataModelImpl(expectedMsgTypes, expectedMsgArgs);

        /* 検証の準備 */
        final KmgCmnValMsgTypes actualMsgTypes = testTarget.getMessageTypes();
        final Object[]          actualMsgArgs  = testTarget.getMessageArgs();
        final String            actualMessage  = testTarget.getMessage();

        /* 検証の実施 */
        Assertions.assertNotNull(testTarget, "インスタンスが作成されていません");
        Assertions.assertEquals(expectedMsgTypes, actualMsgTypes, "メッセージタイプが一致しません");
        Assertions.assertArrayEquals(expectedMsgArgs, actualMsgArgs, "メッセージ引数が一致しません");
        Assertions.assertNotNull(actualMessage, "メッセージが作成されていません");

    }

    /**
     * getMessage メソッドのテスト - 正常系：正常にメッセージが取得される場合
     */
    @Test
    public void testGetMessage_normal() {

        /* 期待値の定義 */
        final KmgCoreValMsgTypes expectedMsgTypes = KmgValDataModelImplTest.TEST_MESSAGE_TYPE;
        final Object[]           expectedMsgArgs  = KmgValDataModelImplTest.TEST_MESSAGE_ARGS;

        /* テスト対象の実行 */
        final KmgValDataModelImpl testTarget = new KmgValDataModelImpl(expectedMsgTypes, expectedMsgArgs);

        /* 検証の準備 */
        final String actualMessage = testTarget.getMessage();

        /* 検証の実施 */
        Assertions.assertNotNull(actualMessage, "メッセージがnullではないです");
        Assertions.assertTrue(actualMessage.isEmpty(), "メッセージが空文字です");

    }

    /**
     * getMessageArgs メソッドのテスト - 正常系：正常にメッセージ引数が取得される場合
     */
    @Test
    public void testGetMessageArgs_normal() {

        /* 期待値の定義 */
        final KmgCoreValMsgTypes expectedMsgTypes = KmgValDataModelImplTest.TEST_MESSAGE_TYPE;
        final Object[]           expectedMsgArgs  = KmgValDataModelImplTest.TEST_MESSAGE_ARGS;

        /* テスト対象の実行 */
        final KmgValDataModelImpl testTarget = new KmgValDataModelImpl(expectedMsgTypes, expectedMsgArgs);

        /* 検証の準備 */
        final Object[] actualMsgArgs = testTarget.getMessageArgs();

        /* 検証の実施 */
        Assertions.assertNotNull(actualMsgArgs, "メッセージ引数がnullです");
        Assertions.assertArrayEquals(expectedMsgArgs, actualMsgArgs, "メッセージ引数が一致しません");

    }

    /**
     * getMessageTypes メソッドのテスト - 正常系：正常にメッセージタイプが取得される場合
     */
    @Test
    public void testGetMessageTypes_normal() {

        /* 期待値の定義 */
        final KmgCoreValMsgTypes expectedMsgTypes = KmgValDataModelImplTest.TEST_MESSAGE_TYPE;
        final Object[]           expectedMsgArgs  = KmgValDataModelImplTest.TEST_MESSAGE_ARGS;

        /* テスト対象の実行 */
        final KmgValDataModelImpl testTarget = new KmgValDataModelImpl(expectedMsgTypes, expectedMsgArgs);

        /* 検証の準備 */
        final KmgCmnValMsgTypes actualMsgTypes = testTarget.getMessageTypes();

        /* 検証の実施 */
        Assertions.assertNotNull(actualMsgTypes, "メッセージタイプがnullです");
        Assertions.assertEquals(expectedMsgTypes, actualMsgTypes, "メッセージタイプが一致しません");

    }
}

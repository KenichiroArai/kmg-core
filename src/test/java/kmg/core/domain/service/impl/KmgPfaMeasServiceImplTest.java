package kmg.core.domain.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

import kmg.core.infrastructure.model.KmgPfaMeasModel;
import kmg.core.infrastructure.types.KmgTimeUnitTypes;
import kmg.core.infrastructure.types.msg.KmgCoreLogMsgTypes;
import kmg.core.infrastructure.utils.KmgMessageUtils;

/**
 * KMG性能測定サービス実装のテスト<br>
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
public class KmgPfaMeasServiceImplTest {

    /**
     * デフォルトコンストラクタ<br>
     *
     * @since 0.1.0
     */
    public KmgPfaMeasServiceImplTest() {

        // 処理なし
    }

    /**
     * コンストラクタのテスト - 正常系:名称が正しく設定されることの確認
     * <p>
     * 保護された（protected）コンストラクタが同じパッケージ内から正しくアクセスできることを確認します。
     * </p>
     *
     * @since 0.1.0
     */
    @Test
    public void testConstructor_normalSetName() {

        /* 期待値の定義 */
        final String expectedName = "テスト測定";

        /* 準備 */
        final Logger                mockLogger = Mockito.mock(Logger.class);
        final KmgPfaMeasServiceImpl testTarget = new KmgPfaMeasServiceImpl(expectedName, mockLogger);

        /* テスト対象の実行 */
        testTarget.start();

        /* 検証の準備 */
        final String actualName = testTarget.getName();

        /* 検証の実施 */
        Assertions.assertEquals(expectedName, actualName, "名称が正しく設定されていること");

    }

    /**
     * コンストラクタ（名前のみ）のテスト - 正常系:名称が正しく設定されることの確認
     * <p>
     * 名前のみのコンストラクタを使用した場合に、名称が正しく設定されることを確認します。
     * </p>
     *
     * @since 0.1.0
     */
    @Test
    public void testConstructorWithOnlyName_normalSetName() {

        /* 期待値の定義 */
        final String expectedName = "テスト測定（名前のみ）";

        /* 準備 */
        final KmgPfaMeasServiceImpl testTarget = new KmgPfaMeasServiceImpl(expectedName);

        /* テスト対象の実行 */
        testTarget.start();

        /* 検証の準備 */
        final String actualName = testTarget.getName();

        /* 検証の実施 */
        Assertions.assertEquals(expectedName, actualName, "名前のみのコンストラクタで名称が正しく設定されていること");

    }

    /**
     * end メソッドのテスト - 正常系:終了メッセージが正しく出力されることの確認
     *
     * @since 0.1.0
     */
    @Test
    public void testEnd_normalOutputEndMessage() {

        /* 期待値の定義 */
        final String           expectedName        = "テスト測定";
        final double           expectedElapsedTime = 1.5;
        final KmgTimeUnitTypes expectedTimeUnit    = KmgTimeUnitTypes.SECONDS;

        // 期待されるログメッセージ
        final KmgCoreLogMsgTypes logType            = KmgCoreLogMsgTypes.KMGCORE_LOG12001;
        final Object[]               messageArgs        = {
            expectedName, expectedElapsedTime, expectedTimeUnit.getUnitName(),
        };
        final String                 expectedLogMessage = KmgMessageUtils.getLogMessage(logType, messageArgs);

        /* 準備 */
        final Logger          mockLogger = Mockito.mock(Logger.class);
        final KmgPfaMeasModel mockModel  = Mockito.mock(KmgPfaMeasModel.class);
        Mockito.when(mockModel.getElapsedTime()).thenReturn(expectedElapsedTime);
        Mockito.when(mockModel.getTimeUnit()).thenReturn(expectedTimeUnit);

        final KmgPfaMeasServiceImpl testTarget = new KmgPfaMeasServiceImpl(expectedName, mockLogger) {

            @Override
            protected KmgPfaMeasModel createKmgPfaMeasModel() {

                final KmgPfaMeasModel result = mockModel;
                return result;

            }
        };

        /* テスト対象の実行 */
        testTarget.start();
        testTarget.end();

        /* 検証の実施 */
        Mockito.verify(mockModel).start();
        Mockito.verify(mockModel).end();

        // ログメッセージの検証
        Mockito.verify(mockLogger).info(expectedLogMessage);

    }

    /**
     * start メソッドのテスト - 正常系:開始メッセージが正しく出力されることの確認
     *
     * @since 0.1.0
     */
    @Test
    public void testStart_normalOutputStartMessage() {

        /* 期待値の定義 */
        final String expectedName = "テスト測定";

        // 期待されるログメッセージ
        final KmgCoreLogMsgTypes logType            = KmgCoreLogMsgTypes.KMGCORE_LOG12000;
        final Object[]               messageArgs        = {
            expectedName,
        };
        final String                 expectedLogMessage = KmgMessageUtils.getLogMessage(logType, messageArgs);

        /* 準備 */
        final Logger          mockLogger = Mockito.mock(Logger.class);
        final KmgPfaMeasModel mockModel  = Mockito.mock(KmgPfaMeasModel.class);

        final KmgPfaMeasServiceImpl testTarget = new KmgPfaMeasServiceImpl(expectedName, mockLogger) {

            @Override
            protected KmgPfaMeasModel createKmgPfaMeasModel() {

                final KmgPfaMeasModel result = mockModel;
                return result;

            }
        };

        /* テスト対象の実行 */
        testTarget.start();

        /* 検証の実施 */
        Mockito.verify(mockModel).start();

        // ログメッセージの検証
        Mockito.verify(mockLogger).info(expectedLogMessage);

    }
}

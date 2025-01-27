package kmg.core.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import kmg.core.infrastructure.types.KmgTimeUnitTypes;

/**
 * KMG性能測定モデルテスト<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
public class KmgPfaMeasModelTest {

    /**
     * start メソッドのテスト - 開始時間が記録されることの確認
     */
    @Test
    @SuppressWarnings("static-method")
    public void testStart_recordStartTime() {

        /* 期待値の定義 */
        // 開始時間は0より大きい値が設定されることを期待

        /* 準備 */
        final KmgPfaMeasModel testTarget = new KmgPfaMeasModel();

        /* テスト対象の実行 */
        testTarget.start();

        /* 検証の準備 */
        final long actualStartTime = testTarget.getStartTime();

        /* 検証の実施 */
        Assertions.assertTrue(actualStartTime > 0, "開始時間が0より大きい値であること");

    }

    /**
     * end メソッドのテスト - ナノ秒の経過時間が正しく計算されることの確認
     */
    @Test
    @SuppressWarnings("static-method")
    public void testEnd_calculateElapsedTimeInNanoseconds() {

        /* 期待値の定義 */
        final KmgTimeUnitTypes expectedTimeUnit = KmgTimeUnitTypes.NANOSECONDS;

        /* 準備 */
        final KmgPfaMeasModel testTarget = new KmgPfaMeasModel();
        testTarget.start();

        /* テスト対象の実行 */
        testTarget.end();

        /* 検証の準備 */
        final long             actualStartTime   = testTarget.getStartTime();
        final long             actualEndTime     = testTarget.getEndTime();
        final double           actualElapsedTime = testTarget.getElapsedTime();
        final KmgTimeUnitTypes actualTimeUnit    = testTarget.getTimeUnit();

        /* 検証の実施 */
        Assertions.assertTrue(actualEndTime > actualStartTime, "終了時間が開始時間より大きいこと");
        Assertions.assertTrue(actualElapsedTime > 0, "経過時間が0より大きいこと");
        Assertions.assertEquals(expectedTimeUnit, actualTimeUnit, "時間単位がナノ秒であること");

    }

    /**
     * end メソッドのテスト - マイクロ秒の経過時間が正しく計算されることの確認
     *
     * @throws InterruptedException
     *                              スレッドの割り込みが発生した場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testEnd_calculateElapsedTimeInMicroseconds() throws InterruptedException {

        /* 期待値の定義 */
        final KmgTimeUnitTypes expectedTimeUnit = KmgTimeUnitTypes.MICROSECONDS;

        /* 準備 */
        final KmgPfaMeasModel testTarget = new KmgPfaMeasModel();
        testTarget.start();
        Thread.sleep(1); // 1ミリ秒待機して確実にマイクロ秒単位になるようにする

        /* テスト対象の実行 */
        testTarget.end();

        /* 検証の準備 */
        final KmgTimeUnitTypes actualTimeUnit = testTarget.getTimeUnit();

        /* 検証の実施 */
        Assertions.assertEquals(expectedTimeUnit, actualTimeUnit, "時間単位がマイクロ秒であること");

    }

    /**
     * end メソッドのテスト - ミリ秒の経過時間が正しく計算されることの確認
     *
     * @throws InterruptedException
     *                              スレッドの割り込みが発生した場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testEnd_calculateElapsedTimeInMilliseconds() throws InterruptedException {

        /* 期待値の定義 */
        final KmgTimeUnitTypes expectedTimeUnit = KmgTimeUnitTypes.MILLISECOND;

        /* 準備 */
        final KmgPfaMeasModel testTarget = new KmgPfaMeasModel();
        testTarget.start();
        Thread.sleep(2); // 2ミリ秒待機して確実にミリ秒単位になるようにする

        /* テスト対象の実行 */
        testTarget.end();

        /* 検証の準備 */
        final KmgTimeUnitTypes actualTimeUnit = testTarget.getTimeUnit();

        /* 検証の実施 */
        Assertions.assertEquals(expectedTimeUnit, actualTimeUnit, "時間単位がミリ秒であること");

    }

    /**
     * end メソッドのテスト - 秒の経過時間が正しく計算されることの確認
     *
     * @throws InterruptedException
     *                              スレッドの割り込みが発生した場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testEnd_calculateElapsedTimeInSeconds() throws InterruptedException {

        /* 期待値の定義 */
        final KmgTimeUnitTypes expectedTimeUnit = KmgTimeUnitTypes.SECONDS;

        /* 準備 */
        final KmgPfaMeasModel testTarget = new KmgPfaMeasModel();
        testTarget.start();
        Thread.sleep(1000); // 1秒待機して確実に秒単位になるようにする

        /* テスト対象の実行 */
        testTarget.end();

        /* 検証の準備 */
        final KmgTimeUnitTypes actualTimeUnit = testTarget.getTimeUnit();

        /* 検証の実施 */
        Assertions.assertEquals(expectedTimeUnit, actualTimeUnit, "時間単位が秒であること");

    }
}

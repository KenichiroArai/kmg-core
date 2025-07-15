package kmg.core.infrastructure.model.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import kmg.core.infrastructure.types.KmgTimeUnitTypes;

/**
 * KMG性能測定モデルテスト<br>
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
public class KmgPfaMeasModelImplTest {

    /**
     * 許容誤差
     *
     * @since 0.1.0
     */
    private static final double DELTA = 0.001;

    /**
     * デフォルトコンストラクタ<br>
     *
     * @since 0.1.0
     */
    public KmgPfaMeasModelImplTest() {

        // 処理なし
    }

    /**
     * checkpoint メソッドのテスト - 正常系:チェックポイント時間が正しく記録され、経過時間が計算されることの確認
     *
     * @since 0.2.0
     */
    @Test
    public void testCheckpoint_normalRecordCheckpointTimeAndCalculateElapsedTime() {

        /* 期待値の定義 */
        final long             expectedStartTime      = 1000L;
        final long             expectedCheckpointTime = 2000L;
        final double           expectedElapsedTime    = 1.0;
        final KmgTimeUnitTypes expectedTimeUnit       = KmgTimeUnitTypes.MICROSECONDS;

        /* 準備 */
        final KmgPfaMeasModelImpl testTarget
            = this.createKmgPfaMeasModelImpl(expectedStartTime, expectedCheckpointTime);

        /* テスト対象の実行 */
        testTarget.start();
        testTarget.checkpoint();

        /* 検証の準備 */
        final double           actualElapsedTime = testTarget.getElapsedTime();
        final KmgTimeUnitTypes actualTimeUnit    = testTarget.getTimeUnit();

        /* 検証の実施 */
        Assertions.assertEquals(expectedElapsedTime, actualElapsedTime, KmgPfaMeasModelImplTest.DELTA,
            "経過時間が期待値と一致すること");
        Assertions.assertEquals(expectedTimeUnit, actualTimeUnit, "時間単位がマイクロ秒であること");

    }

    /**
     * end メソッドのテスト - 正常系:マイクロ秒の経過時間が正しく計算されることの確認
     *
     * @since 0.1.0
     */
    @Test
    public void testEnd_normalCalculateElapsedTimeInMicroseconds() {

        /* 期待値の定義 */
        final long             expectedStartTime   = 1L;
        final long             expectedEndTime     = 2_000L;
        final double           expectedElapsedTime = 1.999;
        final KmgTimeUnitTypes expectedTimeUnit    = KmgTimeUnitTypes.MICROSECONDS;

        /* 準備 */
        final KmgPfaMeasModelImpl testTarget = this.createKmgPfaMeasModelImpl(expectedStartTime, expectedEndTime);

        /* テスト対象の実行 */
        testTarget.start();
        testTarget.end();

        /* 検証の準備 */
        final double           actualElapsedTime = testTarget.getElapsedTime();
        final KmgTimeUnitTypes actualTimeUnit    = testTarget.getTimeUnit();

        /* 検証の実施 */
        Assertions.assertEquals(expectedElapsedTime, actualElapsedTime, KmgPfaMeasModelImplTest.DELTA,
            "経過時間が期待値と一致すること");
        Assertions.assertEquals(expectedTimeUnit, actualTimeUnit, "時間単位がマイクロ秒であること");

    }

    /**
     * end メソッドのテスト - 正常系:ミリ秒の経過時間が正しく計算されることの確認
     *
     * @since 0.1.0
     */
    @Test
    public void testEnd_normalCalculateElapsedTimeInMilliseconds() {

        /* 期待値の定義 */
        final long             expectedStartTime   = 1000L;
        final long             expectedEndTime     = 2_000_000L;
        final double           expectedElapsedTime = 1.999999;
        final KmgTimeUnitTypes expectedTimeUnit    = KmgTimeUnitTypes.MILLISECOND;

        /* 準備 */
        final KmgPfaMeasModelImpl testTarget = this.createKmgPfaMeasModelImpl(expectedStartTime, expectedEndTime);

        /* テスト対象の実行 */
        testTarget.start();
        testTarget.end();

        /* 検証の準備 */
        final double           actualElapsedTime = testTarget.getElapsedTime();
        final KmgTimeUnitTypes actualTimeUnit    = testTarget.getTimeUnit();

        /* 検証の実施 */
        Assertions.assertEquals(expectedElapsedTime, actualElapsedTime, KmgPfaMeasModelImplTest.DELTA,
            "経過時間が期待値と一致すること");
        Assertions.assertEquals(expectedTimeUnit, actualTimeUnit, "時間単位がミリ秒であること");

    }

    /**
     * end メソッドのテスト - 正常系:ナノ秒の経過時間が正しく計算されることの確認
     *
     * @since 0.1.0
     */
    @Test
    public void testEnd_normalCalculateElapsedTimeInNanoseconds() {

        /* 期待値の定義 */
        final long             expectedStartTime   = 1000L;
        final long             expectedEndTime     = 1500L;
        final double           expectedElapsedTime = 500.0;
        final KmgTimeUnitTypes expectedTimeUnit    = KmgTimeUnitTypes.NANOSECONDS;

        /* 準備 */
        final KmgPfaMeasModelImpl testTarget = this.createKmgPfaMeasModelImpl(expectedStartTime, expectedEndTime);

        /* テスト対象の実行 */
        testTarget.start();
        testTarget.end();

        /* 検証の準備 */
        final long             actualStartTime   = testTarget.getStartTime();
        final long             actualEndTime     = testTarget.getEndTime();
        final double           actualElapsedTime = testTarget.getElapsedTime();
        final KmgTimeUnitTypes actualTimeUnit    = testTarget.getTimeUnit();

        /* 検証の実施 */
        Assertions.assertEquals(expectedStartTime, actualStartTime, "開始時間が期待値と一致すること");
        Assertions.assertEquals(expectedEndTime, actualEndTime, "終了時間が期待値と一致すること");
        Assertions.assertEquals(expectedElapsedTime, actualElapsedTime, KmgPfaMeasModelImplTest.DELTA,
            "経過時間が期待値と一致すること");
        Assertions.assertEquals(expectedTimeUnit, actualTimeUnit, "時間単位がナノ秒であること");

    }

    /**
     * end メソッドのテスト - 正常系:秒の経過時間が正しく計算されることの確認
     *
     * @since 0.1.0
     */
    @Test
    public void testEnd_normalCalculateElapsedTimeInSeconds() {

        /* 期待値の定義 */
        final long             expectedStartTime   = 1000L;
        final long             expectedEndTime     = 2_000_000_000_000L;
        final double           expectedElapsedTime = 1999.9999990000001;
        final KmgTimeUnitTypes expectedTimeUnit    = KmgTimeUnitTypes.SECONDS;

        /* 準備 */
        final KmgPfaMeasModelImpl testTarget = this.createKmgPfaMeasModelImpl(expectedStartTime, expectedEndTime);

        /* テスト対象の実行 */
        testTarget.start();
        testTarget.end();

        /* 検証の準備 */
        final double           actualElapsedTime = testTarget.getElapsedTime();
        final KmgTimeUnitTypes actualTimeUnit    = testTarget.getTimeUnit();

        /* 検証の実施 */
        Assertions.assertEquals(expectedElapsedTime, actualElapsedTime, KmgPfaMeasModelImplTest.DELTA,
            "経過時間が期待値と一致すること");
        Assertions.assertEquals(expectedTimeUnit, actualTimeUnit, "時間単位が秒であること");

    }

    /**
     * start メソッドのテスト - 正常系:開始時間が正しく記録されることの確認
     *
     * @since 0.1.0
     */
    @Test
    public void testStart_normalRecordStartTime() {

        /* 期待値の定義 */
        final long expectedStartTime = 1000L;

        /* 準備 */
        final KmgPfaMeasModelImpl testTarget = this.createKmgPfaMeasModelImpl(expectedStartTime);

        /* テスト対象の実行 */
        testTarget.start();

        /* 検証の準備 */
        final long actualStartTime = testTarget.getStartTime();

        /* 検証の実施 */
        Assertions.assertEquals(expectedStartTime, actualStartTime, "開始時間が期待値と一致すること");

    }

    /**
     * 指定された時間値でモック化された KmgPfaMeasModelImpl を作成する。
     * <p>
     * このメソッドは KmgPfaMeasModelImpl のスパイオブジェクトを作成し、getNow() が呼び出されたときに 返される連続的な時間値を設定します。
     * </p>
     *
     * @since 0.1.0
     *
     * @param times
     *              getNow() メソッドが返す連続的なタイムスタンプを表す可変長の long 値。 空の場合、モック化されていないスパイオブジェクトを返します。
     *
     * @return モック化された getNow() の動作を持つ KmgPfaMeasModelImpl のスパイオブジェクト
     */
    private KmgPfaMeasModelImpl createKmgPfaMeasModelImpl(final Long... times) {

        final KmgPfaMeasModelImpl result = Mockito.spy(new KmgPfaMeasModelImpl());

        if (times.length <= 0) {

            return result;

        }

        // 複数の戻り値を一度に設定するために、Mockito.when() を使用する
        final Long   firstTime      = times[0];
        final Long[] remainingTimes = new Long[times.length - 1];
        System.arraycopy(times, 1, remainingTimes, 0, remainingTimes.length);
        Mockito.when(result.getNow()).thenReturn(firstTime, remainingTimes);

        return result;

    }
}

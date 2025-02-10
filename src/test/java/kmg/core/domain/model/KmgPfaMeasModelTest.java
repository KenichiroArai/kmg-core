package kmg.core.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import kmg.core.infrastructure.types.KmgTimeUnitTypes;

/**
 * KMG性能測定モデルテスト<br>
 *
 * @author KenichiroArai
 *
 * @sine 1.0.0
 *
 * @version 1.0.0
 */
@SuppressWarnings("nls")
public class KmgPfaMeasModelTest {

    /** 許容誤差 */
    private static final double DELTA = 0.001;

    /**
     * end メソッドのテスト - マイクロ秒の経過時間が正しく計算されることの確認
     */
    @Test
    public void testEnd_calculateElapsedTimeInMicroseconds() {

        /* 期待値の定義 */
        final long             expectedStartTime   = 1L;
        final long             expectedEndTime     = 2_000L;
        final double           expectedElapsedTime = 1.999;
        final KmgTimeUnitTypes expectedTimeUnit    = KmgTimeUnitTypes.MICROSECONDS;

        /* 準備 */
        final KmgPfaMeasModel testTarget = this.createMockedModel(expectedStartTime, expectedEndTime);

        testTarget.start();
        testTarget.end();

        /* 検証の準備 */
        final double           actualElapsedTime = testTarget.getElapsedTime();
        final KmgTimeUnitTypes actualTimeUnit    = testTarget.getTimeUnit();

        /* 検証の実施 */
        Assertions.assertEquals(expectedElapsedTime, actualElapsedTime, KmgPfaMeasModelTest.DELTA, "経過時間が期待値と一致すること");
        Assertions.assertEquals(expectedTimeUnit, actualTimeUnit, "時間単位がマイクロ秒であること");

    }

    /**
     * end メソッドのテスト - ミリ秒の経過時間が正しく計算されることの確認
     */
    @Test
    public void testEnd_calculateElapsedTimeInMilliseconds() {

        /* 期待値の定義 */
        final long             expectedStartTime   = 1000L;
        final long             expectedEndTime     = 2_000_000L;
        final double           expectedElapsedTime = 1.999999;
        final KmgTimeUnitTypes expectedTimeUnit    = KmgTimeUnitTypes.MILLISECOND;

        /* 準備 */
        final KmgPfaMeasModel testTarget = this.createMockedModel(expectedStartTime, expectedEndTime);

        testTarget.start();
        testTarget.end();

        /* 検証の準備 */
        final double           actualElapsedTime = testTarget.getElapsedTime();
        final KmgTimeUnitTypes actualTimeUnit    = testTarget.getTimeUnit();

        /* 検証の実施 */
        Assertions.assertEquals(expectedElapsedTime, actualElapsedTime, KmgPfaMeasModelTest.DELTA, "経過時間が期待値と一致すること");
        Assertions.assertEquals(expectedTimeUnit, actualTimeUnit, "時間単位がミリ秒であること");

    }

    /**
     * end メソッドのテスト - ナノ秒の経過時間が正しく計算されることの確認
     */
    @Test
    public void testEnd_calculateElapsedTimeInNanoseconds() {

        /* 期待値の定義 */
        final long             expectedStartTime   = 1000L;
        final long             expectedEndTime     = 1500L;
        final double           expectedElapsedTime = 500.0;
        final KmgTimeUnitTypes expectedTimeUnit    = KmgTimeUnitTypes.NANOSECONDS;

        /* 準備 */
        final KmgPfaMeasModel testTarget = this.createMockedModel(expectedStartTime, expectedEndTime);

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
        Assertions.assertEquals(expectedElapsedTime, actualElapsedTime, KmgPfaMeasModelTest.DELTA, "経過時間が期待値と一致すること");
        Assertions.assertEquals(expectedTimeUnit, actualTimeUnit, "時間単位がナノ秒であること");

    }

    /**
     * end メソッドのテスト - 秒の経過時間が正しく計算されることの確認
     */
    @Test
    public void testEnd_calculateElapsedTimeInSeconds() {

        /* 期待値の定義 */
        final long             expectedStartTime   = 1000L;
        final long             expectedEndTime     = 2_000_000_000_000L;
        final double           expectedElapsedTime = 1999.9999990000001;
        final KmgTimeUnitTypes expectedTimeUnit    = KmgTimeUnitTypes.SECONDS;

        /* 準備 */
        final KmgPfaMeasModel testTarget = this.createMockedModel(expectedStartTime, expectedEndTime);

        testTarget.start();
        testTarget.end();

        /* 検証の準備 */
        final double           actualElapsedTime = testTarget.getElapsedTime();
        final KmgTimeUnitTypes actualTimeUnit    = testTarget.getTimeUnit();

        /* 検証の実施 */
        Assertions.assertEquals(expectedElapsedTime, actualElapsedTime, KmgPfaMeasModelTest.DELTA, "経過時間が期待値と一致すること");
        Assertions.assertEquals(expectedTimeUnit, actualTimeUnit, "時間単位が秒であること");

    }

    /**
     * start メソッドのテスト - 開始時間が記録されることの確認
     */
    @Test
    public void testStart_recordStartTime() {

        /* 期待値の定義 */
        final long expectedStartTime = 1000L;

        /* 準備 */
        final KmgPfaMeasModel testTarget = this.createMockedModel(expectedStartTime);

        /* テスト対象の実行 */
        testTarget.start();

        /* 検証の準備 */
        final long actualStartTime = testTarget.getStartTime();

        /* 検証の実施 */
        Assertions.assertEquals(expectedStartTime, actualStartTime, "開始時間が期待値と一致すること");

    }

    /**
     * 指定された時間値でモック化された KmgPfaMeasModel を作成する。
     * <p>
     * このメソッドは KmgPfaMeasModel のスパイオブジェクトを作成し、getNow() が呼び出されたときに 返される連続的な時間値を設定します。
     * </p>
     *
     * @param times
     *              getNow() メソッドが返す連続的なタイムスタンプを表す可変長の long 値。 空の場合、モック化されていないスパイオブジェクトを返します。
     *
     * @return モック化された getNow() の動作を持つ KmgPfaMeasModel のスパイオブジェクト
     */
    @SuppressWarnings("static-method")
    private KmgPfaMeasModel createMockedModel(final Long... times) {

        final KmgPfaMeasModel result = Mockito.spy(new KmgPfaMeasModel());

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

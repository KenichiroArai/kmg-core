package kmg.core.infrastructure.model;

import kmg.core.infrastructure.types.KmgTimeUnitTypes;

/**
 * KMG性能測定モデル<br>
 *
 * @author KenichiroArai
 *
 * @since 0.1.0
 *
 * @version 0.2.0
 */
public class KmgPfaMeasModel {

    /**
     * 開始時間
     *
     * @since 0.1.0
     */
    private long startTime;

    /**
     * 中間時間
     *
     * @since 0.2.0
     */
    private long intermediateTime;

    /**
     * 終了時間
     *
     * @since 0.1.0
     */
    private long endTime;

    /**
     * 経過時間
     *
     * @since 0.1.0
     */
    private double elapsedTime;

    /**
     * 時間単位
     *
     * @since 0.1.0
     */
    private KmgTimeUnitTypes timeUnit;

    /**
     * デフォルトコンストラクタ<br>
     *
     * @since 0.1.0
     */
    public KmgPfaMeasModel() {

        // 処理なし
    }

    /**
     * 終了<br>
     *
     * @since 0.1.0
     */
    public void end() {

        // 中間時間と終了時間の設定
        this.intermediateTime = this.getNow();
        this.endTime = this.intermediateTime;

        this.calculateElapsedTime();

    }

    /**
     * 経過時間を返す<br>
     *
     * @since 0.1.0
     *
     * @return 経過時間
     */
    public double getElapsedTime() {

        final double result = this.elapsedTime;
        return result;

    }

    /**
     * 終了時間を返す<br>
     *
     * @since 0.1.0
     *
     * @return 終了時間
     */
    public long getEndTime() {

        final long result = this.endTime;
        return result;

    }

    /**
     * 開始時間を返す<br>
     *
     * @since 0.1.0
     *
     * @return 開始時間
     */
    public long getStartTime() {

        final long result = this.startTime;
        return result;

    }

    /**
     * 時間単位を返す<br>
     *
     * @since 0.1.0
     *
     * @return 時間単位
     */
    public KmgTimeUnitTypes getTimeUnit() {

        final KmgTimeUnitTypes result = this.timeUnit;
        return result;

    }

    /**
     * 中間<br>
     *
     * @since 0.2.0
     */
    public void intermediate() {

        this.intermediateTime = this.getNow();

        this.calculateElapsedTime();

    }

    /**
     * 開始<br>
     *
     * @since 0.1.0
     */
    public void start() {

        this.startTime = this.getNow();

    }

    /**
     * 現在時刻を返す<br>
     *
     * @since 0.1.0
     *
     * @return 現在時刻
     */
    @SuppressWarnings("static-method")
    protected long getNow() {

        final long result = System.nanoTime();

        return result;

    }

    /**
     * 中間時間から経過時間と時間単位を計算します。<br>
     *
     * @since 0.2.0
     */
    private void calculateElapsedTime() {

        double           elapsedTimeTmp = this.intermediateTime - this.startTime;
        KmgTimeUnitTypes timeUnitTmp    = KmgTimeUnitTypes.NANOSECONDS;

        if (elapsedTimeTmp >= 1000.0) {

            elapsedTimeTmp /= 1000.0;
            timeUnitTmp = KmgTimeUnitTypes.MICROSECONDS;

        }

        if (elapsedTimeTmp >= 1000.0) {

            elapsedTimeTmp /= 1000.0;
            timeUnitTmp = KmgTimeUnitTypes.MILLISECOND;

        }

        if (elapsedTimeTmp >= 1000.0) {

            elapsedTimeTmp /= 1000.0;
            timeUnitTmp = KmgTimeUnitTypes.SECONDS;

        }

        this.elapsedTime = elapsedTimeTmp;
        this.timeUnit = timeUnitTmp;

    }

}

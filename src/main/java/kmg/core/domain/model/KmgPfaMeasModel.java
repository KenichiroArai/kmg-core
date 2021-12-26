package kmg.core.domain.model;

import kmg.core.infrastructure.types.KmgTimeUnitTypes;

/**
 * ＫＭＧ性能測定モデル<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
public class KmgPfaMeasModel {

    /** 開始時間 */
    private long startTime;

    /** 終了時間 */
    private long endTime;

    /** 経過時間 */
    private double elapsedTime;

    /** 時間単位 */
    private KmgTimeUnitTypes timeUnit;

    /**
     * 開始<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     */
    public void start() {
        this.startTime = System.nanoTime();
    }

    /**
     * 終了<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     */
    public void end() {
        this.endTime = System.nanoTime();

        /* 経過時間と時間単位を求める */
        double timeTmp = this.endTime - this.startTime;
        KmgTimeUnitTypes timeUnitTmp = KmgTimeUnitTypes.NANOSECONDS;
        if (timeTmp >= 1000.0) {
            timeTmp /= 1000.0;
            timeUnitTmp = KmgTimeUnitTypes.MICROSECONDS;
        }
        if (timeTmp >= 1000.0) {
            timeTmp /= 1000.0;
            timeUnitTmp = KmgTimeUnitTypes.MILLISECOND;
        }
        if (timeTmp >= 1000.0) {
            timeTmp /= 1000.0;
            timeUnitTmp = KmgTimeUnitTypes.SECONDS;
        }

        this.elapsedTime = timeTmp;
        this.timeUnit = timeUnitTmp;
    }

    /**
     * 開始時間を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 開始時間
     */
    public long getStartTime() {
        final long result = this.startTime;
        return result;
    }

    /**
     * 終了時間を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 終了時間
     */
    public long getEndTime() {
        final long result = this.endTime;
        return result;
    }

    /**
     * 経過時間を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 経過時間
     */
    public double getElapsedTime() {
        final double result = this.elapsedTime;
        return result;
    }

    /**
     * 時間単位を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 時間単位
     */
    public KmgTimeUnitTypes getTimeUnit() {
        final KmgTimeUnitTypes result = this.timeUnit;
        return result;
    }

}

package kmg.core.infrastructure.model.impl;

import kmg.core.infrastructure.model.KmgPfaMeasModel;
import kmg.core.infrastructure.types.KmgTimeUnitTypes;

/**
 * KMG性能測定モデル<br>
 * このクラスは、処理の実行時間を計測し、結果を適切な時間単位（ナノ秒、マイクロ秒、ミリ秒、秒）で表示するための機能を提供します。<br>
 * <br>
 * 【使用方法】<br>
 * 1. インスタンスを生成し、計測の準備を行います。（この時点でチェックポイント時間が初期化されます）<br>
 * 2. {@link #start()}メソッドを呼び出して計測を開始します。<br>
 * 3. 計測途中の時間を取得する場合は{@link #checkpoint()}メソッドを呼び出します。<br>
 * 4. 計測を終了する場合は{@link #end()}メソッドを呼び出します。<br>
 * 5. {@link #getElapsedTime()}と{@link #getTimeUnit()}で経過時間と単位を取得できます。<br>
 * <br>
 * 【使用例】<br>
 *
 * <pre>
 * {@code
 * KmgPfaMeasModelImpl measModel = new KmgPfaMeasModelImpl();
 * measModel.start();
 * // 処理を実行
 * measModel.checkpoint(); // 途中経過の計測（必要に応じて）
 * double checkpointTime = measModel.getElapsedTime();
 * KmgTimeUnitTypes checkpointUnit = measModel.getTimeUnit();
 * // さらに処理を実行
 * measModel.end();
 * double finalTime = measModel.getElapsedTime();
 * KmgTimeUnitTypes finalUnit = measModel.getTimeUnit();
 * }
 * </pre>
 *
 * @author KenichiroArai
 *
 * @since 0.2.0
 *
 * @version 0.2.0
 */
public class KmgPfaMeasModelImpl implements KmgPfaMeasModel {

    /**
     * 開始時間<br>
     * {@link #start()}メソッドが呼ばれたときのシステム時間（ナノ秒）
     *
     * @since 0.2.0
     */
    private long startTime;

    /**
     * チェックポイント時間<br>
     * {@link #checkpoint()}または{@link #end()}メソッドが呼ばれたときのシステム時間（ナノ秒）
     *
     * @since 0.2.0
     */
    private long checkpointTime;

    /**
     * 終了時間<br>
     * {@link #end()}メソッドが呼ばれたときのシステム時間（ナノ秒）
     *
     * @since 0.2.0
     */
    private long endTime;

    /**
     * 経過時間<br>
     * 計測開始から最後のチェックポイントまたは終了時点までの経過時間<br>
     * 時間単位は{@link #timeUnit}によって決定される
     *
     * @since 0.2.0
     */
    private double elapsedTime;

    /**
     * 時間単位<br>
     * 経過時間の単位（ナノ秒、マイクロ秒、ミリ秒、秒）<br>
     * 経過時間の大きさに応じて自動的に適切な単位が選択される
     *
     * @since 0.2.0
     */
    private KmgTimeUnitTypes timeUnit;

    /**
     * デフォルトコンストラクタ<br>
     * 計測の準備をします。チェックポイント時間を現在時刻で初期化します。<br>
     * 実際の計測を開始するには{@link #start()}メソッドを呼び出してください。<br>
     * <br>
     * 注：コンストラクタ実行時に{@link #checkpointTime}が現在時刻で初期化されます。
     *
     * @since 0.2.0
     */
    public KmgPfaMeasModelImpl() {

        this.checkpointTime = this.getNow();

    }

    /**
     * チェックポイント<br>
     * 計測開始からこのメソッドが呼ばれるまでの経過時間を計算します。<br>
     * このメソッドの呼び出し後、{@link #getElapsedTime()}と{@link #getTimeUnit()}で 開始時点からチェックポイントまでの経過時間と単位を取得できます。<br>
     * <br>
     * 注：計測を終了する場合は{@link #end()}メソッドを使用してください。
     *
     * @since 0.2.0
     */
    @Override
    public void checkpoint() {

        this.checkpointTime = this.getNow();

        this.calculateElapsedTime();

    }

    /**
     * 終了<br>
     * 計測を終了し、開始時点から終了時点までの経過時間を計算します。<br>
     * このメソッドの呼び出し後、{@link #getElapsedTime()}と{@link #getTimeUnit()}で 開始時点から終了時点までの経過時間と単位を取得できます。<br>
     * <br>
     * 注：計測の途中経過を知りたい場合は{@link #checkpoint()}メソッドを使用してください。
     *
     * @since 0.2.0
     */
    @Override
    public void end() {

        // チェックポイント時間と終了時間の設定
        this.checkpointTime = this.getNow();
        this.endTime = this.checkpointTime;

        this.calculateElapsedTime();

    }

    /**
     * 経過時間を返す<br>
     * 最後に{@link #checkpoint()}または{@link #end()}が呼ばれた時点での 開始時点からの経過時間を返します。<br>
     * 時間の単位は{@link #getTimeUnit()}メソッドで取得できます。<br>
     * <br>
     * 注：このメソッドを呼び出す前に、インスタンスを生成し、{@link #start()}と{@link #checkpoint()}または{@link #end()}を 呼び出す必要があります。
     *
     * @since 0.2.0
     *
     * @return 経過時間（単位は{@link #getTimeUnit()}で取得可能）
     */
    @Override
    public double getElapsedTime() {

        final double result = this.elapsedTime;
        return result;

    }

    /**
     * 終了時間を返す<br>
     * {@link #end()}メソッドが呼ばれたときのシステム時間（ナノ秒）を返します。<br>
     * <br>
     * 注：このメソッドを呼び出す前に{@link #end()}を呼び出す必要があります。
     *
     * @since 0.2.0
     *
     * @return 終了時間（ナノ秒）
     */
    @Override
    public long getEndTime() {

        final long result = this.endTime;
        return result;

    }

    /**
     * 開始時間を返す<br>
     * {@link #start()}メソッドが呼ばれたときのシステム時間（ナノ秒）を返します。<br>
     * <br>
     * 注：このメソッドを呼び出す前に{@link #start()}を呼び出す必要があります。
     *
     * @since 0.2.0
     *
     * @return 開始時間（ナノ秒）
     */
    @Override
    public long getStartTime() {

        final long result = this.startTime;
        return result;

    }

    /**
     * 時間単位を返す<br>
     * 経過時間の単位（ナノ秒、マイクロ秒、ミリ秒、秒）を返します。<br>
     * 単位は経過時間の大きさに応じて自動的に適切なものが選択されます。<br>
     * <br>
     * 注：このメソッドを呼び出す前に、{@link #start()}と{@link #checkpoint()}または{@link #end()}を 呼び出す必要があります。
     *
     * @since 0.2.0
     *
     * @return 時間単位（{@link KmgTimeUnitTypes}の値）
     */
    @Override
    public KmgTimeUnitTypes getTimeUnit() {

        final KmgTimeUnitTypes result = this.timeUnit;
        return result;

    }

    /**
     * 開始<br>
     * パフォーマンス計測を開始します。このメソッドは計測の最初に呼び出す必要があります。<br>
     * 計測を途中で確認する場合は{@link #checkpoint()}を、 計測を終了する場合は{@link #end()}を呼び出してください。<br>
     * <br>
     * 注：このメソッドを呼び出した後、{@link #checkpoint()}または{@link #end()}を呼び出すまで 経過時間は計算されません。
     *
     * @since 0.2.0
     */
    @Override
    public void start() {

        this.startTime = this.getNow();

    }

    /**
     * 現在時刻を返す<br>
     * システムのナノ秒精度の現在時刻を取得します。<br>
     * このメソッドは内部で使用され、{@link System#nanoTime()}を呼び出します。
     *
     * @since 0.2.0
     *
     * @return 現在時刻（ナノ秒）
     */
    @SuppressWarnings("static-method")
    protected long getNow() {

        final long result = System.nanoTime();

        return result;

    }

    /**
     * チェックポイント時間から経過時間と時間単位を計算します。<br>
     * 開始時間からチェックポイント時間までの経過時間を計算し、 その大きさに応じて適切な時間単位（ナノ秒、マイクロ秒、ミリ秒、秒）を設定します。<br>
     * <br>
     * 計算結果は{@link #elapsedTime}と{@link #timeUnit}に保存され、 それぞれ{@link #getElapsedTime()}と{@link #getTimeUnit()}で取得できます。
     *
     * @since 0.2.0
     */
    private void calculateElapsedTime() {

        double           elapsedTimeTmp = this.checkpointTime - this.startTime;
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

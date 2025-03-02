package kmg.core.domain.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kmg.core.domain.service.KmgPfaMeasService;
import kmg.core.domain.types.KmgLogMessageTypes;
import kmg.core.infrastructure.model.KmgPfaMeasModel;
import kmg.core.infrastructure.model.impl.KmgPfaMeasModelImpl;
import kmg.core.infrastructure.utils.KmgMessageUtils;

/**
 * KMG性能測定サービスの実装クラス。
 * <p>
 * このクラスは、KMG性能測定サービスを提供します。
 * </p>
 *
 * @author KenichiroArai
 *
 * @since 0.1.0
 *
 * @version 0.2.0
 */
public class KmgPfaMeasServiceImpl implements KmgPfaMeasService {

    /**
     * ロガー
     *
     * @since 0.1.0
     */
    private final Logger logger;

    /**
     * 名称
     *
     * @since 0.1.0
     */
    private final String name;

    /**
     * KMG性能測定モデル
     *
     * @since 0.1.0
     */
    private final KmgPfaMeasModel kmgPfaMeasModel;

    /**
     * コンストラクタ<br>
     *
     * @since 0.1.0
     *
     * @param name
     *             名称
     */
    public KmgPfaMeasServiceImpl(final String name) {

        this(name, LoggerFactory.getLogger(KmgPfaMeasServiceImpl.class));

    }

    /**
     * テスト用コンストラクタ<br>
     *
     * @since 0.1.0
     *
     * @param name
     *               名称
     * @param logger
     *               ロガー
     */
    protected KmgPfaMeasServiceImpl(final String name, final Logger logger) {

        this.name = name;
        this.logger = logger;
        this.kmgPfaMeasModel = this.createKmgPfaMeasModel();

    }

    /**
     * 測定を終了します。
     * <p>
     * 測定を終了し、経過時間をログに出力します。
     * </p>
     *
     * @since 0.1.0
     */
    @Override
    public void end() {

        /* 測定終了 */
        this.kmgPfaMeasModel.end();

        /* ログの出力 */
        final KmgLogMessageTypes logType     = KmgLogMessageTypes.KMGLOGI12001;
        final Object[]           messageArgs = {
            this.name, this.kmgPfaMeasModel.getElapsedTime(), this.kmgPfaMeasModel.getTimeUnit().getUnitName(),
        };
        final String             msg         = KmgMessageUtils.getMessage(logType, messageArgs);
        this.logger.info(msg);

    }

    /**
     * エラーメッセージを出力します。
     * <p>
     * 経過時間をログに出力します。
     * </p>
     *
     * @since 0.2.0
     */
    @Override
    public void error() {

        /* チェックポイント */
        this.kmgPfaMeasModel.checkpoint();

        /* ログの出力 */
        final KmgLogMessageTypes logType     = KmgLogMessageTypes.KMGLOGI12002;
        final Object[]           messageArgs = {
            this.name, this.kmgPfaMeasModel.getElapsedTime(), this.kmgPfaMeasModel.getTimeUnit().getUnitName(),
        };
        final String             msg         = KmgMessageUtils.getMessage(logType, messageArgs);
        this.logger.error(msg);

    }

    /**
     * 名称を取得します。
     *
     * @return 名称
     */
    public String getName() {

        final String result = this.name;
        return result;

    }

    /**
     * 情報メッセージを出力します。
     * <p>
     * 経過時間をログに出力します。
     * </p>
     *
     * @since 0.2.0
     */
    @Override
    public void info() {

        /* チェックポイント */
        this.kmgPfaMeasModel.checkpoint();

        /* ログの出力 */
        final KmgLogMessageTypes logType     = KmgLogMessageTypes.KMGLOGI12003;
        final Object[]           messageArgs = {
            this.name, this.kmgPfaMeasModel.getElapsedTime(), this.kmgPfaMeasModel.getTimeUnit().getUnitName(),
        };
        final String             msg         = KmgMessageUtils.getMessage(logType, messageArgs);
        this.logger.info(msg);

    }

    /**
     * 測定を開始します。
     * <p>
     * 測定を開始し、開始メッセージをログに出力します。
     * </p>
     *
     * @since 0.1.0
     */
    @Override
    public void start() {

        /* ログの出力 */
        final KmgLogMessageTypes logType     = KmgLogMessageTypes.KMGLOGI12000;
        final Object[]           messageArgs = {
            this.name,
        };
        final String             msg         = KmgMessageUtils.getMessage(logType, messageArgs);
        this.logger.info(msg);

        /* 測定開始 */
        this.kmgPfaMeasModel.start();

    }

    /**
     * 警告メッセージを出力します。
     * <p>
     * 経過時間をログに出力します。
     * </p>
     *
     * @since 0.2.0
     */
    @Override
    public void warn() {

        /* チェックポイント */
        this.kmgPfaMeasModel.checkpoint();

        /* ログの出力 */
        final KmgLogMessageTypes logType     = KmgLogMessageTypes.KMGLOGI12004;
        final Object[]           messageArgs = {
            this.name, this.kmgPfaMeasModel.getElapsedTime(), this.kmgPfaMeasModel.getTimeUnit().getUnitName(),
        };
        final String             msg         = KmgMessageUtils.getMessage(logType, messageArgs);
        this.logger.warn(msg);

    }

    /**
     * KMG性能測定モデルを生成します。
     * <p>
     * 新しいKMG性能測定モデルを生成して返します。
     * </p>
     *
     * @return KMG性能測定モデル
     */
    @SuppressWarnings("static-method")
    protected KmgPfaMeasModel createKmgPfaMeasModel() {

        final KmgPfaMeasModel result = new KmgPfaMeasModelImpl();
        return result;

    }
}

package kmg.core.domain.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kmg.core.domain.service.KmgPfaMeasService;
import kmg.core.domain.types.KmgLogMessageTypes;
import kmg.core.infrastructure.model.KmgPfaMeasModel;
import kmg.core.infrastructure.utils.KmgMessageUtils;

/**
 * KMG性能測定サービス<br>
 *
 * @author KenichiroArai
 *
 * @since 0.1.0
 *
 * @version 0.1.0
 */
public class KmgPfaMeasServiceImpl implements KmgPfaMeasService {

    /** ロガー */
    private static final Logger LOG = LoggerFactory.getLogger(KmgPfaMeasServiceImpl.class);

    /**
     * 名称
     *
     * @author KenichiroArai
     *
     * @since 0.1.0
     *
     * @version 0.1.0
     */
    private final String name;

    /**
     * KMG性能測定モデル
     *
     * @author KenichiroArai
     *
     * @since 0.1.0
     *
     * @version 0.1.0
     */
    private final KmgPfaMeasModel kmgPfaMeasModel;

    /**
     * コンストラクタ<br>
     *
     * @author KenichiroArai
     *
     * @since 0.1.0
     *
     * @version 0.1.0
     *
     * @param name
     *             名称
     */
    public KmgPfaMeasServiceImpl(final String name) {

        this.name = name;
        this.kmgPfaMeasModel = this.createKmgPfaMeasModel();

    }

    /**
     * 終了<br>
     *
     * @author KenichiroArai
     *
     * @since 0.1.0
     *
     * @version 0.1.0
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
        KmgPfaMeasServiceImpl.LOG.info(msg);

    }

    /**
     * 開始<br>
     *
     * @author KenichiroArai
     *
     * @since 0.1.0
     *
     * @version 0.1.0
     */
    @Override
    public void start() {

        /* ログの出力 */
        final KmgLogMessageTypes logType     = KmgLogMessageTypes.KMGLOGI12000;
        final Object[]           messageArgs = {
            this.name,
        };
        final String             msg         = KmgMessageUtils.getMessage(logType, messageArgs);
        KmgPfaMeasServiceImpl.LOG.info(msg);

        this.kmgPfaMeasModel.start();

    }

    /**
     * KMG性能測定モデルを生成する<br>
     *
     * @author KenichiroArai
     *
     * @since 0.1.0
     *
     * @version 0.1.0
     *
     * @return KMG性能測定モデル
     */
    @SuppressWarnings("static-method")
    protected KmgPfaMeasModel createKmgPfaMeasModel() {

        final KmgPfaMeasModel result = new KmgPfaMeasModel();
        return result;

    }

}

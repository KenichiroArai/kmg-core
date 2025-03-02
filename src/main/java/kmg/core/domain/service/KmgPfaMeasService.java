package kmg.core.domain.service;

/**
 * KMG性能測定サービスインタフェース<br>
 *
 * @author KenichiroArai
 *
 * @since 0.1.0
 *
 * @version 0.2.0
 */
public interface KmgPfaMeasService {

    /**
     * 終了<br>
     *
     * @since 0.1.0
     */
    void end();

    /**
     * エラーメッセージを出力します。
     * <p>
     * 経過時間をログに出力します。
     * </p>
     *
     * @since 0.2.0
     */
    void error();

    /**
     * 情報メッセージを出力します。
     * <p>
     * 経過時間をログに出力します。
     * </p>
     *
     * @since 0.2.0
     */
    void info();

    /**
     * 開始<br>
     *
     * @since 0.1.0
     */
    void start();

    /**
     * 警告メッセージを出力します。
     * <p>
     * 経過時間をログに出力します。
     * </p>
     *
     * @since 0.2.0
     */
    void warn();

}

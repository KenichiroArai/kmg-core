package kmg.core.infrastructure.exception;

/**
 * KMG例外<br>
 *
 * @author KenichiroArai
 *
 * @since 0.1.0
 *
 * @version 0.2.0
 */
public class KmgException extends Exception {

    /**
     * デフォルトシリアルバージョンUID
     *
     * @since 0.1.0
     */
    private static final long serialVersionUID = 1L;

    /**
     * コンストラクタ<br>
     *
     * @since 0.1.0
     *
     * @param cause
     *              原因
     */
    public KmgException(final Throwable cause) {

        super(cause);

    }

}

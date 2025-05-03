package kmg.core.infrastructure.exception;

import kmg.core.infrastructure.common.KmgComValMessageTypes;

/**
 * KMGバリデーション例外<br>
 *
 * @author KenichiroArai
 *
 * @since 0.2.0
 *
 * @version 0.2.0
 */
public class KmgValidationException extends KmgException {

    /**
     * デフォルトシリアルバージョンＵＩＤ
     *
     * @since 0.2.0
     */
    private static final long serialVersionUID = 1L;

    /**
     * コンストラクタ<br>
     *
     * @since 0.2.0
     *
     * @param messageTypes
     *                     メッセージの種類
     */
    public KmgValidationException(final KmgComValMessageTypes messageTypes) {

        this(messageTypes, null, null);

    }

    /**
     * コンストラクタ<br>
     *
     * @since 0.2.0
     *
     * @param messageTypes
     *                     メッセージの種類
     * @param messageArgs
     *                     メッセージの引数
     */
    public KmgValidationException(final KmgComValMessageTypes messageTypes, final Object[] messageArgs) {

        this(messageTypes, messageArgs, null);

    }

    /**
     * コンストラクタ<br>
     *
     * @since 0.2.0
     *
     * @param messageTypes
     *                     メッセージの種類
     * @param messageArgs
     *                     メッセージの引数
     * @param cause
     *                     原因
     */
    public KmgValidationException(final KmgComValMessageTypes messageTypes, final Object[] messageArgs,
        final Throwable cause) {

        super(messageTypes, messageArgs, cause);

    }

    /**
     * コンストラクタ<br>
     *
     * @since 0.2.0
     *
     * @param messageTypes
     *                     メッセージの種類
     * @param cause
     *                     原因
     */
    public KmgValidationException(final KmgComValMessageTypes messageTypes, final Throwable cause) {

        this(messageTypes, null, cause);

    }

}

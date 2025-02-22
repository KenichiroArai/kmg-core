package kmg.core.infrastructure.exception;

import kmg.core.infrastructure.common.KmgMessageTypes;
import kmg.core.infrastructure.model.KmgReflectionModel;

/**
 * KMGリフレクション例外<br>
 *
 * @author KenichiroArai
 *
 * @sine 1.0.0
 *
 * @version 1.0.0
 */
public class KmgReflectionException extends KmgDomainException {

    /** デフォルトシリアルバージョンＵＩＤ */
    private static final long serialVersionUID = 1L;

    /** KMGリフレクションモデル */
    private final KmgReflectionModel kmgReflectionModel;

    /**
     * コンストラクタ<br>
     *
     * @author KenichiroArai
     *
     * @sine 1.0.0
     *
     * @version 1.0.0
     *
     * @param kmgReflectionModel
     *                           KMGリフレクションモデル
     * @param messageTypes
     *                           メッセージの種類
     */
    public KmgReflectionException(final KmgReflectionModel kmgReflectionModel, final KmgMessageTypes messageTypes) {

        this(kmgReflectionModel, messageTypes, null, null);

    }

    /**
     * コンストラクタ<br>
     *
     * @author KenichiroArai
     *
     * @sine 1.0.0
     *
     * @version 1.0.0
     *
     * @param kmgReflectionModel
     *                           KMGリフレクションモデル
     * @param messageTypes
     *                           メッセージの種類
     * @param messageArgs
     *                           メッセージの引数
     */
    public KmgReflectionException(final KmgReflectionModel kmgReflectionModel, final KmgMessageTypes messageTypes,
        final Object[] messageArgs) {

        this(kmgReflectionModel, messageTypes, messageArgs, null);

    }

    /**
     * コンストラクタ<br>
     *
     * @author KenichiroArai
     *
     * @sine 1.0.0
     *
     * @version 1.0.0
     *
     * @param kmgReflectionModel
     *                           KMGリフレクションモデル
     * @param messageTypes
     *                           メッセージの種類
     * @param messageArgs
     *                           メッセージの引数
     * @param cause
     *                           原因
     */
    public KmgReflectionException(final KmgReflectionModel kmgReflectionModel, final KmgMessageTypes messageTypes,
        final Object[] messageArgs, final Throwable cause) {

        super(messageTypes, messageArgs, cause);
        this.kmgReflectionModel = kmgReflectionModel;

    }

    /**
     * コンストラクタ<br>
     *
     * @author KenichiroArai
     *
     * @sine 1.0.0
     *
     * @version 1.0.0
     *
     * @param kmgReflectionModel
     *                           KMGリフレクションモデル
     * @param messageTypes
     *                           メッセージの種類
     * @param cause
     *                           原因
     */
    public KmgReflectionException(final KmgReflectionModel kmgReflectionModel, final KmgMessageTypes messageTypes,
        final Throwable cause) {

        this(kmgReflectionModel, messageTypes, null, cause);

    }

    /**
     * KMGリフレクションモデルを返す<br>
     *
     * @author KenichiroArai
     *
     * @sine 1.0.0
     *
     * @version 1.0.0
     *
     * @return KMGリフレクションモデル
     */
    public KmgReflectionModel getKmgReflectionModel() {

        final KmgReflectionModel result = this.kmgReflectionModel;
        return result;

    }

}

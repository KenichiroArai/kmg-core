package kmg.core.infrastructure.exception;

import kmg.core.infrastructure.cmn.msg.KmgComExcMsgTypes;
import kmg.core.infrastructure.model.KmgReflectionModel;

/**
 * KMGリフレクション例外<br>
 *
 * @author KenichiroArai
 *
 * @since 0.1.0
 *
 * @version 0.2.0
 */
public class KmgReflectionException extends KmgMsgException {

    /**
     * デフォルトシリアルバージョンＵＩＤ
     *
     * @since 0.1.0
     */
    private static final long serialVersionUID = 1L;

    /**
     * KMGリフレクションモデル
     *
     * @since 0.1.0
     */
    private final KmgReflectionModel kmgReflectionModel;

    /**
     * コンストラクタ<br>
     *
     * @since 0.1.0
     *
     * @param kmgReflectionModel
     *                           KMGリフレクションモデル
     * @param messageTypes
     *                           メッセージの種類
     */
    public KmgReflectionException(final KmgReflectionModel kmgReflectionModel, final KmgComExcMsgTypes messageTypes) {

        this(kmgReflectionModel, messageTypes, null, null);

    }

    /**
     * コンストラクタ<br>
     *
     * @since 0.1.0
     *
     * @param kmgReflectionModel
     *                           KMGリフレクションモデル
     * @param messageTypes
     *                           メッセージの種類
     * @param messageArgs
     *                           メッセージの引数
     */
    public KmgReflectionException(final KmgReflectionModel kmgReflectionModel, final KmgComExcMsgTypes messageTypes,
        final Object[] messageArgs) {

        this(kmgReflectionModel, messageTypes, messageArgs, null);

    }

    /**
     * コンストラクタ<br>
     *
     * @since 0.1.0
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
    public KmgReflectionException(final KmgReflectionModel kmgReflectionModel, final KmgComExcMsgTypes messageTypes,
        final Object[] messageArgs, final Throwable cause) {

        super(messageTypes, messageArgs, cause);
        this.kmgReflectionModel = kmgReflectionModel;

    }

    /**
     * コンストラクタ<br>
     *
     * @since 0.1.0
     *
     * @param kmgReflectionModel
     *                           KMGリフレクションモデル
     * @param messageTypes
     *                           メッセージの種類
     * @param cause
     *                           原因
     */
    public KmgReflectionException(final KmgReflectionModel kmgReflectionModel, final KmgComExcMsgTypes messageTypes,
        final Throwable cause) {

        this(kmgReflectionModel, messageTypes, null, cause);

    }

    /**
     * KMGリフレクションモデルを返す<br>
     *
     * @since 0.1.0
     *
     * @return KMGリフレクションモデル
     */
    public KmgReflectionModel getKmgReflectionModel() {

        final KmgReflectionModel result = this.kmgReflectionModel;
        return result;

    }

}

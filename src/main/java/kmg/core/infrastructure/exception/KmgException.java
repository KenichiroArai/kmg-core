package kmg.core.infrastructure.exception;

import kmg.core.infrastructure.types.KmgMsgMessageTypes;
import kmg.core.infrastructure.utils.KmgMessageUtils;

/**
 * KMG例外<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
public class KmgException extends Exception {

    /** デフォルトシリアルバージョンUID */
    private static final long serialVersionUID = 1L;

    /** メッセージメッセージの種類 */
    private KmgMsgMessageTypes messageTypes;

    /** メッセージメッセージの引数 */
    private Object[] messageArgs;

    /** メッセージ */
    private final String message;

    /**
     * コンストラクタ<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param messageTypes
     *                     メッセージの種類
     */
    public KmgException(final KmgMsgMessageTypes messageTypes) {

        this.message = KmgMessageUtils.getMessage(messageTypes, null);

    }

    /**
     * コンストラクタ<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param messageTypes
     *                     メッセージの種類
     * @param messageArgs
     *                     メッセージの引数
     */
    public KmgException(final KmgMsgMessageTypes messageTypes, final Object[] messageArgs) {

        this.message = KmgMessageUtils.getMessage(messageTypes, messageArgs);

    }

    /**
     * コンストラクタ<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param messageTypes
     *                     メッセージの種類
     * @param cause
     *                     原因
     */
    public KmgException(final KmgMsgMessageTypes messageTypes, final Throwable cause) {

        super(cause);
        this.message = KmgMessageUtils.getMessage(messageTypes, null);

    }

    /**
     * コンストラクタ<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param messageTypes
     *                     メッセージの種類
     * @param messageArgs
     *                     メッセージの引数
     * @param cause
     *                     原因
     */
    public KmgException(final KmgMsgMessageTypes messageTypes, final Object[] messageArgs, final Throwable cause) {

        super(cause);
        this.message = KmgMessageUtils.getMessage(messageTypes, messageArgs);

    }

    /**
     * メッセージを返す。<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return メッセージ
     */
    @Override
    public String getMessage() {

        final String result = this.message;
        return result;

    }

    /**
     * メッセージの引数を返す。<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return メッセージの引数
     */
    public Object[] getMessageArgs() {

        final Object[] result = this.messageArgs;
        return result;

    }

    /**
     * メッセージの種類を返す。<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return メッセージの種類
     */
    public KmgMsgMessageTypes getMessageTypes() {

        final KmgMsgMessageTypes result = this.messageTypes;
        return result;

    }
}

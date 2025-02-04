package kmg.core.infrastructure.exception;

import org.springframework.beans.factory.annotation.Autowired;

import kmg.core.infrastructure.context.KmgMessageSource;
import kmg.core.infrastructure.types.KmgMsgMessageTypes;

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

    /** メッセージソース */
    @Autowired
    private KmgMessageSource kmgMessageSource;

    /** メッセージ */
    private String message;

    /** メッセージの種類 */
    private final KmgMsgMessageTypes messageTypes;

    /** メッセージの引数 */
    private final Object[] messageArgs;

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

        this(messageTypes, messageArgs, null);

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
        this.messageTypes = messageTypes;
        this.messageArgs = messageArgs;

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

        this(messageTypes, null, cause);

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

        String result = null;

        if (this.message == null) {

            this.message = this.kmgMessageSource.getMessage(this.messageTypes, this.messageArgs);

        }

        result = this.message;
        return result;

    }

    /**
     * メッセージの引数を返す<br>
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
     * メッセージの種類を返す<br>
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

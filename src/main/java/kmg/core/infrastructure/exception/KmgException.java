package kmg.core.infrastructure.exception;

import kmg.core.infrastructure.type.KmgString;
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
    private final KmgMsgMessageTypes messageTypes;

    /** メッセージメッセージの引数 */
    private final Object[] messageArgs;

    /** メッセージ */
    private final String message;

    /** メッセージ引数の数 */
    private int messageArgsCount;

    /** メッセージパターンの引数の数 */
    private int messagePatternArgsCount;

    /** メッセージ引数の数が一致しているか */
    private boolean isMatchMessageArgsCount;

    /** メッセージパターン */
    private final String messagePattern;

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

        this(messageTypes, null, null);

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
        this.messagePattern = KmgMessageUtils.getMessagePattern(messageTypes);
        this.message = KmgMessageUtils.getMessage(messageTypes, messageArgs);

        /* メッセージカウントの初期化 */
        this.setMessageCounts();

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
     * メッセージ引数の数を返す。<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return メッセージ引数の数
     */
    public int getMessageArgsCount() {

        final int result = this.messageArgsCount;
        return result;

    }

    /**
     * メッセージパターンの引数の数を返す。<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return メッセージパターンの引数の数
     */
    public int getMessagePatternArgsCount() {

        final int result = this.messagePatternArgsCount;
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

    /**
     * メッセージ引数の数が一致しているかを返す。<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return メッセージ引数の数が一致しているか
     */
    public boolean isMatchMessageArgsCount() {

        final boolean result = this.isMatchMessageArgsCount;
        return result;

    }

    /**
     * メッセージパターンを返す。<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return メッセージパターン
     */
    public String getMessagePattern() {

        final String result = this.messagePattern;
        return result;

    }

    /**
     * メッセージカウントを設定する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     */
    private void setMessageCounts() {

        /* メッセージ引数の数を計算する */
        this.messageArgsCount = 0;

        if (this.messageArgs != null) {

            this.messageArgsCount = this.messageArgs.length;

        }

        /* メッセージパターンの引数の数を計算する */
        if (KmgString.isEmpty(this.messagePattern)) {

            return;

        }
        this.messagePatternArgsCount = KmgMessageUtils.getMessageArgsCount(this.messagePattern);

        /* メッセージ引数の数とメッセージパターンの引数の数を比較する */
        this.isMatchMessageArgsCount = (this.messagePatternArgsCount == this.messageArgsCount);

    }
}

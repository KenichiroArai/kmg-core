package kmg.core.infrastructure.exception;

import kmg.core.infrastructure.common.KmgMessageTypes;
import kmg.core.infrastructure.utils.KmgMessageUtils;

/**
 * KMG例外<br>
 *
 * @author KenichiroArai
 *
 * @since 0.1.0
 *
 * @version 0.1.0
 */
public class KmgException extends Exception {

    /**
     * デフォルトシリアルバージョンUID
     *
     * @author KenichiroArai
     *
     * @since 0.1.0
     *
     * @version 0.1.0
     */
    private static final long serialVersionUID = 1L;

    /**
     * メッセージメッセージの種類
     *
     * @author KenichiroArai
     *
     * @since 0.1.0
     *
     * @version 0.1.0
     */
    private final KmgMessageTypes messageTypes;

    /**
     * メッセージメッセージの引数
     *
     * @author KenichiroArai
     *
     * @since 0.1.0
     *
     * @version 0.1.0
     */
    private final Object[] messageArgs;

    /**
     * メッセージ
     *
     * @author KenichiroArai
     *
     * @since 0.1.0
     *
     * @version 0.1.0
     */
    private final String message;

    /**
     * メッセージ引数の数
     *
     * @author KenichiroArai
     *
     * @since 0.1.0
     *
     * @version 0.1.0
     */
    private int messageArgsCount;

    /**
     * メッセージパターンの引数の数
     *
     * @author KenichiroArai
     *
     * @since 0.1.0
     *
     * @version 0.1.0
     */
    private int messagePatternArgsCount;

    /**
     * メッセージ引数の数が一致しているか
     *
     * @author KenichiroArai
     *
     * @since 0.1.0
     *
     * @version 0.1.0
     */
    private boolean isMatchMessageArgsCount;

    /**
     * メッセージパターン
     *
     * @author KenichiroArai
     *
     * @since 0.1.0
     *
     * @version 0.1.0
     */
    private final String messagePattern;

    /**
     * コンストラクタ<br>
     *
     * @author KenichiroArai
     *
     * @since 0.1.0
     *
     * @version 0.1.0
     *
     * @param messageTypes
     *                     メッセージの種類
     */
    public KmgException(final KmgMessageTypes messageTypes) {

        this(messageTypes, null, null);

    }

    /**
     * コンストラクタ<br>
     *
     * @author KenichiroArai
     *
     * @since 0.1.0
     *
     * @version 0.1.0
     *
     * @param messageTypes
     *                     メッセージの種類
     * @param messageArgs
     *                     メッセージの引数
     */
    public KmgException(final KmgMessageTypes messageTypes, final Object[] messageArgs) {

        this(messageTypes, messageArgs, null);

    }

    /**
     * コンストラクタ<br>
     *
     * @author KenichiroArai
     *
     * @since 0.1.0
     *
     * @version 0.1.0
     *
     * @param messageTypes
     *                     メッセージの種類
     * @param messageArgs
     *                     メッセージの引数
     * @param cause
     *                     原因
     */
    public KmgException(final KmgMessageTypes messageTypes, final Object[] messageArgs, final Throwable cause) {

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
     *
     * @since 0.1.0
     *
     * @version 0.1.0
     *
     * @param messageTypes
     *                     メッセージの種類
     * @param cause
     *                     原因
     */
    public KmgException(final KmgMessageTypes messageTypes, final Throwable cause) {

        this(messageTypes, null, cause);

    }

    /**
     * メッセージを返す。<br>
     *
     * @author KenichiroArai
     *
     * @since 0.1.0
     *
     * @version 0.1.0
     *
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
     *
     * @since 0.1.0
     *
     * @version 0.1.0
     *
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
     *
     * @since 0.1.0
     *
     * @version 0.1.0
     *
     * @return メッセージ引数の数
     */
    public int getMessageArgsCount() {

        final int result = this.messageArgsCount;
        return result;

    }

    /**
     * メッセージパターンを返す。<br>
     *
     * @author KenichiroArai
     *
     * @since 0.1.0
     *
     * @version 0.1.0
     *
     * @return メッセージパターン
     */
    public String getMessagePattern() {

        final String result = this.messagePattern;
        return result;

    }

    /**
     * メッセージパターンの引数の数を返す。<br>
     *
     * @author KenichiroArai
     *
     * @since 0.1.0
     *
     * @version 0.1.0
     *
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
     *
     * @since 0.1.0
     *
     * @version 0.1.0
     *
     * @return メッセージの種類
     */
    public KmgMessageTypes getMessageTypes() {

        final KmgMessageTypes result = this.messageTypes;
        return result;

    }

    /**
     * メッセージ引数の数が一致しているかを返す。<br>
     *
     * @author KenichiroArai
     *
     * @since 0.1.0
     *
     * @version 0.1.0
     *
     * @return メッセージ引数の数が一致しているか
     */
    public boolean isMatchMessageArgsCount() {

        final boolean result = this.isMatchMessageArgsCount;
        return result;

    }

    /**
     * メッセージカウントを設定する<br>
     *
     * @author KenichiroArai
     *
     * @since 0.1.0
     *
     * @version 0.1.0
     */
    private void setMessageCounts() {

        /* メッセージ引数の数を計算する */
        this.messageArgsCount = 0;

        if (this.messageArgs != null) {

            this.messageArgsCount = this.messageArgs.length;

        }

        /* メッセージパターンの引数の数を計算する */
        this.messagePatternArgsCount = KmgMessageUtils.getMessageArgsCount(this.messagePattern);

        /* メッセージ引数の数とメッセージパターンの引数の数を比較する */
        this.isMatchMessageArgsCount = (this.messagePatternArgsCount == this.messageArgsCount);

    }
}

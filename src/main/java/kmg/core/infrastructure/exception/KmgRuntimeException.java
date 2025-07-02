package kmg.core.infrastructure.exception;

import kmg.core.infrastructure.cmn.msg.KmgCmnExcMsgTypes;
import kmg.core.infrastructure.utils.KmgMessageUtils;

/**
 * KMG実行時例外<br>
 *
 * @author KenichiroArai
 *
 * @since 0.2.0
 *
 * @version 0.2.0
 */
public class KmgRuntimeException extends RuntimeException {

    /**
     * デフォルトシリアルバージョンUID
     *
     * @since 0.2.0
     */
    private static final long serialVersionUID = 1L;

    /**
     * 例外メッセージの種類
     *
     * @since 0.2.0
     */
    private final KmgCmnExcMsgTypes messageTypes;

    /**
     * 例外メッセージの引数
     *
     * @since 0.2.0
     */
    private final Object[] messageArgs;

    /**
     * メッセージ
     *
     * @since 0.2.0
     */
    private final String message;

    /**
     * メッセージ引数の数
     *
     * @since 0.2.0
     */
    private int messageArgsCount;

    /**
     * メッセージパターンの引数の数
     *
     * @since 0.2.0
     */
    private int messagePatternArgsCount;

    /**
     * メッセージ引数の数が一致しているか
     *
     * @since 0.2.0
     */
    private boolean isMatchMessageArgsCount;

    /**
     * メッセージパターン
     *
     * @since 0.2.0
     */
    private final String messagePattern;

    /**
     * コンストラクタ<br>
     *
     * @since 0.2.0
     *
     * @param messageTypes
     *                     メッセージの種類
     */
    public KmgRuntimeException(final KmgCmnExcMsgTypes messageTypes) {

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
    public KmgRuntimeException(final KmgCmnExcMsgTypes messageTypes, final Object[] messageArgs) {

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
    public KmgRuntimeException(final KmgCmnExcMsgTypes messageTypes, final Object[] messageArgs,
        final Throwable cause) {

        super(cause);
        this.messageTypes = messageTypes;
        this.messageArgs = messageArgs;

        this.createMessageSource();

        this.messagePattern = this.createMessagePattern();
        this.message = this.createMessage();

        /* メッセージカウントの初期化 */
        this.setMessageCounts();

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
    public KmgRuntimeException(final KmgCmnExcMsgTypes messageTypes, final Throwable cause) {

        this(messageTypes, null, cause);

    }

    /**
     * メッセージを返す。<br>
     *
     * @since 0.2.0
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
     * @since 0.2.0
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
     * @since 0.2.0
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
     * @since 0.2.0
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
     * @since 0.2.0
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
     * @since 0.2.0
     *
     * @return メッセージの種類
     */
    public KmgCmnExcMsgTypes getMessageTypes() {

        final KmgCmnExcMsgTypes result = this.messageTypes;
        return result;

    }

    /**
     * メッセージ引数の数が一致しているかを返す。<br>
     *
     * @since 0.2.0
     *
     * @return メッセージ引数の数が一致しているか
     */
    public boolean isMatchMessageArgsCount() {

        final boolean result = this.isMatchMessageArgsCount;
        return result;

    }

    /**
     * メッセージを作成して返す。
     *
     * @since 0.2.0
     *
     * @return メッセージ
     */
    protected String createMessage() {

        final String result = KmgMessageUtils.getExcMessage(this.messageTypes, this.messageArgs);
        return result;

    }

    /**
     * メッセージパターンを作成し、返す。
     *
     * @since 0.2.0
     *
     * @return メッセージパターン
     */
    protected String createMessagePattern() {

        final String result = this.messageTypes.getValue();
        return result;

    }

    /**
     * メッセージソースを作成する。
     *
     * @since 0.2.0
     */
    protected void createMessageSource() {

        // KmgMessageUtilsを使用するため、処理なし
    }

    /**
     * メッセージカウントを設定する<br>
     *
     * @since 0.2.0
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

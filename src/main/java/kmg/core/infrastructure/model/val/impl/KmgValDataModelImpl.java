package kmg.core.infrastructure.model.val.impl;

import kmg.core.infrastructure.cmn.msg.KmgCmnValMsgTypes;
import kmg.core.infrastructure.model.val.KmgValDataModel;
import kmg.core.infrastructure.utils.KmgMessageUtils;

/**
 * KMGバリデーションデータモデル<br>
 * <p>
 * Valは、Validationの略。
 * </p>
 *
 * @author KenichiroArai
 *
 * @since 0.2.0
 *
 * @version 0.2.0
 */
public class KmgValDataModelImpl implements KmgValDataModel {

    /**
     * メッセージの種類
     *
     * @since 0.2.0
     */
    private final KmgCmnValMsgTypes messageTypes;

    /**
     * メッセージの引数
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
     * コンストラクタ<br>
     *
     * @since 0.2.0
     *
     * @param messageTypes
     *                     メッセージの種類
     * @param messageArgs
     *                     メッセージの引数
     */
    public KmgValDataModelImpl(final KmgCmnValMsgTypes messageTypes, final Object[] messageArgs) {

        this.messageTypes = messageTypes;
        this.messageArgs = messageArgs;

        this.createMessageSource();

        this.message = this.createMessage();

    }

    /**
     * メッセージを返す。
     *
     * @return メッセージ
     *
     * @since 0.2.0
     */
    @Override
    public String getMessage() {

        final String result = this.message;
        return result;

    }

    /**
     * メッセージの引数を返す<br>
     *
     * @since 0.2.0
     *
     * @return メッセージの引数
     */
    @Override
    public Object[] getMessageArgs() {

        final Object[] result = this.messageArgs;
        return result;

    }

    /**
     * メッセージの種類を返す<br>
     *
     * @since 0.2.0
     *
     * @return メッセージの種類
     */
    @Override
    public KmgCmnValMsgTypes getMessageTypes() {

        final KmgCmnValMsgTypes result = this.messageTypes;
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
     * メッセージソースを作成する。
     *
     * @since 0.2.0
     */
    protected void createMessageSource() {

        // KmgMessageUtilsを使用するため、処理なし
    }

}

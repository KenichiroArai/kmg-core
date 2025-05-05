package kmg.core.infrastructure.model.val.impl;

import kmg.core.infrastructure.common.KmgComValMessageTypes;
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

    /** メッセージの種類 */
    private final KmgComValMessageTypes messageTypes;

    /** メッセージの引数 */
    private final Object[] messageArgs;

    /** メッセージ */
    private final String message;

    /**
     * コンストラクタ<br>
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     *
     * @param messageTypes
     *                     メッセージの種類
     * @param messageArgs
     *                     メッセージの引数
     */
    public KmgValDataModelImpl(final KmgComValMessageTypes messageTypes, final Object[] messageArgs) {

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
     * @author KenichiroArai
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
     * @author KenichiroArai
     *
     * @since 0.2.0
     *
     * @return メッセージの種類
     */
    @Override
    public KmgComValMessageTypes getMessageTypes() {

        final KmgComValMessageTypes result = this.messageTypes;
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

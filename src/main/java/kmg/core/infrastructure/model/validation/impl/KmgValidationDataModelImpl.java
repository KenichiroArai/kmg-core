package kmg.core.infrastructure.model.validation.impl;

import kmg.core.infrastructure.common.KmgComValMessageTypes;
import kmg.core.infrastructure.model.validation.KmgValidationDataModel;

/**
 * KMGバリデーションデータモデル<br>
 *
 * @author KenichiroArai
 *
 * @since 0.2.0
 *
 * @version 0.2.0
 */
public class KmgValidationDataModelImpl implements KmgValidationDataModel {

    /** メッセージの種類 */
    private final KmgComValMessageTypes msgTypes;

    /** メッセージの引数 */
    private final Object[] messageArgs;

    /**
     * コンストラクタ<br>
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     *
     * @param msgTypes
     *                    メッセージの種類
     * @param messageArgs
     *                    メッセージの引数
     */
    public KmgValidationDataModelImpl(final KmgComValMessageTypes msgTypes, final Object[] messageArgs) {

        this.msgTypes = msgTypes;
        this.messageArgs = messageArgs;

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
    public KmgComValMessageTypes getMsgTypes() {

        final KmgComValMessageTypes result = this.msgTypes;
        return result;

    }

}

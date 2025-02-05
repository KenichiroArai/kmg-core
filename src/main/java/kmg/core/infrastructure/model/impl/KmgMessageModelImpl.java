package kmg.core.infrastructure.model.impl;

import kmg.core.infrastructure.context.KmgMessageSource;
import kmg.core.infrastructure.model.KmgMessageModel;
import kmg.core.infrastructure.types.KmgMsgMessageTypes;

/**
 * メッセージモデルの実装<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
public class KmgMessageModelImpl implements KmgMessageModel {

    /** メッセージの種類 */
    private final KmgMsgMessageTypes messageTypes;

    /** メッセージの引数 */
    private final Object[] messageArgs;

    /** KMGメッセージリソース */
    private final KmgMessageSource kmgMessageSource;

    /**
     * コンストラクタ<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param messageTypes
     *                         メッセージの種類
     * @param messageArgs
     *                         メッセージの引数
     * @param kmgMessageSource
     *                         KMGメッセージリソース
     */
    public KmgMessageModelImpl(final KmgMsgMessageTypes messageTypes, final Object[] messageArgs,
        final KmgMessageSource kmgMessageSource) {

        this.messageTypes = messageTypes;
        this.messageArgs = messageArgs;
        this.kmgMessageSource = kmgMessageSource;

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getMessage() {

        final String result = this.kmgMessageSource.getMessage(this.messageTypes, this.messageArgs);
        return result;

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object[] getMessageArgs() {

        return this.messageArgs;

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public KmgMsgMessageTypes getMessageTypes() {

        return this.messageTypes;

    }

}

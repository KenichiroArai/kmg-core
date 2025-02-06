package kmg.core.infrastructure.model.impl;

import kmg.core.infrastructure.model.KmgMessageModel;
import kmg.core.infrastructure.types.KmgMsgMessageTypes;
import kmg.core.infrastructure.utils.KmgMessageUtils;
import java.text.MessageFormat;

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
    public KmgMessageModelImpl(final KmgMsgMessageTypes messageTypes, final Object[] messageArgs) {

        this.messageTypes = messageTypes;
        this.messageArgs = messageArgs;

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getMessage() {

        String messagePattern = KmgMessageUtils.getMessage(this.messageTypes);

        if (this.messageArgs != null && this.messageArgs.length > 0) {

            return MessageFormat.format(messagePattern, this.messageArgs);

        }
        return messagePattern;

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

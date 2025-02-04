package kmg.core.infrastructure.model.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kmg.core.infrastructure.context.KmgMessageSource;
import kmg.core.infrastructure.model.KmgMessageModel;
import kmg.core.infrastructure.model.impl.KmgMessageModelImpl;
import kmg.core.infrastructure.types.KmgMsgMessageTypes;

/**
 * KMGメッセージモデルファクトリ<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
@Component
public class KmgMessageModelFactory {

    /** KMGメッセージリソース */
    @Autowired
    private KmgMessageSource kmgMessageSource;

    /**
     * メッセージモデルを作成する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param messageTypes
     *                     メッセージの種類
     * @return メッセージモデル
     */
    public KmgMessageModel create(final KmgMsgMessageTypes messageTypes) {

        final KmgMessageModel result = this.create(messageTypes, null);
        return result;

    }

    /**
     * メッセージモデルを作成する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param messageTypes
     *                     メッセージの種類
     * @param args
     *                     引数
     * @return メッセージモデル
     */
    public KmgMessageModel create(final KmgMsgMessageTypes messageTypes, final Object[] args) {

        final KmgMessageModel result = new KmgMessageModelImpl(messageTypes, args, this.kmgMessageSource);
        return result;

    }
}

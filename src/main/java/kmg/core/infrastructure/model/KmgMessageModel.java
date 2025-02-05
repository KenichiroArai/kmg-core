package kmg.core.infrastructure.model;

import kmg.core.infrastructure.types.KmgMsgMessageTypes;

/**
 * メッセージモデルのインタフェース
 */
public interface KmgMessageModel {

    /**
     * メッセージを返す。<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return メッセージ
     */
    String getMessage();

    /**
     * メッセージの引数を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return メッセージの引数
     */
    Object[] getMessageArgs();

    /**
     * メッセージの種類を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return メッセージの種類
     */
    KmgMsgMessageTypes getMessageTypes();

}

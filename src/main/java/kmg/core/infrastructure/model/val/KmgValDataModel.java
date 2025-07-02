package kmg.core.infrastructure.model.val;

import kmg.core.infrastructure.cmn.msg.KmgCmnValMsgTypes;

/**
 * KMGバリデーションデータモデルインタフェース<br>
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
public interface KmgValDataModel {

    /**
     * メッセージを返す。
     *
     * @return メッセージ
     *
     * @since 0.2.0
     */
    String getMessage();

    /**
     * メッセージの引数を返す<br>
     *
     * @since 0.2.0
     *
     * @return メッセージの引数
     */
    Object[] getMessageArgs();

    /**
     * メッセージの種類を返す<br>
     *
     * @since 0.2.0
     *
     * @return メッセージの種類
     */
    KmgCmnValMsgTypes getMessageTypes();

}

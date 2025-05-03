package kmg.core.infrastructure.model.validation;

import kmg.core.infrastructure.common.KmgComValMessageTypes;

/**
 * KMGバリデーションデータモデルインタフェース<br>
 *
 * @author KenichiroArai
 *
 * @since 0.2.0
 *
 * @version 0.2.0
 */
public interface KmgValidationDataModel {

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
     * @author KenichiroArai
     *
     * @since 0.2.0
     *
     * @return メッセージの引数
     */
    Object[] getMessageArgs();

    /**
     * メッセージの種類を返す<br>
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     *
     * @return メッセージの種類
     */
    KmgComValMessageTypes getMessageTypes();

}

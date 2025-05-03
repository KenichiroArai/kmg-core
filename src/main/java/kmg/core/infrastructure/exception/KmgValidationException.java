package kmg.core.infrastructure.exception;

import kmg.core.infrastructure.model.validation.KmgValidationsModel;

/**
 * KMGバリデーション例外<br>
 *
 * @author KenichiroArai
 *
 * @since 0.2.0
 *
 * @version 0.2.0
 */
public class KmgValidationException extends KmgMsgException {

    /**
     * デフォルトシリアルバージョンＵＩＤ
     *
     * @since 0.2.0
     */
    private static final long serialVersionUID = 1L;

    /** KMGバリデーション集合モデル */
    private final KmgValidationsModel validationsModel;

    /**
     * コンストラクタ<br>
     *
     * @since 0.2.0
     *
     * @param validationsModel
     *                         KMGバリデーション集合モデル
     */
    public KmgValidationException(final KmgValidationsModel validationsModel) {

        this(validationsModel, null);

    }

    /**
     * コンストラクタ<br>
     *
     * @since 0.2.0
     *
     * @param validationsModel
     *                         KMGバリデーション集合モデル
     * @param cause
     *                         原因
     */
    public KmgValidationException(final KmgValidationsModel validationsModel, final Throwable cause) {

        super(null, cause);

        this.validationsModel = validationsModel;

    }

    /**
     * KMGバリデーション集合モデルを返す<br>
     *
     * @since 0.2.0
     *
     * @return KMGバリデーション集合モデル
     */
    public KmgValidationsModel getValidationsModel() {

        final KmgValidationsModel result = this.validationsModel;
        return result;

    }

}

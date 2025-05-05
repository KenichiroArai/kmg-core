package kmg.core.infrastructure.exception;

import kmg.core.infrastructure.model.validation.KmgValsModel;

/**
 * KMGバリデーション例外<br>
 *
 * @author KenichiroArai
 *
 * @since 0.2.0
 *
 * @version 0.2.0
 */
public class KmgValidationException extends KmgException {

    /**
     * デフォルトシリアルバージョンＵＩＤ
     *
     * @since 0.2.0
     */
    private static final long serialVersionUID = 1L;

    /** KMGバリデーション集合モデル */
    private final KmgValsModel validationsModel;

    /**
     * コンストラクタ<br>
     *
     * @since 0.2.0
     *
     * @param validationsModel
     *                         KMGバリデーション集合モデル
     */
    public KmgValidationException(final KmgValsModel validationsModel) {

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
    public KmgValidationException(final KmgValsModel validationsModel, final Throwable cause) {

        super(cause);

        this.validationsModel = validationsModel;

    }

    /**
     * KMGバリデーション集合モデルを返す<br>
     *
     * @since 0.2.0
     *
     * @return KMGバリデーション集合モデル
     */
    public KmgValsModel getValidationsModel() {

        final KmgValsModel result = this.validationsModel;
        return result;

    }

}

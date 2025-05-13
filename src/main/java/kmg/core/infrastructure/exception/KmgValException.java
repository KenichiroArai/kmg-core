package kmg.core.infrastructure.exception;

import kmg.core.infrastructure.model.val.KmgValsModel;

/**
 * KMGバリデーション例外<br>
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
public class KmgValException extends KmgException {

    /**
     * デフォルトシリアルバージョンＵＩＤ
     *
     * @since 0.2.0
     */
    private static final long serialVersionUID = 1L;

    /**
     * KMGバリデーション集合モデル
     *
     * @since 0.2.0
     */
    private final KmgValsModel validationsModel;

    /**
     * コンストラクタ<br>
     *
     * @since 0.2.0
     *
     * @param validationsModel
     *                         KMGバリデーション集合モデル
     */
    public KmgValException(final KmgValsModel validationsModel) {

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
    public KmgValException(final KmgValsModel validationsModel, final Throwable cause) {

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

package kmg.core.infrastructure.exception;

import kmg.core.infrastructure.model.KmgMessageModel;

/**
 * KMGドメイン例外<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
public class KmgDomainException extends KmgException {

    /** デフォルトシリアルバージョンＵＩＤ */
    private static final long serialVersionUID = 1L;

    /**
     * コンストラクタ<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param kmgMessageModel
     *                    メッセージモデル
     */
    public KmgDomainException(final KmgMessageModel kmgMessageModel) {

        super(kmgMessageModel);

    }

    /**
     * コンストラクタ<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param kmgMessageModel
     *                    メッセージモデル
     * @param cause
     *                    原因
     */
    public KmgDomainException(final KmgMessageModel kmgMessageModel, final Throwable cause) {

        super(kmgMessageModel, cause);

    }

}

package kmg.core.infrastructure.exception;

import kmg.core.infrastructure.model.KmgMessageModel;

/**
 * KMG例外<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
public class KmgException extends Exception {

    /** デフォルトシリアルバージョンUID */
    private static final long serialVersionUID = 1L;

    /** メッセージモデル */
    private final KmgMessageModel kmgMessageModel;

    /**
     * コンストラクタ<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param kmgMessageModel
     *                    メッセージモデル
     */
    public KmgException(final KmgMessageModel kmgMessageModel) {

        this(kmgMessageModel, null);

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
    public KmgException(final KmgMessageModel kmgMessageModel, final Throwable cause) {

        super(cause);
        this.kmgMessageModel = kmgMessageModel;

    }

    /**
     * メッセージを返す。<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return メッセージ
     */
    @Override
    public String getMessage() {

        final String result = this.kmgMessageModel.getMessage();
        return result;

    }

    /**
     * メッセージモデルを返す。
     *
     * @return メッセージモデル
     */
    public KmgMessageModel getMessageInfo() {

        final KmgMessageModel result = this.kmgMessageModel;

        return result;

    }

}

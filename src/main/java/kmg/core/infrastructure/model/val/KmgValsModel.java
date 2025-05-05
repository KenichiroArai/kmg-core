package kmg.core.infrastructure.model.val;

import java.util.List;

/**
 * KMGバリデーション集合モデルインタフェース<br>
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
public interface KmgValsModel {

    /**
     * データを追加する。
     *
     * @param data
     *             追加するデータ
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    void addData(KmgValDataModel data);

    /**
     * データのリストを返す。
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     *
     * @return データのリスト
     */
    List<KmgValDataModel> getDatas();

}

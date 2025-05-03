package kmg.core.infrastructure.model.validation;

import java.util.List;

/**
 * KMGバリデーション集合モデルインタフェース<br>
 *
 * @author KenichiroArai
 *
 * @since 0.2.0
 *
 * @version 0.2.0
 */
public interface KmgValidationsModel {

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
    void addData(KmgValidationDataModel data);

    /**
     * データのリストを返す。
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     *
     * @return データのリスト
     */
    List<KmgValidationDataModel> getDatas();

}

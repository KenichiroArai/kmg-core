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
     * KMGバリデーションのリストを返す。
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     *
     * @return KMGバリデーションのリスト
     */
    List<KmgValidationModel> getKmgValidations();

}

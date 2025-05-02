package kmg.core.infrastructure.model.validation;

import java.util.List;

/**
 * KMGバリデーションモデルインタフェース<br>
 *
 * @author KenichiroArai
 *
 * @since 0.2.0
 *
 * @version 0.2.0
 */
public interface KmgValidationsModel {

    /**
     * KMGバリデーションを返す。
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     *
     * @return KMGバリデーション
     */
    List<KmgValidationModel> getKmgValidations();

}

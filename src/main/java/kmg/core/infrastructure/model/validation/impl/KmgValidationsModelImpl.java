package kmg.core.infrastructure.model.validation.impl;

import java.util.ArrayList;
import java.util.List;

import kmg.core.infrastructure.model.validation.KmgValidationDataModel;
import kmg.core.infrastructure.model.validation.KmgValidationsModel;

/**
 * KMGバリデーション集合モデル<br>
 *
 * @author KenichiroArai
 *
 * @since 0.2.0
 *
 * @version 0.2.0
 */
public class KmgValidationsModelImpl implements KmgValidationsModel {

    /**
     * データのリスト
     */
    private final List<KmgValidationDataModel> datas;

    /**
     * コンストラクタ
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    public KmgValidationsModelImpl() {

        this.datas = new ArrayList<>();

    }

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
    @Override
    public void addData(final KmgValidationDataModel data) {

        /* 引数チェック */
        if (data == null) {

            return;

        }

        /* データを追加 */
        this.datas.add(data);

    }

    /**
     * データのリストを返す。
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     *
     * @return データのリスト
     */
    @Override
    public List<KmgValidationDataModel> getDatas() {

        final List<KmgValidationDataModel> result = this.datas;
        return result;

    }

}

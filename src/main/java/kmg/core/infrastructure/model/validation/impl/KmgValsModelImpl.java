package kmg.core.infrastructure.model.validation.impl;

import java.util.ArrayList;
import java.util.List;

import kmg.core.infrastructure.model.validation.KmgValDataModel;
import kmg.core.infrastructure.model.validation.KmgValsModel;

/**
 * KMGバリデーション集合モデル<br>
 * <p>
 * valは、Validationの略。
 * </p>
 *
 * @author KenichiroArai
 *
 * @since 0.2.0
 *
 * @version 0.2.0
 */
public class KmgValsModelImpl implements KmgValsModel {

    /**
     * データのリスト
     */
    private final List<KmgValDataModel> datas;

    /**
     * コンストラクタ
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    public KmgValsModelImpl() {

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
    public void addData(final KmgValDataModel data) {

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
    public List<KmgValDataModel> getDatas() {

        final List<KmgValDataModel> result = this.datas;
        return result;

    }

}

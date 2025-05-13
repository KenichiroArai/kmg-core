package kmg.core.infrastructure.model.val.impl;

import java.util.ArrayList;
import java.util.List;

import kmg.core.infrastructure.model.val.KmgValDataModel;
import kmg.core.infrastructure.model.val.KmgValsModel;

/**
 * KMGバリデーション集合モデル<br>
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
public class KmgValsModelImpl implements KmgValsModel {

    /**
     * データのリスト
     *
     * @since 0.2.0
     */
    private final List<KmgValDataModel> datas;

    /**
     * コンストラクタ
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
     * @since 0.2.0
     *
     * @return データのリスト
     */
    @Override
    public List<KmgValDataModel> getDatas() {

        final List<KmgValDataModel> result = this.datas;
        return result;

    }

    /**
     * データが空か。
     *
     * @since 0.2.0
     *
     * @return true：空、false：空ではない
     */
    @Override
    public boolean isEmpty() {

        final boolean result = this.datas.isEmpty();
        return result;

    }

    /**
     * データが空ではないか。
     *
     * @since 0.2.0
     *
     * @return true：空ではない、false：空である
     */
    @Override
    public boolean isNotEmpty() {

        final boolean result = !this.isEmpty();
        return result;

    }

    /**
     * KMGバリデーション集合モデルをマージする。
     *
     * @param valsModel
     *                  KMGバリデーション集合モデル
     *
     * @since 0.2.0
     */
    @Override
    public void merge(final KmgValsModel valsModel) {

        valsModel.getDatas().forEach(this::addData);

    }

}

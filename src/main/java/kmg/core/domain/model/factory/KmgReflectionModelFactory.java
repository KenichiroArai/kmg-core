package kmg.core.domain.model.factory;

import org.springframework.stereotype.Component;

import kmg.core.domain.model.KmgReflectionModel;
import kmg.core.domain.model.impl.KmgReflectionModelImpl;
import kmg.core.infrastructure.model.factory.KmgMessageModelFactory;

/**
 * KMGリフレクションモデルファクトリ<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
@Component
public class KmgReflectionModelFactory {

    /** KMGメッセージモデルファクトリ */
    private KmgMessageModelFactory kmgMessageModelFactory;

    /**
     * リフレクションモデルを作成する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param object
     *               対象オブジェクトのインスタンス
     * @return リフレクションモデル
     */
    public KmgReflectionModel create(final Object object) {

        final KmgReflectionModel result = new KmgReflectionModelImpl(this.kmgMessageModelFactory, object);
        return result;

    }
}

package kmg.core.infrastructure.config;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import kmg.core.infrastructure.model.factory.KmgMessageModelFactory;
import kmg.core.infrastructure.utils.KmgPathUtils;

/**
 * KMGパスユーティリティ設定<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
@Configuration
public class KmgPathUtilsConfig {

    /** KMGメッセージモデルファクトリ */
    @Autowired
    private KmgMessageModelFactory kmgMessageModelFactory;

    /**
     * 初期化<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     */
    @PostConstruct
    public void init() {

        KmgPathUtils.setKmgMessageModelFactory(this.kmgMessageModelFactory);

    }
}

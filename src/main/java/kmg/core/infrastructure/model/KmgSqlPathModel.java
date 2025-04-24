package kmg.core.infrastructure.model;

import kmg.core.infrastructure.exception.KmgDomainException;

/**
 * KMGSQLパスモデルインタフェース<br>
 *
 * @author KenichiroArai
 *
 * @since 0.1.0
 *
 * @version 0.1.0
 */
public interface KmgSqlPathModel {

    /**
     * SQLにして返す<br>
     * <p>
     * SQLパスで受け取ったファイルの中身をSQLにして返す。<br>
     * コメントに埋め込まれたパラメータをパラメータに変換する。<br>
     * コメントの後にあるサンプル値を削除する。<br>
     * 例：&#047;*:sampleId*&#047;'サンプル'→:sampleId<br>
     * 例：&#047;*:sampleId*&#047;123→:sampleId<br>
     * </p>
     *
     * @since 0.1.0
     *
     * @return SQLにして返す
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    String toSql() throws KmgDomainException;

}

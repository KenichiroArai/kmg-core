package kmg.core.infrastructure.model;

import kmg.core.infrastructure.exception.KmgDomainException;

/**
 * KMGＳＱＬパスモデルインタフェース<br>
 *
 * @author KenichiroArai
 *
 * @sine 1.0.0
 *
 * @version 1.0.0
 */
public interface KmgSqlPathModel {

    /**
     * ＳＱＬにして返す<br>
     * <p>
     * ＳＱＬパスで受け取ったファイルの中身をＳＱＬにして返す。<br>
     * コメントに埋め込まれたパラメータをパラメータに変換する。<br>
     * コメントの後にあるサンプル値を削除する。<br>
     * 例：&#047;*:sampleId*&#047;'サンプル'→:sampleId<br>
     * 例：&#047;*:sampleId*&#047;123→:sampleId<br>
     * </p>
     *
     * @author KenichiroArai
     *
     * @sine 1.0.0
     *
     * @version 1.0.0
     *
     * @return ＳＱＬにして返す
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    String toSql() throws KmgDomainException;

}

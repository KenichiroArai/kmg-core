package kmg.core.infrastructure.model;

import java.lang.reflect.Field;

import kmg.core.infrastructure.exception.KmgDomainException;

/**
 * KMGリフレクションモデルインタフェース<br>
 *
 * @author KenichiroArai
 *
 * @sine 0.1.0
 *
 * @version 0.1.0
 */
public interface KmgReflectionModel {

    /**
     * 最後に取得したフィールドを返す<br>
     *
     * @author KenichiroArai
     *
     * @sine 0.1.0
     *
     * @version 0.1.0
     *
     * @return 最後に取得したフィールド
     */
    Field getLastGetField();

    /**
     * フィールド名に該当するフィールドに値を設定する<br>
     *
     * @author KenichiroArai
     *
     * @sine 0.1.0
     *
     * @version 0.1.0
     *
     * @param fieldName
     *                  フィールド名
     * @param value
     *                  値
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    void set(final String fieldName, final Object value) throws KmgDomainException;

    /**
     * フィールド名に該当するフィールドに値を返す<br>
     *
     * @author KenichiroArai
     *
     * @sine 0.1.0
     *
     * @version 0.1.0
     *
     * @param fieldName
     *                  フィールド名
     *
     * @return 値
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    Object get(final String fieldName) throws KmgDomainException;

    /**
     * メソッド名に該当するメソッドを呼び出す<br>
     *
     * @author KenichiroArai
     *
     * @sine 0.1.0
     *
     * @version 0.1.0
     *
     * @param methodName
     *                   メソッド名
     * @param parameters
     *                   パラメータ
     *
     * @return 返却値
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    Object getMethod(final String methodName, final Object... parameters) throws KmgDomainException;

}

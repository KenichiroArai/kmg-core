package kmg.core.infrastructure.model;

import java.lang.reflect.Field;

import kmg.core.infrastructure.exception.KmgReflectionException;

/**
 * KMGリフレクションモデルインタフェース<br>
 *
 * @author KenichiroArai
 *
 * @since 0.1.0
 *
 * @version 0.2.0
 */
public interface KmgReflectionModel {

    /**
     * フィールド名に該当するフィールドに値を返す<br>
     *
     * @since 0.1.0
     *
     * @param fieldName
     *                  フィールド名
     *
     * @return 値
     *
     * @throws KmgReflectionException
     *                                KMGリフレクション例外
     */
    Object get(final String fieldName) throws KmgReflectionException;

    /**
     * 最後に取得したフィールドを返す<br>
     *
     * @since 0.1.0
     *
     * @return 最後に取得したフィールド
     */
    Field getLastGetField();

    /**
     * メソッド名に該当するメソッドを呼び出す<br>
     *
     * @since 0.1.0
     *
     * @param methodName
     *                   メソッド名
     * @param parameters
     *                   パラメータ
     *
     * @return 返却値
     *
     * @throws KmgReflectionException
     *                                KMGリフレクション例外
     * @throws Exception
     *                                メソッド実行時に発生した元の例外
     */
    Object getMethod(final String methodName, final Object... parameters) throws KmgReflectionException, Exception;

    /**
     * フィールド名に該当するフィールドに値を設定する<br>
     *
     * @since 0.1.0
     *
     * @param fieldName
     *                  フィールド名
     * @param value
     *                  値
     *
     * @throws KmgReflectionException
     *                                KMGリフレクション例外
     */
    void set(final String fieldName, final Object value) throws KmgReflectionException;

}

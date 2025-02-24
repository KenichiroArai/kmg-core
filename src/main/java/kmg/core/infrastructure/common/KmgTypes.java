package kmg.core.infrastructure.common;

import java.util.function.Supplier;

/**
 * 種類のインタフェース
 *
 * @author KenichiroArai
 *
 * @sine 0.1.0
 *
 * @version 0.1.0
 *
 * @param <T>
 *            列挙型の型パラメータ
 */
public interface KmgTypes<T> extends Supplier<T> {

    /**
     * キーを返す。<br>
     *
     * @author KenichiroArai
     *
     * @sine 0.1.0
     *
     * @version 0.1.0
     *
     * @return キー
     *
     * @see #getKey()
     */
    @Override
    T get();

    /**
     * 詳細情報を返す。<br>
     *
     * @author KenichiroArai
     *
     * @sine 0.1.0
     *
     * @version 0.1.0
     *
     * @return 詳細情報
     */
    String getDetail();

    /**
     * 表示名を返す。<br>
     * <p>
     * 識別するための表示名を返す。
     * </p>
     *
     * @author KenichiroArai
     *
     * @sine 0.1.0
     *
     * @version 0.1.0
     *
     * @return 表示名
     */
    String getDisplayName();

    /**
     * キーを返す。<br>
     *
     * @author KenichiroArai
     *
     * @sine 0.1.0
     *
     * @version 0.1.0
     *
     * @return キー
     */
    String getKey();

    /**
     * キーを返す。<br>
     *
     * @author KenichiroArai
     *
     * @sine 0.1.0
     *
     * @version 0.1.0
     *
     * @return キー
     *
     * @see #getKey()
     */
    @Override
    String toString();

}

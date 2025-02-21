package kmg.core.infrastructure.common;

import java.util.function.Supplier;

/**
 * 種類のインタフェース
 *
 * @param <T>
 *            列挙型の型パラメータ
 */
public interface KmgTypes<T> extends Supplier<T> {

    /**
     * キーを返す。<br>
     * このメソッドは{@link #getKey()}のエイリアスです。
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
     * @return 詳細情報
     */
    String getDetail();

    /**
     * 表示名を返す。<br>
     * <p>
     * 識別するための表示名を返す。
     * </p>
     *
     * @return 表示名
     */
    String getDisplayName();

    /**
     * キーを返す。<br>
     *
     * @return キー
     */
    String getKey();

    /**
     * キーを返す。<br>
     * このメソッドは{@link #getKey()}のエイリアスです。
     *
     * @return キー
     *
     * @see #getKey()
     */
    @Override
    String toString();

}

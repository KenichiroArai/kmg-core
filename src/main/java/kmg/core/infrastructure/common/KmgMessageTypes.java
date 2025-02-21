package kmg.core.infrastructure.common;

/**
 * メッセージの種類のインタフェース
 */
public interface KmgMessageTypes extends KmgTypes<String> {

    /**
     * メッセージのキーを返す。<br>
     * このメソッドは{@link #getKey()}のエイリアスです。
     *
     * @return メッセージのキー
     *
     * @see #getKey()
     */
    @Override
    String get();

    /**
     * メッセージのキーを返す。<br>
     * このメソッドは{@link #getKey()}のエイリアスです。
     *
     * @return メッセージのキー
     *
     * @see #getKey()
     */
    String getCode();

    /**
     * メッセージのキーを返す。<br>
     *
     * @return メッセージのキー
     */
    @Override
    String getKey();

    /**
     * メッセージの値を返す。
     *
     * @return メッセージの値
     */
    String getValue();

    /**
     * メッセージのキーを返す。<br>
     * このメソッドは{@link #getKey()}のエイリアスです。
     *
     * @return メッセージのキー
     *
     * @see #getKey()
     */
    @Override
    String toString();

}

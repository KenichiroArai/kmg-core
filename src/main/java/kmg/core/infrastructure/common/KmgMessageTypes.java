package kmg.core.infrastructure.common;

/**
 * メッセージの種類のインタフェース
 * 
 * @author KenichiroArai
 * 
 * @sine 0.1.0
 * 
 * @version 0.1.0
 */
public interface KmgMessageTypes extends KmgTypes<String> {

    /**
     * メッセージのキーを返す。<br>
     * 
     * @author KenichiroArai
     * 
     * @sine 0.1.0
     * 
     * @version 0.1.0 このメソッドは{@link #getKey()}のエイリアスです。
     *
     * @return メッセージのキー
     *
     * @see #getKey()
     */
    @Override
    String get();

    /**
     * メッセージのキーを返す。<br>
     * 
     * @author KenichiroArai
     * 
     * @sine 0.1.0
     * 
     * @version 0.1.0 このメソッドは{@link #getKey()}のエイリアスです。
     *
     * @return メッセージのキー
     *
     * @see #getKey()
     */
    String getCode();

    /**
     * メッセージのキーを返す。<br>
     *
     * @author KenichiroArai
     * 
     * @sine 0.1.0
     * 
     * @version 0.1.0
     * 
     * @return メッセージのキー
     */
    @Override
    String getKey();

    /**
     * メッセージの値を返す。
     *
     * @author KenichiroArai
     * 
     * @sine 0.1.0
     * 
     * @version 0.1.0
     * 
     * @return メッセージの値
     */
    String getValue();

    /**
     * メッセージのキーを返す。<br>
     * 
     * @author KenichiroArai
     * 
     * @sine 0.1.0
     * 
     * @version 0.1.0 このメソッドは{@link #getKey()}のエイリアスです。
     *
     * @return メッセージのキー
     *
     * @see #getKey()
     */
    @Override
    String toString();

}

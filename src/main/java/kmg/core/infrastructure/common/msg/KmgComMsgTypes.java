package kmg.core.infrastructure.common.msg;

import kmg.core.infrastructure.common.KmgComTypes;

/**
 * KMG共通メッセージの種類のインタフェース
 * <p>
 * Comは、Commonの略。<br>
 * Msgは、Messageの略。
 * </p>
 *
 * @author KenichiroArai
 *
 * @since 0.2.0
 *
 * @version 0.2.0
 */
public interface KmgComMsgTypes extends KmgComTypes<String> {

    /**
     * メッセージのキーを返す。<br>
     *
     * @since 0.2.0
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
     * @since 0.2.0
     *
     * @return メッセージのキー
     *
     * @see #getKey()
     */
    String getCode();

    /**
     * メッセージのキーを返す。<br>
     *
     * @since 0.2.0
     *
     * @return メッセージのキー
     */
    @Override
    String getKey();

    /**
     * メッセージの値を返す。
     *
     * @since 0.2.0
     *
     * @return メッセージの値
     */
    String getValue();

    /**
     * メッセージのキーを返す。<br>
     *
     * @since 0.2.0
     *
     * @return メッセージのキー
     *
     * @see #getKey()
     */
    @Override
    String toString();

}

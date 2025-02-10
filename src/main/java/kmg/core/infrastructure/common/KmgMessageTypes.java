/**
 *
 */
package kmg.core.infrastructure.common;

/**
 * メッセージの種類のインタフェース
 */
public interface KmgMessageTypes {

    /**
     * メッセージのコードを返す。
     *
     * @return メッセージのコード
     */
    String getCode();

    /**
     * メッセージの名称を返す。<br>
     *
     * @author KenichiroArai
     *
     * @sine 1.0.0
     *
     * @version 1.0.0
     *
     * @return 名称
     */
    String getName();

}

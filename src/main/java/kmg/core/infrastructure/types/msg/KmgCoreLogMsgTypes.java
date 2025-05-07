package kmg.core.infrastructure.types.msg;

import java.util.HashMap;
import java.util.Map;

import kmg.core.infrastructure.common.msg.KmgComLogMessageTypes;

/**
 * KMGコアログメッセージの種類<br>
 * <p>
 * Genは、Generalの略。<br>
 * Msgは、Messageの略。
 * </p>
 *
 * @author KenichiroArai
 *
 * @since 0.2.0
 *
 * @version 0.2.0
 */
@SuppressWarnings("nls")
public enum KmgCoreLogMsgTypes implements KmgComLogMessageTypes {

    /* 定義：開始 */

    /**
     * 指定無し
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    NONE("指定無し"),

    /**
     * {0}：開始
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    KMGCORE_LOG12000("{0}：開始"),

    /**
     * {0}：終了。経過時間=[{1}{2}]
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    KMGCORE_LOG12001("{0}：終了。経過時間=[{1}{2}]"),

    /**
     * {0}：{1}。経過時間=[{2}{3}]
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    KMGCORE_LOG12002("{0}：{1}。経過時間=[{2}{3}]"),

    /**
     * {0}：{1}。経過時間=[{2}{3}]
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    KMGCORE_LOG12003("{0}：{1}。経過時間=[{2}{3}]"),

    /**
     * {0}：{1}。経過時間=[{2}{3}]
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    KMGCORE_LOG12004("{0}：{1}。経過時間=[{2}{3}]"),

    /**
     * {0}
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    KMGCORE_LOG91100("{0}"),

    /* 定義：終了 */
    ;

    /**
     * 種類のマップ
     *
     * @since 0.2.0
     */
    private static final Map<String, KmgCoreLogMsgTypes> VALUES_MAP = new HashMap<>();

    static {

        /* 種類のマップにプット */
        for (final KmgCoreLogMsgTypes type : KmgCoreLogMsgTypes.values()) {

            KmgCoreLogMsgTypes.VALUES_MAP.put(type.get(), type);

        }

    }

    /**
     * 表示名
     *
     * @since 0.2.0
     */
    private final String displayName;

    /**
     * メッセージのキー
     *
     * @since 0.2.0
     */
    private final String key;

    /**
     * メッセージの値
     *
     * @since 0.2.0
     */
    private final String value;

    /**
     * 詳細情報
     *
     * @since 0.2.0
     */
    private final String detail;

    /**
     * デフォルトの種類を返す<br>
     *
     * @since 0.2.0
     *
     * @return デフォルト値
     */
    public static KmgCoreLogMsgTypes getDefault() {

        final KmgCoreLogMsgTypes result = NONE;
        return result;

    }

    /**
     * キーに該当する種類を返す<br>
     * <p>
     * 但し、キーが存在しない場合は、指定無し（NONE）を返す。
     * </p>
     *
     * @since 0.2.0
     *
     * @param key
     *            キー
     *
     * @return 種類。指定無し（NONE）：キーが存在しない場合。
     */
    public static KmgCoreLogMsgTypes getEnum(final String key) {

        KmgCoreLogMsgTypes result = KmgCoreLogMsgTypes.VALUES_MAP.get(key);

        if (result == null) {

            result = NONE;

        }
        return result;

    }

    /**
     * 初期値の種類を返す<br>
     *
     * @since 0.2.0
     *
     * @return 初期値
     */
    public static KmgCoreLogMsgTypes getInitValue() {

        final KmgCoreLogMsgTypes result = NONE;
        return result;

    }

    /**
     * コンストラクタ<br>
     *
     * @since 0.2.0
     *
     * @param displayName
     *                    表示名
     */
    KmgCoreLogMsgTypes(final String displayName) {

        this.displayName = displayName;
        this.key = super.name();
        this.value = displayName;
        this.detail = displayName;

    }

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
    public String get() {

        final String result = this.getKey();
        return result;

    }

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
    public String getCode() {

        final String result = this.getKey();
        return result;

    }

    /**
     * 詳細情報を返す。<br>
     *
     * @since 0.2.0
     *
     * @return 詳細情報
     */
    @Override
    public String getDetail() {

        final String result = this.detail;
        return result;

    }

    /**
     * 表示名を返す。<br>
     * <p>
     * 識別するための表示名を返す。
     * </p>
     *
     * @since 0.2.0
     *
     * @return 表示名
     */
    @Override
    public String getDisplayName() {

        final String result = this.displayName;
        return result;

    }

    /**
     * メッセージのキーを返す。<br>
     *
     * @since 0.2.0
     *
     * @return メッセージのキー
     */
    @Override
    public String getKey() {

        final String result = this.key;
        return result;

    }

    /**
     * メッセージの値を返す。
     *
     * @since 0.2.0
     *
     * @return メッセージの値
     */
    @Override
    public String getValue() {

        final String result = this.value;
        return result;

    }

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
    public String toString() {

        final String result = this.getKey();
        return result;

    }

}

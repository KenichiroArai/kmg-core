package kmg.core.domain.types;

import java.util.HashMap;
import java.util.Map;

import kmg.core.infrastructure.common.KmgComLogMessageTypes;

/**
 * KMGコアログメッセージの種類<br>
 *
 * @author KenichiroArai
 *
 * @since 0.1.0
 *
 * @version 0.2.0
 */
@SuppressWarnings("nls")
public enum KmgCoreLogMessageTypes implements KmgComLogMessageTypes {

    /* 定義：開始 */

    /**
     * 指定無し
     *
     * @author KenichiroArai
     *
     * @since 0.1.0
     *
     * @version 0.1.0
     */
    NONE("指定無し"),

    /**
     * {0}：開始
     *
     * @author KenichiroArai
     *
     * @since 0.1.0
     *
     * @version 0.2.0
     */
    KMGCORE_LOGI12000("KMGCORE_LOGI12000"),

    /**
     * {0}：終了。経過時間=[{1}{2}]
     *
     * @author KenichiroArai
     *
     * @since 0.1.0
     *
     * @version 0.2.0
     */
    KMGCORE_LOGI12001("KMGCORE_LOGI12001"),

    /**
     * {0}：{1}。経過時間=[{2}{3}]
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     *
     * @version 0.2.0
     */
    KMGCORELOGE12002("KMGCORELOGE12002"),

    /**
     * {0}：{1}。経過時間=[{2}{3}]
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     *
     * @version 0.2.0
     */
    KMGCORE_LOGI12003("KMGCORE_LOGI12003"),

    /**
     * {0}：{1}。経過時間=[{2}{3}]
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     *
     * @version 0.2.0
     */
    KMGCORELOGW12004("KMGCORELOGW12004"),

    /* 定義：終了 */
    ;

    /**
     * 種類のマップ
     *
     * @since 0.1.0
     */
    private static final Map<String, KmgCoreLogMessageTypes> VALUES_MAP = new HashMap<>();

    static {

        /* 種類のマップにプット */
        for (final KmgCoreLogMessageTypes type : KmgCoreLogMessageTypes.values()) {

            KmgCoreLogMessageTypes.VALUES_MAP.put(type.get(), type);

        }

    }

    /**
     * 表示名
     *
     * @since 0.1.0
     */
    private final String displayName;

    /**
     * メッセージのキー
     *
     * @since 0.1.0
     */
    private final String key;

    /**
     * メッセージの値
     *
     * @since 0.1.0
     */
    private final String value;

    /**
     * 詳細情報
     *
     * @since 0.1.0
     */
    private final String detail;

    /**
     * デフォルトの種類を返す<br>
     *
     * @since 0.1.0
     *
     * @return デフォルト値
     */
    public static KmgCoreLogMessageTypes getDefault() {

        final KmgCoreLogMessageTypes result = NONE;
        return result;

    }

    /**
     * キーに該当する種類を返す<br>
     * <p>
     * 但し、キーが存在しない場合は、指定無し（NONE）を返す。
     * </p>
     *
     * @since 0.1.0
     *
     * @param key
     *            キー
     *
     * @return 種類。指定無し（NONE）：キーが存在しない場合。
     */
    public static KmgCoreLogMessageTypes getEnum(final String key) {

        KmgCoreLogMessageTypes result = KmgCoreLogMessageTypes.VALUES_MAP.get(key);

        if (result == null) {

            result = NONE;

        }
        return result;

    }

    /**
     * 初期値の種類を返す<br>
     *
     * @since 0.1.0
     *
     * @return 初期値
     */
    public static KmgCoreLogMessageTypes getInitValue() {

        final KmgCoreLogMessageTypes result = NONE;
        return result;

    }

    /**
     * コンストラクタ<br>
     *
     * @since 0.1.0
     *
     * @param displayName
     *                    表示名
     */
    KmgCoreLogMessageTypes(final String displayName) {

        this.displayName = displayName;
        this.key = super.name();
        this.value = displayName;
        this.detail = displayName;

    }

    /**
     * メッセージのキーを返す。<br>
     *
     * @since 0.1.0
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
     * @since 0.1.0
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
     * @since 0.1.0
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
     * @since 0.1.0
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
     * @since 0.1.0
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
     * @since 0.1.0
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
     * @since 0.1.0
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

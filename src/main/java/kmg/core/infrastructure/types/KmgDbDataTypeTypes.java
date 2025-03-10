package kmg.core.infrastructure.types;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import kmg.core.infrastructure.common.KmgComTypes;
import kmg.core.infrastructure.type.KmgString;

/**
 * KMGDB型の種類<br>
 *
 * @author KenichiroArai
 *
 * @since 0.1.0
 *
 * @version 0.2.0
 */
@SuppressWarnings("nls")
public enum KmgDbDataTypeTypes implements KmgComTypes<String> {

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
    NONE("指定無し", KmgString.EMPTY, null),

    /**
     * 4バイト整数
     *
     * @author KenichiroArai
     *
     * @since 0.1.0
     *
     * @version 0.1.0
     */
    INTEGER("4バイト整数", "4バイト整数", Integer.class),

    /**
     * 8バイト整数
     *
     * @author KenichiroArai
     *
     * @since 0.1.0
     *
     * @version 0.1.0
     */
    LONG("8バイト整数", "8バイト整数", Long.class),

    /**
     * 日付型
     *
     * @author KenichiroArai
     *
     * @since 0.1.0
     *
     * @version 0.1.0
     */
    DATE("日付型", "日付型", LocalDate.class),

    /**
     * 日時型
     *
     * @author KenichiroArai
     *
     * @since 0.1.0
     *
     * @version 0.1.0
     */
    TIME("日時型", "日時型", LocalDateTime.class),

    /**
     * 文字列型
     *
     * @author KenichiroArai
     *
     * @since 0.1.0
     *
     * @version 0.1.0
     */
    STRING("文字列型", "文字列型", String.class),

    /**
     * 自動4バイト
     *
     * @author KenichiroArai
     *
     * @since 0.1.0
     *
     * @version 0.1.0
     */
    SMALLSERIAL("自動4バイト", "自動4バイト", Integer.class),

    /**
     * 自動8バイト
     *
     * @author KenichiroArai
     *
     * @since 0.1.0
     *
     * @version 0.1.0
     */
    SERIAL("自動8バイト", "自動8バイト", Long.class),

    /**
     * 4バイト実数
     *
     * @author KenichiroArai
     *
     * @since 0.1.0
     *
     * @version 0.1.0
     */
    FLOAT("4バイト実数", "4バイト実数", Float.class),

    /**
     * 8バイト実数
     *
     * @author KenichiroArai
     *
     * @since 0.1.0
     *
     * @version 0.1.0
     */
    DOUBLE("8バイト実数", "8バイト実数", Double.class),

    /**
     * 8バイト実数
     *
     * @author KenichiroArai
     *
     * @since 0.1.0
     *
     * @version 0.1.0
     */
    BIG_DECIMAL("8バイト実数", "8バイト実数", BigDecimal.class),

    /* 定義：終了 */
    ;

    /**
     * 種類のマップ
     *
     * @since 0.1.0
     */
    private static final Map<String, KmgDbDataTypeTypes> VALUES_MAP = new HashMap<>();

    static {

        /* 種類のマップにプット */
        for (final KmgDbDataTypeTypes type : KmgDbDataTypeTypes.values()) {

            KmgDbDataTypeTypes.VALUES_MAP.put(type.get(), type);

        }

    }

    /**
     * 表示名
     *
     * @since 0.1.0
     */
    private final String displayName;

    /**
     * キー
     *
     * @since 0.1.0
     */
    private final String key;

    /**
     * 詳細情報
     *
     * @since 0.1.0
     */
    private final String detail;

    /**
     * 型
     *
     * @since 0.1.0
     */
    private final Type type;

    /**
     * デフォルトの種類を返す<br>
     *
     * @since 0.1.0
     *
     * @return デフォルト値
     */
    public static KmgDbDataTypeTypes getDefault() {

        final KmgDbDataTypeTypes result = NONE;
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
    public static KmgDbDataTypeTypes getEnum(final String key) {

        KmgDbDataTypeTypes result = KmgDbDataTypeTypes.VALUES_MAP.get(key);

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
    public static KmgDbDataTypeTypes getInitValue() {

        final KmgDbDataTypeTypes result = NONE;
        return result;

    }

    /**
     * コンストラクタ<br>
     *
     * @since 0.1.0
     *
     * @param displayName
     *                    表示名
     * @param key
     *                    キー
     * @param type
     *                    型
     */
    KmgDbDataTypeTypes(final String displayName, final String key, final Type type) {

        this.displayName = displayName;
        this.key = key;
        this.detail = displayName;
        this.type = type;

    }

    /**
     * キーを返す。<br>
     *
     * @since 0.1.0
     *
     * @return キー
     *
     * @see #getKey()
     */
    @Override
    public String get() {

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
     * キーを返す。<br>
     *
     * @since 0.1.0
     *
     * @return キー
     */
    @Override
    public String getKey() {

        final String result = this.key;
        return result;

    }

    /**
     * 型を返す<br>
     *
     * @since 0.1.0
     *
     * @return 型
     */
    public Type getType() {

        final Type result = this.type;
        return result;

    }

    /**
     * キーを返す。<br>
     *
     * @since 0.1.0
     *
     * @return キー
     *
     * @see #getKey()
     */
    @Override
    public String toString() {

        final String result = this.getKey();
        return result;

    }

}

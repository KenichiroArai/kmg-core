package kmg.core.infrastructure.types;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import kmg.core.infrastructure.common.KmgTypes;

/**
 * KMG時間単位の種類<br>
 *
 * @author KenichiroArai
 *
 * @since 0.1.0
 *
 * @version 0.1.0
 */
@SuppressWarnings("nls")
public enum KmgTimeUnitTypes implements KmgTypes<String> {

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
    NONE("指定無し", null, "指定無し", BigDecimal.ZERO),

    /**
     * 秒
     *
     * @author KenichiroArai
     *
     * @since 0.1.0
     *
     * @version 0.1.0
     */
    SECONDS("秒", "seconds", "秒", BigDecimal.ONE),

    /**
     * ミリ秒
     *
     * @author KenichiroArai
     *
     * @since 0.1.0
     *
     * @version 0.1.0
     */
    MILLISECOND("ミリ秒", "millisecond,", "ミリ秒", new BigDecimal("0.001")),

    /**
     * マイクロ秒
     *
     * @author KenichiroArai
     *
     * @since 0.1.0
     *
     * @version 0.1.0
     */
    MICROSECONDS("マイクロ秒", "microseconds", "マイクロ秒", new BigDecimal("0.000001")),

    /**
     * ナノ秒
     *
     * @author KenichiroArai
     *
     * @since 0.1.0
     *
     * @version 0.1.0
     */
    NANOSECONDS("ナノ秒", "nanoseconds", "ナノ秒", new BigDecimal("0.000000001")),

    /* 定義：終了 */
    ;

    /**
     * 種類のマップ
     *
     * @since 0.1.0
     */
    private static final Map<String, KmgTimeUnitTypes> VALUES_MAP = new HashMap<>();

    static {

        /* 種類のマップにプット */
        for (final KmgTimeUnitTypes type : KmgTimeUnitTypes.values()) {

            KmgTimeUnitTypes.VALUES_MAP.put(type.get(), type);

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
     * 単位名
     *
     * @since 0.1.0
     */
    private final String unitName;

    /**
     * 単位値
     *
     * @since 0.1.0
     */
    private final BigDecimal unitValue;

    /**
     * デフォルトの種類を返す<br>
     *
     * @since 0.1.0
     *
     * @return デフォルト値
     */
    public static KmgTimeUnitTypes getDefault() {

        final KmgTimeUnitTypes result = NONE;
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
    public static KmgTimeUnitTypes getEnum(final String key) {

        KmgTimeUnitTypes result = KmgTimeUnitTypes.VALUES_MAP.get(key);

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
    public static KmgTimeUnitTypes getInitValue() {

        final KmgTimeUnitTypes result = NONE;
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
     * @param unitName
     *                    単位名
     * @param unitValue
     *                    単位値
     */
    KmgTimeUnitTypes(final String displayName, final String key, final String unitName, final BigDecimal unitValue) {

        this.displayName = displayName;
        this.key = key;
        this.detail = displayName;
        this.unitName = unitName;
        this.unitValue = unitValue;

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
     * 単位名を返す<br>
     *
     * @since 0.1.0
     *
     * @return 単位名
     */
    public String getUnitName() {

        final String result = this.unitName;
        return result;

    }

    /**
     * 単位値を返す<br>
     *
     * @since 0.1.0
     *
     * @return 単位値
     */
    public BigDecimal getUnitValue() {

        final BigDecimal result = this.unitValue;
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

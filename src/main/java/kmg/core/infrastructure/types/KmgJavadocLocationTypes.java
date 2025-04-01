package kmg.core.infrastructure.types;

import java.util.HashMap;
import java.util.Map;

import kmg.core.infrastructure.common.KmgComTypes;

/**
 * KMG Javadocの設定可能な場所の種類<br>
 *
 * @author KenichiroArai
 *
 * @since 0.2.0
 *
 * @version 0.2.0
 */
@SuppressWarnings("nls")
public enum KmgJavadocLocationTypes implements KmgComTypes<String> {

    /* 定義：開始 */

    /**
     * 指定無し
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    NONE("指定無し", "None", "指定無し"),

    /**
     * クラス
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    CLASS("クラス", "class", "クラスの定義"),

    /**
     * インターフェース
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    INTERFACE("インターフェース", "interface", "インターフェースの定義"),

    /**
     * 列挙型
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    ENUM("列挙型", "enum", "列挙型の定義"),

    /**
     * アノテーション
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    ANNOTATION("アノテーション", "annotation", "アノテーションの定義"),

    /**
     * メソッド
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    METHOD("メソッド", "method", "メソッドの定義"),

    /**
     * フィールド
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    FIELD("フィールド", "field", "フィールドの定義"),

    /**
     * コンストラクタ
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    CONSTRUCTOR("コンストラクタ", "constructor", "コンストラクタの定義"),

    /**
     * モジュール
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    MODULE("モジュール", "module", "モジュールの定義"),

    /**
     * すべての場所
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    ALL("すべての場所", "all", "すべての場所で使用可能"),

    /* 定義：終了 */
    ;

    /**
     * 種類のマップ
     *
     * @since 0.2.0
     */
    private static final Map<String, KmgJavadocLocationTypes> VALUES_MAP = new HashMap<>();

    static {

        /* 種類のマップにプット */
        for (final KmgJavadocLocationTypes type : KmgJavadocLocationTypes.values()) {

            KmgJavadocLocationTypes.VALUES_MAP.put(type.get(), type);

        }

    }

    /**
     * 表示名
     *
     * @since 0.2.0
     */
    private final String displayName;

    /**
     * キー
     *
     * @since 0.2.0
     */
    private final String key;

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
    public static KmgJavadocLocationTypes getDefault() {

        final KmgJavadocLocationTypes result = NONE;
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
    public static KmgJavadocLocationTypes getEnum(final String key) {

        KmgJavadocLocationTypes result = KmgJavadocLocationTypes.VALUES_MAP.get(key);

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
    public static KmgJavadocLocationTypes getInitValue() {

        final KmgJavadocLocationTypes result = NONE;
        return result;

    }

    /**
     * コンストラクタ<br>
     *
     * @since 0.2.0
     *
     * @param displayName
     *                    表示名
     * @param key
     *                    キー
     * @param detail
     *                    詳細情報
     */
    KmgJavadocLocationTypes(final String displayName, final String key, final String detail) {

        this.displayName = displayName;
        this.key = key;
        this.detail = detail;

    }

    /**
     * キーを返す。<br>
     *
     * @since 0.2.0
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
     * キーを返す。<br>
     *
     * @since 0.2.0
     *
     * @return キー
     */
    @Override
    public String getKey() {

        final String result = this.key;
        return result;

    }

    /**
     * キーを返す。<br>
     *
     * @since 0.2.0
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

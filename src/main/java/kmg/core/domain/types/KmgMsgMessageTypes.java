package kmg.core.domain.types;

import java.util.HashMap;
import java.util.Map;

import kmg.core.infrastructure.common.KmgCommonMsgMessageTypes;

/**
 * KMGメッセージメッセージの種類<br>
 *
 * @author KenichiroArai
 *
 * @since 0.1.0
 *
 * @version 0.2.0
 */
@SuppressWarnings("nls")
public enum KmgMsgMessageTypes implements KmgCommonMsgMessageTypes {

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
     * {0}がありません。
     *
     * @author KenichiroArai
     *
     * @since 0.1.0
     *
     * @version 0.1.0
     */
    KMGMSGE11100("{0}がありません。"),

    /**
     * フィールドの取得に失敗しました。フィールド名=[{0}]、対象のクラス=[{1}]、最後に取得したフィールド=[{2}]
     *
     * @author KenichiroArai
     *
     * @since 0.1.0
     *
     * @version 0.1.0
     */
    KMGMSGE11200("フィールドの取得に失敗しました。フィールド名=[{0}]、対象のクラス=[{1}]、最後に取得したフィールド=[{2}]"),

    /**
     * フィールドの値の取得に失敗しました。フィールド名=[{0}]、対象のクラス=[{1}]、最後に取得したフィールド=[{2}]
     *
     * @author KenichiroArai
     *
     * @since 0.1.0
     *
     * @version 0.1.0
     */
    KMGMSGE11201("フィールドの値の取得に失敗しました。フィールド名=[{0}]、対象のクラス=[{1}]、最後に取得したフィールド=[{2}]"),

    /**
     * フィールドの値の取得に失敗しました。フィールド名=[{0}]、対象のクラス=[{1}]、最後に取得したフィールド=[{2}]
     *
     * @author KenichiroArai
     *
     * @since 0.1.0
     *
     * @version 0.1.0
     */
    KMGMSGE11202("フィールドの値の取得に失敗しました。フィールド名=[{0}]、対象のクラス=[{1}]、最後に取得したフィールド=[{2}]"),

    /**
     * メソッドの取得に失敗しました。メソッド名=[{0}]、対象のクラス=[{1}]
     *
     * @author KenichiroArai
     *
     * @since 0.1.0
     *
     * @version 0.1.0
     */
    KMGMSGE11203("メソッドの取得に失敗しました。メソッド名=[{0}]、対象のクラス=[{1}]"),

    /**
     * メソッドの値の取得に失敗しました。メソッド名=[{0}]、対象のクラス=[{1}]
     *
     * @author KenichiroArai
     *
     * @since 0.1.0
     *
     * @version 0.1.0
     */
    KMGMSGE11204("メソッドの値の取得に失敗しました。メソッド名=[{0}]、対象のクラス=[{1}]"),

    /**
     * メソッドの値の取得に失敗しました。メソッド名=[{0}]、対象のクラス=[{1}]
     *
     * @author KenichiroArai
     *
     * @since 0.1.0
     *
     * @version 0.1.0
     */
    KMGMSGE11205("メソッドの値の取得に失敗しました。メソッド名=[{0}]、対象のクラス=[{1}]"),

    /**
     * メソッドの値の取得に失敗しました。メソッド名=[{0}]、対象のクラス=[{1}]
     *
     * @author KenichiroArai
     *
     * @since 0.1.0
     *
     * @version 0.1.0
     */
    KMGMSGE11206("メソッドの値の取得に失敗しました。メソッド名=[{0}]、対象のクラス=[{1}]"),

    /**
     * メソッドの値の取得に失敗しました。メソッド名=[{0}]、対象のクラス=[{1}]
     *
     * @author KenichiroArai
     *
     * @since 0.1.0
     *
     * @version 0.1.0
     */
    KMGMSGE11207("メソッドの値の取得に失敗しました。メソッド名=[{0}]、対象のクラス=[{1}]"),

    /**
     * フィールドの取得に失敗しました。フィールド名=[{0}]、対象のクラス=[{1}]、最後に取得したフィールド=[{2}]
     *
     * @author KenichiroArai
     *
     * @since 0.1.0
     *
     * @version 0.1.0
     */
    KMGMSGE11209("フィールドの取得に失敗しました。フィールド名=[{0}]、対象のクラス=[{1}]、最後に取得したフィールド=[{2}]"),

    /**
     * フィールドの値の設定に失敗しました。フィールド名=[{0}]、対象のクラス=[{1}]、最後に取得したフィールド=[{2}]
     *
     * @author KenichiroArai
     *
     * @since 0.1.0
     *
     * @version 0.1.0
     */
    KMGMSGE11210("フィールドの値の設定に失敗しました。フィールド名=[{0}]、対象のクラス=[{1}]、最後に取得したフィールド=[{2}]"),

    /**
     * フィールドの値の設定に失敗しました。フィールド名=[{0}]、対象のクラス=[{1}]、最後に取得したフィールド=[{2}]
     *
     * @author KenichiroArai
     *
     * @since 0.1.0
     *
     * @version 0.1.0
     */
    KMGMSGE11211("フィールドの値の設定に失敗しました。フィールド名=[{0}]、対象のクラス=[{1}]、最後に取得したフィールド=[{2}]"),

    /**
     * クラスからビルドバスの取得に失敗しました。クラス=[{0}]
     *
     * @author KenichiroArai
     *
     * @since 0.1.0
     *
     * @version 0.1.0
     */
    KMGMSGE24000("クラスからビルドバスの取得に失敗しました。クラス=[{0}]"),

    /* 定義：終了 */
    ;

    /**
     * 種類のマップ
     *
     * @since 0.1.0
     */
    private static final Map<String, KmgMsgMessageTypes> VALUES_MAP = new HashMap<>();

    static {

        /* 種類のマップにプット */
        for (final KmgMsgMessageTypes type : KmgMsgMessageTypes.values()) {

            KmgMsgMessageTypes.VALUES_MAP.put(type.get(), type);

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
    public static KmgMsgMessageTypes getDefault() {

        final KmgMsgMessageTypes result = NONE;
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
    public static KmgMsgMessageTypes getEnum(final String key) {

        KmgMsgMessageTypes result = KmgMsgMessageTypes.VALUES_MAP.get(key);

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
    public static KmgMsgMessageTypes getInitValue() {

        final KmgMsgMessageTypes result = NONE;
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
    KmgMsgMessageTypes(final String displayName) {

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

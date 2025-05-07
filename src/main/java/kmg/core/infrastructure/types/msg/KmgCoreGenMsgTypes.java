package kmg.core.infrastructure.types.msg;

import java.util.HashMap;
import java.util.Map;

import kmg.core.infrastructure.common.KmgComExcMessageTypes;
import kmg.core.infrastructure.common.KmgComGenMessageTypes;

/**
 * KMGコア一般メッセージの種類<br>
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
public enum KmgCoreGenMsgTypes implements KmgComGenMessageTypes, KmgComExcMessageTypes {

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
     * {0}がありません。
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    KMGCORE_GEN11100("{0}がありません。"),

    /**
     * フィールドの取得に失敗しました。フィールド名=[{0}]、対象のクラス=[{1}]、最後に取得したフィールド=[{2}]
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    KMGCORE_GEN11200("フィールドの取得に失敗しました。フィールド名=[{0}]、対象のクラス=[{1}]、最後に取得したフィールド=[{2}]"),

    /**
     * フィールドの値の取得に失敗しました。フィールド名=[{0}]、対象のクラス=[{1}]、最後に取得したフィールド=[{2}]
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    KMGCORE_GEN11201("フィールドの値の取得に失敗しました。フィールド名=[{0}]、対象のクラス=[{1}]、最後に取得したフィールド=[{2}]"),

    /**
     * フィールドの値の取得に失敗しました。フィールド名=[{0}]、対象のクラス=[{1}]、最後に取得したフィールド=[{2}]
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    KMGCORE_GEN11202("フィールドの値の取得に失敗しました。フィールド名=[{0}]、対象のクラス=[{1}]、最後に取得したフィールド=[{2}]"),

    /**
     * メソッドの取得に失敗しました。メソッド名=[{0}]、対象のクラス=[{1}]
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    KMGCORE_GEN11203("メソッドの取得に失敗しました。メソッド名=[{0}]、対象のクラス=[{1}]"),

    /**
     * メソッドの値の取得に失敗しました。メソッド名=[{0}]、対象のクラス=[{1}]
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    KMGCORE_GEN11204("メソッドの値の取得に失敗しました。メソッド名=[{0}]、対象のクラス=[{1}]"),

    /**
     * メソッドの値の取得に失敗しました。メソッド名=[{0}]、対象のクラス=[{1}]
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    KMGCORE_GEN11205("メソッドの値の取得に失敗しました。メソッド名=[{0}]、対象のクラス=[{1}]"),

    /**
     * メソッドの値の取得に失敗しました。メソッド名=[{0}]、対象のクラス=[{1}]
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    KMGCORE_GEN11206("メソッドの値の取得に失敗しました。メソッド名=[{0}]、対象のクラス=[{1}]"),

    /**
     * メソッドの値の取得に失敗しました。メソッド名=[{0}]、対象のクラス=[{1}]
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    KMGCORE_GEN11207("メソッドの値の取得に失敗しました。メソッド名=[{0}]、対象のクラス=[{1}]"),

    /**
     * フィールドの取得に失敗しました。フィールド名=[{0}]、対象のクラス=[{1}]、最後に取得したフィールド=[{2}]
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    KMGCORE_GEN11209("フィールドの取得に失敗しました。フィールド名=[{0}]、対象のクラス=[{1}]、最後に取得したフィールド=[{2}]"),

    /**
     * フィールドの値の設定に失敗しました。フィールド名=[{0}]、対象のクラス=[{1}]、最後に取得したフィールド=[{2}]
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    KMGCORE_GEN11210("フィールドの値の設定に失敗しました。フィールド名=[{0}]、対象のクラス=[{1}]、最後に取得したフィールド=[{2}]"),

    /**
     * フィールドの値の設定に失敗しました。フィールド名=[{0}]、対象のクラス=[{1}]、最後に取得したフィールド=[{2}]
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    KMGCORE_GEN11211("フィールドの値の設定に失敗しました。フィールド名=[{0}]、対象のクラス=[{1}]、最後に取得したフィールド=[{2}]"),

    /**
     * クラスからビルドバスの取得に失敗しました。クラス=[{0}]
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    KMGCORE_GEN24000("クラスからビルドバスの取得に失敗しました。クラス=[{0}]"),

    /* 定義：終了 */
    ;

    /**
     * 種類のマップ
     *
     * @since 0.2.0
     */
    private static final Map<String, KmgCoreGenMsgTypes> VALUES_MAP = new HashMap<>();

    static {

        /* 種類のマップにプット */
        for (final KmgCoreGenMsgTypes type : KmgCoreGenMsgTypes.values()) {

            KmgCoreGenMsgTypes.VALUES_MAP.put(type.get(), type);

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
    public static KmgCoreGenMsgTypes getDefault() {

        final KmgCoreGenMsgTypes result = NONE;
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
    public static KmgCoreGenMsgTypes getEnum(final String key) {

        KmgCoreGenMsgTypes result = KmgCoreGenMsgTypes.VALUES_MAP.get(key);

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
    public static KmgCoreGenMsgTypes getInitValue() {

        final KmgCoreGenMsgTypes result = NONE;
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
    KmgCoreGenMsgTypes(final String displayName) {

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

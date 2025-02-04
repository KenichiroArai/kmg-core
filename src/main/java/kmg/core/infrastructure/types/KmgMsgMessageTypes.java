package kmg.core.infrastructure.types;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import kmg.core.infrastructure.common.KmgMessageTypes;

/**
 * KMGメッセージメッセージの種類<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
@SuppressWarnings("nls")
public enum KmgMsgMessageTypes implements Supplier<String>, KmgMessageTypes {

    /* 定義：開始 */

    /** 指定無し */
    NONE("指定無し", null),

    /** {0}がありません。 */
    KMGMSGE11100("{0}がありません。", "KMGMSGE11100"),

    /** フィールドの取得に失敗しました。フィールド名=[{0}]、対象のクラス=[{1}]、最後に取得したフィールド=[{2}] */
    KMGMSGE11200("フィールドの取得に失敗しました。フィールド名=[{0}]、対象のクラス=[{1}]、最後に取得したフィールド=[{2}]", "KMGMSGE11200"),

    /** フィールドの値の取得に失敗しました。フィールド名=[{0}]、対象のクラス=[{1}]、最後に取得したフィールド=[{2}] */
    KMGMSGE11201("フィールドの値の取得に失敗しました。フィールド名=[{0}]、対象のクラス=[{1}]、最後に取得したフィールド=[{2}]", "KMGMSGE11201"),

    /** フィールドの値の取得に失敗しました。フィールド名=[{0}]、対象のクラス=[{1}]、最後に取得したフィールド=[{2}] */
    KMGMSGE11202("フィールドの値の取得に失敗しました。フィールド名=[{0}]、対象のクラス=[{1}]、最後に取得したフィールド=[{2}]", "KMGMSGE11202"),

    /** メソッドの取得に失敗しました。メソッド名=[{0}]、対象のクラス=[{1}] */
    KMGMSGE11203("メソッドの取得に失敗しました。メソッド名=[{0}]、対象のクラス=[{1}]", "KMGMSGE11203"),

    /** メソッドの値の取得に失敗しました。メソッド名=[{0}]、対象のクラス=[{1}] */
    KMGMSGE11204("メソッドの値の取得に失敗しました。メソッド名=[{0}]、対象のクラス=[{1}]", "KMGMSGE11204"),

    /** メソッドの値の取得に失敗しました。メソッド名=[{0}]、対象のクラス=[{1}] */
    KMGMSGE11205("メソッドの値の取得に失敗しました。メソッド名=[{0}]、対象のクラス=[{1}]", "KMGMSGE11205"),

    /** メソッドの値の取得に失敗しました。メソッド名=[{0}]、対象のクラス=[{1}] */
    KMGMSGE11206("メソッドの値の取得に失敗しました。メソッド名=[{0}]、対象のクラス=[{1}]", "KMGMSGE11206"),

    /** メソッドの値の取得に失敗しました。メソッド名=[{0}]、対象のクラス=[{1}] */
    KMGMSGE11207("メソッドの値の取得に失敗しました。メソッド名=[{0}]、対象のクラス=[{1}]", "KMGMSGE11207"),

    /** メソッドの値の取得に失敗しました。メソッド名=[{0}]、対象のクラス=[{1}] */
    KMGMSGE11208("メソッドの値の取得に失敗しました。メソッド名=[{0}]、対象のクラス=[{1}]", "KMGMSGE11208"),

    /** フィールドの取得に失敗しました。フィールド名=[{0}]、対象のクラス=[{1}]、最後に取得したフィールド=[{2}] */
    KMGMSGE11209("フィールドの取得に失敗しました。フィールド名=[{0}]、対象のクラス=[{1}]、最後に取得したフィールド=[{2}]", "KMGMSGE11209"),

    /** フィールドの値の設定に失敗しました。フィールド名=[{0}]、対象のクラス=[{1}]、最後に取得したフィールド=[{2}] */
    KMGMSGE11210("フィールドの値の設定に失敗しました。フィールド名=[{0}]、対象のクラス=[{1}]、最後に取得したフィールド=[{2}]", "KMGMSGE11210"),

    /** フィールドの値の設定に失敗しました。フィールド名=[{0}]、対象のクラス=[{1}]、最後に取得したフィールド=[{2}] */
    KMGMSGE11211("フィールドの値の設定に失敗しました。フィールド名=[{0}]、対象のクラス=[{1}]、最後に取得したフィールド=[{2}]", "KMGMSGE11211"),

    /** クラスからビルドバスの取得に失敗しました。クラス=[{0}] */
    KMGMSGE24000("クラスからビルドバスの取得に失敗しました。クラス=[{0}]", "KMGMSGE24000"),

    /* 定義：終了 */
    ;

    /** 種類のマップ */
    private static final Map<String, KmgMsgMessageTypes> VALUES_MAP = new HashMap<>();

    static {

        /* 種類のマップにプット */
        for (final KmgMsgMessageTypes type : KmgMsgMessageTypes.values()) {

            KmgMsgMessageTypes.VALUES_MAP.put(type.get(), type);

        }

    }

    /** 名称 */
    private final String name;

    /** 値 */
    private final String value;

    /**
     * デフォルトの種類を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return デフォルト値
     */
    public static KmgMsgMessageTypes getDefault() {

        final KmgMsgMessageTypes result = NONE;
        return result;

    }

    /**
     * 値に該当する種類を返す<br>
     * <p>
     * 但し、値が存在しない場合は、指定無し（NONE）を返す。
     * </p>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param value
     *              値
     * @return 種類。指定無し（NONE）：値が存在しない場合。
     */
    public static KmgMsgMessageTypes getEnum(final String value) {

        KmgMsgMessageTypes result = KmgMsgMessageTypes.VALUES_MAP.get(value);

        if (result == null) {

            result = NONE;

        }
        return result;

    }

    /**
     * 初期値の種類を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 初期値
     */
    public static KmgMsgMessageTypes getInitValue() {

        final KmgMsgMessageTypes result = NONE;
        return result;

    }

    /**
     * コンストラクタ<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param name
     *              名称
     * @param value
     *              値
     */
    KmgMsgMessageTypes(final String name, final String value) {

        this.name = name;
        this.value = value;

    }

    /**
     * 種類の値を返す。<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 種類の値
     */
    @Override
    public String get() {

        final String result = this.value;
        return result;

    }

    /**
     * 種類の値を返す。<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 種類の値
     */
    @Override
    public String getCode() {

        final String result = this.value;
        return result;

    }

    /**
     * 名称を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 名称
     */
    @Override
    public String getName() {

        final String result = this.name;
        return result;

    }

    /**
     * 値を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 値
     */
    public String getValue() {

        final String result = this.value;
        return result;

    }

    /**
     * 値を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 値
     */
    @Override
    public String toString() {

        final String result = this.value;
        return result;

    }
}

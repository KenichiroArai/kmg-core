package kmg.core.infrastructure.types;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import kmg.core.infrastructure.common.MessageTypes;

/**
 * KMGログメッセージの種類<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
@SuppressWarnings("nls")
public enum KmgLogMessageTypes implements Supplier<String>, MessageTypes {

    /* 定義：開始 */

    /** 指定無し */
    NONE("指定無し", null),

    // TODO 2021/06/08 不要なので削除する
    /** サンプル */
    I00001("サンプル", "I00001"),

    /* 定義：終了 */
    ;

    /** 種類のマップ */
    private static final Map<String, KmgLogMessageTypes> VALUES_MAP = new HashMap<>();

    static {

        /* 種類のマップにプット */
        for (final KmgLogMessageTypes type : KmgLogMessageTypes.values()) {

            KmgLogMessageTypes.VALUES_MAP.put(type.get(), type);

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
    public static KmgLogMessageTypes getDefault() {

        final KmgLogMessageTypes result = NONE;
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
    public static KmgLogMessageTypes getEnum(final String value) {

        KmgLogMessageTypes result = KmgLogMessageTypes.VALUES_MAP.get(value);

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
    public static KmgLogMessageTypes getInitValue() {

        final KmgLogMessageTypes result = NONE;
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
    KmgLogMessageTypes(final String name, final String value) {

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

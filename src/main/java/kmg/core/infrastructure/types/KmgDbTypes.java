package kmg.core.infrastructure.types;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import kmg.core.infrastructure.type.KmgString;
import kmg.core.infrastructure.utils.KmgArrayUtils;

/**
 * KMGＤＢの種類<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
@SuppressWarnings("nls")
public enum KmgDbTypes implements Supplier<String> {

    /* 定義：開始 */

    /** 指定無し */
    NONE("指定無し", null, null),

    /** PostgreSQL */
    POSTGRE_SQL("PostgreSQL", "PostgreSQL", new String[] {
        "Postgres"
    }),

    /** MySQL */
    MYSQL("MySQL", "MySQL", null),

    /** Oracle */
    ORACLE("Oracle", "Oracle", null),

    /** SQL Server */
    SQL_SERVER("SQL Server", "SQL Server", new String[] {
        "MS SQL"
    }),

    /* 定義：終了 */
    ;

    /** 種類のマップ */
    private static final Map<String, KmgDbTypes> valuesMap = new HashMap<>();

    static {

        /* 種類のマップにプット */
        for (final KmgDbTypes type : KmgDbTypes.values()) {

            KmgDbTypes.valuesMap.put(type.get(), type);

        }

    }

    /** 名称 */
    private final String name;

    /** 値 */
    private final String value;

    /** 別名の配列 */
    private final String[] aliasArray;

    /**
     * デフォルトの種類を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 初期値
     */
    public static KmgDbTypes getDefault() {

        final KmgDbTypes result = NONE;
        return result;

    }

    /**
     * 値に該当する種類を返す<br>
     * <p>
     * 但し、値が存在しない場合は、指定無し（NONE）を返す
     * </p>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param value
     *              値
     * @return 種類。指定無し（NONE）：値が存在しない場合
     */
    public static KmgDbTypes getEnum(final String value) {

        KmgDbTypes result = KmgDbTypes.valuesMap.get(value);

        if (result == null) {

            result = NONE;

        }

        return result;

    }

    /**
     * 対象に該当する種類を返す<br>
     * <p>
     * 対象は値または別名で大文字小文字を区別しないで検索する。<br>
     * 但し、対象が存在しない場合は、指定無し（NONE）を返す。<br>
     * </p>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param target
     *               対象
     * @return 種類。指定無し（NONE）：対象が存在しない場合
     */
    public static KmgDbTypes getEnumByTarget(final String target) {

        KmgDbTypes result = KmgDbTypes.valuesMap.get(target);

        if (result != null) {

            return result;

        }

        for (final KmgDbTypes type : KmgDbTypes.values()) {

            if (KmgString.equalsIgnoreCase(type.value, target)) {

                result = type;
                return result;

            }

            if (KmgArrayUtils.isEmpty(type.aliasArray)) {

                continue;

            }

            for (final String alias : type.aliasArray) {

                if (!KmgString.equalsIgnoreCase(alias, target)) {

                    continue;

                }
                result = type;
                return result;

            }

        }

        result = NONE;
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
    public static KmgDbTypes getInitValue() {

        final KmgDbTypes result = NONE;
        return result;

    }

    /**
     * コンストラクタ<br>
     *
     * @author KenichiroArai
     * @since 1.0.0
     * @version 1.0.0
     * @param name
     *                   名称
     * @param value
     *                   値
     * @param aliasArray
     *                   別名の配列
     */
    KmgDbTypes(final String name, final String value, final String[] aliasArray) {

        this.name = name;
        this.value = value;
        this.aliasArray = aliasArray;

    }

    /**
     * 種類の値<br>
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
     * 別名の配列を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 別名の配列
     */
    public String[] getAliasArray() {

        final String[] result = this.aliasArray;
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

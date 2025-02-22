package kmg.core.infrastructure.types;

import java.util.HashMap;
import java.util.Map;

import kmg.core.infrastructure.common.KmgTypes;
import kmg.core.infrastructure.type.KmgString;
import kmg.core.infrastructure.utils.KmgArrayUtils;

/**
 * KMGＤＢの種類<br>
 *
 * @author KenichiroArai
 *
 * @sine 1.0.0
 *
 * @version 1.0.0
 */
@SuppressWarnings("nls")
public enum KmgDbTypes implements KmgTypes<String> {

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
    private static final Map<String, KmgDbTypes> VALUES_MAP = new HashMap<>();

    static {

        /* 種類のマップにプット */
        for (final KmgDbTypes type : KmgDbTypes.values()) {

            KmgDbTypes.VALUES_MAP.put(type.get(), type);

        }

    }

    /** 表示名 */
    private final String displayName;

    /** キー */
    private final String key;

    /** 詳細情報 */
    private final String detail;

    /** 別名の配列 */
    private final String[] aliasArray;

    /**
     * デフォルトの種類を返す<br>
     *
     * @author KenichiroArai
     *
     * @sine 1.0.0
     *
     * @version 1.0.0
     *
     * @return デフォルト値
     */
    public static KmgDbTypes getDefault() {

        final KmgDbTypes result = NONE;
        return result;

    }

    /**
     * キーに該当する種類を返す<br>
     * <p>
     * 但し、キーが存在しない場合は、指定無し（NONE）を返す。
     * </p>
     *
     * @author KenichiroArai
     *
     * @sine 1.0.0
     *
     * @version 1.0.0
     *
     * @param key
     *            キー
     *
     * @return 種類。指定無し（NONE）：キーが存在しない場合。
     */
    public static KmgDbTypes getEnum(final String key) {

        KmgDbTypes result = KmgDbTypes.VALUES_MAP.get(key);

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
     *
     * @sine 1.0.0
     *
     * @version 1.0.0
     *
     * @param target
     *               対象
     *
     * @return 種類。指定無し（NONE）：対象が存在しない場合
     */
    public static KmgDbTypes getEnumByTarget(final String target) {

        KmgDbTypes result = KmgDbTypes.VALUES_MAP.get(target);

        if (result != null) {

            return result;

        }

        for (final KmgDbTypes type : KmgDbTypes.values()) {

            if (KmgString.equalsIgnoreCase(type.key, target)) {

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
     *
     * @sine 1.0.0
     *
     * @version 1.0.0
     *
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
     *
     * @sine 1.0.0
     *
     * @version 1.0.0
     *
     * @param displayName
     *                    表示名
     * @param key
     *                    キー
     * @param aliasArray
     *                    別名の配列
     */
    KmgDbTypes(final String displayName, final String key, final String[] aliasArray) {

        this.displayName = displayName;
        this.key = key;
        this.detail = displayName;
        this.aliasArray = aliasArray;

    }

    /**
     * キーを返す。<br>
     * このメソッドは{@link #getKey()}のエイリアスです。
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
     * 別名の配列を返す<br>
     *
     * @author KenichiroArai
     *
     * @sine 1.0.0
     *
     * @version 1.0.0
     *
     * @return 別名の配列
     */
    public String[] getAliasArray() {

        final String[] result = this.aliasArray;
        return result;

    }

    /**
     * 詳細情報を返す。<br>
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
     * @return キー
     */
    @Override
    public String getKey() {

        final String result = this.key;
        return result;

    }

    /**
     * キーを返す。<br>
     * このメソッドは{@link #getKey()}のエイリアスです。
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

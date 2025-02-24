package kmg.core.infrastructure.types;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import kmg.core.infrastructure.common.KmgTypes;
import kmg.core.infrastructure.type.KmgString;

/**
 * KMG文字セットの種類<br>
 *
 * @author KenichiroArai
 *
 * @sine 0.1.0
 *
 * @version 0.1.0
 */
@SuppressWarnings("nls")
public enum KmgCharsetTypes implements KmgTypes<String> {

    /* 定義：開始 */

    /**
     * 指定無し
     *
     * @author KenichiroArai
     *
     * @sine 0.1.0
     *
     * @version 0.1.0
     */
    NONE("指定無し", null),

    /**
     * MS932
     *
     * @author KenichiroArai
     *
     * @sine 0.1.0
     *
     * @version 0.1.0
     */
    MS932("MS932", "MS932"),

    /**
     * UTF-8
     *
     * @author KenichiroArai
     *
     * @sine 0.1.0
     *
     * @version 0.1.0
     */
    UTF8("UTF-8", "UTF-8"),

    /* 定義：終了 */
    ;

    /**
     * 種類のマップ
     *
     * @author KenichiroArai
     *
     * @sine 0.1.0
     *
     * @version 0.1.0
     */
    private static final Map<String, KmgCharsetTypes> VALUES_MAP = new HashMap<>();

    static {

        /* 種類のマップにプット */
        for (final KmgCharsetTypes type : KmgCharsetTypes.values()) {

            KmgCharsetTypes.VALUES_MAP.put(type.get(), type);

        }

    }

    /**
     * 表示名
     *
     * @author KenichiroArai
     *
     * @sine 0.1.0
     *
     * @version 0.1.0
     */
    private final String displayName;

    /**
     * キー
     *
     * @author KenichiroArai
     *
     * @sine 0.1.0
     *
     * @version 0.1.0
     */
    private final String key;

    /**
     * 詳細情報
     *
     * @author KenichiroArai
     *
     * @sine 0.1.0
     *
     * @version 0.1.0
     */
    private final String detail;

    /**
     * 文字セット
     *
     * @author KenichiroArai
     *
     * @sine 0.1.0
     *
     * @version 0.1.0
     */
    private Charset charset;

    /**
     * デフォルトの種類を返す<br>
     *
     * @author KenichiroArai
     *
     * @sine 0.1.0
     *
     * @version 0.1.0
     *
     * @return デフォルト値
     */
    public static KmgCharsetTypes getDefault() {

        final KmgCharsetTypes result = NONE;
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
     * @sine 0.1.0
     *
     * @version 0.1.0
     *
     * @param key
     *            キー
     *
     * @return 種類。指定無し（NONE）：キーが存在しない場合。
     */
    public static KmgCharsetTypes getEnum(final String key) {

        KmgCharsetTypes result = KmgCharsetTypes.VALUES_MAP.get(key);

        if (result == null) {

            result = NONE;

        }
        return result;

    }

    /**
     * 初期値の種類を返す<br>
     *
     * @author KenichiroArai
     *
     * @sine 0.1.0
     *
     * @version 0.1.0
     *
     * @return 初期値
     */
    public static KmgCharsetTypes getInitValue() {

        final KmgCharsetTypes result = NONE;
        return result;

    }

    /**
     * コンストラクタ<br>
     *
     * @author KenichiroArai
     *
     * @sine 0.1.0
     *
     * @version 0.1.0
     *
     * @param displayName
     *                    表示名
     * @param key
     *                    キー
     */
    KmgCharsetTypes(final String displayName, final String key) {

        this.displayName = displayName;
        this.key = key;
        this.detail = displayName;

        if (KmgString.isEmpty(key)) {

            this.charset = null;

        } else {

            this.charset = Charset.forName(key);

        }

    }

    /**
     * キーを返す。<br>
     *
     * @author KenichiroArai
     *
     * @sine 0.1.0
     *
     * @version 0.1.0
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
     * @author KenichiroArai
     *
     * @sine 0.1.0
     *
     * @version 0.1.0
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
     * @author KenichiroArai
     *
     * @sine 0.1.0
     *
     * @version 0.1.0
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
     * @author KenichiroArai
     *
     * @sine 0.1.0
     *
     * @version 0.1.0
     *
     * @return キー
     */
    @Override
    public String getKey() {

        final String result = this.key;
        return result;

    }

    /**
     * 文字セットを返す<br>
     * <p>
     * NONEの場合は、nullを返す。
     * </p>
     *
     * @author KenichiroArai
     *
     * @sine 0.1.0
     *
     * @version 0.1.0
     *
     * @return 文字セット
     */
    public Charset toCharset() {

        final Charset result = this.charset;
        return result;

    }

    /**
     * キーを返す。<br>
     *
     * @author KenichiroArai
     *
     * @sine 0.1.0
     *
     * @version 0.1.0
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

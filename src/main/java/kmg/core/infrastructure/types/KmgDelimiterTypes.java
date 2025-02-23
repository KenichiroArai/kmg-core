package kmg.core.infrastructure.types;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kmg.core.infrastructure.common.KmgTypes;
import kmg.core.infrastructure.type.KmgString;

/**
 * KMG区切り文字の種類<br>
 *
 * @author KenichiroArai
 *
 * @sine 1.0.0
 *
 * @version 1.0.0
 */
@SuppressWarnings("nls")
public enum KmgDelimiterTypes implements KmgTypes<String> {

    /* 定義：開始 */

    /** 指定無し */
    NONE("指定無し", null),

    /** ピリオド */
    PERIOD("ピリオド", "."),

    /** カンマ */
    COMMA("カンマ", ","),

    /** コロン */
    COLON("コロン", "."),

    /** バーティカルバー */
    VERTICAL_BAR("バーティカルバー", "|"),

    /** アンダースコア */
    UNDERSCORE("アンダースコア", "_"),

    /** スラッシュ */
    SLASH("スラッシュ", "/"),

    /** ハイフン */
    HYPHEN("ハイフン", "-"),

    /** 半角スペース */
    HALF_SPACE("半角スペース", KmgString.HALF_SPACE),

    /** プラス */
    PLUS("プラス", "+"),

    /** 全角コロン */
    ALL_COLON("全角コロン", "："),

    /** 全角読点 */
    ALL_IDEOGRAPHIC("全角読点", "、"),

    /** 連続半角スペース */
    SERIES_HALF_SPACE("連続半角スペース", "\\s+"),

    /** 改行 */
    LINE_SEPARATOR("改行", KmgString.LINE_SEPARATOR),

    /** 半角イコール */
    HALF_EQUAL("半角イコール", "="),

    /** 半角アットマーク */
    HALF_AT_SIGN("半角アットマーク", "@"),

    /* 定義：終了 */
    ;

    /** 種類のマップ */
    private static final Map<String, KmgDelimiterTypes> VALUES_MAP = new HashMap<>();

    static {

        /* 種類のマップにプット */
        for (final KmgDelimiterTypes type : KmgDelimiterTypes.values()) {

            KmgDelimiterTypes.VALUES_MAP.put(type.get(), type);

        }

    }

    /** 表示名 */
    private final String displayName;

    /** キー */
    private final String key;

    /** 詳細情報 */
    private final String detail;

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
    public static KmgDelimiterTypes getDefault() {

        final KmgDelimiterTypes result = NONE;
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
    public static KmgDelimiterTypes getEnum(final String key) {

        KmgDelimiterTypes result = KmgDelimiterTypes.VALUES_MAP.get(key);

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
     * @sine 1.0.0
     *
     * @version 1.0.0
     *
     * @return 初期値
     */
    public static KmgDelimiterTypes getInitValue() {

        final KmgDelimiterTypes result = NONE;
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
     */
    KmgDelimiterTypes(final String displayName, final String key) {

        this.displayName = displayName;
        this.key = key;
        this.detail = displayName;

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
     * 結合する文字列リストにデリミタを付加して文字列を返す<br>
     * <p>
     * 但し、結合する文字列がnullまたは空文字の場合は結合しない
     * </p>
     *
     * @author KenichiroArai
     *
     * @sine 1.0.0
     *
     * @version 1.0.0
     *
     * @param <T>
     *                   結合する文字列の型
     * @param targetList
     *                   結合する文字列リスト
     *
     * @return 結合する文字列リストにデリミタを付加した文字列
     */
    public <T> String join(final List<T> targetList) {

        final String result = this.join(targetList.toArray(new Object[0]));
        return result;

    }

    /**
     * 結合する文字列にデリミタを付加して文字列を返す<br>
     * <p>
     * 結合する文字列にnullまたは空文字があるの場合はその結合する文字列を含めない。<br>
     * 結合する文字列がnullの場合は空文字を返す。<br>
     * </p>
     *
     * @author KenichiroArai
     *
     * @sine 1.0.0
     *
     * @version 1.0.0
     *
     * @param targets
     *                結合する文字列
     *
     * @return 結合する文字列にデリミタを付加した文字列
     */
    public String join(final Object... targets) {

        String result = KmgString.EMPTY;

        if (targets == null) {

            return result;

        }

        final StringBuilder sb = new StringBuilder();

        for (final Object target : targets) {

            if (target == null) {

                continue;

            }

            if (KmgString.isEmpty(target.toString())) {

                continue;

            }

            sb.append(target.toString());
            sb.append(this.key);

        }

        if (sb.length() > 1) {

            result = sb.substring(0, sb.length() - 1).toString();

        }

        return result;

    }

    /**
     * 結合する文字列にデリミタを付加して文字列を返す<br>
     * <p>
     * 結合する文字列にnullまたは空文字があるの場合はそのまま結合する<br>
     * 結合する文字列がnullの場合は空文字を返す。<br>
     * </p>
     *
     * @author KenichiroArai
     *
     * @sine 1.0.0
     *
     * @version 1.0.0
     *
     * @param targets
     *                結合する文字列
     *
     * @return 結合する文字列にデリミタを付加した文字列
     */
    public String joinAll(final Object... targets) {

        String result = KmgString.EMPTY;

        if ((targets == null) || (targets.length == 0)) {

            return result;

        }

        // リストが渡された場合は配列に変換
        Object[] targetArray = targets;

        if ((targets.length == 1) && (targets[0] instanceof final List<?> list)) {

            targetArray = list.toArray();

        }

        final StringBuilder sb = new StringBuilder();

        for (final Object target : targetArray) {

            if (target == null) {

                sb.append("null");

            } else {

                sb.append(target.toString());

            }
            sb.append(this.key);

        }

        if (sb.length() > 1) {

            result = sb.substring(0, sb.length() - 1).toString();

        }

        return result;

    }

    /**
     * 分割する文字列を分割し、文字列の配列にして返す。<br>
     *
     * @author KenichiroArai
     *
     * @sine 1.0.0
     *
     * @version 1.0.0
     *
     * @param target
     *               分割する文字列
     *
     * @return 分割した文字列の配列
     */
    public String[] split(final String target) {

        String[] result = null;

        if (KmgString.isEmpty(target)) {

            return result;

        }

        result = target.split(this.key);

        return result;

    }

    /**
     * 分割する文字列を分割し、文字列の配列にして返す。<br>
     *
     * @author KenichiroArai
     *
     * @sine 1.0.0
     *
     * @version 1.0.0
     *
     * @param target
     *               分割する文字列
     * @param limit
     *               制限数
     *
     * @return 分割した文字列の配列
     */
    public String[] split(final String target, final int limit) {

        String[] result = null;

        if (KmgString.isEmpty(target)) {

            return result;

        }

        result = target.split(this.key, limit);

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

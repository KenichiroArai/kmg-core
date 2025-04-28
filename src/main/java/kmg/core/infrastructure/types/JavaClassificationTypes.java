package kmg.core.infrastructure.types;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import kmg.core.infrastructure.common.KmgComTypes;
import kmg.core.infrastructure.type.KmgString;

/**
 * Java区分の種類<br>
 *
 * @author KenichiroArai
 *
 * @since 0.2.0
 *
 * @version 0.2.0
 */
@SuppressWarnings("nls")
public enum JavaClassificationTypes implements KmgComTypes<String> {

    /* 定義：開始 */

    /**
     * 指定無し
     *
     * @version 0.2.0
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    NONE("指定無し", KmgJavaKeywordTypes.NONE, "指定無し", null),

    /**
     * クラス
     *
     * @version 0.2.0
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    CLASS("クラス", KmgJavaKeywordTypes.CLASS, "クラス",
        "^\\s*(public|private|protected|abstract|final)\\s+(class)\\s+\\w+.*"),

    /**
     * インターフェース
     *
     * @version 0.2.0
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    INTERFACE("インターフェース", KmgJavaKeywordTypes.INTERFACE, "インターフェース",
        "^\\s*(public|private|protected)\\s+(interface)\\s+\\w+.*"),

    /**
     * 列挙型
     *
     * @version 0.2.0
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    ENUM("列挙型", KmgJavaKeywordTypes.ENUM, "列挙型", "^\\s*(public|private|protected)\\s+(enum)\\s+\\w+.*"),

    /**
     * アノテーション定義
     *
     * @version 0.2.0
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    ANNOTATION_DEFINITION("アノテーション定義", KmgJavaKeywordTypes.NONE, "アノテーション定義",
        "^\\s*(public|private|protected)\\s+@interface\\s+\\w+.*"),

    /**
     * アノテーション使用<br>
     * <p>
     * Javadocのタグと区別するため、区分判定パターンで除外している。
     * </p>
     *
     * @version 0.2.0
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    ANNOTATION_USAGE("アノテーション使用", KmgJavaKeywordTypes.NONE, "アノテーション使用",
        "^\\s*@(?!(author|since|version|param|return|throws|see|deprecated|Override))\\w+.*"),

    /**
     * フィールド
     *
     * @version 0.2.0
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    FIELD("フィールド", KmgJavaKeywordTypes.NONE, "フィールド",
        "^\\s*(public|private|protected|static|final)\\s+((\\w+\\s+)*\\w+\\s+\\w+.*;)"),

    /**
     * メソッド
     *
     * @version 0.2.0
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    METHOD("メソッド", KmgJavaKeywordTypes.NONE, "メソッド",
        "^\\s*(public|private|protected|static|final|abstract|synchronized)\\s+([\\w<>\\[\\]]+\\s+)?\\w+\\s*\\(.*\\).*"),

    /**
     * コンストラクタ
     *
     * @version 0.2.0
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    CONSTRUCTOR("コンストラクタ", KmgJavaKeywordTypes.NONE, "コンストラクタ",
        "^\\s*(public|private|protected)\\s+\\w+\\s*\\(.*\\)\\s*\\{.*$"),

    /**
     * モジュール
     *
     * @version 0.2.0
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    MODULE("モジュール", KmgJavaKeywordTypes.MODULE, "モジュール", "^\\s*module\\s+\\w+\\s*\\{.*$"),

    /* 定義：終了 */
    ;

    /**
     * 種類のマップ
     *
     * @since 0.2.0
     */
    private static final Map<KmgJavaKeywordTypes, JavaClassificationTypes> VALUES_MAP = new HashMap<>();

    static {

        /* 種類のマップにプット */
        for (final JavaClassificationTypes type : JavaClassificationTypes.values()) {

            JavaClassificationTypes.VALUES_MAP.put(type.key, type);

        }

    }

    /**
     * グループ名：要素名
     */
    private static final String GROUP_ELEMENT_NAME = "elementName";

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
    private final KmgJavaKeywordTypes key;

    /**
     * 詳細情報
     *
     * @since 0.2.0
     */
    private final String detail;

    /**
     * 区分判定パターン
     *
     * @since 0.2.0
     */
    private final String classificationPattern;

    /**
     * デフォルトの種類を返す<br>
     *
     * @since 0.2.0
     *
     * @return デフォルト値
     */
    public static JavaClassificationTypes getDefault() {

        final JavaClassificationTypes result = NONE;
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
     * @version 0.2.0
     *
     * @since 0.2.0
     *
     * @param key
     *            キー
     *
     * @return 種類。指定無し（NONE）：キーが存在しない場合。
     */
    public static JavaClassificationTypes getEnum(final String key) {

        JavaClassificationTypes result = JavaClassificationTypes.VALUES_MAP.get(KmgJavaKeywordTypes.getEnum(key));

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
    public static JavaClassificationTypes getInitValue() {

        final JavaClassificationTypes result = NONE;
        return result;

    }

    /**
     * 判定対象の文字列からJava区分を判別する<br>
     *
     * @since 0.2.0
     *
     * @param text
     *             判定対象の文字列
     *
     * @return Java区分。該当する区分が見つからない場合はNONEを返す
     */
    public static JavaClassificationTypes identify(final String text) {

        JavaClassificationTypes result = NONE;

        // 引数チェック
        if (KmgString.isEmpty(text)) {

            return result;

        }

        for (final JavaClassificationTypes type : JavaClassificationTypes.values()) {

            // NONEか
            if (type == NONE) {
                // NONEの場合

                continue;

            }

            // 区分判定パターンがnullか
            if (type.getClassificationPattern() == null) {
                // nullの場合

                continue;

            }

            // 判定対象の文字列が区分判定パターンにマッチしないか
            final Pattern pattern = Pattern.compile(type.getClassificationPattern());
            final Matcher matcher = pattern.matcher(text);

            if (!matcher.find()) {

                // マッチしない場合
                continue;

            }
            result = type;
            break;

        }

        return result;

    }

    /**
     * コンストラクタ<br>
     *
     * @author KenichiroArai
     *
     * @version 0.2.0
     *
     * @since 0.2.0
     *
     * @param displayName
     *                              表示名
     * @param key
     *                              キー
     * @param detail
     *                              詳細情報
     * @param classificationPattern
     *                              区分判定パターン
     */
    JavaClassificationTypes(final String displayName, final KmgJavaKeywordTypes key, final String detail,
        final String classificationPattern) {

        this.displayName = displayName;
        this.key = key;
        this.detail = detail;
        this.classificationPattern = classificationPattern;

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
     * 区分判定パターンを返す。<br>
     *
     * @since 0.2.0
     *
     * @return 区分判定パターン
     */
    public String getClassificationPattern() {

        final String result = this.classificationPattern;
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
     * 判定対象の文字列から要素名を返す。<br>
     *
     * @since 0.2.0
     *
     * @param text
     *             判定対象の文字列
     *
     * @return 要素名
     */
    public String getElementName(final String text) {

        String result = KmgString.EMPTY;

        // 引数チェック
        if (KmgString.isEmpty(text)) {

            return result;

        }

        // NONEか
        if (this == NONE) {
            // NONEの場合

            return result;

        }

        // 区分判定パターンがnullか
        if (this.getClassificationPattern() == null) {
            // nullの場合

            return result;

        }

        // 判定対象の文字列が区分判定パターンにマッチしないか
        final Pattern pattern = Pattern.compile(this.getClassificationPattern());
        final Matcher matcher = pattern.matcher(text);

        if (!matcher.find()) {
            // マッチしない場合

            return result;

        }

        // 要素名を設定する
        try {

            result = matcher.group(JavaClassificationTypes.GROUP_ELEMENT_NAME);

        } catch (final IllegalArgumentException e) {

            // TODO KenichiroArai 2025/04/29 例外処理
            e.printStackTrace();

        }

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

        final String result = this.key.getKey();
        return result;

    }

    /**
     * Javadoc対象の区分かを判定する<br>
     *
     * @since 0.2.0
     *
     * @return true：Javadoc対象の区分、false：Javadoc対象外の区分
     */
    public boolean isJavadocTarget() {

        final boolean result = switch (this) {

            // Javadoc対象
            case CLASS, INTERFACE, ENUM, ANNOTATION_DEFINITION, FIELD, METHOD, CONSTRUCTOR, MODULE -> true;

            // Javadoc対象外
            case NONE, ANNOTATION_USAGE -> false;

        };

        return result;

    }

    /**
     * Javadoc対象外の区分かを判定する<br>
     *
     * @since 0.2.0
     *
     * @return true：Javadoc対象外の区分、false：Javadoc対象の区分
     */
    public boolean isNotJavadocTarget() {

        final boolean result = !this.isJavadocTarget();
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

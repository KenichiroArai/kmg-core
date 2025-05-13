package kmg.core.infrastructure.types;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kmg.core.infrastructure.common.KmgComTypes;
import kmg.core.infrastructure.type.KmgString;

/**
 * KMG Javadocタグの種類<br>
 *
 * @author KenichiroArai
 *
 * @since 0.2.0
 *
 * @version 0.2.0
 */
@SuppressWarnings("nls")
public enum KmgJavadocTagTypes implements KmgComTypes<String> {

    /* 定義：開始 */

    /**
     * 指定無し
     *
     * @since 0.2.0
     */
    NONE("指定無し", "None", "指定無し", List.of()),

    /**
     * 著者
     *
     * @since 0.2.0
     */
    AUTHOR("著者", "@author", "クラスやインタフェースの作成者を示す",
        Arrays.asList(JavaClassificationTypes.CLASS, JavaClassificationTypes.INTERFACE, JavaClassificationTypes.ENUM,
            JavaClassificationTypes.ANNOTATION_USAGE)),

    /**
     * バージョン
     *
     * @since 0.2.0
     */
    VERSION("バージョン", "@version", "クラスやインタフェースのバージョンを示す",
        Arrays.asList(JavaClassificationTypes.CLASS, JavaClassificationTypes.INTERFACE, JavaClassificationTypes.ENUM,
            JavaClassificationTypes.ANNOTATION_USAGE)),

    /**
     * 参照
     *
     * @since 0.2.0
     */
    SEE("参照", "@see", "関連する他のクラス、メソッド、フィールドへの参照を示す",
        Arrays.asList(JavaClassificationTypes.CLASS, JavaClassificationTypes.INTERFACE, JavaClassificationTypes.ENUM,
            JavaClassificationTypes.ANNOTATION_USAGE, JavaClassificationTypes.METHOD, JavaClassificationTypes.FIELD,
            JavaClassificationTypes.CONSTRUCTOR)),

    /**
     * シンス（導入バージョン）
     *
     * @since 0.2.0
     */
    SINCE("シンス", "@since", "機能が導入されたバージョンを示す",
        Arrays.asList(JavaClassificationTypes.CLASS, JavaClassificationTypes.INTERFACE, JavaClassificationTypes.ENUM,
            JavaClassificationTypes.ENUM_CONST, JavaClassificationTypes.ANNOTATION_USAGE,
            JavaClassificationTypes.METHOD, JavaClassificationTypes.FIELD, JavaClassificationTypes.CONSTRUCTOR)),

    /**
     * 非推奨
     *
     * @since 0.2.0
     */
    DEPRECATED("非推奨", "@deprecated", "非推奨の機能であることを示す",
        Arrays.asList(JavaClassificationTypes.CLASS, JavaClassificationTypes.INTERFACE, JavaClassificationTypes.ENUM,
            JavaClassificationTypes.ANNOTATION_USAGE, JavaClassificationTypes.METHOD, JavaClassificationTypes.FIELD,
            JavaClassificationTypes.CONSTRUCTOR)),

    /**
     * パラメータ
     *
     * @since 0.2.0
     */
    PARAM("パラメータ", "@param", "メソッドや構築子のパラメータについて説明する",
        Arrays.asList(JavaClassificationTypes.METHOD, JavaClassificationTypes.CONSTRUCTOR)),

    /**
     * 戻り値
     *
     * @since 0.2.0
     */
    RETURN("戻り値", "@return", "メソッドの戻り値について説明する", Arrays.asList(JavaClassificationTypes.METHOD)),

    /**
     * 例外
     *
     * @since 0.2.0
     */
    THROWS("例外", "@throws", "メソッドが発生させる可能性のある例外について説明する",
        Arrays.asList(JavaClassificationTypes.METHOD, JavaClassificationTypes.CONSTRUCTOR)),

    /**
     * 例外（別名）
     *
     * @since 0.2.0
     */
    EXCEPTION("例外（別名）", "@exception", "@throwsと同じ",
        Arrays.asList(JavaClassificationTypes.METHOD, JavaClassificationTypes.CONSTRUCTOR)),

    /**
     * シリアルデータ
     *
     * @since 0.2.0
     */
    SERIAL_DATA("シリアルデータ", "@serialData", "ObjectStreamMethodの書き込みメソッドによって書き込まれるデータを説明する",
        Arrays.asList(JavaClassificationTypes.METHOD)),

    /**
     * シリアルフィールド
     *
     * @since 0.2.0
     */
    SERIAL_FIELD("シリアルフィールド", "@serialField", "ObjectStreamFieldコンポーネントを文書化する",
        Arrays.asList(JavaClassificationTypes.FIELD)),

    /**
     * 直列化可能
     *
     * @since 0.2.0
     */
    SERIAL("直列化可能", "@serial", "直列化可能なクラスの非transientインスタンス変数を文書化する", Arrays.asList(JavaClassificationTypes.FIELD)),

    /**
     * 継承Doc
     *
     * @since 0.2.0
     */
    INHERIT_DOC("継承Doc", "{@inheritDoc}", "スーパークラスからドキュメントコメントを継承する", Arrays.asList(JavaClassificationTypes.METHOD)),

    /**
     * コード
     *
     * @since 0.2.0
     */
    CODE("コード", "{@code}", "コードサンプルを示す", Arrays.asList(JavaClassificationTypes.NONE)),

    /**
     * リンク
     *
     * @since 0.2.0
     */
    LINK("リンク", "{@link}", "他のクラスやメソッドへのリンクを作成する", Arrays.asList(JavaClassificationTypes.NONE)),

    /**
     * リンクプレーン
     *
     * @since 0.2.0
     */
    LINK_PLAIN("リンクプレーン", "{@linkplain}", "プレーンテキストフォントでリンクを表示する", Arrays.asList(JavaClassificationTypes.NONE)),

    /**
     * リテラル
     *
     * @since 0.2.0
     */
    LITERAL("リテラル", "{@literal}", "特殊文字やHTMLマークアップを無視して表示する", Arrays.asList(JavaClassificationTypes.NONE)),

    /**
     * 値
     *
     * @since 0.2.0
     */
    VALUE("値", "{@value}", "静的フィールドの値を表示する", Arrays.asList(JavaClassificationTypes.NONE)),

    /**
     * ドキトート
     *
     * @since 0.2.0
     */
    DOC_ROOT("ドキトート", "{@docRoot}", "ドキュメントルートへの相対パスを生成する", Arrays.asList(JavaClassificationTypes.NONE)),

    /**
     * 隠し
     *
     * @since 0.2.0
     */
    HIDDEN("隠し", "@hidden", "ドキュメント生成から要素を除外する",
        Arrays.asList(JavaClassificationTypes.CLASS, JavaClassificationTypes.INTERFACE, JavaClassificationTypes.ENUM,
            JavaClassificationTypes.ANNOTATION_USAGE, JavaClassificationTypes.METHOD, JavaClassificationTypes.FIELD,
            JavaClassificationTypes.CONSTRUCTOR)),

    /**
     * 要約
     *
     * @since 0.2.0
     */
    SUMMARY("要約", "@summary", "要約説明を提供する", Arrays.asList(JavaClassificationTypes.NONE)),

    /**
     * インデックス
     *
     * @since 0.2.0
     */
    INDEX("インデックス", "{@index}", "検索インデックスに項目を追加する", Arrays.asList(JavaClassificationTypes.NONE)),

    /**
     * 内部API
     *
     * @since 0.2.0
     */
    API_NOTE("内部API", "@apiNote", "APIに関する注意事項を記述する",
        Arrays.asList(JavaClassificationTypes.CLASS, JavaClassificationTypes.INTERFACE, JavaClassificationTypes.ENUM,
            JavaClassificationTypes.ANNOTATION_USAGE, JavaClassificationTypes.METHOD, JavaClassificationTypes.FIELD,
            JavaClassificationTypes.CONSTRUCTOR)),

    /**
     * 実装詳細
     *
     * @since 0.2.0
     */
    IMPL_SPEC("実装詳細", "@implSpec", "実装に関する仕様を記述する",
        Arrays.asList(JavaClassificationTypes.CLASS, JavaClassificationTypes.INTERFACE, JavaClassificationTypes.ENUM,
            JavaClassificationTypes.ANNOTATION_USAGE, JavaClassificationTypes.METHOD)),

    /**
     * 実装ノート
     *
     * @since 0.2.0
     */
    IMPL_NOTE("実装ノート", "@implNote", "実装に関する注意事項を記述する",
        Arrays.asList(JavaClassificationTypes.CLASS, JavaClassificationTypes.INTERFACE, JavaClassificationTypes.ENUM,
            JavaClassificationTypes.ANNOTATION_USAGE, JavaClassificationTypes.METHOD)),

    /**
     * システムプロパティ
     *
     * @since 0.2.0
     */
    SYSTEM_PROPERTY("システムプロパティ", "{@systemProperty}", "Javaシステムプロパティを参照する",
        Arrays.asList(JavaClassificationTypes.NONE)),

    /**
     * スニペット
     *
     * @since 0.2.0
     */
    SNIPPET("スニペット", "{@snippet}", "コードスニペットを挿入する", Arrays.asList(JavaClassificationTypes.NONE)),

    /**
     * 許可された宣言的アクセス
     *
     * @since 0.2.0
     */
    PROVIDES("許可された宣言的アクセス", "@provides", "モジュールが提供するサービスを示す", Arrays.asList(JavaClassificationTypes.MODULE)),

    /**
     * 使用サービス
     *
     * @since 0.2.0
     */
    USES("使用サービス", "@uses", "モジュールが使用するサービスを示す", Arrays.asList(JavaClassificationTypes.MODULE)),

    /* 定義：終了 */
    ;

    /**
     * 種類のマップ
     *
     * @since 0.2.0
     */
    private static final Map<String, KmgJavadocTagTypes> VALUES_MAP = new HashMap<>();

    /**
     * Javadocタグのプレフィックス
     *
     * @since 0.2.0
     */
    private static final String JAVADOC_TAG_PREFIX = "@";

    static {

        /* 種類のマップにプット */
        for (final KmgJavadocTagTypes type : KmgJavadocTagTypes.values()) {

            KmgJavadocTagTypes.VALUES_MAP.put(type.get(), type);

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
     * 設定可能な場所のリスト
     *
     * @since 0.2.0
     */
    private final List<JavaClassificationTypes> locations;

    /**
     * 指定されたキーに基づいて検索用のキーを生成します。<br>
     *
     * @since 0.2.0
     *
     * @param key
     *            検索対象のキー
     *
     * @return 検索用のキー。キーが「@」で始まる場合はそのまま返します。
     */
    public static String createSearchKey(final String key) {

        String result;

        if (key.startsWith(KmgJavadocTagTypes.JAVADOC_TAG_PREFIX)) {

            result = key;
            return result;

        }

        result = KmgString.concat(KmgJavadocTagTypes.JAVADOC_TAG_PREFIX, key);

        return result;

    }

    /**
     * デフォルトの種類を返す<br>
     *
     * @since 0.2.0
     *
     * @return デフォルト値
     */
    public static KmgJavadocTagTypes getDefault() {

        final KmgJavadocTagTypes result = NONE;
        return result;

    }

    /**
     * キーに該当する種類を返す<br>
     * <p>
     * 但し、キーが存在しない場合は、指定無し（NONE）を返す。<br>
     * キーが「@」始まりではない場合は、「@」を付加して検索します。
     * </p>
     *
     * @since 0.2.0
     *
     * @param key
     *            キー
     *
     * @return 種類。指定無し（NONE）：キーが存在しない場合。
     */
    public static KmgJavadocTagTypes getEnum(final String key) {

        KmgJavadocTagTypes result = NONE;

        final String searchKey = KmgJavadocTagTypes.createSearchKey(key);
        result = KmgJavadocTagTypes.VALUES_MAP.get(searchKey);

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
    public static KmgJavadocTagTypes getInitValue() {

        final KmgJavadocTagTypes result = NONE;
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
     * @param locations
     *                    設定可能な場所のリスト。リストが空：指定可能な場所無し。リストにNONEあり：全ての場所で指定可能。
     */
    KmgJavadocTagTypes(final String displayName, final String key, final String detail,
        final List<JavaClassificationTypes> locations) {

        this.displayName = displayName;
        this.key = key;
        this.detail = detail;
        this.locations = locations;

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
     * 設定可能な場所のリストを返す。<br>
     *
     * @since 0.2.0
     *
     * @return 設定可能な場所のリスト
     */
    public List<JavaClassificationTypes> getLocations() {

        final List<JavaClassificationTypes> result = this.locations;
        return result;

    }

    /**
     * バージョン値かどうかを返す。<br>
     *
     * @since 0.2.0
     *
     * @return バージョン値かどうか。true：バージョン値、false：バージョン値以外。
     */
    public boolean isVersionValue() {

        boolean result = false;

        /* バージョン値かどうかの判定 */
        switch (this) {

            case VERSION:
                /* バージョン */
            case SINCE:
                /* シンス（導入バージョン） */
                result = true;
                break;

            case NONE:
                /* 指定無し */
            case AUTHOR:
                /* 著者 */
            case SEE:
                /* 参照 */
            case DEPRECATED:
                /* 非推奨 */
            case PARAM:
                /* パラメータ */
            case RETURN:
                /* 戻り値 */
            case THROWS:
                /* 例外 */
            case EXCEPTION:
                /* 例外（別名） */
            case SERIAL_DATA:
                /* シリアルデータ */
            case SERIAL_FIELD:
                /* シリアルフィールド */
            case SERIAL:
                /* 直列化可能 */
            case INHERIT_DOC:
                /* 継承Doc */
            case CODE:
                /* コード */
            case LINK:
                /* リンク */
            case LINK_PLAIN:
                /* リンクプレーン */
            case LITERAL:
                /* リテラル */
            case VALUE:
                /* 値 */
            case DOC_ROOT:
                /* ドキトート */
            case HIDDEN:
                /* 隠し */
            case SUMMARY:
                /* 要約 */
            case INDEX:
                /* インデックス */
            case API_NOTE:
                /* 内部API */
            case IMPL_SPEC:
                /* 実装詳細 */
            case IMPL_NOTE:
                /* 実装ノート */
            case SYSTEM_PROPERTY:
                /* システムプロパティ */
            case SNIPPET:
                /* スニペット */
            case PROVIDES:
                /* 許可された宣言的アクセス */
            case USES:
                /* 使用サービス */
                break;

        }

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

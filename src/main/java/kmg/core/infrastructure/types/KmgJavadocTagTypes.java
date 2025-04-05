package kmg.core.infrastructure.types;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import kmg.core.infrastructure.common.KmgComTypes;

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
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    NONE("指定無し", "None", "指定無し", Arrays.asList(KmgJavadocLocationTypes.NONE)),

    /**
     * 著者
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    AUTHOR("著者", "@author", "クラスやインタフェースの作成者を示す",
        Arrays.asList(KmgJavadocLocationTypes.CLASS, KmgJavadocLocationTypes.INTERFACE, KmgJavadocLocationTypes.ENUM,
            KmgJavadocLocationTypes.ANNOTATION)),

    /**
     * バージョン
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    VERSION("バージョン", "@version", "クラスやインタフェースのバージョンを示す",
        Arrays.asList(KmgJavadocLocationTypes.CLASS, KmgJavadocLocationTypes.INTERFACE, KmgJavadocLocationTypes.ENUM,
            KmgJavadocLocationTypes.ANNOTATION)),

    /**
     * 参照
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    SEE("参照", "@see", "関連する他のクラス、メソッド、フィールドへの参照を示す",
        Arrays.asList(KmgJavadocLocationTypes.CLASS, KmgJavadocLocationTypes.INTERFACE, KmgJavadocLocationTypes.ENUM,
            KmgJavadocLocationTypes.ANNOTATION, KmgJavadocLocationTypes.METHOD, KmgJavadocLocationTypes.FIELD,
            KmgJavadocLocationTypes.CONSTRUCTOR)),

    /**
     * シンス（導入バージョン）
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    SINCE("シンス", "@since", "機能が導入されたバージョンを示す",
        Arrays.asList(KmgJavadocLocationTypes.CLASS, KmgJavadocLocationTypes.INTERFACE, KmgJavadocLocationTypes.ENUM,
            KmgJavadocLocationTypes.ANNOTATION, KmgJavadocLocationTypes.METHOD, KmgJavadocLocationTypes.FIELD,
            KmgJavadocLocationTypes.CONSTRUCTOR)),

    /**
     * 非推奨
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    DEPRECATED("非推奨", "@deprecated", "非推奨の機能であることを示す",
        Arrays.asList(KmgJavadocLocationTypes.CLASS, KmgJavadocLocationTypes.INTERFACE, KmgJavadocLocationTypes.ENUM,
            KmgJavadocLocationTypes.ANNOTATION, KmgJavadocLocationTypes.METHOD, KmgJavadocLocationTypes.FIELD,
            KmgJavadocLocationTypes.CONSTRUCTOR)),

    /**
     * パラメータ
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    PARAM("パラメータ", "@param", "メソッドや構築子のパラメータについて説明する",
        Arrays.asList(KmgJavadocLocationTypes.METHOD, KmgJavadocLocationTypes.CONSTRUCTOR)),

    /**
     * 戻り値
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    RETURN("戻り値", "@return", "メソッドの戻り値について説明する", Arrays.asList(KmgJavadocLocationTypes.METHOD)),

    /**
     * 例外
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    THROWS("例外", "@throws", "メソッドが発生させる可能性のある例外について説明する",
        Arrays.asList(KmgJavadocLocationTypes.METHOD, KmgJavadocLocationTypes.CONSTRUCTOR)),

    /**
     * 例外（別名）
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    EXCEPTION("例外（別名）", "@exception", "@throwsと同じ",
        Arrays.asList(KmgJavadocLocationTypes.METHOD, KmgJavadocLocationTypes.CONSTRUCTOR)),

    /**
     * シリアルデータ
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    SERIAL_DATA("シリアルデータ", "@serialData", "ObjectStreamMethodの書き込みメソッドによって書き込まれるデータを説明する",
        Arrays.asList(KmgJavadocLocationTypes.METHOD)),

    /**
     * シリアルフィールド
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    SERIAL_FIELD("シリアルフィールド", "@serialField", "ObjectStreamFieldコンポーネントを文書化する",
        Arrays.asList(KmgJavadocLocationTypes.FIELD)),

    /**
     * 直列化可能
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    SERIAL("直列化可能", "@serial", "直列化可能なクラスの非transientインスタンス変数を文書化する", Arrays.asList(KmgJavadocLocationTypes.FIELD)),

    /**
     * 継承Doc
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    INHERIT_DOC("継承Doc", "{@inheritDoc}", "スーパークラスからドキュメントコメントを継承する", Arrays.asList(KmgJavadocLocationTypes.METHOD)),

    /**
     * コード
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    CODE("コード", "{@code}", "コードサンプルを示す", Arrays.asList(KmgJavadocLocationTypes.ALL)),

    /**
     * リンク
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    LINK("リンク", "{@link}", "他のクラスやメソッドへのリンクを作成する", Arrays.asList(KmgJavadocLocationTypes.ALL)),

    /**
     * リンクプレーン
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    LINK_PLAIN("リンクプレーン", "{@linkplain}", "プレーンテキストフォントでリンクを表示する", Arrays.asList(KmgJavadocLocationTypes.ALL)),

    /**
     * リテラル
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    LITERAL("リテラル", "{@literal}", "特殊文字やHTMLマークアップを無視して表示する", Arrays.asList(KmgJavadocLocationTypes.ALL)),

    /**
     * 値
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    VALUE("値", "{@value}", "静的フィールドの値を表示する", Arrays.asList(KmgJavadocLocationTypes.ALL)),

    /**
     * ドキトート
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    DOC_ROOT("ドキトート", "{@docRoot}", "ドキュメントルートへの相対パスを生成する", Arrays.asList(KmgJavadocLocationTypes.ALL)),

    /**
     * 隠し
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    HIDDEN("隠し", "@hidden", "ドキュメント生成から要素を除外する",
        Arrays.asList(KmgJavadocLocationTypes.CLASS, KmgJavadocLocationTypes.INTERFACE, KmgJavadocLocationTypes.ENUM,
            KmgJavadocLocationTypes.ANNOTATION, KmgJavadocLocationTypes.METHOD, KmgJavadocLocationTypes.FIELD,
            KmgJavadocLocationTypes.CONSTRUCTOR)),

    /**
     * 要約
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    SUMMARY("要約", "@summary", "要約説明を提供する", Arrays.asList(KmgJavadocLocationTypes.ALL)),

    /**
     * インデックス
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    INDEX("インデックス", "{@index}", "検索インデックスに項目を追加する", Arrays.asList(KmgJavadocLocationTypes.ALL)),

    /**
     * 内部API
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    API_NOTE("内部API", "@apiNote", "APIに関する注意事項を記述する",
        Arrays.asList(KmgJavadocLocationTypes.CLASS, KmgJavadocLocationTypes.INTERFACE, KmgJavadocLocationTypes.ENUM,
            KmgJavadocLocationTypes.ANNOTATION, KmgJavadocLocationTypes.METHOD, KmgJavadocLocationTypes.FIELD,
            KmgJavadocLocationTypes.CONSTRUCTOR)),

    /**
     * 実装詳細
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    IMPL_SPEC("実装詳細", "@implSpec", "実装に関する仕様を記述する",
        Arrays.asList(KmgJavadocLocationTypes.CLASS, KmgJavadocLocationTypes.INTERFACE, KmgJavadocLocationTypes.ENUM,
            KmgJavadocLocationTypes.ANNOTATION, KmgJavadocLocationTypes.METHOD)),

    /**
     * 実装ノート
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    IMPL_NOTE("実装ノート", "@implNote", "実装に関する注意事項を記述する",
        Arrays.asList(KmgJavadocLocationTypes.CLASS, KmgJavadocLocationTypes.INTERFACE, KmgJavadocLocationTypes.ENUM,
            KmgJavadocLocationTypes.ANNOTATION, KmgJavadocLocationTypes.METHOD)),

    /**
     * システムプロパティ
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    SYSTEM_PROPERTY("システムプロパティ", "{@systemProperty}", "Javaシステムプロパティを参照する", Arrays.asList(KmgJavadocLocationTypes.ALL)),

    /**
     * スニペット
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    SNIPPET("スニペット", "{@snippet}", "コードスニペットを挿入する", Arrays.asList(KmgJavadocLocationTypes.ALL)),

    /**
     * 許可された宣言的アクセス
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    PROVIDES("許可された宣言的アクセス", "@provides", "モジュールが提供するサービスを示す", Arrays.asList(KmgJavadocLocationTypes.MODULE)),

    /**
     * 使用サービス
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    USES("使用サービス", "@uses", "モジュールが使用するサービスを示す", Arrays.asList(KmgJavadocLocationTypes.MODULE)),

    /* 定義：終了 */
    ;

    /**
     * Javadocタグを抽出する正規表現パターン
     *
     * @since 0.2.0
     */
    private static final String TAG_PATTERN = "\\s+\\*\\s+(@\\w+)\\s+([^\\s\\n]+)(?:\\s+([^@\\n]+))?";

    /**
     * コンパイル済みのJavadocタグパターン
     *
     * @since 0.2.0
     */
    private static final Pattern COMPILED_TAG_PATTERN = Pattern.compile(KmgJavadocTagTypes.TAG_PATTERN);

    /** 種類のマップ */
    private static final Map<String, KmgJavadocTagTypes> VALUES_MAP = new HashMap<>();

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
    private final List<KmgJavadocLocationTypes> locations;

    /**
     * コンパイル済みのJavadocタグパターンを返す<br>
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     *
     * @return コンパイル済みのJavadocタグパターン
     */
    public static Pattern getCompiledTagPattern() {

        final Pattern result = KmgJavadocTagTypes.COMPILED_TAG_PATTERN;
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
    public static KmgJavadocTagTypes getEnum(final String key) {

        KmgJavadocTagTypes result = KmgJavadocTagTypes.VALUES_MAP.get(key);

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
     * Javadocタグを抽出する正規表現パターンを返す<br>
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     *
     * @return Javadocタグを抽出する正規表現パターン
     */
    public static String getTagPattern() {

        final String result = KmgJavadocTagTypes.TAG_PATTERN;
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
     *                    設定可能な場所のリスト
     */
    KmgJavadocTagTypes(final String displayName, final String key, final String detail,
        final List<KmgJavadocLocationTypes> locations) {

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
    public List<KmgJavadocLocationTypes> getLocations() {

        final List<KmgJavadocLocationTypes> result = this.locations;
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

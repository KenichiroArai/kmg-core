package kmg.core.infrastructure.types;

import java.util.HashMap;
import java.util.Map;

import kmg.core.infrastructure.common.KmgComTypes;

/**
 * KMGJavaキーワードの種類<br>
 *
 * @author KenichiroArai
 *
 * @since 0.2.0
 *
 * @version 0.2.0
 */
@SuppressWarnings("nls")
public enum KmgJavaKeywordTypes implements KmgComTypes<String> {

    /* 定義：開始 */

    /**
     * 指定無し
     *
     * @since 0.2.0
     */
    NONE("指定無し", "None", "指定無し"),

    /**
     * abstract
     *
     * @since 0.2.0
     */
    ABSTRACT("abstract", "abstract", "クラス、メソッドを抽象として定義"),

    /**
     * assert
     *
     * @since 0.2.0
     */
    ASSERT("assert", "assert", "アサーション（条件確認）を行う"),

    /**
     * boolean
     *
     * @since 0.2.0
     */
    BOOLEAN("boolean", "boolean", "真偽値（true/false）の型"),

    /**
     * break
     *
     * @since 0.2.0
     */
    BREAK("break", "break", "ループやswitch文から抜ける"),

    /**
     * byte
     *
     * @since 0.2.0
     */
    BYTE("byte", "byte", "8ビット整数型"),

    /**
     * case
     *
     * @since 0.2.0
     */
    CASE("case", "case", "switch文の条件分岐"),

    /**
     * catch
     *
     * @since 0.2.0
     */
    CATCH("catch", "catch", "例外を捕捉する"),

    /**
     * char
     *
     * @since 0.2.0
     */
    CHAR("char", "char", "文字型"),

    /**
     * class
     *
     * @since 0.2.0
     */
    CLASS("class", "class", "クラスを定義する"),

    /**
     * const
     *
     * @since 0.2.0
     */
    CONST("const", "const", "予約語（使用されない）"),

    /**
     * continue
     *
     * @since 0.2.0
     */
    CONTINUE("continue", "continue", "ループの次の繰り返しに進む"),

    /**
     * default
     *
     * @since 0.2.0
     */
    DEFAULT("default", "default", "switch文のデフォルト処理、インターフェースのデフォルトメソッド"),

    /**
     * do
     *
     * @since 0.2.0
     */
    DO("do", "do", "do-whileループの開始"),

    /**
     * double
     *
     * @since 0.2.0
     */
    DOUBLE("double", "double", "倍精度浮動小数点型"),

    /**
     * else
     *
     * @since 0.2.0
     */
    ELSE("else", "else", "条件分岐の代替処理"),

    /**
     * enum
     *
     * @since 0.2.0
     */
    ENUM("enum", "enum", "列挙型を定義"),

    /**
     * exports
     *
     * @since 0.2.0
     */
    EXPORTS("exports", "exports", "モジュールシステムで使用"),

    /**
     * extends
     *
     * @since 0.2.0
     */
    EXTENDS("extends", "extends", "クラスの継承を定義"),

    /**
     * final
     *
     * @since 0.2.0
     */
    FINAL("final", "final", "変更不可能な宣言"),

    /**
     * finally
     *
     * @since 0.2.0
     */
    FINALLY("finally", "finally", "例外処理の最終ブロック"),

    /**
     * float
     *
     * @since 0.2.0
     */
    FLOAT("float", "float", "単精度浮動小数点型"),

    /**
     * for
     *
     * @since 0.2.0
     */
    FOR("for", "for", "ループ構文"),

    /**
     * goto
     *
     * @since 0.2.0
     */
    GOTO("goto", "goto", "予約語（使用されない）"),

    /**
     * if
     *
     * @since 0.2.0
     */
    IF("if", "if", "条件分岐"),

    /**
     * implements
     *
     * @since 0.2.0
     */
    IMPLEMENTS("implements", "implements", "インターフェースの実装を宣言"),

    /**
     * import
     *
     * @since 0.2.0
     */
    IMPORT("import", "import", "パッケージからクラスをインポート"),

    /**
     * instanceof
     *
     * @since 0.2.0
     */
    INSTANCEOF("instanceof", "instanceof", "オブジェクトの型をチェック"),

    /**
     * int
     *
     * @since 0.2.0
     */
    INT("int", "int", "整数型"),

    /**
     * interface
     *
     * @since 0.2.0
     */
    INTERFACE("interface", "interface", "インターフェースを定義"),

    /**
     * long
     *
     * @since 0.2.0
     */
    LONG("long", "long", "長整数型"),

    /**
     * module
     *
     * @since 0.2.0
     */
    MODULE("module", "module", "モジュールを定義"),

    /**
     * native
     *
     * @since 0.2.0
     */
    NATIVE("native", "native", "ネイティブコードで実装されたメソッド"),

    /**
     * new
     *
     * @since 0.2.0
     */
    NEW("new", "new", "オブジェクトの生成"),

    /**
     * non-sealed
     *
     * @since 0.2.0
     */
    NON_SEALED("non-sealed", "non-sealed", "シールドクラスの継承を許可"),

    /**
     * open
     *
     * @since 0.2.0
     */
    OPEN("open", "open", "モジュールシステムで使用"),

    /**
     * opens
     *
     * @since 0.2.0
     */
    OPENS("opens", "opens", "モジュールシステムで使用"),

    /**
     * package
     *
     * @since 0.2.0
     */
    PACKAGE("package", "package", "パッケージを宣言"),

    /**
     * permits
     *
     * @since 0.2.0
     */
    PERMITS("permits", "permits", "シールドクラスで許可するサブクラスを指定"),

    /**
     * private
     *
     * @since 0.2.0
     */
    PRIVATE("private", "private", "クラス内からのみアクセス可能なアクセス修飾子"),

    /**
     * protected
     *
     * @since 0.2.0
     */
    PROTECTED("protected", "protected", "サブクラスおよび同一パッケージからアクセス可能なアクセス修飾子"),

    /**
     * provides
     *
     * @since 0.2.0
     */
    PROVIDES("provides", "provides", "モジュールシステムで使用"),

    /**
     * public
     *
     * @since 0.2.0
     */
    PUBLIC("public", "public", "全てのクラスからアクセス可能なアクセス修飾子"),

    /**
     * record
     *
     * @since 0.2.0
     */
    RECORD("record", "record", "イミュータブルなデータクラスを定義"),

    /**
     * requires
     *
     * @since 0.2.0
     */
    REQUIRES("requires", "requires", "モジュールシステムで使用"),

    /**
     * return
     *
     * @since 0.2.0
     */
    RETURN("return", "return", "メソッドから値を返す"),

    /**
     * sealed
     *
     * @since 0.2.0
     */
    SEALED("sealed", "sealed", "継承できるクラスを制限"),

    /**
     * short
     *
     * @since 0.2.0
     */
    SHORT("short", "short", "16ビット整数型"),

    /**
     * static
     *
     * @since 0.2.0
     */
    STATIC("static", "static", "クラスレベルのメンバーを定義"),

    /**
     * strictfp
     *
     * @since 0.2.0
     */
    STRICTFP("strictfp", "strictfp", "浮動小数点計算の厳密な振る舞いを指定"),

    /**
     * super
     *
     * @since 0.2.0
     */
    SUPER("super", "super", "親クラスを参照"),

    /**
     * switch
     *
     * @since 0.2.0
     */
    SWITCH("switch", "switch", "複数の条件分岐を定義"),

    /**
     * synchronized
     *
     * @since 0.2.0
     */
    SYNCHRONIZED("synchronized", "synchronized", "スレッド間の同期を制御"),

    /**
     * this
     *
     * @since 0.2.0
     */
    THIS("this", "this", "現在のオブジェクトを参照"),

    /**
     * throw
     *
     * @since 0.2.0
     */
    THROW("throw", "throw", "例外をスロー"),

    /**
     * throws
     *
     * @since 0.2.0
     */
    THROWS("throws", "throws", "メソッドが発生させる可能性のある例外を宣言"),

    /**
     * to
     *
     * @since 0.2.0
     */
    TO("to", "to", "モジュールシステムで使用"),

    /**
     * transient
     *
     * @since 0.2.0
     */
    TRANSIENT("transient", "transient", "シリアライズ対象外のフィールドを指定"),

    /**
     * transitive
     *
     * @since 0.2.0
     */
    TRANSITIVE("transitive", "transitive", "モジュールシステムで使用"),

    /**
     * try
     *
     * @since 0.2.0
     */
    TRY("try", "try", "例外処理のブロックを定義"),

    /**
     * uses
     *
     * @since 0.2.0
     */
    USES("uses", "uses", "モジュールシステムで使用"),

    /**
     * var
     *
     * @since 0.2.0
     */
    VAR("var", "var", "ローカル変数の型推論"),

    /**
     * void
     *
     * @since 0.2.0
     */
    VOID("void", "void", "戻り値がないことを示す"),

    /**
     * volatile
     *
     * @since 0.2.0
     */
    VOLATILE("volatile", "volatile", "マルチスレッドで使用される変数を定義"),

    /**
     * when
     *
     * @since 0.2.0
     */
    WHEN("when", "when", "将来の機能のために予約されたキーワード"),

    /**
     * while
     *
     * @since 0.2.0
     */
    WHILE("while", "while", "条件ループを定義"),

    /**
     * yield
     *
     * @since 0.2.0
     */
    YIELD("yield", "yield", "switch式の結果を返す"),

    /* 定義：終了 */
    ;

    /**
     * 種類のマップ
     *
     * @since 0.2.0
     */
    private static final Map<String, KmgJavaKeywordTypes> VALUES_MAP = new HashMap<>();

    static {

        /* 種類のマップにプット */
        for (final KmgJavaKeywordTypes type : KmgJavaKeywordTypes.values()) {

            KmgJavaKeywordTypes.VALUES_MAP.put(type.get(), type);

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
     * デフォルトの種類を返す<br>
     *
     * @since 0.2.0
     *
     * @return デフォルト値
     */
    public static KmgJavaKeywordTypes getDefault() {

        final KmgJavaKeywordTypes result = NONE;
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
    public static KmgJavaKeywordTypes getEnum(final String key) {

        KmgJavaKeywordTypes result = KmgJavaKeywordTypes.VALUES_MAP.get(key);

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
    public static KmgJavaKeywordTypes getInitValue() {

        final KmgJavaKeywordTypes result = NONE;
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
     */
    KmgJavaKeywordTypes(final String displayName, final String key, final String detail) {

        this.displayName = displayName;
        this.key = key;
        this.detail = detail;

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

package kmg.core.infrastructure.type;

import kmg.core.infrastructure.types.KmgDelimiterTypes;
import kmg.core.infrastructure.utils.KmgArrayUtils;

/**
 * 文字列操作ユーティリティクラス。
 * <p>
 * このクラスは、文字列の変換、検証、操作に関するユーティリティメソッドを提供します。
 * </p>
 * <p>
 * 主な機能は以下のとおりです。
 * </p>
 * <ul>
 * <li>キャメルケースとスネークケースの相互変換</li>
 * <li>文字列が空であるかのチェック</li>
 * <li>文字列の結合と置換</li>
 * </ul>
 * <p>
 * 使用例：
 * </p>
 *
 * <pre>
 *
 * // キャメルケースに変換
 * String camel = KmgString.camelCase("test_string"); // "testString"
 *
 * // 文字列が空であるかチェック
 * boolean isEmpty = KmgString.isEmpty(""); // true
 * </pre>
 *
 * @author KenichiroArai
 *
 * @since 0.1.0
 *
 * @version 0.1.0
 */
public class KmgString {

    /**
     * 空文字列
     *
     * @since 0.1.0
     */
    public static final String EMPTY = ""; //$NON-NLS-1$

    /**
     * 半角スペース
     *
     * @since 0.1.0
     */
    public static final String HALF_SPACE = " "; //$NON-NLS-1$

    /**
     * 全角スペース
     *
     * @since 0.1.0
     */
    public static final String ALL_SPACE = "　"; //$NON-NLS-1$

    /**
     * 改行
     *
     * @since 0.1.0
     */
    public static final String LINE_SEPARATOR = System.lineSeparator();

    /**
     * 値
     *
     * @since 0.1.0
     */
    private String value;

    /**
     * スネークケースの文字列をキャメルケースに変換します。
     * <p>
     * 変換ルール：
     * </p>
     * <ul>
     * <li>アンダースコア(_)で区切られた各部分の先頭を大文字にします。</li>
     * <li>最初の単語は小文字のままにします。</li>
     * <li>例："test_string" → "testString"</li>
     * </ul>
     *
     * @param target
     *               変換対象の文字列。nullまたは空文字の場合はnullを返します。
     *
     * @return 変換後のキャメルケース文字列。変換できない場合はnullを返します。
     *
     * @throws IllegalArgumentException
     *                                  無効な文字列形式が指定された場合
     *
     * @since 0.1.0
     *
     * @see #snakeCase(String)
     */
    public static String camelCase(final String target) {

        String result = null;

        /* 事前チェック */
        // 値が空か
        if (KmgString.isEmpty(target)) {
            // 空の場合

            return result;

        }

        /* 事前処理 */
        // ローケースに変換
        final String lowerCase = target.toLowerCase();

        // 単語の配列を取得
        final String[] words = KmgDelimiterTypes.UNDERSCORE.split(lowerCase);

        // 一つ目の単語
        final String firstWord = KmgString.capitalize(words[0]);

        /* 一つの単語の処理 */
        // 単語が一つだけか
        if (words.length == 1) {
            // 一つだけの場合

            result = firstWord.substring(0, 1).toLowerCase().concat(firstWord.substring(1));
            return result;

        }

        /* キャメルケースの文字列を作成 */
        final StringBuilder camelCaseSb = new StringBuilder();

        // 一つ目の単語
        camelCaseSb.append(firstWord);

        // 単語の数分、キャメライズする
        for (int i = 1; i < words.length; i++) {

            camelCaseSb.append(KmgString.capitalize(words[i]));

        }
        result = camelCaseSb.substring(0, 1).toLowerCase().concat(camelCaseSb.substring(1));

        return result;

    }

    /**
     * 文字列の最初の文字を大文字に変換します。
     *
     * @param target
     *               対象文字列
     *
     * @return 最初の文字が大文字に変換された文字列
     *
     * @since 0.1.0
     */
    public static String capitalize(final String target) {

        String result = null;

        /* 事前チェック */
        // 対象が空か
        if (KmgString.isEmpty(target)) {
            // 空の場合

            result = target;
            return result;

        }

        /* 先頭の文字だけ大文字にする */
        final char[] chars = target.toCharArray();
        chars[0] = Character.toUpperCase(chars[0]);

        /* 文字列にして返す */
        result = new String(chars);
        return result;

    }

    /**
     * 複数の文字列を結合して1つの文字列にします。
     *
     * @param target
     *               結合する文字列の配列
     *
     * @return 結合された文字列
     *
     * @since 0.1.0
     */
    public static String concat(final String... target) {

        String result = null;

        if (KmgArrayUtils.isEmpty(target)) {

            result = KmgString.EMPTY;
            return result;

        }

        final StringBuilder concatSb = new StringBuilder();

        for (final String str : target) {

            concatSb.append(str);

        }

        result = concatSb.toString();

        return result;

    }

    /**
     * 2つの文字列が等しいかどうかを比較します。
     *
     * @param str1
     *             最初の文字列
     * @param str2
     *             2番目の文字列
     *
     * @return 文字列が等しい場合はtrue、そうでない場合はfalse
     *
     * @since 0.1.0
     */
    public static boolean equals(final String str1, final String str2) {

        boolean result = false;

        if (str1 == null) {

            return result;

        }

        if (str2 == null) {

            return result;

        }

        result = str1.equals(str2);

        return result;

    }

    /**
     * 2つの文字列が、大文字と小文字を区別せずに等しいかどうかを比較します。
     *
     * @param str1
     *             最初の文字列
     * @param str2
     *             2番目の文字列
     *
     * @return 文字列が等しい場合はtrue、そうでない場合はfalse
     *
     * @since 0.1.0
     */
    public static boolean equalsIgnoreCase(final String str1, final String str2) {

        boolean result = false;

        if (str1 == null) {

            return result;

        }

        if (str2 == null) {

            return result;

        }

        result = str1.equalsIgnoreCase(str2);

        return result;

    }

    /**
     * 文字列がnull、空文字、または空白文字のみで構成されているかどうかを確認します。
     *
     * @param target
     *               確認する文字列
     *
     * @return 文字列がnull、空文字、または空白文字のみの場合はtrue、そうでない場合はfalse
     *
     * @since 0.2.0
     */
    public static boolean isBlank(final String target) {

        boolean result = true;

        /* 事前チェック */
        // 値が空か
        if (KmgString.isEmpty(target)) {
            // 空の場合

            return result;

        }

        /* 空白文字のチェック */
        for (int i = 0; i < target.length(); i++) {

            // 空白文字以外が含まれているか
            if (!Character.isWhitespace(target.charAt(i))) {
                // 空白文字以外が含まれている場合

                result = false;
                return result;

            }

        }

        return result;

    }

    /**
     * 文字列がnullまたは空であるかどうかを確認します。
     *
     * @param target
     *               確認する文字列
     *
     * @return 文字列がnullまたは空の場合はtrue、そうでない場合はfalse
     *
     * @since 0.1.0
     *
     * @see #isNotEmpty(String)
     */
    public static boolean isEmpty(final String target) {

        final KmgString kmgString = new KmgString(target);
        final boolean   result    = kmgString.isEmpty();
        return result;

    }

    /**
     * 文字列がnull、空文字、または空白文字のみで構成されていないかどうかを確認します。
     *
     * @param target
     *               確認する文字列
     *
     * @return 文字列がnull、空文字、または空白文字のみでない場合はtrue、そうでない場合はfalse
     *
     * @since 0.2.0
     */
    public static boolean isNotBlank(final String target) {

        final boolean result = !KmgString.isBlank(target);
        return result;

    }

    /**
     * 文字列がnullまたは空でないかどうかを確認します。
     *
     * @param target
     *               確認する文字列
     *
     * @return 文字列がnullまたは空でない場合はtrue、そうでない場合はfalse
     *
     * @since 0.1.0
     */
    public static boolean isNotEmpty(final String target) {

        final boolean result = !KmgString.isEmpty(target);
        return result;

    }

    /**
     * キャメルケースの文字列をスネークケースに変換します。
     * <p>
     * 変換ルール：
     * </p>
     * <ul>
     * <li>大文字の前にアンダースコア(_)を挿入します。</li>
     * <li>すべての文字を小文字に変換します。</li>
     * <li>例："testString" → "test_string"</li>
     * </ul>
     *
     * @param target
     *               変換対象の文字列。nullまたは空文字の場合はnullを返します。
     *
     * @return 変換後のスネークケース文字列。変換できない場合はnullを返します。
     *
     * @throws IllegalArgumentException
     *                                  無効な文字列形式が指定された場合
     *
     * @since 0.1.0
     *
     * @see #camelCase(String)
     */
    public static String snakeCase(final String target) {

        String result = null;

        /* 事前チェック */
        // 値が空か
        if (KmgString.isEmpty(target)) {
            // 空の場合

            return result;

        }

        /* 一文字の処理 */
        // 一文字か
        if (target.length() > 0) {
            // 一文字の場合

            result = target.toLowerCase();
            return result;

        }

        /* スネークケースの文字列を作成 */
        final StringBuilder snakeCaseSb = new StringBuilder();
        int                 pos         = 0;

        for (int i = 1; i < target.length(); ++i) {

            final char currentChar = target.charAt(i);
            final char prevChar    = target.charAt(i - 1);

            /* アンダースコアを追加するかの判定 */
            final boolean shouldAddUnderscore = KmgString.shouldAddUnderscore(target, i, currentChar, prevChar);

            // アンダースコアを追加しない場合は次の反復に移る
            if (!shouldAddUnderscore) {

                continue;

            }

            /* アンダースコアの追加 */
            if (snakeCaseSb.length() != 0) {

                snakeCaseSb.append('_');

            }
            snakeCaseSb.append(target.substring(pos, i));
            pos = i;

        }

        /* 残りの部分を追加 */
        if (snakeCaseSb.length() != 0) {

            snakeCaseSb.append('_');

        }
        snakeCaseSb.append(target.substring(pos));

        result = snakeCaseSb.toString().toLowerCase();

        return result;

    }

    /**
     * 文字列内の特定の位置にアンダースコアを追加する必要があるかどうかを判断します。
     *
     * @param target
     *                     文字列
     * @param currentIndex
     *                     現在のインデックス
     * @param currentChar
     *                     現在の文字
     * @param prevChar
     *                     前の文字
     *
     * @return アンダースコアを追加する必要がある場合はtrue、そうでない場合はfalse
     *
     * @since 0.1.0
     */
    private static boolean shouldAddUnderscore(final String target, final int currentIndex, final char currentChar,
        final char prevChar) {

        boolean result = false;

        // 現在の文字が大文字でない場合は早期リターン
        if (!Character.isUpperCase(currentChar)) {

            return result;

        }

        // 条件1: 前の文字が小文字である場合
        if (Character.isLowerCase(prevChar)) {

            result = true;
            return result;

        }

        // 条件2: 次の文字が存在し、小文字である場合
        if ((currentIndex + 1) < target.length()) {

            final char nextChar = target.charAt(currentIndex + 1);

            if (Character.isLowerCase(nextChar)) {

                result = true;

            }

        }

        return result;

    }

    /**
     * コンストラクタ
     *
     * @since 0.1.0
     *
     * @param value
     *              値
     */
    public KmgString(final String value) {

        this.value = value;

    }

    /**
     * キャメルケースに変換します。
     * <p>
     * 例：aaa_bbb_ccc→aaaBbbCcc
     * </p>
     *
     * @since 0.1.0
     */
    public void fromCamelCase() {

        this.value = this.toCamelCase();

    }

    /**
     * スネークケースに変換します。
     * <p>
     * 例：aaaBbbCcc→aaa_bbb_ccc
     * </p>
     *
     * @since 0.1.0
     */
    public void fromSnakeCase() {

        this.value = this.toSnakeCase();

    }

    /**
     * 値を取得します。
     *
     * @return 値
     *
     * @since 0.1.0
     */
    public String getValue() {

        final String result = this.value;
        return result;

    }

    /**
     * 文字列がnull、空文字、または空白文字のみで構成されているかどうかを確認します。
     *
     * @return 文字列がnull、空文字、または空白文字のみの場合はtrue、そうでない場合はfalse
     *
     * @since 0.2.0
     */
    public boolean isBlank() {

        final boolean result = KmgString.isBlank(this.value);
        return result;

    }

    /**
     * 文字列が空かどうかを判定します。
     *
     * @return 文字列が空の場合はtrue、そうでない場合はfalse
     *
     * @since 0.1.0
     */
    public boolean isEmpty() {

        boolean result = true;

        if (this.value == null) {

            return result;

        }

        if (this.value.length() == 0) {

            return result;

        }

        result = false;
        return result;

    }

    /**
     * 文字列がnull、空文字、または空白文字のみで構成されていないかどうかを確認します。
     *
     * @return 文字列がnull、空文字、または空白文字のみでない場合はtrue、そうでない場合はfalse
     *
     * @since 0.2.0
     */
    public boolean isNotBlank() {

        final boolean result = !this.isBlank();
        return result;

    }

    /**
     * 文字列が空でないかどうかを判定します。
     *
     * @return 文字列が空でない場合はtrue、そうでない場合はfalse
     *
     * @since 0.1.0
     */
    public boolean isNotEmpty() {

        final boolean result = !this.isEmpty();
        return result;

    }

    /**
     * 文字列を別の文字列に置換します。
     *
     * @param target
     *                   置換対象文字列
     * @param replacemen
     *                   置換文字列
     *
     * @since 0.1.0
     */
    public void replace(final CharSequence target, final CharSequence replacemen) {

        this.value = this.value.replace(target, replacemen);

    }

    /**
     * キャメルケースの文字列を返します。
     * <p>
     * 例：aaa_bbb_ccc→aaaBbbCcc
     * </p>
     *
     * @return キャメルケースの文字列
     *
     * @since 0.1.0
     */
    public String toCamelCase() {

        final String result = KmgString.camelCase(this.value);
        return result;

    }

    /**
     * スネークケースの文字列を返します。
     * <p>
     * 例：aaaBbbCcc→aaa_bbb_ccc
     * </p>
     *
     * @return スネークケースの文字列
     *
     * @since 0.1.0
     */
    public String toSnakeCase() {

        final String result = KmgString.snakeCase(this.value);
        return result;

    }

    /**
     * 文字列表現を返します。
     *
     * @return 文字列表現
     *
     * @since 0.1.0
     */
    @Override
    public String toString() {

        final String result = this.value;
        return result;

    }

}

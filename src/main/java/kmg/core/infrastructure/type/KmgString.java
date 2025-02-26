package kmg.core.infrastructure.type;

import kmg.core.infrastructure.types.KmgDelimiterTypes;
import kmg.core.infrastructure.utils.KmgArrayUtils;

/**
 * KMG文字列ユーティリティクラス。
 * <p>
 * 文字列操作に関するユーティリティメソッドを提供します。 主な機能：
 * <ul>
 * <li>文字列の変換（キャメルケース、スネークケース）</li>
 * <li>文字列の検証（空文字チェック）</li>
 * <li>文字列の操作（結合、置換）</li>
 * </ul>
 * </p>
 * <p>
 * 使用例：
 *
 * <pre>
 *
 * // キャメルケース変換
 * String camel = KmgString.camelCase("test_string");
 *
 * // 空文字チェック
 * boolean isEmpty = KmgString.isEmpty("");
 * </pre>
 * </p>
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
     * スネークケース文字列をキャメルケースに変換します。
     * <p>
     * 変換ルール：
     * <ul>
     * <li>アンダースコア(_)で区切られた各部分の先頭を大文字にする</li>
     * <li>最初の単語は小文字のまま</li>
     * <li>例："test_string" → "testString"</li>
     * </ul>
     * </p>
     *
     * @param target
     *               変換対象の文字列。nullまたは空文字の場合はnullを返します。
     *
     * @return 変換後のキャメルケース文字列。変換できない場合はnull。
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
     * キャピタライズを返す<br>
     *
     * @since 0.1.0
     *
     * @param target
     *               対象文字列
     *
     * @return キャピタライズ
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
     * 文字列を結合して返す<br>
     *
     * @since 0.1.0
     *
     * @param target
     *               対象文字列
     *
     * @return 結合した文字列
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
     * 一致するか<br>
     * <p>
     * 文字列１と文字列２が一致するか
     * </p>
     *
     * @since 0.1.0
     *
     * @param str1
     *             文字列１
     * @param str2
     *             文字列２
     *
     * @return true：一致、false：一致しない
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
     * 大文字小文字区別しないで一致するか<br>
     *
     * @since 0.1.0
     *
     * @param str1
     *             文字列１
     * @param str2
     *             文字列２
     *
     * @return true：一致、false：一致しない
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
     * 指定された文字列が空かどうかを判定します。
     * <p>
     * 以下の場合にtrueを返します：
     * <ul>
     * <li>文字列がnull</li>
     * <li>文字列の長さが0</li>
     * </ul>
     * </p>
     *
     * @param target
     *               検査対象の文字列
     *
     * @return 文字列が空の場合はtrue、それ以外はfalse
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
     * 対象文字列が空文字ではないかどうかを返す<br>
     *
     * @since 0.1.0
     *
     * @param target
     *               対象文字列
     *
     * @return true：空文字ではない、false：空文字列
     */
    public static boolean isNotEmpty(final String target) {

        final boolean result = !KmgString.isEmpty(target);
        return result;

    }

    /**
     * キャメルケース文字列をスネークケースに変換します。
     * <p>
     * 変換ルール：
     * <ul>
     * <li>大文字の前にアンダースコア(_)を挿入</li>
     * <li>全ての文字を小文字に変換</li>
     * <li>例："testString" → "test_string"</li>
     * </ul>
     * </p>
     *
     * @param target
     *               変換対象の文字列。nullまたは空文字の場合はnullを返します。
     *
     * @return 変換後のスネークケース文字列。変換できない場合はnull。
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
        if (target.length() == 1) {
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
     * アンダースコアを追加するかどうかを判定する<br>
     * <p>
     * 現在の文字が大文字でない場合は早期リターン
     * </p>
     *
     * @since 0.1.0
     *
     * @param target
     *                     対象文字列
     * @param currentIndex
     *                     現在の位置
     * @param currentChar
     *                     現在の文字
     * @param prevChar
     *                     前の文字
     *
     * @return true：アンダースコアを追加する、false：アンダースコアを追加しない
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
     * スネークケースに変換する。<br>
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
     * スネークケースに変換する。<br>
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
     * 値を返す。
     *
     * @since 0.1.0
     *
     * @return 値
     */
    public String getValue() {

        final String result = this.value;
        return result;

    }

    /**
     * 空文字かどうかを返す<br>
     *
     * @since 0.1.0
     *
     * @return true：空文字である、false：空文字ではない
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
     * 空文字ではないかどうかを返す<br>
     *
     * @since 0.1.0
     *
     * @return true：空文字である、false：空文字ではない
     */
    public boolean isNotEmpty() {

        final boolean result = !this.isEmpty();
        return result;

    }

    /**
     * 置換対象文字列を置換文字列に置換する。
     *
     * @since 0.1.0
     *
     * @param target
     *                   置換対象文字列
     * @param replacemen
     *                   置換文字列
     */
    public void replace(final CharSequence target, final CharSequence replacemen) {

        this.value = this.value.replace(target, replacemen);

    }

    /**
     * キャメルケースで返す。<br>
     * <p>
     * 例：aaa_bbb_ccc→aaaBbbCcc
     * </p>
     *
     * @since 0.1.0
     *
     * @return キャメルケースの文字列
     */
    public String toCamelCase() {

        final String result = KmgString.camelCase(this.value);
        return result;

    }

    /**
     * スネークケースで返す。<br>
     * <p>
     * 例：aaaBbbCcc→aaa_bbb_ccc
     * </p>
     *
     * @since 0.1.0
     *
     * @return スネークケースの文字列
     */
    public String toSnakeCase() {

        final String result = KmgString.snakeCase(this.value);
        return result;

    }

    /**
     * 文字列を返す<br>
     *
     * @since 0.1.0
     */
    @Override
    public String toString() {

        final String result = this.value;
        return result;

    }

}

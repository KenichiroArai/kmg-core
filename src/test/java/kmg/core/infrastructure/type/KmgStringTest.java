package kmg.core.infrastructure.type;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * KmgString クラスのテスト
 *
 * @author KenichiroArai
 *
 * @sine 1.0.0
 *
 * @version 1.0.0
 */
@SuppressWarnings({
    "nls", "static-method"
})
public class KmgStringTest {

    /**
     * camelCase メソッドのテスト - 異常系：引数がnullの場合
     */
    @Test
    public void testCamelCase_errorNull() {

        /* 期待値の定義 */
        final String expected = null;

        /* 準備 */
        final String target = null;

        /* テスト対象の実行 */
        final String actual = KmgString.camelCase(target);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "nullの場合、nullを返すべき");

    }

    /**
     * camelCase メソッドのテスト - 正常系：スネークケースからキャメルケースへの変換
     */
    @Test
    public void testCamelCase_normalFromSnakeCase() {

        /* 期待値の定義 */
        final String expected = "aaaBbbCcc";

        /* 準備 */
        final String target = "aaa_bbb_ccc";

        /* テスト対象の実行 */
        final String actual = KmgString.camelCase(target);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "スネークケースからキャメルケースへの変換が正しくないです");

    }

    /**
     * camelCase メソッドのテスト - 準正常系：大文字の1文字の場合
     */
    @Test
    public void testCamelCase_semiSingleBigChar() {

        /* 期待値の定義 */
        final String expected = "a";

        /* 準備 */
        final String target = "A";

        /* テスト対象の実行 */
        final String actual = KmgString.camelCase(target);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "1文字の場合、小文字の1文字を返すべき");

    }

    /**
     * camelCase メソッドのテスト - 準正常系：小文字の1文字の場合
     */
    @Test
    public void testCamelCase_semiSingleLowerChar() {

        /* 期待値の定義 */
        final String expected = "a";

        /* 準備 */
        final String target = "a";

        /* テスト対象の実行 */
        final String actual = KmgString.camelCase(target);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "1文字の場合、小文字の1文字を返すべき");

    }

    /**
     * capitalize メソッドのテスト - 正常系：通常の文字列の場合
     */
    @Test
    public void testCapitalize_normalString() {

        /* 期待値の定義 */
        final String expected = "Test";

        /* 準備 */
        final String target = "test";

        /* テスト対象の実行 */
        final String actual = KmgString.capitalize(target);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "先頭の文字が大文字になること");

    }

    /**
     * capitalize メソッドのテスト - 準正常系：空文字の場合
     */
    @Test
    public void testCapitalize_semiEmptyString() {

        /* 期待値の定義 */
        final String expected = "";

        /* 準備 */
        final String target = "";

        /* テスト対象の実行 */
        final String actual = KmgString.capitalize(target);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "空文字の場合、空文字を返すべき");

    }

    /**
     * concat メソッドのテスト - 正常系：複数の文字列を結合する場合
     */
    @Test
    public void testConcat_normalMultipleStrings() {

        /* 期待値の定義 */
        final String expected = "abc123";

        /* 準備 */
        final String[] target = {
            "abc", "123"
        };

        /* テスト対象の実行 */
        final String actual = KmgString.concat(target);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "複数の文字列が正しく結合されること");

    }

    /**
     * concat メソッドのテスト - 準正常系：空の配列の場合
     */
    @Test
    public void testConcat_semiEmptyArray() {

        /* 期待値の定義 */
        final String expected = "";

        /* 準備 */
        final String[] target = {};

        /* テスト対象の実行 */
        final String actual = KmgString.concat(target);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "空の配列の場合、空文字を返すべき");

    }

    /**
     * equals メソッドのテスト - 異常系：str1がnull文字列の場合
     */
    @Test
    public void testEquals_errorStr1NullStrings() {

        /* 期待値の定義 */
        final boolean expected = false;

        /* 準備 */
        final String str1 = null;
        final String str2 = "test";

        /* テスト対象の実行 */
        final boolean actual = KmgString.equals(str1, str2);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "nullを含む場合、falseを返すべき");

    }

    /**
     * equals メソッドのテスト - 異常系：str2がnull文字列の場合
     */
    @Test
    public void testEquals_errorStr2NullStrings() {

        /* 期待値の定義 */
        final boolean expected = false;

        /* 準備 */
        final String str1 = "test";
        final String str2 = null;

        /* テスト対象の実行 */
        final boolean actual = KmgString.equals(str1, str2);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "nullを含む場合、falseを返すべき");

    }

    /**
     * equals メソッドのテスト - 正常系：同じ文字列の場合
     */
    @Test
    public void testEquals_normalSameStrings() {

        /* 期待値の定義 */
        final boolean expected = true;

        /* 準備 */
        final String str1 = "test";
        final String str2 = "test";

        /* テスト対象の実行 */
        final boolean actual = KmgString.equals(str1, str2);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "同じ文字列の場合、trueを返すべき");

    }

    /**
     * equals メソッドのテスト - 準正常系：異なる文字列の場合
     */
    @Test
    public void testEquals_semiDifferentStrings() {

        /* 期待値の定義 */
        final boolean expected = false;

        /* 準備 */
        final String str1 = "test1";
        final String str2 = "test2";

        /* テスト対象の実行 */
        final boolean actual = KmgString.equals(str1, str2);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "異なる文字列の場合、falseを返すべき");

    }

    /**
     * equalsIgnoreCase メソッドのテスト - 異常系：両方がnullの場合
     */
    @Test
    public void testEqualsIgnoreCase_errorBothNull() {

        /* 期待値の定義 */
        final boolean expected = false;

        /* 準備 */
        final String str1 = null;
        final String str2 = null;

        /* テスト対象の実行 */
        final boolean actual = KmgString.equalsIgnoreCase(str1, str2);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "両方nullの場合、falseを返すべき");

    }

    /**
     * equalsIgnoreCase メソッドのテスト - 異常系：str1がnullの場合
     */
    @Test
    public void testEqualsIgnoreCase_errorStr1NullStrings() {

        /* 期待値の定義 */
        final boolean expected = false;

        /* 準備 */
        final String str1 = null;
        final String str2 = "test";

        /* テスト対象の実行 */
        final boolean actual = KmgString.equalsIgnoreCase(str1, str2);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "str1がnullの場合、falseを返すべき");

    }

    /**
     * equalsIgnoreCase メソッドのテスト - 異常系：str2がnullの場合
     */
    @Test
    public void testEqualsIgnoreCase_errorStr2NullStrings() {

        /* 期待値の定義 */
        final boolean expected = false;

        /* 準備 */
        final String str1 = "test";
        final String str2 = null;

        /* テスト対象の実行 */
        final boolean actual = KmgString.equalsIgnoreCase(str1, str2);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "nullを含む場合、falseを返すべき");

    }

    /**
     * equalsIgnoreCase メソッドのテスト - 正常系：大文字小文字が異なる場合
     */
    @Test
    public void testEqualsIgnoreCase_normalDifferentCase() {

        /* 期待値の定義 */
        final boolean expected = true;

        /* 準備 */
        final String str1 = "TEST";
        final String str2 = "test";

        /* テスト対象の実行 */
        final boolean actual = KmgString.equalsIgnoreCase(str1, str2);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "大文字小文字が異なる場合でも、trueを返すべき");

    }

    /**
     * equalsIgnoreCase メソッドのテスト - 正常系：同じ文字列の場合
     */
    @Test
    public void testEqualsIgnoreCase_normalSameStrings() {

        /* 期待値の定義 */
        final boolean expected = true;

        /* 準備 */
        final String str1 = "test";
        final String str2 = "test";

        /* テスト対象の実行 */
        final boolean actual = KmgString.equalsIgnoreCase(str1, str2);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "同じ文字列の場合、trueを返すべき");

    }

    /**
     * equalsIgnoreCase メソッドのテスト - 準正常系：異なる文字列の場合
     */
    @Test
    public void testEqualsIgnoreCase_semiDifferentStrings() {

        /* 期待値の定義 */
        final boolean expected = false;

        /* 準備 */
        final String str1 = "test1";
        final String str2 = "test2";

        /* テスト対象の実行 */
        final boolean actual = KmgString.equalsIgnoreCase(str1, str2);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "異なる文字列の場合、falseを返すべき");

    }

    /**
     * fromCamelCase メソッドのテスト - 正常系：キャメルケースからスネークケースへの変換
     */
    @Test
    public void testFromCamelCase_normalConversion() {

        /* 期待値の定義 */
        final String expected = "aaaBbbCcc";

        /* 準備 */
        final KmgString kmgString = new KmgString("aaa_bbb_ccc");

        /* テスト対象の実行 */
        kmgString.fromCamelCase();

        /* 検証の実施 */
        Assertions.assertEquals(expected, kmgString.getValue(), "キャメルケースへの変換が正しくないです");

    }

    /**
     * fromSnakeCase メソッドのテスト - 正常系：スネークケースからキャメルケースへの変換
     */
    @Test
    public void testFromSnakeCase_normalConversion() {

        /* 期待値の定義 */
        final String expected = "aaa_bbb_ccc";

        /* 準備 */
        final KmgString kmgString = new KmgString("aaaBbbCcc");

        /* テスト対象の実行 */
        kmgString.fromSnakeCase();

        /* 検証の実施 */
        Assertions.assertEquals(expected, kmgString.getValue(), "スネークケースへの変換が正しくないです");

    }

    /**
     * getValue メソッドのテスト - 正常系：初期値の取得
     */
    @Test
    public void testGetValue_normalInitialValue() {

        /* 期待値の定義 */
        final String expected = "test";

        /* 準備 */
        final KmgString kmgString = new KmgString(expected);

        /* テスト対象の実行 */
        final String actual = kmgString.getValue();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "コンストラクタで設定した値がgetValueで取得できること");

    }

    /**
     * インスタンスメソッド - 正常系：isEmpty
     */
    @Test
    public void testInstance_normalIsEmpty() {

        /* 期待値の定義 */
        final boolean expectedEmpty    = true;
        final boolean expectedNonEmpty = false;

        /* 準備 */
        final KmgString emptyString    = new KmgString("");
        final KmgString nonEmptyString = new KmgString("test");

        /* テスト対象の実行と検証 */
        Assertions.assertEquals(expectedEmpty, emptyString.isEmpty(), "空文字の場合、trueを返すべき");
        Assertions.assertEquals(expectedNonEmpty, nonEmptyString.isEmpty(), "文字列がある場合、falseを返すべき");

    }

    /**
     * インスタンスメソッド - 正常系：isNotEmpty
     */
    @Test
    public void testInstance_normalIsNotEmpty() {

        /* 期待値の定義 */
        final boolean expectedEmpty    = false;
        final boolean expectedNonEmpty = true;

        /* 準備 */
        final KmgString emptyString    = new KmgString("");
        final KmgString nonEmptyString = new KmgString("test");

        /* テスト対象の実行と検証 */
        Assertions.assertEquals(expectedEmpty, emptyString.isNotEmpty(), "空文字の場合、falseを返すべき");
        Assertions.assertEquals(expectedNonEmpty, nonEmptyString.isNotEmpty(), "文字列がある場合、trueを返すべき");

    }

    /**
     * isEmpty メソッドのテスト - 異常系：nullの場合
     */
    @Test
    public void testIsEmpty_errorNull() {

        /* 期待値の定義 */
        final boolean expected = true;

        /* 準備 */
        final String target = null;

        /* テスト対象の実行 */
        final boolean actual = KmgString.isEmpty(target);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "nullの場合、trueを返すべき");

    }

    /**
     * isEmpty メソッドのテスト - 正常系：引数が空文字の場合
     */
    @Test
    public void testIsEmpty_normalEmptyString() {

        /* 期待値の定義 */
        final boolean expected = true;

        /* 準備 */
        final String target = "";

        /* テスト対象の実行 */
        final boolean actual = KmgString.isEmpty(target);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "空文字の場合、trueを返すべき");

    }

    /**
     * isEmpty メソッドのテスト - 準正常系：非空文字列の場合
     */
    @Test
    public void testIsEmpty_semiNonEmptyString() {

        /* 期待値の定義 */
        final boolean expected = false;

        /* 準備 */
        final String target = "test";

        /* テスト対象の実行 */
        final boolean actual = KmgString.isEmpty(target);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "文字列がある場合、falseを返すべき");

    }

    /**
     * isNotEmpty メソッドのテスト - 異常系：nullの場合
     */
    @Test
    public void testIsNotEmpty_errorNull() {

        /* 期待値の定義 */
        final boolean expected = false;

        /* 準備 */
        final String target = null;

        /* テスト対象の実行 */
        final boolean actual = KmgString.isNotEmpty(target);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "nullの場合、falseを返すべき");

    }

    /**
     * isNotEmpty メソッドのテスト - 正常系：文字列が存在する場合
     */
    @Test
    public void testIsNotEmpty_normalExistString() {

        /* 期待値の定義 */
        final boolean expected = true;

        /* 準備 */
        final String target = "test";

        /* テスト対象の実行 */
        final boolean actual = KmgString.isNotEmpty(target);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "文字列がある場合、trueを返すべき");

    }

    /**
     * isNotEmpty メソッドのテスト - 準正常系：空文字の場合
     */
    @Test
    public void testIsNotEmpty_semiEmptyString() {

        /* 期待値の定義 */
        final boolean expected = false;

        /* 準備 */
        final String target = "";

        /* テスト対象の実行 */
        final boolean actual = KmgString.isNotEmpty(target);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "空文字の場合、falseを返すべき");

    }

    /**
     * replace メソッドのテスト - 正常系：文字列の置換
     */
    @Test
    public void testReplace_normalReplacement() {

        /* 期待値の定義 */
        final String expected = "Hello World";

        /* 準備 */
        final KmgString kmgString = new KmgString("Hello Test");

        /* テスト対象の実行 */
        kmgString.replace("Test", "World");

        /* 検証の実施 */
        Assertions.assertEquals(expected, kmgString.getValue(), "文字列の置換が正しくないです");

    }

    /**
     * shouldAddUnderscore メソッドのテスト - 正常系：文字列の最後の大文字の場合
     */
    @Test
    public void testShouldAddUnderscore_normalLastUpperCase() {

        /* 期待値の定義 */
        final String expected = "test_a";

        /* 準備 */
        final String target = "testA";

        /* テスト対象の実行 */
        final String actual = KmgString.snakeCase(target);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "文字列の最後の大文字の場合、アンダースコアが追加されるべき");

    }

    /**
     * shouldAddUnderscore メソッドのテスト - 正常系：次の文字が小文字の場合
     */
    @Test
    public void testShouldAddUnderscore_normalNextCharLowerCase() {

        /* 期待値の定義 */
        final String expected = "test_abc";

        /* 準備 */
        final String target = "testAbc";

        /* テスト対象の実行 */
        final String actual = KmgString.snakeCase(target);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "次の文字が小文字の場合、アンダースコアが追加されるべき");

    }

    /**
     * shouldAddUnderscore メソッドのテスト - 正常系：次の文字が大文字の場合
     */
    @Test
    public void testShouldAddUnderscore_normalNextCharUpperCase() {

        /* 期待値の定義 */
        final String expected = "test_abc";

        /* 準備 */
        final String target = "testABC";

        /* テスト対象の実行 */
        final String actual = KmgString.snakeCase(target);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "次の文字が大文字の場合、アンダースコアが追加されるべき");

    }

    /**
     * snakeCase メソッドのテスト - 異常系：空文字の場合
     */
    @Test
    public void testSnakeCase_errorEmptyString() {

        /* 期待値の定義 */
        final String expected = null;

        /* 準備 */
        final String target = "";

        /* テスト対象の実行 */
        final String actual = KmgString.snakeCase(target);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "空文字の場合、nullを返すべき");

    }

    /**
     * snakeCase メソッドのテスト - 正常系：既にスネークケース形式の場合
     */
    @Test
    public void testSnakeCase_normalAlreadySnakeCase() {

        /* 期待値の定義 */
        final String expected = "aaa_bbb_ccc";

        /* 準備 */
        final String target = "aaa_bbb_ccc";

        /* テスト対象の実行 */
        final String actual = KmgString.snakeCase(target);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "既にスネークケース形式の場合の処理が正しくないです");

    }

    /**
     * snakeCase メソッドのテスト - 正常系：連続する大文字の処理
     */
    @Test
    public void testSnakeCase_normalConsecutiveUpperCase() {

        /* 期待値の定義 */
        final String expected = "aaa_bbb_xml_http";

        /* 準備 */
        final String target = "aaaBbbXMLHttp";

        /* テスト対象の実行 */
        final String actual = KmgString.snakeCase(target);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "連続する大文字の処理が正しくないです");

    }

    /**
     * snakeCase メソッドのテスト - 正常系：キャメルケースからスネークケースへの変換
     */
    @Test
    public void testSnakeCase_normalFromCamelCase() {

        /* 期待値の定義 */
        final String expected = "aaa_bbb_ccc";

        /* 準備 */
        final String target = "aaaBbbCcc";

        /* テスト対象の実行 */
        final String actual = KmgString.snakeCase(target);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "キャメルケースからスネークケースへの変換が正しくないです");

    }

    /**
     * snakeCase メソッドのテスト - 正常系：最後の文字が大文字の場合
     */
    @Test
    public void testSnakeCase_normalLastCharUpperCase() {

        /* 期待値の定義 */
        final String expected = "aaa_bbb_c";

        /* 準備 */
        final String target = "aaaBbbC";

        /* テスト対象の実行 */
        final String actual = KmgString.snakeCase(target);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "最後の文字が大文字の場合の変換が正しくないです");

    }

    /**
     * snakeCase メソッドのテスト - 準正常系：1文字の場合
     */
    @Test
    public void testSnakeCase_semiSingleChar() {

        /* 期待値の定義 */
        final String expected = "a";

        /* 準備 */
        final String target = "A";

        /* テスト対象の実行 */
        final String actual = KmgString.snakeCase(target);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "1文字の場合、小文字にして1文字を返すべき");

    }

    /**
     * toCamelCase メソッドのテスト - 正常系：スネークケースからキャメルケースへの変換
     */
    @Test
    public void testToCamelCase_normalFromSnakeCase() {

        /* 期待値の定義 */
        final String expected = "aaaBbbCcc";

        /* 準備 */
        final KmgString kmgString = new KmgString("aaa_bbb_ccc");

        /* テスト対象の実行 */
        final String actual = kmgString.toCamelCase();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "スネークケースからキャメルケースへの変換が正しくないです");

    }

    /**
     * toSnakeCase メソッドのテスト - 正常系：キャメルケースからスネークケースへの変換
     */
    @Test
    public void testToSnakeCase_normalFromCamelCase() {

        /* 期待値の定義 */
        final String expected = "aaa_bbb_ccc";

        /* 準備 */
        final KmgString kmgString = new KmgString("aaaBbbCcc");

        /* テスト対象の実行 */
        final String actual = kmgString.toSnakeCase();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "キャメルケースからスネークケースへの変換が正しくないです");

    }

    /**
     * toString メソッドのテスト - 正常系：文字列表現の取得
     */
    @Test
    public void testToString_normalGetString() {

        /* 期待値の定義 */
        final String expected = "test";

        /* 準備 */
        final KmgString kmgString = new KmgString(expected);

        /* テスト対象の実行 */
        final String actual = kmgString.toString();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "toString()の結果が正しくないです");

    }
}

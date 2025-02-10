package kmg.core.infrastructure.type;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * KmgString テスト
 *
 * @author KenichiroArai
 *
 * @sine 1.0.0
 *
 * @version 1.0.0
 */
public class KmgStringTest {

    /**
     * camelCase メソッドのテスト - スネークケースからキャメルケースへの変換
     */
    @Test
    @SuppressWarnings("static-method")
    public void testCamelCase_fromSnakeCase() {

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
     * camelCase メソッドのテスト - 引数がnullの場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testCamelCase_null() {

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
     * camelCase メソッドのテスト - 大文字の1文字の場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testCamelCase_singleBigChar() {

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
     * camelCase メソッドのテスト - 小文字の1文字の場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testCamelCase_singleLowerChar() {

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
     * capitalize メソッドのテスト - 空文字の場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testCapitalize_emptyString() {

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
     * capitalize メソッドのテスト - 通常の文字列の場合
     */
    @Test
    @SuppressWarnings("static-method")
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
     * concat メソッドのテスト - 空の配列の場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testConcat_emptyArray() {

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
     * concat メソッドのテスト - 複数の文字列を結合する場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testConcat_multipleStrings() {

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
     * equals メソッドのテスト - 異なる文字列の場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testEquals_differentStrings() {

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
     * equals メソッドのテスト - 同じ文字列の場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testEquals_sameStrings() {

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
     * equals メソッドのテスト - str1がnull文字列の場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testEquals_str1NullStrings() {

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
     * equals メソッドのテスト - str2がnull文字列の場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testEquals_str2NullStrings() {

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
     * equalsIgnoreCase メソッドのテスト - 両方nullの場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testEqualsIgnoreCase_bothNull() {

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
     * equalsIgnoreCase メソッドのテスト - 大文字小文字が異なる場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testEqualsIgnoreCase_differentCase() {

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
     * equalsIgnoreCase メソッドのテスト - 異なる文字列の場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testEqualsIgnoreCase_differentStrings() {

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
     * equalsIgnoreCase メソッドのテスト - 同一文字列の場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testEqualsIgnoreCase_sameStrings() {

        /* 期待値の定義 */
        final boolean expected = true;

        /* 準備 */
        final String str1 = "test";
        final String str2 = "test";

        /* テスト対象の実行 */
        final boolean actual = KmgString.equalsIgnoreCase(str1, str2);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "同一文字列の場合、trueを返すべき");

    }

    /**
     * equalsIgnoreCase メソッドのテスト - str1がnull文字列の場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testEqualsIgnoreCase_str1NullStrings() {

        /* 期待値の定義 */
        final boolean expected = false;

        /* 準備 */
        final String str1 = null;
        final String str2 = "test";

        /* テスト対象の実行 */
        final boolean actual = KmgString.equalsIgnoreCase(str1, str2);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "nullを含む場合、falseを返すべき");

    }

    /**
     * equalsIgnoreCase メソッドのテスト - str2がnull文字列の場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testEqualsIgnoreCase_str2NullStrings() {

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
     * fromCamelCaseメソッドのテスト
     */
    @Test
    @SuppressWarnings("static-method")
    public void testFromCamelCase() {

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
     * fromSnakeCaseメソッドのテスト
     */
    @Test
    @SuppressWarnings("static-method")
    public void testFromSnakeCase() {

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
     * getValue メソッドのテスト - 初期値の取得
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGetValue_initialValue() {

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
     * インスタンスメソッドのisEmptyのテスト
     */
    @Test
    @SuppressWarnings("static-method")
    public void testInstanceIsEmpty() {

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
     * インスタンスメソッドのisNotEmptyのテスト
     */
    @Test
    @SuppressWarnings("static-method")
    public void testInstanceIsNotEmpty() {

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
     * isEmpty メソッドのテスト - 引数が空文字の場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testIsEmpty_emptyString() {

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
     * isEmpty メソッドのテスト - 引数が文字列の場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testIsEmpty_nonEmptyString() {

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
     * isEmpty メソッドのテスト - 引数がnullの場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testIsEmpty_null() {

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
     * isNotEmpty メソッドのテスト - 引数が空文字の場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testIsNotEmpty_emptyString() {

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
     * isNotEmpty メソッドのテスト - 引数が文字列の場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testIsNotEmpty_nonEmptyString() {

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
     * isNotEmpty メソッドのテスト - 引数がnullの場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testIsNotEmpty_null() {

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
     * replaceメソッドのテスト
     */
    @Test
    @SuppressWarnings("static-method")
    public void testReplace() {

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
     * snakeCase メソッドのテスト - 空文字の場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testSnakeCase_emptyString() {

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
     * snakeCase メソッドのテスト - キャメルケースからスネークケースへの変換
     */
    @Test
    @SuppressWarnings("static-method")
    public void testSnakeCase_fromCamelCase() {

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
     * snakeCase メソッドのテスト - 1文字の場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testSnakeCase_singleChar() {

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
     * snakeCase メソッドのテスト - 最後の文字が大文字の場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testSnakeCase_lastCharUpperCase() {

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
     * snakeCase メソッドのテスト - 連続する大文字の処理
     */
    @Test
    @SuppressWarnings("static-method")
    public void testSnakeCase_consecutiveUpperCase() {

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
     * snakeCase メソッドのテスト - 既にスネークケース形式の場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testSnakeCase_alreadySnakeCase() {

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
     * toCamelCaseメソッドのテスト
     */
    @Test
    @SuppressWarnings("static-method")
    public void testToCamelCase() {

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
     * toSnakeCaseメソッドのテスト
     */
    @Test
    @SuppressWarnings("static-method")
    public void testToSnakeCase() {

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
     * toStringメソッドのテスト
     */
    @Test
    @SuppressWarnings("static-method")
    public void testToString() {

        /* 期待値の定義 */
        final String expected = "test";

        /* 準備 */
        final KmgString kmgString = new KmgString(expected);

        /* テスト対象の実行 */
        final String actual = kmgString.toString();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "toString()の結果が正しくないです");

    }

    /**
     * shouldAddUnderscore メソッドのテスト - 文字列の最後の大文字の場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testShouldAddUnderscore_lastUpperCase() {

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
     * shouldAddUnderscore メソッドのテスト - 次の文字が小文字の場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testShouldAddUnderscore_nextCharLowerCase() {

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
     * shouldAddUnderscore メソッドのテスト - 次の文字が大文字の場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testShouldAddUnderscore_nextCharUpperCase() {

        /* 期待値の定義 */
        final String expected = "test_abc";

        /* 準備 */
        final String target = "testABC";

        /* テスト対象の実行 */
        final String actual = KmgString.snakeCase(target);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "次の文字が大文字の場合、アンダースコアが追加されるべき");

    }
}

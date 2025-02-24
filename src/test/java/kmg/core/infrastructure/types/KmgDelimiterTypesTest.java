package kmg.core.infrastructure.types;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import kmg.core.infrastructure.type.KmgString;

/**
 * KMG区切り文字の種類のテスト<br>
 *
 * @author KenichiroArai
 * 
 * @sine 0.1.0
 * 
 * @version 0.1.0
 */
@SuppressWarnings({
    "nls", "static-method"
})
public class KmgDelimiterTypesTest {

    /**
     * get メソッドのテスト - 正常系:基本的な値の取得
     * 
     * @author KenichiroArai
     * 
     * @sine 0.1.0
     * 
     * @version 0.1.0
     */
    @Test
    public void testGet_normalBasicValue() {

        /* 期待値の定義 */
        final String expected = ",";

        /* 準備 */
        final KmgDelimiterTypes testType = KmgDelimiterTypes.COMMA;

        /* テスト対象の実行 */
        final String actual = testType.get();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "取得値が一致しません");

    }

    /**
     * getDefault メソッドのテスト - 正常系:デフォルト値の取得
     * 
     * @author KenichiroArai
     * 
     * @sine 0.1.0
     * 
     * @version 0.1.0
     */
    @Test
    public void testGetDefault_normalDefaultValue() {

        /* 期待値の定義 */
        final KmgDelimiterTypes expected = KmgDelimiterTypes.NONE;

        /* テスト対象の実行 */
        final KmgDelimiterTypes actual = KmgDelimiterTypes.getDefault();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "デフォルト値が一致しません");

    }

    /**
     * getDetail メソッドのテスト - 正常系:基本的な詳細情報の取得
     * 
     * @author KenichiroArai
     * 
     * @sine 0.1.0
     * 
     * @version 0.1.0
     */
    @Test
    public void testGetDetail_normalBasicDetail() {

        /* 期待値の定義 */
        final String expected = "カンマ";

        /* 準備 */
        final KmgDelimiterTypes testType = KmgDelimiterTypes.COMMA;

        /* テスト対象の実行 */
        final String actual = testType.getDetail();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "詳細情報が一致しません");

    }

    /**
     * getDisplayName メソッドのテスト - 正常系:基本的な表示名の取得
     * 
     * @author KenichiroArai
     * 
     * @sine 0.1.0
     * 
     * @version 0.1.0
     */
    @Test
    public void testGetDisplayName_normalBasicName() {

        /* 期待値の定義 */
        final String expected = "カンマ";

        /* 準備 */
        final KmgDelimiterTypes testType = KmgDelimiterTypes.COMMA;

        /* テスト対象の実行 */
        final String actual = testType.getDisplayName();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "表示名が一致しません");

    }

    /**
     * getEnum メソッドのテスト - 正常系:存在する値の取得
     * 
     * @author KenichiroArai
     * 
     * @sine 0.1.0
     * 
     * @version 0.1.0
     */
    @Test
    public void testGetEnum_normalExistingValue() {

        /* 期待値の定義 */
        final KmgDelimiterTypes expected = KmgDelimiterTypes.COMMA;

        /* 準備 */
        final String testValue = ",";

        /* テスト対象の実行 */
        final KmgDelimiterTypes actual = KmgDelimiterTypes.getEnum(testValue);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "値が一致しません");

    }

    /**
     * getEnum メソッドのテスト - 準正常系:存在しないキーの取得
     * 
     * @author KenichiroArai
     * 
     * @sine 0.1.0
     * 
     * @version 0.1.0
     */
    @Test
    public void testGetEnum_semiNonExistingKey() {

        /* 期待値の定義 */
        final KmgDelimiterTypes expected = KmgDelimiterTypes.NONE;

        /* 準備 */
        final String testValue = null;

        /* テスト対象の実行 */
        final KmgDelimiterTypes actual = KmgDelimiterTypes.getEnum(testValue);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "存在しないキーの場合、NONEが返されること");

    }

    /**
     * getEnum メソッドのテスト - 準正常系:存在しない値の取得
     * 
     * @author KenichiroArai
     * 
     * @sine 0.1.0
     * 
     * @version 0.1.0
     */
    @Test
    public void testGetEnum_semiNonExistingValue() {

        /* 期待値の定義 */
        final KmgDelimiterTypes expected = KmgDelimiterTypes.NONE;

        /* 準備 */
        final String testValue = "INVALID";

        /* テスト対象の実行 */
        final KmgDelimiterTypes actual = KmgDelimiterTypes.getEnum(testValue);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "値が一致しません");

    }

    /**
     * getInitValue メソッドのテスト - 正常系:初期値の取得
     * 
     * @author KenichiroArai
     * 
     * @sine 0.1.0
     * 
     * @version 0.1.0
     */
    @Test
    public void testGetInitValue_normalInitialValue() {

        /* 期待値の定義 */
        final KmgDelimiterTypes expected = KmgDelimiterTypes.NONE;

        /* テスト対象の実行 */
        final KmgDelimiterTypes actual = KmgDelimiterTypes.getInitValue();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "初期値が一致しません");

    }

    /**
     * getKey メソッドのテスト - 正常系:基本的なキーの取得
     * 
     * @author KenichiroArai
     * 
     * @sine 0.1.0
     * 
     * @version 0.1.0
     */
    @Test
    public void testGetKey_normalBasicKey() {

        /* 期待値の定義 */
        final String expected = ",";

        /* 準備 */
        final KmgDelimiterTypes testType = KmgDelimiterTypes.COMMA;

        /* テスト対象の実行 */
        final String actual = testType.getKey();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "キーが一致しません");

    }

    /**
     * join メソッドのテスト - 正常系:基本的な結合
     * 
     * @author KenichiroArai
     * 
     * @sine 0.1.0
     * 
     * @version 0.1.0
     */
    @Test
    public void testJoin_normalBasicCase() {

        /* 期待値の定義 */
        final String expectedResult = "a,b,c";

        /* 準備 */
        final KmgDelimiterTypes testTarget = KmgDelimiterTypes.COMMA;
        final String[]          testInput  = {
            "a", "b", "c"
        };

        /* テスト対象の実行 */
        final String testResult = testTarget.join((Object[]) testInput);

        /* 検証の準備 */
        final String actualResult = testResult;

        /* 検証の実施 */
        Assertions.assertEquals(expectedResult, actualResult, "通常の文字列配列の結合結果が一致しません");

    }

    /**
     * join メソッドのテスト - 正常系:リストの結合
     * 
     * @author KenichiroArai
     * 
     * @sine 0.1.0
     * 
     * @version 0.1.0
     */
    @Test
    public void testJoin_normalList() {

        /* 期待値の定義 */
        final String expected = "test1,test2,test3";

        /* 準備 */
        final KmgDelimiterTypes testType = KmgDelimiterTypes.COMMA;
        final List<String>      testList = Arrays.asList("test1", "test2", "test3");

        /* テスト対象の実行 */
        final String actual = testType.join(testList);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "リストの結合結果が一致しません");

    }

    /**
     * join メソッドのテスト - 正常系:単一要素の結合
     * 
     * @author KenichiroArai
     * 
     * @sine 0.1.0
     * 
     * @version 0.1.0
     */
    @Test
    public void testJoin_normalSingleElement() {

        /* 期待値の定義 */
        final String expectedResult = "a";

        /* 準備 */
        final KmgDelimiterTypes testTarget = KmgDelimiterTypes.COMMA;
        final String[]          testInput  = {
            "a"
        };

        /* テスト対象の実行 */
        final String testResult = testTarget.join((Object[]) testInput);

        /* 検証の準備 */
        final String actualResult = testResult;

        /* 検証の実施 */
        Assertions.assertEquals(expectedResult, actualResult, "1つの要素の結合結果が一致しません");

    }

    /**
     * join メソッドのテスト - 正常系:可変引数の結合
     * 
     * @author KenichiroArai
     * 
     * @sine 0.1.0
     * 
     * @version 0.1.0
     */
    @Test
    public void testJoin_normalVarargs() {

        /* 期待値の定義 */
        final String expected = "test1,test2,test3";

        /* 準備 */
        final KmgDelimiterTypes testType = KmgDelimiterTypes.COMMA;

        /* テスト対象の実行 */
        final String actual = testType.join("test1", "test2", "test3");

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "可変長引数の結合結果が一致しません");

    }

    /**
     * join メソッドのテスト - 準正常系:空文字を含む配列の結合
     * 
     * @author KenichiroArai
     * 
     * @sine 0.1.0
     * 
     * @version 0.1.0
     */
    @Test
    public void testJoin_semiContainsEmptyString() {

        /* 期待値の定義 */
        final String expectedResult = "a,c";

        /* 準備 */
        final KmgDelimiterTypes testTarget = KmgDelimiterTypes.COMMA;
        final String[]          testInput  = {
            "a", "", "c"
        };

        /* テスト対象の実行 */
        final String testResult = testTarget.join((Object[]) testInput);

        /* 検証の準備 */
        final String actualResult = testResult;

        /* 検証の実施 */
        Assertions.assertEquals(expectedResult, actualResult, "空文字を含む配列の結合結果が一致しません");

    }

    /**
     * join メソッドのテスト - 準正常系:nullを含む配列の結合
     * 
     * @author KenichiroArai
     * 
     * @sine 0.1.0
     * 
     * @version 0.1.0
     */
    @Test
    public void testJoin_semiContainsNull() {

        /* 期待値の定義 */
        final String expectedResult = "a,c";

        /* 準備 */
        final KmgDelimiterTypes testTarget = KmgDelimiterTypes.COMMA;
        final String[]          testInput  = {
            "a", null, "c"
        };

        /* テスト対象の実行 */
        final String testResult = testTarget.join((Object[]) testInput);

        /* 検証の準備 */
        final String actualResult = testResult;

        /* 検証の実施 */
        Assertions.assertEquals(expectedResult, actualResult, "nullを含む配列の結合結果が一致しません");

    }

    /**
     * join メソッドのテスト - 準正常系:空配列の結合
     * 
     * @author KenichiroArai
     * 
     * @sine 0.1.0
     * 
     * @version 0.1.0
     */
    @Test
    public void testJoin_semiEmptyArray() {

        /* 期待値の定義 */
        final String expectedResult = KmgString.EMPTY;

        /* 準備 */
        final KmgDelimiterTypes testTarget = KmgDelimiterTypes.COMMA;
        final String[]          testInput  = {};

        /* テスト対象の実行 */
        final String testResult = testTarget.join((Object[]) testInput);

        /* 検証の準備 */
        final String actualResult = testResult;

        /* 検証の実施 */
        Assertions.assertEquals(expectedResult, actualResult, "空配列の結合結果が一致しません");

    }

    /**
     * join メソッドのテスト - 準正常系:null配列の結合
     * 
     * @author KenichiroArai
     * 
     * @sine 0.1.0
     * 
     * @version 0.1.0
     */
    @Test
    public void testJoin_semiNullArray() {

        /* 期待値の定義 */
        final String expectedResult = KmgString.EMPTY;

        /* 準備 */
        final KmgDelimiterTypes testTarget = KmgDelimiterTypes.COMMA;
        final String[]          testInput  = null;

        /* テスト対象の実行 */
        final String testResult = testTarget.join((Object[]) testInput);

        /* 検証の準備 */
        final String actualResult = testResult;

        /* 検証の実施 */
        Assertions.assertEquals(expectedResult, actualResult, "null配列の結合結果が一致しません");

    }

    /**
     * join メソッドのテスト - 準正常系:空文字を含む可変引数の結合
     * 
     * @author KenichiroArai
     * 
     * @sine 0.1.0
     * 
     * @version 0.1.0
     */
    @Test
    public void testJoin_semiVarargsWithEmpty() {

        /* 期待値の定義 */
        final String expected = "test1,test3";

        /* 準備 */
        final KmgDelimiterTypes testType = KmgDelimiterTypes.COMMA;

        /* テスト対象の実行 */
        final String actual = testType.join("test1", "", "test3");

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "空文字を含む可変長引数の結合結果が一致しません");

    }

    /**
     * join メソッドのテスト - 準正常系:nullを含む可変引数の結合
     * 
     * @author KenichiroArai
     * 
     * @sine 0.1.0
     * 
     * @version 0.1.0
     */
    @Test
    public void testJoin_semiVarargsWithNull() {

        /* 期待値の定義 */
        final String expected = "test1,test3";

        /* 準備 */
        final KmgDelimiterTypes testType = KmgDelimiterTypes.COMMA;

        /* テスト対象の実行 */
        final String actual = testType.join("test1", null, "test3");

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "nullを含む可変長引数の結合結果が一致しません");

    }

    /**
     * joinAll メソッドのテスト - 正常系:基本的な結合
     * 
     * @author KenichiroArai
     * 
     * @sine 0.1.0
     * 
     * @version 0.1.0
     */
    @Test
    public void testJoinAll_normalBasicCase() {

        /* 期待値の定義 */
        final String expectedResult = "a,b,c";

        /* 準備 */
        final KmgDelimiterTypes testTarget = KmgDelimiterTypes.COMMA;
        final String[]          testInput  = {
            "a", "b", "c"
        };

        /* テスト対象の実行 */
        final String testResult = testTarget.joinAll((Object[]) testInput);

        /* 検証の準備 */
        final String actualResult = testResult;

        /* 検証の実施 */
        Assertions.assertEquals(expectedResult, actualResult, "通常の文字列配列の結合結果が一致しません");

    }

    /**
     * joinAll メソッドのテスト - 正常系:リストの結合
     * 
     * @author KenichiroArai
     * 
     * @sine 0.1.0
     * 
     * @version 0.1.0
     */
    @Test
    public void testJoinAll_normalList() {

        /* 期待値の定義 */
        final String expected = "test1,null,test3";

        /* 準備 */
        final KmgDelimiterTypes testType = KmgDelimiterTypes.COMMA;
        final List<String>      testList = Arrays.asList("test1", null, "test3");

        /* テスト対象の実行 */
        final String actual = testType.joinAll(testList);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "リストの結合結果が一致しません");

    }

    /**
     * joinAll メソッドのテスト - 正常系:複数の単一文字要素の結合
     * 
     * @author KenichiroArai
     * 
     * @sine 0.1.0
     * 
     * @version 0.1.0
     */
    @Test
    public void testJoinAll_normalMultipleSingleCharElements() {

        /* 期待値の定義 */
        final String expectedResult = "a,b";

        /* 準備 */
        final KmgDelimiterTypes testTarget = KmgDelimiterTypes.COMMA;
        final String[]          testInput  = {
            "a", "b"
        };

        /* テスト対象の実行 */
        final String testResult = testTarget.joinAll((Object[]) testInput);

        /* 検証の準備 */
        final String actualResult = testResult;

        /* 検証の実施 */
        Assertions.assertEquals(expectedResult, actualResult, "複数の1文字要素の結合結果が一致しません");

    }

    /**
     * joinAll メソッドのテスト - 正常系:単一文字要素の結合
     * 
     * @author KenichiroArai
     * 
     * @sine 0.1.0
     * 
     * @version 0.1.0
     */
    @Test
    public void testJoinAll_normalSingleCharElement() {

        /* 期待値の定義 */
        final String expectedResult = "a";

        /* 準備 */
        final KmgDelimiterTypes testTarget = KmgDelimiterTypes.COMMA;
        final String[]          testInput  = {
            "a"
        };

        /* テスト対象の実行 */
        final String testResult = testTarget.joinAll((Object[]) testInput);

        /* 検証の準備 */
        final String actualResult = testResult;

        /* 検証の実施 */
        Assertions.assertEquals(expectedResult, actualResult, "1文字の要素の結合結果が一致しません");

    }

    /**
     * joinAll メソッドのテスト - 正常系:単一要素の結合
     * 
     * @author KenichiroArai
     * 
     * @sine 0.1.0
     * 
     * @version 0.1.0
     */
    @Test
    public void testJoinAll_normalSingleElement() {

        /* 期待値の定義 */
        final String expectedResult = "a";

        /* 準備 */
        final KmgDelimiterTypes testTarget = KmgDelimiterTypes.COMMA;
        final String[]          testInput  = {
            "a"
        };

        /* テスト対象の実行 */
        final String testResult = testTarget.joinAll((Object[]) testInput);

        /* 検証の準備 */
        final String actualResult = testResult;

        /* 検証の実施 */
        Assertions.assertEquals(expectedResult, actualResult, "1つの要素の結合結果が一致しません");

    }

    /**
     * joinAll メソッドのテスト - 正常系:可変引数の結合
     * 
     * @author KenichiroArai
     * 
     * @sine 0.1.0
     * 
     * @version 0.1.0
     */
    @Test
    public void testJoinAll_normalVarargs() {

        /* 期待値の定義 */
        final String expected = "test1,null,test3";

        /* 準備 */
        final KmgDelimiterTypes testType = KmgDelimiterTypes.COMMA;

        /* テスト対象の実行 */
        final String actual = testType.joinAll("test1", null, "test3");

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "可変長引数の結合結果が一致しません");

    }

    /**
     * joinAll メソッドのテスト - 準正常系:空文字を含む配列の結合
     * 
     * @author KenichiroArai
     * 
     * @sine 0.1.0
     * 
     * @version 0.1.0
     */
    @Test
    public void testJoinAll_semiContainsEmptyString() {

        /* 期待値の定義 */
        final String expectedResult = "a,,c";

        /* 準備 */
        final KmgDelimiterTypes testTarget = KmgDelimiterTypes.COMMA;
        final String[]          testInput  = {
            "a", "", "c"
        };

        /* テスト対象の実行 */
        final String testResult = testTarget.joinAll((Object[]) testInput);

        /* 検証の準備 */
        final String actualResult = testResult;

        /* 検証の実施 */
        Assertions.assertEquals(expectedResult, actualResult, "空文字を含む配列の結合結果が一致しません");

    }

    /**
     * joinAll メソッドのテスト - 準正常系:nullを含む配列の結合
     * 
     * @author KenichiroArai
     * 
     * @sine 0.1.0
     * 
     * @version 0.1.0
     */
    @Test
    public void testJoinAll_semiContainsNull() {

        /* 期待値の定義 */
        final String expectedResult = "a,null,c";

        /* 準備 */
        final KmgDelimiterTypes testTarget = KmgDelimiterTypes.COMMA;
        final String[]          testInput  = {
            "a", null, "c"
        };

        /* テスト対象の実行 */
        final String testResult = testTarget.joinAll((Object[]) testInput);

        /* 検証の準備 */
        final String actualResult = testResult;

        /* 検証の実施 */
        Assertions.assertEquals(expectedResult, actualResult, "nullを含む配列の結合結果が一致しません");

    }

    /**
     * joinAll メソッドのテスト - 準正常系:空配列の結合
     * 
     * @author KenichiroArai
     * 
     * @sine 0.1.0
     * 
     * @version 0.1.0
     */
    @Test
    public void testJoinAll_semiEmptyArray() {

        /* 期待値の定義 */
        final String expectedResult = KmgString.EMPTY;

        /* 準備 */
        final KmgDelimiterTypes testTarget = KmgDelimiterTypes.COMMA;
        final String[]          testInput  = {};

        /* テスト対象の実行 */
        final String testResult = testTarget.joinAll((Object[]) testInput);

        /* 検証の準備 */
        final String actualResult = testResult;

        /* 検証の実施 */
        Assertions.assertEquals(expectedResult, actualResult, "空配列の結合結果が一致しません");

    }

    /**
     * joinAll メソッドのテスト - 準正常系:空文字要素の結合
     * 
     * @author KenichiroArai
     * 
     * @sine 0.1.0
     * 
     * @version 0.1.0
     */
    @Test
    public void testJoinAll_semiEmptyStringElement() {

        /* 期待値の定義 */
        final String expectedResult = "";

        /* 準備 */
        final KmgDelimiterTypes testTarget = KmgDelimiterTypes.COMMA;
        final String[]          testInput  = {
            ""
        };

        /* テスト対象の実行 */
        final String testResult = testTarget.joinAll((Object[]) testInput);

        /* 検証の準備 */
        final String actualResult = testResult;

        /* 検証の実施 */
        Assertions.assertEquals(expectedResult, actualResult, "空文字の要素の結合結果が一致しません");

    }

    /**
     * joinAll メソッドのテスト - 準正常系:null配列の結合
     * 
     * @author KenichiroArai
     * 
     * @sine 0.1.0
     * 
     * @version 0.1.0
     */
    @Test
    public void testJoinAll_semiNullArray() {

        /* 期待値の定義 */
        final String expectedResult = KmgString.EMPTY;

        /* 準備 */
        final KmgDelimiterTypes testTarget = KmgDelimiterTypes.COMMA;
        final String[]          testInput  = null;

        /* テスト対象の実行 */
        final String testResult = testTarget.joinAll((Object[]) testInput);

        /* 検証の準備 */
        final String actualResult = testResult;

        /* 検証の実施 */
        Assertions.assertEquals(expectedResult, actualResult, "null配列の結合結果が一致しません");

    }

    /**
     * split メソッドのテスト - 正常系:基本的な分割
     * 
     * @author KenichiroArai
     * 
     * @sine 0.1.0
     * 
     * @version 0.1.0
     */
    @Test
    public void testSplit_normalBasicCase() {

        /* 期待値の定義 */
        final String[] expected = {
            "test1", "test2", "test3"
        };

        /* 準備 */
        final KmgDelimiterTypes testType   = KmgDelimiterTypes.COMMA;
        final String            testString = "test1,test2,test3";

        /* テスト対象の実行 */
        final String[] actual = testType.split(testString);

        /* 検証の実施 */
        Assertions.assertArrayEquals(expected, actual, "分割結果が一致しません");

    }

    /**
     * split メソッドのテスト - 正常系:大きな制限値での分割
     * 
     * @author KenichiroArai
     * 
     * @sine 0.1.0
     * 
     * @version 0.1.0
     */
    @Test
    public void testSplit_normalWithLargerLimit() {

        /* 期待値の定義 */
        final String[] expected = {
            "test1", "test2", "test3"
        };

        /* 準備 */
        final KmgDelimiterTypes testType   = KmgDelimiterTypes.COMMA;
        final String            testString = "test1,test2,test3";
        final int               testLimit  = 5;

        /* テスト対象の実行 */
        final String[] actual = testType.split(testString, testLimit);

        /* 検証の実施 */
        Assertions.assertArrayEquals(expected, actual, "制限が大きい場合の分割結果が一致しません");

    }

    /**
     * split メソッドのテスト - 正常系:制限付きの分割
     * 
     * @author KenichiroArai
     * 
     * @sine 0.1.0
     * 
     * @version 0.1.0
     */
    @Test
    public void testSplit_normalWithLimit() {

        /* 期待値の定義 */
        final String[] expected = {
            "test1", "test2,test3"
        };

        /* 準備 */
        final KmgDelimiterTypes testType   = KmgDelimiterTypes.COMMA;
        final String            testString = "test1,test2,test3";
        final int               testLimit  = 2;

        /* テスト対象の実行 */
        final String[] actual = testType.split(testString, testLimit);

        /* 検証の実施 */
        Assertions.assertArrayEquals(expected, actual, "制限付き分割結果が一致しません");

    }

    /**
     * split メソッドのテスト - 準正常系:空文字列の分割
     * 
     * @author KenichiroArai
     * 
     * @sine 0.1.0
     * 
     * @version 0.1.0
     */
    @Test
    public void testSplit_semiEmpty() {

        /* 期待値の定義 */
        final String[] expected = null;

        /* 準備 */
        final KmgDelimiterTypes testType   = KmgDelimiterTypes.COMMA;
        final String            testString = KmgString.EMPTY;

        /* テスト対象の実行 */
        final String[] actual = testType.split(testString);

        /* 検証の実施 */
        Assertions.assertArrayEquals(expected, actual, "空文字の分割結果が一致しません");

    }

    /**
     * split メソッドのテスト - 準正常系:制限付きの空文字列分割
     * 
     * @author KenichiroArai
     * 
     * @sine 0.1.0
     * 
     * @version 0.1.0
     */
    @Test
    public void testSplit_semiWithLimitEmpty() {

        /* 期待値の定義 */
        final String[] expected = null;

        /* 準備 */
        final KmgDelimiterTypes testType   = KmgDelimiterTypes.COMMA;
        final String            testString = KmgString.EMPTY;
        final int               testLimit  = 2;

        /* テスト対象の実行 */
        final String[] actual = testType.split(testString, testLimit);

        /* 検証の実施 */
        Assertions.assertArrayEquals(expected, actual, "空文字の制限付き分割結果が一致しません");

    }

    /**
     * toString メソッドのテスト - 正常系:半角スペースの文字列表現
     * 
     * @author KenichiroArai
     * 
     * @sine 0.1.0
     * 
     * @version 0.1.0
     */
    @Test
    public void testToString_normalHalfSpace() {

        /* 期待値の定義 */
        final String expected = KmgString.HALF_SPACE;

        /* 準備 */
        final KmgDelimiterTypes testType = KmgDelimiterTypes.HALF_SPACE;

        /* テスト対象の実行 */
        final String actual = testType.toString();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "HALF_SPACEの場合、半角スペースが返されること");

    }

    /**
     * toString メソッドのテスト - 正常系:NONEの文字列表現
     * 
     * @author KenichiroArai
     * 
     * @sine 0.1.0
     * 
     * @version 0.1.0
     */
    @Test
    public void testToString_normalNone() {

        /* 期待値の定義 */
        final String expected = null;

        /* 準備 */
        final KmgDelimiterTypes testType = KmgDelimiterTypes.NONE;

        /* テスト対象の実行 */
        final String actual = testType.toString();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "NONEの場合、nullが返されること");

    }

    /**
     * toString メソッドのテスト - 正常系:ピリオドの文字列表現
     * 
     * @author KenichiroArai
     * 
     * @sine 0.1.0
     * 
     * @version 0.1.0
     */
    @Test
    public void testToString_normalPeriod() {

        /* 期待値の定義 */
        final String expected = ".";

        /* 準備 */
        final KmgDelimiterTypes testType = KmgDelimiterTypes.PERIOD;

        /* テスト対象の実行 */
        final String actual = testType.toString();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "PERIODの場合、'.'が返されること");

    }
}

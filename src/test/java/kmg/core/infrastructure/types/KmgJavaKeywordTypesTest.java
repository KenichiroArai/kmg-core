package kmg.core.infrastructure.types;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * KMGJavaキーワードの種類のテスト<br>
 *
 * @author KenichiroArai
 *
 * @since 0.2.0
 *
 * @version 0.2.0
 */
@SuppressWarnings({
    "nls", "static-method"
})
public class KmgJavaKeywordTypesTest {

    /**
     * デフォルトコンストラクタ<br>
     *
     * @since 0.2.0
     */
    public KmgJavaKeywordTypesTest() {

        // 処理なし
    }

    /**
     * get メソッドのテスト - 正常系:基本的な値の取得
     *
     * @since 0.2.0
     */
    @Test
    public void testGet_normalBasicValue() {

        /* 期待値の定義 */
        final String expected = "public";

        /* 準備 */
        final KmgJavaKeywordTypes testType = KmgJavaKeywordTypes.PUBLIC;

        /* テスト対象の実行 */
        final String actual = testType.get();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "取得値が一致しません");

    }

    /**
     * getDefault メソッドのテスト - 正常系:デフォルト値の取得
     *
     * @since 0.2.0
     */
    @Test
    public void testGetDefault_normalDefaultValue() {

        /* 期待値の定義 */
        final KmgJavaKeywordTypes expected = KmgJavaKeywordTypes.NONE;

        /* テスト対象の実行 */
        final KmgJavaKeywordTypes actual = KmgJavaKeywordTypes.getDefault();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "デフォルト値が一致しません");

    }

    /**
     * getDetail メソッドのテスト - 正常系:詳細情報の取得
     *
     * @since 0.2.0
     */
    @Test
    public void testGetDetail_normalBasicDetail() {

        /* 期待値の定義 */
        final String expected = "全てのクラスからアクセス可能なアクセス修飾子";

        /* 準備 */
        final KmgJavaKeywordTypes testType = KmgJavaKeywordTypes.PUBLIC;

        /* テスト対象の実行 */
        final String actual = testType.getDetail();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "詳細情報が一致しません");

    }

    /**
     * getDisplayName メソッドのテスト - 正常系:表示名の取得
     *
     * @since 0.2.0
     */
    @Test
    public void testGetDisplayName_normalBasicDisplayName() {

        /* 期待値の定義 */
        final String expected = "public";

        /* 準備 */
        final KmgJavaKeywordTypes testType = KmgJavaKeywordTypes.PUBLIC;

        /* テスト対象の実行 */
        final String actual = testType.getDisplayName();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "表示名が一致しません");

    }

    /**
     * getEnum メソッドのテスト - 正常系:アクセス修飾子の取得
     *
     * @since 0.2.0
     */
    @Test
    public void testGetEnum_normalAccessModifiers() {

        /* 期待値の定義 */
        final KmgJavaKeywordTypes expectedPublic    = KmgJavaKeywordTypes.PUBLIC;
        final KmgJavaKeywordTypes expectedPrivate   = KmgJavaKeywordTypes.PRIVATE;
        final KmgJavaKeywordTypes expectedProtected = KmgJavaKeywordTypes.PROTECTED;

        /* テスト対象の実行 */
        final KmgJavaKeywordTypes actualPublic    = KmgJavaKeywordTypes.getEnum("public");
        final KmgJavaKeywordTypes actualPrivate   = KmgJavaKeywordTypes.getEnum("private");
        final KmgJavaKeywordTypes actualProtected = KmgJavaKeywordTypes.getEnum("protected");

        /* 検証の実施 */
        Assertions.assertEquals(expectedPublic, actualPublic, "publicアクセス修飾子が一致しません");
        Assertions.assertEquals(expectedPrivate, actualPrivate, "privateアクセス修飾子が一致しません");
        Assertions.assertEquals(expectedProtected, actualProtected, "protectedアクセス修飾子が一致しません");

    }

    /**
     * getEnum メソッドのテスト - 正常系:データ型の取得
     *
     * @since 0.2.0
     */
    @Test
    public void testGetEnum_normalDataTypes() {

        /* 期待値の定義 */
        final KmgJavaKeywordTypes expectedInt     = KmgJavaKeywordTypes.INT;
        final KmgJavaKeywordTypes expectedString  = KmgJavaKeywordTypes.NONE;   // stringは予約語ではない
        final KmgJavaKeywordTypes expectedBoolean = KmgJavaKeywordTypes.BOOLEAN;

        /* テスト対象の実行 */
        final KmgJavaKeywordTypes actualInt     = KmgJavaKeywordTypes.getEnum("int");
        final KmgJavaKeywordTypes actualString  = KmgJavaKeywordTypes.getEnum("string");
        final KmgJavaKeywordTypes actualBoolean = KmgJavaKeywordTypes.getEnum("boolean");

        /* 検証の実施 */
        Assertions.assertEquals(expectedInt, actualInt, "intデータ型が一致しません");
        Assertions.assertEquals(expectedString, actualString, "stringは予約語ではありません");
        Assertions.assertEquals(expectedBoolean, actualBoolean, "booleanデータ型が一致しません");

    }

    /**
     * getEnum メソッドのテスト - 正常系:存在する値の取得
     *
     * @since 0.2.0
     */
    @Test
    public void testGetEnum_normalExistingValue() {

        /* 期待値の定義 */
        final KmgJavaKeywordTypes expected = KmgJavaKeywordTypes.PUBLIC;

        /* 準備 */
        final String testValue = "public";

        /* テスト対象の実行 */
        final KmgJavaKeywordTypes actual = KmgJavaKeywordTypes.getEnum(testValue);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "値が一致しません");

    }

    /**
     * getEnum メソッドのテスト - 正常系:複数のキーワードの取得
     *
     * @since 0.2.0
     */
    @Test
    public void testGetEnum_normalMultipleKeywords() {

        /* 期待値の定義 */
        final KmgJavaKeywordTypes expectedClass     = KmgJavaKeywordTypes.CLASS;
        final KmgJavaKeywordTypes expectedInterface = KmgJavaKeywordTypes.INTERFACE;
        final KmgJavaKeywordTypes expectedEnum      = KmgJavaKeywordTypes.ENUM;

        /* テスト対象の実行 */
        final KmgJavaKeywordTypes actualClass     = KmgJavaKeywordTypes.getEnum("class");
        final KmgJavaKeywordTypes actualInterface = KmgJavaKeywordTypes.getEnum("interface");
        final KmgJavaKeywordTypes actualEnum      = KmgJavaKeywordTypes.getEnum("enum");

        /* 検証の実施 */
        Assertions.assertEquals(expectedClass, actualClass, "classキーワードが一致しません");
        Assertions.assertEquals(expectedInterface, actualInterface, "interfaceキーワードが一致しません");
        Assertions.assertEquals(expectedEnum, actualEnum, "enumキーワードが一致しません");

    }

    /**
     * getEnum メソッドのテスト - 準正常系:存在しない値の取得
     *
     * @since 0.2.0
     */
    @Test
    public void testGetEnum_semiNonExistingValue() {

        /* 期待値の定義 */
        final KmgJavaKeywordTypes expected = KmgJavaKeywordTypes.NONE;

        /* 準備 */
        final String testValue = "INVALID";

        /* テスト対象の実行 */
        final KmgJavaKeywordTypes actual = KmgJavaKeywordTypes.getEnum(testValue);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "値が一致しません");

    }

    /**
     * getEnum メソッドのテスト - 準正常系:null値の取得
     *
     * @since 0.2.0
     */
    @Test
    public void testGetEnum_semiNullValue() {

        /* 期待値の定義 */
        final KmgJavaKeywordTypes expected = KmgJavaKeywordTypes.NONE;

        /* 準備 */
        final String testValue = null;

        /* テスト対象の実行 */
        final KmgJavaKeywordTypes actual = KmgJavaKeywordTypes.getEnum(testValue);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "値が一致しません");

    }

    /**
     * getInitValue メソッドのテスト - 正常系:初期値の取得
     *
     * @since 0.2.0
     */
    @Test
    public void testGetInitValue_normalInitialValue() {

        /* 期待値の定義 */
        final KmgJavaKeywordTypes expected = KmgJavaKeywordTypes.NONE;

        /* テスト対象の実行 */
        final KmgJavaKeywordTypes actual = KmgJavaKeywordTypes.getInitValue();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "初期値が一致しません");

    }

    /**
     * getKey メソッドのテスト - 正常系:キーの取得
     *
     * @since 0.2.0
     */
    @Test
    public void testGetKey_normalBasicKey() {

        /* 期待値の定義 */
        final String expected = "public";

        /* 準備 */
        final KmgJavaKeywordTypes testType = KmgJavaKeywordTypes.PUBLIC;

        /* テスト対象の実行 */
        final String actual = testType.getKey();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "キーが一致しません");

    }

    /**
     * toString メソッドのテスト - 正常系:基本的な値の取得
     *
     * @since 0.2.0
     */
    @Test
    public void testToString_normalBasicValue() {

        /* 期待値の定義 */
        final String expected = "public";

        /* 準備 */
        final KmgJavaKeywordTypes testType = KmgJavaKeywordTypes.PUBLIC;

        /* テスト対象の実行 */
        final String actual = testType.toString();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "文字列表現が一致しません");

    }
}

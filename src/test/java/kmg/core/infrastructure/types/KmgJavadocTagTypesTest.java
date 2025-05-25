package kmg.core.infrastructure.types;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * KMG Javadocタグの種類のテスト<br>
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
public class KmgJavadocTagTypesTest {

    /**
     * デフォルトコンストラクタ<br>
     *
     * @since 0.2.0
     */
    public KmgJavadocTagTypesTest() {

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
        final String expected = "@author";

        /* 準備 */
        final KmgJavadocTagTypes testType = KmgJavadocTagTypes.AUTHOR;

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
        final KmgJavadocTagTypes expected = KmgJavadocTagTypes.NONE;

        /* テスト対象の実行 */
        final KmgJavadocTagTypes actual = KmgJavadocTagTypes.getDefault();

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
        final String expected = "クラスやインタフェースの作成者を示す";

        /* 準備 */
        final KmgJavadocTagTypes testType = KmgJavadocTagTypes.AUTHOR;

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
        final String expected = "著者";

        /* 準備 */
        final KmgJavadocTagTypes testType = KmgJavadocTagTypes.AUTHOR;

        /* テスト対象の実行 */
        final String actual = testType.getDisplayName();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "表示名が一致しません");

    }

    /**
     * getEnum メソッドのテスト - 正常系:存在する値の取得（@付き）
     *
     * @since 0.2.0
     */
    @Test
    public void testGetEnum_normalExistingValueWithAt() {

        /* 期待値の定義 */
        final KmgJavadocTagTypes expected = KmgJavadocTagTypes.AUTHOR;

        /* 準備 */
        final String testValue = "@author";

        /* テスト対象の実行 */
        final KmgJavadocTagTypes actual = KmgJavadocTagTypes.getEnum(testValue);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "値が一致しません");

    }

    /**
     * getEnum メソッドのテスト - 正常系:存在する値の取得（@なし）
     *
     * @since 0.2.0
     */
    @Test
    public void testGetEnum_normalExistingValueWithoutAt() {

        /* 期待値の定義 */
        final KmgJavadocTagTypes expected = KmgJavadocTagTypes.AUTHOR;

        /* 準備 */
        final String testValue = "author";

        /* テスト対象の実行 */
        final KmgJavadocTagTypes actual = KmgJavadocTagTypes.getEnum(testValue);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "値が一致しません");

    }

    /**
     * getEnum メソッドのテスト - 準正常系:存在しない値の取得
     *
     * @since 0.2.0
     */
    @Test
    public void testGetEnum_semiNonExistingValue() {

        /* 期待値の定義 */
        final KmgJavadocTagTypes expected = KmgJavadocTagTypes.NONE;

        /* 準備 */
        final String testValue = "INVALID";

        /* テスト対象の実行 */
        final KmgJavadocTagTypes actual = KmgJavadocTagTypes.getEnum(testValue);

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
        final KmgJavadocTagTypes expected = KmgJavadocTagTypes.NONE;

        /* 準備 */
        final String testValue = null;

        /* テスト対象の実行 */
        // createSearchKeyでNullPointerExceptionが発生することを確認
        Assertions.assertThrows(NullPointerException.class, () -> {

            KmgJavadocTagTypes.getEnum(testValue);

        }, "null値でNullPointerExceptionが発生することを確認");

    }

    /**
     * getInitValue メソッドのテスト - 正常系:初期値の取得
     *
     * @since 0.2.0
     */
    @Test
    public void testGetInitValue_normalInitialValue() {

        /* 期待値の定義 */
        final KmgJavadocTagTypes expected = KmgJavadocTagTypes.NONE;

        /* テスト対象の実行 */
        final KmgJavadocTagTypes actual = KmgJavadocTagTypes.getInitValue();

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
        final String expected = "@author";

        /* 準備 */
        final KmgJavadocTagTypes testType = KmgJavadocTagTypes.AUTHOR;

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
        final String expected = "@author";

        /* 準備 */
        final KmgJavadocTagTypes testType = KmgJavadocTagTypes.AUTHOR;

        /* テスト対象の実行 */
        final String actual = testType.toString();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "文字列表現が一致しません");

    }

    /**
     * createSearchKey メソッドのテスト - 正常系:@付きキーの処理
     *
     * @since 0.2.0
     */
    @Test
    public void testCreateSearchKey_normalWithAtPrefix() {

        /* 期待値の定義 */
        final String expected = "@author";

        /* 準備 */
        final String testKey = "@author";

        /* テスト対象の実行 */
        final String actual = KmgJavadocTagTypes.createSearchKey(testKey);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "検索キーが一致しません");

    }

    /**
     * createSearchKey メソッドのテスト - 正常系:@なしキーの処理
     *
     * @since 0.2.0
     */
    @Test
    public void testCreateSearchKey_normalWithoutAtPrefix() {

        /* 期待値の定義 */
        final String expected = "@author";

        /* 準備 */
        final String testKey = "author";

        /* テスト対象の実行 */
        final String actual = KmgJavadocTagTypes.createSearchKey(testKey);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "検索キーが一致しません");

    }

    /**
     * getLocations メソッドのテスト - 正常系:設定可能な場所のリスト取得
     *
     * @since 0.2.0
     */
    @Test
    public void testGetLocations_normalBasicLocations() {

        /* 準備 */
        final KmgJavadocTagTypes testType = KmgJavadocTagTypes.AUTHOR;

        /* テスト対象の実行 */
        final List<JavaClassificationTypes> actual = testType.getLocations();

        /* 検証の準備 */
        final boolean actualContainsClass     = actual.contains(JavaClassificationTypes.CLASS);
        final boolean actualContainsInterface = actual.contains(JavaClassificationTypes.INTERFACE);
        final boolean actualContainsEnum      = actual.contains(JavaClassificationTypes.ENUM);

        /* 検証の実施 */
        Assertions.assertNotNull(actual, "設定可能な場所のリストがnullです");
        Assertions.assertTrue(actualContainsClass, "CLASSが含まれていません");
        Assertions.assertTrue(actualContainsInterface, "INTERFACEが含まれていません");
        Assertions.assertTrue(actualContainsEnum, "ENUMが含まれていません");

    }

    /**
     * isVersionValue メソッドのテスト - 正常系:バージョン値の判定（VERSION）
     *
     * @since 0.2.0
     */
    @Test
    public void testIsVersionValue_normalVersionTag() {

        /* 期待値の定義 */
        final boolean expected = true;

        /* 準備 */
        final KmgJavadocTagTypes testType = KmgJavadocTagTypes.VERSION;

        /* テスト対象の実行 */
        final boolean actual = testType.isVersionValue();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "バージョン値の判定が一致しません");

    }

    /**
     * isVersionValue メソッドのテスト - 正常系:バージョン値の判定（SINCE）
     *
     * @since 0.2.0
     */
    @Test
    public void testIsVersionValue_normalSinceTag() {

        /* 期待値の定義 */
        final boolean expected = true;

        /* 準備 */
        final KmgJavadocTagTypes testType = KmgJavadocTagTypes.SINCE;

        /* テスト対象の実行 */
        final boolean actual = testType.isVersionValue();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "バージョン値の判定が一致しません");

    }

    /**
     * isVersionValue メソッドのテスト - 正常系:バージョン値以外の判定（AUTHOR）
     *
     * @since 0.2.0
     */
    @Test
    public void testIsVersionValue_normalNonVersionTag() {

        /* 期待値の定義 */
        final boolean expected = false;

        /* 準備 */
        final KmgJavadocTagTypes testType = KmgJavadocTagTypes.AUTHOR;

        /* テスト対象の実行 */
        final boolean actual = testType.isVersionValue();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "バージョン値の判定が一致しません");

    }

    /**
     * getEnum メソッドのテスト - 正常系:複数のタグの取得
     *
     * @since 0.2.0
     */
    @Test
    public void testGetEnum_normalMultipleTags() {

        /* 期待値の定義 */
        final KmgJavadocTagTypes expectedParam  = KmgJavadocTagTypes.PARAM;
        final KmgJavadocTagTypes expectedReturn = KmgJavadocTagTypes.RETURN;
        final KmgJavadocTagTypes expectedThrows = KmgJavadocTagTypes.THROWS;

        /* テスト対象の実行 */
        final KmgJavadocTagTypes actualParam  = KmgJavadocTagTypes.getEnum("@param");
        final KmgJavadocTagTypes actualReturn = KmgJavadocTagTypes.getEnum("@return");
        final KmgJavadocTagTypes actualThrows = KmgJavadocTagTypes.getEnum("@throws");

        /* 検証の実施 */
        Assertions.assertEquals(expectedParam, actualParam, "@paramタグが一致しません");
        Assertions.assertEquals(expectedReturn, actualReturn, "@returnタグが一致しません");
        Assertions.assertEquals(expectedThrows, actualThrows, "@throwsタグが一致しません");

    }

    /**
     * getEnum メソッドのテスト - 正常系:特殊なタグの取得
     *
     * @since 0.2.0
     */
    @Test
    public void testGetEnum_normalSpecialTags() {

        /* 期待値の定義 */
        final KmgJavadocTagTypes expectedDeprecated = KmgJavadocTagTypes.DEPRECATED;
        final KmgJavadocTagTypes expectedSee        = KmgJavadocTagTypes.SEE;
        final KmgJavadocTagTypes expectedHidden     = KmgJavadocTagTypes.HIDDEN;

        /* テスト対象の実行 */
        final KmgJavadocTagTypes actualDeprecated = KmgJavadocTagTypes.getEnum("@deprecated");
        final KmgJavadocTagTypes actualSee        = KmgJavadocTagTypes.getEnum("@see");
        final KmgJavadocTagTypes actualHidden     = KmgJavadocTagTypes.getEnum("@hidden");

        /* 検証の実施 */
        Assertions.assertEquals(expectedDeprecated, actualDeprecated, "@deprecatedタグが一致しません");
        Assertions.assertEquals(expectedSee, actualSee, "@seeタグが一致しません");
        Assertions.assertEquals(expectedHidden, actualHidden, "@hiddenタグが一致しません");

    }

    /**
     * getLocations メソッドのテスト - 正常系:メソッド専用タグの場所確認
     *
     * @since 0.2.0
     */
    @Test
    public void testGetLocations_normalMethodOnlyTag() {

        /* 準備 */
        final KmgJavadocTagTypes testType = KmgJavadocTagTypes.RETURN;

        /* テスト対象の実行 */
        final List<JavaClassificationTypes> actual = testType.getLocations();

        /* 検証の準備 */
        final boolean actualContainsMethod = actual.contains(JavaClassificationTypes.METHOD);
        final boolean actualContainsClass  = actual.contains(JavaClassificationTypes.CLASS);

        /* 検証の実施 */
        Assertions.assertNotNull(actual, "設定可能な場所のリストがnullです");
        Assertions.assertTrue(actualContainsMethod, "METHODが含まれていません");
        Assertions.assertFalse(actualContainsClass, "CLASSが含まれています（含まれるべきではありません）");

    }
}

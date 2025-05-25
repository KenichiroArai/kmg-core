package kmg.core.infrastructure.types;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import kmg.core.infrastructure.exception.KmgMsgException;

/**
 * Java区分の種類のテスト<br>
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
public class JavaClassificationTypesTest {

    /**
     * デフォルトコンストラクタ<br>
     *
     * @since 0.2.0
     */
    public JavaClassificationTypesTest() {

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
        final String expected = "class";

        /* 準備 */
        final JavaClassificationTypes testType = JavaClassificationTypes.CLASS;

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
        final JavaClassificationTypes expected = JavaClassificationTypes.NONE;

        /* テスト対象の実行 */
        final JavaClassificationTypes actual = JavaClassificationTypes.getDefault();

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
        final String expected = "クラス";

        /* 準備 */
        final JavaClassificationTypes testType = JavaClassificationTypes.CLASS;

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
        final String expected = "クラス";

        /* 準備 */
        final JavaClassificationTypes testType = JavaClassificationTypes.CLASS;

        /* テスト対象の実行 */
        final String actual = testType.getDisplayName();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "表示名が一致しません");

    }

    /**
     * getEnum メソッドのテスト - 正常系:存在する値の取得
     *
     * @since 0.2.0
     */
    @Test
    public void testGetEnum_normalExistingValue() {

        /* 期待値の定義 */
        final JavaClassificationTypes expected = JavaClassificationTypes.CLASS;

        /* 準備 */
        final String testValue = "class";

        /* テスト対象の実行 */
        final JavaClassificationTypes actual = JavaClassificationTypes.getEnum(testValue);

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
        final JavaClassificationTypes expected = JavaClassificationTypes.NONE;

        /* 準備 */
        final String testValue = "INVALID";

        /* テスト対象の実行 */
        final JavaClassificationTypes actual = JavaClassificationTypes.getEnum(testValue);

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
        final JavaClassificationTypes expected = JavaClassificationTypes.NONE;

        /* 準備 */
        final String testValue = null;

        /* テスト対象の実行 */
        final JavaClassificationTypes actual = JavaClassificationTypes.getEnum(testValue);

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
        final JavaClassificationTypes expected = JavaClassificationTypes.NONE;

        /* テスト対象の実行 */
        final JavaClassificationTypes actual = JavaClassificationTypes.getInitValue();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "初期値が一致しません");

    }

    /**
     * identify メソッドのテスト - 正常系:クラス定義の識別
     *
     * @since 0.2.0
     */
    @Test
    public void testIdentify_normalClassDefinition() {

        /* 期待値の定義 */
        final JavaClassificationTypes expected = JavaClassificationTypes.CLASS;

        /* 準備 */
        final String testText = "public class TestClass {";

        /* テスト対象の実行 */
        final JavaClassificationTypes actual = JavaClassificationTypes.identify(testText);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "識別結果が一致しません");

    }

    /**
     * identify メソッドのテスト - 正常系:インターフェース定義の識別
     *
     * @since 0.2.0
     */
    @Test
    public void testIdentify_normalInterfaceDefinition() {

        /* 期待値の定義 */
        final JavaClassificationTypes expected = JavaClassificationTypes.INTERFACE;

        /* 準備 */
        final String testText = "public interface TestInterface {";

        /* テスト対象の実行 */
        final JavaClassificationTypes actual = JavaClassificationTypes.identify(testText);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "識別結果が一致しません");

    }

    /**
     * identify メソッドのテスト - 正常系:列挙型定義の識別
     *
     * @since 0.2.0
     */
    @Test
    public void testIdentify_normalEnumDefinition() {

        /* 期待値の定義 */
        final JavaClassificationTypes expected = JavaClassificationTypes.ENUM;

        /* 準備 */
        final String testText = "public enum TestEnum {";

        /* テスト対象の実行 */
        final JavaClassificationTypes actual = JavaClassificationTypes.identify(testText);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "識別結果が一致しません");

    }

    /**
     * identify メソッドのテスト - 正常系:列挙型定数の識別
     *
     * @since 0.2.0
     */
    @Test
    public void testIdentify_normalEnumConstDefinition() {

        /* 期待値の定義 */
        final JavaClassificationTypes expected = JavaClassificationTypes.ENUM_CONST;

        /* 準備 */
        final String testText = "    TEST_CONST(\"テスト定数\", \"test\"),";

        /* テスト対象の実行 */
        final JavaClassificationTypes actual = JavaClassificationTypes.identify(testText);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "識別結果が一致しません");

    }

    /**
     * identify メソッドのテスト - 正常系:アノテーション定義の識別
     *
     * @since 0.2.0
     */
    @Test
    public void testIdentify_normalAnnotationDefinition() {

        /* 期待値の定義 */
        final JavaClassificationTypes expected = JavaClassificationTypes.ANNOTATION_DEFINITION;

        /* 準備 */
        final String testText = "public @interface TestAnnotation {";

        /* テスト対象の実行 */
        final JavaClassificationTypes actual = JavaClassificationTypes.identify(testText);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "識別結果が一致しません");

    }

    /**
     * identify メソッドのテスト - 正常系:アノテーション使用の識別
     *
     * @since 0.2.0
     */
    @Test
    public void testIdentify_normalAnnotationUsage() {

        /* 期待値の定義 */
        final JavaClassificationTypes expected = JavaClassificationTypes.ANNOTATION_USAGE;

        /* 準備 */
        final String testText = "@Test";

        /* テスト対象の実行 */
        final JavaClassificationTypes actual = JavaClassificationTypes.identify(testText);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "識別結果が一致しません");

    }

    /**
     * identify メソッドのテスト - 正常系:フィールド定義の識別
     *
     * @since 0.2.0
     */
    @Test
    public void testIdentify_normalFieldDefinition() {

        /* 期待値の定義 */
        final JavaClassificationTypes expected = JavaClassificationTypes.FIELD;

        /* 準備 */
        final String testText = "    private String testField;";

        /* テスト対象の実行 */
        final JavaClassificationTypes actual = JavaClassificationTypes.identify(testText);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "識別結果が一致しません");

    }

    /**
     * identify メソッドのテスト - 正常系:メソッド定義の識別
     *
     * @since 0.2.0
     */
    @Test
    public void testIdentify_normalMethodDefinition() {

        /* 期待値の定義 */
        final JavaClassificationTypes expected = JavaClassificationTypes.METHOD;

        /* 準備 */
        final String testText = "    public String testMethod() {";

        /* テスト対象の実行 */
        final JavaClassificationTypes actual = JavaClassificationTypes.identify(testText);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "識別結果が一致しません");

    }

    /**
     * identify メソッドのテスト - 正常系:コンストラクタ定義の識別
     *
     * @since 0.2.0
     */
    @Test
    public void testIdentify_normalConstructorDefinition() {

        /* 期待値の定義 */
        final JavaClassificationTypes expected = JavaClassificationTypes.METHOD;

        /* 準備 */
        final String testText = "public TestClass() {";

        /* テスト対象の実行 */
        final JavaClassificationTypes actual = JavaClassificationTypes.identify(testText);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "識別結果が一致しません");

    }

    /**
     * identify メソッドのテスト - 正常系:モジュール定義の識別
     *
     * @since 0.2.0
     */
    @Test
    public void testIdentify_normalModuleDefinition() {

        /* 期待値の定義 */
        final JavaClassificationTypes expected = JavaClassificationTypes.MODULE;

        /* 準備 */
        final String testText = "module testmodule {";

        /* テスト対象の実行 */
        final JavaClassificationTypes actual = JavaClassificationTypes.identify(testText);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "識別結果が一致しません");

    }

    /**
     * identify メソッドのテスト - 準正常系:空文字列の識別
     *
     * @since 0.2.0
     */
    @Test
    public void testIdentify_semiEmptyString() {

        /* 期待値の定義 */
        final JavaClassificationTypes expected = JavaClassificationTypes.NONE;

        /* 準備 */
        final String testText = "";

        /* テスト対象の実行 */
        final JavaClassificationTypes actual = JavaClassificationTypes.identify(testText);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "識別結果が一致しません");

    }

    /**
     * identify メソッドのテスト - 準正常系:null文字列の識別
     *
     * @since 0.2.0
     */
    @Test
    public void testIdentify_semiNullString() {

        /* 期待値の定義 */
        final JavaClassificationTypes expected = JavaClassificationTypes.NONE;

        /* 準備 */
        final String testText = null;

        /* テスト対象の実行 */
        final JavaClassificationTypes actual = JavaClassificationTypes.identify(testText);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "識別結果が一致しません");

    }

    /**
     * identify メソッドのテスト - 準正常系:マッチしない文字列の識別
     *
     * @since 0.2.0
     */
    @Test
    public void testIdentify_semiNoMatchString() {

        /* 期待値の定義 */
        final JavaClassificationTypes expected = JavaClassificationTypes.NONE;

        /* 準備 */
        final String testText = "// コメント";

        /* テスト対象の実行 */
        final JavaClassificationTypes actual = JavaClassificationTypes.identify(testText);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "識別結果が一致しません");

    }

    /**
     * getClassificationPattern メソッドのテスト - 正常系:区分判定パターンの取得
     *
     * @since 0.2.0
     */
    @Test
    public void testGetClassificationPattern_normalBasicPattern() {

        /* 期待値の定義 */
        final String expected
            = "^\\s*(?:(?:public|private|protected|abstract|final)\\s+)*class\\s+(?<elementName>\\w+)";

        /* 準備 */
        final JavaClassificationTypes testType = JavaClassificationTypes.CLASS;

        /* テスト対象の実行 */
        final String actual = testType.getClassificationPattern();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "区分判定パターンが一致しません");

    }

    /**
     * getClassificationPattern メソッドのテスト - 正常系:NONEの区分判定パターンの取得
     *
     * @since 0.2.0
     */
    @Test
    public void testGetClassificationPattern_normalNonePattern() {

        /* 期待値の定義 */
        final String expected = null;

        /* 準備 */
        final JavaClassificationTypes testType = JavaClassificationTypes.NONE;

        /* テスト対象の実行 */
        final String actual = testType.getClassificationPattern();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "区分判定パターンが一致しません");

    }

    /**
     * getElementName メソッドのテスト - 正常系:クラス名の取得
     *
     * @since 0.2.0
     *
     * @throws KmgMsgException
     *                         KMGメッセージ例外
     */
    @Test
    public void testGetElementName_normalClassName() throws KmgMsgException {

        /* 期待値の定義 */
        final String expected = "TestClass";

        /* 準備 */
        final JavaClassificationTypes testType = JavaClassificationTypes.CLASS;
        final String                  testText = "public class TestClass {";

        /* テスト対象の実行 */
        final String actual = testType.getElementName(testText);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "要素名が一致しません");

    }

    /**
     * getElementName メソッドのテスト - 正常系:インターフェース名の取得
     *
     * @since 0.2.0
     *
     * @throws KmgMsgException
     *                         KMGメッセージ例外
     */
    @Test
    public void testGetElementName_normalInterfaceName() throws KmgMsgException {

        /* 期待値の定義 */
        final String expected = "TestInterface";

        /* 準備 */
        final JavaClassificationTypes testType = JavaClassificationTypes.INTERFACE;
        final String                  testText = "public interface TestInterface {";

        /* テスト対象の実行 */
        final String actual = testType.getElementName(testText);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "要素名が一致しません");

    }

    /**
     * getElementName メソッドのテスト - 正常系:メソッド名の取得
     *
     * @since 0.2.0
     *
     * @throws KmgMsgException
     *                         KMGメッセージ例外
     */
    @Test
    public void testGetElementName_normalMethodName() throws KmgMsgException {

        /* 期待値の定義 */
        final String expected = "testMethod";

        /* 準備 */
        final JavaClassificationTypes testType = JavaClassificationTypes.METHOD;
        final String                  testText = "    public String testMethod() {";

        /* テスト対象の実行 */
        final String actual = testType.getElementName(testText);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "要素名が一致しません");

    }

    /**
     * getElementName メソッドのテスト - 準正常系:空文字列の要素名取得
     *
     * @since 0.2.0
     *
     * @throws KmgMsgException
     *                         KMGメッセージ例外
     */
    @Test
    public void testGetElementName_semiEmptyString() throws KmgMsgException {

        /* 期待値の定義 */
        final String expected = "";

        /* 準備 */
        final JavaClassificationTypes testType = JavaClassificationTypes.CLASS;
        final String                  testText = "";

        /* テスト対象の実行 */
        final String actual = testType.getElementName(testText);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "要素名が一致しません");

    }

    /**
     * getElementName メソッドのテスト - 準正常系:null文字列の要素名取得
     *
     * @since 0.2.0
     *
     * @throws KmgMsgException
     *                         KMGメッセージ例外
     */
    @Test
    public void testGetElementName_semiNullString() throws KmgMsgException {

        /* 期待値の定義 */
        final String expected = "";

        /* 準備 */
        final JavaClassificationTypes testType = JavaClassificationTypes.CLASS;
        final String                  testText = null;

        /* テスト対象の実行 */
        final String actual = testType.getElementName(testText);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "要素名が一致しません");

    }

    /**
     * getElementName メソッドのテスト - 準正常系:NONEタイプの要素名取得
     *
     * @since 0.2.0
     *
     * @throws KmgMsgException
     *                         KMGメッセージ例外
     */
    @Test
    public void testGetElementName_semiNoneType() throws KmgMsgException {

        /* 期待値の定義 */
        final String expected = "";

        /* 準備 */
        final JavaClassificationTypes testType = JavaClassificationTypes.NONE;
        final String                  testText = "public class TestClass {";

        /* テスト対象の実行 */
        final String actual = testType.getElementName(testText);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "要素名が一致しません");

    }

    /**
     * getElementName メソッドのテスト - 準正常系:マッチしない文字列の要素名取得
     *
     * @since 0.2.0
     *
     * @throws KmgMsgException
     *                         KMGメッセージ例外
     */
    @Test
    public void testGetElementName_semiNoMatchString() throws KmgMsgException {

        /* 期待値の定義 */
        final String expected = "";

        /* 準備 */
        final JavaClassificationTypes testType = JavaClassificationTypes.CLASS;
        final String                  testText = "// コメント";

        /* テスト対象の実行 */
        final String actual = testType.getElementName(testText);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "要素名が一致しません");

    }

    /**
     * getKey メソッドのテスト - 正常系:キーの取得
     *
     * @since 0.2.0
     */
    @Test
    public void testGetKey_normalBasicKey() {

        /* 期待値の定義 */
        final String expected = "class";

        /* 準備 */
        final JavaClassificationTypes testType = JavaClassificationTypes.CLASS;

        /* テスト対象の実行 */
        final String actual = testType.getKey();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "キーが一致しません");

    }

    /**
     * isJavadocTarget メソッドのテスト - 正常系:Javadoc対象の区分
     *
     * @since 0.2.0
     */
    @Test
    public void testIsJavadocTarget_normalJavadocTarget() {

        /* 期待値の定義 */
        final boolean expected = true;

        /* 準備 */
        final JavaClassificationTypes testType = JavaClassificationTypes.CLASS;

        /* テスト対象の実行 */
        final boolean actual = testType.isJavadocTarget();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "Javadoc対象判定が一致しません");

    }

    /**
     * isJavadocTarget メソッドのテスト - 正常系:Javadoc対象外の区分
     *
     * @since 0.2.0
     */
    @Test
    public void testIsJavadocTarget_normalNotJavadocTarget() {

        /* 期待値の定義 */
        final boolean expected = false;

        /* 準備 */
        final JavaClassificationTypes testType = JavaClassificationTypes.NONE;

        /* テスト対象の実行 */
        final boolean actual = testType.isJavadocTarget();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "Javadoc対象判定が一致しません");

    }

    /**
     * isNotJavadocTarget メソッドのテスト - 正常系:Javadoc対象外の区分
     *
     * @since 0.2.0
     */
    @Test
    public void testIsNotJavadocTarget_normalNotJavadocTarget() {

        /* 期待値の定義 */
        final boolean expected = true;

        /* 準備 */
        final JavaClassificationTypes testType = JavaClassificationTypes.NONE;

        /* テスト対象の実行 */
        final boolean actual = testType.isNotJavadocTarget();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "Javadoc対象外判定が一致しません");

    }

    /**
     * isNotJavadocTarget メソッドのテスト - 正常系:Javadoc対象の区分
     *
     * @since 0.2.0
     */
    @Test
    public void testIsNotJavadocTarget_normalJavadocTarget() {

        /* 期待値の定義 */
        final boolean expected = false;

        /* 準備 */
        final JavaClassificationTypes testType = JavaClassificationTypes.CLASS;

        /* テスト対象の実行 */
        final boolean actual = testType.isNotJavadocTarget();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "Javadoc対象外判定が一致しません");

    }

    /**
     * toString メソッドのテスト - 正常系:文字列表現の取得
     *
     * @since 0.2.0
     */
    @Test
    public void testToString_normalBasicValue() {

        /* 期待値の定義 */
        final String expected = "class";

        /* 準備 */
        final JavaClassificationTypes testType = JavaClassificationTypes.CLASS;

        /* テスト対象の実行 */
        final String actual = testType.toString();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "文字列表現が一致しません");

    }

}

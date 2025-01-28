package kmg.core.domain.model.impl;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import kmg.core.infrastructure.exception.KmgDomainException;

/**
 * KMGリフレクションモデル実装のテスト<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
public class KmgReflectionModelImplTest {

    /**
     * テスト用のクラス<br>
     */
    @SuppressWarnings("unused")
    private static class TestClass {

        /** パブリックフィールド */
        public String publicField;

        /** プライベートフィールド */
        private String privateField;

        /** BigDecimalフィールド */
        private BigDecimal decimalField;

        /**
         * プライベートフィールドを取得する<br>
         *
         * @return プライベートフィールド
         */
        public String getPrivateField() {

            final String result = this.privateField;

            return result;

        }

        /**
         * プライベートフィールドを設定する<br>
         *
         * @param privateField
         *                     プライベートフィールド
         */
        public void setPrivateField(final String privateField) {

            this.privateField = privateField;

        }

        /**
         * テストメソッド<br>
         *
         * @param param
         *              パラメータ
         * @return パラメータに「Test」を追加した文字列
         */
        @SuppressWarnings("static-method")
        public String testMethod(final String param) {

            final String result = param + "Test";

            return result;

        }
    }

    /**
     * getLastGetField メソッドのテスト - フィールド取得前<br>
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGetLastGetField_beforeGetField() throws KmgDomainException {

        /* 期待値の定義 */

        /* 準備 */
        final TestClass              testObject     = new TestClass();
        final KmgReflectionModelImpl testReflection = new KmgReflectionModelImpl(testObject);

        /* テスト対象の実行 */
        final Object testResult = testReflection.getLastGetField();

        /* 検証の準備 */
        final Object actualResult = testResult;

        /* 検証の実施 */
        Assertions.assertNull(actualResult, "最後に取得したフィールドがnullであること");

    }

    /**
     * set メソッドのテスト - パブリックフィールドに値を設定<br>
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
    @SuppressWarnings("static-method")
    public void testSet_publicField() throws KmgDomainException {

        /* 期待値の定義 */
        final String expectedValue = "test value";

        /* 準備 */
        final TestClass              testObject     = new TestClass();
        final KmgReflectionModelImpl testReflection = new KmgReflectionModelImpl(testObject);

        /* テスト対象の実行 */
        testReflection.set("publicField", expectedValue);

        /* 検証の準備 */
        final String actualValue = testObject.publicField;

        /* 検証の実施 */
        Assertions.assertEquals(expectedValue, actualValue, "パブリックフィールドに値が設定されていること");

    }

    /**
     * set メソッドのテスト - プライベートフィールドに値を設定<br>
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
    @SuppressWarnings("static-method")
    public void testSet_privateField() throws KmgDomainException {

        /* 期待値の定義 */
        final String expectedValue = "test value";

        /* 準備 */
        final TestClass              testObject     = new TestClass();
        final KmgReflectionModelImpl testReflection = new KmgReflectionModelImpl(testObject);

        /* テスト対象の実行 */
        testReflection.set("privateField", expectedValue);

        /* 検証の準備 */
        final String actualValue = testObject.getPrivateField();

        /* 検証の実施 */
        Assertions.assertEquals(expectedValue, actualValue, "プライベートフィールドに値が設定されていること");

    }

    /**
     * set メソッドのテスト - BigDecimalフィールドに文字列を設定<br>
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
    @SuppressWarnings("static-method")
    public void testSet_bigDecimalField() throws KmgDomainException {

        /* 期待値の定義 */
        final BigDecimal expectedValue = new BigDecimal("123.45");

        /* 準備 */
        final TestClass              testObject     = new TestClass();
        final KmgReflectionModelImpl testReflection = new KmgReflectionModelImpl(testObject);

        /* テスト対象の実行 */
        testReflection.set("decimalField", "123.45");

        /* 検証の準備 */
        final Object actualValue = testReflection.get("decimalField");

        /* 検証の実施 */
        Assertions.assertEquals(expectedValue, actualValue, "BigDecimalフィールドに値が設定されていること");

    }

    /**
     * get メソッドのテスト - パブリックフィールドの値を取得<br>
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGet_publicField() throws KmgDomainException {

        /* 期待値の定義 */
        final String expectedValue = "test value";

        /* 準備 */
        final TestClass testObject = new TestClass();
        testObject.publicField = expectedValue;
        final KmgReflectionModelImpl testReflection = new KmgReflectionModelImpl(testObject);

        /* テスト対象の実行 */
        final Object testResult = testReflection.get("publicField");

        /* 検証の準備 */
        final String actualValue = (String) testResult;

        /* 検証の実施 */
        Assertions.assertEquals(expectedValue, actualValue, "パブリックフィールドから値が取得できること");

    }

    /**
     * getMethodInvoke メソッドのテスト - メソッドを呼び出し<br>
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGetMethodInvoke_withParameters() throws KmgDomainException {

        /* 期待値の定義 */
        final String expectedValue = "HelloTest";

        /* 準備 */
        final TestClass              testObject     = new TestClass();
        final KmgReflectionModelImpl testReflection = new KmgReflectionModelImpl(testObject);

        /* テスト対象の実行 */
        final Object testResult = testReflection.getMethodInvoke("testMethod", "Hello");

        /* 検証の準備 */
        final String actualValue = (String) testResult;

        /* 検証の実施 */
        Assertions.assertEquals(expectedValue, actualValue, "メソッドが正しく呼び出され、結果が返されること");

    }

    /**
     * getMethodInvoke メソッドのテスト - パラメータタイプを指定してメソッドを呼び出し<br>
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGetMethodInvoke_withParameterTypes() throws KmgDomainException {

        /* 期待値の定義 */
        final String expectedValue = "HelloTest";

        /* 準備 */
        final TestClass              testObject     = new TestClass();
        final KmgReflectionModelImpl testReflection = new KmgReflectionModelImpl(testObject);
        final Class<?>[]             parameterTypes = {
                String.class
        };

        /* テスト対象の実行 */
        final Object testResult = testReflection.getMethodInvoke("testMethod", parameterTypes, "Hello");

        /* 検証の準備 */
        final String actualValue = (String) testResult;

        /* 検証の実施 */
        Assertions.assertEquals(expectedValue, actualValue, "メソッドが正しく呼び出され、結果が返されること");

    }
}

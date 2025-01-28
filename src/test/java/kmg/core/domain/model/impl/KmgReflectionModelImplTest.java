package kmg.core.domain.model.impl;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import kmg.core.infrastructure.exception.KmgDomainException;
import kmg.core.infrastructure.type.KmgString;

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

            final String result = KmgString.concat(param, "Test");

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
     * get メソッドのテスト - プライベートフィールドの値を取得<br>
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGet_privateField() throws KmgDomainException {

        /* 期待値の定義 */
        final String expectedValue = "test value";

        /* 準備 */
        final TestClass testObject = new TestClass();
        testObject.setPrivateField(expectedValue);
        final KmgReflectionModelImpl testReflection = new KmgReflectionModelImpl(testObject);

        /* テスト対象の実行 */
        final Object testResult = testReflection.get("privateField");

        /* 検証の準備 */
        final String actualValue = (String) testResult;

        /* 検証の実施 */
        Assertions.assertEquals(expectedValue, actualValue, "プライベートフィールドから値が取得できること");

    }

    /**
     * get メソッドのテスト - nullフィールド名を指定<br>
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGet_nullFieldName() throws KmgDomainException {

        /* 準備 */
        final TestClass              testObject     = new TestClass();
        final KmgReflectionModelImpl testReflection = new KmgReflectionModelImpl(testObject);

        /* テスト対象の実行 */
        final Object actualValue = testReflection.get(null);

        /* 検証の実施 */
        Assertions.assertNull(actualValue, "nullフィールド名を指定した場合、nullが返されること");

    }

    /**
     * get メソッドのテスト - BigDecimalフィールドの値を取得<br>
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGet_bigDecimalField() throws KmgDomainException {

        /* 期待値の定義 */
        final BigDecimal expectedValue = new BigDecimal("123.45");

        /* 準備 */
        final TestClass              testObject     = new TestClass();
        final KmgReflectionModelImpl testReflection = new KmgReflectionModelImpl(testObject);
        testReflection.set("decimalField", expectedValue);

        /* テスト対象の実行 */
        final Object testResult = testReflection.get("decimalField");

        /* 検証の準備 */
        final BigDecimal actualValue = (BigDecimal) testResult;

        /* 検証の実施 */
        Assertions.assertEquals(expectedValue, actualValue, "BigDecimalフィールドから値が正しく取得できること");

    }

    /**
     * get メソッドのテスト - 存在しないフィールドへのアクセス<br>
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGet_nonExistentField() throws KmgDomainException {

        /* 期待値の定義 */
        final String expectedValue = null;

        /* 準備 */
        final TestClass              testObject     = new TestClass();
        final KmgReflectionModelImpl testReflection = new KmgReflectionModelImpl(testObject);

        /* テスト対象の実行 */
        final String actualValue = (String) testReflection.get("nonExistentField");

        /* 検証の実施 */
        Assertions.assertEquals(expectedValue, actualValue, "存在しないフィールドへのアクセスでnullが返されること");

    }

    /**
     * set メソッドのテスト - 存在しないフィールドへの設定<br>
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
    @SuppressWarnings("static-method")
    public void testSet_nonExistentField() throws KmgDomainException {

        /* 準備 */
        final TestClass              testObject     = new TestClass();
        final KmgReflectionModelImpl testReflection = new KmgReflectionModelImpl(testObject);

        /* テスト対象の実行 */
        testReflection.set("nonExistentField", "value");

        /* 検証の準備 */
        final String     actuaPublicField   = testObject.publicField;
        final String     actualPrivateField = testObject.privateField;
        final BigDecimal actualDecimalField = testObject.decimalField;

        /* 検証の実施 */
        Assertions.assertNull(actuaPublicField, "パブリックフィールドがnullであること");
        Assertions.assertNull(actualPrivateField, "プライベートフィールドがnullであること");
        Assertions.assertNull(actualDecimalField, "BigDecimalフィールドがnullであること");

    }

    /**
     * getMethodInvoke メソッドのテスト - 存在しないメソッドの呼び出し<br>
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGetMethodInvoke_nonExistentMethod() throws KmgDomainException {

        /* 期待値の定義 */
        final String expectedValue = null;

        /* 準備 */
        final TestClass              testObject     = new TestClass();
        final KmgReflectionModelImpl testReflection = new KmgReflectionModelImpl(testObject);

        /* テスト対象の実行 */
        final String actualValue = (String) testReflection.getMethodInvoke("nonExistentMethod", "param");

        /* 検証の実施 */
        Assertions.assertEquals(expectedValue, actualValue, "存在しないメソッドの呼び出しでnullが返されること");

    }

    /**
     * set メソッドのテスト - 型変換エラー<br>
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
    @SuppressWarnings("static-method")
    public void testSet_typeConversionError() throws KmgDomainException {

        /* 準備 */
        final TestClass              testObject     = new TestClass();
        final KmgReflectionModelImpl testReflection = new KmgReflectionModelImpl(testObject);

        /* 検証の実施 */
        testReflection.set("decimalField", "invalid number");

        /* 検証の準備 */
        final String     actuaPublicField   = testObject.publicField;
        final String     actualPrivateField = testObject.privateField;
        final BigDecimal actualDecimalField = testObject.decimalField;

        /* 検証の実施 */
        Assertions.assertNull(actuaPublicField, "パブリックフィールドがnullであること");
        Assertions.assertNull(actualPrivateField, "プライベートフィールドがnullであること");
        Assertions.assertNull(actualDecimalField, "BigDecimalフィールドがnullであること");

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

    /**
     * get メソッドのテスト - 連続呼び出し時のlastGetFieldの状態確認<br>
     *
     * @throws KmgDomainException
     *                                  KMGドメイン例外
     * @throws IllegalAccessException
     *                                  イリーガルアクセス例外
     * @throws IllegalArgumentException
     *                                  引数例外
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGet_consecutiveCalls() throws KmgDomainException, IllegalArgumentException, IllegalAccessException {

        /* 準備 */
        final TestClass testObject = new TestClass();
        testObject.publicField = "test1";
        testObject.setPrivateField("test2");
        final KmgReflectionModelImpl testReflection = new KmgReflectionModelImpl(testObject);

        /* テスト対象の実行と検証 */
        // 1回目の呼び出し
        final Object firstResult = testReflection.get("publicField");
        Assertions.assertEquals("test1", firstResult, "1回目のget呼び出しで正しい値が取得できること");
        Assertions.assertEquals("test1", testReflection.getLastGetField().get(testObject),
                "1回目のget呼び出し後のlastGetFieldが正しいこと");

        // 2回目の呼び出し
        final Object secondResult = testReflection.get("privateField");
        Assertions.assertEquals("test2", secondResult, "2回目のget呼び出しで正しい値が取得できること");
        Assertions.assertEquals("test2", testReflection.getLastGetField().get(testObject),
                "2回目のget呼び出し後のlastGetFieldが更新されていること");

        // 存在しないフィールドの呼び出し
        final Object thirdResult = testReflection.get("nonExistentField");
        Assertions.assertNull(thirdResult, "存在しないフィールドの呼び出しでnullが返されること");
        Assertions.assertNull(testReflection.getLastGetField(), "存在しないフィールドの呼び出し後のlastGetFieldがnullになること");

    }
}

package kmg.core.domain.model.impl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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

    /**
     * get メソッドのテスト - getValue呼び出し時のIllegalAccessException<br>
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGet_getValueIllegalAccessException() throws KmgDomainException {

        /* 期待値の定義 */
        final String expectedMessage = "Test illegal access exception from getValue";

        /* 準備 */
        final TestClass testObject = new TestClass();

        final KmgReflectionModelImpl testReflection = new KmgReflectionModelImpl(testObject) {

            @Override
            protected Object getValue(final Field field, final Object targetObject)
                throws SecurityException, IllegalAccessException {

                throw new IllegalAccessException(expectedMessage);

            }
        };

        /* テスト対象の実行 */
        final KmgDomainException actualException
            = Assertions.assertThrows(KmgDomainException.class, () -> testReflection.get("publicField"));

        /* 検証の準備 */
        final Throwable actualCause   = actualException.getCause();
        final String    actualMessage = actualCause.getMessage();

        /* 検証の実施 */
        Assertions.assertTrue(actualCause instanceof IllegalAccessException,
            "KmgDomainExceptionの原因がIllegalAccessExceptionであること");
        Assertions.assertEquals(expectedMessage, actualMessage, "IllegalAccessExceptionのメッセージが正しいこと");

    }

    /**
     * get メソッドのテスト - getValue呼び出し時のSecurityException<br>
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGet_getValueSecurityException() throws KmgDomainException {

        /* 期待値の定義 */
        final String expectedMessage = "Test security exception from getValue";

        /* 準備 */
        final TestClass testObject = new TestClass();

        final KmgReflectionModelImpl testReflection = new KmgReflectionModelImpl(testObject) {

            @Override
            protected Object getValue(final Field field, final Object targetObject)
                throws SecurityException, IllegalAccessException {

                throw new SecurityException(expectedMessage);

            }
        };

        /* テスト対象の実行 */
        final KmgDomainException actualException
            = Assertions.assertThrows(KmgDomainException.class, () -> testReflection.get("publicField"));

        /* 検証の準備 */
        final Throwable actualCause   = actualException.getCause();
        final String    actualMessage = actualCause.getMessage();

        /* 検証の実施 */
        Assertions.assertTrue(actualCause instanceof SecurityException, "KmgDomainExceptionの原因がSecurityExceptionであること");
        Assertions.assertEquals(expectedMessage, actualMessage, "SecurityExceptionのメッセージが正しいこと");

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
     * get メソッドのテスト - SecurityException発生時<br>
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGet_securityException() throws KmgDomainException {

        /* 期待値の定義 */
        final String expectedMessage = "Test security exception";

        /* 準備 */
        final TestClass testObject = new TestClass();

        final KmgReflectionModelImpl testReflection = new KmgReflectionModelImpl(testObject) {

            @Override
            protected Field getField(final Class<?> targetClazz, final String name)
                throws NoSuchFieldException, SecurityException {

                throw new SecurityException(expectedMessage);

            }
        };

        /* テスト対象の実行 */
        final KmgDomainException actualException
            = Assertions.assertThrows(KmgDomainException.class, () -> testReflection.get("publicField"));

        /* 検証の準備 */
        final Throwable actualCause   = actualException.getCause();
        final String    actualMessage = actualCause.getMessage();

        /* 検証の実施 */
        Assertions.assertTrue(actualCause instanceof SecurityException, "KmgDomainExceptionの原因がSecurityExceptionであること");
        Assertions.assertEquals(expectedMessage, actualMessage, "SecurityExceptionのメッセージが正しいこと");

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
     * getMethod メソッドのテスト - IllegalAccessException発生時<br>
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGetMethod_illegalAccessException() throws KmgDomainException {

        /* 期待値の定義 */
        final String expectedMessage = "Test illegal access exception";

        /* 準備 */
        final TestClass testObject = new TestClass();

        final KmgReflectionModelImpl testReflection = new KmgReflectionModelImpl(testObject) {

            @Override
            protected Object invoke(final Method method, final Object targetObject, final Object... parameters)
                throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {

                throw new IllegalAccessException(expectedMessage);

            }
        };

        /* テスト対象の実行 */
        final KmgDomainException actualException
            = Assertions.assertThrows(KmgDomainException.class, () -> testReflection.getMethod("testMethod", "Hello"));

        /* 検証の準備 */
        final Throwable actualCause   = actualException.getCause();
        final String    actualMessage = actualCause.getMessage();

        /* 検証の実施 */
        Assertions.assertTrue(actualCause instanceof IllegalAccessException,
            "KmgDomainExceptionの原因がIllegalAccessExceptionであること");
        Assertions.assertEquals(expectedMessage, actualMessage, "IllegalAccessExceptionのメッセージが正しいこと");

    }

    /**
     * getMethod メソッドのテスト - 存在しないメソッドへのアクセス<br>
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGetMethod_nonExistentMethod() throws KmgDomainException {

        /* 期待値の定義 */
        final Object expectedValue = null;

        /* 準備 */
        final TestClass              testObject     = new TestClass();
        final KmgReflectionModelImpl testReflection = new KmgReflectionModelImpl(testObject);

        /* テスト対象の実行 */
        final Object testResult = testReflection.getMethod("nonExistentMethod", "param");

        /* 検証の準備 */
        final Object actualValue = testResult;

        /* 検証の実施 */
        Assertions.assertEquals(expectedValue, actualValue, "存在しないメソッドへのアクセスでnullが返されること");

    }

    /**
     * getMethod メソッドのテスト - メソッド名がnullの場合<br>
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGetMethod_nullMethodName() throws KmgDomainException {

        /* 期待値の定義 */
        final Object expectedValue = null;

        /* 準備 */
        final TestClass              testObject     = new TestClass();
        final KmgReflectionModelImpl testReflection = new KmgReflectionModelImpl(testObject);

        /* テスト対象の実行 */
        final Object testResult = testReflection.getMethod(null, "Hello");

        /* 検証の準備 */
        final Object actualValue = testResult;

        /* 検証の実施 */
        Assertions.assertEquals(expectedValue, actualValue, "メソッド名がnullの場合、nullが返されること");

    }

    /**
     * getMethod メソッドのテスト - privateメソッドへのアクセス<br>
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGetMethod_privateMethod() throws KmgDomainException {

        /* 期待値の定義 */
        final String expectedValue = "PrivateTest";

        /* 準備 */
        final TestClass testObject = new TestClass() {

            @SuppressWarnings("unused")
            private String privateTestMethod(final String param) {

                final String result = KmgString.concat(param, "Test");

                return result;

            }
        };

        final KmgReflectionModelImpl testReflection = new KmgReflectionModelImpl(testObject);

        /* テスト対象の実行 */
        final Object testResult = testReflection.getMethod("privateTestMethod", "Private");

        /* 検証の準備 */
        final String actualValue = (String) testResult;

        /* 検証の実施 */
        Assertions.assertEquals(expectedValue, actualValue, "privateメソッドが正しく呼び出され、結果が返されること");

    }

    /**
     * getMethod メソッドのテスト - SecurityException発生時<br>
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGetMethod_securityException() throws KmgDomainException {

        /* 期待値の定義 */
        final String expectedMessage = "Test security exception";

        /* 準備 */
        final TestClass testObject = new TestClass();

        final KmgReflectionModelImpl testReflection = new KmgReflectionModelImpl(testObject) {

            @Override
            protected Method getMethod(final Class<?> targetClazz, final String name, final Class<?>[] parameterTypes)
                throws NoSuchMethodException, SecurityException {

                throw new SecurityException(expectedMessage);

            }
        };

        /* テスト対象の実行 */
        final KmgDomainException actualException
            = Assertions.assertThrows(KmgDomainException.class, () -> testReflection.getMethod("testMethod", "Hello"));

        /* 検証の準備 */
        final Throwable actualCause   = actualException.getCause();
        final String    actualMessage = actualCause.getMessage();

        /* 検証の実施 */
        Assertions.assertTrue(actualCause instanceof SecurityException, "KmgDomainExceptionの原因がSecurityExceptionであること");
        Assertions.assertEquals(expectedMessage, actualMessage, "SecurityExceptionのメッセージが正しいこと");

    }

    /**
     * getMethod メソッドのテスト - 正常系（パラメータありのメソッド呼び出し）<br>
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGetMethod_withParameters() throws KmgDomainException {

        /* 期待値の定義 */
        final String expectedValue = "HelloTest";

        /* 準備 */
        final TestClass              testObject     = new TestClass();
        final KmgReflectionModelImpl testReflection = new KmgReflectionModelImpl(testObject);

        /* テスト対象の実行 */
        final Object testResult = testReflection.getMethod("testMethod", "Hello");

        /* 検証の準備 */
        final String actualValue = (String) testResult;

        /* 検証の実施 */
        Assertions.assertEquals(expectedValue, actualValue, "メソッドが正しく呼び出され、結果が返されること");

    }

    /**
     * getMethodInvoke メソッドのテスト - getDeclaredMethodで取得できる場合<br>
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGetMethodInvoke_getDeclaredMethod() throws KmgDomainException {

        /* 期待値の定義 */
        final String expectedValue = "PrivateTest";

        /* 準備 */
        final TestClass testObject = new TestClass() {

            @SuppressWarnings("unused")
            private String privateTestMethod(final String param) {

                final String result = KmgString.concat(param, "Test");

                return result;

            }
        };

        final KmgReflectionModelImpl testReflection = new KmgReflectionModelImpl(testObject);
        final Class<?>[]             parameterTypes = {
            String.class
        };

        /* テスト対象の実行 */
        final Object testResult = testReflection.getMethodInvoke("privateTestMethod", parameterTypes, "Private");

        /* 検証の準備 */
        final String actualValue = (String) testResult;

        /* 検証の実施 */
        Assertions.assertEquals(expectedValue, actualValue, "getDeclaredMethodで取得したprivateメソッドが正しく呼び出されること");

    }

    /**
     * getMethodInvoke メソッドのテスト - IllegalArgumentException発生時<br>
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGetMethodInvoke_illegalArgumentException() throws KmgDomainException {

        /* 期待値の定義 */
        final String expectedMessage = "Test illegal argument exception";

        /* 準備 */
        final TestClass testObject = new TestClass();

        final KmgReflectionModelImpl testReflection = new KmgReflectionModelImpl(testObject) {

            @Override
            protected Object invoke(final Method method, final Object targetObject, final Object... parameters)
                throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {

                throw new IllegalArgumentException(expectedMessage);

            }
        };

        /* テスト対象の実行 */
        final KmgDomainException actualException = Assertions.assertThrows(KmgDomainException.class,
            () -> testReflection.getMethodInvoke("testMethod", "Hello"));

        /* 検証の準備 */
        final Throwable actualCause   = actualException.getCause();
        final String    actualMessage = actualCause.getMessage();

        /* 検証の実施 */
        Assertions.assertTrue(actualCause instanceof IllegalArgumentException,
            "KmgDomainExceptionの原因がIllegalArgumentExceptionであること");
        Assertions.assertEquals(expectedMessage, actualMessage, "IllegalArgumentExceptionのメッセージが正しいこと");

    }

    /**
     * getMethodInvoke メソッドのテスト - InvocationTargetException発生時<br>
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGetMethodInvoke_invocationTargetException() throws KmgDomainException {

        /* 期待値の定義 */
        final String expectedMessage = "Test invocation target exception";

        /* 準備 */
        final TestClass testObject = new TestClass();

        final KmgReflectionModelImpl testReflection = new KmgReflectionModelImpl(testObject) {

            @Override
            protected Object invoke(final Method method, final Object targetObject, final Object... parameters)
                throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {

                throw new InvocationTargetException(new RuntimeException(expectedMessage));

            }
        };

        /* テスト対象の実行 */
        final KmgDomainException actualException = Assertions.assertThrows(KmgDomainException.class,
            () -> testReflection.getMethodInvoke("testMethod", "Hello"));

        /* 検証の準備 */
        final Throwable actualCause   = actualException.getCause();
        final String    actualMessage = actualCause.getCause().getMessage();

        /* 検証の実施 */
        Assertions.assertTrue(actualCause instanceof InvocationTargetException,
            "KmgDomainExceptionの原因がInvocationTargetExceptionであること");
        Assertions.assertEquals(expectedMessage, actualMessage, "InvocationTargetExceptionのメッセージが正しいこと");

    }

    /**
     * getMethodInvoke メソッドのテスト - パラメータタイプと実際のパラメータの型が一致しない場合<br>
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGetMethodInvoke_mismatchedParameterTypes() throws KmgDomainException {

        /* 期待値の定義 */
        final Object expectedValue = null;

        /* 準備 */
        final TestClass              testObject     = new TestClass();
        final KmgReflectionModelImpl testReflection = new KmgReflectionModelImpl(testObject);
        final Class<?>[]             parameterTypes = {
            Integer.class  // String型のメソッドにInteger型のパラメータタイプを指定
        };

        /* テスト対象の実行 */
        final Object testResult = testReflection.getMethodInvoke("testMethod", parameterTypes, "Hello");

        /* 検証の準備 */
        final Object actualValue = testResult;

        /* 検証の実施 */
        Assertions.assertEquals(expectedValue, actualValue, "パラメータタイプが一致しない場合、nullが返されること");

    }

    /**
     * getMethodInvoke メソッドのテスト - 複数パラメータの場合<br>
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGetMethodInvoke_multipleParameters() throws KmgDomainException {

        /* 期待値の定義 */
        final String expectedValue = "Hello World Test";

        /* 準備 */
        final TestClass testObject = new TestClass() {

            @SuppressWarnings("unused")
            public String multiParamMethod(final String param1, final String param2) {

                final String result = KmgString.concat(KmgString.concat(param1, param2), "Test");

                return result;

            }
        };

        final KmgReflectionModelImpl testReflection = new KmgReflectionModelImpl(testObject);
        final Class<?>[]             parameterTypes = {
            String.class, String.class
        };

        /* テスト対象の実行 */
        final Object testResult = testReflection.getMethodInvoke("multiParamMethod", parameterTypes, "Hello", " World");

        /* 検証の準備 */
        final String actualValue = (String) testResult;

        /* 検証の実施 */
        Assertions.assertEquals(expectedValue, actualValue, "複数パラメータを持つメソッドが正しく呼び出されること");

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
        final Object expectedValue = null;

        /* 準備 */
        final TestClass              testObject     = new TestClass();
        final KmgReflectionModelImpl testReflection = new KmgReflectionModelImpl(testObject);

        /* テスト対象の実行 */
        final Object testResult = testReflection.getMethodInvoke("nonExistentMethod", "param");

        /* 検証の実施 */
        Assertions.assertEquals(expectedValue, testResult, "存在しないメソッドの呼び出しでnullが返されること");

    }

    /**
     * getMethodInvoke メソッドのテスト - メソッド名がnullの場合<br>
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGetMethodInvoke_nullMethodName() throws KmgDomainException {

        /* 期待値の定義 */
        final Object expectedValue = null;

        /* 準備 */
        final TestClass              testObject     = new TestClass();
        final KmgReflectionModelImpl testReflection = new KmgReflectionModelImpl(testObject);
        final Class<?>[]             parameterTypes = {
            String.class
        };

        /* テスト対象の実行 */
        final Object testResult = testReflection.getMethodInvoke(null, parameterTypes, "test");

        /* 検証の準備 */
        final Object actualValue = testResult;

        /* 検証の実施 */
        Assertions.assertEquals(expectedValue, actualValue, "メソッド名がnullの場合、nullが返されること");

    }

    /**
     * getMethodInvoke メソッドのテスト - スーパークラスのメソッドを検索する場合<br>
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGetMethodInvoke_searchSuperClass() throws KmgDomainException {

        /* 期待値の定義 */
        final String expectedValue = "SuperTest";

        /* 準備 */
        class SuperClass {

            @SuppressWarnings("unused")
            public String superMethod(final String param) {

                final String result = KmgString.concat(param, "Test");

                return result;

            }
        }
        class SubClass extends SuperClass {
            /** スーパークラスのメソッドのみを使用するサブクラス */
        }

        final SubClass               testObject     = new SubClass();
        final KmgReflectionModelImpl testReflection = new KmgReflectionModelImpl(testObject);
        final Class<?>[]             parameterTypes = {
            String.class
        };

        /* テスト対象の実行 */
        final Object testResult = testReflection.getMethodInvoke("superMethod", parameterTypes, "Super");

        /* 検証の準備 */
        final String actualValue = (String) testResult;

        /* 検証の実施 */
        Assertions.assertEquals(expectedValue, actualValue, "スーパークラスのメソッドが正しく呼び出されること");

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

}

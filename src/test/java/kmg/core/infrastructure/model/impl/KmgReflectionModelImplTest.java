package kmg.core.infrastructure.model.impl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import kmg.core.infrastructure.common.msg.KmgComExcMsgTypes;
import kmg.core.infrastructure.exception.KmgReflectionException;
import kmg.core.infrastructure.type.KmgString;
import kmg.core.infrastructure.types.msg.KmgCoreGenMsgTypes;
import kmg.core.test.AbstractKmgTest;

/**
 * KMGリフレクションモデル実装のテスト<br>
 *
 * @author KenichiroArai
 *
 * @since 0.1.0
 *
 * @version 0.2.0
 */
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@SuppressWarnings({
    "nls", "static-method",
})
public class KmgReflectionModelImplTest extends AbstractKmgTest {

    /**
     * テスト用のクラス<br>
     *
     * @author KenichiroArai
     *
     * @since 0.1.0
     *
     * @version 0.2.0
     */
    private static class TestClass {

        /**
         * パブリックフィールド
         *
         * @since 0.1.0
         */
        public String publicField;

        /**
         * BigDecimalフィールド
         *
         * @since 0.1.0
         */
        @SuppressWarnings("unused")
        private BigDecimal decimalField;

        /**
         * プライベートフィールド
         *
         * @since 0.1.0
         */
        private String privateField;

        /**
         * デフォルトコンストラクタ<br>
         *
         * @since 0.1.0
         */
        public TestClass() {

            // 処理なし
        }

        /**
         * プライベートフィールドを取得する<br>
         *
         * @since 0.1.0
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
         * @since 0.1.0
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
         * @since 0.1.0
         *
         * @param param
         *              パラメータ
         *
         * @return パラメータに「Test」を追加した文字列
         */
        @SuppressWarnings("unused")
        public String testMethod(final String param) {

            final String result = KmgString.concat(param, "Test");
            return result;

        }
    }

    /**
     * デフォルトコンストラクタ<br>
     *
     * @since 0.1.0
     */
    public KmgReflectionModelImplTest() {

        // 処理なし
    }

    /**
     * get メソッドのテスト - 異常系:getValue呼び出し時のIllegalAccessException
     *
     * @since 0.1.0
     *
     * @throws KmgReflectionException
     *                                KMGドメイン例外
     */
    @Test
    public void testGet_errorGetValueIllegalAccessException() throws KmgReflectionException {

        /* 期待値の定義 */
        final String             expectedDomainMessage = String.format(
            "[%s] フィールドの値の取得に失敗しました。フィールド名=[%s]、対象のクラス=[%s]、最後に取得したフィールド=[%s]", "KMGCORE_GEN11202", "publicField",
            "class kmg.core.infrastructure.model.impl.KmgReflectionModelImplTest$TestClass",
            "public java.lang.String kmg.core.infrastructure.model.impl.KmgReflectionModelImplTest$TestClass.publicField");
        final KmgCoreGenMsgTypes expectedMessageTypes  = KmgCoreGenMsgTypes.KMGCORE_GEN11202;

        /* 準備 */
        final TestClass testObject = new TestClass();

        final KmgReflectionModelImpl testReflection = new KmgReflectionModelImpl(testObject) {

            @Override
            protected Object getValue(final Field field, final Object targetObject)
                throws SecurityException, IllegalAccessException {

                throw new IllegalAccessException();

            }
        };

        /* テスト対象の実行 */
        final KmgReflectionException actualException
            = Assertions.assertThrows(KmgReflectionException.class, () -> testReflection.get("publicField"));

        /* 検証の準備 */
        /* 検証の実施 */
        this.verifyKmgMsgException(actualException, IllegalAccessException.class, expectedDomainMessage,
            expectedMessageTypes);

    }

    /**
     * get メソッドのテスト - 異常系:getValue呼び出し時のSecurityException
     *
     * @since 0.1.0
     *
     * @throws KmgReflectionException
     *                                KMGドメイン例外
     */
    @Test
    public void testGet_errorGetValueSecurityException() throws KmgReflectionException {

        /* 期待値の定義 */
        final String             expectedDomainMessage = String.format(
            "[%s] フィールドの値の取得に失敗しました。フィールド名=[%s]、対象のクラス=[%s]、最後に取得したフィールド=[%s]", "KMGCORE_GEN11201", "publicField",
            "class kmg.core.infrastructure.model.impl.KmgReflectionModelImplTest$TestClass",
            "public java.lang.String kmg.core.infrastructure.model.impl.KmgReflectionModelImplTest$TestClass.publicField");
        final KmgCoreGenMsgTypes expectedMessageTypes  = KmgCoreGenMsgTypes.KMGCORE_GEN11201;

        /* 準備 */
        final TestClass testObject = new TestClass();

        final KmgReflectionModelImpl testReflection = new KmgReflectionModelImpl(testObject) {

            @Override
            protected Object getValue(final Field field, final Object targetObject)
                throws SecurityException, IllegalAccessException {

                throw new SecurityException("Test security exception from getValue");

            }
        };

        /* テスト対象の実行 */
        final KmgReflectionException actualException
            = Assertions.assertThrows(KmgReflectionException.class, () -> testReflection.get("publicField"));

        /* 検証の準備 */
        /* 検証の実施 */
        this.verifyKmgMsgException(actualException, SecurityException.class, expectedDomainMessage,
            expectedMessageTypes);

    }

    /**
     * get メソッドのテスト - SecurityException発生時<br>
     *
     * @since 0.1.0
     *
     * @throws KmgReflectionException
     *                                KMGドメイン例外
     */
    @Test
    public void testGet_errorSecurityException() throws KmgReflectionException {

        /* 期待値の定義 */
        final String             expectedDomainMessage = String.format(
            "[%s] フィールドの取得に失敗しました。フィールド名=[%s]、対象のクラス=[%s]、最後に取得したフィールド=[%s]", "KMGCORE_GEN11200", "publicField",
            "class kmg.core.infrastructure.model.impl.KmgReflectionModelImplTest$TestClass", "null");
        final KmgCoreGenMsgTypes expectedMessageTypes  = KmgCoreGenMsgTypes.KMGCORE_GEN11200;

        /* 準備 */
        final TestClass testObject = new TestClass();

        final KmgReflectionModelImpl testReflection = new KmgReflectionModelImpl(testObject) {

            @Override
            protected Field getField(final Class<?> targetClazz, final String name)
                throws NoSuchFieldException, SecurityException {

                throw new SecurityException();

            }
        };

        /* テスト対象の実行 */
        final KmgReflectionException actualException
            = Assertions.assertThrows(KmgReflectionException.class, () -> testReflection.get("publicField"));

        /* 検証の準備 */

        /* 検証の実施 */
        this.verifyKmgMsgException(actualException, SecurityException.class, expectedDomainMessage,
            expectedMessageTypes);

    }

    /**
     * get メソッドのテスト - 正常系：BigDecimalフィールドの値を取得<br>
     *
     * @since 0.1.0
     *
     * @throws KmgReflectionException
     *                                KMGドメイン例外
     */
    @Test
    public void testGet_normalBigDecimalField() throws KmgReflectionException {

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
        Assertions.assertEquals(expectedValue, actualValue, "get: BigDecimalフィールドから値が正しく取得できること");

    }

    /**
     * get メソッドのテスト - 正常系:連続呼び出し時のlastGetFieldの状態確認
     *
     * @since 0.1.0
     *
     * @throws KmgReflectionException
     *                                  KMGドメイン例外
     * @throws IllegalAccessException
     *                                  イリーガルアクセス例外
     * @throws IllegalArgumentException
     *                                  引数例外
     */
    @Test
    public void testGet_normalConsecutiveCalls()
        throws KmgReflectionException, IllegalArgumentException, IllegalAccessException {

        /* 準備 */
        final TestClass testObject = new TestClass();
        testObject.publicField = "test1";
        testObject.setPrivateField("test2");
        final KmgReflectionModelImpl testReflection = new KmgReflectionModelImpl(testObject);

        /* テスト対象の実行と検証 */
        // 1回目の呼び出し
        /* 期待値の定義 */
        /* テスト対象の実行 */
        final Object firstResult = testReflection.get("publicField");
        /* 検証の準備 */
        /* 検証の実施 */
        Assertions.assertEquals("test1", firstResult, "get: 1回目のget呼び出しで正しい値が取得できること");
        Assertions.assertEquals("test1", testReflection.getLastGetField().get(testObject),
            "get: 1回目のget呼び出し後のlastGetFieldが正しいこと");

        // 2回目の呼び出し
        /* 期待値の定義 */
        /* テスト対象の実行 */
        final Object secondResult = testReflection.get("privateField");
        /* 検証の準備 */
        /* 検証の実施 */
        Assertions.assertEquals("test2", secondResult, "get: 2回目のget呼び出しで正しい値が取得できること");
        Assertions.assertEquals("test2", testReflection.getLastGetField().get(testObject),
            "get: 2回目のget呼び出し後のlastGetFieldが更新されていること");

        // 存在しないフィールドの呼び出し
        /* 期待値の定義 */
        /* テスト対象の実行 */
        final Object thirdResult = testReflection.get("nonExistentField");
        /* 検証の準備 */
        /* 検証の実施 */
        Assertions.assertNull(thirdResult, "get: 存在しないフィールドの呼び出しでnullが返されること");
        Assertions.assertNull(testReflection.getLastGetField(), "get: 存在しないフィールドの呼び出し後のlastGetFieldがnullになること");

    }

    /**
     * get メソッドのテスト - 正常系:存在しないフィールドへのアクセス
     *
     * @since 0.1.0
     *
     * @throws KmgReflectionException
     *                                KMGドメイン例外
     */
    @Test
    public void testGet_normalNonExistentField() throws KmgReflectionException {

        /* 期待値の定義 */
        final String expectedValue = null;

        /* 準備 */
        final TestClass              testObject     = new TestClass();
        final KmgReflectionModelImpl testReflection = new KmgReflectionModelImpl(testObject);

        /* テスト対象の実行 */
        final String actualValue = (String) testReflection.get("nonExistentField");

        /* 検証の準備 */
        /* 検証の実施 */
        Assertions.assertEquals(expectedValue, actualValue, "get: 存在しないフィールドへのアクセスでnullが返されること");

    }

    /**
     * get メソッドのテスト - 正常系:nullフィールド名を指定
     *
     * @since 0.1.0
     *
     * @throws KmgReflectionException
     *                                KMGドメイン例外
     */
    @Test
    public void testGet_normalNullFieldName() throws KmgReflectionException {

        /* 準備 */
        final TestClass              testObject     = new TestClass();
        final KmgReflectionModelImpl testReflection = new KmgReflectionModelImpl(testObject);

        /* テスト対象の実行 */
        final Object actualValue = testReflection.get(null);

        /* 検証の準備 */
        /* 検証の実施 */
        Assertions.assertNull(actualValue, "get: nullフィールド名を指定した場合、nullが返されること");

    }

    /**
     * get メソッドのテスト - 正常系:プライベートフィールドの値を取得
     *
     * @since 0.1.0
     *
     * @throws KmgReflectionException
     *                                KMGドメイン例外
     */
    @Test
    public void testGet_normalPrivateField() throws KmgReflectionException {

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
        Assertions.assertEquals(expectedValue, actualValue, "get: プライベートフィールドから値が取得できること");

    }

    /**
     * get メソッドのテスト - 正常系:パブリックフィールドの値を取得
     *
     * @since 0.1.0
     *
     * @throws KmgReflectionException
     *                                KMGドメイン例外
     */
    @Test
    public void testGet_normalPublicField() throws KmgReflectionException {

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
        Assertions.assertEquals(expectedValue, actualValue, "get: パブリックフィールドから値が取得できること");

    }

    /**
     * getDeclaredMethods メソッドのテスト - SecurityException発生時<br>
     *
     * @since 0.1.0
     *
     * @throws KmgReflectionException
     *                                KMGドメイン例外
     */
    @Test
    public void testGetDeclaredMethods_errorSecurityException() throws KmgReflectionException {

        /* 期待値の定義 */
        final String             expectedMessage       = "Test security exception from getDeclaredMethods";
        final String             expectedDomainMessage = String.format("[%s] メソッドの取得に失敗しました。メソッド名=[%s]、対象のクラス=[%s]",
            "KMGCORE_GEN11203", "testMethod",
            "class kmg.core.infrastructure.model.impl.KmgReflectionModelImplTest$TestClass");
        final KmgCoreGenMsgTypes expectedMessageTypes  = KmgCoreGenMsgTypes.KMGCORE_GEN11203;

        /* 準備 */
        final TestClass testObject = new TestClass();

        final KmgReflectionModelImpl testReflection = new KmgReflectionModelImpl(testObject) {

            @Override
            protected Method[] getDeclaredMethods(final Class<?> targetClazz) throws SecurityException {

                throw new SecurityException(expectedMessage);

            }
        };

        /* テスト対象の実行 */
        final KmgReflectionException actualException
            = Assertions.assertThrows(KmgReflectionException.class, () -> testReflection.getMethod("testMethod"));

        /* 検証の準備 */
        final Throwable         actualCause         = actualException.getCause();
        final String            actualMessage       = actualCause.getMessage();
        final String            actualDomainMessage = actualException.getMessage();
        final KmgComExcMsgTypes actualMessageTypes  = actualException.getMessageTypes();

        /* 検証の実施 */
        Assertions.assertInstanceOf(SecurityException.class, actualCause,
            "KmgReflectionExceptionの原因がSecurityExceptionであること");
        Assertions.assertEquals(expectedMessage, actualMessage, "SecurityExceptionのメッセージが正しいこと");
        Assertions.assertEquals(expectedDomainMessage, actualDomainMessage, "KmgReflectionExceptionのメッセージが正しいこと");
        Assertions.assertEquals(expectedMessageTypes, actualMessageTypes, "メッセージの種類が正しいこと");

    }

    /**
     * getDeclaredMethods メソッドのテスト - 正常系<br>
     *
     * @since 0.1.0
     *
     * @throws KmgReflectionException
     *                                KMGドメイン例外
     */
    @Test
    public void testGetDeclaredMethods_normal() throws KmgReflectionException {

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
        Assertions.assertEquals(expectedValue, actualValue, "メソッドの実行結果が正しいこと");

    }

    /**
     * getLastGetField メソッドのテスト - フィールド取得前<br>
     *
     * @since 0.1.0
     *
     * @throws KmgReflectionException
     *                                KMGドメイン例外
     */
    @Test
    public void testGetLastGetField_normalBeforeGetField() throws KmgReflectionException {

        /* 期待値の定義 */
        final Object expectedValue = null;

        /* 準備 */
        final TestClass              testObject     = new TestClass();
        final KmgReflectionModelImpl testReflection = new KmgReflectionModelImpl(testObject);

        /* テスト対象の実行 */
        final Object testResult = testReflection.getLastGetField();

        /* 検証の準備 */
        final Object actualValue = testResult;

        /* 検証の実施 */
        Assertions.assertEquals(expectedValue, actualValue, "最後に取得したフィールドがnullであること");

    }

    /**
     * getMethod メソッドのテスト - 異常系：IllegalAccessException発生時<br>
     *
     * @since 0.1.0
     *
     * @throws KmgReflectionException
     *                                KMGドメイン例外
     */
    @Test
    public void testGetMethod_errorIllegalAccessException() throws KmgReflectionException {

        /* 期待値の定義 */
        final String             expectedDomainMessage = String.format("[%s] メソッドの値の取得に失敗しました。メソッド名=[%s]、対象のクラス=[%s]",
            "KMGCORE_GEN11205", "testMethod",
            "class kmg.core.infrastructure.model.impl.KmgReflectionModelImplTest$TestClass");
        final KmgCoreGenMsgTypes expectedMessageTypes  = KmgCoreGenMsgTypes.KMGCORE_GEN11205;

        /* 準備 */
        final TestClass testObject = new TestClass();

        final KmgReflectionModelImpl testReflection = new KmgReflectionModelImpl(testObject) {

            @Override
            protected Object invoke(final Method method, final Object targetObject, final Object... parameters)
                throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {

                throw new IllegalAccessException();

            }
        };

        /* テスト対象の実行 */
        final KmgReflectionException actualException = Assertions.assertThrows(KmgReflectionException.class,
            () -> testReflection.getMethod("testMethod", "Hello"));

        /* 検証の実施 */
        this.verifyKmgMsgException(actualException, IllegalAccessException.class, expectedDomainMessage,
            expectedMessageTypes);

    }

    /**
     * getMethod メソッドのテスト - 異常系：IllegalArgumentException発生時<br>
     *
     * @since 0.1.0
     *
     * @throws KmgReflectionException
     *                                KMGドメイン例外
     */
    @Test
    public void testGetMethod_errorIllegalArgumentException() throws KmgReflectionException {

        /* 期待値の定義 */
        final String             expectedDomainMessage = String.format("[%s] メソッドの値の取得に失敗しました。メソッド名=[%s]、対象のクラス=[%s]",
            "KMGCORE_GEN11206", "testMethod",
            "class kmg.core.infrastructure.model.impl.KmgReflectionModelImplTest$TestClass");
        final KmgCoreGenMsgTypes expectedMessageTypes  = KmgCoreGenMsgTypes.KMGCORE_GEN11206;

        /* 準備 */
        final TestClass testObject = new TestClass();

        final KmgReflectionModelImpl testReflection = new KmgReflectionModelImpl(testObject) {

            @Override
            protected Object invoke(final Method method, final Object targetObject, final Object... parameters)
                throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {

                throw new IllegalArgumentException("Test illegal argument exception");

            }
        };

        /* テスト対象の実行 */
        final KmgReflectionException actualException = Assertions.assertThrows(KmgReflectionException.class,
            () -> testReflection.getMethod("testMethod", "Hello"));

        /* 検証の実施 */
        this.verifyKmgMsgException(actualException, IllegalArgumentException.class, expectedDomainMessage,
            expectedMessageTypes);

    }

    /**
     * getMethod メソッドのテスト - 異常系：InvocationTargetException発生時<br>
     *
     * @since 0.1.0
     *
     * @throws KmgReflectionException
     *                                KMGドメイン例外
     */
    @Test
    public void testGetMethod_errorInvocationTargetException() throws KmgReflectionException {

        /* 期待値の定義 */
        final String             expectedDomainMessage = String.format("[%s] メソッドの値の取得に失敗しました。メソッド名=[%s]、対象のクラス=[%s]",
            "KMGCORE_GEN11207", "testMethod",
            "class kmg.core.infrastructure.model.impl.KmgReflectionModelImplTest$TestClass");
        final KmgCoreGenMsgTypes expectedMessageTypes  = KmgCoreGenMsgTypes.KMGCORE_GEN11207;

        /* 準備 */
        final TestClass testObject = new TestClass();

        final KmgReflectionModelImpl testReflection = new KmgReflectionModelImpl(testObject) {

            @Override
            protected Object invoke(final Method method, final Object targetObject, final Object... parameters)
                throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {

                throw new InvocationTargetException(new RuntimeException("Test invocation target exception"));

            }
        };

        /* テスト対象の実行 */
        final KmgReflectionException actualException = Assertions.assertThrows(KmgReflectionException.class,
            () -> testReflection.getMethod("testMethod", "Hello"));

        /* 検証の実施 */
        this.verifyKmgMsgException(actualException, InvocationTargetException.class, expectedDomainMessage,
            expectedMessageTypes);

    }

    /**
     * getMethod メソッドのテスト - 正常系：privateメソッドへのアクセス<br>
     *
     * @since 0.1.0
     *
     * @throws KmgReflectionException
     *                                KMGドメイン例外
     */
    @Test
    public void testGetMethod_normalPrivateMethod() throws KmgReflectionException {

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
     * getMethod メソッドのテスト - 正常系：パラメータありのメソッド呼び出し<br>
     *
     * @since 0.1.0
     *
     * @throws KmgReflectionException
     *                                KMGドメイン例外
     */
    @Test
    public void testGetMethod_normalWithParameters() throws KmgReflectionException {

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
     * getMethod メソッドのテスト - 準正常系：パラメータ数が一致しない場合<br>
     *
     * @since 0.1.0
     *
     * @throws KmgReflectionException
     *                                KMGドメイン例外
     */
    @Test
    public void testGetMethod_semiMismatchParameterCount() throws KmgReflectionException {

        /* 期待値の定義 */
        final Object expectedValue = null;

        /* 準備 */
        final TestClass              testObject     = new TestClass();
        final KmgReflectionModelImpl testReflection = new KmgReflectionModelImpl(testObject);

        /* テスト対象の実行 */
        final Object testResult = testReflection.getMethod("testMethod", "Hello", "World");

        /* 検証の準備 */
        final Object actualValue = testResult;

        /* 検証の実施 */
        Assertions.assertEquals(expectedValue, actualValue, "パラメータ数が一致しない場合、nullが返されること");

    }

    /**
     * getMethod メソッドのテスト - 準正常系：パラメータの型が一致しない場合<br>
     *
     * @since 0.1.0
     *
     * @throws KmgReflectionException
     *                                KMGドメイン例外
     */
    @Test
    public void testGetMethod_semiMismatchParameterType() throws KmgReflectionException {

        /* 期待値の定義 */
        final Object expectedValue = null;

        /* 準備 */
        final TestClass              testObject     = new TestClass();
        final KmgReflectionModelImpl testReflection = new KmgReflectionModelImpl(testObject);

        /* テスト対象の実行 */
        final Object testResult = testReflection.getMethod("testMethod", Integer.valueOf(123));

        /* 検証の準備 */
        final Object actualValue = testResult;

        /* 検証の実施 */
        Assertions.assertEquals(expectedValue, actualValue, "パラメータの型が一致しない場合、nullが返されること");

    }

    /**
     * getMethod メソッドのテスト - 準正常系：存在しないメソッドへのアクセス<br>
     *
     * @since 0.1.0
     *
     * @throws KmgReflectionException
     *                                KMGドメイン例外
     */
    @Test
    public void testGetMethod_semiNonExistentMethod() throws KmgReflectionException {

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
     * getMethod メソッドのテスト - 準正常系：メソッド名がnullの場合<br>
     *
     * @since 0.1.0
     *
     * @throws KmgReflectionException
     *                                KMGドメイン例外
     */
    @Test
    public void testGetMethod_semiNullMethodName() throws KmgReflectionException {

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
     * invoke メソッドのテスト - 異常系：SecurityException発生時<br>
     *
     * @since 0.1.0
     *
     * @throws KmgReflectionException
     *                                KMGドメイン例外
     */
    @Test
    public void testInvoke_errorSecurityException() throws KmgReflectionException {

        /* 期待値の定義 */
        final String             expectedDomainMessage = String.format("[%s] メソッドの値の取得に失敗しました。メソッド名=[%s]、対象のクラス=[%s]",
            "KMGCORE_GEN11204", "testMethod",
            "class kmg.core.infrastructure.model.impl.KmgReflectionModelImplTest$TestClass");
        final KmgCoreGenMsgTypes expectedMessageTypes  = KmgCoreGenMsgTypes.KMGCORE_GEN11204;

        /* 準備 */
        final TestClass testObject = new TestClass();

        final KmgReflectionModelImpl testReflection = new KmgReflectionModelImpl(testObject) {

            @Override
            protected Object invoke(final Method method, final Object targetObject, final Object... parameters)
                throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {

                throw new SecurityException("Test security exception from invoke");

            }
        };

        /* テスト対象の実行 */
        final KmgReflectionException actualException = Assertions.assertThrows(KmgReflectionException.class,
            () -> testReflection.getMethod("testMethod", "Hello"));

        /* 検証の実施 */
        this.verifyKmgMsgException(actualException, SecurityException.class, expectedDomainMessage,
            expectedMessageTypes);

    }

    /**
     * invoke メソッドのテスト - 正常系：メソッドが正しく呼び出されること<br>
     *
     * @since 0.1.0
     *
     * @throws KmgReflectionException
     *                                KMGドメイン例外
     */
    @Test
    public void testInvoke_normalMethodCall() throws KmgReflectionException {

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
     * set メソッドのテスト - 異常系：IllegalAccessException発生時<br>
     *
     * @since 0.1.0
     *
     * @throws KmgReflectionException
     *                                KMGドメイン例外
     */
    @Test
    public void testSet_errorIllegalAccessException() throws KmgReflectionException {

        /* 期待値の定義 */
        final String             expectedDomainMessage = String.format(
            "[%s] フィールドの値の設定に失敗しました。フィールド名=[%s]、対象のクラス=[%s]、最後に取得したフィールド=[%s]", "KMGCORE_GEN11211", "publicField",
            "class kmg.core.infrastructure.model.impl.KmgReflectionModelImplTest$TestClass",
            "public java.lang.String kmg.core.infrastructure.model.impl.KmgReflectionModelImplTest$TestClass.publicField");
        final KmgCoreGenMsgTypes expectedMessageTypes  = KmgCoreGenMsgTypes.KMGCORE_GEN11211;

        /* 準備 */
        final TestClass testObject = new TestClass();

        final KmgReflectionModelImpl testReflection = new KmgReflectionModelImpl(testObject) {

            @Override
            protected void setValue(final Field field, final Object targetObject, final Object value)
                throws SecurityException, IllegalAccessException {

                throw new IllegalAccessException("Test illegal access exception from setValue");

            }
        };

        /* テスト対象の実行 */
        final KmgReflectionException actualException
            = Assertions.assertThrows(KmgReflectionException.class, () -> testReflection.set("publicField", "test"));

        /* 検証の実施 */
        this.verifyKmgMsgException(actualException, IllegalAccessException.class, expectedDomainMessage,
            expectedMessageTypes);

    }

    /**
     * set メソッドのテスト - 異常系：BigDecimalに変換できない値の場合<br>
     *
     * @since 0.1.0
     *
     * @throws KmgReflectionException
     *                                KMGドメイン例外
     */
    @Test
    public void testSet_errorInvalidBigDecimalValue() throws KmgReflectionException {

        /* 期待値の定義 */
        final KmgCoreGenMsgTypes expectedMessageTypes = KmgCoreGenMsgTypes.KMGCORE_GEN11210;

        /* 準備 */
        final TestClass              testObject     = new TestClass();
        final KmgReflectionModelImpl testReflection = new KmgReflectionModelImpl(testObject);

        /* テスト対象の実行 */
        final KmgReflectionException actualException = Assertions.assertThrows(KmgReflectionException.class,
            () -> testReflection.set("decimalField", "invalid"));

        /* 検証の準備 */
        final Throwable actualCause = actualException.getCause();

        /* 検証の実施 */
        Assertions.assertInstanceOf(IllegalArgumentException.class, actualCause,
            "KmgReflectionExceptionの原因がIllegalArgumentExceptionであること");
        Assertions.assertEquals(expectedMessageTypes, actualException.getMessageTypes(), "メッセージの種類が正しいこと");

    }

    /**
     * set メソッドのテスト - 異常系：SecurityException発生時<br>
     *
     * @since 0.1.0
     *
     * @throws KmgReflectionException
     *                                KMGドメイン例外
     */
    @Test
    public void testSet_errorSecurityException() throws KmgReflectionException {

        /* 期待値の定義 */
        final String             expectedDomainMessage = String.format(
            "[%s] フィールドの取得に失敗しました。フィールド名=[%s]、対象のクラス=[%s]、最後に取得したフィールド=[%s]", "KMGCORE_GEN11209", "publicField",
            "class kmg.core.infrastructure.model.impl.KmgReflectionModelImplTest$TestClass", "null");
        final KmgCoreGenMsgTypes expectedMessageTypes  = KmgCoreGenMsgTypes.KMGCORE_GEN11209;

        /* 準備 */
        final TestClass testObject = new TestClass();

        final KmgReflectionModelImpl testReflection = new KmgReflectionModelImpl(testObject) {

            @Override
            protected Field getField(final Class<?> targetClazz, final String name)
                throws NoSuchFieldException, SecurityException {

                throw new SecurityException();

            }
        };

        /* テスト対象の実行 */
        final KmgReflectionException actualException = Assertions.assertThrows(KmgReflectionException.class,
            () -> testReflection.set("publicField", "test value"));

        /* 検証の実施 */
        this.verifyKmgMsgException(actualException, SecurityException.class, expectedDomainMessage,
            expectedMessageTypes);

    }

    /**
     * set メソッドのテスト - 正常系：BigDecimalフィールドへの値の設定<br>
     *
     * @since 0.1.0
     *
     * @throws KmgReflectionException
     *                                KMGドメイン例外
     */
    @Test
    public void testSet_normalBigDecimalField() throws KmgReflectionException {

        /* 期待値の定義 */
        final BigDecimal expectedValue = new BigDecimal("123.45");

        /* 準備 */
        final TestClass              testObject     = new TestClass();
        final KmgReflectionModelImpl testReflection = new KmgReflectionModelImpl(testObject);

        /* テスト対象の実行 */
        testReflection.set("decimalField", expectedValue);

        /* 検証の準備 */
        final Object actualValue = testReflection.get("decimalField");

        /* 検証の実施 */
        Assertions.assertEquals(expectedValue, actualValue, "BigDecimalフィールドに値が正しく設定されること");

    }

    /**
     * set メソッドのテスト - 正常系：値がnullの場合<br>
     *
     * @since 0.1.0
     *
     * @throws KmgReflectionException
     *                                KMGドメイン例外
     */
    @Test
    public void testSet_normalNullValue() throws KmgReflectionException {

        /* 期待値の定義 */
        final Object expectedValue = null;

        /* 準備 */
        final TestClass              testObject     = new TestClass();
        final KmgReflectionModelImpl testReflection = new KmgReflectionModelImpl(testObject);

        /* テスト対象の実行 */
        testReflection.set("publicField", null);

        /* 検証の準備 */
        final Object actualValue = testObject.publicField;

        /* 検証の実施 */
        Assertions.assertEquals(expectedValue, actualValue, "nullが正しく設定されること");

    }

    /**
     * set メソッドのテスト - 正常系：プライベートフィールドへの値の設定<br>
     *
     * @since 0.1.0
     *
     * @throws KmgReflectionException
     *                                KMGドメイン例外
     */
    @Test
    public void testSet_normalPrivateField() throws KmgReflectionException {

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
        Assertions.assertEquals(expectedValue, actualValue, "プライベートフィールドに値が正しく設定されること");

    }

    /**
     * set メソッドのテスト - 正常系：パブリックフィールドへの値の設定<br>
     *
     * @since 0.1.0
     *
     * @throws KmgReflectionException
     *                                KMGドメイン例外
     */
    @Test
    public void testSet_normalPublicField() throws KmgReflectionException {

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
        Assertions.assertEquals(expectedValue, actualValue, "パブリックフィールドに値が正しく設定されること");

    }

    /**
     * set メソッドのテスト - 準正常系：存在しないフィールドへの値の設定<br>
     *
     * @since 0.1.0
     *
     * @throws KmgReflectionException
     *                                KMGドメイン例外
     */
    @Test
    public void testSet_semiNonExistentField() throws KmgReflectionException {

        /* 期待値の定義 */
        final Field expectedLastGetField = null;

        /* 準備 */
        final TestClass              testObject     = new TestClass();
        final KmgReflectionModelImpl testReflection = new KmgReflectionModelImpl(testObject);

        /* テスト対象の実行 */
        testReflection.set("nonExistentField", "test value");

        /* 検証の準備 */
        final Field actualLastGetField = testReflection.getLastGetField();

        /* 検証の実施 */
        Assertions.assertEquals(expectedLastGetField, actualLastGetField, "存在しないフィールドへの設定時にlastGetFieldがnullであること");

    }

    /**
     * set メソッドのテスト - 準正常系：nullフィールド名を指定<br>
     *
     * @since 0.1.0
     *
     * @throws KmgReflectionException
     *                                KMGドメイン例外
     */
    @Test
    public void testSet_semiNullFieldName() throws KmgReflectionException {

        /* 期待値の定義 */
        final Field expectedLastGetField = null;

        /* 準備 */
        final TestClass              testObject     = new TestClass();
        final KmgReflectionModelImpl testReflection = new KmgReflectionModelImpl(testObject);

        /* テスト対象の実行 */
        testReflection.set(null, "test value");

        /* 検証の準備 */
        final Field actualLastGetField = testReflection.getLastGetField();

        /* 検証の実施 */
        Assertions.assertEquals(expectedLastGetField, actualLastGetField, "nullフィールド名指定時にlastGetFieldがnullであること");

    }

}

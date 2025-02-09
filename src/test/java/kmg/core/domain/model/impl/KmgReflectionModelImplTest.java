package kmg.core.domain.model.impl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import kmg.core.infrastructure.common.KmgMessageTypes;
import kmg.core.infrastructure.exception.KmgDomainException;
import kmg.core.infrastructure.type.KmgString;
import kmg.core.infrastructure.types.KmgMsgMessageTypes;

/**
 * KMGリフレクションモデル実装のテスト<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
@ExtendWith(MockitoExtension.class)
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
    public void testGet_getValueIllegalAccessException() throws KmgDomainException {

        /* 期待値の定義 */
        final String             expectedDomainMessage           = String.format(
            "フィールドの値の取得に失敗しました。フィールド名=[%s]、対象のクラス=[%s]、最後に取得したフィールド=[%s]", "publicField",
            "class kmg.core.domain.model.impl.KmgReflectionModelImplTest$TestClass",
            "public java.lang.String kmg.core.domain.model.impl.KmgReflectionModelImplTest$TestClass.publicField");
        final KmgMsgMessageTypes expectedMessageTypes            = KmgMsgMessageTypes.KMGMSGE11202;
        final int                expectedMessageArgsCount        = 3;
        final int                expectedMessagePatternArgsCount = 3;

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
        final KmgDomainException actualException
            = Assertions.assertThrows(KmgDomainException.class, () -> testReflection.get("publicField"));

        /* 検証の準備 */
        final Throwable       actualCause                   = actualException.getCause();
        final String          actualDomainMessage           = actualException.getMessage();
        final KmgMessageTypes actualMessageTypes            = actualException.getMessageTypes();
        final int             actualMessageArgsCount        = actualException.getMessageArgsCount();
        final int             actualMessagePatternArgsCount = actualException.getMessagePatternArgsCount();
        final boolean         actualIsMatchMessageArgsCount = actualException.isMatchMessageArgsCount();

        /* 検証の実施 */
        Assertions.assertTrue(actualCause instanceof IllegalAccessException,
            "KmgDomainExceptionの原因がIllegalAccessExceptionであること");
        Assertions.assertEquals(expectedDomainMessage, actualDomainMessage, "KmgDomainExceptionのメッセージが正しいこと");
        Assertions.assertEquals(expectedMessageTypes, actualMessageTypes, "メッセージの種類が正しいこと");
        Assertions.assertEquals(expectedMessageArgsCount, actualMessageArgsCount, "メッセージ引数の数が正しいこと");
        Assertions.assertEquals(expectedMessagePatternArgsCount, actualMessagePatternArgsCount, "メッセージパターンの引数の数が正しいこと");
        Assertions.assertTrue(actualIsMatchMessageArgsCount, "メッセージ引数の数が一致していること");

    }

    /**
     * get メソッドのテスト - getValue呼び出し時のSecurityException<br>
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
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
    public void testGet_securityException() throws KmgDomainException {

        /* 期待値の定義 */
        final String             expectedMessage                 = "Test security exception";
        final String             expectedDomainMessage           = String.format(
            "フィールドの取得に失敗しました。フィールド名=[%s]、対象のクラス=[%s]", "publicField",
            "class kmg.core.domain.model.impl.KmgReflectionModelImplTest$TestClass");
        final KmgMsgMessageTypes expectedMessageTypes            = KmgMsgMessageTypes.KMGMSGE11201;
        final int                expectedMessageArgsCount        = 2;
        final int                expectedMessagePatternArgsCount = 2;

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
        final Throwable       actualCause                   = actualException.getCause();
        final String          actualMessage                 = actualCause.getMessage();
        final String          actualDomainMessage           = actualException.getMessage();
        final KmgMessageTypes actualMessageTypes            = actualException.getMessageTypes();
        final int             actualMessageArgsCount        = actualException.getMessageArgsCount();
        final int             actualMessagePatternArgsCount = actualException.getMessagePatternArgsCount();
        final boolean         actualIsMatchMessageArgsCount = actualException.isMatchMessageArgsCount();

        /* 検証の実施 */
        Assertions.assertTrue(actualCause instanceof SecurityException, "KmgDomainExceptionの原因がSecurityExceptionであること");
        Assertions.assertEquals(expectedMessage, actualMessage, "SecurityExceptionのメッセージが正しいこと");
        Assertions.assertEquals(expectedDomainMessage, actualDomainMessage, "KmgDomainExceptionのメッセージが正しいこと");
        Assertions.assertEquals(expectedMessageTypes, actualMessageTypes, "メッセージの種類が正しいこと");
        Assertions.assertEquals(expectedMessageArgsCount, actualMessageArgsCount, "メッセージ引数の数が正しいこと");
        Assertions.assertEquals(expectedMessagePatternArgsCount, actualMessagePatternArgsCount, "メッセージパターンの引数の数が正しいこと");
        Assertions.assertTrue(actualIsMatchMessageArgsCount, "メッセージ引数の数が一致していること");

    }

    /**
     * getDeclaredMethods メソッドのテスト - 正常系<br>
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
    public void testGetDeclaredMethods_normal() throws KmgDomainException {

        /* 準備 */
        final TestClass              testObject     = new TestClass();
        final KmgReflectionModelImpl testReflection = new KmgReflectionModelImpl(testObject);

        /* テスト対象の実行 */
        final Object testResult = testReflection.getMethod("testMethod", "Hello");

        /* 検証の実施 */
        Assertions.assertNotNull(testResult, "宣言されたメソッドが正しく取得できること");
        Assertions.assertEquals("HelloTest", testResult, "メソッドの実行結果が正しいこと");

    }

    /**
     * getDeclaredMethods メソッドのテスト - SecurityException発生時<br>
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
    public void testGetDeclaredMethods_securityException() throws KmgDomainException {

        /* 期待値の定義 */
        final String             expectedMessage                 = "Test security exception from getDeclaredMethods";
        final String             expectedDomainMessage           = String.format(
            "メソッドの取得に失敗しました。メソッド名=[%s]、対象のクラス=[%s]", "testMethod",
            "class kmg.core.domain.model.impl.KmgReflectionModelImplTest$TestClass");
        final KmgMsgMessageTypes expectedMessageTypes            = KmgMsgMessageTypes.KMGMSGE11203;
        final int                expectedMessageArgsCount        = 2;
        final int                expectedMessagePatternArgsCount = 2;

        /* 準備 */
        final TestClass testObject = new TestClass();

        final KmgReflectionModelImpl testReflection = new KmgReflectionModelImpl(testObject) {

            @Override
            protected Method[] getDeclaredMethods(final Class<?> targetClazz) throws SecurityException {

                throw new SecurityException(expectedMessage);

            }
        };

        /* テスト対象の実行 */
        final KmgDomainException actualException
            = Assertions.assertThrows(KmgDomainException.class, () -> testReflection.getMethod("testMethod"));

        /* 検証の準備 */
        final Throwable       actualCause                   = actualException.getCause();
        final String          actualMessage                 = actualCause.getMessage();
        final String          actualDomainMessage           = actualException.getMessage();
        final KmgMessageTypes actualMessageTypes            = actualException.getMessageTypes();
        final int             actualMessageArgsCount        = actualException.getMessageArgsCount();
        final int             actualMessagePatternArgsCount = actualException.getMessagePatternArgsCount();
        final boolean         actualIsMatchMessageArgsCount = actualException.isMatchMessageArgsCount();

        /* 検証の実施 */
        Assertions.assertTrue(actualCause instanceof SecurityException, "KmgDomainExceptionの原因がSecurityExceptionであること");
        Assertions.assertEquals(expectedMessage, actualMessage, "SecurityExceptionのメッセージが正しいこと");
        Assertions.assertEquals(expectedDomainMessage, actualDomainMessage, "KmgDomainExceptionのメッセージが正しいこと");
        Assertions.assertEquals(expectedMessageTypes, actualMessageTypes, "メッセージの種類が正しいこと");
        Assertions.assertEquals(expectedMessageArgsCount, actualMessageArgsCount, "メッセージ引数の数が正しいこと");
        Assertions.assertEquals(expectedMessagePatternArgsCount, actualMessagePatternArgsCount, "メッセージパターンの引数の数が正しいこと");
        Assertions.assertTrue(actualIsMatchMessageArgsCount, "メッセージ引数の数が一致していること");

    }

    /**
     * getLastGetField メソッドのテスト - フィールド取得前<br>
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
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
    public void testGetMethod_illegalAccessException() throws KmgDomainException {

        /* 期待値の定義 */
        final String             expectedMessage                 = "Test illegal access exception";
        final String             expectedDomainMessage           = String.format(
            "メソッドの実行に失敗しました。メソッド名=[%s]、対象のクラス=[%s]", "testMethod",
            "class kmg.core.domain.model.impl.KmgReflectionModelImplTest$TestClass");
        final KmgMsgMessageTypes expectedMessageTypes            = KmgMsgMessageTypes.KMGMSGE11204;
        final int                expectedMessageArgsCount        = 2;
        final int                expectedMessagePatternArgsCount = 2;

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
        final Throwable       actualCause                   = actualException.getCause();
        final String          actualMessage                 = actualCause.getMessage();
        final String          actualDomainMessage           = actualException.getMessage();
        final KmgMessageTypes actualMessageTypes            = actualException.getMessageTypes();
        final int             actualMessageArgsCount        = actualException.getMessageArgsCount();
        final int             actualMessagePatternArgsCount = actualException.getMessagePatternArgsCount();
        final boolean         actualIsMatchMessageArgsCount = actualException.isMatchMessageArgsCount();

        /* 検証の実施 */
        Assertions.assertTrue(actualCause instanceof IllegalAccessException,
            "KmgDomainExceptionの原因がIllegalAccessExceptionであること");
        Assertions.assertEquals(expectedMessage, actualMessage, "IllegalAccessExceptionのメッセージが正しいこと");
        Assertions.assertEquals(expectedDomainMessage, actualDomainMessage, "KmgDomainExceptionのメッセージが正しいこと");
        Assertions.assertEquals(expectedMessageTypes, actualMessageTypes, "メッセージの種類が正しいこと");
        Assertions.assertEquals(expectedMessageArgsCount, actualMessageArgsCount, "メッセージ引数の数が正しいこと");
        Assertions.assertEquals(expectedMessagePatternArgsCount, actualMessagePatternArgsCount, "メッセージパターンの引数の数が正しいこと");
        Assertions.assertTrue(actualIsMatchMessageArgsCount, "メッセージ引数の数が一致していること");

    }

    /**
     * getMethod メソッドのテスト - IllegalArgumentException発生時<br>
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
    public void testGetMethod_illegalArgumentException() throws KmgDomainException {

        /* 期待値の定義 */
        final String             expectedMessage                 = "Test illegal argument exception";
        final String             expectedDomainMessage           = String.format(
            "メソッドの実行に失敗しました。メソッド名=[%s]、対象のクラス=[%s]", "testMethod",
            "class kmg.core.domain.model.impl.KmgReflectionModelImplTest$TestClass");
        final KmgMsgMessageTypes expectedMessageTypes            = KmgMsgMessageTypes.KMGMSGE11204;
        final int                expectedMessageArgsCount        = 2;
        final int                expectedMessagePatternArgsCount = 2;

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
        final KmgDomainException actualException
            = Assertions.assertThrows(KmgDomainException.class, () -> testReflection.getMethod("testMethod", "Hello"));

        /* 検証の準備 */
        final Throwable       actualCause                   = actualException.getCause();
        final String          actualMessage                 = actualCause.getMessage();
        final String          actualDomainMessage           = actualException.getMessage();
        final KmgMessageTypes actualMessageTypes            = actualException.getMessageTypes();
        final int             actualMessageArgsCount        = actualException.getMessageArgsCount();
        final int             actualMessagePatternArgsCount = actualException.getMessagePatternArgsCount();
        final boolean         actualIsMatchMessageArgsCount = actualException.isMatchMessageArgsCount();

        /* 検証の実施 */
        Assertions.assertTrue(actualCause instanceof IllegalArgumentException,
            "KmgDomainExceptionの原因がIllegalArgumentExceptionであること");
        Assertions.assertEquals(expectedMessage, actualMessage, "IllegalArgumentExceptionのメッセージが正しいこと");
        Assertions.assertEquals(expectedDomainMessage, actualDomainMessage, "KmgDomainExceptionのメッセージが正しいこと");
        Assertions.assertEquals(expectedMessageTypes, actualMessageTypes, "メッセージの種類が正しいこと");
        Assertions.assertEquals(expectedMessageArgsCount, actualMessageArgsCount, "メッセージ引数の数が正しいこと");
        Assertions.assertEquals(expectedMessagePatternArgsCount, actualMessagePatternArgsCount, "メッセージパターンの引数の数が正しいこと");
        Assertions.assertTrue(actualIsMatchMessageArgsCount, "メッセージ引数の数が一致していること");

    }

    /**
     * getMethod メソッドのテスト - InvocationTargetException発生時<br>
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
    public void testGetMethod_invocationTargetException() throws KmgDomainException {

        /* 期待値の定義 */
        final String             expectedMessage                 = "Test invocation target exception";
        final String             expectedDomainMessage           = String.format(
            "メソッドの実行に失敗しました。メソッド名=[%s]、対象のクラス=[%s]", "testMethod",
            "class kmg.core.domain.model.impl.KmgReflectionModelImplTest$TestClass");
        final KmgMsgMessageTypes expectedMessageTypes            = KmgMsgMessageTypes.KMGMSGE11204;
        final int                expectedMessageArgsCount        = 2;
        final int                expectedMessagePatternArgsCount = 2;

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
        final KmgDomainException actualException
            = Assertions.assertThrows(KmgDomainException.class, () -> testReflection.getMethod("testMethod", "Hello"));

        /* 検証の準備 */
        final Throwable       actualCause                   = actualException.getCause();
        final String          actualMessage                 = actualCause.getCause().getMessage();
        final String          actualDomainMessage           = actualException.getMessage();
        final KmgMessageTypes actualMessageTypes            = actualException.getMessageTypes();
        final int             actualMessageArgsCount        = actualException.getMessageArgsCount();
        final int             actualMessagePatternArgsCount = actualException.getMessagePatternArgsCount();
        final boolean         actualIsMatchMessageArgsCount = actualException.isMatchMessageArgsCount();

        /* 検証の実施 */
        Assertions.assertTrue(actualCause instanceof InvocationTargetException,
            "KmgDomainExceptionの原因がInvocationTargetExceptionであること");
        Assertions.assertEquals(expectedMessage, actualMessage, "InvocationTargetExceptionのメッセージが正しいこと");
        Assertions.assertEquals(expectedDomainMessage, actualDomainMessage, "KmgDomainExceptionのメッセージが正しいこと");
        Assertions.assertEquals(expectedMessageTypes, actualMessageTypes, "メッセージの種類が正しいこと");
        Assertions.assertEquals(expectedMessageArgsCount, actualMessageArgsCount, "メッセージ引数の数が正しいこと");
        Assertions.assertEquals(expectedMessagePatternArgsCount, actualMessagePatternArgsCount, "メッセージパターンの引数の数が正しいこと");
        Assertions.assertTrue(actualIsMatchMessageArgsCount, "メッセージ引数の数が一致していること");

    }

    /**
     * getMethod メソッドのテスト - パラメータ数が一致しない場合<br>
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
    public void testGetMethod_mismatchParameterCount() throws KmgDomainException {

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
     * getMethod メソッドのテスト - パラメータの型が一致しない場合<br>
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
    public void testGetMethod_mismatchParameterType() throws KmgDomainException {

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
     * getMethod メソッドのテスト - 存在しないメソッドへのアクセス<br>
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
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
     * getMethod メソッドのテスト - 正常系（パラメータありのメソッド呼び出し）<br>
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
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
     * invoke メソッドのテスト - 正常系<br>
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
    public void testInvoke_normal() throws KmgDomainException {

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
     * invoke メソッドのテスト - SecurityException発生時<br>
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
    public void testInvoke_securityException() throws KmgDomainException {

        /* 期待値の定義 */
        final String             expectedMessage                 = "Test security exception from invoke";
        final String             expectedDomainMessage           = String.format(
            "メソッドの実行に失敗しました。メソッド名=[%s]、対象のクラス=[%s]", "testMethod",
            "class kmg.core.domain.model.impl.KmgReflectionModelImplTest$TestClass");
        final KmgMsgMessageTypes expectedMessageTypes            = KmgMsgMessageTypes.KMGMSGE11204;
        final int                expectedMessageArgsCount        = 2;
        final int                expectedMessagePatternArgsCount = 2;

        /* 準備 */
        final TestClass testObject = new TestClass();

        final KmgReflectionModelImpl testReflection = new KmgReflectionModelImpl(testObject) {

            @Override
            protected Object invoke(final Method method, final Object targetObject, final Object... parameters)
                throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {

                throw new SecurityException(expectedMessage);

            }
        };

        /* テスト対象の実行 */
        final KmgDomainException actualException
            = Assertions.assertThrows(KmgDomainException.class, () -> testReflection.getMethod("testMethod", "Hello"));

        /* 検証の準備 */
        final Throwable       actualCause                   = actualException.getCause();
        final String          actualMessage                 = actualCause.getMessage();
        final String          actualDomainMessage           = actualException.getMessage();
        final KmgMessageTypes actualMessageTypes            = actualException.getMessageTypes();
        final int             actualMessageArgsCount        = actualException.getMessageArgsCount();
        final int             actualMessagePatternArgsCount = actualException.getMessagePatternArgsCount();
        final boolean         actualIsMatchMessageArgsCount = actualException.isMatchMessageArgsCount();

        /* 検証の実施 */
        Assertions.assertTrue(actualCause instanceof SecurityException, "KmgDomainExceptionの原因がSecurityExceptionであること");
        Assertions.assertEquals(expectedMessage, actualMessage, "SecurityExceptionのメッセージが正しいこと");
        Assertions.assertEquals(expectedDomainMessage, actualDomainMessage, "KmgDomainExceptionのメッセージが正しいこと");
        Assertions.assertEquals(expectedMessageTypes, actualMessageTypes, "メッセージの種類が正しいこと");
        Assertions.assertEquals(expectedMessageArgsCount, actualMessageArgsCount, "メッセージ引数の数が正しいこと");
        Assertions.assertEquals(expectedMessagePatternArgsCount, actualMessagePatternArgsCount, "メッセージパターンの引数の数が正しいこと");
        Assertions.assertTrue(actualIsMatchMessageArgsCount, "メッセージ引数の数が一致していること");

    }

    /**
     * set メソッドのテスト - BigDecimalフィールドへの値の設定<br>
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
    public void testSet_bigDecimalField() throws KmgDomainException {

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
     * set メソッドのテスト - IllegalAccessException発生時<br>
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
    public void testSet_illegalAccessException() throws KmgDomainException {

        /* 期待値の定義 */
        final String             expectedMessage                 = "Test illegal access exception from setValue";
        final String             expectedDomainMessage           = String.format(
            "フィールドの値の設定に失敗しました。フィールド名=[%s]、対象のクラス=[%s]、最後に取得したフィールド=[%s]", "publicField",
            "class kmg.core.domain.model.impl.KmgReflectionModelImplTest$TestClass",
            "public java.lang.String kmg.core.domain.model.impl.KmgReflectionModelImplTest$TestClass.publicField");
        final KmgMsgMessageTypes expectedMessageTypes            = KmgMsgMessageTypes.KMGMSGE11205;
        final int                expectedMessageArgsCount        = 3;
        final int                expectedMessagePatternArgsCount = 3;

        /* 準備 */
        final TestClass testObject = new TestClass();

        final KmgReflectionModelImpl testReflection = new KmgReflectionModelImpl(testObject) {

            @Override
            protected void setValue(final Field field, final Object targetObject, final Object value)
                throws SecurityException, IllegalAccessException {

                throw new IllegalAccessException(expectedMessage);

            }
        };

        /* テスト対象の実行 */
        final KmgDomainException actualException
            = Assertions.assertThrows(KmgDomainException.class, () -> testReflection.set("publicField", "test"));

        /* 検証の準備 */
        final Throwable       actualCause                   = actualException.getCause();
        final String          actualMessage                 = actualCause.getMessage();
        final String          actualDomainMessage           = actualException.getMessage();
        final KmgMessageTypes actualMessageTypes            = actualException.getMessageTypes();
        final int             actualMessageArgsCount        = actualException.getMessageArgsCount();
        final int             actualMessagePatternArgsCount = actualException.getMessagePatternArgsCount();
        final boolean         actualIsMatchMessageArgsCount = actualException.isMatchMessageArgsCount();

        /* 検証の実施 */
        Assertions.assertTrue(actualCause instanceof IllegalAccessException,
            "KmgDomainExceptionの原因がIllegalAccessExceptionであること");
        Assertions.assertEquals(expectedMessage, actualMessage, "IllegalAccessExceptionのメッセージが正しいこと");
        Assertions.assertEquals(expectedDomainMessage, actualDomainMessage, "KmgDomainExceptionのメッセージが正しいこと");
        Assertions.assertEquals(expectedMessageTypes, actualMessageTypes, "メッセージの種類が正しいこと");
        Assertions.assertEquals(expectedMessageArgsCount, actualMessageArgsCount, "メッセージ引数の数が正しいこと");
        Assertions.assertEquals(expectedMessagePatternArgsCount, actualMessagePatternArgsCount, "メッセージパターンの引数の数が正しいこと");
        Assertions.assertTrue(actualIsMatchMessageArgsCount, "メッセージ引数の数が一致していること");

    }

    /**
     * set メソッドのテスト - BigDecimalに変換できない値の場合<br>
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
    public void testSet_invalidBigDecimalValue() throws KmgDomainException {

        /* 期待値の定義 */

        /* 準備 */
        final TestClass testObject = new TestClass();

        final KmgReflectionModelImpl testReflection = new KmgReflectionModelImpl(testObject);

        /* テスト対象の実行 */
        final KmgDomainException actualException
            = Assertions.assertThrows(KmgDomainException.class, () -> testReflection.set("decimalField", "invalid"));

        /* 検証の準備 */
        final Throwable actualCause = actualException.getCause();

        /* 検証の実施 */
        Assertions.assertTrue(actualCause instanceof IllegalArgumentException,
            "KmgDomainExceptionの原因がIllegalArgumentExceptionであること");

    }

    /**
     * set メソッドのテスト - 存在しないフィールドへの値の設定<br>
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
    public void testSet_nonExistentField() throws KmgDomainException {

        /* 準備 */
        final TestClass              testObject     = new TestClass();
        final KmgReflectionModelImpl testReflection = new KmgReflectionModelImpl(testObject);

        /* テスト対象の実行 */
        testReflection.set("nonExistentField", "test value");

        /* 検証の実施 */
        Assertions.assertNull(testReflection.getLastGetField(), "存在しないフィールドへの設定時にlastGetFieldがnullであること");

    }

    /**
     * set メソッドのテスト - nullフィールド名を指定<br>
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
    public void testSet_nullFieldName() throws KmgDomainException {

        /* 準備 */
        final TestClass              testObject     = new TestClass();
        final KmgReflectionModelImpl testReflection = new KmgReflectionModelImpl(testObject);

        /* テスト対象の実行 */
        testReflection.set(null, "test value");

        /* 検証の実施 */
        Assertions.assertNull(testReflection.getLastGetField(), "nullフィールド名指定時にlastGetFieldがnullであること");

    }

    /**
     * set メソッドのテスト - 値がnullの場合<br>
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
    public void testSet_nullValue() throws KmgDomainException {

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
     * set メソッドのテスト - プライベートフィールドへの値の設定<br>
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
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
        Assertions.assertEquals(expectedValue, actualValue, "プライベートフィールドに値が正しく設定されること");

    }

    /**
     * set メソッドのテスト - パブリックフィールドへの値の設定<br>
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
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
        Assertions.assertEquals(expectedValue, actualValue, "パブリックフィールドに値が正しく設定されること");

    }

    /**
     * set メソッドのテスト - SecurityException発生時<br>
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
    public void testSet_securityException() throws KmgDomainException {

        /* 期待値の定義 */
        final String             expectedMessage                 = "Test security exception";
        final String             expectedDomainMessage           = String.format(
            "フィールドの取得に失敗しました。フィールド名=[%s]、対象のクラス=[%s]", "publicField",
            "class kmg.core.domain.model.impl.KmgReflectionModelImplTest$TestClass");
        final KmgMsgMessageTypes expectedMessageTypes            = KmgMsgMessageTypes.KMGMSGE11201;
        final int                expectedMessageArgsCount        = 2;
        final int                expectedMessagePatternArgsCount = 2;

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
            = Assertions.assertThrows(KmgDomainException.class, () -> testReflection.set("publicField", "test value"));

        /* 検証の準備 */
        final Throwable       actualCause                   = actualException.getCause();
        final String          actualMessage                 = actualCause.getMessage();
        final String          actualDomainMessage           = actualException.getMessage();
        final KmgMessageTypes actualMessageTypes            = actualException.getMessageTypes();
        final int             actualMessageArgsCount        = actualException.getMessageArgsCount();
        final int             actualMessagePatternArgsCount = actualException.getMessagePatternArgsCount();
        final boolean         actualIsMatchMessageArgsCount = actualException.isMatchMessageArgsCount();

        /* 検証の実施 */
        Assertions.assertTrue(actualCause instanceof SecurityException, "KmgDomainExceptionの原因がSecurityExceptionであること");
        Assertions.assertEquals(expectedMessage, actualMessage, "SecurityExceptionのメッセージが正しいこと");
        Assertions.assertEquals(expectedDomainMessage, actualDomainMessage, "KmgDomainExceptionのメッセージが正しいこと");
        Assertions.assertEquals(expectedMessageTypes, actualMessageTypes, "メッセージの種類が正しいこと");
        Assertions.assertEquals(expectedMessageArgsCount, actualMessageArgsCount, "メッセージ引数の数が正しいこと");
        Assertions.assertEquals(expectedMessagePatternArgsCount, actualMessagePatternArgsCount, "メッセージパターンの引数の数が正しいこと");
        Assertions.assertTrue(actualIsMatchMessageArgsCount, "メッセージ引数の数が一致していること");

    }

}

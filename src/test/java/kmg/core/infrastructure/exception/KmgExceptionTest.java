package kmg.core.infrastructure.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import kmg.core.infrastructure.types.KmgMsgMessageTypes;

/**
 * KMG例外テスト<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
@ExtendWith(MockitoExtension.class)
public class KmgExceptionTest {

    /**
     * コンストラクタのテスト - メッセージタイプのみを指定した場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testConstructor_withMessageTypes() {

        /* 期待値の定義 */
        final KmgMsgMessageTypes expectedMsgTypes = KmgMsgMessageTypes.NONE;
        final String             expectedMessage  = "テストメッセージ";

        /* テスト対象の実行 */
        final KmgException testException = new KmgException(expectedMsgTypes);

        /* 検証の準備 */
        final String             actualMessage  = testException.getMessage();
        final KmgMsgMessageTypes actualMsgTypes = testException.getMessageTypes();

        /* 検証の実施 */
        Assertions.assertEquals(expectedMsgTypes, actualMsgTypes, "メッセージタイプが一致しません");
        Assertions.assertEquals(expectedMessage, actualMessage, "メッセージが一致しません");

    }

    /**
     * コンストラクタのテスト - メッセージタイプとメッセージ引数を指定した場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testConstructor_withMessageTypesAndArgs() {

        /* 期待値の定義 */
        final KmgMsgMessageTypes expectedMsgTypes = KmgMsgMessageTypes.NONE;
        final Object[]           expectedMsgArgs  = {
            "テスト引数1", "テスト引数2"
        };
        final String             expectedMessage  = "テストメッセージ";

        /* テスト対象の実行 */
        final KmgException testException = new KmgException(expectedMsgTypes, expectedMsgArgs);

        /* 検証の準備 */
        final String             actualMessage  = testException.getMessage();
        final KmgMsgMessageTypes actualMsgTypes = testException.getMessageTypes();
        final Object[]           actualMsgArgs  = testException.getMessageArgs();

        /* 検証の実施 */
        Assertions.assertEquals(expectedMsgTypes, actualMsgTypes, "メッセージタイプが一致しません");
        Assertions.assertEquals(expectedMessage, actualMessage, "メッセージが一致しません");
        Assertions.assertArrayEquals(expectedMsgArgs, actualMsgArgs, "メッセージ引数が一致しません");

    }

    /**
     * コンストラクタのテスト - メッセージタイプと原因を指定した場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testConstructor_withMessageTypesAndCause() {

        /* 期待値の定義 */
        final KmgMsgMessageTypes expectedMsgTypes = KmgMsgMessageTypes.NONE;
        final String             expectedMessage  = "テストメッセージ";
        final Throwable          expectedCause    = new RuntimeException("テスト原因");

        /* テスト対象の実行 */
        final KmgException testException = new KmgException(expectedMsgTypes, expectedCause);

        /* 検証の準備 */
        final String             actualMessage  = testException.getMessage();
        final KmgMsgMessageTypes actualMsgTypes = testException.getMessageTypes();
        final Throwable          actualCause    = testException.getCause();

        /* 検証の実施 */
        Assertions.assertEquals(expectedMsgTypes, actualMsgTypes, "メッセージタイプが一致しません");
        Assertions.assertEquals(expectedMessage, actualMessage, "メッセージが一致しません");
        Assertions.assertEquals(expectedCause, actualCause, "原因が一致しません");

    }

    /**
     * コンストラクタのテスト - メッセージタイプ、メッセージ引数、原因を指定した場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testConstructor_withMessageTypesArgsAndCause() {

        /* 期待値の定義 */
        final KmgMsgMessageTypes expectedMsgTypes = KmgMsgMessageTypes.NONE;
        final Object[]           expectedMsgArgs  = {
            "テスト引数1", "テスト引数2"
        };
        final String             expectedMessage  = "テストメッセージ";
        final Throwable          expectedCause    = new RuntimeException("テスト原因");

        /* テスト対象の実行 */
        final KmgException testException = new KmgException(expectedMsgTypes, expectedMsgArgs, expectedCause);

        /* 検証の準備 */
        final String             actualMessage  = testException.getMessage();
        final KmgMsgMessageTypes actualMsgTypes = testException.getMessageTypes();
        final Object[]           actualMsgArgs  = testException.getMessageArgs();
        final Throwable          actualCause    = testException.getCause();

        /* 検証の実施 */
        Assertions.assertEquals(expectedMsgTypes, actualMsgTypes, "メッセージタイプが一致しません");
        Assertions.assertEquals(expectedMessage, actualMessage, "メッセージが一致しません");
        Assertions.assertArrayEquals(expectedMsgArgs, actualMsgArgs, "メッセージ引数が一致しません");
        Assertions.assertEquals(expectedCause, actualCause, "原因が一致しません");

    }

    /**
     * getMessageArgsCount メソッドのテスト - メッセージ引数がある場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGetMessageArgsCount_withArgs() {

        /* 期待値の定義 */
        final int expectedCount = 2;

        /* 準備 */
        final Object[] testMsgArgs = {
            "テスト引数1", "テスト引数2"
        };

        /* テスト対象の実行 */
        final KmgException testException = new KmgException(KmgMsgMessageTypes.NONE, testMsgArgs);

        /* 検証の準備 */
        final int actualCount = testException.getMessageArgsCount();

        /* 検証の実施 */
        Assertions.assertEquals(expectedCount, actualCount, "メッセージ引数の数が一致しません");

    }

    /**
     * getMessageArgsCount メソッドのテスト - メッセージ引数がnullの場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGetMessageArgsCount_withNullArgs() {

        /* 期待値の定義 */
        final int expectedCount = 0;

        /* テスト対象の実行 */
        final KmgException testException = new KmgException(KmgMsgMessageTypes.NONE);

        /* 検証の準備 */
        final int actualCount = testException.getMessageArgsCount();

        /* 検証の実施 */
        Assertions.assertEquals(expectedCount, actualCount, "メッセージ引数の数が0であること");

    }

    /**
     * getMessagePatternArgsCount メソッドのテスト
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGetMessagePatternArgsCount() {

        /* 期待値の定義 */
        final int expectedCount = 0;

        /* テスト対象の実行 */
        final KmgException testException = new KmgException(KmgMsgMessageTypes.NONE);

        /* 検証の準備 */
        final int actualCount = testException.getMessagePatternArgsCount();

        /* 検証の実施 */
        Assertions.assertEquals(expectedCount, actualCount, "メッセージパターンの引数の数が一致しません");

    }

    /**
     * isMatchMessageArgsCount メソッドのテスト - メッセージ引数の数が一致する場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testIsMatchMessageArgsCount_matching() {

        /* 期待値の定義 */
        final boolean expectedIsMatch = true;

        /* 準備 */
        final Object[] testMsgArgs = {
            "テスト引数1"
        };

        /* テスト対象の実行 */
        final KmgException testException = new KmgException(KmgMsgMessageTypes.KMGMSGE11100, testMsgArgs);

        /* 検証の準備 */
        final boolean actualIsMatch = testException.isMatchMessageArgsCount();

        /* 検証の実施 */
        Assertions.assertEquals(expectedIsMatch, actualIsMatch, "メッセージ引数の数が一致しているか");

    }

    /**
     * isMatchMessageArgsCount メソッドのテスト - メッセージ引数の数が一致しない場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testIsMatchMessageArgsCount_notMatching() {

        /* 期待値の定義 */
        final boolean expectedIsMatch = false;

        /* 準備 */
        final Object[] testMsgArgs = {
            "テスト引数1", "テスト引数2"
        };

        /* テスト対象の実行 */
        final KmgException testException = new KmgException(KmgMsgMessageTypes.KMGMSGE11100, testMsgArgs);

        /* 検証の準備 */
        final boolean actualIsMatch = testException.isMatchMessageArgsCount();

        /* 検証の実施 */
        Assertions.assertEquals(expectedIsMatch, actualIsMatch, "メッセージ引数の数が一致していないか");

    }
}

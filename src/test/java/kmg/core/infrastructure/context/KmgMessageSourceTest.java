package kmg.core.infrastructure.context;

import java.util.Locale;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.context.MessageSource;

import kmg.core.infrastructure.types.KmgMsgMessageTypes;

/**
 * {@link KmgMessageSource}のテストクラス
 */
public class KmgMessageSourceTest {

    /** テスト対象 */
    @InjectMocks
    private KmgMessageSource testTarget;

    /** MessageSourceのモック */
    @Mock
    private MessageSource messageSource;

    /** AutoCloseable */
    private AutoCloseable closeable;

    /**
     * テストの準備
     *
     * @throws Exception
     *                   例外が発生した場合
     */
    @BeforeEach
    public void setUp() throws Exception {

        try (AutoCloseable autoCloseable = MockitoAnnotations.openMocks(this)) {

            this.closeable = autoCloseable;

        }

    }

    /**
     * テストの後処理
     *
     * @throws Exception
     *                   例外が発生した場合
     */
    @AfterEach
    public void tearDown() throws Exception {

        if (this.closeable == null) {

            return;

        }
        this.closeable.close();

    }

    /**
     * getMessage メソッドのテスト - 引数なしの場合
     */
    @Test
    public void testGetMessage_noArgs() {

        /* 期待値の定義 */
        final String             expectedMessage = "テストメッセージ";
        final KmgMsgMessageTypes testMessageType = KmgMsgMessageTypes.KMGMSGE11100;

        /* 準備 */
        Mockito.when(this.messageSource.getMessage(ArgumentMatchers.anyString(), ArgumentMatchers.any(),
            ArgumentMatchers.any(Locale.class))).thenReturn(expectedMessage);

        /* テスト対象の実行 */
        final String actualMessage = this.testTarget.getMessage(testMessageType);

        /* 検証の実施 */
        Assertions.assertEquals(expectedMessage, actualMessage, "メッセージが一致しません");

    }

    /**
     * getMessage メソッドのテスト - 引数ありの場合
     */
    @Test
    public void testGetMessage_withArgs() {

        /* 期待値の定義 */
        final String             expectedMessage = "テストメッセージ with args";
        final KmgMsgMessageTypes testMessageType = KmgMsgMessageTypes.KMGMSGE11100;
        final Object[]           testArgs        = {
            "arg1", "arg2"
        };

        /* 準備 */
        Mockito.when(this.messageSource.getMessage(ArgumentMatchers.anyString(), ArgumentMatchers.any(),
            ArgumentMatchers.any(Locale.class))).thenReturn(expectedMessage);

        /* テスト対象の実行 */
        final String actualMessage = this.testTarget.getMessage(testMessageType, testArgs);

        /* 検証の実施 */
        Assertions.assertEquals(expectedMessage, actualMessage, "メッセージが一致しません");

    }
}

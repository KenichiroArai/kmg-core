package kmg.core.infrastructure.model.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import kmg.core.infrastructure.context.KmgMessageSource;
import kmg.core.infrastructure.model.KmgMessageModel;
import kmg.core.infrastructure.types.KmgMsgMessageTypes;

/**
 * KMGメッセージモデルファクトリテスト<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
@ExtendWith(MockitoExtension.class)
public class KmgMessageModelFactoryTest {

    /** テスト対象 */
    @InjectMocks
    private KmgMessageModelFactory testTarget;

    /** KMGメッセージリソースのモック */
    @Mock
    private KmgMessageSource kmgMessageSource;

    /**
     * create メソッドのテスト - メッセージの種類のみを指定した場合
     */
    @Test
    public void testCreate_withMessageTypesOnly() {

        /* 期待値の定義 */
        final KmgMsgMessageTypes expectedMsgTypes = KmgMsgMessageTypes.NONE;
        final String             expectedMessage  = "テストメッセージ";

        /* 準備 */
        Mockito.when(this.kmgMessageSource.getMessage(expectedMsgTypes, null)).thenReturn(expectedMessage);

        /* テスト対象の実行 */
        final KmgMessageModel testModel = this.testTarget.create(expectedMsgTypes);

        /* 検証の準備 */
        final KmgMsgMessageTypes actualMsgTypes = testModel.getMessageTypes();
        final Object[]           actualMsgArgs  = testModel.getMessageArgs();
        final String             actualMessage  = testModel.getMessage();

        /* 検証の実施 */
        Assertions.assertEquals(expectedMsgTypes, actualMsgTypes, "メッセージの種類が一致しません");
        Assertions.assertNull(actualMsgArgs, "メッセージの引数がnullではありません");
        Assertions.assertEquals(expectedMessage, actualMessage, "メッセージが一致しません");

    }

    /**
     * create メソッドのテスト - メッセージの種類と引数を指定した場合
     */
    @Test
    public void testCreate_withMessageTypesAndArgs() {

        /* 期待値の定義 */
        final KmgMsgMessageTypes expectedMsgTypes = KmgMsgMessageTypes.KMGMSGE11100;
        final Object[]           expectedMsgArgs  = {
            "テスト引数"
        };
        final String             expectedMessage  = "テストメッセージ";

        /* 準備 */
        Mockito.when(this.kmgMessageSource.getMessage(expectedMsgTypes, expectedMsgArgs)).thenReturn(expectedMessage);

        /* テスト対象の実行 */
        final KmgMessageModel testModel = this.testTarget.create(expectedMsgTypes, expectedMsgArgs);

        /* 検証の準備 */
        final KmgMsgMessageTypes actualMsgTypes = testModel.getMessageTypes();
        final Object[]           actualMsgArgs  = testModel.getMessageArgs();
        final String             actualMessage  = testModel.getMessage();

        /* 検証の実施 */
        Assertions.assertEquals(expectedMsgTypes, actualMsgTypes, "メッセージの種類が一致しません");
        Assertions.assertArrayEquals(expectedMsgArgs, actualMsgArgs, "メッセージの引数が一致しません");
        Assertions.assertEquals(expectedMessage, actualMessage, "メッセージが一致しません");

    }
}

package kmg.core.infrastructure.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.jupiter.api.Assertions;

import kmg.core.infrastructure.cmn.msg.KmgCmnExcMsgTypes;
import kmg.core.infrastructure.cmn.msg.KmgCmnGenMsgTypes;
import kmg.core.infrastructure.exception.KmgMsgException;

/**
 * KMGのテストの抽象クラス<br>
 *
 * @author KenichiroArai
 *
 * @since 0.2.0
 *
 * @version 0.2.0
 */
@SuppressWarnings({
    "nls", "static-method",
})
public abstract class AbstractKmgTest {

    /**
     * ファイルの内容を確認し、デバッグ情報を出力する
     *
     * @param filePath
     *                 確認対象のファイルパス
     *
     * @since 0.1.0
     */
    protected static void verifyFileContent(final Path filePath) {

        System.out.println(String.format("FilePath: %s", filePath.toAbsolutePath()));

        if (!Files.exists(filePath)) {

            System.out.println("ファイルが存在しません。");
            return;

        }

        List<String> lines;

        try {

            lines = Files.readAllLines(filePath);

        } catch (final IOException e) {

            e.printStackTrace();
            return;

        }
        System.out.println("==== ファイルの内容 ====");

        for (final String line : lines) {

            System.out.println(line);

        }
        System.out.println("==== ここまで ====");

    }

    /**
     * デフォルトコンストラクタ<br>
     *
     * @since 0.2.0
     */
    public AbstractKmgTest() {

        // 処理なし
    }

    /**
     * KMG例外の検証を行う<br>
     * <p>
     * 期待する原因のクラスがnullの場合は、nullであることを検証する。
     * </p>
     *
     * @since 0.2.0
     *
     * @param actualException
     *                              実際の例外
     * @param expectedCauseClass
     *                              期待する原因のクラス
     * @param expectedDomainMessage
     *                              期待するドメインメッセージ
     * @param expectedMessageTypes
     *                              期待するメッセージの種類
     */
    protected void verifyKmgMsgException(final KmgMsgException actualException, final Class<?> expectedCauseClass,
        final String expectedDomainMessage, final KmgCmnGenMsgTypes expectedMessageTypes) {

        /* 期待する原因のクラスがnullか */
        if (expectedCauseClass == null) {
            // nullの場合

            // 期待する原因のクラスがnullとして検証する
            this.verifyKmgMsgException(actualException, expectedDomainMessage, expectedMessageTypes);
            return;

        }

        /* 検証の準備 */
        final Throwable         actualCause                   = actualException.getCause();                // 実際の例外の原因
        final String            actualDomainMessage           = actualException.getMessage();              // 実際のドメインメッセージ
        final KmgCmnExcMsgTypes actualMessageTypes            = actualException.getMessageTypes();         // 実際のメッセージタイプ
        final boolean           actualIsMatchMessageArgsCount = actualException.isMatchMessageArgsCount(); // 実際のメッセージ引数の数

        /* 検証の実施 */
        Assertions.assertInstanceOf(expectedCauseClass, actualCause,
            String.format("KmgMsgExceptionの原因が%sであること", expectedCauseClass.getSimpleName()));

        Assertions.assertEquals(expectedDomainMessage, actualDomainMessage, "KmgDomainExceptionのメッセージが正しいこと");
        Assertions.assertEquals(expectedMessageTypes, actualMessageTypes, "メッセージの種類が正しいこと");
        Assertions.assertTrue(actualIsMatchMessageArgsCount, "メッセージ引数の数が一致していること");

    }

    /**
     * KMG例外の検証を行う<br>
     * <p>
     * 実際の例外の原因のクラスがnullであることを検証する。
     * </p>
     *
     * @since 0.2.0
     *
     * @param actualException
     *                              実際の例外
     * @param expectedDomainMessage
     *                              期待するドメインメッセージ
     * @param expectedMessageTypes
     *                              期待するメッセージの種類
     */
    protected void verifyKmgMsgException(final KmgMsgException actualException, final String expectedDomainMessage,
        final KmgCmnGenMsgTypes expectedMessageTypes) {

        /* 検証の準備 */
        final Throwable         actualCause                   = actualException.getCause();                // 実際の例外の原因
        final String            actualDomainMessage           = actualException.getMessage();              // 実際のドメインメッセージ
        final KmgCmnExcMsgTypes actualMessageTypes            = actualException.getMessageTypes();         // 実際のメッセージタイプ
        final boolean           actualIsMatchMessageArgsCount = actualException.isMatchMessageArgsCount(); // 実際のメッセージ引数の数

        /* 検証の実施 */
        Assertions.assertNull(actualCause, "KmgMsgExceptionの原因がnullであること");
        Assertions.assertEquals(expectedDomainMessage, actualDomainMessage, "KmgDomainExceptionのメッセージが正しいこと");
        Assertions.assertEquals(expectedMessageTypes, actualMessageTypes, "メッセージの種類が正しいこと");
        Assertions.assertTrue(actualIsMatchMessageArgsCount, "メッセージ引数の数が一致していること");

    }
}

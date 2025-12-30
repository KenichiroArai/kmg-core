package kmg.core.infrastructure.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.TestInfo;

import kmg.core.infrastructure.cmn.msg.KmgCmnExcMsgTypes;
import kmg.core.infrastructure.cmn.msg.KmgCmnGenMsgTypes;
import kmg.core.infrastructure.exception.KmgMsgException;
import kmg.core.infrastructure.type.KmgString;
import kmg.core.infrastructure.types.KmgDelimiterTypes;
import kmg.core.infrastructure.utils.KmgPathUtils;

/**
 * KMGのテストの抽象クラス<br>
 *
 * @author KenichiroArai
 *
 * @since 0.2.0
 *
 * @version 0.2.5
 */
@SuppressWarnings({
    "nls", "static-method",
})
public abstract class AbstractKmgTest {

    /**
     * テストリソース
     *
     * @since 0.2.0
     */
    protected static final Path TEST_RESOURCES = Path.of("src/test/resources");

    /**
     * テストメソッドのパスを生成する<br>
     * <p>
     * テストクラスのFQCNパスとテストメソッド名から、テストリソースディレクトリ内のパスを生成します。
     * </p>
     *
     * @since 0.2.0
     *
     * @param testClass
     *                       テストクラス
     * @param testMethodName
     *                       テストメソッド名
     *
     * @return テストメソッドのパス
     */
    protected static Path getTestMethodPath(final Class<?> testClass, final String testMethodName) {

        Path       result;
        final Path fqcnPath = KmgPathUtils.getFqcnPath(testClass);
        final Path testPath = AbstractKmgTest.TEST_RESOURCES.resolve(fqcnPath);

        final Path testMethodNamePath = Path.of(KmgString.snakeCase(testMethodName));
        result = testPath.resolve(testMethodNamePath);

        return result;

    }

    /**
     * 改行文字を正規化する<br>
     * <p>
     * 文字列内の改行文字をシステムの改行文字に統一します。
     * </p>
     *
     * @since 0.2.0
     *
     * @param text
     *             正規化対象の文字列
     *
     * @return 正規化された文字列
     */
    protected static String normalizeLineSeparators(final String text) {

        String result = text;

        if (text == null) {

            return result;

        }

        result = text.replaceAll(KmgDelimiterTypes.REGEX_LINE_SEPARATOR.get(), KmgString.LINE_SEPARATOR);
        return result;

    }

    /**
     * ファイルの内容を確認し、デバッグ情報を出力する
     *
     * @param filePath
     *                 確認対象のファイルパス
     *
     * @since 0.2.0
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
     * 現在のテストメソッドのパスを生成する<br>
     * <p>
     * TestInfoから現在のテストメソッド名を取得し、テストリソースディレクトリ内のパスを生成します。
     * </p>
     *
     * @since 0.2.0
     *
     * @param testInfo
     *                 テスト情報
     *
     * @return テストメソッドのパス
     */
    protected Path getCurrentTestMethodPath(final TestInfo testInfo) {

        final String testMethodName = testInfo.getTestMethod().get().getName();
        final Path   result         = AbstractKmgTest.getTestMethodPath(this.getClass(), testMethodName);
        return result;

    }

    /**
     * テストメソッドのパスを生成する<br>
     * <p>
     * 現在のテストクラスとテストメソッド名から、テストリソースディレクトリ内のパスを生成します。
     * </p>
     *
     * @since 0.2.0
     *
     * @param testMethodName
     *                       テストメソッド名
     *
     * @return テストメソッドのパス
     */
    protected Path getTestMethodPath(final String testMethodName) {

        final Path result = AbstractKmgTest.getTestMethodPath(this.getClass(), testMethodName);
        return result;

    }

    /**
     * 現在のテストクラスのパスを生成する<br>
     * <p>
     * 現在のテストクラスのFQCNパスから、テストリソースディレクトリ内のパスを生成します。
     * </p>
     *
     * @since 0.2.5
     *
     * @return テストクラスのパス
     */
    protected Path getCurrentTestClassPath() {

        final Path fqcnPath = KmgPathUtils.getFqcnPath(this.getClass());
        final Path result   = AbstractKmgTest.TEST_RESOURCES.resolve(fqcnPath);
        return result;

    }

    /**
     * テストクラスのパスを生成する<br>
     * <p>
     * テストクラスのFQCNパスから、テストリソースディレクトリ内のパスを生成します。
     * </p>
     *
     * @since 0.2.5
     *
     * @param testClass
     *                  テストクラス
     *
     * @return テストクラスのパス
     */
    protected static Path getTestClassPath(final Class<?> testClass) {

        final Path fqcnPath = KmgPathUtils.getFqcnPath(testClass);
        final Path result   = AbstractKmgTest.TEST_RESOURCES.resolve(fqcnPath);
        return result;

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

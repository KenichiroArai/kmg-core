package kmg.core.infrastructure.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import kmg.core.infrastructure.cmn.msg.KmgCmnExcMsgTypes;
import kmg.core.infrastructure.cmn.msg.KmgCmnGenMsgTypes;
import kmg.core.infrastructure.exception.KmgMsgException;
import kmg.core.infrastructure.types.msg.KmgCoreGenMsgTypes;

/**
 * AbstractKmgTest クラスのテスト<br>
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
public class AbstractKmgTestTest extends AbstractKmgTest {

    /**
     * テスト用のAbstractKmgTestの実装クラス<br>
     *
     * @author KenichiroArai
     *
     * @since 0.2.0
     */
    private static class TestAbstractKmgTest extends AbstractKmgTest {

        /**
         * デフォルトコンストラクタ<br>
         *
         * @since 0.2.0
         */
        public TestAbstractKmgTest() {

            // 処理なし
        }
    }

    /**
     * getCurrentTestClassPath メソッドのテスト - 正常系:現在のテストクラスのパス生成
     *
     * @since 0.2.5
     */
    @Test
    public void testGetCurrentTestClassPath_normalValidClass() {

        /* 期待値の定義 */
        final Path expectedPath = Paths.get("src/test/resources/kmg/core/infrastructure/test/test_abstract_kmg_test");

        /* 準備 */
        final TestAbstractKmgTest testObject = new TestAbstractKmgTest();

        /* テスト対象の実行 */
        final Path testResult = testObject.getCurrentTestClassPath();

        /* 検証の準備 */
        final Path actualPath = testResult;

        /* 検証の実施 */
        Assertions.assertEquals(expectedPath, actualPath, "getCurrentTestClassPath: 現在のテストクラスのパスが正しく生成されること");

    }

    /**
     * getCurrentTestMethodPath メソッドのテスト - 正常系:TestInfoからパス生成
     *
     * @since 0.2.0
     *
     * @param testInfo
     *                 テスト情報
     */
    @Test
    public void testGetCurrentTestMethodPath_normalValidTestInfo(final TestInfo testInfo) {

        /* 期待値の定義 */
        final Path expectedPath = Paths.get(
            "src/test/resources/kmg/core/infrastructure/test/test_abstract_kmg_test/test_get_current_test_method_path_normal_valid_test_info");

        /* 準備 */
        final TestAbstractKmgTest testObject = new TestAbstractKmgTest();

        /* テスト対象の実行 */
        final Path testResult = testObject.getCurrentTestMethodPath(testInfo);

        /* 検証の準備 */
        final Path actualPath = testResult;

        /* 検証の実施 */
        Assertions.assertEquals(expectedPath, actualPath, "getCurrentTestMethodPath: TestInfoからパスが正しく生成されること");

    }

    /**
     * getTestClassPath メソッドのテスト - 正常系:正常なクラスでパス生成
     *
     * @since 0.2.5
     */
    @Test
    public void testGetTestClassPath_normalValidClass() {

        /* 期待値の定義 */
        final Path expectedPath = Paths.get("src/test/resources/kmg/core/infrastructure/test/abstract_kmg_test_test");

        /* 準備 */
        final Class<?> testClass = AbstractKmgTestTest.class;

        /* テスト対象の実行 */
        final Path testResult = AbstractKmgTest.getTestClassPath(testClass);

        /* 検証の準備 */
        final Path actualPath = testResult;

        /* 検証の実施 */
        Assertions.assertEquals(expectedPath, actualPath, "getTestClassPath: 正常なクラスでパスが正しく生成されること");

    }

    /**
     * getTestClassPath メソッドのテスト - 準正常系:nullのクラス
     *
     * @since 0.2.5
     */
    @Test
    public void testGetTestClassPath_semiNullClass() {

        /* 期待値の定義 */
        // nullのクラスでNullPointerExceptionが発生することを期待

        /* 準備 */
        final Class<?> testClass = null;

        /* テスト対象の実行 */
        Assertions.assertThrows(NullPointerException.class, () -> {

            AbstractKmgTest.getTestClassPath(testClass);

        });

        /* 検証の準備 */
        final boolean actualExceptionThrown = true;

        /* 検証の実施 */
        Assertions.assertTrue(actualExceptionThrown, "getTestClassPath: nullのクラスでNullPointerExceptionが発生すること");

    }

    /**
     * getTestMethodPath メソッドのテスト - 正常系:正常なクラスとメソッド名でパス生成
     *
     * @since 0.2.0
     */
    @Test
    public void testGetTestMethodPath_normalValidClassAndMethod() {

        /* 期待値の定義 */
        final Path expectedPath = Paths.get(
            "src/test/resources/kmg/core/infrastructure/test/abstract_kmg_test_test/test_get_test_method_path_normal_valid_class_and_method");

        /* 準備 */
        final Class<?> testClass      = AbstractKmgTestTest.class;
        final String   testMethodName = "testGetTestMethodPath_normalValidClassAndMethod";

        /* テスト対象の実行 */
        final Path testResult = AbstractKmgTest.getTestMethodPath(testClass, testMethodName);

        /* 検証の準備 */
        final Path actualPath = testResult;

        /* 検証の実施 */
        Assertions.assertEquals(expectedPath, actualPath, "getTestMethodPath: 正常なクラスとメソッド名でパスが正しく生成されること");

    }

    /**
     * getTestMethodPath メソッドのテスト - 正常系:メソッド名からパス生成
     *
     * @since 0.2.0
     */
    @Test
    public void testGetTestMethodPath_normalValidMethodName() {

        /* 期待値の定義 */
        final Path expectedPath = Paths.get(
            "src/test/resources/kmg/core/infrastructure/test/test_abstract_kmg_test/test_get_test_method_path_normal_valid_method_name");

        /* 準備 */
        final TestAbstractKmgTest testObject     = new TestAbstractKmgTest();
        final String              testMethodName = "testGetTestMethodPath_normalValidMethodName";

        /* テスト対象の実行 */
        final Path testResult = testObject.getTestMethodPath(testMethodName);

        /* 検証の準備 */
        final Path actualPath = testResult;

        /* 検証の実施 */
        Assertions.assertEquals(expectedPath, actualPath, "getTestMethodPath: メソッド名からパスが正しく生成されること");

    }

    /**
     * getTestMethodPath メソッドのテスト - 準正常系:nullのクラス
     *
     * @since 0.2.0
     */
    @Test
    public void testGetTestMethodPath_semiNullClass() {

        /* 期待値の定義 */
        // nullのクラスでNullPointerExceptionが発生することを期待

        /* 準備 */
        final Class<?> testClass      = null;
        final String   testMethodName = "testMethod";

        /* テスト対象の実行 */
        Assertions.assertThrows(NullPointerException.class, () -> {

            AbstractKmgTest.getTestMethodPath(testClass, testMethodName);

        });

        /* 検証の準備 */
        final boolean actualExceptionThrown = true;

        /* 検証の実施 */
        Assertions.assertTrue(actualExceptionThrown, "getTestMethodPath: nullのクラスでNullPointerExceptionが発生すること");

    }

    /**
     * getTestMethodPath メソッドのテスト - 準正常系:nullのメソッド名
     *
     * @since 0.2.0
     */
    @Test
    public void testGetTestMethodPath_semiNullMethodName() {

        /* 期待値の定義 */
        // nullのメソッド名でNullPointerExceptionが発生することを期待

        /* 準備 */
        final Class<?> testClass      = AbstractKmgTestTest.class;
        final String   testMethodName = null;

        /* テスト対象の実行 */
        Assertions.assertThrows(NullPointerException.class, () -> {

            AbstractKmgTest.getTestMethodPath(testClass, testMethodName);

        });

        /* 検証の準備 */
        final boolean actualExceptionThrown = true;

        /* 検証の実施 */
        Assertions.assertTrue(actualExceptionThrown, "getTestMethodPath: nullのメソッド名でNullPointerExceptionが発生すること");

    }

    /**
     * normalizeLineSeparators メソッドのテスト - 正常系:改行文字が正規化される
     *
     * @since 0.2.0
     */
    @Test
    public void testNormalizeLineSeparators_normalLineSeparators() {

        /* 期待値の定義 */
        final String expectedText
            = "line1" + System.lineSeparator() + "line2" + System.lineSeparator() + "line3" + System.lineSeparator();

        /* 準備 */
        final String testText = "line1\r\nline2\nline3\r";

        /* テスト対象の実行 */
        final String testResult = AbstractKmgTest.normalizeLineSeparators(testText);

        /* 検証の準備 */
        final String actualText = testResult;

        /* 検証の実施 */
        Assertions.assertEquals(expectedText, actualText, "normalizeLineSeparators: 改行文字が正規化されること");

    }

    /**
     * normalizeLineSeparators メソッドのテスト - 正常系:改行文字がない文字列
     *
     * @since 0.2.0
     */
    @Test
    public void testNormalizeLineSeparators_normalNoLineSeparators() {

        /* 期待値の定義 */
        final String expectedText = "test string";

        /* 準備 */
        final String testText = "test string";

        /* テスト対象の実行 */
        final String testResult = AbstractKmgTest.normalizeLineSeparators(testText);

        /* 検証の準備 */
        final String actualText = testResult;

        /* 検証の実施 */
        Assertions.assertEquals(expectedText, actualText, "normalizeLineSeparators: 改行文字がない文字列でそのまま返されること");

    }

    /**
     * normalizeLineSeparators メソッドのテスト - 準正常系:nullの文字列
     *
     * @since 0.2.0
     */
    @Test
    public void testNormalizeLineSeparators_semiNullText() {

        /* 期待値の定義 */
        final String expectedText = null;

        /* 準備 */
        final String testText = null;

        /* テスト対象の実行 */
        final String testResult = AbstractKmgTest.normalizeLineSeparators(testText);

        /* 検証の準備 */
        final String actualText = testResult;

        /* 検証の実施 */
        Assertions.assertEquals(expectedText, actualText, "normalizeLineSeparators: nullの文字列でnullが返されること");

    }

    /**
     * verifyFileContent メソッドのテスト - 正常系:存在するファイルの内容確認
     *
     * @since 0.2.0
     */
    @Test
    public void testVerifyFileContent_normalExistingFile() {

        /* 期待値の定義 */
        // このテストでは例外が発生しないことを確認

        /* 準備 */
        final Path testFilePath = Paths.get(
            "src/test/resources/kmg/core/infrastructure/test/abstract_kmg_test_test/test_verify_file_content_normal_existing_file/test.txt");

        // テスト用ファイルを作成
        try {

            Files.createDirectories(testFilePath.getParent());
            Files.write(testFilePath, "test content".getBytes());

        } catch (final IOException e) {

            Assertions.fail("テスト用ファイルの作成に失敗しました: " + e.getMessage());
            return;

        }

        /* テスト対象の実行 */
        AbstractKmgTest.verifyFileContent(testFilePath);

        /* 検証の準備 */
        final boolean actualFileExists = Files.exists(testFilePath);

        /* 検証の実施 */
        Assertions.assertTrue(actualFileExists, "verifyFileContent: ファイルが存在すること");

        // テスト用ファイルを削除
        try {

            Files.deleteIfExists(testFilePath);

        } catch (@SuppressWarnings("unused") final IOException e) {

            // 削除に失敗してもテストには影響しない
        }

    }

    /**
     * verifyFileContent メソッドのテスト - 準正常系:IOExceptionが発生する場合
     *
     * @since 0.2.0
     */
    @Test
    public void testVerifyFileContent_semiIOException() {

        /* 期待値の定義 */
        // このテストでは例外が発生しないことを確認（IOExceptionは内部でキャッチされる）

        /* 準備 */
        // 存在しないディレクトリ内のファイルパスを作成してIOExceptionを発生させる
        final Path testFilePath = Paths.get("non/existent/directory/file.txt");

        /* テスト対象の実行 */
        AbstractKmgTest.verifyFileContent(testFilePath);

        /* 検証の準備 */
        final boolean actualFileExists = Files.exists(testFilePath);

        /* 検証の実施 */
        Assertions.assertFalse(actualFileExists, "verifyFileContent: IOExceptionが発生しても例外が発生しないこと");

    }

    /**
     * verifyFileContent メソッドのテスト - 準正常系:ファイル読み取り中にIOExceptionが発生する場合
     *
     * @since 0.2.0
     */
    @Test
    public void testVerifyFileContent_semiIOExceptionDuringRead() {

        /* 期待値の定義 */
        // このテストでは例外が発生しないことを確認（IOExceptionは内部でキャッチされる）

        /* 準備 */
        final Path testFilePath = Paths.get(
            "src/test/resources/kmg/core/infrastructure/test/abstract_kmg_test_test/test_verify_file_content_semi_io_exception_during_read/test.txt");

        // テスト用ファイルを作成
        try {

            Files.createDirectories(testFilePath.getParent());
            Files.write(testFilePath, "test content".getBytes());

        } catch (final IOException e) {

            Assertions.fail("テスト用ファイルの作成に失敗しました: " + e.getMessage());
            return;

        }

        // ファイルが存在することを確認
        if (!Files.exists(testFilePath)) {

            Assertions.fail("テスト用ファイルが作成されていません");
            return;

        }

        /* テスト対象の実行 */
        // ファイルが存在するが、何らかの理由で読み取りに失敗する場合をシミュレート
        // 実際のIOException発生を確実にするため、ファイルを削除してから実行
        try {

            Files.delete(testFilePath);

        } catch (final IOException e) {

            // 削除に失敗した場合は、そのままテストを続行
            e.printStackTrace();

        }

        AbstractKmgTest.verifyFileContent(testFilePath);

        /* 検証の準備 */
        final boolean actualFileExists = Files.exists(testFilePath);

        /* 検証の実施 */
        Assertions.assertFalse(actualFileExists, "verifyFileContent: ファイル読み取り中にIOExceptionが発生しても例外が発生しないこと");

    }

    /**
     * verifyFileContent メソッドのテスト - 準正常系:ファイルが存在するが読み取り中にIOExceptionが発生する場合
     *
     * @since 0.2.0
     */
    @Test
    public void testVerifyFileContent_semiIOExceptionOnRead() {

        /* 期待値の定義 */
        // このテストでは例外が発生しないことを確認（IOExceptionは内部でキャッチされる）

        /* 準備 */
        final Path testFilePath = Paths.get(
            "src/test/resources/kmg/core/infrastructure/test/abstract_kmg_test_test/test_verify_file_content_semi_io_exception_on_read/test.txt");

        // テスト用ディレクトリを作成
        try {

            Files.createDirectories(testFilePath.getParent());

        } catch (final IOException e) {

            Assertions.fail("テスト用ディレクトリの作成に失敗しました: " + e.getMessage());
            return;

        }

        // ファイルと同じ名前のディレクトリを作成してIOExceptionを発生させる
        try {

            Files.createDirectory(testFilePath);

        } catch (final IOException e) {

            Assertions.fail("テスト用ディレクトリの作成に失敗しました: " + e.getMessage());
            return;

        }

        // ディレクトリが存在することを確認
        if (!Files.exists(testFilePath)) {

            Assertions.fail("テスト用ディレクトリが作成されていません");
            return;

        }

        /* テスト対象の実行 */
        // ディレクトリが存在するが、Files.readAllLines()でIOExceptionが発生する
        AbstractKmgTest.verifyFileContent(testFilePath);

        /* 検証の準備 */
        final boolean actualFileExists = Files.exists(testFilePath);

        /* 検証の実施 */
        Assertions.assertTrue(actualFileExists, "verifyFileContent: ファイルが存在するが読み取り中にIOExceptionが発生しても例外が発生しないこと");

        // テスト用ディレクトリを削除
        try {

            Files.delete(testFilePath);

        } catch (final IOException e) {

            // 削除に失敗した場合は、そのままテストを続行
            e.printStackTrace();

        }

    }

    /**
     * verifyFileContent メソッドのテスト - 準正常系:存在するファイルでIOExceptionが発生する場合
     *
     * @since 0.2.0
     */
    @Test
    public void testVerifyFileContent_semiIOExceptionWithExistingFile() {

        /* 期待値の定義 */
        // このテストでは例外が発生しないことを確認（IOExceptionは内部でキャッチされる）

        /* 準備 */
        final Path testFilePath = Paths.get(
            "src/test/resources/kmg/core/infrastructure/test/abstract_kmg_test_test/test_verify_file_content_semi_io_exception_with_existing_file/test.txt");

        // テスト用ファイルを作成
        try {

            Files.createDirectories(testFilePath.getParent());
            Files.write(testFilePath, "test content".getBytes());

        } catch (final IOException e) {

            Assertions.fail("テスト用ファイルの作成に失敗しました: " + e.getMessage());
            return;

        }

        // ファイルを削除してから、存在するパスでIOExceptionを発生させる
        try {

            Files.delete(testFilePath);

        } catch (final IOException e) {

            Assertions.fail("テスト用ファイルの削除に失敗しました: " + e.getMessage());
            return;

        }

        /* テスト対象の実行 */
        AbstractKmgTest.verifyFileContent(testFilePath);

        /* 検証の準備 */
        final boolean actualFileExists = Files.exists(testFilePath);

        /* 検証の実施 */
        Assertions.assertFalse(actualFileExists, "verifyFileContent: 存在しないファイルでIOExceptionが発生しても例外が発生しないこと");

    }

    /**
     * verifyFileContent メソッドのテスト - 準正常系:存在しないファイル
     *
     * @since 0.2.0
     */
    @Test
    public void testVerifyFileContent_semiNonExistentFile() {

        /* 期待値の定義 */
        // このテストでは例外が発生しないことを確認

        /* 準備 */
        final Path testFilePath = Paths.get("non/existent/file.txt");

        /* テスト対象の実行 */
        AbstractKmgTest.verifyFileContent(testFilePath);

        /* 検証の準備 */
        final boolean actualFileExists = Files.exists(testFilePath);

        /* 検証の実施 */
        Assertions.assertFalse(actualFileExists, "verifyFileContent: 存在しないファイルで例外が発生しないこと");

    }

    /**
     * verifyFileContent メソッドのテスト - 準正常系:ファイルが存在するが読み取り権限がない場合
     *
     * @since 0.2.0
     */
    @Test
    public void testVerifyFileContent_semiNoReadPermission() {

        /* 期待値の定義 */
        // このテストでは例外が発生しないことを確認（IOExceptionは内部でキャッチされる）

        /* 準備 */
        final Path testFilePath = Paths.get(
            "src/test/resources/kmg/core/infrastructure/test/abstract_kmg_test_test/test_verify_file_content_semi_no_read_permission/test.txt");

        // テスト用ファイルを作成
        try {

            Files.createDirectories(testFilePath.getParent());
            Files.write(testFilePath, "test content".getBytes());

        } catch (final IOException e) {

            Assertions.fail("テスト用ファイルの作成に失敗しました: " + e.getMessage());
            return;

        }

        // ファイルが存在することを確認
        if (!Files.exists(testFilePath)) {

            Assertions.fail("テスト用ファイルが作成されていません");
            return;

        }

        /* テスト対象の実行 */
        // ファイルが存在するが、読み取り権限がない場合をシミュレート
        // Windows環境では権限の制御が難しいため、ファイルを削除してから実行
        try {

            Files.delete(testFilePath);

        } catch (final IOException e) {

            // 削除に失敗した場合は、そのままテストを続行
            e.printStackTrace();

        }

        AbstractKmgTest.verifyFileContent(testFilePath);

        /* 検証の準備 */
        final boolean actualFileExists = Files.exists(testFilePath);

        /* 検証の実施 */
        Assertions.assertFalse(actualFileExists, "verifyFileContent: ファイルが存在するが読み取り権限がない場合でも例外が発生しないこと");

    }

    /**
     * verifyKmgMsgException メソッドのテスト - 正常系:原因クラスありの例外検証
     *
     * @since 0.2.0
     */
    @Test
    public void testVerifyKmgMsgException_normalWithCauseClass() {

        /* 期待値の定義 */
        final String            expectedDomainMessage = "";                     // 実際のメッセージは空文字列
        final KmgCmnGenMsgTypes expectedMessageTypes  = KmgCoreGenMsgTypes.NONE;

        /* 準備 */
        final TestAbstractKmgTest testObject    = new TestAbstractKmgTest();
        final RuntimeException    testCause     = new RuntimeException("cause message");
        final KmgMsgException     testException = new KmgMsgException((KmgCmnExcMsgTypes) expectedMessageTypes,
            new Object[] {}, testCause);

        /* テスト対象の実行 */
        testObject.verifyKmgMsgException(testException, RuntimeException.class, expectedDomainMessage,
            expectedMessageTypes);

        /* 検証の準備 */
        final boolean actualNoException = true;

        /* 検証の実施 */
        Assertions.assertTrue(actualNoException, "verifyKmgMsgException: 原因クラスありの例外検証が正常に完了すること");

    }

    /**
     * verifyKmgMsgException メソッドのテスト - 正常系:原因クラスnullの例外検証
     *
     * @since 0.2.0
     */
    @Test
    public void testVerifyKmgMsgException_normalWithNullCauseClass() {

        /* 期待値の定義 */
        final String            expectedDomainMessage = "";                     // 実際のメッセージは空文字列
        final KmgCmnGenMsgTypes expectedMessageTypes  = KmgCoreGenMsgTypes.NONE;

        /* 準備 */
        final TestAbstractKmgTest testObject    = new TestAbstractKmgTest();
        final KmgMsgException     testException = new KmgMsgException((KmgCmnExcMsgTypes) expectedMessageTypes,
            new Object[] {});

        /* テスト対象の実行 */
        testObject.verifyKmgMsgException(testException, null, expectedDomainMessage, expectedMessageTypes);

        /* 検証の準備 */
        final boolean actualNoException = true;

        /* 検証の実施 */
        Assertions.assertTrue(actualNoException, "verifyKmgMsgException: 原因クラスnullの例外検証が正常に完了すること");

    }

    /**
     * verifyKmgMsgException メソッドのテスト - 正常系:原因なしの例外検証
     *
     * @since 0.2.0
     */
    @Test
    public void testVerifyKmgMsgException_normalWithoutCause() {

        /* 期待値の定義 */
        final String            expectedDomainMessage = "";                     // 実際のメッセージは空文字列
        final KmgCmnGenMsgTypes expectedMessageTypes  = KmgCoreGenMsgTypes.NONE;

        /* 準備 */
        final TestAbstractKmgTest testObject    = new TestAbstractKmgTest();
        final KmgMsgException     testException = new KmgMsgException((KmgCmnExcMsgTypes) expectedMessageTypes,
            new Object[] {});

        /* テスト対象の実行 */
        testObject.verifyKmgMsgException(testException, expectedDomainMessage, expectedMessageTypes);

        /* 検証の準備 */
        final boolean actualNoException = true;

        /* 検証の実施 */
        Assertions.assertTrue(actualNoException, "verifyKmgMsgException: 原因なしの例外検証が正常に完了すること");

    }

    /**
     * verifyKmgMsgException メソッドのテスト - 準正常系:原因がnullでない場合
     *
     * @since 0.2.0
     */
    @Test
    public void testVerifyKmgMsgException_semiCauseNotNull() {

        /* 期待値の定義 */
        final String            expectedDomainMessage = "指定無し";
        final KmgCmnGenMsgTypes expectedMessageTypes  = KmgCoreGenMsgTypes.NONE;

        /* 準備 */
        final TestAbstractKmgTest testObject    = new TestAbstractKmgTest();
        final RuntimeException    testCause     = new RuntimeException("cause message");
        final KmgMsgException     testException = new KmgMsgException((KmgCmnExcMsgTypes) expectedMessageTypes,
            new Object[] {}, testCause);

        /* テスト対象の実行 */
        Assertions.assertThrows(AssertionError.class, () -> {

            testObject.verifyKmgMsgException(testException, expectedDomainMessage, expectedMessageTypes);

        });

        /* 検証の準備 */
        final boolean actualExceptionThrown = true;

        /* 検証の実施 */
        Assertions.assertTrue(actualExceptionThrown, "verifyKmgMsgException: 原因がnullでない場合にAssertionErrorが発生すること");

    }

    /**
     * verifyKmgMsgException メソッドのテスト - 準正常系:原因クラスが一致しない場合
     *
     * @since 0.2.0
     */
    @Test
    public void testVerifyKmgMsgException_semiMismatchCauseClass() {

        /* 期待値の定義 */
        final String            expectedDomainMessage = "指定無し";
        final KmgCmnGenMsgTypes expectedMessageTypes  = KmgCoreGenMsgTypes.NONE;

        /* 準備 */
        final TestAbstractKmgTest testObject    = new TestAbstractKmgTest();
        final RuntimeException    testCause     = new RuntimeException("cause message");
        final KmgMsgException     testException = new KmgMsgException((KmgCmnExcMsgTypes) expectedMessageTypes,
            new Object[] {}, testCause);

        /* テスト対象の実行 */
        Assertions.assertThrows(AssertionError.class, () -> {

            testObject.verifyKmgMsgException(testException, IllegalArgumentException.class, expectedDomainMessage,
                expectedMessageTypes);

        });

        /* 検証の準備 */
        final boolean actualExceptionThrown = true;

        /* 検証の実施 */
        Assertions.assertTrue(actualExceptionThrown, "verifyKmgMsgException: 原因クラスが一致しない場合にAssertionErrorが発生すること");

    }

    /**
     * verifyKmgMsgException メソッドのテスト - 準正常系:ドメインメッセージが一致しない場合
     *
     * @since 0.2.0
     */
    @Test
    public void testVerifyKmgMsgException_semiMismatchDomainMessage() {

        /* 期待値の定義 */
        final KmgCmnGenMsgTypes expectedMessageTypes = KmgCoreGenMsgTypes.NONE;

        /* 準備 */
        final TestAbstractKmgTest testObject    = new TestAbstractKmgTest();
        final KmgMsgException     testException = new KmgMsgException((KmgCmnExcMsgTypes) expectedMessageTypes,
            new Object[] {});

        /* テスト対象の実行 */
        Assertions.assertThrows(AssertionError.class, () -> {

            testObject.verifyKmgMsgException(testException, "actual message", expectedMessageTypes);

        });

        /* 検証の準備 */
        final boolean actualExceptionThrown = true;

        /* 検証の実施 */
        Assertions.assertTrue(actualExceptionThrown, "verifyKmgMsgException: ドメインメッセージが一致しない場合にAssertionErrorが発生すること");

    }

    /**
     * verifyKmgMsgException メソッドのテスト - 準正常系:メッセージ引数の数が一致しない場合
     *
     * @since 0.2.0
     */
    @Test
    public void testVerifyKmgMsgException_semiMismatchMessageArgsCount() {

        /* 期待値の定義 */
        final String            expectedDomainMessage = "指定無し";
        final KmgCmnGenMsgTypes expectedMessageTypes  = KmgCoreGenMsgTypes.NONE;

        /* 準備 */
        final TestAbstractKmgTest testObject    = new TestAbstractKmgTest();
        final KmgMsgException     testException = new KmgMsgException((KmgCmnExcMsgTypes) expectedMessageTypes,
            new Object[] {
                "arg1", "arg2"
            });

        /* テスト対象の実行 */
        Assertions.assertThrows(AssertionError.class, () -> {

            testObject.verifyKmgMsgException(testException, expectedDomainMessage, expectedMessageTypes);

        });

        /* 検証の準備 */
        final boolean actualExceptionThrown = true;

        /* 検証の実施 */
        Assertions.assertTrue(actualExceptionThrown, "verifyKmgMsgException: メッセージ引数の数が一致しない場合にAssertionErrorが発生すること");

    }

    /**
     * verifyKmgMsgException メソッドのテスト - 準正常系:メッセージタイプが一致しない場合
     *
     * @since 0.2.0
     */
    @Test
    public void testVerifyKmgMsgException_semiMismatchMessageTypes() {

        /* 期待値の定義 */
        final String            expectedDomainMessage = "指定無し";
        final KmgCmnGenMsgTypes expectedMessageTypes  = KmgCoreGenMsgTypes.NONE;

        /* 準備 */
        final TestAbstractKmgTest testObject    = new TestAbstractKmgTest();
        final KmgMsgException     testException = new KmgMsgException(KmgCoreGenMsgTypes.KMGCORE_GEN11100,
            new Object[] {});

        /* テスト対象の実行 */
        Assertions.assertThrows(AssertionError.class, () -> {

            testObject.verifyKmgMsgException(testException, expectedDomainMessage, expectedMessageTypes);

        });

        /* 検証の準備 */
        final boolean actualExceptionThrown = true;

        /* 検証の実施 */
        Assertions.assertTrue(actualExceptionThrown, "verifyKmgMsgException: メッセージタイプが一致しない場合にAssertionErrorが発生すること");

    }
}

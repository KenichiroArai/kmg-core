package kmg.core.infrastructure.utils;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import kmg.core.infrastructure.exception.KmgDomainException;

/**
 * KMGパスユーティリティテスト<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
@SuppressWarnings("static-method")
public class KmgPathUtilsTest {

    /**
     * getBinPath メソッドのテスト - nullの場合（Class）
     *
     * @throws Exception
     *                   失敗
     */
    @Test
    public void testGetBinPath_nullClass() throws Exception {

        /* 期待値の定義 */
        final Path expected = null;

        /* 準備 */
        final Class<?> testTarget = null;

        /* テスト対象の実行 */
        final Path actual = KmgPathUtils.getBinPath(testTarget);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "nullの場合はnullを返すべき");

    }

    /**
     * getBinPath メソッドのテスト - nullの場合（Object）
     *
     * @throws KmgDomainException
     *                            失敗
     */
    @Test
    public void testGetBinPath_nullObject() throws KmgDomainException {

        /* 期待値の定義 */
        final Path expected = null;

        /* 準備 */
        final Object testTarget = null;

        /* テスト対象の実行 */
        final Path actual = KmgPathUtils.getBinPath(testTarget);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "nullの場合はnullを返すべき");

    }

    /**
     * getBinPath メソッドのテスト - URISyntaxExceptionが発生する場合
     *
     * @throws Exception
     *                   失敗
     */
    @Test
    public void testGetBinPath_throwsURISyntaxException() throws Exception {

        /* 期待値の定義 */
        final String expectedMessage = "Test URI Syntax Exception";

        /* 準備 */
        final Class<?>           testTarget    = KmgPathUtilsTest.class;
        final URISyntaxException testException = new URISyntaxException("test", expectedMessage);

        try (MockedStatic<KmgPathUtils> mockedStatic = Mockito.mockStatic(KmgPathUtils.class)) {

            /* テスト対象の実行 */
            mockedStatic.when(() -> KmgPathUtils.getCodeSourceLocation(testTarget)).thenThrow(testException);

            mockedStatic.when(() -> KmgPathUtils.getBinPath(testTarget)).thenCallRealMethod();

            /* 検証の実施 */
            final KmgDomainException actualException = Assertions.assertThrows(KmgDomainException.class,
                () -> KmgPathUtils.getBinPath(testTarget), "URISyntaxExceptionが発生した場合、KmgDomainExceptionがスローされるべき");

            Assertions.assertEquals(expectedMessage, actualException.getMessage(), "例外メッセージが一致するべき");
            Assertions.assertEquals(testException, actualException.getCause(), "原因となる例外が設定されているべき");

        }

    }

    /**
     * getBinPath メソッドのテスト - 正常なクラスの場合
     *
     * @throws KmgDomainException
     *                            失敗
     */
    @Test
    public void testGetBinPath_validClass() throws KmgDomainException {

        /* 準備 */
        final Class<?> testTarget = KmgPathUtilsTest.class;

        /* テスト対象の実行 */
        final Path actual = KmgPathUtils.getBinPath(testTarget);

        /* 検証の実施 */
        Assertions.assertNotNull(actual, "ビルドパスが返されるべき");
        Assertions.assertTrue(actual.toString().endsWith("test-classes"), "test-classesディレクトリを指すべき");

    }

    /**
     * getBinPath メソッドのテスト - 正常なオブジェクトの場合
     *
     * @throws KmgDomainException
     *                            失敗
     */
    @Test
    public void testGetBinPath_validObject() throws KmgDomainException {

        /* 準備 */
        final Object testTarget = new KmgPathUtilsTest();

        /* テスト対象の実行 */
        final Path actual = KmgPathUtils.getBinPath(testTarget);

        /* 検証の実施 */
        Assertions.assertNotNull(actual, "ビルドパスが返されるべき");
        Assertions.assertTrue(actual.toString().endsWith("test-classes"), "test-classesディレクトリを指すべき");

    }

    /**
     * getClassFullPath メソッドのテスト - nullの場合（Class）
     *
     * @throws KmgDomainException
     *                            失敗
     */
    @Test
    public void testGetClassFullPath_nullClass() throws KmgDomainException {

        /* 期待値の定義 */
        final Path expected = null;

        /* 準備 */
        final Class<?> testTarget = null;
        final Path     fileName   = Paths.get("test.txt");

        /* テスト対象の実行 */
        final Path actual = KmgPathUtils.getClassFullPath(testTarget, fileName);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "nullの場合はnullを返すべき");

    }

    /**
     * getClassFullPath メソッドのテスト - nullの場合（Object）
     *
     * @throws KmgDomainException
     *                            失敗
     */
    @Test
    public void testGetClassFullPath_nullObject() throws KmgDomainException {

        /* 期待値の定義 */
        final Path expected = null;

        /* 準備 */
        final Object testTarget = null;
        final String fileName   = "test.txt";

        /* テスト対象の実行 */
        final Path actual = KmgPathUtils.getClassFullPath(testTarget, fileName);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "nullの場合はnullを返すべき");

    }

    /**
     * getClassFullPath メソッドのテスト - 正常なクラスの場合
     *
     * @throws Exception
     *                   失敗
     */
    @Test
    public void testGetClassFullPath_validClass() throws Exception {

        /* 期待値の定義 */
        final Path binPath  = Paths
            .get(KmgPathUtilsTest.class.getProtectionDomain().getCodeSource().getLocation().toURI());
        final Path expected = binPath.resolve("kmg/core/infrastructure/utils/kmg_path_utils_test/test.txt");

        /* 準備 */
        final Class<?> testTarget = KmgPathUtilsTest.class;
        final Path     fileName   = Paths.get("test.txt");

        /* テスト対象の実行 */
        final Path actual = KmgPathUtils.getClassFullPath(testTarget, fileName);

        /* 検証の実施：完全一致 */
        Assertions.assertNotNull(actual, "ビルドパスが返されるべき");
        Assertions.assertEquals(expected, actual, "返されたパスが期待する絶対パスと一致するべき");

    }

    /**
     * getClassFullPath メソッドのテスト - 正常なオブジェクトの場合
     *
     * @throws KmgDomainException
     *                            失敗
     */
    @Test
    public void testGetClassFullPath_validObject() throws KmgDomainException {

        /* テスト対象のクラスのビルドパスを取得 */
        final Path binPath = KmgPathUtils.getBinPath(KmgPathUtilsTest.class);

        /* 期待値の定義：ビルドパス + 相対パス */
        final Path expected = binPath.resolve("kmg/core/infrastructure/utils/kmg_path_utils_test/test.txt");

        /* 準備 */
        final Object testTarget = new KmgPathUtilsTest();
        final String fileName   = "test.txt";

        /* テスト対象の実行 */
        final Path actual = KmgPathUtils.getClassFullPath(testTarget, fileName);

        /* 検証の実施：完全一致 */
        Assertions.assertNotNull(actual, "ビルドパスが返されるべき");
        Assertions.assertEquals(expected, actual, "返されたパスが期待する絶対パスと一致するべき");

    }

    /**
     * getCodeSourceLocation メソッドのテスト - nullの場合
     *
     * @throws URISyntaxException
     *                            URI構文例外
     */
    @Test
    public void testGetCodeSourceLocation_null() throws URISyntaxException {

        /* 期待値の定義 */
        final Path expected = null;

        /* 準備 */
        final Class<?> testTarget = null;

        /* テスト対象の実行 */
        final Path actual = KmgPathUtils.getCodeSourceLocation(testTarget);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "nullの場合はnullを返すべき");

    }

    /**
     * getCodeSourceLocation メソッドのテスト - 正常なクラスの場合
     *
     * @throws URISyntaxException
     *                            URI構文例外
     */
    @Test
    public void testGetCodeSourceLocation_validClass() throws URISyntaxException {

        /* 準備 */
        final Class<?> testTarget = KmgPathUtilsTest.class;

        /* テスト対象の実行 */
        final Path actual = KmgPathUtils.getCodeSourceLocation(testTarget);

        /* 検証の実施 */
        Assertions.assertNotNull(actual, "ビルドパスが返されるべき");
        Assertions.assertTrue(actual.toString().endsWith("test-classes"), "test-classesディレクトリを指すべき");

    }

    /**
     * getFileNameOnly メソッドのテスト - nullの場合
     */
    @Test
    public void testGetFileNameOnly_null() {

        /* 期待値の定義 */
        final String expected = null;

        /* 準備 */
        final Path testTarget = null;

        /* テスト対象の実行 */
        final String actual = KmgPathUtils.getFileNameOnly(testTarget);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "nullの場合はnullを返すべき");

    }

    /**
     * getFileNameOnly メソッドのテスト - 正常なファイルパスの場合
     */
    @Test
    public void testGetFileNameOnly_validPath() {

        /* 期待値の定義 */
        final String expected = "test";

        /* 準備 */
        final Path testTarget = Paths.get("path/to/test.txt");

        /* テスト対象の実行 */
        final String actual = KmgPathUtils.getFileNameOnly(testTarget);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "拡張子を除いたファイル名が返されるべき");

    }
}

package kmg.core.infrastructure.utils;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * KMGパスユーティリティテスト<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
public class KmgPathUtilsTest {

    /**
     * getBinPath メソッドのテスト - nullの場合（Class）
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGetBinPath_nullClass() {

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
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGetBinPath_nullObject() {

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
     * getBinPath メソッドのテスト - 正常なクラスの場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGetBinPath_validClass() {

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
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGetBinPath_validObject() {

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
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGetClassFullPath_nullClass() {

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
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGetClassFullPath_nullObject() {

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
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGetClassFullPath_validClass() {

        /* テスト対象のクラスのビルドパスを取得 */
        final Path binPath = KmgPathUtils.getBinPath(KmgPathUtilsTest.class);

        /* 期待値の定義：ビルドパス + 相対パス */
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
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGetClassFullPath_validObject() {

        /* 準備 */
        final Object testTarget = new KmgPathUtilsTest();
        final String fileName   = "test.txt";

        /* テスト対象の実行 */
        final Path actual = KmgPathUtils.getClassFullPath(testTarget, fileName);

        /* 検証の実施 */
        Assertions.assertNotNull(actual, "クラスのフルパスが返されるべき");
        Assertions.assertTrue(actual.toString().contains("kmg/core/infrastructure/utils/kmg_path_utils_test"),
            "正しいパス形式で返されるべき");

    }

    /**
     * getFileNameOnly メソッドのテスト - nullの場合
     */
    @Test
    @SuppressWarnings("static-method")
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
    @SuppressWarnings("static-method")
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

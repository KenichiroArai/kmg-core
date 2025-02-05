package kmg.core.infrastructure.utils;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import kmg.core.domain.model.KmgReflectionModel;
import kmg.core.domain.model.factory.KmgReflectionModelFactory;
import kmg.core.infrastructure.exception.KmgDomainException;

/**
 * KMGパスユーティリティテスト<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
@SpringBootTest
@ExtendWith(MockitoExtension.class)
@SuppressWarnings("static-method")
public class KmgPathUtilsTest {

    /**
     * テストクラス
     */
    private static class TestClass {
        // 処理なし
    }

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
        final String expectedMessage
            = "クラスからビルドバスの取得に失敗しました。クラス=[kmg.core.infrastructure.utils.KmgPathUtilsTest$TestClass]";

        /* 準備 */
        final Class<TestClass>   testTarget    = TestClass.class;
        final URISyntaxException testException = new URISyntaxException("test", "Test URI Syntax Exception");

        try (MockedStatic<KmgPathUtils> mockedStatic = Mockito.mockStatic(KmgPathUtils.class)) {

            /* テスト対象の実行 */
            mockedStatic.when(() -> KmgPathUtils.getCodeSourceLocation(testTarget)).thenThrow(testException);
            mockedStatic.when(() -> KmgPathUtils.getBinPath(testTarget)).thenCallRealMethod();
            mockedStatic.when(() -> KmgPathUtils.setKmgMessageModelFactory(ArgumentMatchers.any()))
                .thenCallRealMethod();

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
        final Class<?> testTarget = TestClass.class;

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
     * getClassFullPath メソッドのテスト - クラス名に$が含まれている場合
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
    public void testGetClassFullPath_classNameWithDollar() throws KmgDomainException {

        /* 期待値の定義 */
        final Path binPath  = Paths.get("test-classes");
        final Path expected = Paths.get(binPath.toAbsolutePath().toString(),
            "kmg/core/infrastructure/utils/test_class/test.txt");

        /* 準備 */
        final String packageName = "kmg.core.infrastructure.utils";
        final String className   = "TestClass$InnerClass";
        final Path   fileName    = Paths.get("test.txt");

        /* テスト対象の実行 */
        final KmgReflectionModel kmgReflectionModel = new KmgReflectionModelFactory().create(KmgPathUtils.class);
        final Path               actual             = (Path) kmgReflectionModel.getMethod("getClassFullPath", binPath,
            packageName, className, fileName);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "$以前の部分がクラス名として扱われるべき");

    }

    /**
     * getClassFullPath メソッドのテスト - クラス名が空の場合
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
    public void testGetClassFullPath_emptyClassName() throws KmgDomainException {

        /* 期待値の定義 */
        final Path expected = null;

        /* 準備 */
        final Path   binPath     = Paths.get("test-classes");
        final String packageName = "kmg.core.infrastructure.utils";
        final String className   = "";
        final Path   fileName    = Paths.get("test.txt");

        /* テスト対象の実行 */
        final KmgReflectionModel kmgReflectionModel = new KmgReflectionModelFactory().create(KmgPathUtils.class);
        final Path               actual             = (Path) kmgReflectionModel.getMethod("getClassFullPath", binPath,
            packageName, className, fileName);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "クラス名が空の場合はnullを返すべき");

    }

    /**
     * getClassFullPath メソッドのテスト - 全ての要素が正しく結合される場合
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
    public void testGetClassFullPath_fullPathCombination() throws KmgDomainException {

        /* 期待値の定義 */
        final Path binPath  = Paths.get("build/classes");
        final Path expected = Paths.get(binPath.toAbsolutePath().toString(),
            "kmg/core/infrastructure/utils/test_class/data.json");

        /* 準備 */
        final String packageName = "kmg.core.infrastructure.utils";
        final String className   = "TestClass";
        final Path   fileName    = Paths.get("data.json");

        /* テスト対象の実行 */
        final KmgReflectionModel kmgReflectionModel = new KmgReflectionModelFactory().create(KmgPathUtils.class);
        final Path               actual             = (Path) kmgReflectionModel.getMethod("getClassFullPath", binPath,
            packageName, className, fileName);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "全ての要素が正しく結合されるべき");

    }

    /**
     * getClassFullPath メソッドのテスト - ビルドパスがnullの場合
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
    public void testGetClassFullPath_nullBinPath() throws KmgDomainException {

        /* 期待値の定義 */
        final Path expected = Paths.get("/kmg/core/infrastructure/utils/test_class/test.txt");

        /* 準備 */
        final Path   binPath     = null;
        final String packageName = "kmg.core.infrastructure.utils";
        final String className   = "TestClass";
        final Path   fileName    = Paths.get("test.txt");

        /* テスト対象の実行 */
        final KmgReflectionModel kmgReflectionModel = new KmgReflectionModelFactory().create(KmgPathUtils.class);
        final Path               actual             = (Path) kmgReflectionModel.getMethod("getClassFullPath", binPath,
            packageName, className, fileName);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "ビルドパスがnullの場合は空文字として扱われるべき");

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
     * getClassFullPath メソッドのテスト - パッケージ名のドットがスラッシュに変換される場合
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
    public void testGetClassFullPath_packageNameConversion() throws KmgDomainException {

        /* 期待値の定義 */
        final Path binPath  = Paths.get("test-classes");
        final Path expected = Paths.get(binPath.toAbsolutePath().toString(), "com/example/test/test_class/test.txt");

        /* 準備 */
        final String packageName = "com.example.test";
        final String className   = "TestClass";
        final Path   fileName    = Paths.get("test.txt");

        /* テスト対象の実行 */
        final KmgReflectionModel kmgReflectionModel = new KmgReflectionModelFactory().create(KmgPathUtils.class);
        final Path               actual             = (Path) kmgReflectionModel.getMethod("getClassFullPath", binPath,
            packageName, className, fileName);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "パッケージ名のドットがスラッシュに変換されるべき");

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
        final Path binPath  = Paths.get(TestClass.class.getProtectionDomain().getCodeSource().getLocation().toURI());
        final Path expected = binPath.resolve("kmg/core/infrastructure/utils/test_class/test.txt");

        /* 準備 */
        final Class<?> testTarget = TestClass.class;
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

        /* 期待値の定義 */

        // テスト対象
        final TestClass testTarget = new TestClass();

        // テスト対象のクラスのビルドパスを取得
        final Path binPath  = KmgPathUtils.getBinPath(testTarget);
        final Path expected = binPath.resolve("kmg/core/infrastructure/utils/test_class/test.txt");

        /* 準備 */
        final String fileName = "test.txt";

        /* テスト対象の実行 */
        final Path actual = KmgPathUtils.getClassFullPath(testTarget, fileName);

        /* 検証の実施：完全一致 */
        Assertions.assertNotNull(actual, "ビルドパスが返されるべき");
        Assertions.assertEquals(expected, actual, "返されたパスが期待する絶対パスと一致するべき");

    }

    /**
     * getClassFullPath メソッドのテスト - objectがClass<?>のインスタンスの場合
     *
     * @throws KmgDomainException
     *                            失敗
     */
    @Test
    public void testGetClassFullPath_objectIsClassInstance() throws KmgDomainException {

        /* 期待値の定義 */
        final Path binPath  = KmgPathUtils.getBinPath(TestClass.class);
        final Path expected = binPath.resolve("kmg/core/infrastructure/utils/test_class/test.txt");

        /* 準備 */
        final Object testTarget = TestClass.class;  // Class<?>のインスタンス
        final String fileName   = "test.txt";

        /* テスト対象の実行 */
        final Path actual = KmgPathUtils.getClassFullPath(testTarget, fileName);

        /* 検証の実施 */
        Assertions.assertNotNull(actual, "ビルドパスが返されるべき");
        Assertions.assertEquals(expected, actual, "返されたパスが期待する絶対パスと一致するべき");

    }

    /**
     * getClassFullPath メソッドのテスト - objectが通常のオブジェクトの場合
     *
     * @throws KmgDomainException
     *                            失敗
     */
    @Test
    public void testGetClassFullPath_objectIsNormalInstance() throws KmgDomainException {

        /* 期待値の定義 */
        final Path binPath  = KmgPathUtils.getBinPath(TestClass.class);
        final Path expected = binPath.resolve("kmg/core/infrastructure/utils/test_class/test.txt");

        /* 準備 */
        final Object testTarget = new TestClass();  // 通常のオブジェクトインスタンス
        final String fileName   = "test.txt";

        /* テスト対象の実行 */
        final Path actual = KmgPathUtils.getClassFullPath(testTarget, fileName);

        /* 検証の実施 */
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
        final Class<TestClass> testTarget = TestClass.class;

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

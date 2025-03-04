package kmg.core.infrastructure.utils;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import kmg.core.domain.types.KmgMsgMessageTypes;
import kmg.core.infrastructure.exception.KmgDomainException;
import kmg.core.infrastructure.model.KmgReflectionModel;
import kmg.core.infrastructure.model.impl.KmgReflectionModelImpl;
import kmg.core.test.AbstractKmgTest;

/**
 * KMGパスユーティリティテスト<br>
 *
 * @author KenichiroArai
 *
 * @since 0.1.0
 *
 * @version 0.2.0
 */
@SuppressWarnings({
    "nls", "static-method"
})
@ExtendWith(MockitoExtension.class)
public class KmgPathUtilsTest extends AbstractKmgTest {

    /**
     * テストクラス<br>
     *
     * @author KenichiroArai
     *
     * @since 0.1.0
     *
     * @version 0.1.0
     */
    private static class TestClass {

        /**
         * デフォルトコンストラクタ<br>
         *
         * @since 0.1.0
         */
        private TestClass() {

            // 処理なし
        }
    }

    /**
     * デフォルトコンストラクタ<br>
     *
     * @since 0.1.0
     */
    public KmgPathUtilsTest() {

        // 処理なし
    }

    /**
     * getBinPath メソッドのテスト - 異常系:nullの場合（Class）
     *
     * @since 0.1.0
     *
     * @throws Exception
     *                   失敗
     */
    @Test
    public void testGetBinPath_errorNullClass() throws Exception {

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
     * getBinPath メソッドのテスト - 異常系:nullの場合（Object）
     *
     * @since 0.1.0
     *
     * @throws KmgDomainException
     *                            失敗
     */
    @Test
    public void testGetBinPath_errorNullObject() throws KmgDomainException {

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
     * getBinPath メソッドのテスト - 異常系:URISyntaxExceptionが発生する場合
     *
     * @since 0.1.0
     *
     * @throws Exception
     *                   失敗
     */
    @Test
    public void testGetBinPath_errorThrowsURISyntaxException() throws Exception {

        /* 期待値の定義 */
        final String          expectedDomainMessage = String.format("クラスからビルドバスの取得に失敗しました。クラス=[%s]",
            "kmg.core.infrastructure.utils.KmgPathUtilsTest$TestClass");
        final KmgMsgMessageTypes expectedMessageTypes  = KmgMsgMessageTypes.KMGMSGE24000;

        /* 準備 */
        final Class<TestClass>   testTarget    = TestClass.class;
        final URISyntaxException testException = new URISyntaxException("test", "Test URI Syntax Exception");

        try (MockedStatic<KmgPathUtils> mockedStatic = Mockito.mockStatic(KmgPathUtils.class)) {

            /* テスト対象の実行 */
            mockedStatic.when(() -> KmgPathUtils.getCodeSourceLocation(testTarget)).thenThrow(testException);
            mockedStatic.when(() -> KmgPathUtils.getBinPath(testTarget)).thenCallRealMethod();

            /* 検証の実施 */
            final KmgDomainException actualException = Assertions.assertThrows(KmgDomainException.class,
                () -> KmgPathUtils.getBinPath(testTarget), "URISyntaxExceptionが発生した場合、KmgDomainExceptionがスローされるべき");
            this.verifyKmgException(actualException, URISyntaxException.class, expectedDomainMessage,
                expectedMessageTypes);

        }

    }

    /**
     * getBinPath メソッドのテスト - 正常系:正常なクラスの場合
     *
     * @since 0.1.0
     *
     * @throws KmgDomainException
     *                            失敗
     */
    @Test
    public void testGetBinPath_normalValidClass() throws KmgDomainException {

        /* 準備 */
        final Class<?> testTarget = TestClass.class;

        /* テスト対象の実行 */
        final Path actual = KmgPathUtils.getBinPath(testTarget);

        /* 検証の実施 */
        Assertions.assertNotNull(actual, "ビルドパスが返されるべき");
        Assertions.assertTrue(actual.toString().endsWith("test-classes"), "test-classesディレクトリを指すべき");

    }

    /**
     * getBinPath メソッドのテスト - 正常系:正常なオブジェクトの場合
     *
     * @since 0.1.0
     *
     * @throws KmgDomainException
     *                            失敗
     */
    @Test
    public void testGetBinPath_normalValidObject() throws KmgDomainException {

        /* 準備 */
        final Object testTarget = new KmgPathUtilsTest();

        /* テスト対象の実行 */
        final Path actual = KmgPathUtils.getBinPath(testTarget);

        /* 検証の実施 */
        Assertions.assertNotNull(actual, "ビルドパスが返されるべき");
        Assertions.assertTrue(actual.toString().endsWith("test-classes"), "test-classesディレクトリを指すべき");

    }

    /**
     * getClassFullPath メソッドのテスト - 異常系:クラス名が空の場合
     *
     * @since 0.1.0
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
    public void testGetClassFullPath_errorEmptyClassName() throws KmgDomainException {

        /* 期待値の定義 */
        final Path expected = null;

        /* 準備 */
        final Path   binPath     = Paths.get("test-classes");
        final String packageName = "kmg.core.infrastructure.utils";
        final String className   = "";
        final Path   fileName    = Paths.get("test.txt");

        /* テスト対象の実行 */
        final KmgReflectionModel kmgReflectionModel = new KmgReflectionModelImpl(KmgPathUtils.class);
        final Path               actual             = (Path) kmgReflectionModel.getMethod("getClassFullPath", binPath,
            packageName, className, fileName);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "クラス名が空の場合はnullを返すべき");

    }

    /**
     * getClassFullPath メソッドのテスト - 異常系:クラスがnullの場合
     *
     * @since 0.1.0
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
    public void testGetClassFullPath_errorNullClass() throws KmgDomainException {

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
     * getClassFullPath メソッドのテスト - 異常系:オブジェクトがnullの場合
     *
     * @since 0.1.0
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
    public void testGetClassFullPath_errorNullObject() throws KmgDomainException {

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
     * getClassFullPath メソッドのテスト - 正常系:全ての要素が正しく結合される場合
     *
     * @since 0.1.0
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
    public void testGetClassFullPath_normalFullPathCombination() throws KmgDomainException {

        /* 期待値の定義 */
        final Path binPath  = Paths.get("build/classes");
        final Path expected = Paths.get(binPath.toAbsolutePath().toString(),
            "kmg/core/infrastructure/utils/test_class/data.json");

        /* 準備 */
        final String packageName = "kmg.core.infrastructure.utils";
        final String className   = "TestClass";
        final Path   fileName    = Paths.get("data.json");

        /* テスト対象の実行 */
        final KmgReflectionModel kmgReflectionModel = new KmgReflectionModelImpl(KmgPathUtils.class);
        final Path               actual             = (Path) kmgReflectionModel.getMethod("getClassFullPath", binPath,
            packageName, className, fileName);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "全ての要素が正しく結合されるべき");

    }

    /**
     * getClassFullPath メソッドのテスト - 正常系：ビルドパスがnullの場合
     *
     * @since 0.1.0
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
    public void testGetClassFullPath_normalNullBinPath() throws KmgDomainException {

        /* 期待値の定義 */
        final Path expected = Paths.get("/kmg/core/infrastructure/utils/test_class/test.txt");

        /* 準備 */
        final Path   binPath     = null;
        final String packageName = "kmg.core.infrastructure.utils";
        final String className   = "TestClass";
        final Path   fileName    = Paths.get("test.txt");

        /* テスト対象の実行 */
        final KmgReflectionModel kmgReflectionModel = new KmgReflectionModelImpl(KmgPathUtils.class);
        final Path               actual             = (Path) kmgReflectionModel.getMethod("getClassFullPath", binPath,
            packageName, className, fileName);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "ビルドパスがnullの場合は空文字として扱われるべき");

    }

    /**
     * getClassFullPath メソッドのテスト - 正常系:オブジェクトがクラスインスタンスの場合
     *
     * @since 0.1.0
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
    public void testGetClassFullPath_normalObjectIsClassInstance() throws KmgDomainException {

        /* 期待値の定義 */
        final Path binPath  = KmgPathUtils.getBinPath(TestClass.class);
        final Path expected = binPath.resolve("kmg/core/infrastructure/utils/test_class/test.txt");

        /* 準備 */
        final Object testTarget = TestClass.class; // Class<?>のインスタンス
        final String fileName   = "test.txt";

        /* テスト対象の実行 */
        final Path actual = KmgPathUtils.getClassFullPath(testTarget, fileName);

        /* 検証の実施 */
        Assertions.assertNotNull(actual, "ビルドパスが返されるべき");
        Assertions.assertEquals(expected, actual, "返されたパスが期待する絶対パスと一致するべき");

    }

    /**
     * getClassFullPath メソッドのテスト - 正常系:オブジェクトが通常のインスタンスの場合
     *
     * @since 0.1.0
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
    public void testGetClassFullPath_normalObjectIsNormalInstance() throws KmgDomainException {

        /* 期待値の定義 */
        final Path binPath  = KmgPathUtils.getBinPath(TestClass.class);
        final Path expected = binPath.resolve("kmg/core/infrastructure/utils/test_class/test.txt");

        /* 準備 */
        final Object testTarget = new TestClass(); // 通常のオブジェクトインスタンス
        final String fileName   = "test.txt";

        /* テスト対象の実行 */
        final Path actual = KmgPathUtils.getClassFullPath(testTarget, fileName);

        /* 検証の実施 */
        Assertions.assertNotNull(actual, "ビルドパスが返されるべき");
        Assertions.assertEquals(expected, actual, "返されたパスが期待する絶対パスと一致するべき");

    }

    /**
     * getClassFullPath メソッドのテスト - 正常系:パッケージ名の変換の場合
     *
     * @since 0.1.0
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
    public void testGetClassFullPath_normalPackageNameConversion() throws KmgDomainException {

        /* 期待値の定義 */
        final Path binPath  = Paths.get("test-classes");
        final Path expected = Paths.get(binPath.toAbsolutePath().toString(), "com/example/test/test_class/test.txt");

        /* 準備 */
        final String packageName = "com.example.test";
        final String className   = "TestClass";
        final Path   fileName    = Paths.get("test.txt");

        /* テスト対象の実行 */
        final KmgReflectionModel kmgReflectionModel = new KmgReflectionModelImpl(KmgPathUtils.class);
        final Path               actual             = (Path) kmgReflectionModel.getMethod("getClassFullPath", binPath,
            packageName, className, fileName);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "パッケージ名のドットがスラッシュに変換されるべき");

    }

    /**
     * getClassFullPath メソッドのテスト - 正常系:有効なクラスの場合
     *
     * @since 0.1.0
     *
     * @throws Exception
     *                   例外
     */
    @Test
    public void testGetClassFullPath_normalValidClass() throws Exception {

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
     * getClassFullPath メソッドのテスト - 正常系:有効なオブジェクトの場合
     *
     * @since 0.1.0
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
    public void testGetClassFullPath_normalValidObject() throws KmgDomainException {

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
     * getClassFullPath メソッドのテスト - 異常系:ビルドパスがnullの場合
     *
     * @since 0.1.0
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
    public void testGetClassFullPath_semiClassNameWithDollar() throws KmgDomainException {

        /* 期待値の定義 */
        final Path binPath  = Paths.get("test-classes");
        final Path expected = Paths.get(binPath.toAbsolutePath().toString(),
            "kmg/core/infrastructure/utils/test_class/test.txt");

        /* 準備 */
        final String packageName = "kmg.core.infrastructure.utils";
        final String className   = "TestClass$InnerClass";
        final Path   fileName    = Paths.get("test.txt");

        /* テスト対象の実行 */
        final KmgReflectionModel kmgReflectionModel = new KmgReflectionModelImpl(KmgPathUtils.class);
        final Path               actual             = (Path) kmgReflectionModel.getMethod("getClassFullPath", binPath,
            packageName, className, fileName);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "$以前の部分がクラス名として扱われるべき");

    }

    /**
     * getCodeSourceLocation メソッドのテスト - 異常系:nullの場合
     *
     * @since 0.1.0
     *
     * @throws URISyntaxException
     *                            URI構文例外
     */
    @Test
    public void testGetCodeSourceLocation_errorNull() throws URISyntaxException {

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
     * getCodeSourceLocation メソッドのテスト - 正常系:有効なクラスの場合
     *
     * @since 0.1.0
     *
     * @throws URISyntaxException
     *                            URI構文例外
     */
    @Test
    public void testGetCodeSourceLocation_normalValidClass() throws URISyntaxException {

        /* 準備 */
        final Class<TestClass> testTarget = TestClass.class;

        /* テスト対象の実行 */
        final Path actual = KmgPathUtils.getCodeSourceLocation(testTarget);

        /* 検証の実施 */
        Assertions.assertNotNull(actual, "ビルドパスが返されるべき");
        Assertions.assertTrue(actual.toString().endsWith("test-classes"), "test-classesディレクトリを指すべき");

    }

    /**
     * getFileNameOnly メソッドのテスト - 異常系:nullの場合
     *
     * @since 0.1.0
     */
    @Test
    public void testGetFileNameOnly_errorNull() {

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
     * getFileNameOnly メソッドのテスト - 正常系:有効なパスの場合
     *
     * @since 0.1.0
     */
    @Test
    public void testGetFileNameOnly_normalValidPath() {

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

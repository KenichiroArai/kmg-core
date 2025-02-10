package kmg.core.domain.model.impl;

import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import kmg.core.domain.model.KmgReflectionModel;
import kmg.core.infrastructure.common.KmgMessageTypes;
import kmg.core.infrastructure.exception.KmgDomainException;
import kmg.core.infrastructure.type.KmgString;
import kmg.core.infrastructure.types.KmgMsgMessageTypes;
import kmg.core.test.AbstractKmgTest;

/**
 * KMGSQLパスモデルテスト<br>
 *
 * @author KenichiroArai
 *
 * @sine 1.0.0
 *
 * @version 1.0.0
 */
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@SuppressWarnings("nls")
public class KmgSqlPathModelImplTest extends AbstractKmgTest {

    /** テスト対象 */
    private KmgSqlPathModelImpl target;

    /** 一時ディレクトリ */
    @TempDir
    private Path tempDir;

    /**
     * セットアップ<br>
     */
    @BeforeEach
    public void setUp() {

        // テスト対象のインスタンスを生成
        final Path testFile = this.tempDir.resolve("test.sql");
        this.target = new KmgSqlPathModelImpl(this.getClass(), testFile);

    }

    /**
     * コンストラクタのテスト - 正常系：クラスを使用したコンストラクタ<br>
     *
     * @author KenichiroArai
     *
     * @sine 1.0.0
     *
     * @version 1.0.0
     *
     * @throws Exception
     *                   例外
     */
    @Test
    public void testConstructor_normalWithClass() throws Exception {

        /* 期待値の定義 */
        final String expectedSql = ":sampleId";

        /* 準備 */
        final Path testFile = this.tempDir.resolve("test.sql");
        Files.writeString(testFile, "/*:sampleId*/'サンプル'");

        /* テスト対象の実行 */
        this.target = new KmgSqlPathModelImpl(KmgSqlPathModelImpl.class, testFile);
        final String testResult = this.target.toSql();

        /* 検証の準備 */
        final String actualSql = testResult;

        /* 検証の実施 */
        Assertions.assertEquals(expectedSql, actualSql, "SQLが一致しません");

    }

    /**
     * convertParameters メソッドのテスト - 正常系：空文字列<br>
     *
     * @author KenichiroArai
     *
     * @sine 1.0.0
     *
     * @version 1.0.0
     *
     * @throws Exception
     *                   例外
     */
    @SuppressWarnings("static-method")
    @Test
    public void testConvertParameters_normalEmptyString() throws Exception {

        /* 期待値の定義 */
        final String expectedResult = KmgString.EMPTY;

        /* 準備 */
        final Path                testFile       = Files.createTempFile("test", ".sql");
        final KmgSqlPathModelImpl testInstance   = new KmgSqlPathModelImpl(KmgSqlPathModelImplTest.class, testFile);
        final KmgReflectionModel  testReflection = new KmgReflectionModelImpl(testInstance);

        /* テスト対象の実行 */
        final String testResult = (String) testReflection.getMethod("convertParameters", KmgString.EMPTY);

        /* 検証の準備 */
        final String actualResult = testResult;

        /* 検証の実施 */
        Assertions.assertEquals(expectedResult, actualResult, "空文字列が返されていません");

    }

    /**
     * toSql メソッドのテスト - 異常系：ファイルが存在しない<br>
     */
    @Test
    public void testToSql_errorFileNotFound() {

        /* 期待値の定義 */
        final String          expectedDomainMessage = KmgString
            .concat(this.tempDir.resolve("not_exists.sql").toString(), "がありません。");
        final KmgMessageTypes expectedMessageTypes  = KmgMsgMessageTypes.KMGMSGE11100;

        /* 準備 */
        final Path testFile = this.tempDir.resolve("not_exists.sql");
        this.target = new KmgSqlPathModelImpl(this, testFile);

        /* テスト対象の実行 */
        final KmgDomainException actualException
            = Assertions.assertThrows(KmgDomainException.class, () -> this.target.toSql());

        /* 検証の実施 */
        this.verifyKmgException(actualException, java.nio.file.NoSuchFileException.class, expectedDomainMessage,
            expectedMessageTypes);

    }

    /**
     * toSql メソッドのテスト - 正常系：空のSQL<br>
     *
     * @author KenichiroArai
     *
     * @sine 1.0.0
     *
     * @version 1.0.0
     *
     * @throws Exception
     *                   例外
     */
    @Test
    public void testToSql_normalEmptySql() throws Exception {

        /* 期待値の定義 */
        final String expectedSql = KmgString.EMPTY;

        /* 準備 */
        final Path testFile = this.tempDir.resolve("empty.sql");
        Files.writeString(testFile, "");

        /* テスト対象の実行 */
        this.target = new KmgSqlPathModelImpl(this, testFile);
        final String testResult = this.target.toSql();

        /* 検証の準備 */
        final String actualSql = testResult;

        /* 検証の実施 */
        Assertions.assertEquals(expectedSql, actualSql, "SQLが一致しません");

    }

    /**
     * toSql メソッドのテスト - 正常系：パラメータ変換<br>
     *
     * @author KenichiroArai
     *
     * @sine 1.0.0
     *
     * @version 1.0.0
     *
     * @throws Exception
     *                   例外
     */
    @Test
    public void testToSql_normalParameterConversion() throws Exception {

        /* 期待値の定義 */
        final String expectedSql = ":sampleId";

        /* 準備 */
        final Path testFile = this.tempDir.resolve("test.sql");
        Files.writeString(testFile, "/*:sampleId*/'サンプル'");

        /* テスト対象の実行 */
        this.target = new KmgSqlPathModelImpl(this, testFile);
        final String testResult = this.target.toSql();

        /* 検証の準備 */
        final String actualSql = testResult;

        /* 検証の実施 */
        Assertions.assertEquals(expectedSql, actualSql, "SQLが一致しません");

    }
}

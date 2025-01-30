package kmg.core.domain.model.impl;

import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import kmg.core.infrastructure.exception.KmgDomainException;
import kmg.core.infrastructure.type.KmgString;

/**
 * KMGSQLパスモデルテスト<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
public class KmgSqlPathModelImplTest {

    /** テスト対象 */
    private KmgSqlPathModelImpl testTarget;

    /** 一時ディレクトリ */
    @TempDir
    private Path tempDir;

    /**
     * 前処理<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     */
    @BeforeEach
    public void beforeEach() {

        this.testTarget = null;

    }

    /**
     * コンストラクタのテスト - 正常系：クラスを使用したコンストラクタ<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
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
        this.testTarget = new KmgSqlPathModelImpl(KmgSqlPathModelImpl.class, testFile);
        final String testResult = this.testTarget.toSql();

        /* 検証の準備 */
        final String actualSql = testResult;

        /* 検証の実施 */
        Assertions.assertEquals(expectedSql, actualSql, "SQLが一致しません");

    }

    /**
     * toSql メソッドのテスト - 異常系：ファイルが存在しない<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     */
    @Test
    public void testToSql_errorFileNotFound() {

        /* 期待値の定義 */
        final Class<KmgDomainException> expectedExceptionClass = KmgDomainException.class;

        /* 準備 */
        final Path testFile = this.tempDir.resolve("not_exists.sql");

        /* テスト対象の実行と検証 */
        this.testTarget = new KmgSqlPathModelImpl(this, testFile);
        Assertions.assertThrows(expectedExceptionClass, () -> this.testTarget.toSql(), "例外が発生しませんでした");

    }

    /**
     * toSql メソッドのテスト - 正常系：空のSQL<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
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
        this.testTarget = new KmgSqlPathModelImpl(this, testFile);
        final String testResult = this.testTarget.toSql();

        /* 検証の準備 */
        final String actualSql = testResult;

        /* 検証の実施 */
        Assertions.assertEquals(expectedSql, actualSql, "SQLが一致しません");

    }

    /**
     * toSql メソッドのテスト - 正常系：パラメータ変換<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
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
        this.testTarget = new KmgSqlPathModelImpl(this, testFile);
        final String testResult = this.testTarget.toSql();

        /* 検証の準備 */
        final String actualSql = testResult;

        /* 検証の実施 */
        Assertions.assertEquals(expectedSql, actualSql, "SQLが一致しません");

    }
}

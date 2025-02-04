package kmg.core.domain.model.impl;

import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import kmg.core.domain.model.KmgReflectionModel;
import kmg.core.infrastructure.exception.KmgDomainException;
import kmg.core.infrastructure.model.KmgMessageModel;
import kmg.core.infrastructure.model.factory.KmgMessageModelFactory;
import kmg.core.infrastructure.type.KmgString;
import kmg.core.infrastructure.types.KmgMsgMessageTypes;

/**
 * KMGSQLパスモデルテスト<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
@ExtendWith(MockitoExtension.class)
public class KmgSqlPathModelImplTest {

    /** KMGメッセージモデルファクトリのモック */
    @Mock
    private KmgMessageModelFactory kmgMessageModelFactory;

    /** KMGメッセージモデルのモック */
    @Mock
    private KmgMessageModel kmgMessageModel;

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

        // モックを注入
        ReflectionTestUtils.setField(this.target, "kmgMessageModelFactory", this.kmgMessageModelFactory);

        // メッセージモデルの基本設定
        Mockito.when(
            this.kmgMessageModelFactory.create(ArgumentMatchers.any(KmgMsgMessageTypes.class), ArgumentMatchers.any()))
            .thenReturn(this.kmgMessageModel);
        Mockito.when(this.kmgMessageModel.getMessage()).thenReturn("テストメッセージ");

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
     * @sine 1.0.0
     * @version 1.0.0
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
        this.target = new KmgSqlPathModelImpl(this, testFile);
        Assertions.assertThrows(expectedExceptionClass, () -> this.target.toSql(), "例外が発生しませんでした");

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
        this.target = new KmgSqlPathModelImpl(this, testFile);
        final String testResult = this.target.toSql();

        /* 検証の準備 */
        final String actualSql = testResult;

        /* 検証の実施 */
        Assertions.assertEquals(expectedSql, actualSql, "SQLが一致しません");

    }
}

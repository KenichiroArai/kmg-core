package kmg.core.domain.model.impl;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import kmg.core.domain.model.KmgReflectionModel;
import kmg.core.domain.model.KmgSqlPathModel;
import kmg.core.infrastructure.exception.KmgDomainException;
import kmg.core.infrastructure.utils.KmgPathUtils;

/**
 * KMGＳＱＬパスモデルテスト<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
@TestMethodOrder(MethodOrderer.DisplayName.class)
public class KmgSqlPathModelImplTests {

    /**
     * テスト００１_コンストラクタ_正常００１_設定<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     */
    @Test
    public void テスト００１_コンストラクタ_正常００１_設定() {

        /* 期待値 */
        final Class<?> expectedZlass           = this.getClass();
        final Path     expectedSqlFileNamePath = Paths.get("test.sql");
        final Path     expectedSqlFilePath     = Paths.get(KmgPathUtils.getBinPath(this).toAbsolutePath().toString(),
                "/kmg/core/domain/model/impl/kmg_sql_path_model_impl_tests/test.sql");

        /* 準備 */
        final Path sqlFileNamePath = Paths.get("test.sql");

        /* テスト対象を呼び出す */
        final KmgSqlPathModelImpl testTarget            = new KmgSqlPathModelImpl(this, sqlFileNamePath);
        final KmgReflectionModel  rm                    = new KmgReflectionModelImpl(testTarget);
        final Class<?>            actualZlass           = (Class<?>) rm.get("zlass");
        final Path                actualSqlFileNamePath = (Path) rm.get("sqlFileNamePath");
        final Path                actualSqlFilePath     = (Path) rm.get("sqlFilePath");

        /* 期待値と比較 */
        Assertions.assertEquals(expectedZlass, actualZlass);
        Assertions.assertEquals(expectedSqlFileNamePath, actualSqlFileNamePath);
        Assertions.assertEquals(expectedSqlFilePath, actualSqlFilePath);

    }

    /**
     * テスト００２_toSql_正常００１_取得<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Test
    public void テスト００２_toSql_正常００１_取得() throws KmgDomainException {

        /* 期待値 */
        final String expected = "SELECT id, name FROM sample WHERE id = :id";

        /* 準備 */
        final Path sqlFileNamePath = Paths.get("test.sql");

        /* テスト対象を呼び出す */
        final KmgSqlPathModel testTarget = new KmgSqlPathModelImpl(this, sqlFileNamePath);
        final String          actual     = testTarget.toSql();

        /* 期待値と比較 */
        Assertions.assertEquals(expected, actual);

    }

}

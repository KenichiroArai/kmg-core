package kmg.core.infrastructure.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import kmg.core.infrastructure.model.val.KmgValsModel;

/**
 * KMGバリデーション例外テスト<br>
 *
 * @author KenichiroArai
 *
 * @since 0.2.0
 *
 * @version 0.2.0
 */
@SuppressWarnings({
    "nls",
})
@ExtendWith(MockitoExtension.class)
public class KmgValExceptionTest {

    /**
     * KMGバリデーション集合モデル
     *
     * @since 0.2.0
     */
    @Mock
    private KmgValsModel validationsModel;

    /**
     * デフォルトコンストラクタ<br>
     *
     * @since 0.2.0
     */
    public KmgValExceptionTest() {

        // 処理なし
    }

    /**
     * constructor メソッドのテスト - 正常系：KMGバリデーション集合モデルを指定した場合
     *
     * @since 0.2.0
     */
    @Test
    public void testConstructor_normalWithValidationsModel() {

        /* テスト対象の実行 */
        final KmgValException testException = new KmgValException(this.validationsModel);

        /* 検証の準備 */
        final KmgValsModel actualModel = testException.getValidationsModel();

        /* 検証の実施 */
        Assertions.assertEquals(this.validationsModel, actualModel, "KMGバリデーション集合モデルが一致しません");

    }

    /**
     * constructor メソッドのテスト - 正常系：KMGバリデーション集合モデルと原因を指定した場合
     *
     * @since 0.2.0
     */
    @Test
    public void testConstructor_normalWithValidationsModelAndCause() {

        /* 期待値の定義 */
        final Throwable expectedCause = new RuntimeException("テスト原因");

        /* テスト対象の実行 */
        final KmgValException testException = new KmgValException(this.validationsModel, expectedCause);

        /* 検証の準備 */
        final KmgValsModel actualModel = testException.getValidationsModel();
        final Throwable    actualCause = testException.getCause();

        /* 検証の実施 */
        Assertions.assertEquals(this.validationsModel, actualModel, "KMGバリデーション集合モデルが一致しません");
        Assertions.assertEquals(expectedCause, actualCause, "原因が一致しません");

    }
}

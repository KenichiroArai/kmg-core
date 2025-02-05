package kmg.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * KmgCoreApplication のテストクラス
 */
public class KmgCoreApplicationTest {

    /**
     * main メソッドのテスト - Spring Boot アプリケーションが正常に起動し、終了することを確認する。
     */
    @Test
    @SuppressWarnings("static-method")
    public void testMain_normalEnd() {

        /* 期待値の定義 */

        /* 準備 */
        final String[] testArgs = {};

        /* テスト対象の実行 */
        @SuppressWarnings("resource")
        final ConfigurableApplicationContext testCtx = SpringApplication.run(KmgCoreApplication.class, testArgs);
        KmgCoreApplication.main(testArgs);

        /* 検証の準備 */
        final boolean actualIsClosed = testCtx.isRunning();

        /* 検証の実施 */
        Assertions.assertTrue(actualIsClosed, "コンテキストが終了していること。");

    }

}

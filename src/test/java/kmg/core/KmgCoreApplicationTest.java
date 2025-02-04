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
        final boolean expectedIsRunning = true;

        /* 準備 */
        final String[] testArgs = {};

        /* テスト対象の実行と検証 */
        try (final ConfigurableApplicationContext testCtx = SpringApplication.run(KmgCoreApplication.class, testArgs)) {

            /* 検証の準備 */
            final boolean actualIsRunning = testCtx.isRunning();

            /* 検証の実施 */
            Assertions.assertEquals(expectedIsRunning, actualIsRunning, "コンテキストが起動していること。");

        }

    }
}

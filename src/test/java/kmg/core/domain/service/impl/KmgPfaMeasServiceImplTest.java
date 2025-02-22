package kmg.core.domain.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import kmg.core.infrastructure.model.KmgPfaMeasModel;
import kmg.core.infrastructure.types.KmgTimeUnitTypes;

/**
 * KMG性能測定サービス実装のテスト<br>
 *
 * @author KenichiroArai
 *
 * @sine 1.0.0
 *
 * @version 1.0.0
 */
@SuppressWarnings({
    "nls",
})
public class KmgPfaMeasServiceImplTest {

    /** 元の標準出力 */
    private PrintStream originalOut;

    /** 標準出力のキャプチャ用 */
    private ByteArrayOutputStream outContent;

    /**
     * テスト前処理<br>
     */
    @BeforeEach
    public void setUp() {

        /* 標準出力をキャプチャするための設定 */
        this.outContent = new ByteArrayOutputStream();
        this.originalOut = System.out;
        System.setOut(new PrintStream(this.outContent));

    }

    /**
     * テスト後処理<br>
     */
    @AfterEach
    public void tearDown() {

        /* 標準出力を元に戻す */
        System.setOut(this.originalOut);

    }

    /**
     * コンストラクタのテスト - 正常系:名称が正しく設定されることの確認
     */
    @Test
    public void testConstructor_normalSetName() {

        /* 期待値の定義 */
        final String expectedName = "テスト測定";

        /* 準備 */
        final KmgPfaMeasServiceImpl testTarget = new KmgPfaMeasServiceImpl(expectedName);

        /* テスト対象の実行 */
        testTarget.start();

        /* 検証の準備 */
        final String actualOutput = this.outContent.toString();

        /* 検証の実施 */
        Assertions.assertTrue(actualOutput.contains(expectedName), "名称が出力に含まれていること");

    }

    /**
     * end メソッドのテスト - 正常系:終了メッセージが正しく出力されることの確認
     */
    @Test
    public void testEnd_normalOutputEndMessage() {

        /* 期待値の定義 */
        final String           expectedName        = "テスト測定";
        final double           expectedElapsedTime = 1.5;
        final KmgTimeUnitTypes expectedTimeUnit    = KmgTimeUnitTypes.SECONDS;
        final String           expectedOutput      = String.format("%s：終了。経過時間=[%f%s]", expectedName,
            expectedElapsedTime, expectedTimeUnit.getUnitName());

        /* 準備 */
        final KmgPfaMeasModel mockModel = Mockito.mock(KmgPfaMeasModel.class);
        Mockito.when(mockModel.getElapsedTime()).thenReturn(expectedElapsedTime);
        Mockito.when(mockModel.getTimeUnit()).thenReturn(expectedTimeUnit);

        final KmgPfaMeasServiceImpl testTarget = new KmgPfaMeasServiceImpl(expectedName) {

            @Override
            protected KmgPfaMeasModel createKmgPfaMeasModel() {

                final KmgPfaMeasModel result = mockModel;
                return result;

            }
        };

        /* テスト対象の実行 */
        testTarget.start();
        testTarget.end();

        /* 検証の準備 */
        final String[] actualOutputLines = this.outContent.toString().trim().split(System.lineSeparator());
        final String   actualEndMessage  = actualOutputLines[actualOutputLines.length - 1];

        /* 検証の実施 */
        Assertions.assertEquals(expectedOutput, actualEndMessage, "終了メッセージが期待値と一致すること");
        Mockito.verify(mockModel).start();
        Mockito.verify(mockModel).end();

    }

    /**
     * start メソッドのテスト - 正常系:開始メッセージが正しく出力されることの確認
     */
    @Test
    public void testStart_normalOutputStartMessage() {

        /* 期待値の定義 */
        final String expectedName   = "テスト測定";
        final String expectedOutput = expectedName + "：開始";

        /* 準備 */
        final KmgPfaMeasServiceImpl testTarget = new KmgPfaMeasServiceImpl(expectedName);

        /* テスト対象の実行 */
        testTarget.start();

        /* 検証の準備 */
        final String actualOutput = this.outContent.toString().trim();

        /* 検証の実施 */
        Assertions.assertEquals(expectedOutput, actualOutput, "開始メッセージが期待値と一致すること");

    }

}

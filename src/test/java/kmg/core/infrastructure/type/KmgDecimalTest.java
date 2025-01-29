package kmg.core.infrastructure.type;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * KMGデシマルテスト<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
public class KmgDecimalTest {

    /**
     * setCalcScale メソッドのテスト - BigDecimalの値で計算用スケールを設定する場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testSetCalcScale_bigDecimalValue() {

        /* 期待値の定義 */
        final BigDecimal expectedValue = new BigDecimal("1.234567890123457");

        /* 準備 */
        final BigDecimal testValue = new BigDecimal("1.2345678901234567890");

        /* テスト対象の実行 */
        final BigDecimal testResult = KmgDecimal.setCalcScale(testValue);

        /* 検証の実施 */
        Assertions.assertEquals(expectedValue, testResult, "計算用スケール（15桁）が正しく設定されていません");

    }

    /**
     * setCalcScale メソッドのテスト - double値で計算用スケールを設定する場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testSetCalcScale_doubleValue() {

        /* 期待値の定義 */
        final BigDecimal expectedValue = new BigDecimal("1.234567890123457");

        /* 準備 */
        final double testValue = 1.2345678901234567890;

        /* テスト対象の実行 */
        final BigDecimal testResult = KmgDecimal.setCalcScale(testValue);

        /* 検証の実施 */
        Assertions.assertEquals(expectedValue, testResult, "計算用スケール（15桁）が正しく設定されていません");

    }

    /**
     * setResultScale メソッドのテスト - BigDecimalの値で結果用スケールを設定する場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testSetResultScale_bigDecimalValue() {

        /* 期待値の定義 */
        final BigDecimal expectedValue = new BigDecimal("1.235");

        /* 準備 */
        final BigDecimal testValue = new BigDecimal("1.2345678901234567890");

        /* テスト対象の実行 */
        final BigDecimal testResult = KmgDecimal.setResultScale(testValue);

        /* 検証の実施 */
        Assertions.assertEquals(expectedValue, testResult, "結果用スケール（3桁）が正しく設定されていません");

    }

    /**
     * setResultScale メソッドのテスト - double値で結果用スケールを設定する場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testSetResultScale_doubleValue() {

        /* 期待値の定義 */
        final BigDecimal expectedValue = new BigDecimal("1.235");

        /* 準備 */
        final double testValue = 1.2345678901234567890;

        /* テスト対象の実行 */
        final BigDecimal testResult = KmgDecimal.setResultScale(testValue);

        /* 検証の実施 */
        Assertions.assertEquals(expectedValue, testResult, "結果用スケール（3桁）が正しく設定されていません");

    }

    /**
     * divide メソッドのテスト - 通常の除算の場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testDivide_normalDivision() {

        /* 期待値の定義 */
        final BigDecimal expectedValue = new BigDecimal("2.000000000000000");

        /* 準備 */
        final BigDecimal testNum1 = new BigDecimal("10");
        final BigDecimal testNum2 = new BigDecimal("5");

        /* テスト対象の実行 */
        final BigDecimal testResult = KmgDecimal.divide(testNum1, testNum2);

        /* 検証の実施 */
        Assertions.assertEquals(expectedValue, testResult, "除算結果が正しくありません");

    }

    /**
     * コンストラクタのテスト - BigDecimal値で初期化する場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testConstructor_bigDecimalValue() {

        /* 期待値の定義 */
        final BigDecimal expectedValue = new BigDecimal("1.234567890123457");

        /* 準備 */
        final BigDecimal testValue = new BigDecimal("1.2345678901234567890");

        /* テスト対象の実行 */
        final KmgDecimal testKmgDecimal = new KmgDecimal(testValue);

        /* 検証の準備 */
        final BigDecimal actualValue = testKmgDecimal.getValue();

        /* 検証の実施 */
        Assertions.assertEquals(expectedValue, actualValue, "KmgDecimalの値が正しく設定されていません");

    }

    /**
     * コンストラクタのテスト - double値で初期化する場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testConstructor_doubleValue() {

        /* 期待値の定義 */
        final BigDecimal expectedValue = new BigDecimal("1.234567890123457");

        /* 準備 */
        final double testValue = 1.2345678901234567890;

        /* テスト対象の実行 */
        final KmgDecimal testKmgDecimal = new KmgDecimal(testValue);

        /* 検証の準備 */
        final BigDecimal actualValue = testKmgDecimal.getValue();

        /* 検証の実施 */
        Assertions.assertEquals(expectedValue, actualValue, "KmgDecimalの値が正しく設定されていません");

    }

    /**
     * CALC_ZERO定数のテスト - 計算用ゼロ値の確認
     */
    @Test
    @SuppressWarnings("static-method")
    public void testCalcZero() {

        /* 期待値の定義 */
        final BigDecimal expectedValue = new BigDecimal("0.000000000000000");

        /* 検証の実施 */
        Assertions.assertEquals(expectedValue, KmgDecimal.CALC_ZERO, "計算用ゼロ値が正しくありません");

    }

    /**
     * RESULT_ZERO定数のテスト - 結果用ゼロ値の確認
     */
    @Test
    @SuppressWarnings("static-method")
    public void testResultZero() {

        /* 期待値の定義 */
        final BigDecimal expectedValue = new BigDecimal("0.000");

        /* 検証の実施 */
        Assertions.assertEquals(expectedValue, KmgDecimal.RESULT_ZERO, "結果用ゼロ値が正しくありません");

    }
}

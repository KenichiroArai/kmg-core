package kmg.core.infrastructure.type;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * KMGデシマルテスト<br>
 *
 * @author KenichiroArai
 *
 * @since 0.1.0
 *
 * @version 0.1.0
 */
@SuppressWarnings({
    "nls", "static-method"
})
public class KmgDecimalTest {

    /**
     * CALC_ZERO定数のテスト - 正常系：計算用ゼロ値の確認
     *
     * @since 0.1.0
     */
    @Test
    public void testCalcZero_normalZeroValue() {

        /* 期待値の定義 */
        final BigDecimal expectedValue = new BigDecimal("0.000000000000000");

        /* 検証の実施 */
        Assertions.assertEquals(expectedValue, KmgDecimal.CALC_ZERO, "計算用ゼロ値が正しくありません");

    }

    /**
     * コンストラクタのテスト - 正常系：BigDecimal値で初期化する場合
     *
     * @since 0.1.0
     */
    @Test
    public void testConstructor_normalBigDecimalValue() {

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
     * コンストラクタのテスト - 正常系：double値で初期化する場合
     *
     * @since 0.1.0
     */
    @Test
    public void testConstructor_normalDoubleValue() {

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
     * コンストラクタのテスト - 準正常系：BigDecimal値がnullの場合
     *
     * @since 0.1.0
     */
    @Test
    public void testConstructor_semiNullBigDecimalValue() {

        /* 期待値の定義 */
        final Class<NullPointerException> expectedExceptionClass = NullPointerException.class;

        /* 準備 */
        final BigDecimal testValue = null;

        /* 検証の実施 */
        Assertions.assertThrows(expectedExceptionClass, () -> new KmgDecimal(testValue),
            "null値でNullPointerExceptionが発生しませんでした");

    }

    /**
     * divide メソッドのテスト - 正常系：通常の除算の場合
     *
     * @since 0.1.0
     */
    @Test
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
     * divide メソッドのテスト - 準正常系：引数がnullの場合
     *
     * @since 0.1.0
     */
    @Test
    public void testDivide_semiNullArguments() {

        /* 期待値の定義 */
        final Class<NullPointerException> expectedExceptionClass = NullPointerException.class;

        /* 準備 */
        final BigDecimal testNum1 = null;
        final BigDecimal testNum2 = new BigDecimal("5");

        /* 検証の実施 */
        Assertions.assertThrows(expectedExceptionClass, () -> KmgDecimal.divide(testNum1, testNum2),
            "null値でNullPointerExceptionが発生しませんでした");

    }

    /**
     * divide メソッドのテスト - 準正常系：ゼロ除算の場合
     *
     * @since 0.1.0
     */
    @Test
    public void testDivide_semiZeroDivision() {

        /* 期待値の定義 */
        final Class<ArithmeticException> expectedExceptionClass = ArithmeticException.class;

        /* 準備 */
        final BigDecimal testNum1 = new BigDecimal("10");
        final BigDecimal testNum2 = BigDecimal.ZERO;

        /* 検証の実施 */
        Assertions.assertThrows(expectedExceptionClass, () -> KmgDecimal.divide(testNum1, testNum2),
            "ゼロ除算でArithmeticExceptionが発生しませんでした");

    }

    /**
     * RESULT_ZERO定数のテスト - 正常系：結果用ゼロ値の確認
     *
     * @since 0.1.0
     */
    @Test
    public void testResultZero_normalZeroValue() {

        /* 期待値の定義 */
        final BigDecimal expectedValue = new BigDecimal("0.000");

        /* 検証の実施 */
        Assertions.assertEquals(expectedValue, KmgDecimal.RESULT_ZERO, "結果用ゼロ値が正しくありません");

    }

    /**
     * setCalcScale メソッドのテスト - 正常系：BigDecimalの値で計算用スケールを設定する場合
     *
     * @since 0.1.0
     */
    @Test
    public void testSetCalcScale_normalBigDecimalValue() {

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
     * setCalcScale メソッドのテスト - 正常系：double値で計算用スケールを設定する場合
     *
     * @since 0.1.0
     */
    @Test
    public void testSetCalcScale_normalDoubleValue() {

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
     * setCalcScale メソッドのテスト - 準正常系：BigDecimalの値がnullの場合
     *
     * @since 0.1.0
     */
    @Test
    public void testSetCalcScale_semiNullBigDecimalValue() {

        /* 期待値の定義 */
        final Class<NullPointerException> expectedExceptionClass = NullPointerException.class;

        /* 準備 */
        final BigDecimal testValue = null;

        /* 検証の実施 */
        Assertions.assertThrows(expectedExceptionClass, () -> KmgDecimal.setCalcScale(testValue),
            "null値でNullPointerExceptionが発生しませんでした");

    }

    /**
     * setResultScale メソッドのテスト - 正常系：BigDecimalの値で結果用スケールを設定する場合
     *
     * @since 0.1.0
     */
    @Test
    public void testSetResultScale_normalBigDecimalValue() {

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
     * setResultScale メソッドのテスト - 正常系：double値で結果用スケールを設定する場合
     *
     * @since 0.1.0
     */
    @Test
    public void testSetResultScale_normalDoubleValue() {

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
     * setResultScale メソッドのテスト - 準正常系：BigDecimalの値がnullの場合
     *
     * @since 0.1.0
     */
    @Test
    public void testSetResultScale_semiNullBigDecimalValue() {

        /* 期待値の定義 */
        final Class<NullPointerException> expectedExceptionClass = NullPointerException.class;

        /* 準備 */
        final BigDecimal testValue = null;

        /* 検証の実施 */
        Assertions.assertThrows(expectedExceptionClass, () -> KmgDecimal.setResultScale(testValue),
            "null値でNullPointerExceptionが発生しませんでした");

    }
}

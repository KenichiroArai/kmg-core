package kmg.core.infrastructure.types;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * KMG時間単位の種類のテスト<br>
 *
 * @author KenichiroArai
 *
 * @sine 1.0.0
 *
 * @version 1.0.0
 */
@SuppressWarnings({
    "nls", "static-method"
})
public class KmgTimeUnitTypesTest {

    /**
     * get メソッドのテスト
     */
    @Test
    public void testGet() {

        /* 期待値の定義 */
        final String expected = "seconds";

        /* 準備 */
        final KmgTimeUnitTypes testType = KmgTimeUnitTypes.SECONDS;

        /* テスト対象の実行 */
        final String actual = testType.get();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "取得値が一致しません");

    }

    /**
     * getDefault メソッドのテスト
     */
    @Test
    public void testGetDefault() {

        /* 期待値の定義 */
        final KmgTimeUnitTypes expected = KmgTimeUnitTypes.NONE;

        /* テスト対象の実行 */
        final KmgTimeUnitTypes actual = KmgTimeUnitTypes.getDefault();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "デフォルト値が一致しません");

    }

    /**
     * getEnum メソッドのテスト - 存在する値の場合
     */
    @Test
    public void testGetEnum_existingValue() {

        /* 期待値の定義 */
        final KmgTimeUnitTypes expected = KmgTimeUnitTypes.SECONDS;

        /* 準備 */
        final String testValue = "seconds";

        /* テスト対象の実行 */
        final KmgTimeUnitTypes actual = KmgTimeUnitTypes.getEnum(testValue);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "値が一致しません");

    }

    /**
     * getEnum メソッドのテスト - 存在しない値の場合
     */
    @Test
    public void testGetEnum_nonExistingValue() {

        /* 期待値の定義 */
        final KmgTimeUnitTypes expected = KmgTimeUnitTypes.NONE;

        /* 準備 */
        final String testValue = "INVALID";

        /* テスト対象の実行 */
        final KmgTimeUnitTypes actual = KmgTimeUnitTypes.getEnum(testValue);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "値が一致しません");

    }

    /**
     * getInitValue メソッドのテスト
     */
    @Test
    public void testGetInitValue() {

        /* 期待値の定義 */
        final KmgTimeUnitTypes expected = KmgTimeUnitTypes.NONE;

        /* テスト対象の実行 */
        final KmgTimeUnitTypes actual = KmgTimeUnitTypes.getInitValue();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "初期値が一致しません");

    }

    /**
     * getName メソッドのテスト
     */
    @Test
    public void testGetName() {

        /* 期待値の定義 */
        final String expected = "秒";

        /* 準備 */
        final KmgTimeUnitTypes testType = KmgTimeUnitTypes.SECONDS;

        /* テスト対象の実行 */
        final String actual = testType.getName();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "名称が一致しません");

    }

    /**
     * getUnitName メソッドのテスト
     */
    @Test
    public void testGetUnitName() {

        /* 期待値の定義 */
        final String expected = "秒";

        /* 準備 */
        final KmgTimeUnitTypes testType = KmgTimeUnitTypes.SECONDS;

        /* テスト対象の実行 */
        final String actual = testType.getUnitName();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "単位名が一致しません");

    }

    /**
     * getUnitValue メソッドのテスト - ミリ秒の場合
     */
    @Test
    public void testGetUnitValue_milliseconds() {

        /* 期待値の定義 */
        final BigDecimal expected = new BigDecimal("0.001");

        /* 準備 */
        final KmgTimeUnitTypes testType = KmgTimeUnitTypes.MILLISECOND;

        /* テスト対象の実行 */
        final BigDecimal actual = testType.getUnitValue();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "単位値が一致しません");

    }

    /**
     * getUnitValue メソッドのテスト - 秒の場合
     */
    @Test
    public void testGetUnitValue_seconds() {

        /* 期待値の定義 */
        final BigDecimal expected = BigDecimal.ONE;

        /* 準備 */
        final KmgTimeUnitTypes testType = KmgTimeUnitTypes.SECONDS;

        /* テスト対象の実行 */
        final BigDecimal actual = testType.getUnitValue();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "単位値が一致しません");

    }

    /**
     * getValue メソッドのテスト
     */
    @Test
    public void testGetValue() {

        /* 期待値の定義 */
        final String expected = "seconds";

        /* 準備 */
        final KmgTimeUnitTypes testType = KmgTimeUnitTypes.SECONDS;

        /* テスト対象の実行 */
        final String actual = testType.getValue();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "値が一致しません");

    }

    /**
     * toString メソッドのテスト - MILLISECONDの場合
     */
    @Test
    public void testToString_millisecond() {

        /* 期待値の定義 */
        final String expected = "millisecond,";

        /* 準備 */
        final KmgTimeUnitTypes testType = KmgTimeUnitTypes.MILLISECOND;

        /* テスト対象の実行 */
        final String actual = testType.toString();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "MILLISECONDの場合、'millisecond,'が返されること");

    }

    /**
     * toString メソッドのテスト - NONEの場合
     */
    @Test
    public void testToString_none() {

        /* 期待値の定義 */
        final String expected = null;

        /* 準備 */
        final KmgTimeUnitTypes testType = KmgTimeUnitTypes.NONE;

        /* テスト対象の実行 */
        final String actual = testType.toString();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "NONEの場合、nullが返されること");

    }

    /**
     * toString メソッドのテスト - SECONDSの場合
     */
    @Test
    public void testToString_seconds() {

        /* 期待値の定義 */
        final String expected = "seconds";

        /* 準備 */
        final KmgTimeUnitTypes testType = KmgTimeUnitTypes.SECONDS;

        /* テスト対象の実行 */
        final String actual = testType.toString();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "SECONDSの場合、'seconds'が返されること");

    }
}

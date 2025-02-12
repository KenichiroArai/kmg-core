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
     * get メソッドのテスト - 正常系:基本的な値の取得
     */
    @Test
    public void testGet_normalBasicValue() {

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
     * getDefault メソッドのテスト - 正常系:デフォルト値の取得
     */
    @Test
    public void testGetDefault_normalDefaultValue() {

        /* 期待値の定義 */
        final KmgTimeUnitTypes expected = KmgTimeUnitTypes.NONE;

        /* テスト対象の実行 */
        final KmgTimeUnitTypes actual = KmgTimeUnitTypes.getDefault();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "デフォルト値が一致しません");

    }

    /**
     * getEnum メソッドのテスト - 正常系:存在する値の取得
     */
    @Test
    public void testGetEnum_normalExistingValue() {

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
     * getEnum メソッドのテスト - 準正常系:存在しない値の取得
     */
    @Test
    public void testGetEnum_semiNonExistingValue() {

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
     * getInitValue メソッドのテスト - 正常系:初期値の取得
     */
    @Test
    public void testGetInitValue_normalInitialValue() {

        /* 期待値の定義 */
        final KmgTimeUnitTypes expected = KmgTimeUnitTypes.NONE;

        /* テスト対象の実行 */
        final KmgTimeUnitTypes actual = KmgTimeUnitTypes.getInitValue();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "初期値が一致しません");

    }

    /**
     * getName メソッドのテスト - 正常系:名前の取得
     */
    @Test
    public void testGetName_normalBasicName() {

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
     * getUnitName メソッドのテスト - 正常系:単位名の取得
     */
    @Test
    public void testGetUnitName_normalBasicUnitName() {

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
     * getUnitValue メソッドのテスト - 正常系:ミリ秒の単位値取得
     */
    @Test
    public void testGetUnitValue_normalMilliseconds() {

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
     * getUnitValue メソッドのテスト - 正常系:秒の単位値取得
     */
    @Test
    public void testGetUnitValue_normalSeconds() {

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
     * getValue メソッドのテスト - 正常系:値の取得
     */
    @Test
    public void testGetValue_normalBasicValue() {

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
     * toString メソッドのテスト - 正常系:ミリ秒の文字列表現
     */
    @Test
    public void testToString_normalMillisecond() {

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
     * toString メソッドのテスト - 正常系:NONEの文字列表現
     */
    @Test
    public void testToString_normalNone() {

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
     * toString メソッドのテスト - 正常系:秒の文字列表現
     */
    @Test
    public void testToString_normalSeconds() {

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
